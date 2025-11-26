package com.sec.chaton.p046a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.es */
/* loaded from: classes.dex */
public final class C0919es extends GeneratedMessageLite implements InterfaceC0921eu {

    /* renamed from: a */
    private static final C0919es f2874a = new C0919es(true);

    /* renamed from: b */
    private List<C0892ds> f2875b;

    /* renamed from: c */
    private byte f2876c;

    /* renamed from: d */
    private int f2877d;

    private C0919es(C0920et c0920et) {
        super(c0920et);
        this.f2876c = (byte) -1;
        this.f2877d = -1;
    }

    private C0919es(boolean z) {
        this.f2876c = (byte) -1;
        this.f2877d = -1;
    }

    /* renamed from: a */
    public static C0919es m4979a() {
        return f2874a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0919es getDefaultInstanceForType() {
        return f2874a;
    }

    /* renamed from: c */
    public List<C0892ds> m4985c() {
        return this.f2875b;
    }

    /* renamed from: f */
    private void m4983f() {
        this.f2875b = Collections.emptyList();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f2876c;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f2876c = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f2875b.size()) {
                codedOutputStream.writeMessage(1, this.f2875b.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeMessageSize = this.f2877d;
        if (iComputeMessageSize == -1) {
            iComputeMessageSize = 0;
            for (int i = 0; i < this.f2875b.size(); i++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.f2875b.get(i));
            }
            this.f2877d = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    public static C0920et newBuilder() {
        return C0920et.m4990h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0920et newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0920et m4980a(C0919es c0919es) {
        return newBuilder().mergeFrom(c0919es);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0920et toBuilder() {
        return m4980a(this);
    }

    static {
        f2874a.m4983f();
    }
}
