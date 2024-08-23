document.addEventListener("DOMContentLoaded", function() {
    populateRoomDropdown();

    document.getElementById("meetingDate").addEventListener("change", updateAvailableRooms);
    document.getElementById("startTime").addEventListener("change", updateAvailableRooms);
    document.getElementById("duration").addEventListener("input", updateAvailableRooms);

    document.getElementById("addMemberBtn").addEventListener("click", addMember);
    document.getElementById("saveMeetingBtn").addEventListener("click", validateAndSaveMeeting);
    document.getElementById("cancelMeetingBtn").addEventListener("click", cancelMeeting);
});

const roomsData = [
    { id: 1, name: "Room A" },
    { id: 2, name: "Room B" },
    { id: 3, name: "Room C" },
    { id: 4, name: "Room D" },
];

let bookings = []; // To store the meeting bookings
let membersList = []; // To store added members

function populateRoomDropdown() {
    const meetingRoomDropdown = document.getElementById("meetingRoom");
    meetingRoomDropdown.innerHTML = ""; // Clear existing options

    roomsData.forEach(room => {
        const option = document.createElement("option");
        option.value = room.id;
        option.text = room.name;
        meetingRoomDropdown.appendChild(option);
    });
}

function updateAvailableRooms() {
    const date = document.getElementById("meetingDate").value;
    const startTime = document.getElementById("startTime").value;
    const duration = parseFloat(document.getElementById("duration").value);

    if (date && startTime && !isNaN(duration)) {
        const selectedDateTime = new Date(`${date}T${startTime}`);

        const availableRooms = roomsData.filter(room => {
            return !bookings.some(booking => {
                const bookingStart = new Date(`${booking.date}T${booking.startTime}`);
                const bookingEnd = new Date(bookingStart);
                bookingEnd.setHours(bookingEnd.getHours() + booking.duration);

                const selectedEndTime = new Date(selectedDateTime);
                selectedEndTime.setHours(selectedEndTime.getHours() + duration);

                return (
                    booking.roomId === room.id &&
                    selectedDateTime < bookingEnd &&
                    selectedEndTime > bookingStart
                );
            });
        });

        const meetingRoomDropdown = document.getElementById("meetingRoom");
        meetingRoomDropdown.innerHTML = ""; // Clear existing options

        availableRooms.forEach(room => {
            const option = document.createElement("option");
            option.value = room.id;
            option.text = room.name;
            meetingRoomDropdown.appendChild(option);
        });

        if (availableRooms.length === 0) {
            const option = document.createElement("option");
            option.text = "No rooms available";
            option.disabled = true;
            meetingRoomDropdown.appendChild(option);
        }
    }
}

function addMember() {
    const name = document.getElementById("memberName").value;
    const email = document.getElementById("memberEmail").value;

    if (name && email) {
        membersList.push({ name, email });
        console.log(`Added member: ${name}, ${email}`);
        document.getElementById("memberName").value = '';
        document.getElementById("memberEmail").value = '';
    } else {
        alert("Please enter both name and email.");
    }
}

function validateAndSaveMeeting() {
    const title = document.getElementById('title').value.trim();
    const date = document.getElementById('meetingDate').value;
    const startTime = document.getElementById('startTime').value;
    const duration = parseFloat(document.getElementById('duration').value);
    const meetingRoom = document.getElementById('meetingRoom').value;
    const managerCredits = document.getElementById('managerCredits').value.trim();

    if (!title || !date || !startTime || isNaN(duration) || !meetingRoom || !managerCredits) {
        alert("Please fill out all fields before saving the meeting.");
        return;
    }

    if (membersList.length === 0) {
        alert("Please add at least one member to the meeting.");
        return;
    }

    // Add booking to bookings array
    bookings.push({
        roomId: parseInt(meetingRoom),
        date: date,
        startTime: startTime,
        duration: duration
    });

    alert(`Meeting saved successfully!`);

    // Reset form and member list
    document.getElementById('meetingForm').reset();
    membersList = [];
    updateAvailableRooms();
}

function cancelMeeting() {
    window.location.href = "../pages/home.html";
}
