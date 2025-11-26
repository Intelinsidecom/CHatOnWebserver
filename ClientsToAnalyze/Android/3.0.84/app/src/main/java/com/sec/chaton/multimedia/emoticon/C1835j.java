package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: EmoticonStringBuilder.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.j */
/* loaded from: classes.dex */
public class C1835j {
    /* renamed from: a */
    public static CharSequence m7508a(Context context, String str, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = Pattern.compile("\\[.*?\\]").matcher(str);
        while (matcher.find()) {
            int iM7503a = C1833h.m7503a(matcher.group());
            if (iM7503a != -1) {
                spannableStringBuilder.setSpan(m7507a(context, iM7503a, i), matcher.start(), matcher.end(), 33);
            }
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    public static List<String> m7509a(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("\\[.*?\\]").matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group();
            if (C1833h.m7503a(strGroup) != -1) {
                arrayList.add(strGroup);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static CharSequence m7510b(Context context, String str, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int iM7503a = C1833h.m7503a(str);
        if (iM7503a != -1) {
            spannableStringBuilder.setSpan(m7507a(context, iM7503a, i), 0, str.length(), 33);
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    private static ImageSpan m7507a(Context context, int i, int i2) throws Resources.NotFoundException {
        Drawable drawable = context.getResources().getDrawable(i);
        if (i2 >= 0) {
            drawable.setBounds(0, 0, i2, i2);
        } else {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        return new ImageSpan(drawable, 0);
    }
}
