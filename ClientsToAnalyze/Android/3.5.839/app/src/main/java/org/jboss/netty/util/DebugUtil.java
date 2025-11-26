package org.jboss.netty.util;

import com.sec.chaton.privateplugin.data.Spam;
import org.jboss.netty.util.internal.SystemPropertyUtil;

/* loaded from: classes.dex */
public class DebugUtil {
    public static boolean isDebugEnabled() {
        String str;
        try {
            str = SystemPropertyUtil.get("org.jboss.netty.debug");
        } catch (Exception e) {
            str = null;
        }
        if (str == null) {
            return false;
        }
        String upperCase = str.trim().toUpperCase();
        return (upperCase.startsWith("N") || upperCase.startsWith("F") || upperCase.equals(Spam.ACTIVITY_CANCEL)) ? false : true;
    }
}
