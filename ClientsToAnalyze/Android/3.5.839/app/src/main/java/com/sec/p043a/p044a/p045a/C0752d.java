package com.sec.p043a.p044a.p045a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.d */
/* loaded from: classes.dex */
public final class C0752d extends GeneratedMessageLite.Builder<C0751c, C0752d> implements InterfaceC0753e {

    /* renamed from: a */
    private int f1772a;

    /* renamed from: b */
    private int f1773b;

    /* renamed from: c */
    private int f1774c;

    /* renamed from: d */
    private Object f1775d = "";

    /* renamed from: e */
    private Object f1776e = "";

    private C0752d() {
        m2554g();
    }

    /* renamed from: g */
    private void m2554g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0752d m2555h() {
        return new C0752d();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0752d clear() {
        super.clear();
        this.f1773b = 0;
        this.f1772a &= -2;
        this.f1774c = 0;
        this.f1772a &= -3;
        this.f1775d = "";
        this.f1772a &= -5;
        this.f1776e = "";
        this.f1772a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0752d mo19949clone() {
        return m2555h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0751c getDefaultInstanceForType() {
        return C0751c.m2531a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0751c build() {
        C0751c c0751cBuildPartial = buildPartial();
        if (!c0751cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0751cBuildPartial);
        }
        return c0751cBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0751c m2556i() throws InvalidProtocolBufferException {
        C0751c c0751cBuildPartial = buildPartial();
        if (!c0751cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0751cBuildPartial).asInvalidProtocolBufferException();
        }
        return c0751cBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0751c buildPartial() {
        C0751c c0751c = new C0751c(this);
        int i = this.f1772a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0751c.f1766c = this.f1773b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0751c.f1767d = this.f1774c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0751c.f1768e = this.f1775d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0751c.f1769f = this.f1776e;
        c0751c.f1765b = i2;
        return c0751c;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0752d mergeFrom(C0751c c0751c) {
        if (c0751c != C0751c.m2531a()) {
            if (c0751c.m2542c()) {
                m2558a(c0751c.m2543d());
            }
            if (c0751c.m2544e()) {
                m2563b(c0751c.m2545f());
            }
            if (c0751c.m2546g()) {
                m2561a(c0751c.m2547h());
            }
            if (c0751c.m2548i()) {
                m2564b(c0751c.m2549j());
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
    public C0752d mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f1772a |= 1;
                    this.f1773b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f1772a |= 2;
                    this.f1774c = codedInputStream.readInt32();
                    break;
                case 26:
                    this.f1772a |= 4;
                    this.f1775d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f1772a |= 8;
                    this.f1776e = codedInputStream.readBytes();
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
    public C0752d m2558a(int i) {
        this.f1772a |= 1;
        this.f1773b = i;
        return this;
    }

    /* renamed from: b */
    public C0752d m2563b(int i) {
        this.f1772a |= 2;
        this.f1774c = i;
        return this;
    }

    /* renamed from: a */
    public C0752d m2561a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1772a |= 4;
        this.f1775d = str;
        return this;
    }

    /* renamed from: b */
    public C0752d m2564b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1772a |= 8;
        this.f1776e = str;
        return this;
    }
}
