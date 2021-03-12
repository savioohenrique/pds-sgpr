async function getResource(urlToGetResource){
    try {
        let response = await fetch(urlToGetResource);
        let resources = await response.json();
        // console.log(resources);
        return resources;
    } catch (error) {
        console.log(error)
    }
}