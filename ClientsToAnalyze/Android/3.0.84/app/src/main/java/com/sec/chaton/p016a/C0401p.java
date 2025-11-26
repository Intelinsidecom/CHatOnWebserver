package com.sec.chaton.p016a;

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
public final class C0401p extends GeneratedMessageLite.Builder<C0400o, C0401p> implements InterfaceC0402q {

    /* renamed from: a */
    private int f1426a;

    /* renamed from: b */
    private List<C0406u> f1427b = Collections.emptyList();

    private C0401p() {
        m2913g();
    }

    /* renamed from: g */
    private void m2913g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0401p m2914h() {
        return new C0401p();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0401p clear() {
        super.clear();
        this.f1427b = Collections.emptyList();
        this.f1426a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0401p mo13386clone() {
        return m2914h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0400o getDefaultInstanceForType() {
        return C0400o.m2899a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0400o build() {
        C0400o c0400oBuildPartial = buildPartial();
        if (!c0400oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0400oBuildPartial);
        }
        return c0400oBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0400o m2915i() throws InvalidProtocolBufferException {
        C0400o c0400oBuildPartial = buildPartial();
        if (!c0400oBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0400oBuildPartial).asInvalidProtocolBufferException();
        }
        return c0400oBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0400o buildPartial() {
        C0400o c0400o = new C0400o(this);
        int i = this.f1426a;
        if ((this.f1426a & 1) == 1) {
            this.f1427b = Collections.unmodifiableList(this.f1427b);
            this.f1426a &= -2;
        }
        c0400o.f1423b = this.f1427b;
        return c0400o;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0401p mergeFrom(C0400o c0400o) {
        if (c0400o != C0400o.m2899a() && !c0400o.f1423b.isEmpty()) {
            if (this.f1427b.isEmpty()) {
                this.f1427b = c0400o.f1423b;
                this.f1426a &= -2;
            } else {
                m2916j();
                this.f1427b.addAll(c0400o.f1423b);
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
    public C0401p mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    C0407v c0407vNewBuilder = C0406u.newBuilder();
                    codedInputStream.readMessage(c0407vNewBuilder, extensionRegistryLite);
                    m2920a(c0407vNewBuilder.buildPartial());
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
    private void m2916j() {
        if ((this.f1426a & 1) != 1) {
            this.f1427b = new ArrayList(this.f1427b);
            this.f1426a |= 1;
        }
    }

    /* renamed from: a */
    public C0401p m2920a(C0406u c0406u) {
        if (c0406u == null) {
            throw new NullPointerException();
        }
        m2916j();
        this.f1427b.add(c0406u);
        return this;
    }
}
