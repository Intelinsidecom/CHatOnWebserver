package com.sec.p043a.p044a.p045a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ae */
/* loaded from: classes.dex */
public final class C0738ae extends GeneratedMessageLite.Builder<C0737ad, C0738ae> implements InterfaceC0739af {

    /* renamed from: a */
    private int f1712a;

    /* renamed from: b */
    private int f1713b;

    /* renamed from: e */
    private int f1716e;

    /* renamed from: g */
    private int f1718g;

    /* renamed from: h */
    private int f1719h;

    /* renamed from: c */
    private Object f1714c = "";

    /* renamed from: d */
    private Object f1715d = "";

    /* renamed from: f */
    private Object f1717f = "";

    /* renamed from: i */
    private Object f1720i = "";

    private C0738ae() {
        m2381g();
    }

    /* renamed from: g */
    private void m2381g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0738ae m2382h() {
        return new C0738ae();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0738ae clear() {
        super.clear();
        this.f1713b = 0;
        this.f1712a &= -2;
        this.f1714c = "";
        this.f1712a &= -3;
        this.f1715d = "";
        this.f1712a &= -5;
        this.f1716e = 0;
        this.f1712a &= -9;
        this.f1717f = "";
        this.f1712a &= -17;
        this.f1718g = 0;
        this.f1712a &= -33;
        this.f1719h = 0;
        this.f1712a &= -65;
        this.f1720i = "";
        this.f1712a &= -129;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0738ae mo19949clone() {
        return m2382h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0737ad getDefaultInstanceForType() {
        return C0737ad.m2344a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0737ad build() {
        C0737ad c0737adBuildPartial = buildPartial();
        if (!c0737adBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0737adBuildPartial);
        }
        return c0737adBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0737ad m2383i() throws InvalidProtocolBufferException {
        C0737ad c0737adBuildPartial = buildPartial();
        if (!c0737adBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0737adBuildPartial).asInvalidProtocolBufferException();
        }
        return c0737adBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0737ad buildPartial() {
        C0737ad c0737ad = new C0737ad(this);
        int i = this.f1712a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0737ad.f1702c = this.f1713b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0737ad.f1703d = this.f1714c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0737ad.f1704e = this.f1715d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0737ad.f1705f = this.f1716e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0737ad.f1706g = this.f1717f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0737ad.f1707h = this.f1718g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0737ad.f1708i = this.f1719h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        c0737ad.f1709j = this.f1720i;
        c0737ad.f1701b = i2;
        return c0737ad;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0738ae mergeFrom(C0737ad c0737ad) {
        if (c0737ad != C0737ad.m2344a()) {
            if (c0737ad.m2361c()) {
                m2385a(c0737ad.m2362d());
            }
            if (c0737ad.m2363e()) {
                m2388a(c0737ad.m2364f());
            }
            if (c0737ad.m2365g()) {
                m2391b(c0737ad.m2366h());
            }
            if (c0737ad.m2367i()) {
                m2390b(c0737ad.m2368j());
            }
            if (c0737ad.m2369k()) {
                m2394c(c0737ad.m2370l());
            }
            if (c0737ad.m2371m()) {
                m2393c(c0737ad.m2372n());
            }
            if (c0737ad.m2373o()) {
                m2396d(c0737ad.m2374p());
            }
            if (c0737ad.m2375q()) {
                m2397d(c0737ad.m2376r());
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
    public C0738ae mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 16:
                    this.f1712a |= 1;
                    this.f1713b = codedInputStream.readInt32();
                    break;
                case 26:
                    this.f1712a |= 2;
                    this.f1714c = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f1712a |= 4;
                    this.f1715d = codedInputStream.readBytes();
                    break;
                case 40:
                    this.f1712a |= 8;
                    this.f1716e = codedInputStream.readInt32();
                    break;
                case 50:
                    this.f1712a |= 16;
                    this.f1717f = codedInputStream.readBytes();
                    break;
                case 56:
                    this.f1712a |= 32;
                    this.f1718g = codedInputStream.readInt32();
                    break;
                case 64:
                    this.f1712a |= 64;
                    this.f1719h = codedInputStream.readInt32();
                    break;
                case 74:
                    this.f1712a |= 128;
                    this.f1720i = codedInputStream.readBytes();
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
    public C0738ae m2385a(int i) {
        this.f1712a |= 1;
        this.f1713b = i;
        return this;
    }

    /* renamed from: a */
    public C0738ae m2388a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1712a |= 2;
        this.f1714c = str;
        return this;
    }

    /* renamed from: b */
    public C0738ae m2391b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1712a |= 4;
        this.f1715d = str;
        return this;
    }

    /* renamed from: b */
    public C0738ae m2390b(int i) {
        this.f1712a |= 8;
        this.f1716e = i;
        return this;
    }

    /* renamed from: c */
    public C0738ae m2394c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1712a |= 16;
        this.f1717f = str;
        return this;
    }

    /* renamed from: c */
    public C0738ae m2393c(int i) {
        this.f1712a |= 32;
        this.f1718g = i;
        return this;
    }

    /* renamed from: d */
    public C0738ae m2396d(int i) {
        this.f1712a |= 64;
        this.f1719h = i;
        return this;
    }

    /* renamed from: d */
    public C0738ae m2397d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1712a |= 128;
        this.f1720i = str;
        return this;
    }
}
