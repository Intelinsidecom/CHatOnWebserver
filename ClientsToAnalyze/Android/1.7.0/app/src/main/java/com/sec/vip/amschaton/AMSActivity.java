package com.sec.vip.amschaton;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1327bw;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.widget.C1619g;
import java.io.File;

/* loaded from: classes.dex */
public class AMSActivity extends Activity {

    /* renamed from: d */
    public static String f4622d;

    /* renamed from: e */
    public static String f4623e;

    /* renamed from: f */
    public static String f4624f;

    /* renamed from: g */
    public static String f4625g;

    /* renamed from: h */
    public static String f4626h;

    /* renamed from: i */
    public static String f4627i;

    /* renamed from: j */
    public static String f4628j;

    /* renamed from: k */
    public static String f4629k;

    /* renamed from: l */
    public static boolean f4630l = false;

    /* renamed from: m */
    public static boolean f4631m = false;

    /* renamed from: b */
    private BroadcastReceiver f4633b;

    /* renamed from: a */
    private boolean f4632a = false;

    /* renamed from: c */
    private boolean f4634c = false;

    /* renamed from: n */
    private boolean f4635n = false;

    /* renamed from: o */
    private Toast f4636o = null;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f4622d = (C1327bw.m4595a() ? GlobalApplication.m3100a().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m3100a().getFilesDir().getAbsolutePath()) + "/AMS/";
        f4623e = f4622d + "amsbasicfiles/";
        f4624f = f4622d + "amsuserfiles/";
        f4625g = f4622d + "userstamp/";
        f4626h = f4622d + "temp/";
        f4627i = f4626h + "justTempAMS.jpg";
        f4628j = f4626h + "justTempImage.jpg";
        f4629k = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/ChatON/";
        new File(f4622d).mkdirs();
        new File(f4623e).mkdirs();
        new File(f4624f).mkdirs();
        new File(f4625g).mkdirs();
        new File(f4626h).mkdirs();
        new File(f4629k).mkdirs();
        m4736k();
        m4737l();
    }

    @Override // android.app.Activity
    protected void onPause() {
        m4735j();
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        m4734i();
        super.onResume();
    }

    /* renamed from: b */
    protected void m4739b() {
        this.f4632a = false;
        if (!m4742e()) {
            C1341p.m4658b("[loadStamp] Resources are already loaded!", getClass().getSimpleName());
            this.f4632a = true;
        } else {
            new C1400e(this, ProgressDialogC1354a.m4724a(this, "", getString(R.string.ams_msg_progress_ams_res_loading), true)).start();
        }
    }

    /* renamed from: c */
    protected boolean m4740c() {
        return this.f4632a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void m4741d() {
        C1561z.m5654a().m5660a(this, getAssets(), f4625g);
    }

    /* renamed from: e */
    protected boolean m4742e() {
        return C1561z.m5654a().m5662b() <= 0;
    }

    /* renamed from: f */
    protected boolean m4743f() {
        m4729a();
        return this.f4634c;
    }

    /* renamed from: g */
    protected boolean m4744g() {
        m4729a();
        return this.f4635n;
    }

    /* renamed from: a */
    private void m4729a() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f4634c = true;
            this.f4635n = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f4634c = true;
            this.f4635n = false;
        } else {
            this.f4634c = false;
            this.f4635n = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m4733h() {
        m4729a();
        m4731a(this.f4634c, this.f4635n);
    }

    /* renamed from: i */
    private void m4734i() {
        this.f4633b = new C1399d(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f4633b, intentFilter);
        m4733h();
    }

    /* renamed from: j */
    private void m4735j() {
        unregisterReceiver(this.f4633b);
    }

    /* renamed from: a */
    private void m4731a(boolean z, boolean z2) {
        C1341p.m4658b("[handleExternalStorageState] " + z + ", " + z2, getClass().getSimpleName());
        if (!z) {
            m4738a(R.string.ams_sdcard_unmounted_msg);
            finish();
        } else if (!z2) {
            m4738a(R.string.ams_sdcard_readonly_msg);
            finish();
        }
    }

    /* renamed from: k */
    private void m4736k() {
        if ((getResources().getConfiguration().screenLayout & 15) >= 4) {
            f4630l = true;
        } else {
            f4630l = false;
        }
    }

    /* renamed from: l */
    private void m4737l() {
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
            f4631m = width <= 320 && height <= 480;
        } else {
            f4631m = width <= 480 && height <= 320;
        }
    }

    /* renamed from: a */
    protected void m4738a(int i) {
        if (this.f4636o == null) {
            this.f4636o = C1619g.m5888a(this, i, 0);
        }
        this.f4636o.setText(i);
        this.f4636o.show();
    }
}
