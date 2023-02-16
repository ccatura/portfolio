import configData from './projects.json' assert { type: "json" }; //import projects from json file

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






listProjects();
function listProjects() {
    var projectCount = Object.keys(configData).length;

    for(i=0;i<projectCount;i++) {
        console.log(configData[i].title);
        console.log(configData[i].type);
        console.log(configData[i].status);
        console.log(configData[i].description);
        console.log(configData[i].languages);
        console.log(configData[i].image);
        console.log(configData[i].url);
        console.log(' ');
    }
}






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


