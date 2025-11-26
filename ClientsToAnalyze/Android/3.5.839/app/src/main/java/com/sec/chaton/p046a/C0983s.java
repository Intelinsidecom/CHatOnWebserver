package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.s */
/* loaded from: classes.dex */
public final class C0983s extends GeneratedMessageLite.Builder<C0982r, C0983s> implements InterfaceC0984t {

    /* renamed from: a */
    private int f3215a;

    /* renamed from: b */
    private List<C0988x> f3216b = Collections.emptyList();

    /* renamed from: c */
    private Object f3217c = "";

    /* renamed from: d */
    private long f3218d;

    private C0983s() {
        m5945g();
    }

    /* renamed from: g */
    private void m5945g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0983s m5946h() {
        return new C0983s();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0983s clear() {
        super.clear();
        this.f3216b = Collections.emptyList();
        this.f3215a &= -2;
        this.f3217c = "";
        this.f3215a &= -3;
        this.f3218d = 0L;
        this.f3215a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0983s mo19949clone() {
        return m5946h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0982r getDefaultInstanceForType() {
        return C0982r.m5925a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0982r build() {
        C0982r c0982rBuildPartial = buildPartial();
        if (!c0982rBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0982rBuildPartial);
        }
        return c0982rBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0982r m5947i() throws InvalidProtocolBufferException {
        C0982r c0982rBuildPartial = buildPartial();
        if (!c0982rBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0982rBuildPartial).asInvalidProtocolBufferException();
        }
        return c0982rBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0982r buildPartial() {
        C0982r c0982r = new C0982r(this);
        int i = this.f3215a;
        if ((this.f3215a & 1) == 1) {
            this.f3216b = Collections.unmodifiableList(this.f3216b);
            this.f3215a &= -2;
        }
        c0982r.f3210c = this.f3216b;
        int i2 = (i & 2) != 2 ? 0 : 1;
        c0982r.f3211d = this.f3217c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0982r.f3212e = this.f3218d;
        c0982r.f3209b = i2;
        return c0982r;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0983s mergeFrom(C0982r c0982r) {
        if (c0982r != C0982r.m5925a()) {
            if (!c0982r.f3210c.isEmpty()) {
                if (this.f3216b.isEmpty()) {
                    this.f3216b = c0982r.f3210c;
                    this.f3215a &= -2;
                } else {
                    m5948j();
                    this.f3216b.addAll(c0982r.f3210c);
                }
            }
            if (c0982r.m5937e()) {
                m5954a(c0982r.m5938f());
            }
            if (c0982r.m5939g()) {
                m5950a(c0982r.m5940h());
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
    public C0983s mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    C0989y c0989yNewBuilder = C0988x.newBuilder();
                    codedInputStream.readMessage(c0989yNewBuilder, extensionRegistryLite);
                    m5953a(c0989yNewBuilder.buildPartial());
                    break;
                case 18:
                    this.f3215a |= 2;
                    this.f3217c = codedInputStream.readBytes();
                    break;
                case 24:
                    this.f3215a |= 4;
                    this.f3218d = codedInputStream.readInt64();
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
    private void m5948j() {
        if ((this.f3215a & 1) != 1) {
            this.f3216b = new ArrayList(this.f3216b);
            this.f3215a |= 1;
        }
    }

    /* renamed from: a */
    public C0983s m5953a(C0988x c0988x) {
        if (c0988x == null) {
            throw new NullPointerException();
        }
        m5948j();
        this.f3216b.add(c0988x);
        return this;
    }

    /* renamed from: a */
    public C0983s m5954a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3215a |= 2;
        this.f3217c = str;
        return this;
    }

    /* renamed from: a */
    public C0983s m5950a(long j) {
        this.f3215a |= 4;
        this.f3218d = j;
        return this;
    }
}
