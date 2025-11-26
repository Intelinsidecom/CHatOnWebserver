package com.sec.amsoma.structure;

import android.graphics.Bitmap;
import android.support.v4.view.MotionEventCompat;

/* loaded from: classes.dex */
public class AMS_UI_DATA {
    public Bitmap m_Bitmap;
    public boolean m_bStart;
    public byte m_cObjectSize;
    public byte m_cObjectStyle;
    public byte m_eObjectType;
    public AMS_RECT m_rectRegion = new AMS_RECT();
    public int m_rgbBack;
    public int m_rgbPen;

    public void Init() {
        this.m_eObjectType = (byte) 1;
        this.m_cObjectStyle = (byte) 0;
        this.m_cObjectSize = (byte) 2;
        this.m_rgbPen = MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.m_rgbBack = 0;
        this.m_rectRegion.setnLeft((short) 0);
        this.m_rectRegion.setnTop((short) 0);
        this.m_rectRegion.setnRight((short) 0);
        this.m_rectRegion.setnBottom((short) 0);
        this.m_bStart = false;
    }

    public void SetRect(short s, short s2, short s3, short s4) {
        this.m_rectRegion.setnLeft(s);
        this.m_rectRegion.setnTop(s2);
        this.m_rectRegion.setnRight(s3);
        this.m_rectRegion.setnBottom(s4);
    }
}
