#language:pt
  Funcionalidade: Account CRUD
    @cadastroCRUD
    Cenario: Cadastro nova conta
      Dado que a pagina newAccount esteja sendo exibida
      Quando os campos de cadastro estiverem preenchido
      |username|Ieda16|
      |email|ieda_menezes@hotmail.com|
      |password|Ieda123              |
      |confirmapassword|Ieda123      |
      |country         |Brazil       |
      Entao deve ser possivel logar no sistema apos o cadastro

    @loginCRUD
      Cenario: Realizar loginCRUD
        Dado que a modal esteja aberta
        Quando os campos de login sejam preenchidos da seguinte forma
          | username | Ieda16 |
          | password | Ieda123 |
          | remember | <false>    |
        Quando for realizado o clique no botao sign in
        Entao deve ser possivel logar no sistema

    @alteracaoCRUD
        Cenario: Realizar alteracao CRUD
      Dado que esteja logado no sistema
        | username | Ieda16 |
        | password | Ieda123 |
        | remember | <false>    |
Dado que esteja na pagina de alteracao de conta
      Quando altero os valores dos seguintes campos
      |firstname|Ieda|
      |lastname |Larissa|
      Quando realizao o clique em Salvar
      Entao a alteracao deve ser exibidsa na pagina MyAccount

      @exclusaoCRUD
      Cenario: Realizar exclusao CRUD
      Dado que esteja logado no sistema
        | username | Ieda16 |
        | password | Ieda123 |
        | remember | <false>    |
        Dado que estena na pagina MyAccount
        Quando for efetuado clique em Delete e Yes
        Entao o usuario deve ser excluido