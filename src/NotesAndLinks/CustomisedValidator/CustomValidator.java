package NotesAndLinks.CustomisedValidator;

import java.lang.annotation.*;


@Constraint(validatedBy = ContactNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomValidator {
    String message() default "Invalid phone number";
    Class<?>[] groups() default {};
    //<Payload> Class<? extends Payload>[] payload() default {};
}

class ContactNumberValidator implements
        ConstraintValidator<CustomValidator, String> {

    @Override
    public void initialize(CustomValidator contactNumber) {
    }

    @Override
    public <ConstraintValidatorContext> boolean isValid(String contactField,
                                                        ConstraintValidatorContext cxt) {
        return contactField != null && contactField.matches("[0-9]+")
                && (contactField.length() > 8) && (contactField.length() < 14);
    }
}