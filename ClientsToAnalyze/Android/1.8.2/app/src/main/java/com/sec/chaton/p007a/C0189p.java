package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.p */
/* loaded from: classes.dex */
public final class C0189p extends GeneratedMessageLite.Builder implements InterfaceC0190q {

    /* renamed from: a */
    private int f691a;

    /* renamed from: b */
    private List f692b = Collections.emptyList();

    private C0189p() {
        m1682g();
    }

    /* renamed from: g */
    private void m1682g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0189p m1683h() {
        return new C0189p();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0189p clear() {
        super.clear();
        this.f692b = Collections.emptyList();
        this.f691a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0189p mo7542clone() {
        return m1683h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0188o getDefaultInstanceForType() {
        return C0188o.m1668a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0188o build() {
        C0188o c0188oBuildPartial = buildPartial();
        if (!c0188oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0188oBuildPartial);
        }
        return c0188oBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0188o m1684i() throws InvalidProtocolBufferException {
        C0188o c0188oBuildPartial = buildPartial();
        if (!c0188oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0188oBuildPartial).asInvalidProtocolBufferException();
        }
        return c0188oBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0188o buildPartial() {
        C0188o c0188o = new C0188o(this);
        int i = this.f691a;
        if ((this.f691a & 1) == 1) {
            this.f692b = Collections.unmodifiableList(this.f692b);
            this.f691a &= -2;
        }
        c0188o.f688b = this.f692b;
        return c0188o;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0189p mergeFrom(C0188o c0188o) {
        if (c0188o != C0188o.m1668a() && !c0188o.f688b.isEmpty()) {
            if (this.f692b.isEmpty()) {
                this.f692b = c0188o.f688b;
                this.f691a &= -2;
            } else {
                m1685j();
                this.f692b.addAll(c0188o.f688b);
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
    public C0189p mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    C0195v c0195vNewBuilder = C0194u.newBuilder();
                    codedInputStream.readMessage(c0195vNewBuilder, extensionRegistryLite);
                    m1689a(c0195vNewBuilder.buildPartial());
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
    private void m1685j() {
        if ((this.f691a & 1) != 1) {
            this.f692b = new ArrayList(this.f692b);
            this.f691a |= 1;
        }
    }

    /* renamed from: a */
    public C0189p m1689a(C0194u c0194u) {
        if (c0194u == null) {
            throw new NullPointerException();
        }
        m1685j();
        this.f692b.add(c0194u);
        return this;
    }
}
