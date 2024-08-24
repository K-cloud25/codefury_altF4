

function bookRoom(roomName) {
    alert(`You have edited the room`);
}

document.addEventListener("DOMContentLoaded", function () {
    // Select all room cards
    const roomCards = document.querySelectorAll('.room-card');

    roomCards.forEach(card => {
        const decreaseBtn = card.querySelector('.decrease-btn');
        const increaseBtn = card.querySelector('.increase-btn');
        const currentCapacityElem = card.querySelector('.current-capacity');
        const editBtn = card.querySelector('.edit-btn');
        const capacityValueElem = card.querySelector('.capacity-value');

        decreaseBtn.addEventListener('click', () => {
            let currentCapacity = parseInt(currentCapacityElem.textContent);
            if (currentCapacity > 1) { // Ensure capacity doesn't go below 1
                currentCapacityElem.textContent = currentCapacity - 1;
            }
        });

        increaseBtn.addEventListener('click', () => {
            let currentCapacity = parseInt(currentCapacityElem.textContent);
            currentCapacityElem.textContent = currentCapacity + 1;
        });

        editBtn.addEventListener('click', () => {
            const newCapacity = currentCapacityElem.textContent;
            capacityValueElem.textContent = newCapacity;
            alert(`You have edited the room`);
        });
    });
});
