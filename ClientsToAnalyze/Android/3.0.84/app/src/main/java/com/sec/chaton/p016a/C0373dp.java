package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dp */
/* loaded from: classes.dex */
public final class C0373dp extends GeneratedMessageLite.Builder<C0372do, C0373dp> implements InterfaceC0374dq {

    /* renamed from: a */
    private int f1299a;

    /* renamed from: b */
    private long f1300b;

    /* renamed from: c */
    private Object f1301c = "";

    /* renamed from: d */
    private List<C0381dx> f1302d = Collections.emptyList();

    /* renamed from: e */
    private C0385ea f1303e = C0385ea.m2690a();

    private C0373dp() {
        m2546i();
    }

    /* renamed from: i */
    private void m2546i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0373dp m2547j() {
        return new C0373dp();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0373dp clear() {
        super.clear();
        this.f1300b = 0L;
        this.f1299a &= -2;
        this.f1301c = "";
        this.f1299a &= -3;
        this.f1302d = Collections.emptyList();
        this.f1299a &= -5;
        this.f1303e = C0385ea.m2690a();
        this.f1299a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0373dp mo13386clone() {
        return m2547j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0372do getDefaultInstanceForType() {
        return C0372do.m2525a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0372do build() {
        C0372do c0372doBuildPartial = buildPartial();
        if (!c0372doBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0372doBuildPartial);
        }
        return c0372doBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0372do m2548k() throws InvalidProtocolBufferException {
        C0372do c0372doBuildPartial = buildPartial();
        if (!c0372doBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0372doBuildPartial).asInvalidProtocolBufferException();
        }
        return c0372doBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0372do buildPartial() {
        C0372do c0372do = new C0372do(this);
        int i = this.f1299a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0372do.f1293c = this.f1300b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0372do.f1294d = this.f1301c;
        if ((this.f1299a & 4) == 4) {
            this.f1302d = Collections.unmodifiableList(this.f1302d);
            this.f1299a &= -5;
        }
        c0372do.f1295e = this.f1302d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0372do.f1296f = this.f1303e;
        c0372do.f1292b = i2;
        return c0372do;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0373dp mergeFrom(C0372do c0372do) {
        if (c0372do != C0372do.m2525a()) {
            if (c0372do.m2535c()) {
                m2551a(c0372do.m2536d());
            }
            if (c0372do.m2537e()) {
                m2556a(c0372do.m2538f());
            }
            if (!c0372do.f1295e.isEmpty()) {
                if (this.f1302d.isEmpty()) {
                    this.f1302d = c0372do.f1295e;
                    this.f1299a &= -5;
                } else {
                    m2549l();
                    this.f1302d.addAll(c0372do.f1295e);
                }
            }
            if (c0372do.m2540h()) {
                m2558b(c0372do.m2541i());
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
    public C0373dp mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1299a |= 1;
                    this.f1300b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f1299a |= 2;
                    this.f1301c = codedInputStream.readBytes();
                    break;
                case 26:
                    MessageLite.Builder builderNewBuilder = C0381dx.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m2554a(builderNewBuilder.buildPartial());
                    break;
                case 34:
                    C0386eb c0386ebNewBuilder = C0385ea.newBuilder();
                    if (m2562f()) {
                        c0386ebNewBuilder.mergeFrom(m2563g());
                    }
                    codedInputStream.readMessage(c0386ebNewBuilder, extensionRegistryLite);
                    m2555a(c0386ebNewBuilder.buildPartial());
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
    public C0373dp m2551a(long j) {
        this.f1299a |= 1;
        this.f1300b = j;
        return this;
    }

    /* renamed from: a */
    public C0373dp m2556a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1299a |= 2;
        this.f1301c = str;
        return this;
    }

    /* renamed from: l */
    private void m2549l() {
        if ((this.f1299a & 4) != 4) {
            this.f1302d = new ArrayList(this.f1302d);
            this.f1299a |= 4;
        }
    }

    /* renamed from: a */
    public C0373dp m2554a(C0381dx c0381dx) {
        if (c0381dx == null) {
            throw new NullPointerException();
        }
        m2549l();
        this.f1302d.add(c0381dx);
        return this;
    }

    /* renamed from: f */
    public boolean m2562f() {
        return (this.f1299a & 8) == 8;
    }

    /* renamed from: g */
    public C0385ea m2563g() {
        return this.f1303e;
    }

    /* renamed from: a */
    public C0373dp m2555a(C0385ea c0385ea) {
        if (c0385ea == null) {
            throw new NullPointerException();
        }
        this.f1303e = c0385ea;
        this.f1299a |= 8;
        return this;
    }

    /* renamed from: b */
    public C0373dp m2558b(C0385ea c0385ea) {
        if ((this.f1299a & 8) == 8 && this.f1303e != C0385ea.m2690a()) {
            this.f1303e = C0385ea.m2691a(this.f1303e).mergeFrom(c0385ea).buildPartial();
        } else {
            this.f1303e = c0385ea;
        }
        this.f1299a |= 8;
        return this;
    }
}
