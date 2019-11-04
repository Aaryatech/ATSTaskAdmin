<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib
	uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
 <div class="navbar navbar-expand-md navbar-dark bg-indigo navbar-static">
		<div class="navbar-brand">
			<a href="${pageContext.request.contextPath}/dashboard" class="d-inline-block">
				<%-- <img src="${pageContext.request.contextPath}/resources/global_assets/images/logo_light.png" alt=""> --%>
				<img src="${pageContext.request.contextPath}/resources/global_assets/images/powerdBy.png" alt="" style="height: 50px; width: 110px;" >
			</a>
		</div>

		<div class="d-md-none">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-mobile">
				<i class="icon-tree5"></i>
			</button>
			<button class="navbar-toggler sidebar-mobile-main-toggle" type="button">
				<i class="icon-paragraph-justify3"></i>
			</button>
		</div>

		<div class="collapse navbar-collapse" id="navbar-mobile">
			<ul class="navbar-nav">
				<li class="nav-item">
					<a href="#" class="navbar-nav-link sidebar-control sidebar-main-toggle d-none d-md-block">
						<i class="icon-paragraph-justify3"></i>
					</a>
				</li>
			</ul>

			<!-- <span class="navbar-text ml-md-3">
				<span class="badge badge-mark border-orange-300 mr-2"></span>
				Morning, Victoria!
			</span> -->
			
			<ul class="navbar-nav ml-md-auto">
			<c:set value="${sessionScope.userType}" var="user"></c:set>
						<c:if test="${user==1}">
				<li class="nav-item dropdown">
					<a href="${pageContext.request.contextPath}/empInfoHistory" class="navbar-nav-link">
					<!-- class="navbar-nav-link dropdown-toggle caret-0" data-toggle="dropdown" -->      <!--// Open commented code(popup) -->
						<i class="icon-calendar3" title="Pending Leaves"></i>
						<span class="d-md-none ml-2">Pending Leaves</span>
						
						<span class="badge badge-pill bg-warning-400 ml-auto ml-md-0">${sessionScope.leaveCount}</span>
					</a>
					
					<!-- <div class="dropdown-menu dropdown-menu-right dropdown-content wmin-md-350">
						<div class="dropdown-content-header">
							<span class="font-weight-semibold">Pending Leaves</span>
							<a href="#" class="text-default"><i class="icon-compose"></i></a>
						</div>

						<div class="dropdown-content-body dropdown-scrollable">
							<ul class="media-list">
								<li class="media">
									<div class="mr-3 position-relative">
										<img src="../../../../global_assets/images/demo/users/face10.jpg" width="36" height="36" class="rounded-circle" alt="">
									</div>

									<div class="media-body">
										<div class="media-title">
											<a href="#">
												<span class="font-weight-semibold">James Alexander</span>
												<span class="text-muted float-right font-size-sm">04:58</span>
											</a>
										</div>

										<span class="text-muted">who knows, maybe that would be the best thing for me...</span>
									</div>
								</li>

								<li class="media">
									<div class="mr-3 position-relative">
										<img src="../../../../global_assets/images/demo/users/face3.jpg" width="36" height="36" class="rounded-circle" alt="">
									</div>

									<div class="media-body">
										<div class="media-title">
											<a href="#">
												<span class="font-weight-semibold">Margo Baker</span>
												<span class="text-muted float-right font-size-sm">12:16</span>
											</a>
										</div>

										<span class="text-muted">That was something he was unable to do because...</span>
									</div>
								</li>

								<li class="media">
									<div class="mr-3">
										<img src="../../../../global_assets/images/demo/users/face24.jpg" width="36" height="36" class="rounded-circle" alt="">
									</div>
									<div class="media-body">
										<div class="media-title">
											<a href="#">
												<span class="font-weight-semibold">Jeremy Victorino</span>
												<span class="text-muted float-right font-size-sm">22:48</span>
											</a>
										</div>

										<span class="text-muted">But that would be extremely strained and suspicious...</span>
									</div>
								</li>

								<li class="media">
									<div class="mr-3">
										<img src="../../../../global_assets/images/demo/users/face4.jpg" width="36" height="36" class="rounded-circle" alt="">
									</div>
									<div class="media-body">
										<div class="media-title">
											<a href="#">
												<span class="font-weight-semibold">Beatrix Diaz</span>
												<span class="text-muted float-right font-size-sm">Tue</span>
											</a>
										</div>

										<span class="text-muted">What a strenuous career it is that I've chosen...</span>
									</div>
								</li>

								<li class="media">
									<div class="mr-3">
										<img src="../../../../global_assets/images/demo/users/face25.jpg" width="36" height="36" class="rounded-circle" alt="">
									</div>
									<div class="media-body">
										<div class="media-title">
											<a href="#">
												<span class="font-weight-semibold">Richard Vango</span>
												<span class="text-muted float-right font-size-sm">Mon</span>
											</a>
										</div>
										
										<span class="text-muted">Other travelling salesmen live a life of luxury...</span>
									</div>
								</li>
							</ul>
						</div>

						<div class="dropdown-content-footer justify-content-center p-0">
							<a href="#" class="bg-light text-grey w-100 py-2" data-popup="tooltip" title="Load more"><i class="icon-menu7 d-block top-0"></i></a>
						</div>
					</div> -->
				</li>
		</c:if>
			
				<li class="nav-item">
					<a href="${pageContext.request.contextPath}/logout" class="navbar-nav-link">
						<i class="icon-switch2"></i>
						<span class="d-md-none ml-2">Logout</span>
					</a>
				</li>
			</ul>
		</div>
	</div>