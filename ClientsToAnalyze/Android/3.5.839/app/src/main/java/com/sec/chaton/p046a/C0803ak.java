package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ak */
/* loaded from: classes.dex */
public final class C0803ak extends GeneratedMessageLite.Builder<C0802aj, C0803ak> implements InterfaceC0804al {

    /* renamed from: a */
    private int f2231a;

    /* renamed from: b */
    private EnumC0813au f2232b = EnumC0813au.ENTER;

    /* renamed from: c */
    private Object f2233c = "";

    /* renamed from: d */
    private Object f2234d = "";

    private C0803ak() {
        m3295g();
    }

    /* renamed from: g */
    private void m3295g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0803ak m3296h() {
        return new C0803ak();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0803ak clear() {
        super.clear();
        this.f2232b = EnumC0813au.ENTER;
        this.f2231a &= -2;
        this.f2233c = "";
        this.f2231a &= -3;
        this.f2234d = "";
        this.f2231a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0803ak mo19949clone() {
        return m3296h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0802aj getDefaultInstanceForType() {
        return C0802aj.m3277a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0802aj build() {
        C0802aj c0802ajBuildPartial = buildPartial();
        if (!c0802ajBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0802ajBuildPartial);
        }
        return c0802ajBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0802aj buildPartial() {
        C0802aj c0802aj = new C0802aj(this);
        int i = this.f2231a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0802aj.f2226c = this.f2232b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0802aj.f2227d = this.f2233c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0802aj.f2228e = this.f2234d;
        c0802aj.f2225b = i2;
        return c0802aj;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0803ak mergeFrom(C0802aj c0802aj) {
        if (c0802aj != C0802aj.m3277a()) {
            if (c0802aj.m3286c()) {
                m3300a(c0802aj.m3287d());
            }
            if (c0802aj.m3288e()) {
                m3301a(c0802aj.m3289f());
            }
            if (c0802aj.m3290g()) {
                m3303b(c0802aj.m3291h());
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
    public C0803ak mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        this.f2231a |= 1;
                        this.f2232b = enumC0813auM3428a;
                        break;
                    }
                case 18:
                    this.f2231a |= 2;
                    this.f2233c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f2231a |= 4;
                    this.f2234d = codedInputStream.readBytes();
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
    public C0803ak m3300a(EnumC0813au enumC0813au) {
        if (enumC0813au == null) {
            throw new NullPointerException();
        }
        this.f2231a |= 1;
        this.f2232b = enumC0813au;
        return this;
    }

    /* renamed from: a */
    public C0803ak m3301a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2231a |= 2;
        this.f2233c = str;
        return this;
    }

    /* renamed from: b */
    public C0803ak m3303b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2231a |= 4;
        this.f2234d = str;
        return this;
    }
}
