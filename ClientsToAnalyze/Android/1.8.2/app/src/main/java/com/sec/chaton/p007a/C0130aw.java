package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.aw */
/* loaded from: classes.dex */
public final class C0130aw extends GeneratedMessageLite.Builder implements InterfaceC0131ax {

    /* renamed from: a */
    private int f448a;

    /* renamed from: b */
    private long f449b;

    /* renamed from: c */
    private EnumC0127at f450c = EnumC0127at.CLOSE;

    /* renamed from: d */
    private C0171cj f451d = C0171cj.m1459a();

    private C0130aw() {
        m958k();
    }

    /* renamed from: k */
    private void m958k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0130aw m959l() {
        return new C0130aw();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0130aw clear() {
        super.clear();
        this.f449b = 0L;
        this.f448a &= -2;
        this.f450c = EnumC0127at.CLOSE;
        this.f448a &= -3;
        this.f451d = C0171cj.m1459a();
        this.f448a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0130aw mo7542clone() {
        return m959l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0129av getDefaultInstanceForType() {
        return C0129av.m942a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0129av build() {
        C0129av c0129avBuildPartial = buildPartial();
        if (!c0129avBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0129avBuildPartial);
        }
        return c0129avBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0129av m960m() throws InvalidProtocolBufferException {
        C0129av c0129avBuildPartial = buildPartial();
        if (!c0129avBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0129avBuildPartial).asInvalidProtocolBufferException();
        }
        return c0129avBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0129av buildPartial() {
        C0129av c0129av = new C0129av(this);
        int i = this.f448a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0129av.f443c = this.f449b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0129av.f444d = this.f450c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0129av.f445e = this.f451d;
        c0129av.f442b = i2;
        return c0129av;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0130aw mergeFrom(C0129av c0129av) {
        if (c0129av != C0129av.m942a()) {
            if (c0129av.m948c()) {
                m962a(c0129av.m949d());
            }
            if (c0129av.m950e()) {
                m964a(c0129av.m951f());
            }
            if (c0129av.m952g()) {
                m968b(c0129av.m953h());
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
    public C0130aw mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f448a |= 1;
                    this.f449b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_paddingRight /* 16 */:
                    EnumC0127at enumC0127atM937a = EnumC0127at.m937a(codedInputStream.readEnum());
                    if (enumC0127atM937a == null) {
                        break;
                    } else {
                        this.f448a |= 2;
                        this.f450c = enumC0127atM937a;
                        break;
                    }
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    C0172ck c0172ckNewBuilder = C0171cj.newBuilder();
                    if (m974h()) {
                        c0172ckNewBuilder.mergeFrom(m975i());
                    }
                    codedInputStream.readMessage(c0172ckNewBuilder, extensionRegistryLite);
                    m966a(c0172ckNewBuilder.buildPartial());
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
    public long m972f() {
        return this.f449b;
    }

    /* renamed from: a */
    public C0130aw m962a(long j) {
        this.f448a |= 1;
        this.f449b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0127at m973g() {
        return this.f450c;
    }

    /* renamed from: a */
    public C0130aw m964a(EnumC0127at enumC0127at) {
        if (enumC0127at == null) {
            throw new NullPointerException();
        }
        this.f448a |= 2;
        this.f450c = enumC0127at;
        return this;
    }

    /* renamed from: h */
    public boolean m974h() {
        return (this.f448a & 4) == 4;
    }

    /* renamed from: i */
    public C0171cj m975i() {
        return this.f451d;
    }

    /* renamed from: a */
    public C0130aw m966a(C0171cj c0171cj) {
        if (c0171cj == null) {
            throw new NullPointerException();
        }
        this.f451d = c0171cj;
        this.f448a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0130aw m968b(C0171cj c0171cj) {
        if ((this.f448a & 4) == 4 && this.f451d != C0171cj.m1459a()) {
            this.f451d = C0171cj.m1460a(this.f451d).mergeFrom(c0171cj).buildPartial();
        } else {
            this.f451d = c0171cj;
        }
        this.f448a |= 4;
        return this;
    }
}
