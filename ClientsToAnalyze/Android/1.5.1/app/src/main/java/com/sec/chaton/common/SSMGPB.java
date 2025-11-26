package com.sec.chaton.common;

import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.sec.pns.msg.frontend.MsgFrontendCommon;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class SSMGPB {

    public final class AllowChatReply extends GeneratedMessageLite {

        /* renamed from: a */
        private static final AllowChatReply f988a = new AllowChatReply(true);

        /* renamed from: b */
        private boolean f989b;

        /* renamed from: c */
        private long f990c;

        /* renamed from: d */
        private boolean f991d;

        /* renamed from: e */
        private Result f992e;

        /* renamed from: f */
        private int f993f;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private AllowChatReply f994a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: j */
            public static Builder m829j() {
                Builder builder = new Builder();
                builder.f994a = new AllowChatReply();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: k */
            public AllowChatReply m830k() {
                if (m839d()) {
                    return m841f();
                }
                throw newUninitializedMessageException(this.f994a).m350a();
            }

            /* renamed from: a */
            public Builder m831a(long j) {
                this.f994a.f989b = true;
                this.f994a.f990c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m831a(codedInputStream.m282c());
                            break;
                        case 18:
                            Result.Builder builderM1894h = Result.m1894h();
                            if (m842g()) {
                                builderM1894h.mergeFrom(m843h());
                            }
                            codedInputStream.m278a(builderM1894h, extensionRegistryLite);
                            m834a(builderM1894h.m1914f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(AllowChatReply allowChatReply) {
                if (allowChatReply == AllowChatReply.m812a()) {
                    return this;
                }
                if (allowChatReply.m821c()) {
                    m831a(allowChatReply.m822d());
                }
                if (allowChatReply.m823e()) {
                    m837b(allowChatReply.m824f());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m834a(Result result) {
                if (result == null) {
                    throw new NullPointerException();
                }
                this.f994a.f991d = true;
                this.f994a.f992e = result;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AllowChatReply internalGetResult() {
                return this.f994a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m829j().mergeFrom(this.f994a);
            }

            /* renamed from: b */
            public Builder m837b(Result result) {
                if (!this.f994a.m823e() || this.f994a.f992e == Result.m1890a()) {
                    this.f994a.f992e = result;
                } else {
                    this.f994a.f992e = Result.m1889a(this.f994a.f992e).mergeFrom(result).m1914f();
                }
                this.f994a.f991d = true;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public AllowChatReply mo4403getDefaultInstanceForType() {
                return AllowChatReply.m812a();
            }

            /* renamed from: d */
            public boolean m839d() {
                return this.f994a.m825g();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public AllowChatReply build() {
                if (this.f994a == null || m839d()) {
                    return m841f();
                }
                throw newUninitializedMessageException(this.f994a);
            }

            /* renamed from: f */
            public AllowChatReply m841f() {
                if (this.f994a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                AllowChatReply allowChatReply = this.f994a;
                this.f994a = null;
                return allowChatReply;
            }

            /* renamed from: g */
            public boolean m842g() {
                return this.f994a.m823e();
            }

            /* renamed from: h */
            public Result m843h() {
                return this.f994a.m824f();
            }
        }

        static {
            SSMGPB.m810a();
            f988a.m819j();
        }

        private AllowChatReply() {
            this.f990c = 0L;
            this.f993f = -1;
            m819j();
        }

        private AllowChatReply(boolean z) {
            this.f990c = 0L;
            this.f993f = -1;
        }

        /* renamed from: a */
        public static AllowChatReply m812a() {
            return f988a;
        }

        /* renamed from: a */
        public static AllowChatReply m813a(byte[] bArr) {
            return ((Builder) m818h().m4401mergeFrom(bArr)).m830k();
        }

        /* renamed from: h */
        public static Builder m818h() {
            return Builder.m829j();
        }

        /* renamed from: j */
        private void m819j() {
            this.f992e = Result.m1890a();
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AllowChatReply getDefaultInstanceForType() {
            return f988a;
        }

        /* renamed from: c */
        public boolean m821c() {
            return this.f989b;
        }

        /* renamed from: d */
        public long m822d() {
            return this.f990c;
        }

        /* renamed from: e */
        public boolean m823e() {
            return this.f991d;
        }

        /* renamed from: f */
        public Result m824f() {
            return this.f992e;
        }

        /* renamed from: g */
        public final boolean m825g() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM301b = this.f993f;
            if (iM301b == -1) {
                iM301b = m821c() ? 0 + CodedOutputStream.m301b(1, m822d()) : 0;
                if (m823e()) {
                    iM301b += CodedOutputStream.m302b(2, m824f());
                }
                this.f993f = iM301b;
            }
            return iM301b;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m818h();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m821c()) {
                codedOutputStream.m320a(1, m822d());
            }
            if (m823e()) {
                codedOutputStream.m321a(2, m824f());
            }
        }
    }

    public final class AllowChatRequest extends GeneratedMessageLite {

        /* renamed from: a */
        private static final AllowChatRequest f995a = new AllowChatRequest(true);

        /* renamed from: b */
        private boolean f996b;

        /* renamed from: c */
        private long f997c;

        /* renamed from: d */
        private boolean f998d;

        /* renamed from: e */
        private ChatType f999e;

        /* renamed from: f */
        private boolean f1000f;

        /* renamed from: g */
        private String f1001g;

        /* renamed from: h */
        private boolean f1002h;

        /* renamed from: i */
        private String f1003i;

        /* renamed from: j */
        private boolean f1004j;

        /* renamed from: k */
        private String f1005k;

        /* renamed from: l */
        private boolean f1006l;

        /* renamed from: m */
        private String f1007m;

        /* renamed from: n */
        private boolean f1008n;

        /* renamed from: o */
        private String f1009o;

        /* renamed from: p */
        private int f1010p;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private AllowChatRequest f1011a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: m */
            public static Builder m881m() {
                Builder builder = new Builder();
                builder.f1011a = new AllowChatRequest();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: n */
            public AllowChatRequest m882n() {
                if (m894d()) {
                    return m897f();
                }
                throw newUninitializedMessageException(this.f1011a).m350a();
            }

            /* renamed from: a */
            public Builder m883a(long j) {
                this.f1011a.f996b = true;
                this.f1011a.f997c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m883a(codedInputStream.m282c());
                            break;
                        case 16:
                            ChatType chatTypeM1239a = ChatType.m1239a(codedInputStream.m289g());
                            if (chatTypeM1239a == null) {
                                break;
                            } else {
                                m886a(chatTypeM1239a);
                                break;
                            }
                        case 26:
                            m887a(codedInputStream.m287f());
                            break;
                        case 34:
                            m890b(codedInputStream.m287f());
                            break;
                        case 42:
                            m891c(codedInputStream.m287f());
                            break;
                        case 50:
                            m893d(codedInputStream.m287f());
                            break;
                        case 58:
                            m895e(codedInputStream.m287f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(AllowChatRequest allowChatRequest) {
                if (allowChatRequest == AllowChatRequest.m845a()) {
                    return this;
                }
                if (allowChatRequest.m863c()) {
                    m883a(allowChatRequest.m864d());
                }
                if (allowChatRequest.m865e()) {
                    m886a(allowChatRequest.m866f());
                }
                if (allowChatRequest.m867g()) {
                    m887a(allowChatRequest.m868h());
                }
                if (allowChatRequest.m869i()) {
                    m890b(allowChatRequest.m870j());
                }
                if (allowChatRequest.m871k()) {
                    m891c(allowChatRequest.m872l());
                }
                if (allowChatRequest.m873m()) {
                    m893d(allowChatRequest.m874n());
                }
                if (allowChatRequest.m875o()) {
                    m895e(allowChatRequest.m876p());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m886a(ChatType chatType) {
                if (chatType == null) {
                    throw new NullPointerException();
                }
                this.f1011a.f998d = true;
                this.f1011a.f999e = chatType;
                return this;
            }

            /* renamed from: a */
            public Builder m887a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1011a.f1000f = true;
                this.f1011a.f1001g = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AllowChatRequest internalGetResult() {
                return this.f1011a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m881m().mergeFrom(this.f1011a);
            }

            /* renamed from: b */
            public Builder m890b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1011a.f1002h = true;
                this.f1011a.f1003i = str;
                return this;
            }

            /* renamed from: c */
            public Builder m891c(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1011a.f1004j = true;
                this.f1011a.f1005k = str;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public AllowChatRequest mo4403getDefaultInstanceForType() {
                return AllowChatRequest.m845a();
            }

            /* renamed from: d */
            public Builder m893d(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1011a.f1006l = true;
                this.f1011a.f1007m = str;
                return this;
            }

            /* renamed from: d */
            public boolean m894d() {
                return this.f1011a.m877q();
            }

            /* renamed from: e */
            public Builder m895e(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1011a.f1008n = true;
                this.f1011a.f1009o = str;
                return this;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public AllowChatRequest build() {
                if (this.f1011a == null || m894d()) {
                    return m897f();
                }
                throw newUninitializedMessageException(this.f1011a);
            }

            /* renamed from: f */
            public AllowChatRequest m897f() {
                if (this.f1011a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                AllowChatRequest allowChatRequest = this.f1011a;
                this.f1011a = null;
                return allowChatRequest;
            }

            /* renamed from: g */
            public long m898g() {
                return this.f1011a.m864d();
            }

            /* renamed from: h */
            public ChatType m899h() {
                return this.f1011a.m866f();
            }

            /* renamed from: i */
            public String m900i() {
                return this.f1011a.m868h();
            }

            /* renamed from: j */
            public String m901j() {
                return this.f1011a.m870j();
            }

            /* renamed from: k */
            public String m902k() {
                return this.f1011a.m872l();
            }
        }

        static {
            SSMGPB.m810a();
            f995a.m861t();
        }

        private AllowChatRequest() {
            this.f997c = 0L;
            this.f1001g = "";
            this.f1003i = "";
            this.f1005k = "";
            this.f1007m = "";
            this.f1009o = "";
            this.f1010p = -1;
            m861t();
        }

        private AllowChatRequest(boolean z) {
            this.f997c = 0L;
            this.f1001g = "";
            this.f1003i = "";
            this.f1005k = "";
            this.f1007m = "";
            this.f1009o = "";
            this.f1010p = -1;
        }

        /* renamed from: a */
        public static AllowChatRequest m845a() {
            return f995a;
        }

        /* renamed from: a */
        public static AllowChatRequest m846a(byte[] bArr) {
            return ((Builder) m860r().m4401mergeFrom(bArr)).m882n();
        }

        /* renamed from: r */
        public static Builder m860r() {
            return Builder.m881m();
        }

        /* renamed from: t */
        private void m861t() {
            this.f999e = ChatType.SINGLE;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AllowChatRequest getDefaultInstanceForType() {
            return f995a;
        }

        /* renamed from: c */
        public boolean m863c() {
            return this.f996b;
        }

        /* renamed from: d */
        public long m864d() {
            return this.f997c;
        }

        /* renamed from: e */
        public boolean m865e() {
            return this.f998d;
        }

        /* renamed from: f */
        public ChatType m866f() {
            return this.f999e;
        }

        /* renamed from: g */
        public boolean m867g() {
            return this.f1000f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM301b = this.f1010p;
            if (iM301b == -1) {
                iM301b = m863c() ? 0 + CodedOutputStream.m301b(1, m864d()) : 0;
                if (m865e()) {
                    iM301b += CodedOutputStream.m311d(2, m866f().m1240a());
                }
                if (m867g()) {
                    iM301b += CodedOutputStream.m303b(3, m868h());
                }
                if (m869i()) {
                    iM301b += CodedOutputStream.m303b(4, m870j());
                }
                if (m871k()) {
                    iM301b += CodedOutputStream.m303b(5, m872l());
                }
                if (m873m()) {
                    iM301b += CodedOutputStream.m303b(6, m874n());
                }
                if (m875o()) {
                    iM301b += CodedOutputStream.m303b(7, m876p());
                }
                this.f1010p = iM301b;
            }
            return iM301b;
        }

        /* renamed from: h */
        public String m868h() {
            return this.f1001g;
        }

        /* renamed from: i */
        public boolean m869i() {
            return this.f1002h;
        }

        /* renamed from: j */
        public String m870j() {
            return this.f1003i;
        }

        /* renamed from: k */
        public boolean m871k() {
            return this.f1004j;
        }

        /* renamed from: l */
        public String m872l() {
            return this.f1005k;
        }

        /* renamed from: m */
        public boolean m873m() {
            return this.f1006l;
        }

        /* renamed from: n */
        public String m874n() {
            return this.f1007m;
        }

        /* renamed from: o */
        public boolean m875o() {
            return this.f1008n;
        }

        /* renamed from: p */
        public String m876p() {
            return this.f1009o;
        }

        /* renamed from: q */
        public final boolean m877q() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m860r();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m863c()) {
                codedOutputStream.m320a(1, m864d());
            }
            if (m865e()) {
                codedOutputStream.m330b(2, m866f().m1240a());
            }
            if (m867g()) {
                codedOutputStream.m322a(3, m868h());
            }
            if (m869i()) {
                codedOutputStream.m322a(4, m870j());
            }
            if (m871k()) {
                codedOutputStream.m322a(5, m872l());
            }
            if (m873m()) {
                codedOutputStream.m322a(6, m874n());
            }
            if (m875o()) {
                codedOutputStream.m322a(7, m876p());
            }
        }
    }

    public final class AnnounceChange extends GeneratedMessageLite {

        /* renamed from: a */
        private static final AnnounceChange f1012a = new AnnounceChange(true);

        /* renamed from: b */
        private boolean f1013b;

        /* renamed from: c */
        private long f1014c;

        /* renamed from: d */
        private boolean f1015d;

        /* renamed from: e */
        private String f1016e;

        /* renamed from: f */
        private List f1017f;

        /* renamed from: g */
        private List f1018g;

        /* renamed from: h */
        private boolean f1019h;

        /* renamed from: i */
        private long f1020i;

        /* renamed from: j */
        private int f1021j;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private AnnounceChange f1022a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: h */
            public static Builder m933h() {
                Builder builder = new Builder();
                builder.f1022a = new AnnounceChange();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: i */
            public AnnounceChange m934i() {
                if (m945d()) {
                    return m947f();
                }
                throw newUninitializedMessageException(this.f1022a).m350a();
            }

            /* renamed from: a */
            public Builder m935a(long j) {
                this.f1022a.f1013b = true;
                this.f1022a.f1014c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m935a(codedInputStream.m282c());
                            break;
                        case 18:
                            m939a(codedInputStream.m287f());
                            break;
                        case 26:
                            ChangeMemberList.Builder builderM1082j = ChangeMemberList.m1082j();
                            codedInputStream.m278a(builderM1082j, extensionRegistryLite);
                            m938a(builderM1082j.m1105f());
                            break;
                        case 34:
                            m943b(codedInputStream.m287f());
                            break;
                        case 40:
                            m942b(codedInputStream.m282c());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(AnnounceChange announceChange) {
                if (announceChange == AnnounceChange.m904a()) {
                    return this;
                }
                if (announceChange.m919c()) {
                    m935a(announceChange.m920d());
                }
                if (announceChange.m921e()) {
                    m939a(announceChange.m922f());
                }
                if (!announceChange.f1017f.isEmpty()) {
                    if (this.f1022a.f1017f.isEmpty()) {
                        this.f1022a.f1017f = new ArrayList();
                    }
                    this.f1022a.f1017f.addAll(announceChange.f1017f);
                }
                if (!announceChange.f1018g.isEmpty()) {
                    if (this.f1022a.f1018g.isEmpty()) {
                        this.f1022a.f1018g = new ArrayList();
                    }
                    this.f1022a.f1018g.addAll(announceChange.f1018g);
                }
                if (announceChange.m927k()) {
                    m942b(announceChange.m928l());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m938a(ChangeMemberList changeMemberList) {
                if (changeMemberList == null) {
                    throw new NullPointerException();
                }
                if (this.f1022a.f1017f.isEmpty()) {
                    this.f1022a.f1017f = new ArrayList();
                }
                this.f1022a.f1017f.add(changeMemberList);
                return this;
            }

            /* renamed from: a */
            public Builder m939a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1022a.f1015d = true;
                this.f1022a.f1016e = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AnnounceChange internalGetResult() {
                return this.f1022a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m933h().mergeFrom(this.f1022a);
            }

            /* renamed from: b */
            public Builder m942b(long j) {
                this.f1022a.f1019h = true;
                this.f1022a.f1020i = j;
                return this;
            }

            /* renamed from: b */
            public Builder m943b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (this.f1022a.f1018g.isEmpty()) {
                    this.f1022a.f1018g = new ArrayList();
                }
                this.f1022a.f1018g.add(str);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public AnnounceChange mo4403getDefaultInstanceForType() {
                return AnnounceChange.m904a();
            }

            /* renamed from: d */
            public boolean m945d() {
                return this.f1022a.m929m();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public AnnounceChange build() {
                if (this.f1022a == null || m945d()) {
                    return m947f();
                }
                throw newUninitializedMessageException(this.f1022a);
            }

            /* renamed from: f */
            public AnnounceChange m947f() {
                if (this.f1022a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.f1022a.f1017f != Collections.EMPTY_LIST) {
                    this.f1022a.f1017f = Collections.unmodifiableList(this.f1022a.f1017f);
                }
                if (this.f1022a.f1018g != Collections.EMPTY_LIST) {
                    this.f1022a.f1018g = Collections.unmodifiableList(this.f1022a.f1018g);
                }
                AnnounceChange announceChange = this.f1022a;
                this.f1022a = null;
                return announceChange;
            }
        }

        static {
            SSMGPB.m810a();
            f1012a.m916p();
        }

        private AnnounceChange() {
            this.f1014c = 0L;
            this.f1016e = "";
            this.f1017f = Collections.emptyList();
            this.f1018g = Collections.emptyList();
            this.f1020i = 0L;
            this.f1021j = -1;
            m916p();
        }

        private AnnounceChange(boolean z) {
            this.f1014c = 0L;
            this.f1016e = "";
            this.f1017f = Collections.emptyList();
            this.f1018g = Collections.emptyList();
            this.f1020i = 0L;
            this.f1021j = -1;
        }

        /* renamed from: a */
        public static AnnounceChange m904a() {
            return f1012a;
        }

        /* renamed from: a */
        public static AnnounceChange m905a(byte[] bArr) {
            return ((Builder) m915n().m4401mergeFrom(bArr)).m934i();
        }

        /* renamed from: n */
        public static Builder m915n() {
            return Builder.m933h();
        }

        /* renamed from: p */
        private void m916p() {
        }

        /* renamed from: a */
        public ChangeMemberList m917a(int i) {
            return (ChangeMemberList) this.f1017f.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AnnounceChange getDefaultInstanceForType() {
            return f1012a;
        }

        /* renamed from: c */
        public boolean m919c() {
            return this.f1013b;
        }

        /* renamed from: d */
        public long m920d() {
            return this.f1014c;
        }

        /* renamed from: e */
        public boolean m921e() {
            return this.f1015d;
        }

        /* renamed from: f */
        public String m922f() {
            return this.f1016e;
        }

        /* renamed from: g */
        public List m923g() {
            return this.f1017f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i;
            int size = this.f1021j;
            if (size == -1) {
                int iM301b = m919c() ? CodedOutputStream.m301b(1, m920d()) + 0 : 0;
                if (m921e()) {
                    iM301b += CodedOutputStream.m303b(2, m922f());
                }
                Iterator it = m923g().iterator();
                while (true) {
                    i = iM301b;
                    if (!it.hasNext()) {
                        break;
                    }
                    iM301b = CodedOutputStream.m302b(3, (ChangeMemberList) it.next()) + i;
                }
                Iterator it2 = m925i().iterator();
                int iM307b = 0;
                while (it2.hasNext()) {
                    iM307b = CodedOutputStream.m307b((String) it2.next()) + iM307b;
                }
                size = i + iM307b + (m925i().size() * 1);
                if (m927k()) {
                    size += CodedOutputStream.m301b(5, m928l());
                }
                this.f1021j = size;
            }
            return size;
        }

        /* renamed from: h */
        public int m924h() {
            return this.f1017f.size();
        }

        /* renamed from: i */
        public List m925i() {
            return this.f1018g;
        }

        /* renamed from: j */
        public int m926j() {
            return this.f1018g.size();
        }

        /* renamed from: k */
        public boolean m927k() {
            return this.f1019h;
        }

        /* renamed from: l */
        public long m928l() {
            return this.f1020i;
        }

        /* renamed from: m */
        public final boolean m929m() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m915n();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m919c()) {
                codedOutputStream.m320a(1, m920d());
            }
            if (m921e()) {
                codedOutputStream.m322a(2, m922f());
            }
            Iterator it = m923g().iterator();
            while (it.hasNext()) {
                codedOutputStream.m321a(3, (ChangeMemberList) it.next());
            }
            Iterator it2 = m925i().iterator();
            while (it2.hasNext()) {
                codedOutputStream.m322a(4, (String) it2.next());
            }
            if (m927k()) {
                codedOutputStream.m320a(5, m928l());
            }
        }
    }

    public final class AnnounceChangeReply extends GeneratedMessageLite {

        /* renamed from: a */
        private static final AnnounceChangeReply f1023a = new AnnounceChangeReply(true);

        /* renamed from: b */
        private boolean f1024b;

        /* renamed from: c */
        private long f1025c;

        /* renamed from: d */
        private boolean f1026d;

        /* renamed from: e */
        private Result f1027e;

        /* renamed from: f */
        private int f1028f;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private AnnounceChangeReply f1029a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: k */
            public static Builder m966k() {
                Builder builder = new Builder();
                builder.f1029a = new AnnounceChangeReply();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: l */
            public AnnounceChangeReply m967l() {
                if (m976d()) {
                    return m978f();
                }
                throw newUninitializedMessageException(this.f1029a).m350a();
            }

            /* renamed from: a */
            public Builder m968a(long j) {
                this.f1029a.f1024b = true;
                this.f1029a.f1025c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m968a(codedInputStream.m282c());
                            break;
                        case 18:
                            Result.Builder builderM1894h = Result.m1894h();
                            if (m980h()) {
                                builderM1894h.mergeFrom(m981i());
                            }
                            codedInputStream.m278a(builderM1894h, extensionRegistryLite);
                            m971a(builderM1894h.m1914f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(AnnounceChangeReply announceChangeReply) {
                if (announceChangeReply == AnnounceChangeReply.m949a()) {
                    return this;
                }
                if (announceChangeReply.m958c()) {
                    m968a(announceChangeReply.m959d());
                }
                if (announceChangeReply.m960e()) {
                    m974b(announceChangeReply.m961f());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m971a(Result result) {
                if (result == null) {
                    throw new NullPointerException();
                }
                this.f1029a.f1026d = true;
                this.f1029a.f1027e = result;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AnnounceChangeReply internalGetResult() {
                return this.f1029a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m966k().mergeFrom(this.f1029a);
            }

            /* renamed from: b */
            public Builder m974b(Result result) {
                if (!this.f1029a.m960e() || this.f1029a.f1027e == Result.m1890a()) {
                    this.f1029a.f1027e = result;
                } else {
                    this.f1029a.f1027e = Result.m1889a(this.f1029a.f1027e).mergeFrom(result).m1914f();
                }
                this.f1029a.f1026d = true;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public AnnounceChangeReply mo4403getDefaultInstanceForType() {
                return AnnounceChangeReply.m949a();
            }

            /* renamed from: d */
            public boolean m976d() {
                return this.f1029a.m962g();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public AnnounceChangeReply build() {
                if (this.f1029a == null || m976d()) {
                    return m978f();
                }
                throw newUninitializedMessageException(this.f1029a);
            }

            /* renamed from: f */
            public AnnounceChangeReply m978f() {
                if (this.f1029a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                AnnounceChangeReply announceChangeReply = this.f1029a;
                this.f1029a = null;
                return announceChangeReply;
            }

            /* renamed from: g */
            public long m979g() {
                return this.f1029a.m959d();
            }

            /* renamed from: h */
            public boolean m980h() {
                return this.f1029a.m960e();
            }

            /* renamed from: i */
            public Result m981i() {
                return this.f1029a.m961f();
            }
        }

        static {
            SSMGPB.m810a();
            f1023a.m956j();
        }

        private AnnounceChangeReply() {
            this.f1025c = 0L;
            this.f1028f = -1;
            m956j();
        }

        private AnnounceChangeReply(boolean z) {
            this.f1025c = 0L;
            this.f1028f = -1;
        }

        /* renamed from: a */
        public static AnnounceChangeReply m949a() {
            return f1023a;
        }

        /* renamed from: a */
        public static AnnounceChangeReply m950a(byte[] bArr) {
            return ((Builder) m955h().m4401mergeFrom(bArr)).m967l();
        }

        /* renamed from: h */
        public static Builder m955h() {
            return Builder.m966k();
        }

        /* renamed from: j */
        private void m956j() {
            this.f1027e = Result.m1890a();
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AnnounceChangeReply getDefaultInstanceForType() {
            return f1023a;
        }

        /* renamed from: c */
        public boolean m958c() {
            return this.f1024b;
        }

        /* renamed from: d */
        public long m959d() {
            return this.f1025c;
        }

        /* renamed from: e */
        public boolean m960e() {
            return this.f1026d;
        }

        /* renamed from: f */
        public Result m961f() {
            return this.f1027e;
        }

        /* renamed from: g */
        public final boolean m962g() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM301b = this.f1028f;
            if (iM301b == -1) {
                iM301b = m958c() ? 0 + CodedOutputStream.m301b(1, m959d()) : 0;
                if (m960e()) {
                    iM301b += CodedOutputStream.m302b(2, m961f());
                }
                this.f1028f = iM301b;
            }
            return iM301b;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m955h();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m958c()) {
                codedOutputStream.m320a(1, m959d());
            }
            if (m960e()) {
                codedOutputStream.m321a(2, m961f());
            }
        }
    }

    public final class AnswerBack extends GeneratedMessageLite {

        /* renamed from: a */
        private static final AnswerBack f1030a = new AnswerBack(true);

        /* renamed from: b */
        private List f1031b;

        /* renamed from: c */
        private int f1032c;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private AnswerBack f1033a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: h */
            public static Builder m996h() {
                Builder builder = new Builder();
                builder.f1033a = new AnswerBack();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: i */
            public AnswerBack m997i() {
                if (m1004d()) {
                    return m1006f();
                }
                throw newUninitializedMessageException(this.f1033a).m350a();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                            AnswerbackItem.Builder builderM1054h = AnswerbackItem.m1054h();
                            codedInputStream.m278a(builderM1054h, extensionRegistryLite);
                            m1000a(builderM1054h.m1074f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(AnswerBack answerBack) {
                if (answerBack == AnswerBack.m982a()) {
                    return this;
                }
                if (!answerBack.f1031b.isEmpty()) {
                    if (this.f1033a.f1031b.isEmpty()) {
                        this.f1033a.f1031b = new ArrayList();
                    }
                    this.f1033a.f1031b.addAll(answerBack.f1031b);
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1000a(AnswerbackItem answerbackItem) {
                if (answerbackItem == null) {
                    throw new NullPointerException();
                }
                if (this.f1033a.f1031b.isEmpty()) {
                    this.f1033a.f1031b = new ArrayList();
                }
                this.f1033a.f1031b.add(answerbackItem);
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AnswerBack internalGetResult() {
                return this.f1033a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m996h().mergeFrom(this.f1033a);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public AnswerBack mo4403getDefaultInstanceForType() {
                return AnswerBack.m982a();
            }

            /* renamed from: d */
            public boolean m1004d() {
                return this.f1033a.m992e();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public AnswerBack build() {
                if (this.f1033a == null || m1004d()) {
                    return m1006f();
                }
                throw newUninitializedMessageException(this.f1033a);
            }

            /* renamed from: f */
            public AnswerBack m1006f() {
                if (this.f1033a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.f1033a.f1031b != Collections.EMPTY_LIST) {
                    this.f1033a.f1031b = Collections.unmodifiableList(this.f1033a.f1031b);
                }
                AnswerBack answerBack = this.f1033a;
                this.f1033a = null;
                return answerBack;
            }
        }

        static {
            SSMGPB.m810a();
            f1030a.m987h();
        }

        private AnswerBack() {
            this.f1031b = Collections.emptyList();
            this.f1032c = -1;
            m987h();
        }

        private AnswerBack(boolean z) {
            this.f1031b = Collections.emptyList();
            this.f1032c = -1;
        }

        /* renamed from: a */
        public static AnswerBack m982a() {
            return f1030a;
        }

        /* renamed from: a */
        public static AnswerBack m983a(byte[] bArr) {
            return ((Builder) m986f().m4401mergeFrom(bArr)).m997i();
        }

        /* renamed from: f */
        public static Builder m986f() {
            return Builder.m996h();
        }

        /* renamed from: h */
        private void m987h() {
        }

        /* renamed from: a */
        public AnswerbackItem m988a(int i) {
            return (AnswerbackItem) this.f1031b.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AnswerBack getDefaultInstanceForType() {
            return f1030a;
        }

        /* renamed from: c */
        public List m990c() {
            return this.f1031b;
        }

        /* renamed from: d */
        public int m991d() {
            return this.f1031b.size();
        }

        /* renamed from: e */
        public final boolean m992e() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m986f();
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f1032c;
            if (i != -1) {
                return i;
            }
            int iM302b = 0;
            Iterator it = m990c().iterator();
            while (true) {
                int i2 = iM302b;
                if (!it.hasNext()) {
                    this.f1032c = i2;
                    return i2;
                }
                iM302b = CodedOutputStream.m302b(1, (AnswerbackItem) it.next()) + i2;
            }
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            Iterator it = m990c().iterator();
            while (it.hasNext()) {
                codedOutputStream.m321a(1, (AnswerbackItem) it.next());
            }
        }
    }

    public final class AnswerBackReply extends GeneratedMessageLite {

        /* renamed from: a */
        private static final AnswerBackReply f1034a = new AnswerBackReply(true);

        /* renamed from: b */
        private boolean f1035b;

        /* renamed from: c */
        private String f1036c;

        /* renamed from: d */
        private List f1037d;

        /* renamed from: e */
        private boolean f1038e;

        /* renamed from: f */
        private Result f1039f;

        /* renamed from: g */
        private int f1040g;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private AnswerBackReply f1041a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: l */
            public static Builder m1030l() {
                Builder builder = new Builder();
                builder.f1041a = new AnswerBackReply();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: m */
            public AnswerBackReply m1031m() {
                if (m1042d()) {
                    return m1044f();
                }
                throw newUninitializedMessageException(this.f1041a).m350a();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                            m1036a(codedInputStream.m287f());
                            break;
                        case 18:
                            AnswerbackItem.Builder builderM1054h = AnswerbackItem.m1054h();
                            codedInputStream.m278a(builderM1054h, extensionRegistryLite);
                            m1034a(builderM1054h.m1074f());
                            break;
                        case 26:
                            Result.Builder builderM1894h = Result.m1894h();
                            if (m1047i()) {
                                builderM1894h.mergeFrom(m1048j());
                            }
                            codedInputStream.m278a(builderM1894h, extensionRegistryLite);
                            m1035a(builderM1894h.m1914f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(AnswerBackReply answerBackReply) {
                if (answerBackReply == AnswerBackReply.m1007a()) {
                    return this;
                }
                if (answerBackReply.m1020c()) {
                    m1036a(answerBackReply.m1021d());
                }
                if (!answerBackReply.f1037d.isEmpty()) {
                    if (this.f1041a.f1037d.isEmpty()) {
                        this.f1041a.f1037d = new ArrayList();
                    }
                    this.f1041a.f1037d.addAll(answerBackReply.f1037d);
                }
                if (answerBackReply.m1024g()) {
                    m1040b(answerBackReply.m1025h());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1034a(AnswerbackItem answerbackItem) {
                if (answerbackItem == null) {
                    throw new NullPointerException();
                }
                if (this.f1041a.f1037d.isEmpty()) {
                    this.f1041a.f1037d = new ArrayList();
                }
                this.f1041a.f1037d.add(answerbackItem);
                return this;
            }

            /* renamed from: a */
            public Builder m1035a(Result result) {
                if (result == null) {
                    throw new NullPointerException();
                }
                this.f1041a.f1038e = true;
                this.f1041a.f1039f = result;
                return this;
            }

            /* renamed from: a */
            public Builder m1036a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1041a.f1035b = true;
                this.f1041a.f1036c = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AnswerBackReply internalGetResult() {
                return this.f1041a;
            }

            /* renamed from: a */
            public AnswerbackItem m1038a(int i) {
                return this.f1041a.m1018a(i);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1030l().mergeFrom(this.f1041a);
            }

            /* renamed from: b */
            public Builder m1040b(Result result) {
                if (!this.f1041a.m1024g() || this.f1041a.f1039f == Result.m1890a()) {
                    this.f1041a.f1039f = result;
                } else {
                    this.f1041a.f1039f = Result.m1889a(this.f1041a.f1039f).mergeFrom(result).m1914f();
                }
                this.f1041a.f1038e = true;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public AnswerBackReply mo4403getDefaultInstanceForType() {
                return AnswerBackReply.m1007a();
            }

            /* renamed from: d */
            public boolean m1042d() {
                return this.f1041a.m1026i();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public AnswerBackReply build() {
                if (this.f1041a == null || m1042d()) {
                    return m1044f();
                }
                throw newUninitializedMessageException(this.f1041a);
            }

            /* renamed from: f */
            public AnswerBackReply m1044f() {
                if (this.f1041a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.f1041a.f1037d != Collections.EMPTY_LIST) {
                    this.f1041a.f1037d = Collections.unmodifiableList(this.f1041a.f1037d);
                }
                AnswerBackReply answerBackReply = this.f1041a;
                this.f1041a = null;
                return answerBackReply;
            }

            /* renamed from: g */
            public List m1045g() {
                return Collections.unmodifiableList(this.f1041a.f1037d);
            }

            /* renamed from: h */
            public int m1046h() {
                return this.f1041a.m1023f();
            }

            /* renamed from: i */
            public boolean m1047i() {
                return this.f1041a.m1024g();
            }

            /* renamed from: j */
            public Result m1048j() {
                return this.f1041a.m1025h();
            }
        }

        static {
            SSMGPB.m810a();
            f1034a.m1017l();
        }

        private AnswerBackReply() {
            this.f1036c = "";
            this.f1037d = Collections.emptyList();
            this.f1040g = -1;
            m1017l();
        }

        private AnswerBackReply(boolean z) {
            this.f1036c = "";
            this.f1037d = Collections.emptyList();
            this.f1040g = -1;
        }

        /* renamed from: a */
        public static AnswerBackReply m1007a() {
            return f1034a;
        }

        /* renamed from: a */
        public static AnswerBackReply m1008a(byte[] bArr) {
            return ((Builder) m1016j().m4401mergeFrom(bArr)).m1031m();
        }

        /* renamed from: j */
        public static Builder m1016j() {
            return Builder.m1030l();
        }

        /* renamed from: l */
        private void m1017l() {
            this.f1039f = Result.m1890a();
        }

        /* renamed from: a */
        public AnswerbackItem m1018a(int i) {
            return (AnswerbackItem) this.f1037d.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AnswerBackReply getDefaultInstanceForType() {
            return f1034a;
        }

        /* renamed from: c */
        public boolean m1020c() {
            return this.f1035b;
        }

        /* renamed from: d */
        public String m1021d() {
            return this.f1036c;
        }

        /* renamed from: e */
        public List m1022e() {
            return this.f1037d;
        }

        /* renamed from: f */
        public int m1023f() {
            return this.f1037d.size();
        }

        /* renamed from: g */
        public boolean m1024g() {
            return this.f1038e;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i;
            int iM302b = this.f1040g;
            if (iM302b == -1) {
                int iM303b = m1020c() ? 0 + CodedOutputStream.m303b(1, m1021d()) : 0;
                Iterator it = m1022e().iterator();
                while (true) {
                    i = iM303b;
                    if (!it.hasNext()) {
                        break;
                    }
                    iM303b = CodedOutputStream.m302b(2, (AnswerbackItem) it.next()) + i;
                }
                iM302b = m1024g() ? CodedOutputStream.m302b(3, m1025h()) + i : i;
                this.f1040g = iM302b;
            }
            return iM302b;
        }

        /* renamed from: h */
        public Result m1025h() {
            return this.f1039f;
        }

        /* renamed from: i */
        public final boolean m1026i() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1016j();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1020c()) {
                codedOutputStream.m322a(1, m1021d());
            }
            Iterator it = m1022e().iterator();
            while (it.hasNext()) {
                codedOutputStream.m321a(2, (AnswerbackItem) it.next());
            }
            if (m1024g()) {
                codedOutputStream.m321a(3, m1025h());
            }
        }
    }

    public final class AnswerbackItem extends GeneratedMessageLite {

        /* renamed from: a */
        private static final AnswerbackItem f1042a = new AnswerbackItem(true);

        /* renamed from: b */
        private boolean f1043b;

        /* renamed from: c */
        private String f1044c;

        /* renamed from: d */
        private boolean f1045d;

        /* renamed from: e */
        private long f1046e;

        /* renamed from: f */
        private int f1047f;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private AnswerbackItem f1048a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: h */
            public static Builder m1064h() {
                Builder builder = new Builder();
                builder.f1048a = new AnswerbackItem();
                return builder;
            }

            /* renamed from: a */
            public Builder m1065a(long j) {
                this.f1048a.f1045d = true;
                this.f1048a.f1046e = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                            m1068a(codedInputStream.m287f());
                            break;
                        case 16:
                            m1065a(codedInputStream.m282c());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(AnswerbackItem answerbackItem) {
                if (answerbackItem == AnswerbackItem.m1050a()) {
                    return this;
                }
                if (answerbackItem.m1057c()) {
                    m1068a(answerbackItem.m1058d());
                }
                if (answerbackItem.m1059e()) {
                    m1065a(answerbackItem.m1060f());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1068a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1048a.f1043b = true;
                this.f1048a.f1044c = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AnswerbackItem internalGetResult() {
                return this.f1048a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1064h().mergeFrom(this.f1048a);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public AnswerbackItem mo4403getDefaultInstanceForType() {
                return AnswerbackItem.m1050a();
            }

            /* renamed from: d */
            public boolean m1072d() {
                return this.f1048a.m1061g();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public AnswerbackItem build() {
                if (this.f1048a == null || m1072d()) {
                    return m1074f();
                }
                throw newUninitializedMessageException(this.f1048a);
            }

            /* renamed from: f */
            public AnswerbackItem m1074f() {
                if (this.f1048a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                AnswerbackItem answerbackItem = this.f1048a;
                this.f1048a = null;
                return answerbackItem;
            }
        }

        static {
            SSMGPB.m810a();
            f1042a.m1055j();
        }

        private AnswerbackItem() {
            this.f1044c = "";
            this.f1046e = 0L;
            this.f1047f = -1;
            m1055j();
        }

        private AnswerbackItem(boolean z) {
            this.f1044c = "";
            this.f1046e = 0L;
            this.f1047f = -1;
        }

        /* renamed from: a */
        public static AnswerbackItem m1050a() {
            return f1042a;
        }

        /* renamed from: h */
        public static Builder m1054h() {
            return Builder.m1064h();
        }

        /* renamed from: j */
        private void m1055j() {
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AnswerbackItem getDefaultInstanceForType() {
            return f1042a;
        }

        /* renamed from: c */
        public boolean m1057c() {
            return this.f1043b;
        }

        /* renamed from: d */
        public String m1058d() {
            return this.f1044c;
        }

        /* renamed from: e */
        public boolean m1059e() {
            return this.f1045d;
        }

        /* renamed from: f */
        public long m1060f() {
            return this.f1046e;
        }

        /* renamed from: g */
        public final boolean m1061g() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM303b = this.f1047f;
            if (iM303b == -1) {
                iM303b = m1057c() ? 0 + CodedOutputStream.m303b(1, m1058d()) : 0;
                if (m1059e()) {
                    iM303b += CodedOutputStream.m301b(2, m1060f());
                }
                this.f1047f = iM303b;
            }
            return iM303b;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1054h();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1057c()) {
                codedOutputStream.m322a(1, m1058d());
            }
            if (m1059e()) {
                codedOutputStream.m320a(2, m1060f());
            }
        }
    }

    public final class ChangeMemberList extends GeneratedMessageLite {

        /* renamed from: a */
        private static final ChangeMemberList f1049a = new ChangeMemberList(true);

        /* renamed from: b */
        private boolean f1050b;

        /* renamed from: c */
        private ChangeStatus f1051c;

        /* renamed from: d */
        private boolean f1052d;

        /* renamed from: e */
        private String f1053e;

        /* renamed from: f */
        private boolean f1054f;

        /* renamed from: g */
        private String f1055g;

        /* renamed from: h */
        private int f1056h;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private ChangeMemberList f1057a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: h */
            public static Builder m1094h() {
                Builder builder = new Builder();
                builder.f1057a = new ChangeMemberList();
                return builder;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            ChangeStatus changeStatusM1106a = ChangeStatus.m1106a(codedInputStream.m289g());
                            if (changeStatusM1106a == null) {
                                break;
                            } else {
                                m1097a(changeStatusM1106a);
                                break;
                            }
                        case 18:
                            m1098a(codedInputStream.m287f());
                            break;
                        case 26:
                            m1101b(codedInputStream.m287f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(ChangeMemberList changeMemberList) {
                if (changeMemberList == ChangeMemberList.m1075a()) {
                    return this;
                }
                if (changeMemberList.m1085c()) {
                    m1097a(changeMemberList.m1086d());
                }
                if (changeMemberList.m1087e()) {
                    m1098a(changeMemberList.m1088f());
                }
                if (changeMemberList.m1089g()) {
                    m1101b(changeMemberList.m1090h());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1097a(ChangeStatus changeStatus) {
                if (changeStatus == null) {
                    throw new NullPointerException();
                }
                this.f1057a.f1050b = true;
                this.f1057a.f1051c = changeStatus;
                return this;
            }

            /* renamed from: a */
            public Builder m1098a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1057a.f1052d = true;
                this.f1057a.f1053e = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ChangeMemberList internalGetResult() {
                return this.f1057a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1094h().mergeFrom(this.f1057a);
            }

            /* renamed from: b */
            public Builder m1101b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1057a.f1054f = true;
                this.f1057a.f1055g = str;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ChangeMemberList mo4403getDefaultInstanceForType() {
                return ChangeMemberList.m1075a();
            }

            /* renamed from: d */
            public boolean m1103d() {
                return this.f1057a.m1091i();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public ChangeMemberList build() {
                if (this.f1057a == null || m1103d()) {
                    return m1105f();
                }
                throw newUninitializedMessageException(this.f1057a);
            }

            /* renamed from: f */
            public ChangeMemberList m1105f() {
                if (this.f1057a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                ChangeMemberList changeMemberList = this.f1057a;
                this.f1057a = null;
                return changeMemberList;
            }
        }

        static {
            SSMGPB.m810a();
            f1049a.m1083l();
        }

        private ChangeMemberList() {
            this.f1053e = "";
            this.f1055g = "";
            this.f1056h = -1;
            m1083l();
        }

        private ChangeMemberList(boolean z) {
            this.f1053e = "";
            this.f1055g = "";
            this.f1056h = -1;
        }

        /* renamed from: a */
        public static ChangeMemberList m1075a() {
            return f1049a;
        }

        /* renamed from: j */
        public static Builder m1082j() {
            return Builder.m1094h();
        }

        /* renamed from: l */
        private void m1083l() {
            this.f1051c = ChangeStatus.ENTER;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChangeMemberList getDefaultInstanceForType() {
            return f1049a;
        }

        /* renamed from: c */
        public boolean m1085c() {
            return this.f1050b;
        }

        /* renamed from: d */
        public ChangeStatus m1086d() {
            return this.f1051c;
        }

        /* renamed from: e */
        public boolean m1087e() {
            return this.f1052d;
        }

        /* renamed from: f */
        public String m1088f() {
            return this.f1053e;
        }

        /* renamed from: g */
        public boolean m1089g() {
            return this.f1054f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM311d = this.f1056h;
            if (iM311d == -1) {
                iM311d = m1085c() ? 0 + CodedOutputStream.m311d(1, m1086d().m1107a()) : 0;
                if (m1087e()) {
                    iM311d += CodedOutputStream.m303b(2, m1088f());
                }
                if (m1089g()) {
                    iM311d += CodedOutputStream.m303b(3, m1090h());
                }
                this.f1056h = iM311d;
            }
            return iM311d;
        }

        /* renamed from: h */
        public String m1090h() {
            return this.f1055g;
        }

        /* renamed from: i */
        public final boolean m1091i() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1082j();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1085c()) {
                codedOutputStream.m330b(1, m1086d().m1107a());
            }
            if (m1087e()) {
                codedOutputStream.m322a(2, m1088f());
            }
            if (m1089g()) {
                codedOutputStream.m322a(3, m1090h());
            }
        }
    }

    public enum ChangeStatus implements Internal.EnumLite {
        ENTER(0, 0),
        LEAVE(1, 1);


        /* renamed from: c */
        private static Internal.EnumLiteMap f1060c = new C0166b();

        /* renamed from: d */
        private final int f1062d;

        /* renamed from: e */
        private final int f1063e;

        ChangeStatus(int i, int i2) {
            this.f1062d = i;
            this.f1063e = i2;
        }

        /* renamed from: a */
        public static ChangeStatus m1106a(int i) {
            switch (i) {
                case 0:
                    return ENTER;
                case 1:
                    return LEAVE;
                default:
                    return null;
            }
        }

        /* renamed from: a */
        public final int m1107a() {
            return this.f1063e;
        }
    }

    public final class ChatReply extends GeneratedMessageLite {

        /* renamed from: a */
        private static final ChatReply f1064a = new ChatReply(true);

        /* renamed from: b */
        private boolean f1065b;

        /* renamed from: c */
        private long f1066c;

        /* renamed from: d */
        private boolean f1067d;

        /* renamed from: e */
        private String f1068e;

        /* renamed from: f */
        private boolean f1069f;

        /* renamed from: g */
        private ServerInfo f1070g;

        /* renamed from: h */
        private boolean f1071h;

        /* renamed from: i */
        private long f1072i;

        /* renamed from: j */
        private boolean f1073j;

        /* renamed from: k */
        private Result f1074k;

        /* renamed from: l */
        private int f1075l;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private ChatReply f1076a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: l */
            public static Builder m1139l() {
                Builder builder = new Builder();
                builder.f1076a = new ChatReply();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: m */
            public ChatReply m1140m() {
                if (m1153d()) {
                    return m1155f();
                }
                throw newUninitializedMessageException(this.f1076a).m350a();
            }

            /* renamed from: a */
            public Builder m1141a(long j) {
                this.f1076a.f1065b = true;
                this.f1076a.f1066c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m1141a(codedInputStream.m282c());
                            break;
                        case 18:
                            m1146a(codedInputStream.m287f());
                            break;
                        case 26:
                            ServerInfo.Builder builderM1921h = ServerInfo.m1921h();
                            if (m1156g()) {
                                builderM1921h.mergeFrom(m1157h());
                            }
                            codedInputStream.m278a(builderM1921h, extensionRegistryLite);
                            m1145a(builderM1921h.m1941f());
                            break;
                        case 32:
                            m1149b(codedInputStream.m282c());
                            break;
                        case 42:
                            Result.Builder builderM1894h = Result.m1894h();
                            if (m1158i()) {
                                builderM1894h.mergeFrom(m1159j());
                            }
                            codedInputStream.m278a(builderM1894h, extensionRegistryLite);
                            m1144a(builderM1894h.m1914f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(ChatReply chatReply) {
                if (chatReply == ChatReply.m1109a()) {
                    return this;
                }
                if (chatReply.m1125c()) {
                    m1141a(chatReply.m1126d());
                }
                if (chatReply.m1127e()) {
                    m1146a(chatReply.m1128f());
                }
                if (chatReply.m1129g()) {
                    m1151b(chatReply.m1130h());
                }
                if (chatReply.m1131i()) {
                    m1149b(chatReply.m1132j());
                }
                if (chatReply.m1133k()) {
                    m1150b(chatReply.m1134l());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1144a(Result result) {
                if (result == null) {
                    throw new NullPointerException();
                }
                this.f1076a.f1073j = true;
                this.f1076a.f1074k = result;
                return this;
            }

            /* renamed from: a */
            public Builder m1145a(ServerInfo serverInfo) {
                if (serverInfo == null) {
                    throw new NullPointerException();
                }
                this.f1076a.f1069f = true;
                this.f1076a.f1070g = serverInfo;
                return this;
            }

            /* renamed from: a */
            public Builder m1146a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1076a.f1067d = true;
                this.f1076a.f1068e = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ChatReply internalGetResult() {
                return this.f1076a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1139l().mergeFrom(this.f1076a);
            }

            /* renamed from: b */
            public Builder m1149b(long j) {
                this.f1076a.f1071h = true;
                this.f1076a.f1072i = j;
                return this;
            }

            /* renamed from: b */
            public Builder m1150b(Result result) {
                if (!this.f1076a.m1133k() || this.f1076a.f1074k == Result.m1890a()) {
                    this.f1076a.f1074k = result;
                } else {
                    this.f1076a.f1074k = Result.m1889a(this.f1076a.f1074k).mergeFrom(result).m1914f();
                }
                this.f1076a.f1073j = true;
                return this;
            }

            /* renamed from: b */
            public Builder m1151b(ServerInfo serverInfo) {
                if (!this.f1076a.m1129g() || this.f1076a.f1070g == ServerInfo.m1917a()) {
                    this.f1076a.f1070g = serverInfo;
                } else {
                    this.f1076a.f1070g = ServerInfo.m1916a(this.f1076a.f1070g).mergeFrom(serverInfo).m1941f();
                }
                this.f1076a.f1069f = true;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ChatReply mo4403getDefaultInstanceForType() {
                return ChatReply.m1109a();
            }

            /* renamed from: d */
            public boolean m1153d() {
                return this.f1076a.m1135m();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public ChatReply build() {
                if (this.f1076a == null || m1153d()) {
                    return m1155f();
                }
                throw newUninitializedMessageException(this.f1076a);
            }

            /* renamed from: f */
            public ChatReply m1155f() {
                if (this.f1076a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                ChatReply chatReply = this.f1076a;
                this.f1076a = null;
                return chatReply;
            }

            /* renamed from: g */
            public boolean m1156g() {
                return this.f1076a.m1129g();
            }

            /* renamed from: h */
            public ServerInfo m1157h() {
                return this.f1076a.m1130h();
            }

            /* renamed from: i */
            public boolean m1158i() {
                return this.f1076a.m1133k();
            }

            /* renamed from: j */
            public Result m1159j() {
                return this.f1076a.m1134l();
            }
        }

        static {
            SSMGPB.m810a();
            f1064a.m1123p();
        }

        private ChatReply() {
            this.f1066c = 0L;
            this.f1068e = "";
            this.f1072i = 0L;
            this.f1075l = -1;
            m1123p();
        }

        private ChatReply(boolean z) {
            this.f1066c = 0L;
            this.f1068e = "";
            this.f1072i = 0L;
            this.f1075l = -1;
        }

        /* renamed from: a */
        public static ChatReply m1109a() {
            return f1064a;
        }

        /* renamed from: a */
        public static ChatReply m1110a(byte[] bArr) {
            return ((Builder) m1122n().m4401mergeFrom(bArr)).m1140m();
        }

        /* renamed from: n */
        public static Builder m1122n() {
            return Builder.m1139l();
        }

        /* renamed from: p */
        private void m1123p() {
            this.f1070g = ServerInfo.m1917a();
            this.f1074k = Result.m1890a();
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChatReply getDefaultInstanceForType() {
            return f1064a;
        }

        /* renamed from: c */
        public boolean m1125c() {
            return this.f1065b;
        }

        /* renamed from: d */
        public long m1126d() {
            return this.f1066c;
        }

        /* renamed from: e */
        public boolean m1127e() {
            return this.f1067d;
        }

        /* renamed from: f */
        public String m1128f() {
            return this.f1068e;
        }

        /* renamed from: g */
        public boolean m1129g() {
            return this.f1069f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM301b = this.f1075l;
            if (iM301b == -1) {
                iM301b = m1125c() ? 0 + CodedOutputStream.m301b(1, m1126d()) : 0;
                if (m1127e()) {
                    iM301b += CodedOutputStream.m303b(2, m1128f());
                }
                if (m1129g()) {
                    iM301b += CodedOutputStream.m302b(3, m1130h());
                }
                if (m1131i()) {
                    iM301b += CodedOutputStream.m301b(4, m1132j());
                }
                if (m1133k()) {
                    iM301b += CodedOutputStream.m302b(5, m1134l());
                }
                this.f1075l = iM301b;
            }
            return iM301b;
        }

        /* renamed from: h */
        public ServerInfo m1130h() {
            return this.f1070g;
        }

        /* renamed from: i */
        public boolean m1131i() {
            return this.f1071h;
        }

        /* renamed from: j */
        public long m1132j() {
            return this.f1072i;
        }

        /* renamed from: k */
        public boolean m1133k() {
            return this.f1073j;
        }

        /* renamed from: l */
        public Result m1134l() {
            return this.f1074k;
        }

        /* renamed from: m */
        public final boolean m1135m() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1122n();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1125c()) {
                codedOutputStream.m320a(1, m1126d());
            }
            if (m1127e()) {
                codedOutputStream.m322a(2, m1128f());
            }
            if (m1129g()) {
                codedOutputStream.m321a(3, m1130h());
            }
            if (m1131i()) {
                codedOutputStream.m320a(4, m1132j());
            }
            if (m1133k()) {
                codedOutputStream.m321a(5, m1134l());
            }
        }
    }

    public final class ChatRequest extends GeneratedMessageLite {

        /* renamed from: a */
        private static final ChatRequest f1077a = new ChatRequest(true);

        /* renamed from: b */
        private boolean f1078b;

        /* renamed from: c */
        private long f1079c;

        /* renamed from: d */
        private boolean f1080d;

        /* renamed from: e */
        private MsgType f1081e;

        /* renamed from: f */
        private boolean f1082f;

        /* renamed from: g */
        private ChatType f1083g;

        /* renamed from: h */
        private boolean f1084h;

        /* renamed from: i */
        private String f1085i;

        /* renamed from: j */
        private boolean f1086j;

        /* renamed from: k */
        private String f1087k;

        /* renamed from: l */
        private List f1088l;

        /* renamed from: m */
        private boolean f1089m;

        /* renamed from: n */
        private String f1090n;

        /* renamed from: o */
        private boolean f1091o;

        /* renamed from: p */
        private String f1092p;

        /* renamed from: q */
        private boolean f1093q;

        /* renamed from: r */
        private String f1094r;

        /* renamed from: s */
        private boolean f1095s;

        /* renamed from: t */
        private String f1096t;

        /* renamed from: u */
        private int f1097u;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private ChatRequest f1098a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: r */
            public static Builder m1209r() {
                Builder builder = new Builder();
                builder.f1098a = new ChatRequest();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: s */
            public ChatRequest m1210s() {
                if (m1223d()) {
                    return m1227f();
                }
                throw newUninitializedMessageException(this.f1098a).m350a();
            }

            /* renamed from: a */
            public Builder m1211a(long j) {
                this.f1098a.f1078b = true;
                this.f1098a.f1079c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m1211a(codedInputStream.m282c());
                            break;
                        case 16:
                            MsgType msgTypeM1792a = MsgType.m1792a(codedInputStream.m289g());
                            if (msgTypeM1792a == null) {
                                break;
                            } else {
                                m1215a(msgTypeM1792a);
                                break;
                            }
                        case 24:
                            ChatType chatTypeM1239a = ChatType.m1239a(codedInputStream.m289g());
                            if (chatTypeM1239a == null) {
                                break;
                            } else {
                                m1214a(chatTypeM1239a);
                                break;
                            }
                        case 34:
                            m1216a(codedInputStream.m287f());
                            break;
                        case 42:
                            m1219b(codedInputStream.m287f());
                            break;
                        case 50:
                            m1220c(codedInputStream.m287f());
                            break;
                        case 58:
                            m1222d(codedInputStream.m287f());
                            break;
                        case 66:
                            m1224e(codedInputStream.m287f());
                            break;
                        case 74:
                            m1226f(codedInputStream.m287f());
                            break;
                        case 82:
                            m1229g(codedInputStream.m287f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(ChatRequest chatRequest) {
                if (chatRequest == ChatRequest.m1161a()) {
                    return this;
                }
                if (chatRequest.m1185c()) {
                    m1211a(chatRequest.m1186d());
                }
                if (chatRequest.m1187e()) {
                    m1215a(chatRequest.m1188f());
                }
                if (chatRequest.m1189g()) {
                    m1214a(chatRequest.m1190h());
                }
                if (chatRequest.m1191i()) {
                    m1216a(chatRequest.m1192j());
                }
                if (chatRequest.m1193k()) {
                    m1219b(chatRequest.m1194l());
                }
                if (!chatRequest.f1088l.isEmpty()) {
                    if (this.f1098a.f1088l.isEmpty()) {
                        this.f1098a.f1088l = new ArrayList();
                    }
                    this.f1098a.f1088l.addAll(chatRequest.f1088l);
                }
                if (chatRequest.m1197o()) {
                    m1222d(chatRequest.m1198p());
                }
                if (chatRequest.m1199q()) {
                    m1224e(chatRequest.m1200r());
                }
                if (chatRequest.m1201s()) {
                    m1226f(chatRequest.m1202t());
                }
                if (chatRequest.m1203u()) {
                    m1229g(chatRequest.m1204v());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1214a(ChatType chatType) {
                if (chatType == null) {
                    throw new NullPointerException();
                }
                this.f1098a.f1082f = true;
                this.f1098a.f1083g = chatType;
                return this;
            }

            /* renamed from: a */
            public Builder m1215a(MsgType msgType) {
                if (msgType == null) {
                    throw new NullPointerException();
                }
                this.f1098a.f1080d = true;
                this.f1098a.f1081e = msgType;
                return this;
            }

            /* renamed from: a */
            public Builder m1216a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1098a.f1084h = true;
                this.f1098a.f1085i = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ChatRequest internalGetResult() {
                return this.f1098a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1209r().mergeFrom(this.f1098a);
            }

            /* renamed from: b */
            public Builder m1219b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1098a.f1086j = true;
                this.f1098a.f1087k = str;
                return this;
            }

            /* renamed from: c */
            public Builder m1220c(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (this.f1098a.f1088l.isEmpty()) {
                    this.f1098a.f1088l = new ArrayList();
                }
                this.f1098a.f1088l.add(str);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ChatRequest mo4403getDefaultInstanceForType() {
                return ChatRequest.m1161a();
            }

            /* renamed from: d */
            public Builder m1222d(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1098a.f1089m = true;
                this.f1098a.f1090n = str;
                return this;
            }

            /* renamed from: d */
            public boolean m1223d() {
                return this.f1098a.m1205w();
            }

            /* renamed from: e */
            public Builder m1224e(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1098a.f1091o = true;
                this.f1098a.f1092p = str;
                return this;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public ChatRequest build() {
                if (this.f1098a == null || m1223d()) {
                    return m1227f();
                }
                throw newUninitializedMessageException(this.f1098a);
            }

            /* renamed from: f */
            public Builder m1226f(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1098a.f1093q = true;
                this.f1098a.f1094r = str;
                return this;
            }

            /* renamed from: f */
            public ChatRequest m1227f() {
                if (this.f1098a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.f1098a.f1088l != Collections.EMPTY_LIST) {
                    this.f1098a.f1088l = Collections.unmodifiableList(this.f1098a.f1088l);
                }
                ChatRequest chatRequest = this.f1098a;
                this.f1098a = null;
                return chatRequest;
            }

            /* renamed from: g */
            public long m1228g() {
                return this.f1098a.m1186d();
            }

            /* renamed from: g */
            public Builder m1229g(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1098a.f1095s = true;
                this.f1098a.f1096t = str;
                return this;
            }

            /* renamed from: h */
            public MsgType m1230h() {
                return this.f1098a.m1188f();
            }

            /* renamed from: i */
            public ChatType m1231i() {
                return this.f1098a.m1190h();
            }

            /* renamed from: j */
            public String m1232j() {
                return this.f1098a.m1192j();
            }

            /* renamed from: k */
            public String m1233k() {
                return this.f1098a.m1194l();
            }

            /* renamed from: l */
            public List m1234l() {
                return Collections.unmodifiableList(this.f1098a.f1088l);
            }

            /* renamed from: m */
            public int m1235m() {
                return this.f1098a.m1196n();
            }

            /* renamed from: n */
            public String m1236n() {
                return this.f1098a.m1200r();
            }

            /* renamed from: o */
            public String m1237o() {
                return this.f1098a.m1202t();
            }

            /* renamed from: p */
            public String m1238p() {
                return this.f1098a.m1204v();
            }
        }

        static {
            SSMGPB.m810a();
            f1077a.m1183z();
        }

        private ChatRequest() {
            this.f1079c = 0L;
            this.f1085i = "";
            this.f1087k = "";
            this.f1088l = Collections.emptyList();
            this.f1090n = "";
            this.f1092p = "";
            this.f1094r = "";
            this.f1096t = "";
            this.f1097u = -1;
            m1183z();
        }

        private ChatRequest(boolean z) {
            this.f1079c = 0L;
            this.f1085i = "";
            this.f1087k = "";
            this.f1088l = Collections.emptyList();
            this.f1090n = "";
            this.f1092p = "";
            this.f1094r = "";
            this.f1096t = "";
            this.f1097u = -1;
        }

        /* renamed from: a */
        public static ChatRequest m1161a() {
            return f1077a;
        }

        /* renamed from: a */
        public static ChatRequest m1162a(byte[] bArr) {
            return ((Builder) m1182x().m4401mergeFrom(bArr)).m1210s();
        }

        /* renamed from: x */
        public static Builder m1182x() {
            return Builder.m1209r();
        }

        /* renamed from: z */
        private void m1183z() {
            this.f1081e = MsgType.TEXT;
            this.f1083g = ChatType.SINGLE;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ChatRequest getDefaultInstanceForType() {
            return f1077a;
        }

        /* renamed from: c */
        public boolean m1185c() {
            return this.f1078b;
        }

        /* renamed from: d */
        public long m1186d() {
            return this.f1079c;
        }

        /* renamed from: e */
        public boolean m1187e() {
            return this.f1080d;
        }

        /* renamed from: f */
        public MsgType m1188f() {
            return this.f1081e;
        }

        /* renamed from: g */
        public boolean m1189g() {
            return this.f1082f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM307b = 0;
            int size = this.f1097u;
            if (size == -1) {
                int iM301b = m1185c() ? CodedOutputStream.m301b(1, m1186d()) + 0 : 0;
                if (m1187e()) {
                    iM301b += CodedOutputStream.m311d(2, m1188f().m1793a());
                }
                if (m1189g()) {
                    iM301b += CodedOutputStream.m311d(3, m1190h().m1240a());
                }
                if (m1191i()) {
                    iM301b += CodedOutputStream.m303b(4, m1192j());
                }
                int iM303b = m1193k() ? iM301b + CodedOutputStream.m303b(5, m1194l()) : iM301b;
                Iterator it = m1195m().iterator();
                while (it.hasNext()) {
                    iM307b = CodedOutputStream.m307b((String) it.next()) + iM307b;
                }
                size = iM303b + iM307b + (m1195m().size() * 1);
                if (m1197o()) {
                    size += CodedOutputStream.m303b(7, m1198p());
                }
                if (m1199q()) {
                    size += CodedOutputStream.m303b(8, m1200r());
                }
                if (m1201s()) {
                    size += CodedOutputStream.m303b(9, m1202t());
                }
                if (m1203u()) {
                    size += CodedOutputStream.m303b(10, m1204v());
                }
                this.f1097u = size;
            }
            return size;
        }

        /* renamed from: h */
        public ChatType m1190h() {
            return this.f1083g;
        }

        /* renamed from: i */
        public boolean m1191i() {
            return this.f1084h;
        }

        /* renamed from: j */
        public String m1192j() {
            return this.f1085i;
        }

        /* renamed from: k */
        public boolean m1193k() {
            return this.f1086j;
        }

        /* renamed from: l */
        public String m1194l() {
            return this.f1087k;
        }

        /* renamed from: m */
        public List m1195m() {
            return this.f1088l;
        }

        /* renamed from: n */
        public int m1196n() {
            return this.f1088l.size();
        }

        /* renamed from: o */
        public boolean m1197o() {
            return this.f1089m;
        }

        /* renamed from: p */
        public String m1198p() {
            return this.f1090n;
        }

        /* renamed from: q */
        public boolean m1199q() {
            return this.f1091o;
        }

        /* renamed from: r */
        public String m1200r() {
            return this.f1092p;
        }

        /* renamed from: s */
        public boolean m1201s() {
            return this.f1093q;
        }

        /* renamed from: t */
        public String m1202t() {
            return this.f1094r;
        }

        /* renamed from: u */
        public boolean m1203u() {
            return this.f1095s;
        }

        /* renamed from: v */
        public String m1204v() {
            return this.f1096t;
        }

        /* renamed from: w */
        public final boolean m1205w() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1185c()) {
                codedOutputStream.m320a(1, m1186d());
            }
            if (m1187e()) {
                codedOutputStream.m330b(2, m1188f().m1793a());
            }
            if (m1189g()) {
                codedOutputStream.m330b(3, m1190h().m1240a());
            }
            if (m1191i()) {
                codedOutputStream.m322a(4, m1192j());
            }
            if (m1193k()) {
                codedOutputStream.m322a(5, m1194l());
            }
            Iterator it = m1195m().iterator();
            while (it.hasNext()) {
                codedOutputStream.m322a(6, (String) it.next());
            }
            if (m1197o()) {
                codedOutputStream.m322a(7, m1198p());
            }
            if (m1199q()) {
                codedOutputStream.m322a(8, m1200r());
            }
            if (m1201s()) {
                codedOutputStream.m322a(9, m1202t());
            }
            if (m1203u()) {
                codedOutputStream.m322a(10, m1204v());
            }
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: y, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1182x();
        }
    }

    public enum ChatType implements Internal.EnumLite {
        SINGLE(0, 0),
        GROUP(1, 1),
        BROADCAST(2, 2);


        /* renamed from: d */
        private static Internal.EnumLiteMap f1102d = new C0170f();

        /* renamed from: e */
        private final int f1104e;

        /* renamed from: f */
        private final int f1105f;

        ChatType(int i, int i2) {
            this.f1104e = i;
            this.f1105f = i2;
        }

        /* renamed from: a */
        public static ChatType m1239a(int i) {
            switch (i) {
                case 0:
                    return SINGLE;
                case 1:
                    return GROUP;
                case 2:
                    return BROADCAST;
                default:
                    return null;
            }
        }

        /* renamed from: a */
        public final int m1240a() {
            return this.f1105f;
        }
    }

    public final class DeliveryChat extends GeneratedMessageLite {

        /* renamed from: a */
        private static final DeliveryChat f1106a = new DeliveryChat(true);

        /* renamed from: b */
        private boolean f1107b;

        /* renamed from: c */
        private String f1108c;

        /* renamed from: d */
        private boolean f1109d;

        /* renamed from: e */
        private ChatType f1110e;

        /* renamed from: f */
        private List f1111f;

        /* renamed from: g */
        private boolean f1112g;

        /* renamed from: h */
        private String f1113h;

        /* renamed from: i */
        private boolean f1114i;

        /* renamed from: j */
        private boolean f1115j;

        /* renamed from: k */
        private int f1116k;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private DeliveryChat f1117a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: h */
            public static Builder m1271h() {
                Builder builder = new Builder();
                builder.f1117a = new DeliveryChat();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: i */
            public DeliveryChat m1272i() {
                if (m1283d()) {
                    return m1285f();
                }
                throw newUninitializedMessageException(this.f1117a).m350a();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                            m1277a(codedInputStream.m287f());
                            break;
                        case 16:
                            ChatType chatTypeM1239a = ChatType.m1239a(codedInputStream.m289g());
                            if (chatTypeM1239a == null) {
                                break;
                            } else {
                                m1274a(chatTypeM1239a);
                                break;
                            }
                        case 26:
                            InboxMessage.Builder builderM1543r = InboxMessage.m1543r();
                            codedInputStream.m278a(builderM1543r, extensionRegistryLite);
                            m1276a(builderM1543r.m1579f());
                            break;
                        case 34:
                            m1281b(codedInputStream.m287f());
                            break;
                        case 40:
                            m1278a(codedInputStream.m285e());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            /* renamed from: a */
            public Builder m1274a(ChatType chatType) {
                if (chatType == null) {
                    throw new NullPointerException();
                }
                this.f1117a.f1109d = true;
                this.f1117a.f1110e = chatType;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(DeliveryChat deliveryChat) {
                if (deliveryChat == DeliveryChat.m1242a()) {
                    return this;
                }
                if (deliveryChat.m1257c()) {
                    m1277a(deliveryChat.m1258d());
                }
                if (deliveryChat.m1259e()) {
                    m1274a(deliveryChat.m1260f());
                }
                if (!deliveryChat.f1111f.isEmpty()) {
                    if (this.f1117a.f1111f.isEmpty()) {
                        this.f1117a.f1111f = new ArrayList();
                    }
                    this.f1117a.f1111f.addAll(deliveryChat.f1111f);
                }
                if (deliveryChat.m1263i()) {
                    m1281b(deliveryChat.m1264j());
                }
                if (deliveryChat.m1265k()) {
                    m1278a(deliveryChat.m1266l());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1276a(InboxMessage inboxMessage) {
                if (inboxMessage == null) {
                    throw new NullPointerException();
                }
                if (this.f1117a.f1111f.isEmpty()) {
                    this.f1117a.f1111f = new ArrayList();
                }
                this.f1117a.f1111f.add(inboxMessage);
                return this;
            }

            /* renamed from: a */
            public Builder m1277a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1117a.f1107b = true;
                this.f1117a.f1108c = str;
                return this;
            }

            /* renamed from: a */
            public Builder m1278a(boolean z) {
                this.f1117a.f1114i = true;
                this.f1117a.f1115j = z;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public DeliveryChat internalGetResult() {
                return this.f1117a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1271h().mergeFrom(this.f1117a);
            }

            /* renamed from: b */
            public Builder m1281b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1117a.f1112g = true;
                this.f1117a.f1113h = str;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public DeliveryChat mo4403getDefaultInstanceForType() {
                return DeliveryChat.m1242a();
            }

            /* renamed from: d */
            public boolean m1283d() {
                return this.f1117a.m1267m();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public DeliveryChat build() {
                if (this.f1117a == null || m1283d()) {
                    return m1285f();
                }
                throw newUninitializedMessageException(this.f1117a);
            }

            /* renamed from: f */
            public DeliveryChat m1285f() {
                if (this.f1117a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.f1117a.f1111f != Collections.EMPTY_LIST) {
                    this.f1117a.f1111f = Collections.unmodifiableList(this.f1117a.f1111f);
                }
                DeliveryChat deliveryChat = this.f1117a;
                this.f1117a = null;
                return deliveryChat;
            }
        }

        static {
            SSMGPB.m810a();
            f1106a.m1254p();
        }

        private DeliveryChat() {
            this.f1108c = "";
            this.f1111f = Collections.emptyList();
            this.f1113h = "";
            this.f1115j = false;
            this.f1116k = -1;
            m1254p();
        }

        private DeliveryChat(boolean z) {
            this.f1108c = "";
            this.f1111f = Collections.emptyList();
            this.f1113h = "";
            this.f1115j = false;
            this.f1116k = -1;
        }

        /* renamed from: a */
        public static DeliveryChat m1242a() {
            return f1106a;
        }

        /* renamed from: a */
        public static DeliveryChat m1243a(byte[] bArr) {
            return ((Builder) m1253n().m4401mergeFrom(bArr)).m1272i();
        }

        /* renamed from: n */
        public static Builder m1253n() {
            return Builder.m1271h();
        }

        /* renamed from: p */
        private void m1254p() {
            this.f1110e = ChatType.SINGLE;
        }

        /* renamed from: a */
        public InboxMessage m1255a(int i) {
            return (InboxMessage) this.f1111f.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DeliveryChat getDefaultInstanceForType() {
            return f1106a;
        }

        /* renamed from: c */
        public boolean m1257c() {
            return this.f1107b;
        }

        /* renamed from: d */
        public String m1258d() {
            return this.f1108c;
        }

        /* renamed from: e */
        public boolean m1259e() {
            return this.f1109d;
        }

        /* renamed from: f */
        public ChatType m1260f() {
            return this.f1110e;
        }

        /* renamed from: g */
        public List m1261g() {
            return this.f1111f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i;
            int iM303b = this.f1116k;
            if (iM303b == -1) {
                int iM303b2 = m1257c() ? 0 + CodedOutputStream.m303b(1, m1258d()) : 0;
                if (m1259e()) {
                    iM303b2 += CodedOutputStream.m311d(2, m1260f().m1240a());
                }
                Iterator it = m1261g().iterator();
                while (true) {
                    i = iM303b2;
                    if (!it.hasNext()) {
                        break;
                    }
                    iM303b2 = CodedOutputStream.m302b(3, (InboxMessage) it.next()) + i;
                }
                iM303b = m1263i() ? CodedOutputStream.m303b(4, m1264j()) + i : i;
                if (m1265k()) {
                    iM303b += CodedOutputStream.m304b(5, m1266l());
                }
                this.f1116k = iM303b;
            }
            return iM303b;
        }

        /* renamed from: h */
        public int m1262h() {
            return this.f1111f.size();
        }

        /* renamed from: i */
        public boolean m1263i() {
            return this.f1112g;
        }

        /* renamed from: j */
        public String m1264j() {
            return this.f1113h;
        }

        /* renamed from: k */
        public boolean m1265k() {
            return this.f1114i;
        }

        /* renamed from: l */
        public boolean m1266l() {
            return this.f1115j;
        }

        /* renamed from: m */
        public final boolean m1267m() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1253n();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1257c()) {
                codedOutputStream.m322a(1, m1258d());
            }
            if (m1259e()) {
                codedOutputStream.m330b(2, m1260f().m1240a());
            }
            Iterator it = m1261g().iterator();
            while (it.hasNext()) {
                codedOutputStream.m321a(3, (InboxMessage) it.next());
            }
            if (m1263i()) {
                codedOutputStream.m322a(4, m1264j());
            }
            if (m1265k()) {
                codedOutputStream.m323a(5, m1266l());
            }
        }
    }

    public final class DeliveryChatReply extends GeneratedMessageLite {

        /* renamed from: a */
        private static final DeliveryChatReply f1118a = new DeliveryChatReply(true);

        /* renamed from: b */
        private boolean f1119b;

        /* renamed from: c */
        private String f1120c;

        /* renamed from: d */
        private List f1121d;

        /* renamed from: e */
        private boolean f1122e;

        /* renamed from: f */
        private Result f1123f;

        /* renamed from: g */
        private int f1124g;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private DeliveryChatReply f1125a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: l */
            public static Builder m1309l() {
                Builder builder = new Builder();
                builder.f1125a = new DeliveryChatReply();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: m */
            public DeliveryChatReply m1310m() {
                if (m1321d()) {
                    return m1323f();
                }
                throw newUninitializedMessageException(this.f1125a).m350a();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                            m1315a(codedInputStream.m287f());
                            break;
                        case 18:
                            DeliveryChatReplyItem.Builder builderM1337l = DeliveryChatReplyItem.m1337l();
                            codedInputStream.m278a(builderM1337l, extensionRegistryLite);
                            m1313a(builderM1337l.m1363f());
                            break;
                        case 26:
                            Result.Builder builderM1894h = Result.m1894h();
                            if (m1326i()) {
                                builderM1894h.mergeFrom(m1327j());
                            }
                            codedInputStream.m278a(builderM1894h, extensionRegistryLite);
                            m1314a(builderM1894h.m1914f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(DeliveryChatReply deliveryChatReply) {
                if (deliveryChatReply == DeliveryChatReply.m1286a()) {
                    return this;
                }
                if (deliveryChatReply.m1299c()) {
                    m1315a(deliveryChatReply.m1300d());
                }
                if (!deliveryChatReply.f1121d.isEmpty()) {
                    if (this.f1125a.f1121d.isEmpty()) {
                        this.f1125a.f1121d = new ArrayList();
                    }
                    this.f1125a.f1121d.addAll(deliveryChatReply.f1121d);
                }
                if (deliveryChatReply.m1303g()) {
                    m1319b(deliveryChatReply.m1304h());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1313a(DeliveryChatReplyItem deliveryChatReplyItem) {
                if (deliveryChatReplyItem == null) {
                    throw new NullPointerException();
                }
                if (this.f1125a.f1121d.isEmpty()) {
                    this.f1125a.f1121d = new ArrayList();
                }
                this.f1125a.f1121d.add(deliveryChatReplyItem);
                return this;
            }

            /* renamed from: a */
            public Builder m1314a(Result result) {
                if (result == null) {
                    throw new NullPointerException();
                }
                this.f1125a.f1122e = true;
                this.f1125a.f1123f = result;
                return this;
            }

            /* renamed from: a */
            public Builder m1315a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1125a.f1119b = true;
                this.f1125a.f1120c = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public DeliveryChatReply internalGetResult() {
                return this.f1125a;
            }

            /* renamed from: a */
            public DeliveryChatReplyItem m1317a(int i) {
                return this.f1125a.m1297a(i);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1309l().mergeFrom(this.f1125a);
            }

            /* renamed from: b */
            public Builder m1319b(Result result) {
                if (!this.f1125a.m1303g() || this.f1125a.f1123f == Result.m1890a()) {
                    this.f1125a.f1123f = result;
                } else {
                    this.f1125a.f1123f = Result.m1889a(this.f1125a.f1123f).mergeFrom(result).m1914f();
                }
                this.f1125a.f1122e = true;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public DeliveryChatReply mo4403getDefaultInstanceForType() {
                return DeliveryChatReply.m1286a();
            }

            /* renamed from: d */
            public boolean m1321d() {
                return this.f1125a.m1305i();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public DeliveryChatReply build() {
                if (this.f1125a == null || m1321d()) {
                    return m1323f();
                }
                throw newUninitializedMessageException(this.f1125a);
            }

            /* renamed from: f */
            public DeliveryChatReply m1323f() {
                if (this.f1125a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.f1125a.f1121d != Collections.EMPTY_LIST) {
                    this.f1125a.f1121d = Collections.unmodifiableList(this.f1125a.f1121d);
                }
                DeliveryChatReply deliveryChatReply = this.f1125a;
                this.f1125a = null;
                return deliveryChatReply;
            }

            /* renamed from: g */
            public List m1324g() {
                return Collections.unmodifiableList(this.f1125a.f1121d);
            }

            /* renamed from: h */
            public int m1325h() {
                return this.f1125a.m1302f();
            }

            /* renamed from: i */
            public boolean m1326i() {
                return this.f1125a.m1303g();
            }

            /* renamed from: j */
            public Result m1327j() {
                return this.f1125a.m1304h();
            }
        }

        static {
            SSMGPB.m810a();
            f1118a.m1296l();
        }

        private DeliveryChatReply() {
            this.f1120c = "";
            this.f1121d = Collections.emptyList();
            this.f1124g = -1;
            m1296l();
        }

        private DeliveryChatReply(boolean z) {
            this.f1120c = "";
            this.f1121d = Collections.emptyList();
            this.f1124g = -1;
        }

        /* renamed from: a */
        public static DeliveryChatReply m1286a() {
            return f1118a;
        }

        /* renamed from: a */
        public static DeliveryChatReply m1287a(byte[] bArr) {
            return ((Builder) m1295j().m4401mergeFrom(bArr)).m1310m();
        }

        /* renamed from: j */
        public static Builder m1295j() {
            return Builder.m1309l();
        }

        /* renamed from: l */
        private void m1296l() {
            this.f1123f = Result.m1890a();
        }

        /* renamed from: a */
        public DeliveryChatReplyItem m1297a(int i) {
            return (DeliveryChatReplyItem) this.f1121d.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DeliveryChatReply getDefaultInstanceForType() {
            return f1118a;
        }

        /* renamed from: c */
        public boolean m1299c() {
            return this.f1119b;
        }

        /* renamed from: d */
        public String m1300d() {
            return this.f1120c;
        }

        /* renamed from: e */
        public List m1301e() {
            return this.f1121d;
        }

        /* renamed from: f */
        public int m1302f() {
            return this.f1121d.size();
        }

        /* renamed from: g */
        public boolean m1303g() {
            return this.f1122e;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i;
            int iM302b = this.f1124g;
            if (iM302b == -1) {
                int iM303b = m1299c() ? 0 + CodedOutputStream.m303b(1, m1300d()) : 0;
                Iterator it = m1301e().iterator();
                while (true) {
                    i = iM303b;
                    if (!it.hasNext()) {
                        break;
                    }
                    iM303b = CodedOutputStream.m302b(2, (DeliveryChatReplyItem) it.next()) + i;
                }
                iM302b = m1303g() ? CodedOutputStream.m302b(3, m1304h()) + i : i;
                this.f1124g = iM302b;
            }
            return iM302b;
        }

        /* renamed from: h */
        public Result m1304h() {
            return this.f1123f;
        }

        /* renamed from: i */
        public final boolean m1305i() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1295j();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1299c()) {
                codedOutputStream.m322a(1, m1300d());
            }
            Iterator it = m1301e().iterator();
            while (it.hasNext()) {
                codedOutputStream.m321a(2, (DeliveryChatReplyItem) it.next());
            }
            if (m1303g()) {
                codedOutputStream.m321a(3, m1304h());
            }
        }
    }

    public final class DeliveryChatReplyItem extends GeneratedMessageLite {

        /* renamed from: a */
        private static final DeliveryChatReplyItem f1126a = new DeliveryChatReplyItem(true);

        /* renamed from: b */
        private boolean f1127b;

        /* renamed from: c */
        private String f1128c;

        /* renamed from: d */
        private boolean f1129d;

        /* renamed from: e */
        private String f1130e;

        /* renamed from: f */
        private boolean f1131f;

        /* renamed from: g */
        private long f1132g;

        /* renamed from: h */
        private boolean f1133h;

        /* renamed from: i */
        private MsgType f1134i;

        /* renamed from: j */
        private int f1135j;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private DeliveryChatReplyItem f1136a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: h */
            public static Builder m1351h() {
                Builder builder = new Builder();
                builder.f1136a = new DeliveryChatReplyItem();
                return builder;
            }

            /* renamed from: a */
            public Builder m1352a(long j) {
                this.f1136a.f1131f = true;
                this.f1136a.f1132g = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                            m1356a(codedInputStream.m287f());
                            break;
                        case 18:
                            m1359b(codedInputStream.m287f());
                            break;
                        case 24:
                            m1352a(codedInputStream.m282c());
                            break;
                        case 32:
                            MsgType msgTypeM1792a = MsgType.m1792a(codedInputStream.m289g());
                            if (msgTypeM1792a == null) {
                                break;
                            } else {
                                m1355a(msgTypeM1792a);
                                break;
                            }
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(DeliveryChatReplyItem deliveryChatReplyItem) {
                if (deliveryChatReplyItem == DeliveryChatReplyItem.m1329a()) {
                    return this;
                }
                if (deliveryChatReplyItem.m1340c()) {
                    m1356a(deliveryChatReplyItem.m1341d());
                }
                if (deliveryChatReplyItem.m1342e()) {
                    m1359b(deliveryChatReplyItem.m1343f());
                }
                if (deliveryChatReplyItem.m1344g()) {
                    m1352a(deliveryChatReplyItem.m1345h());
                }
                if (deliveryChatReplyItem.m1346i()) {
                    m1355a(deliveryChatReplyItem.m1347j());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1355a(MsgType msgType) {
                if (msgType == null) {
                    throw new NullPointerException();
                }
                this.f1136a.f1133h = true;
                this.f1136a.f1134i = msgType;
                return this;
            }

            /* renamed from: a */
            public Builder m1356a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1136a.f1127b = true;
                this.f1136a.f1128c = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public DeliveryChatReplyItem internalGetResult() {
                return this.f1136a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1351h().mergeFrom(this.f1136a);
            }

            /* renamed from: b */
            public Builder m1359b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1136a.f1129d = true;
                this.f1136a.f1130e = str;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public DeliveryChatReplyItem mo4403getDefaultInstanceForType() {
                return DeliveryChatReplyItem.m1329a();
            }

            /* renamed from: d */
            public boolean m1361d() {
                return this.f1136a.m1348k();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public DeliveryChatReplyItem build() {
                if (this.f1136a == null || m1361d()) {
                    return m1363f();
                }
                throw newUninitializedMessageException(this.f1136a);
            }

            /* renamed from: f */
            public DeliveryChatReplyItem m1363f() {
                if (this.f1136a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                DeliveryChatReplyItem deliveryChatReplyItem = this.f1136a;
                this.f1136a = null;
                return deliveryChatReplyItem;
            }
        }

        static {
            SSMGPB.m810a();
            f1126a.m1338n();
        }

        private DeliveryChatReplyItem() {
            this.f1128c = "";
            this.f1130e = "";
            this.f1132g = 0L;
            this.f1135j = -1;
            m1338n();
        }

        private DeliveryChatReplyItem(boolean z) {
            this.f1128c = "";
            this.f1130e = "";
            this.f1132g = 0L;
            this.f1135j = -1;
        }

        /* renamed from: a */
        public static DeliveryChatReplyItem m1329a() {
            return f1126a;
        }

        /* renamed from: l */
        public static Builder m1337l() {
            return Builder.m1351h();
        }

        /* renamed from: n */
        private void m1338n() {
            this.f1134i = MsgType.TEXT;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DeliveryChatReplyItem getDefaultInstanceForType() {
            return f1126a;
        }

        /* renamed from: c */
        public boolean m1340c() {
            return this.f1127b;
        }

        /* renamed from: d */
        public String m1341d() {
            return this.f1128c;
        }

        /* renamed from: e */
        public boolean m1342e() {
            return this.f1129d;
        }

        /* renamed from: f */
        public String m1343f() {
            return this.f1130e;
        }

        /* renamed from: g */
        public boolean m1344g() {
            return this.f1131f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM303b = this.f1135j;
            if (iM303b == -1) {
                iM303b = m1340c() ? 0 + CodedOutputStream.m303b(1, m1341d()) : 0;
                if (m1342e()) {
                    iM303b += CodedOutputStream.m303b(2, m1343f());
                }
                if (m1344g()) {
                    iM303b += CodedOutputStream.m301b(3, m1345h());
                }
                if (m1346i()) {
                    iM303b += CodedOutputStream.m311d(4, m1347j().m1793a());
                }
                this.f1135j = iM303b;
            }
            return iM303b;
        }

        /* renamed from: h */
        public long m1345h() {
            return this.f1132g;
        }

        /* renamed from: i */
        public boolean m1346i() {
            return this.f1133h;
        }

        /* renamed from: j */
        public MsgType m1347j() {
            return this.f1134i;
        }

        /* renamed from: k */
        public final boolean m1348k() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1337l();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1340c()) {
                codedOutputStream.m322a(1, m1341d());
            }
            if (m1342e()) {
                codedOutputStream.m322a(2, m1343f());
            }
            if (m1344g()) {
                codedOutputStream.m320a(3, m1345h());
            }
            if (m1346i()) {
                codedOutputStream.m330b(4, m1347j().m1793a());
            }
        }
    }

    public enum DisconnectActionType implements Internal.EnumLite {
        CLOSE(0, 0),
        HOLD_ON(1, 1);


        /* renamed from: c */
        private static Internal.EnumLiteMap f1139c = new C0165a();

        /* renamed from: d */
        private final int f1141d;

        /* renamed from: e */
        private final int f1142e;

        DisconnectActionType(int i, int i2) {
            this.f1141d = i;
            this.f1142e = i2;
        }

        /* renamed from: a */
        public static DisconnectActionType m1364a(int i) {
            switch (i) {
                case 0:
                    return CLOSE;
                case 1:
                    return HOLD_ON;
                default:
                    return null;
            }
        }

        /* renamed from: a */
        public final int m1365a() {
            return this.f1142e;
        }
    }

    public final class DisconnectReply extends GeneratedMessageLite {

        /* renamed from: a */
        private static final DisconnectReply f1143a = new DisconnectReply(true);

        /* renamed from: b */
        private boolean f1144b;

        /* renamed from: c */
        private long f1145c;

        /* renamed from: d */
        private boolean f1146d;

        /* renamed from: e */
        private DisconnectActionType f1147e;

        /* renamed from: f */
        private boolean f1148f;

        /* renamed from: g */
        private Result f1149g;

        /* renamed from: h */
        private int f1150h;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private DisconnectReply f1151a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: l */
            public static Builder m1388l() {
                Builder builder = new Builder();
                builder.f1151a = new DisconnectReply();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: m */
            public DisconnectReply m1389m() {
                if (m1399d()) {
                    return m1401f();
                }
                throw newUninitializedMessageException(this.f1151a).m350a();
            }

            /* renamed from: a */
            public Builder m1390a(long j) {
                this.f1151a.f1144b = true;
                this.f1151a.f1145c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m1390a(codedInputStream.m282c());
                            break;
                        case 16:
                            DisconnectActionType disconnectActionTypeM1364a = DisconnectActionType.m1364a(codedInputStream.m289g());
                            if (disconnectActionTypeM1364a == null) {
                                break;
                            } else {
                                m1392a(disconnectActionTypeM1364a);
                                break;
                            }
                        case 26:
                            Result.Builder builderM1894h = Result.m1894h();
                            if (m1404i()) {
                                builderM1894h.mergeFrom(m1405j());
                            }
                            codedInputStream.m278a(builderM1894h, extensionRegistryLite);
                            m1394a(builderM1894h.m1914f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            /* renamed from: a */
            public Builder m1392a(DisconnectActionType disconnectActionType) {
                if (disconnectActionType == null) {
                    throw new NullPointerException();
                }
                this.f1151a.f1146d = true;
                this.f1151a.f1147e = disconnectActionType;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(DisconnectReply disconnectReply) {
                if (disconnectReply == DisconnectReply.m1368a()) {
                    return this;
                }
                if (disconnectReply.m1378c()) {
                    m1390a(disconnectReply.m1379d());
                }
                if (disconnectReply.m1380e()) {
                    m1392a(disconnectReply.m1381f());
                }
                if (disconnectReply.m1382g()) {
                    m1397b(disconnectReply.m1383h());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1394a(Result result) {
                if (result == null) {
                    throw new NullPointerException();
                }
                this.f1151a.f1148f = true;
                this.f1151a.f1149g = result;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public DisconnectReply internalGetResult() {
                return this.f1151a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1388l().mergeFrom(this.f1151a);
            }

            /* renamed from: b */
            public Builder m1397b(Result result) {
                if (!this.f1151a.m1382g() || this.f1151a.f1149g == Result.m1890a()) {
                    this.f1151a.f1149g = result;
                } else {
                    this.f1151a.f1149g = Result.m1889a(this.f1151a.f1149g).mergeFrom(result).m1914f();
                }
                this.f1151a.f1148f = true;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public DisconnectReply mo4403getDefaultInstanceForType() {
                return DisconnectReply.m1368a();
            }

            /* renamed from: d */
            public boolean m1399d() {
                return this.f1151a.m1384i();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public DisconnectReply build() {
                if (this.f1151a == null || m1399d()) {
                    return m1401f();
                }
                throw newUninitializedMessageException(this.f1151a);
            }

            /* renamed from: f */
            public DisconnectReply m1401f() {
                if (this.f1151a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                DisconnectReply disconnectReply = this.f1151a;
                this.f1151a = null;
                return disconnectReply;
            }

            /* renamed from: g */
            public long m1402g() {
                return this.f1151a.m1379d();
            }

            /* renamed from: h */
            public DisconnectActionType m1403h() {
                return this.f1151a.m1381f();
            }

            /* renamed from: i */
            public boolean m1404i() {
                return this.f1151a.m1382g();
            }

            /* renamed from: j */
            public Result m1405j() {
                return this.f1151a.m1383h();
            }
        }

        static {
            SSMGPB.m810a();
            f1143a.m1376l();
        }

        private DisconnectReply() {
            this.f1145c = 0L;
            this.f1150h = -1;
            m1376l();
        }

        private DisconnectReply(boolean z) {
            this.f1145c = 0L;
            this.f1150h = -1;
        }

        /* renamed from: a */
        public static DisconnectReply m1368a() {
            return f1143a;
        }

        /* renamed from: a */
        public static DisconnectReply m1369a(byte[] bArr) {
            return ((Builder) m1375j().m4401mergeFrom(bArr)).m1389m();
        }

        /* renamed from: j */
        public static Builder m1375j() {
            return Builder.m1388l();
        }

        /* renamed from: l */
        private void m1376l() {
            this.f1147e = DisconnectActionType.CLOSE;
            this.f1149g = Result.m1890a();
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DisconnectReply getDefaultInstanceForType() {
            return f1143a;
        }

        /* renamed from: c */
        public boolean m1378c() {
            return this.f1144b;
        }

        /* renamed from: d */
        public long m1379d() {
            return this.f1145c;
        }

        /* renamed from: e */
        public boolean m1380e() {
            return this.f1146d;
        }

        /* renamed from: f */
        public DisconnectActionType m1381f() {
            return this.f1147e;
        }

        /* renamed from: g */
        public boolean m1382g() {
            return this.f1148f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM301b = this.f1150h;
            if (iM301b == -1) {
                iM301b = m1378c() ? 0 + CodedOutputStream.m301b(1, m1379d()) : 0;
                if (m1380e()) {
                    iM301b += CodedOutputStream.m311d(2, m1381f().m1365a());
                }
                if (m1382g()) {
                    iM301b += CodedOutputStream.m302b(3, m1383h());
                }
                this.f1150h = iM301b;
            }
            return iM301b;
        }

        /* renamed from: h */
        public Result m1383h() {
            return this.f1149g;
        }

        /* renamed from: i */
        public final boolean m1384i() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1375j();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1378c()) {
                codedOutputStream.m320a(1, m1379d());
            }
            if (m1380e()) {
                codedOutputStream.m330b(2, m1381f().m1365a());
            }
            if (m1382g()) {
                codedOutputStream.m321a(3, m1383h());
            }
        }
    }

    public final class DisconnectRequest extends GeneratedMessageLite {

        /* renamed from: a */
        private static final DisconnectRequest f1152a = new DisconnectRequest(true);

        /* renamed from: b */
        private boolean f1153b;

        /* renamed from: c */
        private long f1154c;

        /* renamed from: d */
        private boolean f1155d;

        /* renamed from: e */
        private DisconnectType f1156e;

        /* renamed from: f */
        private boolean f1157f;

        /* renamed from: g */
        private String f1158g;

        /* renamed from: h */
        private int f1159h;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private DisconnectRequest f1160a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: h */
            public static Builder m1427h() {
                Builder builder = new Builder();
                builder.f1160a = new DisconnectRequest();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: i */
            public DisconnectRequest m1428i() {
                if (m1437d()) {
                    return m1439f();
                }
                throw newUninitializedMessageException(this.f1160a).m350a();
            }

            /* renamed from: a */
            public Builder m1429a(long j) {
                this.f1160a.f1153b = true;
                this.f1160a.f1154c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m1429a(codedInputStream.m282c());
                            break;
                        case 16:
                            DisconnectType disconnectTypeM1440a = DisconnectType.m1440a(codedInputStream.m289g());
                            if (disconnectTypeM1440a == null) {
                                break;
                            } else {
                                m1432a(disconnectTypeM1440a);
                                break;
                            }
                        case 26:
                            m1433a(codedInputStream.m287f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(DisconnectRequest disconnectRequest) {
                if (disconnectRequest == DisconnectRequest.m1407a()) {
                    return this;
                }
                if (disconnectRequest.m1417c()) {
                    m1429a(disconnectRequest.m1418d());
                }
                if (disconnectRequest.m1419e()) {
                    m1432a(disconnectRequest.m1420f());
                }
                if (disconnectRequest.m1421g()) {
                    m1433a(disconnectRequest.m1422h());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1432a(DisconnectType disconnectType) {
                if (disconnectType == null) {
                    throw new NullPointerException();
                }
                this.f1160a.f1155d = true;
                this.f1160a.f1156e = disconnectType;
                return this;
            }

            /* renamed from: a */
            public Builder m1433a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1160a.f1157f = true;
                this.f1160a.f1158g = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public DisconnectRequest internalGetResult() {
                return this.f1160a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1427h().mergeFrom(this.f1160a);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public DisconnectRequest mo4403getDefaultInstanceForType() {
                return DisconnectRequest.m1407a();
            }

            /* renamed from: d */
            public boolean m1437d() {
                return this.f1160a.m1423i();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public DisconnectRequest build() {
                if (this.f1160a == null || m1437d()) {
                    return m1439f();
                }
                throw newUninitializedMessageException(this.f1160a);
            }

            /* renamed from: f */
            public DisconnectRequest m1439f() {
                if (this.f1160a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                DisconnectRequest disconnectRequest = this.f1160a;
                this.f1160a = null;
                return disconnectRequest;
            }
        }

        static {
            SSMGPB.m810a();
            f1152a.m1415l();
        }

        private DisconnectRequest() {
            this.f1154c = 0L;
            this.f1158g = "";
            this.f1159h = -1;
            m1415l();
        }

        private DisconnectRequest(boolean z) {
            this.f1154c = 0L;
            this.f1158g = "";
            this.f1159h = -1;
        }

        /* renamed from: a */
        public static DisconnectRequest m1407a() {
            return f1152a;
        }

        /* renamed from: a */
        public static DisconnectRequest m1408a(byte[] bArr) {
            return ((Builder) m1414j().m4401mergeFrom(bArr)).m1428i();
        }

        /* renamed from: j */
        public static Builder m1414j() {
            return Builder.m1427h();
        }

        /* renamed from: l */
        private void m1415l() {
            this.f1156e = DisconnectType.TIMEOUT;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DisconnectRequest getDefaultInstanceForType() {
            return f1152a;
        }

        /* renamed from: c */
        public boolean m1417c() {
            return this.f1153b;
        }

        /* renamed from: d */
        public long m1418d() {
            return this.f1154c;
        }

        /* renamed from: e */
        public boolean m1419e() {
            return this.f1155d;
        }

        /* renamed from: f */
        public DisconnectType m1420f() {
            return this.f1156e;
        }

        /* renamed from: g */
        public boolean m1421g() {
            return this.f1157f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM301b = this.f1159h;
            if (iM301b == -1) {
                iM301b = m1417c() ? 0 + CodedOutputStream.m301b(1, m1418d()) : 0;
                if (m1419e()) {
                    iM301b += CodedOutputStream.m311d(2, m1420f().m1441a());
                }
                if (m1421g()) {
                    iM301b += CodedOutputStream.m303b(3, m1422h());
                }
                this.f1159h = iM301b;
            }
            return iM301b;
        }

        /* renamed from: h */
        public String m1422h() {
            return this.f1158g;
        }

        /* renamed from: i */
        public final boolean m1423i() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1414j();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1417c()) {
                codedOutputStream.m320a(1, m1418d());
            }
            if (m1419e()) {
                codedOutputStream.m330b(2, m1420f().m1441a());
            }
            if (m1421g()) {
                codedOutputStream.m322a(3, m1422h());
            }
        }
    }

    public enum DisconnectType implements Internal.EnumLite {
        TIMEOUT(0, 0),
        GROUPCHAT_END(1, 1);


        /* renamed from: c */
        private static Internal.EnumLiteMap f1163c = new C0167c();

        /* renamed from: d */
        private final int f1165d;

        /* renamed from: e */
        private final int f1166e;

        DisconnectType(int i, int i2) {
            this.f1165d = i;
            this.f1166e = i2;
        }

        /* renamed from: a */
        public static DisconnectType m1440a(int i) {
            switch (i) {
                case 0:
                    return TIMEOUT;
                case 1:
                    return GROUPCHAT_END;
                default:
                    return null;
            }
        }

        /* renamed from: a */
        public final int m1441a() {
            return this.f1166e;
        }
    }

    public final class EndChatReply extends GeneratedMessageLite {

        /* renamed from: a */
        private static final EndChatReply f1167a = new EndChatReply(true);

        /* renamed from: b */
        private boolean f1168b;

        /* renamed from: c */
        private long f1169c;

        /* renamed from: d */
        private boolean f1170d;

        /* renamed from: e */
        private Result f1171e;

        /* renamed from: f */
        private int f1172f;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private EndChatReply f1173a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: j */
            public static Builder m1460j() {
                Builder builder = new Builder();
                builder.f1173a = new EndChatReply();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: k */
            public EndChatReply m1461k() {
                if (m1470d()) {
                    return m1472f();
                }
                throw newUninitializedMessageException(this.f1173a).m350a();
            }

            /* renamed from: a */
            public Builder m1462a(long j) {
                this.f1173a.f1168b = true;
                this.f1173a.f1169c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m1462a(codedInputStream.m282c());
                            break;
                        case 18:
                            Result.Builder builderM1894h = Result.m1894h();
                            if (m1473g()) {
                                builderM1894h.mergeFrom(m1474h());
                            }
                            codedInputStream.m278a(builderM1894h, extensionRegistryLite);
                            m1465a(builderM1894h.m1914f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(EndChatReply endChatReply) {
                if (endChatReply == EndChatReply.m1443a()) {
                    return this;
                }
                if (endChatReply.m1452c()) {
                    m1462a(endChatReply.m1453d());
                }
                if (endChatReply.m1454e()) {
                    m1468b(endChatReply.m1455f());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1465a(Result result) {
                if (result == null) {
                    throw new NullPointerException();
                }
                this.f1173a.f1170d = true;
                this.f1173a.f1171e = result;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public EndChatReply internalGetResult() {
                return this.f1173a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1460j().mergeFrom(this.f1173a);
            }

            /* renamed from: b */
            public Builder m1468b(Result result) {
                if (!this.f1173a.m1454e() || this.f1173a.f1171e == Result.m1890a()) {
                    this.f1173a.f1171e = result;
                } else {
                    this.f1173a.f1171e = Result.m1889a(this.f1173a.f1171e).mergeFrom(result).m1914f();
                }
                this.f1173a.f1170d = true;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public EndChatReply mo4403getDefaultInstanceForType() {
                return EndChatReply.m1443a();
            }

            /* renamed from: d */
            public boolean m1470d() {
                return this.f1173a.m1456g();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public EndChatReply build() {
                if (this.f1173a == null || m1470d()) {
                    return m1472f();
                }
                throw newUninitializedMessageException(this.f1173a);
            }

            /* renamed from: f */
            public EndChatReply m1472f() {
                if (this.f1173a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                EndChatReply endChatReply = this.f1173a;
                this.f1173a = null;
                return endChatReply;
            }

            /* renamed from: g */
            public boolean m1473g() {
                return this.f1173a.m1454e();
            }

            /* renamed from: h */
            public Result m1474h() {
                return this.f1173a.m1455f();
            }
        }

        static {
            SSMGPB.m810a();
            f1167a.m1450j();
        }

        private EndChatReply() {
            this.f1169c = 0L;
            this.f1172f = -1;
            m1450j();
        }

        private EndChatReply(boolean z) {
            this.f1169c = 0L;
            this.f1172f = -1;
        }

        /* renamed from: a */
        public static EndChatReply m1443a() {
            return f1167a;
        }

        /* renamed from: a */
        public static EndChatReply m1444a(byte[] bArr) {
            return ((Builder) m1449h().m4401mergeFrom(bArr)).m1461k();
        }

        /* renamed from: h */
        public static Builder m1449h() {
            return Builder.m1460j();
        }

        /* renamed from: j */
        private void m1450j() {
            this.f1171e = Result.m1890a();
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EndChatReply getDefaultInstanceForType() {
            return f1167a;
        }

        /* renamed from: c */
        public boolean m1452c() {
            return this.f1168b;
        }

        /* renamed from: d */
        public long m1453d() {
            return this.f1169c;
        }

        /* renamed from: e */
        public boolean m1454e() {
            return this.f1170d;
        }

        /* renamed from: f */
        public Result m1455f() {
            return this.f1171e;
        }

        /* renamed from: g */
        public final boolean m1456g() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM301b = this.f1172f;
            if (iM301b == -1) {
                iM301b = m1452c() ? 0 + CodedOutputStream.m301b(1, m1453d()) : 0;
                if (m1454e()) {
                    iM301b += CodedOutputStream.m302b(2, m1455f());
                }
                this.f1172f = iM301b;
            }
            return iM301b;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1449h();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1452c()) {
                codedOutputStream.m320a(1, m1453d());
            }
            if (m1454e()) {
                codedOutputStream.m321a(2, m1455f());
            }
        }
    }

    public final class EndChatRequest extends GeneratedMessageLite {

        /* renamed from: a */
        private static final EndChatRequest f1174a = new EndChatRequest(true);

        /* renamed from: b */
        private boolean f1175b;

        /* renamed from: c */
        private long f1176c;

        /* renamed from: d */
        private boolean f1177d;

        /* renamed from: e */
        private ChatType f1178e;

        /* renamed from: f */
        private boolean f1179f;

        /* renamed from: g */
        private String f1180g;

        /* renamed from: h */
        private boolean f1181h;

        /* renamed from: i */
        private String f1182i;

        /* renamed from: j */
        private boolean f1183j;

        /* renamed from: k */
        private String f1184k;

        /* renamed from: l */
        private List f1185l;

        /* renamed from: m */
        private int f1186m;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private EndChatRequest f1187a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: m */
            public static Builder m1507m() {
                Builder builder = new Builder();
                builder.f1187a = new EndChatRequest();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: n */
            public EndChatRequest m1508n() {
                if (m1520d()) {
                    return m1522f();
                }
                throw newUninitializedMessageException(this.f1187a).m350a();
            }

            /* renamed from: a */
            public Builder m1509a(long j) {
                this.f1187a.f1175b = true;
                this.f1187a.f1176c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m1509a(codedInputStream.m282c());
                            break;
                        case 16:
                            ChatType chatTypeM1239a = ChatType.m1239a(codedInputStream.m289g());
                            if (chatTypeM1239a == null) {
                                break;
                            } else {
                                m1511a(chatTypeM1239a);
                                break;
                            }
                        case 26:
                            m1513a(codedInputStream.m287f());
                            break;
                        case 34:
                            m1516b(codedInputStream.m287f());
                            break;
                        case 42:
                            m1517c(codedInputStream.m287f());
                            break;
                        case 50:
                            m1519d(codedInputStream.m287f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            /* renamed from: a */
            public Builder m1511a(ChatType chatType) {
                if (chatType == null) {
                    throw new NullPointerException();
                }
                this.f1187a.f1177d = true;
                this.f1187a.f1178e = chatType;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(EndChatRequest endChatRequest) {
                if (endChatRequest == EndChatRequest.m1477a()) {
                    return this;
                }
                if (endChatRequest.m1492c()) {
                    m1509a(endChatRequest.m1493d());
                }
                if (endChatRequest.m1494e()) {
                    m1511a(endChatRequest.m1495f());
                }
                if (endChatRequest.m1496g()) {
                    m1513a(endChatRequest.m1497h());
                }
                if (endChatRequest.m1498i()) {
                    m1516b(endChatRequest.m1499j());
                }
                if (endChatRequest.m1500k()) {
                    m1517c(endChatRequest.m1501l());
                }
                if (!endChatRequest.f1185l.isEmpty()) {
                    if (this.f1187a.f1185l.isEmpty()) {
                        this.f1187a.f1185l = new ArrayList();
                    }
                    this.f1187a.f1185l.addAll(endChatRequest.f1185l);
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1513a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1187a.f1179f = true;
                this.f1187a.f1180g = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public EndChatRequest internalGetResult() {
                return this.f1187a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1507m().mergeFrom(this.f1187a);
            }

            /* renamed from: b */
            public Builder m1516b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1187a.f1181h = true;
                this.f1187a.f1182i = str;
                return this;
            }

            /* renamed from: c */
            public Builder m1517c(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1187a.f1183j = true;
                this.f1187a.f1184k = str;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public EndChatRequest mo4403getDefaultInstanceForType() {
                return EndChatRequest.m1477a();
            }

            /* renamed from: d */
            public Builder m1519d(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (this.f1187a.f1185l.isEmpty()) {
                    this.f1187a.f1185l = new ArrayList();
                }
                this.f1187a.f1185l.add(str);
                return this;
            }

            /* renamed from: d */
            public boolean m1520d() {
                return this.f1187a.m1503n();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public EndChatRequest build() {
                if (this.f1187a == null || m1520d()) {
                    return m1522f();
                }
                throw newUninitializedMessageException(this.f1187a);
            }

            /* renamed from: f */
            public EndChatRequest m1522f() {
                if (this.f1187a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.f1187a.f1185l != Collections.EMPTY_LIST) {
                    this.f1187a.f1185l = Collections.unmodifiableList(this.f1187a.f1185l);
                }
                EndChatRequest endChatRequest = this.f1187a;
                this.f1187a = null;
                return endChatRequest;
            }

            /* renamed from: g */
            public long m1523g() {
                return this.f1187a.m1493d();
            }

            /* renamed from: h */
            public ChatType m1524h() {
                return this.f1187a.m1495f();
            }

            /* renamed from: i */
            public String m1525i() {
                return this.f1187a.m1497h();
            }

            /* renamed from: j */
            public String m1526j() {
                return this.f1187a.m1501l();
            }

            /* renamed from: k */
            public List m1527k() {
                return Collections.unmodifiableList(this.f1187a.f1185l);
            }
        }

        static {
            SSMGPB.m810a();
            f1174a.m1490q();
        }

        private EndChatRequest() {
            this.f1176c = 0L;
            this.f1180g = "";
            this.f1182i = "";
            this.f1184k = "";
            this.f1185l = Collections.emptyList();
            this.f1186m = -1;
            m1490q();
        }

        private EndChatRequest(boolean z) {
            this.f1176c = 0L;
            this.f1180g = "";
            this.f1182i = "";
            this.f1184k = "";
            this.f1185l = Collections.emptyList();
            this.f1186m = -1;
        }

        /* renamed from: a */
        public static EndChatRequest m1477a() {
            return f1174a;
        }

        /* renamed from: a */
        public static EndChatRequest m1478a(byte[] bArr) {
            return ((Builder) m1489o().m4401mergeFrom(bArr)).m1508n();
        }

        /* renamed from: o */
        public static Builder m1489o() {
            return Builder.m1507m();
        }

        /* renamed from: q */
        private void m1490q() {
            this.f1178e = ChatType.SINGLE;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public EndChatRequest getDefaultInstanceForType() {
            return f1174a;
        }

        /* renamed from: c */
        public boolean m1492c() {
            return this.f1175b;
        }

        /* renamed from: d */
        public long m1493d() {
            return this.f1176c;
        }

        /* renamed from: e */
        public boolean m1494e() {
            return this.f1177d;
        }

        /* renamed from: f */
        public ChatType m1495f() {
            return this.f1178e;
        }

        /* renamed from: g */
        public boolean m1496g() {
            return this.f1179f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM307b = 0;
            int i = this.f1186m;
            if (i != -1) {
                return i;
            }
            int iM301b = m1492c() ? CodedOutputStream.m301b(1, m1493d()) + 0 : 0;
            if (m1494e()) {
                iM301b += CodedOutputStream.m311d(2, m1495f().m1240a());
            }
            if (m1496g()) {
                iM301b += CodedOutputStream.m303b(3, m1497h());
            }
            if (m1498i()) {
                iM301b += CodedOutputStream.m303b(4, m1499j());
            }
            int iM303b = m1500k() ? iM301b + CodedOutputStream.m303b(5, m1501l()) : iM301b;
            Iterator it = m1502m().iterator();
            while (it.hasNext()) {
                iM307b = CodedOutputStream.m307b((String) it.next()) + iM307b;
            }
            int size = iM303b + iM307b + (m1502m().size() * 1);
            this.f1186m = size;
            return size;
        }

        /* renamed from: h */
        public String m1497h() {
            return this.f1180g;
        }

        /* renamed from: i */
        public boolean m1498i() {
            return this.f1181h;
        }

        /* renamed from: j */
        public String m1499j() {
            return this.f1182i;
        }

        /* renamed from: k */
        public boolean m1500k() {
            return this.f1183j;
        }

        /* renamed from: l */
        public String m1501l() {
            return this.f1184k;
        }

        /* renamed from: m */
        public List m1502m() {
            return this.f1185l;
        }

        /* renamed from: n */
        public final boolean m1503n() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1489o();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1492c()) {
                codedOutputStream.m320a(1, m1493d());
            }
            if (m1494e()) {
                codedOutputStream.m330b(2, m1495f().m1240a());
            }
            if (m1496g()) {
                codedOutputStream.m322a(3, m1497h());
            }
            if (m1498i()) {
                codedOutputStream.m322a(4, m1499j());
            }
            if (m1500k()) {
                codedOutputStream.m322a(5, m1501l());
            }
            Iterator it = m1502m().iterator();
            while (it.hasNext()) {
                codedOutputStream.m322a(6, (String) it.next());
            }
        }
    }

    public final class InboxMessage extends GeneratedMessageLite {

        /* renamed from: a */
        private static final InboxMessage f1188a = new InboxMessage(true);

        /* renamed from: b */
        private boolean f1189b;

        /* renamed from: c */
        private String f1190c;

        /* renamed from: d */
        private List f1191d;

        /* renamed from: e */
        private boolean f1192e;

        /* renamed from: f */
        private long f1193f;

        /* renamed from: g */
        private boolean f1194g;

        /* renamed from: h */
        private String f1195h;

        /* renamed from: i */
        private boolean f1196i;

        /* renamed from: j */
        private long f1197j;

        /* renamed from: k */
        private boolean f1198k;

        /* renamed from: l */
        private MsgType f1199l;

        /* renamed from: m */
        private boolean f1200m;

        /* renamed from: n */
        private ChatType f1201n;

        /* renamed from: o */
        private int f1202o;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private InboxMessage f1203a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: h */
            public static Builder m1564h() {
                Builder builder = new Builder();
                builder.f1203a = new InboxMessage();
                return builder;
            }

            /* renamed from: a */
            public Builder m1565a(long j) {
                this.f1203a.f1192e = true;
                this.f1203a.f1193f = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                            m1570a(codedInputStream.m287f());
                            break;
                        case 18:
                            m1574b(codedInputStream.m287f());
                            break;
                        case 24:
                            m1565a(codedInputStream.m282c());
                            break;
                        case 34:
                            m1575c(codedInputStream.m287f());
                            break;
                        case 40:
                            m1573b(codedInputStream.m282c());
                            break;
                        case 48:
                            MsgType msgTypeM1792a = MsgType.m1792a(codedInputStream.m289g());
                            if (msgTypeM1792a == null) {
                                break;
                            } else {
                                m1569a(msgTypeM1792a);
                                break;
                            }
                        case 56:
                            ChatType chatTypeM1239a = ChatType.m1239a(codedInputStream.m289g());
                            if (chatTypeM1239a == null) {
                                break;
                            } else {
                                m1567a(chatTypeM1239a);
                                break;
                            }
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            /* renamed from: a */
            public Builder m1567a(ChatType chatType) {
                if (chatType == null) {
                    throw new NullPointerException();
                }
                this.f1203a.f1200m = true;
                this.f1203a.f1201n = chatType;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(InboxMessage inboxMessage) {
                if (inboxMessage == InboxMessage.m1530a()) {
                    return this;
                }
                if (inboxMessage.m1547c()) {
                    m1570a(inboxMessage.m1548d());
                }
                if (!inboxMessage.f1191d.isEmpty()) {
                    if (this.f1203a.f1191d.isEmpty()) {
                        this.f1203a.f1191d = new ArrayList();
                    }
                    this.f1203a.f1191d.addAll(inboxMessage.f1191d);
                }
                if (inboxMessage.m1551g()) {
                    m1565a(inboxMessage.m1552h());
                }
                if (inboxMessage.m1553i()) {
                    m1575c(inboxMessage.m1554j());
                }
                if (inboxMessage.m1555k()) {
                    m1573b(inboxMessage.m1556l());
                }
                if (inboxMessage.m1557m()) {
                    m1569a(inboxMessage.m1558n());
                }
                if (inboxMessage.m1559o()) {
                    m1567a(inboxMessage.m1560p());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1569a(MsgType msgType) {
                if (msgType == null) {
                    throw new NullPointerException();
                }
                this.f1203a.f1198k = true;
                this.f1203a.f1199l = msgType;
                return this;
            }

            /* renamed from: a */
            public Builder m1570a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1203a.f1189b = true;
                this.f1203a.f1190c = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public InboxMessage internalGetResult() {
                return this.f1203a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1564h().mergeFrom(this.f1203a);
            }

            /* renamed from: b */
            public Builder m1573b(long j) {
                this.f1203a.f1196i = true;
                this.f1203a.f1197j = j;
                return this;
            }

            /* renamed from: b */
            public Builder m1574b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (this.f1203a.f1191d.isEmpty()) {
                    this.f1203a.f1191d = new ArrayList();
                }
                this.f1203a.f1191d.add(str);
                return this;
            }

            /* renamed from: c */
            public Builder m1575c(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1203a.f1194g = true;
                this.f1203a.f1195h = str;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InboxMessage mo4403getDefaultInstanceForType() {
                return InboxMessage.m1530a();
            }

            /* renamed from: d */
            public boolean m1577d() {
                return this.f1203a.m1561q();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InboxMessage build() {
                if (this.f1203a == null || m1577d()) {
                    return m1579f();
                }
                throw newUninitializedMessageException(this.f1203a);
            }

            /* renamed from: f */
            public InboxMessage m1579f() {
                if (this.f1203a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.f1203a.f1191d != Collections.EMPTY_LIST) {
                    this.f1203a.f1191d = Collections.unmodifiableList(this.f1203a.f1191d);
                }
                InboxMessage inboxMessage = this.f1203a;
                this.f1203a = null;
                return inboxMessage;
            }
        }

        static {
            SSMGPB.m810a();
            f1188a.m1544t();
        }

        private InboxMessage() {
            this.f1190c = "";
            this.f1191d = Collections.emptyList();
            this.f1193f = 0L;
            this.f1195h = "";
            this.f1197j = 0L;
            this.f1202o = -1;
            m1544t();
        }

        private InboxMessage(boolean z) {
            this.f1190c = "";
            this.f1191d = Collections.emptyList();
            this.f1193f = 0L;
            this.f1195h = "";
            this.f1197j = 0L;
            this.f1202o = -1;
        }

        /* renamed from: a */
        public static InboxMessage m1530a() {
            return f1188a;
        }

        /* renamed from: r */
        public static Builder m1543r() {
            return Builder.m1564h();
        }

        /* renamed from: t */
        private void m1544t() {
            this.f1199l = MsgType.TEXT;
            this.f1201n = ChatType.SINGLE;
        }

        /* renamed from: a */
        public String m1545a(int i) {
            return (String) this.f1191d.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InboxMessage getDefaultInstanceForType() {
            return f1188a;
        }

        /* renamed from: c */
        public boolean m1547c() {
            return this.f1189b;
        }

        /* renamed from: d */
        public String m1548d() {
            return this.f1190c;
        }

        /* renamed from: e */
        public List m1549e() {
            return this.f1191d;
        }

        /* renamed from: f */
        public int m1550f() {
            return this.f1191d.size();
        }

        /* renamed from: g */
        public boolean m1551g() {
            return this.f1192e;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM307b = 0;
            int size = this.f1202o;
            if (size == -1) {
                int iM303b = m1547c() ? CodedOutputStream.m303b(1, m1548d()) + 0 : 0;
                Iterator it = m1549e().iterator();
                while (it.hasNext()) {
                    iM307b = CodedOutputStream.m307b((String) it.next()) + iM307b;
                }
                size = iM303b + iM307b + (m1549e().size() * 1);
                if (m1551g()) {
                    size += CodedOutputStream.m301b(3, m1552h());
                }
                if (m1553i()) {
                    size += CodedOutputStream.m303b(4, m1554j());
                }
                if (m1555k()) {
                    size += CodedOutputStream.m301b(5, m1556l());
                }
                if (m1557m()) {
                    size += CodedOutputStream.m311d(6, m1558n().m1793a());
                }
                if (m1559o()) {
                    size += CodedOutputStream.m311d(7, m1560p().m1240a());
                }
                this.f1202o = size;
            }
            return size;
        }

        /* renamed from: h */
        public long m1552h() {
            return this.f1193f;
        }

        /* renamed from: i */
        public boolean m1553i() {
            return this.f1194g;
        }

        /* renamed from: j */
        public String m1554j() {
            return this.f1195h;
        }

        /* renamed from: k */
        public boolean m1555k() {
            return this.f1196i;
        }

        /* renamed from: l */
        public long m1556l() {
            return this.f1197j;
        }

        /* renamed from: m */
        public boolean m1557m() {
            return this.f1198k;
        }

        /* renamed from: n */
        public MsgType m1558n() {
            return this.f1199l;
        }

        /* renamed from: o */
        public boolean m1559o() {
            return this.f1200m;
        }

        /* renamed from: p */
        public ChatType m1560p() {
            return this.f1201n;
        }

        /* renamed from: q */
        public final boolean m1561q() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1543r();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1547c()) {
                codedOutputStream.m322a(1, m1548d());
            }
            Iterator it = m1549e().iterator();
            while (it.hasNext()) {
                codedOutputStream.m322a(2, (String) it.next());
            }
            if (m1551g()) {
                codedOutputStream.m320a(3, m1552h());
            }
            if (m1553i()) {
                codedOutputStream.m322a(4, m1554j());
            }
            if (m1555k()) {
                codedOutputStream.m320a(5, m1556l());
            }
            if (m1557m()) {
                codedOutputStream.m330b(6, m1558n().m1793a());
            }
            if (m1559o()) {
                codedOutputStream.m330b(7, m1560p().m1240a());
            }
        }
    }

    public final class InitChatReply extends GeneratedMessageLite {

        /* renamed from: a */
        private static final InitChatReply f1204a = new InitChatReply(true);

        /* renamed from: b */
        private boolean f1205b;

        /* renamed from: c */
        private long f1206c;

        /* renamed from: d */
        private boolean f1207d;

        /* renamed from: e */
        private String f1208e;

        /* renamed from: f */
        private boolean f1209f;

        /* renamed from: g */
        private long f1210g;

        /* renamed from: h */
        private boolean f1211h;

        /* renamed from: i */
        private ServerInfo f1212i;

        /* renamed from: j */
        private boolean f1213j;

        /* renamed from: k */
        private Result f1214k;

        /* renamed from: l */
        private int f1215l;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private InitChatReply f1216a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: l */
            public static Builder m1611l() {
                Builder builder = new Builder();
                builder.f1216a = new InitChatReply();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: m */
            public InitChatReply m1612m() throws InvalidProtocolBufferException {
                if (m1625d()) {
                    return m1627f();
                }
                throw newUninitializedMessageException(this.f1216a).m350a();
            }

            /* renamed from: a */
            public Builder m1613a(long j) {
                this.f1216a.f1205b = true;
                this.f1216a.f1206c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m1613a(codedInputStream.m282c());
                            break;
                        case 18:
                            m1618a(codedInputStream.m287f());
                            break;
                        case 24:
                            m1621b(codedInputStream.m282c());
                            break;
                        case 34:
                            ServerInfo.Builder builderM1921h = ServerInfo.m1921h();
                            if (m1628g()) {
                                builderM1921h.mergeFrom(m1629h());
                            }
                            codedInputStream.m278a(builderM1921h, extensionRegistryLite);
                            m1617a(builderM1921h.m1941f());
                            break;
                        case 42:
                            Result.Builder builderM1894h = Result.m1894h();
                            if (m1630i()) {
                                builderM1894h.mergeFrom(m1631j());
                            }
                            codedInputStream.m278a(builderM1894h, extensionRegistryLite);
                            m1616a(builderM1894h.m1914f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(InitChatReply initChatReply) {
                if (initChatReply == InitChatReply.m1581a()) {
                    return this;
                }
                if (initChatReply.m1597c()) {
                    m1613a(initChatReply.m1598d());
                }
                if (initChatReply.m1599e()) {
                    m1618a(initChatReply.m1600f());
                }
                if (initChatReply.m1601g()) {
                    m1621b(initChatReply.m1602h());
                }
                if (initChatReply.m1603i()) {
                    m1623b(initChatReply.m1604j());
                }
                if (initChatReply.m1605k()) {
                    m1622b(initChatReply.m1606l());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1616a(Result result) {
                if (result == null) {
                    throw new NullPointerException();
                }
                this.f1216a.f1213j = true;
                this.f1216a.f1214k = result;
                return this;
            }

            /* renamed from: a */
            public Builder m1617a(ServerInfo serverInfo) {
                if (serverInfo == null) {
                    throw new NullPointerException();
                }
                this.f1216a.f1211h = true;
                this.f1216a.f1212i = serverInfo;
                return this;
            }

            /* renamed from: a */
            public Builder m1618a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1216a.f1207d = true;
                this.f1216a.f1208e = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public InitChatReply internalGetResult() {
                return this.f1216a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1611l().mergeFrom(this.f1216a);
            }

            /* renamed from: b */
            public Builder m1621b(long j) {
                this.f1216a.f1209f = true;
                this.f1216a.f1210g = j;
                return this;
            }

            /* renamed from: b */
            public Builder m1622b(Result result) {
                if (!this.f1216a.m1605k() || this.f1216a.f1214k == Result.m1890a()) {
                    this.f1216a.f1214k = result;
                } else {
                    this.f1216a.f1214k = Result.m1889a(this.f1216a.f1214k).mergeFrom(result).m1914f();
                }
                this.f1216a.f1213j = true;
                return this;
            }

            /* renamed from: b */
            public Builder m1623b(ServerInfo serverInfo) {
                if (!this.f1216a.m1603i() || this.f1216a.f1212i == ServerInfo.m1917a()) {
                    this.f1216a.f1212i = serverInfo;
                } else {
                    this.f1216a.f1212i = ServerInfo.m1916a(this.f1216a.f1212i).mergeFrom(serverInfo).m1941f();
                }
                this.f1216a.f1211h = true;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InitChatReply mo4403getDefaultInstanceForType() {
                return InitChatReply.m1581a();
            }

            /* renamed from: d */
            public boolean m1625d() {
                return this.f1216a.m1607m();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InitChatReply build() {
                if (this.f1216a == null || m1625d()) {
                    return m1627f();
                }
                throw newUninitializedMessageException(this.f1216a);
            }

            /* renamed from: f */
            public InitChatReply m1627f() {
                if (this.f1216a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                InitChatReply initChatReply = this.f1216a;
                this.f1216a = null;
                return initChatReply;
            }

            /* renamed from: g */
            public boolean m1628g() {
                return this.f1216a.m1603i();
            }

            /* renamed from: h */
            public ServerInfo m1629h() {
                return this.f1216a.m1604j();
            }

            /* renamed from: i */
            public boolean m1630i() {
                return this.f1216a.m1605k();
            }

            /* renamed from: j */
            public Result m1631j() {
                return this.f1216a.m1606l();
            }
        }

        static {
            SSMGPB.m810a();
            f1204a.m1595p();
        }

        private InitChatReply() {
            this.f1206c = 0L;
            this.f1208e = "";
            this.f1210g = 0L;
            this.f1215l = -1;
            m1595p();
        }

        private InitChatReply(boolean z) {
            this.f1206c = 0L;
            this.f1208e = "";
            this.f1210g = 0L;
            this.f1215l = -1;
        }

        /* renamed from: a */
        public static InitChatReply m1581a() {
            return f1204a;
        }

        /* renamed from: a */
        public static InitChatReply m1582a(byte[] bArr) {
            return ((Builder) m1594n().m4401mergeFrom(bArr)).m1612m();
        }

        /* renamed from: n */
        public static Builder m1594n() {
            return Builder.m1611l();
        }

        /* renamed from: p */
        private void m1595p() {
            this.f1212i = ServerInfo.m1917a();
            this.f1214k = Result.m1890a();
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InitChatReply getDefaultInstanceForType() {
            return f1204a;
        }

        /* renamed from: c */
        public boolean m1597c() {
            return this.f1205b;
        }

        /* renamed from: d */
        public long m1598d() {
            return this.f1206c;
        }

        /* renamed from: e */
        public boolean m1599e() {
            return this.f1207d;
        }

        /* renamed from: f */
        public String m1600f() {
            return this.f1208e;
        }

        /* renamed from: g */
        public boolean m1601g() {
            return this.f1209f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM301b = this.f1215l;
            if (iM301b == -1) {
                iM301b = m1597c() ? 0 + CodedOutputStream.m301b(1, m1598d()) : 0;
                if (m1599e()) {
                    iM301b += CodedOutputStream.m303b(2, m1600f());
                }
                if (m1601g()) {
                    iM301b += CodedOutputStream.m301b(3, m1602h());
                }
                if (m1603i()) {
                    iM301b += CodedOutputStream.m302b(4, m1604j());
                }
                if (m1605k()) {
                    iM301b += CodedOutputStream.m302b(5, m1606l());
                }
                this.f1215l = iM301b;
            }
            return iM301b;
        }

        /* renamed from: h */
        public long m1602h() {
            return this.f1210g;
        }

        /* renamed from: i */
        public boolean m1603i() {
            return this.f1211h;
        }

        /* renamed from: j */
        public ServerInfo m1604j() {
            return this.f1212i;
        }

        /* renamed from: k */
        public boolean m1605k() {
            return this.f1213j;
        }

        /* renamed from: l */
        public Result m1606l() {
            return this.f1214k;
        }

        /* renamed from: m */
        public final boolean m1607m() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1594n();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1597c()) {
                codedOutputStream.m320a(1, m1598d());
            }
            if (m1599e()) {
                codedOutputStream.m322a(2, m1600f());
            }
            if (m1601g()) {
                codedOutputStream.m320a(3, m1602h());
            }
            if (m1603i()) {
                codedOutputStream.m321a(4, m1604j());
            }
            if (m1605k()) {
                codedOutputStream.m321a(5, m1606l());
            }
        }
    }

    public final class InitChatRequest extends GeneratedMessageLite {

        /* renamed from: a */
        private static final InitChatRequest f1217a = new InitChatRequest(true);

        /* renamed from: b */
        private boolean f1218b;

        /* renamed from: c */
        private long f1219c;

        /* renamed from: d */
        private boolean f1220d;

        /* renamed from: e */
        private MsgType f1221e;

        /* renamed from: f */
        private boolean f1222f;

        /* renamed from: g */
        private ChatType f1223g;

        /* renamed from: h */
        private boolean f1224h;

        /* renamed from: i */
        private String f1225i;

        /* renamed from: j */
        private boolean f1226j;

        /* renamed from: k */
        private String f1227k;

        /* renamed from: l */
        private boolean f1228l;

        /* renamed from: m */
        private long f1229m;

        /* renamed from: n */
        private boolean f1230n;

        /* renamed from: o */
        private String f1231o;

        /* renamed from: p */
        private List f1232p;

        /* renamed from: q */
        private boolean f1233q;

        /* renamed from: r */
        private String f1234r;

        /* renamed from: s */
        private int f1235s;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private InitChatRequest f1236a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: p */
            public static Builder m1677p() {
                Builder builder = new Builder();
                builder.f1236a = new InitChatRequest();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: q */
            public InitChatRequest m1678q() throws InvalidProtocolBufferException {
                if (m1692d()) {
                    return m1695f();
                }
                throw newUninitializedMessageException(this.f1236a).m350a();
            }

            /* renamed from: a */
            public Builder m1679a(long j) {
                this.f1236a.f1218b = true;
                this.f1236a.f1219c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m1679a(codedInputStream.m282c());
                            break;
                        case 16:
                            MsgType msgTypeM1792a = MsgType.m1792a(codedInputStream.m289g());
                            if (msgTypeM1792a == null) {
                                break;
                            } else {
                                m1683a(msgTypeM1792a);
                                break;
                            }
                        case 24:
                            ChatType chatTypeM1239a = ChatType.m1239a(codedInputStream.m289g());
                            if (chatTypeM1239a == null) {
                                break;
                            } else {
                                m1681a(chatTypeM1239a);
                                break;
                            }
                        case 34:
                            m1684a(codedInputStream.m287f());
                            break;
                        case 42:
                            m1688b(codedInputStream.m287f());
                            break;
                        case 48:
                            m1687b(codedInputStream.m282c());
                            break;
                        case 58:
                            m1689c(codedInputStream.m287f());
                            break;
                        case 66:
                            m1691d(codedInputStream.m287f());
                            break;
                        case 74:
                            m1693e(codedInputStream.m287f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            /* renamed from: a */
            public Builder m1681a(ChatType chatType) {
                if (chatType == null) {
                    throw new NullPointerException();
                }
                this.f1236a.f1222f = true;
                this.f1236a.f1223g = chatType;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(InitChatRequest initChatRequest) {
                if (initChatRequest == InitChatRequest.m1634a()) {
                    return this;
                }
                if (initChatRequest.m1655c()) {
                    m1679a(initChatRequest.m1656d());
                }
                if (initChatRequest.m1657e()) {
                    m1683a(initChatRequest.m1658f());
                }
                if (initChatRequest.m1659g()) {
                    m1681a(initChatRequest.m1660h());
                }
                if (initChatRequest.m1661i()) {
                    m1684a(initChatRequest.m1662j());
                }
                if (initChatRequest.m1663k()) {
                    m1688b(initChatRequest.m1664l());
                }
                if (initChatRequest.m1665m()) {
                    m1687b(initChatRequest.m1666n());
                }
                if (initChatRequest.m1667o()) {
                    m1689c(initChatRequest.m1668p());
                }
                if (!initChatRequest.f1232p.isEmpty()) {
                    if (this.f1236a.f1232p.isEmpty()) {
                        this.f1236a.f1232p = new ArrayList();
                    }
                    this.f1236a.f1232p.addAll(initChatRequest.f1232p);
                }
                if (initChatRequest.m1671s()) {
                    m1693e(initChatRequest.m1672t());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1683a(MsgType msgType) {
                if (msgType == null) {
                    throw new NullPointerException();
                }
                this.f1236a.f1220d = true;
                this.f1236a.f1221e = msgType;
                return this;
            }

            /* renamed from: a */
            public Builder m1684a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1236a.f1224h = true;
                this.f1236a.f1225i = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public InitChatRequest internalGetResult() {
                return this.f1236a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1677p().mergeFrom(this.f1236a);
            }

            /* renamed from: b */
            public Builder m1687b(long j) {
                this.f1236a.f1228l = true;
                this.f1236a.f1229m = j;
                return this;
            }

            /* renamed from: b */
            public Builder m1688b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1236a.f1226j = true;
                this.f1236a.f1227k = str;
                return this;
            }

            /* renamed from: c */
            public Builder m1689c(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1236a.f1230n = true;
                this.f1236a.f1231o = str;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InitChatRequest mo4403getDefaultInstanceForType() {
                return InitChatRequest.m1634a();
            }

            /* renamed from: d */
            public Builder m1691d(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (this.f1236a.f1232p.isEmpty()) {
                    this.f1236a.f1232p = new ArrayList();
                }
                this.f1236a.f1232p.add(str);
                return this;
            }

            /* renamed from: d */
            public boolean m1692d() {
                return this.f1236a.m1673u();
            }

            /* renamed from: e */
            public Builder m1693e(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1236a.f1233q = true;
                this.f1236a.f1234r = str;
                return this;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InitChatRequest build() {
                if (this.f1236a == null || m1692d()) {
                    return m1695f();
                }
                throw newUninitializedMessageException(this.f1236a);
            }

            /* renamed from: f */
            public InitChatRequest m1695f() {
                if (this.f1236a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.f1236a.f1232p != Collections.EMPTY_LIST) {
                    this.f1236a.f1232p = Collections.unmodifiableList(this.f1236a.f1232p);
                }
                InitChatRequest initChatRequest = this.f1236a;
                this.f1236a = null;
                return initChatRequest;
            }

            /* renamed from: g */
            public long m1696g() {
                return this.f1236a.m1656d();
            }

            /* renamed from: h */
            public MsgType m1697h() {
                return this.f1236a.m1658f();
            }

            /* renamed from: i */
            public ChatType m1698i() {
                return this.f1236a.m1660h();
            }

            /* renamed from: j */
            public String m1699j() {
                return this.f1236a.m1664l();
            }

            /* renamed from: k */
            public String m1700k() {
                return this.f1236a.m1668p();
            }

            /* renamed from: l */
            public List m1701l() {
                return Collections.unmodifiableList(this.f1236a.f1232p);
            }

            /* renamed from: m */
            public int m1702m() {
                return this.f1236a.m1670r();
            }

            /* renamed from: n */
            public String m1703n() {
                return this.f1236a.m1672t();
            }
        }

        static {
            SSMGPB.m810a();
            f1217a.m1653x();
        }

        private InitChatRequest() {
            this.f1219c = 0L;
            this.f1225i = "";
            this.f1227k = "";
            this.f1229m = 0L;
            this.f1231o = "";
            this.f1232p = Collections.emptyList();
            this.f1234r = "";
            this.f1235s = -1;
            m1653x();
        }

        private InitChatRequest(boolean z) {
            this.f1219c = 0L;
            this.f1225i = "";
            this.f1227k = "";
            this.f1229m = 0L;
            this.f1231o = "";
            this.f1232p = Collections.emptyList();
            this.f1234r = "";
            this.f1235s = -1;
        }

        /* renamed from: a */
        public static InitChatRequest m1634a() {
            return f1217a;
        }

        /* renamed from: a */
        public static InitChatRequest m1635a(byte[] bArr) {
            return ((Builder) m1652v().m4401mergeFrom(bArr)).m1678q();
        }

        /* renamed from: v */
        public static Builder m1652v() {
            return Builder.m1677p();
        }

        /* renamed from: x */
        private void m1653x() {
            this.f1221e = MsgType.TEXT;
            this.f1223g = ChatType.SINGLE;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InitChatRequest getDefaultInstanceForType() {
            return f1217a;
        }

        /* renamed from: c */
        public boolean m1655c() {
            return this.f1218b;
        }

        /* renamed from: d */
        public long m1656d() {
            return this.f1219c;
        }

        /* renamed from: e */
        public boolean m1657e() {
            return this.f1220d;
        }

        /* renamed from: f */
        public MsgType m1658f() {
            return this.f1221e;
        }

        /* renamed from: g */
        public boolean m1659g() {
            return this.f1222f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.f1235s;
            if (size == -1) {
                int iM301b = m1655c() ? CodedOutputStream.m301b(1, m1656d()) + 0 : 0;
                if (m1657e()) {
                    iM301b += CodedOutputStream.m311d(2, m1658f().m1793a());
                }
                if (m1659g()) {
                    iM301b += CodedOutputStream.m311d(3, m1660h().m1240a());
                }
                if (m1661i()) {
                    iM301b += CodedOutputStream.m303b(4, m1662j());
                }
                if (m1663k()) {
                    iM301b += CodedOutputStream.m303b(5, m1664l());
                }
                if (m1665m()) {
                    iM301b += CodedOutputStream.m301b(6, m1666n());
                }
                int iM303b = m1667o() ? iM301b + CodedOutputStream.m303b(7, m1668p()) : iM301b;
                Iterator it = m1669q().iterator();
                int iM307b = 0;
                while (it.hasNext()) {
                    iM307b = CodedOutputStream.m307b((String) it.next()) + iM307b;
                }
                size = iM303b + iM307b + (m1669q().size() * 1);
                if (m1671s()) {
                    size += CodedOutputStream.m303b(9, m1672t());
                }
                this.f1235s = size;
            }
            return size;
        }

        /* renamed from: h */
        public ChatType m1660h() {
            return this.f1223g;
        }

        /* renamed from: i */
        public boolean m1661i() {
            return this.f1224h;
        }

        /* renamed from: j */
        public String m1662j() {
            return this.f1225i;
        }

        /* renamed from: k */
        public boolean m1663k() {
            return this.f1226j;
        }

        /* renamed from: l */
        public String m1664l() {
            return this.f1227k;
        }

        /* renamed from: m */
        public boolean m1665m() {
            return this.f1228l;
        }

        /* renamed from: n */
        public long m1666n() {
            return this.f1229m;
        }

        /* renamed from: o */
        public boolean m1667o() {
            return this.f1230n;
        }

        /* renamed from: p */
        public String m1668p() {
            return this.f1231o;
        }

        /* renamed from: q */
        public List m1669q() {
            return this.f1232p;
        }

        /* renamed from: r */
        public int m1670r() {
            return this.f1232p.size();
        }

        /* renamed from: s */
        public boolean m1671s() {
            return this.f1233q;
        }

        /* renamed from: t */
        public String m1672t() {
            return this.f1234r;
        }

        /* renamed from: u */
        public final boolean m1673u() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1652v();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1655c()) {
                codedOutputStream.m320a(1, m1656d());
            }
            if (m1657e()) {
                codedOutputStream.m330b(2, m1658f().m1793a());
            }
            if (m1659g()) {
                codedOutputStream.m330b(3, m1660h().m1240a());
            }
            if (m1661i()) {
                codedOutputStream.m322a(4, m1662j());
            }
            if (m1663k()) {
                codedOutputStream.m322a(5, m1664l());
            }
            if (m1665m()) {
                codedOutputStream.m320a(6, m1666n());
            }
            if (m1667o()) {
                codedOutputStream.m322a(7, m1668p());
            }
            Iterator it = m1669q().iterator();
            while (it.hasNext()) {
                codedOutputStream.m322a(8, (String) it.next());
            }
            if (m1671s()) {
                codedOutputStream.m322a(9, m1672t());
            }
        }
    }

    public final class InviteChatReply extends GeneratedMessageLite {

        /* renamed from: a */
        private static final InviteChatReply f1237a = new InviteChatReply(true);

        /* renamed from: b */
        private boolean f1238b;

        /* renamed from: c */
        private long f1239c;

        /* renamed from: d */
        private boolean f1240d;

        /* renamed from: e */
        private Result f1241e;

        /* renamed from: f */
        private int f1242f;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private InviteChatReply f1243a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: j */
            public static Builder m1722j() {
                Builder builder = new Builder();
                builder.f1243a = new InviteChatReply();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: k */
            public InviteChatReply m1723k() {
                if (m1732d()) {
                    return m1734f();
                }
                throw newUninitializedMessageException(this.f1243a).m350a();
            }

            /* renamed from: a */
            public Builder m1724a(long j) {
                this.f1243a.f1238b = true;
                this.f1243a.f1239c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m1724a(codedInputStream.m282c());
                            break;
                        case 18:
                            Result.Builder builderM1894h = Result.m1894h();
                            if (m1735g()) {
                                builderM1894h.mergeFrom(m1736h());
                            }
                            codedInputStream.m278a(builderM1894h, extensionRegistryLite);
                            m1727a(builderM1894h.m1914f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(InviteChatReply inviteChatReply) {
                if (inviteChatReply == InviteChatReply.m1705a()) {
                    return this;
                }
                if (inviteChatReply.m1714c()) {
                    m1724a(inviteChatReply.m1715d());
                }
                if (inviteChatReply.m1716e()) {
                    m1730b(inviteChatReply.m1717f());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1727a(Result result) {
                if (result == null) {
                    throw new NullPointerException();
                }
                this.f1243a.f1240d = true;
                this.f1243a.f1241e = result;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public InviteChatReply internalGetResult() {
                return this.f1243a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1722j().mergeFrom(this.f1243a);
            }

            /* renamed from: b */
            public Builder m1730b(Result result) {
                if (!this.f1243a.m1716e() || this.f1243a.f1241e == Result.m1890a()) {
                    this.f1243a.f1241e = result;
                } else {
                    this.f1243a.f1241e = Result.m1889a(this.f1243a.f1241e).mergeFrom(result).m1914f();
                }
                this.f1243a.f1240d = true;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InviteChatReply mo4403getDefaultInstanceForType() {
                return InviteChatReply.m1705a();
            }

            /* renamed from: d */
            public boolean m1732d() {
                return this.f1243a.m1718g();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InviteChatReply build() {
                if (this.f1243a == null || m1732d()) {
                    return m1734f();
                }
                throw newUninitializedMessageException(this.f1243a);
            }

            /* renamed from: f */
            public InviteChatReply m1734f() {
                if (this.f1243a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                InviteChatReply inviteChatReply = this.f1243a;
                this.f1243a = null;
                return inviteChatReply;
            }

            /* renamed from: g */
            public boolean m1735g() {
                return this.f1243a.m1716e();
            }

            /* renamed from: h */
            public Result m1736h() {
                return this.f1243a.m1717f();
            }
        }

        static {
            SSMGPB.m810a();
            f1237a.m1712j();
        }

        private InviteChatReply() {
            this.f1239c = 0L;
            this.f1242f = -1;
            m1712j();
        }

        private InviteChatReply(boolean z) {
            this.f1239c = 0L;
            this.f1242f = -1;
        }

        /* renamed from: a */
        public static InviteChatReply m1705a() {
            return f1237a;
        }

        /* renamed from: a */
        public static InviteChatReply m1706a(byte[] bArr) {
            return ((Builder) m1711h().m4401mergeFrom(bArr)).m1723k();
        }

        /* renamed from: h */
        public static Builder m1711h() {
            return Builder.m1722j();
        }

        /* renamed from: j */
        private void m1712j() {
            this.f1241e = Result.m1890a();
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InviteChatReply getDefaultInstanceForType() {
            return f1237a;
        }

        /* renamed from: c */
        public boolean m1714c() {
            return this.f1238b;
        }

        /* renamed from: d */
        public long m1715d() {
            return this.f1239c;
        }

        /* renamed from: e */
        public boolean m1716e() {
            return this.f1240d;
        }

        /* renamed from: f */
        public Result m1717f() {
            return this.f1241e;
        }

        /* renamed from: g */
        public final boolean m1718g() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM301b = this.f1242f;
            if (iM301b == -1) {
                iM301b = m1714c() ? 0 + CodedOutputStream.m301b(1, m1715d()) : 0;
                if (m1716e()) {
                    iM301b += CodedOutputStream.m302b(2, m1717f());
                }
                this.f1242f = iM301b;
            }
            return iM301b;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1711h();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1714c()) {
                codedOutputStream.m320a(1, m1715d());
            }
            if (m1716e()) {
                codedOutputStream.m321a(2, m1717f());
            }
        }
    }

    public final class InviteChatRequest extends GeneratedMessageLite {

        /* renamed from: a */
        private static final InviteChatRequest f1244a = new InviteChatRequest(true);

        /* renamed from: b */
        private boolean f1245b;

        /* renamed from: c */
        private long f1246c;

        /* renamed from: d */
        private boolean f1247d;

        /* renamed from: e */
        private MsgType f1248e;

        /* renamed from: f */
        private boolean f1249f;

        /* renamed from: g */
        private String f1250g;

        /* renamed from: h */
        private boolean f1251h;

        /* renamed from: i */
        private String f1252i;

        /* renamed from: j */
        private List f1253j;

        /* renamed from: k */
        private List f1254k;

        /* renamed from: l */
        private int f1255l;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private InviteChatRequest f1256a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: n */
            public static Builder m1770n() {
                Builder builder = new Builder();
                builder.f1256a = new InviteChatRequest();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: o */
            public InviteChatRequest m1771o() {
                if (m1783d()) {
                    return m1785f();
                }
                throw newUninitializedMessageException(this.f1256a).m350a();
            }

            /* renamed from: a */
            public Builder m1772a(long j) {
                this.f1256a.f1245b = true;
                this.f1256a.f1246c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m1772a(codedInputStream.m282c());
                            break;
                        case 16:
                            MsgType msgTypeM1792a = MsgType.m1792a(codedInputStream.m289g());
                            if (msgTypeM1792a == null) {
                                break;
                            } else {
                                m1775a(msgTypeM1792a);
                                break;
                            }
                        case 26:
                            m1776a(codedInputStream.m287f());
                            break;
                        case 34:
                            m1779b(codedInputStream.m287f());
                            break;
                        case 42:
                            m1780c(codedInputStream.m287f());
                            break;
                        case 50:
                            m1782d(codedInputStream.m287f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(InviteChatRequest inviteChatRequest) {
                if (inviteChatRequest == InviteChatRequest.m1738a()) {
                    return this;
                }
                if (inviteChatRequest.m1754c()) {
                    m1772a(inviteChatRequest.m1755d());
                }
                if (inviteChatRequest.m1756e()) {
                    m1775a(inviteChatRequest.m1757f());
                }
                if (inviteChatRequest.m1758g()) {
                    m1776a(inviteChatRequest.m1759h());
                }
                if (inviteChatRequest.m1760i()) {
                    m1779b(inviteChatRequest.m1761j());
                }
                if (!inviteChatRequest.f1253j.isEmpty()) {
                    if (this.f1256a.f1253j.isEmpty()) {
                        this.f1256a.f1253j = new ArrayList();
                    }
                    this.f1256a.f1253j.addAll(inviteChatRequest.f1253j);
                }
                if (!inviteChatRequest.f1254k.isEmpty()) {
                    if (this.f1256a.f1254k.isEmpty()) {
                        this.f1256a.f1254k = new ArrayList();
                    }
                    this.f1256a.f1254k.addAll(inviteChatRequest.f1254k);
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1775a(MsgType msgType) {
                if (msgType == null) {
                    throw new NullPointerException();
                }
                this.f1256a.f1247d = true;
                this.f1256a.f1248e = msgType;
                return this;
            }

            /* renamed from: a */
            public Builder m1776a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1256a.f1249f = true;
                this.f1256a.f1250g = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public InviteChatRequest internalGetResult() {
                return this.f1256a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1770n().mergeFrom(this.f1256a);
            }

            /* renamed from: b */
            public Builder m1779b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1256a.f1251h = true;
                this.f1256a.f1252i = str;
                return this;
            }

            /* renamed from: c */
            public Builder m1780c(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (this.f1256a.f1253j.isEmpty()) {
                    this.f1256a.f1253j = new ArrayList();
                }
                this.f1256a.f1253j.add(str);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public InviteChatRequest mo4403getDefaultInstanceForType() {
                return InviteChatRequest.m1738a();
            }

            /* renamed from: d */
            public Builder m1782d(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (this.f1256a.f1254k.isEmpty()) {
                    this.f1256a.f1254k = new ArrayList();
                }
                this.f1256a.f1254k.add(str);
                return this;
            }

            /* renamed from: d */
            public boolean m1783d() {
                return this.f1256a.m1766o();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InviteChatRequest build() {
                if (this.f1256a == null || m1783d()) {
                    return m1785f();
                }
                throw newUninitializedMessageException(this.f1256a);
            }

            /* renamed from: f */
            public InviteChatRequest m1785f() {
                if (this.f1256a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.f1256a.f1253j != Collections.EMPTY_LIST) {
                    this.f1256a.f1253j = Collections.unmodifiableList(this.f1256a.f1253j);
                }
                if (this.f1256a.f1254k != Collections.EMPTY_LIST) {
                    this.f1256a.f1254k = Collections.unmodifiableList(this.f1256a.f1254k);
                }
                InviteChatRequest inviteChatRequest = this.f1256a;
                this.f1256a = null;
                return inviteChatRequest;
            }

            /* renamed from: g */
            public long m1786g() {
                return this.f1256a.m1755d();
            }

            /* renamed from: h */
            public String m1787h() {
                return this.f1256a.m1761j();
            }

            /* renamed from: i */
            public List m1788i() {
                return Collections.unmodifiableList(this.f1256a.f1253j);
            }

            /* renamed from: j */
            public int m1789j() {
                return this.f1256a.m1763l();
            }

            /* renamed from: k */
            public List m1790k() {
                return Collections.unmodifiableList(this.f1256a.f1254k);
            }

            /* renamed from: l */
            public int m1791l() {
                return this.f1256a.m1765n();
            }
        }

        static {
            SSMGPB.m810a();
            f1244a.m1752r();
        }

        private InviteChatRequest() {
            this.f1246c = 0L;
            this.f1250g = "";
            this.f1252i = "";
            this.f1253j = Collections.emptyList();
            this.f1254k = Collections.emptyList();
            this.f1255l = -1;
            m1752r();
        }

        private InviteChatRequest(boolean z) {
            this.f1246c = 0L;
            this.f1250g = "";
            this.f1252i = "";
            this.f1253j = Collections.emptyList();
            this.f1254k = Collections.emptyList();
            this.f1255l = -1;
        }

        /* renamed from: a */
        public static InviteChatRequest m1738a() {
            return f1244a;
        }

        /* renamed from: a */
        public static InviteChatRequest m1739a(byte[] bArr) {
            return ((Builder) m1751p().m4401mergeFrom(bArr)).m1771o();
        }

        /* renamed from: p */
        public static Builder m1751p() {
            return Builder.m1770n();
        }

        /* renamed from: r */
        private void m1752r() {
            this.f1248e = MsgType.TEXT;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public InviteChatRequest getDefaultInstanceForType() {
            return f1244a;
        }

        /* renamed from: c */
        public boolean m1754c() {
            return this.f1245b;
        }

        /* renamed from: d */
        public long m1755d() {
            return this.f1246c;
        }

        /* renamed from: e */
        public boolean m1756e() {
            return this.f1247d;
        }

        /* renamed from: f */
        public MsgType m1757f() {
            return this.f1248e;
        }

        /* renamed from: g */
        public boolean m1758g() {
            return this.f1249f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.f1255l;
            if (i != -1) {
                return i;
            }
            int iM301b = m1754c() ? CodedOutputStream.m301b(1, m1755d()) + 0 : 0;
            if (m1756e()) {
                iM301b += CodedOutputStream.m311d(2, m1757f().m1793a());
            }
            if (m1758g()) {
                iM301b += CodedOutputStream.m303b(3, m1759h());
            }
            int iM303b = m1760i() ? iM301b + CodedOutputStream.m303b(4, m1761j()) : iM301b;
            Iterator it = m1762k().iterator();
            int iM307b = 0;
            while (it.hasNext()) {
                iM307b = CodedOutputStream.m307b((String) it.next()) + iM307b;
            }
            int size = (m1762k().size() * 1) + iM303b + iM307b;
            Iterator it2 = m1764m().iterator();
            int iM307b2 = 0;
            while (it2.hasNext()) {
                iM307b2 = CodedOutputStream.m307b((String) it2.next()) + iM307b2;
            }
            int size2 = size + iM307b2 + (m1764m().size() * 1);
            this.f1255l = size2;
            return size2;
        }

        /* renamed from: h */
        public String m1759h() {
            return this.f1250g;
        }

        /* renamed from: i */
        public boolean m1760i() {
            return this.f1251h;
        }

        /* renamed from: j */
        public String m1761j() {
            return this.f1252i;
        }

        /* renamed from: k */
        public List m1762k() {
            return this.f1253j;
        }

        /* renamed from: l */
        public int m1763l() {
            return this.f1253j.size();
        }

        /* renamed from: m */
        public List m1764m() {
            return this.f1254k;
        }

        /* renamed from: n */
        public int m1765n() {
            return this.f1254k.size();
        }

        /* renamed from: o */
        public final boolean m1766o() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1751p();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1754c()) {
                codedOutputStream.m320a(1, m1755d());
            }
            if (m1756e()) {
                codedOutputStream.m330b(2, m1757f().m1793a());
            }
            if (m1758g()) {
                codedOutputStream.m322a(3, m1759h());
            }
            if (m1760i()) {
                codedOutputStream.m322a(4, m1761j());
            }
            Iterator it = m1762k().iterator();
            while (it.hasNext()) {
                codedOutputStream.m322a(5, (String) it.next());
            }
            Iterator it2 = m1764m().iterator();
            while (it2.hasNext()) {
                codedOutputStream.m322a(6, (String) it2.next());
            }
        }
    }

    public enum MsgType implements Internal.EnumLite {
        TEXT(0, 0),
        MEDIA(1, 1),
        NOTI(2, 2),
        ANS(3, 3);


        /* renamed from: e */
        private static Internal.EnumLiteMap f1261e = new C0169e();

        /* renamed from: f */
        private final int f1263f;

        /* renamed from: g */
        private final int f1264g;

        MsgType(int i, int i2) {
            this.f1263f = i;
            this.f1264g = i2;
        }

        /* renamed from: a */
        public static MsgType m1792a(int i) {
            switch (i) {
                case 0:
                    return TEXT;
                case 1:
                    return MEDIA;
                case 2:
                    return NOTI;
                case 3:
                    return ANS;
                default:
                    return null;
            }
        }

        /* renamed from: a */
        public final int m1793a() {
            return this.f1264g;
        }
    }

    public final class Nickname extends GeneratedMessageLite {

        /* renamed from: a */
        private static final Nickname f1265a = new Nickname(true);

        /* renamed from: b */
        private boolean f1266b;

        /* renamed from: c */
        private String f1267c;

        /* renamed from: d */
        private boolean f1268d;

        /* renamed from: e */
        private String f1269e;

        /* renamed from: f */
        private int f1270f;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private Nickname f1271a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: h */
            public static Builder m1809h() {
                Builder builder = new Builder();
                builder.f1271a = new Nickname();
                return builder;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                            m1812a(codedInputStream.m287f());
                            break;
                        case 18:
                            m1815b(codedInputStream.m287f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(Nickname nickname) {
                if (nickname == Nickname.m1794a()) {
                    return this;
                }
                if (nickname.m1802c()) {
                    m1812a(nickname.m1803d());
                }
                if (nickname.m1804e()) {
                    m1815b(nickname.m1805f());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1812a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1271a.f1266b = true;
                this.f1271a.f1267c = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Nickname internalGetResult() {
                return this.f1271a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1809h().mergeFrom(this.f1271a);
            }

            /* renamed from: b */
            public Builder m1815b(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1271a.f1268d = true;
                this.f1271a.f1269e = str;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Nickname mo4403getDefaultInstanceForType() {
                return Nickname.m1794a();
            }

            /* renamed from: d */
            public boolean m1817d() {
                return this.f1271a.m1806g();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Nickname build() {
                if (this.f1271a == null || m1817d()) {
                    return m1819f();
                }
                throw newUninitializedMessageException(this.f1271a);
            }

            /* renamed from: f */
            public Nickname m1819f() {
                if (this.f1271a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                Nickname nickname = this.f1271a;
                this.f1271a = null;
                return nickname;
            }
        }

        static {
            SSMGPB.m810a();
            f1265a.m1800j();
        }

        private Nickname() {
            this.f1267c = "";
            this.f1269e = "";
            this.f1270f = -1;
            m1800j();
        }

        private Nickname(boolean z) {
            this.f1267c = "";
            this.f1269e = "";
            this.f1270f = -1;
        }

        /* renamed from: a */
        public static Nickname m1794a() {
            return f1265a;
        }

        /* renamed from: h */
        public static Builder m1799h() {
            return Builder.m1809h();
        }

        /* renamed from: j */
        private void m1800j() {
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Nickname getDefaultInstanceForType() {
            return f1265a;
        }

        /* renamed from: c */
        public boolean m1802c() {
            return this.f1266b;
        }

        /* renamed from: d */
        public String m1803d() {
            return this.f1267c;
        }

        /* renamed from: e */
        public boolean m1804e() {
            return this.f1268d;
        }

        /* renamed from: f */
        public String m1805f() {
            return this.f1269e;
        }

        /* renamed from: g */
        public final boolean m1806g() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM303b = this.f1270f;
            if (iM303b == -1) {
                iM303b = m1802c() ? 0 + CodedOutputStream.m303b(1, m1803d()) : 0;
                if (m1804e()) {
                    iM303b += CodedOutputStream.m303b(2, m1805f());
                }
                this.f1270f = iM303b;
            }
            return iM303b;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1799h();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1802c()) {
                codedOutputStream.m322a(1, m1803d());
            }
            if (m1804e()) {
                codedOutputStream.m322a(2, m1805f());
            }
        }
    }

    public final class NicknameReply extends GeneratedMessageLite {

        /* renamed from: a */
        private static final NicknameReply f1272a = new NicknameReply(true);

        /* renamed from: b */
        private boolean f1273b;

        /* renamed from: c */
        private long f1274c;

        /* renamed from: d */
        private List f1275d;

        /* renamed from: e */
        private boolean f1276e;

        /* renamed from: f */
        private Result f1277f;

        /* renamed from: g */
        private int f1278g;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private NicknameReply f1279a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: j */
            public static Builder m1842j() {
                Builder builder = new Builder();
                builder.f1279a = new NicknameReply();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: k */
            public NicknameReply m1843k() {
                if (m1853d()) {
                    return m1855f();
                }
                throw newUninitializedMessageException(this.f1279a).m350a();
            }

            /* renamed from: a */
            public Builder m1844a(long j) {
                this.f1279a.f1273b = true;
                this.f1279a.f1274c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m1844a(codedInputStream.m282c());
                            break;
                        case 18:
                            Nickname.Builder builderM1799h = Nickname.m1799h();
                            codedInputStream.m278a(builderM1799h, extensionRegistryLite);
                            m1846a(builderM1799h.m1819f());
                            break;
                        case 26:
                            Result.Builder builderM1894h = Result.m1894h();
                            if (m1856g()) {
                                builderM1894h.mergeFrom(m1857h());
                            }
                            codedInputStream.m278a(builderM1894h, extensionRegistryLite);
                            m1848a(builderM1894h.m1914f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            /* renamed from: a */
            public Builder m1846a(Nickname nickname) {
                if (nickname == null) {
                    throw new NullPointerException();
                }
                if (this.f1279a.f1275d.isEmpty()) {
                    this.f1279a.f1275d = new ArrayList();
                }
                this.f1279a.f1275d.add(nickname);
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(NicknameReply nicknameReply) {
                if (nicknameReply == NicknameReply.m1821a()) {
                    return this;
                }
                if (nicknameReply.m1833c()) {
                    m1844a(nicknameReply.m1834d());
                }
                if (!nicknameReply.f1275d.isEmpty()) {
                    if (this.f1279a.f1275d.isEmpty()) {
                        this.f1279a.f1275d = new ArrayList();
                    }
                    this.f1279a.f1275d.addAll(nicknameReply.f1275d);
                }
                if (nicknameReply.m1836f()) {
                    m1851b(nicknameReply.m1837g());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1848a(Result result) {
                if (result == null) {
                    throw new NullPointerException();
                }
                this.f1279a.f1276e = true;
                this.f1279a.f1277f = result;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public NicknameReply internalGetResult() {
                return this.f1279a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1842j().mergeFrom(this.f1279a);
            }

            /* renamed from: b */
            public Builder m1851b(Result result) {
                if (!this.f1279a.m1836f() || this.f1279a.f1277f == Result.m1890a()) {
                    this.f1279a.f1277f = result;
                } else {
                    this.f1279a.f1277f = Result.m1889a(this.f1279a.f1277f).mergeFrom(result).m1914f();
                }
                this.f1279a.f1276e = true;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public NicknameReply mo4403getDefaultInstanceForType() {
                return NicknameReply.m1821a();
            }

            /* renamed from: d */
            public boolean m1853d() {
                return this.f1279a.m1838h();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public NicknameReply build() {
                if (this.f1279a == null || m1853d()) {
                    return m1855f();
                }
                throw newUninitializedMessageException(this.f1279a);
            }

            /* renamed from: f */
            public NicknameReply m1855f() {
                if (this.f1279a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.f1279a.f1275d != Collections.EMPTY_LIST) {
                    this.f1279a.f1275d = Collections.unmodifiableList(this.f1279a.f1275d);
                }
                NicknameReply nicknameReply = this.f1279a;
                this.f1279a = null;
                return nicknameReply;
            }

            /* renamed from: g */
            public boolean m1856g() {
                return this.f1279a.m1836f();
            }

            /* renamed from: h */
            public Result m1857h() {
                return this.f1279a.m1837g();
            }
        }

        static {
            SSMGPB.m810a();
            f1272a.m1830k();
        }

        private NicknameReply() {
            this.f1274c = 0L;
            this.f1275d = Collections.emptyList();
            this.f1278g = -1;
            m1830k();
        }

        private NicknameReply(boolean z) {
            this.f1274c = 0L;
            this.f1275d = Collections.emptyList();
            this.f1278g = -1;
        }

        /* renamed from: a */
        public static NicknameReply m1821a() {
            return f1272a;
        }

        /* renamed from: a */
        public static NicknameReply m1822a(byte[] bArr) {
            return ((Builder) m1829i().m4401mergeFrom(bArr)).m1843k();
        }

        /* renamed from: i */
        public static Builder m1829i() {
            return Builder.m1842j();
        }

        /* renamed from: k */
        private void m1830k() {
            this.f1277f = Result.m1890a();
        }

        /* renamed from: a */
        public Nickname m1831a(int i) {
            return (Nickname) this.f1275d.get(i);
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NicknameReply getDefaultInstanceForType() {
            return f1272a;
        }

        /* renamed from: c */
        public boolean m1833c() {
            return this.f1273b;
        }

        /* renamed from: d */
        public long m1834d() {
            return this.f1274c;
        }

        /* renamed from: e */
        public List m1835e() {
            return this.f1275d;
        }

        /* renamed from: f */
        public boolean m1836f() {
            return this.f1276e;
        }

        /* renamed from: g */
        public Result m1837g() {
            return this.f1277f;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i;
            int iM302b = this.f1278g;
            if (iM302b == -1) {
                int iM301b = m1833c() ? 0 + CodedOutputStream.m301b(1, m1834d()) : 0;
                Iterator it = m1835e().iterator();
                while (true) {
                    i = iM301b;
                    if (!it.hasNext()) {
                        break;
                    }
                    iM301b = CodedOutputStream.m302b(2, (Nickname) it.next()) + i;
                }
                iM302b = m1836f() ? CodedOutputStream.m302b(3, m1837g()) + i : i;
                this.f1278g = iM302b;
            }
            return iM302b;
        }

        /* renamed from: h */
        public final boolean m1838h() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1829i();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1833c()) {
                codedOutputStream.m320a(1, m1834d());
            }
            Iterator it = m1835e().iterator();
            while (it.hasNext()) {
                codedOutputStream.m321a(2, (Nickname) it.next());
            }
            if (m1836f()) {
                codedOutputStream.m321a(3, m1837g());
            }
        }
    }

    public final class NicknameRequest extends GeneratedMessageLite {

        /* renamed from: a */
        private static final NicknameRequest f1280a = new NicknameRequest(true);

        /* renamed from: b */
        private boolean f1281b;

        /* renamed from: c */
        private long f1282c;

        /* renamed from: d */
        private List f1283d;

        /* renamed from: e */
        private int f1284e;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private NicknameRequest f1285a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: j */
            public static Builder m1874j() {
                Builder builder = new Builder();
                builder.f1285a = new NicknameRequest();
                return builder;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: k */
            public NicknameRequest m1875k() {
                if (m1883d()) {
                    return m1885f();
                }
                throw newUninitializedMessageException(this.f1285a).m350a();
            }

            /* renamed from: a */
            public Builder m1876a(long j) {
                this.f1285a.f1281b = true;
                this.f1285a.f1282c = j;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m1876a(codedInputStream.m282c());
                            break;
                        case 18:
                            m1879a(codedInputStream.m287f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(NicknameRequest nicknameRequest) {
                if (nicknameRequest == NicknameRequest.m1859a()) {
                    return this;
                }
                if (nicknameRequest.m1867c()) {
                    m1876a(nicknameRequest.m1868d());
                }
                if (!nicknameRequest.f1283d.isEmpty()) {
                    if (this.f1285a.f1283d.isEmpty()) {
                        this.f1285a.f1283d = new ArrayList();
                    }
                    this.f1285a.f1283d.addAll(nicknameRequest.f1283d);
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1879a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (this.f1285a.f1283d.isEmpty()) {
                    this.f1285a.f1283d = new ArrayList();
                }
                this.f1285a.f1283d.add(str);
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public NicknameRequest internalGetResult() {
                return this.f1285a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1874j().mergeFrom(this.f1285a);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public NicknameRequest mo4403getDefaultInstanceForType() {
                return NicknameRequest.m1859a();
            }

            /* renamed from: d */
            public boolean m1883d() {
                return this.f1285a.m1870f();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public NicknameRequest build() {
                if (this.f1285a == null || m1883d()) {
                    return m1885f();
                }
                throw newUninitializedMessageException(this.f1285a);
            }

            /* renamed from: f */
            public NicknameRequest m1885f() {
                if (this.f1285a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.f1285a.f1283d != Collections.EMPTY_LIST) {
                    this.f1285a.f1283d = Collections.unmodifiableList(this.f1285a.f1283d);
                }
                NicknameRequest nicknameRequest = this.f1285a;
                this.f1285a = null;
                return nicknameRequest;
            }

            /* renamed from: g */
            public long m1886g() {
                return this.f1285a.m1868d();
            }

            /* renamed from: h */
            public List m1887h() {
                return Collections.unmodifiableList(this.f1285a.f1283d);
            }
        }

        static {
            SSMGPB.m810a();
            f1280a.m1865i();
        }

        private NicknameRequest() {
            this.f1282c = 0L;
            this.f1283d = Collections.emptyList();
            this.f1284e = -1;
            m1865i();
        }

        private NicknameRequest(boolean z) {
            this.f1282c = 0L;
            this.f1283d = Collections.emptyList();
            this.f1284e = -1;
        }

        /* renamed from: a */
        public static NicknameRequest m1859a() {
            return f1280a;
        }

        /* renamed from: a */
        public static NicknameRequest m1860a(byte[] bArr) {
            return ((Builder) m1864g().m4401mergeFrom(bArr)).m1875k();
        }

        /* renamed from: g */
        public static Builder m1864g() {
            return Builder.m1874j();
        }

        /* renamed from: i */
        private void m1865i() {
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public NicknameRequest getDefaultInstanceForType() {
            return f1280a;
        }

        /* renamed from: c */
        public boolean m1867c() {
            return this.f1281b;
        }

        /* renamed from: d */
        public long m1868d() {
            return this.f1282c;
        }

        /* renamed from: e */
        public List m1869e() {
            return this.f1283d;
        }

        /* renamed from: f */
        public final boolean m1870f() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM307b = 0;
            int i = this.f1284e;
            if (i != -1) {
                return i;
            }
            int iM301b = m1867c() ? CodedOutputStream.m301b(1, m1868d()) + 0 : 0;
            Iterator it = m1869e().iterator();
            while (it.hasNext()) {
                iM307b = CodedOutputStream.m307b((String) it.next()) + iM307b;
            }
            int size = iM301b + iM307b + (m1869e().size() * 1);
            this.f1284e = size;
            return size;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1864g();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1867c()) {
                codedOutputStream.m320a(1, m1868d());
            }
            Iterator it = m1869e().iterator();
            while (it.hasNext()) {
                codedOutputStream.m322a(2, (String) it.next());
            }
        }
    }

    public final class Result extends GeneratedMessageLite {

        /* renamed from: a */
        private static final Result f1286a = new Result(true);

        /* renamed from: b */
        private boolean f1287b;

        /* renamed from: c */
        private int f1288c;

        /* renamed from: d */
        private boolean f1289d;

        /* renamed from: e */
        private String f1290e;

        /* renamed from: f */
        private int f1291f;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private Result f1292a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: h */
            public static Builder m1904h() {
                Builder builder = new Builder();
                builder.f1292a = new Result();
                return builder;
            }

            /* renamed from: a */
            public Builder m1905a(int i) {
                this.f1292a.f1287b = true;
                this.f1292a.f1288c = i;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            m1905a(codedInputStream.m283d());
                            break;
                        case 18:
                            m1908a(codedInputStream.m287f());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(Result result) {
                if (result == Result.m1890a()) {
                    return this;
                }
                if (result.m1897c()) {
                    m1905a(result.m1898d());
                }
                if (result.m1899e()) {
                    m1908a(result.m1900f());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1908a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1292a.f1289d = true;
                this.f1292a.f1290e = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Result internalGetResult() {
                return this.f1292a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1904h().mergeFrom(this.f1292a);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Result mo4403getDefaultInstanceForType() {
                return Result.m1890a();
            }

            /* renamed from: d */
            public boolean m1912d() {
                return this.f1292a.m1901g();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public Result build() {
                if (this.f1292a == null || m1912d()) {
                    return m1914f();
                }
                throw newUninitializedMessageException(this.f1292a);
            }

            /* renamed from: f */
            public Result m1914f() {
                if (this.f1292a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                Result result = this.f1292a;
                this.f1292a = null;
                return result;
            }
        }

        static {
            SSMGPB.m810a();
            f1286a.m1895j();
        }

        private Result() {
            this.f1288c = 0;
            this.f1290e = "";
            this.f1291f = -1;
            m1895j();
        }

        private Result(boolean z) {
            this.f1288c = 0;
            this.f1290e = "";
            this.f1291f = -1;
        }

        /* renamed from: a */
        public static Builder m1889a(Result result) {
            return m1894h().mergeFrom(result);
        }

        /* renamed from: a */
        public static Result m1890a() {
            return f1286a;
        }

        /* renamed from: h */
        public static Builder m1894h() {
            return Builder.m1904h();
        }

        /* renamed from: j */
        private void m1895j() {
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Result getDefaultInstanceForType() {
            return f1286a;
        }

        /* renamed from: c */
        public boolean m1897c() {
            return this.f1287b;
        }

        /* renamed from: d */
        public int m1898d() {
            return this.f1288c;
        }

        /* renamed from: e */
        public boolean m1899e() {
            return this.f1289d;
        }

        /* renamed from: f */
        public String m1900f() {
            return this.f1290e;
        }

        /* renamed from: g */
        public final boolean m1901g() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM309c = this.f1291f;
            if (iM309c == -1) {
                iM309c = m1897c() ? 0 + CodedOutputStream.m309c(1, m1898d()) : 0;
                if (m1899e()) {
                    iM309c += CodedOutputStream.m303b(2, m1900f());
                }
                this.f1291f = iM309c;
            }
            return iM309c;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1894h();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1897c()) {
                codedOutputStream.m319a(1, m1898d());
            }
            if (m1899e()) {
                codedOutputStream.m322a(2, m1900f());
            }
        }
    }

    public final class ServerInfo extends GeneratedMessageLite {

        /* renamed from: a */
        private static final ServerInfo f1293a = new ServerInfo(true);

        /* renamed from: b */
        private boolean f1294b;

        /* renamed from: c */
        private String f1295c;

        /* renamed from: d */
        private boolean f1296d;

        /* renamed from: e */
        private int f1297e;

        /* renamed from: f */
        private int f1298f;

        public final class Builder extends GeneratedMessageLite.Builder {

            /* renamed from: a */
            private ServerInfo f1299a;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: h */
            public static Builder m1931h() {
                Builder builder = new Builder();
                builder.f1299a = new ServerInfo();
                return builder;
            }

            /* renamed from: a */
            public Builder m1932a(int i) {
                this.f1299a.f1296d = true;
                this.f1299a.f1297e = i;
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                            m1935a(codedInputStream.m287f());
                            break;
                        case 16:
                            m1932a(codedInputStream.m283d());
                            break;
                        default:
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, iM276a)) {
                                return this;
                            }
                            break;
                    }
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Builder mergeFrom(ServerInfo serverInfo) {
                if (serverInfo == ServerInfo.m1917a()) {
                    return this;
                }
                if (serverInfo.m1924c()) {
                    m1935a(serverInfo.m1925d());
                }
                if (serverInfo.m1926e()) {
                    m1932a(serverInfo.m1927f());
                }
                return this;
            }

            /* renamed from: a */
            public Builder m1935a(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.f1299a.f1294b = true;
                this.f1299a.f1295c = str;
                return this;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ServerInfo internalGetResult() {
                return this.f1299a;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return m1931h().mergeFrom(this.f1299a);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public ServerInfo mo4403getDefaultInstanceForType() {
                return ServerInfo.m1917a();
            }

            /* renamed from: d */
            public boolean m1939d() {
                return this.f1299a.m1928g();
            }

            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public ServerInfo build() {
                if (this.f1299a == null || m1939d()) {
                    return m1941f();
                }
                throw newUninitializedMessageException(this.f1299a);
            }

            /* renamed from: f */
            public ServerInfo m1941f() {
                if (this.f1299a == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                ServerInfo serverInfo = this.f1299a;
                this.f1299a = null;
                return serverInfo;
            }
        }

        static {
            SSMGPB.m810a();
            f1293a.m1922j();
        }

        private ServerInfo() {
            this.f1295c = "";
            this.f1297e = 0;
            this.f1298f = -1;
            m1922j();
        }

        private ServerInfo(boolean z) {
            this.f1295c = "";
            this.f1297e = 0;
            this.f1298f = -1;
        }

        /* renamed from: a */
        public static Builder m1916a(ServerInfo serverInfo) {
            return m1921h().mergeFrom(serverInfo);
        }

        /* renamed from: a */
        public static ServerInfo m1917a() {
            return f1293a;
        }

        /* renamed from: h */
        public static Builder m1921h() {
            return Builder.m1931h();
        }

        /* renamed from: j */
        private void m1922j() {
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ServerInfo getDefaultInstanceForType() {
            return f1293a;
        }

        /* renamed from: c */
        public boolean m1924c() {
            return this.f1294b;
        }

        /* renamed from: d */
        public String m1925d() {
            return this.f1295c;
        }

        /* renamed from: e */
        public boolean m1926e() {
            return this.f1296d;
        }

        /* renamed from: f */
        public int m1927f() {
            return this.f1297e;
        }

        /* renamed from: g */
        public final boolean m1928g() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM303b = this.f1298f;
            if (iM303b == -1) {
                iM303b = m1924c() ? 0 + CodedOutputStream.m303b(1, m1925d()) : 0;
                if (m1926e()) {
                    iM303b += CodedOutputStream.m309c(2, m1927f());
                }
                this.f1298f = iM303b;
            }
            return iM303b;
        }

        @Override // com.google.protobuf.MessageLite
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Builder newBuilderForType() {
            return m1921h();
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (m1924c()) {
                codedOutputStream.m322a(1, m1925d());
            }
            if (m1926e()) {
                codedOutputStream.m319a(2, m1927f());
            }
        }
    }

    private SSMGPB() {
    }

    /* renamed from: a */
    public static void m810a() {
    }
}
