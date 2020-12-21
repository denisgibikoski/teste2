# teste2


Para rodar o projeto devera ter um banco Postgres com uma database com o nome de teste2, o serviço esta configurado para rodar na porta 4562. Segue abaixo exemplo para realizar as requisições.

1.	Para realizar a requisição para cadastrar Cidade devera emitir um evento do método Post nesta URI http://localhost:4562/cidade contendo no body um Objeto JSON contendo a sugestão de envio:
{
"nome": "Ipuaçu",
"uf": "Santa Catarina"
}

2.	Para realizar a requisição para cadastrar Cliente deverá emitir um evento do método Post nesta URI http://localhost:4562/cliente contendo no body um Objeto JSON contendo a sugestão de envio:
{
    "nome" : "Denis",
    "sobrenome" : "Gibikoski",
    "sexo": "M",
    "nascimento" : "1989-11-24",
    "idade": "31" ,
    "cidade": {
        "id": "1"
    }
}

3.	Para realizar consulta cidade pelo nome deverá emitir um evento do método Get nesta URI http://localhost:4562/cidade/nome/ contendo no body um Objeto JSON contendo a sugestão de envio:
{
    "nome":"Pato Branco"
}

4.	Para realizar a consulta cidade pelo estado deverá emitir um evento do método Get nesta URI http://localhost:4562/cidade/estado/ contendo no body um Objeto JSON a sugestão de envio:
{
    "uf":"Santa Catarina"
}

5.	Para realizar a consulta cliente pelo nome deverá emitir um evento do método Get nesta URI http://localhost:4562/cliente/{nome} deverá ser passado o nome por parâmetro da uri como o exemplo e sem conteúdo no body.

6.	Para realizar a consultar cliente pelo Id deverá emitir um evento do método Get nesta URI http://localhost:4562/cliente/{id} deverá ser passado o id por parâmetro da uri como o exemplo e sem conteúdo no body.

7.	Para realizar remoção cliente deverá emitir um evento do método Delete nesta URI http://localhost:4562/cliente/{id} deverá ser passado o id por parâmetro da uri como o exemplo e sem conteúdo no body.

8.	Para realizar alteração do nome do cliente deverá emitir um evento do método Put nesta URI http://localhost:4562/cliente/{id} deverá ser passado o id por parâmetro da uri como o exemplo e contendo no body um Objeto JSON contendo a sugestão de envio:

{
    "nome" : "Sophia"
}
