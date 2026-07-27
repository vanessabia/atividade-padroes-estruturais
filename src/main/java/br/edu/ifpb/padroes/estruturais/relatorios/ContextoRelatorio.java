package br.edu.ifpb.padroes.estruturais.relatorios;

public class ContextoRelatorio {
    private final Usuario usuario;
    private final String tipo;

    public ContextoRelatorio(Usuario usuario, String tipo) {
        this.usuario = usuario;
        this.tipo = tipo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getTipo() {
        return tipo;
    }
}
