import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.rmi.RemoteException;

public class ConsultaCep {

    public Endereco buscaEndereco(String cep) throws IOException, InterruptedException {
        String uri = "https://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .header("accept","application/json")
                .uri(URI.create(uri))
                .build();

        HttpResponse<String> response = null;

        try {
            response =  client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Endereco.class);
        } catch (Exception exception) {
            throw new RuntimeException("Não consegui obter o endereço a partir desse CEP.");
        }
    }

}
