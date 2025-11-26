package com.samsung.samm.lib.p003a;

import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* renamed from: com.samsung.samm.lib.a.o */
/* loaded from: classes.dex */
public class C0901o {

    /* renamed from: a */
    private a[] f615a;

    public C0901o() {
        m543a();
    }

    /* renamed from: a */
    public void m543a() {
        this.f615a = null;
        this.f615a = new a[10];
        for (int i = 0; i < 10; i++) {
            this.f615a[i] = new a();
        }
    }

    /* renamed from: a */
    public boolean m545a(String str, String str2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i8 > 10 || i7 < 0 || i7 >= i8) {
            Log.e("SAMMLibraryCore", "Invalid Page Index : " + i7);
            return false;
        }
        this.f615a[i7].f617b = str;
        if (this.f615a[i7].f617b != null && this.f615a[i7].f617b.length() <= 0) {
            this.f615a[i7].f617b = null;
        }
        this.f615a[i7].f618c = str2;
        this.f615a[i7].f619d = i & 255;
        this.f615a[i7].f620e = 65535 & i2;
        this.f615a[i7].f621f = i3;
        this.f615a[i7].f622g = i4;
        if (i5 == 0 || i5 == 1 || i5 == 2) {
            this.f615a[i7].f623h = i5;
        } else {
            this.f615a[i7].f623h = 0;
        }
        if (i6 == 0 || i6 == 1 || i6 == 2) {
            this.f615a[i7].f624i = i6;
            return true;
        }
        this.f615a[i7].f624i = 0;
        return true;
    }

    /* renamed from: a */
    public a m542a(int i, int i2) {
        if (i2 <= 10 && i >= 0 && i < i2) {
            return this.f615a[i];
        }
        Log.e("SAMMLibraryCore", "Invalid Page Index : " + i);
        return null;
    }

    /* renamed from: a */
    public boolean m544a(RandomAccessFile randomAccessFile, boolean z) throws IOException {
        int iM597c = C0903q.m597c(randomAccessFile);
        for (int i = 0; i < iM597c; i++) {
            try {
                int iM591b = C0903q.m591b(randomAccessFile);
                if (z) {
                    long filePointer = randomAccessFile.getFilePointer();
                    a aVar = this.f615a[C0903q.m597c(randomAccessFile)];
                    int iM591b2 = C0903q.m591b(randomAccessFile);
                    aVar.f617b = null;
                    if (iM591b2 > 0) {
                        char[] cArr = new char[iM591b2];
                        byte[] bArr = new byte[iM591b2 * 2];
                        int iM593b = 0;
                        int[] iArr = new int[1];
                        randomAccessFile.read(bArr);
                        for (int i2 = 0; i2 < iM591b2; i2++) {
                            iM593b = C0903q.m593b(bArr, iM593b, iArr);
                            cArr[i2] = (char) iArr[0];
                        }
                        aVar.f617b = String.copyValueOf(cArr);
                    }
                    int iM597c2 = C0903q.m597c(randomAccessFile);
                    aVar.f618c = null;
                    if (iM597c2 > 0) {
                        char[] cArr2 = new char[iM597c2];
                        byte[] bArr2 = new byte[iM597c2 * 2];
                        int iM593b2 = 0;
                        int[] iArr2 = new int[1];
                        randomAccessFile.read(bArr2);
                        for (int i3 = 0; i3 < iM597c2; i3++) {
                            iM593b2 = C0903q.m593b(bArr2, iM593b2, iArr2);
                            cArr2[i3] = (char) iArr2[0];
                        }
                        aVar.f618c = String.copyValueOf(cArr2);
                    }
                    byte[] bArr3 = new byte[11];
                    int[] iArr3 = new int[1];
                    randomAccessFile.read(bArr3);
                    aVar.f619d = bArr3[0] & 255;
                    int iM593b3 = C0903q.m593b(bArr3, 1, iArr3);
                    aVar.f620e = iArr3[0];
                    int i4 = 3;
                    while (i4 >= 0) {
                        aVar.f621f = ((bArr3[iM593b3] & 255) << (i4 * 8)) + aVar.f621f;
                        i4--;
                        iM593b3++;
                    }
                    int i5 = 3;
                    while (i5 >= 0) {
                        aVar.f622g = ((bArr3[iM593b3] & 255) << (i5 * 8)) + aVar.f622g;
                        i5--;
                        iM593b3++;
                    }
                    if (iM591b > ((int) (randomAccessFile.getFilePointer() - filePointer))) {
                        aVar.f623h = randomAccessFile.readUnsignedByte();
                        aVar.f624i = randomAccessFile.readUnsignedByte();
                        randomAccessFile.skipBytes(iM591b - ((int) (randomAccessFile.getFilePointer() - filePointer)));
                    }
                } else {
                    randomAccessFile.skipBytes(iM591b);
                }
            } catch (FileNotFoundException e) {
                Log.e("SAMMLibraryCore", "FileNotFoundException : " + e);
                e.printStackTrace();
            } catch (IOException e2) {
                Log.e("SAMMLibraryCore", "IOException : " + e2);
                e2.printStackTrace();
            }
        }
        return true;
    }

    /* renamed from: a */
    public int m541a(RandomAccessFile randomAccessFile) throws IOException {
        int filePointer;
        IOException e;
        FileNotFoundException e2;
        a aVar;
        int i;
        int length;
        int i2 = 0;
        try {
            C0903q.m595b(randomAccessFile, m546b());
            int i3 = -1;
            int i4 = 0;
            filePointer = 2;
            while (i4 < m546b()) {
                try {
                    int i5 = i3 + 1;
                    while (true) {
                        if (i5 >= this.f615a.length) {
                            aVar = null;
                            i = i3;
                            break;
                        }
                        if (this.f615a[i5].f617b == null) {
                            i5++;
                        } else {
                            aVar = this.f615a[i5];
                            i = i5;
                            break;
                        }
                    }
                    if (aVar == null) {
                        return -1;
                    }
                    int length2 = aVar.f617b.length();
                    if (aVar.f618c == null) {
                        length = 0;
                    } else {
                        length = aVar.f618c.length();
                    }
                    int i6 = (length2 * 2) + 6 + 2 + (length * 2) + 1 + 2 + 4 + 4 + 1 + 1;
                    byte[] bArr = new byte[i6];
                    C0903q.m586a(randomAccessFile, i6);
                    i2 = filePointer + 4;
                    long filePointer2 = randomAccessFile.getFilePointer();
                    int iM579a = C0903q.m579a(bArr, C0903q.m592b(bArr, 0, i), length2);
                    if (length2 > 0) {
                        char[] charArray = aVar.f617b.toCharArray();
                        int i7 = 0;
                        while (i7 < length2) {
                            int iM592b = C0903q.m592b(bArr, iM579a, charArray[i7]);
                            i7++;
                            iM579a = iM592b;
                        }
                    }
                    int iM592b2 = C0903q.m592b(bArr, iM579a, length);
                    if (length > 0) {
                        char[] charArray2 = aVar.f618c.toCharArray();
                        int i8 = 0;
                        while (i8 < length) {
                            int iM592b3 = C0903q.m592b(bArr, iM592b2, charArray2[i8]);
                            i8++;
                            iM592b2 = iM592b3;
                        }
                    }
                    bArr[iM592b2] = (byte) aVar.f619d;
                    int iM592b4 = C0903q.m592b(bArr, iM592b2 + 1, aVar.f620e);
                    int i9 = 3;
                    while (i9 >= 0) {
                        bArr[iM592b4] = (byte) ((aVar.f621f >> (i9 * 8)) & 255);
                        i9--;
                        iM592b4++;
                    }
                    int i10 = 3;
                    while (i10 >= 0) {
                        int i11 = iM592b4 + 1;
                        bArr[iM592b4] = (byte) ((aVar.f622g >> (i10 * 8)) & 255);
                        i10--;
                        iM592b4 = i11;
                    }
                    bArr[iM592b4] = (byte) aVar.f623h;
                    bArr[iM592b4 + 1] = (byte) aVar.f624i;
                    randomAccessFile.write(bArr);
                    i4++;
                    i3 = i;
                    filePointer = i2 + ((int) (randomAccessFile.getFilePointer() - filePointer2));
                } catch (FileNotFoundException e3) {
                    e2 = e3;
                    Log.e("SAMMLibraryCore", "FileNotFoundException : " + e2);
                    e2.printStackTrace();
                    return filePointer;
                } catch (IOException e4) {
                    e = e4;
                    Log.e("SAMMLibraryCore", "IOException : " + e);
                    e.printStackTrace();
                    return filePointer;
                }
            }
            return filePointer;
        } catch (FileNotFoundException e5) {
            filePointer = i2;
            e2 = e5;
        } catch (IOException e6) {
            filePointer = i2;
            e = e6;
        }
    }

    /* renamed from: b */
    public int m546b() {
        int i = 0;
        for (int i2 = 0; i2 < this.f615a.length; i2++) {
            if (this.f615a[i2].f617b != null) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: com.samsung.samm.lib.a.o$a */
    public class a {

        /* renamed from: b */
        private String f617b;

        /* renamed from: c */
        private String f618c;

        /* renamed from: d */
        private int f619d;

        /* renamed from: e */
        private int f620e;

        /* renamed from: f */
        private int f621f;

        /* renamed from: g */
        private int f622g;

        /* renamed from: h */
        private int f623h;

        /* renamed from: i */
        private int f624i;

        public a() {
            m563i();
        }

        /* renamed from: i */
        private void m563i() {
            this.f617b = null;
            this.f618c = null;
            this.f619d = 0;
            this.f620e = 10;
            this.f621f = -16777216;
            this.f622g = 0;
            this.f623h = 0;
            this.f624i = 0;
        }

        /* renamed from: a */
        public String m564a() {
            return this.f617b;
        }

        /* renamed from: b */
        public String m565b() {
            return this.f618c;
        }

        /* renamed from: c */
        public int m566c() {
            return this.f619d;
        }

        /* renamed from: d */
        public int m567d() {
            return this.f620e;
        }

        /* renamed from: e */
        public int m568e() {
            return this.f621f;
        }

        /* renamed from: f */
        public int m569f() {
            return this.f622g;
        }

        /* renamed from: g */
        public int m570g() {
            return this.f623h;
        }

        /* renamed from: h */
        public int m571h() {
            return this.f624i;
        }
    }
}
