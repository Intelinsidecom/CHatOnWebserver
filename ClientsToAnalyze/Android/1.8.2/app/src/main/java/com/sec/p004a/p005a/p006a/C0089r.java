package com.sec.p004a.p005a.p006a;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.r */
/* loaded from: classes.dex */
public final class C0089r extends GeneratedMessageLite implements InterfaceC0091t {

    /* renamed from: a */
    private static final C0089r f160a = new C0089r(true);

    /* renamed from: b */
    private int f161b;

    /* renamed from: c */
    private Object f162c;

    /* renamed from: d */
    private Object f163d;

    /* renamed from: e */
    private int f164e;

    /* renamed from: f */
    private int f165f;

    /* renamed from: g */
    private Object f166g;

    /* renamed from: h */
    private Object f167h;

    /* renamed from: i */
    private Object f168i;

    /* renamed from: j */
    private long f169j;

    /* renamed from: k */
    private int f170k;

    /* renamed from: l */
    private Object f171l;

    /* renamed from: m */
    private byte f172m;

    /* renamed from: n */
    private int f173n;

    private C0089r(C0090s c0090s) {
        super(c0090s);
        this.f172m = (byte) -1;
        this.f173n = -1;
    }

    private C0089r(boolean z) {
        this.f172m = (byte) -1;
        this.f173n = -1;
    }

    /* renamed from: a */
    public static C0089r m462a() {
        return f160a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0089r getDefaultInstanceForType() {
        return f160a;
    }

    /* renamed from: c */
    public boolean m477c() {
        return (this.f161b & 1) == 1;
    }

    /* renamed from: d */
    public String m478d() {
        Object obj = this.f162c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f162c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m474y() {
        Object obj = this.f162c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f162c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m479e() {
        return (this.f161b & 2) == 2;
    }

    /* renamed from: f */
    public String m480f() {
        Object obj = this.f163d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f163d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m475z() {
        Object obj = this.f163d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f163d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m481g() {
        return (this.f161b & 4) == 4;
    }

    /* renamed from: h */
    public int m482h() {
        return this.f164e;
    }

    /* renamed from: i */
    public boolean m483i() {
        return (this.f161b & 8) == 8;
    }

    /* renamed from: j */
    public int m484j() {
        return this.f165f;
    }

    /* renamed from: k */
    public boolean m485k() {
        return (this.f161b & 16) == 16;
    }

    /* renamed from: l */
    public String m486l() {
        Object obj = this.f166g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f166g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: A */
    private ByteString m455A() {
        Object obj = this.f166g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f166g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m487m() {
        return (this.f161b & 32) == 32;
    }

    /* renamed from: n */
    public String m488n() {
        Object obj = this.f167h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f167h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: B */
    private ByteString m456B() {
        Object obj = this.f167h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f167h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    public boolean m489o() {
        return (this.f161b & 64) == 64;
    }

    /* renamed from: p */
    public String m490p() {
        Object obj = this.f168i;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f168i = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: C */
    private ByteString m457C() {
        Object obj = this.f168i;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f168i = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: q */
    public boolean m491q() {
        return (this.f161b & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128;
    }

    /* renamed from: r */
    public long m492r() {
        return this.f169j;
    }

    /* renamed from: s */
    public boolean m493s() {
        return (this.f161b & AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT) == 256;
    }

    /* renamed from: t */
    public int m494t() {
        return this.f170k;
    }

    /* renamed from: u */
    public boolean m495u() {
        return (this.f161b & 512) == 512;
    }

    /* renamed from: v */
    public String m496v() {
        Object obj = this.f171l;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f171l = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: D */
    private ByteString m458D() {
        Object obj = this.f171l;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f171l = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: E */
    private void m459E() {
        this.f162c = "";
        this.f163d = "";
        this.f164e = 0;
        this.f165f = 0;
        this.f166g = "";
        this.f167h = "";
        this.f168i = "";
        this.f169j = 0L;
        this.f170k = 0;
        this.f171l = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f172m;
        if (b != -1) {
            return b == 1;
        }
        this.f172m = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f161b & 1) == 1) {
            codedOutputStream.writeBytes(1, m474y());
        }
        if ((this.f161b & 2) == 2) {
            codedOutputStream.writeBytes(2, m475z());
        }
        if ((this.f161b & 4) == 4) {
            codedOutputStream.writeInt32(3, this.f164e);
        }
        if ((this.f161b & 8) == 8) {
            codedOutputStream.writeInt32(4, this.f165f);
        }
        if ((this.f161b & 16) == 16) {
            codedOutputStream.writeBytes(5, m455A());
        }
        if ((this.f161b & 32) == 32) {
            codedOutputStream.writeBytes(6, m456B());
        }
        if ((this.f161b & 64) == 64) {
            codedOutputStream.writeBytes(7, m457C());
        }
        if ((this.f161b & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128) {
            codedOutputStream.writeInt64(11, this.f169j);
        }
        if ((this.f161b & AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT) == 256) {
            codedOutputStream.writeInt32(12, this.f170k);
        }
        if ((this.f161b & 512) == 512) {
            codedOutputStream.writeBytes(13, m458D());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f173n;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f161b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m474y()) : 0;
            if ((this.f161b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m475z());
            }
            if ((this.f161b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(3, this.f164e);
            }
            if ((this.f161b & 8) == 8) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(4, this.f165f);
            }
            if ((this.f161b & 16) == 16) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(5, m455A());
            }
            if ((this.f161b & 32) == 32) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(6, m456B());
            }
            if ((this.f161b & 64) == 64) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(7, m457C());
            }
            if ((this.f161b & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128) {
                iComputeBytesSize += CodedOutputStream.computeInt64Size(11, this.f169j);
            }
            if ((this.f161b & AccessibilityEventCompat.TYPE_VIEW_HOVER_EXIT) == 256) {
                iComputeBytesSize += CodedOutputStream.computeInt32Size(12, this.f170k);
            }
            if ((this.f161b & 512) == 512) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(13, m458D());
            }
            this.f173n = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0089r m463a(byte[] bArr) {
        return ((C0090s) newBuilder().mergeFrom(bArr)).m503i();
    }

    public static C0090s newBuilder() {
        return C0090s.m502h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C0090s newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0090s m464a(C0089r c0089r) {
        return newBuilder().mergeFrom(c0089r);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public C0090s toBuilder() {
        return m464a(this);
    }

    static {
        f160a.m459E();
    }
}
