# language: pt

Funcionalidade: Consulta da API Boring
  Cenário: Chamar a API da aplicação
    Quando consultar o endpoint "/home"
    Então o código de retorno será 200

  Cenário: Chamada a API inexistente
    Quando consultar o endpoint "/inexistente"
    Então o código de retorno será 404