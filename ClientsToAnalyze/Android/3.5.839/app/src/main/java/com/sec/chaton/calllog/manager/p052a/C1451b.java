package com.sec.chaton.calllog.manager.p052a;

import android.content.ContentValues;
import java.util.Map;

/* compiled from: ContentValuesUtil.java */
/* renamed from: com.sec.chaton.calllog.manager.a.b */
/* loaded from: classes.dex */
public final class C1451b {
    /* renamed from: a */
    public static String m7603a(ContentValues contentValues, String str) {
        StringBuilder sb = new StringBuilder(40);
        if (contentValues != null && contentValues.size() > 0) {
            contentValues.valueSet();
            boolean z = false;
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                if (z) {
                    sb.append(" AND ");
                }
                if (str != null && !str.equals("")) {
                    sb.append(str + ".");
                }
                sb.append(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof Integer) {
                    sb.append("=");
                    sb.append(Integer.toString(((Integer) value).intValue()));
                } else if (value instanceof Long) {
                    sb.append("=");
                    sb.append(Long.toString(((Long) value).longValue()));
                } else if (value instanceof String) {
                    if (((String) value).lastIndexOf(37) >= 0) {
                        sb.append(" like ");
                    } else {
                        sb.append("=");
                    }
                    sb.append("\"").append((String) value).append("\"");
                }
                z = true;
            }
        } else {
            sb.append("");
        }
        return sb.toString();
    }
}
