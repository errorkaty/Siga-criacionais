package siga;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade de Padrões Criacionais (Abstract Factory + Builder) ===\n");

        AcessoDados acesso = new AcessoDados();
        acesso.conectar(new FabricaMySQL());
        System.out.println();
        acesso.conectar(new FabricaPostgreSQL());

        System.out.println();
        
       String consulta = new ConsultaBuilder("aluno")
        .comFiltro("curso = 'DSM'")
        .comOrdenacao("nome")
        .comLimite(50)
        .comOffset(0)
        .comTimeoutSegundos(30)
        .somenteAtivos(true)
        .construir();

System.out.println("Consulta montada: " + consulta);

    }
}
