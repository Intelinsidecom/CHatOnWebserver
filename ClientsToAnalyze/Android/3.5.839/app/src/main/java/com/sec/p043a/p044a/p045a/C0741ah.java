package com.sec.p043a.p044a.p045a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ah */
/* loaded from: classes.dex */
public final class C0741ah extends GeneratedMessageLite.Builder<C0740ag, C0741ah> implements InterfaceC0742ai {

    /* renamed from: a */
    private int f1730a;

    /* renamed from: b */
    private Object f1731b = "";

    /* renamed from: c */
    private Object f1732c = "";

    /* renamed from: d */
    private Object f1733d = "";

    /* renamed from: e */
    private Object f1734e = "";

    /* renamed from: f */
    private Object f1735f = "";

    private C0741ah() {
        m2429g();
    }

    /* renamed from: g */
    private void m2429g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0741ah m2430h() {
        return new C0741ah();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0741ah clear() {
        super.clear();
        this.f1731b = "";
        this.f1730a &= -2;
        this.f1732c = "";
        this.f1730a &= -3;
        this.f1733d = "";
        this.f1730a &= -5;
        this.f1734e = "";
        this.f1730a &= -9;
        this.f1735f = "";
        this.f1730a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0741ah mo19949clone() {
        return m2430h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0740ag getDefaultInstanceForType() {
        return C0740ag.m2400a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0740ag build() {
        C0740ag c0740agBuildPartial = buildPartial();
        if (!c0740agBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0740agBuildPartial);
        }
        return c0740agBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0740ag m2431i() throws InvalidProtocolBufferException {
        C0740ag c0740agBuildPartial = buildPartial();
        if (!c0740agBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0740agBuildPartial).asInvalidProtocolBufferException();
        }
        return c0740agBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0740ag buildPartial() {
        C0740ag c0740ag = new C0740ag(this);
        int i = this.f1730a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0740ag.f1723c = this.f1731b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0740ag.f1724d = this.f1732c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0740ag.f1725e = this.f1733d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0740ag.f1726f = this.f1734e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0740ag.f1727g = this.f1735f;
        c0740ag.f1722b = i2;
        return c0740ag;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0741ah mergeFrom(C0740ag c0740ag) {
        if (c0740ag != C0740ag.m2400a()) {
            if (c0740ag.m2415c()) {
                m2435a(c0740ag.m2416d());
            }
            if (c0740ag.m2417e()) {
                m2437b(c0740ag.m2418f());
            }
            if (c0740ag.m2419g()) {
                m2439c(c0740ag.m2420h());
            }
            if (c0740ag.m2421i()) {
                m2441d(c0740ag.m2422j());
            }
            if (c0740ag.m2423k()) {
                m2443e(c0740ag.m2424l());
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
    public C0741ah mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 18:
                    this.f1730a |= 1;
                    this.f1731b = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f1730a |= 2;
                    this.f1732c = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f1730a |= 4;
                    this.f1733d = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f1730a |= 8;
                    this.f1734e = codedInputStream.readBytes();
                    break;
                case 50:
                    this.f1730a |= 16;
                    this.f1735f = codedInputStream.readBytes();
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
    public C0741ah m2435a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1730a |= 1;
        this.f1731b = str;
        return this;
    }

    /* renamed from: b */
    public C0741ah m2437b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1730a |= 2;
        this.f1732c = str;
        return this;
    }

    /* renamed from: c */
    public C0741ah m2439c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1730a |= 4;
        this.f1733d = str;
        return this;
    }

    /* renamed from: d */
    public C0741ah m2441d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1730a |= 8;
        this.f1734e = str;
        return this;
    }

    /* renamed from: e */
    public C0741ah m2443e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1730a |= 16;
        this.f1735f = str;
        return this;
    }
}
