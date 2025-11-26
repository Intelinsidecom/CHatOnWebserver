package com.sec.chaton.service;

import android.accounts.AccountManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C1757q;
import com.sec.chaton.p020c.C0816a;
import com.sec.chaton.p025d.AbstractC1144a;
import com.sec.chaton.p025d.C1302ao;
import com.sec.chaton.p025d.C1303ap;
import com.sec.chaton.p025d.C1307at;
import com.sec.chaton.p025d.C1334l;
import com.sec.chaton.p025d.p026a.C1156ak;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.util.EnumC3215cc;
import com.sec.chaton.util.HandlerC3176ar;
import org.jboss.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: classes.dex */
public class BackGroundRegiService extends Service implements InterfaceC0047c {

    /* renamed from: a */
    private static final String f8872a = BackGroundRegiService.class.getSimpleName();

    /* renamed from: b */
    private int f8873b;

    /* renamed from: c */
    private boolean f8874c;

    /* renamed from: e */
    private AbstractC1144a<?> f8876e;

    /* renamed from: f */
    private C1303ap f8877f;

    /* renamed from: g */
    private C1334l f8878g;

    /* renamed from: h */
    private C1307at f8879h;

    /* renamed from: i */
    private C1156ak f8880i;

    /* renamed from: j */
    private int f8881j;

    /* renamed from: d */
    private C0045a f8875d = null;

    /* renamed from: k */
    private HandlerC3176ar f8882k = new HandlerC2386a(this);

    /* renamed from: l */
    private Handler f8883l = new HandlerC2387b(this);

    /* renamed from: m */
    private BroadcastReceiver f8884m = new C2388c(this);

    /* renamed from: d */
    static /* synthetic */ int m8886d(BackGroundRegiService backGroundRegiService) {
        int i = backGroundRegiService.f8881j + 1;
        backGroundRegiService.f8881j = i;
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
        this.f8873b = intent.getIntExtra("request_type", -1);
        this.f8874c = intent.getBooleanExtra("request_on_chaton", false);
        if (C3250y.f11735c) {
            C3250y.m11453c("onStartCommand, startId : " + i2 + " type : " + this.f8873b + " mOnChatON : " + this.f8874c, f8872a);
        }
        m8893a(this.f8873b);
        return 1;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (C3250y.f11735c) {
            C3250y.m11453c("onCreate ", f8872a);
        }
        if (C1493a.m6463a("chatonv_feature") && C1954g.m7916a().m7918a(GlobalApplication.m11493l(), EnumC1955h.ChatONV)) {
            this.f8875d = new C0045a();
            this.f8875d.m51a(this, this);
        }
        this.f8877f = new C1303ap(this.f8883l);
        this.f8879h = new C1307at(this.f8883l);
        this.f8878g = new C1334l(this.f8883l);
        this.f8876e = C1302ao.m5594a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_sso_receive_code");
        registerReceiver(this.f8884m, intentFilter);
        this.f8881j = 0;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (C3250y.f11735c) {
            C3250y.m11453c("onDestroy ", f8872a);
        }
        unregisterReceiver(this.f8884m);
        if (this.f8873b == 1) {
            GlobalApplication.f5516g = false;
            if (C3214cb.m11248a().equals(EnumC3215cc.OTHER)) {
                Intent intent = new Intent("back_auto_regi");
                intent.putExtra(RtspHeaders.Values.MODE, "end");
                LocalBroadcastManager.getInstance(GlobalApplication.m11493l()).sendBroadcast(intent);
            }
        }
        if (C1493a.m6463a("chatonv_feature") && this.f8875d != null) {
            this.f8875d.m51a(this, (InterfaceC0047c) null);
        }
    }

    /* renamed from: a */
    public void m8893a(int i) {
        if (i == -1) {
            if (C3250y.f11734b) {
                C3250y.m11450b("type is not valid", f8872a);
                return;
            }
            return;
        }
        if (i == 0) {
            if (C1493a.m6463a("chatonv_feature") && C3214cb.m11256a(GlobalApplication.m11493l())) {
                if (this.f8875d.m55d(GlobalApplication.m11493l())) {
                    C3214cb.m11260b(GlobalApplication.m11493l(), this.f8875d);
                    return;
                } else {
                    this.f8876e.mo5481b(this.f8882k);
                    this.f8882k.m11091a(1002, 30000);
                    return;
                }
            }
            this.f8876e.mo5481b(this.f8882k);
            this.f8882k.m11091a(1002, 30000);
            return;
        }
        if (i == 1) {
            Intent intent = new Intent("back_auto_regi");
            intent.putExtra(RtspHeaders.Values.MODE, "start");
            LocalBroadcastManager.getInstance(GlobalApplication.m11493l()).sendBroadcast(intent);
            this.f8878g.m5775a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8879a(boolean z) throws Throwable {
        if (m8883b()) {
            String packageName = GlobalApplication.m11493l().getPackageName();
            if (C3250y.f11734b) {
                C3250y.m11450b("packageName : " + packageName, f8872a);
            }
            Intent intent = new Intent("com.msc.action.ACCESSTOKEN_V02_REQUEST");
            intent.putExtra("client_id", "fs24s8z0hh");
            intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
            intent.putExtra("mypackage", packageName);
            intent.putExtra("OSP_VER", "OSP_02");
            intent.putExtra("MODE", "BACKGROUND");
            intent.putExtra("additional", new String[]{"user_id", "email_id", "mcc", "api_server_url"});
            if (z) {
                intent.putExtra("expired_access_token", C3159aa.m10962a().m10979a("samsung_account_token", ""));
            }
            sendBroadcast(intent);
            return;
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("it was NOT supported auto SSO Registration", f8872a);
        }
        m8882b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m8883b() throws PackageManager.NameNotFoundException {
        String strM11257b = C3214cb.m11257b(GlobalApplication.m11493l());
        int iM11262c = C3214cb.m11262c(GlobalApplication.m11493l());
        boolean zM11255a = C3214cb.m11255a(iM11262c);
        if (C3250y.f11734b) {
            C3250y.m11450b("accountEmail : " + strM11257b + " ssoVer : " + iM11262c + " ssoSuppoted : " + zM11255a, f8872a);
        }
        return !TextUtils.isEmpty(strM11257b) && zM11255a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8882b(boolean z) throws Throwable {
        if (C3250y.f11734b) {
            C3250y.m11450b(" finishRegiService : " + z, f8872a);
        }
        if (z) {
            C0816a.m4368d();
            C3214cb.m11252a(EnumC3215cc.SUCCESS);
            C3159aa.m10962a().m10983b("first_time_after_regi", (Boolean) true);
            C1757q.m7255e();
        } else {
            C3214cb.m11252a(EnumC3215cc.FAIL);
        }
        Intent intent = new Intent("back_auto_regi");
        intent.putExtra(RtspHeaders.Values.MODE, "end");
        LocalBroadcastManager.getInstance(GlobalApplication.m11493l()).sendBroadcast(intent);
        stopSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8884c() {
        if (AccountManager.get(GlobalApplication.m11493l()).getAccountsByType("com.sec.chaton").length <= 0 && C3159aa.m10962a().m10987b("uid")) {
            C3214cb.m11254a(C3159aa.m10962a().m10979a("samsung_account_email", ""), C3159aa.m10962a().m10979a("uid", ""), false);
        }
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("onReceiveCreateAccount : " + z, f8872a);
        }
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
        if (C3250y.f11734b) {
            C3250y.m11450b("onReceiveRemoveAccount : " + z, f8872a);
        }
        if (!z) {
            C3159aa.m10963a("back_chatonv_deregi_fail", (Boolean) true);
        }
        this.f8876e.mo5481b(this.f8882k);
        this.f8882k.m11091a(1002, 30000);
    }
}
