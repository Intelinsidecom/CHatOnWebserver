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
/* renamed from: com.sec.chaton.b.bq */
/* loaded from: classes.dex */
public final class C0304bq extends GeneratedMessageLite.Builder implements InterfaceC0291bd {

    /* renamed from: a */
    private int f827a;

    /* renamed from: b */
    private long f828b;

    /* renamed from: g */
    private long f833g;

    /* renamed from: c */
    private EnumC0275ao f829c = EnumC0275ao.TEXT;

    /* renamed from: d */
    private EnumC0323ci f830d = EnumC0323ci.SINGLE;

    /* renamed from: e */
    private Object f831e = "";

    /* renamed from: f */
    private Object f832f = "";

    /* renamed from: h */
    private Object f834h = "";

    /* renamed from: i */
    private LazyStringList f835i = LazyStringArrayList.EMPTY;

    /* renamed from: j */
    private Object f836j = "";

    private C0304bq() {
        m1466m();
    }

    /* renamed from: m */
    private void m1466m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public static C0304bq m1467n() {
        return new C0304bq();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0304bq clear() {
        super.clear();
        this.f828b = 0L;
        this.f827a &= -2;
        this.f829c = EnumC0275ao.TEXT;
        this.f827a &= -3;
        this.f830d = EnumC0323ci.SINGLE;
        this.f827a &= -5;
        this.f831e = "";
        this.f827a &= -9;
        this.f832f = "";
        this.f827a &= -17;
        this.f833g = 0L;
        this.f827a &= -33;
        this.f834h = "";
        this.f827a &= -65;
        this.f835i = LazyStringArrayList.EMPTY;
        this.f827a &= -129;
        this.f836j = "";
        this.f827a &= -257;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0304bq mo5946clone() {
        return m1467n().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0268ah getDefaultInstanceForType() {
        return C0268ah.m1084a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0268ah build() {
        C0268ah c0268ahBuildPartial = buildPartial();
        if (!c0268ahBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0268ahBuildPartial);
        }
        return c0268ahBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public C0268ah m1468o() throws InvalidProtocolBufferException {
        C0268ah c0268ahBuildPartial = buildPartial();
        if (!c0268ahBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0268ahBuildPartial).asInvalidProtocolBufferException();
        }
        return c0268ahBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0268ah buildPartial() {
        C0268ah c0268ah = new C0268ah(this);
        int i = this.f827a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0268ah.f686c = this.f828b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0268ah.f687d = this.f829c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0268ah.f688e = this.f830d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0268ah.f689f = this.f831e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0268ah.f690g = this.f832f;
        if ((i & 32) == 32) {
            i2 |= 32;
        }
        c0268ah.f691h = this.f833g;
        if ((i & 64) == 64) {
            i2 |= 64;
        }
        c0268ah.f692i = this.f834h;
        if ((this.f827a & 128) == 128) {
            this.f835i = new UnmodifiableLazyStringList(this.f835i);
            this.f827a &= -129;
        }
        c0268ah.f693j = this.f835i;
        if ((i & 256) == 256) {
            i2 |= 128;
        }
        c0268ah.f694k = this.f836j;
        c0268ah.f685b = i2;
        return c0268ah;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0304bq mergeFrom(C0268ah c0268ah) {
        if (c0268ah != C0268ah.m1084a()) {
            if (c0268ah.m1101c()) {
                m1471a(c0268ah.m1102d());
            }
            if (c0268ah.m1103e()) {
                m1474a(c0268ah.m1104f());
            }
            if (c0268ah.m1105g()) {
                m1475a(c0268ah.m1106h());
            }
            if (c0268ah.m1107i()) {
                m1476a(c0268ah.m1108j());
            }
            if (c0268ah.m1109k()) {
                m1479b(c0268ah.m1110l());
            }
            if (c0268ah.m1111m()) {
                m1478b(c0268ah.m1112n());
            }
            if (c0268ah.m1113o()) {
                m1481c(c0268ah.m1114p());
            }
            if (!c0268ah.f693j.isEmpty()) {
                if (this.f835i.isEmpty()) {
                    this.f835i = c0268ah.f693j;
                    this.f827a &= -129;
                } else {
                    m1469p();
                    this.f835i.addAll(c0268ah.f693j);
                }
            }
            if (c0268ah.m1116r()) {
                m1485e(c0268ah.m1117s());
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
    public C0304bq mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f827a |= 1;
                    this.f828b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0275ao enumC0275aoM1170a = EnumC0275ao.m1170a(codedInputStream.readEnum());
                    if (enumC0275aoM1170a == null) {
                        break;
                    } else {
                        this.f827a |= 2;
                        this.f829c = enumC0275aoM1170a;
                        break;
                    }
                case MREvent.TILT_FRONT_BACK_END /* 24 */:
                    EnumC0323ci enumC0323ciM1750a = EnumC0323ci.m1750a(codedInputStream.readEnum());
                    if (enumC0323ciM1750a == null) {
                        break;
                    } else {
                        this.f827a |= 4;
                        this.f830d = enumC0323ciM1750a;
                        break;
                    }
                case MREvent.SHAKE /* 34 */:
                    this.f827a |= 8;
                    this.f831e = codedInputStream.readBytes();
                    break;
                case MREvent.BT_SHARING_SEND_START /* 42 */:
                    this.f827a |= 16;
                    this.f832f = codedInputStream.readBytes();
                    break;
                case MREvent.SNAP1_X_NEGATIVE /* 48 */:
                    this.f827a |= 32;
                    this.f833g = codedInputStream.readInt64();
                    break;
                case MREvent.SNAP2_Z_NEGATIVE /* 58 */:
                    this.f827a |= 64;
                    this.f834h = codedInputStream.readBytes();
                    break;
                case MREvent.BLOW /* 66 */:
                    m1469p();
                    this.f835i.add(codedInputStream.readBytes());
                    break;
                case MREvent.LOCK_EXECUTE_CAMERA_R /* 74 */:
                    this.f827a |= 256;
                    this.f836j = codedInputStream.readBytes();
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
    public long m1486f() {
        return this.f828b;
    }

    /* renamed from: a */
    public C0304bq m1471a(long j) {
        this.f827a |= 1;
        this.f828b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0275ao m1487g() {
        return this.f829c;
    }

    /* renamed from: a */
    public C0304bq m1474a(EnumC0275ao enumC0275ao) {
        if (enumC0275ao == null) {
            throw new NullPointerException();
        }
        this.f827a |= 2;
        this.f829c = enumC0275ao;
        return this;
    }

    /* renamed from: h */
    public EnumC0323ci m1488h() {
        return this.f830d;
    }

    /* renamed from: a */
    public C0304bq m1475a(EnumC0323ci enumC0323ci) {
        if (enumC0323ci == null) {
            throw new NullPointerException();
        }
        this.f827a |= 4;
        this.f830d = enumC0323ci;
        return this;
    }

    /* renamed from: a */
    public C0304bq m1476a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f827a |= 8;
        this.f831e = str;
        return this;
    }

    /* renamed from: b */
    public C0304bq m1479b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f827a |= 16;
        this.f832f = str;
        return this;
    }

    /* renamed from: b */
    public C0304bq m1478b(long j) {
        this.f827a |= 32;
        this.f833g = j;
        return this;
    }

    /* renamed from: i */
    public String m1489i() {
        Object obj = this.f834h;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f834h = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: c */
    public C0304bq m1481c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f827a |= 64;
        this.f834h = str;
        return this;
    }

    /* renamed from: p */
    private void m1469p() {
        if ((this.f827a & 128) != 128) {
            this.f835i = new LazyStringArrayList(this.f835i);
            this.f827a |= 128;
        }
    }

    /* renamed from: j */
    public List m1490j() {
        return Collections.unmodifiableList(this.f835i);
    }

    /* renamed from: d */
    public C0304bq m1483d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m1469p();
        this.f835i.add((LazyStringList) str);
        return this;
    }

    /* renamed from: k */
    public String m1491k() {
        Object obj = this.f836j;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f836j = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: e */
    public C0304bq m1485e(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f827a |= 256;
        this.f836j = str;
        return this;
    }
}
