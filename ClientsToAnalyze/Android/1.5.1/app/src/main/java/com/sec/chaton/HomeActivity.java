package com.sec.chaton;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import com.sec.chaton.account.ContactManager;
import com.sec.chaton.base.BaseMultiPaneActivity;
import com.sec.chaton.chat.ChatActivity;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.control.HttpMessageControl;
import com.sec.chaton.control.PushControlFactory;
import com.sec.chaton.control.VersionControl;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.database.helper.InBoxDatabaseHelper;
import com.sec.chaton.database.helper.NotifyingAsyncTaskWorker;
import com.sec.chaton.database.task.RelationUpdateTask;
import com.sec.chaton.forward.ChatForwardActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p000io.entry.GetVersion3;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ChatONNotificationManager;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ServerAddressMgr;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class HomeActivity extends BaseMultiPaneActivity {

    /* renamed from: e */
    private Handler f295e;

    /* renamed from: f */
    private boolean f296f = false;

    /* renamed from: g */
    private AccountManagerCallback f297g = new C0070b(this);

    /* renamed from: a */
    Runnable f291a = new RunnableC0212d(this);

    /* renamed from: b */
    Handler f292b = new HandlerC0218f(this, Looper.getMainLooper());

    /* renamed from: c */
    Handler f293c = new HandlerC0236g(this, Looper.getMainLooper());

    /* renamed from: d */
    Handler f294d = new HandlerC0239h(this, Looper.getMainLooper());

    public class SendCrashLogFragment extends Fragment {

        /* renamed from: a */
        public static final String f298a = SendCrashLogFragment.class.getSimpleName();

        @Override // android.support.v4.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            new ChatONLogWriter.LogUploadTask().execute(new Void[0]);
        }
    }

    /* renamed from: a */
    public static Intent m358a(Context context, boolean z) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m361a(GetVersion3 getVersion3, boolean z) {
        boolean z2 = false;
        boolean zBooleanValue = getVersion3.critical.booleanValue();
        if (zBooleanValue || !ChatONPref.m3519a().contains("UpdateIsCritical") || !ChatONPref.m3519a().getString("UpdateTargetVersion", "").equals(getVersion3.newversion)) {
            z2 = true;
        }
        ChatONPref.m3519a().edit().putString("UpdateTargetVersion", getVersion3.newversion).commit();
        ChatONPref.m3519a().edit().putBoolean("UpdateIsCritical", zBooleanValue).commit();
        ChatONPref.m3519a().edit().putString("UpdateUrl", getVersion3.downloadurl).commit();
        ChatONPref.m3519a().edit().putString("SamsungappsUrl", getVersion3.samsungappsurl).commit();
        if (z2 && z) {
            m362a(zBooleanValue);
        }
    }

    /* renamed from: a */
    private void m362a(boolean z) {
        Intent intent = new Intent(this, (Class<?>) UpgradeDialog.class);
        intent.putExtra("wantShow", true);
        intent.putExtra("isCritical", z);
        startActivity(intent);
    }

    /* renamed from: b */
    private void m364b() {
        if (!ChatONPref.m3519a().contains("uid") || ChatONPref.m3519a().getBoolean("UpdateIsCritical", false)) {
            return;
        }
        switch (C0240i.f1908a[HandleIntent.m357a(getIntent(), this).ordinal()]) {
            case 1:
                m375k();
                break;
            case 2:
                m376l();
                break;
        }
    }

    /* renamed from: c */
    private String m366c() {
        String str = getIntent().getAction() != null ? ", Intent Action: " + getIntent().getAction() : ", Intent Action: Null";
        return getIntent().getCategories() != null ? str + ", Intent Category: " + getIntent().getCategories().toString() : str + ", Intent Category: Null";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m368d() {
        synchronized (HomeActivity.class) {
            long j = ChatONPref.m3519a().getLong("last_sync_time_on_start", 0L);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            ChatONLogWriter.m3506b("Sync check at onStart - last=" + j + ", cur=" + jElapsedRealtime + ", diff=" + (jElapsedRealtime - j), getClass().getSimpleName());
            if (j == 0 || jElapsedRealtime < j || jElapsedRealtime - j > 60000) {
                ChatONLogWriter.m3506b("Sync start at onStart", getClass().getSimpleName());
                m369e();
                ChatONPref.m3522a("last_sync_time_on_start", Long.valueOf(jElapsedRealtime));
            }
        }
    }

    /* renamed from: e */
    private void m369e() {
        new VersionControl(this.f293c).m2096c();
        if (ChatONPref.m3519a().contains("uid")) {
            if (GlobalApplication.f1895b == null) {
                PushControlFactory.m2072a().mo1974a(new HandlerC0134c(this, Looper.getMainLooper()));
            }
            ContactManager.m403a();
            new HttpMessageControl(new Handler()).m2002a();
            TrunkMessageControl trunkMessageControl = new TrunkMessageControl(GlobalApplication.m2387e(), new Handler());
            ArrayList arrayListM2248a = InBoxDatabaseHelper.m2248a(GlobalApplication.m2387e().getContentResolver());
            if (arrayListM2248a.size() > 0) {
                trunkMessageControl.retrieveTrunkList(arrayListM2248a);
            }
            ServerAddressMgr.m3631b();
            m370f();
        }
    }

    /* renamed from: f */
    private void m370f() {
        String string = ChatONPref.m3519a().getString("relationUpdateTime", "");
        String str = new SimpleDateFormat("yyyy-MM-dd HH").format(Long.valueOf(System.currentTimeMillis()));
        if (string.equals(str)) {
            return;
        }
        m371g();
        ChatONPref.m3523a("relationUpdateTime", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m371g() {
        NotifyingAsyncTaskWorker.m2304a(new NotifyingAsyncTaskWorker(), -1, new RelationUpdateTask(null, new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis())), null));
    }

    /* renamed from: h */
    private void m372h() {
        setContentView(C0062R.layout.activity_home);
    }

    /* renamed from: i */
    private void m373i() {
        if (getIntent().getBooleanExtra("callRestart", false)) {
            finish();
            startActivity(new Intent(this, (Class<?>) HomeActivity.class));
        }
    }

    /* renamed from: j */
    private void m374j() {
        if (getIntent().getBooleanExtra("finish", false)) {
            finish();
        }
    }

    /* renamed from: k */
    private boolean m375k() {
        Intent intent = getIntent();
        ChatONLogWriter.m3508c("Shortcut or Notification: " + intent.getBooleanExtra("callChatList", false), getClass().getSimpleName());
        if (!intent.getBooleanExtra("callChatList", false)) {
            if (ChatONContract.InBoxTable.ChatType.m2188a(intent.getIntExtra("chatType", -1)) == ChatONContract.InBoxTable.ChatType.WEB_AUTH) {
                ChatONNotificationManager.m3515a(this).m3517a(0);
                new AlertDialog.Builder(this).setTitle(C0062R.string.app_name).setMessage(intent.getStringExtra("Content")).setIcon(C0062R.drawable.popup_chat_icon).setPositiveButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0217e(this)).create().show();
            }
            return false;
        }
        intent.putExtra("callChatList", false);
        intent.setClass(this, ChatActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        return true;
    }

    /* renamed from: l */
    private boolean m376l() {
        Intent intent = getIntent();
        ChatONLogWriter.m3508c("Shortcut or Notification: " + intent.getBooleanExtra("callChatList", false), getClass().getSimpleName());
        if (!intent.getBooleanExtra("callForward", false)) {
            return false;
        }
        intent.putExtra("callForward", false);
        intent.setClass(this, ChatForwardActivity.class);
        intent.setFlags(67108864);
        startActivity(intent);
        if (getIntent().getBooleanExtra("extra_from_chaton", false)) {
            finish();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m377m() {
        Intent intent = new Intent(this, (Class<?>) UpgradeDialog.class);
        intent.putExtra("wantShow", false);
        startActivity(intent);
    }

    @Override // com.sec.chaton.base.BaseMultiPaneActivity
    /* renamed from: a */
    protected BaseMultiPaneActivity.FragmentReplaceInfo mo378a(String str) {
        if (findViewById(C0062R.id.fragment_container) == null || !ChatActivity.class.getName().equals(str)) {
            return null;
        }
        return new BaseMultiPaneActivity.FragmentReplaceInfo(ChatFragment.class, ChatFragment.f722a, C0062R.id.fragment_container);
    }

    /* renamed from: a */
    public void m379a() {
        getSupportFragmentManager();
        if (!ChatONPref.m3519a().contains("uid")) {
            AccountManager.get(this).addAccount("com.sec.chaton", null, null, null, this, this.f297g, null);
            return;
        }
        m372h();
        if (ChatONPref.m3519a().getBoolean("PacketDataDialg", false)) {
            return;
        }
        startActivity(new Intent(this, (Class<?>) DataPacketDialog.class));
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ChatONLogWriter.m3508c("[LIFE] onCreate, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m366c(), getClass().getSimpleName());
        this.f295e = new Handler();
        m374j();
        this.f296f = false;
        m379a();
        m364b();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ChatONLogWriter.m3508c("[LIFE] onDestroy, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m366c(), getClass().getSimpleName());
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        ChatONLogWriter.m3508c("[LIFE] onNewIntent, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m366c(), getClass().getSimpleName());
        setIntent(intent);
        m364b();
        m374j();
        m373i();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ChatONLogWriter.m3508c("[LIFE] onPause, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m366c(), getClass().getSimpleName());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        ChatONLogWriter.m3508c("[LIFE] onResume, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m366c(), getClass().getSimpleName());
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        ChatONLogWriter.m3508c("[LIFE] onStart, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m366c(), getClass().getSimpleName());
        getSupportFragmentManager();
        if (ChatONPref.m3519a().contains("uid")) {
            if (ChatONPref.m3519a().getBoolean("UpdateIsCritical", false)) {
                m362a(true);
                new VersionControl(this.f292b).m2096c();
                return;
            }
            if (GlobalApplication.f1894a) {
                GlobalApplication.f1894a = false;
                this.f295e.postDelayed(new RunnableC0063a(this), 5000L);
            } else {
                m368d();
            }
            if (ChatONPref.m3519a().contains("uid") && this.f296f) {
                m372h();
                this.f296f = false;
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        ChatONLogWriter.m3508c("[LIFE] onStop, isTaskRoot: " + isTaskRoot() + ", Task ID: " + getTaskId() + ", Memory Address:" + this + m366c(), getClass().getSimpleName());
    }
}
