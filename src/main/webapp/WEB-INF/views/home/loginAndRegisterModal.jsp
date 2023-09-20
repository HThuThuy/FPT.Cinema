<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>


<div class="modal fade" id="loginModal" tabindex="-1"
	aria-labelledby="loginModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="login-tab" data-bs-toggle="tab"
						href="#login" role="tab" aria-controls="login"
						aria-selected="true" style="color: #ec6090;"><h4>ĐĂNG
								NHẬP</h4></a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="register-tab" data-bs-toggle="tab" href="#register" role="tab"
						aria-controls="register" aria-selected="false"
						style="color: #ec6090;"><h4>ĐĂNG KÝ</h4></a></li>
				</ul>
			</div>
			<div class="modal-body">
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="login" role="tabpanel"
						aria-labelledby="login-tab">
						<!-- Login form -->

						<jsp:include page="loginModal.jsp" />


					</div>
					<div class="tab-pane fade" id="register" role="tabpanel"
						aria-labelledby="register-tab">
						<!-- Register form -->

						<jsp:include page="registerModal.jsp" />

					</div>
				</div>
			</div>

		</div>
	</div>
</div>

<script>
    /* // Thêm sự kiện click cho tab Đăng Ký
    document.getElementById("register-tab").addEventListener("click", function(event) {
        // Thay đổi URL trên trình duyệt
        history.pushState({}, "", "${pageContext.request.contextPath}/register");
    });

    // Thêm sự kiện click cho tab Đăng Nhập
    document.getElementById("login-tab").addEventListener("click", function(event) {
        // Thay đổi URL trên trình duyệt
        history.pushState({}, "", "${pageContext.request.contextPath}/login");
    });

    $(document).ready(function() {
        $('#loginModal').on('hide.bs.modal', function () {
            console.log('Modal is hiding');
            history.pushState({}, "", "${pageContext.request.contextPath}/");
        });
    });
 */
</script>