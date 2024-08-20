// Initial Variables
let petName = "";
let hungerLevel = 50;
let happinessLevel = 50;
let gameActive = false;

// DOM Elements
const adoptBtn = document.getElementById('adopt-btn');
const feedBtn = document.getElementById('feed-btn');
const playBtn = document.getElementById('play-btn');
const statusBtn = document.getElementById('status-btn');
const endBtn = document.getElementById('end-btn');
const statusMessage = document.getElementById('status-message');
const gameStatus = document.getElementById('game-status');

// Adopt a Pet
adoptBtn.addEventListener('click', function() {
    petName = prompt("Enter your pet's name:");
    if (petName) {
        hungerLevel = 50;
        happinessLevel = 50;
        gameActive = true;

        statusMessage.innerHTML = `<p>You have adopted ${petName}! Take care of your pet.</p>`;
        updateButtons(true);
    }
});

// Feed the Pet
feedBtn.addEventListener('click', function() {
    if (gameActive && hungerLevel < 90&& happinessLevel > 0) {
       
        statusMessage.innerHTML = `<p>You fed ${petName}. Hunger level increased!</p>`;
    } else if (hungerLevel >= 90 && happinessLevel > 0) {
        statusMessage.innerHTML = `<p>${petName} is full and cannot eat more.</p>`;
    }
    else if (happinessLevel <=0){
        statusMessage.innerHTML = `<p>Your pet is in critical condition. The game is over."</p>`;
        updateButtons(false);
        gameActive = false;
    }
    hungerLevel += 10;
    happinessLevel -= 10;
    gameStatus.innerHTML = `<p></p>`;
});

// Play with the Pet
playBtn.addEventListener('click', function() {
    if (gameActive && happinessLevel < 90&& hungerLevel > 0 ) {
        
        statusMessage.innerHTML = `<p>You played with ${petName}. Happiness level increased!</p>`;
    } else if (happinessLevel >= 90  && hungerLevel > 0 ) {
        statusMessage.innerHTML = `<p>${petName} is too happy to play more.</p>`;
    }
    else if (hungerLevel <=0){
        statusMessage.innerHTML = `<p>Your pet is in critical condition. The game is over."</p>`;
        updateButtons(false);
        gameActive = false;
    }
    happinessLevel += 10;
	hungerLevel -= 20;
    gameStatus.innerHTML = `<p></p>`;
});

// Check Pet Status
statusBtn.addEventListener('click', function() {
    if (gameActive) {
        gameStatus.innerHTML = `<p>${petName}'s Status: Hunger - ${hungerLevel}, Happiness - ${happinessLevel}</p>`;
    }
});

// End Game
endBtn.addEventListener('click', function() {
    if (gameActive) {
        gameStatus.innerHTML = `<p></p>`;
        statusMessage.innerHTML = `<p>Game Over! Final status of ${petName}: Hunger - ${hungerLevel}, Happiness - ${happinessLevel}</p>`;
        gameStatus.innerHTML = `<p></p>`;
        updateButtons(false);
        gameActive = false;
        
    }
});

// Update Buttons Based on Game State
function updateButtons(active) {
    feedBtn.disabled = !active;
    playBtn.disabled = !active;
    statusBtn.disabled = !active;
    endBtn.disabled = !active;
    adoptBtn.disabled = active;
}
