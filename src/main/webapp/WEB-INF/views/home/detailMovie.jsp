<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!-- ***** Preloader Start ***** -->
<div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="page-content">

          <!-- ***** Banner Start ***** -->
          <div class="row">
            <div class="col-lg-12">
              <div class="main-profile ">
                <div class="row">
                  <div class="col-lg-4 align-self-center">
                    <img
											src="${pageContext.request.contextPath}/resources/img/phimhot2.jpg"
											alt="" class="image">
                  </div>
                  <div class="col-lg-4 align-self-center">
                    <div class="main-info header-text">
                      <span>Đang chiếu</span>
                      <h4>Kẻ ẩn danh</h4>
                      <p>Đạo diễn: Trần Trọng Dần
                        <br>

                        Thể loại: Hài, Gia Đình, Hành Động
                        <br>

                        Diễn viên: Kiều Minh Tuấn, Quốc Trường, Vân Trang, Mạc Văn Khoa
                        <br>
                        Quốc gia: Việt Nam
                        <br>
                        Ngày khởi chiếu: 25/8/2023

                      </p>
                     
                    </div>
                  </div>
                  <div class="col-lg-4 align-self-center">
                    <ul>
                      <li>Lượt xem <span>3</span></li>
                      <li>Điểm đánh giá <span>4.2</span></li>
                      <li>Chi nhánh <span>Đà Nẵng</span></li>
                      <li>Trailer <span>29</span></li>
                    </ul>
                  </div>
                </div>

                <div class="row">
                  <div class="col-lg-12">
                    <div class="clips">
                      <div class="row">
                        <div class="col-lg-12">
                          <div class="heading-section">
                            <h4><em>NỘI DUNG PHIM</em> Movie Details</h4>
                          </div>
                        </div>

                        <p>Lâm - một người đàn ông từng là xã hội đen nhưng lại mất trí nhớ và nay đang lẩn trốn như một
                          người
                          bình thường, kiếm sống bằng lao động chân tay. Lâm sống cùng vợ - Hạnh và con gái riêng của cô
                          là
                          Hiền. Hiền vẫn chưa chấp nhận tình yêu thương của chú Lâm dành cho mình. Hiền lớn lên với sự
                          bốc
                          đồng và bị dụ dỗ bởi Tiến - một thanh niên đạo đức giả chuyên dụ dỗ những cô gái vào nhà thổ
                          để trở
                          thành gái mại dâm. Xuyên suốt bộ phim là hành trình đi tìm con gái của Lâm Phim mới Kẻ Ẩn
                          Danh
                          khởi chiếu 25.08.2023 tại rạp chiếu phim toàn quốc.

                        </p>

                        <div class="col-lg-12">
                          <div class="main-button">
                            <a href="#">Load More Infor</a>
                          </div>
                        </div>
                        <h4 class="mt-4"><em>LỊCH CHIẾU</em> </h4>
                        <div class="row mt-3 mb-3">
                          <div class="col-4">

                            <div class="form-group">
                              <select class="form-control" id="branch" name="branch">
                                <option value="branch1">Cả nước</option>
                                <option value="branch1">TP.Hồ Chí Minh</option>
                                <option value="branch2">TP.Hà Nội</option>
                                <option value="branch3">TP.Đà Nẵng</option>
                              </select>
                            </div>
                          </div>

                          <div class="col-4">
                            <div class="form-group">

                              <input type="date" class="form-control" id="usr">
                            </div>

                          </div>

                          <div class="col-4">

                            <div class="form-group">
                              <select class="form-control" id="theater" name="theater">
                                <option value="theater1">Tất cả rạp</option>
                                <option value="theater1">FPT Cinema 1</option>
                                <option value="theater2">FPT Cinema 2</option>
                                <option value="theater3">FPT Cinema 3</option>
                              </select>
                            </div>

                          </div>
                        </div>
                      
                      </div>
                      <div class="row">
                        <h4 class="mt-4"><em>FPT Cinema 1</em> </h4>
                        <div class="row show-time mt-3">
                          <div class="col-3 title">
                          
                            <h5>2D- Phụ đề</h5>
                          </div>
                          <div class="col-9 content">
                            <a class="show_time_boder" href="booking.html">10:00</a>
                            <a class="show_time_boder" href="booking.html">11:00</a>

                            <a class="show_time_boder" href="booking.html">12:00</a>
                            <a class="show_time_boder" href="booking.html">13:45</a>
                            <a class="show_time_boder" href="booking.html">15:30</a>
                            <a class="show_time_boder" href="booking.html">16:00</a>
                            <a class="show_time_boder" href="booking.html">17:45</a>
                            <a class="show_time_boder" href="booking.html">18:30</a>

                          </div>
                        </div>

                        <div class="row show-time mt-3">
                          <div class="col-3 title">
                          
                            <h5>3D- Phụ đề</h5>
                          </div>
                          <div class="col-9 content">
                            <a class="show_time_boder" href="booking.html">10:00</a>
                            <a class="show_time_boder" href="booking.html">11:00</a>

                            <a class="show_time_boder" href="booking.html">12:00</a>
                            <a class="show_time_boder" href="booking.html">13:45</a>
                            <a class="show_time_boder" href="booking.html">15:30</a>
                            <a class="show_time_boder" href="booking.html">16:00</a>
                            <a class="show_time_boder" href="booking.html">17:45</a>
                            <a class="show_time_boder" href="booking.html">18:30</a>

                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- ***** Banner End ***** -->

        
        </div>
      </div>
    </div>
  </div>