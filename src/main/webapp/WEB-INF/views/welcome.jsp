<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

<jsp:include page="/WEB-INF/views/include/metacssjs.jsp"></jsp:include>

<c:url var="empInfoHistoryList" value="/empInfoHistoryList" />
<style type="text/css">
.dataTables_wrapper{
	margin-left: 15px;
	margin-right: 15px;
}
</style>
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
				</div>
			</div>
			<!-- /page header -->


			<!-- Content area -->
			<div class="content">


				<!-- Highlighting rows and columns -->
				<div class="card">
					<div class="card-body">
						<div class="card-header header-elements-inline">
							<h3 class="card-title">WELCOME</h3>
						</div>
						<%--  
						<c:if test="${authorityInformation.leaveInitialAuth != '0'}">
							<h6 class="card-title">Leave Authority</h6>

							<div class="form-group row">
								<label class="col-form-label col-lg-2" for=leaveInitialAuth>Initial
									Authority : </label>
								<div class="col-lg-6">
									<input type="text" class="form-control" id="leaveInitialAuth"
										Value="${authorityInformation.leaveInitialAuth}"
										name="leaveInitialAuth" autocomplete="off" readonly>

								</div>
							</div>
							<div class="form-group row">
								<label class="col-form-label col-lg-2" for="leaveFinalAuth">Final
									Authority : </label>
								<div class="col-lg-6">
									<input type="text" class="form-control" id="leaveFinalAuth"
										Value="${authorityInformation.leaveFinalAuth}" name="leaveFinalAuth"
										autocomplete="off" readonly>

								</div>
							</div>

						</c:if> --%>
						<%-- <c:if test="${authorityInformation.claimInitialAuth != '0'}">
							<h6 class="card-title">Claim Authority</h6>

							<div class="form-group row">
								<label class="col-form-label col-lg-2" for="claimInitialAuth">Initial
									Authority : </label>
								<div class="col-lg-6">
									<input type="text" class="form-control" id="claimInitialAuth"
										Value="${authorityInformation.claimInitialAuth}" name="claimInitialAuth"
										autocomplete="off" readonly>

								</div>
							</div>
							<div class="form-group row">
								<label class="col-form-label col-lg-2" for="claimFinalAuth">Final
									Authority : </label>
								<div class="col-lg-6">
									<input type="text" class="form-control" id="claimFinalAuth"
										Value="${authorityInformation.claimFinalAuth}" name="claimFinalAuth"
										autocomplete="off" readonly>

								</div>
							</div>
						</c:if> --%>


<!-- Extra large table -->
				<div class="card">
					<div class="card-header header-elements-inline">
						<h5 class="card-title">Project Hours</h5>
						<div class="header-elements">
							<div class="list-icons">
		                		<a class="list-icons-item" data-action="collapse"></a>
		                		<a class="list-icons-item" data-action="remove"></a>
		                	</div>
	                	</div>
					</div>

					<div class="card-body">
					
					<div class="row">

							<c:forEach items="${projHrsList}" var="projList">
								<div class="col-sm-12 col-md-4">
									<div class="card">
										<div
											class="card-header bg-primary text-white header-elements-inline">
											<h6 class="card-title">${projList.projectTitle}</h6>
											<div class="header-elements">
												<div class="list-icons">
													<a class="list-icons-item" data-action="collapse"></a> <a
														class="list-icons-item" data-action="remove"></a>
												</div>
											</div>
										</div>

										<div class="card-body" align="left">
											Logged Hours
											<h4>${projList.workHrs}</h4>
											Estimated Hours
											<h4>${projList.projectEstMhrs}</h4>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					
					
					</div>
				</div>
				<!-- /extra large table -->




						
						<div class="card">
					<div class="card-header header-elements-inline">
						<h5 class="card-title">Leaves Pending</h5>
						<div class="header-elements">
							<div class="list-icons">
		                		<a class="list-icons-item" data-action="collapse"></a>
		                		<a class="list-icons-item" data-action="remove"></a>
		                	</div>
	                	</div>
					</div>

					<div class="card-body">
						
						
							<div class="row">
							<c:if test="${empLeave==1}">
							<c:forEach items="${employeeInfoList}" var="leaveHistoryList">
								
								<div class="col-sm-12 col-md-4">
									
									<div class="card">
									
										<div
											class="card-header bg-success text-white header-elements-inline">
											<h6 class="card-title">${leaveHistoryList.empName}</h6>
											
											<div class="header-elements">
												<div class="list-icons">
													<a class="list-icons-item" data-action="collapse"></a> <a
														class="list-icons-item" data-action="remove"></a>
												</div>
											</div>
										</div>
									<a href="#" onclick="show(${leaveHistoryList.empId}, ${sessionScope.currYearId})">
										<div class="card-body" align="left">
											Pending Leaves 
											<h4>${leaveHistoryList.balLeave+leaveHistoryList.lvsAllotedLeaves-leaveHistoryList.sactionLeave-leaveHistoryList.aplliedLeaeve} (Days)</h4>
										</div>
									</a>
									</div>
									
								</div>
								
							</c:forEach>
							</c:if>
							
							<c:if test="${empLeave==2}">
								<div class="col-sm-12 col-md-4">
									
									<div class="card">
									
										<div
											class="card-header bg-success text-white header-elements-inline">
											<h6 class="card-title">${leaveHistoryList.empName}</h6>
											
											<div class="header-elements">
												<div class="list-icons">
													<a class="list-icons-item" data-action="collapse"></a> <a
														class="list-icons-item" data-action="remove"></a>
												</div>
											</div>
										</div>									
										<div class="card-body" align="left">
											Pending Leaves 
											<h4>${leaveHistoryList.balLeave+leaveHistoryList.lvsAllotedLeaves-leaveHistoryList.sactionLeave-leaveHistoryList.aplliedLeaeve} (Days)</h4>
										</div>
									
									</div>
									
								</div>
							
							</c:if>
							</div>
						</div>
					</div>
						
						<div class="card">
					<div class="card-header header-elements-inline">
						<h5 class="card-title">Short Leaves Used</h5>
						<div class="header-elements">
							<div class="list-icons">
		                		<a class="list-icons-item" data-action="collapse"></a>
		                		<a class="list-icons-item" data-action="remove"></a>
		                	</div>
	                	</div>
					</div>

					<div class="card-body">
						
						<div class="row">
						<c:if test="${empShortLeave==1}">
							<c:forEach items="${shortLeaveList}" var="slList">
								<div class="col-sm-12 col-md-4">
									<div class="card">
										<div
											class="card-header bg-dark text-white header-elements-inline">
											<h6 class="card-title">${slList.empFname} ${slList.empSname}</h6>
											<div class="header-elements">
												<div class="list-icons">
													<a class="list-icons-item" data-action="collapse"></a> <a
														class="list-icons-item" data-action="remove"></a>
												</div>
											</div>
										</div>

										<div class="card-body" align="left">
											Short Leaves
											<h4>${slList.shLeaveCount}</h4>
										</div>
									</div>
								</div>
							</c:forEach>
							</c:if>
							
							<c:if test="${empShortLeave==2}">
								<div class="col-sm-12 col-md-4">
									<div class="card">
										<div
											class="card-header bg-dark text-white header-elements-inline">
											<h6 class="card-title">${shortLeave.empFname} ${shortLeave.empSname}</h6>
											<div class="header-elements">
												<div class="list-icons">
													<a class="list-icons-item" data-action="collapse"></a> <a
														class="list-icons-item" data-action="remove"></a>
												</div>
											</div>
										</div>

										<div class="card-body" align="left">
											Short Leaves
											<h4>${shortLeave.shLeaveCount}</h4>
										</div>
									</div>
								</div>
							</c:if>
						</div>
						</div>
						</div>
						
						<!-- Current server load -->
						<!-- <div class="card bg-pink-400">
									<div class="card-body">
										<div class="d-flex">
											<h3 class="font-weight-semibold mb-0">49.4%</h3>
											<div class="list-icons ml-auto">
						                		<div class="list-icons-item dropdown">
						                			<a href="#" class="list-icons-item dropdown-toggle" data-toggle="dropdown"><i class="icon-cog3"></i></a>
													<div class="dropdown-menu dropdown-menu-right">
														<a href="#" class="dropdown-item"><i class="icon-sync"></i> Update data</a>
														<a href="#" class="dropdown-item"><i class="icon-list-unordered"></i> Detailed log</a>
														<a href="#" class="dropdown-item"><i class="icon-pie5"></i> Statistics</a>
														<a href="#" class="dropdown-item"><i class="icon-cross3"></i> Clear list</a>
													</div>
						                		</div>
					                		</div>
					                	</div>
					                	
					                	<div>
											Current server load
											<div class="font-size-sm opacity-75">34.6% avg</div>
										</div>
									</div>

									<div id="server-load"></div>
								</div> -->
						<!-- /current server load -->




						<%-- <table
							class="table table-bordered table-hover datatable-highlight1 datatable-button-html5-basic  datatable-button-print-columns11"
							id="printtable1">
							<thead>
								<tr class="bg-blue">

									<th width="10%">Sr. No.</th>
									<th>Project Name</th>
									<th>Total Hrs Spent</th>

								</tr>
							</thead>
							<tbody>


								<c:forEach items="${projHrsList}" var="projList"
									varStatus="count">
									<tr>
										<td>${count.index+1}</td>
										<td>${projList.projectTitle}</td>
										<td style="text-align: right;">${projList.workHrs}</td>

									</tr>
								</c:forEach>

							</tbody>
						</table>

						<table
							class="table table-bordered table-hover datatable-highlight1 datatable-button-html5-basic  datatable-button-print-columns11"
							id="printtable1">
							<thead>
								<tr class="bg-blue">

									<th width="10%">Sr. No.</th>
									<th>Employee Name</th>
									<th>Balanced Leave</th>

								</tr>
							</thead>
							<tbody>


								<c:forEach items="${employeeInfoList}" var="leaveHistoryList"
									varStatus="count">
									<tr>
										<td>${count.index+1}</td>
										<td>${leaveHistoryList.empName}</td>
										<td style="text-align: right;">${leaveHistoryList.balLeave+leaveHistoryList.lvsAllotedLeaves-leaveHistoryList.sactionLeave-leaveHistoryList.aplliedLeaeve}</td>

									</tr>
								</c:forEach>

							</tbody>
						</table> --%>
					</div>

				</div>
				<!-- /highlighting rows and columns -->

			</div>
			<!-- /content area -->


			<!-- Footer -->
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
			<!-- /footer -->

		</div>
		<!-- /main content -->

	</div>
	<!-- /page content -->
<script type="text/javascript">
		function show(empId, calYrId) {
		//	var empId = document.getElementById("empId").value;
		//	var calYrId = document.getElementById("calYrId").value;

			var valid = true;

			if (empId == null || empId == "") {
				valid = false;
				alert("Please Select Employee");
			}

			var valid = true;
			if (calYrId == null || calYrId == "") {
				valid = false;
				alert("Please Select Year");

				var dataTable = $('#bootstrap-data-table').DataTable();
				dataTable.clear().draw();

			}
			$("#loader").show();

			if (valid == true) {

				$
						.getJSON(
								'${empInfoHistoryList}',
								{
									empId : empId,
									calYrId : calYrId,
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

														var str = '<a href="${pageContext.request.contextPath}/empDetailHistory?leaveId='
																+ v.exVar1
																+ '" ><i class="icon-list-unordered"   style="color:black"></i></a>'

														var current_status;
														if (v.exInt1 == 1) {
															/* current_status="Pending"; */

															current_status = '<span class="badge badge-info">Initial Pending</span>';
														} else if (v.exInt1 == 2) {

															current_status = '<span class="badge badge-secondary">Final Pending</span>';
														} else if (v.exInt1 == 3) {
															current_status = '<span class="badge badge-success">Final Approved</span>';
														} else if (v.exInt1 == 7) {
															current_status = '<span class="badge badge-danger">Leave Cancelled</span>';
														} else if (v.exInt1 == 8) {
															current_status = '<span class="badge badge-danger">Initial Rejected</span>';
														} else if (v.exInt1 == 9) {
															current_status = '<span class="badge badge-danger">Final Rejected</span>';
														}

														var duration;
														if (v.leaveDuration == 1) {
															/* current_status="Pending"; */

															duration = 'Full Day';
														}
														if (v.leaveDuration == 2) {
															/* current_status="Pending"; */

															duration = '1st Half Day';
														}if (v.leaveDuration == 3) {
															/* current_status="Pending"; */

															duration = '2nd Half Day';
														}

														dataTable.row
																.add(
																		[
																				i + 1,
																				v.empSname
																						+ " "
																						+ v.empFname,
																				v.empDeptName,
																				v.lvTitle,
																				v.leaveNumDays,
																				duration,
																				v.leaveFromdt
																						+ " To "
																						+ v.leaveTodt,
																				current_status,
																				str ])
																.draw();
													});
									$('#modal_full').modal('show'); 
									$("#loader").hide();

								});

			}//end of if valid ==true

		}

		function callDetail(exVar1, empId) {
			alert(exVar1);
			window
					.open("${pageContext.request.contextPath}/empDetailHistory?empId="
							+ exVar1);

		}

		function callDelete(weighId) {
			window.open("${pageContext.request.contextPath}/deleteWeighing/"
					+ weighId);

		}
	</script>
 <!-- Full width modal -->
				<div id="modal_full" class="modal fade" tabindex="-1">
					<div class="modal-dialog modal-full">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">Employee Leave Details</h5>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
<div class="table-responsive">
							<table 
							class="table table-bordered table-hover datatable-highlight1 datatable-button-html5-basic  datatable-button-print-columns1"
							id="bootstrap-data-table">
							<thead>
								<tr class="bg-blue">
									<th width="10%">Sr.no</th>
									<th>Name</th>
									<th>Department Name</th>
									<th>Leave Type</th>
									 
									<th>Leave Days</th>
									<th>Leave Duration</th>
									<th>Date</th>
									 
									<th>Leave Status</th>

									<th class="text-center" width="10%">Actions</th>
								</tr>
							</thead>
						</table>
						</div>

							<div class="modal-footer">
								<button type="button" class="btn btn-link" data-dismiss="modal">Close</button>
								<!-- <button type="button" class="btn bg-primary">Save changes</button> -->
							</div>
						</div>
					</div>
				</div>
				<!-- /full width modal -->
</body>
</html>