async function getResources(urlToRecources){
    try {
        let response = await fetch(urlToRecources);
        let listOfResources = await response.json();
        return listOfResources;
    } catch (error) {
        console.log(error);
    }
}