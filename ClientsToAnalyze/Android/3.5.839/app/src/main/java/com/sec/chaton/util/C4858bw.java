package com.sec.chaton.util;

import java.util.regex.Pattern;

/* compiled from: RegexValidation.java */
/* renamed from: com.sec.chaton.util.bw */
/* loaded from: classes.dex */
public class C4858bw {
    /* renamed from: a */
    public static boolean m18368a(String str) {
        return Pattern.compile("^[0-9A-Za-z]+([-_.+]?[0-9a-zA-Z])*@[_0-9A-Za-z]+(\\.[_0-9A-Za-z]+){1,2}$").matcher(str).find();
    }
}
