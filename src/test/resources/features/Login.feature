#language:pt

Funcionalidade: Login

  Contexto:
    Dado que a modal esteja aberta

  @fechaModal
  Cenario: Fechar a modal ao clicar fora da mesma
    Quando for realizado o clique fora da modal
    Então a janela modal deve ser fechada

  @fechaModalIcone
  Cenario: Fechar a modal realizando o clique no icone fechar
    Quando for realizado o clique no icone do fechar modal
    Então a janela modal deve ser fechada


  @createNewAccount
  Cenario: Link Create NewAccount
    Quando for realizado o clique no link Create NewAccount
    Então a pagina Create NewAccount deve ser exibida

  @loginComSucesso
  Esquema do Cenario: Realizar login com <identificacao>
    Quando os campos de login sejam preenchidos da seguinte forma
      | username | <username> |
      | password | <password> |
      | remember | <false>    |
    Quando for realizado o clique no botao sign in
    Entao deve ser possivel logar no sistema
    Exemplos:
      | identificacao       | username | password | remember |
      | campos obrigatorios | ieda15   | Ieda123  | false    |
      | com todos os campos | ieda15   | Ieda123  | false    |

  @loginComErro
  Esquema do Cenario: Realizar login com <identificacao>

    Quando os campos de login sejam preenchidos da seguinte forma
      | username | <username> |
      | password | <password> |
      | remember | <false>    |
    Quando for realizado o clique no botao sign in
    Entao o sistema devera exibir uma mensagem de erro
    Exemplos:
      | identificacao    | username | password | false |
      | usuario invalido | invalido | Ieda123  | false |
      | senha invalida   | ieda15   | invalida | false |

  @dadosEmBranco
  Esquema do Cenario: Realizar login com <identificacao>

    Quando os campos de login sejam preenchidos da seguinte forma
      | username | <username> |
      | password | <password> |
      | remember | <false>    |
    Entao o botao sign in deve permanecer desabilitado
    Exemplos:
      | identificacao     | username | password | remember |
      | usuario em branco |          | Ieda123  | false    |
      | senha em branco   | ieda15   |          | false    |