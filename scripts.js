import configData from './projects.json' assert { type: "json" }; //import projects from json file

var clickEmailModal     = document.getElementById('click-email-modal');
var emailModal          = document.getElementById('email-modal');
var closeEmailModal     = document.getElementById('close-email-modal');
var clickAbout          = document.getElementById('click-about');
var pacman              = document.getElementById('pacman');
var subHeadingInput     = document.getElementById('sub-heading-input');
var subHeadValue        = subHeadingInput.value;

clickEmailModal.addEventListener('click', function() {
    showEmailModal();
});

closeEmailModal.addEventListener('click', function() {
    showEmailModal();
});

emailModal.addEventListener('click', function(e) {
    if(e.target.id == 'email-modal') {
        showEmailModal();
    }
});

clickAbout.addEventListener('click', function() {
    scrollToAbout();
});

subHeadingInput.addEventListener('click', function() {
    this.select();
});

subHeadingInput.addEventListener('focusout', function() {
    showPacman();
});

subHeadingInput.addEventListener('change', function() {
    showPacman();
});












function showEmailModal() {
    emailModal.classList.toggle('show-hide');
}

function scrollToAbout() {
    document.getElementById('about').scrollIntoView({behavior: 'smooth'});
}

function showPacman() {
    if(subHeadingInput.value == '') {
        resetHeading();
    } else if(subHeadingInput.value == 'pacman' || subHeadingInput.value == 'pac-man') {
        pacman.style.opacity = "1";
        pacman.style.width = "400px";
        setTimeout(() => {
            pacman.style.opacity = "0";
            pacman.style.width = "0";    
        }, 3000);

        resetHeading();
    }
}

// Resets the subheading value
function resetHeading() {
    subHeadingInput.value = subHeadValue;
}
