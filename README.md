# SIGA — Atividade de Padrões Criacionais

## 1. Analisar o código inicial e identificar a possibilidade de misturar fornecedores e o método de consulta telescópico

### Mistura de fornecedores

Os objetos "Conexao" e "Comando" são criados separadamente, sem uma estrutura que garanta que ambos pertençam ao mesmo fornecedor. Por isso,
seria possível combinar acidentalmente uma "ConexaoMySQL" com um "ComandoPostgreSQL". Essa combinação seria incoerente e poderia causar falhas durante a execução.

### Método telescópico

O método "montarConsulta()' recebe muitos parâmetros que não são autoexplicativos, como "50", "0", "30" e "true". Por isso, é fácil confundir o significado e a ordem dos argumentos. Como vários parâmetros são opcionais, a chamada se torna ilegível e propensa a erros.

