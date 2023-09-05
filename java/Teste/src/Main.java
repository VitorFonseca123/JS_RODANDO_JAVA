import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] args) {
        try {
            File inputFile = new File("../../src html/copia.html");
            Document document = Jsoup.parse(inputFile, "UTF-8");

            // Encontre o elemento <div> com ID "modifica"
            Element divElement = document.getElementById("modifica");

            // Verifique se o elemento foi encontrado
            if (divElement != null) {
                // Modifique o conteúdo do elemento <div>
                divElement.text("Novo conteúdo da div com ID 'modifica'");

                // Especifique o caminho para a pasta onde você deseja salvar o arquivo
                String outputFolderPath = "../../src html/";

                // Crie o diretório de saída se ele não existir
                File outputFolder = new File(outputFolderPath);
                if (!outputFolder.exists()) {
                    outputFolder.mkdirs();
                }

                // Crie um novo arquivo de saída na pasta especificada
                File outputFile = new File(outputFolderPath, "copia.html");

                // Salvar as alterações de volta no arquivo HTML
                FileWriter fileWriter = new FileWriter(outputFile);
                fileWriter.write(document.outerHtml());
                fileWriter.close();

                System.out.println("Conteúdo da div com ID 'modifica' modificado e arquivo salvo com sucesso em " + outputFile.getAbsolutePath());
            } else {
                System.out.println("Elemento <div> com ID 'modifica' não encontrado no arquivo HTML.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
