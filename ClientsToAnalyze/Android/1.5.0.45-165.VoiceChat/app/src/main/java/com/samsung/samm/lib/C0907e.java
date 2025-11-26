package com.samsung.samm.lib;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextPaint;
import android.util.Log;
import com.coolots.chaton.setting.data.ChatONHideMeImgData;
import com.samsung.samm.common.SDataAttachFile;
import com.samsung.samm.common.SDataPageMemo;
import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectFilling;
import com.samsung.samm.common.SObjectImage;
import com.samsung.samm.common.SObjectStroke;
import com.samsung.samm.common.SObjectText;
import com.samsung.samm.common.SOptionSAMM;
import com.samsung.samm.lib.engine.image.C0912a;
import com.samsung.samm.lib.engine.p004a.C0910c;
import com.samsung.samm.lib.p003a.C0887a;
import com.samsung.samm.lib.p003a.C0890d;
import com.samsung.samm.lib.p003a.C0901o;
import com.samsung.samm.lib.p003a.C0902p;
import com.samsung.samm.lib.p003a.C0903q;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.samsung.samm.lib.e */
/* loaded from: classes.dex */
public class C0907e implements InterfaceC0886a {

    /* renamed from: d */
    private static String f633d = null;

    /* renamed from: c */
    private boolean f636c = false;

    /* renamed from: a */
    protected C0890d f634a = null;

    /* renamed from: e */
    private C0910c f637e = null;

    /* renamed from: f */
    private SOptionSAMM f638f = null;

    /* renamed from: g */
    private boolean f639g = true;

    /* renamed from: h */
    private boolean f640h = true;

    /* renamed from: b */
    protected a f635b = new a() { // from class: com.samsung.samm.lib.e.1
        @Override // com.samsung.samm.lib.C0907e.a
        /* renamed from: a */
        public Bitmap mo638a(boolean z, int i) {
            return null;
        }
    };

    /* renamed from: com.samsung.samm.lib.e$a */
    public interface a {
        /* renamed from: a */
        Bitmap mo638a(boolean z, int i);
    }

    public C0907e(Context context, int i, int i2, boolean z, boolean z2, String str) {
        m634a(context, i, i2, z, z2, str);
    }

    /* renamed from: a */
    boolean m634a(Context context, int i, int i2, boolean z, boolean z2, String str) {
        this.f636c = false;
        if (!m629P()) {
            return false;
        }
        if (context == null || i <= 0 || i2 <= 0) {
            Log.e("SAMMLibrary", "Error on create SAMMLibrary");
            return false;
        }
        if (f633d == null) {
            if (str == null) {
                f633d = String.valueOf(context.getFilesDir().getParent()) + "/Temp/";
            } else {
                f633d = String.valueOf(str) + "/SPenSDKTemp/";
            }
        }
        File file = new File(f633d);
        if (file.exists()) {
            if (!file.mkdirs()) {
            }
        } else if (!file.mkdirs()) {
            Log.e("SAMMLibrary", "Error on create temporary file directory");
            return false;
        }
        this.f639g = z;
        this.f640h = z2;
        this.f634a = new C0890d(f633d, this.f639g, this.f640h);
        if (this.f634a == null) {
            Log.e("SAMMLibrary", "Error on create Animation Data");
            return false;
        }
        if (!m636c(i, i2)) {
            return false;
        }
        this.f638f = new SOptionSAMM();
        if (!this.f634a.m338b()) {
            Log.e("SAMMLibrary", "Error on cleanTempSaveFolderWithTimeLimit");
            return false;
        }
        this.f636c = true;
        return true;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: a */
    public boolean mo167a() {
        if (m612W()) {
            return this.f634a.m324a();
        }
        return false;
    }

    /* renamed from: O */
    public static String m606O() {
        return "1.3g";
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: b */
    public boolean mo181b() {
        return this.f636c;
    }

    /* renamed from: W */
    private boolean m612W() {
        if (this.f634a != null) {
            return true;
        }
        Log.e("SAMMLibrary", "SAMM Library is null. Library was not created successfully.");
        return false;
    }

    /* renamed from: c */
    boolean m636c(int i, int i2) {
        if (!m612W()) {
            return false;
        }
        if (i <= 0 || i2 <= 0) {
            Log.e("SAMMLibrary", "Invalid Canvas Resolution : width =" + i + ", height=" + i2);
            return false;
        }
        this.f634a.m352f(i);
        this.f634a.m355g(i2);
        return true;
    }

    /* renamed from: P */
    boolean m629P() {
        String str = Build.MODEL;
        if (Build.MODEL.compareToIgnoreCase("google_sdk") == 0 || Build.MODEL.compareToIgnoreCase("sdk") == 0) {
            return true;
        }
        String str2 = Build.BRAND;
        String str3 = Build.MANUFACTURER;
        if (str2 == null || str3 == null) {
            Log.e("SAMMLibrary", "Unknown Brand/Manufacturer Device");
            return false;
        }
        String str4 = Build.DEVICE;
        if (str2.compareToIgnoreCase("Samsung") == 0 || str3.compareToIgnoreCase("Samsung") == 0) {
            return true;
        }
        Log.e("SAMMLibrary", "Device(" + str4 + "), Model(" + str + "), Brand(" + str2 + "), Manufacturer(" + str3 + ") is not a Saumsung device.");
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: a */
    public boolean mo173a(SOptionSAMM sOptionSAMM) {
        if (sOptionSAMM == null) {
            Log.e("SAMMLibrary", "sammOption is null");
            return false;
        }
        if (this.f638f == null) {
            return false;
        }
        this.f638f.setSaveImageLeftCroppingOption(sOptionSAMM.getSaveImageLeftCroppingOption());
        this.f638f.setSaveImageRightCroppingOption(sOptionSAMM.getSaveImageRightCroppingOption());
        this.f638f.setSaveImageTopCroppingOption(sOptionSAMM.getSaveImageTopCroppingOption());
        this.f638f.setSaveImageBottomCroppingOption(sOptionSAMM.getSaveImageBottomCroppingOption());
        this.f638f.setSaveContentsCroppingOption(sOptionSAMM.getSaveContentsCroppingOption());
        this.f638f.setSaveImageSize(sOptionSAMM.getSaveImageSize());
        this.f638f.setJPGImageQuality(sOptionSAMM.getJPGImageQuality());
        this.f638f.setContentsQuality(sOptionSAMM.getContentsQuality());
        this.f638f.setSaveOnlyForegroundImage(sOptionSAMM.isSaveOnlyForegroundImage());
        this.f638f.setCreateNewImageFile(sOptionSAMM.isCreateNewImageFile());
        this.f638f.setConvertCanvasHorizontalAlignOption(sOptionSAMM.getConvertCanvasHorizontalAlignOption());
        this.f638f.setConvertCanvasVerticalAlignOption(sOptionSAMM.getConvertCanvasVerticalAlignOption());
        this.f638f.setConvertCanvasSizeOption(sOptionSAMM.getConvertCanvasSizeOption());
        return true;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: c */
    public SOptionSAMM mo186c() {
        return this.f638f;
    }

    /* renamed from: n */
    public static boolean m626n(String str) {
        return C0890d.m303k(str);
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: a */
    public boolean mo174a(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        if (!m612W()) {
            return false;
        }
        if (!this.f634a.m329a(str, (C0906d) null, this.f638f.getContentsQuality())) {
            Log.e("SAMMLibrary", "Error on load AMS File : " + str);
            return false;
        }
        int iM360i = this.f634a.m360i();
        int iM363j = this.f634a.m363j();
        int iM354g = this.f634a.m354g();
        int iM357h = this.f634a.m357h();
        int convertCanvasSizeOption = this.f638f.getConvertCanvasSizeOption();
        if (convertCanvasSizeOption == 0) {
            if (!m633a(iM354g, iM357h, iM360i, iM363j)) {
                Log.e("SAMMLibrary", "Error on convertResolution");
                return false;
            }
        } else if (convertCanvasSizeOption == 1) {
            int convertCanvasHorizontalAlignOption = this.f638f.getConvertCanvasHorizontalAlignOption();
            int convertCanvasVerticalAlignOption = this.f638f.getConvertCanvasVerticalAlignOption();
            float f = iM360i / iM354g;
            float f2 = iM363j / iM357h;
            if (f > f2) {
                if (convertCanvasHorizontalAlignOption == 0) {
                    i4 = 0;
                    i3 = 0;
                } else if (convertCanvasHorizontalAlignOption == 1) {
                    i3 = (iM360i - ((int) (iM354g * f2))) / 2;
                    i4 = 0;
                } else if (convertCanvasHorizontalAlignOption == 2) {
                    i3 = iM360i - ((int) (iM354g * f2));
                    i4 = 0;
                } else {
                    i4 = 0;
                    i3 = 0;
                }
            } else if (convertCanvasVerticalAlignOption == 0) {
                f2 = f;
                i3 = 0;
                i4 = 0;
            } else if (convertCanvasVerticalAlignOption == 1) {
                i3 = 0;
                f2 = f;
                i4 = (iM363j - ((int) (iM357h * f))) / 2;
            } else if (convertCanvasVerticalAlignOption == 2) {
                i3 = 0;
                f2 = f;
                i4 = iM363j - ((int) (iM357h * f));
            } else {
                f2 = f;
                i3 = 0;
                i4 = 0;
            }
            if (!m632a(f2, i3, i4)) {
                Log.e("SAMMLibrary", "Error on convertResolution");
                return false;
            }
        } else if (convertCanvasSizeOption == 2) {
            int iM360i2 = this.f634a.m360i();
            int iM363j2 = this.f634a.m363j();
            int convertCanvasHorizontalAlignOption2 = this.f638f.getConvertCanvasHorizontalAlignOption();
            int convertCanvasVerticalAlignOption2 = this.f638f.getConvertCanvasVerticalAlignOption();
            if (convertCanvasHorizontalAlignOption2 == 0) {
                i = 0;
            } else if (convertCanvasHorizontalAlignOption2 == 1) {
                i = (iM360i2 - iM354g) / 2;
            } else {
                i = convertCanvasHorizontalAlignOption2 == 2 ? iM360i2 - iM354g : 0;
            }
            if (convertCanvasVerticalAlignOption2 == 0) {
                i2 = 0;
            } else if (convertCanvasVerticalAlignOption2 == 1) {
                i2 = (iM363j2 - iM357h) / 2;
            } else {
                i2 = convertCanvasVerticalAlignOption2 == 2 ? iM363j2 - iM357h : 0;
            }
            if (!m632a(1.0f, i, i2)) {
                Log.e("SAMMLibrary", "Error on convertResolution");
                return false;
            }
        } else if (!m633a(iM354g, iM357h, iM360i, iM363j)) {
            Log.e("SAMMLibrary", "Error on convertResolution");
            return false;
        }
        return true;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: b */
    public boolean mo185b(String str) {
        if (!m612W()) {
            return false;
        }
        String strM628p = m628p(str);
        if (strM628p == null) {
            Log.e("SAMMLibrary", "Invalid SAMM Temp File Path : " + strM628p);
            return false;
        }
        if (!this.f634a.m329a(strM628p, (C0906d) null, this.f638f.getContentsQuality())) {
            Log.e("SAMMLibrary", "Error on load AMS Data : " + strM628p);
            return false;
        }
        if (!m633a(this.f634a.m354g(), this.f634a.m357h(), this.f634a.m360i(), this.f634a.m363j())) {
            Log.e("SAMMLibrary", "Error on convertResolution");
            return false;
        }
        return true;
    }

    /* renamed from: a */
    boolean m633a(int i, int i2, int i3, int i4) {
        if (!m612W()) {
            return false;
        }
        if (i <= 0 || i2 <= 0 || i3 <= 0 || i4 <= 0) {
            Log.e("SAMMLibrary", "Invalid Resolution : srcWidth =" + i + ", srcHeight=" + i2 + ", desWidth =" + i3 + ", desHeight=" + i4);
            return false;
        }
        boolean z = i != i3;
        boolean z2 = i2 != i4;
        float f = i3 / i;
        float f2 = i4 / i2;
        Iterator<SObject> it = this.f634a.m343c().iterator();
        while (it.hasNext()) {
            SObject next = it.next();
            if (next == null) {
                Log.e("SAMMLibrary", "Invalid SAMM Object Instance");
                return false;
            }
            RectF rect = next.getRect();
            if (rect == null) {
                Log.e("SAMMLibrary", "Invalid SAMM Object Rect Data");
                return false;
            }
            if (z) {
                rect.left *= f;
                rect.right *= f;
            }
            if (z2) {
                rect.top *= f2;
                rect.bottom *= f2;
            }
            next.setRect(rect);
            if (next instanceof SObjectStroke) {
                SObjectStroke sObjectStroke = (SObjectStroke) next;
                sObjectStroke.setSize(sObjectStroke.getSize() * f);
                int pointNum = sObjectStroke.getPointNum();
                PointF[] points = sObjectStroke.getPoints();
                if (points == null) {
                    return false;
                }
                for (int i5 = 0; i5 < pointNum; i5++) {
                    PointF pointF = points[i5];
                    PointF pointF2 = new PointF(pointF.x, pointF.y);
                    if (z) {
                        pointF2.x *= f;
                    }
                    if (z2) {
                        pointF2.y *= f2;
                    }
                    points[i5] = pointF2;
                }
                sObjectStroke.setPoints(points);
            } else if (next instanceof SObjectFilling) {
                SObjectFilling sObjectFilling = (SObjectFilling) next;
                PointF fillPoint = sObjectFilling.getFillPoint();
                if (z) {
                    fillPoint.x *= f;
                }
                if (z2) {
                    fillPoint.y *= f2;
                }
                sObjectFilling.setFillPoint(fillPoint);
            } else if (next instanceof SObjectText) {
                SObjectText sObjectText = (SObjectText) next;
                float size = sObjectText.getSize();
                if (z) {
                    size *= f;
                }
                sObjectText.setSize(size);
            }
        }
        return true;
    }

    /* renamed from: a */
    boolean m632a(float f, int i, int i2) {
        if (!m612W()) {
            return false;
        }
        boolean z = f != 1.0f;
        boolean z2 = i > 0;
        boolean z3 = i2 > 0;
        Iterator<SObject> it = this.f634a.m343c().iterator();
        while (it.hasNext()) {
            SObject next = it.next();
            if (next == null) {
                Log.e("SAMMLibrary", "Invalid SAMM Object Instance");
                return false;
            }
            RectF rect = next.getRect();
            if (rect == null) {
                Log.e("SAMMLibrary", "Invalid SAMM Object Rect Data");
                return false;
            }
            if (z) {
                rect.left *= f;
                rect.right *= f;
                rect.top *= f;
                rect.bottom *= f;
            }
            if (z2) {
                rect.left += i;
                rect.right += i;
            }
            if (z3) {
                rect.top += i2;
                rect.bottom += i2;
            }
            next.setRect(rect);
            if (next instanceof SObjectStroke) {
                SObjectStroke sObjectStroke = (SObjectStroke) next;
                sObjectStroke.setSize(sObjectStroke.getSize() * f);
                int pointNum = sObjectStroke.getPointNum();
                PointF[] points = sObjectStroke.getPoints();
                if (points == null) {
                    return false;
                }
                for (int i3 = 0; i3 < pointNum; i3++) {
                    PointF pointF = points[i3];
                    PointF pointF2 = new PointF(pointF.x, pointF.y);
                    if (z) {
                        pointF2.x *= f;
                        pointF2.y *= f;
                    }
                    if (z2) {
                        pointF2.x += i;
                    }
                    if (z3) {
                        pointF2.y += i2;
                    }
                    points[i3] = pointF2;
                }
                sObjectStroke.setPoints(points);
            } else if (next instanceof SObjectFilling) {
                SObjectFilling sObjectFilling = (SObjectFilling) next;
                PointF fillPoint = sObjectFilling.getFillPoint();
                if (z) {
                    fillPoint.x *= f;
                    fillPoint.y *= f;
                }
                sObjectFilling.setFillPoint(fillPoint);
            } else if (next instanceof SObjectText) {
                SObjectText sObjectText = (SObjectText) next;
                float size = sObjectText.getSize();
                if (z) {
                    size *= f;
                }
                sObjectText.setSize(size);
            }
        }
        return true;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: c */
    public boolean mo188c(String str) {
        boolean z = false;
        if (str == null) {
            Log.e("SAMMLibrary", "Invalid SAMM File Path: " + str);
            return false;
        }
        if (!m612W() || !m630Q()) {
            return false;
        }
        String strM585a = C0903q.m585a(str);
        boolean zIsCreateNewImageFile = this.f638f.isCreateNewImageFile();
        if (strM585a == null) {
            str = String.valueOf(str) + ".png";
            z = zIsCreateNewImageFile;
        } else if (strM585a.compareToIgnoreCase("ams") == 0) {
            zIsCreateNewImageFile = false;
            z = true;
        } else if (strM585a.compareToIgnoreCase("jpg") == 0 || strM585a.compareToIgnoreCase("png") == 0) {
            z = zIsCreateNewImageFile;
        } else if (zIsCreateNewImageFile) {
            str = String.valueOf(str) + ".png";
            z = true;
        }
        return m635a(str, z, zIsCreateNewImageFile);
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: d */
    public String mo189d() {
        if (!m612W()) {
            return null;
        }
        String strM615Z = m615Z();
        if (strM615Z == null) {
            Log.e("SAMMLibrary", "saveSAMMData : Invalid SAMM Data Path: " + strM615Z);
            return null;
        }
        String strM614Y = m614Y();
        if (strM614Y == null) {
            Log.e("SAMMLibrary", "saveSAMMData : Invalid SAMM sSAMMDataKeyValue : " + strM614Y);
            return null;
        }
        if (m635a(strM615Z, true, false)) {
            return strM614Y;
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: d */
    public boolean mo191d(String str) {
        if (str == null) {
            Log.e("SAMMLibrary", "Invalid SAMM File Path: " + str);
            return false;
        }
        if (m612W() && m630Q()) {
            return m635a(str, false, false);
        }
        return false;
    }

    /* renamed from: a */
    boolean m635a(String str, boolean z, boolean z2) {
        if (z) {
            File file = new File(str);
            if (file.exists() && !file.delete()) {
                return false;
            }
            try {
                if (!file.createNewFile()) {
                    Log.e("SAMMLibrary", "Fail to create SAMMDataFile : " + str);
                    return false;
                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("SAMMLibrary", "Fail to create SAMMDataFile : " + str);
                return false;
            }
        } else if (!z2 && !new File(str).exists()) {
            Log.e("SAMMLibrary", "File does not exist : " + str);
            return false;
        }
        Rect rectM631a = (this.f638f.getSaveImageLeftCroppingOption() || this.f638f.getSaveImageRightCroppingOption() || this.f638f.getSaveImageTopCroppingOption() || this.f638f.getSaveImageBottomCroppingOption()) ? m631a(this.f638f.getSaveImageLeftCroppingOption(), this.f638f.getSaveImageTopCroppingOption(), this.f638f.getSaveImageRightCroppingOption(), this.f638f.getSaveImageBottomCroppingOption()) : null;
        if (z2 && (str = m617a(str, rectM631a)) == null) {
            Log.e("SAMMLibrary", "Error make SAMM File: " + str);
            return false;
        }
        int iM360i = this.f634a.m360i();
        int iM363j = this.f634a.m363j();
        if (this.f638f.getSaveContentsCroppingOption()) {
            if (rectM631a != null) {
                this.f634a.m346d(rectM631a.right - rectM631a.left);
                this.f634a.m349e(rectM631a.bottom - rectM631a.top);
            } else {
                this.f634a.m346d(iM360i);
                this.f634a.m349e(iM363j);
            }
        } else {
            this.f634a.m346d(iM360i);
            this.f634a.m349e(iM363j);
            rectM631a = null;
        }
        if (!this.f634a.m334a(str, false, rectM631a)) {
            Log.e("SAMMLibrary", "Error save SAMM File: " + str);
            return false;
        }
        return true;
    }

    /* renamed from: a */
    Rect m631a(boolean z, boolean z2, boolean z3, boolean z4) {
        LinkedList<SObject> linkedListM343c = this.f634a.m343c();
        if (linkedListM343c == null || linkedListM343c.size() <= 0) {
            return null;
        }
        int iM360i = this.f634a.m360i();
        int iM363j = this.f634a.m363j();
        RectF rectF = new RectF();
        if (z) {
            rectF.left = iM360i;
        } else {
            rectF.left = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        if (z3) {
            rectF.right = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        } else {
            rectF.right = iM360i;
        }
        if (z2) {
            rectF.top = iM363j;
        } else {
            rectF.top = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        if (z4) {
            rectF.bottom = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        } else {
            rectF.bottom = iM363j;
        }
        Iterator<SObject> it = linkedListM343c.iterator();
        while (it.hasNext()) {
            RectF rect = it.next().getRect();
            if (z && rect.left < rectF.left) {
                rectF.left = rect.left;
            }
            if (z3 && rect.right > rectF.right) {
                rectF.right = rect.right;
            }
            if (z2 && rect.top < rectF.top) {
                rectF.top = rect.top;
            }
            if (z4 && rect.bottom > rectF.bottom) {
                rectF.bottom = rect.bottom;
            }
        }
        if (rectF.left < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            rectF.left = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        if (rectF.top < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            rectF.top = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
        }
        if (rectF.right > iM360i) {
            rectF.right = iM360i;
        }
        if (rectF.bottom > iM363j) {
            rectF.bottom = iM363j;
        }
        if (rectF.left >= rectF.right || rectF.top >= rectF.bottom) {
            return null;
        }
        return new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    /* renamed from: Q */
    boolean m630Q() {
        String strM285A = C0890d.m285A();
        if (strM285A != null && strM285A.length() != 0) {
            return true;
        }
        Log.e("SAMMLibrary", "Application ID Name must be specified for data compatibility. Call setAppID() before save file.");
        return false;
    }

    /* renamed from: o */
    public static boolean m627o(String str) {
        if (str == null) {
            Log.e("SAMMLibrary", "Invalid File Path: " + str);
            return false;
        }
        if (!C0890d.m304l(str)) {
            Log.e("SAMMLibrary", "Error on remove SAMM Data from File: " + str);
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private String m617a(String str, Rect rect) {
        if (str == null) {
            Log.e("SAMMLibrary", "saveImageFile : Invalid Save Image File Path: " + str);
            return null;
        }
        if (!m612W()) {
            return null;
        }
        if (str.substring(str.lastIndexOf("/") + 1).lastIndexOf(".") == -1) {
            str = String.valueOf(str) + ".png";
        }
        Bitmap bitmapM625b = m625b(str, rect);
        if (!(bitmapM625b == null && (bitmapM625b = m613X()) == null) && m623a(str, bitmapM625b)) {
            return str;
        }
        return null;
    }

    /* renamed from: b */
    private Bitmap m625b(String str, Rect rect) {
        boolean zIsSaveOnlyForegroundImage;
        Bitmap bitmapMo638a;
        int width;
        int height;
        if (str != null && m612W() && this.f638f != null && (bitmapMo638a = this.f635b.mo638a((zIsSaveOnlyForegroundImage = this.f638f.isSaveOnlyForegroundImage()), 0)) != null) {
            if (rect != null) {
                bitmapMo638a = Bitmap.createBitmap(bitmapMo638a, rect.left, rect.top, rect.right - rect.left, rect.bottom - rect.top);
            }
            if (this.f638f.getSaveImageSize() == 1) {
                width = ChatONHideMeImgData.IMAGE_DEFAULT_WIDTH;
                height = (bitmapMo638a.getHeight() * ChatONHideMeImgData.IMAGE_DEFAULT_WIDTH) / bitmapMo638a.getWidth();
            } else if (this.f638f.getSaveImageSize() == 2) {
                width = 240;
                height = (bitmapMo638a.getHeight() * 240) / bitmapMo638a.getWidth();
            } else if (this.f638f.getSaveImageSize() == 3) {
                width = 64;
                height = (bitmapMo638a.getHeight() * 64) / bitmapMo638a.getWidth();
            } else {
                width = bitmapMo638a.getWidth();
                height = bitmapMo638a.getHeight();
            }
            String strSubstring = str.substring(str.lastIndexOf(".") + 1);
            Rect rect2 = new Rect();
            Rect rect3 = new Rect();
            if (zIsSaveOnlyForegroundImage) {
                return Bitmap.createScaledBitmap(bitmapMo638a, width, height, true);
            }
            if (this.f634a.m370m() == 3 || this.f634a.m370m() == 4) {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(this.f634a.m378q());
                if (bitmapDecodeFile == null) {
                    return null;
                }
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeFile, width, height, true);
                Canvas canvas = new Canvas(bitmapCreateScaledBitmap);
                rect2.set(0, 0, bitmapMo638a.getWidth(), bitmapMo638a.getHeight());
                rect3.set(0, 0, bitmapCreateScaledBitmap.getWidth(), bitmapCreateScaledBitmap.getHeight());
                canvas.drawBitmap(bitmapMo638a, rect2, rect3, new Paint());
                return bitmapCreateScaledBitmap;
            }
            int iM372n = this.f634a.m372n();
            int i = (iM372n >> 24) & 255;
            if (i == 0 && strSubstring.compareToIgnoreCase("PNG") == 0) {
                return Bitmap.createScaledBitmap(bitmapMo638a, width, height, true);
            }
            if (i == 0 && strSubstring.compareToIgnoreCase("JPG") == 0) {
                iM372n = -1;
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            canvas2.drawColor(iM372n);
            rect2.set(0, 0, bitmapMo638a.getWidth(), bitmapMo638a.getHeight());
            rect3.set(0, 0, bitmapCreateBitmap.getWidth(), bitmapCreateBitmap.getHeight());
            canvas2.drawBitmap(bitmapMo638a, rect2, rect3, new Paint());
            return bitmapCreateBitmap;
        }
        return null;
    }

    /* renamed from: X */
    private Bitmap m613X() throws IOException {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("assets/samm_embeded_icon/temp_icon.png");
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(resourceAsStream);
        try {
            resourceAsStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmapDecodeStream;
    }

    /* renamed from: a */
    private boolean m623a(String str, Bitmap bitmap) {
        if (str == null) {
            Log.e("SAMMLibrary", "saveAMSImageFile sFilePath is null");
            return false;
        }
        if (bitmap == null) {
            Log.e("SAMMLibrary", "Unable to get Bitmap");
            return false;
        }
        String strSubstring = str.substring(str.lastIndexOf(".") + 1);
        if (strSubstring.compareToIgnoreCase("PNG") == 0) {
            if (!C0902p.m576a(str, bitmap)) {
                return false;
            }
        } else if (strSubstring.compareToIgnoreCase("JPG") == 0) {
            if (!C0902p.m577a(str, bitmap, this.f638f.getJPGImageQuality())) {
                return false;
            }
        } else {
            Log.e("SAMMLibrary", "Unsupported File Format");
            return false;
        }
        return true;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: e */
    public boolean mo192e() {
        if (!m612W()) {
            return false;
        }
        this.f634a.m321T();
        return true;
    }

    /* renamed from: a */
    public static boolean m622a(String str, int i, int i2, String str2) {
        return C0890d.m296a(str, i, i2, str2);
    }

    /* renamed from: R */
    public static String m607R() {
        return C0890d.m305z();
    }

    /* renamed from: S */
    public static String m608S() {
        return C0890d.m285A();
    }

    /* renamed from: T */
    public static int m609T() {
        return C0890d.m286B();
    }

    /* renamed from: U */
    public static int m610U() {
        return C0890d.m287C();
    }

    /* renamed from: V */
    public static String m611V() {
        return C0890d.m288D();
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: f */
    public String mo196f() {
        if (m612W()) {
            return this.f634a.m306E();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: g */
    public String mo199g() {
        if (m612W()) {
            return this.f634a.m307F();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: h */
    public int mo201h() {
        if (m612W()) {
            return this.f634a.m308G();
        }
        return 0;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: i */
    public int mo203i() {
        if (m612W()) {
            return this.f634a.m309H();
        }
        return 0;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: j */
    public String mo205j() {
        if (m612W()) {
            return this.f634a.m310I();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: e */
    public boolean mo194e(String str) {
        if (m612W()) {
            return this.f634a.m350e(str);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: k */
    public String mo207k() {
        if (m612W()) {
            return this.f634a.m386y();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: a */
    public boolean mo178a(String str, String str2, String str3, Bitmap bitmap) {
        if (m612W()) {
            return this.f634a.m333a(str, str2, str3, bitmap);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: l */
    public String mo209l() {
        if (m612W()) {
            return this.f634a.m311J();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: m */
    public String mo211m() {
        if (m612W()) {
            return this.f634a.m312K();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: n */
    public String mo213n() {
        if (m612W()) {
            return this.f634a.m313L();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: o */
    public Bitmap mo214o() {
        if (m612W()) {
            return this.f634a.m314M();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: p */
    public long mo215p() {
        if (m612W()) {
            return this.f634a.m315N();
        }
        return 0L;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: f */
    public boolean mo197f(String str) {
        if (m612W()) {
            return this.f634a.m353f(str);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: q */
    public String mo216q() {
        if (m612W()) {
            return this.f634a.m317P();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: a */
    public boolean mo169a(int i, int i2) {
        if (m612W()) {
            return this.f634a.m339b(i, i2);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: r */
    public int mo217r() {
        if (m612W()) {
            return this.f634a.m318Q();
        }
        return 0;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: s */
    public int mo218s() {
        if (m612W()) {
            return this.f634a.m319R();
        }
        return 0;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: t */
    public String[] mo219t() {
        if (m612W()) {
            return this.f634a.m320S();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: g */
    public boolean mo200g(String str) {
        if (m612W()) {
            return this.f634a.m356g(str);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: h */
    public boolean mo202h(String str) {
        if (m612W()) {
            return this.f634a.m359h(str);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: a */
    public boolean mo168a(int i) {
        if (m612W()) {
            return this.f634a.m377p(i);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: u */
    public int mo220u() {
        if (m612W()) {
            return this.f634a.m316O();
        }
        return 0;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: a */
    public boolean mo176a(String str, String str2) {
        if (m612W()) {
            return this.f634a.m330a(str, str2);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: b */
    public String mo180b(String str, String str2) {
        return !m612W() ? str2 : this.f634a.m336b(str, str2);
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: i */
    public boolean mo204i(String str) {
        if (m612W()) {
            return this.f634a.m362i(str);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: a */
    public boolean mo175a(String str, int i) {
        if (m612W()) {
            return this.f634a.m328a(str, i);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: b */
    public int mo179b(String str, int i) {
        return !m612W() ? i : this.f634a.m335b(str, i);
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: j */
    public boolean mo206j(String str) {
        if (m612W()) {
            return this.f634a.m365j(str);
        }
        return false;
    }

    /* renamed from: Y */
    private String m614Y() {
        if (m612W()) {
            return this.f634a.m366k();
        }
        return null;
    }

    /* renamed from: Z */
    private String m615Z() {
        if (m612W()) {
            return this.f634a.m368l();
        }
        return null;
    }

    /* renamed from: p */
    private String m628p(String str) {
        if (m612W()) {
            return this.f634a.m322a(str);
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: b */
    public boolean mo182b(int i) {
        if (!m612W()) {
            return false;
        }
        this.f634a.m358h(i);
        return true;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: v */
    public int mo221v() {
        if (m612W()) {
            return this.f634a.m372n();
        }
        return 0;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: c */
    public boolean mo187c(int i) {
        if (!m612W() || i < 0 || i > 155) {
            return false;
        }
        this.f634a.m361i(i + 100);
        return true;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: w */
    public int mo222w() {
        int iM374o;
        if (m612W() && this.f634a.m370m() == 2 && this.f634a.m374o() - 100 >= 0 && iM374o <= 155) {
            return iM374o;
        }
        return -1;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: k */
    public boolean mo208k(String str) {
        if (m612W()) {
            return this.f634a.m341b(str);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: a */
    public boolean mo170a(Bitmap bitmap) {
        if (m612W()) {
            return this.f634a.m326a(bitmap);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: x */
    public String mo223x() {
        if (m612W()) {
            return this.f634a.m376p();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: y */
    public String mo224y() {
        if (m612W()) {
            return this.f634a.m378q();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: b */
    public boolean mo184b(Bitmap bitmap) {
        if (m612W()) {
            return this.f634a.m340b(bitmap);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: z */
    public String mo225z() {
        if (m612W()) {
            return this.f634a.m379r();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: b */
    public boolean mo183b(int i, int i2) {
        if (m612W()) {
            return this.f634a.m325a(i, i2);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: d */
    public boolean mo190d(int i) {
        if (!m612W() || i < 0 || i > 155) {
            return false;
        }
        this.f634a.m367k(i + 100);
        return true;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: A */
    public int mo155A() {
        int iM381t;
        if (m612W() && this.f634a.m380s() == 1 && this.f634a.m381t() - 100 >= 0 && iM381t <= 155) {
            return iM381t;
        }
        return -1;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: l */
    public boolean mo210l(String str) {
        if (m612W()) {
            return this.f634a.m344c(str);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: B */
    public String mo156B() {
        if (m612W()) {
            return this.f634a.m382u();
        }
        return null;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: C */
    public boolean mo157C() {
        if (m612W()) {
            return this.f634a.m344c(this.f634a.m383v());
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: D */
    public boolean mo158D() {
        if (!m612W()) {
            return false;
        }
        this.f634a.m364j(0);
        return true;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: E */
    public boolean mo159E() {
        if (m612W() && this.f637e != null) {
            return this.f637e.m659c();
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: F */
    public boolean mo160F() throws IllegalStateException, IllegalArgumentException {
        if (!m612W()) {
            return false;
        }
        if (this.f637e != null) {
            this.f637e = null;
        }
        this.f637e = new C0910c();
        C0903q.m599d(this.f634a.m383v());
        this.f637e.m657a(this.f634a.m383v());
        this.f637e.m656a();
        return true;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: G */
    public boolean mo161G() throws IllegalStateException {
        if (!m612W()) {
            return false;
        }
        if (this.f637e == null) {
            Log.e("SAMMLibrary", "Voice Recoding Not in progress");
            return false;
        }
        this.f637e.m658b();
        this.f637e = null;
        return true;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: H */
    public boolean mo162H() throws IllegalStateException {
        if (!m612W()) {
            return false;
        }
        if (this.f637e == null) {
            Log.w("SAMMLibrary", "Voice Recoding Not in progress");
            return false;
        }
        this.f637e.m658b();
        this.f637e = null;
        return true;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: a */
    public boolean mo177a(String str, String str2, Bitmap bitmap, int i) {
        if (m612W()) {
            return this.f634a.m332a(str, str2, bitmap, i);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: m */
    public boolean mo212m(String str) {
        if (m612W()) {
            return this.f634a.m347d(str);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: e */
    public boolean mo193e(int i) {
        if (m612W()) {
            return this.f634a.m369l(i);
        }
        return false;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: I */
    public int mo163I() {
        if (m612W()) {
            return this.f634a.m384w();
        }
        return 0;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: f */
    public SDataAttachFile mo195f(int i) {
        if (!m612W()) {
            return null;
        }
        C0887a.a aVarM371m = this.f634a.m371m(i);
        if (aVarM371m == null) {
            Log.e("SAMMLibrary", "Invalid Attach File Index : " + i);
            return null;
        }
        String strM247a = aVarM371m.m247a();
        String strM248b = aVarM371m.m248b();
        Bitmap bitmapM249c = aVarM371m.m249c();
        SDataAttachFile sDataAttachFile = new SDataAttachFile();
        sDataAttachFile.setFileData(strM247a, strM248b);
        sDataAttachFile.setFileIcon(bitmapM249c);
        return sDataAttachFile;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: a */
    public boolean mo171a(SDataPageMemo sDataPageMemo, int i) {
        if (!m612W()) {
            return false;
        }
        if (sDataPageMemo != null) {
            return this.f634a.m331a(sDataPageMemo.getText(), sDataPageMemo.getFontName(), sDataPageMemo.getStyle(), (int) sDataPageMemo.getSize(), sDataPageMemo.getColor(), sDataPageMemo.getBGColor(), sDataPageMemo.getHorizTextAlign(), sDataPageMemo.getVertTextAlign(), i);
        }
        return this.f634a.m331a(null, null, 0, 0, 0, 0, 0, 0, i);
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: g */
    public SDataPageMemo mo198g(int i) {
        C0901o.a aVarM373n;
        if (!m612W() || (aVarM373n = this.f634a.m373n(i)) == null) {
            return null;
        }
        SDataPageMemo sDataPageMemo = new SDataPageMemo();
        sDataPageMemo.setTextData(aVarM373n.m564a(), aVarM373n.m565b());
        sDataPageMemo.setStyle(aVarM373n.m566c());
        sDataPageMemo.setSize(aVarM373n.m567d());
        sDataPageMemo.setColor(aVarM373n.m568e());
        sDataPageMemo.setBGColor(aVarM373n.m569f());
        sDataPageMemo.setTextAlign(aVarM373n.m570g(), aVarM373n.m571h());
        return sDataPageMemo;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: J */
    public boolean mo164J() {
        if (!m612W()) {
            return false;
        }
        this.f634a.m345d();
        return true;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: a */
    public boolean mo172a(SObject sObject) {
        if (sObject == null) {
            Log.e("SAMMLibrary", "Invalid SAMM Object Instance");
            return false;
        }
        if (!m612W()) {
            return false;
        }
        if (sObject instanceof SObjectStroke) {
            return m620a((SObjectStroke) sObject);
        }
        if (sObject instanceof SObjectImage) {
            return m619a((SObjectImage) sObject);
        }
        if (sObject instanceof SObjectText) {
            return m621a((SObjectText) sObject);
        }
        if (sObject instanceof SObjectFilling) {
            return m618a((SObjectFilling) sObject);
        }
        Log.e("SAMMLibrary", "Unknown SAMM Object");
        return false;
    }

    /* renamed from: a */
    private boolean m620a(SObjectStroke sObjectStroke) {
        if (sObjectStroke == null || !m612W()) {
            return false;
        }
        if (sObjectStroke.getPointNum() != sObjectStroke.getPressureNum()) {
            Log.w("SAMMLibrary", "Number of sData.point and sData.pressure is different");
        }
        PointF[] points = sObjectStroke.getPoints();
        if (points == null || points.length == 0) {
            Log.e("SAMMLibrary", "Point data is invalid");
            return false;
        }
        return this.f634a.m327a(sObjectStroke);
    }

    /* renamed from: a */
    private boolean m618a(SObjectFilling sObjectFilling) {
        if (sObjectFilling != null && m612W()) {
            return this.f634a.m327a(sObjectFilling);
        }
        return false;
    }

    /* renamed from: a */
    private boolean m619a(SObjectImage sObjectImage) {
        if (sObjectImage == null || !m612W()) {
            return false;
        }
        RectF rect = sObjectImage.getRect();
        if (rect == null || rect.width() <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || rect.height() <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            int iM360i = this.f634a.m360i() / 4;
            int iM363j = this.f634a.m363j() / 4;
            sObjectImage.setRect(new RectF((this.f634a.m360i() - iM360i) / 2, (this.f634a.m363j() - iM363j) / 2, iM360i + r2, iM363j + r3));
        }
        return this.f634a.m327a(sObjectImage);
    }

    /* renamed from: a */
    private boolean m621a(SObjectText sObjectText) {
        if (sObjectText == null || !m612W()) {
            return false;
        }
        RectF rect = sObjectText.getRect();
        if (rect == null || rect.width() <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || rect.height() <= VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
            Rect rectM616a = m616a(sObjectText.getText(), sObjectText.getSize(), sObjectText.getFontName(), sObjectText.getStyle());
            int iWidth = rectM616a.width();
            int iHeight = rectM616a.height();
            sObjectText.setRect(new RectF((this.f634a.m360i() - iWidth) / 2, (this.f634a.m363j() - iHeight) / 2, iWidth + r2, iHeight + r3));
        }
        return this.f634a.m327a(sObjectText);
    }

    /* renamed from: a */
    private Rect m616a(String str, float f, String str2, int i) {
        int i2;
        int i3 = 1;
        if ((i & 4) != 0 || (i & 3) != 0) {
            i2 = 3;
        } else if ((i & 1) != 0) {
            i2 = 1;
        } else {
            i2 = (i & 2) != 0 ? 2 : 0;
        }
        Typeface typefaceCreate = Typeface.create(str2, i2);
        TextPaint textPaint = new TextPaint();
        textPaint.setTypeface(typefaceCreate);
        textPaint.setTextSize(f);
        Float fValueOf = Float.valueOf(f / 4.0f);
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (str.charAt(i4) == '\n') {
                i3++;
            }
        }
        int iMeasureText = 0;
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < str.length(); i5++) {
            if (str.charAt(i5) == '\n') {
                int iMeasureText2 = (int) textPaint.measureText(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                if (iMeasureText2 > iMeasureText) {
                    iMeasureText = iMeasureText2;
                    sb = sb2;
                } else {
                    sb = sb2;
                }
            } else {
                sb.append(str.charAt(i5));
                if (i5 == str.length() - 1) {
                    int iMeasureText3 = (int) textPaint.measureText(sb.toString());
                    StringBuilder sb3 = new StringBuilder();
                    if (iMeasureText3 > iMeasureText) {
                        iMeasureText = iMeasureText3;
                        sb = sb3;
                    } else {
                        sb = sb3;
                    }
                }
            }
        }
        if (iMeasureText == 0) {
            iMeasureText = (int) textPaint.measureText(str);
        }
        int iFloatValue = (int) (iMeasureText + fValueOf.floatValue());
        int textSize = (int) ((i3 * textPaint.getTextSize()) + fValueOf.floatValue());
        Rect rect = new Rect();
        rect.set(0, 0, iFloatValue, textSize);
        return rect;
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: K */
    public LinkedList<SObject> mo165K() {
        LinkedList<SObject> linkedList = new LinkedList<>();
        int iM351f = this.f634a.m351f();
        for (int i = 0; i < iM351f; i++) {
            SObject sObjectM637h = m637h(i);
            if (sObjectM637h != null) {
                linkedList.add(sObjectM637h);
            }
        }
        return linkedList;
    }

    /* renamed from: h */
    public SObject m637h(int i) {
        if (!m612W()) {
            return null;
        }
        int iM351f = this.f634a.m351f();
        if (i < 0 || i >= iM351f) {
            Log.e("SAMMLibrary", "Invalid SAMM Object Index : " + i);
            return null;
        }
        return this.f634a.m342c(i);
    }

    @Override // com.samsung.samm.lib.InterfaceC0886a
    /* renamed from: a */
    public void mo166a(a aVar) {
        if (aVar == null) {
            Log.e("SAMMLibrary", "Failed setOnSAMMDataListener!");
        } else {
            this.f635b = aVar;
        }
    }

    @Override // com.samsung.samm.lib.InterfaceC0905c
    /* renamed from: a */
    public Bitmap mo605a(Bitmap bitmap, int i, int i2) {
        return m624b(bitmap, i, i2);
    }

    /* renamed from: b */
    public static Bitmap m624b(Bitmap bitmap, int i, int i2) {
        return C0912a.m669b(bitmap, i, i2);
    }

    @Override // com.samsung.samm.lib.InterfaceC0904b
    /* renamed from: L */
    public String mo602L() {
        return this.f634a.m385x();
    }

    @Override // com.samsung.samm.lib.InterfaceC0904b
    /* renamed from: M */
    public int mo603M() {
        return this.f634a.m360i();
    }

    @Override // com.samsung.samm.lib.InterfaceC0904b
    /* renamed from: N */
    public int mo604N() {
        return this.f634a.m363j();
    }
}
