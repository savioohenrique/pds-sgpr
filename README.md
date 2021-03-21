# SGPR
Projeto da Disciplina PDS

# Criando o Banco
Com o Mysql instalado execute os scrpits que se encontram na pasta scripts_db na ordem indicada abaixo:  
1. create_sgprDB 
2. populateDB
3. Execute os dois primeiros comandos do script consultas  

# Rodando o projeto
Para rodar o projeto abra o terminal na pasta **demo** e digite um dos seguintes comandas:

No Linux:  
`./mvnw spring-boot:run`

No Windows:
1. Descomente a linha 3 do arquivo **application.properties** localizado na pasta **demo/src/main/resources** e comente a linha 2.
2. Execute `mvnw spring-boot:run`  

# Acessando no Navegador
1. Tela de login: http://localhost:8080/login/
2. Tela de busca: http://localhost:8080/busca/
3. Tela de admin: http://localhost:8080/admin/
4. Tela do passageiro: http://localhost:8080/userHomepage/
5. Tela de validar passagens: http://localhost:8080/validate/
