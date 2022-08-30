export default class SnakeService {
    async getSnake() {
        // //TODO: haal deze data van de server
        //
        // return fetch( "/restservices/snake")
        //     .then(response => response.json())
        console.log("secure");

        let response = await fetch("/restservices/snake")
            .then((response) => response.json());

        return Promise.resolve({
            apiversion: response['apiversion'],
            author: response['author'],
            color: response['color'],
            head: response['head'],
            tail: response['tail'],
        });
    }

    async updateSnake(updatedSnake) {
        let fields = {
            'color': updatedSnake.color,
            'head': updatedSnake.head,
            'tail': updatedSnake.tail
        }

        var formBody = [];
        for (var property in fields) {
            var encodedKey = encodeURIComponent(property);
            var encodedValue = encodeURIComponent(fields[property]);
            formBody.push(encodedKey + "=" + encodedValue);
        }
        formBody = formBody.join("&");

        fetch('/restservices', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8',
                // 'Authorization': 'Bearer ' + window.localStorage.getItem("abc")
            },
            body: formBody
        })
    }
}
