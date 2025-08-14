package br.solus.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Utils {
	private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
	public static String ConverterPDFBinario(byte[] pdfBytes) throws IOException {
	     PDDocument document = PDDocument.load(pdfBytes);
	     PDFTextStripper stripper = new PDFTextStripper();
	     String text = stripper.getText(document);
	     	return text.trim();
	}
	
	public static String converterPDFBase64ParaTexto(String base64Pdf) throws IOException {
        byte[] pdfBytes = Base64.getDecoder().decode(base64Pdf);

        try (PDDocument document = PDDocument.load(pdfBytes)) {
            PDFTextStripper stripper = new PDFTextStripper();
            String texto = stripper.getText(document);
            return texto.trim();
        }
    }
	
	public static void CompararConteudoDoPdfComArquivoTxt(String pdfText, String nomeArquivo, boolean removePrimeiraLinha, int qtdLinhaInicio,boolean removeUltimaLinha, int qtdLinhaFinal) throws Exception {
	    File arquivoTxt = new File("src/main/resources/pdf/" + nomeArquivo + ".txt");
	    String textoEsperado = Files.readString(arquivoTxt.toPath(), StandardCharsets.UTF_8).trim();

	    String textoPdfNormalizado = removerPrimeiraELultimaLinha(pdfText, removePrimeiraLinha, qtdLinhaInicio, removeUltimaLinha, qtdLinhaFinal);
	    String textoEsperadoNormalizado = removerPrimeiraELultimaLinha(textoEsperado, removePrimeiraLinha, qtdLinhaInicio, removeUltimaLinha, qtdLinhaFinal);

	    assertEquals(textoEsperadoNormalizado, textoPdfNormalizado);
	}
	
    public static String obterDataAtualFormatada() {
        return LocalDate.now().format(FORMATADOR);
    }
    
    private static String removerPrimeiraELultimaLinha(String texto, boolean ignorarPrimeira, int qtdLinhaInicio, boolean ignorarUltima, int qtdLinhaFinal) {
        List<String> linhas = Arrays.asList(texto.split("\r?\n"));
        
        int inicio = ignorarPrimeira ? qtdLinhaInicio : 0;
        int fim = ignorarUltima ? linhas.size() - qtdLinhaFinal : linhas.size();

        return linhas.subList(inicio, fim).stream()
                .collect(Collectors.joining("\n"))
                .trim();
    }
}
