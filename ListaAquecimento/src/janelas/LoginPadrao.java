package janelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public abstract class LoginPadrao extends JFrame {
	
	public LoginPadrao(String titulo) {
		setTitle(titulo);
		setSize(600, 600);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException ulfe) {
			// handle exception
		} catch (ClassNotFoundException cnfe) {
			// handle exception
		} catch (InstantiationException ie) {
			// handle exception
		} catch (IllegalAccessException iae) {
			// handle exception
		}
	}
	
	protected abstract void adicionarTitulo();
	
	protected abstract void adicionarLabels();
	
	protected abstract void adicionarTextFields();
	
	protected abstract void adicionarBotao();
}
