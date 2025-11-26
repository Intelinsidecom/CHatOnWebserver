package com.samsung.spen.p005a.p009d;

import android.graphics.PointF;
import android.graphics.RectF;
import android.text.Layout;
import android.util.Log;
import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectFilling;
import com.samsung.samm.common.SObjectImage;
import com.samsung.samm.common.SObjectStroke;
import com.samsung.samm.common.SObjectText;
import com.samsung.sdraw.FillColorInfo;
import com.samsung.sdraw.ImageInfo;
import com.samsung.sdraw.ObjectInfo;
import com.samsung.sdraw.PenSettingInfo;
import com.samsung.sdraw.StrokeInfo;
import com.samsung.sdraw.TextInfo;
import com.samsung.spen.settings.SettingStrokeInfo;

/* renamed from: com.samsung.spen.a.d.a */
/* loaded from: classes.dex */
public class C1083a {

    /* renamed from: a */
    private static int[] f1894a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 1, 5};

    /* renamed from: b */
    private static int[] f1895b = {0, 10, 11, 0, 12, 14};

    /* renamed from: c */
    private static int[] f1896c = {0, 1, 2, 3, 4};

    /* renamed from: d */
    private static int[] f1897d = {0, 1, 2, 3, 4};

    /* renamed from: e */
    private static int[] f1898e = {0, 1, 2};

    /* renamed from: f */
    private static int[] f1899f = {0, 1, 2};

    /* renamed from: g */
    private static int[] f1900g = {0, 2, 3, 0, 4, 0, 1, 5};

    /* renamed from: h */
    private static int[] f1901h = {0, 6, 1, 2, 4, 7};

    /* renamed from: i */
    private static int[] f1902i = {0, 1, 2};

    /* renamed from: j */
    private static int[] f1903j = {0, 1, 2};

    /* renamed from: a */
    public static SObject m1804a(ObjectInfo objectInfo) {
        if (objectInfo == null) {
            return null;
        }
        if (objectInfo instanceof StrokeInfo) {
            SObjectStroke sObjectStroke = new SObjectStroke();
            if (m1811a((StrokeInfo) objectInfo, sObjectStroke)) {
                return sObjectStroke;
            }
            return null;
        }
        if (objectInfo instanceof ImageInfo) {
            SObjectImage sObjectImage = new SObjectImage();
            if (m1809a((ImageInfo) objectInfo, sObjectImage)) {
                return sObjectImage;
            }
            return null;
        }
        if (objectInfo instanceof TextInfo) {
            SObjectText sObjectText = new SObjectText();
            if (m1812a((TextInfo) objectInfo, sObjectText)) {
                return sObjectText;
            }
            return null;
        }
        if (objectInfo instanceof FillColorInfo) {
            SObjectFilling sObjectFilling = new SObjectFilling();
            if (m1808a((FillColorInfo) objectInfo, sObjectFilling)) {
                return sObjectFilling;
            }
            return null;
        }
        Log.e("CanvasViewConverter", "Undefined Object");
        return null;
    }

    /* renamed from: a */
    public static boolean m1810a(ObjectInfo objectInfo, SObject sObject) {
        if (objectInfo == null || sObject == null) {
            return false;
        }
        if ((objectInfo instanceof StrokeInfo) && (sObject instanceof SObjectStroke)) {
            return m1811a((StrokeInfo) objectInfo, (SObjectStroke) sObject);
        }
        if (objectInfo instanceof ImageInfo) {
            return m1809a((ImageInfo) objectInfo, (SObjectImage) sObject);
        }
        if (objectInfo instanceof TextInfo) {
            return m1812a((TextInfo) objectInfo, (SObjectText) sObject);
        }
        if (objectInfo instanceof FillColorInfo) {
            return m1808a((FillColorInfo) objectInfo, (SObjectFilling) sObject);
        }
        Log.e("CanvasViewConverter", "Undefined Object");
        return false;
    }

    /* renamed from: a */
    static boolean m1811a(StrokeInfo strokeInfo, SObjectStroke sObjectStroke) {
        sObjectStroke.setColor((strokeInfo.alpha << 24) | strokeInfo.color);
        sObjectStroke.setStyle(m1818g(strokeInfo.type));
        sObjectStroke.setSize(strokeInfo.width);
        sObjectStroke.setLayer(strokeInfo.getLayerID());
        sObjectStroke.setPoints(strokeInfo.points);
        sObjectStroke.setPressures(strokeInfo.pressure);
        sObjectStroke.setMetaData(m1821j(strokeInfo.meta_state));
        return true;
    }

    /* renamed from: a */
    static boolean m1809a(ImageInfo imageInfo, SObjectImage sObjectImage) {
        sObjectImage.setRect(imageInfo.rectf);
        sObjectImage.setLayer(imageInfo.getLayerID());
        sObjectImage.setRotateAngle(imageInfo.getAngle());
        sObjectImage.setImageBitmap(imageInfo.getImg());
        return true;
    }

    /* renamed from: a */
    static boolean m1812a(TextInfo textInfo, SObjectText sObjectText) {
        sObjectText.setSize(textInfo.size);
        sObjectText.setColor(textInfo.color);
        sObjectText.setLayer(textInfo.getLayerID());
        sObjectText.setRect(textInfo.rectf);
        sObjectText.setText(textInfo.text);
        int iM1803a = m1803a(textInfo.alignment);
        sObjectText.setTextAlign(iM1803a, iM1803a);
        sObjectText.setStyle(m1823l(textInfo.textStyle));
        String str = textInfo.textFont;
        if (str != null) {
            sObjectText.setFontName(str);
            return true;
        }
        return true;
    }

    /* renamed from: a */
    static boolean m1808a(FillColorInfo fillColorInfo, SObjectFilling sObjectFilling) {
        sObjectFilling.setColor(fillColorInfo.color);
        sObjectFilling.setFillPoint(new PointF(fillColorInfo.f1045x, fillColorInfo.f1046y));
        if (fillColorInfo.fillingBound != null) {
            sObjectFilling.setRect(new RectF(fillColorInfo.fillingBound.left, fillColorInfo.fillingBound.top, fillColorInfo.fillingBound.right, fillColorInfo.fillingBound.bottom));
            return true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00e0  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.samsung.sdraw.ObjectInfo m1805a(com.samsung.samm.common.SObject r9, int r10) {
        /*
            r4 = 1118961664(0x42b20000, float:89.0)
            r3 = 1116733440(0x42900000, float:72.0)
            r2 = 1065353216(0x3f800000, float:1.0)
            r8 = 0
            r0 = -1
            if (r10 != r0) goto Lb
        La:
            return r8
        Lb:
            boolean r0 = r9 instanceof com.samsung.samm.common.SObjectStroke
            if (r0 == 0) goto L58
            r0 = r9
            com.samsung.samm.common.SObjectStroke r0 = (com.samsung.samm.common.SObjectStroke) r0
            int r1 = r0.getStyle()
            int r1 = m1817f(r1)
            float r5 = r0.getSize()
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 >= 0) goto Le3
        L22:
            r5 = 4
            if (r1 != r5) goto L52
            int r3 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r3 <= 0) goto Le0
        L29:
            int r2 = r0.getColor()
            int r3 = r2 >> 24
            r3 = r3 & 255(0xff, float:3.57E-43)
            android.graphics.PointF[] r6 = r0.getPoints()
            float[] r5 = r0.getPressures()
            int r0 = r0.getMetaData()
            int r7 = m1820i(r0)
            com.samsung.sdraw.StrokeInfo r0 = new com.samsung.sdraw.StrokeInfo
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0.setID(r10)
            int r1 = r9.getLayer()
            r0.setLayerID(r1)
            r8 = r0
            goto La
        L52:
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 <= 0) goto Le0
            r4 = r3
            goto L29
        L58:
            boolean r0 = r9 instanceof com.samsung.samm.common.SObjectImage
            if (r0 == 0) goto L7b
            r0 = r9
            com.samsung.samm.common.SObjectImage r0 = (com.samsung.samm.common.SObjectImage) r0
            com.samsung.sdraw.ImageInfo r8 = new com.samsung.sdraw.ImageInfo
            android.graphics.Bitmap r1 = r0.getImageBitmap()
            android.graphics.RectF r2 = r0.getRect()
            float r0 = r0.getRotateAngle()
            r8.<init>(r1, r2, r0)
            r8.setID(r10)
            int r0 = r9.getLayer()
            r8.setLayerID(r0)
            goto La
        L7b:
            boolean r0 = r9 instanceof com.samsung.samm.common.SObjectText
            if (r0 == 0) goto Lb9
            r3 = r9
            com.samsung.samm.common.SObjectText r3 = (com.samsung.samm.common.SObjectText) r3
            android.graphics.RectF r4 = r3.getRect()
            int r0 = r3.getHorizTextAlign()
            android.text.Layout$Alignment r6 = m1819h(r0)
            int r0 = r3.getStyle()
            int r5 = m1822k(r0)
            java.lang.String r7 = r3.getFontName()
            com.samsung.sdraw.TextInfo r0 = new com.samsung.sdraw.TextInfo
            int r1 = r3.getColor()
            float r2 = r3.getSize()
            int r2 = (int) r2
            java.lang.String r3 = r3.getText()
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0.setID(r10)
            int r1 = r9.getLayer()
            r0.setLayerID(r1)
            r8 = r0
            goto La
        Lb9:
            boolean r0 = r9 instanceof com.samsung.samm.common.SObjectFilling
            if (r0 == 0) goto Ld7
            com.samsung.samm.common.SObjectFilling r9 = (com.samsung.samm.common.SObjectFilling) r9
            int r0 = r9.getColor()
            android.graphics.PointF r1 = r9.getFillPoint()
            com.samsung.sdraw.FillColorInfo r8 = new com.samsung.sdraw.FillColorInfo
            float r2 = r1.x
            int r2 = (int) r2
            float r1 = r1.y
            int r1 = (int) r1
            r8.<init>(r0, r2, r1)
            r8.setID(r10)
            goto La
        Ld7:
            java.lang.String r0 = "CanvasViewConverter"
            java.lang.String r1 = "I don't know How to draw object : Unknown SAMM Object"
            android.util.Log.w(r0, r1)
            goto La
        Le0:
            r4 = r2
            goto L29
        Le3:
            r2 = r5
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.spen.p005a.p009d.C1083a.m1805a(com.samsung.samm.common.SObject, int):com.samsung.sdraw.ObjectInfo");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00fd  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.samsung.sdraw.ObjectInfo m1806a(com.samsung.samm.common.SObject r9, int r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.spen.p005a.p009d.C1083a.m1806a(com.samsung.samm.common.SObject, int, int, int):com.samsung.sdraw.ObjectInfo");
    }

    /* renamed from: a */
    public static int m1802a(int i) {
        if (i < 0 || i > 14) {
            return 1;
        }
        return f1894a[i];
    }

    /* renamed from: b */
    public static int m1813b(int i) {
        if (i < 1 || i > 5) {
            return 0;
        }
        return f1895b[i];
    }

    /* renamed from: c */
    public static int m1814c(int i) {
        if (i < 1 || i > 4) {
            return 0;
        }
        return f1896c[i];
    }

    /* renamed from: d */
    public static int m1815d(int i) {
        if (i < 0 || i > 2) {
            return 0;
        }
        return f1898e[i];
    }

    /* renamed from: e */
    public static int m1816e(int i) {
        if (i < 0 || i > 2) {
            return 0;
        }
        return f1897d[i];
    }

    /* renamed from: f */
    public static int m1817f(int i) {
        if (i < 0 || i >= 100) {
            return i == 100 ? 1 : 0;
        }
        if (i <= 7) {
            return f1900g[i];
        }
        return 0;
    }

    /* renamed from: g */
    public static int m1818g(int i) {
        if (i < 0 || i > 5) {
            return 0;
        }
        return f1901h[i];
    }

    /* renamed from: h */
    public static Layout.Alignment m1819h(int i) {
        return i == 0 ? Layout.Alignment.ALIGN_NORMAL : i == 1 ? Layout.Alignment.ALIGN_CENTER : i == 2 ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_OPPOSITE;
    }

    /* renamed from: a */
    public static int m1803a(Layout.Alignment alignment) {
        if (alignment == Layout.Alignment.ALIGN_NORMAL) {
            return 0;
        }
        if (alignment == Layout.Alignment.ALIGN_CENTER) {
            return 1;
        }
        return alignment == Layout.Alignment.ALIGN_OPPOSITE ? 2 : 0;
    }

    /* renamed from: i */
    public static int m1820i(int i) {
        if (i < 0 || i > 2) {
            return 1;
        }
        return f1902i[i];
    }

    /* renamed from: j */
    public static int m1821j(int i) {
        if (i < 0 || i > 2) {
            return 1;
        }
        return f1903j[i];
    }

    /* renamed from: k */
    public static int m1822k(int i) {
        int i2 = 0;
        if ((i & 1) != 0) {
            i2 = 1;
        }
        if ((i & 2) != 0) {
            i2 |= 2;
        }
        if ((i & 4) != 0) {
            return i2 | 4;
        }
        return i2;
    }

    /* renamed from: l */
    public static int m1823l(int i) {
        int i2 = 0;
        if ((i & 1) != 0) {
            i2 = 1;
        }
        if ((i & 2) != 0) {
            i2 |= 2;
        }
        if ((i & 4) != 0) {
            return i2 | 4;
        }
        return i2;
    }

    /* renamed from: a */
    public static SettingStrokeInfo m1807a(PenSettingInfo penSettingInfo) {
        if (penSettingInfo == null) {
            return null;
        }
        int penType = penSettingInfo.getPenType();
        int penAlpha = (penSettingInfo.getPenAlpha() << 24) | (penSettingInfo.getPenColor() & 16777215);
        int eraserWidth = penType == 4 ? penSettingInfo.getEraserWidth() : penSettingInfo.getPenWidth();
        int iM1818g = m1818g(penType);
        SettingStrokeInfo settingStrokeInfo = new SettingStrokeInfo();
        settingStrokeInfo.setStrokeStyle(iM1818g);
        settingStrokeInfo.setStrokeColor(penAlpha);
        settingStrokeInfo.setStrokeWidth(eraserWidth);
        return settingStrokeInfo;
    }
}
