package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
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
/* renamed from: com.sec.chaton.b.bl */
/* loaded from: classes.dex */
public final class C0299bl extends GeneratedMessageLite.Builder implements InterfaceC0326cl {

    /* renamed from: a */
    private int f795a;

    /* renamed from: b */
    private long f796b;

    /* renamed from: c */
    private EnumC0275ao f797c = EnumC0275ao.TEXT;

    /* renamed from: d */
    private EnumC0323ci f798d = EnumC0323ci.SINGLE;

    /* renamed from: e */
    private Object f799e = "";

    /* renamed from: f */
    private Object f800f = "";

    /* renamed from: g */
    private LazyStringList f801g = LazyStringArrayList.EMPTY;

    /* renamed from: h */
    private Object f802h = "";

    /* renamed from: i */
    private Object f803i = "";

    /* renamed from: j */
    private Object f804j = "";

    /* renamed from: k */
    private Object f805k = "";

    private C0299bl() {
        m1377n();
    }

    /* renamed from: n */
    private void m1377n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public static C0299bl m1378o() {
        return new C0299bl();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0299bl clear() {
        super.clear();
        this.f796b = 0L;
        this.f795a &= -2;
        this.f797c = EnumC0275ao.TEXT;
        this.f795a &= -3;
        this.f798d = EnumC0323ci.SINGLE;
        this.f795a &= -5;
        this.f799e = "";
        this.f795a &= -9;
        this.f800f = "";
        this.f795a &= -17;
        this.f801g = LazyStringArrayList.EMPTY;
        this.f795a &= -33;
        this.f802h = "";
        this.f795a &= -65;
        this.f803i = "";
        this.f795a &= -129;
        this.f804j = "";
        this.f795a &= -257;
        this.f805k = "";
        this.f795a &= -513;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0299bl mo5946clone() {
        return m1378o().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0332f getDefaultInstanceForType() {
        return C0332f.m1878a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0332f build() {
        C0332f c0332fBuildPartial = buildPartial();
        if (!c0332fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0332fBuildPartial);
        }
        return c0332fBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public C0332f m1379p() throws InvalidProtocolBufferException {
        C0332f c0332fBuildPartial = buildPartial();
        if (!c0332fBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0332fBuildPartial).asInvalidProtocolBufferException();
        }
        return c0332fBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0332f buildPartial() {
        C0332f c0332f = new C0332f(this);
        int i = this.f795a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0332f.f957c = this.f796b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0332f.f958d = this.f797c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0332f.f959e = this.f798d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0332f.f960f = this.f799e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0332f.f961g = this.f800f;
        if ((this.f795a & 32) == 32) {
            this.f801g = new UnmodifiableLazyStringList(this.f801g);
            this.f795a &= -33;
        }
        c0332f.f962h = this.f801g;
        if ((i & 64) == 64) {
            i2 |= 32;
        }
        c0332f.f963i = this.f802h;
        if ((i & 128) == 128) {
            i2 |= 64;
        }
        c0332f.f964j = this.f803i;
        if ((i & 256) == 256) {
            i2 |= 128;
        }
        c0332f.f965k = this.f804j;
        if ((i & 512) == 512) {
            i2 |= 256;
        }
        c0332f.f966l = this.f805k;
        c0332f.f956b = i2;
        return c0332f;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0299bl mergeFrom(C0332f c0332f) {
        if (c0332f != C0332f.m1878a()) {
            if (c0332f.m1891c()) {
                m1382a(c0332f.m1892d());
            }
            if (c0332f.m1893e()) {
                m1384a(c0332f.m1894f());
            }
            if (c0332f.m1895g()) {
                m1385a(c0332f.m1896h());
            }
            if (c0332f.m1897i()) {
                m1387a(c0332f.m1898j());
            }
            if (c0332f.m1899k()) {
                m1389b(c0332f.m1900l());
            }
            if (!c0332f.f962h.isEmpty()) {
                if (this.f801g.isEmpty()) {
                    this.f801g = c0332f.f962h;
                    this.f795a &= -33;
                } else {
                    m1380q();
                    this.f801g.addAll(c0332f.f962h);
                }
            }
            if (c0332f.m1902n()) {
                m1392d(c0332f.m1903o());
            }
            if (c0332f.m1904p()) {
                m1394e(c0332f.m1905q());
            }
            if (c0332f.m1906r()) {
                m1397f(c0332f.m1907s());
            }
            if (c0332f.m1908t()) {
                m1399g(c0332f.m1909u());
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
    public C0299bl mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f795a |= 1;
                    this.f796b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0275ao enumC0275aoM1170a = EnumC0275ao.m1170a(codedInputStream.readEnum());
                    if (enumC0275aoM1170a == null) {
                        break;
                    } else {
                        this.f795a |= 2;
                        this.f797c = enumC0275aoM1170a;
                        break;
                    }
                case MREvent.TILT_FRONT_BACK_END /* 24 */:
                    EnumC0323ci enumC0323ciM1750a = EnumC0323ci.m1750a(codedInputStream.readEnum());
                    if (enumC0323ciM1750a == null) {
                        break;
                    } else {
                        this.f795a |= 4;
                        this.f798d = enumC0323ciM1750a;
                        break;
                    }
                case MREvent.SHAKE /* 34 */:
                    this.f795a |= 8;
                    this.f799e = codedInputStream.readBytes();
                    break;
                case MREvent.BT_SHARING_SEND_START /* 42 */:
                    this.f795a |= 16;
                    this.f800f = codedInputStream.readBytes();
                    break;
                case MREvent.SNAP1_Y_NEGATIVE /* 50 */:
                    m1380q();
                    this.f801g.add(codedInputStream.readBytes());
                    break;
                case MREvent.SNAP2_Z_NEGATIVE /* 58 */:
                    this.f795a |= 64;
                    this.f802h = codedInputStream.readBytes();
                    break;
                case MREvent.BLOW /* 66 */:
                    this.f795a |= 128;
                    this.f803i = codedInputStream.readBytes();
                    break;
                case MREvent.LOCK_EXECUTE_CAMERA_R /* 74 */:
                    this.f795a |= 256;
                    this.f804j = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_DOWN_LEVEL_2 /* 82 */:
                    this.f795a |= 512;
                    this.f805k = codedInputStream.readBytes();
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
    public long m1396f() {
        return this.f796b;
    }

    /* renamed from: a */
    public C0299bl m1382a(long j) {
        this.f795a |= 1;
        this.f796b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0275ao m1398g() {
        return this.f797c;
    }

    /* renamed from: a */
    public C0299bl m1384a(EnumC0275ao enumC0275ao) {
        if (enumC0275ao == null) {
            throw new NullPointerException();
        }
        this.f795a |= 2;
        this.f797c = enumC0275ao;
        return this;
    }

    /* renamed from: h */
    public EnumC0323ci m1400h() {
        return this.f798d;
    }

    /* renamed from: a */
    public C0299bl m1385a(EnumC0323ci enumC0323ci) {
        if (enumC0323ci == null) {
            throw new NullPointerException();
        }
        this.f795a |= 4;
        this.f798d = enumC0323ci;
        return this;
    }

    /* renamed from: i */
    public String m1401i() {
        Object obj = this.f799e;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f799e = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: a */
    public C0299bl m1387a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f795a |= 8;
        this.f799e = str;
        return this;
    }

    /* renamed from: j */
    public String m1402j() {
        Object obj = this.f800f;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f800f = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: b */
    public C0299bl m1389b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f795a |= 16;
        this.f800f = str;
        return this;
    }

    /* renamed from: q */
    private void m1380q() {
        if ((this.f795a & 32) != 32) {
            this.f801g = new LazyStringArrayList(this.f801g);
            this.f795a |= 32;
        }
    }

    /* renamed from: k */
    public List m1403k() {
        return Collections.unmodifiableList(this.f801g);
    }

    /* renamed from: c */
    public C0299bl m1390c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m1380q();
        this.f801g.add((LazyStringList) str);
        return this;
    }

    /* renamed from: d */
    public C0299bl m1392d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f795a |= 64;
        this.f802h = str;
        return this;
    }

    /* renamed from: e */
    public C0299bl m1394e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f795a |= 128;
        this.f803i = str;
        return this;
    }

    /* renamed from: l */
    public String m1404l() {
        Object obj = this.f804j;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f804j = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: f */
    public C0299bl m1397f(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f795a |= 256;
        this.f804j = str;
        return this;
    }

    /* renamed from: g */
    public C0299bl m1399g(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f795a |= 512;
        this.f805k = str;
        return this;
    }
}
