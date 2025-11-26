package javax.validation;

import java.util.Set;

/* loaded from: classes.dex */
public class ConstraintViolationException extends ValidationException {
    private final Set<ConstraintViolation<?>> constraintViolations;

    public ConstraintViolationException(String message, Set<ConstraintViolation<?>> constraintViolations) {
        super(message);
        this.constraintViolations = constraintViolations;
    }

    public ConstraintViolationException(Set<ConstraintViolation<?>> constraintViolations) {
        this.constraintViolations = constraintViolations;
    }

    public Set<ConstraintViolation<?>> getConstraintViolations() {
        return this.constraintViolations;
    }
}
