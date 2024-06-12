import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class ArquivoJson {
    public void GravaArquivo(String nomeArquivo, Endereco endereco) throws IOException {
        FileWriter logradouro = new FileWriter(nomeArquivo);
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        logradouro.write(gson.toJson(endereco));
        logradouro.close();
    }
}
