package com.sec.chaton.p015b;

import android.hardware.motion.MREvent;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: SSMGPB.java */
/* renamed from: com.sec.chaton.b.ab */
/* loaded from: classes.dex */
public final class C0262ab extends GeneratedMessageLite.Builder implements InterfaceC0338l {

    /* renamed from: a */
    private int f647a;

    /* renamed from: b */
    private Object f648b = "";

    /* renamed from: c */
    private List f649c = Collections.emptyList();

    /* renamed from: d */
    private C0313bz f650d = C0313bz.m1619a();

    private C0262ab() {
        m963k();
    }

    /* renamed from: k */
    private void m963k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static C0262ab m964l() {
        return new C0262ab();
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0262ab clear() {
        super.clear();
        this.f648b = "";
        this.f647a &= -2;
        this.f649c = Collections.emptyList();
        this.f647a &= -3;
        this.f650d = C0313bz.m1619a();
        this.f647a &= -5;
        return this;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0262ab mo5946clone() {
        return m964l().mergeFrom(buildPartial());
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public C0317cc getDefaultInstanceForType() {
        return C0317cc.m1686a();
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C0317cc build() {
        C0317cc c0317ccBuildPartial = buildPartial();
        if (!c0317ccBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0317ccBuildPartial);
        }
        return c0317ccBuildPartial;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public C0317cc m965m() throws InvalidProtocolBufferException {
        C0317cc c0317ccBuildPartial = buildPartial();
        if (!c0317ccBuildPartial.isInitialized()) {
            throw newUninitializedMessageException(c0317ccBuildPartial).asInvalidProtocolBufferException();
        }
        return c0317ccBuildPartial;
    }

    @Override // com.google.protobuf.MessageLite.Builder
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public C0317cc buildPartial() {
        C0317cc c0317cc = new C0317cc(this);
        int i = this.f647a;
        int i2 = (i & 1) != 1 ? 0 : 1;
        c0317cc.f895c = this.f648b;
        if ((this.f647a & 2) == 2) {
            this.f649c = Collections.unmodifiableList(this.f649c);
            this.f647a &= -3;
        }
        c0317cc.f896d = this.f649c;
        if ((i & 4) == 4) {
            i2 |= 2;
        }
        c0317cc.f897e = this.f650d;
        c0317cc.f894b = i2;
        return c0317cc;
    }

    @Override // com.google.protobuf.GeneratedMessageLite.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0262ab mergeFrom(C0317cc c0317cc) {
        if (c0317cc != C0317cc.m1686a()) {
            if (c0317cc.m1694c()) {
                m972a(c0317cc.m1695d());
            }
            if (!c0317cc.f896d.isEmpty()) {
                if (this.f649c.isEmpty()) {
                    this.f649c = c0317cc.f896d;
                    this.f647a &= -3;
                } else {
                    m966n();
                    this.f649c.addAll(c0317cc.f896d);
                }
            }
            if (c0317cc.m1696e()) {
                m975b(c0317cc.m1697f());
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
    public C0262ab mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        while (true) {
            int tag = codedInputStream.readTag();
            switch (tag) {
                case 0:
                    break;
                case 10:
                    this.f647a |= 1;
                    this.f648b = codedInputStream.readBytes();
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    MessageLite.Builder builderNewBuilder = C0344r.newBuilder();
                    codedInputStream.readMessage(builderNewBuilder, extensionRegistryLite);
                    m971a(builderNewBuilder.buildPartial());
                    break;
                case MREvent.TILT_RIGHT /* 26 */:
                    C0312by c0312byNewBuilder = C0313bz.newBuilder();
                    if (m981h()) {
                        c0312byNewBuilder.mergeFrom(m982i());
                    }
                    codedInputStream.readMessage(c0312byNewBuilder, extensionRegistryLite);
                    m969a(c0312byNewBuilder.buildPartial());
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
    public C0262ab m972a(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.f647a |= 1;
        this.f648b = str;
        return this;
    }

    /* renamed from: n */
    private void m966n() {
        if ((this.f647a & 2) != 2) {
            this.f649c = new ArrayList(this.f649c);
            this.f647a |= 2;
        }
    }

    /* renamed from: f */
    public List m979f() {
        return Collections.unmodifiableList(this.f649c);
    }

    /* renamed from: g */
    public int m980g() {
        return this.f649c.size();
    }

    /* renamed from: a */
    public C0344r m973a(int i) {
        return (C0344r) this.f649c.get(i);
    }

    /* renamed from: a */
    public C0262ab m971a(C0344r c0344r) {
        if (c0344r == null) {
            throw new NullPointerException();
        }
        m966n();
        this.f649c.add(c0344r);
        return this;
    }

    /* renamed from: h */
    public boolean m981h() {
        return (this.f647a & 4) == 4;
    }

    /* renamed from: i */
    public C0313bz m982i() {
        return this.f650d;
    }

    /* renamed from: a */
    public C0262ab m969a(C0313bz c0313bz) {
        if (c0313bz == null) {
            throw new NullPointerException();
        }
        this.f650d = c0313bz;
        this.f647a |= 4;
        return this;
    }

    /* renamed from: b */
    public C0262ab m975b(C0313bz c0313bz) {
        if ((this.f647a & 4) == 4 && this.f650d != C0313bz.m1619a()) {
            this.f650d = C0313bz.m1618a(this.f650d).mergeFrom(c0313bz).buildPartial();
        } else {
            this.f650d = c0313bz;
        }
        this.f647a |= 4;
        return this;
    }
}
