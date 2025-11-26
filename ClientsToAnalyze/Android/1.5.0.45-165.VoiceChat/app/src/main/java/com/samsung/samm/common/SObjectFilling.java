package com.samsung.samm.common;

import android.graphics.PointF;
import android.util.Log;
import com.samsung.samm.lib.p003a.C0897k;

/* loaded from: classes.dex */
public class SObjectFilling extends SObject {
    public static final byte SAMM_FILLING_STYLE_COLOR = 0;

    /* renamed from: a */
    private PointF f409a;

    public SObjectFilling() {
        this.mColor = -16777216;
        this.mStyle = 0;
        this.f409a = new PointF();
    }

    @Override // com.samsung.samm.common.SObject
    public boolean setStyle(int i) {
        if (i == 0) {
            this.mStyle = i;
            return true;
        }
        Log.e("SAMMLibrary", "Undefined filling Style : " + i);
        return false;
    }

    public PointF getFillPoint() {
        return new PointF(this.f409a.x, this.f409a.y);
    }

    public void setFillPoint(PointF pointF) {
        this.f409a.x = pointF.x;
        this.f409a.y = pointF.y;
    }

    @Override // com.samsung.samm.common.SObject
    public SObject copyObject() {
        SObjectFilling sObjectFilling = new SObjectFilling();
        copyObjectGeneral(sObjectFilling);
        sObjectFilling.setFillPoint(getFillPoint());
        return sObjectFilling;
    }

    @Override // com.samsung.samm.common.SObject
    public boolean changeObject(SObject sObject) {
        if (!super.changeObjectGeneral(sObject)) {
            return false;
        }
        setFillPoint(((SObjectFilling) sObject).getFillPoint());
        return true;
    }

    @Override // com.samsung.samm.common.SObject
    public String getObjectInfo() {
        return "Filling coordinates = (" + this.f409a.x + ", " + this.f409a.y + ")";
    }

    protected byte[] getObjectDataBuf() {
        return new C0897k(null, (SObjectFilling) copyObject()).mo525a(0, 0);
    }

    protected boolean setObjectDataBuf(byte[] bArr) {
        SObjectFilling sObjectFilling = (SObjectFilling) copyObject();
        C0897k c0897k = new C0897k(null, sObjectFilling);
        if (c0897k.mo519a(bArr, 0) != c0897k.m532e()) {
            return false;
        }
        return changeObject(sObjectFilling);
    }
}
