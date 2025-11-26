package com.sec.chaton.service;

import android.accounts.AccountManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.content.C0096i;
import android.text.TextUtils;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0418c;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p055d.AbstractC1899a;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.p055d.C2095ba;
import com.sec.chaton.p055d.C2104bj;
import com.sec.chaton.p055d.C2132m;
import com.sec.chaton.p055d.p056a.C1907ag;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4863ca;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.spp.push.Config;

/* loaded from: classes.dex */
public class BackGroundRegiService extends Service implements InterfaceC0418c {

    /* renamed from: a */
    private static final String f12400a = BackGroundRegiService.class.getSimpleName();

    /* renamed from: b */
    private int f12401b;

    /* renamed from: c */
    private boolean f12402c;

    /* renamed from: e */
    private AbstractC1899a<?> f12404e;

    /* renamed from: f */
    private C2095ba f12405f;

    /* renamed from: g */
    private C2132m f12406g;

    /* renamed from: h */
    private C2104bj f12407h;

    /* renamed from: i */
    private C1907ag f12408i;

    /* renamed from: j */
    private int f12409j;

    /* renamed from: d */
    private C0416a f12403d = null;

    /* renamed from: k */
    private HandlerC4826ar f12410k = new HandlerC3414a(this);

    /* renamed from: l */
    private Handler f12411l = new HandlerC3415b(this);

    /* renamed from: m */
    private BroadcastReceiver f12412m = new C3416c(this);

    /* renamed from: d */
    static /* synthetic */ int m13270d(BackGroundRegiService backGroundRegiService) {
        int i = backGroundRegiService.f12409j + 1;
        backGroundRegiService.f12409j = i;
        return i;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 2;
        }
        this.f12401b = intent.getIntExtra("request_type", -1);
        this.f12402c = intent.getBooleanExtra("request_on_chaton", false);
        if (C4904y.f17873c) {
            C4904y.m18641c("onStartCommand, startId : " + i2 + " type : " + this.f12401b + " mOnChatON : " + this.f12402c, f12400a);
        }
        m13277a(this.f12401b);
        return 1;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (C4904y.f17873c) {
            C4904y.m18641c("onCreate ", f12400a);
        }
        if (C2349a.m10301a("chatonv_feature") && C2948h.m12190a().m12192a(GlobalApplication.m18732r(), EnumC2949i.ChatONV)) {
            this.f12403d = new C0416a();
            this.f12403d.m1491a(this, this);
        }
        this.f12405f = new C2095ba(this.f12411l);
        this.f12407h = new C2104bj(this.f12411l);
        this.f12406g = new C2132m(this.f12411l);
        this.f12404e = C2093az.m9337a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_sso_receive_code");
        registerReceiver(this.f12412m, intentFilter);
        this.f12409j = 0;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (C4904y.f17873c) {
            C4904y.m18641c("onDestroy ", f12400a);
        }
        unregisterReceiver(this.f12412m);
        if (this.f12401b == 1) {
            GlobalApplication.f8361h = false;
            if (C4859bx.m18374a().equals(EnumC4863ca.OTHER)) {
                Intent intent = new Intent("back_auto_regi");
                intent.putExtra("mode", "end");
                C0096i.m358a(GlobalApplication.m18732r()).m363a(intent);
            }
        }
        if (C2349a.m10301a("chatonv_feature") && this.f12403d != null) {
            this.f12403d.m1491a(this, (InterfaceC0418c) null);
        }
    }

    /* renamed from: a */
    public void m13277a(int i) {
        if (i == -1) {
            if (C4904y.f17872b) {
                C4904y.m18639b("type is not valid", f12400a);
                return;
            }
            return;
        }
        if (i == 0) {
            if (C2349a.m10301a("chatonv_feature") && C4859bx.m18386a(GlobalApplication.m18732r())) {
                if (this.f12403d.m1495d(GlobalApplication.m18732r())) {
                    if (C4859bx.m18388b(GlobalApplication.m18732r(), this.f12403d) != 0) {
                        this.f12404e.mo9079b(this.f12410k);
                        this.f12410k.m18263a(1002, 30000);
                        return;
                    }
                    return;
                }
                this.f12404e.mo9079b(this.f12410k);
                this.f12410k.m18263a(1002, 30000);
                return;
            }
            this.f12404e.mo9079b(this.f12410k);
            this.f12410k.m18263a(1002, 30000);
            return;
        }
        if (i == 1) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13265b(boolean z) {
        if (m13266b()) {
            String packageName = GlobalApplication.m18732r().getPackageName();
            if (C4904y.f17872b) {
                C4904y.m18639b("packageName : " + packageName, f12400a);
            }
            Intent intent = new Intent("com.msc.action.ACCESSTOKEN_V02_REQUEST");
            intent.putExtra(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, "fs24s8z0hh");
            intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
            intent.putExtra("mypackage", packageName);
            intent.putExtra("OSP_VER", "OSP_02");
            intent.putExtra("MODE", "BACKGROUND");
            intent.putExtra("additional", new String[]{"user_id", "email_id", "mcc", "api_server_url"});
            if (z) {
                intent.putExtra("expired_access_token", C4809aa.m18104a().m18121a("samsung_account_token", ""));
            }
            sendBroadcast(intent);
            return;
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("it was NOT supported auto SSO Registration", f12400a);
        }
        m13269c(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m13266b() throws PackageManager.NameNotFoundException {
        String strM18389b = C4859bx.m18389b(GlobalApplication.m18732r());
        int iM18394c = C4859bx.m18394c(GlobalApplication.m18732r());
        boolean z = iM18394c >= 13001;
        if (C4904y.f17872b) {
            C4904y.m18639b("accountEmail : " + strM18389b + " ssoVer : " + iM18394c + " ssoSuppoted : " + z, f12400a);
        }
        return !TextUtils.isEmpty(strM18389b) && z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m13269c(boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b(" finishRegiService : " + z, f12400a);
        }
        if (z) {
            C4859bx.m18382a(EnumC4863ca.SUCCESS);
        } else {
            C4859bx.m18382a(EnumC4863ca.FAIL);
        }
        Intent intent = new Intent("back_auto_regi");
        intent.putExtra("mode", "end");
        C0096i.m358a(GlobalApplication.m18732r()).m363a(intent);
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m13267c() {
        if (AccountManager.get(GlobalApplication.m18732r()).getAccountsByType(Config.CHATON_PACKAGE_NAME).length <= 0 && C4809aa.m18104a().m18129b("uid")) {
            C4859bx.m18385a(C4809aa.m18104a().m18121a("samsung_account_email", ""), C4809aa.m18104a().m18121a("uid", ""), false);
        }
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a */
    public void mo1508a(boolean z, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onReceiveCreateAccount : " + z + " msg : " + str, f12400a);
        }
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a_ */
    public void mo1509a_(boolean z) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onReceiveRemoveAccount : " + z, f12400a);
        }
        this.f12404e.mo9079b(this.f12410k);
        this.f12410k.m18263a(1002, 30000);
    }
}
