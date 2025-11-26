package com.sec.chaton.settings.tellfriends;

import android.app.Activity;
import android.content.Intent;
import com.sec.chaton.facebook.C0725f;
import com.sec.chaton.facebook.InterfaceC0736q;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SnsHelperFacebook.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bb */
/* loaded from: classes.dex */
public class C1374bb extends AbstractC1367av {

    /* renamed from: a */
    private static final String f5207a = C1374bb.class.getSimpleName();

    /* renamed from: b */
    private C0725f f5208b;

    /* renamed from: c */
    private InterfaceC0736q f5209c = new C1375bc(this);

    /* renamed from: d */
    private InterfaceC1368aw f5210d;

    /* renamed from: e */
    private InterfaceC1371az f5211e;

    /* renamed from: f */
    private InterfaceC1370ay f5212f;

    /* renamed from: g */
    private InterfaceC1369ax f5213g;

    public C1374bb(Activity activity) {
        this.f5208b = new C0725f(activity, this.f5209c);
    }

    /* renamed from: a */
    public void m5119a() {
        this.f5208b.m3225d();
    }

    /* renamed from: a */
    public void m5120a(InterfaceC1368aw interfaceC1368aw) {
        this.f5210d = interfaceC1368aw;
        this.f5208b.m3223c(0);
    }

    /* renamed from: a */
    public void m5123a(String str, String str2, InterfaceC1371az interfaceC1371az) {
        this.f5211e = interfaceC1371az;
        this.f5208b.m3220a(1, str, str2);
    }

    /* renamed from: a */
    public void m5122a(InterfaceC1370ay interfaceC1370ay) {
        this.f5212f = interfaceC1370ay;
        this.f5208b.m3222b(2);
    }

    /* renamed from: a */
    public void m5121a(InterfaceC1369ax interfaceC1369ax) {
        this.f5213g = interfaceC1369ax;
        this.f5208b.m3217a(3);
    }

    /* renamed from: b */
    public boolean m5124b() {
        return this.f5208b.m3224c();
    }

    /* renamed from: c */
    public String m5125c() {
        return this.f5208b.m3221b();
    }

    @Override // com.sec.chaton.settings.tellfriends.AbstractC1367av
    /* renamed from: a */
    public void mo5102a(int i, int i2, Intent intent) {
        this.f5208b.m3218a(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static C1373ba m5115b(JSONObject jSONObject) throws JSONException {
        String string;
        String string2 = null;
        try {
            string = jSONObject.getString("id");
        } catch (JSONException e) {
            string = null;
        }
        try {
            string2 = jSONObject.getString("name");
        } catch (JSONException e2) {
        }
        String str = "http://graph.facebook.com/" + string + "/picture";
        boolean z = false;
        try {
            z = jSONObject.getBoolean("installed");
        } catch (JSONException e3) {
        }
        return new C1373ba(string, string2, str, z);
    }
}
