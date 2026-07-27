package br.edu.ifpb.padroes.estruturais.relatorios;

public abstract class GeradorRelatorioDecorator implements GeradorRelatorio {

    protected GeradorRelatorio gerador;

    public GeradorRelatorioDecorator(GeradorRelatorio gerador) {
        this.gerador = gerador;
    }

}