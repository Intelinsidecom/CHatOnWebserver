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
/* renamed from: com.sec.chaton.b.bm */
/* loaded from: classes.dex */
public final class C0300bm extends GeneratedMessageLite.Builder implements InterfaceC0252a {

    /* renamed from: a */
    private int f806a;

    /* renamed from: b */
    private long f807b;

    /* renamed from: c */
    private EnumC0323ci f808c = EnumC0323ci.SINGLE;

    /* renamed from: d */
    private Object f809d = "";

    /* renamed from: e */
    private Object f810e = "";

    /* renamed from: f */
    private Object f811f = "";

    /* renamed from: g */
    private LazyStringList f812g = LazyStringArrayList.EMPTY;

    private C0300bm() {
        m1407l();
    }

    /* renamed from: l */
    private void m1407l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public static C0300bm m1408m() {
        return new C0300bm();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0300bm clear() {
        super.clear();
        this.f807b = 0L;
        this.f806a &= -2;
        this.f808c = EnumC0323ci.SINGLE;
        this.f806a &= -3;
        this.f809d = "";
        this.f806a &= -5;
        this.f810e = "";
        this.f806a &= -9;
        this.f811f = "";
        this.f806a &= -17;
        this.f812g = LazyStringArrayList.EMPTY;
        this.f806a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0300bm mo5946clone() {
        return m1408m().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0267ag getDefaultInstanceForType() {
        return C0267ag.m1055a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0267ag build() {
        C0267ag c0267agBuildPartial = buildPartial();
        if (!c0267agBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0267agBuildPartial);
        }
        return c0267agBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public C0267ag m1409n() throws InvalidProtocolBufferException {
        C0267ag c0267agBuildPartial = buildPartial();
        if (!c0267agBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0267agBuildPartial).asInvalidProtocolBufferException();
        }
        return c0267agBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0267ag buildPartial() {
        C0267ag c0267ag = new C0267ag(this);
        int i = this.f806a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0267ag.f676c = this.f807b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0267ag.f677d = this.f808c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0267ag.f678e = this.f809d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0267ag.f679f = this.f810e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0267ag.f680g = this.f811f;
        if ((this.f806a & 32) == 32) {
            this.f812g = new UnmodifiableLazyStringList(this.f812g);
            this.f806a &= -33;
        }
        c0267ag.f681h = this.f812g;
        c0267ag.f675b = i2;
        return c0267ag;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0300bm mergeFrom(C0267ag c0267ag) {
        if (c0267ag != C0267ag.m1055a()) {
            if (c0267ag.m1068c()) {
                m1412a(c0267ag.m1069d());
            }
            if (c0267ag.m1070e()) {
                m1415a(c0267ag.m1071f());
            }
            if (c0267ag.m1072g()) {
                m1416a(c0267ag.m1073h());
            }
            if (c0267ag.m1074i()) {
                m1418b(c0267ag.m1075j());
            }
            if (c0267ag.m1076k()) {
                m1420c(c0267ag.m1077l());
            }
            if (!c0267ag.f681h.isEmpty()) {
                if (this.f812g.isEmpty()) {
                    this.f812g = c0267ag.f681h;
                    this.f806a &= -33;
                } else {
                    m1410o();
                    this.f812g.addAll(c0267ag.f681h);
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
    public C0300bm mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f806a |= 1;
                    this.f807b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0323ci enumC0323ciM1750a = EnumC0323ci.m1750a(codedInputStream.readEnum());
                    if (enumC0323ciM1750a == null) {
                        break;
                    } else {
                        this.f806a |= 2;
                        this.f808c = enumC0323ciM1750a;
                        break;
                    }
                case MREvent.TILT_RIGHT /* 26 */:
                    this.f806a |= 4;
                    this.f809d = codedInputStream.readBytes();
                    break;
                case MREvent.SHAKE /* 34 */:
                    this.f806a |= 8;
                    this.f810e = codedInputStream.readBytes();
                    break;
                case MREvent.BT_SHARING_SEND_START /* 42 */:
                    this.f806a |= 16;
                    this.f811f = codedInputStream.readBytes();
                    break;
                case MREvent.SNAP1_Y_NEGATIVE /* 50 */:
                    m1410o();
                    this.f812g.add(codedInputStream.readBytes());
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
    public long m1424f() {
        return this.f807b;
    }

    /* renamed from: a */
    public C0300bm m1412a(long j) {
        this.f806a |= 1;
        this.f807b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0323ci m1425g() {
        return this.f808c;
    }

    /* renamed from: a */
    public C0300bm m1415a(EnumC0323ci enumC0323ci) {
        if (enumC0323ci == null) {
            throw new NullPointerException();
        }
        this.f806a |= 2;
        this.f808c = enumC0323ci;
        return this;
    }

    /* renamed from: h */
    public String m1426h() {
        Object obj = this.f809d;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f809d = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: a */
    public C0300bm m1416a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f806a |= 4;
        this.f809d = str;
        return this;
    }

    /* renamed from: b */
    public C0300bm m1418b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f806a |= 8;
        this.f810e = str;
        return this;
    }

    /* renamed from: i */
    public String m1427i() {
        Object obj = this.f811f;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f811f = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: c */
    public C0300bm m1420c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f806a |= 16;
        this.f811f = str;
        return this;
    }

    /* renamed from: o */
    private void m1410o() {
        if ((this.f806a & 32) != 32) {
            this.f812g = new LazyStringArrayList(this.f812g);
            this.f806a |= 32;
        }
    }

    /* renamed from: j */
    public List m1428j() {
        return Collections.unmodifiableList(this.f812g);
    }

    /* renamed from: d */
    public C0300bm m1422d(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m1410o();
        this.f812g.add((LazyStringList) str);
        return this;
    }
}
