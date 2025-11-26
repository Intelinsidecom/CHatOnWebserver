package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.gi */
/* loaded from: classes.dex */
public final class C0963gi extends GeneratedMessageLite implements InterfaceC0965gk {

    /* renamed from: a */
    private static final C0963gi f3094a = new C0963gi(true);

    /* renamed from: b */
    private int f3095b;

    /* renamed from: c */
    private long f3096c;

    /* renamed from: d */
    private LazyStringList f3097d;

    /* renamed from: e */
    private List<C0892ds> f3098e;

    /* renamed from: f */
    private Object f3099f;

    /* renamed from: g */
    private byte f3100g;

    /* renamed from: h */
    private int f3101h;

    private C0963gi(C0964gj c0964gj) {
        super(c0964gj);
        this.f3100g = (byte) -1;
        this.f3101h = -1;
    }

    private C0963gi(boolean z) {
        this.f3100g = (byte) -1;
        this.f3101h = -1;
    }

    /* renamed from: a */
    public static C0963gi m5611a() {
        return f3094a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0963gi getDefaultInstanceForType() {
        return f3094a;
    }

    /* renamed from: c */
    public boolean m5620c() {
        return (this.f3095b & 1) == 1;
    }

    /* renamed from: d */
    public long m5621d() {
        return this.f3096c;
    }

    /* renamed from: e */
    public List<String> m5622e() {
        return this.f3097d;
    }

    /* renamed from: f */
    public int m5623f() {
        return this.f3097d.size();
    }

    /* renamed from: g */
    public List<C0892ds> m5624g() {
        return this.f3098e;
    }

    /* renamed from: h */
    public boolean m5625h() {
        return (this.f3095b & 2) == 2;
    }

    /* renamed from: i */
    public String m5626i() {
        Object obj = this.f3099f;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (Internal.isValidUtf8(byteString)) {
            this.f3099f = stringUtf8;
        }
        return stringUtf8;
    }

    /* renamed from: l */
    private ByteString m5617l() {
        Object obj = this.f3099f;
        if (!(obj instanceof String)) {
            return (ByteString) obj;
        }
        ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
        this.f3099f = byteStringCopyFromUtf8;
        return byteStringCopyFromUtf8;
    }

    /* renamed from: m */
    private void m5618m() {
        this.f3096c = 0L;
        this.f3097d = LazyStringArrayList.EMPTY;
        this.f3098e = Collections.emptyList();
        this.f3099f = "";
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f3100g;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f3100g = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f3095b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f3096c);
        }
        for (int i = 0; i < this.f3097d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f3097d.getByteString(i));
        }
        for (int i2 = 0; i2 < this.f3098e.size(); i2++) {
            codedOutputStream.writeMessage(3, this.f3098e.get(i2));
        }
        if ((this.f3095b & 2) == 2) {
            codedOutputStream.writeBytes(4, m5617l());
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = 0;
        int iComputeBytesSize = this.f3101h;
        if (iComputeBytesSize == -1) {
            int iComputeInt64Size = (this.f3095b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f3096c) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f3097d.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f3097d.getByteString(i2));
            }
            int size = iComputeInt64Size + iComputeBytesSizeNoTag + (m5622e().size() * 1);
            while (true) {
                iComputeBytesSize = size;
                if (i >= this.f3098e.size()) {
                    break;
                }
                size = CodedOutputStream.computeMessageSize(3, this.f3098e.get(i)) + iComputeBytesSize;
                i++;
            }
            if ((this.f3095b & 2) == 2) {
                iComputeBytesSize += CodedOutputStream.computeBytesSize(4, m5617l());
            }
            this.f3101h = iComputeBytesSize;
        }
        return iComputeBytesSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0964gj newBuilder() {
        return C0964gj.m5631h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0964gj newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0964gj m5612a(C0963gi c0963gi) {
        return newBuilder().mergeFrom(c0963gi);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0964gj toBuilder() {
        return m5612a(this);
    }

    static {
        f3094a.m5618m();
    }
}
