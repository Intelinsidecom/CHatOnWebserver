package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.chaton.C0229at;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.bn */
/* loaded from: classes.dex */
public final class C0148bn extends GeneratedMessageLite.Builder implements InterfaceC0149bo {

    /* renamed from: a */
    private int f522a;

    /* renamed from: b */
    private long f523b;

    /* renamed from: d */
    private long f525d;

    /* renamed from: c */
    private Object f524c = "";

    /* renamed from: e */
    private C0174cm f526e = C0174cm.m1485a();

    /* renamed from: f */
    private C0171cj f527f = C0171cj.m1459a();

    private C0148bn() {
        m1170k();
    }

    /* renamed from: k */
    private void m1170k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0148bn m1171l() {
        return new C0148bn();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0148bn clear() {
        super.clear();
        this.f523b = 0L;
        this.f522a &= -2;
        this.f524c = "";
        this.f522a &= -3;
        this.f525d = 0L;
        this.f522a &= -5;
        this.f526e = C0174cm.m1485a();
        this.f522a &= -9;
        this.f527f = C0171cj.m1459a();
        this.f522a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0148bn mo7542clone() {
        return m1171l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0147bm getDefaultInstanceForType() {
        return C0147bm.m1146a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0147bm build() {
        C0147bm c0147bmBuildPartial = buildPartial();
        if (!c0147bmBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0147bmBuildPartial);
        }
        return c0147bmBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0147bm m1172m() throws InvalidProtocolBufferException {
        C0147bm c0147bmBuildPartial = buildPartial();
        if (!c0147bmBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0147bmBuildPartial).asInvalidProtocolBufferException();
        }
        return c0147bmBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0147bm buildPartial() {
        C0147bm c0147bm = new C0147bm(this);
        int i = this.f522a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0147bm.f515c = this.f523b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0147bm.f516d = this.f524c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0147bm.f517e = this.f525d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0147bm.f518f = this.f526e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0147bm.f519g = this.f527f;
        c0147bm.f514b = i2;
        return c0147bm;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0148bn mergeFrom(C0147bm c0147bm) {
        if (c0147bm != C0147bm.m1146a()) {
            if (c0147bm.m1156c()) {
                m1174a(c0147bm.m1157d());
            }
            if (c0147bm.m1158e()) {
                m1179a(c0147bm.m1159f());
            }
            if (c0147bm.m1160g()) {
                m1181b(c0147bm.m1161h());
            }
            if (c0147bm.m1162i()) {
                m1183b(c0147bm.m1163j());
            }
            if (c0147bm.m1164k()) {
                m1182b(c0147bm.m1165l());
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
    public C0148bn mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f522a |= 1;
                    this.f523b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    this.f522a |= 2;
                    this.f524c = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_fadingEdgeLength /* 24 */:
                    this.f522a |= 4;
                    this.f525d = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    C0175cn c0175cnNewBuilder = C0174cm.newBuilder();
                    if (m1187f()) {
                        c0175cnNewBuilder.mergeFrom(m1188g());
                    }
                    codedInputStream.readMessage(c0175cnNewBuilder, extensionRegistryLite);
                    m1178a(c0175cnNewBuilder.buildPartial());
                    break;
                case C0229at.HorizontalSrollView_android_scrollbarFadeDuration /* 42 */:
                    C0172ck c0172ckNewBuilder = C0171cj.newBuilder();
                    if (m1189h()) {
                        c0172ckNewBuilder.mergeFrom(m1190i());
                    }
                    codedInputStream.readMessage(c0172ckNewBuilder, extensionRegistryLite);
                    m1177a(c0172ckNewBuilder.buildPartial());
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
    public C0148bn m1174a(long j) {
        this.f522a |= 1;
        this.f523b = j;
        return this;
    }

    /* renamed from: a */
    public C0148bn m1179a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f522a |= 2;
        this.f524c = str;
        return this;
    }

    /* renamed from: b */
    public C0148bn m1181b(long j) {
        this.f522a |= 4;
        this.f525d = j;
        return this;
    }

    /* renamed from: f */
    public boolean m1187f() {
        return (this.f522a & 8) == 8;
    }

    /* renamed from: g */
    public C0174cm m1188g() {
        return this.f526e;
    }

    /* renamed from: a */
    public C0148bn m1178a(C0174cm c0174cm) {
        if (c0174cm == null) {
            throw new NullPointerException();
        }
        this.f526e = c0174cm;
        this.f522a |= 8;
        return this;
    }

    /* renamed from: b */
    public C0148bn m1183b(C0174cm c0174cm) {
        if ((this.f522a & 8) == 8 && this.f526e != C0174cm.m1485a()) {
            this.f526e = C0174cm.m1486a(this.f526e).mergeFrom(c0174cm).buildPartial();
        } else {
            this.f526e = c0174cm;
        }
        this.f522a |= 8;
        return this;
    }

    /* renamed from: h */
    public boolean m1189h() {
        return (this.f522a & 16) == 16;
    }

    /* renamed from: i */
    public C0171cj m1190i() {
        return this.f527f;
    }

    /* renamed from: a */
    public C0148bn m1177a(C0171cj c0171cj) {
        if (c0171cj == null) {
            throw new NullPointerException();
        }
        this.f527f = c0171cj;
        this.f522a |= 16;
        return this;
    }

    /* renamed from: b */
    public C0148bn m1182b(C0171cj c0171cj) {
        if ((this.f522a & 16) == 16 && this.f527f != C0171cj.m1459a()) {
            this.f527f = C0171cj.m1460a(this.f527f).mergeFrom(c0171cj).buildPartial();
        } else {
            this.f527f = c0171cj;
        }
        this.f522a |= 16;
        return this;
    }
}
