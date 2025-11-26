package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bk */
/* loaded from: classes.dex */
public final class C0145bk extends GeneratedMessageLite.Builder implements InterfaceC0146bl {

    /* renamed from: a */
    private int f505a;

    /* renamed from: d */
    private long f508d;

    /* renamed from: f */
    private long f510f;

    /* renamed from: b */
    private Object f506b = "";

    /* renamed from: c */
    private LazyStringList f507c = LazyStringArrayList.EMPTY;

    /* renamed from: e */
    private Object f509e = "";

    /* renamed from: g */
    private EnumC0159by f511g = EnumC0159by.TEXT;

    /* renamed from: h */
    private EnumC0116ai f512h = EnumC0116ai.SINGLE;

    private C0145bk() {
        m1128g();
    }

    /* renamed from: g */
    private void m1128g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0145bk m1129h() {
        return new C0145bk();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0145bk clear() {
        super.clear();
        this.f506b = "";
        this.f505a &= -2;
        this.f507c = LazyStringArrayList.EMPTY;
        this.f505a &= -3;
        this.f508d = 0L;
        this.f505a &= -5;
        this.f509e = "";
        this.f505a &= -9;
        this.f510f = 0L;
        this.f505a &= -17;
        this.f511g = EnumC0159by.TEXT;
        this.f505a &= -33;
        this.f512h = EnumC0116ai.SINGLE;
        this.f505a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0145bk mo7542clone() {
        return m1129h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0144bj getDefaultInstanceForType() {
        return C0144bj.m1099a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0144bj build() {
        C0144bj c0144bjBuildPartial = buildPartial();
        if (!c0144bjBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0144bjBuildPartial);
        }
        return c0144bjBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0144bj buildPartial() {
        C0144bj c0144bj = new C0144bj(this);
        int i = this.f505a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0144bj.f496c = this.f506b;
        if ((this.f505a & 2) == 2) {
            this.f507c = new UnmodifiableLazyStringList(this.f507c);
            this.f505a &= -3;
        }
        c0144bj.f497d = this.f507c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0144bj.f498e = this.f508d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0144bj.f499f = this.f509e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0144bj.f500g = this.f510f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0144bj.f501h = this.f511g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0144bj.f502i = this.f512h;
        c0144bj.f495b = i2;
        return c0144bj;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0145bk mergeFrom(C0144bj c0144bj) {
        if (c0144bj != C0144bj.m1099a()) {
            if (c0144bj.m1111c()) {
                m1137a(c0144bj.m1112d());
            }
            if (!c0144bj.f497d.isEmpty()) {
                if (this.f507c.isEmpty()) {
                    this.f507c = c0144bj.f497d;
                    this.f505a &= -3;
                } else {
                    m1130i();
                    this.f507c.addAll(c0144bj.f497d);
                }
            }
            if (c0144bj.m1115g()) {
                m1132a(c0144bj.m1116h());
            }
            if (c0144bj.m1117i()) {
                m1140b(c0144bj.m1118j());
            }
            if (c0144bj.m1119k()) {
                m1139b(c0144bj.m1120l());
            }
            if (c0144bj.m1121m()) {
                m1136a(c0144bj.m1122n());
            }
            if (c0144bj.m1123o()) {
                m1134a(c0144bj.m1124p());
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
    public C0145bk mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f505a |= 1;
                    this.f506b = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    m1130i();
                    this.f507c.add(codedInputStream.readBytes());
                    break;
                case C0229at.HorizontalSrollView_android_fadingEdgeLength /* 24 */:
                    this.f505a |= 4;
                    this.f508d = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    this.f505a |= 8;
                    this.f509e = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_onClick /* 40 */:
                    this.f505a |= 16;
                    this.f510f = codedInputStream.readInt64();
                    break;
                case 48:
                    EnumC0159by enumC0159byM1347a = EnumC0159by.m1347a(codedInputStream.readEnum());
                    if (enumC0159byM1347a == null) {
                        break;
                    } else {
                        this.f505a |= 32;
                        this.f511g = enumC0159byM1347a;
                        break;
                    }
                case 56:
                    EnumC0116ai enumC0116aiM813a = EnumC0116ai.m813a(codedInputStream.readEnum());
                    if (enumC0116aiM813a == null) {
                        break;
                    } else {
                        this.f505a |= 64;
                        this.f512h = enumC0116aiM813a;
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
    public C0145bk m1137a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f505a |= 1;
        this.f506b = str;
        return this;
    }

    /* renamed from: i */
    private void m1130i() {
        if ((this.f505a & 2) != 2) {
            this.f507c = new LazyStringArrayList(this.f507c);
            this.f505a |= 2;
        }
    }

    /* renamed from: a */
    public C0145bk m1132a(long j) {
        this.f505a |= 4;
        this.f508d = j;
        return this;
    }

    /* renamed from: b */
    public C0145bk m1140b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f505a |= 8;
        this.f509e = str;
        return this;
    }

    /* renamed from: b */
    public C0145bk m1139b(long j) {
        this.f505a |= 16;
        this.f510f = j;
        return this;
    }

    /* renamed from: a */
    public C0145bk m1136a(EnumC0159by enumC0159by) {
        if (enumC0159by == null) {
            throw new NullPointerException();
        }
        this.f505a |= 32;
        this.f511g = enumC0159by;
        return this;
    }

    /* renamed from: a */
    public C0145bk m1134a(EnumC0116ai enumC0116ai) {
        if (enumC0116ai == null) {
            throw new NullPointerException();
        }
        this.f505a |= 64;
        this.f512h = enumC0116ai;
        return this;
    }
}
