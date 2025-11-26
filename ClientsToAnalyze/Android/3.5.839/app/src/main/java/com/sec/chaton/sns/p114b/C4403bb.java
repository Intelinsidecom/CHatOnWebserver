package com.sec.chaton.sns.p114b;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.p137vk.sdk.VKAccessToken;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.p137vk.sdk.VKScope;
import com.p137vk.sdk.VKSdk;
import com.p137vk.sdk.VKSdkListener;
import com.p137vk.sdk.VKUIHelper;
import com.p137vk.sdk.api.VKApi;
import com.p137vk.sdk.api.VKApiConst;
import com.p137vk.sdk.api.VKError;
import com.p137vk.sdk.api.VKParameters;
import com.p137vk.sdk.util.VKStringJoiner;
import com.sec.chaton.p051c.C1428b;
import com.sec.chaton.sns.C4444d;
import com.sec.chaton.sns.p113a.AbstractC4369f;
import com.sec.chaton.sns.p113a.C4368e;
import com.sec.chaton.sns.p113a.InterfaceC4367d;
import com.sec.chaton.sns.p115ui.DialogC4464ar;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4904y;
import com.sec.spp.push.dlc.api.DlcApi;
import java.net.URLEncoder;

/* compiled from: VKontakteManager.java */
/* renamed from: com.sec.chaton.sns.b.bb */
/* loaded from: classes.dex */
public class C4403bb extends AbstractC4369f {

    /* renamed from: c */
    public static final String f15941c = C4403bb.class.getSimpleName();

    /* renamed from: d */
    public Context f15942d;

    /* renamed from: e */
    private InterfaceC4367d f15943e;

    /* renamed from: f */
    private C4444d f15944f;

    /* renamed from: g */
    private VKSdkListener f15945g;

    public C4403bb(Context context, InterfaceC4367d interfaceC4367d) {
        super(context, interfaceC4367d, f15941c);
        this.f15945g = new C4404bc(this);
        this.f15942d = context;
        this.f15943e = interfaceC4367d;
        this.f15944f = new C4444d(this.f15942d);
        if (!this.f15944f.m16832a()) {
            VKSdk.initialize(this.f15945g, "4172032", this.f15944f.m16833b());
            if (this.f15942d instanceof Activity) {
                VKUIHelper.onResume((Activity) this.f15942d);
            }
        }
    }

    /* renamed from: b */
    public boolean m16731b() {
        return (this.f15944f == null || this.f15944f.m16832a()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16719a(VKError vKError, int i) {
        if (vKError.errorCode == -105) {
            this.f15943e.mo16563a(i, -1003, vKError.errorMessage);
            return;
        }
        if (vKError.errorCode == -104) {
            this.f15943e.mo16563a(i, -1008, vKError.errorMessage);
            return;
        }
        if (vKError.errorCode == -101 || vKError.errorCode == -103) {
            if (vKError.errorCode == -101 && vKError.apiError != null && vKError.apiError.errorCode == 5) {
                this.f15943e.mo16563a(i, DlcApi.RC_SVC_NOT_CONNECTED, "NeedUserLoginAgain");
                return;
            } else {
                this.f15943e.mo16563a(i, -1004, vKError.errorMessage);
                return;
            }
        }
        if (vKError.errorCode == -102) {
            this.f15943e.mo16563a(i, 0, vKError.errorMessage);
        } else {
            this.f15943e.mo16563a(i, DlcApi.RC_SVC_NOT_CONNECTED, vKError.errorMessage);
        }
    }

    /* renamed from: c */
    public static String m16724c(String str) {
        return C1428b.f5089E + "?" + VKOpenAuthActivity.VK_EXTRA_CLIENT_ID + "=" + str + "&diaplay=mobile&" + VKOpenAuthActivity.VK_EXTRA_SCOPE + "=" + m16723c() + "&redirect_url=" + URLEncoder.encode(C1428b.f5090F) + "&response_type=token&v=" + URLEncoder.encode(C1428b.f5091G);
    }

    /* renamed from: c */
    public static String m16723c() {
        return VKStringJoiner.join(new String[]{VKScope.NOTIFY, VKScope.FRIENDS, VKScope.PHOTOS, "audio", "video", VKScope.DOCS, VKScope.NOTES, VKScope.PAGES, "status", VKScope.WALL, VKScope.GROUPS, VKScope.MESSAGES, VKScope.OFFLINE, VKScope.NOTIFICATIONS}, ",");
    }

    /* renamed from: a */
    public void m16727a(int i) {
        new DialogC4464ar(this.f15942d, m16724c("4172032"), new C4408bg(this, i)).show();
    }

    /* renamed from: d */
    public String m16733d() {
        return this.f15944f.m16836d(this.f15942d);
    }

    /* renamed from: e */
    public String m16734e() {
        return this.f15944f.m16837e(this.f15942d);
    }

    /* renamed from: f */
    public String m16735f() {
        return this.f15944f.m16834b(this.f15942d);
    }

    /* renamed from: g */
    public String m16736g() {
        VKAccessToken vKAccessTokenM16833b = this.f15944f.m16833b();
        if (vKAccessTokenM16833b == null) {
            return null;
        }
        return vKAccessTokenM16833b.accessToken;
    }

    /* renamed from: b */
    public void m16730b(int i) {
        if (m16726h()) {
            this.f15943e.mo16563a(i, DlcApi.RC_SVC_NOT_CONNECTED, "NeedUserLoginAgain");
            return;
        }
        Log.d(f15941c, "getFriends: " + i);
        VKParameters vKParameters = new VKParameters();
        vKParameters.put("user_id", m16735f());
        vKParameters.put(VKApiConst.FIELDS, "first_name,last_name,sex,contacts,uid,screen_name,photo_200");
        vKParameters.put("access_token", m16736g());
        VKApi.friends().get(vKParameters).executeWithListener(new C4405bd(this, i));
    }

    /* renamed from: h */
    private boolean m16726h() {
        C4904y.m18639b("VKmgr checkAcessTokenValid()", f15941c);
        VKAccessToken vKAccessTokenM16833b = this.f15944f.m16833b();
        if (vKAccessTokenM16833b != null) {
            return vKAccessTokenM16833b.isExpired();
        }
        C4904y.m18639b("VKmgr checkAcessTokenValid() acess token null -> returning false", f15941c);
        return true;
    }

    /* renamed from: c */
    public void m16732c(int i) {
        Log.d(f15941c, "getFriendsIDs: " + i);
        VKParameters vKParameters = new VKParameters();
        vKParameters.put("user_id", m16735f());
        vKParameters.put(VKApiConst.FIELDS, "uid");
        vKParameters.put("access_token", m16736g());
        VKApi.friends().get(vKParameters).executeWithListener(new C4406be(this, i));
    }

    /* renamed from: a */
    public void m16728a(int i, String str, String str2) {
        VKParameters vKParameters = new VKParameters();
        if (str == null) {
            str = m16735f();
        }
        vKParameters.put(VKApiConst.OWNER_ID, str);
        vKParameters.put(VKApiConst.MESSAGE, str2);
        vKParameters.put("access_token", m16736g());
        VKApi.wall().post(vKParameters).executeWithListener(new C4407bf(this, i));
    }

    /* renamed from: a */
    public void m16729a(Context context, int i) {
        C4444d.m16828a(context);
        C4368e.m16564a(this.f15942d).m16565a(C4368e.f15820f, false);
        this.f15943e.mo16563a(i, -1, null);
    }

    /* renamed from: a */
    public static void m16716a(Context context) {
        C4444d.m16828a(context);
        C4368e.m16564a(context).m16565a(C4368e.f15820f, false);
        C4809aa.m18108a("register_vk_sns_type", "");
    }
}
