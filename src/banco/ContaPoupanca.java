package banco;

public class ContaPoupanca extends Conta {
	
	public ContaPoupanca(String nome, int documento) {
		super(nome, documento);
	}

	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Poupança ===");
		super.imprimirInfosComuns();
	}


}
