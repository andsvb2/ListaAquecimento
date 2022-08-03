package janelas;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import enums.TipoDePrograma;
import metodos.CentralDeInformacoes;
import programas.Programa;

public class ListarProgramas extends JanelaPadrao{

	private JButton botaoFiltrar;
	private JButton botaoEditar;
	private JButton botaoRetirarFavoritos;
	private JButton botaoAumentarTemporadas;
	private JButton botaoMudarStatus;
	
	CentralDeInformacoes central;
	
	public ListarProgramas(){
		super("Lista de programas");
		setSize(800,800);
		adicionarTitulo();
		adicionarTabela();
		adicionarBotoes();
		setVisible(true);
	}

	private void adicionarTitulo(){
		JLabel titulo = new JLabel("Lista de programas", JLabel.CENTER);
		titulo.setBounds(0, 0, 800, 30);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setOpaque(true);
		add(titulo);
	}

	private void adicionarTabela(){
		DefaultTableModel modelo = new DefaultTableModel();

		modelo.addColumn("Nome do programa");
		modelo.addColumn("Tipo de programa");
		modelo.addColumn("Canal");

		Programa programa = null;

		CentralDeInformacoes central = new CentralDeInformacoes();
		
		ArrayList<Programa> todosOsProgramas = central.getTodosOsProgramas();
		
		Object[] linhas = new Object[todosOsProgramas.size()];

		for(Programa p : todosOsProgramas){
			Object[] linha = new Object[3];

			Programa programaTv = null;

			TipoDePrograma tipo = null;
			
			linha[0] = programa.getNome();
			linha[1] = tipo.getTipo();
			linha[2] = programaTv.getCanal();

			modelo.addRow(linha);
		}
		
		JTable tabela = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane(tabela);

		painelTabela.setBounds(30,90,700,400);

		add(painelTabela);
	}

	private void adicionarBotoes(){
		botaoFiltrar = new JButton("Filtrar programas cadastrados");
		botaoFiltrar.setBounds(20,500,220,80);
		add(botaoFiltrar);

		botaoEditar = new JButton("Editar programa");
		botaoEditar.setBounds(250,500,140,80);
		add(botaoEditar);

		botaoRetirarFavoritos = new JButton("Retirar um programa dos favoritos");
		botaoRetirarFavoritos.setBounds(400,500,250,80);
		add(botaoRetirarFavoritos);

		botaoAumentarTemporadas = new JButton("Aumentar número de temporadas");
		botaoAumentarTemporadas.setBounds(20,600,220,80);
		add(botaoAumentarTemporadas);

		botaoMudarStatus = new JButton("Mudar status de exibição para hiato");
		botaoMudarStatus.setBounds(250,600,280,80);
		add(botaoMudarStatus);
	}
	
	public static void main(String[] args) {
		ListarProgramas listarProgramas = new ListarProgramas();
	}
}
