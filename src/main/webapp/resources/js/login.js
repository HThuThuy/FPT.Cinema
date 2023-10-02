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

$(document).ready(function() {
    $('#forgotPasswordForm').on('submit', function(e) {
        e.preventDefault();
        if ('check OTP') {
            var forgotPasswordModalEl = document.getElementById('forgotPasswordModal');
            var forgotPasswordModal = bootstrap.Modal.getInstance(forgotPasswordModalEl);
            forgotPasswordModal.hide();

            var resetPasswordModalEl = document.getElementById('resetPasswordModal');
            var resetPasswordModal = new bootstrap.Modal(resetPasswordModalEl, {});
            resetPasswordModal.show();
        }
    });

    $('#birthdate').on('focus', function() {
        $(this).attr('type', 'date');
    });
});