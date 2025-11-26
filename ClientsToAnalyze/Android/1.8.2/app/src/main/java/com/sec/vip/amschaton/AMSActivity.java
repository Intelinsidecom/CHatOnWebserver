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
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;
import java.io.File;

/* loaded from: classes.dex */
public class AMSActivity extends Activity {

    /* renamed from: a */
    public static String f6608a;

    /* renamed from: b */
    public static String f6609b;

    /* renamed from: c */
    public static String f6610c;

    /* renamed from: d */
    public static String f6611d;

    /* renamed from: e */
    public static String f6612e;

    /* renamed from: f */
    public static String f6613f;

    /* renamed from: g */
    public static String f6614g;

    /* renamed from: h */
    public static String f6615h;

    /* renamed from: i */
    public static String f6616i;

    /* renamed from: j */
    public static boolean f6617j = false;

    /* renamed from: k */
    public static boolean f6618k = false;

    /* renamed from: m */
    private BroadcastReceiver f6620m;

    /* renamed from: l */
    private boolean f6619l = false;

    /* renamed from: n */
    private boolean f6621n = false;

    /* renamed from: o */
    private boolean f6622o = false;

    /* renamed from: p */
    private Toast f6623p = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f6608a = (C1767bw.m6002a() ? GlobalApplication.m3260b().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3260b().getFilesDir().getAbsolutePath()) + "/AMS/";
        f6609b = f6608a + "amsbasicfiles/";
        f6610c = f6608a + "amsuserfiles/";
        f6611d = f6608a + "amssentfiles/";
        f6612e = f6608a + "userstamp/";
        f6613f = f6608a + "temp/";
        f6614g = f6613f + "justTempAMS.jpg";
        f6615h = f6613f + "justTempImage.jpg";
        f6616i = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/Camera/ChatON/";
        new File(f6608a).mkdirs();
        new File(f6609b).mkdirs();
        new File(f6610c).mkdirs();
        new File(f6611d).mkdirs();
        new File(f6612e).mkdirs();
        new File(f6613f).mkdirs();
        new File(f6616i).mkdirs();
        m6259l();
        m6260m();
    }

    @Override // android.app.Activity
    protected void onPause() {
        m6258k();
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        m6257j();
        overridePendingTransition(R.anim.anim_ics2_activity_appear, R.anim.anim_ics2_activity_disappear);
        super.onResume();
        m6254g();
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
        C1781m.m6022b(getApplicationContext());
    }

    /* renamed from: g */
    private void m6254g() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* renamed from: a */
    protected void m6261a() {
        this.f6619l = false;
        if (!m6265d()) {
            C1786r.m6061b("[loadStamp] Resources are already loaded!", getClass().getSimpleName());
            this.f6619l = true;
        } else {
            m6264c();
            this.f6619l = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public boolean m6263b() {
        return this.f6619l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void m6264c() {
        C1849ai.m6394a().m6400a(this, getAssets(), f6612e);
    }

    /* renamed from: d */
    protected boolean m6265d() {
        return C1849ai.m6394a().m6402b() <= 0;
    }

    /* renamed from: e */
    protected boolean m6266e() {
        m6255h();
        return this.f6621n;
    }

    /* renamed from: f */
    protected boolean m6267f() {
        m6255h();
        return this.f6622o;
    }

    /* renamed from: h */
    private void m6255h() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f6621n = true;
            this.f6622o = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f6621n = true;
            this.f6622o = false;
        } else {
            this.f6621n = false;
            this.f6622o = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m6256i() {
        m6255h();
        m6253a(this.f6621n, this.f6622o);
    }

    /* renamed from: j */
    private void m6257j() {
        this.f6620m = new C1887d(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f6620m, intentFilter);
        m6256i();
    }

    /* renamed from: k */
    private void m6258k() {
        unregisterReceiver(this.f6620m);
    }

    /* renamed from: a */
    private void m6253a(boolean z, boolean z2) {
        C1786r.m6061b("[handleExternalStorageState] " + z + ", " + z2, getClass().getSimpleName());
        if (!z) {
            m6262a(R.string.ams_sdcard_unmounted_msg);
            finish();
        } else if (!z2) {
            m6262a(R.string.ams_sdcard_readonly_msg);
            finish();
        }
    }

    /* renamed from: l */
    private void m6259l() {
        if ((getResources().getConfiguration().screenLayout & 15) >= 4) {
            f6617j = true;
        } else {
            f6617j = false;
        }
    }

    /* renamed from: m */
    private void m6260m() {
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
            f6618k = width <= 320 && height <= 480;
        } else {
            f6618k = width <= 480 && height <= 320;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m6262a(int i) {
        if (this.f6623p == null) {
            this.f6623p = C2153y.m7535a(this, i, 0);
        }
        this.f6623p.setText(i);
        this.f6623p.show();
    }
}
