<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>

<jsp:include page="/WEB-INF/views/include/metacssjs.jsp"></jsp:include>
<c:url var="empExtraWorkHrs" value="/empExtraWorkHrs" />
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
						<h5 class="card-title">Employee Leave History</h5>
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

						<form method="post" id="reportForm" name="myForm">
							<div class="form-group row">

								<label class="col-form-label col-lg-2" for="empId">
									Employee <span style="color: red">* </span>:
								</label>
								<div class="col-lg-4">

									<select multiple="multiple" data-placeholder="Select Employee"
										name="empId" id="empId"
										class="form-control form-control-sm select"
										data-container-css-class="select-sm" data-fouc>
										<option value="">Select Employee</option>
										<option value="0">All</option>
										<c:forEach items="${employeeInfoList}" var="emp">
											<option value="${emp.empId}">${emp.empFname}
												${emp.empSname}</option>
										</c:forEach>

									</select>  
								</div>



								<label class="col-form-label col-lg-2">Date Range<span
									style="color: red">* </span>:
								</label>
								<div class="col-lg-3">
									<input type="text" class="form-control daterange-basic_new "
										name="dateRange" data-placeholder="Select Date" id="dateRange">
								 
								</div>
								 
									<button type="button" class="btn bg-blue ml-3 legitRipple"
										id="submtbtn" onclick="show()">
										Submit <i class="icon-paperplane ml-2"></i>
									</button>
							 

							</div>
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
										<th>Employee Name</th>
										<th>Extra Work Hrs</th>

									</tr>
								</thead>
							</table>
							<input type="hidden" id="p" name="p" value="0">



							<button type="button" class="btn bg-blue ml-3 legitRipple"
								id="submtbtn" onclick="getProgReport(1,'showExtraHrsRep')">
								PDF <i class="icon-paperplane ml-2"></i>
							</button>

							<button type="button" class="btn bg-blue ml-3 legitRipple"
								id="submtbtn" onclick="getProgReport(0,'showExtraHrsRep')">
								Excel <i class="icon-paperplane ml-2"></i>
							</button>

						</form>
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
		//use this function for all reports just get mapping form action name dynamically as like of prm from every report pdf,excel function	
		function getProgReport(prm, mapping) {
			if (prm == 1) {
				document.getElementById("p").value = "1";
			}

			var form = document.getElementById("reportForm");

			form.setAttribute("target", "_blank");
			form.setAttribute("method", "post");

			form.action = ("${pageContext.request.contextPath}/" + mapping + "/");

			form.submit();

			document.getElementById("p").value = "0";
		}
	</script>
	<script type="text/javascript">
		function show() {

			//alert("Hi View Orders  ");

			var empId = $("#empId").val();

			var dateRange = document.getElementById("dateRange").value;

			var str = "-1", i;

			for (i = 0; i < myForm.empId.options.length; i++) {
				if (myForm.empId.options[i].selected) {
					str = str + "," + myForm.empId.options[i].value;
				}
			}

			//alert("Options selected are " + str);
			//alert(empId);

			var valid = true;

			if (empId == null || empId == "") {
				valid = false;
				alert("Please Select Employee");
			}

			if (dateRange == null || dateRange == "") {
				valid = false;
				alert("Please Select Date");

				var dataTable = $('#bootstrap-data-table').DataTable();
				dataTable.clear().draw();

			}
		

			if (valid == true) {
				$("#loader").show();

				$.getJSON('${empExtraWorkHrs}', {
					empId : str,
					dateRange : dateRange,
					ajax : 'true',
				},

				function(data) {

					var dataTable = $('#bootstrap-data-table').DataTable();
					dataTable.clear().draw();

					$.each(data, function(i, v) {

						dataTable.row.add([ i + 1, v.empFname, v.empBudHr ])
								.draw();
					});
					$("#loader").hide();

				});

			}//end of if valid ==true

		}
	</script>
	<script>
		$(document).ready(function($) {

			$("#submtbtn").submit(function(e) {
				var isError = false;
				var errMsg = "";

				if (!$("#empId").val()) {

					isError = true;

					$("#error_empId").show()

				} else {
					$("#error_empId").hide()
				}

				if (!$("#dateRange").val()) {

					isError = true;

					$("#error_dateRange").show()

				} else {
					$("#error_dateRange").hide()
				}

				if (!isError) {

					var x = confirm("Do you really want to submit the form?");
					if (x == true) {

						document.getElementById("submtbtn").disabled = true;
						return true;
					}
					//end ajax send this to php page
				}
				return false;
			});
		});
		//
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