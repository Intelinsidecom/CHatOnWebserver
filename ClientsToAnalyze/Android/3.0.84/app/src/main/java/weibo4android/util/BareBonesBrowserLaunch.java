package weibo4android.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class BareBonesBrowserLaunch {
    public static void openURL(String str) {
        try {
            browse(str);
        } catch (Exception e) {
        }
    }

    private static void browse(String str) throws IllegalAccessException, NoSuchMethodException, IOException, IllegalArgumentException, InvocationTargetException {
        String str2 = null;
        String property = System.getProperty("os.name", "");
        if (property.startsWith("Mac OS")) {
            Class.forName("com.apple.eio.FileManager").getDeclaredMethod("openURL", String.class).invoke(null, str);
            return;
        }
        if (property.startsWith("Windows")) {
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + str);
            return;
        }
        String[] strArr = {"firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape"};
        for (int i = 0; i < strArr.length && str2 == null; i++) {
            if (Runtime.getRuntime().exec(new String[]{"which", strArr[i]}).waitFor() == 0) {
                str2 = strArr[i];
            }
        }
        if (str2 == null) {
            throw new NoSuchMethodException("Could not find web browser");
        }
        Runtime.getRuntime().exec(new String[]{str2, str});
    }
}
