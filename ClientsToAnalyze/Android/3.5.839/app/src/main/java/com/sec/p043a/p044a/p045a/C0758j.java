package com.sec.p043a.p044a.p045a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.j */
/* loaded from: classes.dex */
public final class C0758j extends GeneratedMessageLite.Builder<C0757i, C0758j> implements InterfaceC0759k {

    /* renamed from: a */
    private int f1797a;

    /* renamed from: b */
    private int f1798b;

    /* renamed from: c */
    private int f1799c;

    /* renamed from: d */
    private Object f1800d = "";

    private C0758j() {
        m2627g();
    }

    /* renamed from: g */
    private void m2627g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0758j m2628h() {
        return new C0758j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0758j clear() {
        super.clear();
        this.f1798b = 0;
        this.f1797a &= -2;
        this.f1799c = 0;
        this.f1797a &= -3;
        this.f1800d = "";
        this.f1797a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0758j mo19949clone() {
        return m2628h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0757i getDefaultInstanceForType() {
        return C0757i.m2608a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0757i build() {
        C0757i c0757iBuildPartial = buildPartial();
        if (!c0757iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0757iBuildPartial);
        }
        return c0757iBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0757i m2629i() throws InvalidProtocolBufferException {
        C0757i c0757iBuildPartial = buildPartial();
        if (!c0757iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0757iBuildPartial).asInvalidProtocolBufferException();
        }
        return c0757iBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0757i buildPartial() {
        C0757i c0757i = new C0757i(this);
        int i = this.f1797a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0757i.f1792c = this.f1798b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0757i.f1793d = this.f1799c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0757i.f1794e = this.f1800d;
        c0757i.f1791b = i2;
        return c0757i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0758j mergeFrom(C0757i c0757i) {
        if (c0757i != C0757i.m2608a()) {
            if (c0757i.m2617c()) {
                m2631a(c0757i.m2618d());
            }
            if (c0757i.m2619e()) {
                m2636b(c0757i.m2620f());
            }
            if (c0757i.m2621g()) {
                m2634a(c0757i.m2622h());
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
    public C0758j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1797a |= 1;
                    this.f1798b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f1797a |= 2;
                    this.f1799c = codedInputStream.readInt32();
                    break;
                case 26:
                    this.f1797a |= 4;
                    this.f1800d = codedInputStream.readBytes();
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
    public C0758j m2631a(int i) {
        this.f1797a |= 1;
        this.f1798b = i;
        return this;
    }

    /* renamed from: b */
    public C0758j m2636b(int i) {
        this.f1797a |= 2;
        this.f1799c = i;
        return this;
    }

    /* renamed from: a */
    public C0758j m2634a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1797a |= 4;
        this.f1800d = str;
        return this;
    }
}
