package com.sec.vip.cropimage;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.image.ImageEffectActivity;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.widget.C3641ai;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class ImageModify extends MonitoredActivity {

    /* renamed from: f */
    private static final String f13195f = ImageModify.class.getSimpleName();

    /* renamed from: C */
    private Context f13198C;

    /* renamed from: D */
    private Intent f13199D;

    /* renamed from: F */
    private int f13201F;

    /* renamed from: G */
    private String f13202G;

    /* renamed from: H */
    private AsyncTask<String, Integer, EnumC3598ad> f13203H;

    /* renamed from: a */
    boolean f13205a;

    /* renamed from: b */
    C3619o f13206b;

    /* renamed from: h */
    private int f13210h;

    /* renamed from: i */
    private int f13211i;

    /* renamed from: k */
    private int f13213k;

    /* renamed from: l */
    private int f13214l;

    /* renamed from: m */
    private boolean f13215m;

    /* renamed from: q */
    private boolean f13219q;

    /* renamed from: s */
    private ImageModifyView f13221s;

    /* renamed from: t */
    private Bitmap f13222t;

    /* renamed from: z */
    private Toast f13228z;

    /* renamed from: g */
    private final int f13209g = 1;

    /* renamed from: j */
    private final Handler f13212j = new Handler();

    /* renamed from: n */
    private boolean f13216n = true;

    /* renamed from: o */
    private boolean f13217o = false;

    /* renamed from: p */
    private boolean f13218p = true;

    /* renamed from: r */
    private boolean f13220r = false;

    /* renamed from: c */
    public float f13207c = 0.0f;

    /* renamed from: u */
    private int f13223u = 1000;

    /* renamed from: v */
    private int f13224v = 2000;

    /* renamed from: w */
    private int f13225w = 0;

    /* renamed from: x */
    private int f13226x = 0;

    /* renamed from: y */
    private Bitmap f13227y = null;

    /* renamed from: A */
    private ProgressDialog f13196A = null;

    /* renamed from: B */
    private String f13197B = "";

    /* renamed from: E */
    private String f13200E = "";

    /* renamed from: d */
    Runnable f13208d = new RunnableC3626v(this);

    /* renamed from: I */
    private Handler f13204I = new HandlerC3628x(this);

    @Override // com.sec.vip.cropimage.MonitoredActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13198C = this;
        this.f13225w = getWindowManager().getDefaultDisplay().getWidth();
        this.f13226x = getWindowManager().getDefaultDisplay().getHeight();
        m12939e();
        this.f13203H = new AsyncTaskC3599ae(this, this);
        if (Build.VERSION.SDK_INT < 11) {
            this.f13203H.execute(new String[0]);
        } else {
            this.f13203H.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a(this);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    Bitmap bitmapDecodeFile = null;
                    try {
                        bitmapDecodeFile = BitmapFactory.decodeFile(new File(intent.getExtras().getString("filterResultUri")).getAbsolutePath());
                    } catch (OutOfMemoryError e) {
                        C3641ai.m13210a(getApplicationContext(), R.string.chat_view_memory_error, 0).show();
                    }
                    if (bitmapDecodeFile != null) {
                        this.f13222t = bitmapDecodeFile;
                        m12943g();
                        break;
                    }
                }
                break;
        }
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: a */
    public int mo12916a() {
        return this.f13225w;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: b */
    public int mo12917b() {
        return this.f13226x;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: c */
    public float mo12918c() {
        return this.f13207c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0231 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0245 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x022c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x01c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x01ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:193:0x024a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:198:0x025c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0257 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:222:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:228:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c2 A[Catch: FileNotFoundException -> 0x01b8, OutOfMemoryError -> 0x0221, Exception -> 0x023a, all -> 0x0253, TryCatch #22 {FileNotFoundException -> 0x01b8, Exception -> 0x023a, OutOfMemoryError -> 0x0221, all -> 0x0253, blocks: (B:5:0x002b, B:7:0x0031, B:9:0x0035, B:10:0x0042, B:16:0x004f, B:18:0x005e, B:19:0x00a0, B:21:0x00b0, B:22:0x00be, B:24:0x00c2, B:25:0x00da, B:27:0x00e0, B:29:0x00e8, B:84:0x01d7, B:48:0x0165, B:60:0x019a, B:71:0x01b4, B:72:0x01b7, B:66:0x01aa), top: B:195:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010d A[Catch: all -> 0x028b, Exception -> 0x0298, OutOfMemoryError -> 0x02a2, FileNotFoundException -> 0x02ad, TryCatch #18 {all -> 0x028b, blocks: (B:31:0x00ef, B:33:0x010d, B:34:0x0117, B:36:0x011d, B:37:0x0134, B:39:0x0138, B:108:0x023c, B:98:0x0223, B:88:0x01f2, B:90:0x01fa, B:91:0x0206, B:93:0x020e, B:94:0x021a), top: B:195:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x011d A[Catch: all -> 0x028b, Exception -> 0x0298, OutOfMemoryError -> 0x02a2, FileNotFoundException -> 0x02ad, TryCatch #18 {all -> 0x028b, blocks: (B:31:0x00ef, B:33:0x010d, B:34:0x0117, B:36:0x011d, B:37:0x0134, B:39:0x0138, B:108:0x023c, B:98:0x0223, B:88:0x01f2, B:90:0x01fa, B:91:0x0206, B:93:0x020e, B:94:0x021a), top: B:195:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0138 A[Catch: all -> 0x028b, Exception -> 0x0298, OutOfMemoryError -> 0x02a2, FileNotFoundException -> 0x02ad, TRY_LEAVE, TryCatch #18 {all -> 0x028b, blocks: (B:31:0x00ef, B:33:0x010d, B:34:0x0117, B:36:0x011d, B:37:0x0134, B:39:0x0138, B:108:0x023c, B:98:0x0223, B:88:0x01f2, B:90:0x01fa, B:91:0x0206, B:93:0x020e, B:94:0x021a), top: B:195:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f2 A[Catch: all -> 0x028b, Exception -> 0x0298, OutOfMemoryError -> 0x02a2, FileNotFoundException -> 0x02ad, TRY_ENTER, TryCatch #18 {all -> 0x028b, blocks: (B:31:0x00ef, B:33:0x010d, B:34:0x0117, B:36:0x011d, B:37:0x0134, B:39:0x0138, B:108:0x023c, B:98:0x0223, B:88:0x01f2, B:90:0x01fa, B:91:0x0206, B:93:0x020e, B:94:0x021a), top: B:195:0x002b }] */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.vip.cropimage.EnumC3598ad m12959d() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 706
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageModify.m12959d():com.sec.vip.cropimage.ad");
    }

    /* renamed from: e */
    private boolean m12939e() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getBoolean("circleCrop")) {
                this.f13217o = true;
                this.f13210h = 1;
                this.f13211i = 1;
            }
            this.f13222t = (Bitmap) extras.getParcelable(SlookAirButtonFrequentContactAdapter.DATA);
            this.f13210h = extras.getInt("aspectX");
            this.f13211i = extras.getInt("aspectY");
            this.f13213k = extras.getInt("outputX");
            this.f13214l = extras.getInt("outputY");
            this.f13218p = extras.getBoolean("effect");
            this.f13215m = extras.getBoolean("scale", true);
            this.f13216n = extras.getBoolean("scaleUpIfNeeded", true);
            this.f13219q = extras.getBoolean("sendMode", false);
            this.f13220r = extras.getBoolean("randomFName", false);
        }
        setContentView(R.layout.layout_imagemodify);
        this.f13221s = (ImageModifyView) findViewById(R.id.image);
        this.f13221s.f13235g = this;
        if (Build.VERSION.SDK_INT >= 11) {
            this.f13221s.setLayerType(1, null);
        }
        this.f13202G = new File(getExternalCacheDir().getAbsolutePath() + "/tempCropImage.jpg").getAbsolutePath();
        ImageButton imageButton = (ImageButton) findViewById(R.id.add_message);
        imageButton.setOnClickListener(new ViewOnClickListenerC3621q(this));
        ((ImageButton) findViewById(R.id.rotate_image)).setOnClickListener(new ViewOnClickListenerC3622r(this));
        ((ImageButton) findViewById(R.id.effect_image)).setOnClickListener(new ViewOnClickListenerC3623s(this));
        if (!this.f13219q) {
            imageButton.setVisibility(8);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12941f() throws IOException {
        int i = 0;
        try {
            if (this.f13201F % 360 == 90) {
                i = 6;
            } else if (this.f13201F % 360 == 180) {
                i = 3;
            } else if (this.f13201F % 360 == 270) {
                i = 8;
            }
            ExifInterface exifInterface = new ExifInterface(this.f13202G);
            exifInterface.setAttribute("Orientation", String.valueOf(i));
            exifInterface.saveAttributes();
            if (C3250y.f11734b) {
                C3250y.m11450b("orientation set : " + i, f13195f);
            }
        } catch (IOException e) {
            C3250y.m11443a(e, f13195f);
        }
        Intent intent = new Intent(getApplicationContext(), (Class<?>) ImageEffectActivity.class);
        intent.putExtra("filterOrgUri", this.f13202G);
        startActivityForResult(intent, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m12943g() {
        if (!isFinishing()) {
            this.f13221s.setImageBitmapResetBase(this.f13222t, (int) this.f13207c, true);
            m12931a(this, null, null, new RunnableC3624t(this), this.f13212j);
        }
    }

    /* renamed from: a */
    private static void m12931a(MonitoredActivity monitoredActivity, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new RunnableC3596ab(monitoredActivity, runnable, null, handler)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0215  */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v33, types: [java.lang.String] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m12933a(boolean r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1034
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageModify.m12933a(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m12945h() {
        if (this.f13196A == null) {
            this.f13196A = ProgressDialogC3265l.m11490a(this, null, getResources().getString(R.string.setting_webview_please_wait), true);
        } else {
            this.f13196A.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m12947i() {
        if (this.f13196A != null) {
            this.f13196A.dismiss();
        }
    }

    /* renamed from: a */
    private void m12932a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m12935b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m12949j() {
        int width = this.f13222t.getWidth();
        int height = this.f13222t.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(270.0f, width / 2, height / 2);
        this.f13201F = (int) (this.f13201F + 270.0f);
        this.f13201F = (int) (this.f13201F % 360.0f);
        try {
            this.f13222t = Bitmap.createBitmap(this.f13222t, 0, 0, width, height, matrix, true);
            this.f13221s.mo12927b();
            m12943g();
        } catch (OutOfMemoryError e) {
            C3641ai.m13210a(getApplicationContext(), R.string.chat_view_memory_error, 0).show();
            C3250y.m11443a(e, getClass().getName());
            setResult(0);
            finish();
        }
    }

    /* renamed from: a */
    private static Bitmap m12928a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
        Matrix matrix2;
        int width = bitmap.getWidth() - i;
        int height = bitmap.getHeight() - i2;
        if (!z && (width < 0 || height < 0)) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            int iMax = Math.max(0, width / 2);
            int iMax2 = Math.max(0, height / 2);
            Rect rect = new Rect(iMax, iMax2, Math.min(i, bitmap.getWidth()) + iMax, Math.min(i2, bitmap.getHeight()) + iMax2);
            int iWidth = (i - rect.width()) / 2;
            int iHeight = (i2 - rect.height()) / 2;
            canvas.drawBitmap(bitmap, rect, new Rect(iWidth, iHeight, i - iWidth, i2 - iHeight), (Paint) null);
            if (z2) {
                bitmap.recycle();
            }
            return bitmapCreateBitmap;
        }
        float width2 = bitmap.getWidth();
        float height2 = bitmap.getHeight();
        if (width2 / height2 > i / i2) {
            float f = i2 / height2;
            if (f < 0.9f || f > 1.0f) {
                matrix.setScale(f, f);
            } else {
                matrix = null;
            }
            matrix2 = matrix;
        } else {
            float f2 = i / width2;
            if (f2 < 0.9f || f2 > 1.0f) {
                matrix.setScale(f2, f2);
                matrix2 = matrix;
            } else {
                matrix2 = null;
            }
        }
        Bitmap bitmapCreateBitmap2 = matrix2 != null ? Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true) : bitmap;
        if (z2 && !bitmapCreateBitmap2.equals(bitmap)) {
            bitmap.recycle();
        }
        Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(bitmapCreateBitmap2, Math.max(0, bitmapCreateBitmap2.getWidth() - i) / 2, Math.max(0, bitmapCreateBitmap2.getHeight() - i2) / 2, i, i2);
        if (!bitmapCreateBitmap3.equals(bitmapCreateBitmap2)) {
            if (z2 || !bitmapCreateBitmap2.equals(bitmap)) {
                bitmapCreateBitmap2.recycle();
                return bitmapCreateBitmap3;
            }
            return bitmapCreateBitmap3;
        }
        return bitmapCreateBitmap3;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f13222t != null) {
            this.f13222t.recycle();
            this.f13222t = null;
        }
        m12947i();
        if (this.f13203H != null) {
            this.f13203H.cancel(true);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cancel_done_menu, menu);
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) throws Throwable {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                m12952l();
                finish();
                break;
            case R.id.menu_cancel /* 2131166603 */:
                m12952l();
                finish();
                break;
            case R.id.menu_done /* 2131166604 */:
                m12933a(false);
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        m12952l();
        super.onBackPressed();
    }

    /* renamed from: l */
    private void m12952l() {
        Intent intent = new Intent();
        intent.putExtra("restart", true);
        setResult(0, intent);
    }
}
