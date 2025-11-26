package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.m */
/* loaded from: classes.dex */
public final class C0186m extends GeneratedMessageLite.Builder implements InterfaceC0187n {

    /* renamed from: a */
    private int f684a;

    /* renamed from: b */
    private long f685b;

    /* renamed from: c */
    private C0171cj f686c = C0171cj.m1459a();

    private C0186m() {
        m1651j();
    }

    /* renamed from: j */
    private void m1651j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static C0186m m1652k() {
        return new C0186m();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0186m clear() {
        super.clear();
        this.f685b = 0L;
        this.f684a &= -2;
        this.f686c = C0171cj.m1459a();
        this.f684a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0186m mo7542clone() {
        return m1652k().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0185l getDefaultInstanceForType() {
        return C0185l.m1638a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0185l build() {
        C0185l c0185lBuildPartial = buildPartial();
        if (!c0185lBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0185lBuildPartial);
        }
        return c0185lBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public C0185l m1653l() throws InvalidProtocolBufferException {
        C0185l c0185lBuildPartial = buildPartial();
        if (!c0185lBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0185lBuildPartial).asInvalidProtocolBufferException();
        }
        return c0185lBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0185l buildPartial() {
        C0185l c0185l = new C0185l(this);
        int i = this.f684a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0185l.f680c = this.f685b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0185l.f681d = this.f686c;
        c0185l.f679b = i2;
        return c0185l;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0186m mergeFrom(C0185l c0185l) {
        if (c0185l != C0185l.m1638a()) {
            if (c0185l.m1643c()) {
                m1655a(c0185l.m1644d());
            }
            if (c0185l.m1645e()) {
                m1661b(c0185l.m1646f());
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
    public C0186m mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f684a |= 1;
                    this.f685b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    C0172ck c0172ckNewBuilder = C0171cj.newBuilder();
                    if (m1666g()) {
                        c0172ckNewBuilder.mergeFrom(m1667h());
                    }
                    codedInputStream.readMessage(c0172ckNewBuilder, extensionRegistryLite);
                    m1657a(c0172ckNewBuilder.buildPartial());
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
    public long m1665f() {
        return this.f685b;
    }

    /* renamed from: a */
    public C0186m m1655a(long j) {
        this.f684a |= 1;
        this.f685b = j;
        return this;
    }

    /* renamed from: g */
    public boolean m1666g() {
        return (this.f684a & 2) == 2;
    }

    /* renamed from: h */
    public C0171cj m1667h() {
        return this.f686c;
    }

    /* renamed from: a */
    public C0186m m1657a(C0171cj c0171cj) {
        if (c0171cj == null) {
            throw new NullPointerException();
        }
        this.f686c = c0171cj;
        this.f684a |= 2;
        return this;
    }

    /* renamed from: a */
    public C0186m m1658a(C0172ck c0172ck) {
        this.f686c = c0172ck.build();
        this.f684a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0186m m1661b(C0171cj c0171cj) {
        if ((this.f684a & 2) == 2 && this.f686c != C0171cj.m1459a()) {
            this.f686c = C0171cj.m1460a(this.f686c).mergeFrom(c0171cj).buildPartial();
        } else {
            this.f686c = c0171cj;
        }
        this.f684a |= 2;
        return this;
    }
}
