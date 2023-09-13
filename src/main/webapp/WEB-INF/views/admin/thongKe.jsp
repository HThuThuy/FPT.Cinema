<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

  <div class="templatemo-content col-1 light-gray-bg">
      <div class="templatemo-content-container">
        <h3 style="font-size: 35px; margin: 20px 0 30px;">THỐNG KÊ</h3>

        <div class="row" style="display: flex; justify-content: center; align-items: center;">
          

          <div class="col-lg-3 col-md-6">
            <label for="" style="font-size: 15px; color: white;">Chọn thời gian bắt đầu</label>
            <input type="date" id="divDate" class="form-control " />
          </div>

          <div class="col-lg-3 col-md-6">
            <label for="" style="font-size: 15px; color: white;">Chọn thời gian kết thúc</label>
            <input type="date" id="divDate" class="form-control " />
          </div>

          <div class="col-lg-3 col-md-6">
            <a class="btn  " href="MovieAdminInsertServlet?action=Show">Thống kê</a>
          </div>
          <div class="col-lg-3 col-md-6">
            
          </div>
        </div>

        <!-- TABLE THỐNG KÊ THEO SUẤT CHIẾU-->
        <h4 style="font-size: 25px; color: blanchedalmond;">THỐNG KÊ THEO SUẤT CHIẾU</h4>
        <div class="templatemo-content-widget no-padding">
          <div class="panel panel-default table-responsive">
            <table class="table table-striped table-bordered templatemo-user-table">
              <thead>
                <tr>
                  <td><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Suất chiếu <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Số vé <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Số DV A <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Số DV B <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Doanh thu <span class="caret"></span></a></td>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>                  
                </tr>
                <tr>
                  <td>2.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                </tr>
                <tr>
                  <td>3.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                </tr>
                <tr>
                  <td>4.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                </tr>
                <tr>
                  <td>5.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div class="pagination-wrap">
          <ul class="pagination">
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li class="active"><a href="#">3 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
              <a href="#" aria-label="Next">
                <span aria-hidden="true"><i class="fa fa-play"></i></span>
              </a>
            </li>
          </ul>
        </div>
        <!-- TABLE -->
        <!-- TABLE THỐNG KÊ THEO PHIM-->
        <h4 style="font-size: 25px; color: blanchedalmond;">THỐNG KÊ THEO PHIM</h4>
        <div class="templatemo-content-widget no-padding">
          <div class="panel panel-default table-responsive">
            <table class="table table-striped table-bordered templatemo-user-table">
              <thead>
                <tr>
                  <td><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Tên phim <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Số vé <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Doanh thu <span class="caret"></span></a></td>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                </tr>
                <tr>
                  <td>2.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                </tr>
                <tr>
                  <td>3.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>                  
                </tr>
                <tr>
                  <td>4.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                </tr>
                <tr>
                  <td>5.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div class="pagination-wrap">
          <ul class="pagination">
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li class="active"><a href="#">3 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
              <a href="#" aria-label="Next">
                <span aria-hidden="true"><i class="fa fa-play"></i></span>
              </a>
            </li>
          </ul>
        </div>
        <!-- TABLE -->
        <!-- TABLE THỐNG KÊ THEO RẠP-->
        <h4 style="font-size: 25px; color: blanchedalmond;">THỐNG KÊ THEO RẠP</h4>
        <div class="templatemo-content-widget no-padding">
          <div class="panel panel-default table-responsive">
            <table class="table table-striped table-bordered templatemo-user-table">
              <thead>
                <tr>
                  <td><a href="" class="white-text templatemo-sort-by"># <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Tên rạp <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Thành phố <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Số vé <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Số DV A <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Số DV B <span class="caret"></span></a></td>
                  <td><a href="" class="white-text templatemo-sort-by">Doanh thu <span class="caret"></span></a></td>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                </tr>
                <tr>
                  <td>2.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                </tr>
                <tr>
                  <td>3.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                </tr>
                <tr>
                  <td>4.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                </tr>
                <tr>
                  <td>5.</td>
                  <td>MV1</td>
                  <td>Smith</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                  <td>hai kich</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div class="pagination-wrap">
          <ul class="pagination">
            <li><a href="#">1</a></li>
            <li><a href="#">2</a></li>
            <li class="active"><a href="#">3 <span class="sr-only">(current)</span></a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li>
              <a href="#" aria-label="Next">
                <span aria-hidden="true"><i class="fa fa-play"></i></span>
              </a>
            </li>
          </ul>
        </div>
        <!-- TABLE -->

      </div>
    </div>