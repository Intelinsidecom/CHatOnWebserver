package com.sec.vip.cropimage;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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
import com.sec.chaton.multimedia.image.ImageEffectActivity;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.ProgressDialogC4926s;
import com.sec.widget.C5179v;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class ImageModify extends MonitoredActivity {

    /* renamed from: r */
    private static final String f18607r = ImageModify.class.getSimpleName();

    /* renamed from: C */
    private boolean f18610C;

    /* renamed from: E */
    private ImageModifyView f18612E;

    /* renamed from: F */
    private Bitmap f18613F;

    /* renamed from: L */
    private Toast f18619L;

    /* renamed from: O */
    private Context f18622O;

    /* renamed from: P */
    private Intent f18623P;

    /* renamed from: R */
    private int f18625R;

    /* renamed from: S */
    private String f18626S;

    /* renamed from: T */
    private AsyncTask<String, Integer, EnumC5129p> f18627T;

    /* renamed from: n */
    boolean f18629n;

    /* renamed from: o */
    C5114a f18630o;

    /* renamed from: t */
    private int f18634t;

    /* renamed from: u */
    private int f18635u;

    /* renamed from: w */
    private int f18637w;

    /* renamed from: x */
    private int f18638x;

    /* renamed from: y */
    private boolean f18639y;

    /* renamed from: s */
    private final int f18633s = 1;

    /* renamed from: v */
    private final Handler f18636v = new Handler();

    /* renamed from: z */
    private boolean f18640z = true;

    /* renamed from: A */
    private boolean f18608A = false;

    /* renamed from: B */
    private boolean f18609B = true;

    /* renamed from: D */
    private boolean f18611D = false;

    /* renamed from: p */
    public float f18631p = 0.0f;

    /* renamed from: G */
    private int f18614G = 1000;

    /* renamed from: H */
    private int f18615H = 2000;

    /* renamed from: I */
    private int f18616I = 0;

    /* renamed from: J */
    private int f18617J = 0;

    /* renamed from: K */
    private Bitmap f18618K = null;

    /* renamed from: M */
    private ProgressDialog f18620M = null;

    /* renamed from: N */
    private String f18621N = "";

    /* renamed from: Q */
    private String f18624Q = "";

    /* renamed from: q */
    Runnable f18632q = new RunnableC5121h(this);

    /* renamed from: U */
    private Handler f18628U = new HandlerC5123j(this);

    @Override // com.sec.vip.cropimage.MonitoredActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f18622O = this;
        this.f18616I = getWindowManager().getDefaultDisplay().getWidth();
        this.f18617J = getWindowManager().getDefaultDisplay().getHeight();
        if (!m19526j()) {
            finish();
            return;
        }
        this.f18627T = new AsyncTaskC5130q(this, this, null);
        if (Build.VERSION.SDK_INT < 11) {
            this.f18627T.execute(new String[0]);
        } else {
            this.f18627T.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    Bitmap bitmapDecodeFile = null;
                    try {
                        bitmapDecodeFile = BitmapFactory.decodeFile(new File(intent.getExtras().getString("filterResultUri")).getAbsolutePath());
                    } catch (OutOfMemoryError e) {
                        C5179v.m19810a(getApplicationContext(), R.string.chat_view_memory_error, 0).show();
                    }
                    if (bitmapDecodeFile != null) {
                        this.f18613F = bitmapDecodeFile;
                        m19530l();
                        break;
                    }
                }
                break;
        }
    }

    /* renamed from: f */
    public int m19541f() {
        return this.f18616I;
    }

    /* renamed from: g */
    public int m19542g() {
        return this.f18617J;
    }

    /* renamed from: h */
    public float m19543h() {
        return this.f18631p;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x026d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0268 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0241 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0255 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x023c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x01d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0157 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0152 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x025a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x01d8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:220:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:222:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:228:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c7 A[Catch: FileNotFoundException -> 0x01c5, OutOfMemoryError -> 0x0231, Exception -> 0x024a, all -> 0x0264, TryCatch #24 {FileNotFoundException -> 0x01c5, Exception -> 0x024a, OutOfMemoryError -> 0x0231, all -> 0x0264, blocks: (B:5:0x002c, B:7:0x0032, B:9:0x0036, B:10:0x0044, B:16:0x0051, B:18:0x0060, B:19:0x00a4, B:21:0x00b5, B:22:0x00c3, B:24:0x00c7, B:25:0x00e0, B:27:0x00e6, B:29:0x00ef, B:84:0x01e5, B:48:0x0170, B:60:0x01a7, B:71:0x01c1, B:72:0x01c4, B:66:0x01b7), top: B:203:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0117 A[Catch: all -> 0x029c, Exception -> 0x02a9, OutOfMemoryError -> 0x02b3, FileNotFoundException -> 0x02bf, TryCatch #31 {all -> 0x029c, blocks: (B:31:0x00f6, B:33:0x0117, B:34:0x0121, B:36:0x0127, B:37:0x013e, B:39:0x0142, B:108:0x024c, B:98:0x0233, B:88:0x0200, B:90:0x0209, B:91:0x0215, B:93:0x021e, B:94:0x022a), top: B:203:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0127 A[Catch: all -> 0x029c, Exception -> 0x02a9, OutOfMemoryError -> 0x02b3, FileNotFoundException -> 0x02bf, TryCatch #31 {all -> 0x029c, blocks: (B:31:0x00f6, B:33:0x0117, B:34:0x0121, B:36:0x0127, B:37:0x013e, B:39:0x0142, B:108:0x024c, B:98:0x0233, B:88:0x0200, B:90:0x0209, B:91:0x0215, B:93:0x021e, B:94:0x022a), top: B:203:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0142 A[Catch: all -> 0x029c, Exception -> 0x02a9, OutOfMemoryError -> 0x02b3, FileNotFoundException -> 0x02bf, TRY_LEAVE, TryCatch #31 {all -> 0x029c, blocks: (B:31:0x00f6, B:33:0x0117, B:34:0x0121, B:36:0x0127, B:37:0x013e, B:39:0x0142, B:108:0x024c, B:98:0x0233, B:88:0x0200, B:90:0x0209, B:91:0x0215, B:93:0x021e, B:94:0x022a), top: B:203:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01c1 A[Catch: FileNotFoundException -> 0x01c5, OutOfMemoryError -> 0x0231, Exception -> 0x024a, all -> 0x0264, TryCatch #24 {FileNotFoundException -> 0x01c5, Exception -> 0x024a, OutOfMemoryError -> 0x0231, all -> 0x0264, blocks: (B:5:0x002c, B:7:0x0032, B:9:0x0036, B:10:0x0044, B:16:0x0051, B:18:0x0060, B:19:0x00a4, B:21:0x00b5, B:22:0x00c3, B:24:0x00c7, B:25:0x00e0, B:27:0x00e6, B:29:0x00ef, B:84:0x01e5, B:48:0x0170, B:60:0x01a7, B:71:0x01c1, B:72:0x01c4, B:66:0x01b7), top: B:203:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0200 A[Catch: all -> 0x029c, Exception -> 0x02a9, OutOfMemoryError -> 0x02b3, FileNotFoundException -> 0x02bf, TRY_ENTER, TryCatch #31 {all -> 0x029c, blocks: (B:31:0x00f6, B:33:0x0117, B:34:0x0121, B:36:0x0127, B:37:0x013e, B:39:0x0142, B:108:0x024c, B:98:0x0233, B:88:0x0200, B:90:0x0209, B:91:0x0215, B:93:0x021e, B:94:0x022a), top: B:203:0x002c }] */
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.sec.vip.cropimage.EnumC5129p m19544i() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 724
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageModify.m19544i():com.sec.vip.cropimage.p");
    }

    @SuppressLint({"NewApi"})
    /* renamed from: j */
    private boolean m19526j() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            if (extras.getBoolean("circleCrop")) {
                this.f18608A = true;
                this.f18634t = 1;
                this.f18635u = 1;
            }
            this.f18613F = (Bitmap) extras.getParcelable(SlookAirButtonFrequentContactAdapter.DATA);
            this.f18634t = extras.getInt("aspectX");
            this.f18635u = extras.getInt("aspectY");
            this.f18637w = extras.getInt("outputX");
            this.f18638x = extras.getInt("outputY");
            this.f18609B = extras.getBoolean("effect");
            this.f18639y = extras.getBoolean("scale", true);
            this.f18640z = extras.getBoolean("scaleUpIfNeeded", true);
            this.f18610C = extras.getBoolean("sendMode", false);
            this.f18611D = extras.getBoolean("randomFName", false);
        }
        setContentView(R.layout.layout_imagemodify);
        this.f18612E = (ImageModifyView) findViewById(R.id.image);
        this.f18612E.f18647g = this;
        if (Build.VERSION.SDK_INT >= 11) {
            this.f18612E.setLayerType(1, null);
        }
        if (getExternalCacheDir() == null) {
            C5179v.m19810a(getApplicationContext(), R.string.sdcard_not_found, 0).show();
            return false;
        }
        this.f18626S = new File(getExternalCacheDir().getAbsolutePath() + "/tempCropImage.jpg").getAbsolutePath();
        ImageButton imageButton = (ImageButton) findViewById(R.id.add_message);
        imageButton.setOnClickListener(new ViewOnClickListenerC5116c(this));
        ((ImageButton) findViewById(R.id.rotate_image)).setOnClickListener(new ViewOnClickListenerC5117d(this));
        ((ImageButton) findViewById(R.id.effect_image)).setOnClickListener(new ViewOnClickListenerC5118e(this));
        if (!this.f18610C) {
            imageButton.setVisibility(8);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m19527k() throws IOException {
        int i = 0;
        try {
            if (this.f18625R % 360 == 90) {
                i = 6;
            } else if (this.f18625R % 360 == 180) {
                i = 3;
            } else if (this.f18625R % 360 == 270) {
                i = 8;
            }
            ExifInterface exifInterface = new ExifInterface(this.f18626S);
            exifInterface.setAttribute("Orientation", String.valueOf(i));
            exifInterface.saveAttributes();
            if (C4904y.f17872b) {
                C4904y.m18639b("orientation set : " + i, f18607r);
            }
        } catch (IOException e) {
            C4904y.m18635a(e, f18607r);
        }
        Intent intent = new Intent(getApplicationContext(), (Class<?>) ImageEffectActivity.class);
        intent.putExtra("filterOrgUri", this.f18626S);
        startActivityForResult(intent, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m19530l() {
        if (!isFinishing()) {
            this.f18612E.m19559a(this.f18613F, (int) this.f18631p, true);
            m19513a(this, null, null, new RunnableC5119f(this), this.f18636v);
        }
    }

    /* renamed from: a */
    private static void m19513a(MonitoredActivity monitoredActivity, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new RunnableC5127n(monitoredActivity, runnable, null, handler, 0 == true ? 1 : 0)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0224  */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v33, types: [java.lang.String] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m19517b(boolean r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1052
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageModify.m19517b(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m19532m() {
        if (this.f18620M == null) {
            this.f18620M = ProgressDialogC4926s.m18728a(this, null, getResources().getString(R.string.setting_webview_please_wait), true);
        } else {
            this.f18620M.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m19534n() {
        if (this.f18620M != null) {
            this.f18620M.dismiss();
        }
    }

    /* renamed from: a */
    private void m19514a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m19516b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public void m19536o() {
        int width = this.f18613F.getWidth();
        int height = this.f18613F.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(270.0f, width / 2, height / 2);
        this.f18625R = (int) (this.f18625R + 270.0f);
        this.f18625R = (int) (this.f18625R % 360.0f);
        try {
            this.f18613F = Bitmap.createBitmap(this.f18613F, 0, 0, width, height, matrix, true);
            this.f18612E.mo19548a();
            m19530l();
        } catch (OutOfMemoryError e) {
            C5179v.m19810a(getApplicationContext(), R.string.chat_view_memory_error, 0).show();
            C4904y.m18635a(e, getClass().getName());
            setResult(0);
            finish();
        }
    }

    /* renamed from: a */
    private static Bitmap m19510a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
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
        if (this.f18613F != null) {
            this.f18613F.recycle();
            this.f18613F = null;
        }
        m19534n();
        if (this.f18627T != null) {
            this.f18627T.cancel(true);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cancel_done_menu, menu);
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) throws Throwable {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                m19538p();
                finish();
                break;
            case R.id.menu_cancel /* 2131166684 */:
                m19538p();
                finish();
                break;
            case R.id.menu_done /* 2131166685 */:
                m19517b(false);
                break;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        m19538p();
        super.onBackPressed();
    }

    /* renamed from: p */
    private void m19538p() {
        Intent intent = new Intent();
        intent.putExtra("restart", true);
        setResult(0, intent);
    }
}
