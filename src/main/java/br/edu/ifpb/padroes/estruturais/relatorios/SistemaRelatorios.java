package br.edu.ifpb.padroes.estruturais.relatorios;

public class SistemaRelatorios {

    public GeradorRelatorio criarGerador(String tipo) {

        if (tipo.equals("PDF")) {

            return new GeradorRelatorioPDF();

        } else if (tipo.equals("EXCEL")) {

            return new GeradorRelatorioExcel();

        } else {

            throw new IllegalArgumentException(
                    "Tipo de relatorio desconhecido: " + tipo
            );
        }
    }
}
