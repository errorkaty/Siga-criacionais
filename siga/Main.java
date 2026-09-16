package siga;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade de Padrões Criacionais (Abstract Factory) ===\n");

        AcessoDados acesso = new AcessoDados();
        acesso.conectar(new FabricaMySQL());
        System.out.println();
        acesso.conectar(new FabricaPostgreSQL());

        System.out.println();
        // PROBLEMA 2 em ação: o que significa cada número nesta chamada?
        String consulta = acesso.montarConsulta("aluno", "curso = 'DSM'", "nome",
                50, 0, 30, true);
        System.out.println("Consulta montada: " + consulta);

    }
}
