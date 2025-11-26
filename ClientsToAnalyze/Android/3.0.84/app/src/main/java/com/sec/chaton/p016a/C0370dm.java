package com.sec.chaton.p016a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.dm */
/* loaded from: classes.dex */
public final class C0370dm extends GeneratedMessageLite.Builder<C0369dl, C0370dm> implements InterfaceC0371dn {

    /* renamed from: a */
    private int f1286a;

    /* renamed from: b */
    private int f1287b;

    /* renamed from: c */
    private Object f1288c = "";

    /* renamed from: d */
    private C0388ed f1289d = C0388ed.m2718a();

    /* renamed from: e */
    private C0366di f1290e = C0366di.m2462a();

    private C0370dm() {
        m2504k();
    }

    /* renamed from: k */
    private void m2504k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0370dm m2505l() {
        return new C0370dm();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0370dm clear() {
        super.clear();
        this.f1287b = 0;
        this.f1286a &= -2;
        this.f1288c = "";
        this.f1286a &= -3;
        this.f1289d = C0388ed.m2718a();
        this.f1286a &= -5;
        this.f1290e = C0366di.m2462a();
        this.f1286a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0370dm mo13386clone() {
        return m2505l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0369dl getDefaultInstanceForType() {
        return C0369dl.m2485a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0369dl build() {
        C0369dl c0369dlBuildPartial = buildPartial();
        if (!c0369dlBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0369dlBuildPartial);
        }
        return c0369dlBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0369dl buildPartial() {
        C0369dl c0369dl = new C0369dl(this);
        int i = this.f1286a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0369dl.f1280c = this.f1287b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0369dl.f1281d = this.f1288c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0369dl.f1282e = this.f1289d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0369dl.f1283f = this.f1290e;
        c0369dl.f1279b = i2;
        return c0369dl;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0370dm mergeFrom(C0369dl c0369dl) {
        if (c0369dl != C0369dl.m2485a()) {
            if (c0369dl.m2493c()) {
                m2507a(c0369dl.m2494d());
            }
            if (c0369dl.m2495e()) {
                m2512a(c0369dl.m2496f());
            }
            if (c0369dl.m2497g()) {
                m2515b(c0369dl.m2498h());
            }
            if (c0369dl.m2499i()) {
                m2514b(c0369dl.m2500j());
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
    public C0370dm mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1286a |= 1;
                    this.f1287b = codedInputStream.readInt32();
                    break;
                case 18:
                    this.f1286a |= 2;
                    this.f1288c = codedInputStream.readBytes();
                    break;
                case 26:
                    C0389ee c0389eeNewBuilder = C0388ed.newBuilder();
                    if (m2519f()) {
                        c0389eeNewBuilder.mergeFrom(m2520g());
                    }
                    codedInputStream.readMessage(c0389eeNewBuilder, extensionRegistryLite);
                    m2511a(c0389eeNewBuilder.buildPartial());
                    break;
                case 34:
                    C0367dj c0367djNewBuilder = C0366di.newBuilder();
                    if (m2521h()) {
                        c0367djNewBuilder.mergeFrom(m2522i());
                    }
                    codedInputStream.readMessage(c0367djNewBuilder, extensionRegistryLite);
                    m2509a(c0367djNewBuilder.buildPartial());
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
    public C0370dm m2507a(int i) {
        this.f1286a |= 1;
        this.f1287b = i;
        return this;
    }

    /* renamed from: a */
    public C0370dm m2512a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1286a |= 2;
        this.f1288c = str;
        return this;
    }

    /* renamed from: f */
    public boolean m2519f() {
        return (this.f1286a & 4) == 4;
    }

    /* renamed from: g */
    public C0388ed m2520g() {
        return this.f1289d;
    }

    /* renamed from: a */
    public C0370dm m2511a(C0388ed c0388ed) {
        if (c0388ed == null) {
            throw new NullPointerException();
        }
        this.f1289d = c0388ed;
        this.f1286a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0370dm m2515b(C0388ed c0388ed) {
        if ((this.f1286a & 4) == 4 && this.f1289d != C0388ed.m2718a()) {
            this.f1289d = C0388ed.m2719a(this.f1289d).mergeFrom(c0388ed).buildPartial();
        } else {
            this.f1289d = c0388ed;
        }
        this.f1286a |= 4;
        return this;
    }

    /* renamed from: h */
    public boolean m2521h() {
        return (this.f1286a & 8) == 8;
    }

    /* renamed from: i */
    public C0366di m2522i() {
        return this.f1290e;
    }

    /* renamed from: a */
    public C0370dm m2509a(C0366di c0366di) {
        if (c0366di == null) {
            throw new NullPointerException();
        }
        this.f1290e = c0366di;
        this.f1286a |= 8;
        return this;
    }

    /* renamed from: b */
    public C0370dm m2514b(C0366di c0366di) {
        if ((this.f1286a & 8) == 8 && this.f1290e != C0366di.m2462a()) {
            this.f1290e = C0366di.m2463a(this.f1290e).mergeFrom(c0366di).buildPartial();
        } else {
            this.f1290e = c0366di;
        }
        this.f1286a |= 8;
        return this;
    }
}
