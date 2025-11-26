package com.sec.chaton.p046a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dk */
/* loaded from: classes.dex */
public final class C0884dk extends GeneratedMessageLite.Builder<C0883dj, C0884dk> implements InterfaceC0885dl {

    /* renamed from: a */
    private int f2715a;

    /* renamed from: b */
    private EnumC0822bc f2716b = EnumC0822bc.SINGLE;

    /* renamed from: c */
    private Object f2717c = "";

    /* renamed from: d */
    private Object f2718d = "";

    /* renamed from: e */
    private Object f2719e = "";

    /* renamed from: f */
    private EnumC0824be f2720f = EnumC0824be.CONTENT_TEXT;

    /* renamed from: g */
    private int f2721g;

    /* renamed from: h */
    private long f2722h;

    private C0884dk() {
        m4547m();
    }

    /* renamed from: m */
    private void m4547m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static C0884dk m4548n() {
        return new C0884dk();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0884dk clear() {
        super.clear();
        this.f2716b = EnumC0822bc.SINGLE;
        this.f2715a &= -2;
        this.f2717c = "";
        this.f2715a &= -3;
        this.f2718d = "";
        this.f2715a &= -5;
        this.f2719e = "";
        this.f2715a &= -9;
        this.f2720f = EnumC0824be.CONTENT_TEXT;
        this.f2715a &= -17;
        this.f2721g = 0;
        this.f2715a &= -33;
        this.f2722h = 0L;
        this.f2715a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0884dk mo19949clone() {
        return m4548n().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0883dj getDefaultInstanceForType() {
        return C0883dj.m4517a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0883dj build() {
        C0883dj c0883djBuildPartial = buildPartial();
        if (!c0883djBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0883djBuildPartial);
        }
        return c0883djBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public C0883dj m4549o() throws InvalidProtocolBufferException {
        C0883dj c0883djBuildPartial = buildPartial();
        if (!c0883djBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0883djBuildPartial).asInvalidProtocolBufferException();
        }
        return c0883djBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0883dj buildPartial() {
        C0883dj c0883dj = new C0883dj(this);
        int i = this.f2715a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0883dj.f2706c = this.f2716b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0883dj.f2707d = this.f2717c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0883dj.f2708e = this.f2718d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0883dj.f2709f = this.f2719e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0883dj.f2710g = this.f2720f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0883dj.f2711h = this.f2721g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0883dj.f2712i = this.f2722h;
        c0883dj.f2705b = i2;
        return c0883dj;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0884dk mergeFrom(C0883dj c0883dj) {
        if (c0883dj != C0883dj.m4517a()) {
            if (c0883dj.m4529c()) {
                m4554a(c0883dj.m4530d());
            }
            if (c0883dj.m4531e()) {
                m4557a(c0883dj.m4532f());
            }
            if (c0883dj.m4533g()) {
                m4559b(c0883dj.m4534h());
            }
            if (c0883dj.m4535i()) {
                m4561c(c0883dj.m4536j());
            }
            if (c0883dj.m4537k()) {
                m4555a(c0883dj.m4538l());
            }
            if (c0883dj.m4539m()) {
                m4551a(c0883dj.m4540n());
            }
            if (c0883dj.m4541o()) {
                m4552a(c0883dj.m4542p());
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
    public C0884dk mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
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
                        this.f2715a |= 1;
                        this.f2716b = enumC0822bcM3576a;
                        break;
                    }
                case 18:
                    this.f2715a |= 2;
                    this.f2717c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f2715a |= 4;
                    this.f2718d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f2715a |= 8;
                    this.f2719e = codedInputStream.readBytes();
                    break;
                case 40:
                    EnumC0824be enumC0824beM3578a = EnumC0824be.m3578a(codedInputStream.readEnum());
                    if (enumC0824beM3578a == null) {
                        break;
                    } else {
                        this.f2715a |= 16;
                        this.f2720f = enumC0824beM3578a;
                        break;
                    }
                case 48:
                    this.f2715a |= 32;
                    this.f2721g = codedInputStream.readInt32();
                    break;
                case 56:
                    this.f2715a |= 64;
                    this.f2722h = codedInputStream.readInt64();
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

    /* renamed from: f */
    public EnumC0822bc m4564f() {
        return this.f2716b;
    }

    /* renamed from: a */
    public C0884dk m4554a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f2715a |= 1;
        this.f2716b = enumC0822bc;
        return this;
    }

    /* renamed from: g */
    public String m4565g() {
        Object obj = this.f2717c;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f2717c = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: a */
    public C0884dk m4557a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2715a |= 2;
        this.f2717c = str;
        return this;
    }

    /* renamed from: h */
    public String m4566h() {
        Object obj = this.f2718d;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f2718d = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: b */
    public C0884dk m4559b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2715a |= 4;
        this.f2718d = str;
        return this;
    }

    /* renamed from: i */
    public String m4567i() {
        Object obj = this.f2719e;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f2719e = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: c */
    public C0884dk m4561c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2715a |= 8;
        this.f2719e = str;
        return this;
    }

    /* renamed from: j */
    public EnumC0824be m4568j() {
        return this.f2720f;
    }

    /* renamed from: a */
    public C0884dk m4555a(EnumC0824be enumC0824be) {
        if (enumC0824be == null) {
            throw new NullPointerException();
        }
        this.f2715a |= 16;
        this.f2720f = enumC0824be;
        return this;
    }

    /* renamed from: k */
    public int m4569k() {
        return this.f2721g;
    }

    /* renamed from: a */
    public C0884dk m4551a(int i) {
        this.f2715a |= 32;
        this.f2721g = i;
        return this;
    }

    /* renamed from: a */
    public C0884dk m4552a(long j) {
        this.f2715a |= 64;
        this.f2722h = j;
        return this;
    }
}
