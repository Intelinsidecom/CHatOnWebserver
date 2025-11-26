package com.sec.chaton.p007a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import java.io.IOException;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cg */
/* loaded from: classes.dex */
public final class C0168cg extends GeneratedMessageLite implements InterfaceC0170ci {

    /* renamed from: a */
    private static final C0168cg f612a = new C0168cg(true);

    /* renamed from: b */
    private int f613b;

    /* renamed from: c */
    private long f614c;

    /* renamed from: d */
    private LazyStringList f615d;

    /* renamed from: e */
    private byte f616e;

    /* renamed from: f */
    private int f617f;

    private C0168cg(C0169ch c0169ch) {
        super(c0169ch);
        this.f616e = (byte) -1;
        this.f617f = -1;
    }

    private C0168cg(boolean z) {
        this.f616e = (byte) -1;
        this.f617f = -1;
    }

    /* renamed from: a */
    public static C0168cg m1430a() {
        return f612a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0168cg getDefaultInstanceForType() {
        return f612a;
    }

    /* renamed from: c */
    public boolean m1436c() {
        return (this.f613b & 1) == 1;
    }

    /* renamed from: d */
    public long m1437d() {
        return this.f614c;
    }

    /* renamed from: e */
    public List m1438e() {
        return this.f615d;
    }

    /* renamed from: h */
    private void m1434h() {
        this.f614c = 0L;
        this.f615d = LazyStringArrayList.EMPTY;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f616e;
        if (b != -1) {
            return b == 1;
        }
        this.f616e = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.f613b & 1) == 1) {
            codedOutputStream.writeInt64(1, this.f614c);
        }
        for (int i = 0; i < this.f615d.size(); i++) {
            codedOutputStream.writeBytes(2, this.f615d.getByteString(i));
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.f617f;
        if (i == -1) {
            int iComputeInt64Size = (this.f613b & 1) == 1 ? CodedOutputStream.computeInt64Size(1, this.f614c) + 0 : 0;
            int iComputeBytesSizeNoTag = 0;
            for (int i2 = 0; i2 < this.f615d.size(); i2++) {
                iComputeBytesSizeNoTag += CodedOutputStream.computeBytesSizeNoTag(this.f615d.getByteString(i2));
            }
            int size = iComputeInt64Size + iComputeBytesSizeNoTag + (m1438e().size() * 1);
            this.f617f = size;
            return size;
        }
        return i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* renamed from: a */
    public static C0168cg m1431a(byte[] bArr) {
        return ((C0169ch) newBuilder().mergeFrom(bArr)).m1445k();
    }

    public static C0169ch newBuilder() {
        return C0169ch.m1444j();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0169ch newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0169ch m1432a(C0168cg c0168cg) {
        return newBuilder().mergeFrom(c0168cg);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public C0169ch toBuilder() {
        return m1432a(this);
    }

    static {
        f612a.m1434h();
    }
}
