package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ae */
/* loaded from: classes.dex */
public final class C0281ae extends GeneratedMessageLite.Builder<C0280ad, C0281ae> implements InterfaceC0282af {

    /* renamed from: a */
    private int f892a;

    /* renamed from: b */
    private EnumC0302az f893b = EnumC0302az.SINGLE;

    /* renamed from: c */
    private Object f894c = "";

    /* renamed from: d */
    private LazyStringList f895d = LazyStringArrayList.EMPTY;

    /* renamed from: e */
    private long f896e;

    private C0281ae() {
        m1435g();
    }

    /* renamed from: g */
    private void m1435g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0281ae m1436h() {
        return new C0281ae();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0281ae clear() {
        super.clear();
        this.f893b = EnumC0302az.SINGLE;
        this.f892a &= -2;
        this.f894c = "";
        this.f892a &= -3;
        this.f895d = LazyStringArrayList.EMPTY;
        this.f892a &= -5;
        this.f896e = 0L;
        this.f892a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0281ae mo13386clone() {
        return m1436h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0280ad getDefaultInstanceForType() {
        return C0280ad.m1417a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0280ad build() {
        C0280ad c0280adBuildPartial = buildPartial();
        if (!c0280adBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0280adBuildPartial);
        }
        return c0280adBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0280ad buildPartial() {
        C0280ad c0280ad = new C0280ad(this);
        int i = this.f892a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0280ad.f886c = this.f893b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0280ad.f887d = this.f894c;
        if ((this.f892a & 4) == 4) {
            this.f895d = new UnmodifiableLazyStringList(this.f895d);
            this.f892a &= -5;
        }
        c0280ad.f888e = this.f895d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0280ad.f889f = this.f896e;
        c0280ad.f885b = i2;
        return c0280ad;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0281ae mergeFrom(C0280ad c0280ad) {
        if (c0280ad != C0280ad.m1417a()) {
            if (c0280ad.m1425c()) {
                m1442a(c0280ad.m1426d());
            }
            if (c0280ad.m1427e()) {
                m1444a(c0280ad.m1428f());
            }
            if (!c0280ad.f888e.isEmpty()) {
                if (this.f895d.isEmpty()) {
                    this.f895d = c0280ad.f888e;
                    this.f892a &= -5;
                } else {
                    m1437i();
                    this.f895d.addAll(c0280ad.f888e);
                }
            }
            if (c0280ad.m1430h()) {
                m1439a(c0280ad.m1431i());
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
    public C0281ae mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    EnumC0302az enumC0302azM1704a = EnumC0302az.m1704a(codedInputStream.readEnum());
                    if (enumC0302azM1704a == null) {
                        break;
                    } else {
                        this.f892a |= 1;
                        this.f893b = enumC0302azM1704a;
                        break;
                    }
                case 18:
                    this.f892a |= 2;
                    this.f894c = codedInputStream.readBytes();
                    break;
                case 26:
                    m1437i();
                    this.f895d.add(codedInputStream.readBytes());
                    break;
                case 32:
                    this.f892a |= 8;
                    this.f896e = codedInputStream.readInt64();
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
    public C0281ae m1442a(EnumC0302az enumC0302az) {
        if (enumC0302az == null) {
            throw new NullPointerException();
        }
        this.f892a |= 1;
        this.f893b = enumC0302az;
        return this;
    }

    /* renamed from: a */
    public C0281ae m1444a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f892a |= 2;
        this.f894c = str;
        return this;
    }

    /* renamed from: i */
    private void m1437i() {
        if ((this.f892a & 4) != 4) {
            this.f895d = new LazyStringArrayList(this.f895d);
            this.f892a |= 4;
        }
    }

    /* renamed from: a */
    public C0281ae m1443a(Iterable<String> iterable) {
        m1437i();
        GeneratedMessageLite.Builder.addAll(iterable, this.f895d);
        return this;
    }

    /* renamed from: a */
    public C0281ae m1439a(long j) {
        this.f892a |= 8;
        this.f896e = j;
        return this;
    }
}
