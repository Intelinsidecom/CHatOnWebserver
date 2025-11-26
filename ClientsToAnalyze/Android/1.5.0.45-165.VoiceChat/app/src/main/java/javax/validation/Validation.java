package javax.validation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import javax.validation.bootstrap.GenericBootstrap;
import javax.validation.bootstrap.ProviderSpecificBootstrap;
import javax.validation.spi.BootstrapState;
import javax.validation.spi.ValidationProvider;

/* loaded from: classes.dex */
public class Validation {
    public static ValidatorFactory buildDefaultValidatorFactory() {
        return byDefaultProvider().configure().buildValidatorFactory();
    }

    public static GenericBootstrap byDefaultProvider() {
        return new GenericBootstrapImpl();
    }

    public static <T extends Configuration<T>, U extends ValidationProvider<T>> ProviderSpecificBootstrap<T> byProvider(Class<U> providerType) {
        return new ProviderSpecificBootstrapImpl(providerType);
    }

    private static class ProviderSpecificBootstrapImpl<T extends Configuration<T>, U extends ValidationProvider<T>> implements ProviderSpecificBootstrap<T> {
        private ValidationProviderResolver resolver;
        private final Class<U> validationProviderClass;

        public ProviderSpecificBootstrapImpl(Class<U> validationProviderClass) {
            this.validationProviderClass = validationProviderClass;
        }

        @Override // javax.validation.bootstrap.ProviderSpecificBootstrap
        public ProviderSpecificBootstrap<T> providerResolver(ValidationProviderResolver resolver) {
            this.resolver = resolver;
            return this;
        }

        @Override // javax.validation.bootstrap.ProviderSpecificBootstrap
        public T configure() {
            if (this.validationProviderClass == null) {
                throw new ValidationException("builder is mandatory. Use Validation.byDefaultProvider() to use the generic provider discovery mechanism");
            }
            GenericBootstrapImpl genericBootstrapImpl = new GenericBootstrapImpl();
            if (this.resolver == null) {
                this.resolver = genericBootstrapImpl.getDefaultValidationProviderResolver();
            } else {
                genericBootstrapImpl.providerResolver(this.resolver);
            }
            try {
                for (ValidationProvider<?> validationProvider : this.resolver.getValidationProviders()) {
                    if (this.validationProviderClass.isAssignableFrom(validationProvider.getClass())) {
                        return (T) this.validationProviderClass.cast(validationProvider).createSpecializedConfiguration(genericBootstrapImpl);
                    }
                }
                throw new ValidationException("Unable to find provider: " + this.validationProviderClass);
            } catch (RuntimeException e) {
                throw new ValidationException("Unable to get available provider resolvers.", e);
            }
        }
    }

    private static class GenericBootstrapImpl implements GenericBootstrap, BootstrapState {
        private ValidationProviderResolver defaultResolver;
        private ValidationProviderResolver resolver;

        private GenericBootstrapImpl() {
        }

        @Override // javax.validation.bootstrap.GenericBootstrap
        public GenericBootstrap providerResolver(ValidationProviderResolver resolver) {
            this.resolver = resolver;
            return this;
        }

        @Override // javax.validation.spi.BootstrapState
        public ValidationProviderResolver getValidationProviderResolver() {
            return this.resolver;
        }

        @Override // javax.validation.spi.BootstrapState
        public ValidationProviderResolver getDefaultValidationProviderResolver() {
            if (this.defaultResolver == null) {
                this.defaultResolver = new DefaultValidationProviderResolver();
            }
            return this.defaultResolver;
        }

        @Override // javax.validation.bootstrap.GenericBootstrap
        public Configuration<?> configure() {
            ValidationProviderResolver resolver = this.resolver == null ? getDefaultValidationProviderResolver() : this.resolver;
            try {
                List<ValidationProvider<?>> resolvers = resolver.getValidationProviders();
                if (resolvers.size() == 0) {
                    throw new ValidationException("Unable to find a default provider");
                }
                try {
                    Configuration<?> config = resolver.getValidationProviders().get(0).createGenericConfiguration(this);
                    return config;
                } catch (RuntimeException re) {
                    throw new ValidationException("Unable to instantiate Configuration.", re);
                }
            } catch (RuntimeException re2) {
                throw new ValidationException("Unable to get available provider resolvers.", re2);
            }
        }
    }

    private static class DefaultValidationProviderResolver implements ValidationProviderResolver {
        private static final Map<ClassLoader, List<ValidationProvider<?>>> providersPerClassloader = new WeakHashMap();
        private static final String SERVICES_FILE = "META-INF/services/" + ValidationProvider.class.getName();

        private DefaultValidationProviderResolver() {
        }

        @Override // javax.validation.ValidationProviderResolver
        public List<ValidationProvider<?>> getValidationProviders() throws IOException {
            List<ValidationProvider<?>> providers;
            ClassLoader classloader = GetClassLoader.fromContext();
            if (classloader == null) {
                classloader = GetClassLoader.fromClass(DefaultValidationProviderResolver.class);
            }
            synchronized (providersPerClassloader) {
                providers = providersPerClassloader.get(classloader);
            }
            if (providers == null) {
                providers = new ArrayList<>();
                String name = null;
                try {
                    Enumeration<URL> providerDefinitions = classloader.getResources(SERVICES_FILE);
                    while (providerDefinitions.hasMoreElements()) {
                        URL url = providerDefinitions.nextElement();
                        InputStream stream = url.openStream();
                        try {
                            BufferedReader reader = new BufferedReader(new InputStreamReader(stream), 100);
                            name = reader.readLine();
                            while (name != null) {
                                String name2 = name.trim();
                                if (!name2.startsWith("#")) {
                                    Class<?> providerClass = loadClass(name2, DefaultValidationProviderResolver.class);
                                    providers.add((ValidationProvider) providerClass.newInstance());
                                }
                                name = reader.readLine();
                            }
                        } finally {
                        }
                    }
                    synchronized (providersPerClassloader) {
                        providersPerClassloader.put(classloader, providers);
                    }
                } catch (IOException e) {
                    throw new ValidationException("Unable to read " + SERVICES_FILE, e);
                } catch (ClassNotFoundException e2) {
                    throw new ValidationException("Unable to load Bean Validation provider " + name, e2);
                } catch (IllegalAccessException e3) {
                    throw new ValidationException("Unable to instanciate Bean Validation provider" + name, e3);
                } catch (InstantiationException e4) {
                    throw new ValidationException("Unable to instanciate Bean Validation provider" + name, e4);
                }
            }
            return providers;
        }

        private static Class<?> loadClass(String name, Class<?> caller) throws ClassNotFoundException {
            try {
                ClassLoader loader = GetClassLoader.fromContext();
                if (loader != null) {
                    return loader.loadClass(name);
                }
            } catch (ClassNotFoundException e) {
                if (caller == null) {
                    throw e;
                }
            }
            return Class.forName(name, true, GetClassLoader.fromClass(caller));
        }
    }

    private static class GetClassLoader implements PrivilegedAction<ClassLoader> {
        private final Class<?> clazz;

        public static ClassLoader fromContext() {
            GetClassLoader action = new GetClassLoader(null);
            return System.getSecurityManager() != null ? (ClassLoader) AccessController.doPrivileged(action) : action.run();
        }

        public static ClassLoader fromClass(Class<?> clazz) {
            if (clazz == null) {
                throw new IllegalArgumentException("Class is null");
            }
            GetClassLoader action = new GetClassLoader(clazz);
            return System.getSecurityManager() != null ? (ClassLoader) AccessController.doPrivileged(action) : action.run();
        }

        private GetClassLoader(Class<?> clazz) {
            this.clazz = clazz;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.security.PrivilegedAction
        public ClassLoader run() {
            return this.clazz != null ? this.clazz.getClassLoader() : Thread.currentThread().getContextClassLoader();
        }
    }
}
