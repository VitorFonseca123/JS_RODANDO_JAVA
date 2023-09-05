import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.File;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        try {
            File input = new File("caminho/do/seu/arquivo.html"); // Substitua pelo caminho correto do seu arquivo HTML
            Document doc = Jsoup.parse(input, "UTF-8"); // Carrega o arquivo HTML usando o Jsoup
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}