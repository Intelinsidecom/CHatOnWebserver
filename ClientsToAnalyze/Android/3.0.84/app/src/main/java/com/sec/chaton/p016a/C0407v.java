package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.v */
/* loaded from: classes.dex */
public final class C0407v extends GeneratedMessageLite.Builder<C0406u, C0407v> implements InterfaceC0408w {

    /* renamed from: a */
    private int f1445a;

    /* renamed from: b */
    private Object f1446b = "";

    /* renamed from: c */
    private long f1447c;

    private C0407v() {
        m2979g();
    }

    /* renamed from: g */
    private void m2979g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0407v m2980h() {
        return new C0407v();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0407v clear() {
        super.clear();
        this.f1446b = "";
        this.f1445a &= -2;
        this.f1447c = 0L;
        this.f1445a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0407v mo13386clone() {
        return m2980h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0406u getDefaultInstanceForType() {
        return C0406u.m2966a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0406u build() {
        C0406u c0406uBuildPartial = buildPartial();
        if (!c0406uBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0406uBuildPartial);
        }
        return c0406uBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0406u buildPartial() {
        C0406u c0406u = new C0406u(this);
        int i = this.f1445a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0406u.f1441c = this.f1446b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0406u.f1442d = this.f1447c;
        c0406u.f1440b = i2;
        return c0406u;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0407v mergeFrom(C0406u c0406u) {
        if (c0406u != C0406u.m2966a()) {
            if (c0406u.m2972c()) {
                m2985a(c0406u.m2973d());
            }
            if (c0406u.m2974e()) {
                m2982a(c0406u.m2975f());
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
    public C0407v mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f1445a |= 1;
                    this.f1446b = codedInputStream.readBytes();
                    break;
                case 16:
                    this.f1445a |= 2;
                    this.f1447c = codedInputStream.readInt64();
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
    public C0407v m2985a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1445a |= 1;
        this.f1446b = str;
        return this;
    }

    /* renamed from: a */
    public C0407v m2982a(long j) {
        this.f1445a |= 2;
        this.f1447c = j;
        return this;
    }
}
