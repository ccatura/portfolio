// Email modal
var emailModal = document.getElementById("email-modal");
var openButton = document.getElementById("email-open");
var closeButton = document.getElementById("close-email-modal");

openButton.onclick = function() {
    emailModal.style.display = "flex";
    document.getElementById('email-input').focus();}

closeButton.onclick = function() {
    emailModal.style.display = "none";
}



// note popup
var closePopup = document.getElementById("close-popup");
var popup = document.getElementById("note");
closePopup.onclick = function() {
    popup.style.display = "none";
}



// Scroll to the 'about me' section
var gotoAboutMe = document.getElementById("goto-about-me");
var aboutMe = document.getElementById("about-container");

gotoAboutMe.onclick = function() {
    aboutMe.scrollIntoView({behavior: "smooth"});
}
