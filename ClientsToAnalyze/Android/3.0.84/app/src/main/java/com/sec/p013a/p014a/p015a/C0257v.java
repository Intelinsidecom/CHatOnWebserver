package com.sec.p013a.p014a.p015a;

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
public final class C0257v extends GeneratedMessageLite.Builder<C0256u, C0257v> implements InterfaceC0258w {

    /* renamed from: a */
    private int f612a;

    /* renamed from: b */
    private List<C0253r> f613b = Collections.emptyList();

    private C0257v() {
        m1046g();
    }

    /* renamed from: g */
    private void m1046g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0257v m1047h() {
        return new C0257v();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0257v clear() {
        super.clear();
        this.f613b = Collections.emptyList();
        this.f612a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0257v mo13386clone() {
        return m1047h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0256u getDefaultInstanceForType() {
        return C0256u.m1033a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0256u build() {
        C0256u c0256uBuildPartial = buildPartial();
        if (!c0256uBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0256uBuildPartial);
        }
        return c0256uBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0256u m1048i() throws InvalidProtocolBufferException {
        C0256u c0256uBuildPartial = buildPartial();
        if (!c0256uBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0256uBuildPartial).asInvalidProtocolBufferException();
        }
        return c0256uBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0256u buildPartial() {
        C0256u c0256u = new C0256u(this);
        int i = this.f612a;
        if ((this.f612a & 1) == 1) {
            this.f613b = Collections.unmodifiableList(this.f613b);
            this.f612a &= -2;
        }
        c0256u.f609b = this.f613b;
        return c0256u;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0257v mergeFrom(C0256u c0256u) {
        if (c0256u != C0256u.m1033a() && !c0256u.f609b.isEmpty()) {
            if (this.f613b.isEmpty()) {
                this.f613b = c0256u.f609b;
                this.f612a &= -2;
            } else {
                m1049j();
                this.f613b.addAll(c0256u.f609b);
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
    public C0257v mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    C0254s c0254sNewBuilder = C0253r.newBuilder();
                    codedInputStream.readMessage(c0254sNewBuilder, extensionRegistryLite);
                    m1052a(c0254sNewBuilder.buildPartial());
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
    private void m1049j() {
        if ((this.f612a & 1) != 1) {
            this.f613b = new ArrayList(this.f613b);
            this.f612a |= 1;
        }
    }

    /* renamed from: a */
    public C0257v m1052a(C0253r c0253r) {
        if (c0253r == null) {
            throw new NullPointerException();
        }
        m1049j();
        this.f613b.add(c0253r);
        return this;
    }
}
