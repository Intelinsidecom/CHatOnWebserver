package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.d */
/* loaded from: classes.dex */
public final class C0177d extends GeneratedMessageLite.Builder implements InterfaceC0178e {

    /* renamed from: a */
    private int f639a;

    /* renamed from: b */
    private long f640b;

    /* renamed from: c */
    private C0171cj f641c = C0171cj.m1459a();

    private C0177d() {
        m1512i();
    }

    /* renamed from: i */
    private void m1512i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0177d m1513j() {
        return new C0177d();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0177d clear() {
        super.clear();
        this.f640b = 0L;
        this.f639a &= -2;
        this.f641c = C0171cj.m1459a();
        this.f639a &= -3;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0177d mo7542clone() {
        return m1513j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0161c getDefaultInstanceForType() {
        return C0161c.m1351a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0161c build() {
        C0161c c0161cBuildPartial = buildPartial();
        if (!c0161cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0161cBuildPartial);
        }
        return c0161cBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0161c m1514k() throws InvalidProtocolBufferException {
        C0161c c0161cBuildPartial = buildPartial();
        if (!c0161cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0161cBuildPartial).asInvalidProtocolBufferException();
        }
        return c0161cBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0161c buildPartial() {
        C0161c c0161c = new C0161c(this);
        int i = this.f639a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0161c.f588c = this.f640b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0161c.f589d = this.f641c;
        c0161c.f587b = i2;
        return c0161c;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0177d mergeFrom(C0161c c0161c) {
        if (c0161c != C0161c.m1351a()) {
            if (c0161c.m1357c()) {
                m1516a(c0161c.m1358d());
            }
            if (c0161c.m1359e()) {
                m1521b(c0161c.m1360f());
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
    public C0177d mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f639a |= 1;
                    this.f640b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    C0172ck c0172ckNewBuilder = C0171cj.newBuilder();
                    if (m1525f()) {
                        c0172ckNewBuilder.mergeFrom(m1526g());
                    }
                    codedInputStream.readMessage(c0172ckNewBuilder, extensionRegistryLite);
                    m1519a(c0172ckNewBuilder.buildPartial());
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
    public C0177d m1516a(long j) {
        this.f639a |= 1;
        this.f640b = j;
        return this;
    }

    /* renamed from: f */
    public boolean m1525f() {
        return (this.f639a & 2) == 2;
    }

    /* renamed from: g */
    public C0171cj m1526g() {
        return this.f641c;
    }

    /* renamed from: a */
    public C0177d m1519a(C0171cj c0171cj) {
        if (c0171cj == null) {
            throw new NullPointerException();
        }
        this.f641c = c0171cj;
        this.f639a |= 2;
        return this;
    }

    /* renamed from: b */
    public C0177d m1521b(C0171cj c0171cj) {
        if ((this.f639a & 2) == 2 && this.f641c != C0171cj.m1459a()) {
            this.f641c = C0171cj.m1460a(this.f641c).mergeFrom(c0171cj).buildPartial();
        } else {
            this.f641c = c0171cj;
        }
        this.f639a |= 2;
        return this;
    }
}
