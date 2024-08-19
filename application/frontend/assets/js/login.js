document.getElementById('login-form').addEventListener('submit', async function (event) {
    event.preventDefault();


    const userType = document.querySelector('input[name="user-type"]:checked');
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    await getDataFromXML(email);

    // if (userType && email && password) {
    //     console.log(`Logged in as ${userType.value}`);
    //     console.log(`Email: ${email}`);
    //     console.log(`Password: ${password}`);
    //     alert(`Logged in as ${userType.value}`);
    // } else {
    //     alert('Please fill in all fields and select a user type');
    // }
});

async function getDataFromXML(email) {

    await
        fetch("../assets/xmldoc/userdb.xml")
            .then(res => res.text())
            .then((xmlData) => {
                const parser = new DOMParser();
                const xmlDoc = parser.parseFromString(xmlData, "text/xml");
                const users = xmlDoc.getElementsByTagName("user");

                for (let i = 0; i < users.length; i++) {
                    const userIdNode = users[i].getElementsByTagName("userId")[0];
                    const emailNode = users[i].getElementsByTagName("email")[0];
                    const userTypeNode = users[i].getElementsByTagName("userType")[0];

                    const storedUserID = userIdNode.textContent;
                    const storedEmail = emailNode.textContent;
                    const storedType = userTypeNode.textContent;

                    if (storedEmail == email) {
                        
                        // Also check PWD on server
                        redirect(storedType);
                        return ;
                    }

                }
            })

}

function redirect(userType) {
    switch (userType) {
        case "admin":
            window.location.href = "admin.html";
            break;
        case "manager":
            window.location.href = "manager.html";
            break;
        case "member":
            window.location.href = "member.html";
            break;
        default:
            alert("Invalid user type.");
    }
}
