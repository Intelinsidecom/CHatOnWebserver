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
/* renamed from: com.sec.chaton.b.cj */
/* loaded from: classes.dex */
public final class C0324cj extends GeneratedMessageLite.Builder implements InterfaceC0337k {

    /* renamed from: a */
    private int f918a;

    /* renamed from: b */
    private Object f919b = "";

    /* renamed from: c */
    private List f920c = Collections.emptyList();

    /* renamed from: d */
    private C0313bz f921d = C0313bz.m1619a();

    private C0324cj() {
        m1753k();
    }

    /* renamed from: k */
    private void m1753k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0324cj m1754l() {
        return new C0324cj();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0324cj clear() {
        super.clear();
        this.f919b = "";
        this.f918a &= -2;
        this.f920c = Collections.emptyList();
        this.f918a &= -3;
        this.f921d = C0313bz.m1619a();
        this.f918a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0324cj mo5946clone() {
        return m1754l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0315ca getDefaultInstanceForType() {
        return C0315ca.m1664a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0315ca build() {
        C0315ca c0315caBuildPartial = buildPartial();
        if (!c0315caBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0315caBuildPartial);
        }
        return c0315caBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0315ca m1755m() throws InvalidProtocolBufferException {
        C0315ca c0315caBuildPartial = buildPartial();
        if (!c0315caBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0315caBuildPartial).asInvalidProtocolBufferException();
        }
        return c0315caBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0315ca buildPartial() {
        C0315ca c0315ca = new C0315ca(this);
        int i = this.f918a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0315ca.f888c = this.f919b;
        if ((this.f918a & 2) == 2) {
            this.f920c = Collections.unmodifiableList(this.f920c);
            this.f918a &= -3;
        }
        c0315ca.f889d = this.f920c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0315ca.f890e = this.f921d;
        c0315ca.f887b = i2;
        return c0315ca;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0324cj mergeFrom(C0315ca c0315ca) {
        if (c0315ca != C0315ca.m1664a()) {
            if (c0315ca.m1674c()) {
                m1763a(c0315ca.m1675d());
            }
            if (!c0315ca.f889d.isEmpty()) {
                if (this.f920c.isEmpty()) {
                    this.f920c = c0315ca.f889d;
                    this.f918a &= -3;
                } else {
                    m1756n();
                    this.f920c.addAll(c0315ca.f889d);
                }
            }
            if (c0315ca.m1678g()) {
                m1765b(c0315ca.m1679h());
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
    public C0324cj mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f918a |= 1;
                    this.f919b = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    MessageLite.Builder builderNewBuilder = C0285ay.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m1760a(builderNewBuilder.buildPartial());
                    break;
                case MREvent.TILT_RIGHT /* 26 */:
                    C0312by c0312byNewBuilder = C0313bz.newBuilder();
                    if (m1771h()) {
                        c0312byNewBuilder.mergeFrom(m1772i());
                    }
                    codedInputStream.readMessage(c0312byNewBuilder, extensionRegistryLite);
                    m1761a(c0312byNewBuilder.buildPartial());
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
    public C0324cj m1763a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f918a |= 1;
        this.f919b = str;
        return this;
    }

    /* renamed from: n */
    private void m1756n() {
        if ((this.f918a & 2) != 2) {
            this.f920c = new ArrayList(this.f920c);
            this.f918a |= 2;
        }
    }

    /* renamed from: f */
    public List m1769f() {
        return Collections.unmodifiableList(this.f920c);
    }

    /* renamed from: g */
    public int m1770g() {
        return this.f920c.size();
    }

    /* renamed from: a */
    public C0285ay m1757a(int i) {
        return (C0285ay) this.f920c.get(i);
    }

    /* renamed from: a */
    public C0324cj m1760a(C0285ay c0285ay) {
        if (c0285ay == null) {
            throw new NullPointerException();
        }
        m1756n();
        this.f920c.add(c0285ay);
        return this;
    }

    /* renamed from: h */
    public boolean m1771h() {
        return (this.f918a & 4) == 4;
    }

    /* renamed from: i */
    public C0313bz m1772i() {
        return this.f921d;
    }

    /* renamed from: a */
    public C0324cj m1761a(C0313bz c0313bz) {
        if (c0313bz == null) {
            throw new NullPointerException();
        }
        this.f921d = c0313bz;
        this.f918a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0324cj m1765b(C0313bz c0313bz) {
        if ((this.f918a & 4) == 4 && this.f921d != C0313bz.m1619a()) {
            this.f921d = C0313bz.m1618a(this.f921d).mergeFrom(c0313bz).buildPartial();
        } else {
            this.f921d = c0313bz;
        }
        this.f918a |= 4;
        return this;
    }
}
