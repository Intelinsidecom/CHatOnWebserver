package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.et */
/* loaded from: classes.dex */
public final class C0920et extends GeneratedMessageLite.Builder<C0919es, C0920et> implements InterfaceC0921eu {

    /* renamed from: a */
    private int f2878a;

    /* renamed from: b */
    private List<C0892ds> f2879b = Collections.emptyList();

    private C0920et() {
        m4989g();
    }

    /* renamed from: g */
    private void m4989g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0920et m4990h() {
        return new C0920et();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0920et clear() {
        super.clear();
        this.f2879b = Collections.emptyList();
        this.f2878a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0920et mo19949clone() {
        return m4990h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0919es getDefaultInstanceForType() {
        return C0919es.m4979a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0919es build() {
        C0919es c0919esBuildPartial = buildPartial();
        if (!c0919esBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0919esBuildPartial);
        }
        return c0919esBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0919es buildPartial() {
        C0919es c0919es = new C0919es(this);
        int i = this.f2878a;
        if ((this.f2878a & 1) == 1) {
            this.f2879b = Collections.unmodifiableList(this.f2879b);
            this.f2878a &= -2;
        }
        c0919es.f2875b = this.f2879b;
        return c0919es;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0920et mergeFrom(C0919es c0919es) {
        if (c0919es != C0919es.m4979a() && !c0919es.f2875b.isEmpty()) {
            if (this.f2879b.isEmpty()) {
                this.f2879b = c0919es.f2875b;
                this.f2878a &= -2;
            } else {
                m4991i();
                this.f2879b.addAll(c0919es.f2875b);
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
    public C0920et mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    C0893dt c0893dtNewBuilder = C0892ds.newBuilder();
                    codedInputStream.readMessage(c0893dtNewBuilder, extensionRegistryLite);
                    m4994a(c0893dtNewBuilder.buildPartial());
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
    private void m4991i() {
        if ((this.f2878a & 1) != 1) {
            this.f2879b = new ArrayList(this.f2879b);
            this.f2878a |= 1;
        }
    }

    /* renamed from: a */
    public C0920et m4994a(C0892ds c0892ds) {
        if (c0892ds == null) {
            throw new NullPointerException();
        }
        m4991i();
        this.f2879b.add(c0892ds);
        return this;
    }
}
