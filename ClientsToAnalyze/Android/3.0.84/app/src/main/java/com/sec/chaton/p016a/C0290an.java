package com.sec.chaton.p016a;

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
/* renamed from: com.sec.chaton.a.an */
/* loaded from: classes.dex */
public final class C0290an extends GeneratedMessageLite.Builder<C0289am, C0290an> implements InterfaceC0291ao {

    /* renamed from: a */
    private int f931a;

    /* renamed from: b */
    private long f932b;

    /* renamed from: c */
    private EnumC0302az f933c = EnumC0302az.SINGLE;

    /* renamed from: d */
    private Object f934d = "";

    /* renamed from: e */
    private Object f935e = "";

    /* renamed from: f */
    private LazyStringList f936f = LazyStringArrayList.EMPTY;

    /* renamed from: g */
    private EnumC0292ap f937g = EnumC0292ap.ADD;

    /* renamed from: h */
    private LazyStringList f938h = LazyStringArrayList.EMPTY;

    /* renamed from: i */
    private long f939i;

    private C0290an() {
        m1551q();
    }

    /* renamed from: q */
    private void m1551q() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public static C0290an m1552r() {
        return new C0290an();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0290an clear() {
        super.clear();
        this.f932b = 0L;
        this.f931a &= -2;
        this.f933c = EnumC0302az.SINGLE;
        this.f931a &= -3;
        this.f934d = "";
        this.f931a &= -5;
        this.f935e = "";
        this.f931a &= -9;
        this.f936f = LazyStringArrayList.EMPTY;
        this.f931a &= -17;
        this.f937g = EnumC0292ap.ADD;
        this.f931a &= -33;
        this.f938h = LazyStringArrayList.EMPTY;
        this.f931a &= -65;
        this.f939i = 0L;
        this.f931a &= -129;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0290an mo13386clone() {
        return m1552r().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0289am getDefaultInstanceForType() {
        return C0289am.m1518a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0289am build() {
        C0289am c0289amBuildPartial = buildPartial();
        if (!c0289amBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0289amBuildPartial);
        }
        return c0289amBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public C0289am m1553s() throws InvalidProtocolBufferException {
        C0289am c0289amBuildPartial = buildPartial();
        if (!c0289amBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0289amBuildPartial).asInvalidProtocolBufferException();
        }
        return c0289amBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0289am buildPartial() {
        C0289am c0289am = new C0289am(this);
        int i = this.f931a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0289am.f921c = this.f932b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0289am.f922d = this.f933c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0289am.f923e = this.f934d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0289am.f924f = this.f935e;
        if ((this.f931a & 16) == 16) {
            this.f936f = new UnmodifiableLazyStringList(this.f936f);
            this.f931a &= -17;
        }
        c0289am.f925g = this.f936f;
        if ((i & 32) == 32) {
            i2 |= 16;
        }
        c0289am.f926h = this.f937g;
        if ((this.f931a & 64) == 64) {
            this.f938h = new UnmodifiableLazyStringList(this.f938h);
            this.f931a &= -65;
        }
        c0289am.f927i = this.f938h;
        if ((i & 128) == 128) {
            i2 |= 32;
        }
        c0289am.f928j = this.f939i;
        c0289am.f920b = i2;
        return c0289am;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0290an mergeFrom(C0289am c0289am) {
        if (c0289am != C0289am.m1518a()) {
            if (c0289am.m1533c()) {
                m1557a(c0289am.m1534d());
            }
            if (c0289am.m1535e()) {
                m1561a(c0289am.m1536f());
            }
            if (c0289am.m1537g()) {
                m1563a(c0289am.m1538h());
            }
            if (c0289am.m1539i()) {
                m1566b(c0289am.m1540j());
            }
            if (!c0289am.f925g.isEmpty()) {
                if (this.f936f.isEmpty()) {
                    this.f936f = c0289am.f925g;
                    this.f931a &= -17;
                } else {
                    m1554t();
                    this.f936f.addAll(c0289am.f925g);
                }
            }
            if (c0289am.m1542l()) {
                m1560a(c0289am.m1543m());
            }
            if (!c0289am.f927i.isEmpty()) {
                if (this.f938h.isEmpty()) {
                    this.f938h = c0289am.f927i;
                    this.f931a &= -65;
                } else {
                    m1555u();
                    this.f938h.addAll(c0289am.f927i);
                }
            }
            if (c0289am.m1545o()) {
                m1565b(c0289am.m1546p());
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
    public C0290an mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f931a |= 1;
                    this.f932b = codedInputStream.readInt64();
                    break;
                case 16:
                    EnumC0302az enumC0302azM1704a = EnumC0302az.m1704a(codedInputStream.readEnum());
                    if (enumC0302azM1704a == null) {
                        break;
                    } else {
                        this.f931a |= 2;
                        this.f933c = enumC0302azM1704a;
                        break;
                    }
                case 26:
                    this.f931a |= 4;
                    this.f934d = codedInputStream.readBytes();
                    break;
                case 34:
                    this.f931a |= 8;
                    this.f935e = codedInputStream.readBytes();
                    break;
                case 42:
                    m1554t();
                    this.f936f.add(codedInputStream.readBytes());
                    break;
                case 48:
                    EnumC0292ap enumC0292apM1581a = EnumC0292ap.m1581a(codedInputStream.readEnum());
                    if (enumC0292apM1581a == null) {
                        break;
                    } else {
                        this.f931a |= 32;
                        this.f937g = enumC0292apM1581a;
                        break;
                    }
                case 58:
                    m1555u();
                    this.f938h.add(codedInputStream.readBytes());
                    break;
                case 64:
                    this.f931a |= 128;
                    this.f939i = codedInputStream.readInt64();
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
    public long m1571f() {
        return this.f932b;
    }

    /* renamed from: a */
    public C0290an m1557a(long j) {
        this.f931a |= 1;
        this.f932b = j;
        return this;
    }

    /* renamed from: g */
    public EnumC0302az m1572g() {
        return this.f933c;
    }

    /* renamed from: a */
    public C0290an m1561a(EnumC0302az enumC0302az) {
        if (enumC0302az == null) {
            throw new NullPointerException();
        }
        this.f931a |= 2;
        this.f933c = enumC0302az;
        return this;
    }

    /* renamed from: h */
    public String m1573h() {
        Object obj = this.f934d;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f934d = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: a */
    public C0290an m1563a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f931a |= 4;
        this.f934d = str;
        return this;
    }

    /* renamed from: i */
    public String m1574i() {
        Object obj = this.f935e;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.f935e = stringUtf8;
        return stringUtf8;
    }

    /* renamed from: b */
    public C0290an m1566b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f931a |= 8;
        this.f935e = str;
        return this;
    }

    /* renamed from: t */
    private void m1554t() {
        if ((this.f931a & 16) != 16) {
            this.f936f = new LazyStringArrayList(this.f936f);
            this.f931a |= 16;
        }
    }

    /* renamed from: j */
    public List<String> m1575j() {
        return Collections.unmodifiableList(this.f936f);
    }

    /* renamed from: k */
    public int m1576k() {
        return this.f936f.size();
    }

    /* renamed from: c */
    public C0290an m1568c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        m1554t();
        this.f936f.add((LazyStringList) str);
        return this;
    }

    /* renamed from: l */
    public EnumC0292ap m1577l() {
        return this.f937g;
    }

    /* renamed from: a */
    public C0290an m1560a(EnumC0292ap enumC0292ap) {
        if (enumC0292ap == null) {
            throw new NullPointerException();
        }
        this.f931a |= 32;
        this.f937g = enumC0292ap;
        return this;
    }

    /* renamed from: u */
    private void m1555u() {
        if ((this.f931a & 64) != 64) {
            this.f938h = new LazyStringArrayList(this.f938h);
            this.f931a |= 64;
        }
    }

    /* renamed from: m */
    public List<String> m1578m() {
        return Collections.unmodifiableList(this.f938h);
    }

    /* renamed from: n */
    public int m1579n() {
        return this.f938h.size();
    }

    /* renamed from: a */
    public C0290an m1562a(Iterable<String> iterable) {
        m1555u();
        GeneratedMessageLite.Builder.addAll(iterable, this.f938h);
        return this;
    }

    /* renamed from: o */
    public long m1580o() {
        return this.f939i;
    }

    /* renamed from: b */
    public C0290an m1565b(long j) {
        this.f931a |= 128;
        this.f939i = j;
        return this;
    }
}
