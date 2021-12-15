import java.time.LocalDate;

public class TestaApp {

  public static void main(String[] args) {
    LocalDate dataNascimento = LocalDate.of(2003, 02, 20);


    Cliente cliente1 = new Cliente("sales", "89146432932", new Endereco("quadra 8 casa 2", 25, "bairro vila serrana", "Picos", "PI"),
        dataNascimento);

    System.out.println(cliente1.getEnderecos().get(0).getLagradouro());

    cliente1.addEndereco(new Endereco("quadra 8casa 2", 25, "bairro vila serrrana", "Picos", "PI"));

    System.out.println("quantidades de endereços:" + cliente1.getEnderecos().size());

    Cliente cliente2 = new Cliente("victor", "9842611444414", new Endereco("rua sao sebastiao", 23, "bairro pantanal", "Picos", "PI"),
        dataNascimento);
        System.out.println("quantidades de endereços: " + cliente2.getEnderecos().size());

    Conta conta1 = new Conta(15, 20, cliente1);
    Conta conta2 = new Conta(10, 15, cliente1);

    conta1.deposita(1000);
    conta1.transfere(400, conta2);
    conta2.saca(300);

    System.out.println("------------------------------------------");
    System.out.println("valor na conta do cliente 1: " + conta1.getSaldo());
    System.out.println("------------------------------------------");
    System.out.println("valor na conta do cliente 2: " +conta2.getSaldo());
    
    

  }

}