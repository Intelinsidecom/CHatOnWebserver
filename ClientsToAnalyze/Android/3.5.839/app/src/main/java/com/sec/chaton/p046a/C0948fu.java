package com.sec.chaton.p046a;

import android.hardware.motion.MotionRecognitionManager;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fu */
/* loaded from: classes.dex */
public final class C0948fu extends GeneratedMessageLite.Builder<C0947ft, C0948fu> implements InterfaceC0949fv {

    /* renamed from: a */
    private int f3025a;

    /* renamed from: b */
    private long f3026b;

    /* renamed from: i */
    private long f3033i;

    /* renamed from: l */
    private long f3036l;

    /* renamed from: c */
    private EnumC0822bc f3027c = EnumC0822bc.SINGLE;

    /* renamed from: d */
    private Object f3028d = "";

    /* renamed from: e */
    private Object f3029e = "";

    /* renamed from: f */
    private LazyStringList f3030f = LazyStringArrayList.EMPTY;

    /* renamed from: g */
    private Object f3031g = "";

    /* renamed from: h */
    private Object f3032h = "";

    /* renamed from: j */
    private List<C0950fw> f3034j = Collections.emptyList();

    /* renamed from: k */
    private Object f3035k = "";

    private C0948fu() {
        m5431g();
    }

    /* renamed from: g */
    private void m5431g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0948fu m5432h() {
        return new C0948fu();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0948fu clear() {
        super.clear();
        this.f3026b = 0L;
        this.f3025a &= -2;
        this.f3027c = EnumC0822bc.SINGLE;
        this.f3025a &= -3;
        this.f3028d = "";
        this.f3025a &= -5;
        this.f3029e = "";
        this.f3025a &= -9;
        this.f3030f = LazyStringArrayList.EMPTY;
        this.f3025a &= -17;
        this.f3031g = "";
        this.f3025a &= -33;
        this.f3032h = "";
        this.f3025a &= -65;
        this.f3033i = 0L;
        this.f3025a &= -129;
        this.f3034j = Collections.emptyList();
        this.f3025a &= -257;
        this.f3035k = "";
        this.f3025a &= -513;
        this.f3036l = 0L;
        this.f3025a &= -1025;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0948fu mo19949clone() {
        return m5432h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0947ft getDefaultInstanceForType() {
        return C0947ft.m5391a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0947ft build() {
        C0947ft c0947ftBuildPartial = buildPartial();
        if (!c0947ftBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0947ftBuildPartial);
        }
        return c0947ftBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0947ft m5433i() throws InvalidProtocolBufferException {
        C0947ft c0947ftBuildPartial = buildPartial();
        if (!c0947ftBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0947ftBuildPartial).asInvalidProtocolBufferException();
        }
        return c0947ftBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0947ft buildPartial() {
        C0947ft c0947ft = new C0947ft(this);
        int i = this.f3025a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0947ft.f3012c = this.f3026b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0947ft.f3013d = this.f3027c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0947ft.f3014e = this.f3028d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0947ft.f3015f = this.f3029e;
        if ((this.f3025a & 16) == 16) {
            this.f3030f = new UnmodifiableLazyStringList(this.f3030f);
            this.f3025a &= -17;
        }
        c0947ft.f3016g = this.f3030f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0947ft.f3017h = this.f3031g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0947ft.f3018i = this.f3032h;
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        c0947ft.f3019j = this.f3033i;
        if ((this.f3025a & 256) == 256) {
            this.f3034j = Collections.unmodifiableList(this.f3034j);
            this.f3025a &= -257;
        }
        c0947ft.f3020k = this.f3034j;
        if ((i & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            i2 |= 128;
        }
        c0947ft.f3021l = this.f3035k;
        if ((i & 1024) == 1024) {
            i2 |= 256;
        }
        c0947ft.f3022m = this.f3036l;
        c0947ft.f3011b = i2;
        return c0947ft;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0948fu mergeFrom(C0947ft c0947ft) {
        if (c0947ft != C0947ft.m5391a()) {
            if (c0947ft.m5407c()) {
                m5437a(c0947ft.m5408d());
            }
            if (c0947ft.m5409e()) {
                m5439a(c0947ft.m5410f());
            }
            if (c0947ft.m5411g()) {
                m5443a(c0947ft.m5412h());
            }
            if (c0947ft.m5413i()) {
                m5446b(c0947ft.m5414j());
            }
            if (!c0947ft.f3016g.isEmpty()) {
                if (this.f3030f.isEmpty()) {
                    this.f3030f = c0947ft.f3016g;
                    this.f3025a &= -17;
                } else {
                    m5434j();
                    this.f3030f.addAll(c0947ft.f3016g);
                }
            }
            if (c0947ft.m5416l()) {
                m5451d(c0947ft.m5417m());
            }
            if (c0947ft.m5418n()) {
                m5453e(c0947ft.m5419o());
            }
            if (c0947ft.m5420p()) {
                m5445b(c0947ft.m5421q());
            }
            if (!c0947ft.f3020k.isEmpty()) {
                if (this.f3034j.isEmpty()) {
                    this.f3034j = c0947ft.f3020k;
                    this.f3025a &= -257;
                } else {
                    m5435k();
                    this.f3034j.addAll(c0947ft.f3020k);
                }
            }
            if (c0947ft.m5423s()) {
                m5454f(c0947ft.m5424t());
            }
            if (c0947ft.m5425u()) {
                m5448c(c0947ft.m5426v());
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
    public C0948fu mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f3025a |= 1;
                    this.f3026b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f3025a |= 2;
                        this.f3027c = enumC0822bcM3576a;
                        break;
                    }
                case 26:
                    this.f3025a |= 4;
                    this.f3028d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f3025a |= 8;
                    this.f3029e = codedInputStream.readBytes();
                    break;
                case 42:
                    m5434j();
                    this.f3030f.add(codedInputStream.readBytes());
                    break;
                case 50:
                    this.f3025a |= 32;
                    this.f3031g = codedInputStream.readBytes();
                    break;
                case 58:
                    this.f3025a |= 64;
                    this.f3032h = codedInputStream.readBytes();
                    break;
                case 64:
                    this.f3025a |= 128;
                    this.f3033i = codedInputStream.readInt64();
                    break;
                case 74:
                    C0951fx c0951fxNewBuilder = C0950fw.newBuilder();
                    codedInputStream.readMessage(c0951fxNewBuilder, extensionRegistryLite);
                    m5441a(c0951fxNewBuilder.buildPartial());
                    break;
                case 82:
                    this.f3025a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
                    this.f3035k = codedInputStream.readBytes();
                    break;
                case 88:
                    this.f3025a |= 1024;
                    this.f3036l = codedInputStream.readInt64();
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
    public C0948fu m5437a(long j) {
        this.f3025a |= 1;
        this.f3026b = j;
        return this;
    }

    /* renamed from: a */
    public C0948fu m5439a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f3025a |= 2;
        this.f3027c = enumC0822bc;
        return this;
    }

    /* renamed from: a */
    public C0948fu m5443a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3025a |= 4;
        this.f3028d = str;
        return this;
    }

    /* renamed from: b */
    public C0948fu m5446b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3025a |= 8;
        this.f3029e = str;
        return this;
    }

    /* renamed from: j */
    private void m5434j() {
        if ((this.f3025a & 16) != 16) {
            this.f3030f = new LazyStringArrayList(this.f3030f);
            this.f3025a |= 16;
        }
    }

    /* renamed from: c */
    public C0948fu m5449c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m5434j();
        this.f3030f.add((LazyStringList) str);
        return this;
    }

    /* renamed from: d */
    public C0948fu m5451d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3025a |= 32;
        this.f3031g = str;
        return this;
    }

    /* renamed from: e */
    public C0948fu m5453e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3025a |= 64;
        this.f3032h = str;
        return this;
    }

    /* renamed from: b */
    public C0948fu m5445b(long j) {
        this.f3025a |= 128;
        this.f3033i = j;
        return this;
    }

    /* renamed from: k */
    private void m5435k() {
        if ((this.f3025a & 256) != 256) {
            this.f3034j = new ArrayList(this.f3034j);
            this.f3025a |= 256;
        }
    }

    /* renamed from: a */
    public C0948fu m5441a(C0950fw c0950fw) {
        if (c0950fw == null) {
            throw new NullPointerException();
        }
        m5435k();
        this.f3034j.add(c0950fw);
        return this;
    }

    /* renamed from: a */
    public C0948fu m5442a(C0951fx c0951fx) {
        m5435k();
        this.f3034j.add(c0951fx.build());
        return this;
    }

    /* renamed from: f */
    public C0948fu m5454f(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f3025a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        this.f3035k = str;
        return this;
    }

    /* renamed from: c */
    public C0948fu m5448c(long j) {
        this.f3025a |= 1024;
        this.f3036l = j;
        return this;
    }
}
