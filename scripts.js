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
    var projTitle;
    var projCat;
    var projStatus;
    var projDescription;
    var projLanguages;
    var projImage;
    var projUrl;

    for(var i = 0; i < projectCount - 1; i++) {
        projTitle = (configData[i].title);
        projCat = (configData[i].cat);
        projStatus = (configData[i].status);
        projDescription = (configData[i].description);
        projLanguages = (configData[i].languages);
        projImage = (configData[i].image);
        projUrl = (configData[i].url);

        console.log=(projTitle);
        console.log=(projCat);
        console.log=(projStatus);
        console.log=(projDescription);
        console.log=(projLanguages);
        console.log=(projImage);
        console.log=(projUrl);
        console.log(' ');


        document.querySelector('.project-container').innerHTML = `
        <a href='` + projUrl + `' target='_blank' class='project' rel='nofollow'>
            <div class='project-thumbnail' style='background-image: url("` + projImage + `");'>
                <div class='project-description body-copy'>
                    <b>` + projCat `<br>` + projStatus + `</b><br>` + projDescription + `.<br><b>` + projLanguages + `</b>
                </div>
            </div>
            <div class='project-title'>` + projTitle + `</div>
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


