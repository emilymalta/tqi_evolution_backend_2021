# BACK-END DO SISTEMA DE ANÁLISE DE CRÉDITOS DE UMA EMPRESA

**REQUISITOS**

*i. Cadastro de clientes*

    O cliente pode cadastrar: nome, e-mail, CPF, RG, endereço completo, renda e senha.
    
*ii. Login*

    A autenticação será realizada por e-mail e senha.
   
*iii. Solicitação de empréstimo*

    Para solicitar um empréstimo, precisamos do valor do empréstimo, data da primeira parcela e quantidade de parcelas.
   
    O máximo de parcelas será 60 e a data da primeira parcela deve ser no máximo 3 meses após o dia atual.
   
*iv. Acompanhamento das solicitações de empréstimo*

    O cliente pode visualizar a lista de empréstimos solicitados por ele mesmo e também os detalhes de um de seus empréstimos.
   
    Na listagem, devemos retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.
   
    No detalhe do empréstimo, devemos retornar: código do empréstimo, valor, quantidade de parcelas, data da primeira parcela, e-mail do cliente e renda do cliente.

:wrench: **TECNOLOGIAS**

:small_blue_diamond:Java 11, IDE IntelliJ
 
:small_blue_diamond:Spring Web (Spring MVC): esse framework vai ajudar no desenvolvimento de aplicações web, ou seja, vai criar a aplicação web incluído no seu contexto o RESTful
 
:small_blue_diamond:Maven: cuida das dependências do projeto, é a ferramenta que ficará responsável por trazer pacotes externos para o escopo do projeto.
 
:small_blue_diamond:Spring devtools: irá realizar o LiveReload, disparando um refresh toda vez que alterarmos algum recurso no projeto, otimizando o tempo/desenvolvimento.
 
:small_blue_diamond:Spring Data JPA: irá facilitar a criação e operação dos repositórios, junto com o hibernate auxiliará a gerenciar as classes no banco de dados
 
:small_blue_diamond:Spring Security: adiciona uma camada de segurança para a proteção de dados sensíveis.
 
:small_blue_diamond:Spring Validation: irá validar os objetos com facilidade, com isso impedirá que informações inválidas desçam para camadas mais profundas.
 
:small_blue_diamond:Json Web Token: gera token, encontra o id de um usuário usando o token antes de gerado e filtra as rotas que devem ser ignoradas pelo spring security ou não
 
:small_blue_diamond:Docker: ter o sistema rodando em containers torna mais fácil tanto rodar o sistema localmente quando o deploy em produção.
 
:small_blue_diamond:Lombok: vai ajudar no desenvolvimento das aplicações, como na utilização de annotations para gerar getters, setters e construtores
 
:small_blue_diamond:PostgreSQL: servidor de banco de dados de código aberto para o armazenamento seguro de informações
 
:small_blue_diamond:Postman: ferramenta para testar cada funcionalidade enviando dados em formato json para a api.
