package com.samsung.samm.lib.p003a;

import android.graphics.RectF;
import android.util.Log;
import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectImage;

/* renamed from: com.samsung.samm.lib.a.l */
/* loaded from: classes.dex */
public class C0898l extends AbstractC0896j {
    public C0898l() {
        m523a((AbstractC0896j) null);
        this.f603a = 3;
    }

    public C0898l(AbstractC0896j abstractC0896j, SObject sObject) {
        m523a(abstractC0896j);
        this.f603a = 3;
        this.f606d = sObject;
    }

    /* renamed from: a */
    public boolean m535a(RectF rectF, int i) {
        if (rectF == null || !m524a(rectF)) {
            return false;
        }
        m528b(2);
        m530c(i);
        return true;
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: a */
    protected void mo521a() {
        super.mo521a();
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: g */
    public int mo534g() {
        return 4;
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: a */
    public int mo519a(byte[] bArr, int i) {
        int iB = m527b(bArr, i);
        if (iB == m533f()) {
            int i2 = i + iB;
            int[] iArr = new int[1];
            SObjectImage sObjectImage = (SObjectImage) this.f606d;
            if (sObjectImage.getStyle() == 2) {
                sObjectImage.putTempData("SAMM___LIBRARY___IMAGE___ID___KEY", this.f604b);
            }
            int iM581a = C0903q.m581a(bArr, i2, iArr);
            int i3 = iArr[0];
            if (i3 == 0) {
                return iM581a - i;
            }
            if (i3 < 0) {
                Log.e("SAMMLibraryCore", "SAMM Object Data is Invalid");
                return -1;
            }
            return iM581a - i;
        }
        return iB;
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: a */
    public byte[] mo525a(int i, int i2) {
        int tempIntData;
        SObjectImage sObjectImage = (SObjectImage) this.f606d;
        if (sObjectImage.getStyle() != 2 || ((tempIntData = sObjectImage.getTempIntData("SAMM___LIBRARY___IMAGE___ID___KEY", -1)) >= 0 && m535a(sObjectImage.getRect(), tempIntData))) {
            mo521a();
            byte[] bArr = new byte[m532e()];
            int iA = m520a(bArr, 0, i, i2);
            if (iA != m533f()) {
                return null;
            }
            C0903q.m579a(bArr, iA, mo534g() - 4);
            return bArr;
        }
        return null;
    }
}
