package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.sec.chaton.C0229at;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.s */
/* loaded from: classes.dex */
public final class C0192s extends GeneratedMessageLite.Builder implements InterfaceC0193t {

    /* renamed from: a */
    private int f700a;

    /* renamed from: b */
    private Object f701b = "";

    /* renamed from: c */
    private List f702c = Collections.emptyList();

    /* renamed from: d */
    private C0171cj f703d = C0171cj.m1459a();

    private C0192s() {
        m1713k();
    }

    /* renamed from: k */
    private void m1713k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0192s m1714l() {
        return new C0192s();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0192s clear() {
        super.clear();
        this.f701b = "";
        this.f700a &= -2;
        this.f702c = Collections.emptyList();
        this.f700a &= -3;
        this.f703d = C0171cj.m1459a();
        this.f700a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0192s mo7542clone() {
        return m1714l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0191r getDefaultInstanceForType() {
        return C0191r.m1696a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0191r build() {
        C0191r c0191rBuildPartial = buildPartial();
        if (!c0191rBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0191rBuildPartial);
        }
        return c0191rBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0191r m1715m() throws InvalidProtocolBufferException {
        C0191r c0191rBuildPartial = buildPartial();
        if (!c0191rBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0191rBuildPartial).asInvalidProtocolBufferException();
        }
        return c0191rBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0191r buildPartial() {
        C0191r c0191r = new C0191r(this);
        int i = this.f700a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0191r.f695c = this.f701b;
        if ((this.f700a & 2) == 2) {
            this.f702c = Collections.unmodifiableList(this.f702c);
            this.f700a &= -3;
        }
        c0191r.f696d = this.f702c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0191r.f697e = this.f703d;
        c0191r.f694b = i2;
        return c0191r;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0192s mergeFrom(C0191r c0191r) {
        if (c0191r != C0191r.m1696a()) {
            if (c0191r.m1705c()) {
                m1722a(c0191r.m1706d());
            }
            if (!c0191r.f696d.isEmpty()) {
                if (this.f702c.isEmpty()) {
                    this.f702c = c0191r.f696d;
                    this.f700a &= -3;
                } else {
                    m1716n();
                    this.f702c.addAll(c0191r.f696d);
                }
            }
            if (c0191r.m1707e()) {
                m1725b(c0191r.m1708f());
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
    public C0192s mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f700a |= 1;
                    this.f701b = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    MessageLite.Builder builderNewBuilder = C0194u.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m1721a(builderNewBuilder.buildPartial());
                    break;
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    C0172ck c0172ckNewBuilder = C0171cj.newBuilder();
                    if (m1731h()) {
                        c0172ckNewBuilder.mergeFrom(m1732i());
                    }
                    codedInputStream.readMessage(c0172ckNewBuilder, extensionRegistryLite);
                    m1719a(c0172ckNewBuilder.buildPartial());
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
    public C0192s m1722a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f700a |= 1;
        this.f701b = str;
        return this;
    }

    /* renamed from: n */
    private void m1716n() {
        if ((this.f700a & 2) != 2) {
            this.f702c = new ArrayList(this.f702c);
            this.f700a |= 2;
        }
    }

    /* renamed from: f */
    public List m1729f() {
        return Collections.unmodifiableList(this.f702c);
    }

    /* renamed from: g */
    public int m1730g() {
        return this.f702c.size();
    }

    /* renamed from: a */
    public C0194u m1723a(int i) {
        return (C0194u) this.f702c.get(i);
    }

    /* renamed from: a */
    public C0192s m1721a(C0194u c0194u) {
        if (c0194u == null) {
            throw new NullPointerException();
        }
        m1716n();
        this.f702c.add(c0194u);
        return this;
    }

    /* renamed from: h */
    public boolean m1731h() {
        return (this.f700a & 4) == 4;
    }

    /* renamed from: i */
    public C0171cj m1732i() {
        return this.f703d;
    }

    /* renamed from: a */
    public C0192s m1719a(C0171cj c0171cj) {
        if (c0171cj == null) {
            throw new NullPointerException();
        }
        this.f703d = c0171cj;
        this.f700a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0192s m1725b(C0171cj c0171cj) {
        if ((this.f700a & 4) == 4 && this.f703d != C0171cj.m1459a()) {
            this.f703d = C0171cj.m1460a(this.f703d).mergeFrom(c0171cj).buildPartial();
        } else {
            this.f703d = c0171cj;
        }
        this.f700a |= 4;
        return this;
    }
}
