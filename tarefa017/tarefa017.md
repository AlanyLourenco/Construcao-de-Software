# Tarefa 017 - Configuração de software em tempo de execução, Generics, Closure e Logging - 30/06/2023

1. Considere os seguintes links, sobre os temas **Configuração de software em tempo de execução, _Generics_, _Closure_ e _Logging_**

  1.1 Configuração de software em tempo de execução:

      1.1.1 - [Link1](https://www.baeldung.com/spring-profiles);

      1.1.2 - [Link2](https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring).


O desenvolvimento de aplicativos modernos deve considerar a configuração de software de tempo de execução como um componente crítico. Os aplicativos podem se ajustar e se comportar de maneira diferente dependendo das circunstâncias do ambiente em que estão sendo executados graças a esse recurso. Perfis Spring e as ideias de Inversão de Controle (IoC) e Injeção de Dependência (DI) são duas ideias-chave neste contexto.

O artigo "Spring Profiles" no site "Baeldung" explica como os perfis spring oferecem uma maneira flexível de configurar e adaptar um aplicativo com base no ambiente em que está sendo executado. Por exemplo, os arquivos de configuração para os ambientes de desenvolvimento, teste e produção poderia ser diferente. Podemos ativar o perfil adequado para cada ambiente e carregar as configurações necessárias usando perfis Spring. Como resultado, o programa pode operar de forma eficaz em uma variedade de configurações, fornecendo segurança e desempenho ideais.

Por exemplo, suponha que temos uma aplicação que precisa se conectar a diferentes bancos de dados dependendo do ambiente. Podemos definir perfis como "dev", "test" e "prod", e ter arquivos de configuração separados para cada um deles. Ao ativar o perfil correto, a aplicação usará as configurações apropriadas para estabelecer a conexão com o banco de dados correspondente.

Já os princípios de Inversão de Controle e Injeção de Dependência, abordados no artigo "Inversion of Control and Dependency Injection in Spring" do site "Baeldung", são fundamentais para alcançar uma configuração flexível e modular do software. A IoC é um padrão de projeto que transfere o controle da criação e gerenciamento de objetos para um container ou framework. No contexto do Spring, isso significa que o framework é responsável por criar e gerenciar os objetos (beans) da aplicação, permitindo a configuração desses objetos por meio de metadados, como anotações.

A implementação de IoC é feita usando injeção de dependência. Eles são injetados em um objeto em vez de um objeto desenvolvendo suas próprias dependências. Isso incentiva maior modularidade, reutilização de código e simplicidade de alternância de implementação. Por meio de anotações como @Autowired, que permite que as dependências sejam injetadas automaticamente nos componentes, a injeção de dependência é comumente utilizada no Spring.


  1.2 _Closure_:

    1.2.1 - [Link3](https://www.geeksforgeeks.org/closures-in-java-with-examples/).

    1.2.2 - [Link4](https://receitasdecodigo.com.br/java/exemplo-de-foreach-do-java-8).

    1.2.3 - [Link5](https://www.devmedia.com.br/como-usar-funcoes-lambda-em-java/32826).

Fechamentos de programação são uma ideia crucial, e Java é uma das muitas linguagens que os suportam. Eles são o resultado da interação entre um papel e o contexto em que é definido. Podemos ler o material nos sites "GeeksforGeeks" e "Code Recipes", bem como o artigo "DevMedia" sobre o uso de funções lambda em Java, para compreender melhor a ideia de encerramentos.

Em Java, closures podem ser implementados usando interfaces funcionais e funções lambda. Uma closure captura o estado do ambiente em que é definida, permitindo que ela acesse e manipule as variáveis ​​e parâmetros dessa função. Essa característica torna as closures poderosas, pois elas podem transportar consigo o contexto em que foram criadas.

Podemos descobrir informações detalhadas sobre encerramentos em Java, juntamente com exemplos úteis, no site "GeeksforGeeks". Uma ilustração típica de um encerramento é a iteração por meio de uma lista de expressões lambda usando a função forEach que foi introduzida no Java 8. Esse exemplo específico também é abordado no site "Code Recipes", mostrando como os encerramentos simplificam o processamento de cada lista entrada. lista clara e legível.

Por exemplo, suponha que temos uma lista de nomes de pessoas e queremos imprimir cada nome em letras maiúsculas. Podemos usar uma closure para definir a função de transformação e passá-la como argumento para o método forEach da lista. O código a seguir ilustra esse exemplo:

List<String> nomes = Arrays.asList("João", "Maria", "Pedro");
nomes.forEach(nome -> System.out.println(nome.toUpperCase()));

  1.3 _Generics_:

    1.3.1 - [Link6](https://www.devmedia.com.br/usando-generics-em-java/28981).

    1.3.2 - [Link7](https://www.devmedia.com.br/java-generics-trabalhando-com-metodos/30911).

    1.3.3 - [Link8](https://howtodoinjava.com/java/generics/complete-java-generics-tutorial/).

Os Generics, ou genéricos, são um recurso poderoso introduzido no Java 5 para fornecer maior flexibilidade e segurança de tipo em tempo de compilação. Ao ler o conteúdo dos sites "DevMedia" e "HowToDoInJava" sobre Generics em Java, podemos entender melhor como eles funcionam e como são aplicados.

Os Generics permitem que classes, interfaces e métodos sejam parametrizados por tipos. Isso significa que podemos criar estruturas de dados e algoritmos que são independentes do tipo de dados com os quais serão usados, tornando-os mais reutilizáveis e flexíveis.

No site "DevMedia", encontramos dois artigos relevantes sobre Generics. O primeiro aborda o uso de Generics em Java, explicando como eles podem ser aplicados para criar classes e interfaces genéricas, permitindo que tipos específicos sejam fornecidos quando elas forem utilizadas. Isso oferece maior segurança de tipo durante a compilação e evita erros relacionados à incompatibilidade de tipos. O segundo artigo aborda o uso de Generics em métodos, mostrando como podemos parametrizar métodos específicos em vez de classes inteiras, permitindo maior granularidade na aplicação do recurso.

Além disso, o site "HowToDoInJava" oferece um tutorial completo sobre Generics em Java, abrangendo desde os conceitos básicos até técnicas avançadas. O tutorial explora a sintaxe e a semântica dos Generics, incluindo a definição de classes genéricas, herança com tipos genéricos, wildcards, restrições de tipo e inferência de tipo automática.

Para ilustrar a utilização dos Generics em Java, considere o exemplo de uma classe genérica chamada Lista, que pode armazenar uma lista de elementos de qualquer tipo. A implementação dessa classe pode ser feita da seguinte forma:

public class Lista<T> {
    private List<T> elementos;

    public Lista() {
        elementos = new ArrayList<>();
    }

    public void adicionar(T elemento) {
        elementos.add(elemento);
    }

    public T obter(int indice) {
        return elementos.get(indice);
    }
}

A utilização da classe Lista seria da seguinte forma:
Lista<String> listaStrings = new Lista<>();
listaStrings.adicionar("Elemento 1");
String elemento = listaStrings.obter(0);

Lista<Integer> listaInteiros = new Lista<>();
listaInteiros.adicionar(10);
int valor = listaInteiros.obter(0);
    

  1.4 _Logging_:

    1.4.1 - [Link9](https://www.loggly.com/ultimate-guide/java-logging-basics/).

    1.4.2 - [Link10](https://www.journaldev.com/977/logger-in-java-logging-example).

    1.4.3 - [Link11](https://www.edureka.co/blog/logger-in-java).

O logging, ou registro de eventos, é uma prática fundamental no desenvolvimento de software que envolve a gravação de informações relevantes durante a execução de um programa. Ao ler o conteúdo dos sites "Loggly", "JournalDev" e "Edureka" sobre logging em Java, podemos compreender melhor como ele funciona e como pode ser aplicado.

O logging é importante para monitorar o comportamento de um programa, identificar problemas, depurar erros e analisar o fluxo de execução. Ele permite que informações como mensagens de status, exceções, métricas, entre outros, sejam registradas de forma estruturada.

O site "Loggly" fornece um guia completo sobre os conceitos básicos do logging em Java. Ele explora diferentes bibliotecas de logging disponíveis e como configurar e personalizar os registros. O guia aborda os níveis de logging (como DEBUG, INFO, WARN, ERROR), a formatação das mensagens de log e a integração com ferramentas de análise e monitoramento.

No site "JournalDev", encontramos um exemplo prático de uso da biblioteca de logging padrão do Java, chamada java.util.logging. O artigo demonstra como configurar o logging, criar registros, definir níveis de log, adicionar handlers para direcionar os logs para diferentes destinos (como console ou arquivo) e filtrar os registros com base nos níveis.

O site "Edureka" também explora o uso do logging em Java, apresentando conceitos-chave e fornecendo exemplos de código. Ele aborda a importância de usar logging em diferentes cenários, como o registro de eventos de exceção e a depuração de código.

Vejamos um exemplo de utilização do logging em Java utilizando a biblioteca java.util.logging:

import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClass {
    private static final Logger logger = Logger.getLogger(MyClass.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "Iniciando o programa");

        try {
            // Código do programa
            int resultado = 10 / 0;
        } catch (ArithmeticException e) {
            logger.log(Level.SEVERE, "Ocorreu um erro: " + e.getMessage(), e);
        }

        logger.log(Level.INFO, "Encerrando o programa");
    }
}

Em resumo, o logging desempenha um papel crucial no desenvolvimento de software, permitindo a captura e o registro de informações relevantes durante a execução do programa. Ele ajuda na depuração, monitoramento e análise do comportamento do software. Através do uso de bibliotecas de logging, como a java.util.logging, é possível configurar e personalizar os registros de acordo com as necessidades do projeto.


2. Solicita o estudo destes temas e elaborar um texto descrito, manifestando seu entendimento a respeito de cada um deles e ainda apresentando exemplos de utilização dos mesmos.

**INSTRUÇÕES**
1. Esta é uma tarefa individual. A entrega deve ser entregue no seu repositório pessoal utilizado para a manutenção do controle de versão dos artefatos da disciplina, dentro de uma pasta chamada tarefa017.
2. O prazo para entrega desta tarefa é as 23h59min do dia 02/07/2023.
