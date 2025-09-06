# language: pt

Funcionalidade: Crud simples para persistência de usuário
  Cenário: registrar um novo usuário corretamente
    Quando inserir um usuário com nome "Enzo" e email "enzo@juniorfox.net" no endpoint "/users"
    Então o código de retorno para usuário será 201
    E ao consultar o usuário no endpoint "/users"
    Então o código de retorno para usuário será 200

  Cenário: registrar um novo usuário sem nome
    Quando inserir um usuário com nome "" e email "vazio@juniorfox.net" no endpoint "/users"
    Então o código de retorno para usuário será 400

  Cenário: registrar um novo usuário no endpoint errado
    Quando inserir um usuário com nome "Enzo" e email "enzo@juniorfox.net" no endpoint "/errado"
    Então o código de retorno para usuário será 404