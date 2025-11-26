package com.sec.chaton.p016a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.di */
/* loaded from: classes.dex */
public final class C0366di extends GeneratedMessageLite implements InterfaceC0368dk {

    /* renamed from: a */
    private static final C0366di f1272a = new C0366di(true);

    /* renamed from: b */
    private List<C0351cu> f1273b;

    /* renamed from: c */
    private byte f1274c;

    /* renamed from: d */
    private int f1275d;

    private C0366di(C0367dj c0367dj) {
        super(c0367dj);
        this.f1274c = (byte) -1;
        this.f1275d = -1;
    }

    private C0366di(boolean z) {
        this.f1274c = (byte) -1;
        this.f1275d = -1;
    }

    /* renamed from: a */
    public static C0366di m2462a() {
        return f1272a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0366di getDefaultInstanceForType() {
        return f1272a;
    }

    /* renamed from: c */
    public List<C0351cu> m2468c() {
        return this.f1273b;
    }

    /* renamed from: f */
    private void m2466f() {
        this.f1273b = Collections.emptyList();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b = this.f1274c;
        if (b != -1) {
            return b == 1;
        }
        this.f1274c = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1273b.size()) {
                codedOutputStream.writeMessage(1, this.f1273b.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeMessageSize = this.f1275d;
        if (iComputeMessageSize == -1) {
            iComputeMessageSize = 0;
            for (int i = 0; i < this.f1273b.size(); i++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.f1273b.get(i));
            }
            this.f1275d = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0367dj newBuilder() {
        return C0367dj.m2473h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0367dj newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0367dj m2463a(C0366di c0366di) {
        return newBuilder().mergeFrom(c0366di);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0367dj toBuilder() {
        return m2463a(this);
    }

    static {
        f1272a.m2466f();
    }
}
