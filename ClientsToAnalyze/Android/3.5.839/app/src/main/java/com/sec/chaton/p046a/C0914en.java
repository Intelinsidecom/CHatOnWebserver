package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.en */
/* loaded from: classes.dex */
public final class C0914en extends GeneratedMessageLite.Builder<C0913em, C0914en> implements InterfaceC0915eo {

    /* renamed from: a */
    private int f2861a;

    /* renamed from: b */
    private long f2862b;

    /* renamed from: c */
    private List<C0910ej> f2863c = Collections.emptyList();

    /* renamed from: d */
    private C0935fh f2864d = C0935fh.m5211a();

    private C0914en() {
        m4934i();
    }

    /* renamed from: i */
    private void m4934i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0914en m4935j() {
        return new C0914en();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0914en clear() {
        super.clear();
        this.f2862b = 0L;
        this.f2861a &= -2;
        this.f2863c = Collections.emptyList();
        this.f2861a &= -3;
        this.f2864d = C0935fh.m5211a();
        this.f2861a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0914en mo19949clone() {
        return m4935j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0913em getDefaultInstanceForType() {
        return C0913em.m4918a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0913em build() {
        C0913em c0913emBuildPartial = buildPartial();
        if (!c0913emBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0913emBuildPartial);
        }
        return c0913emBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0913em m4936k() throws InvalidProtocolBufferException {
        C0913em c0913emBuildPartial = buildPartial();
        if (!c0913emBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0913emBuildPartial).asInvalidProtocolBufferException();
        }
        return c0913emBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0913em buildPartial() {
        C0913em c0913em = new C0913em(this);
        int i = this.f2861a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0913em.f2856c = this.f2862b;
        if ((this.f2861a & 2) == 2) {
            this.f2863c = Collections.unmodifiableList(this.f2863c);
            this.f2861a &= -3;
        }
        c0913em.f2857d = this.f2863c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0913em.f2858e = this.f2864d;
        c0913em.f2855b = i2;
        return c0913em;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0914en mergeFrom(C0913em c0913em) {
        if (c0913em != C0913em.m4918a()) {
            if (c0913em.m4926c()) {
                m4939a(c0913em.m4927d());
            }
            if (!c0913em.f2857d.isEmpty()) {
                if (this.f2863c.isEmpty()) {
                    this.f2863c = c0913em.f2857d;
                    this.f2861a &= -3;
                } else {
                    m4937l();
                    this.f2863c.addAll(c0913em.f2857d);
                }
            }
            if (c0913em.m4928e()) {
                m4945b(c0913em.m4929f());
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
    public C0914en mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2861a |= 1;
                    this.f2862b = codedInputStream.readInt64();
                    break;
                case 18:
                    MessageLite.Builder builderNewBuilder = C0910ej.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m4941a(builderNewBuilder.buildPartial());
                    break;
                case 26:
                    C0936fi c0936fiNewBuilder = C0935fh.newBuilder();
                    if (m4949f()) {
                        c0936fiNewBuilder.mergeFrom(m4950g());
                    }
                    codedInputStream.readMessage(c0936fiNewBuilder, extensionRegistryLite);
                    m4943a(c0936fiNewBuilder.buildPartial());
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
    public C0914en m4939a(long j) {
        this.f2861a |= 1;
        this.f2862b = j;
        return this;
    }

    /* renamed from: l */
    private void m4937l() {
        if ((this.f2861a & 2) != 2) {
            this.f2863c = new ArrayList(this.f2863c);
            this.f2861a |= 2;
        }
    }

    /* renamed from: a */
    public C0914en m4941a(C0910ej c0910ej) {
        if (c0910ej == null) {
            throw new NullPointerException();
        }
        m4937l();
        this.f2863c.add(c0910ej);
        return this;
    }

    /* renamed from: f */
    public boolean m4949f() {
        return (this.f2861a & 4) == 4;
    }

    /* renamed from: g */
    public C0935fh m4950g() {
        return this.f2864d;
    }

    /* renamed from: a */
    public C0914en m4943a(C0935fh c0935fh) {
        if (c0935fh == null) {
            throw new NullPointerException();
        }
        this.f2864d = c0935fh;
        this.f2861a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0914en m4945b(C0935fh c0935fh) {
        if ((this.f2861a & 4) == 4 && this.f2864d != C0935fh.m5211a()) {
            this.f2864d = C0935fh.m5212a(this.f2864d).mergeFrom(c0935fh).buildPartial();
        } else {
            this.f2864d = c0935fh;
        }
        this.f2861a |= 4;
        return this;
    }
}
