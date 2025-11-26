package com.sec.chaton.chat.translate;

import android.text.TextUtils;
import java.text.BreakIterator;
import java.util.Locale;

/* compiled from: SentenceBreaker.java */
/* renamed from: com.sec.chaton.chat.translate.g */
/* loaded from: classes.dex */
public class C1854g {

    /* renamed from: a */
    private InterfaceC1855h f7050a;

    /* renamed from: b */
    private int f7051b = 1900;

    /* renamed from: a */
    public void m9043a(InterfaceC1855h interfaceC1855h) {
        this.f7050a = interfaceC1855h;
    }

    /* renamed from: a */
    public void m9042a(int i) {
        int i2 = i < 0 ? 0 : i;
        this.f7051b = i2 <= 10000 ? i2 : 10000;
    }

    /* renamed from: a */
    public void m9044a(Locale locale, String str) {
        int length;
        if (str == null) {
            throw new IllegalArgumentException("Source is null!");
        }
        if (this.f7050a == null) {
            throw new IllegalArgumentException("SentenceListener is null!");
        }
        if ("".equals(str)) {
            throw new IllegalArgumentException("Source is empty!");
        }
        BreakIterator sentenceInstance = BreakIterator.getSentenceInstance(locale);
        sentenceInstance.setText(str);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int iFirst = sentenceInstance.first();
        boolean z = false;
        int next = sentenceInstance.next();
        StringBuilder sb3 = sb2;
        StringBuilder sb4 = sb;
        while (true) {
            int i = next;
            if (i == -1) {
                break;
            }
            String strSubstring = str.substring(iFirst, i);
            if (!TextUtils.isEmpty(strSubstring) && strSubstring.length() > this.f7051b) {
                break;
            }
            z = true;
            if (!"".equals(strSubstring)) {
                sb3.append(strSubstring);
                if (sb3.length() >= this.f7051b) {
                    try {
                        try {
                            this.f7050a.mo9041a(sb4.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new IllegalArgumentException("SentenceListener error!");
                        }
                    } finally {
                        new StringBuilder().append(strSubstring);
                        new StringBuilder();
                    }
                } else {
                    sb4.append(strSubstring);
                }
            }
            next = sentenceInstance.next();
            iFirst = i;
        }
        if (sb4.length() > 0) {
            try {
                this.f7050a.mo9041a(sb4.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new IllegalArgumentException("SentenceListener error!!");
            }
        }
        if (!z) {
            int i2 = this.f7051b;
            if (this.f7051b == 0) {
                throw new IllegalArgumentException("threshold is zero!");
            }
            int i3 = i2;
            int i4 = 0;
            int i5 = iFirst;
            while (i4 < Math.ceil(str.length() / this.f7051b)) {
                this.f7050a.mo9041a(str.substring(i5, i3));
                if ((str.length() - i3) / this.f7051b > 0) {
                    length = this.f7051b;
                } else {
                    length = (str.length() - i3) % this.f7051b;
                }
                int i6 = length + i3;
                i4++;
                i5 = i3;
                i3 = i6;
            }
        }
    }
}
