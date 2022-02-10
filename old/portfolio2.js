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



// Scroll to the 'about me' section
var gotoAboutMe = document.getElementById("goto-about-me");
var aboutMe = document.getElementById("about-me-container");

gotoAboutMe.onclick = function() {
    aboutMe.scrollIntoView({behavior: "smooth"});
}
