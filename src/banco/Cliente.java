package banco;

public class Cliente {
	public static void main(String[] args) {
		Conta cc = new ContaCorrente("Gustavo", 12345);
		Conta cp = new ContaPoupanca("Ana", 28494);
		
		System.out.println("");
		
		cp.depositar(1700);
		cp.exibirSaldo();
		cp.fazerEmprestimo(2000, 32);
		cp.transferir(1200, cp);
	}
}
