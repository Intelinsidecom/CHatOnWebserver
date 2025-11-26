package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.gg */
/* loaded from: classes.dex */
public final class C0961gg extends GeneratedMessageLite.Builder<C0960gf, C0961gg> implements InterfaceC0962gh {

    /* renamed from: a */
    private int f3090a;

    /* renamed from: c */
    private long f3092c;

    /* renamed from: b */
    private EnumC0813au f3091b = EnumC0813au.ENTER;

    /* renamed from: d */
    private Object f3093d = "";

    private C0961gg() {
        m5596g();
    }

    /* renamed from: g */
    private void m5596g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0961gg m5597h() {
        return new C0961gg();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0961gg clear() {
        super.clear();
        this.f3091b = EnumC0813au.ENTER;
        this.f3090a &= -2;
        this.f3092c = 0L;
        this.f3090a &= -3;
        this.f3093d = "";
        this.f3090a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0961gg mo19949clone() {
        return m5597h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0960gf getDefaultInstanceForType() {
        return C0960gf.m5581a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0960gf build() {
        C0960gf c0960gfBuildPartial = buildPartial();
        if (!c0960gfBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0960gfBuildPartial);
        }
        return c0960gfBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0960gf buildPartial() {
        C0960gf c0960gf = new C0960gf(this);
        int i = this.f3090a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0960gf.f3085c = this.f3091b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0960gf.f3086d = this.f3092c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0960gf.f3087e = this.f3093d;
        c0960gf.f3084b = i2;
        return c0960gf;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0961gg mergeFrom(C0960gf c0960gf) {
        if (c0960gf != C0960gf.m5581a()) {
            if (c0960gf.m5587c()) {
                m5601a(c0960gf.m5588d());
            }
            if (c0960gf.m5589e()) {
                m5599a(c0960gf.m5590f());
            }
            if (c0960gf.m5591g()) {
                m5603a(c0960gf.m5592h());
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
    public C0961gg mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    EnumC0813au enumC0813auM3428a = EnumC0813au.m3428a(codedInputStream.readEnum());
                    if (enumC0813auM3428a == null) {
                        break;
                    } else {
                        this.f3090a |= 1;
                        this.f3091b = enumC0813auM3428a;
                        break;
                    }
                case 16:
                    this.f3090a |= 2;
                    this.f3092c = codedInputStream.readInt64();
                    break;
                case 26:
                    this.f3090a |= 4;
                    this.f3093d = codedInputStream.readBytes();
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
    public C0961gg m5601a(EnumC0813au enumC0813au) {
        if (enumC0813au == null) {
            throw new NullPointerException();
        }
        this.f3090a |= 1;
        this.f3091b = enumC0813au;
        return this;
    }

    /* renamed from: a */
    public C0961gg m5599a(long j) {
        this.f3090a |= 2;
        this.f3092c = j;
        return this;
    }

    /* renamed from: a */
    public C0961gg m5603a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3090a |= 4;
        this.f3093d = str;
        return this;
    }
}
