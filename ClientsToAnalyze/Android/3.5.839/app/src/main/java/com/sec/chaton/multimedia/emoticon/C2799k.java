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
/* renamed from: com.sec.chaton.multimedia.emoticon.k */
/* loaded from: classes.dex */
public class C2799k {
    /* renamed from: a */
    public static CharSequence m11709a(Context context, String str, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = Pattern.compile("\\[.*?\\]").matcher(str);
        while (matcher.find()) {
            int iM11704a = C2797i.m11704a(matcher.group());
            if (iM11704a != -1) {
                spannableStringBuilder.setSpan(m11708a(context, iM11704a, i), matcher.start(), matcher.end(), 33);
            }
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    public static List<String> m11710a(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile("\\[.*?\\]").matcher(str);
        while (matcher.find()) {
            String strGroup = matcher.group();
            if (C2797i.m11704a(strGroup) != -1) {
                arrayList.add(strGroup);
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static CharSequence m11712b(Context context, String str, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int iM11704a = C2797i.m11704a(str);
        if (iM11704a != -1) {
            spannableStringBuilder.setSpan(m11708a(context, iM11704a, i), 0, str.length(), 33);
        }
        return spannableStringBuilder;
    }

    /* renamed from: a */
    public static boolean m11711a(String str) {
        Matcher matcher = Pattern.compile("\\[.*?\\]").matcher(str);
        if (matcher.find()) {
            String strGroup = matcher.group();
            if (C2797i.m11704a(strGroup) != -1 && strGroup.length() == str.trim().length()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private static ImageSpan m11708a(Context context, int i, int i2) throws Resources.NotFoundException {
        Drawable drawable = context.getResources().getDrawable(i);
        if (i2 >= 0) {
            drawable.setBounds(0, 0, i2, i2);
        } else {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
        return new ImageSpan(drawable, 0);
    }
}
