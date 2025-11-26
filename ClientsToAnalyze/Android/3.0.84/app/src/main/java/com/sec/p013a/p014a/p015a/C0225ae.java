package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ae */
/* loaded from: classes.dex */
public final class C0225ae extends GeneratedMessageLite.Builder<C0224ad, C0225ae> implements InterfaceC0226af {

    /* renamed from: a */
    private int f476a;

    /* renamed from: b */
    private int f477b;

    /* renamed from: e */
    private int f480e;

    /* renamed from: g */
    private int f482g;

    /* renamed from: h */
    private int f483h;

    /* renamed from: c */
    private Object f478c = "";

    /* renamed from: d */
    private Object f479d = "";

    /* renamed from: f */
    private Object f481f = "";

    /* renamed from: i */
    private Object f484i = "";

    private C0225ae() {
        m649g();
    }

    /* renamed from: g */
    private void m649g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0225ae m650h() {
        return new C0225ae();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0225ae clear() {
        super.clear();
        this.f477b = 0;
        this.f476a &= -2;
        this.f478c = "";
        this.f476a &= -3;
        this.f479d = "";
        this.f476a &= -5;
        this.f480e = 0;
        this.f476a &= -9;
        this.f481f = "";
        this.f476a &= -17;
        this.f482g = 0;
        this.f476a &= -33;
        this.f483h = 0;
        this.f476a &= -65;
        this.f484i = "";
        this.f476a &= -129;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0225ae mo13386clone() {
        return m650h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0224ad getDefaultInstanceForType() {
        return C0224ad.m612a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0224ad build() {
        C0224ad c0224adBuildPartial = buildPartial();
        if (!c0224adBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0224adBuildPartial);
        }
        return c0224adBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0224ad m651i() throws InvalidProtocolBufferException {
        C0224ad c0224adBuildPartial = buildPartial();
        if (!c0224adBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0224adBuildPartial).asInvalidProtocolBufferException();
        }
        return c0224adBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0224ad buildPartial() {
        C0224ad c0224ad = new C0224ad(this);
        int i = this.f476a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0224ad.f466c = this.f477b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0224ad.f467d = this.f478c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0224ad.f468e = this.f479d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0224ad.f469f = this.f480e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0224ad.f470g = this.f481f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0224ad.f471h = this.f482g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0224ad.f472i = this.f483h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        c0224ad.f473j = this.f484i;
        c0224ad.f465b = i2;
        return c0224ad;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0225ae mergeFrom(C0224ad c0224ad) {
        if (c0224ad != C0224ad.m612a()) {
            if (c0224ad.m629c()) {
                m653a(c0224ad.m630d());
            }
            if (c0224ad.m631e()) {
                m656a(c0224ad.m632f());
            }
            if (c0224ad.m633g()) {
                m659b(c0224ad.m634h());
            }
            if (c0224ad.m635i()) {
                m658b(c0224ad.m636j());
            }
            if (c0224ad.m637k()) {
                m662c(c0224ad.m638l());
            }
            if (c0224ad.m639m()) {
                m661c(c0224ad.m640n());
            }
            if (c0224ad.m641o()) {
                m664d(c0224ad.m642p());
            }
            if (c0224ad.m643q()) {
                m665d(c0224ad.m644r());
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
    public C0225ae mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 16:
                    this.f476a |= 1;
                    this.f477b = codedInputStream.readInt32();
                    break;
                case 26:
                    this.f476a |= 2;
                    this.f478c = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f476a |= 4;
                    this.f479d = codedInputStream.readBytes();
                    break;
                case 40:
                    this.f476a |= 8;
                    this.f480e = codedInputStream.readInt32();
                    break;
                case 50:
                    this.f476a |= 16;
                    this.f481f = codedInputStream.readBytes();
                    break;
                case 56:
                    this.f476a |= 32;
                    this.f482g = codedInputStream.readInt32();
                    break;
                case 64:
                    this.f476a |= 64;
                    this.f483h = codedInputStream.readInt32();
                    break;
                case 74:
                    this.f476a |= 128;
                    this.f484i = codedInputStream.readBytes();
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
    public C0225ae m653a(int i) {
        this.f476a |= 1;
        this.f477b = i;
        return this;
    }

    /* renamed from: a */
    public C0225ae m656a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f476a |= 2;
        this.f478c = str;
        return this;
    }

    /* renamed from: b */
    public C0225ae m659b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f476a |= 4;
        this.f479d = str;
        return this;
    }

    /* renamed from: b */
    public C0225ae m658b(int i) {
        this.f476a |= 8;
        this.f480e = i;
        return this;
    }

    /* renamed from: c */
    public C0225ae m662c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f476a |= 16;
        this.f481f = str;
        return this;
    }

    /* renamed from: c */
    public C0225ae m661c(int i) {
        this.f476a |= 32;
        this.f482g = i;
        return this;
    }

    /* renamed from: d */
    public C0225ae m664d(int i) {
        this.f476a |= 64;
        this.f483h = i;
        return this;
    }

    /* renamed from: d */
    public C0225ae m665d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f476a |= 128;
        this.f484i = str;
        return this;
    }
}
