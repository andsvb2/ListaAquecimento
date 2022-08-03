package janelas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import enums.TipoCanal;
import metodos.CentralDeInformacoes;
import metodos.Persistencia;
import midia.Canal;
import midia.CanalBroadcast;
import midia.CanalTv;

public class CadastrarCanal extends JanelaPadrao {
	
	private JTextField nomeCanal;
	private JComboBox<TipoCanal> cbTipoCanal;
	private JFormattedTextField tfNumero;
	private JFormattedTextField tfLink;
//	private Persistencia pe = Persistencia.getInstancia();
//	private CentralDeInformacoes central = pe.recuperarCentral();

	public CadastrarCanal() {
		super("Cadastro de canal");
		adicionarTitulo();
		adicionarLabels();
		adicionarTextFields();
		adicionarBotoes();
		adicionarCombo();
		setVisible(true);
	}

	public JFormattedTextField getTfNumero() {
		return tfNumero;
	}
	
	public JComboBox<TipoCanal> getCbTipoCanal() {
		return cbTipoCanal;
	}
	
	public JTextField getNomeCanal() {
		return nomeCanal;
	}

	public JFormattedTextField getTfLink() {
		return tfLink;
	}

	private void adicionarTitulo() {
		JLabel titulo = new JLabel("CADASTRO DE CANAL", JLabel.CENTER);
		titulo.setBounds(0, 0, 600, 30);
		titulo.setFont(new Font("Fira Sans", Font.BOLD, 15));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setOpaque(true);
		add(titulo);
	}

	private void adicionarLabels() {
		JLabel nomeDoCanal = new JLabel("Nome:");
		nomeDoCanal.setBounds(5, 35, 55, 30);
		nomeDoCanal.setHorizontalAlignment(JLabel.CENTER);
		add(nomeDoCanal);
		
		JLabel tipoCanal = new JLabel("Tipo:");
		tipoCanal.setBounds(5, 70, 55, 30);
		tipoCanal.setHorizontalAlignment(JLabel.CENTER);
		add(tipoCanal);

		JLabel numeroDoCanal = new JLabel("Número:");
		numeroDoCanal.setBounds(370, 70, 55, 30);
		numeroDoCanal.setHorizontalAlignment(JLabel.CENTER);
		add(numeroDoCanal);
		
		JLabel linkTransmissao = new JLabel("Link:");
		linkTransmissao.setBounds(5, 105, 55, 30);
		linkTransmissao.setHorizontalAlignment(JLabel.CENTER);
		add(linkTransmissao);
	}

	private void adicionarTextFields() {
		nomeCanal = new JTextField();
		nomeCanal.setBounds(65, 35, 520, 30);
		add(nomeCanal);
		
		try {
			MaskFormatter mascara = new MaskFormatter("####");
			tfNumero = new JFormattedTextField(mascara);
			tfNumero.setHorizontalAlignment(JFormattedTextField.CENTER);
			tfNumero.setBounds(430, 70, 120, 30);
//			tfNumero.setEditable(false);
			add(tfNumero);
		} catch (Exception e) {}
		
		tfLink = new JFormattedTextField();
		tfLink.setBounds(65, 105, 530, 30);
		tfLink.setEditable(false);
		tfLink.setBackground(Color.RED);
		add(tfLink);
	}
	
	private void adicionarBotoes() {
		JButton botaoCadastrar = new JButton("Cadastrar");
		OuvinteBotaoCadastrar ouvinte = new OuvinteBotaoCadastrar(this);
		botaoCadastrar.setBounds(465, 505, 130, 30);
		botaoCadastrar.addActionListener(ouvinte);
		add(botaoCadastrar);
		
		JButton botaoEditar = new JButton("Editar");
		botaoEditar.setBounds(330, 505, 130, 30);
		add(botaoEditar);
	}
	
	private void adicionarCombo() {
		cbTipoCanal = new JComboBox(TipoCanal.values());
		cbTipoCanal.setBounds(65, 70, 300, 30);
		cbTipoCanal.setSelectedItem(TipoCanal.ABERTO);
		OuvinteCbItem ouvinteComboBox = new OuvinteCbItem();
		cbTipoCanal.addItemListener(ouvinteComboBox);
		add(cbTipoCanal);
	}
	
	private class OuvinteCbItem implements ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {
			TipoCanal tipo = (TipoCanal) getCbTipoCanal().getSelectedItem();
			switch (tipo) {
			case ABERTO:
			case PACOTE:
			case AIT:
				tfNumero.setEditable(true);
				tfNumero.setBackground(null);
				tfLink.setEditable(false);
				tfLink.setBackground(Color.RED);
				repaint();
				break;
			case BROADCASTING:
			case AIB:
				tfNumero.setEditable(false);
				tfNumero.setBackground(Color.RED);
				tfLink.setEditable(true);
				tfLink.setBackground(null);
				repaint();
				break;
			default:
				break;
			}
		}
		
	}
	
	private class OuvinteBotaoCadastrar implements ActionListener{
		private CadastrarCanal cadastro;
		private OuvinteBotaoCadastrar(CadastrarCanal cadastro) {
			this.cadastro = cadastro;
		}
				
		@Override
		public void actionPerformed(ActionEvent e) {
			
			TipoCanal tipo = (TipoCanal) getCbTipoCanal().getSelectedItem();
			Canal c = null;
			String nomeC = nomeCanal.getText();
						
			switch (tipo) {
			case ABERTO:
			case PACOTE:
			case AIT:
				int num = Integer.parseInt(cadastro.getTfNumero().getText());
				c = new CanalTv(nomeC, tipo, num);
				break;
			case BROADCASTING:
			case AIB:
				String link = cadastro.getTfLink().getText();
				c = new CanalBroadcast(nomeC, tipo, link);
				break;
			default:
				break;
			}
		
			boolean deuCerto = false;
			
			
			
//			Persistencia pe = Persistencia.getInstancia();
			Persistencia pe = new Persistencia();
			CentralDeInformacoes central = pe.recuperarCentral();
			deuCerto = central.adicionarCanal(c);
			pe.salvarCentral(central);
			
			
			if (deuCerto) {
				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
				dispose();
				new CadastrarCanal();
			} else {
				JOptionPane.showMessageDialog(null, "Cadastro não pôde ser concluído");
			}
		}
	}
	
	private class OuvinteBotaoEditar implements ActionListener{
		

		@Override
		public void actionPerformed(ActionEvent clique) {
			
			
			
			String opcao = (String) cbTipoCanal.getSelectedItem();
			
			if(opcao.equals("Canal aberto") 
					|| opcao.equals("Pacote de assinatura") 
					|| opcao.equals("Assinatura individual de televisão")) {
				tfNumero.setEditable(true);
			} else {
				dispose();
				new JanelaDeBroadcasting();
			}
		}
	}

}
