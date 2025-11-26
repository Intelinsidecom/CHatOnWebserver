package com.p137vk.sdk.util;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class VKStringJoiner {
    public static String join(String[] strArr, String str) {
        return join(Arrays.asList(strArr), str);
    }

    public static String join(Collection<?> collection, String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            int i2 = i + 1;
            if (i < collection.size() - 1) {
                sb.append(str);
            }
            i = i2;
        }
        return sb.toString();
    }

    public static String joinParams(Map<String, Object> map, boolean z) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object[] objArr = new Object[2];
            objArr[0] = entry.getKey();
            objArr[1] = z ? Uri.encode(String.valueOf(entry.getValue())) : String.valueOf(entry.getValue());
            arrayList.add(String.format("%s=%s", objArr));
        }
        return join(arrayList, "&");
    }

    public static String joinParams(Map<String, Object> map) {
        return joinParams(map, false);
    }

    public static String joinUriParams(Map<String, Object> map) {
        return joinParams(map, true);
    }
}
