package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.MessageLite;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.m */
/* loaded from: classes.dex */
public final class C0977m extends GeneratedMessageLite.Builder<C0976l, C0977m> implements InterfaceC0978n {

    /* renamed from: a */
    private int f3186a;

    /* renamed from: b */
    private long f3187b;

    /* renamed from: f */
    private long f3191f;

    /* renamed from: h */
    private long f3193h;

    /* renamed from: c */
    private Object f3188c = "";

    /* renamed from: d */
    private List<C0802aj> f3189d = Collections.emptyList();

    /* renamed from: e */
    private LazyStringList f3190e = LazyStringArrayList.EMPTY;

    /* renamed from: g */
    private Object f3192g = "";

    /* renamed from: i */
    private C0960gf f3194i = C0960gf.m5581a();

    private C0977m() {
        m5859i();
    }

    /* renamed from: i */
    private void m5859i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0977m m5860j() {
        return new C0977m();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0977m clear() {
        super.clear();
        this.f3187b = 0L;
        this.f3186a &= -2;
        this.f3188c = "";
        this.f3186a &= -3;
        this.f3189d = Collections.emptyList();
        this.f3186a &= -5;
        this.f3190e = LazyStringArrayList.EMPTY;
        this.f3186a &= -9;
        this.f3191f = 0L;
        this.f3186a &= -17;
        this.f3192g = "";
        this.f3186a &= -33;
        this.f3193h = 0L;
        this.f3186a &= -65;
        this.f3194i = C0960gf.m5581a();
        this.f3186a &= -129;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0977m mo19949clone() {
        return m5860j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0976l getDefaultInstanceForType() {
        return C0976l.m5824a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0976l build() {
        C0976l c0976lBuildPartial = buildPartial();
        if (!c0976lBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0976lBuildPartial);
        }
        return c0976lBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0976l m5861k() throws InvalidProtocolBufferException {
        C0976l c0976lBuildPartial = buildPartial();
        if (!c0976lBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0976lBuildPartial).asInvalidProtocolBufferException();
        }
        return c0976lBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0976l buildPartial() {
        C0976l c0976l = new C0976l(this);
        int i = this.f3186a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0976l.f3176c = this.f3187b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0976l.f3177d = this.f3188c;
        if ((this.f3186a & 4) == 4) {
            this.f3189d = Collections.unmodifiableList(this.f3189d);
            this.f3186a &= -5;
        }
        c0976l.f3178e = this.f3189d;
        if ((this.f3186a & 8) == 8) {
            this.f3190e = new UnmodifiableLazyStringList(this.f3190e);
            this.f3186a &= -9;
        }
        c0976l.f3179f = this.f3190e;
        if ((i & 16) == 16) {
            i2 |= 4;
        }
        c0976l.f3180g = this.f3191f;
        if ((i & 32) == 32) {
            i2 |= 8;
        }
        c0976l.f3181h = this.f3192g;
        if ((i & 64) == 64) {
            i2 |= 16;
        }
        c0976l.f3182i = this.f3193h;
        if ((i & 128) == 128) {
            i2 |= 32;
        }
        c0976l.f3183j = this.f3194i;
        c0976l.f3175b = i2;
        return c0976l;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0977m mergeFrom(C0976l c0976l) {
        if (c0976l != C0976l.m5824a()) {
            if (c0976l.m5839c()) {
                m5865a(c0976l.m5840d());
            }
            if (c0976l.m5841e()) {
                m5870a(c0976l.m5842f());
            }
            if (!c0976l.f3178e.isEmpty()) {
                if (this.f3189d.isEmpty()) {
                    this.f3189d = c0976l.f3178e;
                    this.f3186a &= -5;
                } else {
                    m5862l();
                    this.f3189d.addAll(c0976l.f3178e);
                }
            }
            if (!c0976l.f3179f.isEmpty()) {
                if (this.f3190e.isEmpty()) {
                    this.f3190e = c0976l.f3179f;
                    this.f3186a &= -9;
                } else {
                    m5863m();
                    this.f3190e.addAll(c0976l.f3179f);
                }
            }
            if (c0976l.m5847k()) {
                m5872b(c0976l.m5848l());
            }
            if (c0976l.m5849m()) {
                m5874b(c0976l.m5850n());
            }
            if (c0976l.m5851o()) {
                m5876c(c0976l.m5852p());
            }
            if (c0976l.m5853q()) {
                m5873b(c0976l.m5854r());
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
    public C0977m mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f3186a |= 1;
                    this.f3187b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f3186a |= 2;
                    this.f3188c = codedInputStream.readBytes();
                    break;
                case 26:
                    MessageLite.Builder builderNewBuilder = C0802aj.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m5867a(builderNewBuilder.buildPartial());
                    break;
                case 34:
                    m5863m();
                    this.f3190e.add(codedInputStream.readBytes());
                    break;
                case 40:
                    this.f3186a |= 16;
                    this.f3191f = codedInputStream.readInt64();
                    break;
                case 50:
                    this.f3186a |= 32;
                    this.f3192g = codedInputStream.readBytes();
                    break;
                case 56:
                    this.f3186a |= 64;
                    this.f3193h = codedInputStream.readInt64();
                    break;
                case 66:
                    C0961gg c0961ggNewBuilder = C0960gf.newBuilder();
                    if (m5879f()) {
                        c0961ggNewBuilder.mergeFrom(m5880g());
                    }
                    codedInputStream.readMessage(c0961ggNewBuilder, extensionRegistryLite);
                    m5868a(c0961ggNewBuilder.buildPartial());
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
    public C0977m m5865a(long j) {
        this.f3186a |= 1;
        this.f3187b = j;
        return this;
    }

    /* renamed from: a */
    public C0977m m5870a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3186a |= 2;
        this.f3188c = str;
        return this;
    }

    /* renamed from: l */
    private void m5862l() {
        if ((this.f3186a & 4) != 4) {
            this.f3189d = new ArrayList(this.f3189d);
            this.f3186a |= 4;
        }
    }

    /* renamed from: a */
    public C0977m m5867a(C0802aj c0802aj) {
        if (c0802aj == null) {
            throw new NullPointerException();
        }
        m5862l();
        this.f3189d.add(c0802aj);
        return this;
    }

    /* renamed from: m */
    private void m5863m() {
        if ((this.f3186a & 8) != 8) {
            this.f3190e = new LazyStringArrayList(this.f3190e);
            this.f3186a |= 8;
        }
    }

    /* renamed from: b */
    public C0977m m5872b(long j) {
        this.f3186a |= 16;
        this.f3191f = j;
        return this;
    }

    /* renamed from: b */
    public C0977m m5874b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3186a |= 32;
        this.f3192g = str;
        return this;
    }

    /* renamed from: c */
    public C0977m m5876c(long j) {
        this.f3186a |= 64;
        this.f3193h = j;
        return this;
    }

    /* renamed from: f */
    public boolean m5879f() {
        return (this.f3186a & 128) == 128;
    }

    /* renamed from: g */
    public C0960gf m5880g() {
        return this.f3194i;
    }

    /* renamed from: a */
    public C0977m m5868a(C0960gf c0960gf) {
        if (c0960gf == null) {
            throw new NullPointerException();
        }
        this.f3194i = c0960gf;
        this.f3186a |= 128;
        return this;
    }

    /* renamed from: b */
    public C0977m m5873b(C0960gf c0960gf) {
        if ((this.f3186a & 128) == 128 && this.f3194i != C0960gf.m5581a()) {
            this.f3194i = C0960gf.m5582a(this.f3194i).mergeFrom(c0960gf).buildPartial();
        } else {
            this.f3194i = c0960gf;
        }
        this.f3186a |= 128;
        return this;
    }
}
