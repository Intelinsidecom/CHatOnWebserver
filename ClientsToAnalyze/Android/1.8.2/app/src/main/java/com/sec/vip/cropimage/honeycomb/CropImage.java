package com.sec.vip.cropimage.honeycomb;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.graphics.Bitmap;
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
import com.sec.vip.amschaton.AMSActionBarView;
import com.sec.vip.cropimage.C2077a;
import com.sec.vip.cropimage.CropImageView;
import com.sec.vip.cropimage.MonitoredActivity;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class CropImage extends MonitoredActivity {

    /* renamed from: A */
    private ImageView f7574A;

    /* renamed from: B */
    private ImageView f7575B;

    /* renamed from: a */
    C2077a f7578a;

    /* renamed from: d */
    private int f7581d;

    /* renamed from: f */
    private int f7582f;

    /* renamed from: h */
    private int f7584h;

    /* renamed from: i */
    private int f7585i;

    /* renamed from: j */
    private boolean f7586j;

    /* renamed from: o */
    private CropImageView f7591o;

    /* renamed from: p */
    private Bitmap f7592p;

    /* renamed from: x */
    private ImageView f7600x;

    /* renamed from: y */
    private ImageView f7601y;

    /* renamed from: z */
    private ImageView f7602z;

    /* renamed from: g */
    private final Handler f7583g = new Handler();

    /* renamed from: k */
    private boolean f7587k = true;

    /* renamed from: l */
    private boolean f7588l = false;

    /* renamed from: m */
    private boolean f7589m = false;

    /* renamed from: n */
    private boolean f7590n = true;

    /* renamed from: q */
    private float f7593q = 0.0f;

    /* renamed from: r */
    private int f7594r = 1000;

    /* renamed from: s */
    private int f7595s = 2000;

    /* renamed from: t */
    private int f7596t = 0;

    /* renamed from: u */
    private int f7597u = 0;

    /* renamed from: v */
    private Bitmap f7598v = null;

    /* renamed from: w */
    private int f7599w = this.f7594r;

    /* renamed from: b */
    AMSActionBarView f7579b = null;

    /* renamed from: c */
    Runnable f7580c = new RunnableC2088d(this);

    /* renamed from: C */
    private View.OnTouchListener f7576C = new ViewOnTouchListenerC2090f(this);

    /* renamed from: D */
    private View.OnClickListener f7577D = new ViewOnClickListenerC2091g(this);

    @Override // com.sec.vip.cropimage.MonitoredActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f7596t = getWindowManager().getDefaultDisplay().getWidth();
        this.f7597u = getWindowManager().getDefaultDisplay().getHeight();
        if (!m7363e()) {
            C1786r.m6054a("[onCreate] setLayout error!", getClass().getSimpleName());
            finish();
        }
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: a */
    public int mo7298a() {
        return this.f7596t;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: b */
    public int mo7299b() {
        return this.f7597u;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: c */
    public float mo7300c() {
        return this.f7593q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public Context m7360d() {
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00de A[Catch: IOException -> 0x0143, OutOfMemoryError -> 0x0153, all -> 0x01fa, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x0143, blocks: (B:14:0x008d, B:15:0x0091, B:17:0x0097, B:19:0x00a2, B:21:0x00ac, B:32:0x00de, B:26:0x00be), top: B:100:0x008d }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00dc -> B:111:0x00bc). Please report as a decompilation issue!!! */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m7363e() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 513
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.honeycomb.CropImage.m7363e():boolean");
    }

    /* renamed from: a */
    private int m7338a(int i) {
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
    private String m7343a(Uri uri) throws IllegalArgumentException {
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

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:14:0x0030
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* renamed from: b */
    private int m7349b(android.net.Uri r6) {
        /*
            r5 = this;
            r2 = 0
            r4 = 24
            r0 = -1
            android.content.ContentResolver r1 = r5.getContentResolver()
            java.io.InputStream r2 = r1.openInputStream(r6)     // Catch: java.io.FileNotFoundException -> L26 java.lang.Throwable -> L32
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch: java.io.FileNotFoundException -> L26 java.lang.Throwable -> L32
            r1.<init>()     // Catch: java.io.FileNotFoundException -> L26 java.lang.Throwable -> L32
            r3 = 1
            r1.inJustDecodeBounds = r3     // Catch: java.io.FileNotFoundException -> L26 java.lang.Throwable -> L32
            r3 = 0
            android.graphics.BitmapFactory.decodeStream(r2, r3, r1)     // Catch: java.io.FileNotFoundException -> L26 java.lang.Throwable -> L32
            int r3 = r1.outWidth     // Catch: java.io.FileNotFoundException -> L26 java.lang.Throwable -> L32
            int r1 = r1.outHeight     // Catch: java.io.FileNotFoundException -> L26 java.lang.Throwable -> L32
            if (r3 < r4) goto L20
            if (r1 >= r4) goto L39
        L20:
            if (r2 == 0) goto L25
            r2.close()     // Catch: java.io.IOException -> L30
        L25:
            return r0
        L26:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L25
            r2.close()     // Catch: java.io.IOException -> L30
            goto L25
        L30:
            r1 = move-exception
            goto L25
        L32:
            r0 = move-exception
            if (r2 == 0) goto L38
            r2.close()     // Catch: java.io.IOException -> L71
        L38:
            throw r0
        L39:
            if (r2 == 0) goto L3e
            r2.close()     // Catch: java.io.IOException -> L73
        L3e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "optiions width height : "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r2 = ", "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Class r2 = r5.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1786r.m6061b(r0, r2)
            int r0 = r3 * r1
            float r0 = (float) r0
            r1 = 1234567168(0x49960000, float:1228800.0)
            float r0 = r0 / r1
            r1 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r1
            int r0 = (int) r0
            goto L25
        L71:
            r1 = move-exception
            goto L38
        L73:
            r0 = move-exception
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.honeycomb.CropImage.m7349b(android.net.Uri):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7347a(boolean z) {
        if (!isFinishing()) {
            this.f7591o.setImageBitmapResetBase(this.f7592p, (int) this.f7593q, false);
            m7344a(this, z, (String) null, getResources().getString(R.string.ams_msg_runningImageCrop), new RunnableC2085a(this), this.f7583g);
        }
    }

    /* renamed from: a */
    private static void m7344a(MonitoredActivity monitoredActivity, boolean z, String str, String str2, Runnable runnable, Handler handler) {
        ProgressDialog progressDialogM6142a = null;
        if (z) {
            progressDialogM6142a = ProgressDialogC1806j.m6142a(monitoredActivity, str, str2, true, false);
        }
        new Thread(new RunnableC2097m(monitoredActivity, runnable, progressDialogM6142a, handler)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0185  */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m7365f() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.honeycomb.CropImage.m7365f():void");
    }

    /* renamed from: a */
    private void m7346a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m7353b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m7366g() {
        this.f7593q += 90.0f;
        if (this.f7593q == 360.0f) {
            this.f7593q = 0.0f;
        }
        m7347a(false);
    }

    /* renamed from: b */
    private void m7352b(int i) {
        this.f7593q = i;
    }

    /* renamed from: h */
    private void m7369h() {
        this.f7599w = this.f7594r;
        this.f7600x = (ImageView) findViewById(R.id.iv_template_rect);
        this.f7601y = (ImageView) findViewById(R.id.iv_template_circle);
        this.f7602z = (ImageView) findViewById(R.id.iv_template_roundrect);
        this.f7574A = (ImageView) findViewById(R.id.iv_template_heart);
        this.f7575B = (ImageView) findViewById(R.id.iv_template_star);
        this.f7600x.setOnClickListener(this.f7577D);
        this.f7600x.setOnTouchListener(this.f7576C);
        this.f7601y.setOnClickListener(this.f7577D);
        this.f7601y.setOnTouchListener(this.f7576C);
        this.f7602z.setOnClickListener(this.f7577D);
        this.f7602z.setOnTouchListener(this.f7576C);
        this.f7574A.setOnClickListener(this.f7577D);
        this.f7574A.setOnTouchListener(this.f7576C);
        this.f7575B.setOnClickListener(this.f7577D);
        this.f7575B.setOnTouchListener(this.f7576C);
        m7356c(this.f7594r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7356c(int i) {
        int[] iArr = {1000, 1002, 1001, 1004, 1003};
        ImageView[] imageViewArr = {this.f7600x, this.f7601y, this.f7602z, this.f7574A, this.f7575B};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            imageViewArr[i2].setSelected(iArr[i2] == i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public int m7358d(int i) {
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
    /* renamed from: i */
    public void m7371i() {
        new AlertDialogBuilderC2120a(this).setTitle(R.string.ams_crop_effect_image_title).setItems(R.array.ams_strarr_effect_image, new DialogInterfaceOnClickListenerC2093i(this, new AMSLibs())).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC2092h(this)).create().show();
    }

    /* renamed from: a */
    private static Bitmap m7340a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
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

    @Override // android.app.Activity
    protected void onResume() {
        overridePendingTransition(R.anim.anim_ics2_activity_appear, R.anim.anim_ics2_activity_disappear);
        super.onResume();
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: b */
    private void m7354b(boolean z) {
        if (this.f7579b != null) {
            this.f7579b.m6251b(5002, z);
        }
    }

    /* renamed from: j */
    private void m7373j() {
        this.f7579b = (AMSActionBarView) findViewById(R.id.actionbar);
    }

    /* renamed from: k */
    private void m7375k() {
        m7373j();
        this.f7579b.setTitleText(R.string.ams_app_name);
        this.f7579b.m6244a();
        this.f7579b.m6246a(R.drawable.ams_ics_selector_title_ic_cancel, R.string.ams_btn_cancel, new ViewOnClickListenerC2094j(this), 5000);
        this.f7579b.m6246a(R.drawable.ams_ics_selector_title_ic_rotate, R.string.imagemodify_crop_rotate_image, new ViewOnClickListenerC2095k(this), 5001);
        this.f7579b.m6246a(R.drawable.ams_ics_selector_title_ic_effect, R.string.ams_crop_effect_image, new ViewOnClickListenerC2096l(this), 5002);
        this.f7579b.m6246a(R.drawable.ams_ics_selector_title_ic_check, R.string.ams_btn_apply, new ViewOnClickListenerC2087c(this), 5003);
        this.f7579b.setMoreOptionIconVisibility(false);
        this.f7579b.setActionButtonLayoutVisibility(true);
    }
}
