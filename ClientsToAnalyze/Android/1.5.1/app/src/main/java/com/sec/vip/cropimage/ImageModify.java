package com.sec.vip.cropimage;

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
import android.widget.ImageView;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.pns.msg.MsgResultCode;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class ImageModify extends MonitoredActivity {

    /* renamed from: A */
    private ImageView f4395A;

    /* renamed from: B */
    private ImageView f4396B;

    /* renamed from: a */
    boolean f4399a;

    /* renamed from: b */
    C0742o f4400b;

    /* renamed from: e */
    private int f4403e;

    /* renamed from: f */
    private int f4404f;

    /* renamed from: h */
    private int f4406h;

    /* renamed from: i */
    private int f4407i;

    /* renamed from: j */
    private boolean f4408j;

    /* renamed from: o */
    private ImageModifyView f4413o;

    /* renamed from: p */
    private Bitmap f4414p;

    /* renamed from: x */
    private ImageView f4422x;

    /* renamed from: y */
    private ImageView f4423y;

    /* renamed from: z */
    private ImageView f4424z;

    /* renamed from: g */
    private final Handler f4405g = new Handler();

    /* renamed from: k */
    private boolean f4409k = true;

    /* renamed from: l */
    private boolean f4410l = false;

    /* renamed from: m */
    private boolean f4411m = false;

    /* renamed from: n */
    private boolean f4412n = true;

    /* renamed from: c */
    public float f4401c = 0.0f;

    /* renamed from: q */
    private int f4415q = MsgResultCode.SUCCESS;

    /* renamed from: r */
    private int f4416r = MsgResultCode.UNKNOWN_MESSAGE_TYPE;

    /* renamed from: s */
    private int f4417s = 0;

    /* renamed from: t */
    private int f4418t = 0;

    /* renamed from: u */
    private Bitmap f4419u = null;

    /* renamed from: v */
    private Dialog f4420v = null;

    /* renamed from: w */
    private int f4421w = this.f4415q;

    /* renamed from: d */
    Runnable f4402d = new RunnableC0740m(this);

    /* renamed from: C */
    private View.OnTouchListener f4397C = new ViewOnTouchListenerC0738k(this);

    /* renamed from: D */
    private View.OnClickListener f4398D = new ViewOnClickListenerC0739l(this);

    /* renamed from: a */
    private int m4280a(Uri uri) throws FileNotFoundException {
        try {
            InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(inputStreamOpenInputStream, null, options);
            ChatONLogWriter.m3506b("optiions width height : " + options.outWidth + ", " + options.outHeight, getClass().getSimpleName());
            return (int) (((r0 * r1) / 2400000.0f) + 1.0f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    private static Bitmap m4283a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
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
    public void m4284a(int i) {
        int[] iArr = {MsgResultCode.SUCCESS, 1002, 1001, 1004, 1003};
        ImageView[] imageViewArr = {this.f4422x, this.f4423y, this.f4424z, this.f4395A, this.f4396B};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            imageViewArr[i2].setSelected(iArr[i2] == i);
        }
    }

    /* renamed from: a */
    private static void m4286a(MonitoredActivity monitoredActivity, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new RunnableC0753z(monitoredActivity, runnable, ProgressDialog.show(monitoredActivity, str, str2, true, false), handler)).start();
    }

    /* renamed from: a */
    private void m4287a(FileOutputStream fileOutputStream) {
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
    public int m4288b(int i) {
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
    private void m4291b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:30:0x011e
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014a  */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m4295d() {
        /*
            Method dump skipped, instructions count: 416
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageModify.m4295d():boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m4297e() {
        if (isFinishing()) {
            return;
        }
        this.f4413o.m4322a(this.f4414p, (int) this.f4401c, true);
        m4286a(this, null, getResources().getString(C0062R.string.ams_msg_runningImageCrop), new RunnableC0735h(this), this.f4405g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018d  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m4299f() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 730
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.ImageModify.m4299f():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m4301g() {
        int width = this.f4414p.getWidth();
        int height = this.f4414p.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f, width / 2, height / 2);
        this.f4414p = Bitmap.createBitmap(this.f4414p, 0, 0, width, height, matrix, true);
        this.f4413o.mo4313a();
        m4297e();
    }

    /* renamed from: a */
    public int m4307a() {
        return this.f4417s;
    }

    /* renamed from: b */
    public int m4308b() {
        return this.f4418t;
    }

    /* renamed from: c */
    public float m4309c() {
        return this.f4401c;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        this.f4417s = getWindowManager().getDefaultDisplay().getWidth();
        this.f4418t = getWindowManager().getDefaultDisplay().getHeight();
        if (m4295d()) {
            return;
        }
        ChatONLogWriter.m3499a("[onCreate] setLayout error!", getClass().getSimpleName());
        setResult(0);
        finish();
    }
}
