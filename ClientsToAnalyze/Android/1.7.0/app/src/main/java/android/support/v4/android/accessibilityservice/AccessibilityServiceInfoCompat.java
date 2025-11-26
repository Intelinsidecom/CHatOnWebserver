package android.support.v4.android.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;

/* loaded from: classes.dex */
public class AccessibilityServiceInfoCompat {
    public static final int FEEDBACK_ALL_MASK = -1;
    private static final AccessibilityServiceInfoVersionImpl IMPL;

    interface AccessibilityServiceInfoVersionImpl {
        boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityServiceInfo);

        String getDescription(AccessibilityServiceInfo accessibilityServiceInfo);

        String getId(AccessibilityServiceInfo accessibilityServiceInfo);

        ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityServiceInfo);

        String getSettingsActivityName(AccessibilityServiceInfo accessibilityServiceInfo);
    }

    class AccessibilityServiceInfoStubImpl implements AccessibilityServiceInfoVersionImpl {
        AccessibilityServiceInfoStubImpl() {
        }

        @Override // android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityServiceInfo) {
            return false;
        }

        @Override // android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public String getDescription(AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }

        @Override // android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public String getId(AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }

        @Override // android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }

        @Override // android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public String getSettingsActivityName(AccessibilityServiceInfo accessibilityServiceInfo) {
            return null;
        }
    }

    class AccessibilityServiceInfoIcsImpl extends AccessibilityServiceInfoStubImpl {
        AccessibilityServiceInfoIcsImpl() {
        }

        @Override // android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getCanRetrieveWindowContent(accessibilityServiceInfo);
        }

        @Override // android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public String getDescription(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getDescription(accessibilityServiceInfo);
        }

        @Override // android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public String getId(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getId(accessibilityServiceInfo);
        }

        @Override // android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getResolveInfo(accessibilityServiceInfo);
        }

        @Override // android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl, android.support.v4.android.accessibilityservice.AccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
        public String getSettingsActivityName(AccessibilityServiceInfo accessibilityServiceInfo) {
            return AccessibilityServiceInfoCompatIcs.getSettingsActivityName(accessibilityServiceInfo);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityServiceInfoIcsImpl();
        } else {
            IMPL = new AccessibilityServiceInfoStubImpl();
        }
    }

    private AccessibilityServiceInfoCompat() {
    }

    public static String getId(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getId(accessibilityServiceInfo);
    }

    public static ResolveInfo getResolveInfo(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getResolveInfo(accessibilityServiceInfo);
    }

    public static String getSettingsActivityName(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getSettingsActivityName(accessibilityServiceInfo);
    }

    public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getCanRetrieveWindowContent(accessibilityServiceInfo);
    }

    public static String getDescription(AccessibilityServiceInfo accessibilityServiceInfo) {
        return IMPL.getDescription(accessibilityServiceInfo);
    }

    public static String feedbackTypeToString(int i) {
        switch (i) {
            case -1:
                return "FEEDBACK_ALL";
            case 1:
                return "FEEDBACK_SPOKEN";
            case 2:
                return "FEEDBACK_HAPTIC";
            case 4:
                return "FEEDBACK_AUDIBLE";
            case 8:
                return "FEEDBACK_VISUAL";
            case 16:
                return "FEEDBACK_GENERIC";
            default:
                return null;
        }
    }

    public static String flagToString(int i) {
        switch (i) {
            case 1:
                return "DEFAULT";
            default:
                return null;
        }
    }
}
