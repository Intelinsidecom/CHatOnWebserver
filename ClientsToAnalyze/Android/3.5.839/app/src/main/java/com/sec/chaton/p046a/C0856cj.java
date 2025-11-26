package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cj */
/* loaded from: classes.dex */
public final class C0856cj extends GeneratedMessageLite.Builder<C0855ci, C0856cj> implements InterfaceC0857ck {

    /* renamed from: a */
    private int f2515a;

    /* renamed from: b */
    private Object f2516b = "";

    /* renamed from: c */
    private Object f2517c = "";

    /* renamed from: d */
    private Object f2518d = "";

    /* renamed from: e */
    private C0867cu f2519e = C0867cu.m4191a();

    /* renamed from: f */
    private long f2520f;

    /* renamed from: g */
    private long f2521g;

    /* renamed from: h */
    private long f2522h;

    private C0856cj() {
        m3997i();
    }

    /* renamed from: i */
    private void m3997i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0856cj m3998j() {
        return new C0856cj();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0856cj clear() {
        super.clear();
        this.f2516b = "";
        this.f2515a &= -2;
        this.f2517c = "";
        this.f2515a &= -3;
        this.f2518d = "";
        this.f2515a &= -5;
        this.f2519e = C0867cu.m4191a();
        this.f2515a &= -9;
        this.f2520f = 0L;
        this.f2515a &= -17;
        this.f2521g = 0L;
        this.f2515a &= -33;
        this.f2522h = 0L;
        this.f2515a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0856cj mo19949clone() {
        return m3998j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0855ci getDefaultInstanceForType() {
        return C0855ci.m3965a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0855ci build() {
        C0855ci c0855ciBuildPartial = buildPartial();
        if (!c0855ciBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0855ciBuildPartial);
        }
        return c0855ciBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0855ci m3999k() throws InvalidProtocolBufferException {
        C0855ci c0855ciBuildPartial = buildPartial();
        if (!c0855ciBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0855ciBuildPartial).asInvalidProtocolBufferException();
        }
        return c0855ciBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0855ci buildPartial() {
        C0855ci c0855ci = new C0855ci(this);
        int i = this.f2515a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0855ci.f2506c = this.f2516b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0855ci.f2507d = this.f2517c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0855ci.f2508e = this.f2518d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0855ci.f2509f = this.f2519e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0855ci.f2510g = this.f2520f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0855ci.f2511h = this.f2521g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0855ci.f2512i = this.f2522h;
        c0855ci.f2505b = i2;
        return c0855ci;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0856cj mergeFrom(C0855ci c0855ci) {
        if (c0855ci != C0855ci.m3965a()) {
            if (c0855ci.m3979c()) {
                m4005a(c0855ci.m3980d());
            }
            if (c0855ci.m3981e()) {
                m4009b(c0855ci.m3982f());
            }
            if (c0855ci.m3983g()) {
                m4012c(c0855ci.m3984h());
            }
            if (c0855ci.m3985i()) {
                m4008b(c0855ci.m3986j());
            }
            if (c0855ci.m3987k()) {
                m4001a(c0855ci.m3988l());
            }
            if (c0855ci.m3989m()) {
                m4007b(c0855ci.m3990n());
            }
            if (c0855ci.m3991o()) {
                m4011c(c0855ci.m3992p());
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
    public C0856cj mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2515a |= 1;
                    this.f2516b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f2515a |= 2;
                    this.f2517c = codedInputStream.readBytes();
                    break;
                case 26:
                    this.f2515a |= 4;
                    this.f2518d = codedInputStream.readBytes();
                    break;
                case 34:
                    C0868cv c0868cvNewBuilder = C0867cu.newBuilder();
                    if (m4015f()) {
                        c0868cvNewBuilder.mergeFrom(m4016g());
                    }
                    codedInputStream.readMessage(c0868cvNewBuilder, extensionRegistryLite);
                    m4004a(c0868cvNewBuilder.buildPartial());
                    break;
                case 40:
                    this.f2515a |= 16;
                    this.f2520f = codedInputStream.readInt64();
                    break;
                case 48:
                    this.f2515a |= 32;
                    this.f2521g = codedInputStream.readInt64();
                    break;
                case 56:
                    this.f2515a |= 64;
                    this.f2522h = codedInputStream.readInt64();
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
    public C0856cj m4005a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2515a |= 1;
        this.f2516b = str;
        return this;
    }

    /* renamed from: b */
    public C0856cj m4009b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2515a |= 2;
        this.f2517c = str;
        return this;
    }

    /* renamed from: c */
    public C0856cj m4012c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2515a |= 4;
        this.f2518d = str;
        return this;
    }

    /* renamed from: f */
    public boolean m4015f() {
        return (this.f2515a & 8) == 8;
    }

    /* renamed from: g */
    public C0867cu m4016g() {
        return this.f2519e;
    }

    /* renamed from: a */
    public C0856cj m4004a(C0867cu c0867cu) {
        if (c0867cu == null) {
            throw new NullPointerException();
        }
        this.f2519e = c0867cu;
        this.f2515a |= 8;
        return this;
    }

    /* renamed from: b */
    public C0856cj m4008b(C0867cu c0867cu) {
        if ((this.f2515a & 8) == 8 && this.f2519e != C0867cu.m4191a()) {
            this.f2519e = C0867cu.m4192a(this.f2519e).mergeFrom(c0867cu).buildPartial();
        } else {
            this.f2519e = c0867cu;
        }
        this.f2515a |= 8;
        return this;
    }

    /* renamed from: a */
    public C0856cj m4001a(long j) {
        this.f2515a |= 16;
        this.f2520f = j;
        return this;
    }

    /* renamed from: b */
    public C0856cj m4007b(long j) {
        this.f2515a |= 32;
        this.f2521g = j;
        return this;
    }

    /* renamed from: c */
    public C0856cj m4011c(long j) {
        this.f2515a |= 64;
        this.f2522h = j;
        return this;
    }
}
