package com.sec.chaton;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.base.C0240a;
import com.sec.chaton.buddy.BuddyActivity2;
import com.sec.chaton.buddy.BuddyFragment;
import com.sec.chaton.buddy.BuddyGroupEditActivity;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.buddy.honeycomb.BuddySelectFragment;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.coolots.AbstractC0521a;
import com.sec.chaton.coolots.GetPolicyInfoStartService;
import com.sec.chaton.for3rd.AddonStatusService;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p015d.C0629as;
import com.sec.chaton.p015d.p016a.C0577br;
import com.sec.chaton.p015d.p016a.C0598n;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.p017e.p018a.C0668l;
import com.sec.chaton.p017e.p019b.C0686m;
import com.sec.chaton.p028io.entry.GetVersionNotice;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.trunk.TrunkView;
import com.sec.chaton.util.AsyncTaskC1787s;
import com.sec.chaton.util.C1721ad;
import com.sec.chaton.util.C1741ax;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1788t;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.util.InterfaceC1745ba;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.text.SimpleDateFormat;

/* loaded from: classes.dex */
public class HomeActivity extends BaseMultiPaneActivity {

    /* renamed from: a */
    public static final String f213a = HomeActivity.class.getSimpleName();

    /* renamed from: m */
    private BroadcastReceiver f222m;

    /* renamed from: o */
    private C1741ax f224o;

    /* renamed from: i */
    private boolean f218i = false;

    /* renamed from: j */
    private String[] f219j = new String[2];

    /* renamed from: k */
    private int f220k = 0;

    /* renamed from: l */
    private boolean f221l = false;

    /* renamed from: n */
    private AccountManagerCallback f223n = new C1796w(this);

    /* renamed from: p */
    private InterfaceC1745ba f225p = new C0200aa(this);

    /* renamed from: q */
    private InterfaceC1745ba f226q = new C0202ac(this);

    /* renamed from: r */
    private InterfaceC1745ba f227r = new C0213ad(this);

    /* renamed from: s */
    private InterfaceC1745ba f228s = new C0214ae(this);

    /* renamed from: t */
    private InterfaceC1745ba f229t = new C0215af(this);

    /* renamed from: u */
    private InterfaceC1745ba f230u = new C0216ag(this);

    /* renamed from: v */
    private InterfaceC1745ba f231v = new C1067o(this);

    /* renamed from: w */
    private InterfaceC1745ba f232w = new C1068p(this);

    /* renamed from: x */
    private InterfaceC1745ba f233x = new C1142q(this);

    /* renamed from: y */
    private InterfaceC1745ba f234y = new C1143r(this);

    /* renamed from: b */
    Runnable f214b = new RunnableC1214s(this);

    /* renamed from: c */
    Handler f215c = new HandlerC1621u(this, Looper.getMainLooper());

    /* renamed from: d */
    Handler f216d = new HandlerC1795v(this, Looper.getMainLooper());

    /* renamed from: e */
    Handler f217e = new HandlerC1808x(this, Looper.getMainLooper());

    /* renamed from: z */
    private Handler f235z = new HandlerC1809y(this);

    /* renamed from: a */
    public static Intent m585a(Context context, boolean z) {
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

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        HomeTabletFragment homeTabletFragment = (HomeTabletFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_home_tablet);
        if (homeTabletFragment != null && i == 82 && homeTabletFragment.isResumed() && homeTabletFragment.f253a != null) {
            homeTabletFragment.m647b();
            if (homeTabletFragment.f253a.getVisibility() == 0) {
                homeTabletFragment.f253a.requestFocus();
            }
            return true;
        }
        if (i == 4) {
            if ((getSupportFragmentManager().findFragmentById(R.id.fragment_container) instanceof ChatFragment) && !((ChatFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container)).isBackKeyIgnore()) {
                return true;
            }
            if (getSupportFragmentManager().findFragmentById(R.id.fragment_container) instanceof TrunkView) {
                ((TrunkView) getSupportFragmentManager().findFragmentById(R.id.fragment_container)).m5353e();
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6063c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m594c() + ", isAccountAdded=" + this.f218i, getClass().getSimpleName());
        m603g();
        this.f218i = false;
        m611b();
        m589a(false);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.sec.chaton.ACTION_EXIT_APP");
        if (this.f222m == null) {
            this.f222m = new C1066n(this);
            LocalBroadcastManager.getInstance(GlobalApplication.m3260b()).registerReceiver(this.f222m, intentFilter);
        }
        this.f224o = new C1741ax();
        this.f224o.m5931a("recommendee_sync", this.f228s, 10800000L, "last_recommendee_sync_time");
        this.f224o.m5931a("interaction_sync", this.f232w, 1800000L, "last_Interaction_sync_time");
        this.f224o.m5931a("set_compatibility", this.f231v, 3600000L, "last_compatibility_time");
        this.f224o.m5931a("notification", this.f229t, 1800000L, "last_sync_time_notification");
        this.f224o.m5931a("get_all_buddies", this.f233x, 10800000L, "last_sync_time_get_all_buddies");
        this.f224o.m5931a("local_calculation", this.f234y, 60000L, "last_sync_time_on_start");
        this.f224o.m5931a("get_push_status", this.f225p, 60000L, "last_sync_time_get_push_status");
        this.f224o.m5931a("get_trunk_list", this.f227r, 600000L, "last_sync_time_get_trunk_list");
        this.f224o.m5931a("version_notice", this.f230u, 600000L, "last_sync_time_get_version_notice");
        C1786r.m6061b("onCreate : set setShowPasswordLock value", getClass().getSimpleName());
        if (getIntent().getBooleanExtra("extra_from_chaton", false)) {
            C1781m.m6018a(false);
        } else {
            C1781m.m6018a(true);
        }
    }

    /* renamed from: a */
    private void m589a(boolean z) {
        if (!ExitAppDialogActivity.m580a()) {
            if (getIntent().getBooleanExtra("callBuddyProfile", false)) {
                m592b(z);
                return;
            }
            if (C1789u.m6075a().contains("uid") && !C1789u.m6075a().getBoolean("UpdateIsCritical", false)) {
                switch (C1810z.f6502a[C0835l.m3481a(getIntent(), this).ordinal()]) {
                    case 1:
                        m592b(z);
                        break;
                    case 2:
                        m604h();
                        break;
                }
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() throws PackageManager.NameNotFoundException {
        super.onStart();
        C1786r.m6063c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m594c() + ", isAccountAdded=" + this.f218i, getClass().getSimpleName());
        this.f221l = true;
        if (C1789u.m6075a().getBoolean("UpdateIsCritical", false)) {
            m595c(true);
            new C0629as(this.f215c).m2834c();
        } else {
            this.f224o.m5929a();
            if (C1789u.m6075a().contains("uid") && this.f218i) {
                m598e();
                this.f218i = false;
            }
        }
        boolean zM2697a = AbstractC0521a.m2697a(this);
        String strM2768g = C0577br.m2768g();
        if (zM2697a) {
            if (strM2768g != null && strM2768g.contains("voip=1")) {
                C1786r.m6063c("chaton v: installed ", " Extra info already set");
            } else {
                Intent intent = new Intent(this, (Class<?>) AddonStatusService.class);
                intent.putExtra("package_name", "com.coolots.chaton");
                intent.putExtra("need_update", true);
                startService(intent);
            }
            if (C1789u.m6075a().getInt("group_voice_call_max_count", 0) > 0) {
                startService(new Intent(this, (Class<?>) GetPolicyInfoStartService.class));
            }
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws PackageManager.NameNotFoundException {
        super.onResume();
        if (!this.f221l) {
            onStart();
        }
        this.f221l = false;
        C1786r.m6063c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m594c(), getClass().getSimpleName());
        if (!BaseActivity.f773h) {
            m607k();
        }
        BaseActivity.f773h = false;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        C1786r.m6063c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m594c(), getClass().getSimpleName());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        C1786r.m6063c("[LIFE] onStop, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m594c(), getClass().getSimpleName());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C1786r.m6063c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m594c(), getClass().getSimpleName());
        if (this.f222m != null) {
            LocalBroadcastManager.getInstance(GlobalApplication.m3260b()).unregisterReceiver(this.f222m);
            this.f222m = null;
        }
    }

    /* renamed from: c */
    private String m594c() {
        String str = getIntent().getAction() != null ? ", Intent Action: " + getIntent().getAction() : ", Intent Action: Null";
        if (getIntent().getCategories() != null) {
            return str + ", Intent Category: " + getIntent().getCategories().toString();
        }
        return str + ", Intent Category: Null";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m597d() {
        C0668l.m3077a(new C0668l(), -1, new C0686m(null, new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis())), null));
    }

    public class SendCrashLogFragment extends Fragment {

        /* renamed from: a */
        public static final String f236a = SendCrashLogFragment.class.getSimpleName();

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            new AsyncTaskC1787s().execute(new Void[0]);
        }
    }

    /* renamed from: a */
    public boolean m610a() {
        Account[] accountsByType = AccountManager.get(GlobalApplication.m3260b()).getAccountsByType("com.sec.chaton");
        if (0 < accountsByType.length) {
            Account account = accountsByType[0];
            return true;
        }
        if (!C1789u.m6075a().contains("uid")) {
            return false;
        }
        C0598n.m2784f();
        return false;
    }

    /* renamed from: b */
    public void m611b() {
        getSupportFragmentManager();
        if (!C1789u.m6075a().contains("uid") || !m610a()) {
            AccountManager.get(this).addAccount("com.sec.chaton", null, null, null, this, this.f223n, null);
            this.f218i = true;
            return;
        }
        m598e();
        if (!C1789u.m6075a().getBoolean("PacketDataDialg", false) && C1721ad.m5875b().booleanValue()) {
            if (GlobalApplication.m3265f()) {
                if (getSupportFragmentManager().findFragmentByTag(DataPacketDialog2.f208a) == null) {
                    new DataPacketDialog2().show(getSupportFragmentManager(), DataPacketDialog2.f208a);
                    return;
                }
                return;
            }
            startActivity(new Intent(this, (Class<?>) DataPacketDialog.class));
        }
    }

    /* renamed from: e */
    private void m598e() {
        C1786r.m6063c("[LIFE] initView, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m594c() + ", isAccountAdded=" + this.f218i, getClass().getSimpleName());
        setContentView(R.layout.activity_home);
        if (ExitAppDialogActivity.m580a()) {
            startActivity(new Intent(this, (Class<?>) ExitAppDialogActivity.class));
        }
    }

    /* renamed from: f */
    private void m600f() {
        if (getIntent().getBooleanExtra("callRestart", false)) {
            finish();
            startActivity(new Intent(this, (Class<?>) HomeActivity.class));
        }
    }

    /* renamed from: g */
    private void m603g() {
        if (getIntent().getBooleanExtra("finish", false)) {
            finish();
        }
    }

    /* renamed from: b */
    private boolean m592b(boolean z) {
        Intent intent = getIntent();
        C1786r.m6063c("Shortcut or Notification: " + intent.getBooleanExtra("callChatList", false), getClass().getSimpleName());
        if (intent.getBooleanExtra("callChatList", false)) {
            intent.putExtra("callChatList", false);
            intent.setClass(this, ChatActivity.class);
            intent.setFlags(67108864);
            if (!GlobalApplication.m3265f()) {
                startActivity(intent);
            } else {
                intent.putExtra("callChat", true);
                if (z) {
                    HomeTabletFragment homeTabletFragment = (HomeTabletFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_home_tablet);
                    if (homeTabletFragment != null) {
                        homeTabletFragment.m645a(getIntent().getExtras());
                        intent.putExtra("callChat", false);
                    } else {
                        C1786r.m6061b("fragment is null", getClass().getSimpleName());
                    }
                }
            }
            return true;
        }
        if (intent.getBooleanExtra("callBuddyProfile", false)) {
            intent.putExtra("callBuddyProfile", false);
            intent.setClass(this, BuddyProfileActivity.class);
            intent.setFlags(67108864);
            if (!GlobalApplication.m3265f()) {
                startActivity(intent);
            } else if (z) {
                HomeTabletFragment homeTabletFragment2 = (HomeTabletFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_home_tablet);
                if (homeTabletFragment2 != null) {
                    homeTabletFragment2.m648b(getIntent().getExtras());
                } else {
                    C1786r.m6061b("fragment is null", getClass().getSimpleName());
                }
            }
            return true;
        }
        if (EnumC0695j.m3145a(intent.getIntExtra("chatType", -1)) == EnumC0695j.WEB_AUTH) {
            C1788t.m6070a(this).m6073a(0);
            AlertDialog alertDialogCreate = new AlertDialogBuilderC2120a(this).setTitle(R.string.app_name).setMessage(intent.getStringExtra("Content")).setIcon(R.drawable.popup_chat_icon).setPositiveButton(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1511t(this)).create();
            if (!isFinishing()) {
                alertDialogCreate.show();
            }
        }
        return false;
    }

    /* renamed from: h */
    private boolean m604h() {
        Intent intent = getIntent();
        C1786r.m6063c("Shortcut or Notification: " + intent.getBooleanExtra("callChatList", false), getClass().getSimpleName());
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
        C1786r.m6063c("[LIFE] onNewIntent, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m594c(), getClass().getSimpleName());
        setIntent(intent);
        m589a(true);
        m603g();
        m600f();
        if (C1781m.m6024b()) {
            C1781m.m6018a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m588a(GetVersionNotice getVersionNotice, boolean z) {
        boolean z2 = true;
        boolean zBooleanValue = getVersionNotice.critical.booleanValue();
        if (!zBooleanValue && C1789u.m6075a().contains("UpdateIsCritical") && C1789u.m6075a().getString("UpdateTargetVersion", "").equals(getVersionNotice.newversion)) {
            z2 = false;
        }
        C1789u.m6075a().edit().putString("UpdateTargetVersion", getVersionNotice.newversion).commit();
        C1789u.m6075a().edit().putBoolean("UpdateIsCritical", zBooleanValue).commit();
        C1789u.m6075a().edit().putString("UpdateUrl", getVersionNotice.downloadurl).commit();
        C1789u.m6075a().edit().putString("SamsungappsUrl", getVersionNotice.samsungappsurl).commit();
        if (z2 && z) {
            m595c(zBooleanValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m591b(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public String m605i() {
        return C1789u.m6075a().getString("update_disclaimer_status", "");
    }

    /* renamed from: c */
    private void m595c(boolean z) {
        Intent intent = new Intent(this, (Class<?>) UpgradeDialog.class);
        intent.putExtra("isCritical", z);
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m606j() {
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(new Intent("com.sec.chaton.ACTION_DISMISS"));
    }

    @Override // com.sec.chaton.base.BaseMultiPaneActivity
    /* renamed from: a */
    protected C0240a mo608a(String str) {
        if (findViewById(R.id.fragment_container) != null) {
            if (ChatActivity.class.getName().equals(str)) {
                return new C0240a(this, ChatFragment.class, "container", R.id.fragment_container);
            }
            if (BuddyGroupEditActivity.class.getName().equals(str)) {
                return new C0240a(this, BuddySelectFragment.class, "container", R.id.fragment_container);
            }
            if (BuddyActivity2.class.getName().equals(str)) {
                return new C0240a(this, BuddyFragment.class, "container", R.id.fragment_container);
            }
        }
        return super.mo608a(str);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        HomeTabletFragment homeTabletFragment = (HomeTabletFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_home_tablet);
        if (homeTabletFragment == null || !homeTabletFragment.isResumed() || homeTabletFragment.m646a(motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.sec.chaton.base.BaseActivity, android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", f213a);
        C1781m.m6022b(getApplicationContext());
    }

    /* renamed from: a */
    public String m609a(Context context) {
        String className = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getClassName();
        C1786r.m6061b("getClassName : " + className, "HomeActivity");
        return className;
    }

    /* renamed from: k */
    private void m607k() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
