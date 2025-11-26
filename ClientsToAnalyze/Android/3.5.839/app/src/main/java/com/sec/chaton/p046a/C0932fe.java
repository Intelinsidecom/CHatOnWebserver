package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fe */
/* loaded from: classes.dex */
public final class C0932fe extends GeneratedMessageLite implements InterfaceC0934fg {

    /* renamed from: a */
    private static final C0932fe f2925a = new C0932fe(true);

    /* renamed from: b */
    private int f2926b;

    /* renamed from: c */
    private long f2927c;

    /* renamed from: d */
    private Object f2928d;

    /* renamed from: e */
    private long f2929e;

    /* renamed from: f */
    private Object f2930f;

    /* renamed from: g */
    private Object f2931g;

    /* renamed from: h */
    private List<C0867cu> f2932h;

    /* renamed from: i */
    private C0846c f2933i;

    /* renamed from: j */
    private long f2934j;

    /* renamed from: k */
    private long f2935k;

    /* renamed from: l */
    private boolean f2936l;

    /* renamed from: m */
    private byte f2937m;

    /* renamed from: n */
    private int f2938n;

    private C0932fe(C0933ff c0933ff) {
        super(c0933ff);
        this.f2937m = (byte) -1;
        this.f2938n = -1;
    }

    private C0932fe(boolean z) {
        this.f2937m = (byte) -1;
        this.f2938n = -1;
    }

    /* renamed from: a */
    public static C0932fe m5144a() {
        return f2925a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0932fe getDefaultInstanceForType() {
        return f2925a;
    }

    /* renamed from: c */
    public boolean m5160c() {
        return (this.f2926b & 1) == 1;
    }

    /* renamed from: d */
    public long m5161d() {
        return this.f2927c;
    }

    /* renamed from: e */
    public boolean m5162e() {
        return (this.f2926b & 2) == 2;
    }

    /* renamed from: f */
    public String m5163f() {
        Object obj = this.f2928d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2928d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m5156y() {
        Object obj = this.f2928d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2928d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public boolean m5164g() {
        return (this.f2926b & 4) == 4;
    }

    /* renamed from: h */
    public long m5165h() {
        return this.f2929e;
    }

    /* renamed from: i */
    public boolean m5166i() {
        return (this.f2926b & 8) == 8;
    }

    /* renamed from: j */
    public String m5167j() {
        Object obj = this.f2930f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2930f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m5157z() {
        Object obj = this.f2930f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2930f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m5168k() {
        return (this.f2926b & 16) == 16;
    }

    /* renamed from: l */
    public String m5169l() {
        Object obj = this.f2931g;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2931g = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: A */
    private ByteString m5139A() {
        Object obj = this.f2931g;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2931g = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    public List<C0867cu> m5170m() {
        return this.f2932h;
    }

    /* renamed from: n */
    public int m5171n() {
        return this.f2932h.size();
    }

    /* renamed from: a */
    public C0867cu m5158a(int i) {
        return this.f2932h.get(i);
    }

    /* renamed from: o */
    public boolean m5172o() {
        return (this.f2926b & 32) == 32;
    }

    /* renamed from: p */
    public C0846c m5173p() {
        return this.f2933i;
    }

    /* renamed from: q */
    public boolean m5174q() {
        return (this.f2926b & 64) == 64;
    }

    /* renamed from: r */
    public long m5175r() {
        return this.f2934j;
    }

    /* renamed from: s */
    public boolean m5176s() {
        return (this.f2926b & 128) == 128;
    }

    /* renamed from: t */
    public long m5177t() {
        return this.f2935k;
    }

    /* renamed from: u */
    public boolean m5178u() {
        return (this.f2926b & 256) == 256;
    }

    /* renamed from: v */
    public boolean m5179v() {
        return this.f2936l;
    }

    /* renamed from: B */
    private void m5140B() {
        this.f2927c = 0L;
        this.f2928d = "";
        this.f2929e = 0L;
        this.f2930f = "";
        this.f2931g = "";
        this.f2932h = Collections.emptyList();
        this.f2933i = C0846c.m3819a();
        this.f2934j = 0L;
        this.f2935k = 0L;
        this.f2936l = false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2937m;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2937m = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2926b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f2927c);
        }
        if ((this.f2926b & 2) == 2) {
            codedOutputStream.writeBytes(2, m5156y());
        }
        if ((this.f2926b & 4) == 4) {
            codedOutputStream.writeInt64(3, this.f2929e);
        }
        if ((this.f2926b & 8) == 8) {
            codedOutputStream.writeBytes(4, m5157z());
        }
        if ((this.f2926b & 16) == 16) {
            codedOutputStream.writeBytes(5, m5139A());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2932h.size()) {
                break;
            }
            codedOutputStream.writeMessage(6, this.f2932h.get(i2));
            i = i2 + 1;
        }
        if ((this.f2926b & 32) == 32) {
            codedOutputStream.writeMessage(7, this.f2933i);
        }
        if ((this.f2926b & 64) == 64) {
            codedOutputStream.writeInt64(8, this.f2934j);
        }
        if ((this.f2926b & 128) == 128) {
            codedOutputStream.writeInt64(9, this.f2935k);
        }
        if ((this.f2926b & 256) == 256) {
            codedOutputStream.writeBool(10, this.f2936l);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeBoolSize = this.f2938n;
        if (iComputeBoolSize == -1) {
            int iComputeInt64Size = (this.f2926b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f2927c) + 0 : 0;
            if ((this.f2926b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(2, m5156y());
            }
            if ((this.f2926b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(3, this.f2929e);
            }
            if ((this.f2926b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m5157z());
            }
            if ((this.f2926b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(5, m5139A());
            }
            while (true) {
                iComputeBoolSize = iComputeInt64Size;
                if (i >= this.f2932h.size()) {
                    break;
                }
                iComputeInt64Size = CodedOutputStream.computeMessageSize(6, this.f2932h.get(i)) + iComputeBoolSize;
                i++;
            }
            if ((this.f2926b & 32) == 32) {
                iComputeBoolSize += CodedOutputStream.computeMessageSize(7, this.f2933i);
            }
            if ((this.f2926b & 64) == 64) {
                iComputeBoolSize += CodedOutputStream.computeInt64Size(8, this.f2934j);
            }
            if ((this.f2926b & 128) == 128) {
                iComputeBoolSize += CodedOutputStream.computeInt64Size(9, this.f2935k);
            }
            if ((this.f2926b & 256) == 256) {
                iComputeBoolSize += CodedOutputStream.computeBoolSize(10, this.f2936l);
            }
            this.f2938n = iComputeBoolSize;
        }
        return iComputeBoolSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0932fe m5145a(byte[] bArr) {
        return ((C0933ff) newBuilder().mergeFrom(bArr)).m5186k();
    }

    public static C0933ff newBuilder() {
        return C0933ff.m5185j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public C0933ff newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0933ff m5146a(C0932fe c0932fe) {
        return newBuilder().mergeFrom(c0932fe);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public C0933ff toBuilder() {
        return m5146a(this);
    }

    static {
        f2925a.m5140B();
    }
}
