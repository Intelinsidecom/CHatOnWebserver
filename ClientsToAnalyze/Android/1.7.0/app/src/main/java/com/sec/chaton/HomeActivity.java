package com.sec.chaton;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.telephony.TelephonyManager;
import android.view.Menu;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.base.C0353a;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.coolots.AbstractC0617h;
import com.sec.chaton.coolots.GetPolicyInfoStartService;
import com.sec.chaton.for3rd.AddonStatusService;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.C0218q;
import com.sec.chaton.p013a.p014a.C0159bh;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.p025d.p026a.C0627g;
import com.sec.chaton.p025d.p027b.C0640c;
import com.sec.chaton.p029f.C0684a;
import com.sec.chaton.p033io.entry.GetVersionNotice;
import com.sec.chaton.util.AsyncTaskC1321bq;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1326bv;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1332g;
import com.sec.chaton.util.C1336k;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.InterfaceC1288ak;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1632t;
import java.io.IOException;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public class HomeActivity extends BaseMultiPaneActivity {

    /* renamed from: e */
    private BroadcastReceiver f251e;

    /* renamed from: k */
    private C1326bv f256k;

    /* renamed from: d */
    private boolean f250d = false;

    /* renamed from: f */
    private boolean f252f = false;

    /* renamed from: g */
    private String f253g = C1323bs.m4575a().getString("update_disclaimer_status", "");

    /* renamed from: i */
    private boolean f254i = false;

    /* renamed from: j */
    private AccountManagerCallback f255j = new C0619d(this);

    /* renamed from: l */
    private InterfaceC1288ak f257l = new C0673e(this);

    /* renamed from: m */
    private InterfaceC1288ak f258m = new C0683f(this);

    /* renamed from: n */
    private InterfaceC1288ak f259n = new C0708g(this);

    /* renamed from: o */
    private InterfaceC1288ak f260o = new C0715h(this);

    /* renamed from: p */
    private InterfaceC1288ak f261p = new C0721i(this);

    /* renamed from: q */
    private InterfaceC1288ak f262q = new C0724j(this);

    /* renamed from: r */
    private InterfaceC1288ak f263r = new C0924q(this);

    /* renamed from: s */
    private InterfaceC1288ak f264s = new C0925r(this);

    /* renamed from: t */
    private InterfaceC1288ak f265t = new C0995s(this);

    /* renamed from: u */
    private InterfaceC1288ak f266u = new C0846n(this);

    /* renamed from: a */
    Runnable f247a = new RunnableC0847o(this);

    /* renamed from: b */
    Handler f248b = new HandlerC1095t(this, Looper.getMainLooper());

    /* renamed from: c */
    Handler f249c = new HandlerC1201u(this, Looper.getMainLooper());

    /* renamed from: a */
    public static Intent m630a(Context context, boolean z) {
        Intent intent = new Intent(context, (Class<?>) HomeActivity.class);
        if (z) {
            intent.putExtra("callChatList", true);
        } else {
            intent.putExtra("callChatList", false);
        }
        intent.setFlags(65536);
        intent.setFlags(67108864);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        return intent;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1341p.m4660c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m640c() + ", isAccountAdded=" + this.f250d, getClass().getSimpleName());
        C1341p.m4658b("savedInstanceState : " + bundle, getClass().getSimpleName());
        this.f254i = m650g();
        if (!this.f254i) {
            if (C0684a.f2334e) {
                C1341p.m4658b("Welcome, First Time after update ChatON", getClass().getSimpleName());
                m653i();
                C1323bs.m4579a("chaton_version", C0684a.f2331b);
                C0684a.f2334e = false;
            }
            this.f250d = false;
            if (bundle != null) {
                this.f252f = true;
            }
            if (!C1323bs.m4575a().getBoolean("UpdateIsCritical", false)) {
                if (this.f253g.equals("RUN") && !this.f252f) {
                    m641c(C1323bs.m4575a().getString("disclaimer_ID", ""));
                    C1341p.m4658b("show disclaimer in starting time", getClass().getSimpleName());
                }
                m656a();
            } else {
                setContentView(R.layout.layout_settings_starting);
                findViewById(R.id.progress).setVisibility(4);
                findViewById(R.id.loading).setVisibility(4);
                findViewById(R.id.samsung_ltd).setVisibility(0);
            }
            m633a(false);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.sec.chaton.ACTION_EXIT_APP");
            if (this.f251e == null) {
                this.f251e = new C0462c(this);
                LocalBroadcastManager.getInstance(GlobalApplication.m3100a()).registerReceiver(this.f251e, intentFilter);
            }
            this.f256k = new C1326bv();
            this.f256k.m4593a("get_chaton_crypto_key", this.f266u, 60000L, "last_sync_time_get_chaton_crypto_key");
            this.f256k.m4593a("local_calculation", this.f257l, 60000L, "last_sync_time_on_start");
            this.f256k.m4593a("get_push_status", this.f260o, 60000L, "last_sync_time_get_push_status");
            this.f256k.m4593a("version_notice", this.f263r, 600000L, "last_sync_time_get_version_notice");
            this.f256k.m4593a("get_trunk_list", this.f262q, 600000L, "last_sync_time_get_trunk_list");
            this.f256k.m4593a("get_all_buddies", this.f258m, 600000L, "last_sync_time_get_all_buddies");
            this.f256k.m4593a("get_chatonv_download", this.f259n, 600000L, "last_sync_time_get_chatonv_download");
            this.f256k.m4593a("recommendee_sync", this.f264s, 10800000L, "last_recommendee_sync_time");
            this.f256k.m4593a("interaction_sync", this.f265t, 1800000L, "last_Interaction_sync_time");
        }
    }

    /* renamed from: a */
    private void m633a(boolean z) {
        if (!ExitAppDialogActivity.m624a() && C1323bs.m4575a().contains("uid") && !C1323bs.m4575a().getBoolean("UpdateIsCritical", false) && !this.f253g.equals("RUN")) {
            switch (C0727m.f2455a[C0725k.m3124a(getIntent(), this).ordinal()]) {
                case 1:
                    m638b(z);
                    break;
                case 2:
                    m652h();
                    break;
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() throws PackageManager.NameNotFoundException {
        super.onStart();
        C1341p.m4660c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m640c() + ", isAccountAdded=" + this.f250d, getClass().getSimpleName());
        if (C1323bs.m4575a().getBoolean("UpdateIsCritical", false)) {
            m642c(true);
            new C0218q(this.f248b).m801b();
        } else {
            this.f256k.m4592a();
            if (C1323bs.m4575a().contains("uid") && this.f250d) {
                m645e();
                this.f250d = false;
            }
        }
        boolean zM2831a = AbstractC0617h.m2831a(this);
        String strM693f = C0159bh.m693f();
        if (zM2831a) {
            if (strM693f != null && strM693f.contains("voip=1")) {
                C1341p.m4660c("chaton v: installed ", " Extra info already set");
            } else {
                Intent intent = new Intent(this, (Class<?>) AddonStatusService.class);
                intent.putExtra("package_name", "com.coolots.chaton");
                intent.putExtra("need_update", true);
                startService(intent);
            }
            if (C1323bs.m4575a().getInt("group_voice_call_max_count", 0) > 0) {
                startService(new Intent(this, (Class<?>) GetPolicyInfoStartService.class));
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        C1341p.m4660c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m640c(), getClass().getSimpleName());
        if (!C1327bw.m4597c() && !ExitAppDialogActivity.m624a()) {
            ExitAppDialogActivity.m623a(1);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C1341p.m4660c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m640c(), getClass().getSimpleName());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        C1341p.m4660c("[LIFE] onStop, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m640c(), getClass().getSimpleName());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C1341p.m4660c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m640c(), getClass().getSimpleName());
        if (this.f251e != null) {
            LocalBroadcastManager.getInstance(GlobalApplication.m3100a()).unregisterReceiver(this.f251e);
            this.f251e = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m634b(String str) {
        if (str == null) {
        }
        String strSubstring = str.substring(str.indexOf("<appInfo>"));
        return strSubstring.charAt("<resultCode>".length() + strSubstring.indexOf("<resultCode>")) - '0';
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m635b() {
        String strM4636m;
        String simOperator;
        String strM4625c = C1336k.m4625c();
        String strSubstring = "1";
        String strSubstring2 = "1";
        String str = Build.VERSION.SDK;
        TelephonyManager telephonyManager = (TelephonyManager) GlobalApplication.m3100a().getSystemService("phone");
        if (telephonyManager.getSimState() == 5 && (simOperator = telephonyManager.getSimOperator()) != null && simOperator.length() != 0) {
            strSubstring = simOperator.substring(0, 3);
            strSubstring2 = simOperator.substring(3);
        }
        try {
            strM4636m = C1336k.m4636m();
        } catch (IOException e) {
            C1341p.m4658b("there is exception ", getClass().getSimpleName());
            e.printStackTrace();
            strM4636m = "";
        }
        return "http://hub.samsungapps.com/product/appCheck.as?appInfo=com.coolots.chaton@0&deviceId=" + strM4625c + "&mcc=" + strSubstring + "&mnc=" + strSubstring2 + "&csc=" + strM4636m + "&openApi=" + str;
    }

    /* renamed from: c */
    private String m640c() {
        String str = getIntent().getAction() != null ? ", Intent Action: " + getIntent().getAction() : ", Intent Action: Null";
        if (getIntent().getCategories() != null) {
            return str + ", Intent Category: " + getIntent().getCategories().toString();
        }
        return str + ", Intent Category: Null";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m644d() {
        C0627g.m2858a(new C0627g(), -1, new C0640c(null, new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis())), null));
    }

    public class SendCrashLogFragment extends Fragment {

        /* renamed from: a */
        public static final String f267a = SendCrashLogFragment.class.getSimpleName();

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            new AsyncTaskC1321bq().execute(new Void[0]);
        }
    }

    /* renamed from: a */
    public void m656a() {
        if (!C1323bs.m4575a().contains("uid")) {
            if (!this.f252f) {
                AccountManager.get(this).addAccount("com.sec.chaton", null, null, null, this, this.f255j, null);
                this.f250d = true;
                return;
            } else {
                finish();
                return;
            }
        }
        m645e();
        if (!C1323bs.m4575a().getBoolean("PacketDataDialg", false) && C1336k.m4623b() && !this.f252f && !getIntent().getBooleanExtra("extra_from_chaton", false)) {
            startActivity(new Intent(this, (Class<?>) DataPacketDialog.class));
        }
    }

    /* renamed from: e */
    private void m645e() {
        C1341p.m4660c("[LIFE] initView, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m640c() + ", isAccountAdded=" + this.f250d, getClass().getSimpleName());
        setContentView(R.layout.activity_home);
        if (ExitAppDialogActivity.m624a()) {
            startActivity(new Intent(this, (Class<?>) ExitAppDialogActivity.class));
        }
    }

    /* renamed from: f */
    private void m647f() {
        if (getIntent().getBooleanExtra("callRestart", false)) {
            finish();
            startActivity(new Intent(this, (Class<?>) HomeActivity.class));
        }
    }

    /* renamed from: g */
    private boolean m650g() {
        Intent intent = getIntent();
        if (!intent.getBooleanExtra("finish", false) || (intent.getFlags() & 1048576) == 1048576) {
            return false;
        }
        finish();
        return true;
    }

    /* renamed from: b */
    private boolean m638b(boolean z) {
        Intent intent = getIntent();
        C1341p.m4660c("Shortcut or Notification: " + intent.getBooleanExtra("callChatList", false), getClass().getSimpleName());
        if (intent.getBooleanExtra("callChatList", false)) {
            intent.putExtra("callChatList", false);
            intent.setClass(this, ChatActivity.class);
            intent.setFlags(67108864);
            startActivity(intent);
            return true;
        }
        if (EnumC0665r.m3011a(intent.getIntExtra("chatType", -1)) == EnumC0665r.WEB_AUTH) {
            C1332g.m4605a(this).m4610a(0);
            new AlertDialogBuilderC1625m(this).setTitle(R.string.app_name).setMessage(intent.getStringExtra("Content")).setIcon(R.drawable.popup_chat_icon).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC0848p(this)).create().show();
        }
        return false;
    }

    /* renamed from: h */
    private boolean m652h() {
        Intent intent = getIntent();
        C1341p.m4660c("Shortcut or Notification: " + intent.getBooleanExtra("callChatList", false), getClass().getSimpleName());
        if (!intent.getBooleanExtra("callForward", false)) {
            return false;
        }
        intent.putExtra("callForward", false);
        intent.setClass(this, ChatForwardActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        if (!getIntent().getBooleanExtra("extra_from_chaton", false)) {
            return true;
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        C1341p.m4660c("[LIFE] onNewIntent, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m640c(), getClass().getSimpleName());
        setIntent(intent);
        Intent intent2 = getIntent();
        if (!C1323bs.m4575a().contains("uid") && !intent2.getBooleanExtra("callRestart", false) && !intent2.getBooleanExtra("finish", false)) {
            m656a();
        }
        m633a(true);
        m650g();
        m647f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m653i() {
        C1323bs.m4575a().edit().remove("UpdateIsCritical").commit();
        C1323bs.m4575a().edit().remove("UpdateTargetVersion").commit();
        C1323bs.m4575a().edit().remove("UpdateUrl").commit();
        C1323bs.m4575a().edit().remove("SamsungappsUrl").commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m632a(GetVersionNotice getVersionNotice, boolean z) {
        boolean z2 = true;
        boolean zBooleanValue = getVersionNotice.critical.booleanValue();
        if (!zBooleanValue && C1323bs.m4575a().contains("UpdateIsCritical") && C1323bs.m4575a().getString("UpdateTargetVersion", "").equals(getVersionNotice.newversion)) {
            z2 = false;
        }
        C1323bs.m4575a().edit().putString("UpdateTargetVersion", getVersionNotice.newversion).commit();
        C1323bs.m4575a().edit().putBoolean("UpdateIsCritical", zBooleanValue).commit();
        C1323bs.m4575a().edit().putString("UpdateUrl", getVersionNotice.downloadurl).commit();
        C1323bs.m4575a().edit().putString("SamsungappsUrl", getVersionNotice.samsungappsurl).commit();
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent("setting_tab_badge_update"));
        if (z2 && z) {
            m642c(zBooleanValue);
        }
    }

    /* renamed from: c */
    private void m642c(boolean z) {
        Intent intent = new Intent(this, (Class<?>) UpgradeDialog.class);
        intent.putExtra("isCritical", z);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m641c(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m654j() {
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent("com.sec.chaton.ACTION_DISMISS"));
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent("setting_tab_badge_update"));
    }

    @Override // com.sec.chaton.base.BaseMultiPaneActivity
    /* renamed from: a */
    protected C0353a mo655a(String str) {
        if (findViewById(R.id.fragment_container) != null) {
        }
        return super.mo655a(str);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        if (!C1632t.m5917c()) {
            return super.onMenuOpened(i, menu);
        }
        ((BuddyFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_buddy)).m2206h();
        return false;
    }
}
