import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account {
    private List<Field> fields;

    public Account(String s) {
        String[] parts = s.split(",");
        if (parts.length != 3) {
            throw new AccountCreationException();
        };
        fields = Arrays.asList(
                new IdField(parts[0]),
                new EmailField(parts[1]),
                new AgeField(parts[2])
        );
    };
}

class AccountCreationException extends RuntimeException {
    public AccountCreationException() {
        super("This account could not be created");
    }
};
