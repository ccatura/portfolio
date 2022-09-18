// Email modal
var emailModal = document.getElementById("email-modal");
var openButton = document.getElementById("email-open");
var closeButton = document.querySelector("#close-email-modal, #send-email");

openButton.onclick = function() {
    emailModal.style.display = "flex";
    document.getElementById('email-input').focus();
    document.getElementById('email-textarea').value = '';
    document.getElementById('email-input').value = '';

}

closeButton.onclick = function() {
    emailModal.style.display = "none";
}


// Scroll to the 'about me' section
var gotoAboutMe = document.getElementById("goto-about-me");
var aboutMe = document.getElementById("about-container");

gotoAboutMe.onclick = function() {
    aboutMe.scrollIntoView({behavior: "smooth"});
}












// note popup at start
var closePopup = document.querySelector("#closebox");
var popup = document.querySelector("#popup-dim");

document.body.addEventListener("click", function(e) {
    if(e.target.id == "popup-dim" || e.target.id == "closebox") {
        popup.style.display = "none";
        document.body.style.overflow = "auto";
    };
})
