var page = 0;
var globalResouces = {
    main: [],
    dependence: null
};

function loadLoginPage(){
    window.location.href = 'http://127.0.0.1:5500/login/login.html';
}

async function createTableUsers(){   
    page = 1;
    globalResouces.main = await getResources("http://localhost:8080/passageiro");
    let headers = Object.keys(globalResouces.main[0]);

    //load table usuarios
    clearTable();
    createTableHead(headers);
    createRows(headers, globalResouces.main);
    //load form update/delete de usuarios
    createFormUpdateDelete();
    //load serach input and add button
    showSearchAndAdd();
    hideWarnig();
}
async function createTableBus(){
    page = 2;
    // globalResouces.main = await getResources("http://localhost:8080/viagens");
    let headers = Object.keys(globalResouces.main[0]);

    //load table onibus
    clearTable();
    createTableHead(headers);
    createRows(headers, globalResouces.main);
    //load form update/delete de onibus
    createFormUpdateDelete();
    //load serach input and add button
    showSearchAndAdd();
    hideWarnig();
}

async function createTableViagem(){
    page = 4;
    globalResouces.main = await getResources("http://localhost:8080/viagens");
    let headers = Object.keys(globalResouces.main[0]);

    //load table onibus
    clearTable();
    createTableHead(headers);
    createRows(headers, globalResouces.main);
    //load form update/delete de onibus
    createFormUpdateDelete();
    //load serach input and add button
    showSearchAndAdd();
    hideWarnig();
}

function createTableMotorista(){
    page = 5;
    globalResouces.main = [{
        cpf: '36182361627',
        nome: 'Jose Da Silva',
        endereco: 'Rua depis da outra',
        telefone: '112123131',
        email: 'jsasdasdasdasd@gm.com'
    }, {
        cpf: '8237429473',
        nome: 'Doido do Pastel',
        endereco: 'Na esquina da rua',
        telefone: '487892374243',
        email: 'dsasdasdasda@ht.com'
    }]
    let headers = Object.keys(globalResouces.main[0]);

    //load table usuarios
    clearTable();
    createTableHead(headers);
    createRows(headers, globalResouces.main);
    //load form update/delete de usuarios
    createFormUpdateDelete();
    //load serach input and add button
    showSearchAndAdd();
    hideWarnig();
}

function createTableRota(){
    page = 3;
    globalResouces.main = [{
        id_rota: 'emp-123',
        nome_rota: 'Natal-Macaiba',
    }, {
        id_rota: 'emp-432',
        nome_rota: 'Natal-SaoGonsalo'
    }, {
        id_rota: 'emp-545',
        nome_rota: 'Mossoro-Caico'
    }, {
        id_rota: 'emp-987',
        nome_rota: 'Macal-Apodi'
    }, {
        id_rota: 'emp-026',
        nome_rota: 'Inteiro-Sitio'
    }]
    let headers = Object.keys(globalResouces.main[0]);

    //load table usuarios
    clearTable();
    createTableHead(headers);
    createRows(headers, globalResouces.main);
    //load form update/delete de usuarios
    createFormUpdateDelete();
    //load serach input and add button
    showSearchAndAdd();
    hideWarnig();
}

function createTableCid(){
    page = 6;
    globalResouces.main = [{
        id_cidade: '1',
        nome: 'Natal',
    }, {
        id_cidade: '2',
        nome: 'Assu',
    }, {
        id_cidade: '3',
        nome: 'Mossoro',
    }, {
        id_cidade: '4',
        nome: 'Macau',
    }]
    let headers = Object.keys(globalResouces.main[0]);

    //load table usuarios
    clearTable();
    createTableHead(headers);
    createRows(headers, globalResouces.main);
    //load form update/delete de usuarios
    createFormUpdateDelete();
    //load serach input and add button
    showSearchAndAdd();
    hideWarnig();
}

//forms manipulaing

function showForm(){
    document.getElementById('divForms').style.display = 'flex';
}

function hideForm(event){
    event.target.parentNode.parentNode.style.display = 'none';
}

function showAddForm(){
    selectForm = 0;
    clearForm();
    switch(page){
        case 1:
            createAddForm(Object.keys(globalResouces.main[0]), 'Usuario');
            break;
        case 2:
            createAddForm(Object.keys(globalResouces.main[0]), 'Onibus');
            break;
        case 3:
            createAddForm(Object.keys(globalResouces.main[0]), 'Rota');
            break;
        case 31:
            createAddCitytoRoute();
            break;
        case 4:
            let atr = Object.keys(globalResouces.main[0]);
            createAddForm(atr.slice(2, atr.length), 'Viagem');
            break;
        case 5:
            createAddForm(Object.keys(globalResouces.main[0]), 'Motorista');
            break;
        case 6:
            createAddForm(Object.keys(globalResouces.main[0]), 'Cidade');
            break;
    }
    showForm();
}

function loadUpdateDeleteForm(event){
    createFormUpdateDelete(event.target.innerText);
    showForm();
}

function showSearchAndAdd(){
    document.getElementById('searchDiv').style.visibility = 'visible';
}

function hideSearchAndAdd(){
    document.getElementById('searchDiv').style.visibility = 'hidden';
    clearTable();
    showWarnig();
}

// waring manipulaing
function showWarnig(){
    document.getElementById('warnig1').style.display = 'flex';
}

function hideWarnig(){
    document.getElementById('warnig1').style.display = 'none';
}