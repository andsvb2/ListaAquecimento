package janelas;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import metodos.CentralDeInformacoes;
import metodos.Persistencia;
import midia.Canal;

import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import midia.Canal;

public class JanelaListarCanais extends JanelaPadrao{
	
	private Persistencia pe = Persistencia.getInstancia();
	private CentralDeInformacoes central = pe.recuperarCentral();
	private CadastrarCanal janela;
	
	public JanelaListarCanais(){
		super("Lista de canais");
		adicionarTabela();
		setVisible(true);
	}
	
	private void adicionarTabela(){
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("Nome do canal");
		modelo.addColumn("Número");
		modelo.addColumn("Tipo do canal");
		
		ArrayList<Canal> todosOsCanais = central.getListaCanais();
		Object[] linhas = new Object[todosOsCanais.size()];
		
		for(Canal c : todosOsCanais){
			Object[] linha = new Object[3];
			
			linha[0] = c.getNomeCanal();
			linha[1] = janela.getTfNumero().getText();
			linha[2] = c.getTipoCanal();
			
			modelo.addRow(linha);
			
		}
		
		JTable tabela = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane(tabela);
		
		painelTabela.setBounds(40,90,340,190);
		
		add(painelTabela);
	}
	
	public static void main(String[] args) {
		JanelaListarCanais listarCanais = new JanelaListarCanais();
	}
}

        



