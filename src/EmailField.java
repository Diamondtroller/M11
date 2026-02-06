public class EmailField extends Field<String> {
    public EmailField(String value) {
        super(value);
    }

    public String getName() {
        return "email";
    }

    public String parse(String value) {
        return value;
    }

    public void validate(String value) {
        if (!value.contains("@")) {
            throw new FieldInvalidValueException("Value of email must have @ in email");
        }
    }
}
