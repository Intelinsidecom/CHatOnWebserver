package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.v */
/* loaded from: classes.dex */
public final class C0093v extends GeneratedMessageLite.Builder implements InterfaceC0094w {

    /* renamed from: a */
    private int f189a;

    /* renamed from: b */
    private List f190b = Collections.emptyList();

    private C0093v() {
        m534g();
    }

    /* renamed from: g */
    private void m534g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0093v m535h() {
        return new C0093v();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0093v clear() {
        super.clear();
        this.f190b = Collections.emptyList();
        this.f189a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0093v mo7542clone() {
        return m535h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0092u getDefaultInstanceForType() {
        return C0092u.m521a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0092u build() {
        C0092u c0092uBuildPartial = buildPartial();
        if (!c0092uBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0092uBuildPartial);
        }
        return c0092uBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0092u m536i() throws InvalidProtocolBufferException {
        C0092u c0092uBuildPartial = buildPartial();
        if (!c0092uBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0092uBuildPartial).asInvalidProtocolBufferException();
        }
        return c0092uBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0092u buildPartial() {
        C0092u c0092u = new C0092u(this);
        int i = this.f189a;
        if ((this.f189a & 1) == 1) {
            this.f190b = Collections.unmodifiableList(this.f190b);
            this.f189a &= -2;
        }
        c0092u.f186b = this.f190b;
        return c0092u;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0093v mergeFrom(C0092u c0092u) {
        if (c0092u != C0092u.m521a() && !c0092u.f186b.isEmpty()) {
            if (this.f190b.isEmpty()) {
                this.f190b = c0092u.f186b;
                this.f189a &= -2;
            } else {
                m537j();
                this.f190b.addAll(c0092u.f186b);
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
    public C0093v mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    C0090s c0090sNewBuilder = C0089r.newBuilder();
                    codedInputStream.readMessage(c0090sNewBuilder, extensionRegistryLite);
                    m540a(c0090sNewBuilder.buildPartial());
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

    /* renamed from: j */
    private void m537j() {
        if ((this.f189a & 1) != 1) {
            this.f190b = new ArrayList(this.f190b);
            this.f189a |= 1;
        }
    }

    /* renamed from: a */
    public C0093v m540a(C0089r c0089r) {
        if (c0089r == null) {
            throw new NullPointerException();
        }
        m537j();
        this.f190b.add(c0089r);
        return this;
    }
}
