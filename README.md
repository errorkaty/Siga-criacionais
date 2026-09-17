# SIGA — Atividade de Padrões Criacionais

## 1. Analisar o código inicial e identificar a possibilidade de misturar fornecedores e o método de consulta telescópico

### Mistura de fornecedores

Os objetos "Conexao" e "Comando" são criados separadamente, sem uma estrutura que garanta que ambos pertençam ao mesmo fornecedor. Por isso,
seria possível combinar acidentalmente uma "ConexaoMySQL" com um "ComandoPostgreSQL". Essa combinação seria incoerente e poderia causar falhas durante a execução.

### Método telescópico

O método "montarConsulta()' recebe muitos parâmetros que não são autoexplicativos, como "50", "0", "30" e "true". Por isso, é fácil confundir o significado e a ordem dos argumentos. Como vários parâmetros são opcionais, a chamada se torna ilegível e propensa a erros.

## 2. Abstract Factory: criar uma fábrica abstrata (por exemplo, FabricaBanco) com FabricaMySQL e FabricaPostgreSQL, cada uma produzindo uma Conexao e um Comando do mesmo fornecedor. O AcessoDados passa a receber uma fábrica e criar a família coerente a partir dela.

"FabricaBanco" define "CriarConexao()" e "CriarComando()" para que as classes "FabricaMySQL" produza somente produtos MySQL e "FabricaPostgreSQL" apenas produtos PostgreSQL. "AcessoDados" passou a receber uma fábrica e não escolhe mais o banco com "if/else" ou instanciando diretamente as classes concretas, com isso, garante que conexão e comando pertençam ao mesmo fornecedor.

## 3. Builder: criar um ConsultaBuilder com métodos nomeados e encadeáveis para os parâmetros opcionais (comFiltro, comOrdenacao, comLimite, etc.) e um construir() que devolve a consulta. Substitui o método telescópico.



## 4. Singleton: transformar o AcessoDados em um Singleton, com construtor privado, instância estática e método de acesso.



## 5. Desenhar o diagrama de classes da solução (fábrica de banco, produtos, builder e acesso), evidenciando os três padrões.