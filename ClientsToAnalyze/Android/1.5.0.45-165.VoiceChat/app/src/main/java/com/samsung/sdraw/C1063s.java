package com.samsung.sdraw;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* renamed from: com.samsung.sdraw.s */
/* loaded from: classes.dex */
class C1063s extends AbstractSprite {

    /* renamed from: d */
    private RectF f1768d;

    /* renamed from: e */
    private AbstractModeContext f1769e;

    /* renamed from: f */
    private int f1770f;

    /* renamed from: g */
    private int f1771g;

    /* renamed from: h */
    private int f1772h;

    /* renamed from: j */
    private Rect f1774j;

    /* renamed from: k */
    private PointF f1775k;

    /* renamed from: l */
    private boolean f1776l;

    /* renamed from: i */
    private String f1773i = null;

    /* renamed from: m */
    private FillColorInfo f1777m = null;

    C1063s() {
    }

    @Override // com.samsung.sdraw.InterfaceC1008au
    /* renamed from: a */
    public RectF mo1136a() {
        this.f831b.set(this.f1768d);
        return this.f831b;
    }

    /* renamed from: a */
    public Bitmap m1592a(Bitmap bitmap) {
        boolean z;
        boolean z2;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Rect rect = new Rect(width, height, 0, 0);
            int[] iArr = new int[width * height];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int i = 0;
            boolean z3 = false;
            boolean z4 = false;
            while (i < height) {
                int i2 = 0;
                boolean z5 = z3;
                boolean z6 = false;
                while (i2 < width) {
                    if (iArr[(i * width) + i2] != 0) {
                        z2 = true;
                        z = true;
                    } else {
                        z = z6;
                        z2 = false;
                    }
                    if (z2 && !z5) {
                        rect.left = Math.min(rect.left, i2);
                    } else if (!z2 && z5) {
                        rect.right = Math.max(rect.right, i2);
                    }
                    i2++;
                    z5 = z2;
                    z6 = z;
                }
                if (z6 && !z4) {
                    rect.top = Math.min(rect.top, i);
                } else if (!z6 && z4) {
                    rect.bottom = Math.max(rect.bottom, i);
                }
                i++;
                z4 = z6;
                z3 = z5;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
            if (rect.width() <= 0 || rect.height() <= 0) {
                return bitmapCreateBitmap;
            }
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, rect.left, rect.top, rect.width(), rect.height());
            bitmapCreateBitmap.recycle();
            return bitmapCreateBitmap2;
        }
        return null;
    }

    @Override // com.samsung.sdraw.InterfaceC1008au
    /* renamed from: a */
    public void mo1139a(Canvas canvas, RectF rectF) {
        Bitmap bitmapM1589e = m1589e();
        if (bitmapM1589e != null) {
            Bitmap bitmapM1592a = m1592a(bitmapM1589e);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapM1592a, (int) this.f1768d.width(), (int) this.f1768d.height(), false);
            if (!bitmapCreateScaledBitmap.isRecycled()) {
                canvas.drawBitmap(bitmapCreateScaledBitmap, this.f1768d.left, this.f1768d.top, new Paint());
            }
            if (!bitmapM1592a.isRecycled()) {
                bitmapM1592a.recycle();
            }
            if (!bitmapM1589e.isRecycled()) {
                bitmapM1589e.recycle();
            }
            if (!bitmapCreateScaledBitmap.isRecycled()) {
                bitmapCreateScaledBitmap.recycle();
                return;
            }
            return;
        }
        m1591g();
        Bitmap bitmapM1589e2 = m1589e();
        if (bitmapM1589e2 != null) {
            Bitmap bitmapM1592a2 = m1592a(bitmapM1589e2);
            Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapM1592a2, (int) this.f1768d.width(), (int) this.f1768d.height(), false);
            if (!bitmapCreateScaledBitmap2.isRecycled()) {
                canvas.drawBitmap(bitmapCreateScaledBitmap2, this.f1768d.left, this.f1768d.top, new Paint());
            }
            if (!bitmapM1592a2.isRecycled()) {
                bitmapM1592a2.recycle();
            }
            if (!bitmapM1589e2.isRecycled()) {
                bitmapM1589e2.recycle();
            }
            if (!bitmapCreateScaledBitmap2.isRecycled()) {
                bitmapCreateScaledBitmap2.recycle();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.graphics.RectF] */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.graphics.Rect] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.FileInputStream] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap m1589e() throws java.lang.Throwable {
        /*
            r3 = this;
            r0 = 0
            android.graphics.RectF r1 = r3.getBounds()
            android.graphics.Rect r2 = new android.graphics.Rect
            r2.<init>()
            r1.roundOut(r2)
            java.lang.String r1 = r3.f1773i     // Catch: java.io.FileNotFoundException -> L22 java.lang.Throwable -> L32
            if (r1 == 0) goto L49
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.io.FileNotFoundException -> L22 java.lang.Throwable -> L32
            java.lang.String r1 = r3.f1773i     // Catch: java.io.FileNotFoundException -> L22 java.lang.Throwable -> L32
            r2.<init>(r1)     // Catch: java.io.FileNotFoundException -> L22 java.lang.Throwable -> L32
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch: java.lang.Throwable -> L45 java.io.FileNotFoundException -> L47
        L1c:
            if (r2 == 0) goto L21
            r2.close()     // Catch: java.io.IOException -> L40
        L21:
            return r0
        L22:
            r1 = move-exception
            r2 = r0
        L24:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L21
            r2.close()     // Catch: java.io.IOException -> L2d
            goto L21
        L2d:
            r1 = move-exception
            r1.printStackTrace()
            goto L21
        L32:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L35:
            if (r2 == 0) goto L3a
            r2.close()     // Catch: java.io.IOException -> L3b
        L3a:
            throw r0
        L3b:
            r1 = move-exception
            r1.printStackTrace()
            goto L3a
        L40:
            r1 = move-exception
            r1.printStackTrace()
            goto L21
        L45:
            r0 = move-exception
            goto L35
        L47:
            r1 = move-exception
            goto L24
        L49:
            r2 = r0
            goto L1c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.sdraw.C1063s.m1589e():android.graphics.Bitmap");
    }

    /* renamed from: f */
    private Bitmap m1590f() {
        return null;
    }

    @Override // com.samsung.sdraw.AbstractSprite
    public void dispose() {
        m1596c();
    }

    @Override // com.samsung.sdraw.AbstractSprite
    public StringBuilder toXML() throws Throwable {
        StringBuilder sb = new StringBuilder("");
        byte[] bArrM1595b = m1595b();
        for (int i = 0; i < bArrM1595b.length; i++) {
            sb.append(String.valueOf((int) bArrM1595b[i]));
            if (i != bArrM1595b.length - 1) {
                sb.append(" ,");
            }
        }
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(this.f1770f);
        objArr[1] = Integer.valueOf(this.f1771g);
        objArr[2] = Integer.valueOf(this.f1772h);
        objArr[3] = Integer.valueOf(this.f830a ? 1 : 0);
        objArr[4] = Integer.valueOf(this.f832c ? 1 : 0);
        objArr[5] = Integer.valueOf(getLayerID());
        return new StringBuilder(String.format("<fillcolor x=\"%d\" y=\"%d\" spriteColor=\"%d\" visible=\"%d\" fixed=\"%d\" layerID=\"%d\"/>\n", objArr));
    }

    /* renamed from: g */
    private void m1591g() throws Throwable {
        Bitmap bitmapM1590f = m1590f();
        if (bitmapM1590f != null) {
            this.f1768d.left = Math.max(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1768d.left);
            this.f1768d.top = Math.max(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, this.f1768d.top);
            this.f1768d.right = Math.min(bitmapM1590f.getWidth(), this.f1768d.right);
            this.f1768d.bottom = Math.min(bitmapM1590f.getHeight(), this.f1768d.bottom);
            if (this.f1768d.width() <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                this.f1768d.right = this.f1768d.left + 1.0f;
            }
            if (this.f1768d.height() <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                this.f1768d.bottom = this.f1768d.top + 1.0f;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapM1590f, (int) this.f1768d.left, (int) this.f1768d.top, (int) this.f1768d.width(), (int) this.f1768d.height());
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    String strM1116g = this.f1769e.setting.m1116g();
                    if (strM1116g != null) {
                        File file = new File(strM1116g);
                        if (!file.mkdirs()) {
                            C0993af.m1275a("SPen", "cache file delete failed");
                        }
                        File fileCreateTempFile = File.createTempFile("fillColorCache", ".png", file);
                        if (fileCreateTempFile != null) {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(fileCreateTempFile);
                            try {
                                bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                                this.f1773i = fileCreateTempFile.getAbsolutePath();
                                fileOutputStream = fileOutputStream2;
                            } catch (IOException e) {
                                e = e;
                                fileOutputStream = fileOutputStream2;
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                                if (!bitmapM1590f.isRecycled()) {
                                    bitmapM1590f.recycle();
                                }
                                if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
                                    bitmapCreateBitmap.recycle();
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                                if (!bitmapM1590f.isRecycled()) {
                                    bitmapM1590f.recycle();
                                }
                                if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
                                    bitmapCreateBitmap.recycle();
                                }
                                throw th;
                            }
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (!bitmapM1590f.isRecycled()) {
                        bitmapM1590f.recycle();
                    }
                    if (bitmapCreateBitmap != null && !bitmapCreateBitmap.isRecycled()) {
                        bitmapCreateBitmap.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e5) {
                e = e5;
            }
        }
    }

    /* renamed from: a */
    public void m1593a(AbstractModeContext abstractModeContext, int i, int i2, int i3, RectF rectF, String str, int i4) {
        this.f1770f = i;
        this.f1771g = i2;
        this.f1772h = i3;
        this.f1769e = abstractModeContext;
        this.f1773i = str;
        if (this.f1770f < 0) {
            this.f1770f = 0;
        } else if (this.f1770f >= this.f1769e.setting.f1277n.width()) {
            this.f1770f = this.f1769e.setting.f1277n.width() - 1;
        }
        if (this.f1771g < 0) {
            this.f1771g = 0;
        } else if (this.f1771g >= this.f1769e.setting.f1277n.height()) {
            this.f1771g = this.f1769e.setting.f1277n.height() - 1;
        }
        this.f1774j = this.f1769e.setting.f1277n;
        this.f1775k = this.f1769e.stage.mapToScene(new PointF(i, i2));
        setLayerID(i4);
        if (rectF == null) {
            this.f1768d = new RectF(this.f1769e.setting.f1277n);
        } else {
            this.f1768d = rectF;
        }
        this.f1768d.intersect(new RectF(this.f1774j));
        if (this.f1773i == null) {
            m1591g();
        }
        mo1136a();
    }

    @Override // com.samsung.sdraw.AbstractSprite, com.samsung.sdraw.InterfaceC1070z
    public boolean isHitted(PointF point) {
        return false;
    }

    /* renamed from: b */
    public byte[] m1595b() throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Bitmap bitmapM1589e = m1589e();
        if (bitmapM1589e != null) {
            try {
                if (!bitmapM1589e.isRecycled()) {
                    bitmapM1589e.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byteArrayOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (bitmapM1589e != null) {
            bitmapM1589e.recycle();
        }
        return byteArray;
    }

    /* renamed from: a */
    void m1594a(boolean z) {
        setVisible(!z);
        this.f1776l = z;
    }

    /* renamed from: c */
    protected void m1596c() {
        if (this.f1773i != null) {
            File file = new File(this.f1773i);
            if (file.exists()) {
                try {
                    file.delete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f1773i = null;
            }
        }
    }

    /* renamed from: d */
    public FillColorInfo m1597d() {
        this.f1777m = new FillColorInfo(getLayerID(), this.f1772h, (int) this.f1775k.x, (int) this.f1775k.y, this.f1768d, this.f1773i);
        this.f1777m.setID(this.objectID);
        this.f1777m.setMultiObjectID(this.multiObjectID);
        this.f1777m.setMultiUserID(this.multiUserID);
        return this.f1777m;
    }
}
