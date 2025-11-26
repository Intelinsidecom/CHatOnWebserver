package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.aq */
/* loaded from: classes.dex */
public final class C0124aq extends GeneratedMessageLite.Builder implements InterfaceC0125ar {

    /* renamed from: a */
    private int f431a;

    /* renamed from: d */
    private long f434d;

    /* renamed from: b */
    private Object f432b = "";

    /* renamed from: c */
    private Object f433c = "";

    /* renamed from: e */
    private EnumC0159by f435e = EnumC0159by.TEXT;

    private C0124aq() {
        m924g();
    }

    /* renamed from: g */
    private void m924g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0124aq m925h() {
        return new C0124aq();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0124aq clear() {
        super.clear();
        this.f432b = "";
        this.f431a &= -2;
        this.f433c = "";
        this.f431a &= -3;
        this.f434d = 0L;
        this.f431a &= -5;
        this.f435e = EnumC0159by.TEXT;
        this.f431a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0124aq mo7542clone() {
        return m925h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0123ap getDefaultInstanceForType() {
        return C0123ap.m904a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0123ap build() {
        C0123ap c0123apBuildPartial = buildPartial();
        if (!c0123apBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0123apBuildPartial);
        }
        return c0123apBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0123ap buildPartial() {
        C0123ap c0123ap = new C0123ap(this);
        int i = this.f431a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0123ap.f425c = this.f432b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0123ap.f426d = this.f433c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0123ap.f427e = this.f434d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0123ap.f428f = this.f435e;
        c0123ap.f424b = i2;
        return c0123ap;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0124aq mergeFrom(C0123ap c0123ap) {
        if (c0123ap != C0123ap.m904a()) {
            if (c0123ap.m913c()) {
                m931a(c0123ap.m914d());
            }
            if (c0123ap.m915e()) {
                m933b(c0123ap.m916f());
            }
            if (c0123ap.m917g()) {
                m927a(c0123ap.m918h());
            }
            if (c0123ap.m919i()) {
                m930a(c0123ap.m920j());
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
    public C0124aq mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f431a |= 1;
                    this.f432b = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    this.f431a |= 2;
                    this.f433c = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_fadingEdgeLength /* 24 */:
                    this.f431a |= 4;
                    this.f434d = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_drawingCacheQuality /* 32 */:
                    EnumC0159by enumC0159byM1347a = EnumC0159by.m1347a(codedInputStream.readEnum());
                    if (enumC0159byM1347a == null) {
                        break;
                    } else {
                        this.f431a |= 8;
                        this.f435e = enumC0159byM1347a;
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
    public C0124aq m931a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f431a |= 1;
        this.f432b = str;
        return this;
    }

    /* renamed from: b */
    public C0124aq m933b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f431a |= 2;
        this.f433c = str;
        return this;
    }

    /* renamed from: a */
    public C0124aq m927a(long j) {
        this.f431a |= 4;
        this.f434d = j;
        return this;
    }

    /* renamed from: a */
    public C0124aq m930a(EnumC0159by enumC0159by) {
        if (enumC0159by == null) {
            throw new NullPointerException();
        }
        this.f431a |= 8;
        this.f435e = enumC0159by;
        return this;
    }
}
