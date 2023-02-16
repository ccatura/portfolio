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

    for(var i = 0; i < projectCount - 1; i++) {
        document.querySelector('.project-container').innerHTML = `
        <a href='` + (configData[i].url) + `' target='_blank' class='project' rel='nofollow'>
            <div class='project-thumbnail' style='background-image: url(` + (configData[i].image) + `);'>
                <div class='project-description body-copy'>
                    <b>` + (configData[i].type) `<br>` + (configData[i].status) + `</b><br>` + (configData[i].description) + `.<br><b>` + (configData[i].languages) + `</b>
                </div>
            </div>
            <div class='project-title'>` + (configData[i].title) + `</div>
        </a>`;





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


