//0 = add form
//1 = update form
var selectForm = 0;

function createFormUpdateDelete(row, cityName){
    selectForm = 1;
    clearForm();
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
            case 41:
                createHeadForm('Atualizar Passagem');
                break;
            case 5:
                createHeadForm('Atualizar Motorista');
                break;
            case 6:
                createHeadForm('Atualizar Cidade');
                break;
        }
        
        if(page == 4){
            let atrVig = Object.keys(globalResouces.main[0]);
            createINnputForms(atrVig.slice(3, atrVig.length));
            putValueIntoInput(3, Object.keys(globalResouces.main[0]).length, row);
        }else if(page == 41){
            let atrPass = Object.keys(globalResouces.dependence[0]);
            createINnputForms(atrPass.slice(0, atrPass.length - 1));
            putValueIntoInput(0, Object.keys(globalResouces.dependence[0]).length - 1, row);
        }else{
            createINnputForms(Object.keys(globalResouces.main[0]));
            putValueIntoInput(0, Object.keys(globalResouces.main[0]).length, row);
        }
        createBtnsUpdateForm();
    }else{
        // createUpdateCitytoRoute(arguments[0]);
        createUpdateCitytoRoute(cityName);
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
    let btn = createButton('Adicionar', classBtnAdd);
    btn.addEventListener('click', addResource);

    document.getElementById('mainForm').appendChild(btn);
    createCancelButton();
}

function createBtnsUpdateForm(){
    let classBtnUp = 'formsButton confirBtn ' + 'heightBtnInputUp' + page;
    let classBtnDel = 'formsButton deleteBtn ' + 'heightBtnInputUp' + page;

    document.getElementById('mainForm').appendChild(createButton('Atualizar', classBtnUp));
    document.getElementById('mainForm').appendChild(createButton('Deletar', classBtnDel));
    createCancelButton();
}

function createButton(name, classForTheButton){
    let btn = document.createElement('BUTTON');

    btn.innerText = name;

    btn.type = 'button';

    btn.className = classForTheButton;

    return btn;
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
    createINnputForms(["(id_cidade,num_seq), (id_cidade,num_seq), ..., (id_cidade,num_seq)", "(nome_cidade, num_seq), (nome_cidade, num_seq), ..., (nome_cidade, num_seq)"]);
    createBtnsAddForm();
}

function createUpdateCitytoRoute(cityName){
    let classBtnDel = 'formsButton deleteBtn ' + 'heightBtnInputUp' + page;

    createHeadForm('Atualizar Rota');
    createINnputForms([cityName]);
    document.getElementById('mainForm').appendChild(createButton('Deletar', classBtnDel));
    createCancelButton();
}

function calHeightOfForm(numOfEleInForm){
    return (70 * numOfEleInForm) / 9;
}

function putValueIntoInput(starIndex, endIndex, row){
    let rowTds = row.children;
    let form = document.getElementById('mainForm').children;
    let inputs = [];

    for(let e of form){
        if(e.nodeName == "INPUT"){
            inputs.push(e);
        }
    }

    let i = 0;
    while(starIndex < endIndex){
        inputs[i].value = rowTds[starIndex].innerText;
        i++;
        starIndex++;
    }
}
