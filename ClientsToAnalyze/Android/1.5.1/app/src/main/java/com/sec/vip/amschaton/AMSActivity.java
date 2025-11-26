package com.sec.vip.amschaton;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.StorageStateInfoUtil;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public class AMSActivity extends Activity {

    /* renamed from: e */
    public static String f3808e;

    /* renamed from: f */
    public static String f3809f;

    /* renamed from: g */
    public static String f3810g;

    /* renamed from: h */
    public static String f3811h;

    /* renamed from: i */
    public static String f3812i;

    /* renamed from: j */
    public static String f3813j;

    /* renamed from: k */
    public static String f3814k;

    /* renamed from: l */
    public static String f3815l;

    /* renamed from: b */
    private BroadcastReceiver f3817b;

    /* renamed from: a */
    private boolean f3816a = false;

    /* renamed from: c */
    private boolean f3818c = false;

    /* renamed from: d */
    private boolean f3819d = false;

    /* renamed from: a */
    private void m3705a() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState)) {
            this.f3818c = true;
            this.f3819d = true;
        } else if ("mounted_ro".equals(externalStorageState)) {
            this.f3818c = true;
            this.f3819d = false;
        } else {
            this.f3818c = false;
            this.f3819d = false;
        }
    }

    /* renamed from: a */
    private void m3707a(boolean z, boolean z2) {
        ChatONLogWriter.m3506b("[handleExternalStorageState] " + z + ", " + z2, getClass().getSimpleName());
        if (!z) {
            Toast.makeText(this, C0062R.string.ams_sdcard_unmounted_msg, 0).show();
            finish();
        } else {
            if (z2) {
                return;
            }
            Toast.makeText(this, C0062R.string.ams_sdcard_readonly_msg, 0).show();
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m3709i() {
        m3705a();
        m3707a(this.f3818c, this.f3819d);
    }

    /* renamed from: j */
    private void m3710j() {
        this.f3817b = new C0706i(this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
        intentFilter.addDataScheme("file");
        registerReceiver(this.f3817b, intentFilter);
        m3709i();
    }

    /* renamed from: k */
    private void m3711k() {
        unregisterReceiver(this.f3817b);
    }

    /* renamed from: b */
    protected void m3712b() {
        this.f3816a = false;
        if (m3716f()) {
            new C0707j(this, ProgressDialog.show(this, "", getString(C0062R.string.ams_msg_progress_ams_res_loading), true)).start();
        } else {
            ChatONLogWriter.m3506b("[loadStamp] Resources are already loaded!", getClass().getSimpleName());
            this.f3816a = true;
        }
    }

    /* renamed from: c */
    protected boolean m3713c() {
        return this.f3816a;
    }

    /* renamed from: d */
    protected void m3714d() throws IOException {
        AMSStampManager.m4056a().m4061a(this, getAssets(), f3811h);
    }

    /* renamed from: e */
    protected void m3715e() throws IOException {
        AMSBGMManager.m3719a().m3721a(getAssets());
    }

    /* renamed from: f */
    protected boolean m3716f() {
        return AMSStampManager.m4056a().m4063b() <= 0 || AMSBGMManager.m3719a().m3722b() <= 0;
    }

    /* renamed from: g */
    protected boolean m3717g() {
        m3705a();
        return this.f3818c;
    }

    /* renamed from: h */
    protected boolean m3718h() {
        m3705a();
        return this.f3819d;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        f3808e = (StorageStateInfoUtil.m3677a() ? GlobalApplication.m2387e().getExternalFilesDir(null).getAbsolutePath() : GlobalApplication.m2387e().getFilesDir().getAbsolutePath()) + "/AMS/";
        f3809f = f3808e + "amsbasicfiles/";
        f3810g = f3808e + "amsuserfiles/";
        f3811h = f3808e + "userstamp/";
        f3812i = f3808e + "temp/";
        f3813j = f3812i + "justTempAMS.jpg";
        f3814k = f3812i + "justTempImage.jpg";
        f3815l = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/Camera/ChatOn/";
        new File(f3808e).mkdir();
        new File(f3809f).mkdir();
        new File(f3810g).mkdir();
        new File(f3811h).mkdir();
        new File(f3812i).mkdir();
        new File(f3815l).mkdir();
    }

    @Override // android.app.Activity
    protected void onPause() {
        m3711k();
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        m3710j();
        super.onResume();
    }
}
