package com.sec.vip.cropimage;

import android.app.ActionBar;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1786r;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class ImageModify extends MonitoredActivity {

    /* renamed from: A */
    private ImageView f7484A;

    /* renamed from: B */
    private ImageView f7485B;

    /* renamed from: C */
    private ImageView f7486C;

    /* renamed from: D */
    private ImageView f7487D;

    /* renamed from: a */
    boolean f7490a;

    /* renamed from: b */
    C2077a f7491b;

    /* renamed from: f */
    private int f7494f;

    /* renamed from: g */
    private int f7495g;

    /* renamed from: i */
    private int f7497i;

    /* renamed from: j */
    private int f7498j;

    /* renamed from: k */
    private boolean f7499k;

    /* renamed from: p */
    private boolean f7504p;

    /* renamed from: q */
    private ImageModifyView f7505q;

    /* renamed from: r */
    private Bitmap f7506r;

    /* renamed from: z */
    private ImageView f7514z;

    /* renamed from: h */
    private final Handler f7496h = new Handler();

    /* renamed from: l */
    private boolean f7500l = true;

    /* renamed from: m */
    private boolean f7501m = false;

    /* renamed from: n */
    private boolean f7502n = false;

    /* renamed from: o */
    private boolean f7503o = true;

    /* renamed from: c */
    public float f7492c = 0.0f;

    /* renamed from: s */
    private int f7507s = 1000;

    /* renamed from: t */
    private int f7508t = 2000;

    /* renamed from: u */
    private int f7509u = 0;

    /* renamed from: v */
    private int f7510v = 0;

    /* renamed from: w */
    private Bitmap f7511w = null;

    /* renamed from: x */
    private Dialog f7512x = null;

    /* renamed from: y */
    private int f7513y = this.f7507s;

    /* renamed from: d */
    Runnable f7493d = new RunnableC2081e(this);

    /* renamed from: E */
    private View.OnTouchListener f7488E = new ViewOnTouchListenerC2083g(this);

    /* renamed from: F */
    private View.OnClickListener f7489F = new ViewOnClickListenerC2084h(this);

    @Override // com.sec.vip.cropimage.MonitoredActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7509u = getWindowManager().getDefaultDisplay().getWidth();
        this.f7510v = getWindowManager().getDefaultDisplay().getHeight();
        if (GlobalApplication.m3265f()) {
            requestWindowFeature(8);
        } else {
            requestWindowFeature(1);
        }
        if (!m7290e()) {
            C1786r.m6054a("[onCreate] setLayout error!", getClass().getSimpleName());
            setResult(0);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        setTitle(R.string.menu_multimedia_picture);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: a */
    public int mo7298a() {
        return this.f7509u;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: b */
    public int mo7299b() {
        return this.f7510v;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: c */
    public float mo7300c() {
        return this.f7492c;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x021c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m7290e() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageModify.m7290e():boolean");
    }

    /* renamed from: d */
    public void m7301d() {
        Button button = (Button) findViewById(R.id.save);
        if (button != null) {
            button.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m7291f() {
        if (!isFinishing()) {
            this.f7505q.setImageBitmapResetBase(this.f7506r, (int) this.f7492c, true);
            m7279a(this, null, null, new RunnableC2079c(this), this.f7496h);
        }
    }

    /* renamed from: a */
    private static void m7279a(MonitoredActivity monitoredActivity, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new RunnableC2099i(monitoredActivity, runnable, null, handler)).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01a9  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m7281a(boolean r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 844
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageModify.m7281a(boolean):void");
    }

    /* renamed from: a */
    private void m7280a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m7285b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: g */
    private void m7294g() {
        int width = this.f7506r.getWidth();
        int height = this.f7506r.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f, width / 2, height / 2);
        this.f7506r = Bitmap.createBitmap(this.f7506r, 0, 0, width, height, matrix, true);
        this.f7505q.mo7273b();
        m7291f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7278a(int i) {
        int[] iArr = {1000, 1002, 1001, 1004, 1003};
        ImageView[] imageViewArr = {this.f7514z, this.f7484A, this.f7485B, this.f7486C, this.f7487D};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            imageViewArr[i2].setSelected(iArr[i2] == i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m7282b(int i) {
        switch (i) {
            case 1001:
                return R.id.iv_template_roundrect;
            case 1002:
                return R.id.iv_template_circle;
            case 1003:
                return R.id.iv_template_star;
            case 1004:
                return R.id.iv_template_heart;
            default:
                return R.id.iv_template_rect;
        }
    }

    /* renamed from: a */
    private static Bitmap m7276a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
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
        if (z2 && bitmapCreateBitmap2 != bitmap) {
            bitmap.recycle();
        }
        Bitmap bitmapCreateBitmap3 = Bitmap.createBitmap(bitmapCreateBitmap2, Math.max(0, bitmapCreateBitmap2.getWidth() - i) / 2, Math.max(0, bitmapCreateBitmap2.getHeight() - i2) / 2, i, i2);
        if (bitmapCreateBitmap3 != bitmapCreateBitmap2) {
            if (z2 || bitmapCreateBitmap2 != bitmap) {
                bitmapCreateBitmap2.recycle();
                return bitmapCreateBitmap3;
            }
            return bitmapCreateBitmap3;
        }
        return bitmapCreateBitmap3;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (GlobalApplication.m3265f()) {
            getMenuInflater().inflate(R.menu.actionbar_menu_crop, menu);
        }
        if (this.f7504p) {
            menu.findItem(R.id.menu_send).setVisible(true).setEnabled(true);
            menu.findItem(R.id.menu_send_message).setVisible(true).setEnabled(true);
            menu.findItem(R.id.menu_apply).setVisible(false).setEnabled(false);
        } else {
            menu.findItem(R.id.menu_apply).setVisible(true).setEnabled(true);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Throwable {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_cancel /* 2131494116 */:
                setResult(0);
                finish();
                break;
            case R.id.menu_rotate /* 2131494117 */:
                m7294g();
                break;
            case R.id.menu_send_message /* 2131494118 */:
                m7281a(true);
                break;
            case R.id.menu_send /* 2131494119 */:
                m7281a(false);
                break;
            case R.id.menu_apply /* 2131494120 */:
                m7281a(false);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f7506r != null) {
            this.f7506r.recycle();
            this.f7506r = null;
        }
    }
}
