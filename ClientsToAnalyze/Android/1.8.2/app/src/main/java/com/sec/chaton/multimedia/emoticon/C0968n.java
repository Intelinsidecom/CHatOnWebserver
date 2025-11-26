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
/* renamed from: com.sec.chaton.multimedia.emoticon.n */
/* loaded from: classes.dex */
public class C0968n {
    /* renamed from: a */
    public static CharSequence m3825a(Context context, String str, int i) {
        if (str == null) {
            str = new String("");
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = Pattern.compile("\\[.*?\\]").matcher(str);
        while (matcher.find()) {
            int iM3818a = C0962h.m3818a(matcher.group());
            if (iM3818a != -1) {
                spannableStringBuilder.setSpan(m3824a(context, iM3818a, i), matcher.start(), matcher.end(), 33);
            }
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    public static String m3826a(Context context, String str, String str2) {
        return Pattern.compile("\\[.*?\\]").matcher(str).replaceAll(str2);
    }

    /* renamed from: a */
    public static List m3827a(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("\\[.*?\\]").matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group();
            if (C0962h.m3818a(strGroup) != -1) {
                arrayList.add(strGroup);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static CharSequence m3828b(Context context, String str, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int iM3818a = C0962h.m3818a(str);
        if (iM3818a != -1) {
            spannableStringBuilder.setSpan(m3824a(context, iM3818a, i), 0, str.length(), 33);
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    private static ImageSpan m3824a(Context context, int i, int i2) throws Resources.NotFoundException {
        Drawable drawable = context.getResources().getDrawable(i);
        if (i2 >= 0) {
            drawable.setBounds(0, 0, i2, i2);
        } else {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        return new ImageSpan(drawable, 0);
    }
}
