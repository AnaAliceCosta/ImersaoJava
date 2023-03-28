package br.com.alura.omnistream;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import br.com.alura.omnistream.service.json.JsonParser;

public class App {
    public static void main(String[] args) throws Exception {
        var url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        var endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();


        List<Map<String,String>> listaDeFilmes = new JsonParser().parse(body);

        for (Map<String,String> filme: listaDeFilmes){
            var urlImagem = filme.get("image");
            var inputStream = new URL(urlImagem).openStream();
            GeradorDeFigulinhas.cria(inputStream, "/home/ana/projetos/ImersaoJava/src/br/com/alura/omnistream/saida/"+  filme.get("title") + ".png");
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }


        

    }
}
