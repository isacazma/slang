export default class LoginService {
    isLoggedIn() {
        let token = window.localStorage.getItem("abc");
        if (token) {
            return true;
        } else {
            return false;
        }
    }
    //TODO: hoe ga je bepalen of iemand ingelogd is (geweest)?

    login(username, password) {
        console.log("login")

        var formData = new FormData();
        formData.append("username", username);
        formData.append("password", password);
        var encData = new URLSearchParams(formData.entries());


        fetch("/restservices/authentication", {
            method: "POST",
            headers: {
                'Content-Type':'application/x-www-form-urlencoded;charset=UTF-8'
            },
            body: encData
        })
            .then((response) => response.json())
            .then(data => window.localStorage.setItem("abc", data['JWT']));
    }

    getUser() {
        //TODO: deze GET method test je token op server-side problemen. Je kunt client-side op zich wel 'ingelogd' zijn
        //maar het zou altijd zomaar kunnen dat je token verlopen is, of dat er server-side iets anders aan de hand is.
        //Dus het is handig om te checken met een -echte fetch- of je login-token wel echt bruikbaar is.
        return fetch("/restservices/snake/", {
            method: "GET",
            headers: { "Authorization": "Bearer " + window.localStorage.getItem("abc") },
            credentials: "include"
        })
            .then(data => console.log(data));
    }

    logout() {
        //TODO: Logout
    }
}
