package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.u */
/* loaded from: classes.dex */
public final class C0347u extends GeneratedMessageLite.Builder implements InterfaceC0302bo {

    /* renamed from: a */
    private int f996a;

    /* renamed from: b */
    private long f997b;

    /* renamed from: e */
    private long f1000e;

    /* renamed from: c */
    private Object f998c = "";

    /* renamed from: d */
    private C0308bu f999d = C0308bu.m1552a();

    /* renamed from: f */
    private C0313bz f1001f = C0313bz.m1619a();

    private C0347u() {
        m1975k();
    }

    /* renamed from: k */
    private void m1975k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0347u m1976l() {
        return new C0347u();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0347u clear() {
        super.clear();
        this.f997b = 0L;
        this.f996a &= -2;
        this.f998c = "";
        this.f996a &= -3;
        this.f999d = C0308bu.m1552a();
        this.f996a &= -5;
        this.f1000e = 0L;
        this.f996a &= -9;
        this.f1001f = C0313bz.m1619a();
        this.f996a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0347u mo5946clone() {
        return m1976l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0283aw getDefaultInstanceForType() {
        return C0283aw.m1240a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0283aw build() {
        C0283aw c0283awBuildPartial = buildPartial();
        if (!c0283awBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0283awBuildPartial);
        }
        return c0283awBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0283aw m1977m() throws InvalidProtocolBufferException {
        C0283aw c0283awBuildPartial = buildPartial();
        if (!c0283awBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0283awBuildPartial).asInvalidProtocolBufferException();
        }
        return c0283awBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0283aw buildPartial() {
        C0283aw c0283aw = new C0283aw(this);
        int i = this.f996a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0283aw.f745c = this.f997b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0283aw.f746d = this.f998c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0283aw.f747e = this.f999d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0283aw.f748f = this.f1000e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0283aw.f749g = this.f1001f;
        c0283aw.f744b = i2;
        return c0283aw;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0347u mergeFrom(C0283aw c0283aw) {
        if (c0283aw != C0283aw.m1240a()) {
            if (c0283aw.m1250c()) {
                m1979a(c0283aw.m1251d());
            }
            if (c0283aw.m1252e()) {
                m1984a(c0283aw.m1253f());
            }
            if (c0283aw.m1254g()) {
                m1987b(c0283aw.m1255h());
            }
            if (c0283aw.m1256i()) {
                m1986b(c0283aw.m1257j());
            }
            if (c0283aw.m1258k()) {
                m1988b(c0283aw.m1259l());
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
    public C0347u mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f996a |= 1;
                    this.f997b = codedInputStream.readInt64();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    this.f996a |= 2;
                    this.f998c = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_RIGHT /* 26 */:
                    C0273am c0273amNewBuilder = C0308bu.newBuilder();
                    if (m1992f()) {
                        c0273amNewBuilder.mergeFrom(m1993g());
                    }
                    codedInputStream.readMessage(c0273amNewBuilder, extensionRegistryLite);
                    m1982a(c0273amNewBuilder.buildPartial());
                    break;
                case 32:
                    this.f996a |= 8;
                    this.f1000e = codedInputStream.readInt64();
                    break;
                case MREvent.BT_SHARING_SEND_START /* 42 */:
                    C0312by c0312byNewBuilder = C0313bz.newBuilder();
                    if (m1994h()) {
                        c0312byNewBuilder.mergeFrom(m1995i());
                    }
                    codedInputStream.readMessage(c0312byNewBuilder, extensionRegistryLite);
                    m1983a(c0312byNewBuilder.buildPartial());
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
    public C0347u m1979a(long j) {
        this.f996a |= 1;
        this.f997b = j;
        return this;
    }

    /* renamed from: a */
    public C0347u m1984a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f996a |= 2;
        this.f998c = str;
        return this;
    }

    /* renamed from: f */
    public boolean m1992f() {
        return (this.f996a & 4) == 4;
    }

    /* renamed from: g */
    public C0308bu m1993g() {
        return this.f999d;
    }

    /* renamed from: a */
    public C0347u m1982a(C0308bu c0308bu) {
        if (c0308bu == null) {
            throw new NullPointerException();
        }
        this.f999d = c0308bu;
        this.f996a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0347u m1987b(C0308bu c0308bu) {
        if ((this.f996a & 4) == 4 && this.f999d != C0308bu.m1552a()) {
            this.f999d = C0308bu.m1551a(this.f999d).mergeFrom(c0308bu).buildPartial();
        } else {
            this.f999d = c0308bu;
        }
        this.f996a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0347u m1986b(long j) {
        this.f996a |= 8;
        this.f1000e = j;
        return this;
    }

    /* renamed from: h */
    public boolean m1994h() {
        return (this.f996a & 16) == 16;
    }

    /* renamed from: i */
    public C0313bz m1995i() {
        return this.f1001f;
    }

    /* renamed from: a */
    public C0347u m1983a(C0313bz c0313bz) {
        if (c0313bz == null) {
            throw new NullPointerException();
        }
        this.f1001f = c0313bz;
        this.f996a |= 16;
        return this;
    }

    /* renamed from: b */
    public C0347u m1988b(C0313bz c0313bz) {
        if ((this.f996a & 16) == 16 && this.f1001f != C0313bz.m1619a()) {
            this.f1001f = C0313bz.m1618a(this.f1001f).mergeFrom(c0313bz).buildPartial();
        } else {
            this.f1001f = c0313bz;
        }
        this.f996a |= 16;
        return this;
    }
}
