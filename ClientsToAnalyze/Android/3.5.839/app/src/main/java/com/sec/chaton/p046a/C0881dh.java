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
/* renamed from: com.sec.chaton.a.dh */
/* loaded from: classes.dex */
public final class C0881dh extends GeneratedMessageLite.Builder<C0880dg, C0881dh> implements InterfaceC0882di {

    /* renamed from: a */
    private int f2690a;

    /* renamed from: b */
    private long f2691b;

    /* renamed from: h */
    private long f2697h;

    /* renamed from: j */
    private long f2699j;

    /* renamed from: k */
    private boolean f2700k;

    /* renamed from: m */
    private int f2702m;

    /* renamed from: c */
    private EnumC0908eh f2692c = EnumC0908eh.TEXT;

    /* renamed from: d */
    private Object f2693d = "";

    /* renamed from: e */
    private Object f2694e = "";

    /* renamed from: f */
    private LazyStringList f2695f = LazyStringArrayList.EMPTY;

    /* renamed from: g */
    private LazyStringList f2696g = LazyStringArrayList.EMPTY;

    /* renamed from: i */
    private Object f2698i = "";

    /* renamed from: l */
    private Object f2701l = "";

    /* renamed from: n */
    private EnumC0822bc f2703n = EnumC0822bc.SINGLE;

    private C0881dh() {
        m4481n();
    }

    /* renamed from: n */
    private void m4481n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public static C0881dh m4482o() {
        return new C0881dh();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0881dh clear() {
        super.clear();
        this.f2691b = 0L;
        this.f2690a &= -2;
        this.f2692c = EnumC0908eh.TEXT;
        this.f2690a &= -3;
        this.f2693d = "";
        this.f2690a &= -5;
        this.f2694e = "";
        this.f2690a &= -9;
        this.f2695f = LazyStringArrayList.EMPTY;
        this.f2690a &= -17;
        this.f2696g = LazyStringArrayList.EMPTY;
        this.f2690a &= -33;
        this.f2697h = 0L;
        this.f2690a &= -65;
        this.f2698i = "";
        this.f2690a &= -129;
        this.f2699j = 0L;
        this.f2690a &= -257;
        this.f2700k = false;
        this.f2690a &= -513;
        this.f2701l = "";
        this.f2690a &= -1025;
        this.f2702m = 0;
        this.f2690a &= -2049;
        this.f2703n = EnumC0822bc.SINGLE;
        this.f2690a &= -4097;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0881dh mo19949clone() {
        return m4482o().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0880dg getDefaultInstanceForType() {
        return C0880dg.m4437a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0880dg build() {
        C0880dg c0880dgBuildPartial = buildPartial();
        if (!c0880dgBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0880dgBuildPartial);
        }
        return c0880dgBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public C0880dg m4483p() throws InvalidProtocolBufferException {
        C0880dg c0880dgBuildPartial = buildPartial();
        if (!c0880dgBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0880dgBuildPartial).asInvalidProtocolBufferException();
        }
        return c0880dgBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0880dg buildPartial() {
        C0880dg c0880dg = new C0880dg(this);
        int i = this.f2690a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0880dg.f2675c = this.f2691b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0880dg.f2676d = this.f2692c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0880dg.f2677e = this.f2693d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0880dg.f2678f = this.f2694e;
        if ((this.f2690a & 16) == 16) {
            this.f2695f = new UnmodifiableLazyStringList(this.f2695f);
            this.f2690a &= -17;
        }
        c0880dg.f2679g = this.f2695f;
        if ((this.f2690a & 32) == 32) {
            this.f2696g = new UnmodifiableLazyStringList(this.f2696g);
            this.f2690a &= -33;
        }
        c0880dg.f2680h = this.f2696g;
        if ((i & 64) == 64) {
            i2 |= 16;
        }
        c0880dg.f2681i = this.f2697h;
        if ((i & 128) == 128) {
            i2 |= 32;
        }
        c0880dg.f2682j = this.f2698i;
        if ((i & 256) == 256) {
            i2 |= 64;
        }
        c0880dg.f2683k = this.f2699j;
        if ((i & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            i2 |= 128;
        }
        c0880dg.f2684l = this.f2700k;
        if ((i & 1024) == 1024) {
            i2 |= 256;
        }
        c0880dg.f2685m = this.f2701l;
        if ((i & MotionRecognitionManager.EVENT_TILT_TO_UNLOCK) == 2048) {
            i2 |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        }
        c0880dg.f2686n = this.f2702m;
        if ((i & 4096) == 4096) {
            i2 |= 1024;
        }
        c0880dg.f2687o = this.f2703n;
        c0880dg.f2674b = i2;
        return c0880dg;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0881dh mergeFrom(C0880dg c0880dg) {
        if (c0880dg != C0880dg.m4437a()) {
            if (c0880dg.m4455c()) {
                m4488a(c0880dg.m4456d());
            }
            if (c0880dg.m4457e()) {
                m4492a(c0880dg.m4458f());
            }
            if (c0880dg.m4459g()) {
                m4493a(c0880dg.m4460h());
            }
            if (c0880dg.m4461i()) {
                m4497b(c0880dg.m4462j());
            }
            if (!c0880dg.f2679g.isEmpty()) {
                if (this.f2695f.isEmpty()) {
                    this.f2695f = c0880dg.f2679g;
                    this.f2690a &= -17;
                } else {
                    m4484q();
                    this.f2695f.addAll(c0880dg.f2679g);
                }
            }
            if (!c0880dg.f2680h.isEmpty()) {
                if (this.f2696g.isEmpty()) {
                    this.f2696g = c0880dg.f2680h;
                    this.f2690a &= -33;
                } else {
                    m4485r();
                    this.f2696g.addAll(c0880dg.f2680h);
                }
            }
            if (c0880dg.m4465m()) {
                m4496b(c0880dg.m4466n());
            }
            if (c0880dg.m4467o()) {
                m4504e(c0880dg.m4468p());
            }
            if (c0880dg.m4469q()) {
                m4499c(c0880dg.m4470r());
            }
            if (c0880dg.m4471s()) {
                m4494a(c0880dg.m4472t());
            }
            if (c0880dg.m4473u()) {
                m4506f(c0880dg.m4474v());
            }
            if (c0880dg.m4475w()) {
                m4487a(c0880dg.m4476x());
            }
            if (c0880dg.m4477y()) {
                m4490a(c0880dg.m4478z());
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
    public C0881dh mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2690a |= 1;
                    this.f2691b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0908eh enumC0908ehM4887a = EnumC0908eh.m4887a(codedInputStream.readEnum());
                    if (enumC0908ehM4887a == null) {
                        break;
                    } else {
                        this.f2690a |= 2;
                        this.f2692c = enumC0908ehM4887a;
                        break;
                    }
                case 26:
                    this.f2690a |= 4;
                    this.f2693d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f2690a |= 8;
                    this.f2694e = codedInputStream.readBytes();
                    break;
                case 42:
                    m4484q();
                    this.f2695f.add(codedInputStream.readBytes());
                    break;
                case 50:
                    m4485r();
                    this.f2696g.add(codedInputStream.readBytes());
                    break;
                case 56:
                    this.f2690a |= 64;
                    this.f2697h = codedInputStream.readInt64();
                    break;
                case 66:
                    this.f2690a |= 128;
                    this.f2698i = codedInputStream.readBytes();
                    break;
                case 72:
                    this.f2690a |= 256;
                    this.f2699j = codedInputStream.readInt64();
                    break;
                case 80:
                    this.f2690a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
                    this.f2700k = codedInputStream.readBool();
                    break;
                case 90:
                    this.f2690a |= 1024;
                    this.f2701l = codedInputStream.readBytes();
                    break;
                case 96:
                    this.f2690a |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
                    this.f2702m = codedInputStream.readInt32();
                    break;
                case 104:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f2690a |= 4096;
                        this.f2703n = enumC0822bcM3576a;
                        break;
                    }
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
    public long m4505f() {
        return this.f2691b;
    }

    /* renamed from: a */
    public C0881dh m4488a(long j) {
        this.f2690a |= 1;
        this.f2691b = j;
        return this;
    }

    /* renamed from: a */
    public C0881dh m4492a(EnumC0908eh enumC0908eh) {
        if (enumC0908eh == null) {
            throw new NullPointerException();
        }
        this.f2690a |= 2;
        this.f2692c = enumC0908eh;
        return this;
    }

    /* renamed from: a */
    public C0881dh m4493a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2690a |= 4;
        this.f2693d = str;
        return this;
    }

    /* renamed from: g */
    public String m4507g() {
        Object obj = this.f2694e;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f2694e = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: b */
    public C0881dh m4497b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2690a |= 8;
        this.f2694e = str;
        return this;
    }

    /* renamed from: q */
    private void m4484q() {
        if ((this.f2690a & 16) != 16) {
            this.f2695f = new LazyStringArrayList(this.f2695f);
            this.f2690a |= 16;
        }
    }

    /* renamed from: h */
    public List<String> m4508h() {
        return Collections.unmodifiableList(this.f2695f);
    }

    /* renamed from: i */
    public int m4509i() {
        return this.f2695f.size();
    }

    /* renamed from: c */
    public C0881dh m4500c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m4484q();
        this.f2695f.add((LazyStringList) str);
        return this;
    }

    /* renamed from: r */
    private void m4485r() {
        if ((this.f2690a & 32) != 32) {
            this.f2696g = new LazyStringArrayList(this.f2696g);
            this.f2690a |= 32;
        }
    }

    /* renamed from: j */
    public List<String> m4510j() {
        return Collections.unmodifiableList(this.f2696g);
    }

    /* renamed from: k */
    public int m4511k() {
        return this.f2696g.size();
    }

    /* renamed from: d */
    public C0881dh m4502d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m4485r();
        this.f2696g.add((LazyStringList) str);
        return this;
    }

    /* renamed from: l */
    public long m4512l() {
        return this.f2697h;
    }

    /* renamed from: b */
    public C0881dh m4496b(long j) {
        this.f2690a |= 64;
        this.f2697h = j;
        return this;
    }

    /* renamed from: e */
    public C0881dh m4504e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2690a |= 128;
        this.f2698i = str;
        return this;
    }

    /* renamed from: c */
    public C0881dh m4499c(long j) {
        this.f2690a |= 256;
        this.f2699j = j;
        return this;
    }

    /* renamed from: a */
    public C0881dh m4494a(boolean z) {
        this.f2690a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        this.f2700k = z;
        return this;
    }

    /* renamed from: f */
    public C0881dh m4506f(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2690a |= 1024;
        this.f2701l = str;
        return this;
    }

    /* renamed from: a */
    public C0881dh m4487a(int i) {
        this.f2690a |= MotionRecognitionManager.EVENT_TILT_TO_UNLOCK;
        this.f2702m = i;
        return this;
    }

    /* renamed from: a */
    public C0881dh m4490a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f2690a |= 4096;
        this.f2703n = enumC0822bc;
        return this;
    }
}
