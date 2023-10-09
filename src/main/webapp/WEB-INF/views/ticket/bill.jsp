<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<style>
@import
    url("https://fonts.googleapis.com/css2?family=Staatliches&display=swap")
    ;

@import
    url("https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap")
    ;

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

bill-movie {
    height: 100vh;
    display: grid;
    font-family: "Staatliches", cursive;
    background: #d83565;
    color: black;
    font-size: 14px;
    letter-spacing: 0.1em;
}

.ticket-bill {
    margin: auto;
    display: flex;
    background: white;
    box-shadow: rgba(0, 0, 0, 0.3) 0px 19px 38px, rgba(0, 0, 0, 0.22) 0px
        15px 12px;
        height: 350px;
}

.left {
    display: flex;
}

.image {
    height: 250px;
    width: 250px;
    /* background-image:
        url("https://media.pitchfork.com/photos/60db53e71dfc7ddc9f5086f9/1:1/w_1656,h_1656,c_limit/Olivia-Rodrigo-Sour-Prom.jpg"); */
    background-size: contain;
    opacity: 0.85;
    margin-top: 52px;
}

.admit-one {
    position: absolute;
    color: darkgray;
    height: 250px;
    padding: 0 10px;
    letter-spacing: 0.15em;
    display: flex;
    text-align: center;
    justify-content: space-around;
    writing-mode: vertical-rl;
    transform: rotate(-180deg);
}

.admit-one span:nth-child(2) {
    color: white;
    font-weight: 700;
}

.left .ticket-number {
    height: 250px;
    width: 250px;
    display: flex;
    justify-content: flex-end;
    align-items: flex-end;
    padding: 5px;
}

.ticket-info {
    padding: 10px 30px;
    display: flex;
    flex-direction: column;
    text-align: center;
    justify-content: space-between;
    align-items: center;
}

.date {
    border-top: 1px solid gray;
    border-bottom: 1px solid gray;
    padding: 5px 0;
    font-weight: 700;
    display: flex;
    align-items: center;
    justify-content: space-around;
}

.date span {
    width: 100px;
}

.date span:first-child {
    text-align: left;
}

.date span:last-child {
    text-align: right;
}

.date .june-29 {
    color: #d83565;
    font-size: 20px;
}

.show-name {
    font-size: 32px;
    font-family: "Nanum Pen Script", cursive;
    color: #d83565;
}

.show-name h1 {
    font-size: 48px;
    font-weight: 700;
    letter-spacing: 0.1em;
    color: #4a437e;
}

.time {
    padding: 10px 0;
    color: #4a437e;
    text-align: center;
    display: flex;
    flex-direction: column;
    gap: 10px;
    font-weight: 700;
    width: 170px;
}

.time span {
    font-weight: 400;
    color: gray;
}

.left .time {
    font-size: 16px;
}

.location {
    display: flex;
    justify-content: space-around;
    align-items: center;
    width: 100%;
    padding-top: 8px;
    border-top: 1px solid gray;
}

.location .separator {
    font-size: 20px;
}

.right {
    width: 180px;
    border-left: 1px dashed #404040;
}

.right .admit-one {
    color: darkgray;
}

.right .admit-one span:nth-child(2) {
    color: gray;
}

.right .right-info-container {
    height: 250px;
    padding: 10px 10px 10px 35px;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
}

.right .show-name h1 {
    font-size: 18px;
}

.barcode {
    height: 100px;
}

.barcode img {
    height: 100%;
}

.right .ticket-number {
    color: gray;
}
</style>

<div class="container">
    <div class="row">
        <div class="col">
            <div class="page-content2">

                <!-- ***** Details Start ***** -->
                <div class="game-details" style="margin-top: 20px;">
                    <div class="row" style="justify-content: center;">

                        <h2>TICKETS ORDER</h2>
                        <div class="col-8">
                            <div class="row bill-movie">
                                <div class="ticket-bill">
                                    <div class="left">
                                        <div class="image">
                                        <img src="${movieChoose.posterUrl}" alt="">
                                            <div class="ticket-number" style="margin-top: 10px;"></div>
                                        </div>
                                        <div class="ticket-info">
                                            <p class="date">
                                                <span id="dayOfWeek"></span> <span id="monthDay" class="june-29"></span>
                                                <span>2023</span>
                                            </p>
                                            <div class="show-name">
                                                <p>${movieChoose.movieName}</p>
                                                <p>${movieChoose.director}</p>
                                            </div>
                                            <div class="time">
                                                <p>
                                                    Giờ bắt đầu: <span>From</span> ${theaterSel.startTime} 
                                                    
                                                </p>
                                                <p>
                                                    ${theaterSel.room.roomName} <%-- <span>@</span> ${theaterSel.room.roomType} --%>
                                                </p>
                                                
                                            </div>
                                            <p class="location">
                                                <span>FPT Cinema</span> <span class="separator"><i
                                                    class="far fa-smile"></i></span><span>Đà Nẵng, Việt Nam</span>
                                            </p>
                                        </div>
                                    </div>
                                    <div class="right">

                                        <div class="right-info-container">
                                            <div class="show-name"></div>
                                            <div class="time">
                                                <p class="mt-4">
                                                    Welcome to FPT Cinema
                                                </p>
                                                <p>
                                                   08:00 AM <span>TO</span> 22:00 PM
                                                </p>
                                                
                                            </div>
                                            <div class="barcode">
                                                <img
                                                    src="https://external-preview.redd.it/cg8k976AV52mDvDb5jDVJABPrSZ3tpi1aXhPjgcDTbw.png?auto=webp&s=1c205ba303c1fa0370b813ea83b9e1bddb7215eb"
                                                    alt="QR code">
                                            </div>
                                            <p class="ticket-number">#20030220</p>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
                <!-- ***** Details End ***** -->


            </div>
        </div>
    </div>
</div>

<script>
    // Lấy thứ, ngày và tháng hiện tại
    var currentDate = new Date();
    var dayOfWeek = currentDate.toLocaleDateString('en-US', { weekday: 'long' });
    var month = currentDate.toLocaleDateString('en-US', { month: 'long' });
    var day = currentDate.getDate();
    var year = currentDate.getFullYear();

    // Gán giá trị vào các phần tử HTML
    document.getElementById('dayOfWeek').textContent = dayOfWeek.toUpperCase();
    document.getElementById('monthDay').textContent = month.toUpperCase() + ' ' + getOrdinalSuffix(day);
    document.getElementById('year').textContent = year;

    // Hàm để thêm hậu tố 'st', 'nd', 'rd', 'th' cho ngày
    function getOrdinalSuffix(day) {
        var suffixes = ['th', 'st', 'nd', 'rd'];
        var relevantDigits = (day < 30) ? day % 20 : day % 30;
        var suffix = (relevantDigits <= 3 && relevantDigits >= 1) ? suffixes[relevantDigits] : suffixes[0];
        return day + suffix;
    }
</script>