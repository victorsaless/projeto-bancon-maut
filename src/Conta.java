public class Conta {
    private int agencia;
    private int numero;
    private Cliente cliente;
    private double saldo;
  
    private static int quantidadeDeContas;
  
    public Conta(int agencia, int numero, Cliente cliente) {
      System.out.println("carregamento de contas");
      quantidadeDeContas++;
      this.agencia = agencia;
      this.numero = numero;
      this.cliente = cliente;
    }
  
    public void deposita(double valor) {
      if (valor > 0) {
        this.saldo = this.saldo + valor;
        this.enviaNotificacao("Depósito", valor);
        System.out.println("Valor depositado na conta " + this.numero);
      }
    }
  
    public boolean saca(double valor) {
      if (valor > 0 && valor <= this.saldo) {
        this.saldo = this.saldo - valor;
        System.out.println("Valor sacado " + this.numero);
        this.enviaNotificacao("Saque", valor);
        return true;
      } else {
        System.out.println("Saque não realizado, valor do saldo insuficente!");
        return false;
      }
    }
  
    public void transfere(double valor, Conta contaDestino) {
      System.out.println("Iniciando transferência!");
      boolean saqueComSucesso = this.saca(valor);
      if (saqueComSucesso) {
        contaDestino.deposita(valor);
        this.enviaNotificacao("Transferência", valor);
      }
    }
  
    private void enviaNotificacao(String operacao, double valor) {
      new Notificacao().enviaEmail(operacao, valor);
    }
  
    public double getSaldo() {
      return saldo;
    }
  
    public int getAgencia() {
      return this.agencia;
    }
  
    public int getNumero() {
      return numero;
    }
  
    public Cliente getCliente() {
      return cliente;
    }
  
    public static int getQuantidadeDeContas() {
      return quantidadeDeContas;
    }
  
  }