package metodos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.NullPermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;

import midia.Canal;
import programas.SerieRegular;
import users.Usuario;

public class Persistencia {

	private XStream xstream = new XStream(new DomDriver("UTF-8"));
	private File centralPadrao = new File("central.xml");
	private String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
    
    public Persistencia() {
//		xstream.addPermission(AnyTypePermission.ANY);

		  xstream.addPermission(NoTypePermission.NONE); //forbid everything
		  xstream.addPermission(NullPermission.NULL); // allow "null"
		  xstream.addPermission(PrimitiveTypePermission.PRIMITIVES); // allow primitive
		  xstream.allowTypes( new Class[] {CentralDeInformacoes.class,
		  Persistencia.class, GeradorDeRelatorios.class, Canal.class,
		  SerieRegular.class, Usuario.class, java.time.DayOfWeek.class});
		  xstream.allowTypesByWildcard(new String[]{"metodos.*","enums.*","programas.*","midia.*"});
		 
	}
	
	/*
	 * public void salvarSalao(Object sla, String nomeArquivo) throws Exception {
	 * 
	 * File arquivo = new File(nomeArquivo); arquivo.createNewFile(); PrintWriter pW
	 * = new PrintWriter(arquivo); String xml =
	 * "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"; xml += xStream.toXML(sla);
	 * pW.print(xml); pW.close(); }
	 */
    
    public void salvarCentral(CentralDeInformacoes central) {
		try {
			centralPadrao.createNewFile();
			PrintWriter gravar = new PrintWriter(centralPadrao);
			xml += xstream.toXML(central);
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	/*
	 * public Object recuperarSalao(String nomeArquivo)throws Exception{
	 * 
	 * File arquivo = new File(nomeArquivo); if (arquivo.exists()){ FileInputStream
	 * fIS = new FileInputStream(arquivo); return (Object) xStream.fromXML(fIS);
	 * 
	 * } else { throw new Exception(); } }
	 */



    
	

	public CentralDeInformacoes recuperarCentral() {
		try {
			if (centralPadrao.exists()) {
				FileInputStream fis = new FileInputStream(centralPadrao);
				return (CentralDeInformacoes) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new CentralDeInformacoes();
	}
	
}
