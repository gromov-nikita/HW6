package helpers;

import models.Item;

import java.util.List;

public class ItemCalculator {
    public static int calculate(List<Item> list) {
        int sum = 0;
        for(Item it : list) {
            sum += it.getPrice() * it.getQuantity();
        }
        return sum;
    }
}
