package br.edu.ifpb.padroes.estruturais.relatorios;

import java.util.HashMap;
import java.util.Map;

public class CacheDecorator extends GeradorRelatorioDecorator {

    private static final Map<String, String> CACHE = new HashMap<>();
    private final ContextoRelatorio contexto;

    public CacheDecorator(GeradorRelatorio gerador, ContextoRelatorio contexto) {

        super(gerador);
        this.contexto = contexto;
    }

    @Override
    public String gerar(String dadosBrutos) {

        String chave =
                contexto.getTipo()
                        + ":"
                        + dadosBrutos;

        if (CACHE.containsKey(chave)) {

            System.out.println(
                    "[LOG] Retornando resultado do cache para "
                            + contexto.getUsuario().getNome()
            );

            return CACHE.get(chave);
        }

        String resultado = gerador.gerar(dadosBrutos);

        if (resultado != null) {
            CACHE.put(chave, resultado);
        }

        return resultado;
    }
}