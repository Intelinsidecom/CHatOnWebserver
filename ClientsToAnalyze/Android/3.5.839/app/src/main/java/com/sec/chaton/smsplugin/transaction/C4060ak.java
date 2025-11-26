package com.sec.chaton.smsplugin.transaction;

import android.os.Bundle;
import android.os.Messenger;

/* compiled from: TransactionBundle.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.ak */
/* loaded from: classes.dex */
public class C4060ak {

    /* renamed from: a */
    private final Bundle f14643a;

    private C4060ak(int i) {
        this.f14643a = new Bundle();
        this.f14643a.putInt("type", i);
    }

    public C4060ak(int i, String str) {
        this(i);
        this.f14643a.putString("uri", str);
    }

    public C4060ak(Bundle bundle) {
        this.f14643a = bundle;
    }

    /* renamed from: a */
    public int m15622a() {
        return this.f14643a.getInt("type");
    }

    /* renamed from: b */
    public String m15625b() {
        return this.f14643a.getString("uri");
    }

    /* renamed from: c */
    public byte[] m15626c() {
        return this.f14643a.getByteArray("mms-push-data");
    }

    /* renamed from: d */
    public String m15627d() {
        return this.f14643a.getString("mmsc-url");
    }

    /* renamed from: e */
    public String m15628e() {
        return this.f14643a.getString("proxy-address");
    }

    /* renamed from: f */
    public int m15629f() {
        return this.f14643a.getInt("proxy-port");
    }

    /* renamed from: g */
    public int m15630g() {
        return this.f14643a.getInt("extra_bg_token", -1);
    }

    /* renamed from: h */
    public Messenger m15631h() {
        return (Messenger) this.f14643a.getParcelable("extra_bg_cb_messenger");
    }

    /* renamed from: a */
    public void m15623a(int i) {
        this.f14643a.putInt("extra_bg_token", i);
    }

    /* renamed from: a */
    public void m15624a(Messenger messenger) {
        this.f14643a.putParcelable("extra_bg_cb_messenger", messenger);
    }

    public String toString() {
        return "transactionType: " + m15622a() + " uri: " + m15625b() + " pushData: " + m15626c() + " mmscUrl: " + m15627d() + " proxyAddress: " + m15628e() + " proxyPort: " + m15629f();
    }
}
