package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cm */
/* loaded from: classes.dex */
public final class C0859cm extends GeneratedMessageLite.Builder<C0858cl, C0859cm> implements InterfaceC0860cn {

    /* renamed from: a */
    private int f2533a;

    /* renamed from: d */
    private boolean f2536d;

    /* renamed from: f */
    private long f2538f;

    /* renamed from: g */
    private long f2539g;

    /* renamed from: b */
    private Object f2534b = "";

    /* renamed from: c */
    private List<C0864cr> f2535c = Collections.emptyList();

    /* renamed from: e */
    private Object f2537e = "";

    private C0859cm() {
        m4049g();
    }

    /* renamed from: g */
    private void m4049g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0859cm m4050h() {
        return new C0859cm();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0859cm clear() {
        super.clear();
        this.f2534b = "";
        this.f2533a &= -2;
        this.f2535c = Collections.emptyList();
        this.f2533a &= -3;
        this.f2536d = false;
        this.f2533a &= -5;
        this.f2537e = "";
        this.f2533a &= -9;
        this.f2538f = 0L;
        this.f2533a &= -17;
        this.f2539g = 0L;
        this.f2533a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0859cm mo19949clone() {
        return m4050h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0858cl getDefaultInstanceForType() {
        return C0858cl.m4019a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0858cl build() {
        C0858cl c0858clBuildPartial = buildPartial();
        if (!c0858clBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0858clBuildPartial);
        }
        return c0858clBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0858cl m4051i() throws InvalidProtocolBufferException {
        C0858cl c0858clBuildPartial = buildPartial();
        if (!c0858clBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0858clBuildPartial).asInvalidProtocolBufferException();
        }
        return c0858clBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0858cl buildPartial() {
        C0858cl c0858cl = new C0858cl(this);
        int i = this.f2533a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0858cl.f2525c = this.f2534b;
        if ((this.f2533a & 2) == 2) {
            this.f2535c = Collections.unmodifiableList(this.f2535c);
            this.f2533a &= -3;
        }
        c0858cl.f2526d = this.f2535c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0858cl.f2527e = this.f2536d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0858cl.f2528f = this.f2537e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0858cl.f2529g = this.f2538f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0858cl.f2530h = this.f2539g;
        c0858cl.f2524b = i2;
        return c0858cl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0859cm mergeFrom(C0858cl c0858cl) {
        if (c0858cl != C0858cl.m4019a()) {
            if (c0858cl.m4033c()) {
                m4058a(c0858cl.m4034d());
            }
            if (!c0858cl.f2526d.isEmpty()) {
                if (this.f2535c.isEmpty()) {
                    this.f2535c = c0858cl.f2526d;
                    this.f2533a &= -3;
                } else {
                    m4052j();
                    this.f2535c.addAll(c0858cl.f2526d);
                }
            }
            if (c0858cl.m4037g()) {
                m4059a(c0858cl.m4038h());
            }
            if (c0858cl.m4039i()) {
                m4062b(c0858cl.m4040j());
            }
            if (c0858cl.m4041k()) {
                m4054a(c0858cl.m4042l());
            }
            if (c0858cl.m4043m()) {
                m4061b(c0858cl.m4044n());
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
    public C0859cm mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2533a |= 1;
                    this.f2534b = codedInputStream.readBytes();
                    break;
                case 18:
                    C0865cs c0865csNewBuilder = C0864cr.newBuilder();
                    codedInputStream.readMessage(c0865csNewBuilder, extensionRegistryLite);
                    m4057a(c0865csNewBuilder.buildPartial());
                    break;
                case 24:
                    this.f2533a |= 4;
                    this.f2536d = codedInputStream.readBool();
                    break;
                case 34:
                    this.f2533a |= 8;
                    this.f2537e = codedInputStream.readBytes();
                    break;
                case 40:
                    this.f2533a |= 16;
                    this.f2538f = codedInputStream.readInt64();
                    break;
                case 48:
                    this.f2533a |= 32;
                    this.f2539g = codedInputStream.readInt64();
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
    public C0859cm m4058a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2533a |= 1;
        this.f2534b = str;
        return this;
    }

    /* renamed from: j */
    private void m4052j() {
        if ((this.f2533a & 2) != 2) {
            this.f2535c = new ArrayList(this.f2535c);
            this.f2533a |= 2;
        }
    }

    /* renamed from: a */
    public C0859cm m4057a(C0864cr c0864cr) {
        if (c0864cr == null) {
            throw new NullPointerException();
        }
        m4052j();
        this.f2535c.add(c0864cr);
        return this;
    }

    /* renamed from: a */
    public C0859cm m4059a(boolean z) {
        this.f2533a |= 4;
        this.f2536d = z;
        return this;
    }

    /* renamed from: b */
    public C0859cm m4062b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2533a |= 8;
        this.f2537e = str;
        return this;
    }

    /* renamed from: a */
    public C0859cm m4054a(long j) {
        this.f2533a |= 16;
        this.f2538f = j;
        return this;
    }

    /* renamed from: b */
    public C0859cm m4061b(long j) {
        this.f2533a |= 32;
        this.f2539g = j;
        return this;
    }
}
