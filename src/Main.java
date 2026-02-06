import java.io.*;
import java.util.ArrayList;

public class Main {
    static void main(String[] args) {
        File input = new File(args[0]);

        String s;

        int line = 0;
        ArrayList<Account> accounts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
            while ((s = br.readLine()) != null) {
                try {
                    accounts.add(new Account(s));
                } catch (Exception e) {
                    System.err.printf("Error processing line %d:%s", line++, System.lineSeparator());
                    System.err.println(e);
                }
            }
            // use
        } catch (IOException e) {
            System.err.println("Error reading: " + args[0]);
            System.err.println(e);
        }
    }
}
