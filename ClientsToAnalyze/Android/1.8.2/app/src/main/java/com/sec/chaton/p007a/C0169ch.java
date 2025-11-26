package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import com.sec.chaton.C0229at;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ch */
/* loaded from: classes.dex */
public final class C0169ch extends GeneratedMessageLite.Builder implements InterfaceC0170ci {

    /* renamed from: a */
    private int f618a;

    /* renamed from: b */
    private long f619b;

    /* renamed from: c */
    private LazyStringList f620c = LazyStringArrayList.EMPTY;

    private C0169ch() {
        m1443i();
    }

    /* renamed from: i */
    private void m1443i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0169ch m1444j() {
        return new C0169ch();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0169ch clear() {
        super.clear();
        this.f619b = 0L;
        this.f618a &= -2;
        this.f620c = LazyStringArrayList.EMPTY;
        this.f618a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0169ch mo7542clone() {
        return m1444j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0168cg getDefaultInstanceForType() {
        return C0168cg.m1430a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0168cg build() {
        C0168cg c0168cgBuildPartial = buildPartial();
        if (!c0168cgBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0168cgBuildPartial);
        }
        return c0168cgBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0168cg m1445k() throws InvalidProtocolBufferException {
        C0168cg c0168cgBuildPartial = buildPartial();
        if (!c0168cgBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0168cgBuildPartial).asInvalidProtocolBufferException();
        }
        return c0168cgBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0168cg buildPartial() {
        C0168cg c0168cg = new C0168cg(this);
        int i = (this.f618a & 1) != 1 ? 0 : 1;
        c0168cg.f614c = this.f619b;
        if ((this.f618a & 2) == 2) {
            this.f620c = new UnmodifiableLazyStringList(this.f620c);
            this.f618a &= -3;
        }
        c0168cg.f615d = this.f620c;
        c0168cg.f613b = i;
        return c0168cg;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0169ch mergeFrom(C0168cg c0168cg) {
        if (c0168cg != C0168cg.m1430a()) {
            if (c0168cg.m1436c()) {
                m1448a(c0168cg.m1437d());
            }
            if (!c0168cg.f615d.isEmpty()) {
                if (this.f620c.isEmpty()) {
                    this.f620c = c0168cg.f615d;
                    this.f618a &= -3;
                } else {
                    m1446l();
                    this.f620c.addAll(c0168cg.f615d);
                }
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
    public C0169ch mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f618a |= 1;
                    this.f619b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    m1446l();
                    this.f620c.add(codedInputStream.readBytes());
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

    /* renamed from: f */
    public long m1456f() {
        return this.f619b;
    }

    /* renamed from: a */
    public C0169ch m1448a(long j) {
        this.f618a |= 1;
        this.f619b = j;
        return this;
    }

    /* renamed from: l */
    private void m1446l() {
        if ((this.f618a & 2) != 2) {
            this.f620c = new LazyStringArrayList(this.f620c);
            this.f618a |= 2;
        }
    }

    /* renamed from: g */
    public List m1457g() {
        return Collections.unmodifiableList(this.f620c);
    }

    /* renamed from: a */
    public C0169ch m1451a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m1446l();
        this.f620c.add((LazyStringList) str);
        return this;
    }
}
