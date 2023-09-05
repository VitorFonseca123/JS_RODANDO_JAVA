import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        try {
            // Carregar o arquivo HTML
            Document document = Jsoup.parse(new File("../../src html/teste copy.html"), "UTF-8");

            // Agora você tem o documento HTML pronto para edição
            // Você pode fazer várias operações, como buscar elementos e editar seu conteúdo

            // Por exemplo, você pode alterar o conteúdo de um elemento:
            document.select("div").first().text("Novo Título");

            // Ou adicionar um novo elemento:
            document.body().append("<p>Este é um novo parágrafo.</p>");

            // Salvar as alterações de volta no arquivo HTML
            FileWriter fileWriter = new FileWriter("exemplo.html");
            fileWriter.write(document.outerHtml());
            fileWriter.close();

            System.out.println("Arquivo HTML editado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
