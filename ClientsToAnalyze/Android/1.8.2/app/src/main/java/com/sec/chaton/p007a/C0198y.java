package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.y */
/* loaded from: classes.dex */
public final class C0198y extends GeneratedMessageLite.Builder implements InterfaceC0199z {

    /* renamed from: a */
    private int f720a;

    /* renamed from: b */
    private EnumC0108aa f721b = EnumC0108aa.ENTER;

    /* renamed from: c */
    private Object f722c = "";

    /* renamed from: d */
    private Object f723d = "";

    private C0198y() {
        m1778g();
    }

    /* renamed from: g */
    private void m1778g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0198y m1779h() {
        return new C0198y();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0198y clear() {
        super.clear();
        this.f721b = EnumC0108aa.ENTER;
        this.f720a &= -2;
        this.f722c = "";
        this.f720a &= -3;
        this.f723d = "";
        this.f720a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0198y mo7542clone() {
        return m1779h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0197x getDefaultInstanceForType() {
        return C0197x.m1761a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0197x build() {
        C0197x c0197xBuildPartial = buildPartial();
        if (!c0197xBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0197xBuildPartial);
        }
        return c0197xBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0197x buildPartial() {
        C0197x c0197x = new C0197x(this);
        int i = this.f720a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0197x.f715c = this.f721b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0197x.f716d = this.f722c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0197x.f717e = this.f723d;
        c0197x.f714b = i2;
        return c0197x;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0198y mergeFrom(C0197x c0197x) {
        if (c0197x != C0197x.m1761a()) {
            if (c0197x.m1769c()) {
                m1782a(c0197x.m1770d());
            }
            if (c0197x.m1771e()) {
                m1784a(c0197x.m1772f());
            }
            if (c0197x.m1773g()) {
                m1786b(c0197x.m1774h());
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
    public C0198y mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    EnumC0108aa enumC0108aaM690a = EnumC0108aa.m690a(codedInputStream.readEnum());
                    if (enumC0108aaM690a == null) {
                        break;
                    } else {
                        this.f720a |= 1;
                        this.f721b = enumC0108aaM690a;
                        break;
                    }
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    this.f720a |= 2;
                    this.f722c = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    this.f720a |= 4;
                    this.f723d = codedInputStream.readBytes();
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
    public C0198y m1782a(EnumC0108aa enumC0108aa) {
        if (enumC0108aa == null) {
            throw new NullPointerException();
        }
        this.f720a |= 1;
        this.f721b = enumC0108aa;
        return this;
    }

    /* renamed from: a */
    public C0198y m1784a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f720a |= 2;
        this.f722c = str;
        return this;
    }

    /* renamed from: b */
    public C0198y m1786b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f720a |= 4;
        this.f723d = str;
        return this;
    }
}
