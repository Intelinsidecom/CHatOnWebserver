package com.sec.chaton.p046a;

import android.hardware.motion.MotionRecognitionManager;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.aq */
/* loaded from: classes.dex */
public final class C0809aq extends GeneratedMessageLite.Builder<C0808ap, C0809aq> implements InterfaceC0810ar {

    /* renamed from: a */
    private int f2263a;

    /* renamed from: b */
    private long f2264b;

    /* renamed from: i */
    private long f2271i;

    /* renamed from: k */
    private long f2273k;

    /* renamed from: l */
    private boolean f2274l;

    /* renamed from: c */
    private EnumC0822bc f2265c = EnumC0822bc.SINGLE;

    /* renamed from: d */
    private Object f2266d = "";

    /* renamed from: e */
    private Object f2267e = "";

    /* renamed from: f */
    private LazyStringList f2268f = LazyStringArrayList.EMPTY;

    /* renamed from: g */
    private EnumC0811as f2269g = EnumC0811as.ADD;

    /* renamed from: h */
    private LazyStringList f2270h = LazyStringArrayList.EMPTY;

    /* renamed from: j */
    private Object f2272j = "";

    private C0809aq() {
        m3393q();
    }

    /* renamed from: q */
    private void m3393q() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public static C0809aq m3394r() {
        return new C0809aq();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0809aq clear() {
        super.clear();
        this.f2264b = 0L;
        this.f2263a &= -2;
        this.f2265c = EnumC0822bc.SINGLE;
        this.f2263a &= -3;
        this.f2266d = "";
        this.f2263a &= -5;
        this.f2267e = "";
        this.f2263a &= -9;
        this.f2268f = LazyStringArrayList.EMPTY;
        this.f2263a &= -17;
        this.f2269g = EnumC0811as.ADD;
        this.f2263a &= -33;
        this.f2270h = LazyStringArrayList.EMPTY;
        this.f2263a &= -65;
        this.f2271i = 0L;
        this.f2263a &= -129;
        this.f2272j = "";
        this.f2263a &= -257;
        this.f2273k = 0L;
        this.f2263a &= -513;
        this.f2274l = false;
        this.f2263a &= -1025;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0809aq mo19949clone() {
        return m3394r().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0808ap getDefaultInstanceForType() {
        return C0808ap.m3352a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0808ap build() {
        C0808ap c0808apBuildPartial = buildPartial();
        if (!c0808apBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0808apBuildPartial);
        }
        return c0808apBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public C0808ap m3395s() throws InvalidProtocolBufferException {
        C0808ap c0808apBuildPartial = buildPartial();
        if (!c0808apBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0808apBuildPartial).asInvalidProtocolBufferException();
        }
        return c0808apBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0808ap buildPartial() {
        C0808ap c0808ap = new C0808ap(this);
        int i = this.f2263a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0808ap.f2250c = this.f2264b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0808ap.f2251d = this.f2265c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0808ap.f2252e = this.f2266d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0808ap.f2253f = this.f2267e;
        if ((this.f2263a & 16) == 16) {
            this.f2268f = new UnmodifiableLazyStringList(this.f2268f);
            this.f2263a &= -17;
        }
        c0808ap.f2254g = this.f2268f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0808ap.f2255h = this.f2269g;
        if ((this.f2263a & 64) == 64) {
            this.f2270h = new UnmodifiableLazyStringList(this.f2270h);
            this.f2263a &= -65;
        }
        c0808ap.f2256i = this.f2270h;
        if ((i & 128) == 128) {
            i2 |= 32;
        }
        c0808ap.f2257j = this.f2271i;
        if ((i & 256) == 256) {
            i2 |= 64;
        }
        c0808ap.f2258k = this.f2272j;
        if ((i & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            i2 |= 128;
        }
        c0808ap.f2259l = this.f2273k;
        if ((i & 1024) == 1024) {
            i2 |= 256;
        }
        c0808ap.f2260m = this.f2274l;
        c0808ap.f2249b = i2;
        return c0808ap;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0809aq mergeFrom(C0808ap c0808ap) {
        if (c0808ap != C0808ap.m3352a()) {
            if (c0808ap.m3369c()) {
                m3399a(c0808ap.m3370d());
            }
            if (c0808ap.m3371e()) {
                m3403a(c0808ap.m3372f());
            }
            if (c0808ap.m3373g()) {
                m3405a(c0808ap.m3374h());
            }
            if (c0808ap.m3375i()) {
                m3409b(c0808ap.m3376j());
            }
            if (!c0808ap.f2254g.isEmpty()) {
                if (this.f2268f.isEmpty()) {
                    this.f2268f = c0808ap.f2254g;
                    this.f2263a &= -17;
                } else {
                    m3396t();
                    this.f2268f.addAll(c0808ap.f2254g);
                }
            }
            if (c0808ap.m3378l()) {
                m3402a(c0808ap.m3379m());
            }
            if (!c0808ap.f2256i.isEmpty()) {
                if (this.f2270h.isEmpty()) {
                    this.f2270h = c0808ap.f2256i;
                    this.f2263a &= -65;
                } else {
                    m3397u();
                    this.f2270h.addAll(c0808ap.f2256i);
                }
            }
            if (c0808ap.m3381o()) {
                m3408b(c0808ap.m3382p());
            }
            if (c0808ap.m3383q()) {
                m3414d(c0808ap.m3384r());
            }
            if (c0808ap.m3385s()) {
                m3411c(c0808ap.m3386t());
            }
            if (c0808ap.m3387u()) {
                m3406a(c0808ap.m3388v());
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
    public C0809aq mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2263a |= 1;
                    this.f2264b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f2263a |= 2;
                        this.f2265c = enumC0822bcM3576a;
                        break;
                    }
                case 26:
                    this.f2263a |= 4;
                    this.f2266d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f2263a |= 8;
                    this.f2267e = codedInputStream.readBytes();
                    break;
                case 42:
                    m3396t();
                    this.f2268f.add(codedInputStream.readBytes());
                    break;
                case 48:
                    EnumC0811as enumC0811asM3426a = EnumC0811as.m3426a(codedInputStream.readEnum());
                    if (enumC0811asM3426a == null) {
                        break;
                    } else {
                        this.f2263a |= 32;
                        this.f2269g = enumC0811asM3426a;
                        break;
                    }
                case 58:
                    m3397u();
                    this.f2270h.add(codedInputStream.readBytes());
                    break;
                case 64:
                    this.f2263a |= 128;
                    this.f2271i = codedInputStream.readInt64();
                    break;
                case 74:
                    this.f2263a |= 256;
                    this.f2272j = codedInputStream.readBytes();
                    break;
                case 80:
                    this.f2263a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
                    this.f2273k = codedInputStream.readInt64();
                    break;
                case 88:
                    this.f2263a |= 1024;
                    this.f2274l = codedInputStream.readBool();
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
    public long m3416f() {
        return this.f2264b;
    }

    /* renamed from: a */
    public C0809aq m3399a(long j) {
        this.f2263a |= 1;
        this.f2264b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0822bc m3417g() {
        return this.f2265c;
    }

    /* renamed from: a */
    public C0809aq m3403a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f2263a |= 2;
        this.f2265c = enumC0822bc;
        return this;
    }

    /* renamed from: h */
    public String m3418h() {
        Object obj = this.f2266d;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f2266d = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: a */
    public C0809aq m3405a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2263a |= 4;
        this.f2266d = str;
        return this;
    }

    /* renamed from: i */
    public String m3419i() {
        Object obj = this.f2267e;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f2267e = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: b */
    public C0809aq m3409b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2263a |= 8;
        this.f2267e = str;
        return this;
    }

    /* renamed from: t */
    private void m3396t() {
        if ((this.f2263a & 16) != 16) {
            this.f2268f = new LazyStringArrayList(this.f2268f);
            this.f2263a |= 16;
        }
    }

    /* renamed from: j */
    public List<String> m3420j() {
        return Collections.unmodifiableList(this.f2268f);
    }

    /* renamed from: k */
    public int m3421k() {
        return this.f2268f.size();
    }

    /* renamed from: c */
    public C0809aq m3412c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m3396t();
        this.f2268f.add((LazyStringList) str);
        return this;
    }

    /* renamed from: l */
    public EnumC0811as m3422l() {
        return this.f2269g;
    }

    /* renamed from: a */
    public C0809aq m3402a(EnumC0811as enumC0811as) {
        if (enumC0811as == null) {
            throw new NullPointerException();
        }
        this.f2263a |= 32;
        this.f2269g = enumC0811as;
        return this;
    }

    /* renamed from: u */
    private void m3397u() {
        if ((this.f2263a & 64) != 64) {
            this.f2270h = new LazyStringArrayList(this.f2270h);
            this.f2263a |= 64;
        }
    }

    /* renamed from: m */
    public List<String> m3423m() {
        return Collections.unmodifiableList(this.f2270h);
    }

    /* renamed from: n */
    public int m3424n() {
        return this.f2270h.size();
    }

    /* renamed from: a */
    public C0809aq m3404a(Iterable<String> iterable) {
        m3397u();
        GeneratedMessageLite.Builder.addAll(iterable, this.f2270h);
        return this;
    }

    /* renamed from: o */
    public long m3425o() {
        return this.f2271i;
    }

    /* renamed from: b */
    public C0809aq m3408b(long j) {
        this.f2263a |= 128;
        this.f2271i = j;
        return this;
    }

    /* renamed from: d */
    public C0809aq m3414d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2263a |= 256;
        this.f2272j = str;
        return this;
    }

    /* renamed from: c */
    public C0809aq m3411c(long j) {
        this.f2263a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        this.f2273k = j;
        return this;
    }

    /* renamed from: a */
    public C0809aq m3406a(boolean z) {
        this.f2263a |= 1024;
        this.f2274l = z;
        return this;
    }
}
