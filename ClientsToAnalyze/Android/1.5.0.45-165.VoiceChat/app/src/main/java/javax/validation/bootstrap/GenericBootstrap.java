package javax.validation.bootstrap;

import javax.validation.Configuration;
import javax.validation.ValidationProviderResolver;

/* loaded from: classes.dex */
public interface GenericBootstrap {
    Configuration<?> configure();

    GenericBootstrap providerResolver(ValidationProviderResolver validationProviderResolver);
}
