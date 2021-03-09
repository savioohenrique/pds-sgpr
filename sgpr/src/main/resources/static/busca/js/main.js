function loadLoginPage(){
    window.location.href = 'http://localhost:8080/login/';
}

async function startBusca(){
    let org = document.getElementById('origem').value;
    let des = document.getElementById('destino').value;
    console.log("testeeeeeeeeeeeeeeeeeeeeee");
    if(org == ''){
        alert('Escolha uma origem(local de partida)!');
    }else{
        document.getElementById('bkTrips').innerHTML = "";

        // if(des == ''){
        //     viagens = await getViagens(makeUrlWithOrg(org));
        // }else{
        //     viagens = await getViagens(makeUrlWithOrgDes(org, des));
        // }
        viagens = await getViagens(`http://localhost:8080/viagens/busca?origem=${org}&destino=${des}`);

        activeAnimation2();
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