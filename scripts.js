var subHeadingInput = document.getElementById('sub-heading-input');
var subHeadValue = subHeadingInput.value;
var pacman = document.getElementById('pacman');

subHeadingInput.addEventListener('click', function() {
    this.select();
});

subHeadingInput.addEventListener('focusout', function() {
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
});








function resetHeading() {
    subHeadingInput.value = subHeadValue;
}