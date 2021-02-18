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
