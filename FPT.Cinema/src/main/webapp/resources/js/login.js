var isLoggedIn = false;

function loginSuccess(customerName) {
    isLoggedIn = true;
}

function logoutSuccess() {
    isLoggedIn = false;
}

document.getElementById('member-tab').addEventListener('click', function(event) {
    if (isLoggedIn) {
        event.preventDefault();
    } else {
        var myModalEl = document.getElementById('loginModal');
        var myModal = new bootstrap.Modal(myModalEl, {});
        myModal.show();
    }
});


function logout() {
    // Send an AJAX request to the server to logout
    $.ajax({
        url : "${pageContext.request.contextPath}/logout",
        method : "POST",
        success : function() {
            // Refresh the page or redirect the user
            logoutSuccess(); // Call the function after successful logout
        }
    });
}
