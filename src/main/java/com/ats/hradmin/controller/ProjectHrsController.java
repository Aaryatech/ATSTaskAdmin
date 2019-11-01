package com.ats.hradmin.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.ats.hradmin.common.AcessController;
import com.ats.hradmin.common.Constants;
import com.ats.hradmin.common.DateConvertor;
import com.ats.hradmin.common.FormValidation;
import com.ats.hradmin.common.HoursConversion;
import com.ats.hradmin.model.AccessRightModule;
import com.ats.hradmin.model.EmployeeInfo;
import com.ats.hradmin.model.GetEmpLogGrpByDate;
import com.ats.hradmin.model.GetEmpWorkLog;
import com.ats.hradmin.model.GetProjWorkLog;
import com.ats.hradmin.model.GetProjectHeader;
import com.ats.hradmin.model.Info;
import com.ats.hradmin.model.LoginResponse;
import com.ats.hradmin.model.ProjTypeWorkLog;
import com.ats.hradmin.model.ProjectHeader;
import com.ats.hradmin.model.WorkLog;
import com.ats.hradmin.model.WorkType;

@Controller
@Scope("session")
public class ProjectHrsController {

	WorkType editwork = new WorkType();
	WorkLog editworkLog = new WorkLog();
	// *****************************Work type************************

	@RequestMapping(value = "/showAddWorkType", method = RequestMethod.GET)
	public ModelAndView showAddWorkType(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("master/addWorkType");

		return model;
	}

	@RequestMapping(value = "/submitAddWorkType", method = RequestMethod.POST)
	public String submitAddWorkType(HttpServletRequest request, HttpServletResponse response) {

		try {
			HttpSession session = request.getSession();
			LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String typeName = request.getParameter("typeName");
			String typeShortName = request.getParameter("typeShortName");
			String remark = null;
			try {
				remark = request.getParameter("remark");
			} catch (Exception e) {
				remark = "";
			}

			Boolean ret = false;

			if (FormValidation.Validaton(typeName, "") == true) {

				ret = true;
			}
			if (FormValidation.Validaton(typeShortName, "") == true) {

				ret = true;
			}
			if (ret == false) {

				WorkType workType = new WorkType();

				workType.setWorkTypeName(typeName);
				workType.setShortName(typeShortName);
				workType.setWorkTypeDesc(remark);
				workType.setIsActive(1);
				workType.setDelStatus(1);
				workType.setMakerUserId(userObj.getUserId());
				workType.setUpdateDatetime(sf.format(date));
				workType.setDelStatus(1);
				workType.setIsActive(1);
				workType.setExInt1(0);
				workType.setExVar1("NA");

				WorkType res = Constants.getRestTemplate().postForObject(Constants.url + "/saveWorkType", workType,
						WorkType.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/showWorkTypeList";
	}

	@RequestMapping(value = "/showWorkTypeList", method = RequestMethod.GET)
	public ModelAndView showEmpList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = null;

		try {
			HttpSession session = request.getSession();
			LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");
			List<AccessRightModule> newModuleList = (List<AccessRightModule>) session.getAttribute("moduleJsonList");
			Info view = AcessController.checkAccess("showWorkTypeList", "showWorkTypeList", 1, 0, 0, 0, newModuleList);

			if (view.isError() == true) {

				model = new ModelAndView("accessDenied");

			} else {
				model = new ModelAndView("master/workTypeList");

				WorkType[] employeeDepartment = Constants.getRestTemplate()
						.getForObject(Constants.url + "/getWorkTypeList", WorkType[].class);

				List<WorkType> employeeDepartmentlist = new ArrayList<WorkType>(Arrays.asList(employeeDepartment));

				for (int i = 0; i < employeeDepartmentlist.size(); i++) {
					employeeDepartmentlist.get(i).setExVar1(
							FormValidation.Encrypt(String.valueOf(employeeDepartmentlist.get(i).getWorkTypeId())));
				}

				model.addObject("typeList", employeeDepartmentlist);

				Info add = AcessController.checkAccess("showWorkTypeList", "showWorkTypeList", 0, 1, 0, 0,
						newModuleList);
				Info edit = AcessController.checkAccess("showWorkTypeList", "showWorkTypeList", 0, 0, 1, 0,
						newModuleList);
				Info delete = AcessController.checkAccess("showWorkTypeList", "showWorkTypeList", 0, 0, 0, 1,
						newModuleList);

				if (add.isError() == false) {
					System.out.println(" add   Accessable ");
					model.addObject("addAccess", 0);

				}
				if (edit.isError() == false) {
					System.out.println(" edit   Accessable ");
					model.addObject("editAccess", 0);
				}
				if (delete.isError() == false) {
					System.out.println(" delete   Accessable ");
					model.addObject("deleteAccess", 0);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/showEditWorkType", method = RequestMethod.GET)
	public ModelAndView showEditWorkType(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("master/editWorkType");

		try {
			String base64encodedString = request.getParameter("workTypeId");
			String workTypeId = FormValidation.DecodeKey(base64encodedString);

			MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
			map.add("workTypeId", Integer.parseInt(workTypeId));
			editwork = Constants.getRestTemplate().postForObject(Constants.url + "/getWorkTypeById", map,
					WorkType.class);
			model.addObject("editwork", editwork);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/submitEditWorkType", method = RequestMethod.POST)
	public String submitEditWorkType(HttpServletRequest request, HttpServletResponse response) {

		try {
			HttpSession session = request.getSession();
			LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String typeName = request.getParameter("typeName");
			String typeShortName = request.getParameter("typeShortName");
			String remark = null;
			try {
				remark = request.getParameter("remark");
			} catch (Exception e) {
				remark = "";
			}

			Boolean ret = false;

			if (FormValidation.Validaton(typeName, "") == true) {

				ret = true;
			}
			if (FormValidation.Validaton(typeShortName, "") == true) {

				ret = true;
			}
			if (ret == false) {

				editwork.setWorkTypeName(typeName);
				editwork.setShortName(typeShortName);
				editwork.setWorkTypeDesc(remark);
				editwork.setIsActive(1);
				editwork.setDelStatus(1);
				editwork.setMakerUserId(userObj.getUserId());
				editwork.setUpdateDatetime(sf.format(date));
				editwork.setDelStatus(1);
				editwork.setIsActive(1);
				editwork.setExInt1(0);
				editwork.setExVar1("NA");

				WorkType res = Constants.getRestTemplate().postForObject(Constants.url + "/saveWorkType", editwork,
						WorkType.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/showWorkTypeList";
	}

	@RequestMapping(value = "/deleteWorkType", method = RequestMethod.GET)
	public String deleteWorkType(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String a = null;
		List<AccessRightModule> newModuleList = (List<AccessRightModule>) session.getAttribute("moduleJsonList");

		Info view = AcessController.checkAccess("deleteWorkType", "showWorkTypeList", 0, 0, 0, 1, newModuleList);

		try {
			if (view.isError() == true) {

				a = "redirect:/accessDenied";

			}

			else {
				a = "redirect:/showWorkTypeList";
			}
			String base64encodedString = request.getParameter("workTypeId");
			String workTypeId = FormValidation.DecodeKey(base64encodedString);

			MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
			map.add("workTypeId", workTypeId);
			Info info = Constants.getRestTemplate().postForObject(Constants.url + "/deleteWorkType", map, Info.class);

			if (info.isError() == false) {
				session.setAttribute("successMsg", "Deleted Successfully");
			} else {
				session.setAttribute("errorMsg", "Failed to Delete");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMsg", "Failed to Delete");
		}
		return a;
	}

	// *****************************Add project hrs************************

	@RequestMapping(value = "/showAddProjHrs", method = RequestMethod.GET)
	public ModelAndView showAddProjHrs(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("project/add_proj_hrs");

		try {
			ProjectHeader[] proHeaderArray = Constants.getRestTemplate()
					.getForObject(Constants.url + "/getProjectAllList", ProjectHeader[].class);
			List<ProjectHeader> projectHeaderList = new ArrayList<ProjectHeader>(Arrays.asList(proHeaderArray));
			model.addObject("projList", projectHeaderList);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			//toDate = sdf.format(toDate1);
			String curDate=sdf.format(new Date());
			
			System.err.println("curDate " +curDate);
			model.addObject("curDate", curDate);

			WorkType[] workTypeListArr = Constants.getRestTemplate().getForObject(Constants.url + "/getWorkTypeList",
					WorkType[].class);
			List<WorkType> workTypeList = new ArrayList<WorkType>(Arrays.asList(workTypeListArr));
			model.addObject("workTypeList", workTypeList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/showEditProjHrs", method = RequestMethod.GET)
	public ModelAndView showEditProjHrs(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("project/edit_proj_hrs");

		try {

			String workLogId = request.getParameter("workLogId");

			MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
			map.add("workLogId", workLogId);
			editworkLog = Constants.getRestTemplate().postForObject(Constants.url + "/getWorkLogById", map,
					WorkLog.class);

			editworkLog.setWorkHrs(HoursConversion.convertMinToHours(editworkLog.getWorkHrs()));
			
			editworkLog.setWorkDate(DateConvertor.convertToDMY(editworkLog.getWorkDate()));
			model.addObject("editworkLog", editworkLog);

			ProjectHeader[] proHeaderArray = Constants.getRestTemplate()
					.getForObject(Constants.url + "/getProjectAllList", ProjectHeader[].class);
			List<ProjectHeader> projectHeaderList = new ArrayList<ProjectHeader>(Arrays.asList(proHeaderArray));
			model.addObject("projList", projectHeaderList);

			WorkType[] workTypeListArr = Constants.getRestTemplate().getForObject(Constants.url + "/getWorkTypeList",
					WorkType[].class);
			List<WorkType> workTypeList = new ArrayList<WorkType>(Arrays.asList(workTypeListArr));
			model.addObject("workTypeList", workTypeList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/submitEditProjHrs", method = RequestMethod.POST)
	public String submitEditProjHrs(HttpServletRequest request, HttpServletResponse response) {

		try {
			HttpSession session = request.getSession();
			LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String projId = request.getParameter("projId");
			String workTypeId = request.getParameter("workTypeId");
			String typeId = request.getParameter("TypeId");
			String workDate = request.getParameter("workDate");
			String projectHrs = request.getParameter("projectHrs");
			String remark = null;
			try {
				remark = request.getParameter("woDesc");
			} catch (Exception e) {
				remark = "";
			}

			Boolean ret = false;

			if (FormValidation.Validaton(projId, "") == true) {

				ret = true;
			}
			if (FormValidation.Validaton(workTypeId, "") == true) {

				ret = true;
			}
			if (FormValidation.Validaton(workDate, "") == true) {

				ret = true;
			}
			if (FormValidation.Validaton(projectHrs, "") == true) {

				ret = true;
			}

			if (ret == false) {

				editworkLog.setWorkHrs(HoursConversion.convertHoursToMin(projectHrs));
				editworkLog.setEmpId(userObj.getEmpId()); // change by Sachin 14-10-2019

				editworkLog.setWorkTypeId(Integer.parseInt(workTypeId));
				editworkLog.setProjectId(Integer.parseInt(projId));
				editworkLog.setLogType(Integer.parseInt(typeId));
				editworkLog.setWorkDate(DateConvertor.convertToYMD(workDate));
				editworkLog.setWorkDesc(remark);
				editworkLog.setExFloat1(1);
				editworkLog.setIsActive(1);
				editworkLog.setDelStatus(1);
				editworkLog.setMakerUserId(userObj.getUserId());
				editworkLog.setUpdateDatetime(sf.format(date));
				editworkLog.setDelStatus(1);
				editworkLog.setIsActive(1);
				editworkLog.setExInt1(0);
				editworkLog.setExVar1("NA");
				editworkLog.setExVar2("NA");

				WorkLog res = Constants.getRestTemplate().postForObject(Constants.url + "/saveWorkLog", editworkLog,
						WorkLog.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/showProjHrsListToEmp";
	}

	@RequestMapping(value = "/submitInsertProjHrs", method = RequestMethod.POST)
	public String submitInsertProjHrs(HttpServletRequest request, HttpServletResponse response) {

		try {
			HttpSession session = request.getSession();
			LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String projId = request.getParameter("projId");
			String workTypeId = request.getParameter("workTypeId");
			String typeId = request.getParameter("TypeId");
			String workDate = request.getParameter("workDate");
			String projectHrs = request.getParameter("projectHrs");
			String remark = null;
			try {
				remark = request.getParameter("woDesc");
			} catch (Exception e) {
				remark = "";
			}

			Boolean ret = false;

			if (FormValidation.Validaton(projId, "") == true) {

				ret = true;
			}
			if (FormValidation.Validaton(workTypeId, "") == true) {

				ret = true;
			}
			if (FormValidation.Validaton(workDate, "") == true) {

				ret = true;
			}
			if (FormValidation.Validaton(projectHrs, "") == true) {

				ret = true;
			}

			if (ret == false) {

				WorkLog workType = new WorkLog();
				workType.setWorkHrs(HoursConversion.convertHoursToMin(projectHrs));
				workType.setEmpId(userObj.getEmpId());
				;
				workType.setWorkTypeId(Integer.parseInt(workTypeId));
				workType.setProjectId(Integer.parseInt(projId));
				workType.setLogType(Integer.parseInt(typeId));
				workType.setWorkDate(DateConvertor.convertToYMD(workDate));
				workType.setWorkDesc(remark);
				workType.setExFloat1(1);
				workType.setIsActive(1);
				workType.setDelStatus(1);
				workType.setMakerUserId(userObj.getUserId());
				workType.setUpdateDatetime(sf.format(date));
				workType.setDelStatus(1);
				workType.setIsActive(1);
				workType.setExInt1(0);
				workType.setExVar1("NA");
				workType.setExVar2("NA");

				WorkLog res = Constants.getRestTemplate().postForObject(Constants.url + "/saveWorkLog", workType,
						WorkLog.class);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/showProjHrsListToEmp";
	}

	@RequestMapping(value = "/showProjHrsListToEmp", method = RequestMethod.GET)
	public ModelAndView showProjHrsListToEmp(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("project/proj_hrs_list");
		String[] arrOfStr = null;
		String leaveDateRange = null;
		int projId = 0;
		String fromDate = null;
		String toDate = null;
		HttpSession session = request.getSession();
		LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");

		if (request.getParameter("leaveDateRange") != null && request.getParameter("leaveDateRange") != "") {

			leaveDateRange = request.getParameter("leaveDateRange");
			arrOfStr = leaveDateRange.split("to", 2);
			fromDate = DateConvertor.convertToYMD(arrOfStr[0].toString().trim());
			toDate = DateConvertor.convertToYMD(arrOfStr[1].toString().trim());
			model.addObject("leaveDateRange", leaveDateRange);

		} else {
			fromDate = "";
			toDate = "";
		}

		if (request.getParameter("projId") != "" && request.getParameter("projId") != null) {
			projId = Integer.parseInt(request.getParameter("projId"));
			

		} else {
			projId = 0;
		}
		model.addObject("projId", projId);
		System.out.println("leaveDateRange" + leaveDateRange);
		try {
			ProjectHeader[] proHeaderArray = Constants.getRestTemplate()
					.getForObject(Constants.url + "/getProjectAllList", ProjectHeader[].class);
			List<ProjectHeader> projectHeaderList = new ArrayList<ProjectHeader>(Arrays.asList(proHeaderArray));
			model.addObject("projList", projectHeaderList);

			MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
			map.add("empId", userObj.getEmpId()); // change by sachin
			map.add("projId", projId);
			map.add("fromDate", fromDate);
			map.add("toDate", toDate);

			GetEmpWorkLog[] proHeaderArray1 = Constants.getRestTemplate()
					.postForObject(Constants.url + "/getEmpWorkLogByProjId", map, GetEmpWorkLog[].class);
			List<GetEmpWorkLog> projectHeaderList1 = new ArrayList<GetEmpWorkLog>(Arrays.asList(proHeaderArray1));
			model.addObject("logList", projectHeaderList1);

			System.out.println("project " + projectHeaderList.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	// Sachin 14-10-2019

	@RequestMapping(value = "/showProjHrsToAdm", method = RequestMethod.GET)
	public ModelAndView showProjHrsToAdm(HttpServletRequest request, HttpServletResponse response) {

		System.err.println("Hi");

		ModelAndView model = new ModelAndView("project/show_proj_hr_adm");
		String[] arrOfStr = null;
		String leaveDateRange = null;
		int projId = 0;
		String fromDate = null;
		String toDate = null;
		HttpSession session = request.getSession();
		LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");
		String projIdList;
		if (request.getParameter("leaveDateRange") != null && request.getParameter("leaveDateRange") != "") {
			System.err.println("Hi 1");
			leaveDateRange = request.getParameter("leaveDateRange");
			arrOfStr = leaveDateRange.split("to", 2);
			fromDate = DateConvertor.convertToYMD(arrOfStr[0].toString().trim());
			toDate = DateConvertor.convertToYMD(arrOfStr[1].toString().trim());

			String[] locId2 = request.getParameterValues("projId");

			StringBuilder sb = new StringBuilder();
			List<Integer> projIds = new ArrayList<Integer>();
			for (int i = 0; i < locId2.length; i++) {
				sb = sb.append(locId2[i] + ",");
				try {
					projIds.add(Integer.parseInt(locId2[i]));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			projIdList = sb.toString();
			projIdList = projIdList.substring(0, projIdList.length() - 1);

			model.addObject("leaveDateRange", leaveDateRange);
			model.addObject("projIds", projIds);

		} else {

			Calendar c = Calendar.getInstance(); // this takes current date

			System.out.println(c.getTime());

			Date toDate1 = c.getTime();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			toDate = sdf.format(toDate1);

			c.set(Calendar.DAY_OF_MONTH, 1);
			Date fromDate1 = c.getTime();

			fromDate = sdf.format(fromDate1);

			leaveDateRange = fromDate.concat(" to ").concat(toDate);

			model.addObject("leaveDateRange", leaveDateRange);

			projIdList = "ALL";

			fromDate = DateConvertor.convertToYMD(fromDate);
			toDate = DateConvertor.convertToYMD(toDate);

		}

		try {

			MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
			//map.add("empIdList", empIdList); // change by sachin
			map.add("projIdList", projIdList);
			map.add("fromDate", fromDate);
			map.add("toDate", toDate);

			/*GetEmpWorkLog[] proHeaderArray1 = Constants.getRestTemplate()
					.postForObject(Constants.url + "/getWorkLogAdm", map, GetEmpWorkLog[].class);
			List<GetEmpWorkLog> projectHeaderList1 = new ArrayList<GetEmpWorkLog>(Arrays.asList(proHeaderArray1));*/
			
			

			/*EmployeeInfo[] employeeInfo = Constants.getRestTemplate()
					.postForObject(Constants.url + "/getEmpInfoByLocId", map, EmployeeInfo[].class);
			List<EmployeeInfo> employeeInfoList = new ArrayList<EmployeeInfo>(Arrays.asList(employeeInfo));

			model.addObject("employeeInfoList", employeeInfoList);*/
			
			GetProjWorkLog[] proHeaderArray1 = Constants.getRestTemplate()
					.postForObject(Constants.url + "/getProjWorkLog", map, GetProjWorkLog[].class);
			List<GetProjWorkLog> projectHeaderList1 = new ArrayList<GetProjWorkLog>(Arrays.asList(proHeaderArray1));
			model.addObject("logList", projectHeaderList1);
			
			model.addObject("fromDate", fromDate);
			model.addObject("toDate", toDate);

			map = new LinkedMultiValueMap<>();
			map.add("locationId", userObj.getLocationIds());
			
			ProjectHeader[] proHeaderArray = Constants.getRestTemplate()
					.getForObject(Constants.url + "/getProjectAllList", ProjectHeader[].class);
			List<ProjectHeader> projectHeaderList = new ArrayList<ProjectHeader>(Arrays.asList(proHeaderArray));
			model.addObject("projList", projectHeaderList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	
	
	
	
	@RequestMapping(value = "/showProjHrsDatewise", method = RequestMethod.GET)
	public ModelAndView showProjHrsDatewise(HttpServletRequest request, HttpServletResponse response) {

		System.err.println("Hi showProjHrsDatewise");

		ModelAndView model = new ModelAndView("project/show_proj_hrs_dateEmpGrp");
		String[] arrOfStr = null;
		String leaveDateRange = null;
		int projId = 0;
		String fromDate = null;
		String toDate = null;
		HttpSession session = request.getSession();
		LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");
		String empIdList;
		if (request.getParameter("leaveDateRange") != null && request.getParameter("leaveDateRange") != "") {
			System.err.println("Hi 1");
			leaveDateRange = request.getParameter("leaveDateRange");
			arrOfStr = leaveDateRange.split("to", 2);
			fromDate = DateConvertor.convertToYMD(arrOfStr[0].toString().trim());
			toDate = DateConvertor.convertToYMD(arrOfStr[1].toString().trim());

			String[] locId2 = request.getParameterValues("empId");

			StringBuilder sb = new StringBuilder();
			List<Integer> empIds = new ArrayList<Integer>();
			for (int i = 0; i < locId2.length; i++) {
				sb = sb.append(locId2[i] + ",");
				try {
					empIds.add(Integer.parseInt(locId2[i]));
				} catch (Exception e) {
				
				}
			}
			empIdList = sb.toString();
			empIdList = empIdList.substring(0, empIdList.length() - 1);

			model.addObject("leaveDateRange", leaveDateRange);
			model.addObject("empIds", empIds);

		} else {

			Calendar c = Calendar.getInstance(); // this takes current date

			System.out.println(c.getTime());

			Date toDate1 = c.getTime();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			toDate = sdf.format(toDate1);

			c.set(Calendar.DAY_OF_MONTH, 1);
			Date fromDate1 = c.getTime();

			fromDate = sdf.format(fromDate1);

			leaveDateRange = fromDate.concat(" to ").concat(toDate);

			model.addObject("leaveDateRange", leaveDateRange);

			empIdList = "ALL";

			fromDate = DateConvertor.convertToYMD(fromDate);
			toDate = DateConvertor.convertToYMD(toDate);

		}

		try {

			MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
			map.add("empIdList", empIdList); // change by sachin
			// map.add("projId", projId);
			map.add("fromDate", fromDate);
			map.add("toDate", toDate);

			GetEmpLogGrpByDate[] proHeaderArray1 = Constants.getRestTemplate()
					.postForObject(Constants.url + "/getWorkLogGrpByDate", map, GetEmpLogGrpByDate[].class);
			List<GetEmpLogGrpByDate> projectHeaderList1 = new ArrayList<GetEmpLogGrpByDate>(Arrays.asList(proHeaderArray1));
			model.addObject("logList", projectHeaderList1);

			map = new LinkedMultiValueMap<>();
			map.add("locationId", userObj.getLocationIds());

			EmployeeInfo[] employeeInfo = Constants.getRestTemplate()
					.postForObject(Constants.url + "/getEmpInfoByLocId", map, EmployeeInfo[].class);
			List<EmployeeInfo> employeeInfoList = new ArrayList<EmployeeInfo>(Arrays.asList(employeeInfo));

			model.addObject("employeeInfoList", employeeInfoList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
		
	@RequestMapping(value = "/showEmpProjHrs", method = RequestMethod.GET)
	public ModelAndView showEmpProjHrs(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("project/show_emp_work_log");
		try {
			
				MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
				
				map.add("projId", Integer.parseInt(request.getParameter("projWorkLogId")));
				map.add("fromDate", request.getParameter("fromDate"));
				map.add("toDate", request.getParameter("toDate"));
				
				GetEmpWorkLog[] proHeaderArray1 = Constants.getRestTemplate()
						.postForObject(Constants.url + "/getEmpWorkLogAdm", map, GetEmpWorkLog[].class);
				List<GetEmpWorkLog> projectHeaderList1 = new ArrayList<GetEmpWorkLog>(Arrays.asList(proHeaderArray1));
				
				model.addObject("logList", projectHeaderList1);
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		return model;
		
	}
	
	@RequestMapping(value = "/workTypeHrs", method = RequestMethod.GET)
	public ModelAndView workTypeHrs(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("project/show_work_type_log");
		try {
			ProjectHeader[] proHeaderArray = Constants.getRestTemplate()
					.getForObject(Constants.url + "/getProjectAllList", ProjectHeader[].class);
			List<ProjectHeader> projectHeaderList = new ArrayList<ProjectHeader>(Arrays.asList(proHeaderArray));
			model.addObject("projList", projectHeaderList);



			WorkType[] workTypeListArr = Constants.getRestTemplate().getForObject(Constants.url + "/getWorkTypeList",
					WorkType[].class);
			List<WorkType> workTypeList = new ArrayList<WorkType>(Arrays.asList(workTypeListArr));
			model.addObject("workTypeList", workTypeList);
				
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		return model;
		
	}
	
	@RequestMapping(value = "/showProjTypeHrsToAdm", method = RequestMethod.POST)
	public ModelAndView showProjTypeHrsToAdm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("project/show_work_type_log");
		String leaveDateRange = null;
		String[] arrOfStr = null;
		String fromDate = null;
		String toDate = null;
		try {
			
			leaveDateRange = request.getParameter("leaveDateRange");
			arrOfStr = leaveDateRange.split("to", 2);
			fromDate = DateConvertor.convertToYMD(arrOfStr[0].toString().trim());
			toDate = DateConvertor.convertToYMD(arrOfStr[1].toString().trim());
			
			
				MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
				
				ProjectHeader[] proHeaderArray = Constants.getRestTemplate()
						.getForObject(Constants.url + "/getProjectAllList", ProjectHeader[].class);
				List<ProjectHeader> projectHeaderList = new ArrayList<ProjectHeader>(Arrays.asList(proHeaderArray));
				model.addObject("projList", projectHeaderList);



				WorkType[] workTypeListArr = Constants.getRestTemplate().getForObject(Constants.url + "/getWorkTypeList",
						WorkType[].class);
				List<WorkType> workTypeList = new ArrayList<WorkType>(Arrays.asList(workTypeListArr));
				model.addObject("workTypeList", workTypeList);
				
				
				map.add("fromDate", fromDate);
				map.add("toDate", toDate);
				
				ProjTypeWorkLog[] proHeaderArray1 = Constants.getRestTemplate()
						.postForObject(Constants.url + "/getProjTypeWorkLogAdm", map, ProjTypeWorkLog[].class);
				List<ProjTypeWorkLog> projectHeaderList1 = new ArrayList<ProjTypeWorkLog>(Arrays.asList(proHeaderArray1));
				
				model.addObject("logList", projectHeaderList1);
				model.addObject("leaveDateRange", leaveDateRange);
				
				
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		return model;
		
	}
}
