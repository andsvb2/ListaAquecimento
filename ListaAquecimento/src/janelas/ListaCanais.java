import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public abstract class ListaCanais extends JanelaPadrao{

	public ListaCanais() {
		super("Lista de canais");
		adicionarTitulo();
		adicionarTabela();
		adicionarBotoes();
	}

	protected void adicionarTitulo() {
		JLabel titulo = new JLabel("Lista de canais", JLabel.CENTER);
		titulo.setBounds(0, 0, 600, 30);
		titulo.setFont(new Font("Fira Sans", Font.BOLD, 15));
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setOpaque(true);
		add(titulo);
	}

	private void adicionarTabela() {
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("Nome do canal");
		modelo.addColumn("Tipo");
		modelo.addColumn("Número do canal");
		
		JTable tabela = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane();
		painelTabela.setBounds(0,0,0,0);
		
		add(painelTabela);
	}
	
	private void adicionarBotoes() {
		JButton botaoExcluir = new JButton("Excluir um canal");
		
		botaoExcluir.setBounds(55, 85, 30, 30);
		add(botaoExcluir);
		
		JButton voltar = new JButton("Voltar para o menu");
		
		voltar.setBounds(55, 85, 30, 30);
		add(voltar);
	}
	
	private class OuvinteBotaoExcluir implements ActionListener{
		
		private ListaCanais janela;
		
		private OuvinteBotaoExcluir(ListaCanais janela) {
			this.janela = janela;
		}
		
		public void actionPerformed(ActionEvent ouvinte) {
			S
		}
	}
	
}
