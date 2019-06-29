import java.util.ArrayList;
import java.util.Scanner;
//emitir relatorio com o total de comissoes do vendedor(%10 do valor de cada venda)
//emitir um relatorio (via metodo molimorfico) com as vendas realizadas e seus totais
//atualizar a quantidade em estoque


//OBS:o metodo poliformico esta classe venda e vendas e vendas a prazo e a vista
//GRUPO: LUZENIR
//       TIAGO JUNIOR
//       PAULO RUBENS
public class Principal {
	static Clientes clientes=new Clientes();
	static Vendedor vendedores=new Vendedor();
	static Produtos produtos=new Produtos();

	public static void main(String[] args) {
		Principal principal=new Principal();

		produtos.cadastrarProduto();
		clientes.cadastrarCliente();
		vendedores.cadastrarVendedor();

		int op = 0;
		do{
			op = principal.menu();
			switch(op){
				case 1:
					principal.menuVendas();
					break;

				case 2:
					produtos.listarProdutos();
					break;

				case 3:
					clientes.listarClientes();
					break;

				case 4:
					vendedores.listarVendedores();
					break;

				case 0:
					System.out.println("\n\n\n 				 Finalizando...\n\n\n");		
					System.out.println("\t\t              SISTEMA FINALIZADO !  \n");
					System.out.println("\t\t===========================================\n");
					break;
				default:System.out.println("\t\tOpcao invalida !");
			}
		}while(op != 0);	  
		System.exit(0);
	}
	//////////////////////////////////////////////////////////////////////////////////////////


	static Scanner leitura = new Scanner(System.in);

    static int menu(){

		System.out.println("\n\n");
		System.out.println("\t\t============ SISTEMA DE VENDAS ===============");
		System.out.print("\n\t\t1 - Vendas\n\t\t2 - Estoque\n\t\t3 - Clientes\n\t\t4 - Vendedores\n\t\t0 - Sair\n");
		System.out.print("\t\t>");
		int op = leitura.nextInt();

		return op;
	}	
	void menuVendas(){
		int opcao=0;
		Scanner entrada = new Scanner(System.in);

		while(opcao>=0){
			System.out.println("\n\t\t1 - Cadastrar venda\n\t\t2 - imprimir relatorio das vendas\n\t\t3 - Imprimir Relatorio da comissao do vendedor\n\t\t4 - Listar vendas\n\t\t5 - voltar");
			System.out.print("\n\t\t>");
			opcao=entrada.nextInt();

			switch (opcao) {
				case 1:
					cadastrarVenda();
					break;

				case 2:
					System.out.println("\t\tRelatorio de vendas\n");
					double tot=0;
					for(int i= 0; i < listaDeVendas.size();i++){
						tot=listaDeVendas.get(i).getValorTotalOriginal()*0.9;
						tot++;
					}
					System.out.println("\t\tTotal a vista: R$ "+tot);
					double tot2=0;
					for(int i= 0; i < listaDeVendas.size();i++){
						tot2=listaDeVendas.get(i).getValorTotalOriginal()*1.1;
						tot2++;
					}
					System.out.println("\t\tTotal a prazo: R$ "+tot2);
					double tot3=0;
					tot3=tot3+tot+tot2;
					System.out.println("\t\tTotal geral: R$ "+tot3);
					
					break;

				case 3:
					System.out.println("\t\tRelatorio de comissoes\n");
					double totalComissao = 0;
					System.out.println("\t\tCodigo vendedor");
					int codigo=entrada.nextInt();

					Vendedor v =vendedores.buscarVendedor(codigo);
					for(int i= 0; i < listaDeVendas.size();i++){
						if(listaDeVendas.get(i).getVendedor().getCodigo()==codigo){
							totalComissao += listaDeVendas.get(i).getValor()*0.10;
						}
					}
					System.out.println("\t\tVendedor: "+v+"\n\t\tTotal da comissao: R$ "+totalComissao);

					break;

				case 4:
					listarVendas();
					break;

				case 5:
					menu();
					break;

				default:
					System.out.println("\t\tOpcao invalida !");
					break;
			}
		}	
	}
	Scanner entrada = new Scanner(System.in);
	ArrayList<Venda> listaDeVendas = new ArrayList <Venda>();
	static int cont=0;
	void cadastrarVenda(){
		int opcao=1;
		while(opcao == 1){
			cont++;
			System.out.print("\n\t\tData: ");
			String data = entrada.next();
			System.out.print("\t\tCPF do cliente: ");
			int cpf = entrada.nextInt();

			Cliente c = clientes.buscarCliente(cpf);
			System.out.println("\t\tCliente: "+c);
			System.out.print("\t\tCodigo do vendedor: ");
			int codigo = entrada.nextInt();

			Vendedor v = vendedores.buscarVendedor(codigo);
			System.out.println("\t\tVendedor: "+v);

			ArrayList <ItemVenda> itensDaVenda = new ArrayList<ItemVenda>();
			while(true){
				System.out.print("\t\tCodigo do produto :");
				codigo=entrada.nextInt();

				Produto p = produtos.buscarProduto(codigo);
				System.out.println("\t\tProduto: "+p);
				System.out.print("\t\tQuantidade:");
				int quantidade=entrada.nextInt();
				produtos.setDecrementaEstoque(quantidade);
				if (p!=null){
					itensDaVenda.add(new ItemVenda(p, quantidade));
					System.out.println("\t\tItem adicionado!");
				}

				System.out.print("\n\t\tDeseja cadastrar outro produto? 1 - Sim .... 2 - Nao");
				int res=entrada.nextInt();
				if(res == 2)
					break;
			}
			System.out.print("\t\t1 - Venda a vista .... 2 - Venda a prazo");
			int resp=entrada.nextInt();
			if(resp == 1)
				listaDeVendas.add(new VendaAVista(cont, data, c, v, itensDaVenda));

			if(resp == 2){
				listaDeVendas.add(new VendaAPrazo(cont, data, c, v, itensDaVenda));
			}


			System.out.println("\n\t\tCadastrar nova venda? 1 - sim   2 - Nao");
			System.out.print("\t\t>");
			opcao = entrada.nextInt();	
		}
	}

	void listarVendas(){
		if(listaDeVendas.size()>0){
			System.out.println("\n\t\t--- Vendas ---");
			for(int i=0; i<listaDeVendas.size(); i++){
				Venda v = listaDeVendas.get(i);
				System.out.print("\t\tData: " + v.getData() 
								 +"\n\t\tNumero da venda: "+v.getId()
								 +"\n\t\tCliente: "+v.getCliente()
								 +"\n\t\tVendedor: "+v.getVendedor()
								 +"\n\t\tValor Total Original R$ "+v.getValorTotalOriginal()
								 +"\n\t\tValor Total R$ "+v.getValor()
								 +"\n\t\tProduto(s): \n"+v.imprimirItens() 
								 +"\n\t\t----------------\n");
				System.out.println();
			}
		}else{
			System.out.println("\t\tNenhuma venda cadastrada");
		}
	}
	
	public void calculaTotalVendas(ArrayList<Venda>listaDeVendas){
		double total=0;
		for(int i=0;i<listaDeVendas.size();i++){
			total=listaDeVendas.get(i).getValor();
		}
		System.out.println("\n\t\tTotal das Vendas realizadas: R$ "+total);
	}

	double getTotalVendaAVista(){
		double total = 0;
		for(int i=0; i<listaDeVendas.size(); i++){
			//double valor = (venda.get(i).getQuantidade()*venda.get(i).getValor());
			//total = total+valor;
		}
		return total;
	}

}
	


