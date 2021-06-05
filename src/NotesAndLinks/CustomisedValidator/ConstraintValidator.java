package NotesAndLinks.CustomisedValidator;

public interface ConstraintValidator<T, T1> {
    public void initialize(CustomValidator contactNumber);
    public <T> boolean isValid(T1 contactField,T cxt);
}
