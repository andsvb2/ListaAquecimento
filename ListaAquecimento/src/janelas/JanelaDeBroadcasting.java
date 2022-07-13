package janelas;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import metodos.CentralDeInformacoes;
import metodos.Persistencia;

public class JanelaDeBroadcasting extends JanelaPadrao {

	private Persistencia pe = Persistencia.getInstancia();
	private CentralDeInformacoes central = pe.recuperarCentral();
	
	public JanelaDeBroadcasting() {
		super("Broadcasting");
		adicionarTitulo();
		adicionarLabels();
		adicionarTextFields();
		adicionarBotao();
		setVisible(true);
	}

		
	private void adicionarTitulo() {
		JLabel titulo = new JLabel("Broadcasting", JLabel.CENTER);
		titulo.setBounds(0, 0, 600, 30);
		titulo.setFont(new Font("Fira Sans", Font.BOLD, 15));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setOpaque(true);
		add(titulo);
	}

	private void adicionarLabels() {
		JLabel link = new JLabel("Link de transmissão");
		link.setBounds(getBounds());
		link.setOpaque(true);
		add(link);
	}

	private void adicionarTextFields() {
		JTextField campoDoLink= new JTextField();
		campoDoLink.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		add(campoDoLink);
	}

	private void adicionarBotao() {
		JButton botaoConfirmar = new JButton("Confirmar link");
		botaoConfirmar.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
		add(botaoConfirmar);
	}

	private class OuvinteBotaoConfirmar implements ActionListener{
		private JanelaDeBroadcasting janela;
		
		private OuvinteBotaoConfirmar(JanelaDeBroadcasting janela) {
			this.janela= janela;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean deuCerto = true;
			// TODO implementar lógica.

			if (deuCerto) {
				JOptionPane.showMessageDialog(null, "Link copiado com sucesso");
				// TODO: corrigir isso
				central.adicionarCanal();
			} else {
				JOptionPane.showMessageDialog(null, "Link não pôde ser copiado");
			}
		}
		// TODO: corrigir isso
		pe.salvarCentral(central);
	}
}
