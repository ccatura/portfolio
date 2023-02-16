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

    for(var i=0;i<projectCount;i++) {
        var projTitle = (configData[i].title);
        console.log(configData[i].type);
        console.log(configData[i].status);
        console.log(configData[i].description);
        console.log(configData[i].languages);
        console.log(configData[i].image);
        console.log(configData[i].url);
        console.log(' ');

        document.querySelector('.project-container').innerHTML = `
        <a href='` + projTitle + `' target='_blank' class='project' rel='nofollow'>
            <div class='project-thumbnail' style='background-image: url(images/thumbs/music-scroller.jpg);'>
                <div class='project-description body-copy'>
                    <b>PERSONAL PROJECT<br>IN PROGRESS</b><br>This is a partially working web-based teleprompter application geared toward song writers who perform on-stage. It is not completed as of yet, but will have the ability to create, edit, share, and display songs like a traditional teleprompter.<br><b>HTML, CSS, JS, PHP</b>
                </div>
            </div>
            <div class='project-title'>Music Scroller</div>
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


