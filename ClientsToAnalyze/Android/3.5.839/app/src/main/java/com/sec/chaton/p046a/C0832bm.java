package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bm */
/* loaded from: classes.dex */
public final class C0832bm extends GeneratedMessageLite.Builder<C0831bl, C0832bm> implements InterfaceC0833bn {

    /* renamed from: a */
    private int f2410a;

    /* renamed from: d */
    private long f2413d;

    /* renamed from: b */
    private Object f2411b = "";

    /* renamed from: c */
    private Object f2412c = "";

    /* renamed from: e */
    private EnumC0908eh f2414e = EnumC0908eh.TEXT;

    private C0832bm() {
        m3712g();
    }

    /* renamed from: g */
    private void m3712g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0832bm m3713h() {
        return new C0832bm();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0832bm clear() {
        super.clear();
        this.f2411b = "";
        this.f2410a &= -2;
        this.f2412c = "";
        this.f2410a &= -3;
        this.f2413d = 0L;
        this.f2410a &= -5;
        this.f2414e = EnumC0908eh.TEXT;
        this.f2410a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0832bm mo19949clone() {
        return m3713h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0831bl getDefaultInstanceForType() {
        return C0831bl.m3692a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0831bl build() {
        C0831bl c0831blBuildPartial = buildPartial();
        if (!c0831blBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0831blBuildPartial);
        }
        return c0831blBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0831bl buildPartial() {
        C0831bl c0831bl = new C0831bl(this);
        int i = this.f2410a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0831bl.f2404c = this.f2411b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0831bl.f2405d = this.f2412c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0831bl.f2406e = this.f2413d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0831bl.f2407f = this.f2414e;
        c0831bl.f2403b = i2;
        return c0831bl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0832bm mergeFrom(C0831bl c0831bl) {
        if (c0831bl != C0831bl.m3692a()) {
            if (c0831bl.m3701c()) {
                m3719a(c0831bl.m3702d());
            }
            if (c0831bl.m3703e()) {
                m3721b(c0831bl.m3704f());
            }
            if (c0831bl.m3705g()) {
                m3715a(c0831bl.m3706h());
            }
            if (c0831bl.m3707i()) {
                m3718a(c0831bl.m3708j());
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
    public C0832bm mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2410a |= 1;
                    this.f2411b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f2410a |= 2;
                    this.f2412c = codedInputStream.readBytes();
                    break;
                case 24:
                    this.f2410a |= 4;
                    this.f2413d = codedInputStream.readInt64();
                    break;
                case 32:
                    EnumC0908eh enumC0908ehM4887a = EnumC0908eh.m4887a(codedInputStream.readEnum());
                    if (enumC0908ehM4887a == null) {
                        break;
                    } else {
                        this.f2410a |= 8;
                        this.f2414e = enumC0908ehM4887a;
                        break;
                    }
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
    public C0832bm m3719a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2410a |= 1;
        this.f2411b = str;
        return this;
    }

    /* renamed from: b */
    public C0832bm m3721b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2410a |= 2;
        this.f2412c = str;
        return this;
    }

    /* renamed from: a */
    public C0832bm m3715a(long j) {
        this.f2410a |= 4;
        this.f2413d = j;
        return this;
    }

    /* renamed from: a */
    public C0832bm m3718a(EnumC0908eh enumC0908eh) {
        if (enumC0908eh == null) {
            throw new NullPointerException();
        }
        this.f2410a |= 8;
        this.f2414e = enumC0908eh;
        return this;
    }
}
