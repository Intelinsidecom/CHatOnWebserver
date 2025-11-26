package twitter4j;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public interface ProfileImage extends Serializable, TwitterResponse {
    public static final ImageSize BIGGER = new ImageSize("bigger", null);
    public static final ImageSize NORMAL = new ImageSize("normal", null);
    public static final ImageSize MINI = new ImageSize("mini", null);
    public static final ImageSize ORIGINAL = new ImageSize("original", null);

    /* renamed from: twitter4j.ProfileImage$1 */
    class C37781 {
    }

    String getURL();

    public class ImageSize implements Serializable {
        private static final Map<String, ImageSize> instances = new HashMap();
        private static final long serialVersionUID = 3363026523372848987L;
        private final String name;

        ImageSize(String str, C37781 c37781) {
            this(str);
        }

        private ImageSize() {
            throw new AssertionError();
        }

        private ImageSize(String str) {
            this.name = str;
            instances.put(str, this);
        }

        public String getName() {
            return this.name;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.name.equals(((ImageSize) obj).name);
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return this.name;
        }

        private static ImageSize getInstance(String str) {
            return instances.get(str);
        }

        private Object readResolve() {
            return getInstance(this.name);
        }
    }
}
