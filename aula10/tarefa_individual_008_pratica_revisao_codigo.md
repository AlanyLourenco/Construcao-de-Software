### Tarefa 008: Prática de Revisão de Código - 12/05/2023
1-

Cliente
Para utilizar a classe java.util.Date em seu código, você deve importá-la.
Para garantir que o parâmetro do construtor seja uma data válida, mais validação é necessária.
As propriedades de classe podem ser inicializadas no construtor sem usar a função "set". 
A atribuição direta a campos é uma maneira direta de fazer isso.
Para tornar o código mais legível e evitar problemas de fuso horário, a classe LocalDate do pacote java.time pode ser usada no lugar da classe Date.
A quantidade de código necessária para produzir getters e setters pode ser diminuída pela classe usando as anotações do Lombok.
____________________________________________________________________________

2-

Prêmio Seguro 
-Como a classe PremioSeguro é responsável por coletar o percentual de desconto e calcular o prêmio do seguro com o desconto, o código viola o princípio da responsabilidade única (SRP). É necessário dividir os métodos getPercentDiscount() e calculateValueWithDiscount() em duas classes distintas.
-O gênero e o estado civil do cliente são representados no código por strings literais. Isso não é desejável porque aumenta a probabilidade de erros e dificulta alterações futuras no código. Para esses valores, seria preferível definir constantes.
-O atributo valorSeguro não passa por validação, o que pode resultar em cálculos imprecisos caso seja nulo ou negativo.
-Numerosas instruções if aninhadas estão presentes no método getPercentDiscount(), o que pode dificultar a leitura e a compreensão do código. Uma estratégia aprimorada seria mapear os atributos do cliente para a porcentagem de desconto usando uma instrução switch ou um mapa.
-Como a implementação das regras de desconto é implementada no método getPercentualDiscount(), o código viola o Princípio Aberto/Fechado (OCP). Esta abordagem deve ser corrigida sempre que uma nova regra é adicionada ou uma regra antiga é modificada. -Usar o design de Estratégia, onde cada regra de desconto é implementada em uma classe diferente que implementa uma interface comum, seria uma estratégia preferível.
-A classe Date, obsoleta desde o Java 8, é usada em todo o código. A classe LocalDate deve ser usada em seu lugar.
____________________________________________________________________________

3- 

Teste java
-O código viola o Princípio da Responsabilidade Única (SRP).. Os métodos obtemPercentualDesconto() e calculaValorComDesconto() deveriam ser separados em duas classes diferentes.
-O código usa literais de string para representar o sexo e estado civil do cliente. Isso não é ideal, pois torna o código mais propenso a erros e mais difícil de alterar no futuro. Seria melhor definir constantes ou enums para esses valores.
-Não há validação para o atributo valorSeguro, o que pode levar a cálculos incorretos se esse atributo for nulo ou negativo.
-O código viola o Princípio Aberto/Fechado (OCP), já que a implementação das regras de desconto está codificada no método obtemPercentualDesconto(). Se uma nova regra for adicionada ou uma regra existente for modificada, esse método precisará ser alterado. 
___________________________________________________________________________

4-

cpfvalidator
-A implementação não está fazendo uma verificação completa da validade do CPF, uma vez que ela não está verificando se o CPF é válido segundo a fórmula do algoritmo. A validação realizada é somente baseada nos dígitos verificadores.
-Há uma exceção sendo lançada caso o CPF seja inválido, mas essa exceção não está sendo tratada no código apresentado. A exceção deveria ser capturada e tratada adequadamente em um bloco try-catch.
____________________________________________________________________________

5- 

CpfValidatorRefactored
-A variável boolean "result" é desnecessária e adiciona complexidade desnecessária.
-O método "validaQuantidadeMaiorOnze" retorna true ou false em uma variável que não é usada em nenhum lugar do código.
-"existeNaoDigito" é um nome de método mal escolhido. O que o método faz é verificar se existem caracteres no CPF que não são dígitos. Poderia ser renomeado para algo como "verificaSeCpfContemCaracteresInvalidos".
-O método "preencheZero" é desnecessário. Os zeros poderiam ser adicionados diretamente na etapa de inicialização do vetor.
-"preencheVetor" é um nome de método ruim, já que não está claro qual vetor está sendo preenchido. Também usa um parâmetro desnecessário, pois a quantidade de zeros poderia ser calculada internamente com uma simples subtração. Além disso, "j" poderia ser renomeado para "posicaoAtual".
-"calculaPrimeiroDigito" usa uma variável "soma" que poderia ser renomeada para algo mais descritivo.
____________________________________________________________________________

6-

DataUtils
-As variáveis "result" e "temp" não têm nenhuma utilização no método "validaIdade".
-O método "validaIdade" contém uma lógica complexa para calcular a diferença entre duas datas, que não é utilizada na verificação da idade do usuário. Além disso, esse cálculo já é feito em outro método da mesma classe, "calculaDiferencaEntreDatas", que recebe dois objetos do tipo DateTime como parâmetro.
-O método "getIdade" não lança nenhuma exceção, mesmo quando a idade do usuário não está dentro da faixa permitida. Isso pode causar problemas em outras partes do código que chamam esse método e dependem da verificação da idade para realizar outras operações.
____________________________________________________________________________

7-

EstadoCivilValidator:
-Tratamento de exceções: A classe lança uma exceção "EstadoCivilInvalidoException" se o estado civil não for um dos estados civis válidos predefinidos. No entanto, não há tratamento adequado dessa exceção. O código simplesmente lança a exceção, mas não fornece informações adicionais, como uma mensagem de erro personalizada ou um log de exceção. Isso torna difícil para o usuário da classe identificar o erro específico que ocorreu.
-Nomes de variáveis: A lista de estados civis válidos é armazenada na variável "estadosCivisValidos", que pode ser considerada inadequada porque o nome sugere que essa lista contém estados civis inválidos. Além disso, a variável "result" é usada para armazenar o resultado da validação, o que é desnecessário, já que o código poderia simplesmente retornar o valor booleano diretamente.
-Lista de estados civis válidos: A lista de estados civis válidos é definida como uma lista de strings, o que significa que o código é sensível a maiúsculas e minúsculas e não permite variações ortográficas comuns, como "Solteiro" e "solteiro". Também não é claro se todos os estados civis válidos são realmente aceitáveis para fins de validação de seguros.
____________________________________________________________________________

8-

NacionalidadeValidator:
-A lista de nacionalidades válidas é muito restritiva, permitindo apenas "Brasileira" e "Estrangeira". Isso pode causar problemas para clientes com dupla nacionalidade ou nacionalidades diferentes das duas definidas. Seria interessante considerar outras possibilidades de nacionalidades válidas.
-A exceção lançada é genérica e não oferece informações detalhadas sobre o erro ocorrido. Seria interessante incluir informações mais específicas, como o valor da nacionalidade recebida ou uma mensagem mais descritiva sobre a natureza do erro.
-O método estático validaNacionalidade retorna um valor booleano indicando se a nacionalidade é válida ou não, mas não há nenhuma indicação do que deve ser feito com esse valor. Seria interessante incluir algum tipo de retorno que informe o usuário sobre o resultado da validação e o que ele deve fazer em seguida.
____________________________________________________________________________

9-

NacionalidadeValidator:
Não foram identificadas não conformidades na implementação da classe NacionalidadeValidator. A classe possui um método estático que recebe uma string com a nacionalidade do cliente e valida se o valor é válido, comparando-o com uma lista de nacionalidades válidas. Caso a nacionalidade não esteja na lista, é lançada uma exceção NacionalidadeInvalidaException.
__________________________________________________________________________

10- 

PassaporteValidator:
A implementação da classe PassaporteValidator apresenta uma não conformidade, pois não está sendo feita a validação do formato do passaporte, que deve seguir um padrão definido pelo órgão emissor do documento. Dessa forma, um passaporte inválido em termos de formatação poderia passar pela validação realizada pelo método validaPassaporte. Uma possível solução seria adicionar uma expressão regular para validar o formato do passaporte antes de retornar o resultado da validação. Além disso, o nome da exceção lançada em caso de passaporte inválido poderia ser alterado para PassaporteFormatoInvalidoException para indicar de forma mais precisa qual é o problema com o passaporte.
____________________________________________________________________________

11-

SexoValidator
A classe SexoValidator parece estar em conformidade com o que foi especificado. No entanto, há uma oportunidade de melhoria na implementação da lista de sexos válidos, que atualmente é definida como uma lista de strings. Seria mais apropriado definir um enum para os sexos, tornando mais fácil a manutenção do código e prevenindo erros de digitação na string do sexo. Além disso, pode ser necessário avaliar se os sexos válidos definidos na lista estão de acordo com as regras de negócio do projeto.





</DIV/>
