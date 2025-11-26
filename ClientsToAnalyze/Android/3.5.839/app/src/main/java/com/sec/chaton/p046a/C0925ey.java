package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import java.io.IOException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ey */
/* loaded from: classes.dex */
public final class C0925ey extends GeneratedMessageLite implements InterfaceC0928fa {

    /* renamed from: a */
    private static final C0925ey f2891a = new C0925ey(true);

    /* renamed from: b */
    private int f2892b;

    /* renamed from: c */
    private Object f2893c;

    /* renamed from: d */
    private boolean f2894d;

    /* renamed from: e */
    private byte f2895e;

    /* renamed from: f */
    private int f2896f;

    private C0925ey(C0926ez c0926ez) {
        super(c0926ez);
        this.f2895e = (byte) -1;
        this.f2896f = -1;
    }

    private C0925ey(boolean z) {
        this.f2895e = (byte) -1;
        this.f2896f = -1;
    }

    /* renamed from: a */
    public static C0925ey m5035a() {
        return f2891a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0925ey getDefaultInstanceForType() {
        return f2891a;
    }

    /* renamed from: c */
    public boolean m5042c() {
        return (this.f2892b & 1) == 1;
    }

    /* renamed from: d */
    public String m5043d() {
        Object obj = this.f2893c;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f2893c = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: i */
    private ByteString m5039i() {
        Object obj = this.f2893c;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f2893c = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: e */
    public boolean m5044e() {
        return (this.f2892b & 2) == 2;
    }

    /* renamed from: f */
    public boolean m5045f() {
        return this.f2894d;
    }

    /* renamed from: j */
    private void m5040j() {
        this.f2893c = "";
        this.f2894d = false;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2895e;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2895e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f2892b & 1) == 1) {
            codedOutputStream.writeBytes(1, m5039i());
        }
        if ((this.f2892b & 2) == 2) {
            codedOutputStream.writeBool(2, this.f2894d);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeBytesSize = this.f2896f;
        if (iComputeBytesSize == -1) {
            iComputeBytesSize = (this.f2892b & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, m5039i()) : 0;
            if ((this.f2892b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBoolSize(2, this.f2894d);
            }
            this.f2896f = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0926ez newBuilder() {
        return C0926ez.m5050h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0926ez newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0926ez m5036a(C0925ey c0925ey) {
        return newBuilder().mergeFrom(c0925ey);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public C0926ez toBuilder() {
        return m5036a(this);
    }

    static {
        f2891a.m5040j();
    }
}
