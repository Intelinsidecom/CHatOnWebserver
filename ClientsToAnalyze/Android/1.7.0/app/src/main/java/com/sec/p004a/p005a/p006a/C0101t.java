package com.sec.p004a.p005a.p006a;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.t */
/* loaded from: classes.dex */
public final class C0101t extends GeneratedMessageLite.Builder implements InterfaceC0097p {

    /* renamed from: a */
    private int f171a;

    /* renamed from: b */
    private int f172b;

    /* renamed from: c */
    private int f173c;

    /* renamed from: d */
    private Object f174d = "";

    /* renamed from: e */
    private Object f175e = "";

    /* renamed from: f */
    private Object f176f = "";

    private C0101t() {
        m486g();
    }

    /* renamed from: g */
    private void m486g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0101t m487h() {
        return new C0101t();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0101t clear() {
        super.clear();
        this.f172b = 0;
        this.f171a &= -2;
        this.f173c = 0;
        this.f171a &= -3;
        this.f174d = "";
        this.f171a &= -5;
        this.f175e = "";
        this.f171a &= -9;
        this.f176f = "";
        this.f171a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0101t mo5946clone() {
        return m487h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0089h getDefaultInstanceForType() {
        return C0089h.m347a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0089h build() {
        C0089h c0089hBuildPartial = buildPartial();
        if (!c0089hBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0089hBuildPartial);
        }
        return c0089hBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0089h m488i() throws InvalidProtocolBufferException {
        C0089h c0089hBuildPartial = buildPartial();
        if (!c0089hBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0089hBuildPartial).asInvalidProtocolBufferException();
        }
        return c0089hBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0089h buildPartial() {
        C0089h c0089h = new C0089h(this);
        int i = this.f171a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0089h.f127c = this.f172b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0089h.f128d = this.f173c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0089h.f129e = this.f174d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0089h.f130f = this.f175e;
        if ((i & 16) == 16) {
            i2 |= 16;
        }
        c0089h.f131g = this.f176f;
        c0089h.f126b = i2;
        return c0089h;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0101t mergeFrom(C0089h c0089h) {
        if (c0089h != C0089h.m347a()) {
            if (c0089h.m360c()) {
                m490a(c0089h.m361d());
            }
            if (c0089h.m362e()) {
                m495b(c0089h.m363f());
            }
            if (c0089h.m364g()) {
                m493a(c0089h.m365h());
            }
            if (c0089h.m366i()) {
                m496b(c0089h.m367j());
            }
            if (c0089h.m368k()) {
                m498c(c0089h.m369l());
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
    public C0101t mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f171a |= 1;
                    this.f172b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f171a |= 2;
                    this.f173c = codedInputStream.readInt32();
                    break;
                case MREvent.TILT_RIGHT /* 26 */:
                    this.f171a |= 4;
                    this.f174d = codedInputStream.readBytes();
                    break;
                case MREvent.SHAKE /* 34 */:
                    this.f171a |= 8;
                    this.f175e = codedInputStream.readBytes();
                    break;
                case MREvent.BT_SHARING_SEND_START /* 42 */:
                    this.f171a |= 16;
                    this.f176f = codedInputStream.readBytes();
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
    public C0101t m490a(int i) {
        this.f171a |= 1;
        this.f172b = i;
        return this;
    }

    /* renamed from: b */
    public C0101t m495b(int i) {
        this.f171a |= 2;
        this.f173c = i;
        return this;
    }

    /* renamed from: a */
    public C0101t m493a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f171a |= 4;
        this.f174d = str;
        return this;
    }

    /* renamed from: b */
    public C0101t m496b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f171a |= 8;
        this.f175e = str;
        return this;
    }

    /* renamed from: c */
    public C0101t m498c(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f171a |= 16;
        this.f176f = str;
        return this;
    }
}
