package com.sec.p013a.p014a.p015a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.an */
/* loaded from: classes.dex */
public final class C0234an extends GeneratedMessageLite.Builder<C0233am, C0234an> implements InterfaceC0235ao {

    /* renamed from: a */
    private int f523a;

    /* renamed from: b */
    private int f524b;

    /* renamed from: c */
    private Object f525c = "";

    /* renamed from: d */
    private Object f526d = "";

    /* renamed from: e */
    private Object f527e = "";

    private C0234an() {
        m780g();
    }

    /* renamed from: g */
    private void m780g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0234an m781h() {
        return new C0234an();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0234an clear() {
        super.clear();
        this.f524b = 0;
        this.f523a &= -2;
        this.f525c = "";
        this.f523a &= -3;
        this.f526d = "";
        this.f523a &= -5;
        this.f527e = "";
        this.f523a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0234an mo13386clone() {
        return m781h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0233am getDefaultInstanceForType() {
        return C0233am.m756a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0233am build() {
        C0233am c0233amBuildPartial = buildPartial();
        if (!c0233amBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0233amBuildPartial);
        }
        return c0233amBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0233am m782i() throws InvalidProtocolBufferException {
        C0233am c0233amBuildPartial = buildPartial();
        if (!c0233amBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0233amBuildPartial).asInvalidProtocolBufferException();
        }
        return c0233amBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0233am buildPartial() {
        C0233am c0233am = new C0233am(this);
        int i = this.f523a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0233am.f517c = this.f524b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0233am.f518d = this.f525c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0233am.f519e = this.f526d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0233am.f520f = this.f527e;
        c0233am.f516b = i2;
        return c0233am;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0234an mergeFrom(C0233am c0233am) {
        if (c0233am != C0233am.m756a()) {
            if (c0233am.m768c()) {
                m784a(c0233am.m769d());
            }
            if (c0233am.m770e()) {
                m787a(c0233am.m771f());
            }
            if (c0233am.m772g()) {
                m789b(c0233am.m773h());
            }
            if (c0233am.m774i()) {
                m791c(c0233am.m775j());
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
    public C0234an mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f523a |= 1;
                    this.f524b = codedInputStream.readInt32();
                    break;
                case 18:
                    this.f523a |= 2;
                    this.f525c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f523a |= 4;
                    this.f526d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f523a |= 8;
                    this.f527e = codedInputStream.readBytes();
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
    public C0234an m784a(int i) {
        this.f523a |= 1;
        this.f524b = i;
        return this;
    }

    /* renamed from: a */
    public C0234an m787a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f523a |= 2;
        this.f525c = str;
        return this;
    }

    /* renamed from: b */
    public C0234an m789b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f523a |= 4;
        this.f526d = str;
        return this;
    }

    /* renamed from: c */
    public C0234an m791c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f523a |= 8;
        this.f527e = str;
        return this;
    }
}
