package siga;

public class AcessoDados {

public void conectar(FabricaBanco fabrica) {
        Conexao conexao = fabrica.criarConexao();
        Comando comando = fabrica.criarComando();
        
        conexao.abrir();
        comando.executar("SELECT * FROM aluno");
    }
}
