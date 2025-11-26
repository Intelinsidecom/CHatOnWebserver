package com.sec.p004a.p005a.p006a;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.ad */
/* loaded from: classes.dex */
public final class C0070ad extends GeneratedMessageLite.Builder implements InterfaceC0081ao {

    /* renamed from: a */
    private int f54a;

    /* renamed from: d */
    private int f57d;

    /* renamed from: e */
    private int f58e;

    /* renamed from: i */
    private long f62i;

    /* renamed from: j */
    private int f63j;

    /* renamed from: b */
    private Object f55b = "";

    /* renamed from: c */
    private Object f56c = "";

    /* renamed from: f */
    private Object f59f = "";

    /* renamed from: g */
    private Object f60g = "";

    /* renamed from: h */
    private Object f61h = "";

    /* renamed from: k */
    private Object f64k = "";

    private C0070ad() {
        m146g();
    }

    /* renamed from: g */
    private void m146g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0070ad m147h() {
        return new C0070ad();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0070ad clear() {
        super.clear();
        this.f55b = "";
        this.f54a &= -2;
        this.f56c = "";
        this.f54a &= -3;
        this.f57d = 0;
        this.f54a &= -5;
        this.f58e = 0;
        this.f54a &= -9;
        this.f59f = "";
        this.f54a &= -17;
        this.f60g = "";
        this.f54a &= -33;
        this.f61h = "";
        this.f54a &= -65;
        this.f62i = 0L;
        this.f54a &= -129;
        this.f63j = 0;
        this.f54a &= -257;
        this.f64k = "";
        this.f54a &= -513;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0070ad mo5946clone() {
        return m147h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0103v getDefaultInstanceForType() {
        return C0103v.m509a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0103v build() {
        C0103v c0103vBuildPartial = buildPartial();
        if (!c0103vBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0103vBuildPartial);
        }
        return c0103vBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0103v m148i() throws InvalidProtocolBufferException {
        C0103v c0103vBuildPartial = buildPartial();
        if (!c0103vBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0103vBuildPartial).asInvalidProtocolBufferException();
        }
        return c0103vBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0103v buildPartial() {
        C0103v c0103v = new C0103v(this);
        int i = this.f54a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0103v.f179c = this.f55b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0103v.f180d = this.f56c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0103v.f181e = this.f57d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0103v.f182f = this.f58e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0103v.f183g = this.f59f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0103v.f184h = this.f60g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0103v.f185i = this.f61h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        c0103v.f186j = this.f62i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        c0103v.f187k = this.f63j;
        if ((i & 512) == 512) {
            i2 |= 512;
        }
        c0103v.f188l = this.f64k;
        c0103v.f178b = i2;
        return c0103v;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0070ad mergeFrom(C0103v c0103v) {
        if (c0103v != C0103v.m509a()) {
            if (c0103v.m523c()) {
                m154a(c0103v.m524d());
            }
            if (c0103v.m525e()) {
                m157b(c0103v.m526f());
            }
            if (c0103v.m527g()) {
                m150a(c0103v.m528h());
            }
            if (c0103v.m529i()) {
                m156b(c0103v.m530j());
            }
            if (c0103v.m531k()) {
                m159c(c0103v.m532l());
            }
            if (c0103v.m533m()) {
                m161d(c0103v.m534n());
            }
            if (c0103v.m535o()) {
                m163e(c0103v.m536p());
            }
            if (c0103v.m537q()) {
                m151a(c0103v.m538r());
            }
            if (c0103v.m539s()) {
                m158c(c0103v.m540t());
            }
            if (c0103v.m541u()) {
                m165f(c0103v.m542v());
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
    public C0070ad mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f54a |= 1;
                    this.f55b = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    this.f54a |= 2;
                    this.f56c = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_FRONT_BACK_END /* 24 */:
                    this.f54a |= 4;
                    this.f57d = codedInputStream.readInt32();
                    break;
                case 32:
                    this.f54a |= 8;
                    this.f58e = codedInputStream.readInt32();
                    break;
                case MREvent.BT_SHARING_SEND_START /* 42 */:
                    this.f54a |= 16;
                    this.f59f = codedInputStream.readBytes();
                    break;
                case MREvent.SNAP1_Y_NEGATIVE /* 50 */:
                    this.f54a |= 32;
                    this.f60g = codedInputStream.readBytes();
                    break;
                case MREvent.SNAP2_Z_NEGATIVE /* 58 */:
                    this.f54a |= 64;
                    this.f61h = codedInputStream.readBytes();
                    break;
                case 88:
                    this.f54a |= 128;
                    this.f62i = codedInputStream.readInt64();
                    break;
                case 96:
                    this.f54a |= 256;
                    this.f63j = codedInputStream.readInt32();
                    break;
                case 106:
                    this.f54a |= 512;
                    this.f64k = codedInputStream.readBytes();
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
    public C0070ad m154a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f54a |= 1;
        this.f55b = str;
        return this;
    }

    /* renamed from: b */
    public C0070ad m157b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f54a |= 2;
        this.f56c = str;
        return this;
    }

    /* renamed from: a */
    public C0070ad m150a(int i) {
        this.f54a |= 4;
        this.f57d = i;
        return this;
    }

    /* renamed from: b */
    public C0070ad m156b(int i) {
        this.f54a |= 8;
        this.f58e = i;
        return this;
    }

    /* renamed from: c */
    public C0070ad m159c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f54a |= 16;
        this.f59f = str;
        return this;
    }

    /* renamed from: d */
    public C0070ad m161d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f54a |= 32;
        this.f60g = str;
        return this;
    }

    /* renamed from: e */
    public C0070ad m163e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f54a |= 64;
        this.f61h = str;
        return this;
    }

    /* renamed from: a */
    public C0070ad m151a(long j) {
        this.f54a |= 128;
        this.f62i = j;
        return this;
    }

    /* renamed from: c */
    public C0070ad m158c(int i) {
        this.f54a |= 256;
        this.f63j = i;
        return this;
    }

    /* renamed from: f */
    public C0070ad m165f(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f54a |= 512;
        this.f64k = str;
        return this;
    }
}
