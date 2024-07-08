#language: pt
Funcionalidade: Testar API dos Gatos

  @catApi
  Cenário: Enviar POST contendo dados para criacao de novo registro na Cat API
    Quando envio request Post catApi
    Entao verifico se gato foi criado

  @catApi
  Cenário: Enviar POST sem corpo de requisição
    Quando envio post catApi sem corpo
    Entao verifico se a API retorna erro de requisição invalida

  @catApi
  Cenário: Enviar POST com corpo da requisição vazio
    Quando envio post catApi com corpo vazio
    Entao verifico se a API retorna erro de requisição invalida

  @catApi
  Cenário: Enviar GET verificando os retornos da Cat API
    Quando envio request Get catApi
    Entao verifico se retornou a lista de gatos

  @catApi
  Cenário: Enviar GET pesquisando por Id especifico e verificando retorno na Cat API
    Quando envio request Get-Id catApi
    Entao verifico se retornou a lista com o id do registro especifico de gatos

