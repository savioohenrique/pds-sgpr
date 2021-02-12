async function getPassageiros(){
    try {
        let response = await fetch("http://localhost:8080/passageiro");
        let listOfPassageiros = await response.json();
        return listOfPassageiros;
    } catch (error) {
        console.log(error);
    }
}