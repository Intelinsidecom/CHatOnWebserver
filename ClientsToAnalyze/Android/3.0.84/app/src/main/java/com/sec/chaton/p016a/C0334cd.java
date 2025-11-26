package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cd */
/* loaded from: classes.dex */
public final class C0334cd extends GeneratedMessageLite.Builder<C0333cc, C0334cd> implements InterfaceC0335ce {

    /* renamed from: a */
    private int f1130a;

    /* renamed from: d */
    private long f1133d;

    /* renamed from: f */
    private long f1135f;

    /* renamed from: b */
    private Object f1131b = "";

    /* renamed from: c */
    private LazyStringList f1132c = LazyStringArrayList.EMPTY;

    /* renamed from: e */
    private Object f1134e = "";

    /* renamed from: g */
    private EnumC0354cx f1136g = EnumC0354cx.TEXT;

    /* renamed from: h */
    private EnumC0302az f1137h = EnumC0302az.SINGLE;

    private C0334cd() {
        m2059g();
    }

    /* renamed from: g */
    private void m2059g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0334cd m2060h() {
        return new C0334cd();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0334cd clear() {
        super.clear();
        this.f1131b = "";
        this.f1130a &= -2;
        this.f1132c = LazyStringArrayList.EMPTY;
        this.f1130a &= -3;
        this.f1133d = 0L;
        this.f1130a &= -5;
        this.f1134e = "";
        this.f1130a &= -9;
        this.f1135f = 0L;
        this.f1130a &= -17;
        this.f1136g = EnumC0354cx.TEXT;
        this.f1130a &= -33;
        this.f1137h = EnumC0302az.SINGLE;
        this.f1130a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0334cd mo13386clone() {
        return m2060h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0333cc getDefaultInstanceForType() {
        return C0333cc.m2030a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0333cc build() {
        C0333cc c0333ccBuildPartial = buildPartial();
        if (!c0333ccBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0333ccBuildPartial);
        }
        return c0333ccBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0333cc buildPartial() {
        C0333cc c0333cc = new C0333cc(this);
        int i = this.f1130a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0333cc.f1121c = this.f1131b;
        if ((this.f1130a & 2) == 2) {
            this.f1132c = new UnmodifiableLazyStringList(this.f1132c);
            this.f1130a &= -3;
        }
        c0333cc.f1122d = this.f1132c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0333cc.f1123e = this.f1133d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0333cc.f1124f = this.f1134e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0333cc.f1125g = this.f1135f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0333cc.f1126h = this.f1136g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0333cc.f1127i = this.f1137h;
        c0333cc.f1120b = i2;
        return c0333cc;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0334cd mergeFrom(C0333cc c0333cc) {
        if (c0333cc != C0333cc.m2030a()) {
            if (c0333cc.m2042c()) {
                m2068a(c0333cc.m2043d());
            }
            if (!c0333cc.f1122d.isEmpty()) {
                if (this.f1132c.isEmpty()) {
                    this.f1132c = c0333cc.f1122d;
                    this.f1130a &= -3;
                } else {
                    m2061i();
                    this.f1132c.addAll(c0333cc.f1122d);
                }
            }
            if (c0333cc.m2046g()) {
                m2063a(c0333cc.m2047h());
            }
            if (c0333cc.m2048i()) {
                m2071b(c0333cc.m2049j());
            }
            if (c0333cc.m2050k()) {
                m2070b(c0333cc.m2051l());
            }
            if (c0333cc.m2052m()) {
                m2067a(c0333cc.m2053n());
            }
            if (c0333cc.m2054o()) {
                m2065a(c0333cc.m2055p());
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
    public C0334cd mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f1130a |= 1;
                    this.f1131b = codedInputStream.readBytes();
                    break;
                case 18:
                    m2061i();
                    this.f1132c.add(codedInputStream.readBytes());
                    break;
                case 24:
                    this.f1130a |= 4;
                    this.f1133d = codedInputStream.readInt64();
                    break;
                case 34:
                    this.f1130a |= 8;
                    this.f1134e = codedInputStream.readBytes();
                    break;
                case 40:
                    this.f1130a |= 16;
                    this.f1135f = codedInputStream.readInt64();
                    break;
                case 48:
                    EnumC0354cx enumC0354cxM2352a = EnumC0354cx.m2352a(codedInputStream.readEnum());
                    if (enumC0354cxM2352a == null) {
                        break;
                    } else {
                        this.f1130a |= 32;
                        this.f1136g = enumC0354cxM2352a;
                        break;
                    }
                case 56:
                    EnumC0302az enumC0302azM1704a = EnumC0302az.m1704a(codedInputStream.readEnum());
                    if (enumC0302azM1704a == null) {
                        break;
                    } else {
                        this.f1130a |= 64;
                        this.f1137h = enumC0302azM1704a;
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
    public C0334cd m2068a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1130a |= 1;
        this.f1131b = str;
        return this;
    }

    /* renamed from: i */
    private void m2061i() {
        if ((this.f1130a & 2) != 2) {
            this.f1132c = new LazyStringArrayList(this.f1132c);
            this.f1130a |= 2;
        }
    }

    /* renamed from: a */
    public C0334cd m2063a(long j) {
        this.f1130a |= 4;
        this.f1133d = j;
        return this;
    }

    /* renamed from: b */
    public C0334cd m2071b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1130a |= 8;
        this.f1134e = str;
        return this;
    }

    /* renamed from: b */
    public C0334cd m2070b(long j) {
        this.f1130a |= 16;
        this.f1135f = j;
        return this;
    }

    /* renamed from: a */
    public C0334cd m2067a(EnumC0354cx enumC0354cx) {
        if (enumC0354cx == null) {
            throw new NullPointerException();
        }
        this.f1130a |= 32;
        this.f1136g = enumC0354cx;
        return this;
    }

    /* renamed from: a */
    public C0334cd m2065a(EnumC0302az enumC0302az) {
        if (enumC0302az == null) {
            throw new NullPointerException();
        }
        this.f1130a |= 64;
        this.f1137h = enumC0302az;
        return this;
    }
}
