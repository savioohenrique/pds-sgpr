# Api Docs

## Passageiro

Resquest:

`GET http://localhost:8080/passageiro`

Response:
```
[    
	{ 
	  "cpf": "123456789012,  
	  "nome":"Fulano",  
	  "telefone":"(82) 3836-2691",  
	  "email":"fulano@zf.com"  
	},
	...
]
``` 

## Passagens

Request:

`GET http://localhost:8080/passagens?viagemId=id` 

| id = id da viagem |

Response:  

```
[
	{
	  "codValidacao":"2",
	  "dataValidade":"2020-12-31",
	  "numAssento":5,
	  "cpf":"40811470784",
	  "nome":"Fulano"
	},
	...
]
```

## Rotas

Request:

`GET http://localhost:8080/rotas`

Response:
```
[
	{
	  "idRota":"a-n",
	  "nome":"Assu-Natal"
	},
	...
]
```

Request:

`POST http://localhost:8080/rotas`

Body do request:

```
{
  "idRota": "a-n", 
  "nome": "AssuNatal"
}
```

Response:

`"messagem de sucesso ou erro."`

### Cidades da Rota
Resquest:

`GET http://localhost:8080/rotacidades?idRota=id`

| id = id da rota |

Response:
```
[
	{
	  "id_rota":"a-n",
	  "numSeq":7,
	  "nomeCidade":
	  "Natal"
	},
	...
]
```

