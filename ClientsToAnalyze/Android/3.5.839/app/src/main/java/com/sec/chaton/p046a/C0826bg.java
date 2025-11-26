package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bg */
/* loaded from: classes.dex */
public final class C0826bg extends GeneratedMessageLite implements InterfaceC0828bi {

    /* renamed from: a */
    private static final C0826bg f2366a = new C0826bg(true);

    /* renamed from: b */
    private int f2367b;

    /* renamed from: c */
    private Object f2368c;

    /* renamed from: d */
    private EnumC0822bc f2369d;

    /* renamed from: e */
    private List<C0864cr> f2370e;

    /* renamed from: f */
    private Object f2371f;

    /* renamed from: g */
    private boolean f2372g;

    /* renamed from: h */
    private Object f2373h;

    /* renamed from: i */
    private long f2374i;

    /* renamed from: j */
    private byte f2375j;

    /* renamed from: k */
    private int f2376k;

    private C0826bg(C0827bh c0827bh) {
        super(c0827bh);
        this.f2375j = (byte) -1;
        this.f2376k = -1;
    }

    private C0826bg(boolean z) {
        this.f2375j = (byte) -1;
        this.f2376k = -1;
    }

    /* renamed from: a */
    public static C0826bg m3583a() {
        return f2366a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0826bg getDefaultInstanceForType() {
        return f2366a;
    }

    /* renamed from: c */
    public boolean m3598c() {
        return (this.f2367b & 1) == 1;
    }

    /* renamed from: d */
    public String m3599d() {
        Object obj = this.f2368c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2368c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: s */
    private ByteString m3592s() {
        Object obj = this.f2368c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2368c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m3600e() {
        return (this.f2367b & 2) == 2;
    }

    /* renamed from: f */
    public EnumC0822bc m3601f() {
        return this.f2369d;
    }

    /* renamed from: g */
    public List<C0864cr> m3602g() {
        return this.f2370e;
    }

    /* renamed from: h */
    public int m3603h() {
        return this.f2370e.size();
    }

    /* renamed from: a */
    public C0864cr m3596a(int i) {
        return this.f2370e.get(i);
    }

    /* renamed from: i */
    public boolean m3604i() {
        return (this.f2367b & 4) == 4;
    }

    /* renamed from: j */
    public String m3605j() {
        Object obj = this.f2371f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2371f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: t */
    private ByteString m3593t() {
        Object obj = this.f2371f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2371f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m3606k() {
        return (this.f2367b & 8) == 8;
    }

    /* renamed from: l */
    public boolean m3607l() {
        return this.f2372g;
    }

    /* renamed from: m */
    public boolean m3608m() {
        return (this.f2367b & 16) == 16;
    }

    /* renamed from: n */
    public String m3609n() {
        Object obj = this.f2373h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2373h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: u */
    private ByteString m3594u() {
        Object obj = this.f2373h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2373h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    public boolean m3610o() {
        return (this.f2367b & 32) == 32;
    }

    /* renamed from: p */
    public long m3611p() {
        return this.f2374i;
    }

    /* renamed from: v */
    private void m3595v() {
        this.f2368c = "";
        this.f2369d = EnumC0822bc.SINGLE;
        this.f2370e = Collections.emptyList();
        this.f2371f = "";
        this.f2372g = false;
        this.f2373h = "";
        this.f2374i = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2375j;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2375j = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2367b & 1) == 1) {
            codedOutputStream.writeBytes(1, m3592s());
        }
        if ((this.f2367b & 2) == 2) {
            codedOutputStream.writeEnum(2, this.f2369d.getNumber());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2370e.size()) {
                break;
            }
            codedOutputStream.writeMessage(3, this.f2370e.get(i2));
            i = i2 + 1;
        }
        if ((this.f2367b & 4) == 4) {
            codedOutputStream.writeBytes(4, m3593t());
        }
        if ((this.f2367b & 8) == 8) {
            codedOutputStream.writeBool(5, this.f2372g);
        }
        if ((this.f2367b & 16) == 16) {
            codedOutputStream.writeBytes(6, m3594u());
        }
        if ((this.f2367b & 32) == 32) {
            codedOutputStream.writeInt64(7, this.f2374i);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeInt64Size = this.f2376k;
        if (iComputeInt64Size == -1) {
            int iComputeBytesSize = (this.f2367b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m3592s()) + 0 : 0;
            if ((this.f2367b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeEnumSize(2, this.f2369d.getNumber());
            }
            while (true) {
                iComputeInt64Size = iComputeBytesSize;
                if (i >= this.f2370e.size()) {
                    break;
                }
                iComputeBytesSize = CodedOutputStream.computeMessageSize(3, this.f2370e.get(i)) + iComputeInt64Size;
                i++;
            }
            if ((this.f2367b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m3593t());
            }
            if ((this.f2367b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBoolSize(5, this.f2372g);
            }
            if ((this.f2367b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(6, m3594u());
            }
            if ((this.f2367b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(7, this.f2374i);
            }
            this.f2376k = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0826bg m3584a(byte[] bArr) {
        return ((C0827bh) newBuilder().mergeFrom(bArr)).m3618i();
    }

    public static C0827bh newBuilder() {
        return C0827bh.m3617h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public C0827bh newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0827bh m3585a(C0826bg c0826bg) {
        return newBuilder().mergeFrom(c0826bg);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public C0827bh toBuilder() {
        return m3585a(this);
    }

    static {
        f2366a.m3595v();
    }
}
