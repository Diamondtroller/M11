public class IdField extends Field<Long> {
    public IdField(String value) {
        super(value);
    }
    public String getName() {
        return "id";
    }
    public Long parse(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new FieldParseException(getName(), e.toString());
        }
    }

    public void validate(Long value) {
        if (value < 0) {
            throw new FieldInvalidValueException("Value of id must be positive");
        }
    }
}
