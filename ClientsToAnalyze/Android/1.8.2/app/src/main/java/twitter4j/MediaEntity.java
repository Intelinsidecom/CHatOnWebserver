package twitter4j;

import java.io.Serializable;
import java.net.URL;
import java.util.Map;

/* loaded from: classes.dex */
public interface MediaEntity extends URLEntity {

    public interface Size extends Serializable {
        public static final int CROP = 101;
        public static final int FIT = 100;
        public static final Integer THUMB = new Integer(0);
        public static final Integer SMALL = new Integer(1);
        public static final Integer MEDIUM = new Integer(2);
        public static final Integer LARGE = new Integer(3);

        int getHeight();

        int getResize();

        int getWidth();
    }

    long getId();

    URL getMediaURL();

    URL getMediaURLHttps();

    Map getSizes();
}
