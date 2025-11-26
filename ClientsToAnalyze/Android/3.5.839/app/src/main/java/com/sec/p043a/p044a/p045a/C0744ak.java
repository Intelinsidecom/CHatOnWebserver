package com.sec.p043a.p044a.p045a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ak */
/* loaded from: classes.dex */
public final class C0744ak extends GeneratedMessageLite.Builder<C0743aj, C0744ak> implements InterfaceC0745al {

    /* renamed from: a */
    private int f1745a;

    /* renamed from: b */
    private int f1746b;

    /* renamed from: c */
    private int f1747c;

    /* renamed from: d */
    private Object f1748d = "";

    /* renamed from: e */
    private Object f1749e = "";

    /* renamed from: f */
    private Object f1750f = "";

    private C0744ak() {
        m2472g();
    }

    /* renamed from: g */
    private void m2472g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0744ak m2473h() {
        return new C0744ak();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0744ak clear() {
        super.clear();
        this.f1746b = 0;
        this.f1745a &= -2;
        this.f1747c = 0;
        this.f1745a &= -3;
        this.f1748d = "";
        this.f1745a &= -5;
        this.f1749e = "";
        this.f1745a &= -9;
        this.f1750f = "";
        this.f1745a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0744ak mo19949clone() {
        return m2473h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0743aj getDefaultInstanceForType() {
        return C0743aj.m2445a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0743aj build() {
        C0743aj c0743ajBuildPartial = buildPartial();
        if (!c0743ajBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0743ajBuildPartial);
        }
        return c0743ajBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0743aj m2474i() throws InvalidProtocolBufferException {
        C0743aj c0743ajBuildPartial = buildPartial();
        if (!c0743ajBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0743ajBuildPartial).asInvalidProtocolBufferException();
        }
        return c0743ajBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0743aj buildPartial() {
        C0743aj c0743aj = new C0743aj(this);
        int i = this.f1745a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0743aj.f1738c = this.f1746b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0743aj.f1739d = this.f1747c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0743aj.f1740e = this.f1748d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0743aj.f1741f = this.f1749e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0743aj.f1742g = this.f1750f;
        c0743aj.f1737b = i2;
        return c0743aj;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0744ak mergeFrom(C0743aj c0743aj) {
        if (c0743aj != C0743aj.m2445a()) {
            if (c0743aj.m2458c()) {
                m2476a(c0743aj.m2459d());
            }
            if (c0743aj.m2460e()) {
                m2481b(c0743aj.m2461f());
            }
            if (c0743aj.m2462g()) {
                m2479a(c0743aj.m2463h());
            }
            if (c0743aj.m2464i()) {
                m2482b(c0743aj.m2465j());
            }
            if (c0743aj.m2466k()) {
                m2484c(c0743aj.m2467l());
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
    public C0744ak mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1745a |= 1;
                    this.f1746b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f1745a |= 2;
                    this.f1747c = codedInputStream.readInt32();
                    break;
                case 26:
                    this.f1745a |= 4;
                    this.f1748d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f1745a |= 8;
                    this.f1749e = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f1745a |= 16;
                    this.f1750f = codedInputStream.readBytes();
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
    public C0744ak m2476a(int i) {
        this.f1745a |= 1;
        this.f1746b = i;
        return this;
    }

    /* renamed from: b */
    public C0744ak m2481b(int i) {
        this.f1745a |= 2;
        this.f1747c = i;
        return this;
    }

    /* renamed from: a */
    public C0744ak m2479a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1745a |= 4;
        this.f1748d = str;
        return this;
    }

    /* renamed from: b */
    public C0744ak m2482b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1745a |= 8;
        this.f1749e = str;
        return this;
    }

    /* renamed from: c */
    public C0744ak m2484c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1745a |= 16;
        this.f1750f = str;
        return this;
    }
}
