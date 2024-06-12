import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("Informe o número do CEP a ser pesquisado: ");
        Scanner entrada = new Scanner(System.in);
        String cep = entrada.nextLine();

        ConsultaCep consultaCep = new ConsultaCep();
        Endereco endereco = consultaCep.buscaEndereco(cep);

        ArquivoJson arquivoJson = new ArquivoJson();
        String nomeArquivo = cep + ".json";
        arquivoJson.GravaArquivo(nomeArquivo, endereco);

    }
}