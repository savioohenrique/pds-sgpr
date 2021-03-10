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
## Viagem

Request:

`GET http://localhost:8080/viagem`

Response:

```
[
  {
    "id": 1,
    "origem": "Assu",
    "destino": "Natal",
    "data": "2021-02-15",
    "preco": 150.0,
    "motorista": "Fulano Da Silva",
    "onibus": "HZV8911",
    "rota": "a-n",
    "status": "confirmada",
    "empresa": "Sertão",
    "horaSaida": "13:00"
  },
  ...
]
```

Request:

`POST http://localhost:8080/viagem`

Body:
```
{
    "data": "2021-02-15",
    "preco": 150.0,
    "rota": "a-n",
    "motorista": "29306192100",
    "onibus": "HZV8911",
    "status": "confirmada",
    "empresa": "1",
    "horaSaida": "13:00"
}
```

Request:

`DELETE http://localhost:8080/viagem/viagemId`

| viagemId = id da viagem a ser deletada|

Response:

`Mensagem de sucesso ou erro`
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

`Mensagem de sucesso ou erro`

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

`Mensagem de sucesso ou erro`

Request:

`DELETE http://localhost:8080/rota/rotaId/cidades`

| rotaId = id da rota ao qual as cidades fazem parte |

Response:

`Mensagem de sucesso ou erro`

## Cidades

Resquest:

`GET http://localhost:8080/cidades`

Response:
```
[
  {
    "id": 1,
    "nome": "Natal"
  },
  {
    "id": 2,
    "nome": "Assu"
  },
  ...
]
```
Request:

`POST http://localhost:8080/cidades`

Body:
```
{
    "nome": "cidade nome teste"
}
```

Response:

`Mensagem de sucesso ou erro`

Request:

`DELETE http://localhost:8080/cidades/cidadeId`

| cidadeId = id da cidade a ser deletada|

Response:

`Mensagem de sucesso ou erro`