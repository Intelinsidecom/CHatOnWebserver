package com.sec.pns.msg.frontend;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class MsgFrontend {

    public final class DeregistrationReply extends GeneratedMessageLite {
        public static final int ASYNC_ID_FIELD_NUMBER = 1;
        public static final int RESULT_CODE_FIELD_NUMBER = 2;
        public static final int RESULT_MSG_FIELD_NUMBER = 3;
        public static final int USER_DATA_FIELD_NUMBER = 4;
        private static final DeregistrationReply defaultInstance = new DeregistrationReply(true);
        private int asyncId_;
        private boolean hasAsyncId;
        private boolean hasResultCode;
        private boolean hasResultMsg;
        private boolean hasUserData;
        private int memoizedSerializedSize;
        private int resultCode_;
        private String resultMsg_;
        private String userData_;

        public final class Builder extends GeneratedMessageLite.Builder {
            private DeregistrationReply result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public DeregistrationReply buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).m350a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new DeregistrationReply();
                return builder;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            public DeregistrationReply build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            public DeregistrationReply buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                DeregistrationReply deregistrationReply = this.result;
                this.result = null;
                return deregistrationReply;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new DeregistrationReply();
                return this;
            }

            public Builder clearAsyncId() {
                this.result.hasAsyncId = false;
                this.result.asyncId_ = 0;
                return this;
            }

            public Builder clearResultCode() {
                this.result.hasResultCode = false;
                this.result.resultCode_ = 0;
                return this;
            }

            public Builder clearResultMsg() {
                this.result.hasResultMsg = false;
                this.result.resultMsg_ = DeregistrationReply.getDefaultInstance().getResultMsg();
                return this;
            }

            public Builder clearUserData() {
                this.result.hasUserData = false;
                this.result.userData_ = DeregistrationReply.getDefaultInstance().getUserData();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return create().mergeFrom(this.result);
            }

            public int getAsyncId() {
                return this.result.getAsyncId();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: getDefaultInstanceForType, reason: merged with bridge method [inline-methods] */
            public DeregistrationReply mo4403getDefaultInstanceForType() {
                return DeregistrationReply.getDefaultInstance();
            }

            public int getResultCode() {
                return this.result.getResultCode();
            }

            public String getResultMsg() {
                return this.result.getResultMsg();
            }

            public String getUserData() {
                return this.result.getUserData();
            }

            public boolean hasAsyncId() {
                return this.result.hasAsyncId();
            }

            public boolean hasResultCode() {
                return this.result.hasResultCode();
            }

            public boolean hasResultMsg() {
                return this.result.hasResultMsg();
            }

            public boolean hasUserData() {
                return this.result.hasUserData();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public DeregistrationReply internalGetResult() {
                return this.result;
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            setAsyncId(codedInputStream.m283d());
                            break;
                        case 16:
                            setResultCode(codedInputStream.m283d());
                            break;
                        case 26:
                            setResultMsg(codedInputStream.m287f());
                            break;
                        case 34:
                            setUserData(codedInputStream.m287f());
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
            public Builder mergeFrom(DeregistrationReply deregistrationReply) {
                if (deregistrationReply == DeregistrationReply.getDefaultInstance()) {
                    return this;
                }
                if (deregistrationReply.hasAsyncId()) {
                    setAsyncId(deregistrationReply.getAsyncId());
                }
                if (deregistrationReply.hasResultCode()) {
                    setResultCode(deregistrationReply.getResultCode());
                }
                if (deregistrationReply.hasResultMsg()) {
                    setResultMsg(deregistrationReply.getResultMsg());
                }
                if (deregistrationReply.hasUserData()) {
                    setUserData(deregistrationReply.getUserData());
                }
                return this;
            }

            public Builder setAsyncId(int i) {
                this.result.hasAsyncId = true;
                this.result.asyncId_ = i;
                return this;
            }

            public Builder setResultCode(int i) {
                this.result.hasResultCode = true;
                this.result.resultCode_ = i;
                return this;
            }

            public Builder setResultMsg(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasResultMsg = true;
                this.result.resultMsg_ = str;
                return this;
            }

            public Builder setUserData(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasUserData = true;
                this.result.userData_ = str;
                return this;
            }
        }

        static {
            MsgFrontend.internalForceInit();
            defaultInstance.initFields();
        }

        private DeregistrationReply() {
            this.asyncId_ = 0;
            this.resultCode_ = 0;
            this.resultMsg_ = "";
            this.userData_ = "";
            this.memoizedSerializedSize = -1;
            initFields();
        }

        private DeregistrationReply(boolean z) {
            this.asyncId_ = 0;
            this.resultCode_ = 0;
            this.resultMsg_ = "";
            this.userData_ = "";
            this.memoizedSerializedSize = -1;
        }

        public static DeregistrationReply getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(DeregistrationReply deregistrationReply) {
            return newBuilder().mergeFrom(deregistrationReply);
        }

        public static DeregistrationReply parseDelimitedFrom(InputStream inputStream) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static DeregistrationReply parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream, extensionRegistryLite)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static DeregistrationReply parseFrom(ByteString byteString) {
            return ((Builder) newBuilder().m4398mergeFrom(byteString)).buildParsed();
        }

        public static DeregistrationReply parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4399mergeFrom(byteString, extensionRegistryLite)).buildParsed();
        }

        public static DeregistrationReply parseFrom(CodedInputStream codedInputStream) {
            return ((Builder) newBuilder().m4400mergeFrom(codedInputStream)).buildParsed();
        }

        public static DeregistrationReply parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return newBuilder().mergeFrom(codedInputStream, extensionRegistryLite).buildParsed();
        }

        public static DeregistrationReply parseFrom(InputStream inputStream) {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        public static DeregistrationReply parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().mergeFrom(inputStream, extensionRegistryLite)).buildParsed();
        }

        public static DeregistrationReply parseFrom(byte[] bArr) {
            return ((Builder) newBuilder().m4401mergeFrom(bArr)).buildParsed();
        }

        public static DeregistrationReply parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4402mergeFrom(bArr, extensionRegistryLite)).buildParsed();
        }

        public int getAsyncId() {
            return this.asyncId_;
        }

        @Override // com.google.protobuf.MessageLite
        public DeregistrationReply getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getResultCode() {
            return this.resultCode_;
        }

        public String getResultMsg() {
            return this.resultMsg_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM309c = this.memoizedSerializedSize;
            if (iM309c == -1) {
                iM309c = hasAsyncId() ? 0 + CodedOutputStream.m309c(1, getAsyncId()) : 0;
                if (hasResultCode()) {
                    iM309c += CodedOutputStream.m309c(2, getResultCode());
                }
                if (hasResultMsg()) {
                    iM309c += CodedOutputStream.m303b(3, getResultMsg());
                }
                if (hasUserData()) {
                    iM309c += CodedOutputStream.m303b(4, getUserData());
                }
                this.memoizedSerializedSize = iM309c;
            }
            return iM309c;
        }

        public String getUserData() {
            return this.userData_;
        }

        public boolean hasAsyncId() {
            return this.hasAsyncId;
        }

        public boolean hasResultCode() {
            return this.hasResultCode;
        }

        public boolean hasResultMsg() {
            return this.hasResultMsg;
        }

        public boolean hasUserData() {
            return this.hasUserData;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (hasAsyncId()) {
                codedOutputStream.m319a(1, getAsyncId());
            }
            if (hasResultCode()) {
                codedOutputStream.m319a(2, getResultCode());
            }
            if (hasResultMsg()) {
                codedOutputStream.m322a(3, getResultMsg());
            }
            if (hasUserData()) {
                codedOutputStream.m322a(4, getUserData());
            }
        }
    }

    public final class DeregistrationRequest extends GeneratedMessageLite {
        public static final int ASYNC_ID_FIELD_NUMBER = 1;
        public static final int DEVICE_TOKEN_FIELD_NUMBER = 2;
        public static final int REG_ID_FIELD_NUMBER = 3;
        public static final int USER_DATA_FIELD_NUMBER = 4;
        private static final DeregistrationRequest defaultInstance = new DeregistrationRequest(true);
        private int asyncId_;
        private String deviceToken_;
        private boolean hasAsyncId;
        private boolean hasDeviceToken;
        private boolean hasRegId;
        private boolean hasUserData;
        private int memoizedSerializedSize;
        private String regId_;
        private String userData_;

        public final class Builder extends GeneratedMessageLite.Builder {
            private DeregistrationRequest result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public DeregistrationRequest buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).m350a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new DeregistrationRequest();
                return builder;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            public DeregistrationRequest build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            public DeregistrationRequest buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                DeregistrationRequest deregistrationRequest = this.result;
                this.result = null;
                return deregistrationRequest;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new DeregistrationRequest();
                return this;
            }

            public Builder clearAsyncId() {
                this.result.hasAsyncId = false;
                this.result.asyncId_ = 0;
                return this;
            }

            public Builder clearDeviceToken() {
                this.result.hasDeviceToken = false;
                this.result.deviceToken_ = DeregistrationRequest.getDefaultInstance().getDeviceToken();
                return this;
            }

            public Builder clearRegId() {
                this.result.hasRegId = false;
                this.result.regId_ = DeregistrationRequest.getDefaultInstance().getRegId();
                return this;
            }

            public Builder clearUserData() {
                this.result.hasUserData = false;
                this.result.userData_ = DeregistrationRequest.getDefaultInstance().getUserData();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone, reason: merged with bridge method [inline-methods] */
            public Builder mo4397clone() {
                return create().mergeFrom(this.result);
            }

            public int getAsyncId() {
                return this.result.getAsyncId();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: getDefaultInstanceForType */
            public DeregistrationRequest mo4403getDefaultInstanceForType() {
                return DeregistrationRequest.getDefaultInstance();
            }

            public String getDeviceToken() {
                return this.result.getDeviceToken();
            }

            public String getRegId() {
                return this.result.getRegId();
            }

            public String getUserData() {
                return this.result.getUserData();
            }

            public boolean hasAsyncId() {
                return this.result.hasAsyncId();
            }

            public boolean hasDeviceToken() {
                return this.result.hasDeviceToken();
            }

            public boolean hasRegId() {
                return this.result.hasRegId();
            }

            public boolean hasUserData() {
                return this.result.hasUserData();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public DeregistrationRequest internalGetResult() {
                return this.result;
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            setAsyncId(codedInputStream.m283d());
                            break;
                        case 18:
                            setDeviceToken(codedInputStream.m287f());
                            break;
                        case 26:
                            setRegId(codedInputStream.m287f());
                            break;
                        case 34:
                            setUserData(codedInputStream.m287f());
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
            public Builder mergeFrom(DeregistrationRequest deregistrationRequest) {
                if (deregistrationRequest == DeregistrationRequest.getDefaultInstance()) {
                    return this;
                }
                if (deregistrationRequest.hasAsyncId()) {
                    setAsyncId(deregistrationRequest.getAsyncId());
                }
                if (deregistrationRequest.hasDeviceToken()) {
                    setDeviceToken(deregistrationRequest.getDeviceToken());
                }
                if (deregistrationRequest.hasRegId()) {
                    setRegId(deregistrationRequest.getRegId());
                }
                if (deregistrationRequest.hasUserData()) {
                    setUserData(deregistrationRequest.getUserData());
                }
                return this;
            }

            public Builder setAsyncId(int i) {
                this.result.hasAsyncId = true;
                this.result.asyncId_ = i;
                return this;
            }

            public Builder setDeviceToken(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasDeviceToken = true;
                this.result.deviceToken_ = str;
                return this;
            }

            public Builder setRegId(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasRegId = true;
                this.result.regId_ = str;
                return this;
            }

            public Builder setUserData(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasUserData = true;
                this.result.userData_ = str;
                return this;
            }
        }

        static {
            MsgFrontend.internalForceInit();
            defaultInstance.initFields();
        }

        private DeregistrationRequest() {
            this.asyncId_ = 0;
            this.deviceToken_ = "";
            this.regId_ = "";
            this.userData_ = "";
            this.memoizedSerializedSize = -1;
            initFields();
        }

        private DeregistrationRequest(boolean z) {
            this.asyncId_ = 0;
            this.deviceToken_ = "";
            this.regId_ = "";
            this.userData_ = "";
            this.memoizedSerializedSize = -1;
        }

        public static DeregistrationRequest getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(DeregistrationRequest deregistrationRequest) {
            return newBuilder().mergeFrom(deregistrationRequest);
        }

        public static DeregistrationRequest parseDelimitedFrom(InputStream inputStream) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static DeregistrationRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream, extensionRegistryLite)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static DeregistrationRequest parseFrom(ByteString byteString) {
            return ((Builder) newBuilder().m4398mergeFrom(byteString)).buildParsed();
        }

        public static DeregistrationRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4399mergeFrom(byteString, extensionRegistryLite)).buildParsed();
        }

        public static DeregistrationRequest parseFrom(CodedInputStream codedInputStream) {
            return ((Builder) newBuilder().m4400mergeFrom(codedInputStream)).buildParsed();
        }

        public static DeregistrationRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return newBuilder().mergeFrom(codedInputStream, extensionRegistryLite).buildParsed();
        }

        public static DeregistrationRequest parseFrom(InputStream inputStream) {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        public static DeregistrationRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().mergeFrom(inputStream, extensionRegistryLite)).buildParsed();
        }

        public static DeregistrationRequest parseFrom(byte[] bArr) {
            return ((Builder) newBuilder().m4401mergeFrom(bArr)).buildParsed();
        }

        public static DeregistrationRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4402mergeFrom(bArr, extensionRegistryLite)).buildParsed();
        }

        public int getAsyncId() {
            return this.asyncId_;
        }

        @Override // com.google.protobuf.MessageLite
        public DeregistrationRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public String getDeviceToken() {
            return this.deviceToken_;
        }

        public String getRegId() {
            return this.regId_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM309c = this.memoizedSerializedSize;
            if (iM309c == -1) {
                iM309c = hasAsyncId() ? 0 + CodedOutputStream.m309c(1, getAsyncId()) : 0;
                if (hasDeviceToken()) {
                    iM309c += CodedOutputStream.m303b(2, getDeviceToken());
                }
                if (hasRegId()) {
                    iM309c += CodedOutputStream.m303b(3, getRegId());
                }
                if (hasUserData()) {
                    iM309c += CodedOutputStream.m303b(4, getUserData());
                }
                this.memoizedSerializedSize = iM309c;
            }
            return iM309c;
        }

        public String getUserData() {
            return this.userData_;
        }

        public boolean hasAsyncId() {
            return this.hasAsyncId;
        }

        public boolean hasDeviceToken() {
            return this.hasDeviceToken;
        }

        public boolean hasRegId() {
            return this.hasRegId;
        }

        public boolean hasUserData() {
            return this.hasUserData;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (hasAsyncId()) {
                codedOutputStream.m319a(1, getAsyncId());
            }
            if (hasDeviceToken()) {
                codedOutputStream.m322a(2, getDeviceToken());
            }
            if (hasRegId()) {
                codedOutputStream.m322a(3, getRegId());
            }
            if (hasUserData()) {
                codedOutputStream.m322a(4, getUserData());
            }
        }
    }

    public final class InitReply extends GeneratedMessageLite {
        public static final int ASYNC_ID_FIELD_NUMBER = 1;
        public static final int RESULT_CODE_FIELD_NUMBER = 2;
        public static final int RESULT_MSG_FIELD_NUMBER = 3;
        private static final InitReply defaultInstance = new InitReply(true);
        private int asyncId_;
        private boolean hasAsyncId;
        private boolean hasResultCode;
        private boolean hasResultMsg;
        private int memoizedSerializedSize;
        private int resultCode_;
        private String resultMsg_;

        public final class Builder extends GeneratedMessageLite.Builder {
            private InitReply result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public InitReply buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).m350a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new InitReply();
                return builder;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            public InitReply build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            public InitReply buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                InitReply initReply = this.result;
                this.result = null;
                return initReply;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new InitReply();
                return this;
            }

            public Builder clearAsyncId() {
                this.result.hasAsyncId = false;
                this.result.asyncId_ = 0;
                return this;
            }

            public Builder clearResultCode() {
                this.result.hasResultCode = false;
                this.result.resultCode_ = 0;
                return this;
            }

            public Builder clearResultMsg() {
                this.result.hasResultMsg = false;
                this.result.resultMsg_ = InitReply.getDefaultInstance().getResultMsg();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo4397clone() {
                return create().mergeFrom(this.result);
            }

            public int getAsyncId() {
                return this.result.getAsyncId();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: getDefaultInstanceForType */
            public InitReply mo4403getDefaultInstanceForType() {
                return InitReply.getDefaultInstance();
            }

            public int getResultCode() {
                return this.result.getResultCode();
            }

            public String getResultMsg() {
                return this.result.getResultMsg();
            }

            public boolean hasAsyncId() {
                return this.result.hasAsyncId();
            }

            public boolean hasResultCode() {
                return this.result.hasResultCode();
            }

            public boolean hasResultMsg() {
                return this.result.hasResultMsg();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public InitReply internalGetResult() {
                return this.result;
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            setAsyncId(codedInputStream.m283d());
                            break;
                        case 16:
                            setResultCode(codedInputStream.m283d());
                            break;
                        case 26:
                            setResultMsg(codedInputStream.m287f());
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
            public Builder mergeFrom(InitReply initReply) {
                if (initReply == InitReply.getDefaultInstance()) {
                    return this;
                }
                if (initReply.hasAsyncId()) {
                    setAsyncId(initReply.getAsyncId());
                }
                if (initReply.hasResultCode()) {
                    setResultCode(initReply.getResultCode());
                }
                if (initReply.hasResultMsg()) {
                    setResultMsg(initReply.getResultMsg());
                }
                return this;
            }

            public Builder setAsyncId(int i) {
                this.result.hasAsyncId = true;
                this.result.asyncId_ = i;
                return this;
            }

            public Builder setResultCode(int i) {
                this.result.hasResultCode = true;
                this.result.resultCode_ = i;
                return this;
            }

            public Builder setResultMsg(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasResultMsg = true;
                this.result.resultMsg_ = str;
                return this;
            }
        }

        static {
            MsgFrontend.internalForceInit();
            defaultInstance.initFields();
        }

        private InitReply() {
            this.asyncId_ = 0;
            this.resultCode_ = 0;
            this.resultMsg_ = "";
            this.memoizedSerializedSize = -1;
            initFields();
        }

        private InitReply(boolean z) {
            this.asyncId_ = 0;
            this.resultCode_ = 0;
            this.resultMsg_ = "";
            this.memoizedSerializedSize = -1;
        }

        public static InitReply getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(InitReply initReply) {
            return newBuilder().mergeFrom(initReply);
        }

        public static InitReply parseDelimitedFrom(InputStream inputStream) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static InitReply parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream, extensionRegistryLite)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static InitReply parseFrom(ByteString byteString) {
            return ((Builder) newBuilder().m4398mergeFrom(byteString)).buildParsed();
        }

        public static InitReply parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4399mergeFrom(byteString, extensionRegistryLite)).buildParsed();
        }

        public static InitReply parseFrom(CodedInputStream codedInputStream) {
            return ((Builder) newBuilder().m4400mergeFrom(codedInputStream)).buildParsed();
        }

        public static InitReply parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return newBuilder().mergeFrom(codedInputStream, extensionRegistryLite).buildParsed();
        }

        public static InitReply parseFrom(InputStream inputStream) {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        public static InitReply parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().mergeFrom(inputStream, extensionRegistryLite)).buildParsed();
        }

        public static InitReply parseFrom(byte[] bArr) {
            return ((Builder) newBuilder().m4401mergeFrom(bArr)).buildParsed();
        }

        public static InitReply parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4402mergeFrom(bArr, extensionRegistryLite)).buildParsed();
        }

        public int getAsyncId() {
            return this.asyncId_;
        }

        @Override // com.google.protobuf.MessageLite
        public InitReply getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getResultCode() {
            return this.resultCode_;
        }

        public String getResultMsg() {
            return this.resultMsg_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM309c = this.memoizedSerializedSize;
            if (iM309c == -1) {
                iM309c = hasAsyncId() ? 0 + CodedOutputStream.m309c(1, getAsyncId()) : 0;
                if (hasResultCode()) {
                    iM309c += CodedOutputStream.m309c(2, getResultCode());
                }
                if (hasResultMsg()) {
                    iM309c += CodedOutputStream.m303b(3, getResultMsg());
                }
                this.memoizedSerializedSize = iM309c;
            }
            return iM309c;
        }

        public boolean hasAsyncId() {
            return this.hasAsyncId;
        }

        public boolean hasResultCode() {
            return this.hasResultCode;
        }

        public boolean hasResultMsg() {
            return this.hasResultMsg;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (hasAsyncId()) {
                codedOutputStream.m319a(1, getAsyncId());
            }
            if (hasResultCode()) {
                codedOutputStream.m319a(2, getResultCode());
            }
            if (hasResultMsg()) {
                codedOutputStream.m322a(3, getResultMsg());
            }
        }
    }

    public final class InitRequest extends GeneratedMessageLite {
        public static final int ASYNC_ID_FIELD_NUMBER = 1;
        public static final int DEVICE_TOKEN_FIELD_NUMBER = 2;
        private static final InitRequest defaultInstance = new InitRequest(true);
        private int asyncId_;
        private String deviceToken_;
        private boolean hasAsyncId;
        private boolean hasDeviceToken;
        private int memoizedSerializedSize;

        public final class Builder extends GeneratedMessageLite.Builder {
            private InitRequest result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public InitRequest buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).m350a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new InitRequest();
                return builder;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            public InitRequest build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            public InitRequest buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                InitRequest initRequest = this.result;
                this.result = null;
                return initRequest;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new InitRequest();
                return this;
            }

            public Builder clearAsyncId() {
                this.result.hasAsyncId = false;
                this.result.asyncId_ = 0;
                return this;
            }

            public Builder clearDeviceToken() {
                this.result.hasDeviceToken = false;
                this.result.deviceToken_ = InitRequest.getDefaultInstance().getDeviceToken();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo4397clone() {
                return create().mergeFrom(this.result);
            }

            public int getAsyncId() {
                return this.result.getAsyncId();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: getDefaultInstanceForType */
            public InitRequest mo4403getDefaultInstanceForType() {
                return InitRequest.getDefaultInstance();
            }

            public String getDeviceToken() {
                return this.result.getDeviceToken();
            }

            public boolean hasAsyncId() {
                return this.result.hasAsyncId();
            }

            public boolean hasDeviceToken() {
                return this.result.hasDeviceToken();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public InitRequest internalGetResult() {
                return this.result;
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            setAsyncId(codedInputStream.m283d());
                            break;
                        case 18:
                            setDeviceToken(codedInputStream.m287f());
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
            public Builder mergeFrom(InitRequest initRequest) {
                if (initRequest == InitRequest.getDefaultInstance()) {
                    return this;
                }
                if (initRequest.hasAsyncId()) {
                    setAsyncId(initRequest.getAsyncId());
                }
                if (initRequest.hasDeviceToken()) {
                    setDeviceToken(initRequest.getDeviceToken());
                }
                return this;
            }

            public Builder setAsyncId(int i) {
                this.result.hasAsyncId = true;
                this.result.asyncId_ = i;
                return this;
            }

            public Builder setDeviceToken(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasDeviceToken = true;
                this.result.deviceToken_ = str;
                return this;
            }
        }

        static {
            MsgFrontend.internalForceInit();
            defaultInstance.initFields();
        }

        private InitRequest() {
            this.asyncId_ = 0;
            this.deviceToken_ = "";
            this.memoizedSerializedSize = -1;
            initFields();
        }

        private InitRequest(boolean z) {
            this.asyncId_ = 0;
            this.deviceToken_ = "";
            this.memoizedSerializedSize = -1;
        }

        public static InitRequest getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(InitRequest initRequest) {
            return newBuilder().mergeFrom(initRequest);
        }

        public static InitRequest parseDelimitedFrom(InputStream inputStream) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static InitRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream, extensionRegistryLite)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static InitRequest parseFrom(ByteString byteString) {
            return ((Builder) newBuilder().m4398mergeFrom(byteString)).buildParsed();
        }

        public static InitRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4399mergeFrom(byteString, extensionRegistryLite)).buildParsed();
        }

        public static InitRequest parseFrom(CodedInputStream codedInputStream) {
            return ((Builder) newBuilder().m4400mergeFrom(codedInputStream)).buildParsed();
        }

        public static InitRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return newBuilder().mergeFrom(codedInputStream, extensionRegistryLite).buildParsed();
        }

        public static InitRequest parseFrom(InputStream inputStream) {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        public static InitRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().mergeFrom(inputStream, extensionRegistryLite)).buildParsed();
        }

        public static InitRequest parseFrom(byte[] bArr) {
            return ((Builder) newBuilder().m4401mergeFrom(bArr)).buildParsed();
        }

        public static InitRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4402mergeFrom(bArr, extensionRegistryLite)).buildParsed();
        }

        public int getAsyncId() {
            return this.asyncId_;
        }

        @Override // com.google.protobuf.MessageLite
        public InitRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public String getDeviceToken() {
            return this.deviceToken_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM309c = this.memoizedSerializedSize;
            if (iM309c == -1) {
                iM309c = hasAsyncId() ? 0 + CodedOutputStream.m309c(1, getAsyncId()) : 0;
                if (hasDeviceToken()) {
                    iM309c += CodedOutputStream.m303b(2, getDeviceToken());
                }
                this.memoizedSerializedSize = iM309c;
            }
            return iM309c;
        }

        public boolean hasAsyncId() {
            return this.hasAsyncId;
        }

        public boolean hasDeviceToken() {
            return this.hasDeviceToken;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (hasAsyncId()) {
                codedOutputStream.m319a(1, getAsyncId());
            }
            if (hasDeviceToken()) {
                codedOutputStream.m322a(2, getDeviceToken());
            }
        }
    }

    public final class NotiAcks extends GeneratedMessageLite {
        public static final int DEVICE_TOKEN_FIELD_NUMBER = 1;
        public static final int NOTI_IDS_FIELD_NUMBER = 2;
        private static final NotiAcks defaultInstance = new NotiAcks(true);
        private String deviceToken_;
        private boolean hasDeviceToken;
        private int memoizedSerializedSize;
        private List notiIds_;

        public final class Builder extends GeneratedMessageLite.Builder {
            private NotiAcks result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public NotiAcks buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).m350a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new NotiAcks();
                return builder;
            }

            public Builder addAllNotiIds(Iterable iterable) {
                if (this.result.notiIds_.isEmpty()) {
                    this.result.notiIds_ = new ArrayList();
                }
                GeneratedMessageLite.Builder.addAll(iterable, this.result.notiIds_);
                return this;
            }

            public Builder addNotiIds(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                if (this.result.notiIds_.isEmpty()) {
                    this.result.notiIds_ = new ArrayList();
                }
                this.result.notiIds_.add(str);
                return this;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            public NotiAcks build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            public NotiAcks buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.notiIds_ != Collections.EMPTY_LIST) {
                    this.result.notiIds_ = Collections.unmodifiableList(this.result.notiIds_);
                }
                NotiAcks notiAcks = this.result;
                this.result = null;
                return notiAcks;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new NotiAcks();
                return this;
            }

            public Builder clearDeviceToken() {
                this.result.hasDeviceToken = false;
                this.result.deviceToken_ = NotiAcks.getDefaultInstance().getDeviceToken();
                return this;
            }

            public Builder clearNotiIds() {
                this.result.notiIds_ = Collections.emptyList();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo4397clone() {
                return create().mergeFrom(this.result);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: getDefaultInstanceForType */
            public NotiAcks mo4403getDefaultInstanceForType() {
                return NotiAcks.getDefaultInstance();
            }

            public String getDeviceToken() {
                return this.result.getDeviceToken();
            }

            public String getNotiIds(int i) {
                return this.result.getNotiIds(i);
            }

            public int getNotiIdsCount() {
                return this.result.getNotiIdsCount();
            }

            public List getNotiIdsList() {
                return Collections.unmodifiableList(this.result.notiIds_);
            }

            public boolean hasDeviceToken() {
                return this.result.hasDeviceToken();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public NotiAcks internalGetResult() {
                return this.result;
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                            setDeviceToken(codedInputStream.m287f());
                            break;
                        case 18:
                            addNotiIds(codedInputStream.m287f());
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
            public Builder mergeFrom(NotiAcks notiAcks) {
                if (notiAcks == NotiAcks.getDefaultInstance()) {
                    return this;
                }
                if (notiAcks.hasDeviceToken()) {
                    setDeviceToken(notiAcks.getDeviceToken());
                }
                if (!notiAcks.notiIds_.isEmpty()) {
                    if (this.result.notiIds_.isEmpty()) {
                        this.result.notiIds_ = new ArrayList();
                    }
                    this.result.notiIds_.addAll(notiAcks.notiIds_);
                }
                return this;
            }

            public Builder setDeviceToken(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasDeviceToken = true;
                this.result.deviceToken_ = str;
                return this;
            }

            public Builder setNotiIds(int i, String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.notiIds_.set(i, str);
                return this;
            }
        }

        static {
            MsgFrontend.internalForceInit();
            defaultInstance.initFields();
        }

        private NotiAcks() {
            this.deviceToken_ = "";
            this.notiIds_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
            initFields();
        }

        private NotiAcks(boolean z) {
            this.deviceToken_ = "";
            this.notiIds_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        public static NotiAcks getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(NotiAcks notiAcks) {
            return newBuilder().mergeFrom(notiAcks);
        }

        public static NotiAcks parseDelimitedFrom(InputStream inputStream) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static NotiAcks parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream, extensionRegistryLite)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static NotiAcks parseFrom(ByteString byteString) {
            return ((Builder) newBuilder().m4398mergeFrom(byteString)).buildParsed();
        }

        public static NotiAcks parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4399mergeFrom(byteString, extensionRegistryLite)).buildParsed();
        }

        public static NotiAcks parseFrom(CodedInputStream codedInputStream) {
            return ((Builder) newBuilder().m4400mergeFrom(codedInputStream)).buildParsed();
        }

        public static NotiAcks parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return newBuilder().mergeFrom(codedInputStream, extensionRegistryLite).buildParsed();
        }

        public static NotiAcks parseFrom(InputStream inputStream) {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        public static NotiAcks parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().mergeFrom(inputStream, extensionRegistryLite)).buildParsed();
        }

        public static NotiAcks parseFrom(byte[] bArr) {
            return ((Builder) newBuilder().m4401mergeFrom(bArr)).buildParsed();
        }

        public static NotiAcks parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4402mergeFrom(bArr, extensionRegistryLite)).buildParsed();
        }

        @Override // com.google.protobuf.MessageLite
        public NotiAcks getDefaultInstanceForType() {
            return defaultInstance;
        }

        public String getDeviceToken() {
            return this.deviceToken_;
        }

        public String getNotiIds(int i) {
            return (String) this.notiIds_.get(i);
        }

        public int getNotiIdsCount() {
            return this.notiIds_.size();
        }

        public List getNotiIdsList() {
            return this.notiIds_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM307b = 0;
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iM303b = hasDeviceToken() ? CodedOutputStream.m303b(1, getDeviceToken()) + 0 : 0;
            Iterator it = getNotiIdsList().iterator();
            while (it.hasNext()) {
                iM307b = CodedOutputStream.m307b((String) it.next()) + iM307b;
            }
            int size = iM303b + iM307b + (getNotiIdsList().size() * 1);
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDeviceToken() {
            return this.hasDeviceToken;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (hasDeviceToken()) {
                codedOutputStream.m322a(1, getDeviceToken());
            }
            Iterator it = getNotiIdsList().iterator();
            while (it.hasNext()) {
                codedOutputStream.m322a(2, (String) it.next());
            }
        }
    }

    public final class NotiElement extends GeneratedMessageLite {
        public static final int APP_DATA_FIELD_NUMBER = 7;
        public static final int APP_ID_FIELD_NUMBER = 2;
        public static final int CONNECTION_TERM_FIELD_NUMBER = 12;
        public static final int MESSAGE_FIELD_NUMBER = 6;
        public static final int NOTI_ID_FIELD_NUMBER = 1;
        public static final int RELIABLE_LEVEL_FIELD_NUMBER = 3;
        public static final int SENDER_FIELD_NUMBER = 5;
        public static final int SESSION_INFO_FIELD_NUMBER = 13;
        public static final int TIME_STAMP_FIELD_NUMBER = 11;
        public static final int TYPE_FIELD_NUMBER = 4;
        private static final NotiElement defaultInstance = new NotiElement(true);
        private String appData_;
        private String appId_;
        private int connectionTerm_;
        private boolean hasAppData;
        private boolean hasAppId;
        private boolean hasConnectionTerm;
        private boolean hasMessage;
        private boolean hasNotiId;
        private boolean hasReliableLevel;
        private boolean hasSender;
        private boolean hasSessionInfo;
        private boolean hasTimeStamp;
        private boolean hasType;
        private int memoizedSerializedSize;
        private String message_;
        private String notiId_;
        private int reliableLevel_;
        private String sender_;
        private String sessionInfo_;
        private long timeStamp_;
        private int type_;

        public final class Builder extends GeneratedMessageLite.Builder {
            private NotiElement result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public NotiElement buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).m350a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new NotiElement();
                return builder;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            public NotiElement build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            public NotiElement buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                NotiElement notiElement = this.result;
                this.result = null;
                return notiElement;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new NotiElement();
                return this;
            }

            public Builder clearAppData() {
                this.result.hasAppData = false;
                this.result.appData_ = NotiElement.getDefaultInstance().getAppData();
                return this;
            }

            public Builder clearAppId() {
                this.result.hasAppId = false;
                this.result.appId_ = NotiElement.getDefaultInstance().getAppId();
                return this;
            }

            public Builder clearConnectionTerm() {
                this.result.hasConnectionTerm = false;
                this.result.connectionTerm_ = 0;
                return this;
            }

            public Builder clearMessage() {
                this.result.hasMessage = false;
                this.result.message_ = NotiElement.getDefaultInstance().getMessage();
                return this;
            }

            public Builder clearNotiId() {
                this.result.hasNotiId = false;
                this.result.notiId_ = NotiElement.getDefaultInstance().getNotiId();
                return this;
            }

            public Builder clearReliableLevel() {
                this.result.hasReliableLevel = false;
                this.result.reliableLevel_ = 0;
                return this;
            }

            public Builder clearSender() {
                this.result.hasSender = false;
                this.result.sender_ = NotiElement.getDefaultInstance().getSender();
                return this;
            }

            public Builder clearSessionInfo() {
                this.result.hasSessionInfo = false;
                this.result.sessionInfo_ = NotiElement.getDefaultInstance().getSessionInfo();
                return this;
            }

            public Builder clearTimeStamp() {
                this.result.hasTimeStamp = false;
                this.result.timeStamp_ = 0L;
                return this;
            }

            public Builder clearType() {
                this.result.hasType = false;
                this.result.type_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo4397clone() {
                return create().mergeFrom(this.result);
            }

            public String getAppData() {
                return this.result.getAppData();
            }

            public String getAppId() {
                return this.result.getAppId();
            }

            public int getConnectionTerm() {
                return this.result.getConnectionTerm();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: getDefaultInstanceForType */
            public NotiElement mo4403getDefaultInstanceForType() {
                return NotiElement.getDefaultInstance();
            }

            public String getMessage() {
                return this.result.getMessage();
            }

            public String getNotiId() {
                return this.result.getNotiId();
            }

            public int getReliableLevel() {
                return this.result.getReliableLevel();
            }

            public String getSender() {
                return this.result.getSender();
            }

            public String getSessionInfo() {
                return this.result.getSessionInfo();
            }

            public long getTimeStamp() {
                return this.result.getTimeStamp();
            }

            public int getType() {
                return this.result.getType();
            }

            public boolean hasAppData() {
                return this.result.hasAppData();
            }

            public boolean hasAppId() {
                return this.result.hasAppId();
            }

            public boolean hasConnectionTerm() {
                return this.result.hasConnectionTerm();
            }

            public boolean hasMessage() {
                return this.result.hasMessage();
            }

            public boolean hasNotiId() {
                return this.result.hasNotiId();
            }

            public boolean hasReliableLevel() {
                return this.result.hasReliableLevel();
            }

            public boolean hasSender() {
                return this.result.hasSender();
            }

            public boolean hasSessionInfo() {
                return this.result.hasSessionInfo();
            }

            public boolean hasTimeStamp() {
                return this.result.hasTimeStamp();
            }

            public boolean hasType() {
                return this.result.hasType();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public NotiElement internalGetResult() {
                return this.result;
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                            setNotiId(codedInputStream.m287f());
                            break;
                        case 18:
                            setAppId(codedInputStream.m287f());
                            break;
                        case 24:
                            setReliableLevel(codedInputStream.m283d());
                            break;
                        case 32:
                            setType(codedInputStream.m283d());
                            break;
                        case 42:
                            setSender(codedInputStream.m287f());
                            break;
                        case 50:
                            setMessage(codedInputStream.m287f());
                            break;
                        case 58:
                            setAppData(codedInputStream.m287f());
                            break;
                        case 88:
                            setTimeStamp(codedInputStream.m282c());
                            break;
                        case 96:
                            setConnectionTerm(codedInputStream.m283d());
                            break;
                        case 106:
                            setSessionInfo(codedInputStream.m287f());
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
            public Builder mergeFrom(NotiElement notiElement) {
                if (notiElement == NotiElement.getDefaultInstance()) {
                    return this;
                }
                if (notiElement.hasNotiId()) {
                    setNotiId(notiElement.getNotiId());
                }
                if (notiElement.hasAppId()) {
                    setAppId(notiElement.getAppId());
                }
                if (notiElement.hasReliableLevel()) {
                    setReliableLevel(notiElement.getReliableLevel());
                }
                if (notiElement.hasType()) {
                    setType(notiElement.getType());
                }
                if (notiElement.hasSender()) {
                    setSender(notiElement.getSender());
                }
                if (notiElement.hasMessage()) {
                    setMessage(notiElement.getMessage());
                }
                if (notiElement.hasAppData()) {
                    setAppData(notiElement.getAppData());
                }
                if (notiElement.hasTimeStamp()) {
                    setTimeStamp(notiElement.getTimeStamp());
                }
                if (notiElement.hasConnectionTerm()) {
                    setConnectionTerm(notiElement.getConnectionTerm());
                }
                if (notiElement.hasSessionInfo()) {
                    setSessionInfo(notiElement.getSessionInfo());
                }
                return this;
            }

            public Builder setAppData(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasAppData = true;
                this.result.appData_ = str;
                return this;
            }

            public Builder setAppId(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasAppId = true;
                this.result.appId_ = str;
                return this;
            }

            public Builder setConnectionTerm(int i) {
                this.result.hasConnectionTerm = true;
                this.result.connectionTerm_ = i;
                return this;
            }

            public Builder setMessage(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasMessage = true;
                this.result.message_ = str;
                return this;
            }

            public Builder setNotiId(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasNotiId = true;
                this.result.notiId_ = str;
                return this;
            }

            public Builder setReliableLevel(int i) {
                this.result.hasReliableLevel = true;
                this.result.reliableLevel_ = i;
                return this;
            }

            public Builder setSender(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasSender = true;
                this.result.sender_ = str;
                return this;
            }

            public Builder setSessionInfo(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasSessionInfo = true;
                this.result.sessionInfo_ = str;
                return this;
            }

            public Builder setTimeStamp(long j) {
                this.result.hasTimeStamp = true;
                this.result.timeStamp_ = j;
                return this;
            }

            public Builder setType(int i) {
                this.result.hasType = true;
                this.result.type_ = i;
                return this;
            }
        }

        static {
            MsgFrontend.internalForceInit();
            defaultInstance.initFields();
        }

        private NotiElement() {
            this.notiId_ = "";
            this.appId_ = "";
            this.reliableLevel_ = 0;
            this.type_ = 0;
            this.sender_ = "";
            this.message_ = "";
            this.appData_ = "";
            this.timeStamp_ = 0L;
            this.connectionTerm_ = 0;
            this.sessionInfo_ = "";
            this.memoizedSerializedSize = -1;
            initFields();
        }

        private NotiElement(boolean z) {
            this.notiId_ = "";
            this.appId_ = "";
            this.reliableLevel_ = 0;
            this.type_ = 0;
            this.sender_ = "";
            this.message_ = "";
            this.appData_ = "";
            this.timeStamp_ = 0L;
            this.connectionTerm_ = 0;
            this.sessionInfo_ = "";
            this.memoizedSerializedSize = -1;
        }

        public static NotiElement getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(NotiElement notiElement) {
            return newBuilder().mergeFrom(notiElement);
        }

        public static NotiElement parseDelimitedFrom(InputStream inputStream) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static NotiElement parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream, extensionRegistryLite)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static NotiElement parseFrom(ByteString byteString) {
            return ((Builder) newBuilder().m4398mergeFrom(byteString)).buildParsed();
        }

        public static NotiElement parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4399mergeFrom(byteString, extensionRegistryLite)).buildParsed();
        }

        public static NotiElement parseFrom(CodedInputStream codedInputStream) {
            return ((Builder) newBuilder().m4400mergeFrom(codedInputStream)).buildParsed();
        }

        public static NotiElement parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return newBuilder().mergeFrom(codedInputStream, extensionRegistryLite).buildParsed();
        }

        public static NotiElement parseFrom(InputStream inputStream) {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        public static NotiElement parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().mergeFrom(inputStream, extensionRegistryLite)).buildParsed();
        }

        public static NotiElement parseFrom(byte[] bArr) {
            return ((Builder) newBuilder().m4401mergeFrom(bArr)).buildParsed();
        }

        public static NotiElement parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4402mergeFrom(bArr, extensionRegistryLite)).buildParsed();
        }

        public String getAppData() {
            return this.appData_;
        }

        public String getAppId() {
            return this.appId_;
        }

        public int getConnectionTerm() {
            return this.connectionTerm_;
        }

        @Override // com.google.protobuf.MessageLite
        public NotiElement getDefaultInstanceForType() {
            return defaultInstance;
        }

        public String getMessage() {
            return this.message_;
        }

        public String getNotiId() {
            return this.notiId_;
        }

        public int getReliableLevel() {
            return this.reliableLevel_;
        }

        public String getSender() {
            return this.sender_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM303b = this.memoizedSerializedSize;
            if (iM303b == -1) {
                iM303b = hasNotiId() ? 0 + CodedOutputStream.m303b(1, getNotiId()) : 0;
                if (hasAppId()) {
                    iM303b += CodedOutputStream.m303b(2, getAppId());
                }
                if (hasReliableLevel()) {
                    iM303b += CodedOutputStream.m309c(3, getReliableLevel());
                }
                if (hasType()) {
                    iM303b += CodedOutputStream.m309c(4, getType());
                }
                if (hasSender()) {
                    iM303b += CodedOutputStream.m303b(5, getSender());
                }
                if (hasMessage()) {
                    iM303b += CodedOutputStream.m303b(6, getMessage());
                }
                if (hasAppData()) {
                    iM303b += CodedOutputStream.m303b(7, getAppData());
                }
                if (hasTimeStamp()) {
                    iM303b += CodedOutputStream.m301b(11, getTimeStamp());
                }
                if (hasConnectionTerm()) {
                    iM303b += CodedOutputStream.m309c(12, getConnectionTerm());
                }
                if (hasSessionInfo()) {
                    iM303b += CodedOutputStream.m303b(13, getSessionInfo());
                }
                this.memoizedSerializedSize = iM303b;
            }
            return iM303b;
        }

        public String getSessionInfo() {
            return this.sessionInfo_;
        }

        public long getTimeStamp() {
            return this.timeStamp_;
        }

        public int getType() {
            return this.type_;
        }

        public boolean hasAppData() {
            return this.hasAppData;
        }

        public boolean hasAppId() {
            return this.hasAppId;
        }

        public boolean hasConnectionTerm() {
            return this.hasConnectionTerm;
        }

        public boolean hasMessage() {
            return this.hasMessage;
        }

        public boolean hasNotiId() {
            return this.hasNotiId;
        }

        public boolean hasReliableLevel() {
            return this.hasReliableLevel;
        }

        public boolean hasSender() {
            return this.hasSender;
        }

        public boolean hasSessionInfo() {
            return this.hasSessionInfo;
        }

        public boolean hasTimeStamp() {
            return this.hasTimeStamp;
        }

        public boolean hasType() {
            return this.hasType;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (hasNotiId()) {
                codedOutputStream.m322a(1, getNotiId());
            }
            if (hasAppId()) {
                codedOutputStream.m322a(2, getAppId());
            }
            if (hasReliableLevel()) {
                codedOutputStream.m319a(3, getReliableLevel());
            }
            if (hasType()) {
                codedOutputStream.m319a(4, getType());
            }
            if (hasSender()) {
                codedOutputStream.m322a(5, getSender());
            }
            if (hasMessage()) {
                codedOutputStream.m322a(6, getMessage());
            }
            if (hasAppData()) {
                codedOutputStream.m322a(7, getAppData());
            }
            if (hasTimeStamp()) {
                codedOutputStream.m320a(11, getTimeStamp());
            }
            if (hasConnectionTerm()) {
                codedOutputStream.m319a(12, getConnectionTerm());
            }
            if (hasSessionInfo()) {
                codedOutputStream.m322a(13, getSessionInfo());
            }
        }
    }

    public final class NotiGroup extends GeneratedMessageLite {
        public static final int NOTI_ELEMENTS_FIELD_NUMBER = 1;
        private static final NotiGroup defaultInstance = new NotiGroup(true);
        private int memoizedSerializedSize;
        private List notiElements_;

        public final class Builder extends GeneratedMessageLite.Builder {
            private NotiGroup result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public NotiGroup buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).m350a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new NotiGroup();
                return builder;
            }

            public Builder addAllNotiElements(Iterable iterable) {
                if (this.result.notiElements_.isEmpty()) {
                    this.result.notiElements_ = new ArrayList();
                }
                GeneratedMessageLite.Builder.addAll(iterable, this.result.notiElements_);
                return this;
            }

            public Builder addNotiElements(NotiElement.Builder builder) {
                if (this.result.notiElements_.isEmpty()) {
                    this.result.notiElements_ = new ArrayList();
                }
                this.result.notiElements_.add(builder.build());
                return this;
            }

            public Builder addNotiElements(NotiElement notiElement) {
                if (notiElement == null) {
                    throw new NullPointerException();
                }
                if (this.result.notiElements_.isEmpty()) {
                    this.result.notiElements_ = new ArrayList();
                }
                this.result.notiElements_.add(notiElement);
                return this;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            public NotiGroup build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            public NotiGroup buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                if (this.result.notiElements_ != Collections.EMPTY_LIST) {
                    this.result.notiElements_ = Collections.unmodifiableList(this.result.notiElements_);
                }
                NotiGroup notiGroup = this.result;
                this.result = null;
                return notiGroup;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new NotiGroup();
                return this;
            }

            public Builder clearNotiElements() {
                this.result.notiElements_ = Collections.emptyList();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo4397clone() {
                return create().mergeFrom(this.result);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: getDefaultInstanceForType */
            public NotiGroup mo4403getDefaultInstanceForType() {
                return NotiGroup.getDefaultInstance();
            }

            public NotiElement getNotiElements(int i) {
                return this.result.getNotiElements(i);
            }

            public int getNotiElementsCount() {
                return this.result.getNotiElementsCount();
            }

            public List getNotiElementsList() {
                return Collections.unmodifiableList(this.result.notiElements_);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public NotiGroup internalGetResult() {
                return this.result;
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case MsgFrontendCommon.__NotiAcks__ /* 10 */:
                            NotiElement.Builder builderNewBuilder = NotiElement.newBuilder();
                            codedInputStream.m278a(builderNewBuilder, extensionRegistryLite);
                            addNotiElements(builderNewBuilder.buildPartial());
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
            public Builder mergeFrom(NotiGroup notiGroup) {
                if (notiGroup == NotiGroup.getDefaultInstance()) {
                    return this;
                }
                if (!notiGroup.notiElements_.isEmpty()) {
                    if (this.result.notiElements_.isEmpty()) {
                        this.result.notiElements_ = new ArrayList();
                    }
                    this.result.notiElements_.addAll(notiGroup.notiElements_);
                }
                return this;
            }

            public Builder setNotiElements(int i, NotiElement.Builder builder) {
                this.result.notiElements_.set(i, builder.build());
                return this;
            }

            public Builder setNotiElements(int i, NotiElement notiElement) {
                if (notiElement == null) {
                    throw new NullPointerException();
                }
                this.result.notiElements_.set(i, notiElement);
                return this;
            }
        }

        static {
            MsgFrontend.internalForceInit();
            defaultInstance.initFields();
        }

        private NotiGroup() {
            this.notiElements_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
            initFields();
        }

        private NotiGroup(boolean z) {
            this.notiElements_ = Collections.emptyList();
            this.memoizedSerializedSize = -1;
        }

        public static NotiGroup getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(NotiGroup notiGroup) {
            return newBuilder().mergeFrom(notiGroup);
        }

        public static NotiGroup parseDelimitedFrom(InputStream inputStream) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static NotiGroup parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream, extensionRegistryLite)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static NotiGroup parseFrom(ByteString byteString) {
            return ((Builder) newBuilder().m4398mergeFrom(byteString)).buildParsed();
        }

        public static NotiGroup parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4399mergeFrom(byteString, extensionRegistryLite)).buildParsed();
        }

        public static NotiGroup parseFrom(CodedInputStream codedInputStream) {
            return ((Builder) newBuilder().m4400mergeFrom(codedInputStream)).buildParsed();
        }

        public static NotiGroup parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return newBuilder().mergeFrom(codedInputStream, extensionRegistryLite).buildParsed();
        }

        public static NotiGroup parseFrom(InputStream inputStream) {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        public static NotiGroup parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().mergeFrom(inputStream, extensionRegistryLite)).buildParsed();
        }

        public static NotiGroup parseFrom(byte[] bArr) {
            return ((Builder) newBuilder().m4401mergeFrom(bArr)).buildParsed();
        }

        public static NotiGroup parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4402mergeFrom(bArr, extensionRegistryLite)).buildParsed();
        }

        @Override // com.google.protobuf.MessageLite
        public NotiGroup getDefaultInstanceForType() {
            return defaultInstance;
        }

        public NotiElement getNotiElements(int i) {
            return (NotiElement) this.notiElements_.get(i);
        }

        public int getNotiElementsCount() {
            return this.notiElements_.size();
        }

        public List getNotiElementsList() {
            return this.notiElements_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iM302b = 0;
            Iterator it = getNotiElementsList().iterator();
            while (true) {
                int i2 = iM302b;
                if (!it.hasNext()) {
                    this.memoizedSerializedSize = i2;
                    return i2;
                }
                iM302b = CodedOutputStream.m302b(1, (NotiElement) it.next()) + i2;
            }
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            Iterator it = getNotiElementsList().iterator();
            while (it.hasNext()) {
                codedOutputStream.m321a(1, (NotiElement) it.next());
            }
        }
    }

    public final class PingReply extends GeneratedMessageLite {
        public static final int ASYNC_ID_FIELD_NUMBER = 1;
        public static final int CREATED_TIME_FIELD_NUMBER = 2;
        public static final int DELTA_FIELD_NUMBER = 3;
        private static final PingReply defaultInstance = new PingReply(true);
        private int asyncId_;
        private long createdTime_;
        private int delta_;
        private boolean hasAsyncId;
        private boolean hasCreatedTime;
        private boolean hasDelta;
        private int memoizedSerializedSize;

        public final class Builder extends GeneratedMessageLite.Builder {
            private PingReply result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public PingReply buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).m350a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new PingReply();
                return builder;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            public PingReply build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            public PingReply buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                PingReply pingReply = this.result;
                this.result = null;
                return pingReply;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new PingReply();
                return this;
            }

            public Builder clearAsyncId() {
                this.result.hasAsyncId = false;
                this.result.asyncId_ = 0;
                return this;
            }

            public Builder clearCreatedTime() {
                this.result.hasCreatedTime = false;
                this.result.createdTime_ = 0L;
                return this;
            }

            public Builder clearDelta() {
                this.result.hasDelta = false;
                this.result.delta_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo4397clone() {
                return create().mergeFrom(this.result);
            }

            public int getAsyncId() {
                return this.result.getAsyncId();
            }

            public long getCreatedTime() {
                return this.result.getCreatedTime();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: getDefaultInstanceForType */
            public PingReply mo4403getDefaultInstanceForType() {
                return PingReply.getDefaultInstance();
            }

            public int getDelta() {
                return this.result.getDelta();
            }

            public boolean hasAsyncId() {
                return this.result.hasAsyncId();
            }

            public boolean hasCreatedTime() {
                return this.result.hasCreatedTime();
            }

            public boolean hasDelta() {
                return this.result.hasDelta();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public PingReply internalGetResult() {
                return this.result;
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            setAsyncId(codedInputStream.m283d());
                            break;
                        case 16:
                            setCreatedTime(codedInputStream.m282c());
                            break;
                        case 24:
                            setDelta(codedInputStream.m283d());
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
            public Builder mergeFrom(PingReply pingReply) {
                if (pingReply == PingReply.getDefaultInstance()) {
                    return this;
                }
                if (pingReply.hasAsyncId()) {
                    setAsyncId(pingReply.getAsyncId());
                }
                if (pingReply.hasCreatedTime()) {
                    setCreatedTime(pingReply.getCreatedTime());
                }
                if (pingReply.hasDelta()) {
                    setDelta(pingReply.getDelta());
                }
                return this;
            }

            public Builder setAsyncId(int i) {
                this.result.hasAsyncId = true;
                this.result.asyncId_ = i;
                return this;
            }

            public Builder setCreatedTime(long j) {
                this.result.hasCreatedTime = true;
                this.result.createdTime_ = j;
                return this;
            }

            public Builder setDelta(int i) {
                this.result.hasDelta = true;
                this.result.delta_ = i;
                return this;
            }
        }

        static {
            MsgFrontend.internalForceInit();
            defaultInstance.initFields();
        }

        private PingReply() {
            this.asyncId_ = 0;
            this.createdTime_ = 0L;
            this.delta_ = 0;
            this.memoizedSerializedSize = -1;
            initFields();
        }

        private PingReply(boolean z) {
            this.asyncId_ = 0;
            this.createdTime_ = 0L;
            this.delta_ = 0;
            this.memoizedSerializedSize = -1;
        }

        public static PingReply getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(PingReply pingReply) {
            return newBuilder().mergeFrom(pingReply);
        }

        public static PingReply parseDelimitedFrom(InputStream inputStream) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static PingReply parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream, extensionRegistryLite)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static PingReply parseFrom(ByteString byteString) {
            return ((Builder) newBuilder().m4398mergeFrom(byteString)).buildParsed();
        }

        public static PingReply parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4399mergeFrom(byteString, extensionRegistryLite)).buildParsed();
        }

        public static PingReply parseFrom(CodedInputStream codedInputStream) {
            return ((Builder) newBuilder().m4400mergeFrom(codedInputStream)).buildParsed();
        }

        public static PingReply parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return newBuilder().mergeFrom(codedInputStream, extensionRegistryLite).buildParsed();
        }

        public static PingReply parseFrom(InputStream inputStream) {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        public static PingReply parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().mergeFrom(inputStream, extensionRegistryLite)).buildParsed();
        }

        public static PingReply parseFrom(byte[] bArr) {
            return ((Builder) newBuilder().m4401mergeFrom(bArr)).buildParsed();
        }

        public static PingReply parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4402mergeFrom(bArr, extensionRegistryLite)).buildParsed();
        }

        public int getAsyncId() {
            return this.asyncId_;
        }

        public long getCreatedTime() {
            return this.createdTime_;
        }

        @Override // com.google.protobuf.MessageLite
        public PingReply getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getDelta() {
            return this.delta_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM309c = this.memoizedSerializedSize;
            if (iM309c == -1) {
                iM309c = hasAsyncId() ? 0 + CodedOutputStream.m309c(1, getAsyncId()) : 0;
                if (hasCreatedTime()) {
                    iM309c += CodedOutputStream.m301b(2, getCreatedTime());
                }
                if (hasDelta()) {
                    iM309c += CodedOutputStream.m309c(3, getDelta());
                }
                this.memoizedSerializedSize = iM309c;
            }
            return iM309c;
        }

        public boolean hasAsyncId() {
            return this.hasAsyncId;
        }

        public boolean hasCreatedTime() {
            return this.hasCreatedTime;
        }

        public boolean hasDelta() {
            return this.hasDelta;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (hasAsyncId()) {
                codedOutputStream.m319a(1, getAsyncId());
            }
            if (hasCreatedTime()) {
                codedOutputStream.m320a(2, getCreatedTime());
            }
            if (hasDelta()) {
                codedOutputStream.m319a(3, getDelta());
            }
        }
    }

    public final class PingRequest extends GeneratedMessageLite {
        public static final int ASYNC_ID_FIELD_NUMBER = 1;
        public static final int CREATED_TIME_FIELD_NUMBER = 2;
        public static final int INTERVAL_FIELD_NUMBER = 3;
        private static final PingRequest defaultInstance = new PingRequest(true);
        private int asyncId_;
        private long createdTime_;
        private boolean hasAsyncId;
        private boolean hasCreatedTime;
        private boolean hasInterval;
        private int interval_;
        private int memoizedSerializedSize;

        public final class Builder extends GeneratedMessageLite.Builder {
            private PingRequest result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public PingRequest buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).m350a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new PingRequest();
                return builder;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            public PingRequest build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            public PingRequest buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                PingRequest pingRequest = this.result;
                this.result = null;
                return pingRequest;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new PingRequest();
                return this;
            }

            public Builder clearAsyncId() {
                this.result.hasAsyncId = false;
                this.result.asyncId_ = 0;
                return this;
            }

            public Builder clearCreatedTime() {
                this.result.hasCreatedTime = false;
                this.result.createdTime_ = 0L;
                return this;
            }

            public Builder clearInterval() {
                this.result.hasInterval = false;
                this.result.interval_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo4397clone() {
                return create().mergeFrom(this.result);
            }

            public int getAsyncId() {
                return this.result.getAsyncId();
            }

            public long getCreatedTime() {
                return this.result.getCreatedTime();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: getDefaultInstanceForType */
            public PingRequest mo4403getDefaultInstanceForType() {
                return PingRequest.getDefaultInstance();
            }

            public int getInterval() {
                return this.result.getInterval();
            }

            public boolean hasAsyncId() {
                return this.result.hasAsyncId();
            }

            public boolean hasCreatedTime() {
                return this.result.hasCreatedTime();
            }

            public boolean hasInterval() {
                return this.result.hasInterval();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public PingRequest internalGetResult() {
                return this.result;
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            setAsyncId(codedInputStream.m283d());
                            break;
                        case 16:
                            setCreatedTime(codedInputStream.m282c());
                            break;
                        case 24:
                            setInterval(codedInputStream.m283d());
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
            public Builder mergeFrom(PingRequest pingRequest) {
                if (pingRequest == PingRequest.getDefaultInstance()) {
                    return this;
                }
                if (pingRequest.hasAsyncId()) {
                    setAsyncId(pingRequest.getAsyncId());
                }
                if (pingRequest.hasCreatedTime()) {
                    setCreatedTime(pingRequest.getCreatedTime());
                }
                if (pingRequest.hasInterval()) {
                    setInterval(pingRequest.getInterval());
                }
                return this;
            }

            public Builder setAsyncId(int i) {
                this.result.hasAsyncId = true;
                this.result.asyncId_ = i;
                return this;
            }

            public Builder setCreatedTime(long j) {
                this.result.hasCreatedTime = true;
                this.result.createdTime_ = j;
                return this;
            }

            public Builder setInterval(int i) {
                this.result.hasInterval = true;
                this.result.interval_ = i;
                return this;
            }
        }

        static {
            MsgFrontend.internalForceInit();
            defaultInstance.initFields();
        }

        private PingRequest() {
            this.asyncId_ = 0;
            this.createdTime_ = 0L;
            this.interval_ = 0;
            this.memoizedSerializedSize = -1;
            initFields();
        }

        private PingRequest(boolean z) {
            this.asyncId_ = 0;
            this.createdTime_ = 0L;
            this.interval_ = 0;
            this.memoizedSerializedSize = -1;
        }

        public static PingRequest getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(PingRequest pingRequest) {
            return newBuilder().mergeFrom(pingRequest);
        }

        public static PingRequest parseDelimitedFrom(InputStream inputStream) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static PingRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream, extensionRegistryLite)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static PingRequest parseFrom(ByteString byteString) {
            return ((Builder) newBuilder().m4398mergeFrom(byteString)).buildParsed();
        }

        public static PingRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4399mergeFrom(byteString, extensionRegistryLite)).buildParsed();
        }

        public static PingRequest parseFrom(CodedInputStream codedInputStream) {
            return ((Builder) newBuilder().m4400mergeFrom(codedInputStream)).buildParsed();
        }

        public static PingRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return newBuilder().mergeFrom(codedInputStream, extensionRegistryLite).buildParsed();
        }

        public static PingRequest parseFrom(InputStream inputStream) {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        public static PingRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().mergeFrom(inputStream, extensionRegistryLite)).buildParsed();
        }

        public static PingRequest parseFrom(byte[] bArr) {
            return ((Builder) newBuilder().m4401mergeFrom(bArr)).buildParsed();
        }

        public static PingRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4402mergeFrom(bArr, extensionRegistryLite)).buildParsed();
        }

        public int getAsyncId() {
            return this.asyncId_;
        }

        public long getCreatedTime() {
            return this.createdTime_;
        }

        @Override // com.google.protobuf.MessageLite
        public PingRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public int getInterval() {
            return this.interval_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM309c = this.memoizedSerializedSize;
            if (iM309c == -1) {
                iM309c = hasAsyncId() ? 0 + CodedOutputStream.m309c(1, getAsyncId()) : 0;
                if (hasCreatedTime()) {
                    iM309c += CodedOutputStream.m301b(2, getCreatedTime());
                }
                if (hasInterval()) {
                    iM309c += CodedOutputStream.m309c(3, getInterval());
                }
                this.memoizedSerializedSize = iM309c;
            }
            return iM309c;
        }

        public boolean hasAsyncId() {
            return this.hasAsyncId;
        }

        public boolean hasCreatedTime() {
            return this.hasCreatedTime;
        }

        public boolean hasInterval() {
            return this.hasInterval;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (hasAsyncId()) {
                codedOutputStream.m319a(1, getAsyncId());
            }
            if (hasCreatedTime()) {
                codedOutputStream.m320a(2, getCreatedTime());
            }
            if (hasInterval()) {
                codedOutputStream.m319a(3, getInterval());
            }
        }
    }

    public final class ProvisionReply extends GeneratedMessageLite {
        public static final int DEVICE_TOKEN_FIELD_NUMBER = 3;
        public static final int PING_INTERVAL_FIELD_NUMBER = 8;
        public static final int PRIMARY_IP_FIELD_NUMBER = 4;
        public static final int PRIMARY_PORT_FIELD_NUMBER = 5;
        public static final int RESULT_CODE_FIELD_NUMBER = 2;
        public static final int SECONDARY_IP_FIELD_NUMBER = 6;
        public static final int SECONDARY_PORT_FIELD_NUMBER = 7;
        public static final int USER_DATA_FIELD_NUMBER = 9;
        private static final ProvisionReply defaultInstance = new ProvisionReply(true);
        private String deviceToken_;
        private boolean hasDeviceToken;
        private boolean hasPingInterval;
        private boolean hasPrimaryIp;
        private boolean hasPrimaryPort;
        private boolean hasResultCode;
        private boolean hasSecondaryIp;
        private boolean hasSecondaryPort;
        private boolean hasUserData;
        private int memoizedSerializedSize;
        private int pingInterval_;
        private String primaryIp_;
        private int primaryPort_;
        private int resultCode_;
        private String secondaryIp_;
        private int secondaryPort_;
        private String userData_;

        public final class Builder extends GeneratedMessageLite.Builder {
            private ProvisionReply result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public ProvisionReply buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).m350a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new ProvisionReply();
                return builder;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            public ProvisionReply build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            public ProvisionReply buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                ProvisionReply provisionReply = this.result;
                this.result = null;
                return provisionReply;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new ProvisionReply();
                return this;
            }

            public Builder clearDeviceToken() {
                this.result.hasDeviceToken = false;
                this.result.deviceToken_ = ProvisionReply.getDefaultInstance().getDeviceToken();
                return this;
            }

            public Builder clearPingInterval() {
                this.result.hasPingInterval = false;
                this.result.pingInterval_ = 0;
                return this;
            }

            public Builder clearPrimaryIp() {
                this.result.hasPrimaryIp = false;
                this.result.primaryIp_ = ProvisionReply.getDefaultInstance().getPrimaryIp();
                return this;
            }

            public Builder clearPrimaryPort() {
                this.result.hasPrimaryPort = false;
                this.result.primaryPort_ = 0;
                return this;
            }

            public Builder clearResultCode() {
                this.result.hasResultCode = false;
                this.result.resultCode_ = 0;
                return this;
            }

            public Builder clearSecondaryIp() {
                this.result.hasSecondaryIp = false;
                this.result.secondaryIp_ = ProvisionReply.getDefaultInstance().getSecondaryIp();
                return this;
            }

            public Builder clearSecondaryPort() {
                this.result.hasSecondaryPort = false;
                this.result.secondaryPort_ = 0;
                return this;
            }

            public Builder clearUserData() {
                this.result.hasUserData = false;
                this.result.userData_ = ProvisionReply.getDefaultInstance().getUserData();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo4397clone() {
                return create().mergeFrom(this.result);
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: getDefaultInstanceForType */
            public ProvisionReply mo4403getDefaultInstanceForType() {
                return ProvisionReply.getDefaultInstance();
            }

            public String getDeviceToken() {
                return this.result.getDeviceToken();
            }

            public int getPingInterval() {
                return this.result.getPingInterval();
            }

            public String getPrimaryIp() {
                return this.result.getPrimaryIp();
            }

            public int getPrimaryPort() {
                return this.result.getPrimaryPort();
            }

            public int getResultCode() {
                return this.result.getResultCode();
            }

            public String getSecondaryIp() {
                return this.result.getSecondaryIp();
            }

            public int getSecondaryPort() {
                return this.result.getSecondaryPort();
            }

            public String getUserData() {
                return this.result.getUserData();
            }

            public boolean hasDeviceToken() {
                return this.result.hasDeviceToken();
            }

            public boolean hasPingInterval() {
                return this.result.hasPingInterval();
            }

            public boolean hasPrimaryIp() {
                return this.result.hasPrimaryIp();
            }

            public boolean hasPrimaryPort() {
                return this.result.hasPrimaryPort();
            }

            public boolean hasResultCode() {
                return this.result.hasResultCode();
            }

            public boolean hasSecondaryIp() {
                return this.result.hasSecondaryIp();
            }

            public boolean hasSecondaryPort() {
                return this.result.hasSecondaryPort();
            }

            public boolean hasUserData() {
                return this.result.hasUserData();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public ProvisionReply internalGetResult() {
                return this.result;
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 16:
                            setResultCode(codedInputStream.m283d());
                            break;
                        case 26:
                            setDeviceToken(codedInputStream.m287f());
                            break;
                        case 34:
                            setPrimaryIp(codedInputStream.m287f());
                            break;
                        case 40:
                            setPrimaryPort(codedInputStream.m283d());
                            break;
                        case 50:
                            setSecondaryIp(codedInputStream.m287f());
                            break;
                        case 56:
                            setSecondaryPort(codedInputStream.m283d());
                            break;
                        case 64:
                            setPingInterval(codedInputStream.m283d());
                            break;
                        case 74:
                            setUserData(codedInputStream.m287f());
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
            public Builder mergeFrom(ProvisionReply provisionReply) {
                if (provisionReply == ProvisionReply.getDefaultInstance()) {
                    return this;
                }
                if (provisionReply.hasResultCode()) {
                    setResultCode(provisionReply.getResultCode());
                }
                if (provisionReply.hasDeviceToken()) {
                    setDeviceToken(provisionReply.getDeviceToken());
                }
                if (provisionReply.hasPrimaryIp()) {
                    setPrimaryIp(provisionReply.getPrimaryIp());
                }
                if (provisionReply.hasPrimaryPort()) {
                    setPrimaryPort(provisionReply.getPrimaryPort());
                }
                if (provisionReply.hasSecondaryIp()) {
                    setSecondaryIp(provisionReply.getSecondaryIp());
                }
                if (provisionReply.hasSecondaryPort()) {
                    setSecondaryPort(provisionReply.getSecondaryPort());
                }
                if (provisionReply.hasPingInterval()) {
                    setPingInterval(provisionReply.getPingInterval());
                }
                if (provisionReply.hasUserData()) {
                    setUserData(provisionReply.getUserData());
                }
                return this;
            }

            public Builder setDeviceToken(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasDeviceToken = true;
                this.result.deviceToken_ = str;
                return this;
            }

            public Builder setPingInterval(int i) {
                this.result.hasPingInterval = true;
                this.result.pingInterval_ = i;
                return this;
            }

            public Builder setPrimaryIp(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasPrimaryIp = true;
                this.result.primaryIp_ = str;
                return this;
            }

            public Builder setPrimaryPort(int i) {
                this.result.hasPrimaryPort = true;
                this.result.primaryPort_ = i;
                return this;
            }

            public Builder setResultCode(int i) {
                this.result.hasResultCode = true;
                this.result.resultCode_ = i;
                return this;
            }

            public Builder setSecondaryIp(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasSecondaryIp = true;
                this.result.secondaryIp_ = str;
                return this;
            }

            public Builder setSecondaryPort(int i) {
                this.result.hasSecondaryPort = true;
                this.result.secondaryPort_ = i;
                return this;
            }

            public Builder setUserData(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasUserData = true;
                this.result.userData_ = str;
                return this;
            }
        }

        static {
            MsgFrontend.internalForceInit();
            defaultInstance.initFields();
        }

        private ProvisionReply() {
            this.resultCode_ = 0;
            this.deviceToken_ = "";
            this.primaryIp_ = "";
            this.primaryPort_ = 0;
            this.secondaryIp_ = "";
            this.secondaryPort_ = 0;
            this.pingInterval_ = 0;
            this.userData_ = "";
            this.memoizedSerializedSize = -1;
            initFields();
        }

        private ProvisionReply(boolean z) {
            this.resultCode_ = 0;
            this.deviceToken_ = "";
            this.primaryIp_ = "";
            this.primaryPort_ = 0;
            this.secondaryIp_ = "";
            this.secondaryPort_ = 0;
            this.pingInterval_ = 0;
            this.userData_ = "";
            this.memoizedSerializedSize = -1;
        }

        public static ProvisionReply getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(ProvisionReply provisionReply) {
            return newBuilder().mergeFrom(provisionReply);
        }

        public static ProvisionReply parseDelimitedFrom(InputStream inputStream) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static ProvisionReply parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream, extensionRegistryLite)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static ProvisionReply parseFrom(ByteString byteString) {
            return ((Builder) newBuilder().m4398mergeFrom(byteString)).buildParsed();
        }

        public static ProvisionReply parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4399mergeFrom(byteString, extensionRegistryLite)).buildParsed();
        }

        public static ProvisionReply parseFrom(CodedInputStream codedInputStream) {
            return ((Builder) newBuilder().m4400mergeFrom(codedInputStream)).buildParsed();
        }

        public static ProvisionReply parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return newBuilder().mergeFrom(codedInputStream, extensionRegistryLite).buildParsed();
        }

        public static ProvisionReply parseFrom(InputStream inputStream) {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        public static ProvisionReply parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().mergeFrom(inputStream, extensionRegistryLite)).buildParsed();
        }

        public static ProvisionReply parseFrom(byte[] bArr) {
            return ((Builder) newBuilder().m4401mergeFrom(bArr)).buildParsed();
        }

        public static ProvisionReply parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4402mergeFrom(bArr, extensionRegistryLite)).buildParsed();
        }

        @Override // com.google.protobuf.MessageLite
        public ProvisionReply getDefaultInstanceForType() {
            return defaultInstance;
        }

        public String getDeviceToken() {
            return this.deviceToken_;
        }

        public int getPingInterval() {
            return this.pingInterval_;
        }

        public String getPrimaryIp() {
            return this.primaryIp_;
        }

        public int getPrimaryPort() {
            return this.primaryPort_;
        }

        public int getResultCode() {
            return this.resultCode_;
        }

        public String getSecondaryIp() {
            return this.secondaryIp_;
        }

        public int getSecondaryPort() {
            return this.secondaryPort_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM309c = this.memoizedSerializedSize;
            if (iM309c == -1) {
                iM309c = hasResultCode() ? 0 + CodedOutputStream.m309c(2, getResultCode()) : 0;
                if (hasDeviceToken()) {
                    iM309c += CodedOutputStream.m303b(3, getDeviceToken());
                }
                if (hasPrimaryIp()) {
                    iM309c += CodedOutputStream.m303b(4, getPrimaryIp());
                }
                if (hasPrimaryPort()) {
                    iM309c += CodedOutputStream.m309c(5, getPrimaryPort());
                }
                if (hasSecondaryIp()) {
                    iM309c += CodedOutputStream.m303b(6, getSecondaryIp());
                }
                if (hasSecondaryPort()) {
                    iM309c += CodedOutputStream.m309c(7, getSecondaryPort());
                }
                if (hasPingInterval()) {
                    iM309c += CodedOutputStream.m309c(8, getPingInterval());
                }
                if (hasUserData()) {
                    iM309c += CodedOutputStream.m303b(9, getUserData());
                }
                this.memoizedSerializedSize = iM309c;
            }
            return iM309c;
        }

        public String getUserData() {
            return this.userData_;
        }

        public boolean hasDeviceToken() {
            return this.hasDeviceToken;
        }

        public boolean hasPingInterval() {
            return this.hasPingInterval;
        }

        public boolean hasPrimaryIp() {
            return this.hasPrimaryIp;
        }

        public boolean hasPrimaryPort() {
            return this.hasPrimaryPort;
        }

        public boolean hasResultCode() {
            return this.hasResultCode;
        }

        public boolean hasSecondaryIp() {
            return this.hasSecondaryIp;
        }

        public boolean hasSecondaryPort() {
            return this.hasSecondaryPort;
        }

        public boolean hasUserData() {
            return this.hasUserData;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (hasResultCode()) {
                codedOutputStream.m319a(2, getResultCode());
            }
            if (hasDeviceToken()) {
                codedOutputStream.m322a(3, getDeviceToken());
            }
            if (hasPrimaryIp()) {
                codedOutputStream.m322a(4, getPrimaryIp());
            }
            if (hasPrimaryPort()) {
                codedOutputStream.m319a(5, getPrimaryPort());
            }
            if (hasSecondaryIp()) {
                codedOutputStream.m322a(6, getSecondaryIp());
            }
            if (hasSecondaryPort()) {
                codedOutputStream.m319a(7, getSecondaryPort());
            }
            if (hasPingInterval()) {
                codedOutputStream.m319a(8, getPingInterval());
            }
            if (hasUserData()) {
                codedOutputStream.m322a(9, getUserData());
            }
        }
    }

    public final class ProvisionRequest extends GeneratedMessageLite {
        public static final int CLIENT_VERSION_FIELD_NUMBER = 2;
        public static final int DEVICE_ID_FIELD_NUMBER = 3;
        public static final int DEVICE_INFO_FIELD_NUMBER = 6;
        public static final int DEVICE_TOKEN_FIELD_NUMBER = 5;
        public static final int DEVICE_TYPE_FIELD_NUMBER = 4;
        private static final ProvisionRequest defaultInstance = new ProvisionRequest(true);
        private String clientVersion_;
        private String deviceId_;
        private String deviceInfo_;
        private String deviceToken_;
        private String deviceType_;
        private boolean hasClientVersion;
        private boolean hasDeviceId;
        private boolean hasDeviceInfo;
        private boolean hasDeviceToken;
        private boolean hasDeviceType;
        private int memoizedSerializedSize;

        public final class Builder extends GeneratedMessageLite.Builder {
            private ProvisionRequest result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public ProvisionRequest buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).m350a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new ProvisionRequest();
                return builder;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            public ProvisionRequest build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            public ProvisionRequest buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                ProvisionRequest provisionRequest = this.result;
                this.result = null;
                return provisionRequest;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new ProvisionRequest();
                return this;
            }

            public Builder clearClientVersion() {
                this.result.hasClientVersion = false;
                this.result.clientVersion_ = ProvisionRequest.getDefaultInstance().getClientVersion();
                return this;
            }

            public Builder clearDeviceId() {
                this.result.hasDeviceId = false;
                this.result.deviceId_ = ProvisionRequest.getDefaultInstance().getDeviceId();
                return this;
            }

            public Builder clearDeviceInfo() {
                this.result.hasDeviceInfo = false;
                this.result.deviceInfo_ = ProvisionRequest.getDefaultInstance().getDeviceInfo();
                return this;
            }

            public Builder clearDeviceToken() {
                this.result.hasDeviceToken = false;
                this.result.deviceToken_ = ProvisionRequest.getDefaultInstance().getDeviceToken();
                return this;
            }

            public Builder clearDeviceType() {
                this.result.hasDeviceType = false;
                this.result.deviceType_ = ProvisionRequest.getDefaultInstance().getDeviceType();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo4397clone() {
                return create().mergeFrom(this.result);
            }

            public String getClientVersion() {
                return this.result.getClientVersion();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: getDefaultInstanceForType */
            public ProvisionRequest mo4403getDefaultInstanceForType() {
                return ProvisionRequest.getDefaultInstance();
            }

            public String getDeviceId() {
                return this.result.getDeviceId();
            }

            public String getDeviceInfo() {
                return this.result.getDeviceInfo();
            }

            public String getDeviceToken() {
                return this.result.getDeviceToken();
            }

            public String getDeviceType() {
                return this.result.getDeviceType();
            }

            public boolean hasClientVersion() {
                return this.result.hasClientVersion();
            }

            public boolean hasDeviceId() {
                return this.result.hasDeviceId();
            }

            public boolean hasDeviceInfo() {
                return this.result.hasDeviceInfo();
            }

            public boolean hasDeviceToken() {
                return this.result.hasDeviceToken();
            }

            public boolean hasDeviceType() {
                return this.result.hasDeviceType();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public ProvisionRequest internalGetResult() {
                return this.result;
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 18:
                            setClientVersion(codedInputStream.m287f());
                            break;
                        case 26:
                            setDeviceId(codedInputStream.m287f());
                            break;
                        case 34:
                            setDeviceType(codedInputStream.m287f());
                            break;
                        case 42:
                            setDeviceToken(codedInputStream.m287f());
                            break;
                        case 50:
                            setDeviceInfo(codedInputStream.m287f());
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
            public Builder mergeFrom(ProvisionRequest provisionRequest) {
                if (provisionRequest == ProvisionRequest.getDefaultInstance()) {
                    return this;
                }
                if (provisionRequest.hasClientVersion()) {
                    setClientVersion(provisionRequest.getClientVersion());
                }
                if (provisionRequest.hasDeviceId()) {
                    setDeviceId(provisionRequest.getDeviceId());
                }
                if (provisionRequest.hasDeviceType()) {
                    setDeviceType(provisionRequest.getDeviceType());
                }
                if (provisionRequest.hasDeviceToken()) {
                    setDeviceToken(provisionRequest.getDeviceToken());
                }
                if (provisionRequest.hasDeviceInfo()) {
                    setDeviceInfo(provisionRequest.getDeviceInfo());
                }
                return this;
            }

            public Builder setClientVersion(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasClientVersion = true;
                this.result.clientVersion_ = str;
                return this;
            }

            public Builder setDeviceId(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasDeviceId = true;
                this.result.deviceId_ = str;
                return this;
            }

            public Builder setDeviceInfo(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasDeviceInfo = true;
                this.result.deviceInfo_ = str;
                return this;
            }

            public Builder setDeviceToken(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasDeviceToken = true;
                this.result.deviceToken_ = str;
                return this;
            }

            public Builder setDeviceType(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasDeviceType = true;
                this.result.deviceType_ = str;
                return this;
            }
        }

        static {
            MsgFrontend.internalForceInit();
            defaultInstance.initFields();
        }

        private ProvisionRequest() {
            this.clientVersion_ = "";
            this.deviceId_ = "";
            this.deviceType_ = "";
            this.deviceToken_ = "";
            this.deviceInfo_ = "";
            this.memoizedSerializedSize = -1;
            initFields();
        }

        private ProvisionRequest(boolean z) {
            this.clientVersion_ = "";
            this.deviceId_ = "";
            this.deviceType_ = "";
            this.deviceToken_ = "";
            this.deviceInfo_ = "";
            this.memoizedSerializedSize = -1;
        }

        public static ProvisionRequest getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(ProvisionRequest provisionRequest) {
            return newBuilder().mergeFrom(provisionRequest);
        }

        public static ProvisionRequest parseDelimitedFrom(InputStream inputStream) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static ProvisionRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream, extensionRegistryLite)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static ProvisionRequest parseFrom(ByteString byteString) {
            return ((Builder) newBuilder().m4398mergeFrom(byteString)).buildParsed();
        }

        public static ProvisionRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4399mergeFrom(byteString, extensionRegistryLite)).buildParsed();
        }

        public static ProvisionRequest parseFrom(CodedInputStream codedInputStream) {
            return ((Builder) newBuilder().m4400mergeFrom(codedInputStream)).buildParsed();
        }

        public static ProvisionRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return newBuilder().mergeFrom(codedInputStream, extensionRegistryLite).buildParsed();
        }

        public static ProvisionRequest parseFrom(InputStream inputStream) {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        public static ProvisionRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().mergeFrom(inputStream, extensionRegistryLite)).buildParsed();
        }

        public static ProvisionRequest parseFrom(byte[] bArr) {
            return ((Builder) newBuilder().m4401mergeFrom(bArr)).buildParsed();
        }

        public static ProvisionRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4402mergeFrom(bArr, extensionRegistryLite)).buildParsed();
        }

        public String getClientVersion() {
            return this.clientVersion_;
        }

        @Override // com.google.protobuf.MessageLite
        public ProvisionRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public String getDeviceId() {
            return this.deviceId_;
        }

        public String getDeviceInfo() {
            return this.deviceInfo_;
        }

        public String getDeviceToken() {
            return this.deviceToken_;
        }

        public String getDeviceType() {
            return this.deviceType_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM303b = this.memoizedSerializedSize;
            if (iM303b == -1) {
                iM303b = hasClientVersion() ? 0 + CodedOutputStream.m303b(2, getClientVersion()) : 0;
                if (hasDeviceId()) {
                    iM303b += CodedOutputStream.m303b(3, getDeviceId());
                }
                if (hasDeviceType()) {
                    iM303b += CodedOutputStream.m303b(4, getDeviceType());
                }
                if (hasDeviceToken()) {
                    iM303b += CodedOutputStream.m303b(5, getDeviceToken());
                }
                if (hasDeviceInfo()) {
                    iM303b += CodedOutputStream.m303b(6, getDeviceInfo());
                }
                this.memoizedSerializedSize = iM303b;
            }
            return iM303b;
        }

        public boolean hasClientVersion() {
            return this.hasClientVersion;
        }

        public boolean hasDeviceId() {
            return this.hasDeviceId;
        }

        public boolean hasDeviceInfo() {
            return this.hasDeviceInfo;
        }

        public boolean hasDeviceToken() {
            return this.hasDeviceToken;
        }

        public boolean hasDeviceType() {
            return this.hasDeviceType;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (hasClientVersion()) {
                codedOutputStream.m322a(2, getClientVersion());
            }
            if (hasDeviceId()) {
                codedOutputStream.m322a(3, getDeviceId());
            }
            if (hasDeviceType()) {
                codedOutputStream.m322a(4, getDeviceType());
            }
            if (hasDeviceToken()) {
                codedOutputStream.m322a(5, getDeviceToken());
            }
            if (hasDeviceInfo()) {
                codedOutputStream.m322a(6, getDeviceInfo());
            }
        }
    }

    public final class RegistrationReply extends GeneratedMessageLite {
        public static final int ASYNC_ID_FIELD_NUMBER = 1;
        public static final int REG_ID_FIELD_NUMBER = 4;
        public static final int RESULT_CODE_FIELD_NUMBER = 2;
        public static final int RESULT_MSG_FIELD_NUMBER = 3;
        public static final int USER_DATA_FIELD_NUMBER = 5;
        private static final RegistrationReply defaultInstance = new RegistrationReply(true);
        private int asyncId_;
        private boolean hasAsyncId;
        private boolean hasRegId;
        private boolean hasResultCode;
        private boolean hasResultMsg;
        private boolean hasUserData;
        private int memoizedSerializedSize;
        private String regId_;
        private int resultCode_;
        private String resultMsg_;
        private String userData_;

        public final class Builder extends GeneratedMessageLite.Builder {
            private RegistrationReply result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public RegistrationReply buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).m350a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new RegistrationReply();
                return builder;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            public RegistrationReply build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            public RegistrationReply buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                RegistrationReply registrationReply = this.result;
                this.result = null;
                return registrationReply;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new RegistrationReply();
                return this;
            }

            public Builder clearAsyncId() {
                this.result.hasAsyncId = false;
                this.result.asyncId_ = 0;
                return this;
            }

            public Builder clearRegId() {
                this.result.hasRegId = false;
                this.result.regId_ = RegistrationReply.getDefaultInstance().getRegId();
                return this;
            }

            public Builder clearResultCode() {
                this.result.hasResultCode = false;
                this.result.resultCode_ = 0;
                return this;
            }

            public Builder clearResultMsg() {
                this.result.hasResultMsg = false;
                this.result.resultMsg_ = RegistrationReply.getDefaultInstance().getResultMsg();
                return this;
            }

            public Builder clearUserData() {
                this.result.hasUserData = false;
                this.result.userData_ = RegistrationReply.getDefaultInstance().getUserData();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo4397clone() {
                return create().mergeFrom(this.result);
            }

            public int getAsyncId() {
                return this.result.getAsyncId();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: getDefaultInstanceForType */
            public RegistrationReply mo4403getDefaultInstanceForType() {
                return RegistrationReply.getDefaultInstance();
            }

            public String getRegId() {
                return this.result.getRegId();
            }

            public int getResultCode() {
                return this.result.getResultCode();
            }

            public String getResultMsg() {
                return this.result.getResultMsg();
            }

            public String getUserData() {
                return this.result.getUserData();
            }

            public boolean hasAsyncId() {
                return this.result.hasAsyncId();
            }

            public boolean hasRegId() {
                return this.result.hasRegId();
            }

            public boolean hasResultCode() {
                return this.result.hasResultCode();
            }

            public boolean hasResultMsg() {
                return this.result.hasResultMsg();
            }

            public boolean hasUserData() {
                return this.result.hasUserData();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public RegistrationReply internalGetResult() {
                return this.result;
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            setAsyncId(codedInputStream.m283d());
                            break;
                        case 16:
                            setResultCode(codedInputStream.m283d());
                            break;
                        case 26:
                            setResultMsg(codedInputStream.m287f());
                            break;
                        case 34:
                            setRegId(codedInputStream.m287f());
                            break;
                        case 42:
                            setUserData(codedInputStream.m287f());
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
            public Builder mergeFrom(RegistrationReply registrationReply) {
                if (registrationReply == RegistrationReply.getDefaultInstance()) {
                    return this;
                }
                if (registrationReply.hasAsyncId()) {
                    setAsyncId(registrationReply.getAsyncId());
                }
                if (registrationReply.hasResultCode()) {
                    setResultCode(registrationReply.getResultCode());
                }
                if (registrationReply.hasResultMsg()) {
                    setResultMsg(registrationReply.getResultMsg());
                }
                if (registrationReply.hasRegId()) {
                    setRegId(registrationReply.getRegId());
                }
                if (registrationReply.hasUserData()) {
                    setUserData(registrationReply.getUserData());
                }
                return this;
            }

            public Builder setAsyncId(int i) {
                this.result.hasAsyncId = true;
                this.result.asyncId_ = i;
                return this;
            }

            public Builder setRegId(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasRegId = true;
                this.result.regId_ = str;
                return this;
            }

            public Builder setResultCode(int i) {
                this.result.hasResultCode = true;
                this.result.resultCode_ = i;
                return this;
            }

            public Builder setResultMsg(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasResultMsg = true;
                this.result.resultMsg_ = str;
                return this;
            }

            public Builder setUserData(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasUserData = true;
                this.result.userData_ = str;
                return this;
            }
        }

        static {
            MsgFrontend.internalForceInit();
            defaultInstance.initFields();
        }

        private RegistrationReply() {
            this.asyncId_ = 0;
            this.resultCode_ = 0;
            this.resultMsg_ = "";
            this.regId_ = "";
            this.userData_ = "";
            this.memoizedSerializedSize = -1;
            initFields();
        }

        private RegistrationReply(boolean z) {
            this.asyncId_ = 0;
            this.resultCode_ = 0;
            this.resultMsg_ = "";
            this.regId_ = "";
            this.userData_ = "";
            this.memoizedSerializedSize = -1;
        }

        public static RegistrationReply getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(RegistrationReply registrationReply) {
            return newBuilder().mergeFrom(registrationReply);
        }

        public static RegistrationReply parseDelimitedFrom(InputStream inputStream) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static RegistrationReply parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream, extensionRegistryLite)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static RegistrationReply parseFrom(ByteString byteString) {
            return ((Builder) newBuilder().m4398mergeFrom(byteString)).buildParsed();
        }

        public static RegistrationReply parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4399mergeFrom(byteString, extensionRegistryLite)).buildParsed();
        }

        public static RegistrationReply parseFrom(CodedInputStream codedInputStream) {
            return ((Builder) newBuilder().m4400mergeFrom(codedInputStream)).buildParsed();
        }

        public static RegistrationReply parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return newBuilder().mergeFrom(codedInputStream, extensionRegistryLite).buildParsed();
        }

        public static RegistrationReply parseFrom(InputStream inputStream) {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        public static RegistrationReply parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().mergeFrom(inputStream, extensionRegistryLite)).buildParsed();
        }

        public static RegistrationReply parseFrom(byte[] bArr) {
            return ((Builder) newBuilder().m4401mergeFrom(bArr)).buildParsed();
        }

        public static RegistrationReply parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4402mergeFrom(bArr, extensionRegistryLite)).buildParsed();
        }

        public int getAsyncId() {
            return this.asyncId_;
        }

        @Override // com.google.protobuf.MessageLite
        public RegistrationReply getDefaultInstanceForType() {
            return defaultInstance;
        }

        public String getRegId() {
            return this.regId_;
        }

        public int getResultCode() {
            return this.resultCode_;
        }

        public String getResultMsg() {
            return this.resultMsg_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM309c = this.memoizedSerializedSize;
            if (iM309c == -1) {
                iM309c = hasAsyncId() ? 0 + CodedOutputStream.m309c(1, getAsyncId()) : 0;
                if (hasResultCode()) {
                    iM309c += CodedOutputStream.m309c(2, getResultCode());
                }
                if (hasResultMsg()) {
                    iM309c += CodedOutputStream.m303b(3, getResultMsg());
                }
                if (hasRegId()) {
                    iM309c += CodedOutputStream.m303b(4, getRegId());
                }
                if (hasUserData()) {
                    iM309c += CodedOutputStream.m303b(5, getUserData());
                }
                this.memoizedSerializedSize = iM309c;
            }
            return iM309c;
        }

        public String getUserData() {
            return this.userData_;
        }

        public boolean hasAsyncId() {
            return this.hasAsyncId;
        }

        public boolean hasRegId() {
            return this.hasRegId;
        }

        public boolean hasResultCode() {
            return this.hasResultCode;
        }

        public boolean hasResultMsg() {
            return this.hasResultMsg;
        }

        public boolean hasUserData() {
            return this.hasUserData;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (hasAsyncId()) {
                codedOutputStream.m319a(1, getAsyncId());
            }
            if (hasResultCode()) {
                codedOutputStream.m319a(2, getResultCode());
            }
            if (hasResultMsg()) {
                codedOutputStream.m322a(3, getResultMsg());
            }
            if (hasRegId()) {
                codedOutputStream.m322a(4, getRegId());
            }
            if (hasUserData()) {
                codedOutputStream.m322a(5, getUserData());
            }
        }
    }

    public final class RegistrationRequest extends GeneratedMessageLite {
        public static final int APP_ID_FIELD_NUMBER = 3;
        public static final int ASYNC_ID_FIELD_NUMBER = 1;
        public static final int DEVICE_TOKEN_FIELD_NUMBER = 2;
        public static final int USER_DATA_FIELD_NUMBER = 4;
        private static final RegistrationRequest defaultInstance = new RegistrationRequest(true);
        private String appId_;
        private int asyncId_;
        private String deviceToken_;
        private boolean hasAppId;
        private boolean hasAsyncId;
        private boolean hasDeviceToken;
        private boolean hasUserData;
        private int memoizedSerializedSize;
        private String userData_;

        public final class Builder extends GeneratedMessageLite.Builder {
            private RegistrationRequest result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public RegistrationRequest buildParsed() throws InvalidProtocolBufferException {
                if (isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result).m350a();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new RegistrationRequest();
                return builder;
            }

            @Override // com.google.protobuf.MessageLite.Builder
            public RegistrationRequest build() {
                if (this.result == null || isInitialized()) {
                    return buildPartial();
                }
                throw newUninitializedMessageException(this.result);
            }

            public RegistrationRequest buildPartial() {
                if (this.result == null) {
                    throw new IllegalStateException("build() has already been called on this Builder.");
                }
                RegistrationRequest registrationRequest = this.result;
                this.result = null;
                return registrationRequest;
            }

            public Builder clear() {
                if (this.result == null) {
                    throw new IllegalStateException("Cannot call clear() after build().");
                }
                this.result = new RegistrationRequest();
                return this;
            }

            public Builder clearAppId() {
                this.result.hasAppId = false;
                this.result.appId_ = RegistrationRequest.getDefaultInstance().getAppId();
                return this;
            }

            public Builder clearAsyncId() {
                this.result.hasAsyncId = false;
                this.result.asyncId_ = 0;
                return this;
            }

            public Builder clearDeviceToken() {
                this.result.hasDeviceToken = false;
                this.result.deviceToken_ = RegistrationRequest.getDefaultInstance().getDeviceToken();
                return this;
            }

            public Builder clearUserData() {
                this.result.hasUserData = false;
                this.result.userData_ = RegistrationRequest.getDefaultInstance().getUserData();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
            /* renamed from: clone */
            public Builder mo4397clone() {
                return create().mergeFrom(this.result);
            }

            public String getAppId() {
                return this.result.getAppId();
            }

            public int getAsyncId() {
                return this.result.getAsyncId();
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: getDefaultInstanceForType */
            public RegistrationRequest mo4403getDefaultInstanceForType() {
                return RegistrationRequest.getDefaultInstance();
            }

            public String getDeviceToken() {
                return this.result.getDeviceToken();
            }

            public String getUserData() {
                return this.result.getUserData();
            }

            public boolean hasAppId() {
                return this.result.hasAppId();
            }

            public boolean hasAsyncId() {
                return this.result.hasAsyncId();
            }

            public boolean hasDeviceToken() {
                return this.result.hasDeviceToken();
            }

            public boolean hasUserData() {
                return this.result.hasUserData();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public RegistrationRequest internalGetResult() {
                return this.result;
            }

            public boolean isInitialized() {
                return this.result.isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                while (true) {
                    int iM276a = codedInputStream.m276a();
                    switch (iM276a) {
                        case 0:
                            return this;
                        case 8:
                            setAsyncId(codedInputStream.m283d());
                            break;
                        case 18:
                            setDeviceToken(codedInputStream.m287f());
                            break;
                        case 26:
                            setAppId(codedInputStream.m287f());
                            break;
                        case 34:
                            setUserData(codedInputStream.m287f());
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
            public Builder mergeFrom(RegistrationRequest registrationRequest) {
                if (registrationRequest == RegistrationRequest.getDefaultInstance()) {
                    return this;
                }
                if (registrationRequest.hasAsyncId()) {
                    setAsyncId(registrationRequest.getAsyncId());
                }
                if (registrationRequest.hasDeviceToken()) {
                    setDeviceToken(registrationRequest.getDeviceToken());
                }
                if (registrationRequest.hasAppId()) {
                    setAppId(registrationRequest.getAppId());
                }
                if (registrationRequest.hasUserData()) {
                    setUserData(registrationRequest.getUserData());
                }
                return this;
            }

            public Builder setAppId(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasAppId = true;
                this.result.appId_ = str;
                return this;
            }

            public Builder setAsyncId(int i) {
                this.result.hasAsyncId = true;
                this.result.asyncId_ = i;
                return this;
            }

            public Builder setDeviceToken(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasDeviceToken = true;
                this.result.deviceToken_ = str;
                return this;
            }

            public Builder setUserData(String str) {
                if (str == null) {
                    throw new NullPointerException();
                }
                this.result.hasUserData = true;
                this.result.userData_ = str;
                return this;
            }
        }

        static {
            MsgFrontend.internalForceInit();
            defaultInstance.initFields();
        }

        private RegistrationRequest() {
            this.asyncId_ = 0;
            this.deviceToken_ = "";
            this.appId_ = "";
            this.userData_ = "";
            this.memoizedSerializedSize = -1;
            initFields();
        }

        private RegistrationRequest(boolean z) {
            this.asyncId_ = 0;
            this.deviceToken_ = "";
            this.appId_ = "";
            this.userData_ = "";
            this.memoizedSerializedSize = -1;
        }

        public static RegistrationRequest getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(RegistrationRequest registrationRequest) {
            return newBuilder().mergeFrom(registrationRequest);
        }

        public static RegistrationRequest parseDelimitedFrom(InputStream inputStream) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static RegistrationRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            Builder builderNewBuilder = newBuilder();
            if (builderNewBuilder.mergeDelimitedFrom(inputStream, extensionRegistryLite)) {
                return builderNewBuilder.buildParsed();
            }
            return null;
        }

        public static RegistrationRequest parseFrom(ByteString byteString) {
            return ((Builder) newBuilder().m4398mergeFrom(byteString)).buildParsed();
        }

        public static RegistrationRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4399mergeFrom(byteString, extensionRegistryLite)).buildParsed();
        }

        public static RegistrationRequest parseFrom(CodedInputStream codedInputStream) {
            return ((Builder) newBuilder().m4400mergeFrom(codedInputStream)).buildParsed();
        }

        public static RegistrationRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return newBuilder().mergeFrom(codedInputStream, extensionRegistryLite).buildParsed();
        }

        public static RegistrationRequest parseFrom(InputStream inputStream) {
            return ((Builder) newBuilder().mergeFrom(inputStream)).buildParsed();
        }

        public static RegistrationRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().mergeFrom(inputStream, extensionRegistryLite)).buildParsed();
        }

        public static RegistrationRequest parseFrom(byte[] bArr) {
            return ((Builder) newBuilder().m4401mergeFrom(bArr)).buildParsed();
        }

        public static RegistrationRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return ((Builder) newBuilder().m4402mergeFrom(bArr, extensionRegistryLite)).buildParsed();
        }

        public String getAppId() {
            return this.appId_;
        }

        public int getAsyncId() {
            return this.asyncId_;
        }

        @Override // com.google.protobuf.MessageLite
        public RegistrationRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        public String getDeviceToken() {
            return this.deviceToken_;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int iM309c = this.memoizedSerializedSize;
            if (iM309c == -1) {
                iM309c = hasAsyncId() ? 0 + CodedOutputStream.m309c(1, getAsyncId()) : 0;
                if (hasDeviceToken()) {
                    iM309c += CodedOutputStream.m303b(2, getDeviceToken());
                }
                if (hasAppId()) {
                    iM309c += CodedOutputStream.m303b(3, getAppId());
                }
                if (hasUserData()) {
                    iM309c += CodedOutputStream.m303b(4, getUserData());
                }
                this.memoizedSerializedSize = iM309c;
            }
            return iM309c;
        }

        public String getUserData() {
            return this.userData_;
        }

        public boolean hasAppId() {
            return this.hasAppId;
        }

        public boolean hasAsyncId() {
            return this.hasAsyncId;
        }

        public boolean hasDeviceToken() {
            return this.hasDeviceToken;
        }

        public boolean hasUserData() {
            return this.hasUserData;
        }

        public final boolean isInitialized() {
            return true;
        }

        @Override // com.google.protobuf.MessageLite
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public Builder toBuilder() {
            return newBuilder(this);
        }

        @Override // com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if (hasAsyncId()) {
                codedOutputStream.m319a(1, getAsyncId());
            }
            if (hasDeviceToken()) {
                codedOutputStream.m322a(2, getDeviceToken());
            }
            if (hasAppId()) {
                codedOutputStream.m322a(3, getAppId());
            }
            if (hasUserData()) {
                codedOutputStream.m322a(4, getUserData());
            }
        }
    }

    private MsgFrontend() {
    }

    public static void internalForceInit() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }
}
