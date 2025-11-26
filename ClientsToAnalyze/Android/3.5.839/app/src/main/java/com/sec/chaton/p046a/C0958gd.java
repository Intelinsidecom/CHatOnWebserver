package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.gd */
/* loaded from: classes.dex */
public final class C0958gd extends GeneratedMessageLite.Builder<C0957gc, C0958gd> implements InterfaceC0959ge {

    /* renamed from: a */
    private int f3080a;

    /* renamed from: b */
    private Object f3081b = "";

    /* renamed from: c */
    private int f3082c;

    private C0958gd() {
        m5567g();
    }

    /* renamed from: g */
    private void m5567g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0958gd m5568h() {
        return new C0958gd();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0958gd clear() {
        super.clear();
        this.f3081b = "";
        this.f3080a &= -2;
        this.f3082c = 0;
        this.f3080a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0958gd mo19949clone() {
        return m5568h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0957gc getDefaultInstanceForType() {
        return C0957gc.m5553a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0957gc build() {
        C0957gc c0957gcBuildPartial = buildPartial();
        if (!c0957gcBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0957gcBuildPartial);
        }
        return c0957gcBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0957gc buildPartial() {
        C0957gc c0957gc = new C0957gc(this);
        int i = this.f3080a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0957gc.f3076c = this.f3081b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0957gc.f3077d = this.f3082c;
        c0957gc.f3075b = i2;
        return c0957gc;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0958gd mergeFrom(C0957gc c0957gc) {
        if (c0957gc != C0957gc.m5553a()) {
            if (c0957gc.m5560c()) {
                m5573a(c0957gc.m5561d());
            }
            if (c0957gc.m5562e()) {
                m5570a(c0957gc.m5563f());
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
    public C0958gd mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f3080a |= 1;
                    this.f3081b = codedInputStream.readBytes();
                    break;
                case 16:
                    this.f3080a |= 2;
                    this.f3082c = codedInputStream.readInt32();
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
    public C0958gd m5573a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3080a |= 1;
        this.f3081b = str;
        return this;
    }

    /* renamed from: a */
    public C0958gd m5570a(int i) {
        this.f3080a |= 2;
        this.f3082c = i;
        return this;
    }
}
