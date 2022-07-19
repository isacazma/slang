export default class SnakeService {
    async getSnake() {
        //TODO: haal deze data van de server

        return fetch( "/restservices/snake")
            .then(response => response.json())

    }

    async updateSnake(updatedSnake) {
        //TODO: update je slang aan de server-kant met de nieuwe gegevens
        return Promise.resolve();
    }
}
