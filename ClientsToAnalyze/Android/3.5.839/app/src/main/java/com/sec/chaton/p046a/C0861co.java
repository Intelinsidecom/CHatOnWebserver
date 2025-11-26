package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.co */
/* loaded from: classes.dex */
public final class C0861co extends GeneratedMessageLite implements InterfaceC0863cq {

    /* renamed from: a */
    private static final C0861co f2540a = new C0861co(true);

    /* renamed from: b */
    private int f2541b;

    /* renamed from: c */
    private Object f2542c;

    /* renamed from: d */
    private Object f2543d;

    /* renamed from: e */
    private Object f2544e;

    /* renamed from: f */
    private List<C0867cu> f2545f;

    /* renamed from: g */
    private int f2546g;

    /* renamed from: h */
    private Object f2547h;

    /* renamed from: i */
    private long f2548i;

    /* renamed from: j */
    private long f2549j;

    /* renamed from: k */
    private long f2550k;

    /* renamed from: l */
    private byte f2551l;

    /* renamed from: m */
    private int f2552m;

    private C0861co(C0862cp c0862cp) {
        super(c0862cp);
        this.f2551l = (byte) -1;
        this.f2552m = -1;
    }

    private C0861co(boolean z) {
        this.f2551l = (byte) -1;
        this.f2552m = -1;
    }

    /* renamed from: a */
    public static C0861co m4069a() {
        return f2540a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0861co getDefaultInstanceForType() {
        return f2540a;
    }

    /* renamed from: c */
    public boolean m4087c() {
        return (this.f2541b & 1) == 1;
    }

    /* renamed from: d */
    public String m4088d() {
        Object obj = this.f2542c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2542c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m4081w() {
        Object obj = this.f2542c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2542c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m4089e() {
        return (this.f2541b & 2) == 2;
    }

    /* renamed from: f */
    public String m4090f() {
        Object obj = this.f2543d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2543d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m4082x() {
        Object obj = this.f2543d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2543d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m4091g() {
        return (this.f2541b & 4) == 4;
    }

    /* renamed from: h */
    public String m4092h() {
        Object obj = this.f2544e;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2544e = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m4083y() {
        Object obj = this.f2544e;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2544e = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: i */
    public List<C0867cu> m4093i() {
        return this.f2545f;
    }

    /* renamed from: j */
    public int m4094j() {
        return this.f2545f.size();
    }

    /* renamed from: a */
    public C0867cu m4085a(int i) {
        return this.f2545f.get(i);
    }

    /* renamed from: k */
    public boolean m4095k() {
        return (this.f2541b & 8) == 8;
    }

    /* renamed from: l */
    public int m4096l() {
        return this.f2546g;
    }

    /* renamed from: m */
    public boolean m4097m() {
        return (this.f2541b & 16) == 16;
    }

    /* renamed from: n */
    public String m4098n() {
        Object obj = this.f2547h;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2547h = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m4084z() {
        Object obj = this.f2547h;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2547h = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: o */
    public boolean m4099o() {
        return (this.f2541b & 32) == 32;
    }

    /* renamed from: p */
    public long m4100p() {
        return this.f2548i;
    }

    /* renamed from: q */
    public boolean m4101q() {
        return (this.f2541b & 64) == 64;
    }

    /* renamed from: r */
    public long m4102r() {
        return this.f2549j;
    }

    /* renamed from: s */
    public boolean m4103s() {
        return (this.f2541b & 128) == 128;
    }

    /* renamed from: t */
    public long m4104t() {
        return this.f2550k;
    }

    /* renamed from: A */
    private void m4066A() {
        this.f2542c = "";
        this.f2543d = "";
        this.f2544e = "";
        this.f2545f = Collections.emptyList();
        this.f2546g = 0;
        this.f2547h = "";
        this.f2548i = 0L;
        this.f2549j = 0L;
        this.f2550k = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2551l;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2551l = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2541b & 1) == 1) {
            codedOutputStream.writeBytes(1, m4081w());
        }
        if ((this.f2541b & 2) == 2) {
            codedOutputStream.writeBytes(2, m4082x());
        }
        if ((this.f2541b & 4) == 4) {
            codedOutputStream.writeBytes(3, m4083y());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2545f.size()) {
                break;
            }
            codedOutputStream.writeMessage(4, this.f2545f.get(i2));
            i = i2 + 1;
        }
        if ((this.f2541b & 8) == 8) {
            codedOutputStream.writeInt32(5, this.f2546g);
        }
        if ((this.f2541b & 16) == 16) {
            codedOutputStream.writeBytes(6, m4084z());
        }
        if ((this.f2541b & 32) == 32) {
            codedOutputStream.writeInt64(7, this.f2548i);
        }
        if ((this.f2541b & 64) == 64) {
            codedOutputStream.writeInt64(8, this.f2549j);
        }
        if ((this.f2541b & 128) == 128) {
            codedOutputStream.writeInt64(9, this.f2550k);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeInt64Size = this.f2552m;
        if (iComputeInt64Size == -1) {
            int iComputeBytesSize = (this.f2541b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m4081w()) + 0 : 0;
            if ((this.f2541b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(2, m4082x());
            }
            if ((this.f2541b & 4) == 4) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(3, m4083y());
            }
            while (true) {
                iComputeInt64Size = iComputeBytesSize;
                if (i >= this.f2545f.size()) {
                    break;
                }
                iComputeBytesSize = CodedOutputStream.computeMessageSize(4, this.f2545f.get(i)) + iComputeInt64Size;
                i++;
            }
            if ((this.f2541b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeInt32Size(5, this.f2546g);
            }
            if ((this.f2541b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(6, m4084z());
            }
            if ((this.f2541b & 32) == 32) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(7, this.f2548i);
            }
            if ((this.f2541b & 64) == 64) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(8, this.f2549j);
            }
            if ((this.f2541b & 128) == 128) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(9, this.f2550k);
            }
            this.f2552m = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0861co m4070a(byte[] bArr) {
        return ((C0862cp) newBuilder().mergeFrom(bArr)).m4111i();
    }

    public static C0862cp newBuilder() {
        return C0862cp.m4110h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public C0862cp newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0862cp m4071a(C0861co c0861co) {
        return newBuilder().mergeFrom(c0861co);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public C0862cp toBuilder() {
        return m4071a(this);
    }

    static {
        f2540a.m4066A();
    }
}
