//0 = add form
//1 = update form
var selectForm = 0;

function createFormUpdateDelete(){
    selectForm = 1;
    clearForm();
    console.log('forms ' + "formUp" + page);
    document.getElementById('mainForm').className = 'forms ' + "formUp" + page;

    if(page !== 31){
        switch(page){
            case 1:
                createHeadForm('Atualizar Usuario');
                break;
            case 2:
                createHeadForm('Atualizar Onibus');
                break;
            case 3:
                createHeadForm('Atualizar Rota');
                break;
            case 4:
                createHeadForm('Atualizar Viagem');
                break;
            case 5:
                createHeadForm('Atualizar Motorista');
                break;
            case 6:
                createHeadForm('Atualizar Cidade');
                break;
        }
        
        if(page == 4){
            let atr = Object.keys(globalResouces.main[0]);
            createINnputForms(atr.slice(2, atr.length));    
        }else{
            createINnputForms(Object.keys(globalResouces.main[0]));
        }
        createBtnsUpdateForm();
    }else{
        createUpdateCitytoRoute(arguments[0]);
    }
}

function createAddForm(listOfAtributes, tableName){
    document.getElementById('mainForm').className = 'forms ' + "formAdd" + page;
    createHeadForm('Adicionar Novo ' + tableName);
    createINnputForms(listOfAtributes);
    createBtnsAddForm();
}

function createHeadForm(nameForm){
    let h2 = document.createElement('H2');
    h2.innerText = nameForm;
    document.getElementById('mainForm').appendChild(h2);
}

function createINnputForms(namesForInput){
    let btnInputPrefix = selectForm ? "heightBtnInputUp" : "heightBtnInputAdd";
    let form = document.getElementById('mainForm');

    for(let prop of namesForInput){
        let input = document.createElement('INPUT');
        input.type = 'text';
        input.placeholder = prop;
        input.className = 'formsInput ' + btnInputPrefix + page;
        form.appendChild(input);
    }
}

function createBtnsAddForm(){
    let classBtnAdd = 'formsButton confirBtn ' + 'heightBtnInputAdd' + page;

    createButton('Adicionar', classBtnAdd);
    createCancelButton();
}

function createBtnsUpdateForm(){
    let classBtnUp = 'formsButton confirBtn ' + 'heightBtnInputUp' + page;
    let classBtnDel = 'formsButton deleteBtn ' + 'heightBtnInputUp' + page;

    createButton('Atualizar', classBtnUp);
    createButton('Deletar', classBtnDel);
    createCancelButton();
}

function createButton(name, classForTheButton){
    let btnUpdate = document.createElement('BUTTON');

    btnUpdate.innerText = name;

    btnUpdate.type = 'button';

    btnUpdate.className = classForTheButton;

    document.getElementById('mainForm').appendChild(btnUpdate);
}

function createCancelButton(){
    let btnInputPrefix = selectForm ? "heightBtnInputUp" : "heightBtnInputAdd";
    let btnCancel = document.createElement('BUTTON');

    btnCancel.innerText = 'Cancelar';

    btnCancel.type = 'button';

    btnCancel.className = 'formsButton ' + btnInputPrefix + page;

    btnCancel.addEventListener('click', hideForm);

    document.getElementById('mainForm').appendChild(btnCancel);
}

function clearForm(){
    document.getElementById('mainForm').innerHTML = '';
}

function createAddCitytoRoute(){
    document.getElementById('mainForm').className = 'forms ' + "formAdd" + page;
    createHeadForm("Adicionar Cidade a Rota");
    createINnputForms(["id_cidade, id_cidade, ..., id_cidade", "nome_cidade, nome_cidade, ..., nome_cidade"]);
    createBtnsAddForm();
}

function createUpdateCitytoRoute(cityName){
    let classBtnDel = 'formsButton deleteBtn ' + 'heightBtnInputUp' + page;

    createHeadForm('Atualizar Rota');
    createINnputForms([cityName]);
    createButton('Deletar', classBtnDel);
    createCancelButton();
}

function calHeightOfForm(numOfEleInForm){
    return (70 * numOfEleInForm) / 9;
}
