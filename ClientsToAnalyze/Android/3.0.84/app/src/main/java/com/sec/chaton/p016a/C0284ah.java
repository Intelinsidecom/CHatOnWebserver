package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ah */
/* loaded from: classes.dex */
public final class C0284ah extends GeneratedMessageLite.Builder<C0283ag, C0284ah> implements InterfaceC0285ai {

    /* renamed from: a */
    private int f904a;

    /* renamed from: b */
    private EnumC0294ar f905b = EnumC0294ar.ENTER;

    /* renamed from: c */
    private Object f906c = "";

    /* renamed from: d */
    private Object f907d = "";

    private C0284ah() {
        m1468g();
    }

    /* renamed from: g */
    private void m1468g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0284ah m1469h() {
        return new C0284ah();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0284ah clear() {
        super.clear();
        this.f905b = EnumC0294ar.ENTER;
        this.f904a &= -2;
        this.f906c = "";
        this.f904a &= -3;
        this.f907d = "";
        this.f904a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0284ah mo13386clone() {
        return m1469h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0283ag getDefaultInstanceForType() {
        return C0283ag.m1450a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0283ag build() {
        C0283ag c0283agBuildPartial = buildPartial();
        if (!c0283agBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0283agBuildPartial);
        }
        return c0283agBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0283ag buildPartial() {
        C0283ag c0283ag = new C0283ag(this);
        int i = this.f904a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0283ag.f899c = this.f905b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0283ag.f900d = this.f906c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0283ag.f901e = this.f907d;
        c0283ag.f898b = i2;
        return c0283ag;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0284ah mergeFrom(C0283ag c0283ag) {
        if (c0283ag != C0283ag.m1450a()) {
            if (c0283ag.m1459c()) {
                m1473a(c0283ag.m1460d());
            }
            if (c0283ag.m1461e()) {
                m1474a(c0283ag.m1462f());
            }
            if (c0283ag.m1463g()) {
                m1476b(c0283ag.m1464h());
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
    public C0284ah mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    EnumC0294ar enumC0294arM1583a = EnumC0294ar.m1583a(codedInputStream.readEnum());
                    if (enumC0294arM1583a == null) {
                        break;
                    } else {
                        this.f904a |= 1;
                        this.f905b = enumC0294arM1583a;
                        break;
                    }
                case 18:
                    this.f904a |= 2;
                    this.f906c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f904a |= 4;
                    this.f907d = codedInputStream.readBytes();
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
    public C0284ah m1473a(EnumC0294ar enumC0294ar) {
        if (enumC0294ar == null) {
            throw new NullPointerException();
        }
        this.f904a |= 1;
        this.f905b = enumC0294ar;
        return this;
    }

    /* renamed from: a */
    public C0284ah m1474a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f904a |= 2;
        this.f906c = str;
        return this;
    }

    /* renamed from: b */
    public C0284ah m1476b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f904a |= 4;
        this.f907d = str;
        return this;
    }
}
