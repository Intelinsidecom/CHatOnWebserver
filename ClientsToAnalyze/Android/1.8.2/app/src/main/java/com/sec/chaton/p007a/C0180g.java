package com.sec.chaton.p007a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.g */
/* loaded from: classes.dex */
public final class C0180g extends GeneratedMessageLite.Builder implements InterfaceC0181h {

    /* renamed from: a */
    private int f653a;

    /* renamed from: b */
    private long f654b;

    /* renamed from: c */
    private EnumC0116ai f655c = EnumC0116ai.SINGLE;

    /* renamed from: d */
    private Object f656d = "";

    /* renamed from: e */
    private Object f657e = "";

    /* renamed from: f */
    private Object f658f = "";

    /* renamed from: g */
    private Object f659g = "";

    /* renamed from: h */
    private Object f660h = "";

    private C0180g() {
        m1563l();
    }

    /* renamed from: l */
    private void m1563l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static C0180g m1564m() {
        return new C0180g();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0180g clear() {
        super.clear();
        this.f654b = 0L;
        this.f653a &= -2;
        this.f655c = EnumC0116ai.SINGLE;
        this.f653a &= -3;
        this.f656d = "";
        this.f653a &= -5;
        this.f657e = "";
        this.f653a &= -9;
        this.f658f = "";
        this.f653a &= -17;
        this.f659g = "";
        this.f653a &= -33;
        this.f660h = "";
        this.f653a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0180g mo7542clone() {
        return m1564m().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0179f getDefaultInstanceForType() {
        return C0179f.m1530a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0179f build() {
        C0179f c0179fBuildPartial = buildPartial();
        if (!c0179fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0179fBuildPartial);
        }
        return c0179fBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public C0179f m1565n() throws InvalidProtocolBufferException {
        C0179f c0179fBuildPartial = buildPartial();
        if (!c0179fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0179fBuildPartial).asInvalidProtocolBufferException();
        }
        return c0179fBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0179f buildPartial() {
        C0179f c0179f = new C0179f(this);
        int i = this.f653a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0179f.f644c = this.f654b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0179f.f645d = this.f655c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0179f.f646e = this.f656d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0179f.f647f = this.f657e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0179f.f648g = this.f658f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0179f.f649h = this.f659g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0179f.f650i = this.f660h;
        c0179f.f643b = i2;
        return c0179f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0180g mergeFrom(C0179f c0179f) {
        if (c0179f != C0179f.m1530a()) {
            if (c0179f.m1545c()) {
                m1567a(c0179f.m1546d());
            }
            if (c0179f.m1547e()) {
                m1569a(c0179f.m1548f());
            }
            if (c0179f.m1549g()) {
                m1571a(c0179f.m1550h());
            }
            if (c0179f.m1551i()) {
                m1573b(c0179f.m1552j());
            }
            if (c0179f.m1553k()) {
                m1575c(c0179f.m1554l());
            }
            if (c0179f.m1555m()) {
                m1577d(c0179f.m1556n());
            }
            if (c0179f.m1557o()) {
                m1579e(c0179f.m1558p());
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
    public C0180g mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f653a |= 1;
                    this.f654b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    EnumC0116ai enumC0116aiM813a = EnumC0116ai.m813a(codedInputStream.readEnum());
                    if (enumC0116aiM813a == null) {
                        break;
                    } else {
                        this.f653a |= 2;
                        this.f655c = enumC0116aiM813a;
                        break;
                    }
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    this.f653a |= 4;
                    this.f656d = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    this.f653a |= 8;
                    this.f657e = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_scrollbarFadeDuration /* 42 */:
                    this.f653a |= 16;
                    this.f658f = codedInputStream.readBytes();
                    break;
                case 50:
                    this.f653a |= 32;
                    this.f659g = codedInputStream.readBytes();
                    break;
                case 58:
                    this.f653a |= 64;
                    this.f660h = codedInputStream.readBytes();
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
    public long m1580f() {
        return this.f654b;
    }

    /* renamed from: a */
    public C0180g m1567a(long j) {
        this.f653a |= 1;
        this.f654b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0116ai m1581g() {
        return this.f655c;
    }

    /* renamed from: a */
    public C0180g m1569a(EnumC0116ai enumC0116ai) {
        if (enumC0116ai == null) {
            throw new NullPointerException();
        }
        this.f653a |= 2;
        this.f655c = enumC0116ai;
        return this;
    }

    /* renamed from: h */
    public String m1582h() {
        Object obj = this.f656d;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f656d = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: a */
    public C0180g m1571a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f653a |= 4;
        this.f656d = str;
        return this;
    }

    /* renamed from: i */
    public String m1583i() {
        Object obj = this.f657e;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f657e = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: b */
    public C0180g m1573b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f653a |= 8;
        this.f657e = str;
        return this;
    }

    /* renamed from: j */
    public String m1584j() {
        Object obj = this.f658f;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f658f = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: c */
    public C0180g m1575c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f653a |= 16;
        this.f658f = str;
        return this;
    }

    /* renamed from: d */
    public C0180g m1577d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f653a |= 32;
        this.f659g = str;
        return this;
    }

    /* renamed from: e */
    public C0180g m1579e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f653a |= 64;
        this.f660h = str;
        return this;
    }
}
