package com.samsung.spen.p005a.p011f;

import android.graphics.Bitmap;
import android.util.Log;
import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectFilling;
import com.samsung.samm.common.SObjectImage;
import com.samsung.samm.common.SObjectStroke;
import com.samsung.samm.common.SObjectText;
import com.samsung.samm.lib.InterfaceC0904b;
import com.samsung.samm.lib.p003a.C0890d;
import com.samsung.spen.p005a.p009d.InterfaceC1088f;
import com.samsung.spensdk.applistener.SPenTouchIDListener;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.samsung.spen.a.f.d */
/* loaded from: classes.dex */
public class C1097d implements InterfaceC1094a {

    /* renamed from: a */
    protected LinkedList<SObject> f1986a;

    /* renamed from: b */
    protected LinkedList<SObject> f1987b;

    /* renamed from: c */
    protected int f1988c;

    /* renamed from: e */
    protected int f1990e;

    /* renamed from: f */
    protected LinkedList<SObject> f1991f;

    /* renamed from: g */
    protected LinkedList<SObject> f1992g;

    /* renamed from: h */
    protected LinkedList<SObject> f1993h;

    /* renamed from: d */
    protected int f1989d = 0;

    /* renamed from: i */
    private InterfaceC0904b f1994i = new InterfaceC0904b() { // from class: com.samsung.spen.a.f.d.1
        @Override // com.samsung.samm.lib.InterfaceC0904b
        /* renamed from: L */
        public String mo602L() {
            return null;
        }

        @Override // com.samsung.samm.lib.InterfaceC0904b
        /* renamed from: N */
        public int mo604N() {
            return 0;
        }

        @Override // com.samsung.samm.lib.InterfaceC0904b
        /* renamed from: M */
        public int mo603M() {
            return 0;
        }
    };

    /* renamed from: j */
    private InterfaceC1088f f1995j = new InterfaceC1088f() { // from class: com.samsung.spen.a.f.d.2
        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public boolean onChangeObject(SObject sObject) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public boolean onDeleteObject(SObject sObject) {
            return false;
        }

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
        public Bitmap onGetCanvasBitmap(boolean z) {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public byte[] onGetSCanvasBitmapData() {
            return null;
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
        public void onSetDispatchObjectEvent(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public boolean onSetSCanvasBitmapData(byte[] bArr) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public boolean onSetSCanvasSize(int i, int i2) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
        public void onSetUsingHistoricalEventForStroke(boolean z) {
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

    public C1097d() {
        this.f1986a = null;
        this.f1987b = null;
        this.f1988c = 0;
        this.f1990e = 0;
        this.f1991f = null;
        this.f1992g = null;
        this.f1993h = null;
        this.f1986a = new LinkedList<>();
        this.f1987b = new LinkedList<>();
        this.f1988c = 0;
        this.f1990e = 0;
        this.f1991f = new LinkedList<>();
        this.f1992g = new LinkedList<>();
        this.f1993h = new LinkedList<>();
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: a */
    public int mo1877a(boolean z) {
        return m1921g(z);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: a */
    public SObject mo1878a(int i, boolean z) {
        return m1909b(i, z);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: a */
    public SObject mo1879a(int i, boolean z, boolean z2) {
        return m1910b(i, z, z2);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
    /* renamed from: a */
    public SObject mo1850a(int i) {
        return m1918f(i);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: b */
    public LinkedList<SObject> mo1885b(boolean z) {
        return m1919f(z);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a, com.samsung.spen.p005a.p011f.InterfaceC1095b
    /* renamed from: b */
    public int mo1854b(SObject sObject) {
        return m1916e(sObject);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
    /* renamed from: c */
    public boolean mo1858c(SObject sObject) {
        return m1920f(sObject);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
    /* renamed from: a */
    public int mo1849a(SObject sObject) {
        return m1904g(sObject);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: b */
    public boolean mo1887b(SObject sObject, SObject sObject2) {
        return m1912c(sObject, sObject2);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: a */
    public void mo1880a() {
        m1929l();
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: b */
    public void mo1886b() {
        m1926j();
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: a */
    public boolean mo1883a(LinkedList<SObject> linkedList) {
        return m1915d(linkedList);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: b */
    public int mo1884b(LinkedList<SObject> linkedList) {
        return m1903e(linkedList);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
    /* renamed from: a */
    public SObject mo1851a(int i, int i2) {
        return m1908b(i, i2);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
    /* renamed from: a */
    public int mo1848a(int i, int i2, SObject sObject) {
        return m1907b(i, i2, sObject);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
    /* renamed from: b */
    public LinkedList<SObject> mo1855b(int i) {
        return m1917e(i);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: c */
    public void mo1889c() {
        m1928k();
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
    /* renamed from: a */
    public boolean mo1853a(SObject sObject, SObject sObject2) {
        return m1913d(sObject, sObject2);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
    /* renamed from: c */
    public void mo1857c(int i) {
        m1922g(i);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
    /* renamed from: d */
    public void mo1859d(int i) {
        m1924h(i);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
    /* renamed from: a */
    public final SObject mo1852a(SObject sObject, boolean z) {
        return m1911c(sObject, z);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: d */
    public boolean mo1893d() {
        return m1931n();
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: c */
    public SObject mo1888c(boolean z) {
        return m1923h(z);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: d */
    public LinkedList<SObject> mo1891d(boolean z) {
        return m1925i(z);
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: e */
    public int mo1894e() {
        return m1932o();
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
    /* renamed from: b */
    public void mo1856b(SObject sObject, boolean z) {
        if (!z) {
            sObject.putTempData("SObjectVisibleKey", 0);
        } else {
            sObject.putTempData("SObjectVisibleKey", 1);
        }
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: f */
    public boolean mo1896f() {
        return m1933p();
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: g */
    public LinkedList<SObject> mo1897g() {
        return m1934q();
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: h */
    public int mo1898h() {
        return m1935r();
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: i */
    public void mo1899i() {
        m1936s();
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: e */
    public boolean mo1895e(boolean z) {
        return m1927j(z);
    }

    /* renamed from: f */
    public final LinkedList<SObject> m1919f(boolean z) {
        if (this.f1986a == null || this.f1986a.size() <= 0) {
            return null;
        }
        LinkedList<SObject> linkedList = new LinkedList<>();
        if (z) {
            Iterator<SObject> it = this.f1986a.iterator();
            while (it.hasNext()) {
                SObject next = it.next();
                if (next.getTempIntData("SObjectVisibleKey", 0) == 1) {
                    linkedList.add(next);
                }
            }
            return linkedList;
        }
        return this.f1986a;
    }

    /* renamed from: e */
    public final LinkedList<SObject> m1917e(int i) {
        if (i == 0) {
            if (this.f1987b == null || this.f1987b.size() <= 0) {
                return null;
            }
            LinkedList<SObject> linkedList = new LinkedList<>();
            Iterator<SObject> it = this.f1987b.iterator();
            while (it.hasNext()) {
                SObject next = it.next();
                if (next.getTempIntData("SObjectVisibleKey", 0) == 1 && next.getLayer() == i) {
                    linkedList.add(next.copyObject());
                }
            }
            return linkedList;
        }
        if (i != 1 || this.f1986a == null || this.f1986a.size() <= 0) {
            return null;
        }
        LinkedList<SObject> linkedList2 = new LinkedList<>();
        Iterator<SObject> it2 = this.f1986a.iterator();
        while (it2.hasNext()) {
            SObject next2 = it2.next();
            if (next2.getTempIntData("SObjectVisibleKey", 0) == 1 && next2.getLayer() == i) {
                linkedList2.add(next2.copyObject());
            }
        }
        return linkedList2;
    }

    /* renamed from: d */
    public boolean m1915d(LinkedList<SObject> linkedList) {
        this.f1986a = linkedList;
        Iterator<SObject> it = this.f1986a.iterator();
        while (it.hasNext()) {
            SObject next = it.next();
            next.putTempData("SObjectIDKey", this.f1988c);
            next.putTempData("SObjectVisibleKey", 0);
            this.f1988c++;
            if ((next instanceof SObjectImage) && next.getStyle() == 2) {
                int tempIntData = next.getTempIntData("SAMM___LIBRARY___IMAGE___ID___KEY", -1);
                if (tempIntData < 0) {
                    return false;
                }
                if (this.f1990e <= tempIntData) {
                    this.f1990e = tempIntData + 1;
                }
            }
        }
        return true;
    }

    /* renamed from: g */
    public int m1921g(boolean z) {
        LinkedList<SObject> linkedListM1919f;
        if (this.f1986a == null || (linkedListM1919f = m1919f(z)) == null) {
            return 0;
        }
        return linkedListM1919f.size();
    }

    /* renamed from: a */
    private boolean m1900a(SObject sObject, int i) {
        if (sObject == null || i < 0) {
            return false;
        }
        sObject.putTempData("SObjectIDKey", i);
        return true;
    }

    /* renamed from: b */
    private boolean m1901b(SObject sObject, int i) {
        if (sObject == null) {
            return false;
        }
        sObject.putTempData("SObjectMultiUserIDKey", i);
        return true;
    }

    /* renamed from: c */
    private boolean m1902c(SObject sObject, int i) {
        if (sObject == null) {
            return false;
        }
        sObject.putTempData("SObjectMultiObjectIDKey", i);
        return true;
    }

    /* renamed from: g */
    private int m1904g(SObject sObject) {
        if (sObject == null) {
            return -1;
        }
        return sObject.getTempIntData("SObjectIDKey", -1);
    }

    /* renamed from: h */
    private int m1905h(SObject sObject) {
        if (sObject == null) {
            return -1;
        }
        return sObject.getTempIntData("SObjectMultiUserIDKey", -1);
    }

    /* renamed from: i */
    private int m1906i(SObject sObject) {
        if (sObject == null) {
            return -1;
        }
        return sObject.getTempIntData("SObjectMultiObjectIDKey", -1);
    }

    /* renamed from: b */
    public final SObject m1909b(int i, boolean z) {
        return m1910b(i, z, false);
    }

    /* renamed from: b */
    SObject m1910b(int i, boolean z, boolean z2) {
        LinkedList<SObject> linkedListM1919f = m1919f(z);
        if (linkedListM1919f == null) {
            return null;
        }
        if (i < 0 || i >= linkedListM1919f.size()) {
            return null;
        }
        SObject sObject = linkedListM1919f.get(i);
        if (sObject == null) {
            return null;
        }
        if (z2) {
            return sObject.copyObject();
        }
        return sObject;
    }

    /* renamed from: f */
    public final SObject m1918f(int i) {
        if (this.f1986a == null) {
            return null;
        }
        if (this.f1986a.size() < 0) {
            Log.e("ObjectManager", "Invalid SObjectList(getSObject) ID " + i);
            return null;
        }
        Iterator<SObject> it = this.f1986a.iterator();
        while (it.hasNext()) {
            SObject next = it.next();
            if (m1904g(next) == i) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: b */
    public final SObject m1908b(int i, int i2) {
        if (this.f1987b == null) {
            return null;
        }
        if (this.f1987b.size() < 0) {
            Log.e("ObjectManager", "Invalid mMultiSObjectList(getSObject) MultiUserID " + i + "   nMultiStrokeID" + i2);
            return null;
        }
        Iterator<SObject> it = this.f1987b.iterator();
        while (it.hasNext()) {
            SObject next = it.next();
            int iM1905h = m1905h(next);
            int iM1906i = m1906i(next);
            if (iM1905h == i && iM1906i == i2) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: e */
    public int m1916e(SObject sObject) throws Throwable {
        if (this.f1986a == null) {
            this.f1986a = new LinkedList<>();
            this.f1988c = 0;
            this.f1990e = 0;
        }
        if (this.f1986a == null) {
            return -1;
        }
        if ((sObject instanceof SObjectImage) && sObject.getStyle() == 2) {
            sObject.putTempData("SAMM___LIBRARY___IMAGE___PATH___KEY", this.f1994i.mo602L());
            int iM295a = C0890d.m295a(sObject, this.f1986a, this.f1994i.mo603M(), this.f1994i.mo604N(), true, this.f1990e);
            if (iM295a < 0) {
                return -1;
            }
            if (iM295a == this.f1990e) {
                this.f1990e++;
            }
            sObject.putTempData("SAMM___LIBRARY___IMAGE___ID___KEY", iM295a);
        }
        int i = this.f1988c;
        sObject.putTempData("SObjectIDKey", i);
        sObject.putTempData("SObjectVisibleKey", 1);
        if (!this.f1986a.add(sObject)) {
            return -1;
        }
        this.f1988c++;
        return i;
    }

    /* renamed from: b */
    public int m1907b(int i, int i2, SObject sObject) {
        if (this.f1987b == null) {
            this.f1987b = new LinkedList<>();
            this.f1989d = 0;
        }
        if (this.f1987b == null) {
            return -1;
        }
        int i3 = this.f1989d;
        sObject.putTempData("SObjectIDKey", i3);
        sObject.putTempData("SObjectMultiUserIDKey", i);
        sObject.putTempData("SObjectMultiObjectIDKey", i2);
        sObject.putTempData("SObjectVisibleKey", 1);
        if (!this.f1987b.add(sObject)) {
            return -1;
        }
        this.f1989d++;
        return i3;
    }

    /* renamed from: j */
    public boolean m1926j() {
        if (this.f1986a == null) {
            return false;
        }
        int size = this.f1986a.size() - 1;
        if (size < 0) {
            Log.e("ObjectManager", "No SObject in SObjectList");
            return false;
        }
        this.f1986a.remove(size);
        return true;
    }

    /* renamed from: k */
    public boolean m1928k() {
        if (this.f1987b == null) {
            return false;
        }
        int size = this.f1987b.size() - 1;
        if (size < 0) {
            Log.e("ObjectManager", "No SObject in mMultiSObjectList");
            return false;
        }
        this.f1987b.remove(size);
        return true;
    }

    /* renamed from: f */
    public boolean m1920f(SObject sObject) {
        if (sObject.getLayer() == 0) {
            if (this.f1987b == null) {
                return false;
            }
            return this.f1987b.remove(sObject);
        }
        if (sObject.getLayer() != 1 || this.f1986a == null) {
            return false;
        }
        return this.f1986a.remove(sObject);
    }

    /* renamed from: g */
    public void m1922g(int i) {
        if (i == 0) {
            if (this.f1987b != null) {
                this.f1987b.clear();
            }
        } else if (i == 1 && this.f1986a != null) {
            this.f1986a.clear();
        }
    }

    /* renamed from: h */
    public void m1924h(int i) {
        if (i == 0) {
            if (this.f1987b != null) {
                Iterator<SObject> it = this.f1987b.iterator();
                while (it.hasNext()) {
                    it.next().putTempData("SObjectVisibleKey", 0);
                }
                return;
            }
            return;
        }
        if (i == 1 && this.f1986a != null) {
            Iterator<SObject> it2 = this.f1986a.iterator();
            while (it2.hasNext()) {
                it2.next().putTempData("SObjectVisibleKey", 0);
            }
        }
    }

    /* renamed from: c */
    public boolean m1912c(SObject sObject, SObject sObject2) {
        if (sObject == null || sObject2 == null) {
            return false;
        }
        int iM1904g = m1904g(sObject);
        if (iM1904g < 0) {
            return false;
        }
        int tempIntData = sObject.getTempIntData("SObjectVisibleKey", 0);
        if ((sObject2 instanceof SObjectStroke) && (sObject instanceof SObjectStroke)) {
            if (!((SObjectStroke) sObject).changeObject((SObjectStroke) sObject2)) {
                return false;
            }
        } else if ((sObject2 instanceof SObjectImage) && (sObject instanceof SObjectImage)) {
            if (!((SObjectImage) sObject).changeObject((SObjectImage) sObject2)) {
                return false;
            }
        } else if ((sObject2 instanceof SObjectText) && (sObject instanceof SObjectText)) {
            if (!((SObjectText) sObject).changeObject((SObjectText) sObject2)) {
                return false;
            }
        } else if ((sObject2 instanceof SObjectFilling) && (sObject instanceof SObjectFilling)) {
            if (!((SObjectFilling) sObject).changeObject((SObjectFilling) sObject2)) {
                return false;
            }
        } else {
            Log.e("ObjectManager", "changeSObject : Invalid Input SObject");
            return false;
        }
        if (sObject.putTempData("SObjectVisibleKey", tempIntData)) {
            return m1900a(sObject, iM1904g);
        }
        return false;
    }

    /* renamed from: d */
    public boolean m1913d(SObject sObject, SObject sObject2) {
        if (sObject == null || sObject2 == null) {
            return false;
        }
        int iM1904g = m1904g(sObject);
        int iM1905h = m1905h(sObject);
        int iM1906i = m1906i(sObject);
        int tempIntData = sObject.getTempIntData("SObjectVisibleKey", 0);
        if (iM1904g < 0) {
            return false;
        }
        if ((sObject2 instanceof SObjectStroke) && (sObject instanceof SObjectStroke)) {
            if (!((SObjectStroke) sObject).changeObject((SObjectStroke) sObject2)) {
                return false;
            }
        } else if ((sObject2 instanceof SObjectImage) && (sObject instanceof SObjectImage)) {
            if (!((SObjectImage) sObject).changeObject((SObjectImage) sObject2)) {
                return false;
            }
        } else if ((sObject2 instanceof SObjectText) && (sObject instanceof SObjectText)) {
            if (!((SObjectText) sObject).changeObject((SObjectText) sObject2)) {
                return false;
            }
        } else {
            Log.e("ObjectManager", "changeSObject : Invalid Input SObject");
            return false;
        }
        if (m1901b(sObject, iM1905h) && m1902c(sObject, iM1906i) && sObject.putTempData("SObjectVisibleKey", tempIntData)) {
            return m1900a(sObject, iM1904g);
        }
        return false;
    }

    /* renamed from: l */
    public void m1929l() {
        if (this.f1986a != null) {
            this.f1986a.clear();
        }
        if (this.f1987b != null) {
            this.f1987b.clear();
        }
        if (m1931n() && this.f1992g != null) {
            this.f1992g.clear();
        }
    }

    /* renamed from: e */
    public static int m1903e(LinkedList<SObject> linkedList) {
        if (linkedList == null) {
            return 0;
        }
        Iterator<SObject> it = linkedList.iterator();
        int i = 0;
        while (it.hasNext()) {
            SObject next = it.next();
            if (next instanceof SObjectStroke) {
                switch (i) {
                    case 0:
                        i = 1;
                        break;
                    case 1:
                        break;
                    default:
                        return 255;
                }
            } else if (next instanceof SObjectImage) {
                switch (i) {
                    case 0:
                        i = 3;
                        break;
                    case 1:
                    case 2:
                    default:
                        return 255;
                    case 3:
                        break;
                }
            } else if (next instanceof SObjectText) {
                switch (i) {
                    case 0:
                        i = 2;
                        break;
                    case 1:
                    default:
                        return 255;
                    case 2:
                        break;
                }
            } else {
                if (!(next instanceof SObjectFilling)) {
                    return 255;
                }
                switch (i) {
                    case 0:
                        i = 4;
                        break;
                    case 4:
                        break;
                    default:
                        return 255;
                }
            }
        }
        return i;
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: d */
    public void mo1892d(SObject sObject) {
        if (sObject != null) {
            int tempIntData = sObject.getTempIntData("SObjectIDKey", -1);
            if (sObject instanceof SObjectImage) {
                Log.i("ObjectManager", "SObject[" + tempIntData + "] SObjectImage : " + ((SObjectImage) sObject).getObjectInfo());
                return;
            }
            if (sObject instanceof SObjectText) {
                Log.i("ObjectManager", "SObject[" + tempIntData + "] SObjectText : " + ((SObjectText) sObject).getObjectInfo());
                return;
            }
            if (sObject instanceof SObjectStroke) {
                Log.i("ObjectManager", "SObject[" + tempIntData + "] SObjectStroke: " + ((SObjectStroke) sObject).getObjectInfo());
            } else if (sObject instanceof SObjectFilling) {
                Log.i("ObjectManager", "SObject[" + tempIntData + "] SObjectFilling: " + ((SObjectFilling) sObject).getObjectInfo());
            } else {
                Log.i("ObjectManager", "Unknown SObject");
            }
        }
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: c */
    public void mo1890c(LinkedList<SObject> linkedList) {
        if (linkedList != null) {
            StringBuffer stringBuffer = new StringBuffer("<root>");
            Iterator<SObject> it = linkedList.iterator();
            while (it.hasNext()) {
                SObject next = it.next();
                if (next != null) {
                    int tempIntData = next.getTempIntData("SObjectIDKey", -1);
                    boolean z = next.getTempIntData("SObjectVisibleKey", 0) == 1;
                    if (next instanceof SObjectImage) {
                        if (z) {
                            stringBuffer.append("--I" + tempIntData);
                        } else {
                            stringBuffer.append("--(I" + tempIntData + ")");
                        }
                    } else if (next instanceof SObjectText) {
                        if (z) {
                            stringBuffer.append("--T" + tempIntData);
                        } else {
                            stringBuffer.append("--(T" + tempIntData + ")");
                        }
                    } else if (next instanceof SObjectStroke) {
                        if (z) {
                            stringBuffer.append("--S" + tempIntData);
                        } else {
                            stringBuffer.append("--(S" + tempIntData + ")");
                        }
                    } else if (next instanceof SObjectFilling) {
                        if (z) {
                            stringBuffer.append("--F" + tempIntData);
                        } else {
                            stringBuffer.append("--(F" + tempIntData + ")");
                        }
                    } else if (z) {
                        stringBuffer.append("--U" + tempIntData);
                    } else {
                        stringBuffer.append("--(U" + tempIntData + ")");
                    }
                }
            }
            Log.i("ObjectManager", stringBuffer.toString());
            stringBuffer.delete(0, stringBuffer.length());
        }
    }

    /* renamed from: m */
    void m1930m() {
        this.f1995j.onUpdateSelectedObjectList();
    }

    /* renamed from: n */
    public boolean m1931n() {
        m1930m();
        return this.f1992g != null && this.f1992g.size() > 0;
    }

    /* renamed from: h */
    public SObject m1923h(boolean z) {
        m1930m();
        if (this.f1992g == null || this.f1992g.size() <= 0) {
            return null;
        }
        if (z) {
            return this.f1992g.get(0).copyObject();
        }
        return this.f1992g.get(0);
    }

    /* renamed from: i */
    public LinkedList<SObject> m1925i(boolean z) {
        m1930m();
        if (z) {
            LinkedList<SObject> linkedList = new LinkedList<>();
            Iterator<SObject> it = this.f1992g.iterator();
            while (it.hasNext()) {
                linkedList.add(it.next().copyObject());
            }
            return linkedList;
        }
        return this.f1992g;
    }

    /* renamed from: o */
    public int m1932o() {
        m1930m();
        return m1903e(this.f1992g);
    }

    /* renamed from: c */
    public final SObject m1911c(SObject sObject, boolean z) {
        boolean zRemove;
        if (this.f1992g == null) {
            this.f1992g = new LinkedList<>();
        }
        if (z) {
            this.f1992g.remove(sObject);
            zRemove = this.f1992g.add(sObject);
        } else {
            zRemove = this.f1992g.remove(sObject);
        }
        if (!zRemove) {
            return null;
        }
        return sObject;
    }

    /* renamed from: p */
    public boolean m1933p() {
        return this.f1991f != null && this.f1991f.size() > 0;
    }

    /* renamed from: q */
    public LinkedList<SObject> m1934q() {
        if (this.f1991f.size() <= 0) {
            return null;
        }
        return this.f1991f;
    }

    /* renamed from: r */
    public int m1935r() {
        return m1903e(this.f1991f);
    }

    /* renamed from: s */
    public void m1936s() {
        if (this.f1991f != null) {
            this.f1991f.clear();
        }
    }

    /* renamed from: d */
    public boolean m1914d(SObject sObject, boolean z) {
        if (this.f1991f == null) {
            this.f1991f = new LinkedList<>();
        }
        SObject sObjectCopyObject = sObject.copyObject();
        if (sObjectCopyObject == null) {
            return false;
        }
        if (z) {
            m1936s();
        }
        return this.f1991f.add(sObjectCopyObject);
    }

    /* renamed from: j */
    public boolean m1927j(boolean z) {
        if (!m1931n()) {
            Log.e("ObjectManager", "There is no selected object");
            return false;
        }
        if (z) {
            m1936s();
        }
        LinkedList<SObject> linkedListM1925i = m1925i(false);
        if (linkedListM1925i == null) {
            return false;
        }
        Iterator<SObject> it = linkedListM1925i.iterator();
        while (it.hasNext()) {
            if (!m1914d(it.next(), false)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: a */
    public void mo1881a(InterfaceC0904b interfaceC0904b) {
        this.f1994i = interfaceC0904b;
    }

    @Override // com.samsung.spen.p005a.p011f.InterfaceC1094a
    /* renamed from: a */
    public void mo1882a(InterfaceC1088f interfaceC1088f) {
        this.f1995j = interfaceC1088f;
    }
}
