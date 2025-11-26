package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.eb */
/* loaded from: classes.dex */
public final class C0386eb extends GeneratedMessageLite.Builder<C0385ea, C0386eb> implements InterfaceC0387ec {

    /* renamed from: a */
    private int f1355a;

    /* renamed from: b */
    private Object f1356b = "";

    /* renamed from: c */
    private int f1357c;

    private C0386eb() {
        m2704g();
    }

    /* renamed from: g */
    private void m2704g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0386eb m2705h() {
        return new C0386eb();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0386eb clear() {
        super.clear();
        this.f1356b = "";
        this.f1355a &= -2;
        this.f1357c = 0;
        this.f1355a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0386eb mo13386clone() {
        return m2705h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0385ea getDefaultInstanceForType() {
        return C0385ea.m2690a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0385ea build() {
        C0385ea c0385eaBuildPartial = buildPartial();
        if (!c0385eaBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0385eaBuildPartial);
        }
        return c0385eaBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0385ea buildPartial() {
        C0385ea c0385ea = new C0385ea(this);
        int i = this.f1355a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0385ea.f1351c = this.f1356b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0385ea.f1352d = this.f1357c;
        c0385ea.f1350b = i2;
        return c0385ea;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0386eb mergeFrom(C0385ea c0385ea) {
        if (c0385ea != C0385ea.m2690a()) {
            if (c0385ea.m2697c()) {
                m2710a(c0385ea.m2698d());
            }
            if (c0385ea.m2699e()) {
                m2707a(c0385ea.m2700f());
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
    public C0386eb mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f1355a |= 1;
                    this.f1356b = codedInputStream.readBytes();
                    break;
                case 16:
                    this.f1355a |= 2;
                    this.f1357c = codedInputStream.readInt32();
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
    public C0386eb m2710a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1355a |= 1;
        this.f1356b = str;
        return this;
    }

    /* renamed from: a */
    public C0386eb m2707a(int i) {
        this.f1355a |= 2;
        this.f1357c = i;
        return this;
    }
}
