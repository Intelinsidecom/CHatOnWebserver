package javax.validation;

/* loaded from: classes.dex */
public interface ConstraintValidatorFactory {
    <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> cls);
}
