package twitter4j.conf;

/* loaded from: classes.dex */
public final class ConfigurationContext {
    public static final String CONFIGURATION_IMPL = "twitter4j.configurationFactory";
    public static final String DEFAULT_CONFIGURATION_FACTORY = "twitter4j.conf.PropertyConfigurationFactory";
    private static final ConfigurationFactory factory;

    static {
        String property;
        try {
            property = System.getProperty(CONFIGURATION_IMPL, DEFAULT_CONFIGURATION_FACTORY);
        } catch (SecurityException e) {
            property = DEFAULT_CONFIGURATION_FACTORY;
        }
        try {
            factory = (ConfigurationFactory) Class.forName(property).newInstance();
        } catch (ClassNotFoundException e2) {
            throw new AssertionError(e2);
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        } catch (InstantiationException e4) {
            throw new AssertionError(e4);
        }
    }

    public static Configuration getInstance() {
        return factory.getInstance();
    }

    public static Configuration getInstance(String str) {
        return factory.getInstance(str);
    }
}
