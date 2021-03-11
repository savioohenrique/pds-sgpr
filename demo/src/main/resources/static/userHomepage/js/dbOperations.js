async function getViagens(urlToGetUserPass){
    try {
        let response = await fetch(urlToGetUserPass);
        let listOfViagens = await response.json();
        console.log(listOfViagens);
        return listOfViagens;
    } catch (error) {
        console.log(error)
    }
}