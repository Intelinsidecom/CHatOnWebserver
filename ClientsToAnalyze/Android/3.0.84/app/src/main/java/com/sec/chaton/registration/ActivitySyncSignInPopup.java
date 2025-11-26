package com.sec.chaton.registration;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0047c;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.chat.C1090fe;
import com.sec.chaton.global.C1493a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C1303ap;
import com.sec.chaton.p025d.C1307at;
import com.sec.chaton.p025d.C1330h;
import com.sec.chaton.p027e.p028a.C1357af;
import com.sec.chaton.p027e.p028a.C1362f;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.samsungaccount.DialogC2339ba;
import com.sec.chaton.samsungaccount.EnumC2335ax;
import com.sec.chaton.samsungaccount.InterfaceC2347bi;
import com.sec.chaton.samsungaccount.MainActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3171am;
import com.sec.chaton.util.C3214cb;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class ActivitySyncSignInPopup extends BaseActivity implements InterfaceC0047c {

    /* renamed from: A */
    private String f8096A;

    /* renamed from: B */
    private String f8097B;

    /* renamed from: C */
    private String f8098C;

    /* renamed from: D */
    private int f8099D;

    /* renamed from: H */
    private C1303ap f8103H;

    /* renamed from: J */
    private InterfaceC3274d f8105J;

    /* renamed from: g */
    private Context f8118g;

    /* renamed from: h */
    private Button f8119h;

    /* renamed from: i */
    private Button f8120i;

    /* renamed from: j */
    private ImageView f8121j;

    /* renamed from: k */
    private TextView f8122k;

    /* renamed from: l */
    private TextView f8123l;

    /* renamed from: n */
    private InterfaceC3274d f8125n;

    /* renamed from: p */
    private C1307at f8127p;

    /* renamed from: q */
    private C1330h f8128q;

    /* renamed from: r */
    private C1090fe f8129r;

    /* renamed from: s */
    private boolean f8130s;

    /* renamed from: t */
    private boolean f8131t;

    /* renamed from: u */
    private boolean f8132u;

    /* renamed from: v */
    private String f8133v;

    /* renamed from: w */
    private String f8134w;

    /* renamed from: x */
    private String f8135x;

    /* renamed from: y */
    private String f8136y;

    /* renamed from: z */
    private String f8137z;

    /* renamed from: b */
    private final String f8113b = ActivitySyncSignInPopup.class.getSimpleName();

    /* renamed from: c */
    private final int f8114c = 0;

    /* renamed from: d */
    private final int f8115d = 1;

    /* renamed from: e */
    private final int f8116e = 2;

    /* renamed from: f */
    private final int f8117f = 3;

    /* renamed from: m */
    private ProgressDialog f8124m = null;

    /* renamed from: o */
    private DialogC2339ba f8126o = null;

    /* renamed from: E */
    private int f8100E = 0;

    /* renamed from: F */
    private boolean f8101F = false;

    /* renamed from: G */
    private View f8102G = null;

    /* renamed from: I */
    private C0045a f8104I = null;

    /* renamed from: K */
    private Handler f8106K = new HandlerC2301r(this);

    /* renamed from: L */
    private Handler f8107L = new HandlerC2303t(this);

    /* renamed from: M */
    private Handler f8108M = new HandlerC2304u(this);

    /* renamed from: N */
    private BroadcastReceiver f8109N = new C2305v(this);

    /* renamed from: a */
    Handler f8112a = new HandlerC2306w(this);

    /* renamed from: O */
    private InterfaceC2347bi f8110O = new C2309z(this);

    /* renamed from: P */
    private Handler f8111P = new HandlerC2123aa(this);

    /* renamed from: n */
    static /* synthetic */ int m8425n(ActivitySyncSignInPopup activitySyncSignInPopup) {
        int i = activitySyncSignInPopup.f8100E;
        activitySyncSignInPopup.f8100E = i + 1;
        return i;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (C3250y.f11735c) {
            C3250y.m11453c("onCreate", this.f8113b);
        }
        setContentView(R.layout.layout_pop_up_account);
        this.f8118g = this;
        this.f8135x = this.f8118g.getPackageName();
        this.f8099D = C3214cb.m11262c(this);
        if (this.f8099D > -1) {
            this.f8131t = true;
        } else {
            this.f8131t = false;
        }
        this.f8132u = C3214cb.m11255a(this.f8099D);
        this.f8134w = C3214cb.m11257b(this.f8118g);
        this.f8133v = C3159aa.m10962a().m10979a("samsung_account_email", "");
        String[] strArrSplit = getResources().getString(R.string.multidevice_sync_popup).split("\n\n");
        this.f8136y = strArrSplit[0];
        this.f8137z = strArrSplit[1];
        this.f8127p = new C1307at(this.f8106K);
        this.f8129r = new C1090fe(this.f8107L, C3159aa.m10962a().m10976a("multidevice_chatlist_sync_last_time", 0L));
        this.f8128q = new C1330h(this.f8107L);
        this.f8119h = (Button) findViewById(R.id.btn_sync_sign);
        this.f8120i = (Button) findViewById(R.id.btn_not_now);
        this.f8121j = (ImageView) findViewById(R.id.image);
        this.f8122k = (TextView) findViewById(R.id.text1);
        this.f8123l = (TextView) findViewById(R.id.text2);
        this.f8130s = getIntent().getExtras().getBoolean("isSyncContacts", false);
        if (this.f8130s) {
            this.f8119h.setText(getResources().getString(R.string.user_sign_in_account));
            this.f8121j.setImageDrawable(getResources().getDrawable(R.drawable.push_popup_samsung));
            this.f8122k.setText(getResources().getString(R.string.dialog_sign_in_comment1));
            this.f8123l.setText(getResources().getString(R.string.dialog_sign_in_comment2));
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_sso_receive_code");
        registerReceiver(this.f8109N, intentFilter);
        if (C1954g.m7916a().m7918a(this.f8118g, EnumC1955h.ChatONV)) {
            this.f8104I = new C0045a();
            this.f8104I.m51a(this, this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (C3250y.f11735c) {
            C3250y.m11453c("onStart", this.f8113b);
        }
        this.f8119h.setOnClickListener(new ViewOnClickListenerC2296m(this));
        this.f8120i.setOnClickListener(new ViewOnClickListenerC2300q(this));
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (C3250y.f11735c) {
            C3250y.m11453c("onResume", this.f8113b);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (C3250y.f11735c) {
            C3250y.m11450b("onDestroy", this.f8113b);
        }
        unregisterReceiver(this.f8109N);
        this.f8101F = true;
        if (this.f8124m != null && this.f8124m.isShowing()) {
            this.f8124m.dismiss();
        }
        if (this.f8125n != null && this.f8125n.isShowing()) {
            this.f8125n.dismiss();
            this.f8102G = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8393a() throws Resources.NotFoundException {
        if (this.f8131t) {
            C3250y.m11450b("SSO was installed, SSO ver : " + this.f8099D, this.f8113b);
            if (this.f8132u) {
                m8401a(false);
                return;
            } else {
                m8405b();
                return;
            }
        }
        C3250y.m11450b("SSO was NOT installed", this.f8113b);
        if (TextUtils.isEmpty(this.f8133v)) {
            if (this.f8124m != null && this.f8124m.isShowing()) {
                this.f8124m.dismiss();
            }
            this.f8126o = new DialogC2339ba(this.f8118g, this.f8110O);
            this.f8126o.show();
            return;
        }
        m8407b(false);
    }

    /* renamed from: b */
    private void m8405b() throws Resources.NotFoundException {
        if (!TextUtils.isEmpty(this.f8134w)) {
            Intent intent = new Intent("com.msc.action.samsungaccount.request.BackGroundSignin");
            intent.putExtra("client_id", "fs24s8z0hh");
            intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
            intent.putExtra("mypackage", this.f8135x);
            intent.putExtra("OSP_VER", "OSP_02");
            sendBroadcast(intent);
            return;
        }
        if (this.f8124m != null && this.f8124m.isShowing()) {
            this.f8124m.dismiss();
        }
        C3250y.m11450b("ActivitySignIn will be run", this.f8113b);
        Intent intent2 = new Intent();
        intent2.setClassName("com.osp.app.signin", "com.osp.app.signin.AccountView");
        intent2.putExtra("client_id", "fs24s8z0hh");
        intent2.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
        intent2.putExtra("OSP_VER", "OSP_02");
        try {
            startActivityForResult(intent2, 1);
        } catch (ActivityNotFoundException e) {
            MainActivity.m8733a(this.f8118g, EnumC2335ax.disable);
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8401a(boolean z) throws Resources.NotFoundException {
        if (!TextUtils.isEmpty(this.f8134w)) {
            Intent intent = new Intent("com.msc.action.ACCESSTOKEN_V02_REQUEST");
            intent.putExtra("client_id", "fs24s8z0hh");
            intent.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
            intent.putExtra("mypackage", this.f8135x);
            intent.putExtra("OSP_VER", "OSP_02");
            intent.putExtra("MODE", "HIDE_NOTIFICATION_WITH_RESULT");
            intent.putExtra("additional", new String[]{"user_id", "email_id", "mcc", "api_server_url", "birthday"});
            if (z) {
                intent.putExtra("expired_access_token", C3159aa.m10962a().m10979a("samsung_account_token", ""));
            }
            sendBroadcast(intent);
            return;
        }
        if (this.f8124m != null && this.f8124m.isShowing()) {
            this.f8124m.dismiss();
        }
        C3250y.m11450b("ActivitySignIn will be run", this.f8113b);
        Intent intent2 = new Intent("com.osp.app.signin.action.ADD_SAMSUNG_ACCOUNT");
        intent2.putExtra("client_id", "fs24s8z0hh");
        intent2.putExtra("client_secret", "8F23805C79D7D4EBAAC5CE705A87371D");
        intent2.putExtra("mypackage", this.f8135x);
        intent2.putExtra("OSP_VER", "OSP_02");
        intent2.putExtra("MODE", "ADD_ACCOUNT");
        try {
            startActivityForResult(intent2, 2);
        } catch (ActivityNotFoundException e) {
            MainActivity.m8733a(this.f8118g, EnumC2335ax.disable);
            e.printStackTrace();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws Resources.NotFoundException {
        switch (i) {
            case 0:
                if (i2 == -1) {
                    C3214cb.m11253a(intent.getStringExtra("country_code"), this.f8118g, true);
                    m8400a(getResources().getString(R.string.multi_deivce_mapping_pop_up_title), this.f8136y, this.f8137z);
                    m8407b(false);
                    break;
                }
                break;
            case 1:
                m8412d();
                if (i2 == -1) {
                    this.f8096A = intent.getStringExtra("authcode");
                    if (this.f8096A != null) {
                        this.f8127p.m5616a(this.f8096A, "fs24s8z0hh", "8F23805C79D7D4EBAAC5CE705A87371D");
                    } else {
                        if (this.f8124m != null && this.f8124m.isShowing()) {
                            this.f8124m.dismiss();
                        }
                        MainActivity.m8733a(this.f8118g, EnumC2335ax.normal);
                    }
                    C3250y.m11450b("authcode : " + this.f8096A, this.f8113b);
                    break;
                } else {
                    if (this.f8124m != null && this.f8124m.isShowing()) {
                        this.f8124m.dismiss();
                    }
                    C3250y.m11450b("SIGN_IN : result is ERROR", this.f8113b);
                    break;
                }
                break;
            case 2:
                m8412d();
                if (i2 == -1) {
                    this.f8134w = C3214cb.m11257b(this.f8118g);
                    if (!TextUtils.isEmpty(this.f8134w)) {
                        m8401a(false);
                        break;
                    } else {
                        if (this.f8124m != null && this.f8124m.isShowing()) {
                            this.f8124m.dismiss();
                        }
                        MainActivity.m8733a(this.f8118g, EnumC2335ax.normal);
                        break;
                    }
                } else {
                    if (this.f8124m != null && this.f8124m.isShowing()) {
                        this.f8124m.dismiss();
                    }
                    String stringExtra = "";
                    if (intent != null) {
                        stringExtra = intent.getStringExtra("error_message");
                    }
                    C3250y.m11450b("NEW_SIGN_IN : result is ERROR, errorMessage : " + stringExtra, this.f8113b);
                    break;
                }
                break;
            case 3:
                if (i2 == -1) {
                    finish();
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m8409c() {
        if (this.f8124m != null && this.f8124m.isShowing()) {
            this.f8124m.dismiss();
        }
        setResult(-1, new Intent());
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8400a(String str, String str2, String str3) {
        if (!this.f8101F) {
            this.f8102G = LayoutInflater.from(this).inflate(R.layout.layout_multidevice_sync, (ViewGroup) null, false);
            TextView textView = (TextView) this.f8102G.findViewById(R.id.messageText);
            ((TextView) this.f8102G.findViewById(R.id.subTitleText)).setText(str2);
            textView.setText(str3);
            this.f8125n = AbstractC3271a.m11494a(this.f8118g).mo11500a(str).mo11508b(this.f8102G).mo11502a(true).mo11505a();
            this.f8125n.setCancelable(false);
            this.f8125n.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8399a(String str) {
        if (this.f8125n != null && this.f8125n.isShowing() && this.f8102G != null) {
            ((TextView) this.f8102G.findViewById(R.id.subTitleText)).setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m8412d() {
        if ((this.f8124m == null || !this.f8124m.isShowing()) && !this.f8101F) {
            String strM11257b = C3214cb.m11257b(this.f8118g);
            if (TextUtils.isEmpty(strM11257b) || !this.f8131t) {
                this.f8124m = ProgressDialogC3265l.m11489a(this.f8118g, null, this.f8118g.getResources().getString(R.string.multi_device_checking_account_no_email));
            } else {
                this.f8124m = ProgressDialogC3265l.m11489a(this.f8118g, null, this.f8118g.getResources().getString(R.string.multi_device_checking_account, strM11257b));
            }
            this.f8124m.setCancelable(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8407b(boolean z) {
        if (C1493a.m6463a("mum_enable_feature") && !z) {
            m8414e();
            return;
        }
        ContentResolver contentResolver = CommonApplication.m11493l().getContentResolver();
        ArrayList<String> arrayListM6068b = C1362f.m6068b(contentResolver);
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<Integer> arrayListM6059a = C1362f.m6059a(contentResolver);
        for (int i = 0; i < arrayListM6059a.size(); i++) {
            ArrayList<String> arrayListM6060a = C1362f.m6060a(contentResolver, arrayListM6059a.get(i).intValue());
            if (!arrayListM6068b.get(i).equals("Favorites")) {
                map.put(arrayListM6068b.get(i), arrayListM6060a);
            }
        }
        new C1330h(this.f8111P).m5714a("group", false, 328, arrayListM6068b, map);
    }

    /* renamed from: e */
    private void m8414e() {
        m8412d();
        this.f8103H = new C1303ap(this.f8112a);
        String strM10979a = C3159aa.m10962a().m10979a("samsung_account_email", "");
        this.f8133v = strM10979a;
        C3250y.m11450b("Samsung email : " + strM10979a, this.f8113b);
        this.f8103H.m5599a(C3159aa.m10962a().m10979a("msisdn", ""), strM10979a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m8398a(EnumC2124ab enumC2124ab, String str) {
        m8417f();
        if (C3250y.f11734b) {
            C3250y.m11450b("network error, type : " + enumC2124ab.toString() + " errorCode : " + str, this.f8113b);
        }
        if (GlobalApplication.m11493l() != null) {
            this.f8105J = AbstractC3271a.m11494a(this.f8118g).mo11500a(getResources().getString(R.string.toast_error)).mo11509b(C3171am.m11046a(getResources().getString(R.string.toast_network_unable), getResources().getString(R.string.toast_error), str)).mo11515d(R.string.setting_selfsms_retry, new DialogInterfaceOnClickListenerC2298o(this, enumC2124ab)).mo11507b(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC2297n(this, enumC2124ab)).mo11505a();
            if (!this.f8101F) {
                this.f8105J.show();
            }
        }
    }

    /* renamed from: f */
    private void m8417f() {
        if (C3250y.f11734b) {
            C3250y.m11450b("dismissProgressBar, progressBar : " + (this.f8124m == null ? this.f8124m : Boolean.valueOf(this.f8124m.isShowing())) + " mMultiDeviceDialog : " + (this.f8125n == null ? this.f8125n : Boolean.valueOf(this.f8125n.isShowing())), this.f8113b);
        }
        if (this.f8124m != null && this.f8124m.isShowing()) {
            this.f8124m.dismiss();
        }
        if (this.f8125n != null && this.f8125n.isShowing()) {
            this.f8125n.dismiss();
            this.f8102G = null;
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getDefaultTheme() {
        return R.style.AppTheme_Dialog;
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.chaton.util.InterfaceC3226cn
    public int getBlackTheme() {
        return R.style.AppTheme_Dialog;
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveCreateAccount(boolean z, String str) throws UnsupportedEncodingException {
        if (C3250y.f11734b) {
            C3250y.m11450b("onReceiveCreateAccount : " + this.f8131t, this.f8113b);
        }
        if (this.f8131t) {
            this.f8128q.m5723a("voip", 1, false);
            return;
        }
        new C2160bk().m8674a();
        m8399a(getResources().getString(R.string.auto_regi_buddy_sync));
        C1357af.m5988a();
        this.f8128q.m5717a();
        this.f8128q.m5736c();
    }

    @Override // com.coolots.sso.p006a.InterfaceC0047c
    public void onReceiveRemoveAccount(boolean z) {
    }
}
