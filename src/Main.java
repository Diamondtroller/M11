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
                System.out.println(line++);
                try {
                    accounts.add(new Account(s));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            // use
        } catch (IOException e) {
            System.out.println("Error reading: " + args[0]);
            System.out.println(e);
        }
    }
}
