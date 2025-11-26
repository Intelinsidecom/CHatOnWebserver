package javax.validation;

/* loaded from: classes.dex */
public interface ValidatorContext {
    ValidatorContext constraintValidatorFactory(ConstraintValidatorFactory constraintValidatorFactory);

    Validator getValidator();

    ValidatorContext messageInterpolator(MessageInterpolator messageInterpolator);

    ValidatorContext traversableResolver(TraversableResolver traversableResolver);
}
