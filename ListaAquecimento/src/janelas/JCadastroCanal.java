package janelas;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JCadastroCanal extends JanelaPadrao {

	public JCadastroCanal() {
		super("Cadastro de canal");
	}

	@Override
	protected void adicionarTitulo() {
		ImageIcon icone = new ImageIcon();
		JLabel titulo = new JLabel("CADASTRO DE CANAL", icone, JLabel.CENTER);
		titulo.setBounds(0, 0, 600, 30);
		titulo.setFont(new Font("Fira Sans", Font.BOLD, 15));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setOpaque(true);
		add(titulo);
	}

	@Override
	protected void adicionarLabels() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void adicionarTextFields() {
		// TODO Auto-generated method stub
		
	}

}
