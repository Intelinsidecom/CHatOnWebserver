package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.d */
/* loaded from: classes.dex */
public final class C0239d extends GeneratedMessageLite.Builder<C0238c, C0239d> implements InterfaceC0240e {

    /* renamed from: a */
    private int f536a;

    /* renamed from: b */
    private int f537b;

    /* renamed from: c */
    private int f538c;

    /* renamed from: d */
    private Object f539d = "";

    /* renamed from: e */
    private Object f540e = "";

    private C0239d() {
        m822g();
    }

    /* renamed from: g */
    private void m822g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0239d m823h() {
        return new C0239d();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0239d clear() {
        super.clear();
        this.f537b = 0;
        this.f536a &= -2;
        this.f538c = 0;
        this.f536a &= -3;
        this.f539d = "";
        this.f536a &= -5;
        this.f540e = "";
        this.f536a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0239d mo13386clone() {
        return m823h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0238c getDefaultInstanceForType() {
        return C0238c.m799a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0238c build() {
        C0238c c0238cBuildPartial = buildPartial();
        if (!c0238cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0238cBuildPartial);
        }
        return c0238cBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0238c m824i() throws InvalidProtocolBufferException {
        C0238c c0238cBuildPartial = buildPartial();
        if (!c0238cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0238cBuildPartial).asInvalidProtocolBufferException();
        }
        return c0238cBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0238c buildPartial() {
        C0238c c0238c = new C0238c(this);
        int i = this.f536a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0238c.f530c = this.f537b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0238c.f531d = this.f538c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0238c.f532e = this.f539d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0238c.f533f = this.f540e;
        c0238c.f529b = i2;
        return c0238c;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0239d mergeFrom(C0238c c0238c) {
        if (c0238c != C0238c.m799a()) {
            if (c0238c.m810c()) {
                m826a(c0238c.m811d());
            }
            if (c0238c.m812e()) {
                m831b(c0238c.m813f());
            }
            if (c0238c.m814g()) {
                m829a(c0238c.m815h());
            }
            if (c0238c.m816i()) {
                m832b(c0238c.m817j());
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
    public C0239d mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f536a |= 1;
                    this.f537b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f536a |= 2;
                    this.f538c = codedInputStream.readInt32();
                    break;
                case 26:
                    this.f536a |= 4;
                    this.f539d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f536a |= 8;
                    this.f540e = codedInputStream.readBytes();
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
    public C0239d m826a(int i) {
        this.f536a |= 1;
        this.f537b = i;
        return this;
    }

    /* renamed from: b */
    public C0239d m831b(int i) {
        this.f536a |= 2;
        this.f538c = i;
        return this;
    }

    /* renamed from: a */
    public C0239d m829a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f536a |= 4;
        this.f539d = str;
        return this;
    }

    /* renamed from: b */
    public C0239d m832b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f536a |= 8;
        this.f540e = str;
        return this;
    }
}
