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
/* renamed from: com.sec.chaton.a.ce */
/* loaded from: classes.dex */
public final class C0166ce extends GeneratedMessageLite.Builder implements InterfaceC0167cf {

    /* renamed from: a */
    private int f608a;

    /* renamed from: b */
    private long f609b;

    /* renamed from: c */
    private List f610c = Collections.emptyList();

    /* renamed from: d */
    private C0171cj f611d = C0171cj.m1459a();

    private C0166ce() {
        m1410i();
    }

    /* renamed from: i */
    private void m1410i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0166ce m1411j() {
        return new C0166ce();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0166ce clear() {
        super.clear();
        this.f609b = 0L;
        this.f608a &= -2;
        this.f610c = Collections.emptyList();
        this.f608a &= -3;
        this.f611d = C0171cj.m1459a();
        this.f608a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0166ce mo7542clone() {
        return m1411j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0165cd getDefaultInstanceForType() {
        return C0165cd.m1392a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0165cd build() {
        C0165cd c0165cdBuildPartial = buildPartial();
        if (!c0165cdBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0165cdBuildPartial);
        }
        return c0165cdBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0165cd m1412k() throws InvalidProtocolBufferException {
        C0165cd c0165cdBuildPartial = buildPartial();
        if (!c0165cdBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0165cdBuildPartial).asInvalidProtocolBufferException();
        }
        return c0165cdBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0165cd buildPartial() {
        C0165cd c0165cd = new C0165cd(this);
        int i = this.f608a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0165cd.f603c = this.f609b;
        if ((this.f608a & 2) == 2) {
            this.f610c = Collections.unmodifiableList(this.f610c);
            this.f608a &= -3;
        }
        c0165cd.f604d = this.f610c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0165cd.f605e = this.f611d;
        c0165cd.f602b = i2;
        return c0165cd;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0166ce mergeFrom(C0165cd c0165cd) {
        if (c0165cd != C0165cd.m1392a()) {
            if (c0165cd.m1401c()) {
                m1415a(c0165cd.m1402d());
            }
            if (!c0165cd.f604d.isEmpty()) {
                if (this.f610c.isEmpty()) {
                    this.f610c = c0165cd.f604d;
                    this.f608a &= -3;
                } else {
                    m1413l();
                    this.f610c.addAll(c0165cd.f604d);
                }
            }
            if (c0165cd.m1404f()) {
                m1421b(c0165cd.m1405g());
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
    public C0166ce mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f608a |= 1;
                    this.f609b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    MessageLite.Builder builderNewBuilder = C0162ca.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m1417a(builderNewBuilder.buildPartial());
                    break;
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    C0172ck c0172ckNewBuilder = C0171cj.newBuilder();
                    if (m1425f()) {
                        c0172ckNewBuilder.mergeFrom(m1426g());
                    }
                    codedInputStream.readMessage(c0172ckNewBuilder, extensionRegistryLite);
                    m1419a(c0172ckNewBuilder.buildPartial());
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
    public C0166ce m1415a(long j) {
        this.f608a |= 1;
        this.f609b = j;
        return this;
    }

    /* renamed from: l */
    private void m1413l() {
        if ((this.f608a & 2) != 2) {
            this.f610c = new ArrayList(this.f610c);
            this.f608a |= 2;
        }
    }

    /* renamed from: a */
    public C0166ce m1417a(C0162ca c0162ca) {
        if (c0162ca == null) {
            throw new NullPointerException();
        }
        m1413l();
        this.f610c.add(c0162ca);
        return this;
    }

    /* renamed from: f */
    public boolean m1425f() {
        return (this.f608a & 4) == 4;
    }

    /* renamed from: g */
    public C0171cj m1426g() {
        return this.f611d;
    }

    /* renamed from: a */
    public C0166ce m1419a(C0171cj c0171cj) {
        if (c0171cj == null) {
            throw new NullPointerException();
        }
        this.f611d = c0171cj;
        this.f608a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0166ce m1421b(C0171cj c0171cj) {
        if ((this.f608a & 4) == 4 && this.f611d != C0171cj.m1459a()) {
            this.f611d = C0171cj.m1460a(this.f611d).mergeFrom(c0171cj).buildPartial();
        } else {
            this.f611d = c0171cj;
        }
        this.f608a |= 4;
        return this;
    }
}
