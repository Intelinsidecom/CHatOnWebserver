package com.sec.chaton.p015b;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.bt */
/* loaded from: classes.dex */
public final class C0307bt extends GeneratedMessageLite.Builder implements InterfaceC0345s {

    /* renamed from: a */
    private int f849a;

    /* renamed from: b */
    private List f850b = Collections.emptyList();

    private C0307bt() {
        m1538g();
    }

    /* renamed from: g */
    private void m1538g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0307bt m1539h() {
        return new C0307bt();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0307bt clear() {
        super.clear();
        this.f850b = Collections.emptyList();
        this.f849a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0307bt mo5946clone() {
        return m1539h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0322ch getDefaultInstanceForType() {
        return C0322ch.m1739a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0322ch build() {
        C0322ch c0322chBuildPartial = buildPartial();
        if (!c0322chBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0322chBuildPartial);
        }
        return c0322chBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0322ch m1540i() throws InvalidProtocolBufferException {
        C0322ch c0322chBuildPartial = buildPartial();
        if (!c0322chBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0322chBuildPartial).asInvalidProtocolBufferException();
        }
        return c0322chBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0322ch buildPartial() {
        C0322ch c0322ch = new C0322ch(this);
        int i = this.f849a;
        if ((this.f849a & 1) == 1) {
            this.f850b = Collections.unmodifiableList(this.f850b);
            this.f849a &= -2;
        }
        c0322ch.f909b = this.f850b;
        return c0322ch;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0307bt mergeFrom(C0322ch c0322ch) {
        if (c0322ch != C0322ch.m1739a() && !c0322ch.f909b.isEmpty()) {
            if (this.f850b.isEmpty()) {
                this.f850b = c0322ch.f909b;
                this.f849a &= -2;
            } else {
                m1541j();
                this.f850b.addAll(c0322ch.f909b);
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
    public C0307bt mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    C0346t c0346tNewBuilder = C0344r.newBuilder();
                    codedInputStream.readMessage(c0346tNewBuilder, extensionRegistryLite);
                    m1545a(c0346tNewBuilder.buildPartial());
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
    private void m1541j() {
        if ((this.f849a & 1) != 1) {
            this.f850b = new ArrayList(this.f850b);
            this.f849a |= 1;
        }
    }

    /* renamed from: a */
    public C0307bt m1545a(C0344r c0344r) {
        if (c0344r == null) {
            throw new NullPointerException();
        }
        m1541j();
        this.f850b.add(c0344r);
        return this;
    }
}
