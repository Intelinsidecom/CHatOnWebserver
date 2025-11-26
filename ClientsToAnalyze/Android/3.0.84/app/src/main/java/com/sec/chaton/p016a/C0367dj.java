package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dj */
/* loaded from: classes.dex */
public final class C0367dj extends GeneratedMessageLite.Builder<C0366di, C0367dj> implements InterfaceC0368dk {

    /* renamed from: a */
    private int f1276a;

    /* renamed from: b */
    private List<C0351cu> f1277b = Collections.emptyList();

    private C0367dj() {
        m2472g();
    }

    /* renamed from: g */
    private void m2472g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0367dj m2473h() {
        return new C0367dj();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0367dj clear() {
        super.clear();
        this.f1277b = Collections.emptyList();
        this.f1276a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0367dj mo13386clone() {
        return m2473h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0366di getDefaultInstanceForType() {
        return C0366di.m2462a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0366di build() {
        C0366di c0366diBuildPartial = buildPartial();
        if (!c0366diBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0366diBuildPartial);
        }
        return c0366diBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0366di buildPartial() {
        C0366di c0366di = new C0366di(this);
        int i = this.f1276a;
        if ((this.f1276a & 1) == 1) {
            this.f1277b = Collections.unmodifiableList(this.f1277b);
            this.f1276a &= -2;
        }
        c0366di.f1273b = this.f1277b;
        return c0366di;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0367dj mergeFrom(C0366di c0366di) {
        if (c0366di != C0366di.m2462a() && !c0366di.f1273b.isEmpty()) {
            if (this.f1277b.isEmpty()) {
                this.f1277b = c0366di.f1273b;
                this.f1276a &= -2;
            } else {
                m2474i();
                this.f1277b.addAll(c0366di.f1273b);
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
    public C0367dj mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    C0352cv c0352cvNewBuilder = C0351cu.newBuilder();
                    codedInputStream.readMessage(c0352cvNewBuilder, extensionRegistryLite);
                    m2477a(c0352cvNewBuilder.buildPartial());
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

    /* renamed from: i */
    private void m2474i() {
        if ((this.f1276a & 1) != 1) {
            this.f1277b = new ArrayList(this.f1277b);
            this.f1276a |= 1;
        }
    }

    /* renamed from: a */
    public C0367dj m2477a(C0351cu c0351cu) {
        if (c0351cu == null) {
            throw new NullPointerException();
        }
        m2474i();
        this.f1277b.add(c0351cu);
        return this;
    }
}
