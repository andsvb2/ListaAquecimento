package metodos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Document;

public class GeradorDeRelatorios {

	public static void obterProgramacaoDeUmCanal(Canal canal) {

		Persistencia pe = Persistencia.getInstancia();
		CentralDeInformacoes central = pe.recuperarCentral();
		
		Document doc = new Document(PageSize.A4);
		try {
			OutputStream os = new FileOutputStream("relatorio.pdf");

			PdfWriter.getInstance(doc, os);

			doc.open();

			Paragraph pg = new Paragraph("Programas cadastrados no canal" + canal + "\n");
			doc.add(pg);
			
			doc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

}

