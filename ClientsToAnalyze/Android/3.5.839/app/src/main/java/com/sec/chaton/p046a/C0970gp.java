package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.gp */
/* loaded from: classes.dex */
public final class C0970gp extends GeneratedMessageLite.Builder<C0969go, C0970gp> implements InterfaceC0971gq {

    /* renamed from: a */
    private int f3133a;

    /* renamed from: b */
    private Object f3134b = "";

    /* renamed from: c */
    private Object f3135c = "";

    /* renamed from: d */
    private Object f3136d = "";

    /* renamed from: e */
    private Object f3137e = "";

    /* renamed from: f */
    private Object f3138f = "";

    /* renamed from: g */
    private long f3139g;

    /* renamed from: h */
    private long f3140h;

    private C0970gp() {
        m5722g();
    }

    /* renamed from: g */
    private void m5722g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0970gp m5723h() {
        return new C0970gp();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0970gp clear() {
        super.clear();
        this.f3134b = "";
        this.f3133a &= -2;
        this.f3135c = "";
        this.f3133a &= -3;
        this.f3136d = "";
        this.f3133a &= -5;
        this.f3137e = "";
        this.f3133a &= -9;
        this.f3138f = "";
        this.f3133a &= -17;
        this.f3139g = 0L;
        this.f3133a &= -33;
        this.f3140h = 0L;
        this.f3133a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0970gp mo19949clone() {
        return m5723h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0969go getDefaultInstanceForType() {
        return C0969go.m5688a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0969go build() {
        C0969go c0969goBuildPartial = buildPartial();
        if (!c0969goBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0969goBuildPartial);
        }
        return c0969goBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0969go m5724i() throws InvalidProtocolBufferException {
        C0969go c0969goBuildPartial = buildPartial();
        if (!c0969goBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0969goBuildPartial).asInvalidProtocolBufferException();
        }
        return c0969goBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0969go buildPartial() {
        C0969go c0969go = new C0969go(this);
        int i = this.f3133a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0969go.f3124c = this.f3134b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0969go.f3125d = this.f3135c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0969go.f3126e = this.f3136d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0969go.f3127f = this.f3137e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0969go.f3128g = this.f3138f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0969go.f3129h = this.f3139g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0969go.f3130i = this.f3140h;
        c0969go.f3123b = i2;
        return c0969go;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0970gp mergeFrom(C0969go c0969go) {
        if (c0969go != C0969go.m5688a()) {
            if (c0969go.m5704c()) {
                m5729a(c0969go.m5705d());
            }
            if (c0969go.m5706e()) {
                m5732b(c0969go.m5707f());
            }
            if (c0969go.m5708g()) {
                m5734c(c0969go.m5709h());
            }
            if (c0969go.m5710i()) {
                m5736d(c0969go.m5711j());
            }
            if (c0969go.m5712k()) {
                m5738e(c0969go.m5713l());
            }
            if (c0969go.m5714m()) {
                m5726a(c0969go.m5715n());
            }
            if (c0969go.m5716o()) {
                m5731b(c0969go.m5717p());
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
    public C0970gp mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f3133a |= 1;
                    this.f3134b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f3133a |= 2;
                    this.f3135c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f3133a |= 4;
                    this.f3136d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f3133a |= 8;
                    this.f3137e = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f3133a |= 16;
                    this.f3138f = codedInputStream.readBytes();
                    break;
                case 48:
                    this.f3133a |= 32;
                    this.f3139g = codedInputStream.readInt64();
                    break;
                case 56:
                    this.f3133a |= 64;
                    this.f3140h = codedInputStream.readInt64();
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
    public C0970gp m5729a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3133a |= 1;
        this.f3134b = str;
        return this;
    }

    /* renamed from: b */
    public C0970gp m5732b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3133a |= 2;
        this.f3135c = str;
        return this;
    }

    /* renamed from: c */
    public C0970gp m5734c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3133a |= 4;
        this.f3136d = str;
        return this;
    }

    /* renamed from: d */
    public C0970gp m5736d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3133a |= 8;
        this.f3137e = str;
        return this;
    }

    /* renamed from: e */
    public C0970gp m5738e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3133a |= 16;
        this.f3138f = str;
        return this;
    }

    /* renamed from: a */
    public C0970gp m5726a(long j) {
        this.f3133a |= 32;
        this.f3139g = j;
        return this;
    }

    /* renamed from: b */
    public C0970gp m5731b(long j) {
        this.f3133a |= 64;
        this.f3140h = j;
        return this;
    }
}
