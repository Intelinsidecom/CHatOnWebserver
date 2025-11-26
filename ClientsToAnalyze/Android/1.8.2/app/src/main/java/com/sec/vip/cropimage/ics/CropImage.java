package com.sec.vip.cropimage.ics;

import android.app.ProgressDialog;
import android.content.CursorLoader;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;
import com.sec.vip.cropimage.C2077a;
import com.sec.vip.cropimage.CropImageView;
import com.sec.vip.cropimage.MonitoredActivity;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class CropImage extends MonitoredActivity {

    /* renamed from: A */
    private ImageView f7631A;

    /* renamed from: a */
    C2077a f7635a;

    /* renamed from: c */
    private int f7637c;

    /* renamed from: d */
    private int f7638d;

    /* renamed from: g */
    private int f7640g;

    /* renamed from: h */
    private int f7641h;

    /* renamed from: i */
    private boolean f7642i;

    /* renamed from: n */
    private CropImageView f7647n;

    /* renamed from: o */
    private Bitmap f7648o;

    /* renamed from: w */
    private ImageView f7656w;

    /* renamed from: x */
    private ImageView f7657x;

    /* renamed from: y */
    private ImageView f7658y;

    /* renamed from: z */
    private ImageView f7659z;

    /* renamed from: f */
    private final Handler f7639f = new Handler();

    /* renamed from: j */
    private boolean f7643j = true;

    /* renamed from: k */
    private boolean f7644k = false;

    /* renamed from: l */
    private boolean f7645l = false;

    /* renamed from: m */
    private boolean f7646m = true;

    /* renamed from: p */
    private float f7649p = 0.0f;

    /* renamed from: q */
    private int f7650q = 1000;

    /* renamed from: r */
    private int f7651r = 2000;

    /* renamed from: s */
    private int f7652s = 0;

    /* renamed from: t */
    private int f7653t = 0;

    /* renamed from: u */
    private Bitmap f7654u = null;

    /* renamed from: v */
    private int f7655v = this.f7650q;

    /* renamed from: B */
    private ImageView f7632B = null;

    /* renamed from: b */
    Runnable f7636b = new RunnableC2106g(this);

    /* renamed from: C */
    private View.OnTouchListener f7633C = new ViewOnTouchListenerC2108i(this);

    /* renamed from: D */
    private View.OnClickListener f7634D = new ViewOnClickListenerC2109j(this);

    @Override // com.sec.vip.cropimage.MonitoredActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f7652s = getWindowManager().getDefaultDisplay().getWidth();
        this.f7653t = getWindowManager().getDefaultDisplay().getHeight();
        if (!m7409d()) {
            C1786r.m6054a("[onCreate] setLayout error!", getClass().getSimpleName());
            finish();
        }
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: a */
    public int mo7298a() {
        return this.f7652s;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: b */
    public int mo7299b() {
        return this.f7653t;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: c */
    public float mo7300c() {
        return this.f7649p;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m7409d() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ics.CropImage.m7409d():boolean");
    }

    /* renamed from: a */
    private int m7387a(int i) {
        switch (i) {
            case 3:
                return 180;
            case 4:
            case 5:
            case 7:
            default:
                return 0;
            case 6:
                return 90;
            case 8:
                return 270;
        }
    }

    /* renamed from: a */
    private String m7391a(Uri uri) throws IllegalArgumentException {
        Cursor cursorLoadInBackground;
        String[] strArr = {"_data"};
        if (Build.VERSION.SDK_INT < 11) {
            cursorLoadInBackground = managedQuery(uri, strArr, null, null, null);
        } else {
            cursorLoadInBackground = new CursorLoader(this, uri, strArr, null, null, null).loadInBackground();
        }
        if (cursorLoadInBackground == null) {
            C1786r.m6065d("[getRealPathFromURI] cursor is null! - Camera", getClass().getSimpleName());
            return null;
        }
        int columnIndexOrThrow = cursorLoadInBackground.getColumnIndexOrThrow("_data");
        cursorLoadInBackground.moveToFirst();
        String string = cursorLoadInBackground.getString(columnIndexOrThrow);
        cursorLoadInBackground.close();
        return string;
    }

    /* renamed from: b */
    private int m7397b(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                C1786r.m6061b("optiions width height : " + options.outWidth + ", " + options.outHeight, getClass().getSimpleName());
                return (int) (((r0 * r2) / 1228800.0f) + 0.5f);
            } finally {
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException e) {
                    }
                }
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            if (inputStreamOpenInputStream == null) {
                return 0;
            }
            try {
                inputStreamOpenInputStream.close();
                return 0;
            } catch (IOException e3) {
                return 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7396a(boolean z) {
        if (!isFinishing()) {
            this.f7632B.setVisibility(0);
            this.f7647n.setImageBitmapResetBase(this.f7648o, (int) this.f7649p, true);
            m7392a(this, z, (String) null, getResources().getString(R.string.ams_msg_runningImageCrop), new RunnableC2104e(this), this.f7639f);
        }
    }

    /* renamed from: a */
    private static void m7392a(MonitoredActivity monitoredActivity, boolean z, String str, String str2, Runnable runnable, Handler handler) {
        ProgressDialog progressDialogM6142a = null;
        if (z) {
            progressDialogM6142a = ProgressDialogC1806j.m6142a(monitoredActivity, str, str2, true, false);
        }
        new Thread(new RunnableC2111l(monitoredActivity, runnable, progressDialogM6142a, handler)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0185  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m7411e() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ics.CropImage.m7411e():void");
    }

    /* renamed from: a */
    private void m7395a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m7402b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m7413f() {
        this.f7649p += 90.0f;
        if (this.f7649p == 360.0f) {
            this.f7649p = 0.0f;
        }
        m7396a(false);
    }

    /* renamed from: b */
    private void m7400b(int i) {
        this.f7649p = i;
    }

    /* renamed from: g */
    private void m7415g() {
        this.f7655v = this.f7650q;
        this.f7656w = (ImageView) findViewById(R.id.iv_template_rect);
        this.f7657x = (ImageView) findViewById(R.id.iv_template_circle);
        this.f7658y = (ImageView) findViewById(R.id.iv_template_roundrect);
        this.f7659z = (ImageView) findViewById(R.id.iv_template_heart);
        this.f7631A = (ImageView) findViewById(R.id.iv_template_star);
        this.f7656w.setOnClickListener(this.f7634D);
        this.f7656w.setOnTouchListener(this.f7633C);
        this.f7657x.setOnClickListener(this.f7634D);
        this.f7657x.setOnTouchListener(this.f7633C);
        this.f7658y.setOnClickListener(this.f7634D);
        this.f7658y.setOnTouchListener(this.f7633C);
        this.f7659z.setOnClickListener(this.f7634D);
        this.f7659z.setOnTouchListener(this.f7633C);
        this.f7631A.setOnClickListener(this.f7634D);
        this.f7631A.setOnTouchListener(this.f7633C);
        m7403c(this.f7650q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7403c(int i) {
        int[] iArr = {1000, 1002, 1001, 1004, 1003};
        ImageView[] imageViewArr = {this.f7656w, this.f7657x, this.f7658y, this.f7659z, this.f7631A};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            imageViewArr[i2].setSelected(iArr[i2] == i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public int m7406d(int i) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m7417h() {
        new AlertDialogBuilderC2120a(this).setTitle(R.string.ams_crop_effect_image_title).setItems(R.array.ams_strarr_effect_image, new DialogInterfaceOnClickListenerC2110k(this, new AMSLibs())).create().show();
    }

    /* renamed from: a */
    private static Bitmap m7389a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
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
    protected void onPause() {
        super.onPause();
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
