package twitter4j;

import java.io.Serializable;

/* loaded from: classes.dex */
final class ExceptionDiagnosis implements Serializable {
    private static final long serialVersionUID = 453958937114285988L;
    String hexString;
    int lineNumberHash;
    int stackLineHash;

    /* renamed from: th */
    Throwable f7890th;

    ExceptionDiagnosis(Throwable th) {
        this(th, new String[0]);
    }

    ExceptionDiagnosis(Throwable th, String[] strArr) {
        this.hexString = "";
        this.f7890th = th;
        StackTraceElement[] stackTrace = th.getStackTrace();
        this.stackLineHash = 0;
        this.lineNumberHash = 0;
        for (int length = stackTrace.length - 1; length >= 0; length--) {
            StackTraceElement stackTraceElement = stackTrace[length];
            int length2 = strArr.length;
            int i = 0;
            while (true) {
                if (i < length2) {
                    if (!stackTraceElement.getClassName().startsWith(strArr[i])) {
                        i++;
                    } else {
                        this.stackLineHash = stackTraceElement.getClassName().hashCode() + stackTraceElement.getMethodName().hashCode() + (this.stackLineHash * 31);
                        this.lineNumberHash = (this.lineNumberHash * 31) + stackTraceElement.getLineNumber();
                        break;
                    }
                }
            }
        }
        this.hexString = new StringBuffer().append(this.hexString).append(toHexString(this.stackLineHash)).append("-").append(toHexString(this.lineNumberHash)).toString();
        if (th.getCause() != null) {
            this.hexString = new StringBuffer().append(this.hexString).append(" ").append(new ExceptionDiagnosis(th.getCause(), strArr).asHexString()).toString();
        }
    }

    int getStackLineHash() {
        return this.stackLineHash;
    }

    String getStackLineHashAsHex() {
        return toHexString(this.stackLineHash);
    }

    int getLineNumberHash() {
        return this.lineNumberHash;
    }

    String getLineNumberHashAsHex() {
        return toHexString(this.lineNumberHash);
    }

    String asHexString() {
        return this.hexString;
    }

    private String toHexString(int i) {
        String string = new StringBuffer().append("0000000").append(Integer.toHexString(i)).toString();
        return string.substring(string.length() - 8, string.length());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExceptionDiagnosis exceptionDiagnosis = (ExceptionDiagnosis) obj;
        return this.lineNumberHash == exceptionDiagnosis.lineNumberHash && this.stackLineHash == exceptionDiagnosis.stackLineHash;
    }

    public int hashCode() {
        return (this.stackLineHash * 31) + this.lineNumberHash;
    }

    public String toString() {
        return new StringBuffer().append("ExceptionDiagnosis{stackLineHash=").append(this.stackLineHash).append(", lineNumberHash=").append(this.lineNumberHash).append('}').toString();
    }
}
