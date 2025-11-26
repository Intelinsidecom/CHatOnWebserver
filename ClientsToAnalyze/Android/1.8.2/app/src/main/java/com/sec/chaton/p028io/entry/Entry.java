package com.sec.chaton.p028io.entry;

import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class Entry {
    public String value;

    public String toString() throws SecurityException {
        StringBuilder sb = new StringBuilder();
        Field[] fields = getClass().getFields();
        for (int i = 0; i < fields.length; i++) {
            sb.append(fields[i].getName());
            sb.append(":");
            try {
                sb.append(fields[i].get(this));
            } catch (Exception e) {
                sb.append("occur Exception");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
