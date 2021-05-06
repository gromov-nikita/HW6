import generator.IGenerator;

import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        IGenerator gen = () -> new Random().nextInt(90);
        System.out.println(gen.generateInt());
    }
}
