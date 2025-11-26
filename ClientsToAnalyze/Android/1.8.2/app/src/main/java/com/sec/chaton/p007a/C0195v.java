package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.v */
/* loaded from: classes.dex */
public final class C0195v extends GeneratedMessageLite.Builder implements InterfaceC0196w {

    /* renamed from: a */
    private int f710a;

    /* renamed from: b */
    private Object f711b = "";

    /* renamed from: c */
    private long f712c;

    private C0195v() {
        m1748g();
    }

    /* renamed from: g */
    private void m1748g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0195v m1749h() {
        return new C0195v();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0195v clear() {
        super.clear();
        this.f711b = "";
        this.f710a &= -2;
        this.f712c = 0L;
        this.f710a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0195v mo7542clone() {
        return m1749h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0194u getDefaultInstanceForType() {
        return C0194u.m1735a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0194u build() {
        C0194u c0194uBuildPartial = buildPartial();
        if (!c0194uBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0194uBuildPartial);
        }
        return c0194uBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0194u buildPartial() {
        C0194u c0194u = new C0194u(this);
        int i = this.f710a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0194u.f706c = this.f711b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0194u.f707d = this.f712c;
        c0194u.f705b = i2;
        return c0194u;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0195v mergeFrom(C0194u c0194u) {
        if (c0194u != C0194u.m1735a()) {
            if (c0194u.m1741c()) {
                m1754a(c0194u.m1742d());
            }
            if (c0194u.m1743e()) {
                m1751a(c0194u.m1744f());
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
    public C0195v mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f710a |= 1;
                    this.f711b = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    this.f710a |= 2;
                    this.f712c = codedInputStream.readInt64();
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
    public C0195v m1754a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f710a |= 1;
        this.f711b = str;
        return this;
    }

    /* renamed from: a */
    public C0195v m1751a(long j) {
        this.f710a |= 2;
        this.f712c = j;
        return this;
    }
}
