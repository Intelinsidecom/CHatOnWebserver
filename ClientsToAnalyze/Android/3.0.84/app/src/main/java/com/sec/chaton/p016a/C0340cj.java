package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cj */
/* loaded from: classes.dex */
public final class C0340cj extends GeneratedMessageLite.Builder<C0339ci, C0340cj> implements InterfaceC0341ck {

    /* renamed from: a */
    private int f1166a;

    /* renamed from: b */
    private long f1167b;

    /* renamed from: g */
    private long f1172g;

    /* renamed from: c */
    private EnumC0354cx f1168c = EnumC0354cx.TEXT;

    /* renamed from: d */
    private EnumC0302az f1169d = EnumC0302az.SINGLE;

    /* renamed from: e */
    private Object f1170e = "";

    /* renamed from: f */
    private Object f1171f = "";

    /* renamed from: h */
    private Object f1173h = "";

    /* renamed from: i */
    private LazyStringList f1174i = LazyStringArrayList.EMPTY;

    /* renamed from: j */
    private Object f1175j = "";

    private C0340cj() {
        m2164g();
    }

    /* renamed from: g */
    private void m2164g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0340cj m2165h() {
        return new C0340cj();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0340cj clear() {
        super.clear();
        this.f1167b = 0L;
        this.f1166a &= -2;
        this.f1168c = EnumC0354cx.TEXT;
        this.f1166a &= -3;
        this.f1169d = EnumC0302az.SINGLE;
        this.f1166a &= -5;
        this.f1170e = "";
        this.f1166a &= -9;
        this.f1171f = "";
        this.f1166a &= -17;
        this.f1172g = 0L;
        this.f1166a &= -33;
        this.f1173h = "";
        this.f1166a &= -65;
        this.f1174i = LazyStringArrayList.EMPTY;
        this.f1166a &= -129;
        this.f1175j = "";
        this.f1166a &= -257;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0340cj mo13386clone() {
        return m2165h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0339ci getDefaultInstanceForType() {
        return C0339ci.m2127a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0339ci build() {
        C0339ci c0339ciBuildPartial = buildPartial();
        if (!c0339ciBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0339ciBuildPartial);
        }
        return c0339ciBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0339ci m2166i() throws InvalidProtocolBufferException {
        C0339ci c0339ciBuildPartial = buildPartial();
        if (!c0339ciBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0339ciBuildPartial).asInvalidProtocolBufferException();
        }
        return c0339ciBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0339ci buildPartial() {
        C0339ci c0339ci = new C0339ci(this);
        int i = this.f1166a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0339ci.f1155c = this.f1167b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0339ci.f1156d = this.f1168c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0339ci.f1157e = this.f1169d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0339ci.f1158f = this.f1170e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0339ci.f1159g = this.f1171f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0339ci.f1160h = this.f1172g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0339ci.f1161i = this.f1173h;
        if ((this.f1166a & 128) == 128) {
            this.f1174i = new UnmodifiableLazyStringList(this.f1174i);
            this.f1166a &= -129;
        }
        c0339ci.f1162j = this.f1174i;
        if ((i & 256) == 256) {
            i2 |= 128;
        }
        c0339ci.f1163k = this.f1175j;
        c0339ci.f1154b = i2;
        return c0339ci;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0340cj mergeFrom(C0339ci c0339ci) {
        if (c0339ci != C0339ci.m2127a()) {
            if (c0339ci.m2143c()) {
                m2169a(c0339ci.m2144d());
            }
            if (c0339ci.m2145e()) {
                m2173a(c0339ci.m2146f());
            }
            if (c0339ci.m2147g()) {
                m2171a(c0339ci.m2148h());
            }
            if (c0339ci.m2149i()) {
                m2174a(c0339ci.m2150j());
            }
            if (c0339ci.m2151k()) {
                m2177b(c0339ci.m2152l());
            }
            if (c0339ci.m2153m()) {
                m2176b(c0339ci.m2154n());
            }
            if (c0339ci.m2155o()) {
                m2179c(c0339ci.m2156p());
            }
            if (!c0339ci.f1162j.isEmpty()) {
                if (this.f1174i.isEmpty()) {
                    this.f1174i = c0339ci.f1162j;
                    this.f1166a &= -129;
                } else {
                    m2167j();
                    this.f1174i.addAll(c0339ci.f1162j);
                }
            }
            if (c0339ci.m2158r()) {
                m2183e(c0339ci.m2159s());
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
    public C0340cj mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1166a |= 1;
                    this.f1167b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0354cx enumC0354cxM2352a = EnumC0354cx.m2352a(codedInputStream.readEnum());
                    if (enumC0354cxM2352a == null) {
                        break;
                    } else {
                        this.f1166a |= 2;
                        this.f1168c = enumC0354cxM2352a;
                        break;
                    }
                case 24:
                    EnumC0302az enumC0302azM1704a = EnumC0302az.m1704a(codedInputStream.readEnum());
                    if (enumC0302azM1704a == null) {
                        break;
                    } else {
                        this.f1166a |= 4;
                        this.f1169d = enumC0302azM1704a;
                        break;
                    }
                case 34:
                    this.f1166a |= 8;
                    this.f1170e = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f1166a |= 16;
                    this.f1171f = codedInputStream.readBytes();
                    break;
                case 48:
                    this.f1166a |= 32;
                    this.f1172g = codedInputStream.readInt64();
                    break;
                case 58:
                    this.f1166a |= 64;
                    this.f1173h = codedInputStream.readBytes();
                    break;
                case 66:
                    m2167j();
                    this.f1174i.add(codedInputStream.readBytes());
                    break;
                case 74:
                    this.f1166a |= 256;
                    this.f1175j = codedInputStream.readBytes();
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
    public C0340cj m2169a(long j) {
        this.f1166a |= 1;
        this.f1167b = j;
        return this;
    }

    /* renamed from: a */
    public C0340cj m2173a(EnumC0354cx enumC0354cx) {
        if (enumC0354cx == null) {
            throw new NullPointerException();
        }
        this.f1166a |= 2;
        this.f1168c = enumC0354cx;
        return this;
    }

    /* renamed from: a */
    public C0340cj m2171a(EnumC0302az enumC0302az) {
        if (enumC0302az == null) {
            throw new NullPointerException();
        }
        this.f1166a |= 4;
        this.f1169d = enumC0302az;
        return this;
    }

    /* renamed from: a */
    public C0340cj m2174a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1166a |= 8;
        this.f1170e = str;
        return this;
    }

    /* renamed from: b */
    public C0340cj m2177b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1166a |= 16;
        this.f1171f = str;
        return this;
    }

    /* renamed from: b */
    public C0340cj m2176b(long j) {
        this.f1166a |= 32;
        this.f1172g = j;
        return this;
    }

    /* renamed from: c */
    public C0340cj m2179c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1166a |= 64;
        this.f1173h = str;
        return this;
    }

    /* renamed from: j */
    private void m2167j() {
        if ((this.f1166a & 128) != 128) {
            this.f1174i = new LazyStringArrayList(this.f1174i);
            this.f1166a |= 128;
        }
    }

    /* renamed from: d */
    public C0340cj m2181d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m2167j();
        this.f1174i.add((LazyStringList) str);
        return this;
    }

    /* renamed from: e */
    public C0340cj m2183e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1166a |= 256;
        this.f1175j = str;
        return this;
    }
}
