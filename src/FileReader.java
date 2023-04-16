import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
//вынесено в отдельный класс
public class FileReader {
    public static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}
