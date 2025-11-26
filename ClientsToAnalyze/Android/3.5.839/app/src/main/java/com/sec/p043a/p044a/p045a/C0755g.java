package com.sec.p043a.p044a.p045a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.g */
/* loaded from: classes.dex */
public final class C0755g extends GeneratedMessageLite.Builder<C0754f, C0755g> implements InterfaceC0756h {

    /* renamed from: a */
    private int f1785a;

    /* renamed from: b */
    private int f1786b;

    /* renamed from: c */
    private Object f1787c = "";

    /* renamed from: d */
    private Object f1788d = "";

    /* renamed from: e */
    private Object f1789e = "";

    private C0755g() {
        m2593g();
    }

    /* renamed from: g */
    private void m2593g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0755g m2594h() {
        return new C0755g();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0755g clear() {
        super.clear();
        this.f1786b = 0;
        this.f1785a &= -2;
        this.f1787c = "";
        this.f1785a &= -3;
        this.f1788d = "";
        this.f1785a &= -5;
        this.f1789e = "";
        this.f1785a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0755g mo19949clone() {
        return m2594h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0754f getDefaultInstanceForType() {
        return C0754f.m2569a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0754f build() {
        C0754f c0754fBuildPartial = buildPartial();
        if (!c0754fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0754fBuildPartial);
        }
        return c0754fBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0754f m2595i() throws InvalidProtocolBufferException {
        C0754f c0754fBuildPartial = buildPartial();
        if (!c0754fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0754fBuildPartial).asInvalidProtocolBufferException();
        }
        return c0754fBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0754f buildPartial() {
        C0754f c0754f = new C0754f(this);
        int i = this.f1785a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0754f.f1779c = this.f1786b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0754f.f1780d = this.f1787c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0754f.f1781e = this.f1788d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0754f.f1782f = this.f1789e;
        c0754f.f1778b = i2;
        return c0754f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0755g mergeFrom(C0754f c0754f) {
        if (c0754f != C0754f.m2569a()) {
            if (c0754f.m2581c()) {
                m2597a(c0754f.m2582d());
            }
            if (c0754f.m2583e()) {
                m2600a(c0754f.m2584f());
            }
            if (c0754f.m2585g()) {
                m2602b(c0754f.m2586h());
            }
            if (c0754f.m2587i()) {
                m2604c(c0754f.m2588j());
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
    public C0755g mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1785a |= 1;
                    this.f1786b = codedInputStream.readInt32();
                    break;
                case 18:
                    this.f1785a |= 2;
                    this.f1787c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f1785a |= 4;
                    this.f1788d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f1785a |= 8;
                    this.f1789e = codedInputStream.readBytes();
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
    public C0755g m2597a(int i) {
        this.f1785a |= 1;
        this.f1786b = i;
        return this;
    }

    /* renamed from: a */
    public C0755g m2600a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1785a |= 2;
        this.f1787c = str;
        return this;
    }

    /* renamed from: b */
    public C0755g m2602b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1785a |= 4;
        this.f1788d = str;
        return this;
    }

    /* renamed from: c */
    public C0755g m2604c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1785a |= 8;
        this.f1789e = str;
        return this;
    }
}
