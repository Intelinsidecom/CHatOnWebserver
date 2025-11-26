package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.da */
/* loaded from: classes.dex */
public final class C0358da extends GeneratedMessageLite.Builder<C0356cz, C0358da> implements InterfaceC0359db {

    /* renamed from: a */
    private int f1249a;

    /* renamed from: b */
    private Object f1250b = "";

    /* renamed from: c */
    private Object f1251c = "";

    private C0358da() {
        m2388g();
    }

    /* renamed from: g */
    private void m2388g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0358da m2389h() {
        return new C0358da();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0358da clear() {
        super.clear();
        this.f1250b = "";
        this.f1249a &= -2;
        this.f1251c = "";
        this.f1249a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0358da mo13386clone() {
        return m2389h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0356cz getDefaultInstanceForType() {
        return C0356cz.m2355a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0356cz build() {
        C0356cz c0356czBuildPartial = buildPartial();
        if (!c0356czBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0356czBuildPartial);
        }
        return c0356czBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0356cz buildPartial() {
        C0356cz c0356cz = new C0356cz(this);
        int i = this.f1249a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0356cz.f1242c = this.f1250b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0356cz.f1243d = this.f1251c;
        c0356cz.f1241b = i2;
        return c0356cz;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0358da mergeFrom(C0356cz c0356cz) {
        if (c0356cz != C0356cz.m2355a()) {
            if (c0356cz.m2363c()) {
                m2393a(c0356cz.m2364d());
            }
            if (c0356cz.m2365e()) {
                m2395b(c0356cz.m2366f());
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
    public C0358da mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f1249a |= 1;
                    this.f1250b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f1249a |= 2;
                    this.f1251c = codedInputStream.readBytes();
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
    public C0358da m2393a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1249a |= 1;
        this.f1250b = str;
        return this;
    }

    /* renamed from: b */
    public C0358da m2395b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1249a |= 2;
        this.f1251c = str;
        return this;
    }
}
