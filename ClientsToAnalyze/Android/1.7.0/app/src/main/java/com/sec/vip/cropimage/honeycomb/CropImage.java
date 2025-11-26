package com.sec.vip.cropimage.honeycomb;

import android.app.ProgressDialog;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import com.sec.vip.cropimage.C1598o;
import com.sec.vip.cropimage.CropImageView;
import com.sec.vip.cropimage.MonitoredActivity;
import com.sec.widget.C1619g;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class CropImage extends MonitoredActivity {

    /* renamed from: A */
    private ImageView f5514A;

    /* renamed from: a */
    C1598o f5517a;

    /* renamed from: c */
    private int f5519c;

    /* renamed from: d */
    private int f5520d;

    /* renamed from: g */
    private int f5522g;

    /* renamed from: h */
    private int f5523h;

    /* renamed from: i */
    private boolean f5524i;

    /* renamed from: n */
    private CropImageView f5529n;

    /* renamed from: o */
    private Bitmap f5530o;

    /* renamed from: w */
    private ImageView f5538w;

    /* renamed from: x */
    private ImageView f5539x;

    /* renamed from: y */
    private ImageView f5540y;

    /* renamed from: z */
    private ImageView f5541z;

    /* renamed from: f */
    private final Handler f5521f = new Handler();

    /* renamed from: j */
    private boolean f5525j = true;

    /* renamed from: k */
    private boolean f5526k = false;

    /* renamed from: l */
    private boolean f5527l = false;

    /* renamed from: m */
    private boolean f5528m = true;

    /* renamed from: p */
    private float f5531p = 0.0f;

    /* renamed from: q */
    private int f5532q = 1000;

    /* renamed from: r */
    private int f5533r = 2000;

    /* renamed from: s */
    private int f5534s = 0;

    /* renamed from: t */
    private int f5535t = 0;

    /* renamed from: u */
    private Bitmap f5536u = null;

    /* renamed from: v */
    private int f5537v = this.f5532q;

    /* renamed from: b */
    Runnable f5518b = new RunnableC1572c(this);

    /* renamed from: B */
    private View.OnTouchListener f5515B = new ViewOnTouchListenerC1573d(this);

    /* renamed from: C */
    private View.OnClickListener f5516C = new ViewOnClickListenerC1574e(this);

    @Override // com.sec.vip.cropimage.MonitoredActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5534s = getWindowManager().getDefaultDisplay().getWidth();
        this.f5535t = getWindowManager().getDefaultDisplay().getHeight();
        if (!m5760d()) {
            C1341p.m4651a("[onCreate] setLayout error!", getClass().getSimpleName());
            finish();
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ams_ics_option_menu_crop_image, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) throws Throwable {
        switch (menuItem.getItemId()) {
            case R.id.menu_btn_apply /* 2131428257 */:
                m5762e();
                return true;
            case R.id.menu_btn_rotate /* 2131428258 */:
                m5764f();
                return true;
            case R.id.menu_btn_cancel /* 2131428259 */:
                setResult(0);
                finish();
                return true;
            default:
                return false;
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: a */
    public int mo5709a() {
        return this.f5534s;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: b */
    public int mo5710b() {
        return this.f5535t;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: c */
    public float mo5711c() {
        return this.f5531p;
    }

    /* renamed from: d */
    private boolean m5760d() throws Throwable {
        int iM5740a;
        IOException e;
        InputStream inputStream;
        InputStream inputStream2 = null;
        setContentView(R.layout.ams_ics_layout_cropimage);
        this.f5529n = (CropImageView) findViewById(R.id.image);
        if (Build.VERSION.SDK_INT >= 11) {
            this.f5529n.setLayerType(1, null);
        }
        this.f5529n.f5434a = this;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.getBoolean("circleCrop")) {
                this.f5526k = true;
                this.f5519c = 1;
                this.f5520d = 1;
            }
            this.f5530o = (Bitmap) extras.getParcelable("data");
            this.f5519c = extras.getInt("aspectX");
            this.f5520d = extras.getInt("aspectY");
            this.f5522g = extras.getInt("outputX");
            this.f5523h = extras.getInt("outputY");
            this.f5527l = extras.getBoolean("template");
            this.f5528m = extras.getBoolean("effect");
            this.f5524i = extras.getBoolean("scale", true);
            this.f5525j = extras.getBoolean("scaleUpIfNeeded", true);
        }
        this.f5528m = false;
        if (this.f5530o == null) {
            InputStream inputStream3 = null;
            try {
                try {
                    try {
                        Uri data = intent.getData();
                        String strM5745a = m5745a(data);
                        if (strM5745a != null && !new File(strM5745a).exists()) {
                            C1619g.m5888a(this, R.string.trunk_toast_loading_failed, 0).show();
                            if (0 == 0) {
                                return false;
                            }
                            try {
                                inputStream3.close();
                                return false;
                            } catch (IOException e2) {
                                return false;
                            }
                        }
                        InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(data);
                        try {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inSampleSize = m5751b(data);
                            C1341p.m4658b("options.inSampleSize : " + options.inSampleSize, getClass().getSimpleName());
                            this.f5530o = BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
                            if (inputStreamOpenInputStream != null) {
                                try {
                                    inputStreamOpenInputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                        } catch (IOException e4) {
                            e = e4;
                            inputStream = inputStreamOpenInputStream;
                            try {
                                throw new RuntimeException(e);
                            } catch (Throwable th) {
                                th = th;
                                inputStream2 = inputStream;
                                if (inputStream2 != null) {
                                    try {
                                        inputStream2.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                throw th;
                            }
                        }
                    } catch (OutOfMemoryError e6) {
                        throw new OutOfMemoryError();
                    }
                } catch (IOException e7) {
                    e = e7;
                    inputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        if (this.f5530o == null) {
            C1341p.m4651a("mBitmap is null!", getClass().getSimpleName());
            return false;
        }
        findViewById(R.id.layout_template_buttons).setVisibility(this.f5527l ? 0 : 8);
        m5765g();
        invalidateOptionsMenu();
        try {
            iM5740a = m5740a(new ExifInterface(intent.getData().getPath()).getAttributeInt("Orientation", 1));
        } catch (IOException e8) {
            iM5740a = 0;
            e = e8;
        }
        try {
            C1341p.m4660c("# exifDegree : " + iM5740a, getClass().getName());
        } catch (IOException e9) {
            e = e9;
            e.printStackTrace();
            m5753b(iM5740a);
            m5749a(true);
            return true;
        }
        m5753b(iM5740a);
        m5749a(true);
        return true;
    }

    /* renamed from: a */
    private int m5740a(int i) {
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
    private String m5745a(Uri uri) throws IllegalArgumentException {
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
    private int m5751b(Uri uri) throws IOException {
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
    public void m5749a(boolean z) {
        if (!isFinishing()) {
            this.f5529n.setImageBitmapResetBase(this.f5530o, (int) this.f5531p, true);
            m5746a(this, z, (String) null, getResources().getString(R.string.ams_msg_runningImageCrop), new RunnableC1575f(this), this.f5521f);
        }
    }

    /* renamed from: a */
    private static void m5746a(MonitoredActivity monitoredActivity, boolean z, String str, String str2, Runnable runnable, Handler handler) {
        ProgressDialog progressDialogM4725a = null;
        if (z) {
            progressDialogM4725a = ProgressDialogC1354a.m4725a(monitoredActivity, str, str2, true, false);
        }
        new Thread(new RunnableC1577h(monitoredActivity, runnable, progressDialogM4725a, handler)).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0185  */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m5762e() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.honeycomb.CropImage.m5762e():void");
    }

    /* renamed from: a */
    private void m5748a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m5754b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: f */
    private void m5764f() {
        this.f5531p += 90.0f;
        if (this.f5531p == 360.0f) {
            this.f5531p = 0.0f;
        }
        m5749a(false);
    }

    /* renamed from: b */
    private void m5753b(int i) {
        this.f5531p = i;
    }

    /* renamed from: g */
    private void m5765g() {
        this.f5537v = this.f5532q;
        this.f5538w = (ImageView) findViewById(R.id.iv_template_rect);
        this.f5539x = (ImageView) findViewById(R.id.iv_template_circle);
        this.f5540y = (ImageView) findViewById(R.id.iv_template_roundrect);
        this.f5541z = (ImageView) findViewById(R.id.iv_template_heart);
        this.f5514A = (ImageView) findViewById(R.id.iv_template_star);
        this.f5538w.setOnClickListener(this.f5516C);
        this.f5538w.setOnTouchListener(this.f5515B);
        this.f5539x.setOnClickListener(this.f5516C);
        this.f5539x.setOnTouchListener(this.f5515B);
        this.f5540y.setOnClickListener(this.f5516C);
        this.f5540y.setOnTouchListener(this.f5515B);
        this.f5541z.setOnClickListener(this.f5516C);
        this.f5541z.setOnTouchListener(this.f5515B);
        this.f5514A.setOnClickListener(this.f5516C);
        this.f5514A.setOnTouchListener(this.f5515B);
        m5756c(this.f5532q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5756c(int i) {
        int[] iArr = {1000, 1002, 1001, 1004, 1003};
        ImageView[] imageViewArr = {this.f5538w, this.f5539x, this.f5540y, this.f5541z, this.f5514A};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            imageViewArr[i2].setSelected(iArr[i2] == i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public int m5758d(int i) {
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
    private static Bitmap m5742a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
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
