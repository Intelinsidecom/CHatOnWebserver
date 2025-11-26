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
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.vip.cropimage.C1598o;
import com.sec.vip.cropimage.CropImageView;
import com.sec.vip.cropimage.MonitoredActivity;
import com.sec.widget.AlertDialogBuilderC1625m;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class CropImage extends MonitoredActivity {

    /* renamed from: A */
    private ImageView f5560A;

    /* renamed from: a */
    C1598o f5564a;

    /* renamed from: c */
    private int f5566c;

    /* renamed from: d */
    private int f5567d;

    /* renamed from: g */
    private int f5569g;

    /* renamed from: h */
    private int f5570h;

    /* renamed from: i */
    private boolean f5571i;

    /* renamed from: n */
    private CropImageView f5576n;

    /* renamed from: o */
    private Bitmap f5577o;

    /* renamed from: w */
    private ImageView f5585w;

    /* renamed from: x */
    private ImageView f5586x;

    /* renamed from: y */
    private ImageView f5587y;

    /* renamed from: z */
    private ImageView f5588z;

    /* renamed from: f */
    private final Handler f5568f = new Handler();

    /* renamed from: j */
    private boolean f5572j = true;

    /* renamed from: k */
    private boolean f5573k = false;

    /* renamed from: l */
    private boolean f5574l = false;

    /* renamed from: m */
    private boolean f5575m = true;

    /* renamed from: p */
    private float f5578p = 0.0f;

    /* renamed from: q */
    private int f5579q = 1000;

    /* renamed from: r */
    private int f5580r = 2000;

    /* renamed from: s */
    private int f5581s = 0;

    /* renamed from: t */
    private int f5582t = 0;

    /* renamed from: u */
    private Bitmap f5583u = null;

    /* renamed from: v */
    private int f5584v = this.f5579q;

    /* renamed from: B */
    private ImageView f5561B = null;

    /* renamed from: b */
    Runnable f5565b = new RunnableC1588j(this);

    /* renamed from: C */
    private View.OnTouchListener f5562C = new ViewOnTouchListenerC1587i(this);

    /* renamed from: D */
    private View.OnClickListener f5563D = new ViewOnClickListenerC1586h(this);

    @Override // com.sec.vip.cropimage.MonitoredActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f5581s = getWindowManager().getDefaultDisplay().getWidth();
        this.f5582t = getWindowManager().getDefaultDisplay().getHeight();
        if (!m5796d()) {
            C1341p.m4651a("[onCreate] setLayout error!", getClass().getSimpleName());
            finish();
        }
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: a */
    public int mo5709a() {
        return this.f5581s;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: b */
    public int mo5710b() {
        return this.f5582t;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: c */
    public float mo5711c() {
        return this.f5578p;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00dc -> B:102:0x00bc). Please report as a decompilation issue!!! */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m5796d() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 550
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ics.CropImage.m5796d():boolean");
    }

    /* renamed from: a */
    private int m5774a(int i) {
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
    private String m5778a(Uri uri) throws IllegalArgumentException {
        Cursor cursorLoadInBackground;
        String[] strArr = {"_data"};
        if (Build.VERSION.SDK_INT < 11) {
            cursorLoadInBackground = managedQuery(uri, strArr, null, null, null);
        } else {
            cursorLoadInBackground = new CursorLoader(this, uri, strArr, null, null, null).loadInBackground();
        }
        if (cursorLoadInBackground == null) {
            C1341p.m4661d("[getRealPathFromURI] cursor is null! - Camera", getClass().getSimpleName());
            return null;
        }
        int columnIndexOrThrow = cursorLoadInBackground.getColumnIndexOrThrow("_data");
        cursorLoadInBackground.moveToFirst();
        String string = cursorLoadInBackground.getString(columnIndexOrThrow);
        cursorLoadInBackground.close();
        return string;
    }

    /* renamed from: b */
    private int m5784b(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                C1341p.m4658b("optiions width height : " + options.outWidth + ", " + options.outHeight, getClass().getSimpleName());
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
    public void m5783a(boolean z) {
        if (!isFinishing()) {
            this.f5561B.setVisibility(0);
            this.f5576n.setImageBitmapResetBase(this.f5577o, (int) this.f5578p, true);
            m5779a(this, z, (String) null, getResources().getString(R.string.ams_msg_runningImageCrop), new RunnableC1589k(this), this.f5568f);
        }
    }

    /* renamed from: a */
    private static void m5779a(MonitoredActivity monitoredActivity, boolean z, String str, String str2, Runnable runnable, Handler handler) {
        ProgressDialog progressDialogM4725a = null;
        if (z) {
            progressDialogM4725a = ProgressDialogC1354a.m4725a(monitoredActivity, str, str2, true, false);
        }
        new Thread(new RunnableC1579a(monitoredActivity, runnable, progressDialogM4725a, handler)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0185  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m5798e() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ics.CropImage.m5798e():void");
    }

    /* renamed from: a */
    private void m5782a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m5789b(FileOutputStream fileOutputStream) throws IOException {
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
    public void m5800f() {
        this.f5578p += 90.0f;
        if (this.f5578p == 360.0f) {
            this.f5578p = 0.0f;
        }
        m5783a(false);
    }

    /* renamed from: b */
    private void m5787b(int i) {
        this.f5578p = i;
    }

    /* renamed from: g */
    private void m5802g() {
        this.f5584v = this.f5579q;
        this.f5585w = (ImageView) findViewById(R.id.iv_template_rect);
        this.f5586x = (ImageView) findViewById(R.id.iv_template_circle);
        this.f5587y = (ImageView) findViewById(R.id.iv_template_roundrect);
        this.f5588z = (ImageView) findViewById(R.id.iv_template_heart);
        this.f5560A = (ImageView) findViewById(R.id.iv_template_star);
        this.f5585w.setOnClickListener(this.f5563D);
        this.f5585w.setOnTouchListener(this.f5562C);
        this.f5586x.setOnClickListener(this.f5563D);
        this.f5586x.setOnTouchListener(this.f5562C);
        this.f5587y.setOnClickListener(this.f5563D);
        this.f5587y.setOnTouchListener(this.f5562C);
        this.f5588z.setOnClickListener(this.f5563D);
        this.f5588z.setOnTouchListener(this.f5562C);
        this.f5560A.setOnClickListener(this.f5563D);
        this.f5560A.setOnTouchListener(this.f5562C);
        m5790c(this.f5579q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5790c(int i) {
        int[] iArr = {1000, 1002, 1001, 1004, 1003};
        ImageView[] imageViewArr = {this.f5585w, this.f5586x, this.f5587y, this.f5588z, this.f5560A};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            imageViewArr[i2].setSelected(iArr[i2] == i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public int m5793d(int i) {
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
    public void m5804h() {
        new AlertDialogBuilderC1625m(this).setTitle(R.string.ams_crop_effect_image_title).setItems(R.array.ams_strarr_effect_image, new DialogInterfaceOnClickListenerC1580b(this, new AMSLibs())).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1590l(this)).create().show();
    }

    /* renamed from: a */
    private static Bitmap m5776a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
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
