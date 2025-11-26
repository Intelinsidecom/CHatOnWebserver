package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bj */
/* loaded from: classes.dex */
public final class C0313bj extends GeneratedMessageLite.Builder<C0312bi, C0313bj> implements InterfaceC0314bk {

    /* renamed from: a */
    private int f1048a;

    /* renamed from: d */
    private long f1051d;

    /* renamed from: b */
    private Object f1049b = "";

    /* renamed from: c */
    private Object f1050c = "";

    /* renamed from: e */
    private EnumC0354cx f1052e = EnumC0354cx.TEXT;

    private C0313bj() {
        m1836g();
    }

    /* renamed from: g */
    private void m1836g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0313bj m1837h() {
        return new C0313bj();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0313bj clear() {
        super.clear();
        this.f1049b = "";
        this.f1048a &= -2;
        this.f1050c = "";
        this.f1048a &= -3;
        this.f1051d = 0L;
        this.f1048a &= -5;
        this.f1052e = EnumC0354cx.TEXT;
        this.f1048a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0313bj mo13386clone() {
        return m1837h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0312bi getDefaultInstanceForType() {
        return C0312bi.m1816a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0312bi build() {
        C0312bi c0312biBuildPartial = buildPartial();
        if (!c0312biBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0312biBuildPartial);
        }
        return c0312biBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0312bi buildPartial() {
        C0312bi c0312bi = new C0312bi(this);
        int i = this.f1048a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0312bi.f1042c = this.f1049b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0312bi.f1043d = this.f1050c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0312bi.f1044e = this.f1051d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0312bi.f1045f = this.f1052e;
        c0312bi.f1041b = i2;
        return c0312bi;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0313bj mergeFrom(C0312bi c0312bi) {
        if (c0312bi != C0312bi.m1816a()) {
            if (c0312bi.m1825c()) {
                m1843a(c0312bi.m1826d());
            }
            if (c0312bi.m1827e()) {
                m1845b(c0312bi.m1828f());
            }
            if (c0312bi.m1829g()) {
                m1839a(c0312bi.m1830h());
            }
            if (c0312bi.m1831i()) {
                m1842a(c0312bi.m1832j());
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
    public C0313bj mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f1048a |= 1;
                    this.f1049b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f1048a |= 2;
                    this.f1050c = codedInputStream.readBytes();
                    break;
                case 24:
                    this.f1048a |= 4;
                    this.f1051d = codedInputStream.readInt64();
                    break;
                case 32:
                    EnumC0354cx enumC0354cxM2352a = EnumC0354cx.m2352a(codedInputStream.readEnum());
                    if (enumC0354cxM2352a == null) {
                        break;
                    } else {
                        this.f1048a |= 8;
                        this.f1052e = enumC0354cxM2352a;
                        break;
                    }
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
    public C0313bj m1843a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1048a |= 1;
        this.f1049b = str;
        return this;
    }

    /* renamed from: b */
    public C0313bj m1845b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1048a |= 2;
        this.f1050c = str;
        return this;
    }

    /* renamed from: a */
    public C0313bj m1839a(long j) {
        this.f1048a |= 4;
        this.f1051d = j;
        return this;
    }

    /* renamed from: a */
    public C0313bj m1842a(EnumC0354cx enumC0354cx) {
        if (enumC0354cx == null) {
            throw new NullPointerException();
        }
        this.f1048a |= 8;
        this.f1052e = enumC0354cx;
        return this;
    }
}
