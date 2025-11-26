package com.samsung.samm.lib.p003a;

import android.graphics.PointF;
import android.util.Log;
import com.google.protobuf.CodedOutputStream;
import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectStroke;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* renamed from: com.samsung.samm.lib.a.m */
/* loaded from: classes.dex */
public class C0899m extends AbstractC0896j {

    /* renamed from: f */
    private int f613f = 0;

    public C0899m() {
        m523a((AbstractC0896j) null);
        m522a(1);
    }

    public C0899m(AbstractC0896j abstractC0896j, SObject sObject) {
        m523a(abstractC0896j);
        this.f603a = 1;
        this.f606d = sObject;
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: a */
    protected void mo521a() {
        super.mo521a();
        this.f613f |= 1;
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: g */
    public int mo534g() {
        return (((SObjectStroke) this.f606d).getPressureNum() * 2) + (((SObjectStroke) this.f606d).getPointNum() * 2 * 2) + 6 + ((this.f613f & 1) != 0 ? 2 : 0);
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: a */
    public int mo519a(byte[] bArr, int i) {
        int iM593b;
        float f;
        int iB = m527b(bArr, i);
        if (iB == m533f()) {
            int i2 = i + iB;
            int[] iArr = new int[1];
            SObjectStroke sObjectStroke = (SObjectStroke) this.f606d;
            int iM581a = C0903q.m581a(bArr, i2, iArr);
            int i3 = iArr[0];
            if (i3 == 0) {
                return iM581a - i;
            }
            if (i3 < 0) {
                Log.e("SAMMLibraryCore", "SAMM Object Data is Invalid");
                return -1;
            }
            int i4 = iM581a + i3;
            int iM593b2 = C0903q.m593b(bArr, iM581a, iArr);
            int i5 = iArr[0];
            if (i5 > 0) {
                PointF[] pointFArr = new PointF[i5];
                int i6 = 0;
                while (i6 < i5 && iM593b2 < i4) {
                    pointFArr[i6] = new PointF();
                    int iM593b3 = C0903q.m593b(bArr, iM593b2, iArr);
                    pointFArr[i6].x = (short) iArr[0];
                    int iM593b4 = C0903q.m593b(bArr, iM593b3, iArr);
                    pointFArr[i6].y = (short) iArr[0];
                    i6++;
                    iM593b2 = iM593b4;
                }
                sObjectStroke.setPoints(pointFArr);
                float[] fArr = new float[i5];
                int i7 = 0;
                boolean z = false;
                while (i7 < i5) {
                    if (iM593b2 < i4) {
                        iM593b = C0903q.m593b(bArr, iM593b2, iArr);
                        f = iArr[0] / 4096.0f;
                        if (f > VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                            z = true;
                        }
                    } else {
                        iM593b = iM593b2;
                        f = 1.0f;
                    }
                    fArr[i7] = f;
                    i7++;
                    iM593b2 = iM593b;
                }
                if (!z) {
                    for (int i8 = 0; i8 < fArr.length; i8++) {
                        fArr[i8] = 1.0f;
                    }
                }
                sObjectStroke.setPressures(fArr);
            }
            this.f613f = 0;
            if (iM593b2 < i4) {
                iM593b2 = C0903q.m593b(bArr, iM593b2, iArr);
                sObjectStroke.setMetaData(iArr[0]);
                this.f613f |= 1;
            }
            return iM593b2 - i;
        }
        return iB;
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: a */
    public byte[] mo525a(int i, int i2) {
        int i3;
        mo521a();
        byte[] bArr = new byte[m532e()];
        int iA = m520a(bArr, 0, i, i2);
        if (iA != m533f()) {
            return null;
        }
        int iM579a = C0903q.m579a(bArr, iA, mo534g() - 4);
        SObjectStroke sObjectStroke = (SObjectStroke) this.f606d;
        int pointNum = sObjectStroke.getPointNum();
        int iM592b = C0903q.m592b(bArr, iM579a, pointNum);
        if (pointNum > 0) {
            PointF[] points = sObjectStroke.getPoints();
            if (points == null) {
                return null;
            }
            if (i == 0 && i2 == 0) {
                int i4 = 0;
                while (i4 < pointNum) {
                    int iM592b2 = C0903q.m592b(bArr, C0903q.m592b(bArr, iM592b, (int) points[i4].x), (int) points[i4].y);
                    i4++;
                    iM592b = iM592b2;
                }
            } else {
                int i5 = 0;
                while (i5 < pointNum) {
                    int iM592b3 = C0903q.m592b(bArr, C0903q.m592b(bArr, iM592b, ((int) points[i5].x) + i), ((int) points[i5].y) + i2);
                    i5++;
                    iM592b = iM592b3;
                }
            }
            int pressureNum = sObjectStroke.getPressureNum();
            if (pressureNum != pointNum) {
                Log.w("SAMMLibraryCore", "Number of points and pressures are diffent!");
            }
            float[] pressures = sObjectStroke.getPressures();
            int iM592b4 = iM592b;
            for (int i6 = 0; i6 < pointNum; i6++) {
                if (pressures != null && pressureNum > 0 && i6 < pressureNum) {
                    i3 = (int) (pressures[i6] * 4096.0f);
                } else {
                    i3 = CodedOutputStream.DEFAULT_BUFFER_SIZE;
                }
                iM592b4 = C0903q.m592b(bArr, iM592b4, i3);
            }
            iM592b = iM592b4;
        }
        C0903q.m592b(bArr, iM592b, sObjectStroke.getMetaData());
        return bArr;
    }
}
