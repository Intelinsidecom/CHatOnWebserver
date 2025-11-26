package com.sec.chaton.chat;

import android.text.TextUtils;
import com.sec.chaton.multimedia.emoticon.C2797i;
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2301u;
import java.io.IOException;
import java.util.List;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bw */
/* loaded from: classes.dex */
class RunnableC1615bw implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f6132a;

    /* renamed from: b */
    final /* synthetic */ boolean f6133b;

    /* renamed from: c */
    final /* synthetic */ EnumC2214ab f6134c;

    /* renamed from: d */
    final /* synthetic */ String f6135d;

    /* renamed from: e */
    final /* synthetic */ ChatFragment f6136e;

    RunnableC1615bw(ChatFragment chatFragment, String str, boolean z, EnumC2214ab enumC2214ab, String str2) {
        this.f6136e = chatFragment;
        this.f6132a = str;
        this.f6133b = z;
        this.f6134c = enumC2214ab;
        this.f6135d = str2;
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        List<String> listM11710a = C2799k.m11710a(this.f6136e.f5624cN, this.f6132a);
        if (this.f6133b && this.f6134c == EnumC2214ab.ANICON && !TextUtils.isEmpty(this.f6135d)) {
            listM11710a.add(this.f6135d);
        }
        if (this.f6136e.f5637ca == EnumC2301u.NORMAL) {
            C2797i.m11705a().m19003a(listM11710a, true);
        } else {
            C2797i.m11706b().m19003a(listM11710a, true);
        }
    }
}
