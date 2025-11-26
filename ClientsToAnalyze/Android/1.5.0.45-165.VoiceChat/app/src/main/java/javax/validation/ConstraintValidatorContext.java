package javax.validation;

/* loaded from: classes.dex */
public interface ConstraintValidatorContext {

    public interface ConstraintViolationBuilder {

        public interface NodeBuilderCustomizableContext {
            ConstraintValidatorContext addConstraintViolation();

            NodeBuilderCustomizableContext addNode(String str);

            NodeContextBuilder inIterable();
        }

        public interface NodeBuilderDefinedContext {
            ConstraintValidatorContext addConstraintViolation();

            NodeBuilderCustomizableContext addNode(String str);
        }

        public interface NodeContextBuilder {
            ConstraintValidatorContext addConstraintViolation();

            NodeBuilderCustomizableContext addNode(String str);

            NodeBuilderDefinedContext atIndex(Integer num);

            NodeBuilderDefinedContext atKey(Object obj);
        }

        ConstraintValidatorContext addConstraintViolation();

        NodeBuilderDefinedContext addNode(String str);
    }

    ConstraintViolationBuilder buildConstraintViolationWithTemplate(String str);

    void disableDefaultConstraintViolation();

    String getDefaultConstraintMessageTemplate();
}
