package p010b.p014d.p015a;

/* compiled from: BASE64Encoder.java */
/* renamed from: b.d.a.a */
/* loaded from: classes.dex */
public final class C0286a {

    /* renamed from: a */
    private static final char f635a = (char) Integer.parseInt("00000011", 2);

    /* renamed from: b */
    private static final char f636b = (char) Integer.parseInt("00001111", 2);

    /* renamed from: c */
    private static final char f637c = (char) Integer.parseInt("00111111", 2);

    /* renamed from: d */
    private static final char f638d = (char) Integer.parseInt("11111100", 2);

    /* renamed from: e */
    private static final char f639e = (char) Integer.parseInt("11110000", 2);

    /* renamed from: f */
    private static final char f640f = (char) Integer.parseInt("11000000", 2);

    /* renamed from: g */
    private static final char[] f641g = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* renamed from: a */
    public static String m991a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(((int) (bArr.length * 1.34d)) + 3);
        char c2 = 0;
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i %= 8;
            while (i < 8) {
                switch (i) {
                    case 0:
                        c2 = (char) (((char) (bArr[i2] & f638d)) >>> 2);
                        break;
                    case 2:
                        c2 = (char) (bArr[i2] & f637c);
                        break;
                    case 4:
                        c2 = (char) (((char) (bArr[i2] & f636b)) << 2);
                        if (i2 + 1 < bArr.length) {
                            c2 = (char) (c2 | ((bArr[i2 + 1] & f640f) >>> 6));
                            break;
                        } else {
                            break;
                        }
                    case 6:
                        c2 = (char) (((char) (bArr[i2] & f635a)) << 4);
                        if (i2 + 1 < bArr.length) {
                            c2 = (char) (c2 | ((bArr[i2 + 1] & f639e) >>> 4));
                            break;
                        } else {
                            break;
                        }
                }
                sb.append(f641g[c2]);
                i += 6;
            }
        }
        if (sb.length() % 4 != 0) {
            for (int length = 4 - (sb.length() % 4); length > 0; length--) {
                sb.append("=");
            }
        }
        return sb.toString();
    }
}
