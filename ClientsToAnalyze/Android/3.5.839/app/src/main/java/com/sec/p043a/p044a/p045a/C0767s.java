package com.sec.p043a.p044a.p045a;

import android.hardware.motion.MotionRecognitionManager;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.s */
/* loaded from: classes.dex */
public final class C0767s extends GeneratedMessageLite.Builder<C0766r, C0767s> implements InterfaceC0768t {

    /* renamed from: a */
    private int f1833a;

    /* renamed from: d */
    private int f1836d;

    /* renamed from: e */
    private int f1837e;

    /* renamed from: i */
    private long f1841i;

    /* renamed from: j */
    private int f1842j;

    /* renamed from: b */
    private Object f1834b = "";

    /* renamed from: c */
    private Object f1835c = "";

    /* renamed from: f */
    private Object f1838f = "";

    /* renamed from: g */
    private Object f1839g = "";

    /* renamed from: h */
    private Object f1840h = "";

    /* renamed from: k */
    private Object f1843k = "";

    private C0767s() {
        m2745g();
    }

    /* renamed from: g */
    private void m2745g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0767s m2746h() {
        return new C0767s();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0767s clear() {
        super.clear();
        this.f1834b = "";
        this.f1833a &= -2;
        this.f1835c = "";
        this.f1833a &= -3;
        this.f1836d = 0;
        this.f1833a &= -5;
        this.f1837e = 0;
        this.f1833a &= -9;
        this.f1838f = "";
        this.f1833a &= -17;
        this.f1839g = "";
        this.f1833a &= -33;
        this.f1840h = "";
        this.f1833a &= -65;
        this.f1841i = 0L;
        this.f1833a &= -129;
        this.f1842j = 0;
        this.f1833a &= -257;
        this.f1843k = "";
        this.f1833a &= -513;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0767s mo19949clone() {
        return m2746h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0766r getDefaultInstanceForType() {
        return C0766r.m2706a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0766r build() {
        C0766r c0766rBuildPartial = buildPartial();
        if (!c0766rBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0766rBuildPartial);
        }
        return c0766rBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0766r m2747i() throws InvalidProtocolBufferException {
        C0766r c0766rBuildPartial = buildPartial();
        if (!c0766rBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0766rBuildPartial).asInvalidProtocolBufferException();
        }
        return c0766rBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0766r buildPartial() {
        C0766r c0766r = new C0766r(this);
        int i = this.f1833a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0766r.f1821c = this.f1834b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0766r.f1822d = this.f1835c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0766r.f1823e = this.f1836d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0766r.f1824f = this.f1837e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0766r.f1825g = this.f1838f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0766r.f1826h = this.f1839g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0766r.f1827i = this.f1840h;
        if ((i & 128) == 128) {
            i2 |= 128;
        }
        c0766r.f1828j = this.f1841i;
        if ((i & 256) == 256) {
            i2 |= 256;
        }
        c0766r.f1829k = this.f1842j;
        if ((i & MotionRecognitionManager.EVENT_VOLUME_DOWN) == 512) {
            i2 |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        }
        c0766r.f1830l = this.f1843k;
        c0766r.f1820b = i2;
        return c0766r;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0767s mergeFrom(C0766r c0766r) {
        if (c0766r != C0766r.m2706a()) {
            if (c0766r.m2721c()) {
                m2753a(c0766r.m2722d());
            }
            if (c0766r.m2723e()) {
                m2756b(c0766r.m2724f());
            }
            if (c0766r.m2725g()) {
                m2749a(c0766r.m2726h());
            }
            if (c0766r.m2727i()) {
                m2755b(c0766r.m2728j());
            }
            if (c0766r.m2729k()) {
                m2759c(c0766r.m2730l());
            }
            if (c0766r.m2731m()) {
                m2761d(c0766r.m2732n());
            }
            if (c0766r.m2733o()) {
                m2763e(c0766r.m2734p());
            }
            if (c0766r.m2735q()) {
                m2750a(c0766r.m2736r());
            }
            if (c0766r.m2737s()) {
                m2758c(c0766r.m2738t());
            }
            if (c0766r.m2739u()) {
                m2764f(c0766r.m2740v());
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
    public C0767s mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f1833a |= 1;
                    this.f1834b = codedInputStream.readBytes();
                    break;
                case 18:
                    this.f1833a |= 2;
                    this.f1835c = codedInputStream.readBytes();
                    break;
                case 24:
                    this.f1833a |= 4;
                    this.f1836d = codedInputStream.readInt32();
                    break;
                case 32:
                    this.f1833a |= 8;
                    this.f1837e = codedInputStream.readInt32();
                    break;
                case 42:
                    this.f1833a |= 16;
                    this.f1838f = codedInputStream.readBytes();
                    break;
                case 50:
                    this.f1833a |= 32;
                    this.f1839g = codedInputStream.readBytes();
                    break;
                case 58:
                    this.f1833a |= 64;
                    this.f1840h = codedInputStream.readBytes();
                    break;
                case 88:
                    this.f1833a |= 128;
                    this.f1841i = codedInputStream.readInt64();
                    break;
                case 96:
                    this.f1833a |= 256;
                    this.f1842j = codedInputStream.readInt32();
                    break;
                case 106:
                    this.f1833a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
                    this.f1843k = codedInputStream.readBytes();
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
    public C0767s m2753a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1833a |= 1;
        this.f1834b = str;
        return this;
    }

    /* renamed from: b */
    public C0767s m2756b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1833a |= 2;
        this.f1835c = str;
        return this;
    }

    /* renamed from: a */
    public C0767s m2749a(int i) {
        this.f1833a |= 4;
        this.f1836d = i;
        return this;
    }

    /* renamed from: b */
    public C0767s m2755b(int i) {
        this.f1833a |= 8;
        this.f1837e = i;
        return this;
    }

    /* renamed from: c */
    public C0767s m2759c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1833a |= 16;
        this.f1838f = str;
        return this;
    }

    /* renamed from: d */
    public C0767s m2761d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1833a |= 32;
        this.f1839g = str;
        return this;
    }

    /* renamed from: e */
    public C0767s m2763e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1833a |= 64;
        this.f1840h = str;
        return this;
    }

    /* renamed from: a */
    public C0767s m2750a(long j) {
        this.f1833a |= 128;
        this.f1841i = j;
        return this;
    }

    /* renamed from: c */
    public C0767s m2758c(int i) {
        this.f1833a |= 256;
        this.f1842j = i;
        return this;
    }

    /* renamed from: f */
    public C0767s m2764f(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f1833a |= MotionRecognitionManager.EVENT_VOLUME_DOWN;
        this.f1843k = str;
        return this;
    }
}
