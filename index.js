// Email modal
var emailModal = document.getElementById("email-modal");
var openButton = document.getElementById("email-open");
var closeButton1 = document.getElementById("close-email-modal");
var closeButton2 = document.getElementById("send-email");

openButton.onclick = function() {
    emailModal.style.display = "flex";
    document.getElementById('email-input').focus();
    document.getElementById('email-textarea').value = '';
    document.getElementById('email-input').value = '';

}

closeButton1.onclick = function() {
    emailModal.style.display = "none";
}

closeButton2.onclick = function() {
    emailModal.style.display = "none";
}




// Scroll to the 'about me' section
var gotoAboutMe = document.getElementById("goto-about-me");
var aboutMe = document.getElementById("about-container");

gotoAboutMe.onclick = function() {
    aboutMe.scrollIntoView({behavior: "smooth"});
}






// note popup
var closePopup = document.getElementById("closebox");
var popup = document.getElementById("popup");
closePopup.onclick = function() {
    popup.style.display = "none";
}