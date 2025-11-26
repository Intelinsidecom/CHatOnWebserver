package p010b;

import java.io.Serializable;

/* compiled from: ExceptionDiagnosis.java */
/* renamed from: b.a */
/* loaded from: classes.dex */
final class C0267a implements Serializable {

    /* renamed from: a */
    int f609a;

    /* renamed from: b */
    int f610b;

    /* renamed from: c */
    String f611c = "";

    /* renamed from: d */
    Throwable f612d;

    C0267a(Throwable th, String[] strArr) {
        this.f612d = th;
        StackTraceElement[] stackTrace = th.getStackTrace();
        this.f609a = 0;
        this.f610b = 0;
        for (int length = stackTrace.length - 1; length >= 0; length--) {
            StackTraceElement stackTraceElement = stackTrace[length];
            int length2 = strArr.length;
            int i = 0;
            while (true) {
                if (i < length2) {
                    if (!stackTraceElement.getClassName().startsWith(strArr[i])) {
                        i++;
                    } else {
                        this.f609a = stackTraceElement.getClassName().hashCode() + stackTraceElement.getMethodName().hashCode() + (this.f609a * 31);
                        this.f610b = (this.f610b * 31) + stackTraceElement.getLineNumber();
                        break;
                    }
                }
            }
        }
        this.f611c += m941a(this.f609a) + "-" + m941a(this.f610b);
        if (th.getCause() != null) {
            this.f611c += " " + new C0267a(th.getCause(), strArr).m944c();
        }
    }

    /* renamed from: a */
    String m942a() {
        return m941a(this.f609a);
    }

    /* renamed from: b */
    String m943b() {
        return m941a(this.f610b);
    }

    /* renamed from: c */
    String m944c() {
        return this.f611c;
    }

    /* renamed from: a */
    private String m941a(int i) {
        String str = "0000000" + Integer.toHexString(i);
        return str.substring(str.length() - 8, str.length());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0267a c0267a = (C0267a) obj;
        return this.f610b == c0267a.f610b && this.f609a == c0267a.f609a;
    }

    public int hashCode() {
        return (this.f609a * 31) + this.f610b;
    }

    public String toString() {
        return "ExceptionDiagnosis{stackLineHash=" + this.f609a + ", lineNumberHash=" + this.f610b + '}';
    }
}
