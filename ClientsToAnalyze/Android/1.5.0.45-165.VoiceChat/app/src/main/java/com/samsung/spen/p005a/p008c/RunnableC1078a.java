package com.samsung.spen.p005a.p008c;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;
import com.samsung.samm.common.SObject;
import com.samsung.samm.lib.InterfaceC0905c;
import com.samsung.samm.lib.engine.image.C0912a;
import com.samsung.spen.p005a.p009d.InterfaceC1088f;
import com.samsung.spensdk.applistener.FileProcessListener;
import com.samsung.spensdk.applistener.SPenTouchIDListener;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.samsung.spen.a.c.a */
/* loaded from: classes.dex */
public class RunnableC1078a implements InterfaceC1079b, Runnable {

    /* renamed from: b */
    protected Context f1871b;

    /* renamed from: d */
    protected int f1873d;

    /* renamed from: e */
    protected int f1874e;

    /* renamed from: a */
    protected final String f1870a = "DrawManager";

    /* renamed from: c */
    protected Bitmap f1872c = null;

    /* renamed from: f */
    private Handler f1875f = null;

    /* renamed from: g */
    private a f1876g = null;

    /* renamed from: h */
    private ProgressDialog f1877h = null;

    /* renamed from: i */
    private int f1878i = 0;

    /* renamed from: j */
    private int f1879j = 0;

    /* renamed from: k */
    private LinkedList<SObject> f1880k = null;

    /* renamed from: l */
    private int f1881l = 0;

    /* renamed from: m */
    private int f1882m = 0;

    /* renamed from: n */
    private InterfaceC0905c f1883n = new InterfaceC0905c() { // from class: com.samsung.spen.a.c.a.1
        @Override // com.samsung.samm.lib.InterfaceC0905c
        /* renamed from: a */
        public Bitmap mo605a(Bitmap bitmap, int i, int i2) {
            return null;
        }
    };

    /* renamed from: o */
    private FileProcessListener f1884o = new FileProcessListener() { // from class: com.samsung.spen.a.c.a.2
        @Override // com.samsung.spensdk.applistener.FileProcessListener
        public void onChangeProgress(int i) {
        }

        @Override // com.samsung.spensdk.applistener.FileProcessListener
        public void onLoadComplete(boolean z) {
        }
    };

    /* renamed from: p */
    private InterfaceC1088f f1885p = new InterfaceC1088f() { // from class: com.samsung.spen.a.c.a.3
        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public boolean onDrawBackgroundImage(Bitmap bitmap) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public boolean onDrawCanvasBackground(Bitmap bitmap) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public Bitmap onDrawCanvasBackground(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public boolean onDrawObject(SObject sObject, boolean z) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public boolean onDrawSAMMStrokePoint(int i, float f, float f2, float f3, int i2, long j, long j2) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public boolean onDeleteObject(SObject sObject) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public boolean onChangeObject(SObject sObject) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public SObject onSelectSObject(int i, int i2) {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public boolean onSetCanvasBitmap(Bitmap bitmap, boolean z) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public Bitmap onGetCanvasBitmap(boolean z) {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public boolean onSetSCanvasBitmapData(byte[] bArr) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public byte[] onGetSCanvasBitmapData() {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public boolean onSetSCanvasSize(int i, int i2) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public void onSetUsingHistoricalEventForStroke(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public void onSetDispatchObjectEvent(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public void onUpdateSelectedObjectList() {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1089g
        public boolean onDrawObject(int i, int i2, SObject sObject) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1089g
        public boolean onDrawStrokePoint(int i, int i2, int i3, float f, float f2, float f3, int i4, long j, long j2) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1089g
        public boolean onDeleteObject(int i, int i2) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1089g
        public boolean onChangeObject(int i, int i2, SObject sObject) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1089g
        public void onSetSPenTouchIDListener(SPenTouchIDListener sPenTouchIDListener) {
        }
    };

    public RunnableC1078a(Context context, int i, int i2) {
        this.f1873d = 0;
        this.f1874e = 0;
        this.f1871b = context;
        this.f1873d = i;
        this.f1874e = i2;
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1082e
    /* renamed from: a */
    public Bitmap mo1766a(boolean z, int i) {
        if (i > 0) {
            Log.w("DrawManager", "Getting a Bitmap of Multi Page is not Support. PageIndex=" + i);
        }
        return mo1785b(z);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1080c
    /* renamed from: a */
    public boolean mo1669a(SObject sObject) {
        return mo1782a(sObject, false);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1080c
    /* renamed from: b */
    public boolean mo1670b(SObject sObject) {
        return mo1795d(sObject);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1080c
    /* renamed from: a */
    public boolean mo1667a() {
        return m1791c();
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public boolean mo1781a(Bitmap bitmap, boolean z) {
        return this.f1885p.onSetCanvasBitmap(bitmap, z);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public boolean mo1779a(Bitmap bitmap) {
        return m1763d(bitmap);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: b */
    public Bitmap mo1784b() {
        return this.f1872c;
    }

    /* renamed from: d */
    private boolean m1763d(Bitmap bitmap) {
        if (bitmap == null) {
            this.f1872c = bitmap;
            return m1791c();
        }
        int i = this.f1873d;
        int i2 = this.f1874e;
        if (i <= 0 || i2 <= 0) {
            Log.e("DrawManager", "Canvas size is wrong (" + i + "," + i2 + ")");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            Log.e("DrawManager", "Bitmap size is wrong (" + width + "," + height + ")");
            return false;
        }
        if ((i != width || i2 != height) && (bitmap = Bitmap.createScaledBitmap(bitmap, i, i2, true)) == null) {
            Log.e("DrawManager", "Resized Bitmap is null");
            return false;
        }
        this.f1872c = bitmap;
        return m1791c();
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public boolean mo1780a(Bitmap bitmap, int i, int i2) {
        if (!C0912a.m665a(i)) {
            Log.e("DrawManager", "Undefined Image Operation Option : " + i2);
            return false;
        }
        if (bitmap == null) {
            m1763d((Bitmap) null);
            return true;
        }
        int i3 = this.f1873d;
        int i4 = this.f1874e;
        if (i3 <= 0 || i4 <= 0) {
            Log.e("DrawManager", "Canvas size is wrong (" + i3 + "," + i4 + ")");
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            Log.e("DrawManager", "Bitmap size is wrong (" + width + "," + height + ")");
            return false;
        }
        if ((i3 < width || i4 < height) && (bitmap = Bitmap.createScaledBitmap(bitmap, i3, i4, true)) == null) {
            Log.e("DrawManager", "Resized Bitmap is null");
            return false;
        }
        Bitmap bitmapMo605a = bitmap;
        if (i != 10) {
            bitmapMo605a = this.f1883n.mo605a(bitmapMo605a, i, i2);
        }
        m1763d(bitmapMo605a);
        return true;
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public void mo1774a(boolean z) {
        this.f1885p.onSetUsingHistoricalEventForStroke(z);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public boolean mo1782a(SObject sObject, boolean z) {
        return this.f1885p.onDrawObject(sObject, z);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1080c
    /* renamed from: a */
    public boolean mo1668a(int i, float f, float f2, float f3, int i2, long j, long j2) {
        this.f1885p.onDrawSAMMStrokePoint(i, f, f2, f3, i2, j, j2);
        return true;
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: c */
    public boolean mo1794c(SObject sObject) {
        return this.f1885p.onDeleteObject(sObject);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: d */
    public boolean mo1795d(SObject sObject) {
        return this.f1885p.onChangeObject(sObject);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public SObject mo1767a(int i, int i2) {
        return this.f1885p.onSelectSObject(i, i2);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1081d
    /* renamed from: a */
    public boolean mo1778a(int i, int i2, SObject sObject) {
        return this.f1885p.onDrawObject(i, i2, sObject);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1081d
    /* renamed from: a */
    public boolean mo1777a(int i, int i2, int i3, float f, float f2, float f3, int i4, long j, long j2) {
        this.f1885p.onDrawStrokePoint(i, i2, i3, f, f2, f3, i4, j, j2);
        return true;
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1081d
    /* renamed from: b */
    public boolean mo1787b(int i, int i2) {
        return this.f1885p.onDeleteObject(i, i2);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1081d
    /* renamed from: b */
    public boolean mo1788b(int i, int i2, SObject sObject) {
        return this.f1885p.onChangeObject(i, i2, sObject);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1081d
    /* renamed from: a */
    public void mo1772a(SPenTouchIDListener sPenTouchIDListener) {
        this.f1885p.onSetSPenTouchIDListener(sPenTouchIDListener);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: b */
    public boolean mo1789b(Bitmap bitmap) {
        return this.f1885p.onDrawBackgroundImage(bitmap);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: c */
    public boolean mo1793c(Bitmap bitmap) {
        return this.f1885p.onDrawCanvasBackground(bitmap);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public Bitmap mo1765a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        return this.f1885p.onDrawCanvasBackground(bitmap, bitmap2, bitmap3);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public void mo1775a(boolean z, LinkedList<SObject> linkedList) {
        m1786b(z, linkedList);
        if (this.f1880k == null) {
            Log.w("DrawManager", "There is no drawing object list");
            return;
        }
        Iterator<SObject> it = this.f1880k.iterator();
        while (it.hasNext() && mo1782a(it.next(), false)) {
        }
    }

    /* renamed from: c */
    public boolean m1791c() {
        return this.f1885p.onSetCanvasBitmap(this.f1872c, true);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: b */
    public Bitmap mo1785b(boolean z) {
        return this.f1885p.onGetCanvasBitmap(z);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public boolean mo1783a(byte[] bArr) {
        return this.f1885p.onSetSCanvasBitmapData(bArr);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: d */
    public byte[] mo1796d() {
        return this.f1885p.onGetSCanvasBitmapData();
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: c */
    public boolean mo1792c(int i, int i2) {
        return this.f1885p.onSetSCanvasSize(i, i2);
    }

    /* renamed from: a */
    boolean m1776a(int i) {
        int i2 = this.f1881l;
        if (i2 == 0) {
            return true;
        }
        if (i < 0 || i >= i2) {
            Log.w("DrawManager", "Invalid Drawing Object Index : " + i + "/" + i2);
            return false;
        }
        if (this.f1880k == null) {
            Log.w("DrawManager", "There is no drawing object list");
            return false;
        }
        if (i >= this.f1880k.size()) {
            Log.w("DrawManager", "Invalid Drawing Object Index : " + i + "/" + this.f1880k.size());
            return false;
        }
        if (!mo1782a(this.f1880k.get(i), false)) {
            Log.w("DrawManager", "Object drawing may not succeeded.");
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (m1764e() && this.f1875f != null) {
            this.f1875f.postDelayed(this, this.f1882m);
        }
    }

    /* renamed from: e */
    private boolean m1764e() {
        int i = this.f1881l > 10 ? this.f1881l / 10 : 1;
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            if (!m1776a(this.f1878i)) {
                if (this.f1877h != null) {
                    this.f1878i = this.f1881l;
                    m1790c(true);
                }
                if (this.f1884o != null) {
                    this.f1884o.onLoadComplete(false);
                }
                z = false;
            }
            this.f1878i++;
            if (this.f1878i == this.f1881l || this.f1881l == 0) {
                break;
            }
        }
        m1790c(false);
        if (this.f1878i != this.f1881l && this.f1881l != 0) {
            return z;
        }
        if (this.f1884o == null) {
            return false;
        }
        this.f1884o.onLoadComplete(true);
        return false;
    }

    /* renamed from: com.samsung.spen.a.c.a$a */
    public class a {

        /* renamed from: b */
        private String f1890b;

        /* renamed from: c */
        private String f1891c;

        /* renamed from: d */
        private int f1892d;

        /* renamed from: e */
        private boolean f1893e;

        public a() {
            this.f1890b = "SAMM Animation Library";
            this.f1891c = "Please Wait...";
            this.f1892d = 1;
            this.f1893e = false;
            this.f1890b = "SAMM Animation Library";
            this.f1891c = "Please Wait...";
            this.f1892d = 1;
            this.f1893e = false;
        }

        /* renamed from: a */
        public void m1801a(String str, String str2, int i, boolean z) {
            this.f1890b = str;
            this.f1891c = str2;
            if (i == 1 || i == 0) {
                this.f1892d = i;
            } else {
                this.f1892d = 1;
            }
            this.f1893e = z;
        }
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public void mo1773a(String str, String str2, int i, boolean z) {
        if (this.f1876g == null) {
            this.f1876g = new a();
        }
        this.f1876g.m1801a(str, str2, i, z);
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public void mo1768a(Context context, boolean z, LinkedList<SObject> linkedList) {
        if (this.f1875f == null) {
            this.f1875f = new Handler();
        }
        m1786b(z, linkedList);
        if (context != null) {
            if (this.f1876g == null) {
                this.f1876g = new a();
            }
            this.f1877h = new ProgressDialog(context);
            this.f1877h.setTitle(this.f1876g.f1890b);
            this.f1877h.setMessage(this.f1876g.f1891c);
            this.f1877h.setProgressStyle(this.f1876g.f1892d);
            this.f1877h.setCancelable(this.f1876g.f1893e);
            this.f1877h.setMax(100);
            this.f1877h.show();
        } else {
            this.f1877h = null;
        }
        m1790c(true);
        this.f1875f.postDelayed(this, this.f1882m);
    }

    /* renamed from: b */
    public void m1786b(boolean z, LinkedList<SObject> linkedList) {
        if (z) {
            m1791c();
        }
        this.f1880k = linkedList;
        if (this.f1880k != null) {
            this.f1881l = this.f1880k.size();
        } else {
            this.f1881l = 0;
        }
        this.f1879j = 0;
        this.f1878i = 0;
    }

    /* renamed from: c */
    void m1790c(boolean z) {
        int i = this.f1881l > 0 ? (int) ((this.f1878i * 100) / this.f1881l) : 100;
        if (z) {
            if (this.f1884o != null) {
                this.f1884o.onChangeProgress(i);
            }
            this.f1879j = i;
            if (this.f1877h != null) {
                this.f1877h.setProgress(this.f1879j);
            }
        } else if (i != this.f1879j) {
            if (this.f1884o != null) {
                this.f1884o.onChangeProgress(i);
            }
            this.f1879j = i;
            if (this.f1877h != null) {
                this.f1877h.setProgress(this.f1879j);
            }
        }
        if (this.f1877h != null && this.f1879j == 100) {
            this.f1877h.dismiss();
        }
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public void mo1769a(InterfaceC0905c interfaceC0905c) {
        this.f1883n = interfaceC0905c;
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public void mo1771a(FileProcessListener fileProcessListener) {
        this.f1884o = fileProcessListener;
    }

    @Override // com.samsung.spen.p005a.p008c.InterfaceC1079b
    /* renamed from: a */
    public void mo1770a(InterfaceC1088f interfaceC1088f) {
        this.f1885p = interfaceC1088f;
    }
}
