<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.faq-item {
	margin-bottom: 20px;
}

.question {
	cursor: pointer;
	font-weight: bold;
}

.answer {
	display: none;
}

.plus-sign {
    display: inline-block;
    margin-right: 5px;
    font-weight: bold;
}

p {
    font-size: 20px;
}
</style>

</head>
<body>
<div class="templatemo-content col-1 black-bg">
	<div class="templatemo-content-container">
		<h3 class="text-center display-4 mb-4" style="font-size: 35px;">CÁC CÂU HỎI THƯỜNG GẶP</h3>
		<div class="templatemo-content-widget white-bg">

			<div class="faq-item">
				<h3 class="question">
				<span class="plus-sign">+</span>Câu hỏi 1: Làm cách nào để đặt vé phim?
				</h3>
				<div class="answer">
					<p>Để đặt vé phim, bạn cần truy cập trang chủ, chọn phim và
						suất chiếu mong muốn, sau đó nhấn vào nút "Đặt vé".</p>
				</div>
			</div>

			<div class="faq-item">
				<h3 class="question">
				<span class="plus-sign">+</span>Câu hỏi 2: Làm cách nào để thanh toán vé
					đã đặt?
					</h3>
				<div class="answer">
					<p>Bạn có thể thanh toán vé đã đặt bằng cách chọn phương thức
						thanh toán sau khi chọn ghế và điền thông tin thanh toán.</p>
				</div>
			</div>

			<div class="faq-item">
				<h3 class="question"><span class="plus-sign">+</span>Câu hỏi 3: Làm cách nào để hủy vé đã đặt?</h3>
				<div class="answer">
					<p>Để hủy vé đã đặt, bạn cần truy cập trang lịch sử đặt vé,
						chọn vé cần hủy và nhấn vào nút "Hủy vé".</p>
				</div>
			</div>

			<div class="faq-item">
				<h3 class="question"><span class="plus-sign">+</span>Câu hỏi 4: Làm cách nào để đổi suất chiếu
					đã đặt?</h3>
				<div class="answer">
					<p>Để đổi suất chiếu đã đặt, bạn cần liên hệ với tổng đài hỗ
						trợ của chúng tôi để được hướng dẫn cách thức thực hiện.</p>
				</div>
			</div>

			<div class="faq-item">
				<h3 class="question"><span class="plus-sign">+</span>Câu hỏi 5: Làm cách nào để cập nhật thông
					tin cá nhân?</h3>
				<div class="answer">
					<p>Để cập nhật thông tin cá nhân, bạn cần đăng nhập vào tài
						khoản, sau đó vào phần cài đặt tài khoản để thay đổi thông tin
						mong muốn.</p>
				</div>
			</div>

			<div class="faq-item">
				<h3 class="question"><span class="plus-sign">+</span>Câu hỏi 6: Làm cách nào để thay đổi mật
					khẩu?</h3>
				<div class="answer">
					<p>Để thay đổi mật khẩu, bạn cần đăng nhập vào tài khoản, sau
						đó vào phần cài đặt tài khoản để thay đổi mật khẩu.</p>
				</div>
			</div>

			<div class="faq-item">
				<h3 class="question"><span class="plus-sign">+</span>Câu hỏi 7: Làm cách nào để tìm phim theo
					thể loại?</h3>
				<div class="answer">
					<p>Bạn có thể sử dụng chức năng tìm kiếm trên trang chủ để lọc
						phim theo thể loại mong muốn.</p>
				</div>
			</div>

			<div class="faq-item">
				<h3 class="question"><span class="plus-sign">+</span>Câu hỏi 8: Làm cách nào để xem lịch chiếu
					của một phim?</h3>
				<div class="answer">
					<p>Trên trang chi tiết phim, bạn có thể xem lịch chiếu của phim
						đó bằng cách chọn tab "Lịch Chiếu".</p>
				</div>
			</div>

			<div class="faq-item">
				<h3 class="question"><span class="plus-sign">+</span>Câu hỏi 9: Tôi có thể đặt vé cho nhiều
					người cùng lúc không?</h3>
				<div class="answer">
					<p>Được, bạn có thể đặt vé cho nhiều người cùng lúc bằng cách
						chọn số lượng vé mong muốn trong quá trình đặt vé.</p>
				</div>
			</div>

			<div class="faq-item">
				<h3 class="question"><span class="plus-sign">+</span>Câu hỏi 10: Làm cách nào để liên hệ với
					tổng đài hỗ trợ?</h3>
				<div class="answer">
					<p>Để liên hệ với tổng đài hỗ trợ, bạn có thể gọi số điện thoại
						XXX-XXXX hoặc gửi email tới support@example.com.</p>
				</div>
			</div>
		</div>
	</div>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<script>
    $(document).ready(function() {
        $('.question').click(function() {
            $(this).find('.plus-sign').text(function(_, text) {
                return text === '+' ? '-' : '+';
            });
            $(this).next('.answer').slideToggle();
        });
    });
</script>