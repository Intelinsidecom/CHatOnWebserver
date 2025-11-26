package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bh */
/* loaded from: classes.dex */
public final class C0827bh extends GeneratedMessageLite.Builder<C0826bg, C0827bh> implements InterfaceC0828bi {

    /* renamed from: a */
    private int f2377a;

    /* renamed from: f */
    private boolean f2382f;

    /* renamed from: h */
    private long f2384h;

    /* renamed from: b */
    private Object f2378b = "";

    /* renamed from: c */
    private EnumC0822bc f2379c = EnumC0822bc.SINGLE;

    /* renamed from: d */
    private List<C0864cr> f2380d = Collections.emptyList();

    /* renamed from: e */
    private Object f2381e = "";

    /* renamed from: g */
    private Object f2383g = "";

    private C0827bh() {
        m3616g();
    }

    /* renamed from: g */
    private void m3616g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0827bh m3617h() {
        return new C0827bh();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0827bh clear() {
        super.clear();
        this.f2378b = "";
        this.f2377a &= -2;
        this.f2379c = EnumC0822bc.SINGLE;
        this.f2377a &= -3;
        this.f2380d = Collections.emptyList();
        this.f2377a &= -5;
        this.f2381e = "";
        this.f2377a &= -9;
        this.f2382f = false;
        this.f2377a &= -17;
        this.f2383g = "";
        this.f2377a &= -33;
        this.f2384h = 0L;
        this.f2377a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0827bh mo19949clone() {
        return m3617h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0826bg getDefaultInstanceForType() {
        return C0826bg.m3583a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0826bg build() {
        C0826bg c0826bgBuildPartial = buildPartial();
        if (!c0826bgBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0826bgBuildPartial);
        }
        return c0826bgBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0826bg m3618i() throws InvalidProtocolBufferException {
        C0826bg c0826bgBuildPartial = buildPartial();
        if (!c0826bgBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0826bgBuildPartial).asInvalidProtocolBufferException();
        }
        return c0826bgBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0826bg buildPartial() {
        C0826bg c0826bg = new C0826bg(this);
        int i = this.f2377a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0826bg.f2368c = this.f2378b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0826bg.f2369d = this.f2379c;
        if ((this.f2377a & 4) == 4) {
            this.f2380d = Collections.unmodifiableList(this.f2380d);
            this.f2377a &= -5;
        }
        c0826bg.f2370e = this.f2380d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0826bg.f2371f = this.f2381e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0826bg.f2372g = this.f2382f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0826bg.f2373h = this.f2383g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0826bg.f2374i = this.f2384h;
        c0826bg.f2367b = i2;
        return c0826bg;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0827bh mergeFrom(C0826bg c0826bg) {
        if (c0826bg != C0826bg.m3583a()) {
            if (c0826bg.m3598c()) {
                m3626a(c0826bg.m3599d());
            }
            if (c0826bg.m3600e()) {
                m3623a(c0826bg.m3601f());
            }
            if (!c0826bg.f2370e.isEmpty()) {
                if (this.f2380d.isEmpty()) {
                    this.f2380d = c0826bg.f2370e;
                    this.f2377a &= -5;
                } else {
                    m3619j();
                    this.f2380d.addAll(c0826bg.f2370e);
                }
            }
            if (c0826bg.m3604i()) {
                m3629b(c0826bg.m3605j());
            }
            if (c0826bg.m3606k()) {
                m3627a(c0826bg.m3607l());
            }
            if (c0826bg.m3608m()) {
                m3631c(c0826bg.m3609n());
            }
            if (c0826bg.m3610o()) {
                m3621a(c0826bg.m3611p());
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
    public C0827bh mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2377a |= 1;
                    this.f2378b = codedInputStream.readBytes();
                    break;
                case 16:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f2377a |= 2;
                        this.f2379c = enumC0822bcM3576a;
                        break;
                    }
                case 26:
                    C0865cs c0865csNewBuilder = C0864cr.newBuilder();
                    codedInputStream.readMessage(c0865csNewBuilder, extensionRegistryLite);
                    m3625a(c0865csNewBuilder.buildPartial());
                    break;
                case 34:
                    this.f2377a |= 8;
                    this.f2381e = codedInputStream.readBytes();
                    break;
                case 40:
                    this.f2377a |= 16;
                    this.f2382f = codedInputStream.readBool();
                    break;
                case 50:
                    this.f2377a |= 32;
                    this.f2383g = codedInputStream.readBytes();
                    break;
                case 56:
                    this.f2377a |= 64;
                    this.f2384h = codedInputStream.readInt64();
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
    public C0827bh m3626a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2377a |= 1;
        this.f2378b = str;
        return this;
    }

    /* renamed from: a */
    public C0827bh m3623a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f2377a |= 2;
        this.f2379c = enumC0822bc;
        return this;
    }

    /* renamed from: j */
    private void m3619j() {
        if ((this.f2377a & 4) != 4) {
            this.f2380d = new ArrayList(this.f2380d);
            this.f2377a |= 4;
        }
    }

    /* renamed from: a */
    public C0827bh m3625a(C0864cr c0864cr) {
        if (c0864cr == null) {
            throw new NullPointerException();
        }
        m3619j();
        this.f2380d.add(c0864cr);
        return this;
    }

    /* renamed from: b */
    public C0827bh m3629b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2377a |= 8;
        this.f2381e = str;
        return this;
    }

    /* renamed from: a */
    public C0827bh m3627a(boolean z) {
        this.f2377a |= 16;
        this.f2382f = z;
        return this;
    }

    /* renamed from: c */
    public C0827bh m3631c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2377a |= 32;
        this.f2383g = str;
        return this;
    }

    /* renamed from: a */
    public C0827bh m3621a(long j) {
        this.f2377a |= 64;
        this.f2384h = j;
        return this;
    }
}
