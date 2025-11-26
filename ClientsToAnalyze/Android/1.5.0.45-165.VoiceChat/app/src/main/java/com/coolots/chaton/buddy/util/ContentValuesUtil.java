package com.coolots.chaton.buddy.util;

import android.content.ContentValues;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class ContentValuesUtil {
    private ContentValuesUtil() {
    }

    public static String getStringByContentValuesForWhere(ContentValues where, String joinString) {
        StringBuilder values = new StringBuilder(40);
        if (where != null) {
            where.valueSet();
            if (where.size() > 0) {
                Set<Map.Entry<String, Object>> entrySet = where.valueSet();
                boolean needSeparator = false;
                for (Map.Entry<String, Object> entry : entrySet) {
                    if (needSeparator) {
                        values.append(" AND ");
                    }
                    needSeparator = true;
                    if (joinString != null && !joinString.equals("")) {
                        values.append(String.valueOf(joinString) + ".");
                    }
                    values.append(entry.getKey());
                    Object itemValue = entry.getValue();
                    if (itemValue instanceof Integer) {
                        values.append("=");
                        values.append(Integer.toString(((Integer) itemValue).intValue()));
                    } else if (itemValue instanceof Long) {
                        values.append("=");
                        values.append(Long.toString(((Long) itemValue).longValue()));
                    } else if (itemValue instanceof String) {
                        if (((String) itemValue).lastIndexOf(37) >= 0) {
                            values.append(" like ");
                        } else {
                            values.append("=");
                        }
                        values.append("\"").append((String) itemValue).append("\"");
                    }
                }
            } else {
                values.append("");
            }
        }
        return values.toString();
    }

    public static String getStringByContentValuesForValue(ContentValues value) {
        StringBuilder sbValue = null;
        if (value != null) {
            value.valueSet();
            sbValue = new StringBuilder(1000);
            if (value.size() > 0) {
                Set<Map.Entry<String, Object>> entrySet = value.valueSet();
                boolean bComma = false;
                for (Map.Entry<String, Object> entry : entrySet) {
                    if (bComma) {
                        sbValue.append(", ");
                    }
                    Object obj = entry.getValue();
                    if (obj != null) {
                        sbValue.append(entry.getKey()).append("=");
                        if (obj instanceof Integer) {
                            sbValue.append(((Integer) obj).toString());
                        } else if (obj instanceof Long) {
                            sbValue.append(((Long) obj).toString());
                        } else if (obj instanceof String) {
                            sbValue.append("\"").append((String) obj).append("\"");
                        }
                        bComma = true;
                    }
                }
            }
        }
        return sbValue.toString();
    }
}
