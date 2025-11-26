package javax.validation;

import java.io.InputStream;
import javax.validation.Configuration;

/* loaded from: classes.dex */
public interface Configuration<T extends Configuration<T>> {
    T addMapping(InputStream inputStream);

    T addProperty(String str, String str2);

    ValidatorFactory buildValidatorFactory();

    T constraintValidatorFactory(ConstraintValidatorFactory constraintValidatorFactory);

    ConstraintValidatorFactory getDefaultConstraintValidatorFactory();

    MessageInterpolator getDefaultMessageInterpolator();

    TraversableResolver getDefaultTraversableResolver();

    T ignoreXmlConfiguration();

    T messageInterpolator(MessageInterpolator messageInterpolator);

    T traversableResolver(TraversableResolver traversableResolver);
}
