package com.samsung.samm.lib.p003a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.samsung.samm.lib.a.a */
/* loaded from: classes.dex */
public class C0887a {

    /* renamed from: a */
    private LinkedList<a> f443a = null;

    /* renamed from: b */
    private String f444b;

    /* renamed from: c */
    private String f445c;

    public C0887a(String str, String str2) {
        this.f444b = null;
        this.f445c = null;
        m229a();
        this.f444b = str;
        this.f445c = str2;
    }

    /* renamed from: a */
    public void m229a() {
        if (this.f443a != null) {
            Iterator<a> it = this.f443a.iterator();
            while (it.hasNext()) {
                C0903q.m599d(it.next().f450e);
            }
            this.f443a.clear();
            return;
        }
        this.f443a = new LinkedList<>();
    }

    /* renamed from: a */
    public boolean m233a(String str, String str2, Bitmap bitmap, int i) throws IOException {
        a aVar;
        boolean z;
        if (!C0903q.m601f(str)) {
            Log.e("SAMMLibraryCore", "Invalid Attach File Path");
            return false;
        }
        Iterator<a> it = this.f443a.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                z = true;
                break;
            }
            aVar = it.next();
            if (aVar.f448c.equals(str)) {
                z = false;
                break;
            }
        }
        if (z) {
            if (this.f443a.size() >= 20) {
                Log.e("SAMMLibraryCore", "Maximum number of attach file is 20");
                return false;
            }
            aVar = new a();
            this.f443a.add(aVar);
        }
        aVar.f448c = str;
        aVar.f447b = str2;
        aVar.f449d = new File(str).getName();
        aVar.f451f = i & 255;
        C0903q.m599d(aVar.f450e);
        if (bitmap != null) {
            aVar.f450e = m227b(this.f443a.indexOf(aVar), aVar.f449d);
            C0902p.m576a(aVar.f450e, bitmap);
        } else {
            aVar.f450e = null;
        }
        return true;
    }

    /* renamed from: a */
    public boolean m232a(String str) {
        if (str == null) {
            Log.e("SAMMLibraryCore", "Invalid Attach File Path");
            return false;
        }
        Iterator<a> it = this.f443a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            a next = it.next();
            if (next.f448c.compareTo(str) == 0) {
                C0903q.m599d(next.f450e);
                next.f448c = null;
                next.f447b = null;
                next.f449d = null;
                next.f450e = null;
                next.f451f = 0;
                this.f443a.remove(next);
                break;
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean m230a(int i) {
        if (i < 0 || i >= m234b()) {
            Log.e("SAMMLibraryCore", "Invalid Attach File Index : " + i);
            return false;
        }
        C0903q.m599d(this.f443a.get(i).f450e);
        this.f443a.remove(i);
        return true;
    }

    /* renamed from: b */
    public a m235b(int i) {
        if (i < 0 || i >= this.f443a.size()) {
            return null;
        }
        return this.f443a.get(i);
    }

    /* renamed from: b */
    public int m234b() {
        return this.f443a.size();
    }

    /* renamed from: a */
    public boolean m231a(RandomAccessFile randomAccessFile, boolean z) throws IOException {
        int iM597c = C0903q.m597c(randomAccessFile);
        for (int i = 0; i < iM597c; i++) {
            try {
                a aVar = new a();
                int iM591b = C0903q.m591b(randomAccessFile);
                if (z) {
                    long filePointer = randomAccessFile.getFilePointer();
                    int iM597c2 = C0903q.m597c(randomAccessFile);
                    if (iM597c2 > 0) {
                        char[] cArr = new char[iM597c2];
                        byte[] bArr = new byte[iM597c2 * 2];
                        int iM593b = 0;
                        int[] iArr = new int[1];
                        randomAccessFile.read(bArr);
                        for (int i2 = 0; i2 < iM597c2; i2++) {
                            iM593b = C0903q.m593b(bArr, iM593b, iArr);
                            cArr[i2] = (char) iArr[0];
                        }
                        aVar.f449d = String.copyValueOf(cArr);
                    }
                    int iM597c3 = C0903q.m597c(randomAccessFile);
                    if (iM597c3 > 0) {
                        char[] cArr2 = new char[iM597c3];
                        byte[] bArr2 = new byte[iM597c3 * 2];
                        int iM593b2 = 0;
                        int[] iArr2 = new int[1];
                        randomAccessFile.read(bArr2);
                        for (int i3 = 0; i3 < iM597c3; i3++) {
                            iM593b2 = C0903q.m593b(bArr2, iM593b2, iArr2);
                            cArr2[i3] = (char) iArr2[0];
                        }
                        aVar.f447b = String.copyValueOf(cArr2);
                    }
                    int iM591b2 = C0903q.m591b(randomAccessFile);
                    String strM226a = m226a(i, aVar.f449d);
                    aVar.f448c = strM226a;
                    if (!C0903q.m589a(randomAccessFile, strM226a, iM591b2)) {
                        return false;
                    }
                    int iM591b3 = C0903q.m591b(randomAccessFile);
                    if (iM591b3 > 0) {
                        String strM227b = m227b(i, aVar.f449d);
                        aVar.f450e = strM227b;
                        if (!C0903q.m589a(randomAccessFile, strM227b, iM591b3)) {
                            return false;
                        }
                    }
                    aVar.f451f = randomAccessFile.readUnsignedByte();
                    if (iM591b > ((int) (randomAccessFile.getFilePointer() - filePointer))) {
                        randomAccessFile.skipBytes(iM591b - ((int) (randomAccessFile.getFilePointer() - filePointer)));
                    }
                    this.f443a.add(aVar);
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
    public int m228a(RandomAccessFile randomAccessFile) throws Throwable {
        int length;
        int i = 0;
        try {
            C0903q.m595b(randomAccessFile, this.f443a.size());
            i = 2;
            Iterator<a> it = this.f443a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next.f448c == null || next.f449d == null) {
                    return -1;
                }
                int length2 = next.f449d.length();
                if (next.f447b == null) {
                    length = 0;
                } else {
                    length = next.f447b.length();
                }
                int iM600e = C0903q.m600e(next.f448c);
                if (iM600e < 0) {
                    return -1;
                }
                int iM600e2 = 0;
                if (next.f450e != null && (iM600e2 = C0903q.m600e(next.f450e)) < 0) {
                    return -1;
                }
                int i2 = iM600e2;
                byte[] bArr = new byte[(length2 * 2) + 2 + 2 + (length * 2)];
                long filePointer = randomAccessFile.getFilePointer();
                C0903q.m586a(randomAccessFile, 0);
                int i3 = i + 4;
                long filePointer2 = randomAccessFile.getFilePointer();
                int iM592b = C0903q.m592b(bArr, 0, length2);
                if (length2 > 0) {
                    char[] charArray = next.f449d.toCharArray();
                    int i4 = 0;
                    while (i4 < length2) {
                        int iM592b2 = C0903q.m592b(bArr, iM592b, charArray[i4]);
                        i4++;
                        iM592b = iM592b2;
                    }
                }
                int iM592b3 = C0903q.m592b(bArr, iM592b, length);
                if (length > 0) {
                    char[] charArray2 = next.f447b.toCharArray();
                    for (int i5 = 0; i5 < length; i5++) {
                        iM592b3 = C0903q.m592b(bArr, iM592b3, charArray2[i5]);
                    }
                }
                randomAccessFile.write(bArr);
                C0903q.m586a(randomAccessFile, iM600e);
                if (!C0903q.m596b(randomAccessFile, next.f448c, iM600e)) {
                    return -1;
                }
                C0903q.m586a(randomAccessFile, i2);
                if (next.f450e != null && !C0903q.m596b(randomAccessFile, next.f450e, i2)) {
                    return -1;
                }
                randomAccessFile.write(next.f451f);
                long filePointer3 = randomAccessFile.getFilePointer();
                int i6 = (int) (filePointer3 - filePointer2);
                randomAccessFile.seek(filePointer);
                C0903q.m586a(randomAccessFile, i6);
                randomAccessFile.seek(filePointer3);
                i = i3 + i6;
            }
            return i;
        } catch (FileNotFoundException e) {
            int i7 = i;
            Log.e("SAMMLibraryCore", "FileNotFoundException : " + e);
            e.printStackTrace();
            return i7;
        } catch (IOException e2) {
            int i8 = i;
            Log.e("SAMMLibraryCore", "IOException : " + e2);
            e2.printStackTrace();
            return i8;
        }
    }

    /* renamed from: a */
    private String m226a(int i, String str) {
        if (str == null) {
            return null;
        }
        int iLastIndexOf = str.lastIndexOf(".");
        if (iLastIndexOf > 0) {
            return String.valueOf(this.f444b) + this.f445c + str.substring(0, iLastIndexOf) + "(" + i + ")" + str.substring(iLastIndexOf, str.length());
        }
        return String.valueOf(this.f444b) + this.f445c + str + "(" + i + ")";
    }

    /* renamed from: b */
    private String m227b(int i, String str) {
        return str != null ? String.valueOf(this.f444b) + i + str + "_.png" : String.valueOf(this.f444b) + i + "_.png";
    }

    /* renamed from: com.samsung.samm.lib.a.a$a */
    public class a {

        /* renamed from: b */
        private String f447b;

        /* renamed from: c */
        private String f448c;

        /* renamed from: d */
        private String f449d;

        /* renamed from: e */
        private String f450e;

        /* renamed from: f */
        private int f451f;

        public a() {
            m244d();
        }

        /* renamed from: d */
        private void m244d() {
            this.f447b = null;
            this.f448c = null;
            this.f449d = null;
            this.f450e = null;
            this.f451f = 0;
        }

        /* renamed from: a */
        public String m247a() {
            return this.f448c;
        }

        /* renamed from: b */
        public String m248b() {
            return this.f447b;
        }

        /* renamed from: c */
        public Bitmap m249c() {
            if (this.f450e != null) {
                return BitmapFactory.decodeFile(this.f450e);
            }
            return null;
        }
    }
}
