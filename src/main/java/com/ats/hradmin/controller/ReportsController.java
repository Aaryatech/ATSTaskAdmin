package com.ats.hradmin.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ats.hradmin.common.Constants;
import com.ats.hradmin.common.DateConvertor;
import com.ats.hradmin.common.ExceUtil;
import com.ats.hradmin.common.ExportToExcel;
import com.ats.hradmin.common.FormValidation;
import com.ats.hradmin.common.ReportCostants;
import com.ats.hradmin.leave.model.EmpLeaveHistoryRep;
import com.ats.hradmin.model.ActivityRevenueReport;
import com.ats.hradmin.model.EmpWorkHrsRep;
import com.ats.hradmin.model.EmployeeOnBenchReport;
import com.ats.hradmin.model.EmployeeProjectWise;
import com.ats.hradmin.model.GetEmployeeInfo;
import com.ats.hradmin.model.LoginResponse;
import com.ats.hradmin.model.ProjectLocationWise;
import com.ats.hradmin.util.ItextPageEvent;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Controller
@Scope("session")
public class ReportsController {

	@RequestMapping(value = "/onbenchReport", method = RequestMethod.GET)
	public ModelAndView onbenchReport(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");

		ModelAndView model = new ModelAndView("reports/onbenchReport");
		try {

			String fromDate = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");

			if (!fromDate.equalsIgnoreCase(null) || !toDate.equalsIgnoreCase(null)) {

				MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
				map.add("fromDate", DateConvertor.convertToYMD(fromDate));
				map.add("toDate", DateConvertor.convertToYMD(toDate));
				map.add("locIds", userObj.getLocationIds());

				EmployeeOnBenchReport[] employeeOnBenchReport = Constants.getRestTemplate()
						.postForObject(Constants.url + "/getOnBenchReport", map, EmployeeOnBenchReport[].class);

				List<EmployeeOnBenchReport> list = new ArrayList<>(Arrays.asList(employeeOnBenchReport));
				model.addObject("list", list);
				model.addObject("fromDate", fromDate);
				model.addObject("toDate", toDate);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/activityRevenueReport", method = RequestMethod.GET)
	public ModelAndView activityRevenueReport(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");

		ModelAndView model = new ModelAndView("reports/activityRevenueReport");
		try {

			/*
			 * MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
			 * map.add("compId", userObj.getCompanyId());
			 * 
			 * ActivityRevenueReport[] activityRevenueReport =
			 * Constants.getRestTemplate().postForObject(Constants.url +
			 * "/revenueReportProjectCategoryWise", map, ActivityRevenueReport[].class);
			 * 
			 * List<ActivityRevenueReport> list = new
			 * ArrayList<>(Arrays.asList(activityRevenueReport)); model.addObject("list",
			 * list);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/employeeProjectWiseReport", method = RequestMethod.GET)
	public ModelAndView employeeProjectWiseReport(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");

		ModelAndView model = new ModelAndView("reports/employeeProjectWiseReport");
		try {

			/*
			 * MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
			 * map.add("compId", userObj.getCompanyId());
			 * 
			 * EmployeeProjectWise[] employeeProjectWise =
			 * Constants.getRestTemplate().postForObject(Constants.url +
			 * "/employeeProjectWiseReport", map, EmployeeProjectWise[].class);
			 * 
			 * List<EmployeeProjectWise> list = new
			 * ArrayList<>(Arrays.asList(employeeProjectWise)); model.addObject("list",
			 * list);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/projectLocationWiseReport", method = RequestMethod.GET)
	public ModelAndView projectLocationWiseReport(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");

		ModelAndView model = new ModelAndView("reports/projectLocationWiseReport");
		try {

			/*
			 * MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
			 * map.add("compId", userObj.getCompanyId());
			 * 
			 * ProjectLocationWise[] projectLocationWise =
			 * Constants.getRestTemplate().postForObject(Constants.url +
			 * "/projectLocationwiseReport", map, ProjectLocationWise[].class);
			 * 
			 * List<ProjectLocationWise> list = new
			 * ArrayList<>(Arrays.asList(projectLocationWise)); model.addObject("list",
			 * list);
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/empWiseProjHrsRep", method = RequestMethod.GET)
	public ModelAndView empWiseProjHrsRep(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		LoginResponse userObj = (LoginResponse) session.getAttribute("UserDetail");

		ModelAndView model = new ModelAndView("reports/EmpWiseProjHrsRep");
		try {
			MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
			map.add("companyId", userObj.getCompanyId());
			map.add("locIdList", userObj.getLocationIds());

			GetEmployeeInfo[] employeeDepartment = Constants.getRestTemplate()
					.postForObject(Constants.url + "/getEmpInfoList", map, GetEmployeeInfo[].class);

			List<GetEmployeeInfo> employeeDepartmentlist = new ArrayList<GetEmployeeInfo>(
					Arrays.asList(employeeDepartment));

			for (int i = 0; i < employeeDepartmentlist.size(); i++) {
				employeeDepartmentlist.get(i)
						.setExVar1(FormValidation.Encrypt(String.valueOf(employeeDepartmentlist.get(i).getEmpId())));
			}

			System.out.println("emp work hrs" + employeeDepartmentlist.toString());
			model.addObject("employeeInfoList", employeeDepartmentlist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/empExtraWorkHrs", method = RequestMethod.GET)
	public @ResponseBody List<EmpWorkHrsRep> empExtraWorkHrs(HttpServletRequest request, HttpServletResponse response) {

		List<EmpWorkHrsRep> employeeInfoList = new ArrayList<EmpWorkHrsRep>();
		try {

			 

			String empId = request.getParameter("empId");
			 
			String[] empIds=empId.split(","); 
			String items = new String();
 
			System.out.println("employeeInfoList" + empId);
			String leaveDateRange = request.getParameter("dateRange");
			String[] arrOfStr = leaveDateRange.split("to", 2);

			MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
			map.add("empIdList", empId);
			map.add("fromDate", DateConvertor.convertToYMD(arrOfStr[0].toString().trim()));
			map.add("toDate", DateConvertor.convertToYMD(arrOfStr[1].toString().trim()));

			EmpWorkHrsRep[] employeeInfo = Constants.getRestTemplate()
					.postForObject(Constants.url + "/projectExtrahrsEmpwiseReport", map, EmpWorkHrsRep[].class);

			employeeInfoList = new ArrayList<EmpWorkHrsRep>(Arrays.asList(employeeInfo));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeInfoList;
	}

	@RequestMapping(value = "/showExtraHrsRep", method = RequestMethod.POST)
	public void showExtraHrsRep(HttpServletRequest request, HttpServletResponse response) {
		List<EmpWorkHrsRep> progList = new ArrayList<EmpWorkHrsRep>();
		String reportName = "Employee Extra Hours Report";
		try {

			HttpSession session = request.getSession();

			String[] empIds = request.getParameterValues("empId");

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < empIds.length; i++) {
				sb = sb.append(empIds[i] + ",");

			}
			String items = sb.toString();
			items = items.substring(0, items.length() - 1);
			System.err.println("loc are:::" + items);
			String leaveDateRange = request.getParameter("dateRange");
			String[] arrOfStr = leaveDateRange.split("to", 2);

			MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
			map.add("empIdList", items);
			map.add("fromDate", DateConvertor.convertToYMD(arrOfStr[0].toString().trim()));
			map.add("toDate", DateConvertor.convertToYMD(arrOfStr[1].toString().trim()));

			EmpWorkHrsRep[] employeeInfo = Constants.getRestTemplate()
					.postForObject(Constants.url + "/projectExtrahrsEmpwiseReport", map, EmpWorkHrsRep[].class);

			progList = new ArrayList<EmpWorkHrsRep>(Arrays.asList(employeeInfo));

			Document document = new Document(PageSize.A4);
			document.setMargins(50, 45, 50, 60);
			document.setMarginMirroring(false);

			String FILE_PATH = Constants.REPORT_SAVE;
			File file = new File(FILE_PATH);

			PdfWriter writer = null;

			FileOutputStream out = new FileOutputStream(FILE_PATH);
			try {
				writer = PdfWriter.getInstance(document, out);
			} catch (DocumentException e) {

				e.printStackTrace();
			}

			String header = "";
			String title = "                 ";

			DateFormat DF2 = new SimpleDateFormat("dd-MM-yyyy");
			String repDate = DF2.format(new Date());

			ItextPageEvent event = new ItextPageEvent(header, title, "", "");

			writer.setPageEvent(event);
			// writer.add(new Paragraph("Curricular Aspects"));

			PdfPTable table = new PdfPTable(3);

			table.setHeaderRows(1);

			try {
				table.setWidthPercentage(100);
				table.setWidths(new float[] { 2.3f, 4.3f, 4.3f });
				Font headFontData = ReportCostants.headFontData;// new Font(FontFamily.TIMES_ROMAN, 12, Font.NORMAL,
				// BaseColor.BLACK);
				Font tableHeaderFont = ReportCostants.tableHeaderFont; // new Font(FontFamily.HELVETICA, 12, Font.BOLD,
																		// BaseColor.BLACK);
				tableHeaderFont.setColor(ReportCostants.tableHeaderFontBaseColor);

				PdfPCell hcell = new PdfPCell();
				hcell.setBackgroundColor(BaseColor.LIGHT_GRAY);

				hcell = new PdfPCell(new Phrase("Sr.No.", tableHeaderFont));
				hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				hcell.setBackgroundColor(ReportCostants.baseColorTableHeader);

				table.addCell(hcell);

				hcell = new PdfPCell(new Phrase("Employee Name", tableHeaderFont));
				hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				hcell.setBackgroundColor(ReportCostants.baseColorTableHeader);

				table.addCell(hcell);

				hcell = new PdfPCell(new Phrase("Extra Work Hrs", tableHeaderFont));
				hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
				hcell.setBackgroundColor(ReportCostants.baseColorTableHeader);

				table.addCell(hcell);

				int index = 0;
				for (int i = 0; i < progList.size(); i++) {
					// System.err.println("I " + i);
					EmpWorkHrsRep prog = progList.get(i);

					index++;
					PdfPCell cell;
					cell = new PdfPCell(new Phrase(String.valueOf(index), headFontData));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);

					table.addCell(cell);

					cell = new PdfPCell(new Phrase("" + prog.getEmpFname() + "" + prog.getEmpSname(), headFontData));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_LEFT);

					table.addCell(cell);

					cell = new PdfPCell(new Phrase("" + prog.getEmpBudHr(), headFontData));
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_RIGHT);

					table.addCell(cell);

				}

				document.open();
				Font hf = new Font(FontFamily.TIMES_ROMAN, 12.0f, Font.UNDERLINE, BaseColor.BLACK);

				Paragraph name = new Paragraph(reportName, hf);
				name.setAlignment(Element.ALIGN_CENTER);
				document.add(name);
				document.add(new Paragraph("\n"));

				document.add(new Paragraph("Date Range:" + leaveDateRange));
				document.add(new Paragraph("\n"));

				DateFormat DF = new SimpleDateFormat("dd-MM-yyyy");

				document.add(table);

				int totalPages = writer.getPageNumber();

				// System.out.println("Page no " + totalPages);

				document.close();
				int p = Integer.parseInt(request.getParameter("p"));
				// System.err.println("p " + p);

				if (p == 1) {

					if (file != null) {

						String mimeType = URLConnection.guessContentTypeFromName(file.getName());

						if (mimeType == null) {

							mimeType = "application/pdf";

						}

						response.setContentType(mimeType);

						response.addHeader("content-disposition",
								String.format("inline; filename=\"%s\"", file.getName()));

						response.setContentLength((int) file.length());

						InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

						try {
							FileCopyUtils.copy(inputStream, response.getOutputStream());
						} catch (IOException e) {
							// System.out.println("Excep in Opening a Pdf File");
							e.printStackTrace();
						}
					}
				} else {

					List<ExportToExcel> exportToExcelList = new ArrayList<ExportToExcel>();

					ExportToExcel expoExcel = new ExportToExcel();
					List<String> rowData = new ArrayList<String>();

					rowData.add("Sr. No");
					rowData.add("Employee Name ");
					rowData.add("Work Hrs");

					expoExcel.setRowData(rowData);

					exportToExcelList.add(expoExcel);
					int cnt = 1;
					for (int i = 0; i < progList.size(); i++) {
						expoExcel = new ExportToExcel();
						rowData = new ArrayList<String>();
						cnt = cnt + i;

						rowData.add("" + (i + 1));

						rowData.add("" + progList.get(i).getEmpFname() + "" + progList.get(i).getEmpSname());
						rowData.add("" + progList.get(i).getEmpBudHr());

						expoExcel.setRowData(rowData);
						exportToExcelList.add(expoExcel);

					}

					XSSFWorkbook wb = null;
					try {
						System.out.println("exportToExcelList" + exportToExcelList.toString());

						wb = ExceUtil.createWorkbook(exportToExcelList, "", reportName, "  Date:" + leaveDateRange + "",
								"", 'C');

						ExceUtil.autoSizeColumns(wb, 3);
						response.setContentType("application/vnd.ms-excel");
						String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
						response.setHeader("Content-disposition",
								"attachment; filename=" + reportName + "-" + date + ".xlsx");
						wb.write(response.getOutputStream());

					} catch (IOException ioe) {
						throw new RuntimeException("Error writing spreadsheet to output stream");
					} finally {
						if (wb != null) {
							wb.close();
						}
					}

				}

			} catch (DocumentException ex) {

				// System.out.println("Pdf Generation Error: " + ex.getMessage());

				ex.printStackTrace();

			}

		} catch (Exception e) {

			System.err.println("Exce in showProgReport " + e.getMessage());
			e.printStackTrace();

		}

	}

}
