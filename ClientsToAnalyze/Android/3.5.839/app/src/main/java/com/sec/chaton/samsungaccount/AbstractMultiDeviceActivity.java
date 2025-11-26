package com.sec.chaton.samsungaccount;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.content.C0096i;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0418c;
import com.p137vk.sdk.VKOpenAuthActivity;
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.UpgradeDialog;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.chat.C1759he;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p051c.C1427a;
import com.sec.chaton.p055d.AbstractC1899a;
import com.sec.chaton.p055d.C2072ae;
import com.sec.chaton.p055d.C2075ah;
import com.sec.chaton.p055d.C2093az;
import com.sec.chaton.p055d.C2095ba;
import com.sec.chaton.p055d.C2104bj;
import com.sec.chaton.p055d.C2122ca;
import com.sec.chaton.p055d.C2127h;
import com.sec.chaton.p055d.C2128i;
import com.sec.chaton.p055d.C2132m;
import com.sec.chaton.p057e.p058a.C2186al;
import com.sec.chaton.p057e.p058a.C2191e;
import com.sec.chaton.p065io.entry.GetVersionNotice;
import com.sec.chaton.p067j.EnumC2463n;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.registration.C3317x;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4859bx;
import com.sec.chaton.util.C4892m;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.util.EnumC4863ca;
import com.sec.chaton.util.HandlerC4826ar;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.spp.push.Config;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public abstract class AbstractMultiDeviceActivity extends BaseActivity implements InterfaceC0418c {

    /* renamed from: n */
    public static boolean f12108n = false;

    /* renamed from: B */
    private String f12110B;

    /* renamed from: J */
    private Context f12118J;

    /* renamed from: K */
    private C2104bj f12119K;

    /* renamed from: L */
    private C2132m f12120L;

    /* renamed from: M */
    private C1759he f12121M;

    /* renamed from: N */
    private C2128i f12122N;

    /* renamed from: O */
    private C2122ca f12123O;

    /* renamed from: P */
    private AbstractC1899a<?> f12124P;

    /* renamed from: Q */
    private C2127h f12125Q;

    /* renamed from: R */
    private C2072ae f12126R;

    /* renamed from: S */
    private String f12127S;

    /* renamed from: T */
    private String f12128T;

    /* renamed from: U */
    private InterfaceC4936e f12129U;

    /* renamed from: V */
    private String f12130V;

    /* renamed from: W */
    private String f12131W;

    /* renamed from: X */
    private boolean f12132X;

    /* renamed from: Y */
    private String f12133Y;

    /* renamed from: Z */
    private C2095ba f12134Z;

    /* renamed from: aa */
    private String f12135aa;

    /* renamed from: ab */
    private boolean f12136ab;

    /* renamed from: ac */
    private boolean f12137ac;

    /* renamed from: ad */
    private boolean f12138ad;

    /* renamed from: ae */
    private String f12139ae;

    /* renamed from: ag */
    private InterfaceC4936e f12141ag;

    /* renamed from: ai */
    private String f12143ai;

    /* renamed from: aj */
    private String f12144aj;

    /* renamed from: al */
    private GetVersionNotice f12146al;

    /* renamed from: am */
    private int f12147am;

    /* renamed from: an */
    private C2075ah f12148an;

    /* renamed from: ao */
    private boolean f12149ao;

    /* renamed from: ap */
    private boolean f12150ap;

    /* renamed from: aq */
    private boolean f12151aq;

    /* renamed from: p */
    protected TextView f12162p;

    /* renamed from: q */
    protected boolean f12163q;

    /* renamed from: r */
    protected boolean f12164r;

    /* renamed from: u */
    protected String f12167u;

    /* renamed from: v */
    protected boolean f12168v;

    /* renamed from: C */
    private final int f12111C = 0;

    /* renamed from: D */
    private final int f12112D = 1;

    /* renamed from: E */
    private final int f12113E = 2;

    /* renamed from: F */
    private final int f12114F = 3;

    /* renamed from: G */
    private final int f12115G = 4;

    /* renamed from: o */
    protected final int f12161o = 4;

    /* renamed from: H */
    private DialogC3368bt f12116H = null;

    /* renamed from: I */
    private ProgressDialog f12117I = null;

    /* renamed from: af */
    private int f12140af = 0;

    /* renamed from: ah */
    private C0416a f12142ah = null;

    /* renamed from: ak */
    private View f12145ak = null;

    /* renamed from: s */
    protected boolean f12165s = false;

    /* renamed from: t */
    protected boolean f12166t = false;

    /* renamed from: w */
    protected boolean f12169w = false;

    /* renamed from: x */
    protected boolean f12170x = true;

    /* renamed from: ar */
    private Handler f12152ar = new HandlerC3398r(this);

    /* renamed from: y */
    Handler f12171y = new HandlerC3399s(this, Looper.getMainLooper());

    /* renamed from: as */
    private Handler f12153as = new HandlerC3400t(this);

    /* renamed from: at */
    private Handler f12154at = new HandlerC3401u(this);

    /* renamed from: z */
    Handler f12172z = new HandlerC3404x(this);

    /* renamed from: au */
    private BroadcastReceiver f12155au = new C3348b(this);

    /* renamed from: av */
    private BroadcastReceiver f12156av = new C3375c(this);

    /* renamed from: aw */
    private BroadcastReceiver f12157aw = new C3384d(this);

    /* renamed from: ax */
    private Handler f12158ax = new HandlerC3387g(this);

    /* renamed from: ay */
    private InterfaceC3377cb f12159ay = new C3390j(this);

    /* renamed from: az */
    private HandlerC4826ar f12160az = new HandlerC3391k(this);

    /* renamed from: A */
    HandlerC4826ar f12109A = new HandlerC3396p(this);

    /* renamed from: f */
    protected abstract void mo12783f();

    /* renamed from: g */
    protected abstract void mo12787g();

    /* renamed from: h */
    protected abstract void mo12788h();

    /* renamed from: i */
    protected abstract void mo12789i();

    /* renamed from: j */
    protected abstract void mo12790j();

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C4904y.f17872b) {
            C4904y.m18639b("onCreate", this.f12139ae);
        }
        this.f12118J = this;
        this.f12139ae = getClass().getSimpleName();
        if (C2948h.m12190a().m12192a(this.f12118J, EnumC2949i.ChatONV)) {
            this.f12142ah = new C0416a();
            this.f12142ah.m1491a(this, this);
        }
        this.f12110B = this.f12118J.getPackageName();
        this.f12136ab = false;
        if (C4904y.f17872b) {
            C4904y.m18639b("packageName : " + this.f12110B, this.f12139ae);
        }
        if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().getBoolean("is_direct_call")) {
            C4892m.m18577c(true);
            if (C4904y.f17872b) {
                C4904y.m18639b("It called by directly, so set passwordLock", this.f12139ae);
            }
        }
        mo12787g();
        mo12789i();
        mo12783f();
        m13128u();
        m13126s();
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (C4904y.f17872b) {
            C4904y.m18639b("onStart", this.f12139ae);
        }
        m13126s();
    }

    /* renamed from: s */
    private void m13126s() {
        this.f12147am = C4859bx.m18394c(this.f12118J);
        if (this.f12147am > -1) {
            this.f12168v = true;
        } else {
            this.f12168v = false;
        }
        this.f12167u = C4859bx.m18389b(this.f12118J);
        C4904y.m18639b("email : " + this.f12167u + " verSSO : " + this.f12147am + " supportOldSSO : " + this.f12168v, this.f12139ae);
    }

    /* renamed from: u */
    private void m13128u() {
        this.f12119K = new C2104bj(this.f12154at);
        this.f12120L = new C2132m(this.f12154at);
        this.f12123O = new C2122ca(this.f12154at);
        this.f12148an = new C2075ah(this.f12152ar);
        this.f12126R = new C2072ae(this.f12118J, this.f12152ar);
        this.f12121M = C1759he.m8726a(this.f12152ar, C4809aa.m18104a().m18118a("multidevice_chatlist_sync_last_time", 0L));
        this.f12122N = new C2128i(this.f12152ar);
        this.f12124P = C2093az.m9337a();
        this.f12125Q = new C2127h(this.f12154at);
        if (!this.f12163q) {
            if (C1427a.f5070h) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Welcome, First Time after update ChatON.", this.f12139ae);
                }
                C4822an.m18256x();
                C4809aa.m18108a("chaton_version", C1427a.f5063a);
                C1427a.f5070h = false;
            }
            if (m13137y()) {
                String strM18121a = C4809aa.m18104a().m18121a("UpdateAppsReady", "NO");
                Intent intent = new Intent(this, (Class<?>) UpgradeDialog.class);
                intent.putExtra("isCritical", true);
                intent.putExtra("isFromHome", false);
                intent.putExtra("isReadyApps", strM18121a);
                startActivity(intent);
                new C2122ca(this.f12171y).m9471b();
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("upgrade_cancel");
            C0096i.m358a(getApplicationContext()).m362a(this.f12157aw, intentFilter);
        }
        String[] strArrSplit = getResources().getString(R.string.multidevice_sync_popup).split("\n\n");
        this.f12130V = strArrSplit[0];
        this.f12131W = strArrSplit[1];
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("action_sso_receive_code");
        registerReceiver(this.f12155au, intentFilter2);
        this.f12133Y = C4809aa.m18104a().m18121a("samsung_account_email", "");
        if (C2349a.m10301a("auto_regi_feature")) {
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction("back_auto_regi");
            C0096i.m358a(getApplicationContext()).m362a(this.f12156av, intentFilter3);
            if (GlobalApplication.f8361h) {
                if (C4904y.f17872b) {
                    C4904y.m18639b("Now, background register is still going", this.f12139ae);
                }
                m13147p();
            }
        }
    }

    /* renamed from: v */
    private void m13130v() {
        m13086a(getResources().getString(R.string.multi_deivce_mapping_pop_up_title), getResources().getString(R.string.auto_regi_buddy_sync), this.f12131W);
        this.f12122N.m9495a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m13133w() throws Resources.NotFoundException {
        if (this.f12168v) {
            C4904y.m18639b("SSO was installed, SSO ver : " + this.f12147am, this.f12139ae);
            if (this.f12147am >= 150200) {
                m13105e(false);
                return;
            } else if (this.f12147am >= 13001) {
                m13102d(false);
                return;
            } else {
                m13054B();
                return;
            }
        }
        C4904y.m18639b("SSO was NOT installed", this.f12139ae);
        if (this.f12117I != null && this.f12117I.isShowing()) {
            this.f12117I.dismiss();
        }
        this.f12116H = new DialogC3368bt(this.f12118J, this.f12159ay);
        this.f12116H.show();
        this.f12116H.setOnCancelListener(new DialogInterfaceOnCancelListenerC3321a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public void m13142k() throws Resources.NotFoundException {
        m13147p();
        if (!this.f12163q) {
            m13133w();
            return;
        }
        if (C2349a.m10301a("auto_regi_feature")) {
            if (!C4859bx.m18374a().equals(EnumC4863ca.OTHER)) {
                m13130v();
                if (C4904y.f17872b) {
                    C4904y.m18639b("Mapping & Auto Request", this.f12139ae);
                    return;
                }
                return;
            }
            m13133w();
            if (C4904y.f17872b) {
                C4904y.m18639b("Mapping Request", this.f12139ae);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m13140b(boolean z) throws Resources.NotFoundException {
        String strM18121a;
        if (z) {
            strM18121a = C4859bx.m18389b(this.f12118J);
            if (!TextUtils.isEmpty(strM18121a)) {
                this.f12137ac = true;
            } else {
                this.f12137ac = false;
            }
        } else {
            strM18121a = C4809aa.m18104a().m18121a("samsung_account_email", "");
            this.f12137ac = false;
        }
        if (TextUtils.isEmpty(strM18121a)) {
            m13142k();
            return;
        }
        this.f12133Y = strM18121a;
        C4904y.m18639b("Samsung email : " + strM18121a, this.f12139ae);
        m13147p();
        if (C4809aa.m18104a().m18121a("primary_contact_addrss", (String) null) == null) {
            this.f12136ab = true;
            this.f12120L.m9552a();
        } else {
            this.f12134Z = new C2095ba(this.f12172z);
            this.f12134Z.m9352a(C4809aa.m18104a().m18121a("msisdn", ""), strM18121a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m13135x() {
        String strM18389b = C4859bx.m18389b(this.f12118J);
        if (!TextUtils.isEmpty(strM18389b)) {
            this.f12133Y = strM18389b;
            C4904y.m18639b("Samsung email : " + strM18389b, this.f12139ae);
            this.f12134Z = new C2095ba(this.f12172z);
            this.f12134Z.m9358b(C4809aa.m18104a().m18121a("msisdn", ""), strM18389b);
        }
    }

    /* renamed from: l */
    protected void m13143l() {
        C4859bx.m18381a(this.f12118J, this.f12135aa);
        m13075a(R.string.auto_regi_checking_push);
        this.f12124P.mo9077a(this.f12160az);
        this.f12160az.m18263a(1001, 30000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13086a(String str, String str2, String str3) {
        if (!this.f12166t && !this.f12165s) {
            if (this.f12129U == null || !this.f12129U.isShowing()) {
                this.f12145ak = null;
                this.f12145ak = LayoutInflater.from(this).inflate(R.layout.layout_multidevice_sync, (ViewGroup) null, false);
                TextView textView = (TextView) this.f12145ak.findViewById(R.id.messageText);
                ((TextView) this.f12145ak.findViewById(R.id.subTitleText)).setText(str2);
                textView.setText(str3);
                this.f12129U = AbstractC4932a.m18733a(this.f12118J).mo18740a(str).mo18748b(this.f12145ak).mo18742a(true).mo18745a();
                this.f12129U.setCancelable(false);
                this.f12129U.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13093b(String str) {
        if (this.f12129U != null && this.f12129U.isShowing() && this.f12145ak != null) {
            ((TextView) this.f12145ak.findViewById(R.id.subTitleText)).setText(str);
        }
        m13097c(str);
    }

    /* renamed from: y */
    private boolean m13137y() {
        boolean zBooleanValue = C4809aa.m18104a().m18119a("UpdateIsCritical", (Boolean) false).booleanValue();
        C4904y.m18639b("checkCriticalUpdate : " + zBooleanValue, this.f12139ae);
        return zBooleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m13139z() {
        C0096i.m358a(this.f12118J).m363a(new Intent("com.sec.chaton.ACTION_DISMISS"));
    }

    /* renamed from: a */
    public static boolean m13087a(Context context) {
        String simpleName = context.getClass().getSimpleName();
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.sec.spp.provider/version_info/"), null, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_CURRENT_VERSION));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_LATEST_VERSION));
                    boolean z = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex(Config.COLUMN_NEED_UPDATE)));
                    if (C4904y.f17872b) {
                        C4904y.m18639b("[SPP update status] currentVer : " + string + " latestVer : " + string2 + " needUpdate : " + z, simpleName);
                    }
                    C4809aa.m18105a("spp_update_is", Boolean.valueOf(z));
                    C4809aa.m18108a("spp_latest_ver", string2);
                    cursorQuery.close();
                    return z;
                }
                cursorQuery.close();
                return false;
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("cursor is null", simpleName);
            }
            return false;
        } catch (Exception e) {
            C4904y.m18634a(e.toString(), simpleName);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13085a(EnumC3328ag enumC3328ag, String str) {
        m13148q();
        if (C4904y.f17872b) {
            C4904y.m18639b("network error, type : " + enumC3328ag.toString() + " errorCode : " + str, this.f12139ae);
        }
        if (GlobalApplication.m18732r() != null) {
            this.f12141ag = C4859bx.m18375a(AbstractC4932a.m18733a(this.f12118J).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(C4822an.m18209a(getResources().getString(R.string.toast_network_unable), getResources().getString(R.string.error_code_common), str)).mo18754c(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC3325ad(this, enumC3328ag)).mo18747b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC3324ac(this, enumC3328ag)), this, str).mo18745a();
            if (!this.f12166t) {
                this.f12141ag.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m13052A() throws Resources.NotFoundException {
        this.f12140af++;
        if (TextUtils.isEmpty(this.f12167u) || this.f12140af >= 2) {
            m13148q();
        }
        if (this.f12140af < 2) {
            if (this.f12147am >= 150200) {
                m13105e(true);
                return;
            } else {
                m13102d(true);
                return;
            }
        }
        this.f12140af = 0;
        this.f12141ag = AbstractC4932a.m18733a(this.f12118J).mo18740a(getResources().getString(R.string.toast_error)).mo18749b(getResources().getString(R.string.samsung_account_try_later)).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3326ae(this)).mo18745a();
        if (!this.f12166t) {
            this.f12141ag.show();
        }
    }

    /* renamed from: B */
    private void m13054B() throws Resources.NotFoundException {
        if (!TextUtils.isEmpty(this.f12167u)) {
            Intent intent = new Intent("com.msc.action.samsungaccount.request.BackGroundSignin");
            intent.putExtra(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, "fs24s8z0hh");
            intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
            intent.putExtra("mypackage", this.f12110B);
            intent.putExtra("OSP_VER", "OSP_02");
            sendBroadcast(intent);
            this.f12151aq = true;
            return;
        }
        m13148q();
        C4904y.m18639b("ActivitySignIn will be run", this.f12139ae);
        Intent intent2 = new Intent();
        intent2.setClassName("com.osp.app.signin", "com.osp.app.signin.AccountView");
        intent2.putExtra(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, "fs24s8z0hh");
        intent2.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
        intent2.putExtra("OSP_VER", "OSP_02");
        try {
            startActivityForResult(intent2, 1);
            f12108n = true;
        } catch (ActivityNotFoundException e) {
            m13078a(this.f12118J, EnumC3327af.disable, this.f12165s);
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m13102d(boolean z) throws Resources.NotFoundException {
        if (C4904y.f17872b) {
            C4904y.m18639b("runNewSSO", this.f12139ae);
        }
        if (!TextUtils.isEmpty(this.f12167u)) {
            Intent intent = new Intent("com.msc.action.ACCESSTOKEN_V02_REQUEST");
            intent.putExtra(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, "fs24s8z0hh");
            intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
            intent.putExtra("mypackage", this.f12110B);
            intent.putExtra("OSP_VER", "OSP_02");
            intent.putExtra("MODE", "HIDE_NOTIFICATION_WITH_RESULT");
            intent.putExtra("additional", new String[]{"user_id", "email_id", "mcc", "api_server_url", "birthday"});
            if (z) {
                intent.putExtra("expired_access_token", C4809aa.m18104a().m18121a("samsung_account_token", ""));
            }
            sendBroadcast(intent);
            this.f12151aq = true;
            this.f12109A.m18262a(30000);
            return;
        }
        m13057C();
    }

    /* renamed from: e */
    private void m13105e(boolean z) throws Resources.NotFoundException {
        if (C4904y.f17872b) {
            C4904y.m18639b("startActivitySSO", this.f12139ae);
        }
        if (!TextUtils.isEmpty(this.f12167u)) {
            Intent intent = new Intent("com.msc.action.samsungaccount.REQUEST_ACCESSTOKEN");
            intent.putExtra(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, "fs24s8z0hh");
            intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
            intent.putExtra("progress_theme", "invisible");
            intent.putExtra("additional", new String[]{"user_id", "login_id", "login_id_type", "mcc", "api_server_url", "birthday"});
            if (z) {
                intent.putExtra("expired_access_token", C4809aa.m18104a().m18121a("samsung_account_token", ""));
            }
            startActivityForResult(intent, 4);
            this.f12109A.m18262a(30000);
            return;
        }
        m13057C();
    }

    /* renamed from: C */
    private void m13057C() throws Resources.NotFoundException {
        m13148q();
        C4904y.m18639b("ActivitySignIn will be run", this.f12139ae);
        Intent intent = new Intent("com.osp.app.signin.action.ADD_SAMSUNG_ACCOUNT");
        intent.putExtra(VKOpenAuthActivity.VK_EXTRA_CLIENT_ID, "fs24s8z0hh");
        intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
        intent.putExtra("mypackage", this.f12110B);
        intent.putExtra("OSP_VER", "OSP_02");
        intent.putExtra("MODE", "ADD_ACCOUNT");
        try {
            startActivityForResult(intent, 2);
            f12108n = true;
        } catch (ActivityNotFoundException e) {
            m13078a(this.f12118J, EnumC3327af.disable, this.f12165s);
            e.printStackTrace();
        }
    }

    /* renamed from: m */
    protected void mo13144m() {
        m13109f(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m13109f(boolean z) {
        if (!z && this.f12163q) {
            this.f12126R.m9283a();
            return;
        }
        m13148q();
        Intent intent = new Intent();
        if (this.f12163q) {
            setResult(-1, intent);
        } else {
            setResult(4, intent);
        }
        finish();
    }

    /* renamed from: n */
    protected void m13145n() {
        if (this.f12163q) {
            finish();
            return;
        }
        this.f12132X = true;
        m13147p();
        if (C4809aa.m18104a().m18121a("primary_contact_addrss", (String) null) == null) {
            this.f12120L.m9552a();
            return;
        }
        if (C2349a.m10301a("chatonv_feature")) {
            this.f12125Q.m9483a(EnumC2463n.UI);
        } else {
            this.f12123O.m9471b();
        }
        C4904y.m18639b("[GLD] Already get server address", this.f12139ae);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m13059D() {
        if (this.f12117I != null && this.f12117I.isShowing()) {
            this.f12117I.dismiss();
        }
        setResult(3, new Intent());
        finish();
    }

    /* renamed from: o */
    protected void m13146o() {
        m13148q();
        setResult(5, new Intent());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m13061E() throws Resources.NotFoundException {
        m13148q();
        m13078a(this.f12118J, EnumC3327af.normal, this.f12165s);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (C4904y.f17872b) {
            C4904y.m18639b("onPause", this.f12139ae);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C4904y.f17872b) {
            C4904y.m18639b("onResume", this.f12139ae);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (C4904y.f17872b) {
            C4904y.m18639b("onDestroy", this.f12139ae);
        }
        this.f12166t = true;
        if (this.f12117I != null && this.f12117I.isShowing()) {
            this.f12117I.dismiss();
        }
        if (this.f12129U != null && this.f12129U.isShowing()) {
            this.f12129U.dismiss();
            this.f12145ak = null;
        }
        if (this.f12141ag != null && this.f12141ag.isShowing()) {
            this.f12141ag.dismiss();
        }
        unregisterReceiver(this.f12155au);
        if (C2349a.m10301a("auto_regi_feature")) {
            C0096i.m358a(getApplicationContext()).m361a(this.f12156av);
        }
        f12108n = false;
        if (C2349a.m10301a("chatonv_feature") && this.f12142ah != null) {
            this.f12142ah.m1491a(this, (InterfaceC0418c) null);
        }
        if (!this.f12163q) {
            C0096i.m358a(getApplicationContext()).m361a(this.f12157aw);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 0:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("country_code");
                    if (this.f12163q) {
                        C4859bx.m18384a(stringExtra, this.f12118J, true);
                        m13086a(getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12130V, this.f12131W);
                        m13112g(false);
                        break;
                    } else {
                        C4859bx.m18384a(stringExtra, this.f12118J, false);
                        if (!this.f12166t && C4859bx.m18387a(C4809aa.m18104a().m18121a("temp_account_country_code", ""), this)) {
                            m13148q();
                            break;
                        } else {
                            this.f12120L.m9552a();
                            m13086a(getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12130V, this.f12131W);
                            break;
                        }
                    }
                }
                break;
            case 1:
                m13147p();
                if (i2 == -1) {
                    this.f12127S = intent.getStringExtra("authcode");
                    if (this.f12127S != null) {
                        this.f12119K.m9389a(this.f12127S, "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
                    } else {
                        m13148q();
                        m13078a(this.f12118J, EnumC3327af.normal, this.f12165s);
                    }
                    C4904y.m18639b("authcode : " + this.f12127S, this.f12139ae);
                    break;
                } else {
                    m13148q();
                    C4904y.m18639b("SIGN_IN : result is ERROR", this.f12139ae);
                    if (this.f12149ao) {
                        finish();
                        break;
                    }
                }
                break;
            case 2:
                m13147p();
                if (!GlobalApplication.f8361h) {
                    if (i2 == -1) {
                        this.f12167u = C4859bx.m18389b(this.f12118J);
                        if (!TextUtils.isEmpty(this.f12167u)) {
                            if (this.f12147am >= 150200) {
                                m13105e(false);
                                break;
                            } else if (this.f12147am >= 13001) {
                                m13102d(false);
                                break;
                            }
                        } else {
                            m13148q();
                            m13078a(this.f12118J, EnumC3327af.normal, this.f12165s);
                            break;
                        }
                    } else {
                        m13148q();
                        String stringExtra2 = "";
                        if (intent != null) {
                            stringExtra2 = intent.getStringExtra("error_message");
                        }
                        C4904y.m18639b("NEW_SIGN_IN : result is ERROR, errorMessage : " + stringExtra2, this.f12139ae);
                        if (this.f12149ao) {
                            finish();
                            break;
                        }
                    }
                }
                break;
            case 3:
                if (i2 == -1) {
                    if (this.f12165s) {
                        m13086a(getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12130V, this.f12131W);
                        this.f12119K.m9390b();
                        break;
                    } else if (this.f12149ao) {
                        finish();
                        break;
                    }
                } else if (this.f12165s || this.f12149ao) {
                    finish();
                    break;
                }
                break;
            case 4:
                this.f12109A.m18261a();
                if (i2 == -1) {
                    String stringExtra3 = intent.getStringExtra("access_token");
                    if (!TextUtils.isEmpty(stringExtra3)) {
                        this.f12143ai = intent.getStringExtra("login_id");
                        String stringExtra4 = intent.getStringExtra("login_id_type");
                        this.f12144aj = intent.getStringExtra("user_id");
                        String stringExtra5 = intent.getStringExtra("mcc");
                        String stringExtra6 = intent.getStringExtra("api_server_url");
                        String stringExtra7 = intent.getStringExtra("birthday");
                        if (C4904y.f17872b) {
                            C4904y.m18639b("[ActivityResult] authToken : " + stringExtra3 + " loginID : " + this.f12143ai + " userId : " + this.f12144aj + " loginType : " + stringExtra4 + " mcc : " + stringExtra5 + " birthday : " + stringExtra7 + " server : " + stringExtra6, this.f12139ae);
                        }
                        C4809aa.m18108a("samsung_account_token", stringExtra3);
                        C4809aa.m18108a("samsung_account_email", this.f12143ai);
                        C4809aa.m18108a("samsung_account_user_id", this.f12144aj);
                        C4809aa.m18108a("samsung_account_api_server", stringExtra6);
                        C4809aa.m18108a("samsung_account_birthday", stringExtra7);
                        m13086a(getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f12130V, this.f12131W);
                        if (this.f12163q) {
                            C4859bx.m18381a(this.f12118J, stringExtra5);
                            m13124r();
                            m13112g(false);
                            break;
                        } else if (C2349a.m10301a("mum_enable_feature") && !this.f12138ad) {
                            m13135x();
                            this.f12135aa = stringExtra5;
                            break;
                        } else {
                            C4859bx.m18381a(this.f12118J, stringExtra5);
                            m13075a(R.string.auto_regi_checking_push);
                            if (!this.f12166t && C4859bx.m18387a(C4809aa.m18104a().m18121a("temp_account_country_code", ""), this)) {
                                m13148q();
                                break;
                            } else {
                                this.f12120L.m9552a();
                                break;
                            }
                        }
                    } else {
                        m13061E();
                        break;
                    }
                } else if (i2 == 0) {
                    finish();
                    break;
                } else {
                    if (intent != null) {
                        String stringExtra8 = intent.getStringExtra(VKApiConst.ERROR_CODE);
                        String stringExtra9 = intent.getStringExtra("error_message");
                        if (C4904y.f17872b) {
                            C4904y.m18639b("[ActivityResult] errorCode : " + stringExtra8 + " errorMessage : " + stringExtra9, this.f12139ae);
                        }
                    } else if (C4904y.f17872b) {
                        C4904y.m18639b("data is null", this.f12139ae);
                    }
                    m13061E();
                    break;
                }
                break;
            case 100:
                if (!this.f12166t) {
                    setResult(11);
                    finish();
                    break;
                }
                break;
        }
    }

    /* renamed from: p */
    protected void m13147p() {
        if ((this.f12117I == null || !this.f12117I.isShowing()) && !this.f12165s) {
            String strM18389b = C4859bx.m18389b(this.f12118J);
            this.f12147am = C4859bx.m18394c(this);
            if (this.f12132X || this.f12164r) {
                this.f12117I = ProgressDialogC4926s.m18727a(this.f12118J, null, this.f12118J.getResources().getString(R.string.dialog_provision_ing));
            } else if (TextUtils.isEmpty(strM18389b) || this.f12147am <= -1) {
                this.f12117I = ProgressDialogC4926s.m18727a(this.f12118J, null, this.f12118J.getResources().getString(R.string.multi_device_checking_account_no_email));
            } else {
                this.f12117I = ProgressDialogC4926s.m18727a(this.f12118J, null, this.f12118J.getResources().getString(R.string.multi_device_checking_account, strM18389b));
            }
            this.f12117I.setCancelable(false);
        }
    }

    /* renamed from: q */
    protected void m13148q() {
        if (C4904y.f17872b) {
            C4904y.m18639b("dismissProgressBar, progressBar : " + (this.f12117I == null ? this.f12117I : Boolean.valueOf(this.f12117I.isShowing())) + " mMultiDeviceDialog : " + (this.f12129U == null ? this.f12129U : Boolean.valueOf(this.f12129U.isShowing())), this.f12139ae);
        }
        if (this.f12117I != null && this.f12117I.isShowing()) {
            this.f12117I.dismiss();
        }
        if (this.f12129U != null && this.f12129U.isShowing()) {
            this.f12129U.dismiss();
            this.f12145ak = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13078a(Context context, EnumC3327af enumC3327af, boolean z) throws Resources.NotFoundException {
        String string = "";
        if (enumC3327af == EnumC3327af.normal) {
            string = context.getResources().getString(R.string.samsung_account_try_later);
        } else if (enumC3327af == EnumC3327af.disable) {
            string = context.getResources().getString(R.string.chaton_ps_has_been_disabled, context.getResources().getString(R.string.setting_samsung_account));
        }
        if (z) {
            this.f12141ag = AbstractC4932a.m18733a(context).mo18740a(context.getResources().getString(R.string.toast_error)).mo18749b(string).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3385e(this)).mo18745a();
            if (!this.f12166t) {
                this.f12141ag.show();
                return;
            }
            return;
        }
        m13092b(context, enumC3327af, null, this.f12149ao);
    }

    /* renamed from: a */
    public static void m13076a(Context context, EnumC3327af enumC3327af) throws Resources.NotFoundException {
        m13092b(context, enumC3327af, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m13092b(Context context, EnumC3327af enumC3327af, String str, boolean z) throws Resources.NotFoundException {
        String string;
        String string2 = context.getResources().getString(R.string.setting_samsung_account);
        if (enumC3327af == EnumC3327af.normal) {
            string = context.getResources().getString(R.string.samsung_account_try_later);
        } else {
            string = enumC3327af == EnumC3327af.disable ? context.getResources().getString(R.string.chaton_ps_has_been_disabled, context.getResources().getString(R.string.setting_samsung_account)) : string2;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AbstractC4932a.m18733a(context).mo18740a(context.getResources().getString(R.string.toast_error)).mo18749b(string).mo18756d(R.string.dialog_confirm, new DialogInterfaceOnClickListenerC3386f(z, context)).mo18745a().show();
        }
    }

    /* renamed from: r */
    public static void m13124r() {
        ArrayList<String> arrayListM9861b = C2191e.m9861b(CommonApplication.m18732r().getContentResolver());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayListM9861b.size()) {
                C2496n.m10794g(CommonApplication.m18732r(), arrayListM9861b.get(i2).toString());
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m13112g(boolean z) throws Resources.NotFoundException {
        if (C2349a.m10301a("mum_enable_feature") && !z) {
            m13140b(false);
            return;
        }
        ContentResolver contentResolver = CommonApplication.m18732r().getContentResolver();
        ArrayList<String> arrayListM9861b = C2191e.m9861b(contentResolver);
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<Integer> arrayListM9851a = C2191e.m9851a(contentResolver);
        for (int i = 0; i < arrayListM9851a.size(); i++) {
            ArrayList<String> arrayListM9852a = C2191e.m9852a(contentResolver, arrayListM9851a.get(i).intValue());
            if (!arrayListM9861b.get(i).equals("Favorites")) {
                map.put(arrayListM9861b.get(i), arrayListM9852a);
            }
        }
        new C2128i(this.f12158ax).m9487a("group", false, 328, arrayListM9861b, map);
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a_ */
    public void mo1509a_(boolean z) {
    }

    @Override // com.coolots.sso.p030a.InterfaceC0418c
    /* renamed from: a */
    public void mo1508a(boolean z, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onReceiveCreateAccount : " + z + " msg : " + str, this.f12139ae);
        }
        if (z) {
            this.f12122N.m9499a("voip", 1, false);
            return;
        }
        new C3317x().m13050a();
        m13093b(getResources().getString(R.string.auto_regi_buddy_sync));
        if (this.f12163q) {
            C2186al.m9763a();
            this.f12122N.m9495a();
            this.f12122N.m9515c();
            return;
        }
        this.f12122N.m9495a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m13075a(int i) {
        if (this.f12165s && this.f12162p != null) {
            this.f12162p.setText(i);
        }
    }

    /* renamed from: c */
    private void m13097c(String str) {
        if (this.f12165s && this.f12162p != null) {
            this.f12162p.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public void m13063F() {
        if (C4859bx.m18386a(this.f12118J)) {
            if (this.f12142ah != null) {
                if (C4859bx.m18369a(this.f12118J, this.f12142ah) != 0) {
                    m13093b(getResources().getString(R.string.auto_regi_buddy_sync));
                    this.f12122N.m9495a();
                    return;
                } else {
                    m13093b(getResources().getString(R.string.auto_regi_initializing_voice_and_video));
                    return;
                }
            }
            if (C4904y.f17872b) {
                C4904y.m18639b("mChatonV is null", this.f12139ae);
            }
            m13093b(getResources().getString(R.string.auto_regi_buddy_sync));
            this.f12122N.m9495a();
            return;
        }
        m13093b(getResources().getString(R.string.auto_regi_buddy_sync));
        this.f12122N.m9495a();
    }

    /* renamed from: c */
    protected void m13141c(boolean z) {
        this.f12149ao = z;
    }
}
