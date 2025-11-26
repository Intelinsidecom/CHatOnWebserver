package com.sec.chaton.p046a;

import android.hardware.motion.MotionRecognitionManager;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.ff */
/* loaded from: classes.dex */
public final class C0933ff extends GeneratedMessageLite.Builder<C0932fe, C0933ff> implements InterfaceC0934fg {

    /* renamed from: a */
    private int f2939a;

    /* renamed from: b */
    private long f2940b;

    /* renamed from: d */
    private long f2942d;

    /* renamed from: i */
    private long f2947i;

    /* renamed from: j */
    private long f2948j;

    /* renamed from: k */
    private boolean f2949k;

    /* renamed from: c */
    private Object f2941c = "";

    /* renamed from: e */
    private Object f2943e = "";

    /* renamed from: f */
    private Object f2944f = "";

    /* renamed from: g */
    private List<C0867cu> f2945g = Collections.emptyList();

    /* renamed from: h */
    private C0846c f2946h = C0846c.m3819a();

    private C0933ff() {
        m5184i();
    }

    /* renamed from: i */
    private void m5184i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static C0933ff m5185j() {
        return new C0933ff();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0933ff clear() {
        super.clear();
        this.f2940b = 0L;
        this.f2939a &= -2;
        this.f2941c = "";
        this.f2939a &= -3;
        this.f2942d = 0L;
        this.f2939a &= -5;
        this.f2943e = "";
        this.f2939a &= -9;
        this.f2944f = "";
        this.f2939a &= -17;
        this.f2945g = Collections.emptyList();
        this.f2939a &= -33;
        this.f2946h = C0846c.m3819a();
        this.f2939a &= -65;
        this.f2947i = 0L;
        this.f2939a &= -129;
        this.f2948j = 0L;
        this.f2939a &= -257;
        this.f2949k = false;
        this.f2939a &= -513;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0933ff mo19949clone() {
        return m5185j().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0932fe getDefaultInstanceForType() {
        return C0932fe.m5144a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0932fe build() {
        C0932fe c0932feBuildPartial = buildPartial();
        if (!c0932feBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0932feBuildPartial);
        }
        return c0932feBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public C0932fe m5186k() throws InvalidProtocolBufferException {
        C0932fe c0932feBuildPartial = buildPartial();
        if (!c0932feBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0932feBuildPartial).asInvalidProtocolBufferException();
        }
        return c0932feBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0932fe buildPartial() {
        C0932fe c0932fe = new C0932fe(this);
        int i = this.f2939a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0932fe.f2927c = this.f2940b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0932fe.f2928d = this.f2941c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0932fe.f2929e = this.f2942d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0932fe.f2930f = this.f2943e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0932fe.f2931g = this.f2944f;
        if ((this.f2939a & 32) == 32) {
            this.f2945g = Collections.unmodifiableList(this.f2945g);
            this.f2939a &= -33;
        }
        c0932fe.f2932h = this.f2945g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0932fe.f2933i = this.f2946h;
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        c0932fe.f2934j = this.f2947i;
        if ((i & 256) == 256) {
            i2 |= 128;
        }
        c0932fe.f2935k = this.f2948j;
        if ((i & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            i2 |= 256;
        }
        c0932fe.f2936l = this.f2949k;
        c0932fe.f2926b = i2;
        return c0932fe;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0933ff mergeFrom(C0932fe c0932fe) {
        if (c0932fe != C0932fe.m5144a()) {
            if (c0932fe.m5160c()) {
                m5189a(c0932fe.m5161d());
            }
            if (c0932fe.m5162e()) {
                m5194a(c0932fe.m5163f());
            }
            if (c0932fe.m5164g()) {
                m5197b(c0932fe.m5165h());
            }
            if (c0932fe.m5166i()) {
                m5199b(c0932fe.m5167j());
            }
            if (c0932fe.m5168k()) {
                m5202c(c0932fe.m5169l());
            }
            if (!c0932fe.f2932h.isEmpty()) {
                if (this.f2945g.isEmpty()) {
                    this.f2945g = c0932fe.f2932h;
                    this.f2939a &= -33;
                } else {
                    m5187l();
                    this.f2945g.addAll(c0932fe.f2932h);
                }
            }
            if (c0932fe.m5172o()) {
                m5198b(c0932fe.m5173p());
            }
            if (c0932fe.m5174q()) {
                m5201c(c0932fe.m5175r());
            }
            if (c0932fe.m5176s()) {
                m5204d(c0932fe.m5177t());
            }
            if (c0932fe.m5178u()) {
                m5195a(c0932fe.m5179v());
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
    public C0933ff mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2939a |= 1;
                    this.f2940b = codedInputStream.readInt64();
                    break;
                case 18:
                    this.f2939a |= 2;
                    this.f2941c = codedInputStream.readBytes();
                    break;
                case 24:
                    this.f2939a |= 4;
                    this.f2942d = codedInputStream.readInt64();
                    break;
                case 34:
                    this.f2939a |= 8;
                    this.f2943e = codedInputStream.readBytes();
                    break;
                case 42:
                    this.f2939a |= 16;
                    this.f2944f = codedInputStream.readBytes();
                    break;
                case 50:
                    MessageLite.Builder builderNewBuilder = C0867cu.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m5192a(builderNewBuilder.buildPartial());
                    break;
                case 58:
                    C0873d c0873dNewBuilder = C0846c.newBuilder();
                    if (m5206f()) {
                        c0873dNewBuilder.mergeFrom(m5207g());
                    }
                    codedInputStream.readMessage(c0873dNewBuilder, extensionRegistryLite);
                    m5191a(c0873dNewBuilder.buildPartial());
                    break;
                case 64:
                    this.f2939a |= 128;
                    this.f2947i = codedInputStream.readInt64();
                    break;
                case 72:
                    this.f2939a |= 256;
                    this.f2948j = codedInputStream.readInt64();
                    break;
                case 80:
                    this.f2939a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
                    this.f2949k = codedInputStream.readBool();
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
    public C0933ff m5189a(long j) {
        this.f2939a |= 1;
        this.f2940b = j;
        return this;
    }

    /* renamed from: a */
    public C0933ff m5194a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2939a |= 2;
        this.f2941c = str;
        return this;
    }

    /* renamed from: b */
    public C0933ff m5197b(long j) {
        this.f2939a |= 4;
        this.f2942d = j;
        return this;
    }

    /* renamed from: b */
    public C0933ff m5199b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2939a |= 8;
        this.f2943e = str;
        return this;
    }

    /* renamed from: c */
    public C0933ff m5202c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2939a |= 16;
        this.f2944f = str;
        return this;
    }

    /* renamed from: l */
    private void m5187l() {
        if ((this.f2939a & 32) != 32) {
            this.f2945g = new ArrayList(this.f2945g);
            this.f2939a |= 32;
        }
    }

    /* renamed from: a */
    public C0933ff m5192a(C0867cu c0867cu) {
        if (c0867cu == null) {
            throw new NullPointerException();
        }
        m5187l();
        this.f2945g.add(c0867cu);
        return this;
    }

    /* renamed from: f */
    public boolean m5206f() {
        return (this.f2939a & 64) == 64;
    }

    /* renamed from: g */
    public C0846c m5207g() {
        return this.f2946h;
    }

    /* renamed from: a */
    public C0933ff m5191a(C0846c c0846c) {
        if (c0846c == null) {
            throw new NullPointerException();
        }
        this.f2946h = c0846c;
        this.f2939a |= 64;
        return this;
    }

    /* renamed from: b */
    public C0933ff m5198b(C0846c c0846c) {
        if ((this.f2939a & 64) == 64 && this.f2946h != C0846c.m3819a()) {
            this.f2946h = C0846c.m3820a(this.f2946h).mergeFrom(c0846c).buildPartial();
        } else {
            this.f2946h = c0846c;
        }
        this.f2939a |= 64;
        return this;
    }

    /* renamed from: c */
    public C0933ff m5201c(long j) {
        this.f2939a |= 128;
        this.f2947i = j;
        return this;
    }

    /* renamed from: d */
    public C0933ff m5204d(long j) {
        this.f2939a |= 256;
        this.f2948j = j;
        return this;
    }

    /* renamed from: a */
    public C0933ff m5195a(boolean z) {
        this.f2939a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        this.f2949k = z;
        return this;
    }
}
