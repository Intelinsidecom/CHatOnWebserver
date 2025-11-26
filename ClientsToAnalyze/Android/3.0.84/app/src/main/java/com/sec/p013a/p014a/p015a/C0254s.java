package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.s */
/* loaded from: classes.dex */
public final class C0254s extends GeneratedMessageLite.Builder<C0253r, C0254s> implements InterfaceC0255t {

    /* renamed from: a */
    private int f597a;

    /* renamed from: d */
    private int f600d;

    /* renamed from: e */
    private int f601e;

    /* renamed from: i */
    private long f605i;

    /* renamed from: j */
    private int f606j;

    /* renamed from: b */
    private Object f598b = "";

    /* renamed from: c */
    private Object f599c = "";

    /* renamed from: f */
    private Object f602f = "";

    /* renamed from: g */
    private Object f603g = "";

    /* renamed from: h */
    private Object f604h = "";

    /* renamed from: k */
    private Object f607k = "";

    private C0254s() {
        m1013g();
    }

    /* renamed from: g */
    private void m1013g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0254s m1014h() {
        return new C0254s();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0254s clear() {
        super.clear();
        this.f598b = "";
        this.f597a &= -2;
        this.f599c = "";
        this.f597a &= -3;
        this.f600d = 0;
        this.f597a &= -5;
        this.f601e = 0;
        this.f597a &= -9;
        this.f602f = "";
        this.f597a &= -17;
        this.f603g = "";
        this.f597a &= -33;
        this.f604h = "";
        this.f597a &= -65;
        this.f605i = 0L;
        this.f597a &= -129;
        this.f606j = 0;
        this.f597a &= -257;
        this.f607k = "";
        this.f597a &= -513;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0254s mo13386clone() {
        return m1014h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0253r getDefaultInstanceForType() {
        return C0253r.m974a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0253r build() {
        C0253r c0253rBuildPartial = buildPartial();
        if (!c0253rBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0253rBuildPartial);
        }
        return c0253rBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0253r m1015i() throws InvalidProtocolBufferException {
        C0253r c0253rBuildPartial = buildPartial();
        if (!c0253rBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0253rBuildPartial).asInvalidProtocolBufferException();
        }
        return c0253rBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0253r buildPartial() {
        C0253r c0253r = new C0253r(this);
        int i = this.f597a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0253r.f585c = this.f598b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0253r.f586d = this.f599c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0253r.f587e = this.f600d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0253r.f588f = this.f601e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0253r.f589g = this.f602f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0253r.f590h = this.f603g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0253r.f591i = this.f604h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        c0253r.f592j = this.f605i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        c0253r.f593k = this.f606j;
        if ((i & 512) == 512) {
            i2 |= 512;
        }
        c0253r.f594l = this.f607k;
        c0253r.f584b = i2;
        return c0253r;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0254s mergeFrom(C0253r c0253r) {
        if (c0253r != C0253r.m974a()) {
            if (c0253r.m989c()) {
                m1021a(c0253r.m990d());
            }
            if (c0253r.m991e()) {
                m1024b(c0253r.m992f());
            }
            if (c0253r.m993g()) {
                m1017a(c0253r.m994h());
            }
            if (c0253r.m995i()) {
                m1023b(c0253r.m996j());
            }
            if (c0253r.m997k()) {
                m1027c(c0253r.m998l());
            }
            if (c0253r.m999m()) {
                m1029d(c0253r.m1000n());
            }
            if (c0253r.m1001o()) {
                m1031e(c0253r.m1002p());
            }
            if (c0253r.m1003q()) {
                m1018a(c0253r.m1004r());
            }
            if (c0253r.m1005s()) {
                m1026c(c0253r.m1006t());
            }
            if (c0253r.m1007u()) {
                m1032f(c0253r.m1008v());
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
    public C0254s mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f597a |= 1;
                    this.f598b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f597a |= 2;
                    this.f599c = codedInputStream.readBytes();
                    break;
                case 24:
                    this.f597a |= 4;
                    this.f600d = codedInputStream.readInt32();
                    break;
                case 32:
                    this.f597a |= 8;
                    this.f601e = codedInputStream.readInt32();
                    break;
                case 42:
                    this.f597a |= 16;
                    this.f602f = codedInputStream.readBytes();
                    break;
                case 50:
                    this.f597a |= 32;
                    this.f603g = codedInputStream.readBytes();
                    break;
                case 58:
                    this.f597a |= 64;
                    this.f604h = codedInputStream.readBytes();
                    break;
                case 88:
                    this.f597a |= 128;
                    this.f605i = codedInputStream.readInt64();
                    break;
                case 96:
                    this.f597a |= 256;
                    this.f606j = codedInputStream.readInt32();
                    break;
                case 106:
                    this.f597a |= 512;
                    this.f607k = codedInputStream.readBytes();
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
    public C0254s m1021a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f597a |= 1;
        this.f598b = str;
        return this;
    }

    /* renamed from: b */
    public C0254s m1024b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f597a |= 2;
        this.f599c = str;
        return this;
    }

    /* renamed from: a */
    public C0254s m1017a(int i) {
        this.f597a |= 4;
        this.f600d = i;
        return this;
    }

    /* renamed from: b */
    public C0254s m1023b(int i) {
        this.f597a |= 8;
        this.f601e = i;
        return this;
    }

    /* renamed from: c */
    public C0254s m1027c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f597a |= 16;
        this.f602f = str;
        return this;
    }

    /* renamed from: d */
    public C0254s m1029d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f597a |= 32;
        this.f603g = str;
        return this;
    }

    /* renamed from: e */
    public C0254s m1031e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f597a |= 64;
        this.f604h = str;
        return this;
    }

    /* renamed from: a */
    public C0254s m1018a(long j) {
        this.f597a |= 128;
        this.f605i = j;
        return this;
    }

    /* renamed from: c */
    public C0254s m1026c(int i) {
        this.f597a |= 256;
        this.f606j = i;
        return this;
    }

    /* renamed from: f */
    public C0254s m1032f(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f597a |= 512;
        this.f607k = str;
        return this;
    }
}
