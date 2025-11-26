package p010b.p013c;

/* compiled from: ConfigurationContext.java */
/* renamed from: b.c.b */
/* loaded from: classes.dex */
public final class C0283b {

    /* renamed from: a */
    private static final InterfaceC0284c f634a;

    static {
        String property;
        try {
            property = System.getProperty("twitter4j.configurationFactory", "twitter4j.conf.PropertyConfigurationFactory");
        } catch (SecurityException e) {
            property = "twitter4j.conf.PropertyConfigurationFactory";
        }
        try {
            f634a = (InterfaceC0284c) Class.forName(property).newInstance();
        } catch (ClassNotFoundException e2) {
            throw new AssertionError(e2);
        } catch (IllegalAccessException e3) {
            throw new AssertionError(e3);
        } catch (InstantiationException e4) {
            throw new AssertionError(e4);
        }
    }

    /* renamed from: a */
    public static InterfaceC0282a m989a() {
        return f634a.m990a();
    }
}
