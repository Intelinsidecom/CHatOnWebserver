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
/* renamed from: com.sec.chaton.a.s */
/* loaded from: classes.dex */
public final class C0404s extends GeneratedMessageLite.Builder<C0403r, C0404s> implements InterfaceC0405t {

    /* renamed from: a */
    private int f1435a;

    /* renamed from: b */
    private Object f1436b = "";

    /* renamed from: c */
    private List<C0406u> f1437c = Collections.emptyList();

    /* renamed from: d */
    private C0369dl f1438d = C0369dl.m2485a();

    private C0404s() {
        m2944k();
    }

    /* renamed from: k */
    private void m2944k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0404s m2945l() {
        return new C0404s();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0404s clear() {
        super.clear();
        this.f1436b = "";
        this.f1435a &= -2;
        this.f1437c = Collections.emptyList();
        this.f1435a &= -3;
        this.f1438d = C0369dl.m2485a();
        this.f1435a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0404s mo13386clone() {
        return m2945l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0403r getDefaultInstanceForType() {
        return C0403r.m2927a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0403r build() {
        C0403r c0403rBuildPartial = buildPartial();
        if (!c0403rBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0403rBuildPartial);
        }
        return c0403rBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0403r m2946m() throws InvalidProtocolBufferException {
        C0403r c0403rBuildPartial = buildPartial();
        if (!c0403rBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0403rBuildPartial).asInvalidProtocolBufferException();
        }
        return c0403rBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0403r buildPartial() {
        C0403r c0403r = new C0403r(this);
        int i = this.f1435a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0403r.f1430c = this.f1436b;
        if ((this.f1435a & 2) == 2) {
            this.f1437c = Collections.unmodifiableList(this.f1437c);
            this.f1435a &= -3;
        }
        c0403r.f1431d = this.f1437c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0403r.f1432e = this.f1438d;
        c0403r.f1429b = i2;
        return c0403r;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0404s mergeFrom(C0403r c0403r) {
        if (c0403r != C0403r.m2927a()) {
            if (c0403r.m2936c()) {
                m2953a(c0403r.m2937d());
            }
            if (!c0403r.f1431d.isEmpty()) {
                if (this.f1437c.isEmpty()) {
                    this.f1437c = c0403r.f1431d;
                    this.f1435a &= -3;
                } else {
                    m2947n();
                    this.f1437c.addAll(c0403r.f1431d);
                }
            }
            if (c0403r.m2938e()) {
                m2956b(c0403r.m2939f());
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
    public C0404s mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f1435a |= 1;
                    this.f1436b = codedInputStream.readBytes();
                    break;
                case 18:
                    MessageLite.Builder builderNewBuilder = C0406u.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m2952a(builderNewBuilder.buildPartial());
                    break;
                case 26:
                    C0370dm c0370dmNewBuilder = C0369dl.newBuilder();
                    if (m2962h()) {
                        c0370dmNewBuilder.mergeFrom(m2963i());
                    }
                    codedInputStream.readMessage(c0370dmNewBuilder, extensionRegistryLite);
                    m2950a(c0370dmNewBuilder.buildPartial());
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
    public C0404s m2953a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1435a |= 1;
        this.f1436b = str;
        return this;
    }

    /* renamed from: n */
    private void m2947n() {
        if ((this.f1435a & 2) != 2) {
            this.f1437c = new ArrayList(this.f1437c);
            this.f1435a |= 2;
        }
    }

    /* renamed from: f */
    public List<C0406u> m2960f() {
        return Collections.unmodifiableList(this.f1437c);
    }

    /* renamed from: g */
    public int m2961g() {
        return this.f1437c.size();
    }

    /* renamed from: a */
    public C0406u m2954a(int i) {
        return this.f1437c.get(i);
    }

    /* renamed from: a */
    public C0404s m2952a(C0406u c0406u) {
        if (c0406u == null) {
            throw new NullPointerException();
        }
        m2947n();
        this.f1437c.add(c0406u);
        return this;
    }

    /* renamed from: h */
    public boolean m2962h() {
        return (this.f1435a & 4) == 4;
    }

    /* renamed from: i */
    public C0369dl m2963i() {
        return this.f1438d;
    }

    /* renamed from: a */
    public C0404s m2950a(C0369dl c0369dl) {
        if (c0369dl == null) {
            throw new NullPointerException();
        }
        this.f1438d = c0369dl;
        this.f1435a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0404s m2956b(C0369dl c0369dl) {
        if ((this.f1435a & 4) == 4 && this.f1438d != C0369dl.m2485a()) {
            this.f1438d = C0369dl.m2486a(this.f1438d).mergeFrom(c0369dl).buildPartial();
        } else {
            this.f1438d = c0369dl;
        }
        this.f1435a |= 4;
        return this;
    }
}
