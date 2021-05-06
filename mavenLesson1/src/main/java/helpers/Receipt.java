package helpers;
import models.Item;
import parsers.CsvParser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Receipt {
    private double price;
    private List<Item> purchases;
    Date date;
    public Receipt(List<Item> list) {
        date = new GregorianCalendar().getTime();
        price = ItemCalculator.calculate(list);
        purchases = list;
    }
    public Receipt(String path) throws IOException {
        this(new CsvParser().readDate(path));
    }
    public void outputReceiptToFile(String path) throws IOException {
        FileWriter writer = null;
        try {
            writer = new FileWriter(path);
            writer.write("*****************************\n");
            writer.write("           RECEIPT           \n");
            writer.write("*****************************\n");
            writer.write(date.toString() + "\n");
            writer.write("-----------------------------\n");
            for (Item it : purchases) {
                writer.write(it.getQuantity() + "x " + it.getName() + " " + it.getPrice() + "\n");
            }
            writer.write("-----------------------------\n");
            writer.write("-----------------------------\n");
            writer.write("TOTAL AMOUNT " + price + "\n");
        }
        catch (FileNotFoundException ex) {
            Files.createFile(Paths.get(path));
        }
        finally {
            if(writer != null) {
                writer.close();
            }
        }
    }
}
