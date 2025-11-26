package twitter4j;

/* loaded from: classes.dex */
public final class Version {
    private static final String TITLE = "Twitter4J";
    private static final String VERSION = "2.2.5";

    private Version() {
        throw new AssertionError();
    }

    public static String getVersion() {
        return VERSION;
    }

    public static void main(String[] strArr) {
        System.out.println("Twitter4J 2.2.5");
    }
}
