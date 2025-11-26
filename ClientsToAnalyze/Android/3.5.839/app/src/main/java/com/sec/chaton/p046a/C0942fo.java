package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fo */
/* loaded from: classes.dex */
public final class C0942fo extends GeneratedMessageLite.Builder<C0941fn, C0942fo> implements InterfaceC0943fp {

    /* renamed from: a */
    private int f2990a;

    /* renamed from: b */
    private long f2991b;

    /* renamed from: c */
    private Object f2992c = "";

    /* renamed from: d */
    private Object f2993d = "";

    /* renamed from: e */
    private Object f2994e = "";

    private C0942fo() {
        m5324g();
    }

    /* renamed from: g */
    private void m5324g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0942fo m5325h() {
        return new C0942fo();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0942fo clear() {
        super.clear();
        this.f2991b = 0L;
        this.f2990a &= -2;
        this.f2992c = "";
        this.f2990a &= -3;
        this.f2993d = "";
        this.f2990a &= -5;
        this.f2994e = "";
        this.f2990a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0942fo mo19949clone() {
        return m5325h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0941fn getDefaultInstanceForType() {
        return C0941fn.m5301a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0941fn build() {
        C0941fn c0941fnBuildPartial = buildPartial();
        if (!c0941fnBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0941fnBuildPartial);
        }
        return c0941fnBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0941fn m5326i() throws InvalidProtocolBufferException {
        C0941fn c0941fnBuildPartial = buildPartial();
        if (!c0941fnBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0941fnBuildPartial).asInvalidProtocolBufferException();
        }
        return c0941fnBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0941fn buildPartial() {
        C0941fn c0941fn = new C0941fn(this);
        int i = this.f2990a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0941fn.f2984c = this.f2991b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0941fn.f2985d = this.f2992c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0941fn.f2986e = this.f2993d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0941fn.f2987f = this.f2994e;
        c0941fn.f2983b = i2;
        return c0941fn;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0942fo mergeFrom(C0941fn c0941fn) {
        if (c0941fn != C0941fn.m5301a()) {
            if (c0941fn.m5312c()) {
                m5328a(c0941fn.m5313d());
            }
            if (c0941fn.m5314e()) {
                m5331a(c0941fn.m5315f());
            }
            if (c0941fn.m5316g()) {
                m5333b(c0941fn.m5317h());
            }
            if (c0941fn.m5318i()) {
                m5335c(c0941fn.m5319j());
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
    public C0942fo mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2990a |= 1;
                    this.f2991b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f2990a |= 2;
                    this.f2992c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f2990a |= 4;
                    this.f2993d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f2990a |= 8;
                    this.f2994e = codedInputStream.readBytes();
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
    public C0942fo m5328a(long j) {
        this.f2990a |= 1;
        this.f2991b = j;
        return this;
    }

    /* renamed from: a */
    public C0942fo m5331a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2990a |= 2;
        this.f2992c = str;
        return this;
    }

    /* renamed from: b */
    public C0942fo m5333b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2990a |= 4;
        this.f2993d = str;
        return this;
    }

    /* renamed from: c */
    public C0942fo m5335c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2990a |= 8;
        this.f2994e = str;
        return this;
    }
}
