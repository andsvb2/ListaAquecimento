import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Persistencia {

	private XStream xstream = new XStream(new DomDriver("UTF-8"));

	public void salvarCentral(CentralDeInformacoes central) throws Exception {
		File arquivo = new File("salvar.xml");
		arquivo.createNewFile();

		PrintWriter pw = new PrintWriter(arquivo);
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
		xml = xstream.toXML(central);
		pw.print(xml);
		pw.close();
	}

	public CentralDeInformacoes recuperarCentral() throws Exception{

		File arquivo = new File("salvar.xml");

		if(arquivo.exists()) {
			FileInputStream f = new FileInputStream(arquivo);
			return (CentralDeInformacoes) xstream.fromXML(f);
		}else {
			return new CentralDeInformacoes();
		}
	}
}

