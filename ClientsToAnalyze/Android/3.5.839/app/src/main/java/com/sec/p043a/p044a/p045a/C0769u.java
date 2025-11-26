package com.sec.p043a.p044a.p045a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.u */
/* loaded from: classes.dex */
public final class C0769u extends GeneratedMessageLite implements InterfaceC0771w {

    /* renamed from: a */
    private static final C0769u f1844a = new C0769u(true);

    /* renamed from: b */
    private List<C0766r> f1845b;

    /* renamed from: c */
    private byte f1846c;

    /* renamed from: d */
    private int f1847d;

    private C0769u(C0770v c0770v) {
        super(c0770v);
        this.f1846c = (byte) -1;
        this.f1847d = -1;
    }

    private C0769u(boolean z) {
        this.f1846c = (byte) -1;
        this.f1847d = -1;
    }

    /* renamed from: a */
    public static C0769u m2765a() {
        return f1844a;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0769u getDefaultInstanceForType() {
        return f1844a;
    }

    /* renamed from: c */
    public List<C0766r> m2772c() {
        return this.f1845b;
    }

    /* renamed from: d */
    public int m2773d() {
        return this.f1845b.size();
    }

    /* renamed from: g */
    private void m2770g() {
        this.f1845b = Collections.emptyList();
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.f1846c;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.f1846c = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1845b.size()) {
                codedOutputStream.writeMessage(1, this.f1845b.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int iComputeMessageSize = this.f1847d;
        if (iComputeMessageSize == -1) {
            iComputeMessageSize = 0;
            for (int i = 0; i < this.f1845b.size(); i++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.f1845b.get(i));
            }
            this.f1847d = iComputeMessageSize;
        }
        return iComputeMessageSize;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected Object writeReplace() {
        return super.writeReplace();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static C0769u m2766a(byte[] bArr) {
        return ((C0770v) newBuilder().mergeFrom(bArr)).m2780i();
    }

    public static C0770v newBuilder() {
        return C0770v.m2779h();
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0770v newBuilderForType() {
        return newBuilder();
    }

    /* renamed from: a */
    public static C0770v m2767a(C0769u c0769u) {
        return newBuilder().mergeFrom(c0769u);
    }

    @Override // com.google.protobuf.MessageLite
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public C0770v toBuilder() {
        return m2767a(this);
    }

    static {
        f1844a.m2770g();
    }
}
