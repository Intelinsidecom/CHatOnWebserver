package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ah */
/* loaded from: classes.dex */
public final class C0800ah extends GeneratedMessageLite.Builder<C0799ag, C0800ah> implements InterfaceC0801ai {

    /* renamed from: a */
    private int f2217a;

    /* renamed from: b */
    private EnumC0822bc f2218b = EnumC0822bc.SINGLE;

    /* renamed from: c */
    private Object f2219c = "";

    /* renamed from: d */
    private LazyStringList f2220d = LazyStringArrayList.EMPTY;

    /* renamed from: e */
    private long f2221e;

    /* renamed from: f */
    private long f2222f;

    /* renamed from: g */
    private boolean f2223g;

    private C0800ah() {
        m3260g();
    }

    /* renamed from: g */
    private void m3260g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0800ah m3261h() {
        return new C0800ah();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0800ah clear() {
        super.clear();
        this.f2218b = EnumC0822bc.SINGLE;
        this.f2217a &= -2;
        this.f2219c = "";
        this.f2217a &= -3;
        this.f2220d = LazyStringArrayList.EMPTY;
        this.f2217a &= -5;
        this.f2221e = 0L;
        this.f2217a &= -9;
        this.f2222f = 0L;
        this.f2217a &= -17;
        this.f2223g = false;
        this.f2217a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0800ah mo19949clone() {
        return m3261h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0799ag getDefaultInstanceForType() {
        return C0799ag.m3236a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0799ag build() {
        C0799ag c0799agBuildPartial = buildPartial();
        if (!c0799agBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0799agBuildPartial);
        }
        return c0799agBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0799ag buildPartial() {
        C0799ag c0799ag = new C0799ag(this);
        int i = this.f2217a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0799ag.f2209c = this.f2218b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0799ag.f2210d = this.f2219c;
        if ((this.f2217a & 4) == 4) {
            this.f2220d = new UnmodifiableLazyStringList(this.f2220d);
            this.f2217a &= -5;
        }
        c0799ag.f2211e = this.f2220d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0799ag.f2212f = this.f2221e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0799ag.f2213g = this.f2222f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0799ag.f2214h = this.f2223g;
        c0799ag.f2208b = i2;
        return c0799ag;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0800ah mergeFrom(C0799ag c0799ag) {
        if (c0799ag != C0799ag.m3236a()) {
            if (c0799ag.m3246c()) {
                m3267a(c0799ag.m3247d());
            }
            if (c0799ag.m3248e()) {
                m3269a(c0799ag.m3249f());
            }
            if (!c0799ag.f2211e.isEmpty()) {
                if (this.f2220d.isEmpty()) {
                    this.f2220d = c0799ag.f2211e;
                    this.f2217a &= -5;
                } else {
                    m3262i();
                    this.f2220d.addAll(c0799ag.f2211e);
                }
            }
            if (c0799ag.m3251h()) {
                m3264a(c0799ag.m3252i());
            }
            if (c0799ag.m3253j()) {
                m3272b(c0799ag.m3254k());
            }
            if (c0799ag.m3255l()) {
                m3270a(c0799ag.m3256m());
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
    public C0800ah mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f2217a |= 1;
                        this.f2218b = enumC0822bcM3576a;
                        break;
                    }
                case 18:
                    this.f2217a |= 2;
                    this.f2219c = codedInputStream.readBytes();
                    break;
                case 26:
                    m3262i();
                    this.f2220d.add(codedInputStream.readBytes());
                    break;
                case 32:
                    this.f2217a |= 8;
                    this.f2221e = codedInputStream.readInt64();
                    break;
                case 40:
                    this.f2217a |= 16;
                    this.f2222f = codedInputStream.readInt64();
                    break;
                case 48:
                    this.f2217a |= 32;
                    this.f2223g = codedInputStream.readBool();
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
    public C0800ah m3267a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f2217a |= 1;
        this.f2218b = enumC0822bc;
        return this;
    }

    /* renamed from: a */
    public C0800ah m3269a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2217a |= 2;
        this.f2219c = str;
        return this;
    }

    /* renamed from: i */
    private void m3262i() {
        if ((this.f2217a & 4) != 4) {
            this.f2220d = new LazyStringArrayList(this.f2220d);
            this.f2217a |= 4;
        }
    }

    /* renamed from: a */
    public C0800ah m3268a(Iterable<String> iterable) {
        m3262i();
        GeneratedMessageLite.Builder.addAll(iterable, this.f2220d);
        return this;
    }

    /* renamed from: a */
    public C0800ah m3264a(long j) {
        this.f2217a |= 8;
        this.f2221e = j;
        return this;
    }

    /* renamed from: b */
    public C0800ah m3272b(long j) {
        this.f2217a |= 16;
        this.f2222f = j;
        return this;
    }

    /* renamed from: a */
    public C0800ah m3270a(boolean z) {
        this.f2217a |= 32;
        this.f2223g = z;
        return this;
    }
}
