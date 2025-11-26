package javax.validation.spi;

import javax.validation.ValidationProviderResolver;

/* loaded from: classes.dex */
public interface BootstrapState {
    ValidationProviderResolver getDefaultValidationProviderResolver();

    ValidationProviderResolver getValidationProviderResolver();
}
