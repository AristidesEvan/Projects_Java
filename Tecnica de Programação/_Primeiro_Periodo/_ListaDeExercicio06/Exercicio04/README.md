## Exercício 04

Escreva as seguintes classes:

a)Uma classe Pessoa com os atributos nome (String) e sobrenome (String), cada um com get e set. Essa classe deve ter também o método getNomeCompleto, sem parâmetros, que retorna a concatenação do nome e sobrenome. Deve possuir dois construtores: um sem parâmetros e outro com os dois atributos, devendo alterá-los diretamente com os métodos set.

b)Uma  subclasse  de  Pessoa,  denominada  de  Funcionario,  com  os  atributos  matricula(int)  e salário(double),  com  seus  get  e  set. Sendo  que  osalário  jamais  deve  ser  negativo.  Todo funcionário  recebe  seu  salário  em  duas  parcelas,  sendo  60%  na  primeira  parcela  e  40%  na segunda parcela. Assim, escreva os métodos getSalarioPrimeiraParcelaque retorna os 60% do salário e getSalarioSegundaParcelaque retorna os 40% do salário.

c)Uma subclasse de Funcionario,  denominada de Professor, sendo  que todo professor recebe seu     salário     em     uma     única     parcela.     Assim,     deve-se     sobrescrever     os     métodos getSalarioPrimeiraParcela e getSalarioSegundaParcela, sendo que esses dois métodosdevem retornar o valor integral do salário. 

d)Uma classe, denominada UsaPessoaque instancia os seguintes objetos:
pessoa1 (Pessoa) nome:Mário sobrenome:Lopes
pessoa2(Funcionario) matricula:10 nome:Lucas sobrenome:Mendes salario:2000
pessoa3 (Professor) matricula:20 nome:Rafael sobrenome:Lira salario:5000

Em seguida, execute as operações na seguinte ordem:
 
d.1)Exibir a saída do método getNomeCompletopara os 3 objetos.

d.2)Exibir getSalarioPrimeiraParcelae getSalarioSegundaParcelapara  os  objetos pessoa2 e pessoa3.