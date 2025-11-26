package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ag */
/* loaded from: classes.dex */
public final class C0799ag extends GeneratedMessageLite implements InterfaceC0801ai {

    /* renamed from: a */
    private static final C0799ag f2207a = new C0799ag(true);

    /* renamed from: b */
    private int f2208b;

    /* renamed from: c */
    private EnumC0822bc f2209c;

    /* renamed from: d */
    private Object f2210d;

    /* renamed from: e */
    private LazyStringList f2211e;

    /* renamed from: f */
    private long f2212f;

    /* renamed from: g */
    private long f2213g;

    /* renamed from: h */
    private boolean f2214h;

    /* renamed from: i */
    private byte f2215i;

    /* renamed from: j */
    private int f2216j;

    private C0799ag(C0800ah c0800ah) {
        super(c0800ah);
        this.f2215i = (byte) -1;
        this.f2216j = -1;
    }

    private C0799ag(boolean z) {
        this.f2215i = (byte) -1;
        this.f2216j = -1;
    }

    /* renamed from: a */
    public static C0799ag m3236a() {
        return f2207a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0799ag getDefaultInstanceForType() {
        return f2207a;
    }

    /* renamed from: c */
    public boolean m3246c() {
        return (this.f2208b & 1) == 1;
    }

    /* renamed from: d */
    public EnumC0822bc m3247d() {
        return this.f2209c;
    }

    /* renamed from: e */
    public boolean m3248e() {
        return (this.f2208b & 2) == 2;
    }

    /* renamed from: f */
    public String m3249f() {
        Object obj = this.f2210d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2210d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: p */
    private ByteString m3243p() {
        Object obj = this.f2210d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2210d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public List<String> m3250g() {
        return this.f2211e;
    }

    /* renamed from: h */
    public boolean m3251h() {
        return (this.f2208b & 4) == 4;
    }

    /* renamed from: i */
    public long m3252i() {
        return this.f2212f;
    }

    /* renamed from: j */
    public boolean m3253j() {
        return (this.f2208b & 8) == 8;
    }

    /* renamed from: k */
    public long m3254k() {
        return this.f2213g;
    }

    /* renamed from: l */
    public boolean m3255l() {
        return (this.f2208b & 16) == 16;
    }

    /* renamed from: m */
    public boolean m3256m() {
        return this.f2214h;
    }

    /* renamed from: q */
    private void m3244q() {
        this.f2209c = EnumC0822bc.SINGLE;
        this.f2210d = "";
        this.f2211e = LazyStringArrayList.EMPTY;
        this.f2212f = 0L;
        this.f2213g = 0L;
        this.f2214h = false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2215i;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2215i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2208b & 1) == 1) {
            codedOutputStream.writeEnum(1, this.f2209c.getNumber());
        }
        if ((this.f2208b & 2) == 2) {
            codedOutputStream.writeBytes(2, m3243p());
        }
        for (int i = 0; i < this.f2211e.size(); i++) {
            codedOutputStream.writeBytes(3, this.f2211e.getByteString(i));
        }
        if ((this.f2208b & 4) == 4) {
            codedOutputStream.writeInt64(4, this.f2212f);
        }
        if ((this.f2208b & 8) == 8) {
            codedOutputStream.writeInt64(5, this.f2213g);
        }
        if ((this.f2208b & 16) == 16) {
            codedOutputStream.writeBool(6, this.f2214h);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f2216j;
        if (size == -1) {
            int iComputeEnumSize = (this.f2208b & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.f2209c.getNumber()) + 0 : 0;
            if ((this.f2208b & 2) == 2) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(2, m3243p());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f2211e.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f2211e.getByteString(i));
            }
            size = iComputeEnumSize + iComputeBytesSizeNoTag + (m3250g().size() * 1);
            if ((this.f2208b & 4) == 4) {
                size += CodedOutputStream.computeInt64Size(4, this.f2212f);
            }
            if ((this.f2208b & 8) == 8) {
                size += CodedOutputStream.computeInt64Size(5, this.f2213g);
            }
            if ((this.f2208b & 16) == 16) {
                size += CodedOutputStream.computeBoolSize(6, this.f2214h);
            }
            this.f2216j = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0800ah newBuilder() {
        return C0800ah.m3261h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C0800ah newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0800ah m3237a(C0799ag c0799ag) {
        return newBuilder().mergeFrom(c0799ag);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0800ah toBuilder() {
        return m3237a(this);
    }

    static {
        f2207a.m3244q();
    }
}
