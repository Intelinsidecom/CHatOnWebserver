package com.sec.vip.amschaton;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.io.File;

/* loaded from: classes.dex */
public class AMSActivity extends Activity {

    /* renamed from: a */
    public static String f12268a;

    /* renamed from: b */
    public static String f12269b;

    /* renamed from: c */
    public static String f12270c;

    /* renamed from: d */
    public static String f12271d;

    /* renamed from: e */
    public static String f12272e;

    /* renamed from: f */
    public static String f12273f;

    /* renamed from: g */
    public static String f12274g;

    /* renamed from: h */
    public static String f12275h;

    /* renamed from: i */
    public static String f12276i;

    /* renamed from: j */
    public static boolean f12277j = false;

    /* renamed from: k */
    public static boolean f12278k = false;

    /* renamed from: m */
    private BroadcastReceiver f12280m;

    /* renamed from: l */
    private boolean f12279l = false;

    /* renamed from: n */
    private boolean f12281n = false;

    /* renamed from: o */
    private boolean f12282o = false;

    /* renamed from: p */
    private Toast f12283p = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f12268a = (C3223ck.m11327a() ? CommonApplication.m11493l().getExternalFilesDir(null).getAbsolutePath() : CommonApplication.m11493l().getFilesDir().getAbsolutePath()) + "/AMS/";
        f12269b = f12268a + "amsbasicfiles/";
        f12270c = f12268a + "amsuserfiles/";
        f12271d = f12268a + "amssentfiles/";
        f12272e = f12268a + "userstamp/";
        f12273f = f12268a + "temp/";
        f12274g = f12273f + "justTempAMS.jpg";
        f12275h = f12273f + "justTempImage.jpg";
        f12276i = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/ChatON/";
        new File(f12268a).mkdirs();
        new File(f12269b).mkdirs();
        new File(f12270c).mkdirs();
        new File(f12271d).mkdirs();
        new File(f12272e).mkdirs();
        new File(f12273f).mkdirs();
        new File(f12276i).mkdirs();
        m11969j();
        m11970k();
    }

    @Override // android.app.Activity
    protected void onPause() {
        m11968i();
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        m11967h();
        super.onResume();
        m11971l();
    }

    /* renamed from: a */
    protected void m11972a() {
        this.f12279l = false;
        if (!m11975c()) {
            C3250y.m11450b("[loadStamp] Resources are already loaded!", getClass().getSimpleName());
            this.f12279l = true;
        } else {
            m11974b();
            this.f12279l = true;
        }
    }

    /* renamed from: b */
    protected void m11974b() {
        C3410al.m12173a().m12184a(this, getAssets(), f12272e);
    }

    /* renamed from: c */
    protected boolean m11975c() {
        return C3410al.m12173a().m12201g() <= 0;
    }

    /* renamed from: d */
    protected boolean m11976d() {
        m11965f();
        return this.f12281n;
    }

    /* renamed from: e */
    protected boolean m11977e() {
        m11965f();
        return this.f12282o;
    }

    /* renamed from: f */
    private void m11965f() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f12281n = true;
            this.f12282o = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f12281n = true;
            this.f12282o = false;
        } else {
            this.f12281n = false;
            this.f12282o = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m11966g() {
        m11965f();
        m11964a(this.f12281n, this.f12282o);
    }

    /* renamed from: h */
    private void m11967h() {
        this.f12280m = new C3392a(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f12280m, intentFilter);
        m11966g();
    }

    /* renamed from: i */
    private void m11968i() {
        unregisterReceiver(this.f12280m);
    }

    /* renamed from: a */
    private void m11964a(boolean z, boolean z2) {
        C3250y.m11450b("[handleExternalStorageState] " + z + ", " + z2, getClass().getSimpleName());
        if (!z) {
            m11973a(R.string.ams_sdcard_unmounted_msg);
            finish();
        } else if (!z2) {
            m11973a(R.string.ams_sdcard_readonly_msg);
            finish();
        }
    }

    /* renamed from: j */
    private void m11969j() {
        if ((getResources().getConfiguration().screenLayout & 15) >= 4) {
            f12277j = true;
        } else {
            f12277j = false;
        }
    }

    /* renamed from: k */
    private void m11970k() {
        boolean z;
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        int width = defaultDisplay.getWidth();
        int height = defaultDisplay.getHeight();
        switch (defaultDisplay.getRotation()) {
            case 1:
            case 3:
                z = false;
                break;
            case 2:
            default:
                z = true;
                break;
        }
        if (z) {
            f12278k = width <= 320 && height <= 480;
        } else {
            f12278k = width <= 480 && height <= 320;
        }
    }

    /* renamed from: a */
    protected void m11973a(int i) {
        if (this.f12283p == null) {
            this.f12283p = C3641ai.m13210a(this, i, 0);
        }
        this.f12283p.setText(i);
        this.f12283p.show();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    /* renamed from: l */
    private void m11971l() {
        C3250y.m11450b("showPasswordLockActivity", "HomeActivity");
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
