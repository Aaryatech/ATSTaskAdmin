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

import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ats.hradmin.common.Constants;
import com.ats.hradmin.common.DateConvertor;
import com.ats.hradmin.common.HoursConversion;
import com.ats.hradmin.model.EmployeeInfo;
import com.ats.hradmin.model.GetEmpShortLeaves;
import com.ats.hradmin.model.LoginResponse;
import com.ats.hradmin.model.ShortLeave;

@Controller
public class ShortLeaveController {

	@RequestMapping(value = "/showAddShortLeave", method = RequestMethod.GET)
	public ModelAndView showAddShortLeave(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("short_leave/add_sl");

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			// toDate = sdf.format(toDate1);
			String curDate = sdf.format(new Date());

			System.err.println("curDate " + curDate);
			model.addObject("curDate", curDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	// submitShortLeave

	@RequestMapping(value = "/submitShortLeave", method = RequestMethod.POST)
	public String submitShortLeave(HttpServletRequest request, HttpServletResponse response) {

		try {
			HttpSession session = request.getSession();
			LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");
			Date date = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String projId = request.getParameter("projId");
			String workTypeId = request.getParameter("workTypeId");
			String typeId = request.getParameter("TypeId");
			String sl_date = request.getParameter("sl_date");
			String leaveHrs = request.getParameter("leaveHrs");
			String remark = null;
			try {
				remark = request.getParameter("woDesc");
			} catch (Exception e) {
				remark = "";
			}

			ShortLeave shLeave = new ShortLeave();

			shLeave.setAddDttime(sf.format(date));
			shLeave.setApprDttime(sf.format(date));
			shLeave.setApproverId(0);

			shLeave.setIsApproved(0);
			shLeave.setMakerUserId(userObj.getEmpId());
			shLeave.setShLeaveDate(DateConvertor.convertToYMD(sl_date));
			shLeave.setShLeaveDesc(request.getParameter("leaveDesc"));
			shLeave.setShLeaveEmpId(userObj.getEmpId());
			shLeave.setShLeaveId(0);
			shLeave.setShLeaveMonth(1);
			shLeave.setShLeaveYear(2019);
			shLeave.setSlDuration(HoursConversion.convertHoursToMin(leaveHrs));
			shLeave.setUpdateDttime(sf.format(date));
			shLeave.setDelStatus(1);
			
			ShortLeave res = Constants.getRestTemplate().postForObject(Constants.url + "/saveShortLeave", shLeave,
					ShortLeave.class);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/showSLListToEmp";
	}
	
	
	
	
	@RequestMapping(value = "/showSLListToEmp", method = RequestMethod.GET)
	public ModelAndView showSLListToEmp(HttpServletRequest request, HttpServletResponse response) {

		System.err.println("Hi");
		ModelAndView model = new ModelAndView("short_leave/sl_list");

		String[] arrOfStr = null;
		String leaveDateRange = null;
		int projId = 0;
		String fromDate = null;
		String toDate = null;
		HttpSession session = request.getSession();
		LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");
		String empIdList;
		List<Integer> empIds = new ArrayList<Integer>();

		if (request.getParameter("leaveDateRange") != null && request.getParameter("leaveDateRange") != "") {
			System.err.println("Hi 1");
			leaveDateRange = request.getParameter("leaveDateRange");
			arrOfStr = leaveDateRange.split("to", 2);
			fromDate = DateConvertor.convertToYMD(arrOfStr[0].toString().trim());
			toDate = DateConvertor.convertToYMD(arrOfStr[1].toString().trim());
			if(userObj.getEmpTypeId()==1) {
			String[] locId2 = request.getParameterValues("empId");

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < locId2.length; i++) {
				sb = sb.append(locId2[i] + ",");
				try {
					empIds.add(Integer.parseInt(locId2[i]));
				} catch (Exception e) {
					
				}
			}
			empIdList = sb.toString();
			empIdList = empIdList.substring(0, empIdList.length() - 1);
			
				
			}
			else {
				System.err.println("single emp ");
				empIdList=""+userObj.getEmpId();
				empIds.add(userObj.getEmpId());
			}
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
if(userObj.getEmpTypeId()==1) {
	System.err.println("all emp ");
			empIdList = "ALL";
}
else {
	System.err.println("single emp ");
	empIdList=""+userObj.getEmpId();
}

			fromDate = DateConvertor.convertToYMD(fromDate);
			toDate = DateConvertor.convertToYMD(toDate);

		}

		try {

			MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
			map.add("empIdList", empIdList); // change by sachin
			// map.add("projId", projId);
			map.add("fromDate", fromDate);
			map.add("toDate", toDate);

			GetEmpShortLeaves[] proHeaderArray1 = Constants.getRestTemplate()
					.postForObject(Constants.url + "/getShortLeaveList", map, GetEmpShortLeaves[].class);
			List<GetEmpShortLeaves> projectHeaderList1 = new ArrayList<GetEmpShortLeaves>(Arrays.asList(proHeaderArray1));
			model.addObject("logList", projectHeaderList1);

			map = new LinkedMultiValueMap<>();
			map.add("locationId", userObj.getLocationIds());

			if(userObj.getEmpTypeId()==1) {
				System.err.println("all emp get");
				EmployeeInfo[] employeeInfo = Constants.getRestTemplate()
						.postForObject(Constants.url + "/getEmpInfoByLocId", map, EmployeeInfo[].class);
				List<EmployeeInfo> employeeInfoList = new ArrayList<EmployeeInfo>(Arrays.asList(employeeInfo));

				model.addObject("employeeInfoList", employeeInfoList);

			}
			else {
				System.err.println("single emp get  ");
				
				
				List<EmployeeInfo> employeeInfoList = new ArrayList<EmployeeInfo>();
				EmployeeInfo emp=new EmployeeInfo();
				emp.setEmpId(userObj.getEmpId());
				emp.setEmpMname(userObj.getEmpMname());
				emp.setEmpFname(userObj.getEmpFname());
				emp.setEmpSname(userObj.getEmpSname());
				employeeInfoList.add(emp);
				
				model.addObject("employeeInfoList", employeeInfoList);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	

}
