var subHeadingInput = document.getElementById('sub-heading-input');
var subHeadValue = subHeadingInput.value;
var pacman = document.getElementById('pacman');
var emailModal = document.getElementById('email-modal');

subHeadingInput.addEventListener('click', function() {
    this.select();
});


subHeadingInput.addEventListener('focusout', function() {
    showPacman();
});

subHeadingInput.addEventListener('change', function() {
    showPacman();
});

emailModal.addEventListener('click', function(e) {
    if(e.target.id == 'email-modal') {
        showEmailModal();
    }
});






function scrollToAbout() {
    document.getElementById('about').scrollIntoView({behavior: 'smooth'});
}

function showEmailModal() {
    emailModal.classList.toggle('show-hide');
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











fetch('./projects.json')
    .then((response) => response.json())
    .then((json) => console.log(json));
