package com.sec.chaton.chat.p024b;

import java.text.BreakIterator;
import java.util.Locale;

/* compiled from: SentenceBreaker.java */
/* renamed from: com.sec.chaton.chat.b.g */
/* loaded from: classes.dex */
public class C0956g {

    /* renamed from: a */
    private InterfaceC0957h f3939a;

    /* renamed from: b */
    private int f3940b = 1900;

    /* renamed from: a */
    public void m5161a(InterfaceC0957h interfaceC0957h) {
        this.f3939a = interfaceC0957h;
    }

    /* renamed from: a */
    public void m5160a(int i) {
        int i2 = i < 0 ? 0 : i;
        this.f3940b = i2 <= 10000 ? i2 : 10000;
    }

    /* JADX WARN: Finally extract failed */
    /* renamed from: a */
    public void m5162a(Locale locale, String str) {
        int length;
        if (str == null) {
            throw new IllegalArgumentException("Source is null!");
        }
        if (this.f3939a == null) {
            throw new IllegalArgumentException("SentenceListener is null!");
        }
        if ("".equals(str)) {
            throw new IllegalArgumentException("Source is empty!");
        }
        BreakIterator sentenceInstance = BreakIterator.getSentenceInstance(locale);
        sentenceInstance.setText(str);
        StringBuilder sb = new StringBuilder();
        int iFirst = sentenceInstance.first();
        boolean z = false;
        int next = sentenceInstance.next();
        StringBuilder sb2 = sb;
        while (true) {
            int i = next;
            if (i == -1 || i - iFirst > this.f3940b) {
                break;
            }
            z = true;
            String strSubstring = str.substring(iFirst, i);
            if (!"".equals(strSubstring)) {
                sb2.append(strSubstring);
                if (sb2.length() >= this.f3940b) {
                    try {
                        try {
                            this.f3939a.mo5159a(sb2.toString());
                            sb2 = new StringBuilder();
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw new IllegalArgumentException("SentenceListener error!");
                        }
                    } catch (Throwable th) {
                        new StringBuilder();
                        throw th;
                    }
                } else {
                    continue;
                }
            }
            next = sentenceInstance.next();
            iFirst = i;
        }
        if (sb2.length() > 0) {
            try {
                this.f3939a.mo5159a(sb2.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                throw new IllegalArgumentException("SentenceListener error!!");
            }
        }
        if (!z) {
            int i2 = this.f3940b;
            if (this.f3940b == 0) {
                throw new IllegalArgumentException("threshold is zero!");
            }
            int i3 = i2;
            int i4 = 0;
            while (i4 < Math.ceil(str.length() / this.f3940b)) {
                this.f3939a.mo5159a(str.substring(iFirst, i3));
                if ((str.length() - i3) / this.f3940b > 0) {
                    length = this.f3940b;
                } else {
                    length = (str.length() - i3) % this.f3940b;
                }
                int i5 = length + i3;
                i4++;
                iFirst = i3;
                i3 = i5;
            }
        }
    }
}
