async function getResources(urlToRecources){
    try {
        let response = await fetch(urlToRecources);
        let listOfResources = await response.json();
        return listOfResources;
    } catch (error) {
        console.log(error);
    }
}

async function postResource(urlToPost, resourceToPost){
    try {
        let response = await fetch(urlToPost, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            },
            body: JSON.stringify(resourceToPost)
        });
        // let msg = await response.json();
        console.log(response);
    } catch (error) {
        console.log(error)
    }
}

async function deleteResource(urlToDelete){
    try {
        let response = await fetch(urlToDelete, {
            method: "DELETE"
        });
        let resJson = await response.json();
        console.log(resJson);
    } catch (error) {
        console.log(error)
    }
}