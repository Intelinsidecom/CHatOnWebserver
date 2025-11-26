package javax.validation;

import javax.validation.metadata.ConstraintDescriptor;

/* loaded from: classes.dex */
public interface ConstraintViolation<T> {
    ConstraintDescriptor<?> getConstraintDescriptor();

    Object getInvalidValue();

    Object getLeafBean();

    String getMessage();

    String getMessageTemplate();

    Path getPropertyPath();

    T getRootBean();

    Class<T> getRootBeanClass();
}
