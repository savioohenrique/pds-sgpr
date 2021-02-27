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

`GET http://localhost:8080/rota`

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

`POST http://localhost:8080/rota`

Body do request:

```
{
  "idRota": "a-n", 
  "nome": "AssuNatal"
  "nomeOrigem": "Assu", 
  "nomeDestino": "Natal"
}
```

Response:

`"messagem de sucesso ou erro."`

Request:

`DELETE http://localhost:8080/rota/rotaId`

| rotaId = id da rota a ser deletada |

Response:

`Mensagem de erro ou sucesso`

### Cidades da Rota

Resquest:

`GET http://localhost:8080/rota/rotaId/cidades`

| rotaId = id da rota |

Response:
```
[
	{
	  "id_rota":"a-n",
	  "numSeq":7,
	  "nomeCidade":"Natal"
	},
	...
]
```

Request:

`POST http://localhost:8080/rota/cidades`

Body:

```
[
    {"idRota": "t-5", "nomeCidade": "Natal", "numSeq": "0"},
    {"idRota": "t-5", "nomeCidade": "Assu", "numSeq": "1"},
    {"idRota": "t-5", "nomeCidade": "Mossoro", "numSeq": "2"}
]

```

Response:

`Mensagem de erro ou sucesso`

Request:

`DELETE http://localhost:8080/rota/rotaId/cidades`

| rotaId = id da rota ao qual as cidades fazem parte |

Response:

'Mensagem de erro ou sucesso'
