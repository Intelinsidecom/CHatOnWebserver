package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ad */
/* loaded from: classes.dex */
public final class C0280ad extends GeneratedMessageLite implements InterfaceC0282af {

    /* renamed from: a */
    private static final C0280ad f884a = new C0280ad(true);

    /* renamed from: b */
    private int f885b;

    /* renamed from: c */
    private EnumC0302az f886c;

    /* renamed from: d */
    private Object f887d;

    /* renamed from: e */
    private LazyStringList f888e;

    /* renamed from: f */
    private long f889f;

    /* renamed from: g */
    private byte f890g;

    /* renamed from: h */
    private int f891h;

    private C0280ad(C0281ae c0281ae) {
        super(c0281ae);
        this.f890g = (byte) -1;
        this.f891h = -1;
    }

    private C0280ad(boolean z) {
        this.f890g = (byte) -1;
        this.f891h = -1;
    }

    /* renamed from: a */
    public static C0280ad m1417a() {
        return f884a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0280ad getDefaultInstanceForType() {
        return f884a;
    }

    /* renamed from: c */
    public boolean m1425c() {
        return (this.f885b & 1) == 1;
    }

    /* renamed from: d */
    public EnumC0302az m1426d() {
        return this.f886c;
    }

    /* renamed from: e */
    public boolean m1427e() {
        return (this.f885b & 2) == 2;
    }

    /* renamed from: f */
    public String m1428f() {
        Object obj = this.f887d;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f887d = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: l */
    private ByteString m1422l() {
        Object obj = this.f887d;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f887d = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: g */
    public List<String> m1429g() {
        return this.f888e;
    }

    /* renamed from: h */
    public boolean m1430h() {
        return (this.f885b & 4) == 4;
    }

    /* renamed from: i */
    public long m1431i() {
        return this.f889f;
    }

    /* renamed from: m */
    private void m1423m() {
        this.f886c = EnumC0302az.SINGLE;
        this.f887d = "";
        this.f888e = LazyStringArrayList.EMPTY;
        this.f889f = 0L;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f890g;
        if (b != -1) {
            return b == 1;
        }
        this.f890g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f885b & 1) == 1) {
            codedOutputStream.writeEnum(1, this.f886c.getNumber());
        }
        if ((this.f885b & 2) == 2) {
            codedOutputStream.writeBytes(2, m1422l());
        }
        for (int i = 0; i < this.f888e.size(); i++) {
            codedOutputStream.writeBytes(3, this.f888e.getByteString(i));
        }
        if ((this.f885b & 4) == 4) {
            codedOutputStream.writeInt64(4, this.f889f);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.f891h;
        if (size == -1) {
            int iComputeEnumSize = (this.f885b & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.f886c.getNumber()) + 0 : 0;
            if ((this.f885b & 2) == 2) {
                iComputeEnumSize += CodedOutputStream.computeBytesSize(2, m1422l());
            }
            int iComputeBytesSizeNoTag = 0;
            for (int i = 0; i < this.f888e.size(); i++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f888e.getByteString(i));
            }
            size = iComputeEnumSize + iComputeBytesSizeNoTag + (m1429g().size() * 1);
            if ((this.f885b & 4) == 4) {
                size += CodedOutputStream.computeInt64Size(4, this.f889f);
            }
            this.f891h = size;
        }
        return size;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0281ae newBuilder() {
        return C0281ae.m1436h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0281ae newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0281ae m1418a(C0280ad c0280ad) {
        return newBuilder().mergeFrom(c0280ad);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0281ae toBuilder() {
        return m1418a(this);
    }

    static {
        f884a.m1423m();
    }
}
