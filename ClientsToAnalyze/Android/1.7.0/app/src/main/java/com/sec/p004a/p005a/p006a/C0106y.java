package com.sec.p004a.p005a.p006a;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;

/* compiled from: MsgFrontend.java */
/* renamed from: com.sec.a.a.a.y */
/* loaded from: classes.dex */
public final class C0106y extends GeneratedMessageLite.Builder implements InterfaceC0102u {

    /* renamed from: a */
    private int f198a;

    /* renamed from: b */
    private int f199b;

    /* renamed from: c */
    private int f200c;

    /* renamed from: d */
    private Object f201d = "";

    /* renamed from: e */
    private Object f202e = "";

    private C0106y() {
        m564g();
    }

    /* renamed from: g */
    private void m564g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0106y m565h() {
        return new C0106y();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0106y clear() {
        super.clear();
        this.f199b = 0;
        this.f198a &= -2;
        this.f200c = 0;
        this.f198a &= -3;
        this.f201d = "";
        this.f198a &= -5;
        this.f202e = "";
        this.f198a &= -9;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0106y mo5946clone() {
        return m565h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0090i getDefaultInstanceForType() {
        return C0090i.m373a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0090i build() {
        C0090i c0090iBuildPartial = buildPartial();
        if (!c0090iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0090iBuildPartial);
        }
        return c0090iBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0090i m566i() throws InvalidProtocolBufferException {
        C0090i c0090iBuildPartial = buildPartial();
        if (!c0090iBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0090iBuildPartial).asInvalidProtocolBufferException();
        }
        return c0090iBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0090i buildPartial() {
        C0090i c0090i = new C0090i(this);
        int i = this.f198a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0090i.f136c = this.f199b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0090i.f137d = this.f200c;
        if ((i & 4) == 4) {
            i2 |= 4;
        }
        c0090i.f138e = this.f201d;
        if ((i & 8) == 8) {
            i2 |= 8;
        }
        c0090i.f139f = this.f202e;
        c0090i.f135b = i2;
        return c0090i;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0106y mergeFrom(C0090i c0090i) {
        if (c0090i != C0090i.m373a()) {
            if (c0090i.m384c()) {
                m568a(c0090i.m385d());
            }
            if (c0090i.m386e()) {
                m573b(c0090i.m387f());
            }
            if (c0090i.m388g()) {
                m571a(c0090i.m389h());
            }
            if (c0090i.m390i()) {
                m574b(c0090i.m391j());
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
    public C0106y mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 8:
                    this.f198a |= 1;
                    this.f199b = codedInputStream.readInt32();
                    break;
                case 16:
                    this.f198a |= 2;
                    this.f200c = codedInputStream.readInt32();
                    break;
                case MREvent.TILT_RIGHT /* 26 */:
                    this.f198a |= 4;
                    this.f201d = codedInputStream.readBytes();
                    break;
                case MREvent.SHAKE /* 34 */:
                    this.f198a |= 8;
                    this.f202e = codedInputStream.readBytes();
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
    public C0106y m568a(int i) {
        this.f198a |= 1;
        this.f199b = i;
        return this;
    }

    /* renamed from: b */
    public C0106y m573b(int i) {
        this.f198a |= 2;
        this.f200c = i;
        return this;
    }

    /* renamed from: a */
    public C0106y m571a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f198a |= 4;
        this.f201d = str;
        return this;
    }

    /* renamed from: b */
    public C0106y m574b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f198a |= 8;
        this.f202e = str;
        return this;
    }
}
