package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fr */
/* loaded from: classes.dex */
public final class C0945fr extends GeneratedMessageLite.Builder<C0944fq, C0945fr> implements InterfaceC0946fs {

    /* renamed from: a */
    private int f3004a;

    /* renamed from: b */
    private long f3005b;

    /* renamed from: c */
    private Object f3006c = "";

    /* renamed from: d */
    private List<C0953fz> f3007d = Collections.emptyList();

    /* renamed from: e */
    private C0957gc f3008e = C0957gc.m5553a();

    /* renamed from: f */
    private long f3009f;

    private C0945fr() {
        m5364i();
    }

    /* renamed from: i */
    private void m5364i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0945fr m5365j() {
        return new C0945fr();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0945fr clear() {
        super.clear();
        this.f3005b = 0L;
        this.f3004a &= -2;
        this.f3006c = "";
        this.f3004a &= -3;
        this.f3007d = Collections.emptyList();
        this.f3004a &= -5;
        this.f3008e = C0957gc.m5553a();
        this.f3004a &= -9;
        this.f3009f = 0L;
        this.f3004a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0945fr mo19949clone() {
        return m5365j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0944fq getDefaultInstanceForType() {
        return C0944fq.m5340a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0944fq build() {
        C0944fq c0944fqBuildPartial = buildPartial();
        if (!c0944fqBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0944fqBuildPartial);
        }
        return c0944fqBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0944fq m5366k() throws InvalidProtocolBufferException {
        C0944fq c0944fqBuildPartial = buildPartial();
        if (!c0944fqBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0944fqBuildPartial).asInvalidProtocolBufferException();
        }
        return c0944fqBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0944fq buildPartial() {
        C0944fq c0944fq = new C0944fq(this);
        int i = this.f3004a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0944fq.f2997c = this.f3005b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0944fq.f2998d = this.f3006c;
        if ((this.f3004a & 4) == 4) {
            this.f3007d = Collections.unmodifiableList(this.f3007d);
            this.f3004a &= -5;
        }
        c0944fq.f2999e = this.f3007d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0944fq.f3000f = this.f3008e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0944fq.f3001g = this.f3009f;
        c0944fq.f2996b = i2;
        return c0944fq;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0945fr mergeFrom(C0944fq c0944fq) {
        if (c0944fq != C0944fq.m5340a()) {
            if (c0944fq.m5351c()) {
                m5369a(c0944fq.m5352d());
            }
            if (c0944fq.m5353e()) {
                m5374a(c0944fq.m5354f());
            }
            if (!c0944fq.f2999e.isEmpty()) {
                if (this.f3007d.isEmpty()) {
                    this.f3007d = c0944fq.f2999e;
                    this.f3004a &= -5;
                } else {
                    m5367l();
                    this.f3007d.addAll(c0944fq.f2999e);
                }
            }
            if (c0944fq.m5356h()) {
                m5377b(c0944fq.m5357i());
            }
            if (c0944fq.m5358j()) {
                m5376b(c0944fq.m5359k());
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
    public C0945fr mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f3004a |= 1;
                    this.f3005b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f3004a |= 2;
                    this.f3006c = codedInputStream.readBytes();
                    break;
                case 26:
                    MessageLite.Builder builderNewBuilder = C0953fz.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m5372a(builderNewBuilder.buildPartial());
                    break;
                case 34:
                    C0958gd c0958gdNewBuilder = C0957gc.newBuilder();
                    if (m5381f()) {
                        c0958gdNewBuilder.mergeFrom(m5382g());
                    }
                    codedInputStream.readMessage(c0958gdNewBuilder, extensionRegistryLite);
                    m5373a(c0958gdNewBuilder.buildPartial());
                    break;
                case 40:
                    this.f3004a |= 16;
                    this.f3009f = codedInputStream.readInt64();
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
    public C0945fr m5369a(long j) {
        this.f3004a |= 1;
        this.f3005b = j;
        return this;
    }

    /* renamed from: a */
    public C0945fr m5374a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3004a |= 2;
        this.f3006c = str;
        return this;
    }

    /* renamed from: l */
    private void m5367l() {
        if ((this.f3004a & 4) != 4) {
            this.f3007d = new ArrayList(this.f3007d);
            this.f3004a |= 4;
        }
    }

    /* renamed from: a */
    public C0945fr m5372a(C0953fz c0953fz) {
        if (c0953fz == null) {
            throw new NullPointerException();
        }
        m5367l();
        this.f3007d.add(c0953fz);
        return this;
    }

    /* renamed from: f */
    public boolean m5381f() {
        return (this.f3004a & 8) == 8;
    }

    /* renamed from: g */
    public C0957gc m5382g() {
        return this.f3008e;
    }

    /* renamed from: a */
    public C0945fr m5373a(C0957gc c0957gc) {
        if (c0957gc == null) {
            throw new NullPointerException();
        }
        this.f3008e = c0957gc;
        this.f3004a |= 8;
        return this;
    }

    /* renamed from: b */
    public C0945fr m5377b(C0957gc c0957gc) {
        if ((this.f3004a & 8) == 8 && this.f3008e != C0957gc.m5553a()) {
            this.f3008e = C0957gc.m5554a(this.f3008e).mergeFrom(c0957gc).buildPartial();
        } else {
            this.f3008e = c0957gc;
        }
        this.f3004a |= 8;
        return this;
    }

    /* renamed from: b */
    public C0945fr m5376b(long j) {
        this.f3004a |= 16;
        this.f3009f = j;
        return this;
    }
}
