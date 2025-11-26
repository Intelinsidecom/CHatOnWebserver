package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.bk */
/* loaded from: classes.dex */
public final class C0298bk extends GeneratedMessageLite.Builder implements InterfaceC0278ar {

    /* renamed from: a */
    private int f789a;

    /* renamed from: b */
    private Object f790b = "";

    /* renamed from: c */
    private EnumC0323ci f791c = EnumC0323ci.SINGLE;

    /* renamed from: d */
    private List f792d = Collections.emptyList();

    /* renamed from: e */
    private Object f793e = "";

    /* renamed from: f */
    private boolean f794f;

    private C0298bk() {
        m1359g();
    }

    /* renamed from: g */
    private void m1359g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static C0298bk m1360h() {
        return new C0298bk();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0298bk clear() {
        super.clear();
        this.f790b = "";
        this.f789a &= -2;
        this.f791c = EnumC0323ci.SINGLE;
        this.f789a &= -3;
        this.f792d = Collections.emptyList();
        this.f789a &= -5;
        this.f793e = "";
        this.f789a &= -9;
        this.f794f = false;
        this.f789a &= -17;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0298bk mo5946clone() {
        return m1360h().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0305br getDefaultInstanceForType() {
        return C0305br.m1494a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0305br build() {
        C0305br c0305brBuildPartial = buildPartial();
        if (!c0305brBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0305brBuildPartial);
        }
        return c0305brBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public C0305br m1361i() throws InvalidProtocolBufferException {
        C0305br c0305brBuildPartial = buildPartial();
        if (!c0305brBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0305brBuildPartial).asInvalidProtocolBufferException();
        }
        return c0305brBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0305br buildPartial() {
        C0305br c0305br = new C0305br(this);
        int i = this.f789a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0305br.f839c = this.f790b;
        if ((i & 2) == 2) {
            i2 |= 2;
        }
        c0305br.f840d = this.f791c;
        if ((this.f789a & 4) == 4) {
            this.f792d = Collections.unmodifiableList(this.f792d);
            this.f789a &= -5;
        }
        c0305br.f841e = this.f792d;
        if ((i & 8) == 8) {
            i2 |= 4;
        }
        c0305br.f842f = this.f793e;
        if ((i & 16) == 16) {
            i2 |= 8;
        }
        c0305br.f843g = this.f794f;
        c0305br.f838b = i2;
        return c0305br;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0298bk mergeFrom(C0305br c0305br) {
        if (c0305br != C0305br.m1494a()) {
            if (c0305br.m1507c()) {
                m1368a(c0305br.m1508d());
            }
            if (c0305br.m1509e()) {
                m1366a(c0305br.m1510f());
            }
            if (!c0305br.f841e.isEmpty()) {
                if (this.f792d.isEmpty()) {
                    this.f792d = c0305br.f841e;
                    this.f789a &= -5;
                } else {
                    m1362j();
                    this.f792d.addAll(c0305br.f841e);
                }
            }
            if (c0305br.m1513i()) {
                m1371b(c0305br.m1514j());
            }
            if (c0305br.m1515k()) {
                m1369a(c0305br.m1516l());
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
    public C0298bk mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f789a |= 1;
                    this.f790b = codedInputStream.readBytes();
                    break;
                case 16:
                    EnumC0323ci enumC0323ciM1750a = EnumC0323ci.m1750a(codedInputStream.readEnum());
                    if (enumC0323ciM1750a == null) {
                        break;
                    } else {
                        this.f789a |= 2;
                        this.f791c = enumC0323ciM1750a;
                        break;
                    }
                case MREvent.TILT_RIGHT /* 26 */:
                    C0297bj c0297bjNewBuilder = C0329co.newBuilder();
                    codedInputStream.readMessage(c0297bjNewBuilder, extensionRegistryLite);
                    m1367a(c0297bjNewBuilder.buildPartial());
                    break;
                case MREvent.SHAKE /* 34 */:
                    this.f789a |= 8;
                    this.f793e = codedInputStream.readBytes();
                    break;
                case MREvent.BT_SHARING_RECEIVE_READY /* 40 */:
                    this.f789a |= 16;
                    this.f794f = codedInputStream.readBool();
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
    public C0298bk m1368a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f789a |= 1;
        this.f790b = str;
        return this;
    }

    /* renamed from: a */
    public C0298bk m1366a(EnumC0323ci enumC0323ci) {
        if (enumC0323ci == null) {
            throw new NullPointerException();
        }
        this.f789a |= 2;
        this.f791c = enumC0323ci;
        return this;
    }

    /* renamed from: j */
    private void m1362j() {
        if ((this.f789a & 4) != 4) {
            this.f792d = new ArrayList(this.f792d);
            this.f789a |= 4;
        }
    }

    /* renamed from: a */
    public C0298bk m1367a(C0329co c0329co) {
        if (c0329co == null) {
            throw new NullPointerException();
        }
        m1362j();
        this.f792d.add(c0329co);
        return this;
    }

    /* renamed from: b */
    public C0298bk m1371b(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f789a |= 8;
        this.f793e = str;
        return this;
    }

    /* renamed from: a */
    public C0298bk m1369a(boolean z) {
        this.f789a |= 16;
        this.f794f = z;
        return this;
    }
}
