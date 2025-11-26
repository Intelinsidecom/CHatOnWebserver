package com.samsung.samm.lib.p003a;

import android.graphics.RectF;
import android.util.Log;
import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectText;

/* renamed from: com.samsung.samm.lib.a.n */
/* loaded from: classes.dex */
public class C0900n extends AbstractC0896j {

    /* renamed from: f */
    private int f614f = 0;

    public C0900n() {
        m523a((AbstractC0896j) null);
        this.f603a = 2;
    }

    public C0900n(AbstractC0896j abstractC0896j, SObject sObject) {
        m523a(abstractC0896j);
        this.f603a = 2;
        this.f606d = sObject;
    }

    /* renamed from: a */
    private boolean m537a(String str, String str2, RectF rectF) {
        if (m536a(str)) {
            return (str2 == null || m538b(str2)) && m524a(rectF);
        }
        return false;
    }

    /* renamed from: a */
    private boolean m536a(String str) {
        return str != null && str.length() > 0 && str.length() <= 128;
    }

    /* renamed from: b */
    private boolean m538b(String str) {
        return str != null && str.length() > 0 && str.length() <= 128;
    }

    /* renamed from: h */
    private int m539h() {
        String text;
        if (this.f606d != null && (text = ((SObjectText) this.f606d).getText()) != null) {
            return text.length();
        }
        return 0;
    }

    /* renamed from: i */
    private int m540i() {
        String fontName;
        if (this.f606d != null && (fontName = ((SObjectText) this.f606d).getFontName()) != null) {
            return fontName.length();
        }
        return 0;
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: a */
    protected void mo521a() {
        super.mo521a();
        this.f614f |= 1;
        this.f614f |= 2;
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: g */
    public int mo534g() {
        int i = (this.f614f & 1) != 0 ? 4 : 0;
        if ((this.f614f & 2) != 0) {
            i += 2;
        }
        return i + ((m539h() + m540i()) * 2) + 8;
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: a */
    public int mo519a(byte[] bArr, int i) {
        int i2;
        int i3 = 0;
        int iB = m527b(bArr, i);
        if (iB == m533f()) {
            int i4 = i + iB;
            int[] iArr = new int[1];
            SObjectText sObjectText = (SObjectText) this.f606d;
            int iM581a = C0903q.m581a(bArr, i4, iArr);
            int i5 = iArr[0];
            if (i5 == 0) {
                return iM581a - i;
            }
            if (i5 < 0) {
                Log.e("SAMMLibraryCore", "SAMM Object Data is Invalid");
                return -1;
            }
            int i6 = iM581a + i5;
            int iM593b = C0903q.m593b(bArr, iM581a, iArr);
            int i7 = iArr[0];
            if (i7 <= 0) {
                return -1;
            }
            char[] cArr = new char[i7];
            int i8 = iM593b;
            int i9 = 0;
            while (i9 < i7 && i8 < i6) {
                int iM593b2 = C0903q.m593b(bArr, i8, iArr);
                cArr[i9] = (char) iArr[0];
                i9++;
                i8 = iM593b2;
            }
            sObjectText.setText(String.copyValueOf(cArr));
            if (i8 < i6) {
                int iM593b3 = C0903q.m593b(bArr, i8, iArr);
                i2 = iArr[0];
                i8 = iM593b3;
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                char[] cArr2 = new char[i2];
                int i10 = 0;
                while (i10 < i2 && i8 < i6) {
                    int iM593b4 = C0903q.m593b(bArr, i8, iArr);
                    cArr2[i10] = (char) iArr[0];
                    i10++;
                    i8 = iM593b4;
                }
                sObjectText.setFontName(String.copyValueOf(cArr2));
            }
            this.f614f = 0;
            if (i8 < i6) {
                int i11 = 0;
                while (i3 < 4) {
                    i11 = (i11 << 8) + (bArr[i8] & 255);
                    i3++;
                    i8++;
                }
                sObjectText.setBGColor(i11);
                this.f614f |= 1;
                if (i8 < i6) {
                    int i12 = i8 + 1;
                    int i13 = bArr[i8] & 255;
                    i8 = i12 + 1;
                    sObjectText.setTextAlign(i13, bArr[i12] & 255);
                    this.f614f |= 2;
                }
            }
            return i8 - i;
        }
        return iB;
    }

    @Override // com.samsung.samm.lib.p003a.AbstractC0896j
    /* renamed from: a */
    public byte[] mo525a(int i, int i2) {
        int i3 = 0;
        SObjectText sObjectText = (SObjectText) this.f606d;
        if (!m537a(sObjectText.getText(), sObjectText.getFontName(), sObjectText.getRect())) {
            return null;
        }
        mo521a();
        byte[] bArr = new byte[m532e()];
        int iA = m520a(bArr, 0, i, i2);
        if (iA != m533f()) {
            return null;
        }
        int iM579a = C0903q.m579a(bArr, iA, mo534g() - 4);
        int iM539h = m539h();
        int iM592b = C0903q.m592b(bArr, iM579a, iM539h);
        if (iM539h > 0) {
            char[] charArray = sObjectText.getText().toCharArray();
            int i4 = 0;
            while (i4 < iM539h) {
                int iM592b2 = C0903q.m592b(bArr, iM592b, charArray[i4]);
                i4++;
                iM592b = iM592b2;
            }
        }
        int iM540i = m540i();
        int iM592b3 = C0903q.m592b(bArr, iM592b, iM540i);
        if (iM540i > 0) {
            char[] charArray2 = sObjectText.getFontName().toCharArray();
            while (i3 < iM540i) {
                int iM592b4 = C0903q.m592b(bArr, iM592b3, charArray2[i3]);
                i3++;
                iM592b3 = iM592b4;
            }
        }
        int bGColor = sObjectText.getBGColor();
        int i5 = iM592b3;
        int i6 = 24;
        while (i6 >= 0) {
            bArr[i5] = (byte) ((bGColor >> i6) & 255);
            i6 -= 8;
            i5++;
        }
        bArr[i5] = (byte) sObjectText.getHorizTextAlign();
        bArr[i5 + 1] = (byte) sObjectText.getVertTextAlign();
        return bArr;
    }
}
