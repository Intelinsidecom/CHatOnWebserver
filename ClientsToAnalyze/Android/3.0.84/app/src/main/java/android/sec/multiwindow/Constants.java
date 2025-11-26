package android.sec.multiwindow;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class Constants {

    public class Intent {
        public static String ACTION_ARRANGE_WINDOWS;
        public static String CATEGORY_MULTIWINDOW_LAUNCHER;
        public static String EXTRA_ARRANGE_MODE;
        public static String EXTRA_WINDOW_ARRANGED_SIZE;
        public static String EXTRA_WINDOW_DEFAULT_SIZE;
        public static String EXTRA_WINDOW_LAST_SIZE;
        public static String EXTRA_WINDOW_MINIMIZED_SIZE;
        public static String EXTRA_WINDOW_MINIMIZED_SLOT;
        public static String EXTRA_WINDOW_MINIMUM_SIZE;
        public static String EXTRA_WINDOW_MODE;
        public static String EXTRA_WINDOW_OUT_OF_ARRANGE;
        public static String EXTRA_WINDOW_POSITION;
        static String[] FIELD_NAMES = {"EXTRA_WINDOW_MODE", "EXTRA_WINDOW_POSITION", "EXTRA_WINDOW_MINIMUM_SIZE", "EXTRA_WINDOW_MINIMIZED_SIZE", "EXTRA_WINDOW_MINIMIZED_SLOT", "EXTRA_WINDOW_DEFAULT_SIZE", "EXTRA_WINDOW_LAST_SIZE", "EXTRA_WINDOW_ARRANGED_SIZE", "EXTRA_WINDOW_OUT_OF_ARRANGE", "CATEGORY_MULTIWINDOW_LAUNCHER", "METADATA_SUPPORT_MULTIWINDOW", "METADATA_MULTIWINDOW_STYLE", "METADATA_MULTIWINDOW_MIN_WIDTH", "METADATA_MULTIWINDOW_MIN_HEIGHT", "METADATA_MULTIWINDOW_DEF_WIDTH", "METADATA_MULTIWINDOW_DEF_HEIGHT", "ACTION_ARRANGE_WINDOWS", "EXTRA_ARRANGE_MODE"};
        public static String METADATA_MULTIWINDOW_DEF_HEIGHT;
        public static String METADATA_MULTIWINDOW_DEF_WIDTH;
        public static String METADATA_MULTIWINDOW_MIN_HEIGHT;
        public static String METADATA_MULTIWINDOW_MIN_WIDTH;
        public static String METADATA_MULTIWINDOW_STYLE;
        public static String METADATA_SUPPORT_MULTIWINDOW;

        static {
            int length = FIELD_NAMES.length;
            for (int i = 0; i < length; i++) {
                try {
                    Field declaredField = android.content.Intent.class.getDeclaredField(FIELD_NAMES[i]);
                    Field field = Intent.class.getField(FIELD_NAMES[i]);
                    field.set(field, declaredField.get(declaredField));
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e2) {
                } catch (NoSuchFieldException e3) {
                }
            }
        }
    }

    public class PackageManager {
        public static String FEATURE_MULTIWINDOW;
        public static String FEATURE_MULTIWINDOW_PHONE;
        static String[] FIELD_NAMES = {"FEATURE_MULTIWINDOW", "FEATURE_MULTIWINDOW_PHONE"};

        static {
            int length = FIELD_NAMES.length;
            for (int i = 0; i < length; i++) {
                try {
                    Field declaredField = android.content.pm.PackageManager.class.getDeclaredField(FIELD_NAMES[i]);
                    Field field = PackageManager.class.getField(FIELD_NAMES[i]);
                    field.set(field, declaredField.get(declaredField));
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e2) {
                } catch (NoSuchFieldException e3) {
                }
            }
        }
    }

    public class WindowManagerPolicy {
        static String[] FIELD_NAMES = {"WINDOW_MODE_MASK", "WINDOW_MODE_NORMAL", "WINDOW_MODE_FREESTYLE", "WINDOW_MODE_OPTION_COMMON_PINUP", "WINDOW_MODE_OPTION_COMMON_INHERIT", "WINDOW_MODE_OPTION_COMMON_RESIZE", "WINDOW_MODE_OPTION_COMMON_MINIMIZED", "WINDOW_MODE_OPTION_COMMON_HIDDEN", "WINDOW_MODE_OPTION_COMMON_FIXED_SIZE", "WINDOW_MODE_OPTION_COMMON_FIXED_RATIO", "WINDOW_INFO_NOTHING_CHANGED", "WINDOW_INFO_SIZE_CHANGED", "WINDOW_MODE_OPTION_COMMON_NO_DECORATION", "WINDOW_MODE_OPTION_SPLIT_ZONE_MASK", "WINDOW_MODE_OPTION_SPLIT_ZONE_F", "WINDOW_MODE_OPTION_SPLIT_ZONE_E", "WINDOW_MODE_OPTION_SPLIT_ZONE_D", "WINDOW_MODE_OPTION_SPLIT_ZONE_C", "WINDOW_MODE_OPTION_SPLIT_ZONE_UNKNOWN", "WINDOW_MODE_OPTION_SPLIT_ZONE_B", "WINDOW_MODE_OPTION_SPLIT_ZONE_A", "WINDOW_MODE_OPTION_SPLIT_ZONE_FULL", "WINDOW_MODE_OPTION_COMMON_NO_CONTROLBAR"};
        public static int WINDOW_INFO_NOTHING_CHANGED;
        public static int WINDOW_INFO_SIZE_CHANGED;
        public static int WINDOW_MODE_FREESTYLE;
        public static int WINDOW_MODE_MASK;
        public static int WINDOW_MODE_NORMAL;
        public static int WINDOW_MODE_OPTION_COMMON_FIXED_RATIO;
        public static int WINDOW_MODE_OPTION_COMMON_FIXED_SIZE;
        public static int WINDOW_MODE_OPTION_COMMON_HIDDEN;
        public static int WINDOW_MODE_OPTION_COMMON_INHERIT;
        public static int WINDOW_MODE_OPTION_COMMON_MINIMIZED;
        public static int WINDOW_MODE_OPTION_COMMON_NO_CONTROLBAR;
        public static int WINDOW_MODE_OPTION_COMMON_NO_DECORATION;
        public static int WINDOW_MODE_OPTION_COMMON_PINUP;
        public static int WINDOW_MODE_OPTION_COMMON_RESIZE;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_A;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_B;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_C;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_D;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_E;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_F;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_FULL;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_MASK;
        public static int WINDOW_MODE_OPTION_SPLIT_ZONE_UNKNOWN;

        static {
            int length = FIELD_NAMES.length;
            for (int i = 0; i < length; i++) {
                try {
                    Field declaredField = android.view.WindowManagerPolicy.class.getDeclaredField(FIELD_NAMES[i]);
                    Field field = WindowManagerPolicy.class.getField(FIELD_NAMES[i]);
                    field.setInt(field, declaredField.getInt(declaredField));
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e2) {
                } catch (NoSuchFieldException e3) {
                }
            }
        }
    }

    public class Configuration {
        public static int ARRANGE_CASCADE;
        public static int ARRANGE_MINIMIZED_ALL;
        public static int ARRANGE_RESTORED_ALL;
        public static int ARRANGE_SPLITED;
        public static int ARRANGE_TILED;
        public static int ARRANGE_TOGGLE_MASK;
        public static int ARRANGE_UNDEFINED;
        static String[] FIELD_NAMES = {"ARRANGE_UNDEFINED", "ARRANGE_TILED", "ARRANGE_CASCADE", "ARRANGE_SPLITED", "ARRANGE_MINIMIZED_ALL", "ARRANGE_RESTORED_ALL", "ARRANGE_TOGGLE_MASK"};

        static {
            int length = FIELD_NAMES.length;
            for (int i = 0; i < length; i++) {
                try {
                    Field declaredField = android.content.res.Configuration.class.getDeclaredField(FIELD_NAMES[i]);
                    Field field = Configuration.class.getField(FIELD_NAMES[i]);
                    field.setInt(field, declaredField.getInt(declaredField));
                } catch (IllegalAccessException e) {
                } catch (IllegalArgumentException e2) {
                } catch (NoSuchFieldException e3) {
                }
            }
        }
    }
}
