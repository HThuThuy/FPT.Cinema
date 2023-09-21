document.getElementById('member-tab').addEventListener('click', function(event) {
    event.preventDefault();
    var myModalEl = document.getElementById('loginModal');
    var myModal = new bootstrap.Modal(myModalEl, {});
    myModal.show();
});

$(document).ready(function() {
    // When the forgot password form is submitted...
    $('#forgotPasswordForm').on('submit', function(e) {
        e.preventDefault();

        // Check the OTP here...
        // If the OTP is correct...
        if ('check OTP') {
            // Close the forgot password modal
            var forgotPasswordModalEl = document.getElementById('forgotPasswordModal');
            var forgotPasswordModal = bootstrap.Modal.getInstance(forgotPasswordModalEl);
            forgotPasswordModal.hide();

            // Open the reset password modal
            var resetPasswordModalEl = document.getElementById('resetPasswordModal');
            var resetPasswordModal = new bootstrap.Modal(resetPasswordModalEl, {});
            resetPasswordModal.show();
        }
    });
});


$(document).ready(function() {
  $('#birthdate').on('focus', function() {
    $(this).attr('type', 'date');
  });
});

/*var xhr = new XMLHttpRequest();
xhr.addEventListener('readystatechange', function() {
  if (xhr.status == 401) { 
    $('#loginModal').modal('show');
  }
});
*/