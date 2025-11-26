package javax.validation;

/* loaded from: classes.dex */
public interface ValidatorFactory {
    ConstraintValidatorFactory getConstraintValidatorFactory();

    MessageInterpolator getMessageInterpolator();

    TraversableResolver getTraversableResolver();

    Validator getValidator();

    <T> T unwrap(Class<T> cls);

    ValidatorContext usingContext();
}
