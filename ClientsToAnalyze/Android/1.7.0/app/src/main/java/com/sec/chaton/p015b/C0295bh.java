package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.bh */
/* loaded from: classes.dex */
public final class C0295bh extends GeneratedMessageLite.Builder implements InterfaceC0349w {

    /* renamed from: a */
    private int f773a;

    /* renamed from: b */
    private long f774b;

    /* renamed from: c */
    private EnumC0323ci f775c = EnumC0323ci.SINGLE;

    /* renamed from: d */
    private Object f776d = "";

    /* renamed from: e */
    private Object f777e = "";

    /* renamed from: f */
    private Object f778f = "";

    /* renamed from: g */
    private Object f779g = "";

    /* renamed from: h */
    private Object f780h = "";

    private C0295bh() {
        m1318l();
    }

    /* renamed from: l */
    private void m1318l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static C0295bh m1319m() {
        return new C0295bh();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0295bh clear() {
        super.clear();
        this.f774b = 0L;
        this.f773a &= -2;
        this.f775c = EnumC0323ci.SINGLE;
        this.f773a &= -3;
        this.f776d = "";
        this.f773a &= -5;
        this.f777e = "";
        this.f773a &= -9;
        this.f778f = "";
        this.f773a &= -17;
        this.f779g = "";
        this.f773a &= -33;
        this.f780h = "";
        this.f773a &= -65;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0295bh mo5946clone() {
        return m1319m().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0331e getDefaultInstanceForType() {
        return C0331e.m1838a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0331e build() {
        C0331e c0331eBuildPartial = buildPartial();
        if (!c0331eBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0331eBuildPartial);
        }
        return c0331eBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public C0331e m1320n() throws InvalidProtocolBufferException {
        C0331e c0331eBuildPartial = buildPartial();
        if (!c0331eBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0331eBuildPartial).asInvalidProtocolBufferException();
        }
        return c0331eBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0331e buildPartial() {
        C0331e c0331e = new C0331e(this);
        int i = this.f773a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0331e.f946c = this.f774b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0331e.f947d = this.f775c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0331e.f948e = this.f776d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0331e.f949f = this.f777e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0331e.f950g = this.f778f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0331e.f951h = this.f779g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0331e.f952i = this.f780h;
        c0331e.f945b = i2;
        return c0331e;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0295bh mergeFrom(C0331e c0331e) {
        if (c0331e != C0331e.m1838a()) {
            if (c0331e.m1852c()) {
                m1322a(c0331e.m1853d());
            }
            if (c0331e.m1854e()) {
                m1324a(c0331e.m1855f());
            }
            if (c0331e.m1856g()) {
                m1326a(c0331e.m1857h());
            }
            if (c0331e.m1858i()) {
                m1328b(c0331e.m1859j());
            }
            if (c0331e.m1860k()) {
                m1329c(c0331e.m1861l());
            }
            if (c0331e.m1862m()) {
                m1331d(c0331e.m1863n());
            }
            if (c0331e.m1864o()) {
                m1333e(c0331e.m1865p());
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
    public C0295bh mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f773a |= 1;
                    this.f774b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0323ci enumC0323ciM1750a = EnumC0323ci.m1750a(codedInputStream.readEnum());
                    if (enumC0323ciM1750a == null) {
                        break;
                    } else {
                        this.f773a |= 2;
                        this.f775c = enumC0323ciM1750a;
                        break;
                    }
                case MREvent.TILT_RIGHT /* 26 */:
                    this.f773a |= 4;
                    this.f776d = codedInputStream.readBytes();
                    break;
                case MREvent.SHAKE /* 34 */:
                    this.f773a |= 8;
                    this.f777e = codedInputStream.readBytes();
                    break;
                case MREvent.BT_SHARING_SEND_START /* 42 */:
                    this.f773a |= 16;
                    this.f778f = codedInputStream.readBytes();
                    break;
                case MREvent.SNAP1_Y_NEGATIVE /* 50 */:
                    this.f773a |= 32;
                    this.f779g = codedInputStream.readBytes();
                    break;
                case MREvent.SNAP2_Z_NEGATIVE /* 58 */:
                    this.f773a |= 64;
                    this.f780h = codedInputStream.readBytes();
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
    public long m1335f() {
        return this.f774b;
    }

    /* renamed from: a */
    public C0295bh m1322a(long j) {
        this.f773a |= 1;
        this.f774b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0323ci m1336g() {
        return this.f775c;
    }

    /* renamed from: a */
    public C0295bh m1324a(EnumC0323ci enumC0323ci) {
        if (enumC0323ci == null) {
            throw new NullPointerException();
        }
        this.f773a |= 2;
        this.f775c = enumC0323ci;
        return this;
    }

    /* renamed from: h */
    public String m1337h() {
        Object obj = this.f776d;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f776d = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: a */
    public C0295bh m1326a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f773a |= 4;
        this.f776d = str;
        return this;
    }

    /* renamed from: i */
    public String m1338i() {
        Object obj = this.f777e;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f777e = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: b */
    public C0295bh m1328b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f773a |= 8;
        this.f777e = str;
        return this;
    }

    /* renamed from: j */
    public String m1339j() {
        Object obj = this.f778f;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f778f = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: c */
    public C0295bh m1329c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f773a |= 16;
        this.f778f = str;
        return this;
    }

    /* renamed from: d */
    public C0295bh m1331d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f773a |= 32;
        this.f779g = str;
        return this;
    }

    /* renamed from: e */
    public C0295bh m1333e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f773a |= 64;
        this.f780h = str;
        return this;
    }
}
