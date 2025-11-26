package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fx */
/* loaded from: classes.dex */
public final class C0951fx extends GeneratedMessageLite.Builder<C0950fw, C0951fx> implements InterfaceC0952fy {

    /* renamed from: a */
    private int f3046a;

    /* renamed from: b */
    private long f3047b;

    /* renamed from: e */
    private boolean f3050e;

    /* renamed from: c */
    private EnumC0908eh f3048c = EnumC0908eh.TEXT;

    /* renamed from: d */
    private Object f3049d = "";

    /* renamed from: f */
    private Object f3051f = "";

    private C0951fx() {
        m5480g();
    }

    /* renamed from: g */
    private void m5480g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0951fx m5481h() {
        return new C0951fx();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0951fx clear() {
        super.clear();
        this.f3047b = 0L;
        this.f3046a &= -2;
        this.f3048c = EnumC0908eh.TEXT;
        this.f3046a &= -3;
        this.f3049d = "";
        this.f3046a &= -5;
        this.f3050e = false;
        this.f3046a &= -9;
        this.f3051f = "";
        this.f3046a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0951fx mo19949clone() {
        return m5481h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0950fw getDefaultInstanceForType() {
        return C0950fw.m5458a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0950fw build() {
        C0950fw c0950fwBuildPartial = buildPartial();
        if (!c0950fwBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0950fwBuildPartial);
        }
        return c0950fwBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0950fw buildPartial() {
        C0950fw c0950fw = new C0950fw(this);
        int i = this.f3046a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0950fw.f3039c = this.f3047b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0950fw.f3040d = this.f3048c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0950fw.f3041e = this.f3049d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0950fw.f3042f = this.f3050e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0950fw.f3043g = this.f3051f;
        c0950fw.f3038b = i2;
        return c0950fw;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0951fx mergeFrom(C0950fw c0950fw) {
        if (c0950fw != C0950fw.m5458a()) {
            if (c0950fw.m5467c()) {
                m5483a(c0950fw.m5468d());
            }
            if (c0950fw.m5469e()) {
                m5485a(c0950fw.m5470f());
            }
            if (c0950fw.m5471g()) {
                m5487a(c0950fw.m5472h());
            }
            if (c0950fw.m5473i()) {
                m5488a(c0950fw.m5474j());
            }
            if (c0950fw.m5475k()) {
                m5490b(c0950fw.m5476l());
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
    public C0951fx mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f3046a |= 1;
                    this.f3047b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0908eh enumC0908ehM4887a = EnumC0908eh.m4887a(codedInputStream.readEnum());
                    if (enumC0908ehM4887a == null) {
                        break;
                    } else {
                        this.f3046a |= 2;
                        this.f3048c = enumC0908ehM4887a;
                        break;
                    }
                case 26:
                    this.f3046a |= 4;
                    this.f3049d = codedInputStream.readBytes();
                    break;
                case 32:
                    this.f3046a |= 8;
                    this.f3050e = codedInputStream.readBool();
                    break;
                case 42:
                    this.f3046a |= 16;
                    this.f3051f = codedInputStream.readBytes();
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
    public C0951fx m5483a(long j) {
        this.f3046a |= 1;
        this.f3047b = j;
        return this;
    }

    /* renamed from: a */
    public C0951fx m5485a(EnumC0908eh enumC0908eh) {
        if (enumC0908eh == null) {
            throw new NullPointerException();
        }
        this.f3046a |= 2;
        this.f3048c = enumC0908eh;
        return this;
    }

    /* renamed from: a */
    public C0951fx m5487a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3046a |= 4;
        this.f3049d = str;
        return this;
    }

    /* renamed from: a */
    public C0951fx m5488a(boolean z) {
        this.f3046a |= 8;
        this.f3050e = z;
        return this;
    }

    /* renamed from: b */
    public C0951fx m5490b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3046a |= 16;
        this.f3051f = str;
        return this;
    }
}
