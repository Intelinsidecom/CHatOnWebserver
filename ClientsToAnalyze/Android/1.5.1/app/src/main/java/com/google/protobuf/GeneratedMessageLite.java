package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;

/* loaded from: classes.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite {

    public abstract class Builder extends AbstractMessageLite.Builder {
        protected Builder() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: clone */
        public Builder mo4397clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        @Override // 
        /* renamed from: getDefaultInstanceForType */
        public abstract GeneratedMessageLite mo4403getDefaultInstanceForType();

        protected abstract GeneratedMessageLite internalGetResult();

        public abstract Builder mergeFrom(GeneratedMessageLite generatedMessageLite);

        protected boolean parseUnknownField(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, int i) {
            return codedInputStream.m280b(i);
        }
    }

    public abstract class ExtendableBuilder extends Builder {
        protected ExtendableBuilder() {
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ExtendableBuilder mo4397clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    public abstract class ExtendableMessage extends GeneratedMessageLite {

        /* renamed from: a */
        private final FieldSet f240a = FieldSet.m340a();

        public class ExtensionWriter {
        }

        protected ExtendableMessage() {
        }
    }

    public final class GeneratedExtension {
        private GeneratedExtension() {
        }

        /* synthetic */ GeneratedExtension(C0059g c0059g) {
            this();
        }
    }

    protected GeneratedMessageLite() {
    }

    public static GeneratedExtension newGeneratedExtension() {
        return new GeneratedExtension(null);
    }
}
