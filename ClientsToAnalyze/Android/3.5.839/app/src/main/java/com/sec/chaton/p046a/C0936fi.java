package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.fi */
/* loaded from: classes.dex */
public final class C0936fi extends GeneratedMessageLite.Builder<C0935fh, C0936fi> implements InterfaceC0937fj {

    /* renamed from: a */
    private int f2963a;

    /* renamed from: b */
    private int f2964b;

    /* renamed from: c */
    private Object f2965c = "";

    /* renamed from: d */
    private C0963gi f2966d = C0963gi.m5611a();

    /* renamed from: e */
    private C0919es f2967e = C0919es.m4979a();

    /* renamed from: f */
    private LazyStringList f2968f = LazyStringArrayList.EMPTY;

    /* renamed from: g */
    private LazyStringList f2969g = LazyStringArrayList.EMPTY;

    /* renamed from: h */
    private LazyStringList f2970h = LazyStringArrayList.EMPTY;

    /* renamed from: i */
    private LazyStringList f2971i = LazyStringArrayList.EMPTY;

    /* renamed from: j */
    private LazyStringList f2972j = LazyStringArrayList.EMPTY;

    private C0936fi() {
        m5244k();
    }

    /* renamed from: k */
    private void m5244k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0936fi m5245l() {
        return new C0936fi();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0936fi clear() {
        super.clear();
        this.f2964b = 0;
        this.f2963a &= -2;
        this.f2965c = "";
        this.f2963a &= -3;
        this.f2966d = C0963gi.m5611a();
        this.f2963a &= -5;
        this.f2967e = C0919es.m4979a();
        this.f2963a &= -9;
        this.f2968f = LazyStringArrayList.EMPTY;
        this.f2963a &= -17;
        this.f2969g = LazyStringArrayList.EMPTY;
        this.f2963a &= -33;
        this.f2970h = LazyStringArrayList.EMPTY;
        this.f2963a &= -65;
        this.f2971i = LazyStringArrayList.EMPTY;
        this.f2963a &= -129;
        this.f2972j = LazyStringArrayList.EMPTY;
        this.f2963a &= -257;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0936fi mo19949clone() {
        return m5245l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0935fh getDefaultInstanceForType() {
        return C0935fh.m5211a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0935fh build() {
        C0935fh c0935fhBuildPartial = buildPartial();
        if (!c0935fhBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0935fhBuildPartial);
        }
        return c0935fhBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0935fh buildPartial() {
        C0935fh c0935fh = new C0935fh(this);
        int i = this.f2963a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0935fh.f2952c = this.f2964b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0935fh.f2953d = this.f2965c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0935fh.f2954e = this.f2966d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0935fh.f2955f = this.f2967e;
        if ((this.f2963a & 16) == 16) {
            this.f2968f = new UnmodifiableLazyStringList(this.f2968f);
            this.f2963a &= -17;
        }
        c0935fh.f2956g = this.f2968f;
        if ((this.f2963a & 32) == 32) {
            this.f2969g = new UnmodifiableLazyStringList(this.f2969g);
            this.f2963a &= -33;
        }
        c0935fh.f2957h = this.f2969g;
        if ((this.f2963a & 64) == 64) {
            this.f2970h = new UnmodifiableLazyStringList(this.f2970h);
            this.f2963a &= -65;
        }
        c0935fh.f2958i = this.f2970h;
        if ((this.f2963a & 128) == 128) {
            this.f2971i = new UnmodifiableLazyStringList(this.f2971i);
            this.f2963a &= -129;
        }
        c0935fh.f2959j = this.f2971i;
        if ((this.f2963a & 256) == 256) {
            this.f2972j = new UnmodifiableLazyStringList(this.f2972j);
            this.f2963a &= -257;
        }
        c0935fh.f2960k = this.f2972j;
        c0935fh.f2951b = i2;
        return c0935fh;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0936fi mergeFrom(C0935fh c0935fh) {
        if (c0935fh != C0935fh.m5211a()) {
            if (c0935fh.m5228c()) {
                m5252a(c0935fh.m5229d());
            }
            if (c0935fh.m5230e()) {
                m5257a(c0935fh.m5231f());
            }
            if (c0935fh.m5232g()) {
                m5260b(c0935fh.m5233h());
            }
            if (c0935fh.m5234i()) {
                m5259b(c0935fh.m5235j());
            }
            if (!c0935fh.f2956g.isEmpty()) {
                if (this.f2968f.isEmpty()) {
                    this.f2968f = c0935fh.f2956g;
                    this.f2963a &= -17;
                } else {
                    m5246m();
                    this.f2968f.addAll(c0935fh.f2956g);
                }
            }
            if (!c0935fh.f2957h.isEmpty()) {
                if (this.f2969g.isEmpty()) {
                    this.f2969g = c0935fh.f2957h;
                    this.f2963a &= -33;
                } else {
                    m5247n();
                    this.f2969g.addAll(c0935fh.f2957h);
                }
            }
            if (!c0935fh.f2958i.isEmpty()) {
                if (this.f2970h.isEmpty()) {
                    this.f2970h = c0935fh.f2958i;
                    this.f2963a &= -65;
                } else {
                    m5248o();
                    this.f2970h.addAll(c0935fh.f2958i);
                }
            }
            if (!c0935fh.f2959j.isEmpty()) {
                if (this.f2971i.isEmpty()) {
                    this.f2971i = c0935fh.f2959j;
                    this.f2963a &= -129;
                } else {
                    m5249p();
                    this.f2971i.addAll(c0935fh.f2959j);
                }
            }
            if (!c0935fh.f2960k.isEmpty()) {
                if (this.f2972j.isEmpty()) {
                    this.f2972j = c0935fh.f2960k;
                    this.f2963a &= -257;
                } else {
                    m5250q();
                    this.f2972j.addAll(c0935fh.f2960k);
                }
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
    public C0936fi mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f2963a |= 1;
                    this.f2964b = codedInputStream.readInt32();
                    break;
                case 18:
                    this.f2963a |= 2;
                    this.f2965c = codedInputStream.readBytes();
                    break;
                case 26:
                    C0964gj c0964gjNewBuilder = C0963gi.newBuilder();
                    if (m5264f()) {
                        c0964gjNewBuilder.mergeFrom(m5265g());
                    }
                    codedInputStream.readMessage(c0964gjNewBuilder, extensionRegistryLite);
                    m5256a(c0964gjNewBuilder.buildPartial());
                    break;
                case 34:
                    C0920et c0920etNewBuilder = C0919es.newBuilder();
                    if (m5266h()) {
                        c0920etNewBuilder.mergeFrom(m5267i());
                    }
                    codedInputStream.readMessage(c0920etNewBuilder, extensionRegistryLite);
                    m5254a(c0920etNewBuilder.buildPartial());
                    break;
                case 42:
                    m5246m();
                    this.f2968f.add(codedInputStream.readBytes());
                    break;
                case 50:
                    m5247n();
                    this.f2969g.add(codedInputStream.readBytes());
                    break;
                case 58:
                    m5248o();
                    this.f2970h.add(codedInputStream.readBytes());
                    break;
                case 66:
                    m5249p();
                    this.f2971i.add(codedInputStream.readBytes());
                    break;
                case 74:
                    m5250q();
                    this.f2972j.add(codedInputStream.readBytes());
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
    public C0936fi m5252a(int i) {
        this.f2963a |= 1;
        this.f2964b = i;
        return this;
    }

    /* renamed from: a */
    public C0936fi m5257a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2963a |= 2;
        this.f2965c = str;
        return this;
    }

    /* renamed from: f */
    public boolean m5264f() {
        return (this.f2963a & 4) == 4;
    }

    /* renamed from: g */
    public C0963gi m5265g() {
        return this.f2966d;
    }

    /* renamed from: a */
    public C0936fi m5256a(C0963gi c0963gi) {
        if (c0963gi == null) {
            throw new NullPointerException();
        }
        this.f2966d = c0963gi;
        this.f2963a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0936fi m5260b(C0963gi c0963gi) {
        if ((this.f2963a & 4) == 4 && this.f2966d != C0963gi.m5611a()) {
            this.f2966d = C0963gi.m5612a(this.f2966d).mergeFrom(c0963gi).buildPartial();
        } else {
            this.f2966d = c0963gi;
        }
        this.f2963a |= 4;
        return this;
    }

    /* renamed from: h */
    public boolean m5266h() {
        return (this.f2963a & 8) == 8;
    }

    /* renamed from: i */
    public C0919es m5267i() {
        return this.f2967e;
    }

    /* renamed from: a */
    public C0936fi m5254a(C0919es c0919es) {
        if (c0919es == null) {
            throw new NullPointerException();
        }
        this.f2967e = c0919es;
        this.f2963a |= 8;
        return this;
    }

    /* renamed from: b */
    public C0936fi m5259b(C0919es c0919es) {
        if ((this.f2963a & 8) == 8 && this.f2967e != C0919es.m4979a()) {
            this.f2967e = C0919es.m4980a(this.f2967e).mergeFrom(c0919es).buildPartial();
        } else {
            this.f2967e = c0919es;
        }
        this.f2963a |= 8;
        return this;
    }

    /* renamed from: m */
    private void m5246m() {
        if ((this.f2963a & 16) != 16) {
            this.f2968f = new LazyStringArrayList(this.f2968f);
            this.f2963a |= 16;
        }
    }

    /* renamed from: n */
    private void m5247n() {
        if ((this.f2963a & 32) != 32) {
            this.f2969g = new LazyStringArrayList(this.f2969g);
            this.f2963a |= 32;
        }
    }

    /* renamed from: o */
    private void m5248o() {
        if ((this.f2963a & 64) != 64) {
            this.f2970h = new LazyStringArrayList(this.f2970h);
            this.f2963a |= 64;
        }
    }

    /* renamed from: p */
    private void m5249p() {
        if ((this.f2963a & 128) != 128) {
            this.f2971i = new LazyStringArrayList(this.f2971i);
            this.f2963a |= 128;
        }
    }

    /* renamed from: q */
    private void m5250q() {
        if ((this.f2963a & 256) != 256) {
            this.f2972j = new LazyStringArrayList(this.f2972j);
            this.f2963a |= 256;
        }
    }
}
