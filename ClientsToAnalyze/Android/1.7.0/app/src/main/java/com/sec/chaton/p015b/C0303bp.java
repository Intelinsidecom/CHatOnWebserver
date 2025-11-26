package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
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
/* renamed from: com.sec.chaton.b.bp */
/* loaded from: classes.dex */
public final class C0303bp extends GeneratedMessageLite.Builder implements InterfaceC0279as {

    /* renamed from: a */
    private int f820a;

    /* renamed from: b */
    private long f821b;

    /* renamed from: f */
    private long f825f;

    /* renamed from: c */
    private Object f822c = "";

    /* renamed from: d */
    private List f823d = Collections.emptyList();

    /* renamed from: e */
    private LazyStringList f824e = LazyStringArrayList.EMPTY;

    /* renamed from: g */
    private Object f826g = "";

    private C0303bp() {
        m1447g();
    }

    /* renamed from: g */
    private void m1447g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0303bp m1448h() {
        return new C0303bp();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0303bp clear() {
        super.clear();
        this.f821b = 0L;
        this.f820a &= -2;
        this.f822c = "";
        this.f820a &= -3;
        this.f823d = Collections.emptyList();
        this.f820a &= -5;
        this.f824e = LazyStringArrayList.EMPTY;
        this.f820a &= -9;
        this.f825f = 0L;
        this.f820a &= -17;
        this.f826g = "";
        this.f820a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0303bp mo5946clone() {
        return m1448h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0314c getDefaultInstanceForType() {
        return C0314c.m1635a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0314c build() {
        C0314c c0314cBuildPartial = buildPartial();
        if (!c0314cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0314cBuildPartial);
        }
        return c0314cBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0314c m1449i() throws InvalidProtocolBufferException {
        C0314c c0314cBuildPartial = buildPartial();
        if (!c0314cBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0314cBuildPartial).asInvalidProtocolBufferException();
        }
        return c0314cBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0314c buildPartial() {
        C0314c c0314c = new C0314c(this);
        int i = this.f820a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0314c.f878c = this.f821b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0314c.f879d = this.f822c;
        if ((this.f820a & 4) == 4) {
            this.f823d = Collections.unmodifiableList(this.f823d);
            this.f820a &= -5;
        }
        c0314c.f880e = this.f823d;
        if ((this.f820a & 8) == 8) {
            this.f824e = new UnmodifiableLazyStringList(this.f824e);
            this.f820a &= -9;
        }
        c0314c.f881f = this.f824e;
        if ((i & 16) == 16) {
            i2 |= 4;
        }
        c0314c.f882g = this.f825f;
        if ((i & 32) == 32) {
            i2 |= 8;
        }
        c0314c.f883h = this.f826g;
        c0314c.f877b = i2;
        return c0314c;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0303bp mergeFrom(C0314c c0314c) {
        if (c0314c != C0314c.m1635a()) {
            if (c0314c.m1648c()) {
                m1453a(c0314c.m1649d());
            }
            if (c0314c.m1650e()) {
                m1457a(c0314c.m1651f());
            }
            if (!c0314c.f880e.isEmpty()) {
                if (this.f823d.isEmpty()) {
                    this.f823d = c0314c.f880e;
                    this.f820a &= -5;
                } else {
                    m1450j();
                    this.f823d.addAll(c0314c.f880e);
                }
            }
            if (!c0314c.f881f.isEmpty()) {
                if (this.f824e.isEmpty()) {
                    this.f824e = c0314c.f881f;
                    this.f820a &= -9;
                } else {
                    m1451k();
                    this.f824e.addAll(c0314c.f881f);
                }
            }
            if (c0314c.m1656k()) {
                m1459b(c0314c.m1657l());
            }
            if (c0314c.m1658m()) {
                m1460b(c0314c.m1659n());
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
    public C0303bp mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f820a |= 1;
                    this.f821b = codedInputStream.readInt64();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    this.f820a |= 2;
                    this.f822c = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_RIGHT /* 26 */:
                    C0284ax c0284axNewBuilder = C0333g.newBuilder();
                    codedInputStream.readMessage(c0284axNewBuilder, extensionRegistryLite);
                    m1456a(c0284axNewBuilder.buildPartial());
                    break;
                case MREvent.SHAKE /* 34 */:
                    m1451k();
                    this.f824e.add(codedInputStream.readBytes());
                    break;
                case MREvent.BT_SHARING_RECEIVE_READY /* 40 */:
                    this.f820a |= 16;
                    this.f825f = codedInputStream.readInt64();
                    break;
                case MREvent.SNAP1_Y_NEGATIVE /* 50 */:
                    this.f820a |= 32;
                    this.f826g = codedInputStream.readBytes();
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
    public C0303bp m1453a(long j) {
        this.f820a |= 1;
        this.f821b = j;
        return this;
    }

    /* renamed from: a */
    public C0303bp m1457a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f820a |= 2;
        this.f822c = str;
        return this;
    }

    /* renamed from: j */
    private void m1450j() {
        if ((this.f820a & 4) != 4) {
            this.f823d = new ArrayList(this.f823d);
            this.f820a |= 4;
        }
    }

    /* renamed from: a */
    public C0303bp m1456a(C0333g c0333g) {
        if (c0333g == null) {
            throw new NullPointerException();
        }
        m1450j();
        this.f823d.add(c0333g);
        return this;
    }

    /* renamed from: k */
    private void m1451k() {
        if ((this.f820a & 8) != 8) {
            this.f824e = new LazyStringArrayList(this.f824e);
            this.f820a |= 8;
        }
    }

    /* renamed from: b */
    public C0303bp m1459b(long j) {
        this.f820a |= 16;
        this.f825f = j;
        return this;
    }

    /* renamed from: b */
    public C0303bp m1460b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f820a |= 32;
        this.f826g = str;
        return this;
    }
}
