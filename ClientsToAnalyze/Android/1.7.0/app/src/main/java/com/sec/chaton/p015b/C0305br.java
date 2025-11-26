package com.sec.chaton.p015b;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.br */
/* loaded from: classes.dex */
public final class C0305br extends GeneratedMessageLite implements InterfaceC0278ar {

    /* renamed from: a */
    private static final C0305br f837a = new C0305br(true);

    /* renamed from: b */
    private int f838b;

    /* renamed from: c */
    private Object f839c;

    /* renamed from: d */
    private EnumC0323ci f840d;

    /* renamed from: e */
    private List f841e;

    /* renamed from: f */
    private Object f842f;

    /* renamed from: g */
    private boolean f843g;

    /* renamed from: h */
    private byte f844h;

    /* renamed from: i */
    private int f845i;

    private C0305br(C0298bk c0298bk) {
        super(c0298bk);
        this.f844h = (byte) -1;
        this.f845i = -1;
    }

    private C0305br(boolean z) {
        this.f844h = (byte) -1;
        this.f845i = -1;
    }

    /* renamed from: a */
    public static C0305br m1494a() {
        return f837a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0305br getDefaultInstanceForType() {
        return f837a;
    }

    /* renamed from: c */
    public boolean m1507c() {
        return (this.f838b & 1) == 1;
    }

    /* renamed from: d */
    public String m1508d() {
        Object obj = this.f839c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f839c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: o */
    private ByteString m1502o() {
        Object obj = this.f839c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f839c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m1509e() {
        return (this.f838b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0323ci m1510f() {
        return this.f840d;
    }

    /* renamed from: g */
    public List m1511g() {
        return this.f841e;
    }

    /* renamed from: h */
    public int m1512h() {
        return this.f841e.size();
    }

    /* renamed from: a */
    public C0329co m1505a(int i) {
        return (C0329co) this.f841e.get(i);
    }

    /* renamed from: i */
    public boolean m1513i() {
        return (this.f838b & 4) == 4;
    }

    /* renamed from: j */
    public String m1514j() {
        Object obj = this.f842f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f842f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m1503p() {
        Object obj = this.f842f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f842f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m1515k() {
        return (this.f838b & 8) == 8;
    }

    /* renamed from: l */
    public boolean m1516l() {
        return this.f843g;
    }

    /* renamed from: q */
    private void m1504q() {
        this.f839c = "";
        this.f840d = EnumC0323ci.SINGLE;
        this.f841e = Collections.emptyList();
        this.f842f = "";
        this.f843g = false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f844h;
        if (b != -1) {
            return b == 1;
        }
        this.f844h = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f838b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1502o());
        }
        if ((this.f838b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f840d.getNumber());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f841e.size()) {
                break;
            }
            codedOutputStream.writeMessage(3, (MessageLite) this.f841e.get(i2));
            i = i2 + 1;
        }
        if ((this.f838b & 4) == 4) {
            codedOutputStream.writeBytes(4, m1503p());
        }
        if ((this.f838b & 8) == 8) {
            codedOutputStream.writeBool(5, this.f843g);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeBoolSize = this.f845i;
        if (iComputeBoolSize == -1) {
            int iComputeBytesSize = (this.f838b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m1502o()) + 0 : 0;
            if ((this.f838b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeEnumSize(2, this.f840d.getNumber());
            }
            while (true) {
                iComputeBoolSize = iComputeBytesSize;
                if (i >= this.f841e.size()) {
                    break;
                }
                iComputeBytesSize = CodedOutputStream.computeMessageSize(3, (MessageLite) this.f841e.get(i)) + iComputeBoolSize;
                i++;
            }
            if ((this.f838b & 4) == 4) {
                iComputeBoolSize += CodedOutputStream.computeBytesSize(4, m1503p());
            }
            if ((this.f838b & 8) == 8) {
                iComputeBoolSize += CodedOutputStream.computeBoolSize(5, this.f843g);
            }
            this.f845i = iComputeBoolSize;
        }
        return iComputeBoolSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0305br m1495a(byte[] bArr) {
        return ((C0298bk) newBuilder().mergeFrom(bArr)).m1361i();
    }

    public static C0298bk newBuilder() {
        return C0298bk.m1360h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public C0298bk newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0298bk m1493a(C0305br c0305br) {
        return newBuilder().mergeFrom(c0305br);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0298bk toBuilder() {
        return m1493a(this);
    }

    static {
        f837a.m1504q();
    }
}
