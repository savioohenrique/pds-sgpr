function createTableHead(headersNames){
    let tr = document.createElement('TR');
    let cellWidth = page == 3 ? getCellNewWidth(headersNames.length + 1) : getCellNewWidth(headersNames.length);

    for(let i = 0; i < headersNames.length;i++){
        let th = document.createElement('TH');
        th.innerText = headersNames[i];
        // th.width = cellWidth;
        tr.appendChild(th);
    }

    if(page == 3){
        let th = document.createElement('TH');
        th.innerText = 'Ver Rota';
        // th.width = cellWidth;
        tr.appendChild(th);
    }

    document.getElementById('tableMainContent').appendChild(tr);
}

function createRows(headersNames, resouces){
    let cellWidth = page == 3 ? getCellNewWidth(headersNames.length + 1) : getCellNewWidth(headersNames.length);

    for(let i = 0; i < resouces.length; i++){
        let tr = document.createElement('TR');

        for(let j = 0; j < headersNames.length; j++){
            let td = document.createElement('TD');
            td.innerText = resouces[i][headersNames[j]];
            // td.width = cellWidth;
            tr.appendChild(td);
        }

        if(page == 3){
            let td = document.createElement('TD');
            let i = document.createElement('I');
            i.className = 'fas fa-eye';
            i.addEventListener('click', showTableRoute);
            td.appendChild(i);
            // td.width = cellWidth;
            tr.appendChild(td);
        }

        tr.addEventListener('dblclick', loadUpdateDeleteForm);
        document.getElementById('tableMainContent').appendChild(tr);
    }
}

function getCellNewWidth(amountOfHeaders){
    let width = 100 / amountOfHeaders;
    let final_width = width + '%';
    return final_width;
}

function clearTable(){
    document.getElementById('tableMainContent').innerHTML = '';
    if(document.getElementById('main').children[2].id == 'tableRota'){
        document.getElementById('main').removeChild(document.getElementById('main').children[2]);
    }
}


// route manager

function showTableRoute(event){
    page = 31;
    globalResouces.dependence = ['cid1', 'cid2','cid3', 'cid4', 'cid5'];
    let rowToShow = event.target.parentNode.parentNode;
    let tableRotas = document.getElementById('tableMainContent').children;

    for(let i = 1; i < tableRotas.length; i++){
        if(tableRotas[i] !== rowToShow){
            tableRotas[i].style.display = 'none';
        }
    }

    event.target.className = 'fas fa-eye-slash'
    event.target.removeEventListener('click', showTableRoute);
    event.target.addEventListener('click', hideTableRoute);
    createRouteTable(globalResouces.dependence);
    createAddForm(["id_cidade"], 'cidades da rota');
}

function hideTableRoute(event){
    let rowToShow = event.target.parentNode.parentNode;
    let tableRotas = document.getElementById('tableMainContent').children;

    for(let i = 1; i < tableRotas.length; i++){
        tableRotas[i].style.display = 'table-row';
    }

    event.target.className = 'fas fa-eye'
    event.target.removeEventListener('click', hideTableRoute);
    event.target.addEventListener('click', showTableRoute);

    document.getElementById('main').removeChild(document.getElementById('main').children[2]);

    //Atualiza a pagina para a pagina principal de rotas
    globalResouces.dependence = null;
    page = 3;
    createAddForm(Object.keys(globalResouces.main[0]), 'rotas');
}

function createRouteTable(rotas){
    let table = document.createElement('TABLE');
    table.className = 'tableMainContent';
    table.id = 'tableRota';

    let row = document.createElement('TR');
    let th = document.createElement('TH');
    th.innerText = 'Rota';
    row.appendChild(th);

    table.appendChild(row);

    for(let i = 0; i < rotas.length; i++){
        let tr = document.createElement('TR');

        let td = document.createElement('TD');
        td.innerText = rotas[i];
        tr.appendChild(td);

        tr.addEventListener('dblclick', loadUpdateDeleteForm);
        table.appendChild(tr);
    }

    document.getElementById('main').insertBefore(table, document.getElementById('main').children[2]);
}