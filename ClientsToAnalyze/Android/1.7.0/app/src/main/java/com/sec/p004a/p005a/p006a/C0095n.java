package com.sec.p004a.p005a.p006a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.n */
/* loaded from: classes.dex */
public final class C0095n extends GeneratedMessageLite.Builder implements InterfaceC0100s {

    /* renamed from: a */
    private int f160a;

    /* renamed from: b */
    private List f161b = Collections.emptyList();

    private C0095n() {
        m444g();
    }

    /* renamed from: g */
    private void m444g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0095n m445h() {
        return new C0095n();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0095n clear() {
        super.clear();
        this.f161b = Collections.emptyList();
        this.f160a &= -2;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0095n mo5946clone() {
        return m445h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0077ak getDefaultInstanceForType() {
        return C0077ak.m265a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0077ak build() {
        C0077ak c0077akBuildPartial = buildPartial();
        if (!c0077akBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0077akBuildPartial);
        }
        return c0077akBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0077ak m446i() throws InvalidProtocolBufferException {
        C0077ak c0077akBuildPartial = buildPartial();
        if (!c0077akBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0077akBuildPartial).asInvalidProtocolBufferException();
        }
        return c0077akBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0077ak buildPartial() {
        C0077ak c0077ak = new C0077ak(this);
        int i = this.f160a;
        if ((this.f160a & 1) == 1) {
            this.f161b = Collections.unmodifiableList(this.f161b);
            this.f160a &= -2;
        }
        c0077ak.f96b = this.f161b;
        return c0077ak;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0095n mergeFrom(C0077ak c0077ak) {
        if (c0077ak != C0077ak.m265a() && !c0077ak.f96b.isEmpty()) {
            if (this.f161b.isEmpty()) {
                this.f161b = c0077ak.f96b;
                this.f160a &= -2;
            } else {
                m447j();
                this.f161b.addAll(c0077ak.f96b);
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
    public C0095n mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    C0070ad c0070adNewBuilder = C0103v.newBuilder();
                    codedInputStream.readMessage(c0070adNewBuilder, extensionRegistryLite);
                    m451a(c0070adNewBuilder.buildPartial());
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
    private void m447j() {
        if ((this.f160a & 1) != 1) {
            this.f161b = new ArrayList(this.f161b);
            this.f160a |= 1;
        }
    }

    /* renamed from: a */
    public C0095n m451a(C0103v c0103v) {
        if (c0103v == null) {
            throw new NullPointerException();
        }
        m447j();
        this.f161b.add(c0103v);
        return this;
    }
}
