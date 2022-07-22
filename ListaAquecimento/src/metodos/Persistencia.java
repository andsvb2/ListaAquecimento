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

public final class Persistencia {

	private static Persistencia instancia;
	private XStream xstream = new XStream(new DomDriver("UTF-8"));
	private File centralPadrao = new File("central.xml");
	private File usuarioPadrao = new File("usuario.xml");
	private String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n";

	private Persistencia() {

//		xstream.addPermission(AnyTypePermission.ANY);

		
		  xstream.addPermission(NoTypePermission.NONE); //forbid everything
		  xstream.addPermission(NullPermission.NULL); // allow "null"
		  xstream.addPermission(PrimitiveTypePermission.PRIMITIVES); // allow primitive
		  xstream.allowTypes( new Class[] {CentralDeInformacoes.class,
		  Persistencia.class, GeradorDeRelatorios.class, Canal.class,
		  ProgramaDeTv.class, Usuario.class, java.time.DayOfWeek.class});
		  xstream.allowTypesByWildcard(new String[]{"metodos.*","enums.*"});
		 
	}
	
	public static Persistencia getInstancia() {
		if (instancia == null) {
			instancia = new Persistencia();
		}
		return instancia;
	}

	public void salvarCentral(CentralDeInformacoes central) {
		xml += xstream.toXML(central);
		try {
			PrintWriter gravar = new PrintWriter(centralPadrao);
			centralPadrao.createNewFile();
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

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

	public void salvarUsuario(Usuario u) {
		xml += xstream.toXML(u);
		try {
			PrintWriter gravar = new PrintWriter(usuarioPadrao);
			usuarioPadrao.createNewFile();
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Usuario recuperarUsuario() {
		try {
			if (usuarioPadrao.exists()) {
				FileInputStream fis = new FileInputStream(usuarioPadrao);
				return (Usuario) xstream.fromXML(fis);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new Usuario();
	}

}
