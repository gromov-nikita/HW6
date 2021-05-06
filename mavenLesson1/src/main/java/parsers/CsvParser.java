package parsers;
import models.Item;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class CsvParser {
    public List<Item> readDate(String path) throws IOException {
        List<Item> items = new LinkedList<Item>();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(path);
            Scanner scanner = new Scanner(fileReader);
            while(scanner.hasNext()) {
                String value = scanner.next();
                String[] itemValues = value.split(",");
                if(itemValues.length == 3) {
                    Item item = new Item(itemValues[0],
                            Double.parseDouble(itemValues[1]),
                            Integer.parseInt(itemValues[2]));
                    items.add(item);
                }
            }
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        finally {
            if(fileReader != null ) {
                fileReader.close();
            }
        }
        return items;
    }
}
