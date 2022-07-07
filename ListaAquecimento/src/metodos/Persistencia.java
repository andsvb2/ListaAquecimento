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
import programas.ProgramaDeTv;
import users.Usuario;

public abstract class Persistencia {

	private static XStream xstream = new XStream(new DomDriver("UTF-8"));
	
	public Persistencia() {
		
		xstream.addPermission(NoTypePermission.NONE); //forbid everything
		xstream.addPermission(NullPermission.NULL); // allow "null"
		xstream.addPermission(PrimitiveTypePermission.PRIMITIVES); // allow primitive types
		xstream.allowTypes( new Class[] {CentralDeInformacoes.class, Persistencia.class,
				GeradorDeRelatorios.class, Canal.class, ProgramaDeTv.class,
				Usuario.class, java.time.DayOfWeek.class});
		xstream.allowTypesByWildcard(new String[]{"metodos.*"});
	}
	
	public static void salvarCentral(CentralDeInformacoes central) {
		File arquivoPadrao = new File("central.xml");
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
		xml += xstream.toXML(central);
		try {
			PrintWriter gravar = new PrintWriter(arquivoPadrao);
			arquivoPadrao.createNewFile();
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static CentralDeInformacoes recuperarCentral() {
		File arquivoPadrao = new File("central.xml");
		try {
			if (arquivoPadrao.exists()) {
				FileInputStream fis = new FileInputStream(arquivoPadrao);
				return (CentralDeInformacoes) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new CentralDeInformacoes();
	}
	
	public static void salvarUsuario(Usuario u) {
		File arquivoPadrao = new File("usuario.xml");
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";
		xml += xstream.toXML(u);
		try {
			PrintWriter gravar = new PrintWriter(arquivoPadrao);
			arquivoPadrao.createNewFile();
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Usuario recuperarUsuario() {
		File arquivoPadrao = new File("usuario.xml");
		try {
			if (arquivoPadrao.exists()) {
				FileInputStream fis = new FileInputStream(arquivoPadrao);
				return (Usuario) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new Usuario();
	}
	
}


