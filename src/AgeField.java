public class AgeField extends Field<Integer> {
    public AgeField(String value) {
        super(value);
    }

    public String getName() {
        return "age";
    }

    public Integer parse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new FieldParseException(getName(), e.toString());
        }
    }

    public void validate(Integer value) {
        if (value < 18) {
            throw new FieldInvalidValueException("Value of age must be at least 18");
        }
    }
}
