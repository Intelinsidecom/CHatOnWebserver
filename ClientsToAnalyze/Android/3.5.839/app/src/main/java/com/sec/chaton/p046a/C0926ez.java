package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ez */
/* loaded from: classes.dex */
public final class C0926ez extends GeneratedMessageLite.Builder<C0925ey, C0926ez> implements InterfaceC0928fa {

    /* renamed from: a */
    private int f2897a;

    /* renamed from: b */
    private Object f2898b = "";

    /* renamed from: c */
    private boolean f2899c;

    private C0926ez() {
        m5049g();
    }

    /* renamed from: g */
    private void m5049g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0926ez m5050h() {
        return new C0926ez();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0926ez clear() {
        super.clear();
        this.f2898b = "";
        this.f2897a &= -2;
        this.f2899c = false;
        this.f2897a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0926ez mo19949clone() {
        return m5050h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0925ey getDefaultInstanceForType() {
        return C0925ey.m5035a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0925ey build() {
        C0925ey c0925eyBuildPartial = buildPartial();
        if (!c0925eyBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0925eyBuildPartial);
        }
        return c0925eyBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0925ey buildPartial() {
        C0925ey c0925ey = new C0925ey(this);
        int i = this.f2897a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0925ey.f2893c = this.f2898b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0925ey.f2894d = this.f2899c;
        c0925ey.f2892b = i2;
        return c0925ey;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0926ez mergeFrom(C0925ey c0925ey) {
        if (c0925ey != C0925ey.m5035a()) {
            if (c0925ey.m5042c()) {
                m5054a(c0925ey.m5043d());
            }
            if (c0925ey.m5044e()) {
                m5055a(c0925ey.m5045f());
            }
        }
        return this;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0926ez mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2897a |= 1;
                    this.f2898b = codedInputStream.readBytes();
                    break;
                case 16:
                    this.f2897a |= 2;
                    this.f2899c = codedInputStream.readBool();
                    break;
                default:
                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, tag)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }

    /* renamed from: a */
    public C0926ez m5054a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2897a |= 1;
        this.f2898b = str;
        return this;
    }

    /* renamed from: a */
    public C0926ez m5055a(boolean z) {
        this.f2897a |= 2;
        this.f2899c = z;
        return this;
    }
}
