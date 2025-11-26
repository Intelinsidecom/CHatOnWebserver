package com.sec.p043a.p044a.p045a;

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
public final class C0770v extends GeneratedMessageLite.Builder<C0769u, C0770v> implements InterfaceC0771w {

    /* renamed from: a */
    private int f1848a;

    /* renamed from: b */
    private List<C0766r> f1849b = Collections.emptyList();

    private C0770v() {
        m2778g();
    }

    /* renamed from: g */
    private void m2778g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0770v m2779h() {
        return new C0770v();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0770v clear() {
        super.clear();
        this.f1849b = Collections.emptyList();
        this.f1848a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0770v mo19949clone() {
        return m2779h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0769u getDefaultInstanceForType() {
        return C0769u.m2765a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0769u build() {
        C0769u c0769uBuildPartial = buildPartial();
        if (!c0769uBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0769uBuildPartial);
        }
        return c0769uBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0769u m2780i() throws InvalidProtocolBufferException {
        C0769u c0769uBuildPartial = buildPartial();
        if (!c0769uBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0769uBuildPartial).asInvalidProtocolBufferException();
        }
        return c0769uBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0769u buildPartial() {
        C0769u c0769u = new C0769u(this);
        int i = this.f1848a;
        if ((this.f1848a & 1) == 1) {
            this.f1849b = Collections.unmodifiableList(this.f1849b);
            this.f1848a &= -2;
        }
        c0769u.f1845b = this.f1849b;
        return c0769u;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0770v mergeFrom(C0769u c0769u) {
        if (c0769u != C0769u.m2765a() && !c0769u.f1845b.isEmpty()) {
            if (this.f1849b.isEmpty()) {
                this.f1849b = c0769u.f1845b;
                this.f1848a &= -2;
            } else {
                m2781j();
                this.f1849b.addAll(c0769u.f1845b);
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
    public C0770v mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    C0767s c0767sNewBuilder = C0766r.newBuilder();
                    codedInputStream.readMessage(c0767sNewBuilder, extensionRegistryLite);
                    m2784a(c0767sNewBuilder.buildPartial());
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
    private void m2781j() {
        if ((this.f1848a & 1) != 1) {
            this.f1849b = new ArrayList(this.f1849b);
            this.f1848a |= 1;
        }
    }

    /* renamed from: a */
    public C0770v m2784a(C0766r c0766r) {
        if (c0766r == null) {
            throw new NullPointerException();
        }
        m2781j();
        this.f1849b.add(c0766r);
        return this;
    }
}
