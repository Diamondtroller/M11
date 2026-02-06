public abstract class Field<T> {
    private T value;

    abstract T parse(String value) throws FieldParseException;
    abstract String getName();
    abstract void validate(T value) throws FieldInvalidValueException;

    Field(String value) throws FieldException {
        if (value == null || value.isEmpty()) {
            throw new FieldEmptyException(getName());
        }
        this.value = parse(value);
        validate(this.value);
    }
}

class FieldException extends RuntimeException {
    public FieldException(String message) {
        super("Field could not be created. Cause: " + System.lineSeparator() + message);
    }
}

class FieldEmptyException extends FieldException {
    public FieldEmptyException(String name) {
        super("Given string was empty or null for " + name);
    }
}

class FieldParseException extends FieldException {
    public FieldParseException(String name, String cause) {
        super("Given string could not be parsed for " + name + System.lineSeparator() + cause);
    }
}

class FieldInvalidValueException extends FieldException {
    public FieldInvalidValueException(String message) {
        super("Validation failed: "+message);
    }
}
//  List is incorrect length (separator missing)
//  FieldException(Incorrect field)
//      Type unparsable/empty
//      InvalidValue field specific
//          Email contains @
//          Age >= 18