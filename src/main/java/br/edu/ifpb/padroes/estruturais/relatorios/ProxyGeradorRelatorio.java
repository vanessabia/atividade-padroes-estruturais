package br.edu.ifpb.padroes.estruturais.relatorios;

public class ProxyGeradorRelatorio implements GeradorRelatorio {

    private final GeradorRelatorio gerador;
    private final Usuario usuario;

    public ProxyGeradorRelatorio(GeradorRelatorio gerador, Usuario usuario) {

        this.gerador = gerador;
        this.usuario = usuario;
    }

    @Override
    public String gerar(String dadosBrutos) {

        if (!usuario.isAutenticado()) {

            System.out.println(
                    "[ERRO] Usuario nao autenticado tentou gerar relatorio."
            );

            return null;
        }

        if (!usuario.getPapel().equals("ADMIN")
                && !usuario.getPapel().equals("OPERADOR")) {

            System.out.println(
                    "[ERRO] Usuario sem permissao para gerar relatorios: "
                            + usuario.getNome()
            );

            return null;
        }

        return gerador.gerar(dadosBrutos);
    }
}
