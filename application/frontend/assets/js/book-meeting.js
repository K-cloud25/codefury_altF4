document.addEventListener('DOMContentLoaded', function () {
    const roomList = document.getElementById('room-list');

    // Example data
    const rooms = [
        { name: 'Room A', capacity: 10 },
        { name: 'Room B', capacity: 20 },
        { name: 'Room C', capacity: 15 },
        { name: 'Room D', capacity: 25 },
    ];

    rooms.forEach(room => {
        const roomElement = document.createElement('div');
        roomElement.className = 'room-card';
        roomElement.innerHTML = `
            <div class="room-name">${room.name}</div>
            <div class="room-capacity">Capacity: ${room.capacity}</div>
            <button class="book-btn" onclick="bookRoom('${room.name}')">Book</button>
        `;
        roomList.appendChild(roomElement);
    });
});

function bookRoom(roomName) {
    alert(`You have booked ${roomName}`);
}
