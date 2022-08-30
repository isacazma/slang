export default class GamesService {
    async getGameIds() {
        return fetch('/restservices/snake/games')
            .then((response) => response.json())
            .then((data) => data);
    }

    async getReplay(gameId) {
        return fetch('/restservices/snake/games/'+gameId+'')
            .then((response) => response.json())
            .then((data) =>  Promise.resolve({
                id: data.id,
                gameID: data.gameID,
                aantalBeurten: data.aantalBeurten,
                lengteSlang: data.lengteSlang
            }));
    }

    async removeReplay(gameId) {
        fetch('/restservices/snake/deleteGame/ ', {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
            body: gameId
        })
    }
}
