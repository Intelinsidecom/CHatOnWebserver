package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cv */
/* loaded from: classes.dex */
public final class C0868cv extends GeneratedMessageLite.Builder<C0867cu, C0868cv> implements InterfaceC0869cw {

    /* renamed from: a */
    private int f2597a;

    /* renamed from: d */
    private long f2600d;

    /* renamed from: e */
    private long f2601e;

    /* renamed from: b */
    private Object f2598b = "";

    /* renamed from: c */
    private Object f2599c = "";

    /* renamed from: f */
    private EnumC0908eh f2602f = EnumC0908eh.TEXT;

    /* renamed from: g */
    private EnumC0822bc f2603g = EnumC0822bc.SINGLE;

    /* renamed from: h */
    private Object f2604h = "";

    private C0868cv() {
        m4220g();
    }

    /* renamed from: g */
    private void m4220g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0868cv m4221h() {
        return new C0868cv();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0868cv clear() {
        super.clear();
        this.f2598b = "";
        this.f2597a &= -2;
        this.f2599c = "";
        this.f2597a &= -3;
        this.f2600d = 0L;
        this.f2597a &= -5;
        this.f2601e = 0L;
        this.f2597a &= -9;
        this.f2602f = EnumC0908eh.TEXT;
        this.f2597a &= -17;
        this.f2603g = EnumC0822bc.SINGLE;
        this.f2597a &= -33;
        this.f2604h = "";
        this.f2597a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0868cv mo19949clone() {
        return m4221h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0867cu getDefaultInstanceForType() {
        return C0867cu.m4191a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0867cu build() {
        C0867cu c0867cuBuildPartial = buildPartial();
        if (!c0867cuBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0867cuBuildPartial);
        }
        return c0867cuBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0867cu buildPartial() {
        C0867cu c0867cu = new C0867cu(this);
        int i = this.f2597a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0867cu.f2588c = this.f2598b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0867cu.f2589d = this.f2599c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0867cu.f2590e = this.f2600d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0867cu.f2591f = this.f2601e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0867cu.f2592g = this.f2602f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0867cu.f2593h = this.f2603g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0867cu.f2594i = this.f2604h;
        c0867cu.f2587b = i2;
        return c0867cu;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0868cv mergeFrom(C0867cu c0867cu) {
        if (c0867cu != C0867cu.m4191a()) {
            if (c0867cu.m4203c()) {
                m4228a(c0867cu.m4204d());
            }
            if (c0867cu.m4205e()) {
                m4231b(c0867cu.m4206f());
            }
            if (c0867cu.m4207g()) {
                m4223a(c0867cu.m4208h());
            }
            if (c0867cu.m4209i()) {
                m4230b(c0867cu.m4210j());
            }
            if (c0867cu.m4211k()) {
                m4227a(c0867cu.m4212l());
            }
            if (c0867cu.m4213m()) {
                m4225a(c0867cu.m4214n());
            }
            if (c0867cu.m4215o()) {
                m4233c(c0867cu.m4216p());
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
    public C0868cv mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2597a |= 1;
                    this.f2598b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f2597a |= 2;
                    this.f2599c = codedInputStream.readBytes();
                    break;
                case 24:
                    this.f2597a |= 4;
                    this.f2600d = codedInputStream.readInt64();
                    break;
                case 32:
                    this.f2597a |= 8;
                    this.f2601e = codedInputStream.readInt64();
                    break;
                case 40:
                    EnumC0908eh enumC0908ehM4887a = EnumC0908eh.m4887a(codedInputStream.readEnum());
                    if (enumC0908ehM4887a == null) {
                        break;
                    } else {
                        this.f2597a |= 16;
                        this.f2602f = enumC0908ehM4887a;
                        break;
                    }
                case 48:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f2597a |= 32;
                        this.f2603g = enumC0822bcM3576a;
                        break;
                    }
                case 58:
                    this.f2597a |= 64;
                    this.f2604h = codedInputStream.readBytes();
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
    public C0868cv m4228a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2597a |= 1;
        this.f2598b = str;
        return this;
    }

    /* renamed from: b */
    public C0868cv m4231b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2597a |= 2;
        this.f2599c = str;
        return this;
    }

    /* renamed from: a */
    public C0868cv m4223a(long j) {
        this.f2597a |= 4;
        this.f2600d = j;
        return this;
    }

    /* renamed from: b */
    public C0868cv m4230b(long j) {
        this.f2597a |= 8;
        this.f2601e = j;
        return this;
    }

    /* renamed from: a */
    public C0868cv m4227a(EnumC0908eh enumC0908eh) {
        if (enumC0908eh == null) {
            throw new NullPointerException();
        }
        this.f2597a |= 16;
        this.f2602f = enumC0908eh;
        return this;
    }

    /* renamed from: a */
    public C0868cv m4225a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f2597a |= 32;
        this.f2603g = enumC0822bc;
        return this;
    }

    /* renamed from: c */
    public C0868cv m4233c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2597a |= 64;
        this.f2604h = str;
        return this;
    }
}
