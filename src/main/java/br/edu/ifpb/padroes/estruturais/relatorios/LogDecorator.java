package br.edu.ifpb.padroes.estruturais.relatorios;

public class LogDecorator extends GeradorRelatorioDecorator {

    private final ContextoRelatorio contexto;

    public LogDecorator(GeradorRelatorio gerador, ContextoRelatorio contexto) {

        super(gerador);
        this.contexto = contexto;
    }

    @Override
    public String gerar(String dadosBrutos) {

        System.out.println(
                "[LOG] Usuario "
                        + contexto.getUsuario().getNome()
                        + " solicitou relatorio tipo "
                        + contexto.getTipo()
        );

        String resultado = gerador.gerar(dadosBrutos);

        if (resultado != null) {

            System.out.println(
                    "[LOG] Relatorio gerado com sucesso para "
                            + contexto.getUsuario().getNome()
            );
        }

        return resultado;
    }
}
