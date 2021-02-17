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
    createMainTable(headers, globalResouces.main);
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
    //load serach input and add button
    showSearchAndAdd();
    hideWarnig();
}

async function createTableViagem(){
    page = 4;
    globalResouces.main = await getResources("http://localhost:8080/viagens");
    // globalResouces.main = getFakeViagens();
    let headers = Object.keys(globalResouces.main[0]);

    //load table viagem
    clearTable();
    createMainTable(headers, globalResouces.main);
    //load serach input and add button
    showSearchAndAdd();
    hideWarnig();
}

function createTableMotorista(){
    page = 5;
    globalResouces.main = getFakeMotoristas();
    let headers = Object.keys(globalResouces.main[0]);

    //load table motorista
    clearTable();
    createTableHead(headers);
    createRows(headers, globalResouces.main);
    //load serach input and add button
    showSearchAndAdd();
    hideWarnig();
}

async function createTableRota(){
    page = 3;
    globalResouces.main = await getResources("http://localhost:8080/rotas");
    // globalResouces.main = getFakeRota();
    let headers = Object.keys(globalResouces.main[0]);

    //load table rota
    clearTable();
    createMainTable(headers, globalResouces.main);
    //load serach input and add button
    showSearchAndAdd();
    hideWarnig();
}

function createTableCid(){
    page = 6;
    globalResouces.main = getFakeCidades();
    let headers = Object.keys(globalResouces.main[0]);

    //load table usuarios
    clearTable();
    createTableHead(headers);
    createRows(headers, globalResouces.main);
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

function loadUpdateDeleteForm(event){
    createFormUpdateDelete(event.target.parentNode, event.target.innerText);
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

async function addResource(event){
    console.log(buildJSO(event.target.parentNode.id));
    switch(page){
        case 3:
            await postResource('http://localhost:8080/rotas', buildJSO(event.target.parentNode.id));
            break;
        case 4:
            await postResource('http://localhost:8080/viagem', buildJSO(event.target.parentNode.id));
            break;
    }
}

function buildJSO(formId){
    let form = document.getElementById(formId);
    let obj = {};

    for(let e of form.children){
        if(e.nodeName == 'INPUT'){
            if(e.value == ''){
                obj[e.placeholder] = null;
            }else{
                obj[e.placeholder] = e.value;
            }
        }
    }

    return obj;
}