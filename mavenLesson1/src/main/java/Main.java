import helpers.Receipt;
import models.Item;
import parsers.CsvParser;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        CsvParser parser = new CsvParser();
        List<Item> list = parser.readDate("D:\\2\\curs\\item.txt");
        for(Item it : list) {
            System.out.println(it.getName() + " " + it.getPrice() + " " + it.getQuantity());
        }
        Receipt receipt = new Receipt("D:\\2\\curs\\item.txt");
        receipt.outputReceiptToFile("D:\\2\\curs\\Receipt.txt");
    }
}
