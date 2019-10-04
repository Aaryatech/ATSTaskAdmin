<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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

				<!-- Form validation -->
				<div class="row">
					<div class="col-md-12">
						<!-- Title -->
						<!-- <div class="mb-3">
							<h6 class="mb-0 font-weight-semibold">Hidden labels</h6>
							<span class="text-muted d-block">Inputs with empty values</span>
						</div> -->
						<!-- /title -->


						<div class="card">
							<div class="card-header header-elements-inline">
								<h6 class="card-title">Add Project Work Hours</h6>
								<!-- <div class="header-elements">
									<div class="list-icons">
										<a class="list-icons-item" data-action="collapse"></a>
									</div>
								</div> -->
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
										out.println(session.getAttribute("errorMsg"));
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
										out.println(session.getAttribute("successMsg"));
									%>
								</div>
								<%
									session.removeAttribute("successMsg");
									}
								%>

								<form
									action="${pageContext.request.contextPath}/submitInsertProjHrs"
									id="submitInsertProjHrs" method="post">
									<div class="form-group row">
										<label class="col-form-label col-lg-2" for="select2">Select
											Project <span style="color: red">* </span>:
										</label>
										<div class="col-lg-10">
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
									</div>


									<div class="form-group row">
										<label class="col-form-label col-lg-2" for="select2">Work
											Type <span style="color: red">* </span>:
										</label>
										<div class="col-lg-10">
											<select name="workTypeId" data-placeholder="Select Work Type"
												id="workTypeId"
												class="form-control form-control-select2 select2-hidden-accessible"
												aria-hidden="true">
												<option value="">Please Select</option>
												<c:forEach items="${workTypeList}" var="workTypeList">
													<option value="${workTypeList.workTypeId}">${workTypeList.workTypeName}</option>
												</c:forEach>

											</select> <span class="validation-invalid-label" id="error_workTypeId"
												style="display: none;">This field is required.</span>
										</div>
									</div>


									<div class="form-group row">
										<label class="col-form-label col-lg-2" for="select2">
											Type <span style="color: red">* </span>:
										</label>
										<div class="col-lg-10">
											<select name="TypeId" data-placeholder="Select  Type"
												id="TypeId"
												class="form-control form-control-select2 select2-hidden-accessible"
												aria-hidden="true">
												<option value="">Please Select</option>
												<option value="1">Routine</option>
												<option value="2">Extra</option>

											</select> <span class="validation-invalid-label" id="error_TypeId"
												style="display: none;">This field is required.</span>
										</div>
									</div>


									<div class="form-group row">
										<label class="col-form-label col-lg-2" for="joiningDate">Work
											Date <span style="color: red">* </span>:
										</label>
										<div class="col-lg-10">
											<input type="text" class="form-control datepickerclass "
												name="workDate" id="workDate" placeholder="Work Date">
											<span class="validation-invalid-label" id="error_workDate"
												style="display: none;">This field is required.</span>
										</div>
									</div>


									<div class="form-group row">
										<label class="col-form-label col-lg-2" for="projectTitle">
											Project Hrs <span style="color: red">* </span>:
										</label>
										<div class="col-lg-10">
											<input type="text" class="form-control"
												placeholder="Enter Project Hrs" id="projectHrs"
												data-mask="99:99" name="projectHrs" autocomplete="off">
											<span class="validation-invalid-label" id="error_projectHrs"
												style="display: none;">This field is required.</span>
										</div>
									</div>


									<div class="form-group row">
										<label class="col-form-label col-lg-2" for="remark">Work
											Description : </label>
										<div class="col-lg-10">
											<textarea rows="3" cols="3" class="form-control"
												placeholder="Any Remark" onchange="trim(this)" id="woDesc"
												name="woDesc"></textarea>

										</div>
									</div>

									<div class="form-group row mb-0">
										<div class="col-lg-10 ml-lg-auto">

											<button type="submit" class="btn bg-blue ml-3 legitRipple"
												id="submtbtn">
												Submit <i class="icon-paperplane ml-2"></i>
											</button>

										</div>
									</div>
								</form>
							</div>
						</div>


					</div>
				</div>

			</div>
			<!-- /content area -->


			<!-- Footer -->
			<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
			<!-- /footer -->

		</div>
		<!-- /main content -->

	</div>
	<!-- /page content -->

	<script>
		function trim(el) {
			el.value = el.value.replace(/(^\s*)|(\s*$)/gi, ""). // removes leading and trailing spaces
			replace(/[ ]{2,}/gi, " "). // replaces multiple spaces with one space 
			replace(/\n +/, "\n"); // Removes spaces after newlines
			return;
		}

		$(document).ready(function($) {

			$("#submitInsertProjHrs").submit(function(e) {
				var isError = false;
				var errMsg = "";

				if (!$("#projId").val()) {

					isError = true;

					$("#error_projId").show()
					//return false;
				} else {
					$("#error_projId").hide()
				}

				if (!$("#workTypeId").val()) {

					isError = true;

					$("#error_workTypeId").show()

				} else {
					$("#error_workTypeId").hide()
				}

				if (!$("#workDate").val()) {

					isError = true;

					$("#error_workDate").show()

				} else {
					$("#error_workDate").hide()
				}

				if (!$("#projectHrs").val()) {

					isError = true;

					$("#error_projectHrs").show()

				} else {
					$("#error_projectHrs").hide()
				}
				if (!$("#TypeId").val()) {

					isError = true;

					$("#error_TypeId").show()

				} else {
					$("#error_TypeId").hide()
				}

				if (!isError) {

					var x = true;
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

		//daterange-basic_new
		// Basic initialization
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