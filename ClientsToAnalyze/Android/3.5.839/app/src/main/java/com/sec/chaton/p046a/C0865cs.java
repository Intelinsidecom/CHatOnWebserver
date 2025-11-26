package com.sec.chaton.p046a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.cs */
/* loaded from: classes.dex */
public final class C0865cs extends GeneratedMessageLite.Builder<C0864cr, C0865cs> implements InterfaceC0866ct {

    /* renamed from: a */
    private int f2576a;

    /* renamed from: d */
    private long f2579d;

    /* renamed from: f */
    private long f2581f;

    /* renamed from: b */
    private Object f2577b = "";

    /* renamed from: c */
    private LazyStringList f2578c = LazyStringArrayList.EMPTY;

    /* renamed from: e */
    private Object f2580e = "";

    /* renamed from: g */
    private EnumC0908eh f2582g = EnumC0908eh.TEXT;

    /* renamed from: h */
    private EnumC0822bc f2583h = EnumC0822bc.SINGLE;

    /* renamed from: i */
    private Object f2584i = "";

    /* renamed from: j */
    private Object f2585j = "";

    private C0865cs() {
        m4170g();
    }

    /* renamed from: g */
    private void m4170g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0865cs m4171h() {
        return new C0865cs();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0865cs clear() {
        super.clear();
        this.f2577b = "";
        this.f2576a &= -2;
        this.f2578c = LazyStringArrayList.EMPTY;
        this.f2576a &= -3;
        this.f2579d = 0L;
        this.f2576a &= -5;
        this.f2580e = "";
        this.f2576a &= -9;
        this.f2581f = 0L;
        this.f2576a &= -17;
        this.f2582g = EnumC0908eh.TEXT;
        this.f2576a &= -33;
        this.f2583h = EnumC0822bc.SINGLE;
        this.f2576a &= -65;
        this.f2584i = "";
        this.f2576a &= -129;
        this.f2585j = "";
        this.f2576a &= -257;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0865cs mo19949clone() {
        return m4171h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0864cr getDefaultInstanceForType() {
        return C0864cr.m4134a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0864cr build() {
        C0864cr c0864crBuildPartial = buildPartial();
        if (!c0864crBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0864crBuildPartial);
        }
        return c0864crBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0864cr buildPartial() {
        C0864cr c0864cr = new C0864cr(this);
        int i = this.f2576a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0864cr.f2565c = this.f2577b;
        if ((this.f2576a & 2) == 2) {
            this.f2578c = new UnmodifiableLazyStringList(this.f2578c);
            this.f2576a &= -3;
        }
        c0864cr.f2566d = this.f2578c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0864cr.f2567e = this.f2579d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0864cr.f2568f = this.f2580e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0864cr.f2569g = this.f2581f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0864cr.f2570h = this.f2582g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0864cr.f2571i = this.f2583h;
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        c0864cr.f2572j = this.f2584i;
        if ((i & 256) == 256) {
            i2 |= 128;
        }
        c0864cr.f2573k = this.f2585j;
        c0864cr.f2564b = i2;
        return c0864cr;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0865cs mergeFrom(C0864cr c0864cr) {
        if (c0864cr != C0864cr.m4134a()) {
            if (c0864cr.m4149c()) {
                m4179a(c0864cr.m4150d());
            }
            if (!c0864cr.f2566d.isEmpty()) {
                if (this.f2578c.isEmpty()) {
                    this.f2578c = c0864cr.f2566d;
                    this.f2576a &= -3;
                } else {
                    m4172i();
                    this.f2578c.addAll(c0864cr.f2566d);
                }
            }
            if (c0864cr.m4153g()) {
                m4174a(c0864cr.m4154h());
            }
            if (c0864cr.m4155i()) {
                m4182b(c0864cr.m4156j());
            }
            if (c0864cr.m4157k()) {
                m4181b(c0864cr.m4158l());
            }
            if (c0864cr.m4159m()) {
                m4178a(c0864cr.m4160n());
            }
            if (c0864cr.m4161o()) {
                m4176a(c0864cr.m4162p());
            }
            if (c0864cr.m4163q()) {
                m4184c(c0864cr.m4164r());
            }
            if (c0864cr.m4165s()) {
                m4186d(c0864cr.m4166t());
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
    public C0865cs mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f2576a |= 1;
                    this.f2577b = codedInputStream.readBytes();
                    break;
                case 18:
                    m4172i();
                    this.f2578c.add(codedInputStream.readBytes());
                    break;
                case 24:
                    this.f2576a |= 4;
                    this.f2579d = codedInputStream.readInt64();
                    break;
                case 34:
                    this.f2576a |= 8;
                    this.f2580e = codedInputStream.readBytes();
                    break;
                case 40:
                    this.f2576a |= 16;
                    this.f2581f = codedInputStream.readInt64();
                    break;
                case 48:
                    EnumC0908eh enumC0908ehM4887a = EnumC0908eh.m4887a(codedInputStream.readEnum());
                    if (enumC0908ehM4887a == null) {
                        break;
                    } else {
                        this.f2576a |= 32;
                        this.f2582g = enumC0908ehM4887a;
                        break;
                    }
                case 56:
                    EnumC0822bc enumC0822bcM3576a = EnumC0822bc.m3576a(codedInputStream.readEnum());
                    if (enumC0822bcM3576a == null) {
                        break;
                    } else {
                        this.f2576a |= 64;
                        this.f2583h = enumC0822bcM3576a;
                        break;
                    }
                case 66:
                    this.f2576a |= 128;
                    this.f2584i = codedInputStream.readBytes();
                    break;
                case 74:
                    this.f2576a |= 256;
                    this.f2585j = codedInputStream.readBytes();
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
    public C0865cs m4179a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2576a |= 1;
        this.f2577b = str;
        return this;
    }

    /* renamed from: i */
    private void m4172i() {
        if ((this.f2576a & 2) != 2) {
            this.f2578c = new LazyStringArrayList(this.f2578c);
            this.f2576a |= 2;
        }
    }

    /* renamed from: a */
    public C0865cs m4174a(long j) {
        this.f2576a |= 4;
        this.f2579d = j;
        return this;
    }

    /* renamed from: b */
    public C0865cs m4182b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2576a |= 8;
        this.f2580e = str;
        return this;
    }

    /* renamed from: b */
    public C0865cs m4181b(long j) {
        this.f2576a |= 16;
        this.f2581f = j;
        return this;
    }

    /* renamed from: a */
    public C0865cs m4178a(EnumC0908eh enumC0908eh) {
        if (enumC0908eh == null) {
            throw new NullPointerException();
        }
        this.f2576a |= 32;
        this.f2582g = enumC0908eh;
        return this;
    }

    /* renamed from: a */
    public C0865cs m4176a(EnumC0822bc enumC0822bc) {
        if (enumC0822bc == null) {
            throw new NullPointerException();
        }
        this.f2576a |= 64;
        this.f2583h = enumC0822bc;
        return this;
    }

    /* renamed from: c */
    public C0865cs m4184c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2576a |= 128;
        this.f2584i = str;
        return this;
    }

    /* renamed from: d */
    public C0865cs m4186d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f2576a |= 256;
        this.f2585j = str;
        return this;
    }
}
