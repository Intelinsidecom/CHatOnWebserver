package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ab */
/* loaded from: classes.dex */
public final class C0278ab extends GeneratedMessageLite.Builder<C0277aa, C0278ab> implements InterfaceC0279ac {

    /* renamed from: a */
    private int f879a;

    /* renamed from: b */
    private long f880b;

    /* renamed from: c */
    private Object f881c = "";

    /* renamed from: d */
    private Object f882d = "";

    /* renamed from: e */
    private List<C0280ad> f883e = Collections.emptyList();

    private C0278ab() {
        m1398g();
    }

    /* renamed from: g */
    private void m1398g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0278ab m1399h() {
        return new C0278ab();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0278ab clear() {
        super.clear();
        this.f880b = 0L;
        this.f879a &= -2;
        this.f881c = "";
        this.f879a &= -3;
        this.f882d = "";
        this.f879a &= -5;
        this.f883e = Collections.emptyList();
        this.f879a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0278ab mo13386clone() {
        return m1399h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0277aa getDefaultInstanceForType() {
        return C0277aa.m1377a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0277aa build() {
        C0277aa c0277aaBuildPartial = buildPartial();
        if (!c0277aaBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0277aaBuildPartial);
        }
        return c0277aaBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0277aa m1400i() throws InvalidProtocolBufferException {
        C0277aa c0277aaBuildPartial = buildPartial();
        if (!c0277aaBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0277aaBuildPartial).asInvalidProtocolBufferException();
        }
        return c0277aaBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0277aa buildPartial() {
        C0277aa c0277aa = new C0277aa(this);
        int i = this.f879a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0277aa.f873c = this.f880b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0277aa.f874d = this.f881c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0277aa.f875e = this.f882d;
        if ((this.f879a & 8) == 8) {
            this.f883e = Collections.unmodifiableList(this.f883e);
            this.f879a &= -9;
        }
        c0277aa.f876f = this.f883e;
        c0277aa.f872b = i2;
        return c0277aa;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0278ab mergeFrom(C0277aa c0277aa) {
        if (c0277aa != C0277aa.m1377a()) {
            if (c0277aa.m1388c()) {
                m1403a(c0277aa.m1389d());
            }
            if (c0277aa.m1390e()) {
                m1408a(c0277aa.m1391f());
            }
            if (c0277aa.m1392g()) {
                m1410b(c0277aa.m1393h());
            }
            if (!c0277aa.f876f.isEmpty()) {
                if (this.f883e.isEmpty()) {
                    this.f883e = c0277aa.f876f;
                    this.f879a &= -9;
                } else {
                    m1401j();
                    this.f883e.addAll(c0277aa.f876f);
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
    public C0278ab mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f879a |= 1;
                    this.f880b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f879a |= 2;
                    this.f881c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f879a |= 4;
                    this.f882d = codedInputStream.readBytes();
                    break;
                case 34:
                    C0281ae c0281aeNewBuilder = C0280ad.newBuilder();
                    codedInputStream.readMessage(c0281aeNewBuilder, extensionRegistryLite);
                    m1406a(c0281aeNewBuilder.buildPartial());
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
    public C0278ab m1403a(long j) {
        this.f879a |= 1;
        this.f880b = j;
        return this;
    }

    /* renamed from: a */
    public C0278ab m1408a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f879a |= 2;
        this.f881c = str;
        return this;
    }

    /* renamed from: b */
    public C0278ab m1410b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f879a |= 4;
        this.f882d = str;
        return this;
    }

    /* renamed from: j */
    private void m1401j() {
        if ((this.f879a & 8) != 8) {
            this.f883e = new ArrayList(this.f883e);
            this.f879a |= 8;
        }
    }

    /* renamed from: a */
    public C0278ab m1406a(C0280ad c0280ad) {
        if (c0280ad == null) {
            throw new NullPointerException();
        }
        m1401j();
        this.f883e.add(c0280ad);
        return this;
    }

    /* renamed from: a */
    public C0278ab m1407a(Iterable<? extends C0280ad> iterable) {
        m1401j();
        GeneratedMessageLite.Builder.addAll(iterable, this.f883e);
        return this;
    }
}
