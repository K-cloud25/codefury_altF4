document.addEventListener("DOMContentLoaded", function() {
    const teamCards = document.querySelectorAll('.team-card');

    // Optional: Add some simple animations or modals when clicking on a team card
    teamCards.forEach(card => {
        card.addEventListener('click', () => {
            alert(`You clicked on ${card.querySelector('h3').textContent}`);
        });
    });
});
