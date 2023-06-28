# Tarefa 016 - Expressões Regulares - 28/06/2023

1. Elaborar expressões regulares para validação dos objetos constantes da tabela a seguir:

|objeto|formato|Observação|
|--|--|--|
|Data|dd/mm/aa|as "//" (barras) devem fazer parte da regex|
|Data|dd/mm/aaa|as "//" (barras) devem fazer parte da regex|
Data|dd/mm/aaa hh:mm:ss|as "//" (barras), os ":" dois pontos e o espaço devem fazer parte da regex|
|Data|yy/mm/dd|as "//" (barras) devem fazer parte da regex|
|Data|yyyy/mm/dd|as "//" (barras) devem fazer parte da regex|
|Número decimal|dd.ddd.ddd|Os "." (pontos ) devem fazer parte da regex. Tanto a parte inteira, como a fracionária podem conter de 1 a 5 casas|
|Nomes de Arquivos / documentos|nome.(doc,docx,xls,xlsx,pdf,csv,txt)|pode utilizar outras extensões para teste.|
|E-mail|nome@dominio|dominio pode ser ".com", ".com.br", ".goias.gov.br", "(.mil, .gov, .esp, .edu).(br,ar,uk,fr,ru,es,it)"|
|Codigo Cor HTML ||#00ccff|
|Arquivo de Imagem||*.(jpg,gif,png), etc.|
|Endereco IP ||192.168.1.1|
|Arquivos Multimedia ||*.(swf,mov,wma,mpg,mp3,wav)|
|Telefone (BR) ||(11) 5555-1977 |
|Celular (BR)|(55) (62) 9834.1243|os parênteses e pontos fazem parte da regex.|
|Hora|(HH:MM)|Os ":" dois pontos, fazem parte da regex.|
|Hora|(HH:MM:SS)|Os ":" dois pontos, fazem parte da regex.|
|URL||http://www.google.com, https://www.google.com.br |
|Domínio||www.yahoo.com, www.yahoo.com.br|
|Telefone Internacional |1.245.532.3422|os "." pontos fazem parte da regex.|


1-Formato "dd/mm/aa":
Expressão regular: ^\d{2}/\d{2}/\d{2}$

2-Formato "dd/mm/aaa":
Expressão regular: ^\d{2}/\d{2}/\d{4}$

3-Formato "dd/mm/aaa hh:mm:ss":
Expressão regular: ^\d{2}/\d{2}/\d{4} \d{2}:\d{2}:\d{2}$

4-Formato "yy/mm/dd":
Expressão regular: ^\d{2}/\d{2}/\d{2}$

5-Formato "yyyy/mm/dd":
Expressão regular: ^\d{4}/\d{2}/\d{2}$

6-Número decimal no formato "dd.ddd.ddd":
Expressão regular: ^\d{2}\.\d{1,5}\.\d{1,5}$

7-Nomes de Arquivos / documentos com extensões específicas:
Expressão regular: ^nome\.(doc|docx|xls|xlsx|pdf|csv|txt)$
(Você pode adicionar ou remover extensões conforme necessário)

8-E-mail com domínios específicos:
Expressão regular: ^nome@(dominio\.com|dominio\.com\.br|dominio\.goias\.gov\.br|(\.mil|\.gov|\.esp|\.edu)\.(br|ar|uk|fr,ru,es,it))$
(Você pode adicionar ou remover domínios conforme necessário)

9-Código de Cor HTML no formato "#00ccff":
Expressão regular: ^#([A-Fa-f0-9]{6})$

10-Arquivo de Imagem com extensões específicas:
Expressão regular: ^\*.(jpg|gif|png)$
(Você pode adicionar ou remover extensões conforme necessário)

11-Endereço IP no formato "192.168.1.1":
Expressão regular: ^(\d{1,3}\.){3}\d{1,3}$

12-Arquivos Multimídia com extensões específicas:
Expressão regular: ^\*.(swf|mov|wma|mpg|mp3|wav)$
(Você pode adicionar ou remover extensões conforme necessário)

13-Telefone (BR) no formato "(11) 5555-1977":
Expressão regular: ^\(\d{2}\) \d{4}-\d{4}$

14-Celular (BR) no formato "(55) (62) 9834.1243":
Expressão regular: ^\(\d{2}\) \(\d{2}\) \d{4}\.\d{4}$

15-Hora no formato "HH:MM":
Expressão regular: ^\d{2}:\d{2}$

16-Hora no formato "HH:MM:SS":
Expressão regular: ^\d{2}:\d{2}:\d{2}$

17-URL no formato "http://www.google.com" ou "https://www.google.com.br":
Expressão regular: ^(http|https)://(www\.)?[a-zA-Z0-9\-\.]+\.[a-zA-Z]{2,63}$

18-Domínio no formato "www.yahoo.com" ou "www.yahoo.com.br":
Expressão regular: ^www\.[a-zA-Z0-9\-\.]+\.[a-zA-Z]{2,63}$

19-Telefone Internacional no formato "1.245.532.3422":
Expressão regular: ^\d{1,3}(\.\d{1,3}){3}$

**INSTRUÇÕES**
1. Esta é uma tarefa para ser elaborada individualmente, embora possa ser discutida com seu colega do lado.
2. Testar se suas regex estão funcionando. Sugestão de site para teste: [regex101](regex101.com)
3. Commitar este arquivo em uma pasta chamada **Tarefa016**, no seu repositório pessoal.
4. O prazo para entrega desta tarefa é as 20h20min do dia 28/06/2023.
