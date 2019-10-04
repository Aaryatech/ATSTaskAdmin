<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>

<jsp:include page="/WEB-INF/views/include/metacssjs.jsp"></jsp:include>
<c:url var="empInfoCountList" value="/empInfoCountList" />
</head>

<body>

	<!-- Main navbar -->
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<!-- /main navbar -->


	<!-- Page content -->
	<div class="page-content">

		<!-- Main sidebar -->
		<jsp:include page="/WEB-INF/views/include/left.jsp"></jsp:include>
		<!-- /main sidebar -->


		<!-- Main content -->
		<div class="content-wrapper">

			<!-- Page header -->
			<div class="page-header page-header-light">


				<div
					class="breadcrumb-line breadcrumb-line-light header-elements-md-inline">
					<div class="d-flex">
						<div class="breadcrumb">
							<a href="index.html" class="breadcrumb-item"><i
								class="icon-home2 mr-2"></i> Home</a> <span
								class="breadcrumb-item active">Dashboard</span>
						</div>

						<a href="#" class="header-elements-toggle text-default d-md-none"><i
							class="icon-more"></i></a>



					</div>


					<%-- <div class="breadcrumb justify-content-center">
						<a href="${pageContext.request.contextPath}/employeeAdd"
							class="breadcrumb-elements-item"> Add Employee </a>

					</div> --%>


				</div>
			</div>
			<!-- /page header -->


			<!-- Content area -->
			<div class="content">


				<!-- Highlighting rows and columns -->
				<div class="card">
					<div class="card-header header-elements-inline">
						<h5 class="card-title">Employee KRA KPI</h5>
						<!-- <div class="header-elements">
							<div class="list-icons">
								<a class="list-icons-item" data-action="collapse"></a>
							</div> 
						</div>-->
					</div>

					<div class="card-body">

						<%
							if (session.getAttribute("errorMsg") != null) {
						%>
						<div
							class="alert bg-danger text-white alert-styled-left alert-dismissible">
							<button type="button" class="close" data-dismiss="alert">
								<span>×</span>
							</button>
							<span class="font-weight-semibold">Oh snap!</span>
							<%
								session.removeAttribute("errorMsg");
							%>
						</div>

						<%
							session.removeAttribute("errorMsg");
							}
						%>
						<%
							if (session.getAttribute("successMsg") != null) {
						%>
						<div
							class="alert bg-success text-white alert-styled-left alert-dismissible">
							<button type="button" class="close" data-dismiss="alert">
								<span>×</span>
							</button>
							<span class="font-weight-semibold">Well done!</span>
							<%
								session.removeAttribute("successMsg");
							%>
						</div>
						<%
							session.removeAttribute("successMsg");
							}
						%>

						<form
							action="${pageContext.request.contextPath}/showProjHrsListToEmp"
							id="submitInsertLeave" method="GET">

							<div class="form-group row">

								<label class="col-form-label col-lg-2" for="select2">Select
											Project <span style="color: red">* </span>:
										</label>
										<div class="col-lg-3">
											<select name="projId" data-placeholder="Select Project"
												id="projId"
												class="form-control form-control-select2 select2-hidden-accessible"
												aria-hidden="true">
												<option value="">Please Select</option>

												<c:forEach items="${projList}" var="projList">
													<option selected value="${projList.projectId}">${projList.projectTitle}</option>
												</c:forEach>

											</select> <span class="validation-invalid-label" id="error_projId"
												style="display: none;">This field is required.</span>
										</div>
								<label class="col-form-label col-lg-2">Date Range<span
									style="color: red">* </span>:
								</label>
								<div class="col-lg-3">
									<input type="text" class="form-control daterange-basic_new "
										name="leaveDateRange" data-placeholder="Select Date"
										id="leaveDateRange">
									<span class="validation-invalid-label" id="error_Range"
										style="display: none;">This field is required.</span> <span
										class="validation-invalid-label" id="error_insuf"
										style="display: none;">Insufficient Leaves.</span>

								</div>

								<input type="submit" class="btn bg-blue ml-3 legitRipple"
									id="submtbtn" value="Submit">
								 
							</div>
						</form>
						<div id='loader' style='display: none;'>
							<img
								src='${pageContext.request.contextPath}/resources/assets/images/giphy.gif'
								width="150px" height="150px"
								style="display: block; margin-left: auto; margin-right: auto">
						</div>
						<table
							class="table table-bordered table-hover datatable-highlight1 datatable-button-html5-basic  datatable-button-print-columns1"
							id="bootstrap-data-table">
							<thead>
								<tr class="bg-blue">
									<th width="10%">Sr.no</th>

									<th>Work Date</th>
									<th>Work Hrs</th>
									<th>Log Type</th>
									 

									<th class="text-center" width="10%">Actions</th>
								</tr>
							</thead>
							<tbody>
								<%-- <c:forEach items="${employeeInfoList}" var="employeeInfoList"
									varStatus="count">
									<tr>
										<td>${count.index+1}</td>
										<td>${employeeInfoList.empCode}</td>
										<td>${employeeInfoList.kraCount}</td>
										<td>${employeeInfoList.kpiCount}</td>
										<td class="text-center"><a
											href="${pageContext.request.contextPath}/showEditWorkLog?workLogId=${employeeInfoList.empMname}&finYrId=${employeeInfoList.empDeptName}"><i
												class="icon-list-unordered" style="color: black;"></i></a></td>


									</tr>
								</c:forEach>
 --%>
							</tbody>
						</table>
					</div>

				</div>
				<!-- /highlighting rows and columns -->


				<!-- /content area -->
			</div>

			<!-- Footer -->
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
			<!-- /footer -->

		</div>
		<!-- /main content -->

	</div>
	<!-- /page content -->
	<script type="text/javascript">
		function show() {

			//alert("Hi View Orders  ");

			var status = document.getElementById("status").value;
			var finYrId = document.getElementById("finYrId").value;
			//var toDate = document.getElementById("to_date").value;

			//alert(compId);

			var valid = true;

			if (finYrId == null || finYrId == "") {
				valid = false;
				alert("Please Select Year");
			}

			var valid = true;
			if (status == null || status == "") {
				valid = false;
				alert("Please Select Condition");

				var dataTable = $('#bootstrap-data-table').DataTable();
				dataTable.clear().draw();

			}
			$("#loader").show();

			if (valid == true) {

				$
						.getJSON(
								'${empInfoCountList}',
								{
									finYrId : finYrId,
									status : status,
									ajax : 'true',
								},

								function(data) {

									var dataTable = $('#bootstrap-data-table')
											.DataTable();
									dataTable.clear().draw();

									$
											.each(
													data,
													function(i, v) {

														var str = '<a href="${pageContext.request.contextPath}/showAddKra?empId='
																+ v.empMname
																+ '&finYrId='
																+ finYrId
																+ '" ><i class="icon-list-unordered"   style="color:black"></i></a>'

														dataTable.row
																.add(
																		[
																				i + 1,
																				v.empCode,
																				v.empSname
																						+ " "
																						+ v.empFname,
																				v.empTypeShortName
																						+ " "
																						+ v.empDeptShortName
																						+ " "
																						+ v.empCatShortName,
																				v.kraCount,
																				v.kpiCount,
																				str ])
																.draw();
													});
									$("#loader").hide();

								});

			}//end of if valid ==true

		}
	</script>
<script type="text/javascript">
		// Single picker
		$('.datepickerclass').daterangepicker({
			singleDatePicker : true,
			selectMonths : true,
			selectYears : true,
			locale : {
				format : 'DD-MM-YYYY'
			}
		});

		/* var today = new Date();
		var last = new Date(today.getTime() - (7 * 24 * 60 * 60 * 1000));

		var daterange = document.getElementById("yearFinalDate").value;

		var date1res = daterange.split("-");
		var lastdate = new Date(date1res[0], date1res[1] - 1, date1res[2]);

		//alert(lastdate);
		$('.daterange-basic_new').daterangepicker({
			applyClass : 'bg-slate-600',
			minDate : last,
			maxDate : lastdate,
			cancelClass : 'btn-light',
			locale : {
				format : 'DD-MM-YYYY',
				separator : ' to '
			}
		}); */

		$('.daterange-basic_new').daterangepicker({
			applyClass : 'bg-slate-600',
			cancelClass : 'btn-light',
			locale : {
				format : 'DD-MM-YYYY',
				separator : ' to '
			}
		});
	</script>

</body>
</html>