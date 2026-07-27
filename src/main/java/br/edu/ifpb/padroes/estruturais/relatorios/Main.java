package br.edu.ifpb.padroes.estruturais.relatorios;

public class Main {
    public static void main(String[] args) {

        SistemaRelatorios sistema = new SistemaRelatorios();
        Usuario admin = new Usuario("Ana", true, "ADMIN");
        Usuario visitante = new Usuario("Bruno", true, "VISITANTE");
        Usuario naoLogado = new Usuario("Carla", false, "OPERADOR");


        System.out.println("--- Cenario 1: admin, com cache e log ---");

        ContextoRelatorio contextoPDF = new ContextoRelatorio(admin, "PDF");
        GeradorRelatorio geradorPDF = sistema.criarGerador("PDF");

        geradorPDF = new LogDecorator(geradorPDF, contextoPDF);
        geradorPDF = new CacheDecorator(geradorPDF, contextoPDF);
        geradorPDF = new ProxyGeradorRelatorio(geradorPDF, admin);

        System.out.println(geradorPDF.gerar("vendas-julho"));


        System.out.println("--- Cenario 2: mesma consulta (deve vir do cache) ---");
        System.out.println(geradorPDF.gerar("vendas-julho"));


        System.out.println("--- Cenario 3: admin, sem cache, com log, outro tipo ---");

        ContextoRelatorio contextoExcel = new ContextoRelatorio(admin, "EXCEL");
        GeradorRelatorio geradorExcel = sistema.criarGerador("EXCEL");

        geradorExcel = new LogDecorator(geradorExcel, contextoExcel);
        geradorExcel = new ProxyGeradorRelatorio(geradorExcel, admin);

        System.out.println(geradorExcel.gerar("vendas-agosto"));


        System.out.println("--- Cenario 4: visitante (sem permissao) ---");

        ContextoRelatorio contextoVisitante = new ContextoRelatorio(visitante, "PDF");
        GeradorRelatorio geradorVisitante = sistema.criarGerador("PDF");

        geradorVisitante = new CacheDecorator(geradorVisitante, contextoVisitante);
        geradorVisitante = new ProxyGeradorRelatorio(geradorVisitante, visitante);

        System.out.println(geradorVisitante.gerar("vendas-julho"));


        System.out.println("--- Cenario 5: usuario nao autenticado ---");

        ContextoRelatorio contextoNaoLogado = new ContextoRelatorio(naoLogado, "PDF");
        GeradorRelatorio geradorNaoLogado = sistema.criarGerador("PDF");

        geradorNaoLogado = new LogDecorator(geradorNaoLogado, contextoNaoLogado);
        geradorNaoLogado = new CacheDecorator(geradorNaoLogado, contextoNaoLogado);
        geradorNaoLogado = new ProxyGeradorRelatorio(geradorNaoLogado, naoLogado);

        System.out.println(geradorNaoLogado.gerar("vendas-julho"));
    }
}
