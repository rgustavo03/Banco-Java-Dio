package banco;

public abstract class Conta implements InterfaceConta {
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	protected int agencia;
	protected int numero;
	protected double saldo;
	
	protected String nome;
	protected int documento;
	
	public Conta(String nome, int documento) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		
		this.nome = nome;
		this.documento = documento;
		System.out.println("Conta criada, " + nome);
	}

	public void exibirSaldo() {
		System.out.printf("Seu saldo é de R$ %.2f %n", this.saldo);
	}
	
	protected void imprimirInfosComuns() {
		System.out.println("Agência " + this.agencia);
		System.out.println("Número " + this.numero);
		System.out.println("Nome " + this.nome);
		System.out.printf("Saldo %.2f %n", this.saldo);
	}

	@Override
	public void sacar(double valor) {
		if(valor <= saldo) {
			this.saldo -= valor;
		} else {
			System.out.println("Saldo insuficiente");
		}
	}

	@Override
	public void depositar(double valor) {
		saldo += valor;
	}

	@Override
	public void transferir(double valor, Conta contaDestino) {
		if(valor <= saldo) {
			this.sacar(valor);
			contaDestino.depositar(valor);
			System.out.print("Transferência para " + contaDestino.nome + " feita com sucesso. ");
			System.out.printf("Transferido R$ %.2f %n", valor);
		} else {
			System.out.println("Saldo insuficiente");
		}
	}
	
	public void fazerEmprestimo(double valor, int qtdParcelas) {
		if(valor > (this.saldo * 1.5)) {
			System.out.println("Você não pode fazer emprestimos desse valor!");
		} else {
			double parcela = qtdParcelas < 12? (valor / qtdParcelas) : ((valor * 1.1) / qtdParcelas);
			System.out.printf("Você fez um empréstimo no valor de R$ " + valor + ". Pagamento em " + qtdParcelas + " vezes de R$ %.2f %n", parcela);
		}
	}

	
}


