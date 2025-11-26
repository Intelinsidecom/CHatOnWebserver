package com.samsung.samm.lib.p003a;

import android.graphics.PointF;
import android.util.Log;
import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectFilling;

/* renamed from: com.samsung.samm.lib.a.k */
/* loaded from: classes.dex */
public class C0897k extends AbstractC0896j {
    public C0897k() {
        m523a((AbstractC0896j) null);
        this.f603a = 4;
    }

    public C0897k(AbstractC0896j abstractC0896j, SObject sObject) {
        m523a(abstractC0896j);
        this.f603a = 4;
        this.f606d = sObject;
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: a */
    protected void mo521a() {
        super.mo521a();
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: g */
    public int mo534g() {
        return 8;
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: a */
    public int mo519a(byte[] bArr, int i) {
        int iB = m527b(bArr, i);
        if (iB == m533f()) {
            int i2 = i + iB;
            int[] iArr = new int[1];
            SObjectFilling sObjectFilling = (SObjectFilling) this.f606d;
            int iM581a = C0903q.m581a(bArr, i2, iArr);
            int i3 = iArr[0];
            if (i3 == 0) {
                return iM581a - i;
            }
            if (i3 < 0) {
                Log.e("SAMMLibraryCore", "SAMM Object Data is Invalid");
                return -1;
            }
            PointF pointF = new PointF();
            int iM593b = C0903q.m593b(bArr, iM581a, iArr);
            pointF.x = (short) iArr[0];
            int iM593b2 = C0903q.m593b(bArr, iM593b, iArr);
            pointF.y = (short) iArr[0];
            sObjectFilling.setFillPoint(pointF);
            return iM593b2 - i;
        }
        return iB;
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: a */
    public byte[] mo525a(int i, int i2) {
        mo521a();
        byte[] bArr = new byte[m532e()];
        int iA = m520a(bArr, 0, i, i2);
        if (iA != m533f()) {
            return null;
        }
        SObjectFilling sObjectFilling = (SObjectFilling) this.f606d;
        int iM579a = C0903q.m579a(bArr, iA, mo534g() - 4);
        PointF fillPoint = sObjectFilling.getFillPoint();
        if (fillPoint == null) {
            return null;
        }
        C0903q.m592b(bArr, C0903q.m592b(bArr, iM579a, ((int) fillPoint.x) + i), ((int) fillPoint.y) + i2);
        return bArr;
    }
}
