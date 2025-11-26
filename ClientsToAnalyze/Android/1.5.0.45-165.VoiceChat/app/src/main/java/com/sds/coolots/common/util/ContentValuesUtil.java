package com.sds.coolots.common.util;

import android.content.ContentValues;
import java.util.Map;

/* loaded from: classes.dex */
public final class ContentValuesUtil {
    private ContentValuesUtil() {
    }

    public static String getStringByContentValesForValue(ContentValues contentValues) {
        StringBuilder sb = new StringBuilder(1000);
        if (contentValues != null && contentValues.size() > 0) {
            boolean z = false;
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                if (z) {
                    sb.append(", ");
                }
                Object value = entry.getValue();
                if (value != null) {
                    sb.append(entry.getKey()).append("=");
                    if (value instanceof Integer) {
                        sb.append(((Integer) value).toString());
                    } else if (value instanceof Long) {
                        sb.append(((Long) value).toString());
                    } else if (value instanceof String) {
                        sb.append("\"").append((String) value).append("\"");
                    }
                    z = true;
                }
            }
        }
        return sb.toString();
    }

    public static String getStringByContentValuesForWhere(ContentValues contentValues, String str) {
        StringBuilder sb = new StringBuilder(40);
        if (contentValues == null || contentValues.size() <= 0) {
            sb.append("");
        } else {
            boolean z = false;
            for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
                if (z) {
                    sb.append(" AND ");
                }
                if (str != null && !str.equals("")) {
                    sb.append(String.valueOf(str) + ".");
                }
                sb.append(entry.getKey());
                Object value = entry.getValue();
                if (value instanceof Integer) {
                    sb.append("=");
                    sb.append(Integer.toString(((Integer) value).intValue()));
                    z = true;
                } else if (value instanceof Long) {
                    sb.append("=");
                    sb.append(Long.toString(((Long) value).longValue()));
                    z = true;
                } else {
                    if (value instanceof String) {
                        if (((String) value).lastIndexOf(37) >= 0) {
                            sb.append(" like ");
                        } else {
                            sb.append("=");
                        }
                        sb.append("\"").append((String) value).append("\"");
                    }
                    z = true;
                }
            }
        }
        return sb.toString();
    }
}
