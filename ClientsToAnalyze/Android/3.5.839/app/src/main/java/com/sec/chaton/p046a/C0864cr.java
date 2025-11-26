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
/* renamed from: com.sec.chaton.a.cr */
/* loaded from: classes.dex */
public final class C0864cr extends GeneratedMessageLite implements InterfaceC0866ct {

    /* renamed from: a */
    private static final C0864cr f2563a = new C0864cr(true);

    /* renamed from: b */
    private int f2564b;

    /* renamed from: c */
    private Object f2565c;

    /* renamed from: d */
    private LazyStringList f2566d;

    /* renamed from: e */
    private long f2567e;

    /* renamed from: f */
    private Object f2568f;

    /* renamed from: g */
    private long f2569g;

    /* renamed from: h */
    private EnumC0908eh f2570h;

    /* renamed from: i */
    private EnumC0822bc f2571i;

    /* renamed from: j */
    private Object f2572j;

    /* renamed from: k */
    private Object f2573k;

    /* renamed from: l */
    private byte f2574l;

    /* renamed from: m */
    private int f2575m;

    private C0864cr(C0865cs c0865cs) {
        super(c0865cs);
        this.f2574l = (byte) -1;
        this.f2575m = -1;
    }

    private C0864cr(boolean z) {
        this.f2574l = (byte) -1;
        this.f2575m = -1;
    }

    /* renamed from: a */
    public static C0864cr m4134a() {
        return f2563a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0864cr getDefaultInstanceForType() {
        return f2563a;
    }

    /* renamed from: c */
    public boolean m4149c() {
        return (this.f2564b & 1) == 1;
    }

    /* renamed from: d */
    public String m4150d() {
        Object obj = this.f2565c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2565c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: w */
    private ByteString m4143w() {
        Object obj = this.f2565c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2565c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List<String> m4151e() {
        return this.f2566d;
    }

    /* renamed from: f */
    public int m4152f() {
        return this.f2566d.size();
    }

    /* renamed from: a */
    public String m4147a(int i) {
        return this.f2566d.get(i);
    }

    /* renamed from: g */
    public boolean m4153g() {
        return (this.f2564b & 2) == 2;
    }

    /* renamed from: h */
    public long m4154h() {
        return this.f2567e;
    }

    /* renamed from: i */
    public boolean m4155i() {
        return (this.f2564b & 4) == 4;
    }

    /* renamed from: j */
    public String m4156j() {
        Object obj = this.f2568f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2568f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: x */
    private ByteString m4144x() {
        Object obj = this.f2568f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2568f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m4157k() {
        return (this.f2564b & 8) == 8;
    }

    /* renamed from: l */
    public long m4158l() {
        return this.f2569g;
    }

    /* renamed from: m */
    public boolean m4159m() {
        return (this.f2564b & 16) == 16;
    }

    /* renamed from: n */
    public EnumC0908eh m4160n() {
        return this.f2570h;
    }

    /* renamed from: o */
    public boolean m4161o() {
        return (this.f2564b & 32) == 32;
    }

    /* renamed from: p */
    public EnumC0822bc m4162p() {
        return this.f2571i;
    }

    /* renamed from: q */
    public boolean m4163q() {
        return (this.f2564b & 64) == 64;
    }

    /* renamed from: r */
    public String m4164r() {
        Object obj = this.f2572j;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2572j = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: y */
    private ByteString m4145y() {
        Object obj = this.f2572j;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2572j = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: s */
    public boolean m4165s() {
        return (this.f2564b & 128) == 128;
    }

    /* renamed from: t */
    public String m4166t() {
        Object obj = this.f2573k;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2573k = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: z */
    private ByteString m4146z() {
        Object obj = this.f2573k;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2573k = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: A */
    private void m4129A() {
        this.f2565c = "";
        this.f2566d = LazyStringArrayList.EMPTY;
        this.f2567e = 0L;
        this.f2568f = "";
        this.f2569g = 0L;
        this.f2570h = EnumC0908eh.TEXT;
        this.f2571i = EnumC0822bc.SINGLE;
        this.f2572j = "";
        this.f2573k = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2574l;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2574l = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2564b & 1) == 1) {
            codedOutputStream.writeBytes(1, m4143w());
        }
        for (int i = 0; i < this.f2566d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f2566d.getByteString(i));
        }
        if ((this.f2564b & 2) == 2) {
            codedOutputStream.writeInt64(3, this.f2567e);
        }
        if ((this.f2564b & 4) == 4) {
            codedOutputStream.writeBytes(4, m4144x());
        }
        if ((this.f2564b & 8) == 8) {
            codedOutputStream.writeInt64(5, this.f2569g);
        }
        if ((this.f2564b & 16) == 16) {
            codedOutputStream.writeEnum(6, this.f2570h.getNumber());
        }
        if ((this.f2564b & 32) == 32) {
            codedOutputStream.writeEnum(7, this.f2571i.getNumber());
        }
        if ((this.f2564b & 64) == 64) {
            codedOutputStream.writeBytes(8, m4145y());
        }
        if ((this.f2564b & 128) == 128) {
            codedOutputStream.writeBytes(9, m4146z());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f2575m;
        if (size == -1) {
            int iComputeBytesSize = (this.f2564b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m4143w()) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f2566d.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f2566d.getByteString(i));
            }
            size = iComputeBytesSize + iComputeBytesSizeNoTag + (m4151e().size() * 1);
            if ((this.f2564b & 2) == 2) {
                size += CodedOutputStream.computeInt64Size(3, this.f2567e);
            }
            if ((this.f2564b & 4) == 4) {
                size += CodedOutputStream.computeBytesSize(4, m4144x());
            }
            if ((this.f2564b & 8) == 8) {
                size += CodedOutputStream.computeInt64Size(5, this.f2569g);
            }
            if ((this.f2564b & 16) == 16) {
                size += CodedOutputStream.computeEnumSize(6, this.f2570h.getNumber());
            }
            if ((this.f2564b & 32) == 32) {
                size += CodedOutputStream.computeEnumSize(7, this.f2571i.getNumber());
            }
            if ((this.f2564b & 64) == 64) {
                size += CodedOutputStream.computeBytesSize(8, m4145y());
            }
            if ((this.f2564b & 128) == 128) {
                size += CodedOutputStream.computeBytesSize(9, m4146z());
            }
            this.f2575m = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0865cs newBuilder() {
        return C0865cs.m4171h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public C0865cs newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0865cs m4135a(C0864cr c0864cr) {
        return newBuilder().mergeFrom(c0864cr);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public C0865cs toBuilder() {
        return m4135a(this);
    }

    static {
        f2563a.m4129A();
    }
}
