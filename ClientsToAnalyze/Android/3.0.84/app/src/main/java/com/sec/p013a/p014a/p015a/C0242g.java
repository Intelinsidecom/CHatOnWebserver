package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.g */
/* loaded from: classes.dex */
public final class C0242g extends GeneratedMessageLite.Builder<C0241f, C0242g> implements InterfaceC0243h {

    /* renamed from: a */
    private int f549a;

    /* renamed from: b */
    private int f550b;

    /* renamed from: c */
    private Object f551c = "";

    /* renamed from: d */
    private Object f552d = "";

    /* renamed from: e */
    private Object f553e = "";

    private C0242g() {
        m861g();
    }

    /* renamed from: g */
    private void m861g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0242g m862h() {
        return new C0242g();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0242g clear() {
        super.clear();
        this.f550b = 0;
        this.f549a &= -2;
        this.f551c = "";
        this.f549a &= -3;
        this.f552d = "";
        this.f549a &= -5;
        this.f553e = "";
        this.f549a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0242g mo13386clone() {
        return m862h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0241f getDefaultInstanceForType() {
        return C0241f.m837a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0241f build() {
        C0241f c0241fBuildPartial = buildPartial();
        if (!c0241fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0241fBuildPartial);
        }
        return c0241fBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0241f m863i() throws InvalidProtocolBufferException {
        C0241f c0241fBuildPartial = buildPartial();
        if (!c0241fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0241fBuildPartial).asInvalidProtocolBufferException();
        }
        return c0241fBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0241f buildPartial() {
        C0241f c0241f = new C0241f(this);
        int i = this.f549a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0241f.f543c = this.f550b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0241f.f544d = this.f551c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0241f.f545e = this.f552d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0241f.f546f = this.f553e;
        c0241f.f542b = i2;
        return c0241f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0242g mergeFrom(C0241f c0241f) {
        if (c0241f != C0241f.m837a()) {
            if (c0241f.m849c()) {
                m865a(c0241f.m850d());
            }
            if (c0241f.m851e()) {
                m868a(c0241f.m852f());
            }
            if (c0241f.m853g()) {
                m870b(c0241f.m854h());
            }
            if (c0241f.m855i()) {
                m872c(c0241f.m856j());
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
    public C0242g mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f549a |= 1;
                    this.f550b = codedInputStream.readInt32();
                    break;
                case 18:
                    this.f549a |= 2;
                    this.f551c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f549a |= 4;
                    this.f552d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f549a |= 8;
                    this.f553e = codedInputStream.readBytes();
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
    public C0242g m865a(int i) {
        this.f549a |= 1;
        this.f550b = i;
        return this;
    }

    /* renamed from: a */
    public C0242g m868a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f549a |= 2;
        this.f551c = str;
        return this;
    }

    /* renamed from: b */
    public C0242g m870b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f549a |= 4;
        this.f552d = str;
        return this;
    }

    /* renamed from: c */
    public C0242g m872c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f549a |= 8;
        this.f553e = str;
        return this;
    }
}
