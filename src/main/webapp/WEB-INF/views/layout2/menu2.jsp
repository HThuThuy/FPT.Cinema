<%@ page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>


    <div class="templatemo-sidebar">
        <header class="templatemo-site-header">
         <a href="index.html" class="logo"> <img
					src="${pageContext.request.contextPath}/resources/img/logo.png"
					width="200" height="80" alt="logo">
				</a>
        </header>
        <div class="profile-photo-container">
          
          <div class="profile-photo-overlay"></div>
        </div>      
       
        <div class="mobile-menu-icon">
            <i class="fa fa-bars"></i>
          </div>
        <nav class="templatemo-left-nav">          
          <ul>
            <li><a href="${pageContext.request.contextPath}/admin/quanLySuatChieu"><i class="fa fa-database fa-fw"></i>Quản lý suất chiếu</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/quanLyPhim"><i class="fa fa-film fa-fw"></i>Quản lý phim</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/quanLyRap"><i class="fa fa-masks-theater"></i>Quản lý rạp</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/thongKe"><i class="fa fa-bar-chart fa-fw"></i>Thống kê suất chiếu</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/thongKe2"><i class="fa fa-bar-chart fa-fw"></i>Thống kê phim</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/thongKe3"><i class="fa fa-bar-chart fa-fw"></i>Thống kê rạp</a></li>
			<li><a href="${pageContext.request.contextPath}/"><i class="fa fa-eject fa-fw"></i>Sign Out</a></li>
          </ul>  
        </nav>
      </div>