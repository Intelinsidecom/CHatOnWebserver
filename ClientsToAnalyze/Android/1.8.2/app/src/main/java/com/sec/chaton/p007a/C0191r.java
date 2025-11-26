package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.r */
/* loaded from: classes.dex */
public final class C0191r extends GeneratedMessageLite implements InterfaceC0193t {

    /* renamed from: a */
    private static final C0191r f693a = new C0191r(true);

    /* renamed from: b */
    private int f694b;

    /* renamed from: c */
    private Object f695c;

    /* renamed from: d */
    private List f696d;

    /* renamed from: e */
    private C0171cj f697e;

    /* renamed from: f */
    private byte f698f;

    /* renamed from: g */
    private int f699g;

    private C0191r(C0192s c0192s) {
        super(c0192s);
        this.f698f = (byte) -1;
        this.f699g = -1;
    }

    private C0191r(boolean z) {
        this.f698f = (byte) -1;
        this.f699g = -1;
    }

    /* renamed from: a */
    public static C0191r m1696a() {
        return f693a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0191r getDefaultInstanceForType() {
        return f693a;
    }

    /* renamed from: c */
    public boolean m1705c() {
        return (this.f694b & 1) == 1;
    }

    /* renamed from: d */
    public String m1706d() {
        Object obj = this.f695c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f695c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m1702i() {
        Object obj = this.f695c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f695c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m1707e() {
        return (this.f694b & 2) == 2;
    }

    /* renamed from: f */
    public C0171cj m1708f() {
        return this.f697e;
    }

    /* renamed from: j */
    private void m1703j() {
        this.f695c = "";
        this.f696d = Collections.emptyList();
        this.f697e = C0171cj.m1459a();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f698f;
        if (b != -1) {
            return b == 1;
        }
        this.f698f = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f694b & 1) == 1) {
            codedOutputStream.writeBytes(1, m1702i());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f696d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, (MessageLite) this.f696d.get(i2));
            i = i2 + 1;
        }
        if ((this.f694b & 2) == 2) {
            codedOutputStream.writeMessage(3, this.f697e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeMessageSize = this.f699g;
        if (iComputeMessageSize == -1) {
            int iComputeBytesSize = (this.f694b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m1702i()) + 0 : 0;
            while (true) {
                iComputeMessageSize = iComputeBytesSize;
                if (i >= this.f696d.size()) {
                    break;
                }
                iComputeBytesSize = CodedOutputStream.computeMessageSize(2, (MessageLite) this.f696d.get(i)) + iComputeMessageSize;
                i++;
            }
            if ((this.f694b & 2) == 2) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.f697e);
            }
            this.f699g = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0191r m1697a(byte[] bArr) {
        return ((C0192s) newBuilder().mergeFrom(bArr)).m1715m();
    }

    public static C0192s newBuilder() {
        return C0192s.m1714l();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0192s newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0192s m1698a(C0191r c0191r) {
        return newBuilder().mergeFrom(c0191r);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0192s toBuilder() {
        return m1698a(this);
    }

    static {
        f693a.m1703j();
    }
}
