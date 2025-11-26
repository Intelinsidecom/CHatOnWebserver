package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.sec.chaton.C0229at;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ao */
/* loaded from: classes.dex */
public final class C0122ao extends GeneratedMessageLite.Builder implements InterfaceC0126as {

    /* renamed from: a */
    private int f419a;

    /* renamed from: b */
    private Object f420b = "";

    /* renamed from: c */
    private List f421c = Collections.emptyList();

    /* renamed from: d */
    private C0171cj f422d = C0171cj.m1459a();

    private C0122ao() {
        m882k();
    }

    /* renamed from: k */
    private void m882k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0122ao m883l() {
        return new C0122ao();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0122ao clear() {
        super.clear();
        this.f420b = "";
        this.f419a &= -2;
        this.f421c = Collections.emptyList();
        this.f419a &= -3;
        this.f422d = C0171cj.m1459a();
        this.f419a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0122ao mo7542clone() {
        return m883l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0121an getDefaultInstanceForType() {
        return C0121an.m861a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0121an build() {
        C0121an c0121anBuildPartial = buildPartial();
        if (!c0121anBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0121anBuildPartial);
        }
        return c0121anBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0121an m884m() throws InvalidProtocolBufferException {
        C0121an c0121anBuildPartial = buildPartial();
        if (!c0121anBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0121anBuildPartial).asInvalidProtocolBufferException();
        }
        return c0121anBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0121an buildPartial() {
        C0121an c0121an = new C0121an(this);
        int i = this.f419a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0121an.f414c = this.f420b;
        if ((this.f419a & 2) == 2) {
            this.f421c = Collections.unmodifiableList(this.f421c);
            this.f419a &= -3;
        }
        c0121an.f415d = this.f421c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0121an.f416e = this.f422d;
        c0121an.f413b = i2;
        return c0121an;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0122ao mergeFrom(C0121an c0121an) {
        if (c0121an != C0121an.m861a()) {
            if (c0121an.m872c()) {
                m891a(c0121an.m873d());
            }
            if (!c0121an.f415d.isEmpty()) {
                if (this.f421c.isEmpty()) {
                    this.f421c = c0121an.f415d;
                    this.f419a &= -3;
                } else {
                    m885n();
                    this.f421c.addAll(c0121an.f415d);
                }
            }
            if (c0121an.m876g()) {
                m894b(c0121an.m877h());
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
    public C0122ao mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f419a |= 1;
                    this.f420b = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    MessageLite.Builder builderNewBuilder = C0123ap.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m889a(builderNewBuilder.buildPartial());
                    break;
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    C0172ck c0172ckNewBuilder = C0171cj.newBuilder();
                    if (m900h()) {
                        c0172ckNewBuilder.mergeFrom(m901i());
                    }
                    codedInputStream.readMessage(c0172ckNewBuilder, extensionRegistryLite);
                    m890a(c0172ckNewBuilder.buildPartial());
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
    public C0122ao m891a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f419a |= 1;
        this.f420b = str;
        return this;
    }

    /* renamed from: n */
    private void m885n() {
        if ((this.f419a & 2) != 2) {
            this.f421c = new ArrayList(this.f421c);
            this.f419a |= 2;
        }
    }

    /* renamed from: f */
    public List m898f() {
        return Collections.unmodifiableList(this.f421c);
    }

    /* renamed from: g */
    public int m899g() {
        return this.f421c.size();
    }

    /* renamed from: a */
    public C0123ap m892a(int i) {
        return (C0123ap) this.f421c.get(i);
    }

    /* renamed from: a */
    public C0122ao m889a(C0123ap c0123ap) {
        if (c0123ap == null) {
            throw new NullPointerException();
        }
        m885n();
        this.f421c.add(c0123ap);
        return this;
    }

    /* renamed from: h */
    public boolean m900h() {
        return (this.f419a & 4) == 4;
    }

    /* renamed from: i */
    public C0171cj m901i() {
        return this.f422d;
    }

    /* renamed from: a */
    public C0122ao m890a(C0171cj c0171cj) {
        if (c0171cj == null) {
            throw new NullPointerException();
        }
        this.f422d = c0171cj;
        this.f419a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0122ao m894b(C0171cj c0171cj) {
        if ((this.f419a & 4) == 4 && this.f422d != C0171cj.m1459a()) {
            this.f422d = C0171cj.m1460a(this.f422d).mergeFrom(c0171cj).buildPartial();
        } else {
            this.f422d = c0171cj;
        }
        this.f419a |= 4;
        return this;
    }
}
