package siga;

public class ConsultaBuilder {

    private String tabela;
    private String filtro;
    private String ordenacao;
    private int limite;
    private int offset;
    private int timeoutSegundos;
    private boolean somenteAtivos;

    public ConsultaBuilder(String tabela) {
        this.tabela = tabela;
    }

    public ConsultaBuilder comFiltro(String filtro) {
        this.filtro = filtro;
        return this;
    }

    public ConsultaBuilder comOrdenacao(String ordenacao) {
        this.ordenacao = ordenacao;
        return this;
    }

    public ConsultaBuilder comLimite(int limite) {
        this.limite = limite;
        return this;
    }

    public ConsultaBuilder comOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public ConsultaBuilder comTimeoutSegundos(int timeoutSegundos) {
        this.timeoutSegundos = timeoutSegundos;
        return this;
    }

    public ConsultaBuilder somenteAtivos(boolean somenteAtivos) {
        this.somenteAtivos = somenteAtivos;
        return this;
    }

    public String construir() {
        StringBuilder consulta = new StringBuilder("SELECT * FROM ")
                .append(tabela);

        if (filtro != null) {
            consulta.append(" WHERE ").append(filtro);
        }

        if (somenteAtivos) {
            consulta.append(
                    filtro != null
                            ? " AND ativo = 1"
                            : " WHERE ativo = 1"
            );
        }

        if (ordenacao != null) {
            consulta.append(" ORDER BY ").append(ordenacao);
        }

        if (limite > 0) {
            consulta.append(" LIMIT ").append(limite);
        }

        if (offset > 0) {
            consulta.append(" OFFSET ").append(offset);
        }

        return consulta.toString();
    }
}