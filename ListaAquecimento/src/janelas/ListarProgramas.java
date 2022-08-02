
public class ListarProgramas extends JanelaPadrao{
	
	public ListarProgramas(){
		super("Lista de programas");
		adicionarTitulo();
		adicionarTabela();
		adicionarBotoes();
		setVisible(true);
	}
	
	private void adicionarTitulo(){
		JLabel titulo = new JLabel("Lista de programas", JLabel.CENTER);
		titulo.setBounds();
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setOpaque(true);
		add(titulo);
	}
	
	private void adicionarTabela(){
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("Nome do programa");
		modelo.addColumn("Tipo de programa");
		modelo.addColumn("Canal");
		
		Programa programa = new Programa();
		
		ArrayList<ProgramaDeTv> todosOsProgramas = programa.getTodosOsProgramas();
		
		Object[] linhas = new Object[todosOsProgramas.size()];
		
		for(Programa p : todosOsProgramas){
			Object[] linha = new object[3];
			
			ProgramaDeTv programaTv = new ProgramaDeTv();
			
			linha[0] = programa.getNome();
			linha[1] = programa.getTipo();
			linha[2] = programaTv.getCanal();
			
			modelo.addRow(linha);
			
			JTable tabela = new JTable(modelo);
			JScrollPane painelTabela = new JScrollPane(tabela);
			
			painelTabela.setBounds();
			
			add(painelTabela);
		}
	}
	
	private void adicionarBotoes(){
		botaoFiltrar = new JButton("Filtrar programas cadastrados");
		botaoFiltrar.setBounds();
		add(botaoFiltrar);
		
		botaoEditar = new JButton("Editar programa");
		botaoEditar.setBounds();
		add(botaoEditar);
		
		botaoRetirarFavoritos = new JButton("Retirar um programa dos favoritos");
		botaoRetirarFavoritos.setBounds();
		add(botaoRetirarFavoritos);
		
		botaoAumentarTemporadas = new JButton("Aumentar número de temporadas");
	botaoAumentarTemporadas.setBounds();
	add(botaoAumentarTemporadas);
	
	botaoMudarStatus = new JButton("Mudar status de exibição para hiato");
	botaoMudarStatus.setBounds();
	add(botaoMudarStatus);
	}
}

        



