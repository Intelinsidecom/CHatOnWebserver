package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cp */
/* loaded from: classes.dex */
public final class C0862cp extends GeneratedMessageLite.Builder<C0861co, C0862cp> implements InterfaceC0863cq {

    /* renamed from: a */
    private int f2553a;

    /* renamed from: f */
    private int f2558f;

    /* renamed from: h */
    private long f2560h;

    /* renamed from: i */
    private long f2561i;

    /* renamed from: j */
    private long f2562j;

    /* renamed from: b */
    private Object f2554b = "";

    /* renamed from: c */
    private Object f2555c = "";

    /* renamed from: d */
    private Object f2556d = "";

    /* renamed from: e */
    private List<C0867cu> f2557e = Collections.emptyList();

    /* renamed from: g */
    private Object f2559g = "";

    private C0862cp() {
        m4109g();
    }

    /* renamed from: g */
    private void m4109g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0862cp m4110h() {
        return new C0862cp();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0862cp clear() {
        super.clear();
        this.f2554b = "";
        this.f2553a &= -2;
        this.f2555c = "";
        this.f2553a &= -3;
        this.f2556d = "";
        this.f2553a &= -5;
        this.f2557e = Collections.emptyList();
        this.f2553a &= -9;
        this.f2558f = 0;
        this.f2553a &= -17;
        this.f2559g = "";
        this.f2553a &= -33;
        this.f2560h = 0L;
        this.f2553a &= -65;
        this.f2561i = 0L;
        this.f2553a &= -129;
        this.f2562j = 0L;
        this.f2553a &= -257;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0862cp mo19949clone() {
        return m4110h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0861co getDefaultInstanceForType() {
        return C0861co.m4069a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0861co build() {
        C0861co c0861coBuildPartial = buildPartial();
        if (!c0861coBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0861coBuildPartial);
        }
        return c0861coBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0861co m4111i() throws InvalidProtocolBufferException {
        C0861co c0861coBuildPartial = buildPartial();
        if (!c0861coBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0861coBuildPartial).asInvalidProtocolBufferException();
        }
        return c0861coBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0861co buildPartial() {
        C0861co c0861co = new C0861co(this);
        int i = this.f2553a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0861co.f2542c = this.f2554b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0861co.f2543d = this.f2555c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0861co.f2544e = this.f2556d;
        if ((this.f2553a & 8) == 8) {
            this.f2557e = Collections.unmodifiableList(this.f2557e);
            this.f2553a &= -9;
        }
        c0861co.f2545f = this.f2557e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0861co.f2546g = this.f2558f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0861co.f2547h = this.f2559g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0861co.f2548i = this.f2560h;
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        c0861co.f2549j = this.f2561i;
        if ((i & 256) == 256) {
            i2 |= 128;
        }
        c0861co.f2550k = this.f2562j;
        c0861co.f2541b = i2;
        return c0861co;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0862cp mergeFrom(C0861co c0861co) {
        if (c0861co != C0861co.m4069a()) {
            if (c0861co.m4087c()) {
                m4119a(c0861co.m4088d());
            }
            if (c0861co.m4089e()) {
                m4122b(c0861co.m4090f());
            }
            if (c0861co.m4091g()) {
                m4125c(c0861co.m4092h());
            }
            if (!c0861co.f2545f.isEmpty()) {
                if (this.f2557e.isEmpty()) {
                    this.f2557e = c0861co.f2545f;
                    this.f2553a &= -9;
                } else {
                    m4112j();
                    this.f2557e.addAll(c0861co.f2545f);
                }
            }
            if (c0861co.m4095k()) {
                m4114a(c0861co.m4096l());
            }
            if (c0861co.m4097m()) {
                m4127d(c0861co.m4098n());
            }
            if (c0861co.m4099o()) {
                m4115a(c0861co.m4100p());
            }
            if (c0861co.m4101q()) {
                m4121b(c0861co.m4102r());
            }
            if (c0861co.m4103s()) {
                m4124c(c0861co.m4104t());
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
    public C0862cp mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2553a |= 1;
                    this.f2554b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f2553a |= 2;
                    this.f2555c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f2553a |= 4;
                    this.f2556d = codedInputStream.readBytes();
                    break;
                case 34:
                    C0868cv c0868cvNewBuilder = C0867cu.newBuilder();
                    codedInputStream.readMessage(c0868cvNewBuilder, extensionRegistryLite);
                    m4118a(c0868cvNewBuilder.buildPartial());
                    break;
                case 40:
                    this.f2553a |= 16;
                    this.f2558f = codedInputStream.readInt32();
                    break;
                case 50:
                    this.f2553a |= 32;
                    this.f2559g = codedInputStream.readBytes();
                    break;
                case 56:
                    this.f2553a |= 64;
                    this.f2560h = codedInputStream.readInt64();
                    break;
                case 64:
                    this.f2553a |= 128;
                    this.f2561i = codedInputStream.readInt64();
                    break;
                case 72:
                    this.f2553a |= 256;
                    this.f2562j = codedInputStream.readInt64();
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
    public C0862cp m4119a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2553a |= 1;
        this.f2554b = str;
        return this;
    }

    /* renamed from: b */
    public C0862cp m4122b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2553a |= 2;
        this.f2555c = str;
        return this;
    }

    /* renamed from: c */
    public C0862cp m4125c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2553a |= 4;
        this.f2556d = str;
        return this;
    }

    /* renamed from: j */
    private void m4112j() {
        if ((this.f2553a & 8) != 8) {
            this.f2557e = new ArrayList(this.f2557e);
            this.f2553a |= 8;
        }
    }

    /* renamed from: a */
    public C0862cp m4118a(C0867cu c0867cu) {
        if (c0867cu == null) {
            throw new NullPointerException();
        }
        m4112j();
        this.f2557e.add(c0867cu);
        return this;
    }

    /* renamed from: a */
    public C0862cp m4114a(int i) {
        this.f2553a |= 16;
        this.f2558f = i;
        return this;
    }

    /* renamed from: d */
    public C0862cp m4127d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2553a |= 32;
        this.f2559g = str;
        return this;
    }

    /* renamed from: a */
    public C0862cp m4115a(long j) {
        this.f2553a |= 64;
        this.f2560h = j;
        return this;
    }

    /* renamed from: b */
    public C0862cp m4121b(long j) {
        this.f2553a |= 128;
        this.f2561i = j;
        return this;
    }

    /* renamed from: c */
    public C0862cp m4124c(long j) {
        this.f2553a |= 256;
        this.f2562j = j;
        return this;
    }
}
