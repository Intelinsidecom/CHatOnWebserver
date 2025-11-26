package com.samsung.samm.common;

import android.graphics.RectF;
import android.util.Log;
import com.samsung.samm.lib.p003a.C0891e;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public abstract class SObject {
    public static final int SOBJECT_LIST_TYPE_FILLING = 4;
    public static final int SOBJECT_LIST_TYPE_IMAGE = 3;
    public static final int SOBJECT_LIST_TYPE_MIXED = 255;
    public static final int SOBJECT_LIST_TYPE_NONE = 0;
    public static final int SOBJECT_LIST_TYPE_STROKE = 1;
    public static final int SOBJECT_LIST_TYPE_TEXT = 2;
    protected C0891e mExtraDataSet;
    protected C0891e mTempDataSet;
    protected int mStyle = 0;
    protected int mColor = 0;
    protected float mSize = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    protected RectF mRect = null;
    protected int mPageIndex = 0;
    protected float mRotateAngle = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
    protected String mHyperText = null;
    protected String mDescription = null;
    protected int mLatitudeE6 = 0;
    protected int mLongitudeE6 = 0;
    protected boolean mRecordFlag = true;
    protected int mLayer = 1;
    protected int mTimeLineIndex = 0;
    protected int mRepeatFlag = 0;
    protected int mDurationFlag = 0;
    protected int mDurationTime = 0;
    protected int mAnimationEffect = 0;
    protected int mAdditionalID = 0;

    public abstract boolean changeObject(SObject sObject);

    public abstract SObject copyObject();

    public abstract String getObjectInfo();

    protected abstract boolean setStyle(int i);

    public SObject() {
        this.mExtraDataSet = null;
        this.mTempDataSet = null;
        this.mExtraDataSet = new C0891e();
        this.mTempDataSet = new C0891e();
    }

    public int getStyle() {
        return this.mStyle;
    }

    public int getColor() {
        return this.mColor;
    }

    public float getSize() {
        return this.mSize;
    }

    public RectF getRect() {
        return this.mRect;
    }

    /* renamed from: a */
    private int m149a() {
        return this.mPageIndex;
    }

    public float getRotateAngle() {
        return this.mRotateAngle;
    }

    public String getHyperText() {
        return this.mHyperText;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public Object getObjectData() {
        return this.mExtraDataSet;
    }

    public Object getTempObjectData() {
        return this.mTempDataSet;
    }

    public int getLatitude() {
        return this.mLatitudeE6;
    }

    public int getLongitude() {
        return this.mLongitudeE6;
    }

    public int getLayer() {
        return this.mLayer;
    }

    public void setColor(int i) {
        this.mColor = i;
    }

    public void setSize(float f) {
        if (f < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET || f > 255.0f) {
            Log.e("SAMMLibrary", "Invalid range of size 0.000~255.000 : " + f);
        } else {
            this.mSize = f;
        }
    }

    public void setRect(RectF rectF) {
        if (rectF == null) {
            Log.e("SAMMLibrary", "Parameter rect is null");
            return;
        }
        if (rectF.left < -32768.0f || rectF.left > 32767.0f || rectF.top < -32768.0f || rectF.top > 32767.0f || rectF.right < -32768.0f || rectF.right > 32767.0f || rectF.bottom < -32768.0f || rectF.bottom > 32767.0f) {
            Log.e("SAMMLibrary", "Invalid range of rect -32768.000~32767.000");
        } else {
            this.mRect = new RectF(rectF);
        }
    }

    /* renamed from: a */
    private void m150a(int i) {
        this.mPageIndex = i;
    }

    public void setRotateAngle(float f) {
        float f2 = f;
        while (f2 < -360.0f) {
            f2 += 360.0f;
        }
        while (f2 > 360.0f) {
            f2 -= 360.0f;
        }
        this.mRotateAngle = f2;
    }

    public void setHyperText(String str) {
        this.mHyperText = str;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public boolean setObjectData(Object obj) {
        if (obj == null) {
            this.mExtraDataSet = null;
            return true;
        }
        if (obj instanceof C0891e) {
            this.mExtraDataSet = (C0891e) obj;
            return true;
        }
        return false;
    }

    public void setLatitude(int i) {
        this.mLatitudeE6 = i;
    }

    public void setLongitude(int i) {
        this.mLongitudeE6 = i;
    }

    public void setLayer(int i) {
        this.mLayer = i;
    }

    public boolean putExtra(String str, String str2) {
        return this.mExtraDataSet.m397a(str, str2);
    }

    public String getStringExtra(String str, String str2) {
        return this.mExtraDataSet.m405b(str, str2);
    }

    public boolean clearStringExtra(String str) {
        return this.mExtraDataSet.m395a(str);
    }

    public boolean putExtra(String str, int i) {
        return this.mExtraDataSet.m396a(str, i);
    }

    public int getIntExtra(String str, int i) {
        return this.mExtraDataSet.m403b(str, i);
    }

    public boolean clearIntExtra(String str) {
        return this.mExtraDataSet.m407b(str);
    }

    public boolean putExtra(String str, boolean z) {
        return this.mExtraDataSet.m399a(str, z);
    }

    public boolean getBooleanExtra(String str, boolean z) {
        return this.mExtraDataSet.m408b(str, z);
    }

    public boolean clearBooleanExtra(String str) {
        return this.mExtraDataSet.m412c(str);
    }

    public boolean putExtra(String str, String[] strArr) {
        return this.mExtraDataSet.m401a(str, strArr);
    }

    public String[] getStringArrayExtra(String str, String[] strArr) {
        return this.mExtraDataSet.m410b(str, strArr);
    }

    public boolean clearStringArrayExtra(String str) {
        return this.mExtraDataSet.m414d(str);
    }

    public boolean putExtra(String str, byte[] bArr) {
        return this.mExtraDataSet.m400a(str, bArr);
    }

    public byte[] getByteArrayExtra(String str, byte[] bArr) {
        return this.mExtraDataSet.m409b(str, bArr);
    }

    public boolean clearByteArrayExtra(String str) {
        return this.mExtraDataSet.m415e(str);
    }

    public boolean putExtra(String str, short s) {
        return this.mExtraDataSet.m398a(str, s);
    }

    public short getShortExtra(String str, short s) {
        return this.mExtraDataSet.m406b(str, s);
    }

    public boolean clearShortExtra(String str) {
        return this.mExtraDataSet.m416f(str);
    }

    public boolean putTempData(String str, int i) {
        return this.mTempDataSet.m396a(str, i);
    }

    public int getTempIntData(String str, int i) {
        return this.mTempDataSet.m403b(str, i);
    }

    public boolean clearTempIntData(String str) {
        return this.mTempDataSet.m407b(str);
    }

    public boolean putTempData(String str, String str2) {
        return this.mTempDataSet.m397a(str, str2);
    }

    public String getTempStringExtra(String str, String str2) {
        return this.mTempDataSet.m405b(str, str2);
    }

    public boolean clearTempStringExtra(String str) {
        return this.mTempDataSet.m395a(str);
    }

    protected boolean copyObjectGeneral(SObject sObject) {
        sObject.setStyle(this.mStyle);
        sObject.setColor(this.mColor);
        sObject.setSize(this.mSize);
        sObject.setRect(this.mRect);
        sObject.m150a(this.mPageIndex);
        sObject.setRotateAngle(this.mRotateAngle);
        sObject.setHyperText(this.mHyperText);
        sObject.setDescription(this.mDescription);
        sObject.setLatitude(this.mLatitudeE6);
        sObject.setLongitude(this.mLongitudeE6);
        sObject.setLayer(this.mLayer);
        LinkedList<C0891e.a> linkedListM394a = this.mExtraDataSet.m394a();
        if (linkedListM394a != null) {
            Iterator<C0891e.a> it = linkedListM394a.iterator();
            while (it.hasNext()) {
                C0891e.a next = it.next();
                if (next instanceof C0891e.f) {
                    C0891e.f fVar = (C0891e.f) next;
                    sObject.putExtra(fVar.m417a(), fVar.m426b());
                } else if (next instanceof C0891e.d) {
                    C0891e.d dVar = (C0891e.d) next;
                    sObject.putExtra(dVar.m417a(), dVar.m423b());
                } else if (next instanceof C0891e.g) {
                    C0891e.g gVar = (C0891e.g) next;
                    sObject.putExtra(gVar.m417a(), gVar.m428b());
                } else if (next instanceof C0891e.b) {
                    C0891e.b bVar = (C0891e.b) next;
                    sObject.putExtra(bVar.m417a(), bVar.m419b());
                } else if (next instanceof C0891e.c) {
                    C0891e.c cVar = (C0891e.c) next;
                    sObject.putExtra(cVar.m417a(), cVar.m421b());
                }
            }
        }
        LinkedList<C0891e.a> linkedListM394a2 = this.mTempDataSet.m394a();
        if (linkedListM394a2 != null) {
            Iterator<C0891e.a> it2 = linkedListM394a2.iterator();
            while (it2.hasNext()) {
                C0891e.a next2 = it2.next();
                if (next2 instanceof C0891e.f) {
                    C0891e.f fVar2 = (C0891e.f) next2;
                    sObject.putExtra(fVar2.m417a(), fVar2.m426b());
                } else if (next2 instanceof C0891e.d) {
                    C0891e.d dVar2 = (C0891e.d) next2;
                    sObject.putTempData(dVar2.m417a(), dVar2.m423b());
                }
            }
            return true;
        }
        return true;
    }

    protected boolean changeObjectGeneral(SObject sObject) {
        LinkedList<C0891e.a> linkedListM394a;
        LinkedList<C0891e.a> linkedListM394a2;
        if (sObject == null) {
            return false;
        }
        setStyle(sObject.getStyle());
        setColor(sObject.getColor());
        setSize(sObject.getSize());
        setRect(sObject.getRect());
        setLayer(sObject.getLayer());
        m150a(sObject.m149a());
        setRotateAngle(sObject.getRotateAngle());
        setHyperText(sObject.getHyperText());
        setDescription(sObject.getDescription());
        setLatitude(sObject.getLatitude());
        setLongitude(sObject.getLongitude());
        C0891e c0891e = (C0891e) sObject.getObjectData();
        this.mExtraDataSet.m413d();
        if (c0891e != null && (linkedListM394a2 = c0891e.m394a()) != null) {
            Iterator<C0891e.a> it = linkedListM394a2.iterator();
            while (it.hasNext()) {
                C0891e.a next = it.next();
                if (next instanceof C0891e.f) {
                    C0891e.f fVar = (C0891e.f) next;
                    putExtra(fVar.m417a(), fVar.m426b());
                } else if (next instanceof C0891e.d) {
                    C0891e.d dVar = (C0891e.d) next;
                    putExtra(dVar.m417a(), dVar.m423b());
                } else if (next instanceof C0891e.g) {
                    C0891e.g gVar = (C0891e.g) next;
                    putExtra(gVar.m417a(), gVar.m428b());
                } else if (next instanceof C0891e.b) {
                    C0891e.b bVar = (C0891e.b) next;
                    putExtra(bVar.m417a(), bVar.m419b());
                } else if (next instanceof C0891e.c) {
                    C0891e.c cVar = (C0891e.c) next;
                    putExtra(cVar.m417a(), cVar.m421b());
                }
            }
        }
        C0891e c0891e2 = (C0891e) sObject.getTempObjectData();
        this.mTempDataSet.m413d();
        if (c0891e2 != null && (linkedListM394a = c0891e2.m394a()) != null) {
            Iterator<C0891e.a> it2 = linkedListM394a.iterator();
            while (it2.hasNext()) {
                C0891e.a next2 = it2.next();
                if (next2 instanceof C0891e.f) {
                    C0891e.f fVar2 = (C0891e.f) next2;
                    putExtra(fVar2.m417a(), fVar2.m426b());
                } else if (next2 instanceof C0891e.d) {
                    C0891e.d dVar2 = (C0891e.d) next2;
                    putTempData(dVar2.m417a(), dVar2.m423b());
                }
            }
        }
        return true;
    }
}
