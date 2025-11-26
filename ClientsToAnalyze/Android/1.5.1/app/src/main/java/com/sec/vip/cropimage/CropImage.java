package com.sec.vip.cropimage;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.sec.amsoma.AMSLibs;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.pns.msg.MsgResultCode;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class CropImage extends MonitoredActivity {

    /* renamed from: A */
    private ImageView f4358A;

    /* renamed from: B */
    private ImageView f4359B;

    /* renamed from: a */
    boolean f4362a;

    /* renamed from: b */
    C0742o f4363b;

    /* renamed from: d */
    private int f4365d;

    /* renamed from: e */
    private int f4366e;

    /* renamed from: g */
    private int f4368g;

    /* renamed from: h */
    private int f4369h;

    /* renamed from: i */
    private boolean f4370i;

    /* renamed from: n */
    private CropImageView f4375n;

    /* renamed from: o */
    private Bitmap f4376o;

    /* renamed from: x */
    private ImageView f4385x;

    /* renamed from: y */
    private ImageView f4386y;

    /* renamed from: z */
    private ImageView f4387z;

    /* renamed from: f */
    private final Handler f4367f = new Handler();

    /* renamed from: j */
    private boolean f4371j = true;

    /* renamed from: k */
    private boolean f4372k = false;

    /* renamed from: l */
    private boolean f4373l = false;

    /* renamed from: m */
    private boolean f4374m = true;

    /* renamed from: p */
    private float f4377p = 0.0f;

    /* renamed from: q */
    private int f4378q = MsgResultCode.SUCCESS;

    /* renamed from: r */
    private int f4379r = MsgResultCode.UNKNOWN_MESSAGE_TYPE;

    /* renamed from: s */
    private int f4380s = 0;

    /* renamed from: t */
    private int f4381t = 0;

    /* renamed from: u */
    private Bitmap f4382u = null;

    /* renamed from: v */
    private Dialog f4383v = null;

    /* renamed from: w */
    private int f4384w = this.f4378q;

    /* renamed from: c */
    Runnable f4364c = new RunnableC0747t(this);

    /* renamed from: C */
    private View.OnTouchListener f4360C = new ViewOnTouchListenerC0746s(this);

    /* renamed from: D */
    private View.OnClickListener f4361D = new ViewOnClickListenerC0733f(this);

    /* renamed from: a */
    private int m4234a(Uri uri) throws FileNotFoundException {
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
            ChatONLogWriter.m3506b("optiions width height : " + options.outWidth + ", " + options.outHeight, getClass().getSimpleName());
            return (int) (((r0 * r1) / 1228800.0f) + 0.5f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    private static Bitmap m4237a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
        Matrix matrix2;
        Matrix matrix3;
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
                matrix3 = matrix;
            } else {
                matrix3 = null;
            }
            matrix2 = matrix3;
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
        if (bitmapCreateBitmap3 != bitmapCreateBitmap2 && (z2 || bitmapCreateBitmap2 != bitmap)) {
            bitmapCreateBitmap2.recycle();
        }
        return bitmapCreateBitmap3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4239a(int i) {
        int[] iArr = {MsgResultCode.SUCCESS, 1002, 1001, 1004, 1003};
        ImageView[] imageViewArr = {this.f4385x, this.f4386y, this.f4387z, this.f4358A, this.f4359B};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            imageViewArr[i2].setSelected(iArr[i2] == i);
        }
    }

    /* renamed from: a */
    private static void m4241a(MonitoredActivity monitoredActivity, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new RunnableC0728ad(monitoredActivity, runnable, ProgressDialog.show(monitoredActivity, str, str2, true, false), handler)).start();
    }

    /* renamed from: a */
    private void m4242a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m4243b(int i) {
        switch (i) {
            case 1001:
                return C0062R.id.iv_template_roundrect;
            case 1002:
                return C0062R.id.iv_template_circle;
            case 1003:
                return C0062R.id.iv_template_star;
            case 1004:
                return C0062R.id.iv_template_heart;
            default:
                return C0062R.id.iv_template_rect;
        }
    }

    /* renamed from: b */
    private void m4247b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m4252d() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 429
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.CropImage.m4252d():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m4254e() {
        if (isFinishing()) {
            return;
        }
        this.f4375n.m4322a(this.f4376o, (int) this.f4377p, true);
        m4241a(this, null, getResources().getString(C0062R.string.ams_msg_runningImageCrop), new RunnableC0750w(this), this.f4367f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0183  */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v25, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.graphics.Bitmap, android.os.Parcelable] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.sec.vip.cropimage.CropImage, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.os.Bundle] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.FileOutputStream, java.io.OutputStream] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m4256f() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 726
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.CropImage.m4256f():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4258g() {
        this.f4377p += 90.0f;
        if (this.f4377p == 360.0f) {
            this.f4377p = 0.0f;
        }
        m4254e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m4260h() {
        this.f4384w = this.f4378q;
        this.f4383v = new Dialog(this, C0062R.style.AMSCustomDialogTheme);
        this.f4383v.requestWindowFeature(1);
        this.f4383v.setContentView(C0062R.layout.ams_cropstamp_template_layout);
        this.f4383v.setOnCancelListener(new DialogInterfaceOnCancelListenerC0748u(this));
        ((Button) this.f4383v.findViewById(C0062R.id.btn_cancel)).setOnClickListener(this.f4361D);
        this.f4385x = (ImageView) this.f4383v.findViewById(C0062R.id.iv_template_rect);
        this.f4386y = (ImageView) this.f4383v.findViewById(C0062R.id.iv_template_circle);
        this.f4387z = (ImageView) this.f4383v.findViewById(C0062R.id.iv_template_roundrect);
        this.f4358A = (ImageView) this.f4383v.findViewById(C0062R.id.iv_template_heart);
        this.f4359B = (ImageView) this.f4383v.findViewById(C0062R.id.iv_template_star);
        this.f4385x.setOnClickListener(this.f4361D);
        this.f4385x.setOnTouchListener(this.f4360C);
        this.f4386y.setOnClickListener(this.f4361D);
        this.f4386y.setOnTouchListener(this.f4360C);
        this.f4387z.setOnClickListener(this.f4361D);
        this.f4387z.setOnTouchListener(this.f4360C);
        this.f4358A.setOnClickListener(this.f4361D);
        this.f4358A.setOnTouchListener(this.f4360C);
        this.f4359B.setOnClickListener(this.f4361D);
        this.f4359B.setOnTouchListener(this.f4360C);
        m4239a(this.f4378q);
        this.f4383v.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m4262i() {
        new AlertDialog.Builder(this).setTitle(C0062R.string.ams_crop_effect_image_title).setItems(C0062R.array.ams_strarr_effect_image, new DialogInterfaceOnClickListenerC0732e(this, new AMSLibs())).create().show();
    }

    /* renamed from: a */
    public int m4271a() {
        return this.f4380s;
    }

    /* renamed from: b */
    public int m4272b() {
        return this.f4381t;
    }

    /* renamed from: c */
    public float m4273c() {
        return this.f4377p;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f4380s = getWindowManager().getDefaultDisplay().getWidth();
        this.f4381t = getWindowManager().getDefaultDisplay().getHeight();
        if (m4252d()) {
            return;
        }
        ChatONLogWriter.m3499a("[onCreate] setLayout error!", getClass().getSimpleName());
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
    }
}
