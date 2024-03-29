# :moneybag:BACK-END DO SISTEMA DE ANÁLISE DE CRÉDITOS DE UMA EMPRESA:moneybag:

## REQUISITOS ##

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

<h3>:wrench: TECNOLOGIAS</h3>


:small_blue_diamond:Java 8, IDE IntelliJ
 
:small_blue_diamond:Spring Web (Spring MVC): esse framework vai ajudar no desenvolvimento de aplicações web, ou seja, vai criar a aplicação web incluído no seu contexto o RESTful
 
:small_blue_diamond:Maven: responsável pelas dependências do projeto, é a ferramenta que ficará responsável por trazer pacotes externos para o escopo do projeto.
 
:small_blue_diamond:Spring devtools: irá realizar o LiveReload, disparando um refresh toda vez que alterarmos algum recurso no projeto, otimizando o tempo/desenvolvimento.
 
:small_blue_diamond:Spring Data JPA: irá facilitar a criação e operação dos repositórios, junto com o hibernate auxiliará a gerenciar as classes no banco de dados
 
:small_blue_diamond:Spring Security: adiciona uma camada de segurança para a proteção de dados sensíveis.
 
:small_blue_diamond:Spring Validation: irá validar os objetos com facilidade, com isso impedirá que informações inválidas desçam para camadas mais profundas.
 
:small_blue_diamond:Json Web Token: gera token, encontra o id de um usuário usando o token antes de gerado e filtra as rotas que devem ser ignoradas pelo spring security ou não
 
:small_blue_diamond:Docker: ter o sistema rodando em containers torna mais fácil tanto rodar o sistema localmente quando o deploy em produção.
 
:small_blue_diamond:Lombok: vai ajudar no desenvolvimento das aplicações, como na utilização de annotations para gerar getters, setters e construtores

:small_blue_diamond:Swagger: auxilia na documentação da API, para acessar a UI: http://localhost:8080/swagger-ui.html#/
 
:small_blue_diamond:PostgreSQL: servidor de banco de dados de código aberto para o armazenamento seguro de informações
 
:small_blue_diamond:Postman: ferramenta para testar cada funcionalidade enviando dados em formato json para a api.



<h3>:black_circle: ANNOTATIONS</h3>



:small_blue_diamond:**_entities - irá nos mostrar que as classes contidas no projeto serão mapeadas no banco de dados, através do @Entity do JPA._**

_@Entity:responsável pelo mapeamento da classe na tabela do banco de dados, tomando cada atributo em uma coluna._

_@Setter: responsável por criar o setter de cada campo em que estiver denotada._

_@Getter: responsável por criar o getter de cada campo em que estiver denotada ou de todos os atributos se estiverem no nível da classe._

_@AllArgsConstructor: responsável por gerar um construtor com 1 parâmetro para cada atributo de sua classe._

_@NoArgsConstructor: responsável por gerar um construtor sem parâmetros._

_@Id: define a chave primária da nossa entidade._

_@GeneratedValue: determina a maneira com que o valor de cada id será gerado, nosso caso representa um valor incremental._

_@NotBlank: vai tornar obrigatório o preenchimento dos campos valindando informações não nulas e não vazias._

_@Email: realiza a verificação se o email é válido._

_@Column: especifica o mapeamento entre um atributo de entidade básico e a coluna da tabela no banco de dados._

_@OneToOne: estabelece uma relação 1 para 1 com outra entidade._

_@JsonFormat: especifica o campo de data que será recebido no Json._


:small_blue_diamond:**_repositories - as classes que aqui pertencem possuem a função de comunicar com o banco de dados diretamente através do Hibernate._**


_@Repository: informa ao spring que a classe é um componente do projeto._



:small_blue_diamond:**_services - estão nesse pacote as classes que contém a lógica do problema, ou seja, a parte de processamento dos dados será realizada no pacote services._**

_@Service: informa ao spring que a classe é um componente de serviço._

_@Autowrided: responsável pela injeção de dependência._

_@Override: informa ao compilador que a intenção é sobreescrever._


:small_blue_diamond:**_controllers - contém as classes de contato externo do projeto, é nele que conseguimos as informações presentes no projeto ou inserir novas._**

_@RestController: marca a classe como um complemento de controller como a notação @Controller para o spring e por fim, atribui a responsabilidade das transformações envolvendo json e objeto assim como a @ResponseBody faria. Então, @RestController = @Controller + @ResponseBody_


_@RequestMapping: define a rota utilizada para acessar o controller marcado._


_@CrossOrigin: disponibiliza a aplicação para ser chamada de uma origem que não seja local._


_@Autowrided: responsável pela injeção de dependência._


_@PostMapping: predefinição para definir o método da requisição (POST)._


_@GetMapping: predefinição para definir o método da requisição (GET)._


_@DeleteMapping: faz o mapeamento das solicitações HTTP DELETE._


_@RequestBody: define o objeto que será passado como corpo da requisição._


_@PathVariable: define como um dos parâmetros de busca que será passado, essa maneira define a variável sendo passada diretamente na URL._

_@Api: declara qual a api será mostrada._

_@ApiOperation: descreve o que vai ser executado._


:small_blue_diamond:**_configs - são as configurações do spring._**

_@Component: marca a classe como um componente do spring._


_@Override:informa ao compilador que a intenção é sobreescrever._


_@Autowride: responsável pela injeção de dependências._


_@EnableMethodSecurity: mostra em que ponto a autenticação será feita._


_@EnableWebSecurity: marca pro spring habilitar uma configuração personalizada._


_@Configuration: marca a classe como uma classe de configuração do spring._


_@Bean: mostra que a classe pode ser usada como dependência de outras classes do projeto._


:small_blue_diamond:**_dtos - são os objetos de transferência de dados._**

_@AllArgsConstructor: responsável por gerar um construtor com 1 parâmetro para cada atributo de sua classe._
 
_@NoArgsConstructor: responsável por gerar um construtor sem parâmetros._
 
_@Builder: maneira funcional de montar um construtor de um objeto._

_@Data: responsável popr gerar um conjunto de anotações implícitas nela mesma._
 
_@NotBlank: torna obrigatório o preenchimento dos campos username e password validando informações não nulas e não vazias._



:small_blue_diamond:**_handlers - contém classes que resolvem situações internas do próprio sistema._**

_@ControllerAdvice: responsável por cuidar de requisições que são exceções._


_@ExceptionHandler: especifica a exceção que será tratada no método._


_@Component: marca a classe como um componente do spring._


_@Value: demonstra que o spring tem a responsabilidade de injetar o valor na variável, esse valor esta em arquivos de configuração do projeto._


<h3>:heavy_check_mark: TESTE</h3>


Será utilizado o Postman, ferramenta capaz de comunicar diretamente com os endpoints da API.

<h4>POST</h4>
Essa requisição está criando um dado novo.

STATUS 201 (status que retorna quando a requisição é bem sucedida)

- Cadastro de cliente
- Cadastro de empréstimo

STATUS 400 (status que retorna quando a requisição falha)

- Cadastro de cliente
- Cadastro de empréstimo


 
<h4>GET</h4>
Essa requisição esta fazendo a leitura de dados.

STATUS 200 (status que retorna quando a requisição é bem sucedida)

- Listar os empréstimos pela id do cliente.
- Listar os detalhes de cada empréstimo.

STATUS 500 (status que retorna quando a requisição falha).
