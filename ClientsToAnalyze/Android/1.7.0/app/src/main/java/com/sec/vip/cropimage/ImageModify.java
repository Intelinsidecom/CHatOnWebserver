package com.sec.vip.cropimage;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyProfileActivity;
import com.sec.chaton.util.C1341p;
import com.sec.widget.C1619g;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class ImageModify extends MonitoredActivity {

    /* renamed from: A */
    private ImageView f5441A;

    /* renamed from: B */
    private ImageView f5442B;

    /* renamed from: C */
    private ImageView f5443C;

    /* renamed from: D */
    private ImageView f5444D;

    /* renamed from: E */
    private ImageView f5445E;

    /* renamed from: F */
    private Toast f5446F;

    /* renamed from: G */
    private Intent f5447G;

    /* renamed from: H */
    private Uri f5448H;

    /* renamed from: a */
    boolean f5451a;

    /* renamed from: b */
    C1598o f5452b;

    /* renamed from: h */
    private int f5457h;

    /* renamed from: i */
    private int f5458i;

    /* renamed from: k */
    private int f5460k;

    /* renamed from: l */
    private int f5461l;

    /* renamed from: m */
    private boolean f5462m;

    /* renamed from: r */
    private ImageModifyView f5467r;

    /* renamed from: s */
    private Bitmap f5468s;

    /* renamed from: f */
    private final int f5455f = 1;

    /* renamed from: g */
    private final int f5456g = 2;

    /* renamed from: j */
    private final Handler f5459j = new Handler();

    /* renamed from: n */
    private boolean f5463n = true;

    /* renamed from: o */
    private boolean f5464o = false;

    /* renamed from: p */
    private boolean f5465p = false;

    /* renamed from: q */
    private boolean f5466q = true;

    /* renamed from: c */
    public float f5453c = 0.0f;

    /* renamed from: t */
    private int f5469t = 1000;

    /* renamed from: u */
    private int f5470u = 2000;

    /* renamed from: v */
    private int f5471v = 0;

    /* renamed from: w */
    private int f5472w = 0;

    /* renamed from: x */
    private Bitmap f5473x = null;

    /* renamed from: y */
    private Dialog f5474y = null;

    /* renamed from: z */
    private int f5475z = this.f5469t;

    /* renamed from: d */
    Runnable f5454d = new RunnableC1596m(this);

    /* renamed from: I */
    private View.OnTouchListener f5449I = new ViewOnTouchListenerC1597n(this);

    /* renamed from: J */
    private View.OnClickListener f5450J = new ViewOnClickListenerC1595l(this);

    @Override // com.sec.vip.cropimage.MonitoredActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5471v = getWindowManager().getDefaultDisplay().getWidth();
        this.f5472w = getWindowManager().getDefaultDisplay().getHeight();
        requestWindowFeature(1);
        this.f5447G = getIntent();
        Bundle extras = this.f5447G.getExtras();
        if (extras != null) {
            if (!extras.getBoolean("is_gallery") && !extras.getBoolean("is_camera")) {
                this.f5448H = getIntent().getData();
                if (!m5697e()) {
                    C1341p.m4651a("[onCreate] setLayout error!", getClass().getSimpleName());
                    setResult(0);
                    finish();
                    return;
                }
                return;
            }
            m5695d();
        }
    }

    /* renamed from: d */
    private void m5695d() {
        Bundle extras = this.f5447G.getExtras();
        if (extras != null) {
            if (extras.getBoolean("is_gallery")) {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("image/*");
                if (!BuddyProfileActivity.m2254a(this, intent)) {
                    intent = new Intent();
                    intent.setAction("android.intent.action.GET_CONTENT");
                    intent.setType("image/*");
                }
                intent.putExtra("return-data", true);
                intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                startActivityForResult(intent, 1);
                return;
            }
            if (extras.getBoolean("is_camera")) {
                String string = extras.getString("image_uri");
                this.f5448H = Uri.parse(string);
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                intent2.putExtra("outputX", 600);
                intent2.putExtra("outputY", 600);
                intent2.putExtra("aspectX", 1);
                intent2.putExtra("aspectY", 1);
                intent2.putExtra("scale", true);
                intent2.putExtra("return-data", false);
                intent2.putExtra("output", Uri.parse(string));
                intent2.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
                startActivityForResult(intent2, 2);
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 != -1) {
                    setResult(0);
                    finish();
                    break;
                } else if (intent == null) {
                    C1341p.m4658b("Image pick Return is NULL", getClass().getSimpleName());
                    break;
                } else {
                    this.f5448H = intent.getData();
                    this.f5447G.setData(intent.getData());
                    if (!m5697e()) {
                        C1341p.m4651a("[onCreate] setLayout error!", getClass().getSimpleName());
                        setResult(0);
                        finish();
                        break;
                    }
                }
                break;
            case 2:
                if (i2 != -1) {
                    setResult(0);
                    finish();
                    break;
                } else {
                    this.f5447G.setData(this.f5448H);
                    if (!m5697e()) {
                        C1341p.m4651a("[onCreate] setLayout error!", getClass().getSimpleName());
                        setResult(0);
                        finish();
                        break;
                    }
                }
                break;
        }
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: a */
    public int mo5709a() {
        return this.f5471v;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: b */
    public int mo5710b() {
        return this.f5472w;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: c */
    public float mo5711c() {
        return this.f5453c;
    }

    /* JADX WARN: Removed duplicated region for block: B:93:0x01d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m5697e() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 574
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageModify.m5697e():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m5699f() {
        if (!isFinishing()) {
            this.f5467r.setImageBitmapResetBase(this.f5468s, (int) this.f5453c, true);
            m5686a(this, null, null, new RunnableC1578i(this), this.f5459j);
        }
    }

    /* renamed from: a */
    private static void m5686a(MonitoredActivity monitoredActivity, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new RunnableC1599p(monitoredActivity, runnable, null, handler)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:56:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x019b  */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m5701g() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 816
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageModify.m5701g():void");
    }

    /* renamed from: a */
    private void m5687a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m5691b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m5703h() {
        int width = this.f5468s.getWidth();
        int height = this.f5468s.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f, width / 2, height / 2);
        try {
            this.f5468s = Bitmap.createBitmap(this.f5468s, 0, 0, width, height, matrix, true);
            this.f5467r.mo5679b();
            m5699f();
        } catch (OutOfMemoryError e) {
            C1619g.m5888a(getApplicationContext(), R.string.chat_view_memory_error, 0).show();
            C1341p.m4653a(e, getClass().getName());
            setResult(0);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5685a(int i) {
        int[] iArr = {1000, 1002, 1001, 1004, 1003};
        ImageView[] imageViewArr = {this.f5441A, this.f5442B, this.f5443C, this.f5444D, this.f5445E};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            imageViewArr[i2].setSelected(iArr[i2] == i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m5688b(int i) {
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
    private static Bitmap m5682a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
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

    @Override // com.sec.vip.cropimage.MonitoredActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.f5468s != null) {
            this.f5468s.recycle();
            this.f5468s = null;
        }
    }
}
