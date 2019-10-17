<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>

<jsp:include page="/WEB-INF/views/include/metacssjs.jsp"></jsp:include>
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

										<div class="card-body" align="left">
											Pending Leaves 
											<h4>${leaveHistoryList.balLeave+leaveHistoryList.lvsAllotedLeaves-leaveHistoryList.sactionLeave-leaveHistoryList.aplliedLeaeve} (Days)</h4>
										</div>
									</div>
								</div>
							</c:forEach>
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

</body>
</html>