package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ae */
/* loaded from: classes.dex */
public final class C0797ae extends GeneratedMessageLite.Builder<C0796ad, C0797ae> implements InterfaceC0798af {

    /* renamed from: a */
    private int f2202a;

    /* renamed from: b */
    private long f2203b;

    /* renamed from: c */
    private Object f2204c = "";

    /* renamed from: d */
    private Object f2205d = "";

    /* renamed from: e */
    private List<C0799ag> f2206e = Collections.emptyList();

    private C0797ae() {
        m3217g();
    }

    /* renamed from: g */
    private void m3217g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0797ae m3218h() {
        return new C0797ae();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0797ae clear() {
        super.clear();
        this.f2203b = 0L;
        this.f2202a &= -2;
        this.f2204c = "";
        this.f2202a &= -3;
        this.f2205d = "";
        this.f2202a &= -5;
        this.f2206e = Collections.emptyList();
        this.f2202a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0797ae mo19949clone() {
        return m3218h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0796ad getDefaultInstanceForType() {
        return C0796ad.m3196a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0796ad build() {
        C0796ad c0796adBuildPartial = buildPartial();
        if (!c0796adBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0796adBuildPartial);
        }
        return c0796adBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0796ad m3219i() throws InvalidProtocolBufferException {
        C0796ad c0796adBuildPartial = buildPartial();
        if (!c0796adBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0796adBuildPartial).asInvalidProtocolBufferException();
        }
        return c0796adBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0796ad buildPartial() {
        C0796ad c0796ad = new C0796ad(this);
        int i = this.f2202a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0796ad.f2196c = this.f2203b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0796ad.f2197d = this.f2204c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0796ad.f2198e = this.f2205d;
        if ((this.f2202a & 8) == 8) {
            this.f2206e = Collections.unmodifiableList(this.f2206e);
            this.f2202a &= -9;
        }
        c0796ad.f2199f = this.f2206e;
        c0796ad.f2195b = i2;
        return c0796ad;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0797ae mergeFrom(C0796ad c0796ad) {
        if (c0796ad != C0796ad.m3196a()) {
            if (c0796ad.m3207c()) {
                m3222a(c0796ad.m3208d());
            }
            if (c0796ad.m3209e()) {
                m3227a(c0796ad.m3210f());
            }
            if (c0796ad.m3211g()) {
                m3229b(c0796ad.m3212h());
            }
            if (!c0796ad.f2199f.isEmpty()) {
                if (this.f2206e.isEmpty()) {
                    this.f2206e = c0796ad.f2199f;
                    this.f2202a &= -9;
                } else {
                    m3220j();
                    this.f2206e.addAll(c0796ad.f2199f);
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
    public C0797ae mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2202a |= 1;
                    this.f2203b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f2202a |= 2;
                    this.f2204c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f2202a |= 4;
                    this.f2205d = codedInputStream.readBytes();
                    break;
                case 34:
                    C0800ah c0800ahNewBuilder = C0799ag.newBuilder();
                    codedInputStream.readMessage(c0800ahNewBuilder, extensionRegistryLite);
                    m3225a(c0800ahNewBuilder.buildPartial());
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
    public C0797ae m3222a(long j) {
        this.f2202a |= 1;
        this.f2203b = j;
        return this;
    }

    /* renamed from: a */
    public C0797ae m3227a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2202a |= 2;
        this.f2204c = str;
        return this;
    }

    /* renamed from: b */
    public C0797ae m3229b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2202a |= 4;
        this.f2205d = str;
        return this;
    }

    /* renamed from: j */
    private void m3220j() {
        if ((this.f2202a & 8) != 8) {
            this.f2206e = new ArrayList(this.f2206e);
            this.f2202a |= 8;
        }
    }

    /* renamed from: a */
    public C0797ae m3225a(C0799ag c0799ag) {
        if (c0799ag == null) {
            throw new NullPointerException();
        }
        m3220j();
        this.f2206e.add(c0799ag);
        return this;
    }

    /* renamed from: a */
    public C0797ae m3226a(Iterable<? extends C0799ag> iterable) {
        m3220j();
        GeneratedMessageLite.Builder.addAll(iterable, this.f2206e);
        return this;
    }
}
