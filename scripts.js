//import projects from json file
// import projectsData from './projects.json' with { type: "json" };

let projectsData = []; 

async function loadData() {
    try {
        const response = await fetch('./projects.json');
        // 2. Assign the fetched data to your original variable name
        projectsData = await response.json();
        
        // 3. IMPORTANT: Call the functions that need this data inside here
        initPortfolio(); 
    } catch (error) {
        console.error("Failed to load projects:", error);
    }
}

function initPortfolio() {
    console.log(projectsData); // Now this works just like the import did
    // Your logic to build the grid or list goes here
}

loadData();




var clickEmailModal     = document.getElementById('click-email-modal');
var emailModal          = document.getElementById('email-modal');
var sendEmailButton     = document.getElementById('send-email');
var emailName           = document.getElementsByName('name');
var emailEmail          = document.getElementsByName('email');
var emailMessage        = document.getElementsByName('message');
var closeEmailModal     = document.getElementById('close-email-modal');
var clickAbout          = document.getElementById('click-about');
var pacman              = document.getElementById('pacman');
var subHeadingInput     = document.getElementById('sub-heading-input');
var subHeadValue        = subHeadingInput.value;
var goodToGo            = document.getElementById('good-to-go');
var goodToGoInput       = document.getElementsByName('good-to-go');

goodToGo.addEventListener('click', function() {
    if (goodToGo.checked == false) {
        goodToGoInput[0].value = true;
        sendEmailButton.disabled = false;
    } else {
        goodToGoInput[0].value = false;
        sendEmailButton.disabled = true;
    }
});

// Calculate year for specific element inner text
window.addEventListener('load', function() {
    const d = new Date();
    let year = d.getFullYear();
    var calcYears = document.getElementsByName('calcyear');
    calcYears.forEach(element => {
        element.innerText = (year - (element.getAttribute('value')));
    });
});

// Clears the answers to the form once the submit button is clicked
clickEmailModal.addEventListener('click', function() {
    showEmailModal();
    emailName[0].value = '';
    emailEmail[0].value = '';
    emailMessage[0].value = '';
    goodToGo.checked = true;
});

// Toggles off email modal when submit button is clicked
sendEmailButton.addEventListener('click', function(e) {
        showEmailModal();
});

// Close email modal
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

listProjects();
function listProjects() {
    var projectCount = Object.keys(projectsData).length;
    var projTitle = "";
    var projCat = "";
    var projStatus = "";
    var projDescription = "";
    var projLanguages = "";
    var projImage = "";
    var projUrl = "";
    var projActive = "";
    var htmlOutput = "";

    for(var i = 0; i < projectCount; i++) {
        projTitle = (projectsData[i].title);
        projCat = (projectsData[i].cat);
        projStatus = (projectsData[i].status);
        projDescription = (projectsData[i].description);
        projLanguages = (projectsData[i].languages);
        projImage = (projectsData[i].image);
        projUrl = (projectsData[i].url);
        projActive = (projectsData[i].active);

        if (projActive) {
            htmlOutput = htmlOutput + `
            <a href='` + projUrl + `' target='_blank' class='project' rel='nofollow'>
                <div class='project-thumbnail' style='background-image: url("` + projImage + `");'>
                    <div class='project-description body-copy'>
                        <b>` + projCat + `<br>` + projStatus + `</b><br>` + projDescription + `<br><b>` + projLanguages + `</b>
                    </div>
                </div>
                <div class='project-title'>` + projTitle + `</div>
            </a>`;
        }
    }
    document.querySelector('.project-container').innerHTML = htmlOutput;
}
