package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ca */
/* loaded from: classes.dex */
public final class C0331ca extends GeneratedMessageLite.Builder<C0329bz, C0331ca> implements InterfaceC0332cb {

    /* renamed from: a */
    private int f1111a;

    /* renamed from: b */
    private long f1112b;

    /* renamed from: c */
    private EnumC0302az f1113c = EnumC0302az.SINGLE;

    /* renamed from: d */
    private Object f1114d = "";

    /* renamed from: e */
    private Object f1115e = "";

    /* renamed from: f */
    private Object f1116f = "";

    /* renamed from: g */
    private LazyStringList f1117g = LazyStringArrayList.EMPTY;

    /* renamed from: h */
    private long f1118h;

    private C0331ca() {
        m2002m();
    }

    /* renamed from: m */
    private void m2002m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static C0331ca m2003n() {
        return new C0331ca();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0331ca clear() {
        super.clear();
        this.f1112b = 0L;
        this.f1111a &= -2;
        this.f1113c = EnumC0302az.SINGLE;
        this.f1111a &= -3;
        this.f1114d = "";
        this.f1111a &= -5;
        this.f1115e = "";
        this.f1111a &= -9;
        this.f1116f = "";
        this.f1111a &= -17;
        this.f1117g = LazyStringArrayList.EMPTY;
        this.f1111a &= -33;
        this.f1118h = 0L;
        this.f1111a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0331ca mo13386clone() {
        return m2003n().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0329bz getDefaultInstanceForType() {
        return C0329bz.m1958a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0329bz build() {
        C0329bz c0329bzBuildPartial = buildPartial();
        if (!c0329bzBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0329bzBuildPartial);
        }
        return c0329bzBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public C0329bz m2004o() throws InvalidProtocolBufferException {
        C0329bz c0329bzBuildPartial = buildPartial();
        if (!c0329bzBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0329bzBuildPartial).asInvalidProtocolBufferException();
        }
        return c0329bzBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0329bz buildPartial() {
        C0329bz c0329bz = new C0329bz(this);
        int i = this.f1111a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0329bz.f1096c = this.f1112b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0329bz.f1097d = this.f1113c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0329bz.f1098e = this.f1114d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0329bz.f1099f = this.f1115e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0329bz.f1100g = this.f1116f;
        if ((this.f1111a & 32) == 32) {
            this.f1117g = new UnmodifiableLazyStringList(this.f1117g);
            this.f1111a &= -33;
        }
        c0329bz.f1101h = this.f1117g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0329bz.f1102i = this.f1118h;
        c0329bz.f1095b = i2;
        return c0329bz;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0331ca mergeFrom(C0329bz c0329bz) {
        if (c0329bz != C0329bz.m1958a()) {
            if (c0329bz.m1971c()) {
                m2007a(c0329bz.m1972d());
            }
            if (c0329bz.m1973e()) {
                m2009a(c0329bz.m1974f());
            }
            if (c0329bz.m1975g()) {
                m2011a(c0329bz.m1976h());
            }
            if (c0329bz.m1977i()) {
                m2014b(c0329bz.m1978j());
            }
            if (c0329bz.m1979k()) {
                m2016c(c0329bz.m1980l());
            }
            if (!c0329bz.f1101h.isEmpty()) {
                if (this.f1117g.isEmpty()) {
                    this.f1117g = c0329bz.f1101h;
                    this.f1111a &= -33;
                } else {
                    m2005p();
                    this.f1117g.addAll(c0329bz.f1101h);
                }
            }
            if (c0329bz.m1982n()) {
                m2013b(c0329bz.m1983o());
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
    public C0331ca mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1111a |= 1;
                    this.f1112b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0302az enumC0302azM1704a = EnumC0302az.m1704a(codedInputStream.readEnum());
                    if (enumC0302azM1704a == null) {
                        break;
                    } else {
                        this.f1111a |= 2;
                        this.f1113c = enumC0302azM1704a;
                        break;
                    }
                case 26:
                    this.f1111a |= 4;
                    this.f1114d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f1111a |= 8;
                    this.f1115e = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f1111a |= 16;
                    this.f1116f = codedInputStream.readBytes();
                    break;
                case 50:
                    m2005p();
                    this.f1117g.add(codedInputStream.readBytes());
                    break;
                case 56:
                    this.f1111a |= 64;
                    this.f1118h = codedInputStream.readInt64();
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

    /* renamed from: f */
    public long m2020f() {
        return this.f1112b;
    }

    /* renamed from: a */
    public C0331ca m2007a(long j) {
        this.f1111a |= 1;
        this.f1112b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0302az m2021g() {
        return this.f1113c;
    }

    /* renamed from: a */
    public C0331ca m2009a(EnumC0302az enumC0302az) {
        if (enumC0302az == null) {
            throw new NullPointerException();
        }
        this.f1111a |= 2;
        this.f1113c = enumC0302az;
        return this;
    }

    /* renamed from: h */
    public String m2022h() {
        Object obj = this.f1114d;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f1114d = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: a */
    public C0331ca m2011a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1111a |= 4;
        this.f1114d = str;
        return this;
    }

    /* renamed from: b */
    public C0331ca m2014b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1111a |= 8;
        this.f1115e = str;
        return this;
    }

    /* renamed from: i */
    public String m2023i() {
        Object obj = this.f1116f;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f1116f = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: c */
    public C0331ca m2016c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1111a |= 16;
        this.f1116f = str;
        return this;
    }

    /* renamed from: p */
    private void m2005p() {
        if ((this.f1111a & 32) != 32) {
            this.f1117g = new LazyStringArrayList(this.f1117g);
            this.f1111a |= 32;
        }
    }

    /* renamed from: j */
    public List<String> m2024j() {
        return Collections.unmodifiableList(this.f1117g);
    }

    /* renamed from: d */
    public C0331ca m2018d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m2005p();
        this.f1117g.add((LazyStringList) str);
        return this;
    }

    /* renamed from: k */
    public long m2025k() {
        return this.f1118h;
    }

    /* renamed from: b */
    public C0331ca m2013b(long j) {
        this.f1111a |= 64;
        this.f1118h = j;
        return this;
    }
}
