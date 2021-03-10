page = 0;

function testeMenu() {
    let menuDropDown = document.getElementById("dropMenu");
    
    if(menuDropDown.style.display == "none") {
        menuDropDown.style.display = "flex";
    }else {
        menuDropDown.style.display = "none";
    }
}

function loadPassPage() {
    page = 1;
    loadPage();
}

function loadSearchPage() {
    page = 3;
    loadPage();
}

function loadPage() {
    // console.log(document.getElementsByTagName("main"));
    switch(page){
        case 1:
            console.log("case 1")
            document.getElementById("passPage").style.display = "flex";
            document.getElementById("bkForms").style.display = "none";
            document.getElementById("bkTrips").style.display = "none";
            break;
        case 3:
            console.log("case 2")
            document.getElementById("passPage").style.display = "none";
            document.getElementById("bkForms").style.display = "flex";
            document.getElementById("bkTrips").style.display = "flex";
            break;
    }
}

function loadLoginPage(){
    window.location.href = 'http://localhost:8080/login/';
}

async function startBusca(){
    let org = document.getElementById('origem').value;
    let des = document.getElementById('destino').value;

    if(org == ''){
        alert('Escolha uma origem(local de partida)!');
    }else{
        document.getElementById('bkTrips').innerHTML = "";
        viagens = await getViagens(`http://localhost:8080/viagem/busca?origem=${org}&destino=${des}`);
        // viagens = getFakeResponse();
        console.log(viagens);
        if(viagens.length == 0){
            loadWaringNotFoundViagens();
        }else{
            buildResponseOfSearch();
        }
    }
}

function makeUrlWithOrgDes(origem, destino){
    return `http://localhost:8080/viagens/busca?origem=${origem}&destino=${destino}`;
}

function makeUrlWithOrg(origem){
    return `http://localhost:8080/viagens/busca?origem=${origem}`;
}

function loadWaringNotFoundViagens(){
    let div = document.createElement("DIV");
    div.className = "divWarginViagem";
    let span = document.createElement("SPAN");
    span.innerText = "Nenhuma viagem encontrada :(";
    div.appendChild(span);
    document.getElementById('bkTrips').appendChild(div);
}