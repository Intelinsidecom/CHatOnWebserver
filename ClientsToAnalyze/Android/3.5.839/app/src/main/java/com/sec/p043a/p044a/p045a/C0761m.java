package com.sec.p043a.p044a.p045a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.m */
/* loaded from: classes.dex */
public final class C0761m extends GeneratedMessageLite.Builder<C0760l, C0761m> implements InterfaceC0762n {

    /* renamed from: a */
    private int f1807a;

    /* renamed from: b */
    private int f1808b;

    /* renamed from: c */
    private Object f1809c = "";

    private C0761m() {
        m2657g();
    }

    /* renamed from: g */
    private void m2657g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0761m m2658h() {
        return new C0761m();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0761m clear() {
        super.clear();
        this.f1808b = 0;
        this.f1807a &= -2;
        this.f1809c = "";
        this.f1807a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0761m mo19949clone() {
        return m2658h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0760l getDefaultInstanceForType() {
        return C0760l.m2641a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0760l build() {
        C0760l c0760lBuildPartial = buildPartial();
        if (!c0760lBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0760lBuildPartial);
        }
        return c0760lBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0760l m2659i() throws InvalidProtocolBufferException {
        C0760l c0760lBuildPartial = buildPartial();
        if (!c0760lBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0760lBuildPartial).asInvalidProtocolBufferException();
        }
        return c0760lBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0760l buildPartial() {
        C0760l c0760l = new C0760l(this);
        int i = this.f1807a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0760l.f1803c = this.f1808b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0760l.f1804d = this.f1809c;
        c0760l.f1802b = i2;
        return c0760l;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0761m mergeFrom(C0760l c0760l) {
        if (c0760l != C0760l.m2641a()) {
            if (c0760l.m2649c()) {
                m2661a(c0760l.m2650d());
            }
            if (c0760l.m2651e()) {
                m2664a(c0760l.m2652f());
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
    public C0761m mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1807a |= 1;
                    this.f1808b = codedInputStream.readInt32();
                    break;
                case 18:
                    this.f1807a |= 2;
                    this.f1809c = codedInputStream.readBytes();
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
    public C0761m m2661a(int i) {
        this.f1807a |= 1;
        this.f1808b = i;
        return this;
    }

    /* renamed from: a */
    public C0761m m2664a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1807a |= 2;
        this.f1809c = str;
        return this;
    }
}
