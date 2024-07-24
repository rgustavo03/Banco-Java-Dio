package banco;

public class ContaCorrente extends Conta {

	public ContaCorrente(String nome, int documento) {
		super(nome, documento);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}
	
	
}
