function createListOfPass() {
    document.getElementById("tableOfDivs").innerHTML = "";
    createHeaders();
    console.log(listOfPass);
    for(let pass of listOfPass) {
        createRow(pass);
    }
}

function createHeaders() {
    let header = document.createElement("DIV");
    header.className = "listOfPass-row";

    let spanCPF = document.createElement("SPAN");
    spanCPF.className = "listOfPass-span listOfPass-divBtn";
    spanCPF.innerText = "CPF";
    header.appendChild(spanCPF);

    let spanOrigem = document.createElement("SPAN");
    spanOrigem.className = "listOfPass-span listOfPass-divBtn";
    spanOrigem.innerText = "Origem";
    header.appendChild(spanOrigem);

    let spanDestino = document.createElement("SPAN");
    spanDestino.className = "listOfPass-span listOfPass-divBtn";
    spanDestino.innerText = "Destino";
    header.appendChild(spanDestino);

    let spanData = document.createElement("SPAN");
    spanData.className = "listOfPass-span listOfPass-divBtn";
    spanData.innerText = "Data";
    header.appendChild(spanData);

    document.getElementById("tableOfDivs").appendChild(header);
}

function createRow(pass) {
    let row = document.createElement("DIV");
    row.className = "listOfPass-row";

    let spanCPF = document.createElement("SPAN");
    spanCPF.className = "listOfPass-span listOfPass-divBtn";
    spanCPF.innerText = pass.cpf;
    row.appendChild(spanCPF);

    let spanOrigem = document.createElement("SPAN");
    spanOrigem.className = "listOfPass-span listOfPass-divBtn";
    spanOrigem.innerText = pass.origem;
    row.appendChild(spanOrigem);

    let spanDestino = document.createElement("SPAN");
    spanDestino.className = "listOfPass-span listOfPass-divBtn";
    spanDestino.innerText = pass.destino;
    row.appendChild(spanDestino);

    let spanData = document.createElement("SPAN");
    spanData.className = "listOfPass-span listOfPass-divBtn";
    spanData.innerText = pass.data;
    row.appendChild(spanData);

    let divBtn = document.createElement("DIV");
    divBtn.className = "listOfPass-span listOfPass-divBtn";
    let cancelBtn = document.createElement("BUTTON");
    cancelBtn.innerText = "Cancelar";
    divBtn.appendChild(cancelBtn);
    row.appendChild(divBtn);

    document.getElementById("tableOfDivs").appendChild(row);
}