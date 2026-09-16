package siga;

public class AcessoDados {

public void conectar(FabricaBanco fabrica) {
        Conexao conexao = fabrica.criarConexao();
        Comando comando = fabrica.criarComando();
        
        conexao.abrir();
        comando.executar("SELECT * FROM aluno");
    }

    // PROBLEMA 2: método telescópico — muitos parâmetros opcionais.
    public String montarConsulta(String tabela, String filtro, String ordenacao,
                                 int limite, int offset, int timeoutSegundos,
                                 boolean somenteAtivos) {
        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(tabela);
        if (filtro != null) sb.append(" WHERE ").append(filtro);
        if (somenteAtivos) sb.append(filtro != null ? " AND ativo = 1" : " WHERE ativo = 1");
        if (ordenacao != null) sb.append(" ORDER BY ").append(ordenacao);
        if (limite > 0) sb.append(" LIMIT ").append(limite);
        if (offset > 0) sb.append(" OFFSET ").append(offset);
        return sb.toString();
    }
}
