package siga;

public class AcessoDados {

    private static final AcessoDados INSTANCIA = new AcessoDados();

    private AcessoDados() {
    }

    public static AcessoDados getInstancia() {
        return INSTANCIA;
    }

    public void conectar(FabricaBanco fabrica) {
        Conexao conexao = fabrica.criarConexao();
        Comando comando = fabrica.criarComando();

        conexao.abrir();
        comando.executar("SELECT * FROM aluno");
    }
}