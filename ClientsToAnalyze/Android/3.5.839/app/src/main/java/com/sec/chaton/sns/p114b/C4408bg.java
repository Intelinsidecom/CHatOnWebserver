package com.sec.chaton.sns.p114b;

import android.app.Activity;
import com.p137vk.sdk.VKAccessToken;
import com.p137vk.sdk.VKSdk;
import com.p137vk.sdk.VKUIHelper;
import com.p137vk.sdk.api.VKApi;
import com.p137vk.sdk.api.VKApiConst;
import com.p137vk.sdk.api.VKParameters;
import com.sec.chaton.sns.p113a.C4365b;
import com.sec.chaton.sns.p113a.InterfaceC4366c;

/* compiled from: VKontakteManager.java */
/* renamed from: com.sec.chaton.sns.b.bg */
/* loaded from: classes.dex */
public class C4408bg implements InterfaceC4366c {

    /* renamed from: a */
    final /* synthetic */ C4403bb f15953a;

    /* renamed from: b */
    private int f15954b;

    public C4408bg(C4403bb c4403bb, int i) {
        this.f15953a = c4403bb;
        this.f15954b = i;
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2273a(Object obj) {
        this.f15953a.m16571a("Login Request:" + this.f15954b + " Done.");
        if (obj instanceof VKAccessToken) {
            this.f15953a.f15944f.m16830a(this.f15953a.f15942d, (VKAccessToken) obj);
            VKSdk.initialize(this.f15953a.f15945g, "4172032", (VKAccessToken) obj);
            if (this.f15953a.f15942d instanceof Activity) {
                VKUIHelper.onResume((Activity) this.f15953a.f15942d);
            }
            m16738b();
        }
    }

    /* renamed from: b */
    private void m16738b() {
        VKParameters vKParameters = new VKParameters();
        vKParameters.put(VKApiConst.USER_IDS, this.f15953a.m16735f());
        vKParameters.put("access_token", this.f15953a.m16736g());
        vKParameters.put(VKApiConst.FIELDS, "sex,photo_200_orig,name,contacts,screen_name");
        VKApi.users().get(vKParameters).executeWithListener(new C4409bh(this));
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2272a(C4365b c4365b) {
        this.f15953a.m16572b("Login Request:" + this.f15954b + " Webview Error. " + c4365b.getMessage());
        if (c4365b.m16562a() != -1002) {
            this.f15953a.f15831b.mo16563a(this.f15954b, c4365b.m16562a(), c4365b.getMessage());
        } else {
            this.f15953a.f15831b.mo16563a(this.f15954b, -1002, c4365b.getMessage());
        }
    }

    @Override // com.sec.chaton.sns.p113a.InterfaceC4366c
    /* renamed from: a */
    public void mo2271a() {
        this.f15953a.m16571a("Login Request:" + this.f15954b + " Canceled.");
        this.f15953a.f15831b.mo16563a(this.f15954b, 0, null);
    }
}
