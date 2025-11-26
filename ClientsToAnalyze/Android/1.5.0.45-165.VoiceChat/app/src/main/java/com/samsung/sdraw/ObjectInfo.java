package com.samsung.sdraw;

/* loaded from: classes.dex */
public abstract class ObjectInfo {

    /* renamed from: a */
    private int f1092a;

    /* renamed from: b */
    private int f1093b;

    /* renamed from: c */
    private int f1094c;

    /* renamed from: d */
    private int f1095d;

    public int getID() {
        return this.f1094c;
    }

    public void setID(int objectID) {
        this.f1094c = objectID;
    }

    public int getMultiUserID() {
        return this.f1093b;
    }

    public void setMultiUserID(int multiUserID) {
        this.f1093b = multiUserID;
    }

    public int getMultiObjectID() {
        return this.f1092a;
    }

    public void setMultiObjectID(int multiObjectID) {
        this.f1092a = multiObjectID;
    }

    public void setLayerID(int layerID) {
        if (layerID == 0 || layerID == 2) {
            this.f1095d = 0;
            return;
        }
        if (layerID == 3 || layerID == 4) {
            this.f1095d = 1;
        } else if (layerID != 0 && layerID != 1) {
            this.f1095d = 1;
        } else {
            this.f1095d = layerID;
        }
    }

    public int getLayerID() {
        return this.f1095d;
    }
}
