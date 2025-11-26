package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cl */
/* loaded from: classes.dex */
public final class C0858cl extends GeneratedMessageLite implements InterfaceC0860cn {

    /* renamed from: a */
    private static final C0858cl f2523a = new C0858cl(true);

    /* renamed from: b */
    private int f2524b;

    /* renamed from: c */
    private Object f2525c;

    /* renamed from: d */
    private List<C0864cr> f2526d;

    /* renamed from: e */
    private boolean f2527e;

    /* renamed from: f */
    private Object f2528f;

    /* renamed from: g */
    private long f2529g;

    /* renamed from: h */
    private long f2530h;

    /* renamed from: i */
    private byte f2531i;

    /* renamed from: j */
    private int f2532j;

    private C0858cl(C0859cm c0859cm) {
        super(c0859cm);
        this.f2531i = (byte) -1;
        this.f2532j = -1;
    }

    private C0858cl(boolean z) {
        this.f2531i = (byte) -1;
        this.f2532j = -1;
    }

    /* renamed from: a */
    public static C0858cl m4019a() {
        return f2523a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0858cl getDefaultInstanceForType() {
        return f2523a;
    }

    /* renamed from: c */
    public boolean m4033c() {
        return (this.f2524b & 1) == 1;
    }

    /* renamed from: d */
    public String m4034d() {
        Object obj = this.f2525c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2525c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: q */
    private ByteString m4028q() {
        Object obj = this.f2525c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2525c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public List<C0864cr> m4035e() {
        return this.f2526d;
    }

    /* renamed from: f */
    public int m4036f() {
        return this.f2526d.size();
    }

    /* renamed from: a */
    public C0864cr m4031a(int i) {
        return this.f2526d.get(i);
    }

    /* renamed from: g */
    public boolean m4037g() {
        return (this.f2524b & 2) == 2;
    }

    /* renamed from: h */
    public boolean m4038h() {
        return this.f2527e;
    }

    /* renamed from: i */
    public boolean m4039i() {
        return (this.f2524b & 4) == 4;
    }

    /* renamed from: j */
    public String m4040j() {
        Object obj = this.f2528f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2528f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: r */
    private ByteString m4029r() {
        Object obj = this.f2528f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2528f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: k */
    public boolean m4041k() {
        return (this.f2524b & 8) == 8;
    }

    /* renamed from: l */
    public long m4042l() {
        return this.f2529g;
    }

    /* renamed from: m */
    public boolean m4043m() {
        return (this.f2524b & 16) == 16;
    }

    /* renamed from: n */
    public long m4044n() {
        return this.f2530h;
    }

    /* renamed from: s */
    private void m4030s() {
        this.f2525c = "";
        this.f2526d = Collections.emptyList();
        this.f2527e = false;
        this.f2528f = "";
        this.f2529g = 0L;
        this.f2530h = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2531i;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2531i = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2524b & 1) == 1) {
            codedOutputStream.writeBytes(1, m4028q());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f2526d.size()) {
                break;
            }
            codedOutputStream.writeMessage(2, this.f2526d.get(i2));
            i = i2 + 1;
        }
        if ((this.f2524b & 2) == 2) {
            codedOutputStream.writeBool(3, this.f2527e);
        }
        if ((this.f2524b & 4) == 4) {
            codedOutputStream.writeBytes(4, m4029r());
        }
        if ((this.f2524b & 8) == 8) {
            codedOutputStream.writeInt64(5, this.f2529g);
        }
        if ((this.f2524b & 16) == 16) {
            codedOutputStream.writeInt64(6, this.f2530h);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeInt64Size = this.f2532j;
        if (iComputeInt64Size == -1) {
            int iComputeBytesSize = (this.f2524b & 1) == 1 ? CodedOutputStream.computeBytesSize(1, m4028q()) + 0 : 0;
            while (true) {
                iComputeInt64Size = iComputeBytesSize;
                if (i >= this.f2526d.size()) {
                    break;
                }
                iComputeBytesSize = CodedOutputStream.computeMessageSize(2, this.f2526d.get(i)) + iComputeInt64Size;
                i++;
            }
            if ((this.f2524b & 2) == 2) {
                iComputeInt64Size += CodedOutputStream.computeBoolSize(3, this.f2527e);
            }
            if ((this.f2524b & 4) == 4) {
                iComputeInt64Size += CodedOutputStream.computeBytesSize(4, m4029r());
            }
            if ((this.f2524b & 8) == 8) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(5, this.f2529g);
            }
            if ((this.f2524b & 16) == 16) {
                iComputeInt64Size += CodedOutputStream.computeInt64Size(6, this.f2530h);
            }
            this.f2532j = iComputeInt64Size;
        }
        return iComputeInt64Size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0858cl m4020a(byte[] bArr) {
        return ((C0859cm) newBuilder().mergeFrom(bArr)).m4051i();
    }

    public static C0859cm newBuilder() {
        return C0859cm.m4050h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C0859cm newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0859cm m4021a(C0858cl c0858cl) {
        return newBuilder().mergeFrom(c0858cl);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public C0859cm toBuilder() {
        return m4021a(this);
    }

    static {
        f2523a.m4030s();
    }
}
