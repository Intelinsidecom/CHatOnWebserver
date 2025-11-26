package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ah */
/* loaded from: classes.dex */
public final class C0228ah extends GeneratedMessageLite.Builder<C0227ag, C0228ah> implements InterfaceC0229ai {

    /* renamed from: a */
    private int f494a;

    /* renamed from: b */
    private Object f495b = "";

    /* renamed from: c */
    private Object f496c = "";

    /* renamed from: d */
    private Object f497d = "";

    /* renamed from: e */
    private Object f498e = "";

    /* renamed from: f */
    private Object f499f = "";

    private C0228ah() {
        m697g();
    }

    /* renamed from: g */
    private void m697g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0228ah m698h() {
        return new C0228ah();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0228ah clear() {
        super.clear();
        this.f495b = "";
        this.f494a &= -2;
        this.f496c = "";
        this.f494a &= -3;
        this.f497d = "";
        this.f494a &= -5;
        this.f498e = "";
        this.f494a &= -9;
        this.f499f = "";
        this.f494a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0228ah mo13386clone() {
        return m698h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0227ag getDefaultInstanceForType() {
        return C0227ag.m668a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0227ag build() {
        C0227ag c0227agBuildPartial = buildPartial();
        if (!c0227agBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0227agBuildPartial);
        }
        return c0227agBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0227ag m699i() throws InvalidProtocolBufferException {
        C0227ag c0227agBuildPartial = buildPartial();
        if (!c0227agBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0227agBuildPartial).asInvalidProtocolBufferException();
        }
        return c0227agBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0227ag buildPartial() {
        C0227ag c0227ag = new C0227ag(this);
        int i = this.f494a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0227ag.f487c = this.f495b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0227ag.f488d = this.f496c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0227ag.f489e = this.f497d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0227ag.f490f = this.f498e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0227ag.f491g = this.f499f;
        c0227ag.f486b = i2;
        return c0227ag;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0228ah mergeFrom(C0227ag c0227ag) {
        if (c0227ag != C0227ag.m668a()) {
            if (c0227ag.m683c()) {
                m703a(c0227ag.m684d());
            }
            if (c0227ag.m685e()) {
                m705b(c0227ag.m686f());
            }
            if (c0227ag.m687g()) {
                m707c(c0227ag.m688h());
            }
            if (c0227ag.m689i()) {
                m709d(c0227ag.m690j());
            }
            if (c0227ag.m691k()) {
                m711e(c0227ag.m692l());
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
    public C0228ah mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 18:
                    this.f494a |= 1;
                    this.f495b = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f494a |= 2;
                    this.f496c = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f494a |= 4;
                    this.f497d = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f494a |= 8;
                    this.f498e = codedInputStream.readBytes();
                    break;
                case 50:
                    this.f494a |= 16;
                    this.f499f = codedInputStream.readBytes();
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
    public C0228ah m703a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f494a |= 1;
        this.f495b = str;
        return this;
    }

    /* renamed from: b */
    public C0228ah m705b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f494a |= 2;
        this.f496c = str;
        return this;
    }

    /* renamed from: c */
    public C0228ah m707c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f494a |= 4;
        this.f497d = str;
        return this;
    }

    /* renamed from: d */
    public C0228ah m709d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f494a |= 8;
        this.f498e = str;
        return this;
    }

    /* renamed from: e */
    public C0228ah m711e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f494a |= 16;
        this.f499f = str;
        return this;
    }
}
