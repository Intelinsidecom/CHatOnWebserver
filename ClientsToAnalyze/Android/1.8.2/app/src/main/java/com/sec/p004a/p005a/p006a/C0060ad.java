package com.sec.p004a.p005a.p006a;

import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ad */
/* loaded from: classes.dex */
public final class C0060ad extends GeneratedMessageLite implements InterfaceC0062af {

    /* renamed from: a */
    private static final C0060ad f41a = new C0060ad(true);

    /* renamed from: b */
    private int f42b;

    /* renamed from: c */
    private int f43c;

    /* renamed from: d */
    private Object f44d;

    /* renamed from: e */
    private Object f45e;

    /* renamed from: f */
    private int f46f;

    /* renamed from: g */
    private Object f47g;

    /* renamed from: h */
    private int f48h;

    /* renamed from: i */
    private int f49i;

    /* renamed from: j */
    private Object f50j;

    /* renamed from: k */
    private byte f51k;

    /* renamed from: l */
    private int f52l;

    private C0060ad(C0061ae c0061ae) {
        super(c0061ae);
        this.f51k = (byte) -1;
        this.f52l = -1;
    }

    private C0060ad(boolean z) {
        this.f51k = (byte) -1;
        this.f52l = -1;
    }

    /* renamed from: a */
    public static C0060ad m100a() {
        return f41a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0060ad getDefaultInstanceForType() {
        return f41a;
    }

    /* renamed from: c */
    public boolean m117c() {
        return (this.f42b & 1) == 1;
    }

    /* renamed from: d */
    public int m118d() {
        return this.f43c;
    }

    /* renamed from: e */
    public boolean m119e() {
        return (this.f42b & 2) == 2;
    }

    /* renamed from: f */
    public String m120f() {
        Object obj = this.f44d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f44d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m111u() {
        Object obj = this.f44d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f44d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m121g() {
        return (this.f42b & 4) == 4;
    }

    /* renamed from: h */
    public String m122h() {
        Object obj = this.f45e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f45e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: v */
    private ByteString m112v() {
        Object obj = this.f45e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f45e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public boolean m123i() {
        return (this.f42b & 8) == 8;
    }

    /* renamed from: j */
    public int m124j() {
        return this.f46f;
    }

    /* renamed from: k */
    public boolean m125k() {
        return (this.f42b & 16) == 16;
    }

    /* renamed from: l */
    public String m126l() {
        Object obj = this.f47g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f47g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m113w() {
        Object obj = this.f47g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f47g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public boolean m127m() {
        return (this.f42b & 32) == 32;
    }

    /* renamed from: n */
    public int m128n() {
        return this.f48h;
    }

    /* renamed from: o */
    public boolean m129o() {
        return (this.f42b & 64) == 64;
    }

    /* renamed from: p */
    public int m130p() {
        return this.f49i;
    }

    /* renamed from: q */
    public boolean m131q() {
        return (this.f42b & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128;
    }

    /* renamed from: r */
    public String m132r() {
        Object obj = this.f50j;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f50j = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m114x() {
        Object obj = this.f50j;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f50j = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: y */
    private void m115y() {
        this.f43c = 0;
        this.f44d = "";
        this.f45e = "";
        this.f46f = 0;
        this.f47g = "";
        this.f48h = 0;
        this.f49i = 0;
        this.f50j = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f51k;
        if (b != -1) {
            return b == 1;
        }
        this.f51k = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f42b & 1) == 1) {
            codedOutputStream.writeInt32(2, this.f43c);
        }
        if ((this.f42b & 2) == 2) {
            codedOutputStream.writeBytes(3, m111u());
        }
        if ((this.f42b & 4) == 4) {
            codedOutputStream.writeBytes(4, m112v());
        }
        if ((this.f42b & 8) == 8) {
            codedOutputStream.writeInt32(5, this.f46f);
        }
        if ((this.f42b & 16) == 16) {
            codedOutputStream.writeBytes(6, m113w());
        }
        if ((this.f42b & 32) == 32) {
            codedOutputStream.writeInt32(7, this.f48h);
        }
        if ((this.f42b & 64) == 64) {
            codedOutputStream.writeInt32(8, this.f49i);
        }
        if ((this.f42b & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128) {
            codedOutputStream.writeBytes(9, m114x());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeInt32Size = this.f52l;
        if (iComputeInt32Size == -1) {
            iComputeInt32Size = (this.f42b & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(2, this.f43c) : 0;
            if ((this.f42b & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(3, m111u());
            }
            if ((this.f42b & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(4, m112v());
            }
            if ((this.f42b & 8) == 8) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.f46f);
            }
            if ((this.f42b & 16) == 16) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(6, m113w());
            }
            if ((this.f42b & 32) == 32) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(7, this.f48h);
            }
            if ((this.f42b & 64) == 64) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(8, this.f49i);
            }
            if ((this.f42b & AccessibilityEventCompat.TYPE_VIEW_HOVER_ENTER) == 128) {
                iComputeInt32Size += CodedOutputStream.computeBytesSize(9, m114x());
            }
            this.f52l = iComputeInt32Size;
        }
        return iComputeInt32Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0060ad m101a(byte[] bArr) {
        return ((C0061ae) newBuilder().mergeFrom(bArr)).m139i();
    }

    public static C0061ae newBuilder() {
        return C0061ae.m138h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public C0061ae newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0061ae m102a(C0060ad c0060ad) {
        return newBuilder().mergeFrom(c0060ad);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public C0061ae toBuilder() {
        return m102a(this);
    }

    static {
        f41a.m115y();
    }
}
