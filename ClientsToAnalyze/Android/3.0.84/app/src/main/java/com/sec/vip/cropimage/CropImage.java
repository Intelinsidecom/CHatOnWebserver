package com.sec.vip.cropimage;

import android.app.ProgressDialog;
import android.content.CursorLoader;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.CommonApplication;
import com.sec.vip.imagefilter.C3631a;
import com.sec.widget.C3641ai;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class CropImage extends MonitoredActivity {

    /* renamed from: A */
    private ImageView f13146A;

    /* renamed from: B */
    private ImageView f13147B;

    /* renamed from: C */
    private ImageView f13148C;

    /* renamed from: N */
    private boolean f13159N;

    /* renamed from: a */
    C3619o f13163a;

    /* renamed from: c */
    private CropImageView f13165c;

    /* renamed from: d */
    private int f13166d;

    /* renamed from: f */
    private int f13167f;

    /* renamed from: h */
    private int f13169h;

    /* renamed from: i */
    private int f13170i;

    /* renamed from: j */
    private boolean f13171j;

    /* renamed from: o */
    private Bitmap f13176o;

    /* renamed from: y */
    private ImageView f13186y;

    /* renamed from: z */
    private ImageView f13187z;

    /* renamed from: g */
    private final Handler f13168g = new Handler();

    /* renamed from: k */
    private boolean f13172k = true;

    /* renamed from: l */
    private boolean f13173l = false;

    /* renamed from: m */
    private boolean f13174m = false;

    /* renamed from: n */
    private boolean f13175n = true;

    /* renamed from: p */
    private int[] f13177p = null;

    /* renamed from: q */
    private LinearLayout f13178q = null;

    /* renamed from: r */
    private LinearLayout f13179r = null;

    /* renamed from: s */
    private float f13180s = 0.0f;

    /* renamed from: t */
    private float f13181t = 0.0f;

    /* renamed from: u */
    private int f13182u = 1000;

    /* renamed from: v */
    private int f13183v = 2000;

    /* renamed from: w */
    private Bitmap f13184w = null;

    /* renamed from: x */
    private Bitmap f13185x = null;

    /* renamed from: D */
    private String f13149D = "";

    /* renamed from: E */
    private boolean f13150E = false;

    /* renamed from: F */
    private ArrayList<C3618n> f13151F = null;

    /* renamed from: G */
    private boolean f13152G = false;

    /* renamed from: H */
    private int f13153H = 2000;

    /* renamed from: I */
    private Uri f13154I = null;

    /* renamed from: J */
    private int f13155J = 1;

    /* renamed from: K */
    private int f13156K = 0;

    /* renamed from: L */
    private int f13157L = 0;

    /* renamed from: M */
    private boolean f13158M = true;

    /* renamed from: b */
    Runnable f13164b = new RunnableC3610f(this);

    /* renamed from: O */
    private View.OnClickListener f13160O = new ViewOnClickListenerC3612h(this);

    /* renamed from: P */
    private View.OnClickListener f13161P = new ViewOnClickListenerC3613i(this);

    /* renamed from: Q */
    private Handler f13162Q = new HandlerC3614j(this);

    /* JADX WARN: Removed duplicated region for block: B:95:0x0248 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.sec.vip.cropimage.MonitoredActivity, com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 643
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.CropImage.onCreate(android.os.Bundle):void");
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (GlobalApplication.m6456e()) {
            Resources resources = CommonApplication.m11493l().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ams_layout_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ams_layout_height);
            if (resources.getConfiguration().orientation == 1) {
                dimensionPixelSize = -1;
            }
            getWindow().setLayout(dimensionPixelSize, dimensionPixelSize2);
        }
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cancel_done_menu, menu);
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.chaton.base.BaseActivity, com.sec.common.actionbar.ActionBarFragmentActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) throws Throwable {
        View childAt;
        boolean z = true;
        if (menuItem.getItemId() == R.id.menu_cancel || menuItem.getItemId() == 16908332) {
            if (this.f13150E) {
                this.f13150E = false;
                setTitle(this.f13149D);
                m12874a(false);
                if (this.f13179r != null) {
                    int childCount = this.f13179r.getChildCount();
                    int i = 0;
                    while (true) {
                        if (i >= childCount) {
                            childAt = null;
                            break;
                        }
                        childAt = this.f13179r.getChildAt(i);
                        if (childAt.getId() == this.f13153H) {
                            break;
                        }
                        i++;
                    }
                    if (childAt != null) {
                        this.f13183v = this.f13153H;
                        new AsyncTaskC3615k(this, childAt, this.f13176o).execute(new String[0]);
                    }
                }
            } else {
                setResult(0);
                finish();
            }
        } else if (menuItem.getItemId() != R.id.menu_done) {
            z = false;
        } else if (this.f13150E) {
            this.f13150E = false;
            setTitle(this.f13149D);
            m12874a(false);
        } else {
            m12893d();
        }
        if (!z) {
            return super.onSupportOptionsItemSelected(menuItem);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12874a(boolean z) {
        if (this.f13178q != null) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ams_ics_effect_filter_layout_height));
                layoutParams.addRule(12);
                findViewById(R.id.layout_bottom).setLayoutParams(layoutParams);
                this.f13178q.setVisibility(0);
                findViewById(R.id.layout_buttons).setVisibility(8);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ams_ics_crop_image_button_layout_height));
            layoutParams2.addRule(12);
            findViewById(R.id.layout_bottom).setLayoutParams(layoutParams2);
            findViewById(R.id.layout_buttons).setVisibility(0);
            this.f13178q.setVisibility(8);
        }
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity, com.sec.chaton.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        m12907j();
        super.onDestroy();
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: a */
    public int mo12916a() {
        return this.f13156K;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: b */
    public int mo12917b() {
        return this.f13157L;
    }

    @Override // com.sec.vip.cropimage.MonitoredActivity
    /* renamed from: c */
    public float mo12918c() {
        return this.f13180s;
    }

    /* renamed from: a */
    private int m12864a(int i) {
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
    private String m12869a(Uri uri) throws IllegalArgumentException {
        Cursor cursorLoadInBackground;
        String[] strArr = {"_data"};
        if (Build.VERSION.SDK_INT < 11) {
            cursorLoadInBackground = managedQuery(uri, strArr, null, null, null);
        } else {
            cursorLoadInBackground = new CursorLoader(this, uri, strArr, null, null, null).loadInBackground();
        }
        if (cursorLoadInBackground == null) {
            C3250y.m11455d("[getRealPathFromURI] cursor is null! - Camera", getClass().getSimpleName());
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
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.InputStream] */
    /* renamed from: b */
    private int m12877b(android.net.Uri r6) {
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
            r2.close()     // Catch: java.io.IOException -> L7b
        L38:
            throw r0
        L39:
            if (r2 == 0) goto L3e
            r2.close()     // Catch: java.io.IOException -> L7d
        L3e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "options width height : "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r2 = ", "
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Class r2 = r5.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C3250y.m11450b(r0, r2)
            int r0 = r3 * r1
            float r1 = (float) r0
            r0 = 1234567168(0x49960000, float:1228800.0)
            float r0 = r1 / r0
            r2 = 1056964608(0x3f000000, float:0.5)
            float r0 = r0 + r2
            int r0 = (int) r0
            r2 = 1236736768(0x49b71b00, float:1500000.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L25
            int r0 = r0 + 1
            goto L25
        L7b:
            r1 = move-exception
            goto L38
        L7d:
            r0 = move-exception
            goto L3e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.CropImage.m12877b(android.net.Uri):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12884b(boolean z) {
        if (!isFinishing()) {
            this.f13165c.setImageBitmapResetBase(this.f13176o, (int) this.f13180s, false);
            m12872a(this, z, (String) null, getResources().getString(R.string.ams_msg_runningImageCrop), new RunnableC3608d(this), this.f13168g);
        }
    }

    /* renamed from: a */
    private static void m12872a(MonitoredActivity monitoredActivity, boolean z, String str, String str2, Runnable runnable, Handler handler) {
        ProgressDialog progressDialogM11491a = null;
        if (z) {
            progressDialogM11491a = ProgressDialogC3265l.m11491a(monitoredActivity, str, str2, true, false);
        }
        new Thread(new RunnableC3616l(monitoredActivity, runnable, progressDialogM11491a, handler)).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0277  */
    /* JADX WARN: Type inference failed for: r15v0, types: [com.sec.vip.cropimage.CropImage, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v22, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m12893d() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.cropimage.CropImage.m12893d():void");
    }

    /* renamed from: a */
    private void m12873a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m12883b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12896e() {
        this.f13180s += 270.0f;
        this.f13180s %= 360.0f;
        if (this.f13180s == 360.0f) {
            this.f13180s = 0.0f;
        }
        m12884b(false);
    }

    /* renamed from: b */
    private void m12881b(int i) {
        this.f13180s = i;
        this.f13181t = i;
    }

    /* renamed from: f */
    private void m12898f() {
        this.f13186y = (ImageView) findViewById(R.id.iv_template_rect);
        this.f13187z = (ImageView) findViewById(R.id.iv_template_circle);
        this.f13146A = (ImageView) findViewById(R.id.iv_template_roundrect);
        this.f13147B = (ImageView) findViewById(R.id.iv_template_heart);
        this.f13148C = (ImageView) findViewById(R.id.iv_template_star);
        this.f13186y.setOnClickListener(this.f13160O);
        this.f13187z.setOnClickListener(this.f13160O);
        this.f13146A.setOnClickListener(this.f13160O);
        this.f13147B.setOnClickListener(this.f13160O);
        this.f13148C.setOnClickListener(this.f13160O);
        m12887c(this.f13182u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12887c(int i) {
        int[] iArr = {1000, 1002, 1001, 1004, 1003};
        ImageView[] imageViewArr = {this.f13186y, this.f13187z, this.f13146A, this.f13147B, this.f13148C};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            imageViewArr[i2].setSelected(iArr[i2] == i);
        }
    }

    /* renamed from: a */
    private static Bitmap m12866a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z, boolean z2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m12901g() throws Resources.NotFoundException {
        if (this.f13179r != null && this.f13177p != null) {
            m12875a(this.f13179r, this.f13177p, this.f13176o);
        }
    }

    /* renamed from: a */
    private void m12870a(Bitmap bitmap, int i) {
        Bitmap bitmapDecodeResource;
        if (this.f13175n) {
            if (i == 2006 || i == 2007) {
                Canvas canvas = new Canvas(bitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                switch (i) {
                    case 2006:
                        bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.template_polaroid);
                        break;
                    case 2007:
                        bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.template_vignetting);
                        break;
                    default:
                        bitmapDecodeResource = null;
                        break;
                }
                if (bitmapDecodeResource != null) {
                    canvas.drawBitmap(bitmapDecodeResource, (Rect) null, new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight()), paint);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m12875a(LinearLayout linearLayout, int[] iArr, Bitmap bitmap) throws Resources.NotFoundException {
        Bitmap bitmap2;
        Bitmap bitmap3;
        float height;
        try {
            float width = bitmap.getWidth();
            float height2 = bitmap.getHeight();
            if (width > height2) {
                height = 100.0f / bitmap.getWidth();
            } else {
                height = 100.0f / bitmap.getHeight();
            }
            float f = width * height;
            float f2 = height2 * height;
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, (int) (0.5f + f), (int) (0.5f + f2), true);
            int i = 0;
            int i2 = 0;
            if (f > f2) {
                i = (int) ((f - f2) * 0.5f);
                f = f2;
            } else {
                i2 = (int) ((f2 - f) * 0.5f);
                f2 = f;
            }
            try {
                Matrix matrix = new Matrix();
                matrix.postRotate(this.f13180s);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap, i, i2, (int) (f2 + 0.5f), (int) (f + 0.5f), matrix, true);
                if (bitmapCreateScaledBitmap != null) {
                    try {
                        if (!bitmapCreateScaledBitmap.isRecycled() && bitmapCreateScaledBitmap != bitmap) {
                            bitmapCreateScaledBitmap.recycle();
                        }
                    } catch (OutOfMemoryError e) {
                        bitmap2 = bitmapCreateScaledBitmap;
                        bitmap3 = bitmapCreateBitmap;
                        C3641ai.m13210a(this, R.string.chat_view_memory_error, 0).show();
                        if (bitmap3 != null && !bitmap3.isRecycled() && bitmap2 != null && bitmap3 != bitmap2) {
                            bitmap3.recycle();
                        }
                        return false;
                    }
                }
                if (bitmapCreateBitmap == null) {
                    return false;
                }
                if (this.f13151F != null) {
                    this.f13151F.clear();
                    this.f13151F = null;
                }
                this.f13151F = new ArrayList<>();
                String[] stringArray = getResources().getStringArray(R.array.ams_strarr_effect_image);
                for (int i3 : iArr) {
                    int i4 = i3 - 2000;
                    if (i4 < 0 || i4 >= stringArray.length) {
                        if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled() && bitmapCreateScaledBitmap != null && bitmapCreateBitmap != bitmapCreateScaledBitmap) {
                            bitmapCreateBitmap.recycle();
                        }
                        return false;
                    }
                    this.f13151F.add(new C3618n(this, i3, stringArray[i4]));
                }
                LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
                Iterator<C3618n> it = this.f13151F.iterator();
                while (it.hasNext()) {
                    C3618n next = it.next();
                    View viewInflate = layoutInflater.inflate(R.layout.ams_ics_layout_image_filter_item, (ViewGroup) linearLayout, false);
                    ImageView imageView = (ImageView) viewInflate.findViewById(R.id.image_filter_effect);
                    TextView textView = (TextView) viewInflate.findViewById(R.id.text_filter_name);
                    viewInflate.setId(next.f13298c);
                    viewInflate.setOnClickListener(this.f13161P);
                    textView.setText(next.f13299d);
                    Bitmap bitmapCopy = bitmapCreateBitmap.copy(Bitmap.Config.ARGB_8888, true);
                    int i5 = next.f13298c;
                    if (i5 == 2006 || i5 == 2007) {
                        m12870a(bitmapCopy, i5);
                    } else if (!C3631a.m13027a(bitmapCopy, i5)) {
                        C3641ai.m13210a(this, R.string.chat_view_memory_error, 0).show();
                        if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled() && bitmapCreateScaledBitmap != null && bitmapCreateBitmap != bitmapCreateScaledBitmap) {
                            bitmapCreateBitmap.recycle();
                        }
                        return false;
                    }
                    if (bitmapCopy != null) {
                        imageView.setImageBitmap(bitmapCopy);
                    }
                    next.f13296a = imageView;
                    next.f13297b = textView;
                    linearLayout.addView(viewInflate);
                }
                if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled() && bitmapCreateScaledBitmap != null && bitmapCreateBitmap != bitmapCreateScaledBitmap) {
                    bitmapCreateBitmap.recycle();
                }
                return true;
            } catch (OutOfMemoryError e2) {
                bitmap2 = bitmapCreateScaledBitmap;
                bitmap3 = null;
            }
        } catch (OutOfMemoryError e3) {
            bitmap2 = null;
            bitmap3 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m12903h() {
        if (this.f13151F == null) {
            return false;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(this.f13180s - this.f13181t);
        this.f13181t = this.f13180s;
        Iterator<C3618n> it = this.f13151F.iterator();
        while (it.hasNext()) {
            C3618n next = it.next();
            Bitmap bitmap = ((BitmapDrawable) next.f13296a.getDrawable()).getBitmap();
            if (bitmap == null) {
                return false;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            next.f13296a.setImageBitmap(bitmapCreateBitmap);
            if (bitmapCreateBitmap != bitmap) {
                bitmap.recycle();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized Bitmap m12879b(Bitmap bitmap, int i) {
        Bitmap bitmap2 = null;
        synchronized (this) {
            try {
                Bitmap bitmapCopy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                if (C3631a.m13027a(bitmapCopy, i)) {
                    bitmap2 = bitmapCopy;
                } else {
                    this.f13162Q.sendEmptyMessage(R.string.chat_view_memory_error);
                }
            } catch (OutOfMemoryError e) {
                this.f13162Q.sendEmptyMessage(R.string.chat_view_memory_error);
            }
        }
        return bitmap2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m12905i() {
        Iterator<C3618n> it = this.f13151F.iterator();
        while (it.hasNext()) {
            C3618n next = it.next();
            next.f13296a.setSelected(false);
            next.f13297b.setSelected(false);
        }
    }

    /* renamed from: j */
    private void m12907j() {
        if (this.f13176o != null && !this.f13176o.isRecycled()) {
            this.f13176o.recycle();
        }
        if (this.f13184w != null && !this.f13184w.isRecycled()) {
            this.f13184w.recycle();
        }
        if (this.f13185x != null && !this.f13185x.isRecycled()) {
            this.f13185x.recycle();
        }
        if (this.f13151F != null) {
            Iterator<C3618n> it = this.f13151F.iterator();
            while (it.hasNext()) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) it.next().f13296a.getDrawable();
                if (bitmapDrawable != null && !bitmapDrawable.getBitmap().isRecycled()) {
                    bitmapDrawable.getBitmap().recycle();
                }
            }
        }
    }
}
