package com.samsung.samm.lib.p003a;

import android.util.Log;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.samsung.samm.lib.a.e */
/* loaded from: classes.dex */
public class C0891e {

    /* renamed from: a */
    private LinkedList<a> f536a = null;

    /* renamed from: com.samsung.samm.lib.a.e$a */
    public abstract class a {

        /* renamed from: a */
        protected String f537a = null;

        public a() {
        }

        /* renamed from: a */
        public String m417a() {
            return this.f537a;
        }
    }

    /* renamed from: com.samsung.samm.lib.a.e$f */
    public class f extends a {

        /* renamed from: d */
        private String f548d;

        public f(String str, String str2) {
            super();
            this.f537a = str;
            this.f548d = str2;
        }

        /* renamed from: b */
        public String m426b() {
            return this.f548d;
        }
    }

    /* renamed from: com.samsung.samm.lib.a.e$d */
    public class d extends a {

        /* renamed from: d */
        private int f544d;

        public d(String str, int i) {
            super();
            this.f537a = str;
            this.f544d = i;
        }

        /* renamed from: b */
        public int m423b() {
            return this.f544d;
        }
    }

    /* renamed from: com.samsung.samm.lib.a.e$g */
    public class g extends a {

        /* renamed from: d */
        private String[] f550d;

        public g(String str, String[] strArr) {
            super();
            this.f537a = str;
            if (strArr == null || strArr.length <= 0) {
                this.f550d = null;
                return;
            }
            this.f550d = new String[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                this.f550d[i] = strArr[i];
            }
        }

        /* renamed from: b */
        public String[] m428b() {
            if (this.f550d == null || this.f550d.length <= 0) {
                return null;
            }
            String[] strArr = new String[this.f550d.length];
            for (int i = 0; i < this.f550d.length; i++) {
                strArr[i] = this.f550d[i];
            }
            return strArr;
        }
    }

    /* renamed from: com.samsung.samm.lib.a.e$b */
    public class b extends a {

        /* renamed from: d */
        private boolean f540d;

        public b(String str, boolean z) {
            super();
            this.f537a = str;
            this.f540d = z;
        }

        /* renamed from: b */
        public boolean m419b() {
            return this.f540d;
        }
    }

    /* renamed from: com.samsung.samm.lib.a.e$c */
    public class c extends a {

        /* renamed from: d */
        private byte[] f542d;

        public c(String str, byte[] bArr) {
            super();
            this.f537a = str;
            if (bArr == null || bArr.length <= 0) {
                this.f542d = null;
                return;
            }
            this.f542d = new byte[bArr.length];
            for (int i = 0; i < bArr.length; i++) {
                this.f542d[i] = bArr[i];
            }
        }

        /* renamed from: b */
        public byte[] m421b() {
            if (this.f542d == null || this.f542d.length <= 0) {
                return null;
            }
            byte[] bArr = new byte[this.f542d.length];
            for (int i = 0; i < this.f542d.length; i++) {
                bArr[i] = this.f542d[i];
            }
            return bArr;
        }
    }

    /* renamed from: com.samsung.samm.lib.a.e$e */
    public class e extends a {

        /* renamed from: d */
        private short f546d;

        public e(String str, Short sh) {
            super();
            this.f537a = str;
            this.f546d = sh.shortValue();
        }
    }

    /* renamed from: a */
    public boolean m397a(String str, String str2) {
        int i = 0;
        if (str == null || str2 == null) {
            return false;
        }
        if (this.f536a == null) {
            this.f536a = new LinkedList<>();
        }
        Iterator<a> it = this.f536a.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a next = it.next();
                if ((next instanceof f) && next.f537a.equals(str)) {
                    this.f536a.set(i2, new f(str, str2));
                    return true;
                }
                i = i2 + 1;
            } else {
                return this.f536a.add(new f(str, str2));
            }
        }
    }

    /* renamed from: b */
    public String m405b(String str, String str2) {
        if (str != null && this.f536a != null) {
            Iterator<a> it = this.f536a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if ((next instanceof f) && next.f537a.equals(str)) {
                    return ((f) next).f548d;
                }
            }
            return str2;
        }
        return str2;
    }

    /* renamed from: a */
    public boolean m395a(String str) {
        if (str == null) {
            Log.e("SAMMLibraryCore", "keyName is null");
            return false;
        }
        if (this.f536a == null) {
            Log.e("SAMMLibraryCore", "There is no item");
            return false;
        }
        Iterator<a> it = this.f536a.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if ((next instanceof f) && next.f537a.equals(str)) {
                return this.f536a.remove(i) != null;
            }
            i++;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m396a(String str, int i) {
        int i2 = 0;
        if (str == null) {
            return false;
        }
        if (this.f536a == null) {
            this.f536a = new LinkedList<>();
        }
        Iterator<a> it = this.f536a.iterator();
        while (true) {
            int i3 = i2;
            if (it.hasNext()) {
                a next = it.next();
                if ((next instanceof d) && next.f537a.equals(str)) {
                    this.f536a.set(i3, new d(str, i));
                    return true;
                }
                i2 = i3 + 1;
            } else {
                return this.f536a.add(new d(str, i));
            }
        }
    }

    /* renamed from: b */
    public int m403b(String str, int i) {
        if (str != null && this.f536a != null) {
            Iterator<a> it = this.f536a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if ((next instanceof d) && next.f537a.equals(str)) {
                    return ((d) next).f544d;
                }
            }
            return i;
        }
        return i;
    }

    /* renamed from: b */
    public boolean m407b(String str) {
        if (str == null) {
            Log.e("SAMMLibraryCore", "keyName is null");
            return false;
        }
        if (this.f536a == null) {
            Log.e("SAMMLibraryCore", "There is no item");
            return false;
        }
        Iterator<a> it = this.f536a.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if ((next instanceof d) && next.f537a.equals(str)) {
                return this.f536a.remove(i) != null;
            }
            i++;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m399a(String str, boolean z) {
        int i = 0;
        if (str == null) {
            return false;
        }
        if (this.f536a == null) {
            this.f536a = new LinkedList<>();
        }
        Iterator<a> it = this.f536a.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a next = it.next();
                if ((next instanceof b) && next.f537a.equals(str)) {
                    this.f536a.set(i2, new b(str, z));
                    return true;
                }
                i = i2 + 1;
            } else {
                return this.f536a.add(new b(str, z));
            }
        }
    }

    /* renamed from: b */
    public boolean m408b(String str, boolean z) {
        if (str != null && this.f536a != null) {
            Iterator<a> it = this.f536a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if ((next instanceof b) && next.f537a.equals(str)) {
                    return ((b) next).f540d;
                }
            }
            return z;
        }
        return z;
    }

    /* renamed from: c */
    public boolean m412c(String str) {
        if (str == null) {
            Log.e("SAMMLibraryCore", "keyName is null");
            return false;
        }
        if (this.f536a == null) {
            Log.e("SAMMLibraryCore", "There is no item");
            return false;
        }
        Iterator<a> it = this.f536a.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if ((next instanceof b) && next.f537a.equals(str)) {
                if (this.f536a.remove(i) != null) {
                    return true;
                }
                Log.e("SAMMLibraryCore", "remove item of key '" + str + "' error");
                return false;
            }
            i++;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m401a(String str, String[] strArr) {
        int i = 0;
        if (str == null || strArr == null || strArr.length <= 0) {
            return false;
        }
        if (this.f536a == null) {
            this.f536a = new LinkedList<>();
        }
        Iterator<a> it = this.f536a.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a next = it.next();
                if ((next instanceof g) && next.f537a.equals(str)) {
                    this.f536a.set(i2, new g(str, strArr));
                    return true;
                }
                i = i2 + 1;
            } else {
                this.f536a.add(new g(str, strArr));
                return true;
            }
        }
    }

    /* renamed from: b */
    public String[] m410b(String str, String[] strArr) {
        if (str != null && this.f536a != null) {
            Iterator<a> it = this.f536a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if ((next instanceof g) && next.f537a.equals(str)) {
                    return (String[]) ((g) next).f550d.clone();
                }
            }
            return strArr;
        }
        return strArr;
    }

    /* renamed from: d */
    public boolean m414d(String str) {
        if (str == null) {
            Log.e("SAMMLibraryCore", "keyName is null");
            return false;
        }
        if (this.f536a == null) {
            Log.e("SAMMLibraryCore", "There is no item");
            return false;
        }
        Iterator<a> it = this.f536a.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if ((next instanceof g) && next.f537a.equals(str)) {
                if (this.f536a.remove(i) != null) {
                    return true;
                }
                Log.e("SAMMLibraryCore", "remove item of key '" + str + "' error");
                return false;
            }
            i++;
        }
        Log.e("SAMMLibraryCore", "There is no item of key " + str);
        return false;
    }

    /* renamed from: a */
    public boolean m400a(String str, byte[] bArr) {
        int i = 0;
        if (str == null || bArr == null || bArr.length <= 0) {
            return false;
        }
        if (this.f536a == null) {
            this.f536a = new LinkedList<>();
        }
        Iterator<a> it = this.f536a.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a next = it.next();
                if ((next instanceof c) && next.f537a.equals(str)) {
                    this.f536a.set(i2, new c(str, bArr));
                    return true;
                }
                i = i2 + 1;
            } else {
                this.f536a.add(new c(str, bArr));
                return true;
            }
        }
    }

    /* renamed from: b */
    public byte[] m409b(String str, byte[] bArr) {
        if (str != null && this.f536a != null) {
            Iterator<a> it = this.f536a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if ((next instanceof c) && next.f537a.equals(str)) {
                    return (byte[]) ((c) next).f542d.clone();
                }
            }
            return bArr;
        }
        return bArr;
    }

    /* renamed from: e */
    public boolean m415e(String str) {
        if (str == null) {
            Log.e("SAMMLibraryCore", "keyName is null");
            return false;
        }
        if (this.f536a == null) {
            Log.e("SAMMLibraryCore", "There is no item");
            return false;
        }
        Iterator<a> it = this.f536a.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if ((next instanceof c) && next.f537a.equals(str)) {
                if (this.f536a.remove(i) != null) {
                    return true;
                }
                Log.e("SAMMLibraryCore", "remove item of key '" + str + "' error");
                return false;
            }
            i++;
        }
        Log.e("SAMMLibraryCore", "There is no item of key " + str);
        return false;
    }

    /* renamed from: a */
    public boolean m398a(String str, short s) {
        int i = 0;
        if (str == null) {
            return false;
        }
        if (this.f536a == null) {
            this.f536a = new LinkedList<>();
        }
        Iterator<a> it = this.f536a.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                a next = it.next();
                if ((next instanceof e) && next.f537a.equals(str)) {
                    this.f536a.set(i2, new e(str, Short.valueOf(s)));
                    return true;
                }
                i = i2 + 1;
            } else {
                return this.f536a.add(new e(str, Short.valueOf(s)));
            }
        }
    }

    /* renamed from: b */
    public short m406b(String str, short s) {
        if (str != null && this.f536a != null) {
            Iterator<a> it = this.f536a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if ((next instanceof e) && next.f537a.equals(str)) {
                    return ((e) next).f546d;
                }
            }
            return s;
        }
        return s;
    }

    /* renamed from: f */
    public boolean m416f(String str) {
        if (str == null) {
            Log.e("SAMMLibraryCore", "keyName is null");
            return false;
        }
        if (this.f536a == null) {
            Log.e("SAMMLibraryCore", "There is no item");
            return false;
        }
        Iterator<a> it = this.f536a.iterator();
        int i = 0;
        while (it.hasNext()) {
            a next = it.next();
            if ((next instanceof e) && next.f537a.equals(str)) {
                return this.f536a.remove(i) != null;
            }
            i++;
        }
        return false;
    }

    /* renamed from: a */
    public LinkedList<a> m394a() {
        return this.f536a;
    }

    /* renamed from: a */
    private boolean m390a(RandomAccessFile randomAccessFile, int i, int i2, boolean z, boolean z2) throws IOException {
        try {
        } catch (FileNotFoundException e2) {
            Log.e("SAMMLibraryCore", "FileNotFoundException : " + e2);
            e2.printStackTrace();
        } catch (IOException e3) {
            Log.e("SAMMLibraryCore", "IOException : " + e3);
            e3.printStackTrace();
        }
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            randomAccessFile.skipBytes(i2);
            return true;
        }
        long filePointer = randomAccessFile.getFilePointer();
        int iM597c = C0903q.m597c(randomAccessFile);
        char[] cArr = new char[iM597c];
        byte[] bArr = new byte[iM597c * 2];
        int iM593b = 0;
        int[] iArr = new int[1];
        randomAccessFile.read(bArr);
        for (int i3 = 0; i3 < iM597c; i3++) {
            iM593b = C0903q.m593b(bArr, iM593b, iArr);
            cArr[i3] = (char) iArr[0];
        }
        String strCopyValueOf = String.copyValueOf(cArr);
        if (!z && (!z2 || !strCopyValueOf.equals("SAMM___LIBRARY___TAG___KEY"))) {
            randomAccessFile.skipBytes(i2 - ((int) (randomAccessFile.getFilePointer() - filePointer)));
            return true;
        }
        if (i == 0) {
            m396a(strCopyValueOf, C0903q.m591b(randomAccessFile));
        } else if (i == 1) {
            int iM597c2 = C0903q.m597c(randomAccessFile);
            char[] cArr2 = new char[iM597c2];
            byte[] bArr2 = new byte[iM597c2 * 2];
            int iM593b2 = 0;
            randomAccessFile.read(bArr2);
            for (int i4 = 0; i4 < iM597c2; i4++) {
                iM593b2 = C0903q.m593b(bArr2, iM593b2, iArr);
                cArr2[i4] = (char) iArr[0];
            }
            m397a(strCopyValueOf, String.copyValueOf(cArr2));
        } else if (i == 2) {
            m399a(strCopyValueOf, randomAccessFile.readBoolean());
        } else if (i == 3) {
            int iM591b = C0903q.m591b(randomAccessFile);
            String[] strArr = new String[iM591b];
            for (int i5 = 0; i5 < iM591b; i5++) {
                int iM597c3 = C0903q.m597c(randomAccessFile);
                char[] cArr3 = new char[iM597c3];
                byte[] bArr3 = new byte[iM597c3 * 2];
                int iM593b3 = 0;
                randomAccessFile.read(bArr3);
                for (int i6 = 0; i6 < iM597c3; i6++) {
                    iM593b3 = C0903q.m593b(bArr3, iM593b3, iArr);
                    cArr3[i6] = (char) iArr[0];
                }
                strArr[i5] = String.copyValueOf(cArr3);
            }
            m401a(strCopyValueOf, strArr);
        } else if (i == 4) {
            byte[] bArr4 = new byte[C0903q.m591b(randomAccessFile)];
            randomAccessFile.read(bArr4);
            m400a(strCopyValueOf, bArr4);
        } else if (i == 5) {
            m398a(strCopyValueOf, (short) C0903q.m597c(randomAccessFile));
        }
        return true;
    }

    /* renamed from: a */
    private boolean m391a(byte[] bArr, int i, int i2) {
        int[] iArr = new int[1];
        if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4 || i == 5) {
            int iM593b = C0903q.m593b(bArr, i2, iArr);
            int i3 = iArr[0];
            char[] cArr = new char[i3];
            int iM593b2 = iM593b;
            for (int i4 = 0; i4 < i3; i4++) {
                iM593b2 = C0903q.m593b(bArr, iM593b2, iArr);
                cArr[i4] = (char) iArr[0];
            }
            String strCopyValueOf = String.copyValueOf(cArr);
            if (i == 0) {
                C0903q.m581a(bArr, iM593b2, iArr);
                m396a(strCopyValueOf, iArr[0]);
            } else if (i == 1) {
                int iM593b3 = C0903q.m593b(bArr, iM593b2, iArr);
                int i5 = iArr[0];
                char[] cArr2 = new char[i5];
                int iM593b4 = iM593b3;
                for (int i6 = 0; i6 < i5; i6++) {
                    iM593b4 = C0903q.m593b(bArr, iM593b4, iArr);
                    cArr2[i6] = (char) iArr[0];
                }
                m397a(strCopyValueOf, String.copyValueOf(cArr2));
            } else if (i == 2) {
                m399a(strCopyValueOf, bArr[iM593b2] > 0);
            } else if (i == 3) {
                int iM581a = C0903q.m581a(bArr, iM593b2, iArr);
                int i7 = iArr[0];
                String[] strArr = new String[i7];
                for (int i8 = 0; i8 < i7; i8++) {
                    int iM593b5 = C0903q.m593b(bArr, iM581a, iArr);
                    int i9 = iArr[0];
                    char[] cArr3 = new char[i9];
                    iM581a = iM593b5;
                    for (int i10 = 0; i10 < i9; i10++) {
                        iM581a = C0903q.m593b(bArr, iM581a, iArr);
                        cArr3[i10] = (char) iArr[0];
                    }
                    strArr[i8] = String.copyValueOf(cArr3);
                }
                m401a(strCopyValueOf, strArr);
            } else if (i == 4) {
                int iM581a2 = C0903q.m581a(bArr, iM593b2, iArr);
                byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 1, iArr[0]);
                C0903q.m582a(bArr, iM581a2, bArr2);
                m400a(strCopyValueOf, bArr2[0]);
            } else if (i == 5) {
                C0903q.m593b(bArr, iM593b2, iArr);
                m398a(strCopyValueOf, (short) iArr[0]);
            }
        }
        return true;
    }

    /* renamed from: a */
    private int m389a(byte[] bArr, int i, a aVar) {
        int iM592b;
        String str = aVar.f537a;
        int length = str.length();
        int iM592b2 = C0903q.m592b(bArr, i, length);
        if (length > 0) {
            char[] charArray = str.toCharArray();
            int i2 = 0;
            while (i2 < length) {
                int iM592b3 = C0903q.m592b(bArr, iM592b2, charArray[i2]);
                i2++;
                iM592b2 = iM592b3;
            }
        }
        if (aVar instanceof d) {
            iM592b = C0903q.m579a(bArr, iM592b2, ((d) aVar).f544d);
        } else if (aVar instanceof f) {
            String str2 = ((f) aVar).f548d;
            int length2 = str2.length();
            iM592b = C0903q.m592b(bArr, iM592b2, length2);
            if (length2 > 0) {
                char[] charArray2 = str2.toCharArray();
                while (i < length2) {
                    iM592b = C0903q.m592b(bArr, iM592b, charArray2[i]);
                    i++;
                }
            }
        } else if (aVar instanceof b) {
            int i3 = iM592b2 + 1;
            bArr[iM592b2] = (byte) (((b) aVar).f540d ? 1 : 0);
            iM592b = i3;
        } else if (aVar instanceof g) {
            String[] strArr = ((g) aVar).f550d;
            iM592b = C0903q.m579a(bArr, iM592b2, strArr.length);
            for (String str3 : strArr) {
                int length3 = str3.length();
                iM592b = C0903q.m592b(bArr, iM592b, length3);
                if (length3 > 0) {
                    char[] charArray3 = str3.toCharArray();
                    int i4 = 0;
                    while (i4 < length3) {
                        int iM592b4 = C0903q.m592b(bArr, iM592b, charArray3[i4]);
                        i4++;
                        iM592b = iM592b4;
                    }
                }
            }
        } else if (aVar instanceof c) {
            byte[] bArr2 = ((c) aVar).f542d;
            iM592b = C0903q.m580a(bArr, C0903q.m579a(bArr, iM592b2, bArr2.length), bArr2);
        } else if (aVar instanceof e) {
            iM592b = C0903q.m592b(bArr, iM592b2, ((e) aVar).f546d);
        } else {
            return -1;
        }
        return iM592b - i;
    }

    /* renamed from: a */
    public int m392a(RandomAccessFile randomAccessFile, boolean z, boolean z2) throws IOException {
        int iM591b = C0903q.m591b(randomAccessFile);
        int i = 0;
        int i2 = 4;
        while (i < iM591b) {
            try {
                int unsignedByte = randomAccessFile.readUnsignedByte();
                int i3 = i2 + 1;
                try {
                    int iM591b2 = C0903q.m591b(randomAccessFile);
                    int i4 = i3 + 4;
                    if (z || (z2 && unsignedByte == 3)) {
                        if (!m390a(randomAccessFile, unsignedByte, iM591b2, z, z2)) {
                            return -1;
                        }
                    } else {
                        try {
                            randomAccessFile.skipBytes(iM591b2);
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            i2 = i4;
                            Log.e("SAMMLibraryCore", "FileNotFoundException : " + e);
                            e.printStackTrace();
                            return i2;
                        } catch (IOException e3) {
                            e = e3;
                            i2 = i4;
                            Log.e("SAMMLibraryCore", "IOException : " + e);
                            e.printStackTrace();
                            return i2;
                        }
                    }
                    i++;
                    i2 = i4 + iM591b2;
                } catch (FileNotFoundException e4) {
                    i2 = i3;
                    e = e4;
                } catch (IOException e5) {
                    i2 = i3;
                    e = e5;
                }
            } catch (FileNotFoundException e6) {
                e = e6;
            } catch (IOException e7) {
                e = e7;
            }
        }
        return i2;
    }

    /* renamed from: a */
    public int m393a(byte[] bArr, int i) {
        int[] iArr = new int[1];
        int iM581a = C0903q.m581a(bArr, i, iArr);
        int i2 = iArr[0];
        int i3 = iM581a;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 + 1;
            int i6 = bArr[i3] & 255;
            int iM581a2 = C0903q.m581a(bArr, i5, iArr);
            int i7 = iArr[0];
            if (!m391a(bArr, i6, iM581a2)) {
                return -1;
            }
            i3 = iM581a2 + i7;
        }
        return i3 - i;
    }

    /* renamed from: b */
    public int m404b(byte[] bArr, int i) {
        int i2;
        int i3;
        int iM579a = C0903q.m579a(bArr, i, m402b());
        if (this.f536a != null) {
            Iterator<a> it = this.f536a.iterator();
            while (true) {
                i2 = iM579a;
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                if (next instanceof d) {
                    bArr[i2] = 0;
                    i3 = i2 + 1;
                } else if (next instanceof f) {
                    bArr[i2] = 1;
                    i3 = i2 + 1;
                } else if (next instanceof b) {
                    bArr[i2] = 2;
                    i3 = i2 + 1;
                } else if (next instanceof g) {
                    bArr[i2] = 3;
                    i3 = i2 + 1;
                } else if (next instanceof c) {
                    bArr[i2] = 4;
                    i3 = i2 + 1;
                } else {
                    if (!(next instanceof e)) {
                        return -1;
                    }
                    bArr[i2] = 5;
                    i3 = i2 + 1;
                }
                int i4 = i3 + 4;
                int iM389a = m389a(bArr, i4, next);
                if (iM389a < 0) {
                    return -1;
                }
                iM579a = i4 + iM389a;
                C0903q.m579a(bArr, i3, iM389a);
            }
        } else {
            i2 = iM579a;
        }
        return i2 - i;
    }

    /* renamed from: b */
    public int m402b() {
        if (this.f536a == null) {
            return 0;
        }
        return this.f536a.size();
    }

    /* renamed from: c */
    public int m411c() {
        if (this.f536a == null || this.f536a.size() <= 0) {
            return 0;
        }
        Iterator<a> it = this.f536a.iterator();
        int length = 4;
        while (it.hasNext()) {
            a next = it.next();
            length = length + 1 + 4 + 2 + (next.f537a.length() * 2);
            if (next instanceof d) {
                length += 4;
            } else if (next instanceof f) {
                length = (((f) next).f548d.length() * 2) + length + 2;
            } else if (next instanceof b) {
                length++;
            } else if (next instanceof g) {
                String[] strArr = ((g) next).f550d;
                int i = length + 4;
                int i2 = 0;
                while (i2 < strArr.length) {
                    int length2 = (strArr[i2].length() * 2) + i + 2;
                    i2++;
                    i = length2;
                }
                length = i;
            } else if (next instanceof c) {
                length = ((c) next).f542d.length + length + 4;
            } else if (next instanceof e) {
                length += 2;
            }
        }
        return length;
    }

    /* renamed from: d */
    public void m413d() {
        if (this.f536a != null) {
            this.f536a.clear();
        }
    }
}
