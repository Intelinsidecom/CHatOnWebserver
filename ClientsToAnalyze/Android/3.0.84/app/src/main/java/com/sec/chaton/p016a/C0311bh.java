package com.sec.chaton.p016a;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bh */
/* loaded from: classes.dex */
public final class C0311bh extends GeneratedMessageLite.Builder<C0310bg, C0311bh> implements InterfaceC0315bl {

    /* renamed from: a */
    private int f1033a;

    /* renamed from: e */
    private int f1037e;

    /* renamed from: f */
    private long f1038f;

    /* renamed from: b */
    private Object f1034b = "";

    /* renamed from: c */
    private List<C0312bi> f1035c = Collections.emptyList();

    /* renamed from: d */
    private C0369dl f1036d = C0369dl.m2485a();

    /* renamed from: g */
    private Object f1039g = "";

    private C0311bh() {
        m1790l();
    }

    /* renamed from: l */
    private void m1790l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static C0311bh m1791m() {
        return new C0311bh();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0311bh clear() {
        super.clear();
        this.f1034b = "";
        this.f1033a &= -2;
        this.f1035c = Collections.emptyList();
        this.f1033a &= -3;
        this.f1036d = C0369dl.m2485a();
        this.f1033a &= -5;
        this.f1037e = 0;
        this.f1033a &= -9;
        this.f1038f = 0L;
        this.f1033a &= -17;
        this.f1039g = "";
        this.f1033a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0311bh mo13386clone() {
        return m1791m().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0310bg getDefaultInstanceForType() {
        return C0310bg.m1760a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0310bg build() {
        C0310bg c0310bgBuildPartial = buildPartial();
        if (!c0310bgBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0310bgBuildPartial);
        }
        return c0310bgBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public C0310bg m1792n() throws InvalidProtocolBufferException {
        C0310bg c0310bgBuildPartial = buildPartial();
        if (!c0310bgBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0310bgBuildPartial).asInvalidProtocolBufferException();
        }
        return c0310bgBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0310bg buildPartial() {
        C0310bg c0310bg = new C0310bg(this);
        int i = this.f1033a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0310bg.f1025c = this.f1034b;
        if ((this.f1033a & 2) == 2) {
            this.f1035c = Collections.unmodifiableList(this.f1035c);
            this.f1033a &= -3;
        }
        c0310bg.f1026d = this.f1035c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0310bg.f1027e = this.f1036d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0310bg.f1028f = this.f1037e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0310bg.f1029g = this.f1038f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0310bg.f1030h = this.f1039g;
        c0310bg.f1024b = i2;
        return c0310bg;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0311bh mergeFrom(C0310bg c0310bg) {
        if (c0310bg != C0310bg.m1760a()) {
            if (c0310bg.m1774c()) {
                m1800a(c0310bg.m1775d());
            }
            if (!c0310bg.f1026d.isEmpty()) {
                if (this.f1035c.isEmpty()) {
                    this.f1035c = c0310bg.f1026d;
                    this.f1033a &= -3;
                } else {
                    m1793o();
                    this.f1035c.addAll(c0310bg.f1026d);
                }
            }
            if (c0310bg.m1778g()) {
                m1804b(c0310bg.m1779h());
            }
            if (c0310bg.m1780i()) {
                m1803b(c0310bg.m1781j());
            }
            if (c0310bg.m1782k()) {
                m1795a(c0310bg.m1783l());
            }
            if (c0310bg.m1784m()) {
                m1805b(c0310bg.m1785n());
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
    public C0311bh mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f1033a |= 1;
                    this.f1034b = codedInputStream.readBytes();
                    break;
                case 18:
                    MessageLite.Builder builderNewBuilder = C0312bi.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m1798a(builderNewBuilder.buildPartial());
                    break;
                case 26:
                    C0370dm c0370dmNewBuilder = C0369dl.newBuilder();
                    if (m1811h()) {
                        c0370dmNewBuilder.mergeFrom(m1812i());
                    }
                    codedInputStream.readMessage(c0370dmNewBuilder, extensionRegistryLite);
                    m1799a(c0370dmNewBuilder.buildPartial());
                    break;
                case 32:
                    this.f1033a |= 8;
                    this.f1037e = codedInputStream.readInt32();
                    break;
                case 40:
                    this.f1033a |= 16;
                    this.f1038f = codedInputStream.readInt64();
                    break;
                case 50:
                    this.f1033a |= 32;
                    this.f1039g = codedInputStream.readBytes();
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
    public C0311bh m1800a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1033a |= 1;
        this.f1034b = str;
        return this;
    }

    /* renamed from: o */
    private void m1793o() {
        if ((this.f1033a & 2) != 2) {
            this.f1035c = new ArrayList(this.f1035c);
            this.f1033a |= 2;
        }
    }

    /* renamed from: f */
    public List<C0312bi> m1809f() {
        return Collections.unmodifiableList(this.f1035c);
    }

    /* renamed from: g */
    public int m1810g() {
        return this.f1035c.size();
    }

    /* renamed from: a */
    public C0312bi m1801a(int i) {
        return this.f1035c.get(i);
    }

    /* renamed from: a */
    public C0311bh m1798a(C0312bi c0312bi) {
        if (c0312bi == null) {
            throw new NullPointerException();
        }
        m1793o();
        this.f1035c.add(c0312bi);
        return this;
    }

    /* renamed from: h */
    public boolean m1811h() {
        return (this.f1033a & 4) == 4;
    }

    /* renamed from: i */
    public C0369dl m1812i() {
        return this.f1036d;
    }

    /* renamed from: a */
    public C0311bh m1799a(C0369dl c0369dl) {
        if (c0369dl == null) {
            throw new NullPointerException();
        }
        this.f1036d = c0369dl;
        this.f1033a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0311bh m1804b(C0369dl c0369dl) {
        if ((this.f1033a & 4) == 4 && this.f1036d != C0369dl.m2485a()) {
            this.f1036d = C0369dl.m2486a(this.f1036d).mergeFrom(c0369dl).buildPartial();
        } else {
            this.f1036d = c0369dl;
        }
        this.f1033a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0311bh m1803b(int i) {
        this.f1033a |= 8;
        this.f1037e = i;
        return this;
    }

    /* renamed from: a */
    public C0311bh m1795a(long j) {
        this.f1033a |= 16;
        this.f1038f = j;
        return this;
    }

    /* renamed from: j */
    public String m1813j() {
        Object obj = this.f1039g;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f1039g = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: b */
    public C0311bh m1805b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1033a |= 32;
        this.f1039g = str;
        return this;
    }
}
