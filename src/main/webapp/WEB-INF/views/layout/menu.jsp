<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>

<!-- Nav bar bình thường -->
<div class="layout has-sidebar fixed-sidebar fixed-header">
	<aside id="sidebar" class="sidebar break-point-sm has-bg-image">
		<a id="btn-collapse" class="sidebar-collapser"><i
			class="ri-arrow-left-s-line"></i></a>
		<div class="sidebar-layout">
			<div class="sidebar-header">
				<div class="pro-sidebar-logo">
					<div>D</div>
					<h5>DASH BOARD</h5>
				</div>
			</div>
			<div class="sidebar-content">
				<nav class="menu open-current-submenu">
					<ul>
						<li class="menu-header"><span> MENU</span></li>
						<li class="menu-item sub-menu"><a href="#"> <span
								class="menu-icon"> <i class="ri-vip-diamond-fill"></i>
							</span> <span class="menu-title">Quản lý Nhập Viện</span> <span
								class="menu-suffix"> <span class="badge primary">Hot</span>
							</span>
						</a>
							<div class="sub-menu-list">
								<ul>
									<li class="menu-item"><span class="menu-title"> <a
											class="nav-link"
											href="${pageContext.request.contextPath}/nhapVien/create">Thêm
												mới Thông Tin </a>
									</span></li>
									<li class="menu-item"><span class="menu-title"> <a
											class="nav-link"
											href="${pageContext.request.contextPath}/nhapVien/list">Danh
												sách Thông tin</a>
									</span></li>
								</ul>
							</div></li>


						<li class="menu-header" style="padding-top: 20px"><span>
								DỊCH VỤ KHÁC </span></li>
						<li class="menu-item"><a class="nav-link"
							href="${pageContext.request.contextPath}/asc"> <span
								class="menu-icon"> <i
									class="fa-solid fa-magnifying-glass"></i>
							</span> <span class="menu-title">
							
							Tra cứu giá vàng</span>
						</a></li>


					</ul>
				</nav>
			</div>
			<div class="sidebar-footer">
				<div class="footer-box">FinalTest - TraNLC</div>
			</div>
		</div>
	</aside>
</div>