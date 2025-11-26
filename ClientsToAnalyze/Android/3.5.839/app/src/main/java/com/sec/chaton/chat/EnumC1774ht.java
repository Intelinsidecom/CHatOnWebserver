package com.sec.chaton.chat;

import android.text.TextUtils;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.util.C4904y;

/* compiled from: PushUserType.java */
/* renamed from: com.sec.chaton.chat.ht */
/* loaded from: classes.dex */
public enum EnumC1774ht {
    PUT_UNKNNOWN(-1),
    PUT_LIVE_CHAT(1),
    PUT_LIVE_CONTENTS(2);


    /* renamed from: e */
    static final String f6656e = EnumC1774ht.class.getSimpleName();

    /* renamed from: d */
    int f6658d;

    EnumC1774ht(int i) {
        this.f6658d = -1;
        this.f6658d = i;
    }

    /* renamed from: a */
    public int m8785a() {
        return this.f6658d;
    }

    /* renamed from: a */
    public static EnumC1774ht m8782a(String str) throws NumberFormatException {
        int i = -1;
        try {
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (NumberFormatException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f6656e);
            }
        }
        return m8781a(i);
    }

    /* renamed from: a */
    public static EnumC1774ht m8781a(int i) {
        switch (i) {
            case 1:
                return PUT_LIVE_CHAT;
            case 2:
                return PUT_LIVE_CONTENTS;
            default:
                return PUT_UNKNNOWN;
        }
    }

    /* renamed from: b */
    public static EnumC2301u m8784b(String str) throws NumberFormatException {
        int i = -1;
        try {
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (NumberFormatException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, f6656e);
            }
        }
        return m8783b(i);
    }

    /* renamed from: b */
    public static EnumC2301u m8783b(int i) {
        return m8781a(i).m8786b();
    }

    /* renamed from: b */
    public EnumC2301u m8786b() {
        switch (this) {
            case PUT_LIVE_CHAT:
            case PUT_LIVE_CONTENTS:
                return EnumC2301u.LIVE;
            default:
                return EnumC2301u.NORMAL;
        }
    }
}
