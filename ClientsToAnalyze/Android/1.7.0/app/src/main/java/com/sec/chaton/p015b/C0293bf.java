package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.bf */
/* loaded from: classes.dex */
public final class C0293bf extends GeneratedMessageLite.Builder implements InterfaceC0350x {

    /* renamed from: a */
    private int f769a;

    /* renamed from: b */
    private long f770b;

    /* renamed from: c */
    private List f771c = Collections.emptyList();

    /* renamed from: d */
    private C0313bz f772d = C0313bz.m1619a();

    private C0293bf() {
        m1299i();
    }

    /* renamed from: i */
    private void m1299i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0293bf m1300j() {
        return new C0293bf();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0293bf clear() {
        super.clear();
        this.f770b = 0L;
        this.f769a &= -2;
        this.f771c = Collections.emptyList();
        this.f769a &= -3;
        this.f772d = C0313bz.m1619a();
        this.f769a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0293bf mo5946clone() {
        return m1300j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0301bn getDefaultInstanceForType() {
        return C0301bn.m1432a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0301bn build() {
        C0301bn c0301bnBuildPartial = buildPartial();
        if (!c0301bnBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0301bnBuildPartial);
        }
        return c0301bnBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0301bn m1301k() throws InvalidProtocolBufferException {
        C0301bn c0301bnBuildPartial = buildPartial();
        if (!c0301bnBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0301bnBuildPartial).asInvalidProtocolBufferException();
        }
        return c0301bnBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0301bn buildPartial() {
        C0301bn c0301bn = new C0301bn(this);
        int i = this.f769a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0301bn.f815c = this.f770b;
        if ((this.f769a & 2) == 2) {
            this.f771c = Collections.unmodifiableList(this.f771c);
            this.f769a &= -3;
        }
        c0301bn.f816d = this.f771c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0301bn.f817e = this.f772d;
        c0301bn.f814b = i2;
        return c0301bn;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0293bf mergeFrom(C0301bn c0301bn) {
        if (c0301bn != C0301bn.m1432a()) {
            if (c0301bn.m1439c()) {
                m1304a(c0301bn.m1440d());
            }
            if (!c0301bn.f816d.isEmpty()) {
                if (this.f771c.isEmpty()) {
                    this.f771c = c0301bn.f816d;
                    this.f769a &= -3;
                } else {
                    m1302l();
                    this.f771c.addAll(c0301bn.f816d);
                }
            }
            if (c0301bn.m1441e()) {
                m1310b(c0301bn.m1442f());
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
    public C0293bf mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f769a |= 1;
                    this.f770b = codedInputStream.readInt64();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    MessageLite.Builder builderNewBuilder = C0261aa.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m1306a(builderNewBuilder.buildPartial());
                    break;
                case MREvent.TILT_RIGHT /* 26 */:
                    C0312by c0312byNewBuilder = C0313bz.newBuilder();
                    if (m1314f()) {
                        c0312byNewBuilder.mergeFrom(m1315g());
                    }
                    codedInputStream.readMessage(c0312byNewBuilder, extensionRegistryLite);
                    m1308a(c0312byNewBuilder.buildPartial());
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
    public C0293bf m1304a(long j) {
        this.f769a |= 1;
        this.f770b = j;
        return this;
    }

    /* renamed from: l */
    private void m1302l() {
        if ((this.f769a & 2) != 2) {
            this.f771c = new ArrayList(this.f771c);
            this.f769a |= 2;
        }
    }

    /* renamed from: a */
    public C0293bf m1306a(C0261aa c0261aa) {
        if (c0261aa == null) {
            throw new NullPointerException();
        }
        m1302l();
        this.f771c.add(c0261aa);
        return this;
    }

    /* renamed from: f */
    public boolean m1314f() {
        return (this.f769a & 4) == 4;
    }

    /* renamed from: g */
    public C0313bz m1315g() {
        return this.f772d;
    }

    /* renamed from: a */
    public C0293bf m1308a(C0313bz c0313bz) {
        if (c0313bz == null) {
            throw new NullPointerException();
        }
        this.f772d = c0313bz;
        this.f769a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0293bf m1310b(C0313bz c0313bz) {
        if ((this.f769a & 4) == 4 && this.f772d != C0313bz.m1619a()) {
            this.f772d = C0313bz.m1618a(this.f772d).mergeFrom(c0313bz).buildPartial();
        } else {
            this.f772d = c0313bz;
        }
        this.f769a |= 4;
        return this;
    }
}
