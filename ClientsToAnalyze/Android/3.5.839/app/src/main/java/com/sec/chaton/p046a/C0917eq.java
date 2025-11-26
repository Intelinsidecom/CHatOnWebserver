package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.eq */
/* loaded from: classes.dex */
public final class C0917eq extends GeneratedMessageLite.Builder<C0916ep, C0917eq> implements InterfaceC0918er {

    /* renamed from: a */
    private int f2871a;

    /* renamed from: b */
    private long f2872b;

    /* renamed from: c */
    private LazyStringList f2873c = LazyStringArrayList.EMPTY;

    private C0917eq() {
        m4967g();
    }

    /* renamed from: g */
    private void m4967g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0917eq m4968h() {
        return new C0917eq();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0917eq clear() {
        super.clear();
        this.f2872b = 0L;
        this.f2871a &= -2;
        this.f2873c = LazyStringArrayList.EMPTY;
        this.f2871a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0917eq mo19949clone() {
        return m4968h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0916ep getDefaultInstanceForType() {
        return C0916ep.m4954a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0916ep build() {
        C0916ep c0916epBuildPartial = buildPartial();
        if (!c0916epBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0916epBuildPartial);
        }
        return c0916epBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0916ep m4969i() throws InvalidProtocolBufferException {
        C0916ep c0916epBuildPartial = buildPartial();
        if (!c0916epBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0916epBuildPartial).asInvalidProtocolBufferException();
        }
        return c0916epBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0916ep buildPartial() {
        C0916ep c0916ep = new C0916ep(this);
        int i = (this.f2871a & 1) != 1 ? 0 : 1;
        c0916ep.f2867c = this.f2872b;
        if ((this.f2871a & 2) == 2) {
            this.f2873c = new UnmodifiableLazyStringList(this.f2873c);
            this.f2871a &= -3;
        }
        c0916ep.f2868d = this.f2873c;
        c0916ep.f2866b = i;
        return c0916ep;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0917eq mergeFrom(C0916ep c0916ep) {
        if (c0916ep != C0916ep.m4954a()) {
            if (c0916ep.m4960c()) {
                m4972a(c0916ep.m4961d());
            }
            if (!c0916ep.f2868d.isEmpty()) {
                if (this.f2873c.isEmpty()) {
                    this.f2873c = c0916ep.f2868d;
                    this.f2871a &= -3;
                } else {
                    m4970j();
                    this.f2873c.addAll(c0916ep.f2868d);
                }
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
    public C0917eq mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2871a |= 1;
                    this.f2872b = codedInputStream.readInt64();
                    break;
                case 18:
                    m4970j();
                    this.f2873c.add(codedInputStream.readBytes());
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
    public C0917eq m4972a(long j) {
        this.f2871a |= 1;
        this.f2872b = j;
        return this;
    }

    /* renamed from: j */
    private void m4970j() {
        if ((this.f2871a & 2) != 2) {
            this.f2873c = new LazyStringArrayList(this.f2873c);
            this.f2871a |= 2;
        }
    }
}
