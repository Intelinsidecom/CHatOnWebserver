package com.sec.chaton.p007a;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.LazyStringArrayList;
import com.google.protobuf.LazyStringList;
import com.google.protobuf.UnmodifiableLazyStringList;
import com.sec.chaton.C0229at;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.a.j */
/* loaded from: classes.dex */
public final class C0183j extends GeneratedMessageLite.Builder implements InterfaceC0184k {

    /* renamed from: a */
    private int f671a;

    /* renamed from: b */
    private long f672b;

    /* renamed from: f */
    private long f676f;

    /* renamed from: c */
    private Object f673c = "";

    /* renamed from: d */
    private List f674d = Collections.emptyList();

    /* renamed from: e */
    private LazyStringList f675e = LazyStringArrayList.EMPTY;

    /* renamed from: g */
    private Object f677g = "";

    private C0183j() {
        m1618g();
    }

    /* renamed from: g */
    private void m1618g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0183j m1619h() {
        return new C0183j();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0183j clear() {
        super.clear();
        this.f672b = 0L;
        this.f671a &= -2;
        this.f673c = "";
        this.f671a &= -3;
        this.f674d = Collections.emptyList();
        this.f671a &= -5;
        this.f675e = LazyStringArrayList.EMPTY;
        this.f671a &= -9;
        this.f676f = 0L;
        this.f671a &= -17;
        this.f677g = "";
        this.f671a &= -33;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0183j mo7542clone() {
        return m1619h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0182i getDefaultInstanceForType() {
        return C0182i.m1588a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0182i build() {
        C0182i c0182iBuildPartial = buildPartial();
        if (!c0182iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0182iBuildPartial);
        }
        return c0182iBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0182i m1620i() throws InvalidProtocolBufferException {
        C0182i c0182iBuildPartial = buildPartial();
        if (!c0182iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0182iBuildPartial).asInvalidProtocolBufferException();
        }
        return c0182iBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0182i buildPartial() {
        C0182i c0182i = new C0182i(this);
        int i = this.f671a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0182i.f663c = this.f672b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0182i.f664d = this.f673c;
        if ((this.f671a & 4) == 4) {
            this.f674d = Collections.unmodifiableList(this.f674d);
            this.f671a &= -5;
        }
        c0182i.f665e = this.f674d;
        if ((this.f671a & 8) == 8) {
            this.f675e = new UnmodifiableLazyStringList(this.f675e);
            this.f671a &= -9;
        }
        c0182i.f666f = this.f675e;
        if ((i & 16) == 16) {
            i2 |= 4;
        }
        c0182i.f667g = this.f676f;
        if ((i & 32) == 32) {
            i2 |= 8;
        }
        c0182i.f668h = this.f677g;
        c0182i.f662b = i2;
        return c0182i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0183j mergeFrom(C0182i c0182i) {
        if (c0182i != C0182i.m1588a()) {
            if (c0182i.m1602c()) {
                m1624a(c0182i.m1603d());
            }
            if (c0182i.m1604e()) {
                m1628a(c0182i.m1605f());
            }
            if (!c0182i.f665e.isEmpty()) {
                if (this.f674d.isEmpty()) {
                    this.f674d = c0182i.f665e;
                    this.f671a &= -5;
                } else {
                    m1621j();
                    this.f674d.addAll(c0182i.f665e);
                }
            }
            if (!c0182i.f666f.isEmpty()) {
                if (this.f675e.isEmpty()) {
                    this.f675e = c0182i.f666f;
                    this.f671a &= -9;
                } else {
                    m1622k();
                    this.f675e.addAll(c0182i.f666f);
                }
            }
            if (c0182i.m1610k()) {
                m1630b(c0182i.m1611l());
            }
            if (c0182i.m1612m()) {
                m1631b(c0182i.m1613n());
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
    public C0183j mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f671a |= 1;
                    this.f672b = codedInputStream.readInt64();
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    this.f671a |= 2;
                    this.f673c = codedInputStream.readBytes();
                    break;
                case C0229at.HorizontalSrollView_android_nextFocusRight /* 26 */:
                    C0198y c0198yNewBuilder = C0197x.newBuilder();
                    codedInputStream.readMessage(c0198yNewBuilder, extensionRegistryLite);
                    m1627a(c0198yNewBuilder.buildPartial());
                    break;
                case C0229at.HorizontalSrollView_android_minWidth /* 34 */:
                    m1622k();
                    this.f675e.add(codedInputStream.readBytes());
                    break;
                case C0229at.HorizontalSrollView_android_onClick /* 40 */:
                    this.f671a |= 16;
                    this.f676f = codedInputStream.readInt64();
                    break;
                case 50:
                    this.f671a |= 32;
                    this.f677g = codedInputStream.readBytes();
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
    public C0183j m1624a(long j) {
        this.f671a |= 1;
        this.f672b = j;
        return this;
    }

    /* renamed from: a */
    public C0183j m1628a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f671a |= 2;
        this.f673c = str;
        return this;
    }

    /* renamed from: j */
    private void m1621j() {
        if ((this.f671a & 4) != 4) {
            this.f674d = new ArrayList(this.f674d);
            this.f671a |= 4;
        }
    }

    /* renamed from: a */
    public C0183j m1627a(C0197x c0197x) {
        if (c0197x == null) {
            throw new NullPointerException();
        }
        m1621j();
        this.f674d.add(c0197x);
        return this;
    }

    /* renamed from: k */
    private void m1622k() {
        if ((this.f671a & 8) != 8) {
            this.f675e = new LazyStringArrayList(this.f675e);
            this.f671a |= 8;
        }
    }

    /* renamed from: b */
    public C0183j m1630b(long j) {
        this.f671a |= 16;
        this.f676f = j;
        return this;
    }

    /* renamed from: b */
    public C0183j m1631b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f671a |= 32;
        this.f677g = str;
        return this;
    }
}
