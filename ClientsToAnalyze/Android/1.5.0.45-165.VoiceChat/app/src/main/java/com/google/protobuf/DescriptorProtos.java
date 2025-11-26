package com.google.protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.UnknownFieldSet;
import com.infraware.office.evengine.InterfaceC0507E;
import com.samsung.spen.lib.image.SPenImageFilterConstants;
import com.vlingo.sdk.internal.audio.TTSRequestParams;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class DescriptorProtos {
    private static Descriptors.FileDescriptor descriptor;

    /* renamed from: internal_static_google_protobuf_DescriptorProto_ExtensionRange_descriptor */
    private static Descriptors.Descriptor f31x1458f8d;

    /* renamed from: internal_static_google_protobuf_DescriptorProto_ExtensionRange_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f32xf366d90b;
    private static Descriptors.Descriptor internal_static_google_protobuf_DescriptorProto_descriptor;

    /* renamed from: internal_static_google_protobuf_DescriptorProto_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f33x907d0bf0;
    private static Descriptors.Descriptor internal_static_google_protobuf_EnumDescriptorProto_descriptor;

    /* renamed from: internal_static_google_protobuf_EnumDescriptorProto_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f34x9945f651;
    private static Descriptors.Descriptor internal_static_google_protobuf_EnumOptions_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_EnumOptions_fieldAccessorTable;

    /* renamed from: internal_static_google_protobuf_EnumValueDescriptorProto_descriptor */
    private static Descriptors.Descriptor f35xf18031a8;

    /* renamed from: internal_static_google_protobuf_EnumValueDescriptorProto_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f36xfb173026;
    private static Descriptors.Descriptor internal_static_google_protobuf_EnumValueOptions_descriptor;

    /* renamed from: internal_static_google_protobuf_EnumValueOptions_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f37xdf65a421;
    private static Descriptors.Descriptor internal_static_google_protobuf_FieldDescriptorProto_descriptor;

    /* renamed from: internal_static_google_protobuf_FieldDescriptorProto_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f38x4734b330;
    private static Descriptors.Descriptor internal_static_google_protobuf_FieldOptions_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_FileDescriptorProto_descriptor;

    /* renamed from: internal_static_google_protobuf_FileDescriptorProto_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f39x4b52780c;
    private static Descriptors.Descriptor internal_static_google_protobuf_FileDescriptorSet_descriptor;

    /* renamed from: internal_static_google_protobuf_FileDescriptorSet_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f40x15a6a952;
    private static Descriptors.Descriptor internal_static_google_protobuf_FileOptions_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_FileOptions_fieldAccessorTable;
    private static Descriptors.Descriptor internal_static_google_protobuf_MessageOptions_descriptor;

    /* renamed from: internal_static_google_protobuf_MessageOptions_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f41x9c0b3d38;
    private static Descriptors.Descriptor internal_static_google_protobuf_MethodDescriptorProto_descriptor;

    /* renamed from: internal_static_google_protobuf_MethodDescriptorProto_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f42xc5331ef1;
    private static Descriptors.Descriptor internal_static_google_protobuf_MethodOptions_descriptor;
    private static GeneratedMessage.FieldAccessorTable internal_static_google_protobuf_MethodOptions_fieldAccessorTable;

    /* renamed from: internal_static_google_protobuf_ServiceDescriptorProto_descriptor */
    private static Descriptors.Descriptor f43x158c73ed;

    /* renamed from: internal_static_google_protobuf_ServiceDescriptorProto_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f44xee335d6b;
    private static Descriptors.Descriptor internal_static_google_protobuf_ServiceOptions_descriptor;

    /* renamed from: internal_static_google_protobuf_ServiceOptions_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f45x371e666;

    /* renamed from: internal_static_google_protobuf_SourceCodeInfo_Location_descriptor */
    private static Descriptors.Descriptor f46xb210d08d;

    /* renamed from: internal_static_google_protobuf_SourceCodeInfo_Location_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f47x9611a0b;
    private static Descriptors.Descriptor internal_static_google_protobuf_SourceCodeInfo_descriptor;

    /* renamed from: internal_static_google_protobuf_SourceCodeInfo_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f48x532209f9;

    /* renamed from: internal_static_google_protobuf_UninterpretedOption_NamePart_descriptor */
    private static Descriptors.Descriptor f49xb111d23c;

    /* renamed from: internal_static_google_protobuf_UninterpretedOption_NamePart_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f50x1698fcba;
    private static Descriptors.Descriptor internal_static_google_protobuf_UninterpretedOption_descriptor;

    /* renamed from: internal_static_google_protobuf_UninterpretedOption_fieldAccessorTable */
    private static GeneratedMessage.FieldAccessorTable f51x2101041;

    public interface DescriptorProtoOrBuilder extends MessageOrBuilder {
        EnumDescriptorProto getEnumType(int i);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int i);

        List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList();

        FieldDescriptorProto getExtension(int i);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int i);

        List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList();

        DescriptorProto.ExtensionRange getExtensionRange(int i);

        int getExtensionRangeCount();

        List<DescriptorProto.ExtensionRange> getExtensionRangeList();

        DescriptorProto.ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int i);

        List<? extends DescriptorProto.ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList();

        FieldDescriptorProto getField(int i);

        int getFieldCount();

        List<FieldDescriptorProto> getFieldList();

        FieldDescriptorProtoOrBuilder getFieldOrBuilder(int i);

        List<? extends FieldDescriptorProtoOrBuilder> getFieldOrBuilderList();

        String getName();

        DescriptorProto getNestedType(int i);

        int getNestedTypeCount();

        List<DescriptorProto> getNestedTypeList();

        DescriptorProtoOrBuilder getNestedTypeOrBuilder(int i);

        List<? extends DescriptorProtoOrBuilder> getNestedTypeOrBuilderList();

        MessageOptions getOptions();

        MessageOptionsOrBuilder getOptionsOrBuilder();

        boolean hasName();

        boolean hasOptions();
    }

    public interface EnumDescriptorProtoOrBuilder extends MessageOrBuilder {
        String getName();

        EnumOptions getOptions();

        EnumOptionsOrBuilder getOptionsOrBuilder();

        EnumValueDescriptorProto getValue(int i);

        int getValueCount();

        List<EnumValueDescriptorProto> getValueList();

        EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int i);

        List<? extends EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList();

        boolean hasName();

        boolean hasOptions();
    }

    public interface EnumOptionsOrBuilder extends GeneratedMessage.ExtendableMessageOrBuilder<EnumOptions> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    }

    public interface EnumValueDescriptorProtoOrBuilder extends MessageOrBuilder {
        String getName();

        int getNumber();

        EnumValueOptions getOptions();

        EnumValueOptionsOrBuilder getOptionsOrBuilder();

        boolean hasName();

        boolean hasNumber();

        boolean hasOptions();
    }

    public interface EnumValueOptionsOrBuilder extends GeneratedMessage.ExtendableMessageOrBuilder<EnumValueOptions> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    }

    public interface FieldDescriptorProtoOrBuilder extends MessageOrBuilder {
        String getDefaultValue();

        String getExtendee();

        FieldDescriptorProto.Label getLabel();

        String getName();

        int getNumber();

        FieldOptions getOptions();

        FieldOptionsOrBuilder getOptionsOrBuilder();

        FieldDescriptorProto.Type getType();

        String getTypeName();

        boolean hasDefaultValue();

        boolean hasExtendee();

        boolean hasLabel();

        boolean hasName();

        boolean hasNumber();

        boolean hasOptions();

        boolean hasType();

        boolean hasTypeName();
    }

    public interface FieldOptionsOrBuilder extends GeneratedMessage.ExtendableMessageOrBuilder<FieldOptions> {
        FieldOptions.CType getCtype();

        boolean getDeprecated();

        String getExperimentalMapKey();

        boolean getPacked();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();

        boolean hasCtype();

        boolean hasDeprecated();

        boolean hasExperimentalMapKey();

        boolean hasPacked();
    }

    public interface FileDescriptorProtoOrBuilder extends MessageOrBuilder {
        String getDependency(int i);

        int getDependencyCount();

        List<String> getDependencyList();

        EnumDescriptorProto getEnumType(int i);

        int getEnumTypeCount();

        List<EnumDescriptorProto> getEnumTypeList();

        EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int i);

        List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList();

        FieldDescriptorProto getExtension(int i);

        int getExtensionCount();

        List<FieldDescriptorProto> getExtensionList();

        FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int i);

        List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList();

        DescriptorProto getMessageType(int i);

        int getMessageTypeCount();

        List<DescriptorProto> getMessageTypeList();

        DescriptorProtoOrBuilder getMessageTypeOrBuilder(int i);

        List<? extends DescriptorProtoOrBuilder> getMessageTypeOrBuilderList();

        String getName();

        FileOptions getOptions();

        FileOptionsOrBuilder getOptionsOrBuilder();

        String getPackage();

        ServiceDescriptorProto getService(int i);

        int getServiceCount();

        List<ServiceDescriptorProto> getServiceList();

        ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int i);

        List<? extends ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList();

        SourceCodeInfo getSourceCodeInfo();

        SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder();

        boolean hasName();

        boolean hasOptions();

        boolean hasPackage();

        boolean hasSourceCodeInfo();
    }

    public interface FileDescriptorSetOrBuilder extends MessageOrBuilder {
        FileDescriptorProto getFile(int i);

        int getFileCount();

        List<FileDescriptorProto> getFileList();

        FileDescriptorProtoOrBuilder getFileOrBuilder(int i);

        List<? extends FileDescriptorProtoOrBuilder> getFileOrBuilderList();
    }

    public interface FileOptionsOrBuilder extends GeneratedMessage.ExtendableMessageOrBuilder<FileOptions> {
        boolean getCcGenericServices();

        boolean getJavaGenerateEqualsAndHash();

        boolean getJavaGenericServices();

        boolean getJavaMultipleFiles();

        String getJavaOuterClassname();

        String getJavaPackage();

        FileOptions.OptimizeMode getOptimizeFor();

        boolean getPyGenericServices();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();

        boolean hasCcGenericServices();

        boolean hasJavaGenerateEqualsAndHash();

        boolean hasJavaGenericServices();

        boolean hasJavaMultipleFiles();

        boolean hasJavaOuterClassname();

        boolean hasJavaPackage();

        boolean hasOptimizeFor();

        boolean hasPyGenericServices();
    }

    public interface MessageOptionsOrBuilder extends GeneratedMessage.ExtendableMessageOrBuilder<MessageOptions> {
        boolean getMessageSetWireFormat();

        boolean getNoStandardDescriptorAccessor();

        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();

        boolean hasMessageSetWireFormat();

        boolean hasNoStandardDescriptorAccessor();
    }

    public interface MethodDescriptorProtoOrBuilder extends MessageOrBuilder {
        String getInputType();

        String getName();

        MethodOptions getOptions();

        MethodOptionsOrBuilder getOptionsOrBuilder();

        String getOutputType();

        boolean hasInputType();

        boolean hasName();

        boolean hasOptions();

        boolean hasOutputType();
    }

    public interface MethodOptionsOrBuilder extends GeneratedMessage.ExtendableMessageOrBuilder<MethodOptions> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    }

    public interface ServiceDescriptorProtoOrBuilder extends MessageOrBuilder {
        MethodDescriptorProto getMethod(int i);

        int getMethodCount();

        List<MethodDescriptorProto> getMethodList();

        MethodDescriptorProtoOrBuilder getMethodOrBuilder(int i);

        List<? extends MethodDescriptorProtoOrBuilder> getMethodOrBuilderList();

        String getName();

        ServiceOptions getOptions();

        ServiceOptionsOrBuilder getOptionsOrBuilder();

        boolean hasName();

        boolean hasOptions();
    }

    public interface ServiceOptionsOrBuilder extends GeneratedMessage.ExtendableMessageOrBuilder<ServiceOptions> {
        UninterpretedOption getUninterpretedOption(int i);

        int getUninterpretedOptionCount();

        List<UninterpretedOption> getUninterpretedOptionList();

        UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int i);

        List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList();
    }

    public interface SourceCodeInfoOrBuilder extends MessageOrBuilder {
        SourceCodeInfo.Location getLocation(int i);

        int getLocationCount();

        List<SourceCodeInfo.Location> getLocationList();

        SourceCodeInfo.LocationOrBuilder getLocationOrBuilder(int i);

        List<? extends SourceCodeInfo.LocationOrBuilder> getLocationOrBuilderList();
    }

    public interface UninterpretedOptionOrBuilder extends MessageOrBuilder {
        String getAggregateValue();

        double getDoubleValue();

        String getIdentifierValue();

        UninterpretedOption.NamePart getName(int i);

        int getNameCount();

        List<UninterpretedOption.NamePart> getNameList();

        UninterpretedOption.NamePartOrBuilder getNameOrBuilder(int i);

        List<? extends UninterpretedOption.NamePartOrBuilder> getNameOrBuilderList();

        long getNegativeIntValue();

        long getPositiveIntValue();

        ByteString getStringValue();

        boolean hasAggregateValue();

        boolean hasDoubleValue();

        boolean hasIdentifierValue();

        boolean hasNegativeIntValue();

        boolean hasPositiveIntValue();

        boolean hasStringValue();
    }

    private DescriptorProtos() {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
    }

    public static final class FileDescriptorSet extends GeneratedMessage implements FileDescriptorSetOrBuilder {
        public static final int FILE_FIELD_NUMBER = 1;
        private static final FileDescriptorSet defaultInstance = new FileDescriptorSet(true);
        private static final long serialVersionUID = 0;
        private List<FileDescriptorProto> file_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        /* synthetic */ FileDescriptorSet(Builder builder, FileDescriptorSet fileDescriptorSet) {
            this(builder);
        }

        private FileDescriptorSet(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private FileDescriptorSet(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static FileDescriptorSet getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FileDescriptorSet getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f40x15a6a952;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public List<FileDescriptorProto> getFileList() {
            return this.file_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public List<? extends FileDescriptorProtoOrBuilder> getFileOrBuilderList() {
            return this.file_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public int getFileCount() {
            return this.file_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public FileDescriptorProto getFile(int index) {
            return this.file_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
        public FileDescriptorProtoOrBuilder getFileOrBuilder(int index) {
            return this.file_.get(index);
        }

        private void initFields() {
            this.file_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            for (int i = 0; i < getFileCount(); i++) {
                if (!getFile(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.file_.size(); i++) {
                output.writeMessage(1, this.file_.get(i));
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.file_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.file_.get(i));
            }
            int size3 = size2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorSet parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorSet parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorSet parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorSet parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorSet parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorSet parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FileDescriptorSet parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorSet parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileDescriptorSet parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FileDescriptorSet prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FileDescriptorSetOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<FileDescriptorProto, FileDescriptorProto.Builder, FileDescriptorProtoOrBuilder> fileBuilder_;
            private List<FileDescriptorProto> file_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f40x15a6a952;
            }

            private Builder() {
                this.file_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.file_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getFileFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.fileBuilder_ == null) {
                    this.file_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.fileBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FileDescriptorSet.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FileDescriptorSet getDefaultInstanceForType() {
                return FileDescriptorSet.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileDescriptorSet build() {
                FileDescriptorSet result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public FileDescriptorSet buildParsed() throws InvalidProtocolBufferException {
                FileDescriptorSet result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileDescriptorSet buildPartial() {
                FileDescriptorSet result = new FileDescriptorSet(this, null);
                int i = this.bitField0_;
                if (this.fileBuilder_ != null) {
                    result.file_ = this.fileBuilder_.build();
                } else {
                    if ((this.bitField0_ & 1) == 1) {
                        this.file_ = Collections.unmodifiableList(this.file_);
                        this.bitField0_ &= -2;
                    }
                    result.file_ = this.file_;
                }
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof FileDescriptorSet) {
                    return mergeFrom((FileDescriptorSet) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FileDescriptorSet other) {
                if (other != FileDescriptorSet.getDefaultInstance()) {
                    if (this.fileBuilder_ == null) {
                        if (!other.file_.isEmpty()) {
                            if (this.file_.isEmpty()) {
                                this.file_ = other.file_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureFileIsMutable();
                                this.file_.addAll(other.file_);
                            }
                            onChanged();
                        }
                    } else if (!other.file_.isEmpty()) {
                        if (!this.fileBuilder_.isEmpty()) {
                            this.fileBuilder_.addAllMessages(other.file_);
                        } else {
                            this.fileBuilder_.dispose();
                            this.fileBuilder_ = null;
                            this.file_ = other.file_;
                            this.bitField0_ &= -2;
                            this.fileBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getFileFieldBuilder() : null;
                        }
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getFileCount(); i++) {
                    if (!getFile(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 10:
                            FileDescriptorProto.Builder subBuilder = FileDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addFile(subBuilder.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            private void ensureFileIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.file_ = new ArrayList(this.file_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public List<FileDescriptorProto> getFileList() {
                return this.fileBuilder_ == null ? Collections.unmodifiableList(this.file_) : this.fileBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public int getFileCount() {
                return this.fileBuilder_ == null ? this.file_.size() : this.fileBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public FileDescriptorProto getFile(int index) {
                return this.fileBuilder_ == null ? this.file_.get(index) : (FileDescriptorProto) this.fileBuilder_.getMessage(index);
            }

            public Builder setFile(int index, FileDescriptorProto value) {
                if (this.fileBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureFileIsMutable();
                    this.file_.set(index, value);
                    onChanged();
                } else {
                    this.fileBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setFile(int index, FileDescriptorProto.Builder builderForValue) {
                if (this.fileBuilder_ == null) {
                    ensureFileIsMutable();
                    this.file_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fileBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFile(FileDescriptorProto value) {
                if (this.fileBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureFileIsMutable();
                    this.file_.add(value);
                    onChanged();
                } else {
                    this.fileBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addFile(int index, FileDescriptorProto value) {
                if (this.fileBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureFileIsMutable();
                    this.file_.add(index, value);
                    onChanged();
                } else {
                    this.fileBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addFile(FileDescriptorProto.Builder builderForValue) {
                if (this.fileBuilder_ == null) {
                    ensureFileIsMutable();
                    this.file_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.fileBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFile(int index, FileDescriptorProto.Builder builderForValue) {
                if (this.fileBuilder_ == null) {
                    ensureFileIsMutable();
                    this.file_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fileBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFile(Iterable<? extends FileDescriptorProto> values) {
                if (this.fileBuilder_ == null) {
                    ensureFileIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.file_);
                    onChanged();
                } else {
                    this.fileBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFile() {
                if (this.fileBuilder_ == null) {
                    this.file_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.fileBuilder_.clear();
                }
                return this;
            }

            public Builder removeFile(int index) {
                if (this.fileBuilder_ == null) {
                    ensureFileIsMutable();
                    this.file_.remove(index);
                    onChanged();
                } else {
                    this.fileBuilder_.remove(index);
                }
                return this;
            }

            public FileDescriptorProto.Builder getFileBuilder(int index) {
                return (FileDescriptorProto.Builder) getFileFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public FileDescriptorProtoOrBuilder getFileOrBuilder(int index) {
                return this.fileBuilder_ == null ? this.file_.get(index) : (FileDescriptorProtoOrBuilder) this.fileBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorSetOrBuilder
            public List<? extends FileDescriptorProtoOrBuilder> getFileOrBuilderList() {
                return this.fileBuilder_ != null ? this.fileBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.file_);
            }

            public FileDescriptorProto.Builder addFileBuilder() {
                return (FileDescriptorProto.Builder) getFileFieldBuilder().addBuilder(FileDescriptorProto.getDefaultInstance());
            }

            public FileDescriptorProto.Builder addFileBuilder(int index) {
                return (FileDescriptorProto.Builder) getFileFieldBuilder().addBuilder(index, FileDescriptorProto.getDefaultInstance());
            }

            public List<FileDescriptorProto.Builder> getFileBuilderList() {
                return getFileFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<FileDescriptorProto, FileDescriptorProto.Builder, FileDescriptorProtoOrBuilder> getFileFieldBuilder() {
                if (this.fileBuilder_ == null) {
                    this.fileBuilder_ = new RepeatedFieldBuilder<>(this.file_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.file_ = null;
                }
                return this.fileBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class FileDescriptorProto extends GeneratedMessage implements FileDescriptorProtoOrBuilder {
        public static final int DEPENDENCY_FIELD_NUMBER = 3;
        public static final int ENUM_TYPE_FIELD_NUMBER = 5;
        public static final int EXTENSION_FIELD_NUMBER = 7;
        public static final int MESSAGE_TYPE_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int PACKAGE_FIELD_NUMBER = 2;
        public static final int SERVICE_FIELD_NUMBER = 6;
        public static final int SOURCE_CODE_INFO_FIELD_NUMBER = 9;
        private static final FileDescriptorProto defaultInstance = new FileDescriptorProto(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private LazyStringList dependency_;
        private List<EnumDescriptorProto> enumType_;
        private List<FieldDescriptorProto> extension_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<DescriptorProto> messageType_;
        private Object name_;
        private FileOptions options_;
        private Object package_;
        private List<ServiceDescriptorProto> service_;
        private SourceCodeInfo sourceCodeInfo_;

        /* synthetic */ FileDescriptorProto(Builder builder, FileDescriptorProto fileDescriptorProto) {
            this(builder);
        }

        private FileDescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private FileDescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static FileDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FileDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f39x4b52780c;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasPackage() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getPackage() {
            Object ref = this.package_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.package_ = s;
            }
            return s;
        }

        private ByteString getPackageBytes() {
            Object ref = this.package_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.package_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<String> getDependencyList() {
            return this.dependency_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getDependencyCount() {
            return this.dependency_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public String getDependency(int index) {
            return this.dependency_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<DescriptorProto> getMessageTypeList() {
            return this.messageType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<? extends DescriptorProtoOrBuilder> getMessageTypeOrBuilderList() {
            return this.messageType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getMessageTypeCount() {
            return this.messageType_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public DescriptorProto getMessageType(int index) {
            return this.messageType_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public DescriptorProtoOrBuilder getMessageTypeOrBuilder(int index) {
            return this.messageType_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public EnumDescriptorProto getEnumType(int index) {
            return this.enumType_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index) {
            return this.enumType_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<ServiceDescriptorProto> getServiceList() {
            return this.service_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<? extends ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList() {
            return this.service_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getServiceCount() {
            return this.service_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ServiceDescriptorProto getService(int index) {
            return this.service_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int index) {
            return this.service_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public int getExtensionCount() {
            return this.extension_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public FieldDescriptorProto getExtension(int index) {
            return this.extension_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index) {
            return this.extension_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public FileOptions getOptions() {
            return this.options_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public FileOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public boolean hasSourceCodeInfo() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public SourceCodeInfo getSourceCodeInfo() {
            return this.sourceCodeInfo_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
        public SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder() {
            return this.sourceCodeInfo_;
        }

        private void initFields() {
            this.name_ = "";
            this.package_ = "";
            this.dependency_ = LazyStringArrayList.EMPTY;
            this.messageType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.service_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.options_ = FileOptions.getDefaultInstance();
            this.sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            for (int i = 0; i < getMessageTypeCount(); i++) {
                if (!getMessageType(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < getEnumTypeCount(); i2++) {
                if (!getEnumType(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < getServiceCount(); i3++) {
                if (!getService(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < getExtensionCount(); i4++) {
                if (!getExtension(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBytes(1, getNameBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeBytes(2, getPackageBytes());
            }
            for (int i = 0; i < this.dependency_.size(); i++) {
                output.writeBytes(3, this.dependency_.getByteString(i));
            }
            for (int i2 = 0; i2 < this.messageType_.size(); i2++) {
                output.writeMessage(4, this.messageType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                output.writeMessage(5, this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.service_.size(); i4++) {
                output.writeMessage(6, this.service_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                output.writeMessage(7, this.extension_.get(i5));
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(8, this.options_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeMessage(9, this.sourceCodeInfo_);
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getNameBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeBytesSize(2, getPackageBytes());
            }
            int dataSize = 0;
            for (int i = 0; i < this.dependency_.size(); i++) {
                dataSize += CodedOutputStream.computeBytesSizeNoTag(this.dependency_.getByteString(i));
            }
            int size3 = size2 + dataSize + (getDependencyList().size() * 1);
            for (int i2 = 0; i2 < this.messageType_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(4, this.messageType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                size3 += CodedOutputStream.computeMessageSize(5, this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.service_.size(); i4++) {
                size3 += CodedOutputStream.computeMessageSize(6, this.service_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                size3 += CodedOutputStream.computeMessageSize(7, this.extension_.get(i5));
            }
            if ((this.bitField0_ & 4) == 4) {
                size3 += CodedOutputStream.computeMessageSize(8, this.options_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size3 += CodedOutputStream.computeMessageSize(9, this.sourceCodeInfo_);
            }
            int size4 = size3 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FileDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FileDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FileDescriptorProtoOrBuilder {
            private int bitField0_;
            private LazyStringList dependency_;
            private RepeatedFieldBuilder<EnumDescriptorProto, EnumDescriptorProto.Builder, EnumDescriptorProtoOrBuilder> enumTypeBuilder_;
            private List<EnumDescriptorProto> enumType_;
            private RepeatedFieldBuilder<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> extensionBuilder_;
            private List<FieldDescriptorProto> extension_;
            private RepeatedFieldBuilder<DescriptorProto, DescriptorProto.Builder, DescriptorProtoOrBuilder> messageTypeBuilder_;
            private List<DescriptorProto> messageType_;
            private Object name_;
            private SingleFieldBuilder<FileOptions, FileOptions.Builder, FileOptionsOrBuilder> optionsBuilder_;
            private FileOptions options_;
            private Object package_;
            private RepeatedFieldBuilder<ServiceDescriptorProto, ServiceDescriptorProto.Builder, ServiceDescriptorProtoOrBuilder> serviceBuilder_;
            private List<ServiceDescriptorProto> service_;
            private SingleFieldBuilder<SourceCodeInfo, SourceCodeInfo.Builder, SourceCodeInfoOrBuilder> sourceCodeInfoBuilder_;
            private SourceCodeInfo sourceCodeInfo_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f39x4b52780c;
            }

            private Builder() {
                this.name_ = "";
                this.package_ = "";
                this.dependency_ = LazyStringArrayList.EMPTY;
                this.messageType_ = Collections.emptyList();
                this.enumType_ = Collections.emptyList();
                this.service_ = Collections.emptyList();
                this.extension_ = Collections.emptyList();
                this.options_ = FileOptions.getDefaultInstance();
                this.sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.package_ = "";
                this.dependency_ = LazyStringArrayList.EMPTY;
                this.messageType_ = Collections.emptyList();
                this.enumType_ = Collections.emptyList();
                this.service_ = Collections.emptyList();
                this.extension_ = Collections.emptyList();
                this.options_ = FileOptions.getDefaultInstance();
                this.sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getMessageTypeFieldBuilder();
                    getEnumTypeFieldBuilder();
                    getServiceFieldBuilder();
                    getExtensionFieldBuilder();
                    getOptionsFieldBuilder();
                    getSourceCodeInfoFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.name_ = "";
                this.bitField0_ &= -2;
                this.package_ = "";
                this.bitField0_ &= -3;
                this.dependency_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -5;
                if (this.messageTypeBuilder_ == null) {
                    this.messageType_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.messageTypeBuilder_.clear();
                }
                if (this.enumTypeBuilder_ == null) {
                    this.enumType_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.enumTypeBuilder_.clear();
                }
                if (this.serviceBuilder_ == null) {
                    this.service_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                } else {
                    this.serviceBuilder_.clear();
                }
                if (this.extensionBuilder_ == null) {
                    this.extension_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                } else {
                    this.extensionBuilder_.clear();
                }
                if (this.optionsBuilder_ == null) {
                    this.options_ = FileOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -129;
                if (this.sourceCodeInfoBuilder_ == null) {
                    this.sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
                } else {
                    this.sourceCodeInfoBuilder_.clear();
                }
                this.bitField0_ &= -257;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FileDescriptorProto.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FileDescriptorProto getDefaultInstanceForType() {
                return FileDescriptorProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileDescriptorProto build() {
                FileDescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public FileDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                FileDescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileDescriptorProto buildPartial() {
                FileDescriptorProto result = new FileDescriptorProto(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ = 0 | 1;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.package_ = this.package_;
                if ((this.bitField0_ & 4) == 4) {
                    this.dependency_ = new UnmodifiableLazyStringList(this.dependency_);
                    this.bitField0_ &= -5;
                }
                result.dependency_ = this.dependency_;
                if (this.messageTypeBuilder_ != null) {
                    result.messageType_ = this.messageTypeBuilder_.build();
                } else {
                    if ((this.bitField0_ & 8) == 8) {
                        this.messageType_ = Collections.unmodifiableList(this.messageType_);
                        this.bitField0_ &= -9;
                    }
                    result.messageType_ = this.messageType_;
                }
                if (this.enumTypeBuilder_ != null) {
                    result.enumType_ = this.enumTypeBuilder_.build();
                } else {
                    if ((this.bitField0_ & 16) == 16) {
                        this.enumType_ = Collections.unmodifiableList(this.enumType_);
                        this.bitField0_ &= -17;
                    }
                    result.enumType_ = this.enumType_;
                }
                if (this.serviceBuilder_ != null) {
                    result.service_ = this.serviceBuilder_.build();
                } else {
                    if ((this.bitField0_ & 32) == 32) {
                        this.service_ = Collections.unmodifiableList(this.service_);
                        this.bitField0_ &= -33;
                    }
                    result.service_ = this.service_;
                }
                if (this.extensionBuilder_ != null) {
                    result.extension_ = this.extensionBuilder_.build();
                } else {
                    if ((this.bitField0_ & 64) == 64) {
                        this.extension_ = Collections.unmodifiableList(this.extension_);
                        this.bitField0_ &= -65;
                    }
                    result.extension_ = this.extension_;
                }
                if ((from_bitField0_ & 128) == 128) {
                    to_bitField0_ |= 4;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (FileOptions) this.optionsBuilder_.build();
                }
                if ((from_bitField0_ & 256) == 256) {
                    to_bitField0_ |= 8;
                }
                if (this.sourceCodeInfoBuilder_ == null) {
                    result.sourceCodeInfo_ = this.sourceCodeInfo_;
                } else {
                    result.sourceCodeInfo_ = (SourceCodeInfo) this.sourceCodeInfoBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof FileDescriptorProto) {
                    return mergeFrom((FileDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FileDescriptorProto other) {
                if (other != FileDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (other.hasPackage()) {
                        setPackage(other.getPackage());
                    }
                    if (!other.dependency_.isEmpty()) {
                        if (this.dependency_.isEmpty()) {
                            this.dependency_ = other.dependency_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureDependencyIsMutable();
                            this.dependency_.addAll(other.dependency_);
                        }
                        onChanged();
                    }
                    if (this.messageTypeBuilder_ == null) {
                        if (!other.messageType_.isEmpty()) {
                            if (this.messageType_.isEmpty()) {
                                this.messageType_ = other.messageType_;
                                this.bitField0_ &= -9;
                            } else {
                                ensureMessageTypeIsMutable();
                                this.messageType_.addAll(other.messageType_);
                            }
                            onChanged();
                        }
                    } else if (!other.messageType_.isEmpty()) {
                        if (!this.messageTypeBuilder_.isEmpty()) {
                            this.messageTypeBuilder_.addAllMessages(other.messageType_);
                        } else {
                            this.messageTypeBuilder_.dispose();
                            this.messageTypeBuilder_ = null;
                            this.messageType_ = other.messageType_;
                            this.bitField0_ &= -9;
                            this.messageTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getMessageTypeFieldBuilder() : null;
                        }
                    }
                    if (this.enumTypeBuilder_ == null) {
                        if (!other.enumType_.isEmpty()) {
                            if (this.enumType_.isEmpty()) {
                                this.enumType_ = other.enumType_;
                                this.bitField0_ &= -17;
                            } else {
                                ensureEnumTypeIsMutable();
                                this.enumType_.addAll(other.enumType_);
                            }
                            onChanged();
                        }
                    } else if (!other.enumType_.isEmpty()) {
                        if (!this.enumTypeBuilder_.isEmpty()) {
                            this.enumTypeBuilder_.addAllMessages(other.enumType_);
                        } else {
                            this.enumTypeBuilder_.dispose();
                            this.enumTypeBuilder_ = null;
                            this.enumType_ = other.enumType_;
                            this.bitField0_ &= -17;
                            this.enumTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getEnumTypeFieldBuilder() : null;
                        }
                    }
                    if (this.serviceBuilder_ == null) {
                        if (!other.service_.isEmpty()) {
                            if (this.service_.isEmpty()) {
                                this.service_ = other.service_;
                                this.bitField0_ &= -33;
                            } else {
                                ensureServiceIsMutable();
                                this.service_.addAll(other.service_);
                            }
                            onChanged();
                        }
                    } else if (!other.service_.isEmpty()) {
                        if (!this.serviceBuilder_.isEmpty()) {
                            this.serviceBuilder_.addAllMessages(other.service_);
                        } else {
                            this.serviceBuilder_.dispose();
                            this.serviceBuilder_ = null;
                            this.service_ = other.service_;
                            this.bitField0_ &= -33;
                            this.serviceBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getServiceFieldBuilder() : null;
                        }
                    }
                    if (this.extensionBuilder_ == null) {
                        if (!other.extension_.isEmpty()) {
                            if (this.extension_.isEmpty()) {
                                this.extension_ = other.extension_;
                                this.bitField0_ &= -65;
                            } else {
                                ensureExtensionIsMutable();
                                this.extension_.addAll(other.extension_);
                            }
                            onChanged();
                        }
                    } else if (!other.extension_.isEmpty()) {
                        if (!this.extensionBuilder_.isEmpty()) {
                            this.extensionBuilder_.addAllMessages(other.extension_);
                        } else {
                            this.extensionBuilder_.dispose();
                            this.extensionBuilder_ = null;
                            this.extension_ = other.extension_;
                            this.bitField0_ &= -65;
                            this.extensionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getExtensionFieldBuilder() : null;
                        }
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    if (other.hasSourceCodeInfo()) {
                        mergeSourceCodeInfo(other.getSourceCodeInfo());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getMessageTypeCount(); i++) {
                    if (!getMessageType(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i2 = 0; i2 < getEnumTypeCount(); i2++) {
                    if (!getEnumType(i2).isInitialized()) {
                        return false;
                    }
                }
                for (int i3 = 0; i3 < getServiceCount(); i3++) {
                    if (!getService(i3).isInitialized()) {
                        return false;
                    }
                }
                for (int i4 = 0; i4 < getExtensionCount(); i4++) {
                    if (!getExtension(i4).isInitialized()) {
                        return false;
                    }
                }
                return !hasOptions() || getOptions().isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.name_ = input.readBytes();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.package_ = input.readBytes();
                            break;
                        case 26:
                            ensureDependencyIsMutable();
                            this.dependency_.add(input.readBytes());
                            break;
                        case 34:
                            DescriptorProto.Builder subBuilder = DescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addMessageType(subBuilder.buildPartial());
                            break;
                        case 42:
                            EnumDescriptorProto.Builder subBuilder2 = EnumDescriptorProto.newBuilder();
                            input.readMessage(subBuilder2, extensionRegistry);
                            addEnumType(subBuilder2.buildPartial());
                            break;
                        case 50:
                            ServiceDescriptorProto.Builder subBuilder3 = ServiceDescriptorProto.newBuilder();
                            input.readMessage(subBuilder3, extensionRegistry);
                            addService(subBuilder3.buildPartial());
                            break;
                        case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SECOND_DISPLAY /* 58 */:
                            FieldDescriptorProto.Builder subBuilder4 = FieldDescriptorProto.newBuilder();
                            input.readMessage(subBuilder4, extensionRegistry);
                            addExtension(subBuilder4.buildPartial());
                            break;
                        case 66:
                            FileOptions.Builder subBuilder5 = FileOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder5.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder5, extensionRegistry);
                            setOptions(subBuilder5.buildPartial());
                            break;
                        case SPenImageFilterConstants.FILTER_COLORSKETCH /* 74 */:
                            SourceCodeInfo.Builder subBuilder6 = SourceCodeInfo.newBuilder();
                            if (hasSourceCodeInfo()) {
                                subBuilder6.mergeFrom(getSourceCodeInfo());
                            }
                            input.readMessage(subBuilder6, extensionRegistry);
                            setSourceCodeInfo(subBuilder6.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = FileDescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasPackage() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getPackage() {
                Object ref = this.package_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.package_ = s;
                return s;
            }

            public Builder setPackage(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.package_ = value;
                onChanged();
                return this;
            }

            public Builder clearPackage() {
                this.bitField0_ &= -3;
                this.package_ = FileDescriptorProto.getDefaultInstance().getPackage();
                onChanged();
                return this;
            }

            void setPackage(ByteString value) {
                this.bitField0_ |= 2;
                this.package_ = value;
                onChanged();
            }

            private void ensureDependencyIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.dependency_ = new LazyStringArrayList(this.dependency_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<String> getDependencyList() {
                return Collections.unmodifiableList(this.dependency_);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getDependencyCount() {
                return this.dependency_.size();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public String getDependency(int index) {
                return this.dependency_.get(index);
            }

            public Builder setDependency(int index, String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureDependencyIsMutable();
                this.dependency_.set(index, value);
                onChanged();
                return this;
            }

            public Builder addDependency(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureDependencyIsMutable();
                this.dependency_.add((LazyStringList) value);
                onChanged();
                return this;
            }

            public Builder addAllDependency(Iterable<String> values) {
                ensureDependencyIsMutable();
                GeneratedMessage.Builder.addAll(values, this.dependency_);
                onChanged();
                return this;
            }

            public Builder clearDependency() {
                this.dependency_ = LazyStringArrayList.EMPTY;
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            void addDependency(ByteString value) {
                ensureDependencyIsMutable();
                this.dependency_.add(value);
                onChanged();
            }

            private void ensureMessageTypeIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.messageType_ = new ArrayList(this.messageType_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<DescriptorProto> getMessageTypeList() {
                return this.messageTypeBuilder_ == null ? Collections.unmodifiableList(this.messageType_) : this.messageTypeBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getMessageTypeCount() {
                return this.messageTypeBuilder_ == null ? this.messageType_.size() : this.messageTypeBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public DescriptorProto getMessageType(int index) {
                return this.messageTypeBuilder_ == null ? this.messageType_.get(index) : (DescriptorProto) this.messageTypeBuilder_.getMessage(index);
            }

            public Builder setMessageType(int index, DescriptorProto value) {
                if (this.messageTypeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMessageTypeIsMutable();
                    this.messageType_.set(index, value);
                    onChanged();
                } else {
                    this.messageTypeBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setMessageType(int index, DescriptorProto.Builder builderForValue) {
                if (this.messageTypeBuilder_ == null) {
                    ensureMessageTypeIsMutable();
                    this.messageType_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.messageTypeBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMessageType(DescriptorProto value) {
                if (this.messageTypeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMessageTypeIsMutable();
                    this.messageType_.add(value);
                    onChanged();
                } else {
                    this.messageTypeBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addMessageType(int index, DescriptorProto value) {
                if (this.messageTypeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMessageTypeIsMutable();
                    this.messageType_.add(index, value);
                    onChanged();
                } else {
                    this.messageTypeBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addMessageType(DescriptorProto.Builder builderForValue) {
                if (this.messageTypeBuilder_ == null) {
                    ensureMessageTypeIsMutable();
                    this.messageType_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.messageTypeBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMessageType(int index, DescriptorProto.Builder builderForValue) {
                if (this.messageTypeBuilder_ == null) {
                    ensureMessageTypeIsMutable();
                    this.messageType_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.messageTypeBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMessageType(Iterable<? extends DescriptorProto> values) {
                if (this.messageTypeBuilder_ == null) {
                    ensureMessageTypeIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.messageType_);
                    onChanged();
                } else {
                    this.messageTypeBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMessageType() {
                if (this.messageTypeBuilder_ == null) {
                    this.messageType_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.messageTypeBuilder_.clear();
                }
                return this;
            }

            public Builder removeMessageType(int index) {
                if (this.messageTypeBuilder_ == null) {
                    ensureMessageTypeIsMutable();
                    this.messageType_.remove(index);
                    onChanged();
                } else {
                    this.messageTypeBuilder_.remove(index);
                }
                return this;
            }

            public DescriptorProto.Builder getMessageTypeBuilder(int index) {
                return (DescriptorProto.Builder) getMessageTypeFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public DescriptorProtoOrBuilder getMessageTypeOrBuilder(int index) {
                return this.messageTypeBuilder_ == null ? this.messageType_.get(index) : (DescriptorProtoOrBuilder) this.messageTypeBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<? extends DescriptorProtoOrBuilder> getMessageTypeOrBuilderList() {
                return this.messageTypeBuilder_ != null ? this.messageTypeBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.messageType_);
            }

            public DescriptorProto.Builder addMessageTypeBuilder() {
                return (DescriptorProto.Builder) getMessageTypeFieldBuilder().addBuilder(DescriptorProto.getDefaultInstance());
            }

            public DescriptorProto.Builder addMessageTypeBuilder(int index) {
                return (DescriptorProto.Builder) getMessageTypeFieldBuilder().addBuilder(index, DescriptorProto.getDefaultInstance());
            }

            public List<DescriptorProto.Builder> getMessageTypeBuilderList() {
                return getMessageTypeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<DescriptorProto, DescriptorProto.Builder, DescriptorProtoOrBuilder> getMessageTypeFieldBuilder() {
                if (this.messageTypeBuilder_ == null) {
                    this.messageTypeBuilder_ = new RepeatedFieldBuilder<>(this.messageType_, (this.bitField0_ & 8) == 8, getParentForChildren(), isClean());
                    this.messageType_ = null;
                }
                return this.messageTypeBuilder_;
            }

            private void ensureEnumTypeIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.enumType_ = new ArrayList(this.enumType_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<EnumDescriptorProto> getEnumTypeList() {
                return this.enumTypeBuilder_ == null ? Collections.unmodifiableList(this.enumType_) : this.enumTypeBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getEnumTypeCount() {
                return this.enumTypeBuilder_ == null ? this.enumType_.size() : this.enumTypeBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public EnumDescriptorProto getEnumType(int index) {
                return this.enumTypeBuilder_ == null ? this.enumType_.get(index) : (EnumDescriptorProto) this.enumTypeBuilder_.getMessage(index);
            }

            public Builder setEnumType(int index, EnumDescriptorProto value) {
                if (this.enumTypeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureEnumTypeIsMutable();
                    this.enumType_.set(index, value);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setEnumType(int index, EnumDescriptorProto.Builder builderForValue) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.enumTypeBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto value) {
                if (this.enumTypeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(value);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addEnumType(int index, EnumDescriptorProto value) {
                if (this.enumTypeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(index, value);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto.Builder builderForValue) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addEnumType(int index, EnumDescriptorProto.Builder builderForValue) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> values) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.enumType_);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearEnumType() {
                if (this.enumTypeBuilder_ == null) {
                    this.enumType_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.enumTypeBuilder_.clear();
                }
                return this;
            }

            public Builder removeEnumType(int index) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.remove(index);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.remove(index);
                }
                return this;
            }

            public EnumDescriptorProto.Builder getEnumTypeBuilder(int index) {
                return (EnumDescriptorProto.Builder) getEnumTypeFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index) {
                return this.enumTypeBuilder_ == null ? this.enumType_.get(index) : (EnumDescriptorProtoOrBuilder) this.enumTypeBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
                return this.enumTypeBuilder_ != null ? this.enumTypeBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.enumType_);
            }

            public EnumDescriptorProto.Builder addEnumTypeBuilder() {
                return (EnumDescriptorProto.Builder) getEnumTypeFieldBuilder().addBuilder(EnumDescriptorProto.getDefaultInstance());
            }

            public EnumDescriptorProto.Builder addEnumTypeBuilder(int index) {
                return (EnumDescriptorProto.Builder) getEnumTypeFieldBuilder().addBuilder(index, EnumDescriptorProto.getDefaultInstance());
            }

            public List<EnumDescriptorProto.Builder> getEnumTypeBuilderList() {
                return getEnumTypeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<EnumDescriptorProto, EnumDescriptorProto.Builder, EnumDescriptorProtoOrBuilder> getEnumTypeFieldBuilder() {
                if (this.enumTypeBuilder_ == null) {
                    this.enumTypeBuilder_ = new RepeatedFieldBuilder<>(this.enumType_, (this.bitField0_ & 16) == 16, getParentForChildren(), isClean());
                    this.enumType_ = null;
                }
                return this.enumTypeBuilder_;
            }

            private void ensureServiceIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.service_ = new ArrayList(this.service_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<ServiceDescriptorProto> getServiceList() {
                return this.serviceBuilder_ == null ? Collections.unmodifiableList(this.service_) : this.serviceBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getServiceCount() {
                return this.serviceBuilder_ == null ? this.service_.size() : this.serviceBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ServiceDescriptorProto getService(int index) {
                return this.serviceBuilder_ == null ? this.service_.get(index) : (ServiceDescriptorProto) this.serviceBuilder_.getMessage(index);
            }

            public Builder setService(int index, ServiceDescriptorProto value) {
                if (this.serviceBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureServiceIsMutable();
                    this.service_.set(index, value);
                    onChanged();
                } else {
                    this.serviceBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setService(int index, ServiceDescriptorProto.Builder builderForValue) {
                if (this.serviceBuilder_ == null) {
                    ensureServiceIsMutable();
                    this.service_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.serviceBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addService(ServiceDescriptorProto value) {
                if (this.serviceBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureServiceIsMutable();
                    this.service_.add(value);
                    onChanged();
                } else {
                    this.serviceBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addService(int index, ServiceDescriptorProto value) {
                if (this.serviceBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureServiceIsMutable();
                    this.service_.add(index, value);
                    onChanged();
                } else {
                    this.serviceBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addService(ServiceDescriptorProto.Builder builderForValue) {
                if (this.serviceBuilder_ == null) {
                    ensureServiceIsMutable();
                    this.service_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.serviceBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addService(int index, ServiceDescriptorProto.Builder builderForValue) {
                if (this.serviceBuilder_ == null) {
                    ensureServiceIsMutable();
                    this.service_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.serviceBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllService(Iterable<? extends ServiceDescriptorProto> values) {
                if (this.serviceBuilder_ == null) {
                    ensureServiceIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.service_);
                    onChanged();
                } else {
                    this.serviceBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearService() {
                if (this.serviceBuilder_ == null) {
                    this.service_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                    onChanged();
                } else {
                    this.serviceBuilder_.clear();
                }
                return this;
            }

            public Builder removeService(int index) {
                if (this.serviceBuilder_ == null) {
                    ensureServiceIsMutable();
                    this.service_.remove(index);
                    onChanged();
                } else {
                    this.serviceBuilder_.remove(index);
                }
                return this;
            }

            public ServiceDescriptorProto.Builder getServiceBuilder(int index) {
                return (ServiceDescriptorProto.Builder) getServiceFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public ServiceDescriptorProtoOrBuilder getServiceOrBuilder(int index) {
                return this.serviceBuilder_ == null ? this.service_.get(index) : (ServiceDescriptorProtoOrBuilder) this.serviceBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<? extends ServiceDescriptorProtoOrBuilder> getServiceOrBuilderList() {
                return this.serviceBuilder_ != null ? this.serviceBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.service_);
            }

            public ServiceDescriptorProto.Builder addServiceBuilder() {
                return (ServiceDescriptorProto.Builder) getServiceFieldBuilder().addBuilder(ServiceDescriptorProto.getDefaultInstance());
            }

            public ServiceDescriptorProto.Builder addServiceBuilder(int index) {
                return (ServiceDescriptorProto.Builder) getServiceFieldBuilder().addBuilder(index, ServiceDescriptorProto.getDefaultInstance());
            }

            public List<ServiceDescriptorProto.Builder> getServiceBuilderList() {
                return getServiceFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ServiceDescriptorProto, ServiceDescriptorProto.Builder, ServiceDescriptorProtoOrBuilder> getServiceFieldBuilder() {
                if (this.serviceBuilder_ == null) {
                    this.serviceBuilder_ = new RepeatedFieldBuilder<>(this.service_, (this.bitField0_ & 32) == 32, getParentForChildren(), isClean());
                    this.service_ = null;
                }
                return this.serviceBuilder_;
            }

            private void ensureExtensionIsMutable() {
                if ((this.bitField0_ & 64) != 64) {
                    this.extension_ = new ArrayList(this.extension_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<FieldDescriptorProto> getExtensionList() {
                return this.extensionBuilder_ == null ? Collections.unmodifiableList(this.extension_) : this.extensionBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public int getExtensionCount() {
                return this.extensionBuilder_ == null ? this.extension_.size() : this.extensionBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public FieldDescriptorProto getExtension(int index) {
                return this.extensionBuilder_ == null ? this.extension_.get(index) : (FieldDescriptorProto) this.extensionBuilder_.getMessage(index);
            }

            public Builder setExtension(int index, FieldDescriptorProto value) {
                if (this.extensionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureExtensionIsMutable();
                    this.extension_.set(index, value);
                    onChanged();
                } else {
                    this.extensionBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setExtension(int index, FieldDescriptorProto.Builder builderForValue) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extensionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExtension(FieldDescriptorProto value) {
                if (this.extensionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureExtensionIsMutable();
                    this.extension_.add(value);
                    onChanged();
                } else {
                    this.extensionBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addExtension(int index, FieldDescriptorProto value) {
                if (this.extensionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureExtensionIsMutable();
                    this.extension_.add(index, value);
                    onChanged();
                } else {
                    this.extensionBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addExtension(FieldDescriptorProto.Builder builderForValue) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.extensionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExtension(int index, FieldDescriptorProto.Builder builderForValue) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extensionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> values) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.extension_);
                    onChanged();
                } else {
                    this.extensionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExtension() {
                if (this.extensionBuilder_ == null) {
                    this.extension_ = Collections.emptyList();
                    this.bitField0_ &= -65;
                    onChanged();
                } else {
                    this.extensionBuilder_.clear();
                }
                return this;
            }

            public Builder removeExtension(int index) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.remove(index);
                    onChanged();
                } else {
                    this.extensionBuilder_.remove(index);
                }
                return this;
            }

            public FieldDescriptorProto.Builder getExtensionBuilder(int index) {
                return (FieldDescriptorProto.Builder) getExtensionFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index) {
                return this.extensionBuilder_ == null ? this.extension_.get(index) : (FieldDescriptorProtoOrBuilder) this.extensionBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
                return this.extensionBuilder_ != null ? this.extensionBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.extension_);
            }

            public FieldDescriptorProto.Builder addExtensionBuilder() {
                return (FieldDescriptorProto.Builder) getExtensionFieldBuilder().addBuilder(FieldDescriptorProto.getDefaultInstance());
            }

            public FieldDescriptorProto.Builder addExtensionBuilder(int index) {
                return (FieldDescriptorProto.Builder) getExtensionFieldBuilder().addBuilder(index, FieldDescriptorProto.getDefaultInstance());
            }

            public List<FieldDescriptorProto.Builder> getExtensionBuilderList() {
                return getExtensionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> getExtensionFieldBuilder() {
                if (this.extensionBuilder_ == null) {
                    this.extensionBuilder_ = new RepeatedFieldBuilder<>(this.extension_, (this.bitField0_ & 64) == 64, getParentForChildren(), isClean());
                    this.extension_ = null;
                }
                return this.extensionBuilder_;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return (this.bitField0_ & 128) == 128;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public FileOptions getOptions() {
                return this.optionsBuilder_ == null ? this.options_ : (FileOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(FileOptions value) {
                if (this.optionsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.options_ = value;
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(value);
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder setOptions(FileOptions.Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder mergeOptions(FileOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & 128) == 128 && this.options_ != FileOptions.getDefaultInstance()) {
                        this.options_ = FileOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    } else {
                        this.options_ = value;
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = FileOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -129;
                return this;
            }

            public FileOptions.Builder getOptionsBuilder() {
                this.bitField0_ |= 128;
                onChanged();
                return (FileOptions.Builder) getOptionsFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public FileOptionsOrBuilder getOptionsOrBuilder() {
                return this.optionsBuilder_ != null ? (FileOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder() : this.options_;
            }

            private SingleFieldBuilder<FileOptions, FileOptions.Builder, FileOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder<>(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public boolean hasSourceCodeInfo() {
                return (this.bitField0_ & 256) == 256;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public SourceCodeInfo getSourceCodeInfo() {
                return this.sourceCodeInfoBuilder_ == null ? this.sourceCodeInfo_ : (SourceCodeInfo) this.sourceCodeInfoBuilder_.getMessage();
            }

            public Builder setSourceCodeInfo(SourceCodeInfo value) {
                if (this.sourceCodeInfoBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.sourceCodeInfo_ = value;
                    onChanged();
                } else {
                    this.sourceCodeInfoBuilder_.setMessage(value);
                }
                this.bitField0_ |= 256;
                return this;
            }

            public Builder setSourceCodeInfo(SourceCodeInfo.Builder builderForValue) {
                if (this.sourceCodeInfoBuilder_ == null) {
                    this.sourceCodeInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.sourceCodeInfoBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 256;
                return this;
            }

            public Builder mergeSourceCodeInfo(SourceCodeInfo value) {
                if (this.sourceCodeInfoBuilder_ == null) {
                    if ((this.bitField0_ & 256) == 256 && this.sourceCodeInfo_ != SourceCodeInfo.getDefaultInstance()) {
                        this.sourceCodeInfo_ = SourceCodeInfo.newBuilder(this.sourceCodeInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.sourceCodeInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.sourceCodeInfoBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 256;
                return this;
            }

            public Builder clearSourceCodeInfo() {
                if (this.sourceCodeInfoBuilder_ == null) {
                    this.sourceCodeInfo_ = SourceCodeInfo.getDefaultInstance();
                    onChanged();
                } else {
                    this.sourceCodeInfoBuilder_.clear();
                }
                this.bitField0_ &= -257;
                return this;
            }

            public SourceCodeInfo.Builder getSourceCodeInfoBuilder() {
                this.bitField0_ |= 256;
                onChanged();
                return (SourceCodeInfo.Builder) getSourceCodeInfoFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileDescriptorProtoOrBuilder
            public SourceCodeInfoOrBuilder getSourceCodeInfoOrBuilder() {
                return this.sourceCodeInfoBuilder_ != null ? (SourceCodeInfoOrBuilder) this.sourceCodeInfoBuilder_.getMessageOrBuilder() : this.sourceCodeInfo_;
            }

            private SingleFieldBuilder<SourceCodeInfo, SourceCodeInfo.Builder, SourceCodeInfoOrBuilder> getSourceCodeInfoFieldBuilder() {
                if (this.sourceCodeInfoBuilder_ == null) {
                    this.sourceCodeInfoBuilder_ = new SingleFieldBuilder<>(this.sourceCodeInfo_, getParentForChildren(), isClean());
                    this.sourceCodeInfo_ = null;
                }
                return this.sourceCodeInfoBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class DescriptorProto extends GeneratedMessage implements DescriptorProtoOrBuilder {
        public static final int ENUM_TYPE_FIELD_NUMBER = 4;
        public static final int EXTENSION_FIELD_NUMBER = 6;
        public static final int EXTENSION_RANGE_FIELD_NUMBER = 5;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NESTED_TYPE_FIELD_NUMBER = 3;
        public static final int OPTIONS_FIELD_NUMBER = 7;
        private static final DescriptorProto defaultInstance = new DescriptorProto(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private List<EnumDescriptorProto> enumType_;
        private List<ExtensionRange> extensionRange_;
        private List<FieldDescriptorProto> extension_;
        private List<FieldDescriptorProto> field_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private List<DescriptorProto> nestedType_;
        private MessageOptions options_;

        public interface ExtensionRangeOrBuilder extends MessageOrBuilder {
            int getEnd();

            int getStart();

            boolean hasEnd();

            boolean hasStart();
        }

        /* synthetic */ DescriptorProto(Builder builder, DescriptorProto descriptorProto) {
            this(builder);
        }

        private DescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private DescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static DescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f33x907d0bf0;
        }

        public static final class ExtensionRange extends GeneratedMessage implements ExtensionRangeOrBuilder {
            public static final int END_FIELD_NUMBER = 2;
            public static final int START_FIELD_NUMBER = 1;
            private static final ExtensionRange defaultInstance = new ExtensionRange(true);
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private int end_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int start_;

            /* synthetic */ ExtensionRange(Builder builder, ExtensionRange extensionRange) {
                this(builder);
            }

            private ExtensionRange(Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            private ExtensionRange(boolean noInit) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            public static ExtensionRange getDefaultInstance() {
                return defaultInstance;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ExtensionRange getDefaultInstanceForType() {
                return defaultInstance;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.f31x1458f8d;
            }

            @Override // com.google.protobuf.GeneratedMessage
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f32xf366d90b;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public boolean hasStart() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public int getStart() {
                return this.start_;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public boolean hasEnd() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
            public int getEnd() {
                return this.end_;
            }

            private void initFields() {
                this.start_ = 0;
                this.end_ = 0;
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte isInitialized = this.memoizedIsInitialized;
                if (isInitialized != -1) {
                    return isInitialized == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream output) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    output.writeInt32(1, this.start_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeInt32(2, this.end_);
                }
                getUnknownFields().writeTo(output);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                int size2 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.start_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    size2 += CodedOutputStream.computeInt32Size(2, this.end_);
                }
                int size3 = size2 + getUnknownFields().getSerializedSize();
                this.memoizedSerializedSize = size3;
                return size3;
            }

            @Override // com.google.protobuf.GeneratedMessage
            protected Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static ExtensionRange parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static ExtensionRange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static ExtensionRange parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static ExtensionRange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static ExtensionRange parseFrom(InputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static ExtensionRange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
            }

            public static ExtensionRange parseDelimitedFrom(InputStream input) throws IOException {
                Builder builder = newBuilder();
                if (builder.mergeDelimitedFrom(input)) {
                    return builder.buildParsed();
                }
                return null;
            }

            public static ExtensionRange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Builder builder = newBuilder();
                if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                    return builder.buildParsed();
                }
                return null;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static ExtensionRange parseFrom(CodedInputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            public static ExtensionRange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(ExtensionRange prototype) {
                return newBuilder().mergeFrom(prototype);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder toBuilder() {
                return newBuilder(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessage
            public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
                Builder builder = new Builder(parent, null);
                return builder;
            }

            public static final class Builder extends GeneratedMessage.Builder<Builder> implements ExtensionRangeOrBuilder {
                private int bitField0_;
                private int end_;
                private int start_;

                public static final Descriptors.Descriptor getDescriptor() {
                    return DescriptorProtos.f31x1458f8d;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder
                protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                    return DescriptorProtos.f32xf366d90b;
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                    this(builderParent);
                }

                private Builder(GeneratedMessage.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean z = GeneratedMessage.alwaysUseFieldBuilders;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static Builder create() {
                    return new Builder();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.start_ = 0;
                    this.bitField0_ &= -2;
                    this.end_ = 0;
                    this.bitField0_ &= -3;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                /* renamed from: clone */
                public Builder m3102clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return ExtensionRange.getDescriptor();
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public ExtensionRange getDefaultInstanceForType() {
                    return ExtensionRange.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public ExtensionRange build() {
                    ExtensionRange result = buildPartial();
                    if (!result.isInitialized()) {
                        throw newUninitializedMessageException((Message) result);
                    }
                    return result;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public ExtensionRange buildParsed() throws InvalidProtocolBufferException {
                    ExtensionRange result = buildPartial();
                    if (!result.isInitialized()) {
                        throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                    }
                    return result;
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public ExtensionRange buildPartial() {
                    ExtensionRange result = new ExtensionRange(this, null);
                    int from_bitField0_ = this.bitField0_;
                    int to_bitField0_ = 0;
                    if ((from_bitField0_ & 1) == 1) {
                        to_bitField0_ = 0 | 1;
                    }
                    result.start_ = this.start_;
                    if ((from_bitField0_ & 2) == 2) {
                        to_bitField0_ |= 2;
                    }
                    result.end_ = this.end_;
                    result.bitField0_ = to_bitField0_;
                    onBuilt();
                    return result;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message other) {
                    if (other instanceof ExtensionRange) {
                        return mergeFrom((ExtensionRange) other);
                    }
                    super.mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(ExtensionRange other) {
                    if (other != ExtensionRange.getDefaultInstance()) {
                        if (other.hasStart()) {
                            setStart(other.getStart());
                        }
                        if (other.hasEnd()) {
                            setEnd(other.getEnd());
                        }
                        mergeUnknownFields(other.getUnknownFields());
                    }
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                    while (true) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            case 8:
                                this.bitField0_ |= 1;
                                this.start_ = input.readInt32();
                                break;
                            case 16:
                                this.bitField0_ |= 2;
                                this.end_ = input.readInt32();
                                break;
                            default:
                                if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    setUnknownFields(unknownFields.build());
                                    onChanged();
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public boolean hasStart() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public int getStart() {
                    return this.start_;
                }

                public Builder setStart(int value) {
                    this.bitField0_ |= 1;
                    this.start_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearStart() {
                    this.bitField0_ &= -2;
                    this.start_ = 0;
                    onChanged();
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public boolean hasEnd() {
                    return (this.bitField0_ & 2) == 2;
                }

                @Override // com.google.protobuf.DescriptorProtos.DescriptorProto.ExtensionRangeOrBuilder
                public int getEnd() {
                    return this.end_;
                }

                public Builder setEnd(int value) {
                    this.bitField0_ |= 2;
                    this.end_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearEnd() {
                    this.bitField0_ &= -3;
                    this.end_ = 0;
                    onChanged();
                    return this;
                }
            }

            static {
                defaultInstance.initFields();
            }
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<FieldDescriptorProto> getFieldList() {
            return this.field_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<? extends FieldDescriptorProtoOrBuilder> getFieldOrBuilderList() {
            return this.field_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getFieldCount() {
            return this.field_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public FieldDescriptorProto getField(int index) {
            return this.field_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public FieldDescriptorProtoOrBuilder getFieldOrBuilder(int index) {
            return this.field_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<FieldDescriptorProto> getExtensionList() {
            return this.extension_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
            return this.extension_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getExtensionCount() {
            return this.extension_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public FieldDescriptorProto getExtension(int index) {
            return this.extension_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index) {
            return this.extension_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<DescriptorProto> getNestedTypeList() {
            return this.nestedType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<? extends DescriptorProtoOrBuilder> getNestedTypeOrBuilderList() {
            return this.nestedType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getNestedTypeCount() {
            return this.nestedType_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public DescriptorProto getNestedType(int index) {
            return this.nestedType_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public DescriptorProtoOrBuilder getNestedTypeOrBuilder(int index) {
            return this.nestedType_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<EnumDescriptorProto> getEnumTypeList() {
            return this.enumType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
            return this.enumType_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getEnumTypeCount() {
            return this.enumType_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public EnumDescriptorProto getEnumType(int index) {
            return this.enumType_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index) {
            return this.enumType_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<ExtensionRange> getExtensionRangeList() {
            return this.extensionRange_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public List<? extends ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList() {
            return this.extensionRange_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public int getExtensionRangeCount() {
            return this.extensionRange_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ExtensionRange getExtensionRange(int index) {
            return this.extensionRange_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int index) {
            return this.extensionRange_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public MessageOptions getOptions() {
            return this.options_;
        }

        @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
        public MessageOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        private void initFields() {
            this.name_ = "";
            this.field_ = Collections.emptyList();
            this.extension_ = Collections.emptyList();
            this.nestedType_ = Collections.emptyList();
            this.enumType_ = Collections.emptyList();
            this.extensionRange_ = Collections.emptyList();
            this.options_ = MessageOptions.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            for (int i = 0; i < getFieldCount(); i++) {
                if (!getField(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i2 = 0; i2 < getExtensionCount(); i2++) {
                if (!getExtension(i2).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i3 = 0; i3 < getNestedTypeCount(); i3++) {
                if (!getNestedType(i3).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i4 = 0; i4 < getEnumTypeCount(); i4++) {
                if (!getEnumType(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBytes(1, getNameBytes());
            }
            for (int i = 0; i < this.field_.size(); i++) {
                output.writeMessage(2, this.field_.get(i));
            }
            for (int i2 = 0; i2 < this.nestedType_.size(); i2++) {
                output.writeMessage(3, this.nestedType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                output.writeMessage(4, this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.extensionRange_.size(); i4++) {
                output.writeMessage(5, this.extensionRange_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                output.writeMessage(6, this.extension_.get(i5));
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(7, this.options_);
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getNameBytes()) : 0;
            for (int i = 0; i < this.field_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.field_.get(i));
            }
            for (int i2 = 0; i2 < this.nestedType_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.nestedType_.get(i2));
            }
            for (int i3 = 0; i3 < this.enumType_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.enumType_.get(i3));
            }
            for (int i4 = 0; i4 < this.extensionRange_.size(); i4++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.extensionRange_.get(i4));
            }
            for (int i5 = 0; i5 < this.extension_.size(); i5++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.extension_.get(i5));
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeMessageSize(7, this.options_);
            }
            int size3 = size2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static DescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static DescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static DescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static DescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static DescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static DescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static DescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static DescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static DescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static DescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(DescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements DescriptorProtoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<EnumDescriptorProto, EnumDescriptorProto.Builder, EnumDescriptorProtoOrBuilder> enumTypeBuilder_;
            private List<EnumDescriptorProto> enumType_;
            private RepeatedFieldBuilder<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> extensionBuilder_;
            private RepeatedFieldBuilder<ExtensionRange, ExtensionRange.Builder, ExtensionRangeOrBuilder> extensionRangeBuilder_;
            private List<ExtensionRange> extensionRange_;
            private List<FieldDescriptorProto> extension_;
            private RepeatedFieldBuilder<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> fieldBuilder_;
            private List<FieldDescriptorProto> field_;
            private Object name_;
            private RepeatedFieldBuilder<DescriptorProto, Builder, DescriptorProtoOrBuilder> nestedTypeBuilder_;
            private List<DescriptorProto> nestedType_;
            private SingleFieldBuilder<MessageOptions, MessageOptions.Builder, MessageOptionsOrBuilder> optionsBuilder_;
            private MessageOptions options_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f33x907d0bf0;
            }

            private Builder() {
                this.name_ = "";
                this.field_ = Collections.emptyList();
                this.extension_ = Collections.emptyList();
                this.nestedType_ = Collections.emptyList();
                this.enumType_ = Collections.emptyList();
                this.extensionRange_ = Collections.emptyList();
                this.options_ = MessageOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.field_ = Collections.emptyList();
                this.extension_ = Collections.emptyList();
                this.nestedType_ = Collections.emptyList();
                this.enumType_ = Collections.emptyList();
                this.extensionRange_ = Collections.emptyList();
                this.options_ = MessageOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getFieldFieldBuilder();
                    getExtensionFieldBuilder();
                    getNestedTypeFieldBuilder();
                    getEnumTypeFieldBuilder();
                    getExtensionRangeFieldBuilder();
                    getOptionsFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.name_ = "";
                this.bitField0_ &= -2;
                if (this.fieldBuilder_ == null) {
                    this.field_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.fieldBuilder_.clear();
                }
                if (this.extensionBuilder_ == null) {
                    this.extension_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.extensionBuilder_.clear();
                }
                if (this.nestedTypeBuilder_ == null) {
                    this.nestedType_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.nestedTypeBuilder_.clear();
                }
                if (this.enumTypeBuilder_ == null) {
                    this.enumType_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.enumTypeBuilder_.clear();
                }
                if (this.extensionRangeBuilder_ == null) {
                    this.extensionRange_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                } else {
                    this.extensionRangeBuilder_.clear();
                }
                if (this.optionsBuilder_ == null) {
                    this.options_ = MessageOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -65;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DescriptorProto.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DescriptorProto getDefaultInstanceForType() {
                return DescriptorProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DescriptorProto build() {
                DescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public DescriptorProto buildParsed() throws InvalidProtocolBufferException {
                DescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DescriptorProto buildPartial() {
                DescriptorProto result = new DescriptorProto(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ = 0 | 1;
                }
                result.name_ = this.name_;
                if (this.fieldBuilder_ != null) {
                    result.field_ = this.fieldBuilder_.build();
                } else {
                    if ((this.bitField0_ & 2) == 2) {
                        this.field_ = Collections.unmodifiableList(this.field_);
                        this.bitField0_ &= -3;
                    }
                    result.field_ = this.field_;
                }
                if (this.extensionBuilder_ != null) {
                    result.extension_ = this.extensionBuilder_.build();
                } else {
                    if ((this.bitField0_ & 4) == 4) {
                        this.extension_ = Collections.unmodifiableList(this.extension_);
                        this.bitField0_ &= -5;
                    }
                    result.extension_ = this.extension_;
                }
                if (this.nestedTypeBuilder_ != null) {
                    result.nestedType_ = this.nestedTypeBuilder_.build();
                } else {
                    if ((this.bitField0_ & 8) == 8) {
                        this.nestedType_ = Collections.unmodifiableList(this.nestedType_);
                        this.bitField0_ &= -9;
                    }
                    result.nestedType_ = this.nestedType_;
                }
                if (this.enumTypeBuilder_ != null) {
                    result.enumType_ = this.enumTypeBuilder_.build();
                } else {
                    if ((this.bitField0_ & 16) == 16) {
                        this.enumType_ = Collections.unmodifiableList(this.enumType_);
                        this.bitField0_ &= -17;
                    }
                    result.enumType_ = this.enumType_;
                }
                if (this.extensionRangeBuilder_ != null) {
                    result.extensionRange_ = this.extensionRangeBuilder_.build();
                } else {
                    if ((this.bitField0_ & 32) == 32) {
                        this.extensionRange_ = Collections.unmodifiableList(this.extensionRange_);
                        this.bitField0_ &= -33;
                    }
                    result.extensionRange_ = this.extensionRange_;
                }
                if ((from_bitField0_ & 64) == 64) {
                    to_bitField0_ |= 2;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (MessageOptions) this.optionsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof DescriptorProto) {
                    return mergeFrom((DescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DescriptorProto other) {
                if (other != DescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (this.fieldBuilder_ == null) {
                        if (!other.field_.isEmpty()) {
                            if (this.field_.isEmpty()) {
                                this.field_ = other.field_;
                                this.bitField0_ &= -3;
                            } else {
                                ensureFieldIsMutable();
                                this.field_.addAll(other.field_);
                            }
                            onChanged();
                        }
                    } else if (!other.field_.isEmpty()) {
                        if (!this.fieldBuilder_.isEmpty()) {
                            this.fieldBuilder_.addAllMessages(other.field_);
                        } else {
                            this.fieldBuilder_.dispose();
                            this.fieldBuilder_ = null;
                            this.field_ = other.field_;
                            this.bitField0_ &= -3;
                            this.fieldBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getFieldFieldBuilder() : null;
                        }
                    }
                    if (this.extensionBuilder_ == null) {
                        if (!other.extension_.isEmpty()) {
                            if (this.extension_.isEmpty()) {
                                this.extension_ = other.extension_;
                                this.bitField0_ &= -5;
                            } else {
                                ensureExtensionIsMutable();
                                this.extension_.addAll(other.extension_);
                            }
                            onChanged();
                        }
                    } else if (!other.extension_.isEmpty()) {
                        if (!this.extensionBuilder_.isEmpty()) {
                            this.extensionBuilder_.addAllMessages(other.extension_);
                        } else {
                            this.extensionBuilder_.dispose();
                            this.extensionBuilder_ = null;
                            this.extension_ = other.extension_;
                            this.bitField0_ &= -5;
                            this.extensionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getExtensionFieldBuilder() : null;
                        }
                    }
                    if (this.nestedTypeBuilder_ == null) {
                        if (!other.nestedType_.isEmpty()) {
                            if (this.nestedType_.isEmpty()) {
                                this.nestedType_ = other.nestedType_;
                                this.bitField0_ &= -9;
                            } else {
                                ensureNestedTypeIsMutable();
                                this.nestedType_.addAll(other.nestedType_);
                            }
                            onChanged();
                        }
                    } else if (!other.nestedType_.isEmpty()) {
                        if (!this.nestedTypeBuilder_.isEmpty()) {
                            this.nestedTypeBuilder_.addAllMessages(other.nestedType_);
                        } else {
                            this.nestedTypeBuilder_.dispose();
                            this.nestedTypeBuilder_ = null;
                            this.nestedType_ = other.nestedType_;
                            this.bitField0_ &= -9;
                            this.nestedTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getNestedTypeFieldBuilder() : null;
                        }
                    }
                    if (this.enumTypeBuilder_ == null) {
                        if (!other.enumType_.isEmpty()) {
                            if (this.enumType_.isEmpty()) {
                                this.enumType_ = other.enumType_;
                                this.bitField0_ &= -17;
                            } else {
                                ensureEnumTypeIsMutable();
                                this.enumType_.addAll(other.enumType_);
                            }
                            onChanged();
                        }
                    } else if (!other.enumType_.isEmpty()) {
                        if (!this.enumTypeBuilder_.isEmpty()) {
                            this.enumTypeBuilder_.addAllMessages(other.enumType_);
                        } else {
                            this.enumTypeBuilder_.dispose();
                            this.enumTypeBuilder_ = null;
                            this.enumType_ = other.enumType_;
                            this.bitField0_ &= -17;
                            this.enumTypeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getEnumTypeFieldBuilder() : null;
                        }
                    }
                    if (this.extensionRangeBuilder_ == null) {
                        if (!other.extensionRange_.isEmpty()) {
                            if (this.extensionRange_.isEmpty()) {
                                this.extensionRange_ = other.extensionRange_;
                                this.bitField0_ &= -33;
                            } else {
                                ensureExtensionRangeIsMutable();
                                this.extensionRange_.addAll(other.extensionRange_);
                            }
                            onChanged();
                        }
                    } else if (!other.extensionRange_.isEmpty()) {
                        if (!this.extensionRangeBuilder_.isEmpty()) {
                            this.extensionRangeBuilder_.addAllMessages(other.extensionRange_);
                        } else {
                            this.extensionRangeBuilder_.dispose();
                            this.extensionRangeBuilder_ = null;
                            this.extensionRange_ = other.extensionRange_;
                            this.bitField0_ &= -33;
                            this.extensionRangeBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getExtensionRangeFieldBuilder() : null;
                        }
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getFieldCount(); i++) {
                    if (!getField(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i2 = 0; i2 < getExtensionCount(); i2++) {
                    if (!getExtension(i2).isInitialized()) {
                        return false;
                    }
                }
                for (int i3 = 0; i3 < getNestedTypeCount(); i3++) {
                    if (!getNestedType(i3).isInitialized()) {
                        return false;
                    }
                }
                for (int i4 = 0; i4 < getEnumTypeCount(); i4++) {
                    if (!getEnumType(i4).isInitialized()) {
                        return false;
                    }
                }
                return !hasOptions() || getOptions().isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.name_ = input.readBytes();
                            break;
                        case 18:
                            FieldDescriptorProto.Builder subBuilder = FieldDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addField(subBuilder.buildPartial());
                            break;
                        case 26:
                            Builder subBuilder2 = DescriptorProto.newBuilder();
                            input.readMessage(subBuilder2, extensionRegistry);
                            addNestedType(subBuilder2.buildPartial());
                            break;
                        case 34:
                            EnumDescriptorProto.Builder subBuilder3 = EnumDescriptorProto.newBuilder();
                            input.readMessage(subBuilder3, extensionRegistry);
                            addEnumType(subBuilder3.buildPartial());
                            break;
                        case 42:
                            ExtensionRange.Builder subBuilder4 = ExtensionRange.newBuilder();
                            input.readMessage(subBuilder4, extensionRegistry);
                            addExtensionRange(subBuilder4.buildPartial());
                            break;
                        case 50:
                            FieldDescriptorProto.Builder subBuilder5 = FieldDescriptorProto.newBuilder();
                            input.readMessage(subBuilder5, extensionRegistry);
                            addExtension(subBuilder5.buildPartial());
                            break;
                        case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SECOND_DISPLAY /* 58 */:
                            MessageOptions.Builder subBuilder6 = MessageOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder6.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder6, extensionRegistry);
                            setOptions(subBuilder6.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = DescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
            }

            private void ensureFieldIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.field_ = new ArrayList(this.field_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<FieldDescriptorProto> getFieldList() {
                return this.fieldBuilder_ == null ? Collections.unmodifiableList(this.field_) : this.fieldBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getFieldCount() {
                return this.fieldBuilder_ == null ? this.field_.size() : this.fieldBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public FieldDescriptorProto getField(int index) {
                return this.fieldBuilder_ == null ? this.field_.get(index) : (FieldDescriptorProto) this.fieldBuilder_.getMessage(index);
            }

            public Builder setField(int index, FieldDescriptorProto value) {
                if (this.fieldBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureFieldIsMutable();
                    this.field_.set(index, value);
                    onChanged();
                } else {
                    this.fieldBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setField(int index, FieldDescriptorProto.Builder builderForValue) {
                if (this.fieldBuilder_ == null) {
                    ensureFieldIsMutable();
                    this.field_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fieldBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addField(FieldDescriptorProto value) {
                if (this.fieldBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureFieldIsMutable();
                    this.field_.add(value);
                    onChanged();
                } else {
                    this.fieldBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addField(int index, FieldDescriptorProto value) {
                if (this.fieldBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureFieldIsMutable();
                    this.field_.add(index, value);
                    onChanged();
                } else {
                    this.fieldBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addField(FieldDescriptorProto.Builder builderForValue) {
                if (this.fieldBuilder_ == null) {
                    ensureFieldIsMutable();
                    this.field_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.fieldBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addField(int index, FieldDescriptorProto.Builder builderForValue) {
                if (this.fieldBuilder_ == null) {
                    ensureFieldIsMutable();
                    this.field_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fieldBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllField(Iterable<? extends FieldDescriptorProto> values) {
                if (this.fieldBuilder_ == null) {
                    ensureFieldIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.field_);
                    onChanged();
                } else {
                    this.fieldBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearField() {
                if (this.fieldBuilder_ == null) {
                    this.field_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.fieldBuilder_.clear();
                }
                return this;
            }

            public Builder removeField(int index) {
                if (this.fieldBuilder_ == null) {
                    ensureFieldIsMutable();
                    this.field_.remove(index);
                    onChanged();
                } else {
                    this.fieldBuilder_.remove(index);
                }
                return this;
            }

            public FieldDescriptorProto.Builder getFieldBuilder(int index) {
                return (FieldDescriptorProto.Builder) getFieldFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public FieldDescriptorProtoOrBuilder getFieldOrBuilder(int index) {
                return this.fieldBuilder_ == null ? this.field_.get(index) : (FieldDescriptorProtoOrBuilder) this.fieldBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<? extends FieldDescriptorProtoOrBuilder> getFieldOrBuilderList() {
                return this.fieldBuilder_ != null ? this.fieldBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.field_);
            }

            public FieldDescriptorProto.Builder addFieldBuilder() {
                return (FieldDescriptorProto.Builder) getFieldFieldBuilder().addBuilder(FieldDescriptorProto.getDefaultInstance());
            }

            public FieldDescriptorProto.Builder addFieldBuilder(int index) {
                return (FieldDescriptorProto.Builder) getFieldFieldBuilder().addBuilder(index, FieldDescriptorProto.getDefaultInstance());
            }

            public List<FieldDescriptorProto.Builder> getFieldBuilderList() {
                return getFieldFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> getFieldFieldBuilder() {
                if (this.fieldBuilder_ == null) {
                    this.fieldBuilder_ = new RepeatedFieldBuilder<>(this.field_, (this.bitField0_ & 2) == 2, getParentForChildren(), isClean());
                    this.field_ = null;
                }
                return this.fieldBuilder_;
            }

            private void ensureExtensionIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.extension_ = new ArrayList(this.extension_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<FieldDescriptorProto> getExtensionList() {
                return this.extensionBuilder_ == null ? Collections.unmodifiableList(this.extension_) : this.extensionBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getExtensionCount() {
                return this.extensionBuilder_ == null ? this.extension_.size() : this.extensionBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public FieldDescriptorProto getExtension(int index) {
                return this.extensionBuilder_ == null ? this.extension_.get(index) : (FieldDescriptorProto) this.extensionBuilder_.getMessage(index);
            }

            public Builder setExtension(int index, FieldDescriptorProto value) {
                if (this.extensionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureExtensionIsMutable();
                    this.extension_.set(index, value);
                    onChanged();
                } else {
                    this.extensionBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setExtension(int index, FieldDescriptorProto.Builder builderForValue) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extensionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExtension(FieldDescriptorProto value) {
                if (this.extensionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureExtensionIsMutable();
                    this.extension_.add(value);
                    onChanged();
                } else {
                    this.extensionBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addExtension(int index, FieldDescriptorProto value) {
                if (this.extensionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureExtensionIsMutable();
                    this.extension_.add(index, value);
                    onChanged();
                } else {
                    this.extensionBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addExtension(FieldDescriptorProto.Builder builderForValue) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.extensionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExtension(int index, FieldDescriptorProto.Builder builderForValue) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extensionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExtension(Iterable<? extends FieldDescriptorProto> values) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.extension_);
                    onChanged();
                } else {
                    this.extensionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExtension() {
                if (this.extensionBuilder_ == null) {
                    this.extension_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.extensionBuilder_.clear();
                }
                return this;
            }

            public Builder removeExtension(int index) {
                if (this.extensionBuilder_ == null) {
                    ensureExtensionIsMutable();
                    this.extension_.remove(index);
                    onChanged();
                } else {
                    this.extensionBuilder_.remove(index);
                }
                return this;
            }

            public FieldDescriptorProto.Builder getExtensionBuilder(int index) {
                return (FieldDescriptorProto.Builder) getExtensionFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public FieldDescriptorProtoOrBuilder getExtensionOrBuilder(int index) {
                return this.extensionBuilder_ == null ? this.extension_.get(index) : (FieldDescriptorProtoOrBuilder) this.extensionBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<? extends FieldDescriptorProtoOrBuilder> getExtensionOrBuilderList() {
                return this.extensionBuilder_ != null ? this.extensionBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.extension_);
            }

            public FieldDescriptorProto.Builder addExtensionBuilder() {
                return (FieldDescriptorProto.Builder) getExtensionFieldBuilder().addBuilder(FieldDescriptorProto.getDefaultInstance());
            }

            public FieldDescriptorProto.Builder addExtensionBuilder(int index) {
                return (FieldDescriptorProto.Builder) getExtensionFieldBuilder().addBuilder(index, FieldDescriptorProto.getDefaultInstance());
            }

            public List<FieldDescriptorProto.Builder> getExtensionBuilderList() {
                return getExtensionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<FieldDescriptorProto, FieldDescriptorProto.Builder, FieldDescriptorProtoOrBuilder> getExtensionFieldBuilder() {
                if (this.extensionBuilder_ == null) {
                    this.extensionBuilder_ = new RepeatedFieldBuilder<>(this.extension_, (this.bitField0_ & 4) == 4, getParentForChildren(), isClean());
                    this.extension_ = null;
                }
                return this.extensionBuilder_;
            }

            private void ensureNestedTypeIsMutable() {
                if ((this.bitField0_ & 8) != 8) {
                    this.nestedType_ = new ArrayList(this.nestedType_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<DescriptorProto> getNestedTypeList() {
                return this.nestedTypeBuilder_ == null ? Collections.unmodifiableList(this.nestedType_) : this.nestedTypeBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getNestedTypeCount() {
                return this.nestedTypeBuilder_ == null ? this.nestedType_.size() : this.nestedTypeBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public DescriptorProto getNestedType(int index) {
                return this.nestedTypeBuilder_ == null ? this.nestedType_.get(index) : (DescriptorProto) this.nestedTypeBuilder_.getMessage(index);
            }

            public Builder setNestedType(int index, DescriptorProto value) {
                if (this.nestedTypeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNestedTypeIsMutable();
                    this.nestedType_.set(index, value);
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setNestedType(int index, Builder builderForValue) {
                if (this.nestedTypeBuilder_ == null) {
                    ensureNestedTypeIsMutable();
                    this.nestedType_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addNestedType(DescriptorProto value) {
                if (this.nestedTypeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNestedTypeIsMutable();
                    this.nestedType_.add(value);
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addNestedType(int index, DescriptorProto value) {
                if (this.nestedTypeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNestedTypeIsMutable();
                    this.nestedType_.add(index, value);
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addNestedType(Builder builderForValue) {
                if (this.nestedTypeBuilder_ == null) {
                    ensureNestedTypeIsMutable();
                    this.nestedType_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addNestedType(int index, Builder builderForValue) {
                if (this.nestedTypeBuilder_ == null) {
                    ensureNestedTypeIsMutable();
                    this.nestedType_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllNestedType(Iterable<? extends DescriptorProto> values) {
                if (this.nestedTypeBuilder_ == null) {
                    ensureNestedTypeIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.nestedType_);
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearNestedType() {
                if (this.nestedTypeBuilder_ == null) {
                    this.nestedType_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.clear();
                }
                return this;
            }

            public Builder removeNestedType(int index) {
                if (this.nestedTypeBuilder_ == null) {
                    ensureNestedTypeIsMutable();
                    this.nestedType_.remove(index);
                    onChanged();
                } else {
                    this.nestedTypeBuilder_.remove(index);
                }
                return this;
            }

            public Builder getNestedTypeBuilder(int index) {
                return (Builder) getNestedTypeFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public DescriptorProtoOrBuilder getNestedTypeOrBuilder(int index) {
                return this.nestedTypeBuilder_ == null ? this.nestedType_.get(index) : (DescriptorProtoOrBuilder) this.nestedTypeBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<? extends DescriptorProtoOrBuilder> getNestedTypeOrBuilderList() {
                return this.nestedTypeBuilder_ != null ? this.nestedTypeBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.nestedType_);
            }

            public Builder addNestedTypeBuilder() {
                return (Builder) getNestedTypeFieldBuilder().addBuilder(DescriptorProto.getDefaultInstance());
            }

            public Builder addNestedTypeBuilder(int index) {
                return (Builder) getNestedTypeFieldBuilder().addBuilder(index, DescriptorProto.getDefaultInstance());
            }

            public List<Builder> getNestedTypeBuilderList() {
                return getNestedTypeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<DescriptorProto, Builder, DescriptorProtoOrBuilder> getNestedTypeFieldBuilder() {
                if (this.nestedTypeBuilder_ == null) {
                    this.nestedTypeBuilder_ = new RepeatedFieldBuilder<>(this.nestedType_, (this.bitField0_ & 8) == 8, getParentForChildren(), isClean());
                    this.nestedType_ = null;
                }
                return this.nestedTypeBuilder_;
            }

            private void ensureEnumTypeIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.enumType_ = new ArrayList(this.enumType_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<EnumDescriptorProto> getEnumTypeList() {
                return this.enumTypeBuilder_ == null ? Collections.unmodifiableList(this.enumType_) : this.enumTypeBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getEnumTypeCount() {
                return this.enumTypeBuilder_ == null ? this.enumType_.size() : this.enumTypeBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public EnumDescriptorProto getEnumType(int index) {
                return this.enumTypeBuilder_ == null ? this.enumType_.get(index) : (EnumDescriptorProto) this.enumTypeBuilder_.getMessage(index);
            }

            public Builder setEnumType(int index, EnumDescriptorProto value) {
                if (this.enumTypeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureEnumTypeIsMutable();
                    this.enumType_.set(index, value);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setEnumType(int index, EnumDescriptorProto.Builder builderForValue) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.enumTypeBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto value) {
                if (this.enumTypeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(value);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addEnumType(int index, EnumDescriptorProto value) {
                if (this.enumTypeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(index, value);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addEnumType(EnumDescriptorProto.Builder builderForValue) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addEnumType(int index, EnumDescriptorProto.Builder builderForValue) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllEnumType(Iterable<? extends EnumDescriptorProto> values) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.enumType_);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearEnumType() {
                if (this.enumTypeBuilder_ == null) {
                    this.enumType_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.enumTypeBuilder_.clear();
                }
                return this;
            }

            public Builder removeEnumType(int index) {
                if (this.enumTypeBuilder_ == null) {
                    ensureEnumTypeIsMutable();
                    this.enumType_.remove(index);
                    onChanged();
                } else {
                    this.enumTypeBuilder_.remove(index);
                }
                return this;
            }

            public EnumDescriptorProto.Builder getEnumTypeBuilder(int index) {
                return (EnumDescriptorProto.Builder) getEnumTypeFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public EnumDescriptorProtoOrBuilder getEnumTypeOrBuilder(int index) {
                return this.enumTypeBuilder_ == null ? this.enumType_.get(index) : (EnumDescriptorProtoOrBuilder) this.enumTypeBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<? extends EnumDescriptorProtoOrBuilder> getEnumTypeOrBuilderList() {
                return this.enumTypeBuilder_ != null ? this.enumTypeBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.enumType_);
            }

            public EnumDescriptorProto.Builder addEnumTypeBuilder() {
                return (EnumDescriptorProto.Builder) getEnumTypeFieldBuilder().addBuilder(EnumDescriptorProto.getDefaultInstance());
            }

            public EnumDescriptorProto.Builder addEnumTypeBuilder(int index) {
                return (EnumDescriptorProto.Builder) getEnumTypeFieldBuilder().addBuilder(index, EnumDescriptorProto.getDefaultInstance());
            }

            public List<EnumDescriptorProto.Builder> getEnumTypeBuilderList() {
                return getEnumTypeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<EnumDescriptorProto, EnumDescriptorProto.Builder, EnumDescriptorProtoOrBuilder> getEnumTypeFieldBuilder() {
                if (this.enumTypeBuilder_ == null) {
                    this.enumTypeBuilder_ = new RepeatedFieldBuilder<>(this.enumType_, (this.bitField0_ & 16) == 16, getParentForChildren(), isClean());
                    this.enumType_ = null;
                }
                return this.enumTypeBuilder_;
            }

            private void ensureExtensionRangeIsMutable() {
                if ((this.bitField0_ & 32) != 32) {
                    this.extensionRange_ = new ArrayList(this.extensionRange_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<ExtensionRange> getExtensionRangeList() {
                return this.extensionRangeBuilder_ == null ? Collections.unmodifiableList(this.extensionRange_) : this.extensionRangeBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public int getExtensionRangeCount() {
                return this.extensionRangeBuilder_ == null ? this.extensionRange_.size() : this.extensionRangeBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ExtensionRange getExtensionRange(int index) {
                return this.extensionRangeBuilder_ == null ? this.extensionRange_.get(index) : (ExtensionRange) this.extensionRangeBuilder_.getMessage(index);
            }

            public Builder setExtensionRange(int index, ExtensionRange value) {
                if (this.extensionRangeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.set(index, value);
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setExtensionRange(int index, ExtensionRange.Builder builderForValue) {
                if (this.extensionRangeBuilder_ == null) {
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addExtensionRange(ExtensionRange value) {
                if (this.extensionRangeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.add(value);
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addExtensionRange(int index, ExtensionRange value) {
                if (this.extensionRangeBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.add(index, value);
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addExtensionRange(ExtensionRange.Builder builderForValue) {
                if (this.extensionRangeBuilder_ == null) {
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addExtensionRange(int index, ExtensionRange.Builder builderForValue) {
                if (this.extensionRangeBuilder_ == null) {
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllExtensionRange(Iterable<? extends ExtensionRange> values) {
                if (this.extensionRangeBuilder_ == null) {
                    ensureExtensionRangeIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.extensionRange_);
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearExtensionRange() {
                if (this.extensionRangeBuilder_ == null) {
                    this.extensionRange_ = Collections.emptyList();
                    this.bitField0_ &= -33;
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.clear();
                }
                return this;
            }

            public Builder removeExtensionRange(int index) {
                if (this.extensionRangeBuilder_ == null) {
                    ensureExtensionRangeIsMutable();
                    this.extensionRange_.remove(index);
                    onChanged();
                } else {
                    this.extensionRangeBuilder_.remove(index);
                }
                return this;
            }

            public ExtensionRange.Builder getExtensionRangeBuilder(int index) {
                return (ExtensionRange.Builder) getExtensionRangeFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public ExtensionRangeOrBuilder getExtensionRangeOrBuilder(int index) {
                return this.extensionRangeBuilder_ == null ? this.extensionRange_.get(index) : (ExtensionRangeOrBuilder) this.extensionRangeBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public List<? extends ExtensionRangeOrBuilder> getExtensionRangeOrBuilderList() {
                return this.extensionRangeBuilder_ != null ? this.extensionRangeBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.extensionRange_);
            }

            public ExtensionRange.Builder addExtensionRangeBuilder() {
                return (ExtensionRange.Builder) getExtensionRangeFieldBuilder().addBuilder(ExtensionRange.getDefaultInstance());
            }

            public ExtensionRange.Builder addExtensionRangeBuilder(int index) {
                return (ExtensionRange.Builder) getExtensionRangeFieldBuilder().addBuilder(index, ExtensionRange.getDefaultInstance());
            }

            public List<ExtensionRange.Builder> getExtensionRangeBuilderList() {
                return getExtensionRangeFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<ExtensionRange, ExtensionRange.Builder, ExtensionRangeOrBuilder> getExtensionRangeFieldBuilder() {
                if (this.extensionRangeBuilder_ == null) {
                    this.extensionRangeBuilder_ = new RepeatedFieldBuilder<>(this.extensionRange_, (this.bitField0_ & 32) == 32, getParentForChildren(), isClean());
                    this.extensionRange_ = null;
                }
                return this.extensionRangeBuilder_;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public boolean hasOptions() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public MessageOptions getOptions() {
                return this.optionsBuilder_ == null ? this.options_ : (MessageOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(MessageOptions value) {
                if (this.optionsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.options_ = value;
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(value);
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder setOptions(MessageOptions.Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder mergeOptions(MessageOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & 64) == 64 && this.options_ != MessageOptions.getDefaultInstance()) {
                        this.options_ = MessageOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    } else {
                        this.options_ = value;
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 64;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = MessageOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -65;
                return this;
            }

            public MessageOptions.Builder getOptionsBuilder() {
                this.bitField0_ |= 64;
                onChanged();
                return (MessageOptions.Builder) getOptionsFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.DescriptorProtos.DescriptorProtoOrBuilder
            public MessageOptionsOrBuilder getOptionsOrBuilder() {
                return this.optionsBuilder_ != null ? (MessageOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder() : this.options_;
            }

            private SingleFieldBuilder<MessageOptions, MessageOptions.Builder, MessageOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder<>(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class FieldDescriptorProto extends GeneratedMessage implements FieldDescriptorProtoOrBuilder {
        public static final int DEFAULT_VALUE_FIELD_NUMBER = 7;
        public static final int EXTENDEE_FIELD_NUMBER = 2;
        public static final int LABEL_FIELD_NUMBER = 4;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 3;
        public static final int OPTIONS_FIELD_NUMBER = 8;
        public static final int TYPE_FIELD_NUMBER = 5;
        public static final int TYPE_NAME_FIELD_NUMBER = 6;
        private static final FieldDescriptorProto defaultInstance = new FieldDescriptorProto(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object defaultValue_;
        private Object extendee_;
        private Label label_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private int number_;
        private FieldOptions options_;
        private Object typeName_;
        private Type type_;

        /* synthetic */ FieldDescriptorProto(Builder builder, FieldDescriptorProto fieldDescriptorProto) {
            this(builder);
        }

        private FieldDescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private FieldDescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static FieldDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FieldDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f38x4734b330;
        }

        public enum Type implements ProtocolMessageEnum {
            TYPE_DOUBLE(0, 1),
            TYPE_FLOAT(1, 2),
            TYPE_INT64(2, 3),
            TYPE_UINT64(3, 4),
            TYPE_INT32(4, 5),
            TYPE_FIXED64(5, 6),
            TYPE_FIXED32(6, 7),
            TYPE_BOOL(7, 8),
            TYPE_STRING(8, 9),
            TYPE_GROUP(9, 10),
            TYPE_MESSAGE(10, 11),
            TYPE_BYTES(11, 12),
            TYPE_UINT32(12, 13),
            TYPE_ENUM(13, 14),
            TYPE_SFIXED32(14, 15),
            TYPE_SFIXED64(15, 16),
            TYPE_SINT32(16, 17),
            TYPE_SINT64(17, 18);

            public static final int TYPE_BOOL_VALUE = 8;
            public static final int TYPE_BYTES_VALUE = 12;
            public static final int TYPE_DOUBLE_VALUE = 1;
            public static final int TYPE_ENUM_VALUE = 14;
            public static final int TYPE_FIXED32_VALUE = 7;
            public static final int TYPE_FIXED64_VALUE = 6;
            public static final int TYPE_FLOAT_VALUE = 2;
            public static final int TYPE_GROUP_VALUE = 10;
            public static final int TYPE_INT32_VALUE = 5;
            public static final int TYPE_INT64_VALUE = 3;
            public static final int TYPE_MESSAGE_VALUE = 11;
            public static final int TYPE_SFIXED32_VALUE = 15;
            public static final int TYPE_SFIXED64_VALUE = 16;
            public static final int TYPE_SINT32_VALUE = 17;
            public static final int TYPE_SINT64_VALUE = 18;
            public static final int TYPE_STRING_VALUE = 9;
            public static final int TYPE_UINT32_VALUE = 13;
            public static final int TYPE_UINT64_VALUE = 4;
            private final int index;
            private final int value;
            private static Internal.EnumLiteMap<Type> internalValueMap = new Internal.EnumLiteMap<Type>() { // from class: com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Type findValueByNumber(int number) {
                    return Type.valueOf(number);
                }
            };
            private static final Type[] VALUES = {TYPE_DOUBLE, TYPE_FLOAT, TYPE_INT64, TYPE_UINT64, TYPE_INT32, TYPE_FIXED64, TYPE_FIXED32, TYPE_BOOL, TYPE_STRING, TYPE_GROUP, TYPE_MESSAGE, TYPE_BYTES, TYPE_UINT32, TYPE_ENUM, TYPE_SFIXED32, TYPE_SFIXED64, TYPE_SINT32, TYPE_SINT64};

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static Type[] valuesCustom() {
                Type[] typeArrValuesCustom = values();
                int length = typeArrValuesCustom.length;
                Type[] typeArr = new Type[length];
                System.arraycopy(typeArrValuesCustom, 0, typeArr, 0, length);
                return typeArr;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Type valueOf(int value) {
                switch (value) {
                    case 1:
                        return TYPE_DOUBLE;
                    case 2:
                        return TYPE_FLOAT;
                    case 3:
                        return TYPE_INT64;
                    case 4:
                        return TYPE_UINT64;
                    case 5:
                        return TYPE_INT32;
                    case 6:
                        return TYPE_FIXED64;
                    case 7:
                        return TYPE_FIXED32;
                    case 8:
                        return TYPE_BOOL;
                    case 9:
                        return TYPE_STRING;
                    case 10:
                        return TYPE_GROUP;
                    case 11:
                        return TYPE_MESSAGE;
                    case 12:
                        return TYPE_BYTES;
                    case 13:
                        return TYPE_UINT32;
                    case 14:
                        return TYPE_ENUM;
                    case 15:
                        return TYPE_SFIXED32;
                    case 16:
                        return TYPE_SFIXED64;
                    case 17:
                        return TYPE_SINT32;
                    case 18:
                        return TYPE_SINT64;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<Type> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return getDescriptor().getValues().get(this.index);
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return FieldDescriptorProto.getDescriptor().getEnumTypes().get(0);
            }

            public static Type valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            Type(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        public enum Label implements ProtocolMessageEnum {
            LABEL_OPTIONAL(0, 1),
            LABEL_REQUIRED(1, 2),
            LABEL_REPEATED(2, 3);

            public static final int LABEL_OPTIONAL_VALUE = 1;
            public static final int LABEL_REPEATED_VALUE = 3;
            public static final int LABEL_REQUIRED_VALUE = 2;
            private final int index;
            private final int value;
            private static Internal.EnumLiteMap<Label> internalValueMap = new Internal.EnumLiteMap<Label>() { // from class: com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public Label findValueByNumber(int number) {
                    return Label.valueOf(number);
                }
            };
            private static final Label[] VALUES = {LABEL_OPTIONAL, LABEL_REQUIRED, LABEL_REPEATED};

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static Label[] valuesCustom() {
                Label[] labelArrValuesCustom = values();
                int length = labelArrValuesCustom.length;
                Label[] labelArr = new Label[length];
                System.arraycopy(labelArrValuesCustom, 0, labelArr, 0, length);
                return labelArr;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static Label valueOf(int value) {
                switch (value) {
                    case 1:
                        return LABEL_OPTIONAL;
                    case 2:
                        return LABEL_REQUIRED;
                    case 3:
                        return LABEL_REPEATED;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<Label> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return getDescriptor().getValues().get(this.index);
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return FieldDescriptorProto.getDescriptor().getEnumTypes().get(1);
            }

            public static Label valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            Label(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasNumber() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public int getNumber() {
            return this.number_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasLabel() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public Label getLabel() {
            return this.label_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public Type getType() {
            return this.type_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasTypeName() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getTypeName() {
            Object ref = this.typeName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.typeName_ = s;
            }
            return s;
        }

        private ByteString getTypeNameBytes() {
            Object ref = this.typeName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.typeName_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasExtendee() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getExtendee() {
            Object ref = this.extendee_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.extendee_ = s;
            }
            return s;
        }

        private ByteString getExtendeeBytes() {
            Object ref = this.extendee_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.extendee_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasDefaultValue() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public String getDefaultValue() {
            Object ref = this.defaultValue_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.defaultValue_ = s;
            }
            return s;
        }

        private ByteString getDefaultValueBytes() {
            Object ref = this.defaultValue_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.defaultValue_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public FieldOptions getOptions() {
            return this.options_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
        public FieldOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        private void initFields() {
            this.name_ = "";
            this.number_ = 0;
            this.label_ = Label.LABEL_OPTIONAL;
            this.type_ = Type.TYPE_DOUBLE;
            this.typeName_ = "";
            this.extendee_ = "";
            this.defaultValue_ = "";
            this.options_ = FieldOptions.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBytes(1, getNameBytes());
            }
            if ((this.bitField0_ & 32) == 32) {
                output.writeBytes(2, getExtendeeBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeEnum(4, this.label_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeEnum(5, this.type_.getNumber());
            }
            if ((this.bitField0_ & 16) == 16) {
                output.writeBytes(6, getTypeNameBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                output.writeBytes(7, getDefaultValueBytes());
            }
            if ((this.bitField0_ & 128) == 128) {
                output.writeMessage(8, this.options_);
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getNameBytes()) : 0;
            if ((this.bitField0_ & 32) == 32) {
                size2 += CodedOutputStream.computeBytesSize(2, getExtendeeBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeInt32Size(3, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeEnumSize(4, this.label_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                size2 += CodedOutputStream.computeEnumSize(5, this.type_.getNumber());
            }
            if ((this.bitField0_ & 16) == 16) {
                size2 += CodedOutputStream.computeBytesSize(6, getTypeNameBytes());
            }
            if ((this.bitField0_ & 64) == 64) {
                size2 += CodedOutputStream.computeBytesSize(7, getDefaultValueBytes());
            }
            if ((this.bitField0_ & 128) == 128) {
                size2 += CodedOutputStream.computeMessageSize(8, this.options_);
            }
            int size3 = size2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FieldDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FieldDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FieldDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements FieldDescriptorProtoOrBuilder {
            private int bitField0_;
            private Object defaultValue_;
            private Object extendee_;
            private Label label_;
            private Object name_;
            private int number_;
            private SingleFieldBuilder<FieldOptions, FieldOptions.Builder, FieldOptionsOrBuilder> optionsBuilder_;
            private FieldOptions options_;
            private Object typeName_;
            private Type type_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f38x4734b330;
            }

            private Builder() {
                this.name_ = "";
                this.label_ = Label.LABEL_OPTIONAL;
                this.type_ = Type.TYPE_DOUBLE;
                this.typeName_ = "";
                this.extendee_ = "";
                this.defaultValue_ = "";
                this.options_ = FieldOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.label_ = Label.LABEL_OPTIONAL;
                this.type_ = Type.TYPE_DOUBLE;
                this.typeName_ = "";
                this.extendee_ = "";
                this.defaultValue_ = "";
                this.options_ = FieldOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getOptionsFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.name_ = "";
                this.bitField0_ &= -2;
                this.number_ = 0;
                this.bitField0_ &= -3;
                this.label_ = Label.LABEL_OPTIONAL;
                this.bitField0_ &= -5;
                this.type_ = Type.TYPE_DOUBLE;
                this.bitField0_ &= -9;
                this.typeName_ = "";
                this.bitField0_ &= -17;
                this.extendee_ = "";
                this.bitField0_ &= -33;
                this.defaultValue_ = "";
                this.bitField0_ &= -65;
                if (this.optionsBuilder_ == null) {
                    this.options_ = FieldOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -129;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FieldDescriptorProto.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FieldDescriptorProto getDefaultInstanceForType() {
                return FieldDescriptorProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FieldDescriptorProto build() {
                FieldDescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public FieldDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                FieldDescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FieldDescriptorProto buildPartial() {
                FieldDescriptorProto result = new FieldDescriptorProto(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ = 0 | 1;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.number_ = this.number_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.label_ = this.label_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.type_ = this.type_;
                if ((from_bitField0_ & 16) == 16) {
                    to_bitField0_ |= 16;
                }
                result.typeName_ = this.typeName_;
                if ((from_bitField0_ & 32) == 32) {
                    to_bitField0_ |= 32;
                }
                result.extendee_ = this.extendee_;
                if ((from_bitField0_ & 64) == 64) {
                    to_bitField0_ |= 64;
                }
                result.defaultValue_ = this.defaultValue_;
                if ((from_bitField0_ & 128) == 128) {
                    to_bitField0_ |= 128;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (FieldOptions) this.optionsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof FieldDescriptorProto) {
                    return mergeFrom((FieldDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FieldDescriptorProto other) {
                if (other != FieldDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (other.hasNumber()) {
                        setNumber(other.getNumber());
                    }
                    if (other.hasLabel()) {
                        setLabel(other.getLabel());
                    }
                    if (other.hasType()) {
                        setType(other.getType());
                    }
                    if (other.hasTypeName()) {
                        setTypeName(other.getTypeName());
                    }
                    if (other.hasExtendee()) {
                        setExtendee(other.getExtendee());
                    }
                    if (other.hasDefaultValue()) {
                        setDefaultValue(other.getDefaultValue());
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return !hasOptions() || getOptions().isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.name_ = input.readBytes();
                            break;
                        case 18:
                            this.bitField0_ |= 32;
                            this.extendee_ = input.readBytes();
                            break;
                        case 24:
                            this.bitField0_ |= 2;
                            this.number_ = input.readInt32();
                            break;
                        case 32:
                            int rawValue = input.readEnum();
                            Label value = Label.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(4, rawValue);
                                break;
                            } else {
                                this.bitField0_ |= 4;
                                this.label_ = value;
                                break;
                            }
                        case 40:
                            int rawValue2 = input.readEnum();
                            Type value2 = Type.valueOf(rawValue2);
                            if (value2 == null) {
                                unknownFields.mergeVarintField(5, rawValue2);
                                break;
                            } else {
                                this.bitField0_ |= 8;
                                this.type_ = value2;
                                break;
                            }
                        case 50:
                            this.bitField0_ |= 16;
                            this.typeName_ = input.readBytes();
                            break;
                        case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SECOND_DISPLAY /* 58 */:
                            this.bitField0_ |= 64;
                            this.defaultValue_ = input.readBytes();
                            break;
                        case 66:
                            FieldOptions.Builder subBuilder = FieldOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder, extensionRegistry);
                            setOptions(subBuilder.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = FieldDescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasNumber() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public int getNumber() {
                return this.number_;
            }

            public Builder setNumber(int value) {
                this.bitField0_ |= 2;
                this.number_ = value;
                onChanged();
                return this;
            }

            public Builder clearNumber() {
                this.bitField0_ &= -3;
                this.number_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasLabel() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public Label getLabel() {
                return this.label_;
            }

            public Builder setLabel(Label value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.label_ = value;
                onChanged();
                return this;
            }

            public Builder clearLabel() {
                this.bitField0_ &= -5;
                this.label_ = Label.LABEL_OPTIONAL;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasType() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public Type getType() {
                return this.type_;
            }

            public Builder setType(Type value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.bitField0_ &= -9;
                this.type_ = Type.TYPE_DOUBLE;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasTypeName() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getTypeName() {
                Object ref = this.typeName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.typeName_ = s;
                return s;
            }

            public Builder setTypeName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.typeName_ = value;
                onChanged();
                return this;
            }

            public Builder clearTypeName() {
                this.bitField0_ &= -17;
                this.typeName_ = FieldDescriptorProto.getDefaultInstance().getTypeName();
                onChanged();
                return this;
            }

            void setTypeName(ByteString value) {
                this.bitField0_ |= 16;
                this.typeName_ = value;
                onChanged();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasExtendee() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getExtendee() {
                Object ref = this.extendee_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.extendee_ = s;
                return s;
            }

            public Builder setExtendee(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 32;
                this.extendee_ = value;
                onChanged();
                return this;
            }

            public Builder clearExtendee() {
                this.bitField0_ &= -33;
                this.extendee_ = FieldDescriptorProto.getDefaultInstance().getExtendee();
                onChanged();
                return this;
            }

            void setExtendee(ByteString value) {
                this.bitField0_ |= 32;
                this.extendee_ = value;
                onChanged();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasDefaultValue() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public String getDefaultValue() {
                Object ref = this.defaultValue_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.defaultValue_ = s;
                return s;
            }

            public Builder setDefaultValue(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 64;
                this.defaultValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearDefaultValue() {
                this.bitField0_ &= -65;
                this.defaultValue_ = FieldDescriptorProto.getDefaultInstance().getDefaultValue();
                onChanged();
                return this;
            }

            void setDefaultValue(ByteString value) {
                this.bitField0_ |= 64;
                this.defaultValue_ = value;
                onChanged();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return (this.bitField0_ & 128) == 128;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public FieldOptions getOptions() {
                return this.optionsBuilder_ == null ? this.options_ : (FieldOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(FieldOptions value) {
                if (this.optionsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.options_ = value;
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(value);
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder setOptions(FieldOptions.Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder mergeOptions(FieldOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & 128) == 128 && this.options_ != FieldOptions.getDefaultInstance()) {
                        this.options_ = FieldOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    } else {
                        this.options_ = value;
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 128;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = FieldOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -129;
                return this;
            }

            public FieldOptions.Builder getOptionsBuilder() {
                this.bitField0_ |= 128;
                onChanged();
                return (FieldOptions.Builder) getOptionsFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldDescriptorProtoOrBuilder
            public FieldOptionsOrBuilder getOptionsOrBuilder() {
                return this.optionsBuilder_ != null ? (FieldOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder() : this.options_;
            }

            private SingleFieldBuilder<FieldOptions, FieldOptions.Builder, FieldOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder<>(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class EnumDescriptorProto extends GeneratedMessage implements EnumDescriptorProtoOrBuilder {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        public static final int VALUE_FIELD_NUMBER = 2;
        private static final EnumDescriptorProto defaultInstance = new EnumDescriptorProto(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private EnumOptions options_;
        private List<EnumValueDescriptorProto> value_;

        /* synthetic */ EnumDescriptorProto(Builder builder, EnumDescriptorProto enumDescriptorProto) {
            this(builder);
        }

        private EnumDescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private EnumDescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static EnumDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EnumDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f34x9945f651;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public List<EnumValueDescriptorProto> getValueList() {
            return this.value_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public List<? extends EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList() {
            return this.value_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public int getValueCount() {
            return this.value_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public EnumValueDescriptorProto getValue(int index) {
            return this.value_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int index) {
            return this.value_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public EnumOptions getOptions() {
            return this.options_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
        public EnumOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        private void initFields() {
            this.name_ = "";
            this.value_ = Collections.emptyList();
            this.options_ = EnumOptions.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            for (int i = 0; i < getValueCount(); i++) {
                if (!getValue(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBytes(1, getNameBytes());
            }
            for (int i = 0; i < this.value_.size(); i++) {
                output.writeMessage(2, this.value_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(3, this.options_);
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getNameBytes()) : 0;
            for (int i = 0; i < this.value_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.value_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeMessageSize(3, this.options_);
            }
            int size3 = size2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static EnumDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements EnumDescriptorProtoOrBuilder {
            private int bitField0_;
            private Object name_;
            private SingleFieldBuilder<EnumOptions, EnumOptions.Builder, EnumOptionsOrBuilder> optionsBuilder_;
            private EnumOptions options_;
            private RepeatedFieldBuilder<EnumValueDescriptorProto, EnumValueDescriptorProto.Builder, EnumValueDescriptorProtoOrBuilder> valueBuilder_;
            private List<EnumValueDescriptorProto> value_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f34x9945f651;
            }

            private Builder() {
                this.name_ = "";
                this.value_ = Collections.emptyList();
                this.options_ = EnumOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.value_ = Collections.emptyList();
                this.options_ = EnumOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getValueFieldBuilder();
                    getOptionsFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.name_ = "";
                this.bitField0_ &= -2;
                if (this.valueBuilder_ == null) {
                    this.value_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.valueBuilder_.clear();
                }
                if (this.optionsBuilder_ == null) {
                    this.options_ = EnumOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EnumDescriptorProto.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EnumDescriptorProto getDefaultInstanceForType() {
                return EnumDescriptorProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnumDescriptorProto build() {
                EnumDescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public EnumDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                EnumDescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnumDescriptorProto buildPartial() {
                EnumDescriptorProto result = new EnumDescriptorProto(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ = 0 | 1;
                }
                result.name_ = this.name_;
                if (this.valueBuilder_ != null) {
                    result.value_ = this.valueBuilder_.build();
                } else {
                    if ((this.bitField0_ & 2) == 2) {
                        this.value_ = Collections.unmodifiableList(this.value_);
                        this.bitField0_ &= -3;
                    }
                    result.value_ = this.value_;
                }
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 2;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (EnumOptions) this.optionsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof EnumDescriptorProto) {
                    return mergeFrom((EnumDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnumDescriptorProto other) {
                if (other != EnumDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (this.valueBuilder_ == null) {
                        if (!other.value_.isEmpty()) {
                            if (this.value_.isEmpty()) {
                                this.value_ = other.value_;
                                this.bitField0_ &= -3;
                            } else {
                                ensureValueIsMutable();
                                this.value_.addAll(other.value_);
                            }
                            onChanged();
                        }
                    } else if (!other.value_.isEmpty()) {
                        if (!this.valueBuilder_.isEmpty()) {
                            this.valueBuilder_.addAllMessages(other.value_);
                        } else {
                            this.valueBuilder_.dispose();
                            this.valueBuilder_ = null;
                            this.value_ = other.value_;
                            this.bitField0_ &= -3;
                            this.valueBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getValueFieldBuilder() : null;
                        }
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getValueCount(); i++) {
                    if (!getValue(i).isInitialized()) {
                        return false;
                    }
                }
                return !hasOptions() || getOptions().isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.name_ = input.readBytes();
                            break;
                        case 18:
                            EnumValueDescriptorProto.Builder subBuilder = EnumValueDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addValue(subBuilder.buildPartial());
                            break;
                        case 26:
                            EnumOptions.Builder subBuilder2 = EnumOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder2.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder2, extensionRegistry);
                            setOptions(subBuilder2.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = EnumDescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
            }

            private void ensureValueIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.value_ = new ArrayList(this.value_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public List<EnumValueDescriptorProto> getValueList() {
                return this.valueBuilder_ == null ? Collections.unmodifiableList(this.value_) : this.valueBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public int getValueCount() {
                return this.valueBuilder_ == null ? this.value_.size() : this.valueBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public EnumValueDescriptorProto getValue(int index) {
                return this.valueBuilder_ == null ? this.value_.get(index) : (EnumValueDescriptorProto) this.valueBuilder_.getMessage(index);
            }

            public Builder setValue(int index, EnumValueDescriptorProto value) {
                if (this.valueBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureValueIsMutable();
                    this.value_.set(index, value);
                    onChanged();
                } else {
                    this.valueBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setValue(int index, EnumValueDescriptorProto.Builder builderForValue) {
                if (this.valueBuilder_ == null) {
                    ensureValueIsMutable();
                    this.value_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.valueBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addValue(EnumValueDescriptorProto value) {
                if (this.valueBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureValueIsMutable();
                    this.value_.add(value);
                    onChanged();
                } else {
                    this.valueBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addValue(int index, EnumValueDescriptorProto value) {
                if (this.valueBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureValueIsMutable();
                    this.value_.add(index, value);
                    onChanged();
                } else {
                    this.valueBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addValue(EnumValueDescriptorProto.Builder builderForValue) {
                if (this.valueBuilder_ == null) {
                    ensureValueIsMutable();
                    this.value_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.valueBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addValue(int index, EnumValueDescriptorProto.Builder builderForValue) {
                if (this.valueBuilder_ == null) {
                    ensureValueIsMutable();
                    this.value_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.valueBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllValue(Iterable<? extends EnumValueDescriptorProto> values) {
                if (this.valueBuilder_ == null) {
                    ensureValueIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.value_);
                    onChanged();
                } else {
                    this.valueBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearValue() {
                if (this.valueBuilder_ == null) {
                    this.value_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.valueBuilder_.clear();
                }
                return this;
            }

            public Builder removeValue(int index) {
                if (this.valueBuilder_ == null) {
                    ensureValueIsMutable();
                    this.value_.remove(index);
                    onChanged();
                } else {
                    this.valueBuilder_.remove(index);
                }
                return this;
            }

            public EnumValueDescriptorProto.Builder getValueBuilder(int index) {
                return (EnumValueDescriptorProto.Builder) getValueFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public EnumValueDescriptorProtoOrBuilder getValueOrBuilder(int index) {
                return this.valueBuilder_ == null ? this.value_.get(index) : (EnumValueDescriptorProtoOrBuilder) this.valueBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public List<? extends EnumValueDescriptorProtoOrBuilder> getValueOrBuilderList() {
                return this.valueBuilder_ != null ? this.valueBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.value_);
            }

            public EnumValueDescriptorProto.Builder addValueBuilder() {
                return (EnumValueDescriptorProto.Builder) getValueFieldBuilder().addBuilder(EnumValueDescriptorProto.getDefaultInstance());
            }

            public EnumValueDescriptorProto.Builder addValueBuilder(int index) {
                return (EnumValueDescriptorProto.Builder) getValueFieldBuilder().addBuilder(index, EnumValueDescriptorProto.getDefaultInstance());
            }

            public List<EnumValueDescriptorProto.Builder> getValueBuilderList() {
                return getValueFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<EnumValueDescriptorProto, EnumValueDescriptorProto.Builder, EnumValueDescriptorProtoOrBuilder> getValueFieldBuilder() {
                if (this.valueBuilder_ == null) {
                    this.valueBuilder_ = new RepeatedFieldBuilder<>(this.value_, (this.bitField0_ & 2) == 2, getParentForChildren(), isClean());
                    this.value_ = null;
                }
                return this.valueBuilder_;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public EnumOptions getOptions() {
                return this.optionsBuilder_ == null ? this.options_ : (EnumOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(EnumOptions value) {
                if (this.optionsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.options_ = value;
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(value);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setOptions(EnumOptions.Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeOptions(EnumOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & 4) == 4 && this.options_ != EnumOptions.getDefaultInstance()) {
                        this.options_ = EnumOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    } else {
                        this.options_ = value;
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = EnumOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            public EnumOptions.Builder getOptionsBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return (EnumOptions.Builder) getOptionsFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumDescriptorProtoOrBuilder
            public EnumOptionsOrBuilder getOptionsOrBuilder() {
                return this.optionsBuilder_ != null ? (EnumOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder() : this.options_;
            }

            private SingleFieldBuilder<EnumOptions, EnumOptions.Builder, EnumOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder<>(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class EnumValueDescriptorProto extends GeneratedMessage implements EnumValueDescriptorProtoOrBuilder {
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int NUMBER_FIELD_NUMBER = 2;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static final EnumValueDescriptorProto defaultInstance = new EnumValueDescriptorProto(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private int number_;
        private EnumValueOptions options_;

        /* synthetic */ EnumValueDescriptorProto(Builder builder, EnumValueDescriptorProto enumValueDescriptorProto) {
            this(builder);
        }

        private EnumValueDescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private EnumValueDescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static EnumValueDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EnumValueDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.f35xf18031a8;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f36xfb173026;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public boolean hasNumber() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public int getNumber() {
            return this.number_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public EnumValueOptions getOptions() {
            return this.options_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
        public EnumValueOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        private void initFields() {
            this.name_ = "";
            this.number_ = 0;
            this.options_ = EnumValueOptions.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBytes(1, getNameBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeInt32(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeMessage(3, this.options_);
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getNameBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeInt32Size(2, this.number_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeMessageSize(3, this.options_);
            }
            int size3 = size2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static EnumValueDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumValueDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumValueDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements EnumValueDescriptorProtoOrBuilder {
            private int bitField0_;
            private Object name_;
            private int number_;
            private SingleFieldBuilder<EnumValueOptions, EnumValueOptions.Builder, EnumValueOptionsOrBuilder> optionsBuilder_;
            private EnumValueOptions options_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.f35xf18031a8;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f36xfb173026;
            }

            private Builder() {
                this.name_ = "";
                this.options_ = EnumValueOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.options_ = EnumValueOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getOptionsFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.name_ = "";
                this.bitField0_ &= -2;
                this.number_ = 0;
                this.bitField0_ &= -3;
                if (this.optionsBuilder_ == null) {
                    this.options_ = EnumValueOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EnumValueDescriptorProto.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EnumValueDescriptorProto getDefaultInstanceForType() {
                return EnumValueDescriptorProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnumValueDescriptorProto build() {
                EnumValueDescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public EnumValueDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                EnumValueDescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnumValueDescriptorProto buildPartial() {
                EnumValueDescriptorProto result = new EnumValueDescriptorProto(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ = 0 | 1;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.number_ = this.number_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (EnumValueOptions) this.optionsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof EnumValueDescriptorProto) {
                    return mergeFrom((EnumValueDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnumValueDescriptorProto other) {
                if (other != EnumValueDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (other.hasNumber()) {
                        setNumber(other.getNumber());
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return !hasOptions() || getOptions().isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.name_ = input.readBytes();
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.number_ = input.readInt32();
                            break;
                        case 26:
                            EnumValueOptions.Builder subBuilder = EnumValueOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder, extensionRegistry);
                            setOptions(subBuilder.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = EnumValueDescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public boolean hasNumber() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public int getNumber() {
                return this.number_;
            }

            public Builder setNumber(int value) {
                this.bitField0_ |= 2;
                this.number_ = value;
                onChanged();
                return this;
            }

            public Builder clearNumber() {
                this.bitField0_ &= -3;
                this.number_ = 0;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public EnumValueOptions getOptions() {
                return this.optionsBuilder_ == null ? this.options_ : (EnumValueOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(EnumValueOptions value) {
                if (this.optionsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.options_ = value;
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(value);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setOptions(EnumValueOptions.Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeOptions(EnumValueOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & 4) == 4 && this.options_ != EnumValueOptions.getDefaultInstance()) {
                        this.options_ = EnumValueOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    } else {
                        this.options_ = value;
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = EnumValueOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            public EnumValueOptions.Builder getOptionsBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return (EnumValueOptions.Builder) getOptionsFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueDescriptorProtoOrBuilder
            public EnumValueOptionsOrBuilder getOptionsOrBuilder() {
                return this.optionsBuilder_ != null ? (EnumValueOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder() : this.options_;
            }

            private SingleFieldBuilder<EnumValueOptions, EnumValueOptions.Builder, EnumValueOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder<>(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class ServiceDescriptorProto extends GeneratedMessage implements ServiceDescriptorProtoOrBuilder {
        public static final int METHOD_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 3;
        private static final ServiceDescriptorProto defaultInstance = new ServiceDescriptorProto(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<MethodDescriptorProto> method_;
        private Object name_;
        private ServiceOptions options_;

        /* synthetic */ ServiceDescriptorProto(Builder builder, ServiceDescriptorProto serviceDescriptorProto) {
            this(builder);
        }

        private ServiceDescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private ServiceDescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static ServiceDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ServiceDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.f43x158c73ed;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f44xee335d6b;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public List<MethodDescriptorProto> getMethodList() {
            return this.method_;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public List<? extends MethodDescriptorProtoOrBuilder> getMethodOrBuilderList() {
            return this.method_;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public int getMethodCount() {
            return this.method_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public MethodDescriptorProto getMethod(int index) {
            return this.method_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public MethodDescriptorProtoOrBuilder getMethodOrBuilder(int index) {
            return this.method_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public ServiceOptions getOptions() {
            return this.options_;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
        public ServiceOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        private void initFields() {
            this.name_ = "";
            this.method_ = Collections.emptyList();
            this.options_ = ServiceOptions.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            for (int i = 0; i < getMethodCount(); i++) {
                if (!getMethod(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBytes(1, getNameBytes());
            }
            for (int i = 0; i < this.method_.size(); i++) {
                output.writeMessage(2, this.method_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeMessage(3, this.options_);
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getNameBytes()) : 0;
            for (int i = 0; i < this.method_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.method_.get(i));
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeMessageSize(3, this.options_);
            }
            int size3 = size2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static ServiceDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static ServiceDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ServiceDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements ServiceDescriptorProtoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<MethodDescriptorProto, MethodDescriptorProto.Builder, MethodDescriptorProtoOrBuilder> methodBuilder_;
            private List<MethodDescriptorProto> method_;
            private Object name_;
            private SingleFieldBuilder<ServiceOptions, ServiceOptions.Builder, ServiceOptionsOrBuilder> optionsBuilder_;
            private ServiceOptions options_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.f43x158c73ed;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f44xee335d6b;
            }

            private Builder() {
                this.name_ = "";
                this.method_ = Collections.emptyList();
                this.options_ = ServiceOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.method_ = Collections.emptyList();
                this.options_ = ServiceOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getMethodFieldBuilder();
                    getOptionsFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.name_ = "";
                this.bitField0_ &= -2;
                if (this.methodBuilder_ == null) {
                    this.method_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.methodBuilder_.clear();
                }
                if (this.optionsBuilder_ == null) {
                    this.options_ = ServiceOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ServiceDescriptorProto.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ServiceDescriptorProto getDefaultInstanceForType() {
                return ServiceDescriptorProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServiceDescriptorProto build() {
                ServiceDescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public ServiceDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                ServiceDescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServiceDescriptorProto buildPartial() {
                ServiceDescriptorProto result = new ServiceDescriptorProto(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ = 0 | 1;
                }
                result.name_ = this.name_;
                if (this.methodBuilder_ != null) {
                    result.method_ = this.methodBuilder_.build();
                } else {
                    if ((this.bitField0_ & 2) == 2) {
                        this.method_ = Collections.unmodifiableList(this.method_);
                        this.bitField0_ &= -3;
                    }
                    result.method_ = this.method_;
                }
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 2;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (ServiceOptions) this.optionsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof ServiceDescriptorProto) {
                    return mergeFrom((ServiceDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ServiceDescriptorProto other) {
                if (other != ServiceDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (this.methodBuilder_ == null) {
                        if (!other.method_.isEmpty()) {
                            if (this.method_.isEmpty()) {
                                this.method_ = other.method_;
                                this.bitField0_ &= -3;
                            } else {
                                ensureMethodIsMutable();
                                this.method_.addAll(other.method_);
                            }
                            onChanged();
                        }
                    } else if (!other.method_.isEmpty()) {
                        if (!this.methodBuilder_.isEmpty()) {
                            this.methodBuilder_.addAllMessages(other.method_);
                        } else {
                            this.methodBuilder_.dispose();
                            this.methodBuilder_ = null;
                            this.method_ = other.method_;
                            this.bitField0_ &= -3;
                            this.methodBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getMethodFieldBuilder() : null;
                        }
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getMethodCount(); i++) {
                    if (!getMethod(i).isInitialized()) {
                        return false;
                    }
                }
                return !hasOptions() || getOptions().isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.name_ = input.readBytes();
                            break;
                        case 18:
                            MethodDescriptorProto.Builder subBuilder = MethodDescriptorProto.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addMethod(subBuilder.buildPartial());
                            break;
                        case 26:
                            ServiceOptions.Builder subBuilder2 = ServiceOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder2.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder2, extensionRegistry);
                            setOptions(subBuilder2.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = ServiceDescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
            }

            private void ensureMethodIsMutable() {
                if ((this.bitField0_ & 2) != 2) {
                    this.method_ = new ArrayList(this.method_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public List<MethodDescriptorProto> getMethodList() {
                return this.methodBuilder_ == null ? Collections.unmodifiableList(this.method_) : this.methodBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public int getMethodCount() {
                return this.methodBuilder_ == null ? this.method_.size() : this.methodBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public MethodDescriptorProto getMethod(int index) {
                return this.methodBuilder_ == null ? this.method_.get(index) : (MethodDescriptorProto) this.methodBuilder_.getMessage(index);
            }

            public Builder setMethod(int index, MethodDescriptorProto value) {
                if (this.methodBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMethodIsMutable();
                    this.method_.set(index, value);
                    onChanged();
                } else {
                    this.methodBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setMethod(int index, MethodDescriptorProto.Builder builderForValue) {
                if (this.methodBuilder_ == null) {
                    ensureMethodIsMutable();
                    this.method_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.methodBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMethod(MethodDescriptorProto value) {
                if (this.methodBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMethodIsMutable();
                    this.method_.add(value);
                    onChanged();
                } else {
                    this.methodBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addMethod(int index, MethodDescriptorProto value) {
                if (this.methodBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureMethodIsMutable();
                    this.method_.add(index, value);
                    onChanged();
                } else {
                    this.methodBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addMethod(MethodDescriptorProto.Builder builderForValue) {
                if (this.methodBuilder_ == null) {
                    ensureMethodIsMutable();
                    this.method_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.methodBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMethod(int index, MethodDescriptorProto.Builder builderForValue) {
                if (this.methodBuilder_ == null) {
                    ensureMethodIsMutable();
                    this.method_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.methodBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMethod(Iterable<? extends MethodDescriptorProto> values) {
                if (this.methodBuilder_ == null) {
                    ensureMethodIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.method_);
                    onChanged();
                } else {
                    this.methodBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMethod() {
                if (this.methodBuilder_ == null) {
                    this.method_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.methodBuilder_.clear();
                }
                return this;
            }

            public Builder removeMethod(int index) {
                if (this.methodBuilder_ == null) {
                    ensureMethodIsMutable();
                    this.method_.remove(index);
                    onChanged();
                } else {
                    this.methodBuilder_.remove(index);
                }
                return this;
            }

            public MethodDescriptorProto.Builder getMethodBuilder(int index) {
                return (MethodDescriptorProto.Builder) getMethodFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public MethodDescriptorProtoOrBuilder getMethodOrBuilder(int index) {
                return this.methodBuilder_ == null ? this.method_.get(index) : (MethodDescriptorProtoOrBuilder) this.methodBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public List<? extends MethodDescriptorProtoOrBuilder> getMethodOrBuilderList() {
                return this.methodBuilder_ != null ? this.methodBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.method_);
            }

            public MethodDescriptorProto.Builder addMethodBuilder() {
                return (MethodDescriptorProto.Builder) getMethodFieldBuilder().addBuilder(MethodDescriptorProto.getDefaultInstance());
            }

            public MethodDescriptorProto.Builder addMethodBuilder(int index) {
                return (MethodDescriptorProto.Builder) getMethodFieldBuilder().addBuilder(index, MethodDescriptorProto.getDefaultInstance());
            }

            public List<MethodDescriptorProto.Builder> getMethodBuilderList() {
                return getMethodFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<MethodDescriptorProto, MethodDescriptorProto.Builder, MethodDescriptorProtoOrBuilder> getMethodFieldBuilder() {
                if (this.methodBuilder_ == null) {
                    this.methodBuilder_ = new RepeatedFieldBuilder<>(this.method_, (this.bitField0_ & 2) == 2, getParentForChildren(), isClean());
                    this.method_ = null;
                }
                return this.methodBuilder_;
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public ServiceOptions getOptions() {
                return this.optionsBuilder_ == null ? this.options_ : (ServiceOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(ServiceOptions value) {
                if (this.optionsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.options_ = value;
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(value);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder setOptions(ServiceOptions.Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder mergeOptions(ServiceOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & 4) == 4 && this.options_ != ServiceOptions.getDefaultInstance()) {
                        this.options_ = ServiceOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    } else {
                        this.options_ = value;
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 4;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = ServiceOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -5;
                return this;
            }

            public ServiceOptions.Builder getOptionsBuilder() {
                this.bitField0_ |= 4;
                onChanged();
                return (ServiceOptions.Builder) getOptionsFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceDescriptorProtoOrBuilder
            public ServiceOptionsOrBuilder getOptionsOrBuilder() {
                return this.optionsBuilder_ != null ? (ServiceOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder() : this.options_;
            }

            private SingleFieldBuilder<ServiceOptions, ServiceOptions.Builder, ServiceOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder<>(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class MethodDescriptorProto extends GeneratedMessage implements MethodDescriptorProtoOrBuilder {
        public static final int INPUT_TYPE_FIELD_NUMBER = 2;
        public static final int NAME_FIELD_NUMBER = 1;
        public static final int OPTIONS_FIELD_NUMBER = 4;
        public static final int OUTPUT_TYPE_FIELD_NUMBER = 3;
        private static final MethodDescriptorProto defaultInstance = new MethodDescriptorProto(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private Object inputType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Object name_;
        private MethodOptions options_;
        private Object outputType_;

        /* synthetic */ MethodDescriptorProto(Builder builder, MethodDescriptorProto methodDescriptorProto) {
            this(builder);
        }

        private MethodDescriptorProto(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private MethodDescriptorProto(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MethodDescriptorProto getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MethodDescriptorProto getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f42xc5331ef1;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public String getName() {
            Object ref = this.name_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.name_ = s;
            }
            return s;
        }

        private ByteString getNameBytes() {
            Object ref = this.name_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.name_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasInputType() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public String getInputType() {
            Object ref = this.inputType_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.inputType_ = s;
            }
            return s;
        }

        private ByteString getInputTypeBytes() {
            Object ref = this.inputType_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.inputType_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasOutputType() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public String getOutputType() {
            Object ref = this.outputType_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.outputType_ = s;
            }
            return s;
        }

        private ByteString getOutputTypeBytes() {
            Object ref = this.outputType_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.outputType_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public boolean hasOptions() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public MethodOptions getOptions() {
            return this.options_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
        public MethodOptionsOrBuilder getOptionsOrBuilder() {
            return this.options_;
        }

        private void initFields() {
            this.name_ = "";
            this.inputType_ = "";
            this.outputType_ = "";
            this.options_ = MethodOptions.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            if (hasOptions() && !getOptions().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBytes(1, getNameBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeBytes(2, getInputTypeBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeBytes(3, getOutputTypeBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeMessage(4, this.options_);
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getNameBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeBytesSize(2, getInputTypeBytes());
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeBytesSize(3, getOutputTypeBytes());
            }
            if ((this.bitField0_ & 8) == 8) {
                size2 += CodedOutputStream.computeMessageSize(4, this.options_);
            }
            int size3 = size2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodDescriptorProto parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodDescriptorProto parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodDescriptorProto parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodDescriptorProto parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodDescriptorProto parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodDescriptorProto parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static MethodDescriptorProto parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodDescriptorProto parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MethodDescriptorProto parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MethodDescriptorProto prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements MethodDescriptorProtoOrBuilder {
            private int bitField0_;
            private Object inputType_;
            private Object name_;
            private SingleFieldBuilder<MethodOptions, MethodOptions.Builder, MethodOptionsOrBuilder> optionsBuilder_;
            private MethodOptions options_;
            private Object outputType_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f42xc5331ef1;
            }

            private Builder() {
                this.name_ = "";
                this.inputType_ = "";
                this.outputType_ = "";
                this.options_ = MethodOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = "";
                this.inputType_ = "";
                this.outputType_ = "";
                this.options_ = MethodOptions.getDefaultInstance();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getOptionsFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.name_ = "";
                this.bitField0_ &= -2;
                this.inputType_ = "";
                this.bitField0_ &= -3;
                this.outputType_ = "";
                this.bitField0_ &= -5;
                if (this.optionsBuilder_ == null) {
                    this.options_ = MethodOptions.getDefaultInstance();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -9;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MethodDescriptorProto.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MethodDescriptorProto getDefaultInstanceForType() {
                return MethodDescriptorProto.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MethodDescriptorProto build() {
                MethodDescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public MethodDescriptorProto buildParsed() throws InvalidProtocolBufferException {
                MethodDescriptorProto result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MethodDescriptorProto buildPartial() {
                MethodDescriptorProto result = new MethodDescriptorProto(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ = 0 | 1;
                }
                result.name_ = this.name_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.inputType_ = this.inputType_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.outputType_ = this.outputType_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                if (this.optionsBuilder_ == null) {
                    result.options_ = this.options_;
                } else {
                    result.options_ = (MethodOptions) this.optionsBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof MethodDescriptorProto) {
                    return mergeFrom((MethodDescriptorProto) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MethodDescriptorProto other) {
                if (other != MethodDescriptorProto.getDefaultInstance()) {
                    if (other.hasName()) {
                        setName(other.getName());
                    }
                    if (other.hasInputType()) {
                        setInputType(other.getInputType());
                    }
                    if (other.hasOutputType()) {
                        setOutputType(other.getOutputType());
                    }
                    if (other.hasOptions()) {
                        mergeOptions(other.getOptions());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return !hasOptions() || getOptions().isInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.name_ = input.readBytes();
                            break;
                        case 18:
                            this.bitField0_ |= 2;
                            this.inputType_ = input.readBytes();
                            break;
                        case 26:
                            this.bitField0_ |= 4;
                            this.outputType_ = input.readBytes();
                            break;
                        case 34:
                            MethodOptions.Builder subBuilder = MethodOptions.newBuilder();
                            if (hasOptions()) {
                                subBuilder.mergeFrom(getOptions());
                            }
                            input.readMessage(subBuilder, extensionRegistry);
                            setOptions(subBuilder.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasName() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public String getName() {
                Object ref = this.name_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.name_ = s;
                return s;
            }

            public Builder setName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
                return this;
            }

            public Builder clearName() {
                this.bitField0_ &= -2;
                this.name_ = MethodDescriptorProto.getDefaultInstance().getName();
                onChanged();
                return this;
            }

            void setName(ByteString value) {
                this.bitField0_ |= 1;
                this.name_ = value;
                onChanged();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasInputType() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public String getInputType() {
                Object ref = this.inputType_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.inputType_ = s;
                return s;
            }

            public Builder setInputType(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.inputType_ = value;
                onChanged();
                return this;
            }

            public Builder clearInputType() {
                this.bitField0_ &= -3;
                this.inputType_ = MethodDescriptorProto.getDefaultInstance().getInputType();
                onChanged();
                return this;
            }

            void setInputType(ByteString value) {
                this.bitField0_ |= 2;
                this.inputType_ = value;
                onChanged();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasOutputType() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public String getOutputType() {
                Object ref = this.outputType_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.outputType_ = s;
                return s;
            }

            public Builder setOutputType(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 4;
                this.outputType_ = value;
                onChanged();
                return this;
            }

            public Builder clearOutputType() {
                this.bitField0_ &= -5;
                this.outputType_ = MethodDescriptorProto.getDefaultInstance().getOutputType();
                onChanged();
                return this;
            }

            void setOutputType(ByteString value) {
                this.bitField0_ |= 4;
                this.outputType_ = value;
                onChanged();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public boolean hasOptions() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public MethodOptions getOptions() {
                return this.optionsBuilder_ == null ? this.options_ : (MethodOptions) this.optionsBuilder_.getMessage();
            }

            public Builder setOptions(MethodOptions value) {
                if (this.optionsBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.options_ = value;
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(value);
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder setOptions(MethodOptions.Builder builderForValue) {
                if (this.optionsBuilder_ == null) {
                    this.options_ = builderForValue.build();
                    onChanged();
                } else {
                    this.optionsBuilder_.setMessage(builderForValue.build());
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder mergeOptions(MethodOptions value) {
                if (this.optionsBuilder_ == null) {
                    if ((this.bitField0_ & 8) == 8 && this.options_ != MethodOptions.getDefaultInstance()) {
                        this.options_ = MethodOptions.newBuilder(this.options_).mergeFrom(value).buildPartial();
                    } else {
                        this.options_ = value;
                    }
                    onChanged();
                } else {
                    this.optionsBuilder_.mergeFrom(value);
                }
                this.bitField0_ |= 8;
                return this;
            }

            public Builder clearOptions() {
                if (this.optionsBuilder_ == null) {
                    this.options_ = MethodOptions.getDefaultInstance();
                    onChanged();
                } else {
                    this.optionsBuilder_.clear();
                }
                this.bitField0_ &= -9;
                return this;
            }

            public MethodOptions.Builder getOptionsBuilder() {
                this.bitField0_ |= 8;
                onChanged();
                return (MethodOptions.Builder) getOptionsFieldBuilder().getBuilder();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodDescriptorProtoOrBuilder
            public MethodOptionsOrBuilder getOptionsOrBuilder() {
                return this.optionsBuilder_ != null ? (MethodOptionsOrBuilder) this.optionsBuilder_.getMessageOrBuilder() : this.options_;
            }

            private SingleFieldBuilder<MethodOptions, MethodOptions.Builder, MethodOptionsOrBuilder> getOptionsFieldBuilder() {
                if (this.optionsBuilder_ == null) {
                    this.optionsBuilder_ = new SingleFieldBuilder<>(this.options_, getParentForChildren(), isClean());
                    this.options_ = null;
                }
                return this.optionsBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class FileOptions extends GeneratedMessage.ExtendableMessage<FileOptions> implements FileOptionsOrBuilder {
        public static final int CC_GENERIC_SERVICES_FIELD_NUMBER = 16;
        public static final int JAVA_GENERATE_EQUALS_AND_HASH_FIELD_NUMBER = 20;
        public static final int JAVA_GENERIC_SERVICES_FIELD_NUMBER = 17;
        public static final int JAVA_MULTIPLE_FILES_FIELD_NUMBER = 10;
        public static final int JAVA_OUTER_CLASSNAME_FIELD_NUMBER = 8;
        public static final int JAVA_PACKAGE_FIELD_NUMBER = 1;
        public static final int OPTIMIZE_FOR_FIELD_NUMBER = 9;
        public static final int PY_GENERIC_SERVICES_FIELD_NUMBER = 18;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final FileOptions defaultInstance = new FileOptions(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private boolean ccGenericServices_;
        private boolean javaGenerateEqualsAndHash_;
        private boolean javaGenericServices_;
        private boolean javaMultipleFiles_;
        private Object javaOuterClassname_;
        private Object javaPackage_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private OptimizeMode optimizeFor_;
        private boolean pyGenericServices_;
        private List<UninterpretedOption> uninterpretedOption_;

        /* synthetic */ FileOptions(Builder builder, FileOptions fileOptions) {
            this(builder);
        }

        private FileOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private FileOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static FileOptions getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FileOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable;
        }

        public enum OptimizeMode implements ProtocolMessageEnum {
            SPEED(0, 1),
            CODE_SIZE(1, 2),
            LITE_RUNTIME(2, 3);

            public static final int CODE_SIZE_VALUE = 2;
            public static final int LITE_RUNTIME_VALUE = 3;
            public static final int SPEED_VALUE = 1;
            private final int index;
            private final int value;
            private static Internal.EnumLiteMap<OptimizeMode> internalValueMap = new Internal.EnumLiteMap<OptimizeMode>() { // from class: com.google.protobuf.DescriptorProtos.FileOptions.OptimizeMode.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public OptimizeMode findValueByNumber(int number) {
                    return OptimizeMode.valueOf(number);
                }
            };
            private static final OptimizeMode[] VALUES = {SPEED, CODE_SIZE, LITE_RUNTIME};

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static OptimizeMode[] valuesCustom() {
                OptimizeMode[] optimizeModeArrValuesCustom = values();
                int length = optimizeModeArrValuesCustom.length;
                OptimizeMode[] optimizeModeArr = new OptimizeMode[length];
                System.arraycopy(optimizeModeArrValuesCustom, 0, optimizeModeArr, 0, length);
                return optimizeModeArr;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static OptimizeMode valueOf(int value) {
                switch (value) {
                    case 1:
                        return SPEED;
                    case 2:
                        return CODE_SIZE;
                    case 3:
                        return LITE_RUNTIME;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<OptimizeMode> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return getDescriptor().getValues().get(this.index);
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return FileOptions.getDescriptor().getEnumTypes().get(0);
            }

            public static OptimizeMode valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            OptimizeMode(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaPackage() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getJavaPackage() {
            Object ref = this.javaPackage_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.javaPackage_ = s;
            }
            return s;
        }

        private ByteString getJavaPackageBytes() {
            Object ref = this.javaPackage_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.javaPackage_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaOuterClassname() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public String getJavaOuterClassname() {
            Object ref = this.javaOuterClassname_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.javaOuterClassname_ = s;
            }
            return s;
        }

        private ByteString getJavaOuterClassnameBytes() {
            Object ref = this.javaOuterClassname_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.javaOuterClassname_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaMultipleFiles() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getJavaMultipleFiles() {
            return this.javaMultipleFiles_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaGenerateEqualsAndHash() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getJavaGenerateEqualsAndHash() {
            return this.javaGenerateEqualsAndHash_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasOptimizeFor() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public OptimizeMode getOptimizeFor() {
            return this.optimizeFor_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasCcGenericServices() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getCcGenericServices() {
            return this.ccGenericServices_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasJavaGenericServices() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getJavaGenericServices() {
            return this.javaGenericServices_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean hasPyGenericServices() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public boolean getPyGenericServices() {
            return this.pyGenericServices_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int index) {
            return this.uninterpretedOption_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.javaPackage_ = "";
            this.javaOuterClassname_ = "";
            this.javaMultipleFiles_ = false;
            this.javaGenerateEqualsAndHash_ = false;
            this.optimizeFor_ = OptimizeMode.SPEED;
            this.ccGenericServices_ = false;
            this.javaGenericServices_ = false;
            this.pyGenericServices_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                if (!getUninterpretedOption(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            GeneratedMessage.ExtendableMessage<MessageType>.ExtensionWriter extensionWriterNewExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBytes(1, getJavaPackageBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeBytes(8, getJavaOuterClassnameBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                output.writeEnum(9, this.optimizeFor_.getNumber());
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeBool(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 32) == 32) {
                output.writeBool(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 64) == 64) {
                output.writeBool(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 128) == 128) {
                output.writeBool(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeBool(20, this.javaGenerateEqualsAndHash_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, this.uninterpretedOption_.get(i));
            }
            extensionWriterNewExtensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getJavaPackageBytes()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeBytesSize(8, getJavaOuterClassnameBytes());
            }
            if ((this.bitField0_ & 16) == 16) {
                size2 += CodedOutputStream.computeEnumSize(9, this.optimizeFor_.getNumber());
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeBoolSize(10, this.javaMultipleFiles_);
            }
            if ((this.bitField0_ & 32) == 32) {
                size2 += CodedOutputStream.computeBoolSize(16, this.ccGenericServices_);
            }
            if ((this.bitField0_ & 64) == 64) {
                size2 += CodedOutputStream.computeBoolSize(17, this.javaGenericServices_);
            }
            if ((this.bitField0_ & 128) == 128) {
                size2 += CodedOutputStream.computeBoolSize(18, this.pyGenericServices_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size2 += CodedOutputStream.computeBoolSize(20, this.javaGenerateEqualsAndHash_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FileOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FileOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FileOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FileOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FileOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.ExtendableBuilder<FileOptions, Builder> implements FileOptionsOrBuilder {
            private int bitField0_;
            private boolean ccGenericServices_;
            private boolean javaGenerateEqualsAndHash_;
            private boolean javaGenericServices_;
            private boolean javaMultipleFiles_;
            private Object javaOuterClassname_;
            private Object javaPackage_;
            private OptimizeMode optimizeFor_;
            private boolean pyGenericServices_;
            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable;
            }

            private Builder() {
                this.javaPackage_ = "";
                this.javaOuterClassname_ = "";
                this.optimizeFor_ = OptimizeMode.SPEED;
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.javaPackage_ = "";
                this.javaOuterClassname_ = "";
                this.optimizeFor_ = OptimizeMode.SPEED;
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.javaPackage_ = "";
                this.bitField0_ &= -2;
                this.javaOuterClassname_ = "";
                this.bitField0_ &= -3;
                this.javaMultipleFiles_ = false;
                this.bitField0_ &= -5;
                this.javaGenerateEqualsAndHash_ = false;
                this.bitField0_ &= -9;
                this.optimizeFor_ = OptimizeMode.SPEED;
                this.bitField0_ &= -17;
                this.ccGenericServices_ = false;
                this.bitField0_ &= -33;
                this.javaGenericServices_ = false;
                this.bitField0_ &= -65;
                this.pyGenericServices_ = false;
                this.bitField0_ &= -129;
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -257;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FileOptions.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FileOptions getDefaultInstanceForType() {
                return FileOptions.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileOptions build() {
                FileOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public FileOptions buildParsed() throws InvalidProtocolBufferException {
                FileOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FileOptions buildPartial() {
                FileOptions result = new FileOptions(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ = 0 | 1;
                }
                result.javaPackage_ = this.javaPackage_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.javaOuterClassname_ = this.javaOuterClassname_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.javaMultipleFiles_ = this.javaMultipleFiles_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.javaGenerateEqualsAndHash_ = this.javaGenerateEqualsAndHash_;
                if ((from_bitField0_ & 16) == 16) {
                    to_bitField0_ |= 16;
                }
                result.optimizeFor_ = this.optimizeFor_;
                if ((from_bitField0_ & 32) == 32) {
                    to_bitField0_ |= 32;
                }
                result.ccGenericServices_ = this.ccGenericServices_;
                if ((from_bitField0_ & 64) == 64) {
                    to_bitField0_ |= 64;
                }
                result.javaGenericServices_ = this.javaGenericServices_;
                if ((from_bitField0_ & 128) == 128) {
                    to_bitField0_ |= 128;
                }
                result.pyGenericServices_ = this.pyGenericServices_;
                if (this.uninterpretedOptionBuilder_ != null) {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                } else {
                    if ((this.bitField0_ & 256) == 256) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -257;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof FileOptions) {
                    return mergeFrom((FileOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FileOptions other) {
                if (other != FileOptions.getDefaultInstance()) {
                    if (other.hasJavaPackage()) {
                        setJavaPackage(other.getJavaPackage());
                    }
                    if (other.hasJavaOuterClassname()) {
                        setJavaOuterClassname(other.getJavaOuterClassname());
                    }
                    if (other.hasJavaMultipleFiles()) {
                        setJavaMultipleFiles(other.getJavaMultipleFiles());
                    }
                    if (other.hasJavaGenerateEqualsAndHash()) {
                        setJavaGenerateEqualsAndHash(other.getJavaGenerateEqualsAndHash());
                    }
                    if (other.hasOptimizeFor()) {
                        setOptimizeFor(other.getOptimizeFor());
                    }
                    if (other.hasCcGenericServices()) {
                        setCcGenericServices(other.getCcGenericServices());
                    }
                    if (other.hasJavaGenericServices()) {
                        setJavaGenericServices(other.getJavaGenericServices());
                    }
                    if (other.hasPyGenericServices()) {
                        setPyGenericServices(other.getPyGenericServices());
                    }
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -257;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (!this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        } else {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -257;
                            this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null;
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                return extensionsAreInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 10:
                            this.bitField0_ |= 1;
                            this.javaPackage_ = input.readBytes();
                            break;
                        case 66:
                            this.bitField0_ |= 2;
                            this.javaOuterClassname_ = input.readBytes();
                            break;
                        case 72:
                            int rawValue = input.readEnum();
                            OptimizeMode value = OptimizeMode.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(9, rawValue);
                                break;
                            } else {
                                this.bitField0_ |= 16;
                                this.optimizeFor_ = value;
                                break;
                            }
                        case 80:
                            this.bitField0_ |= 4;
                            this.javaMultipleFiles_ = input.readBool();
                            break;
                        case 128:
                            this.bitField0_ |= 32;
                            this.ccGenericServices_ = input.readBool();
                            break;
                        case SPenImageFilterConstants.FILTER_CLASSIC /* 136 */:
                            this.bitField0_ |= 64;
                            this.javaGenericServices_ = input.readBool();
                            break;
                        case 144:
                            this.bitField0_ |= 128;
                            this.pyGenericServices_ = input.readBool();
                            break;
                        case 160:
                            this.bitField0_ |= 8;
                            this.javaGenerateEqualsAndHash_ = input.readBool();
                            break;
                        case 7994:
                            UninterpretedOption.Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaPackage() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getJavaPackage() {
                Object ref = this.javaPackage_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.javaPackage_ = s;
                return s;
            }

            public Builder setJavaPackage(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.javaPackage_ = value;
                onChanged();
                return this;
            }

            public Builder clearJavaPackage() {
                this.bitField0_ &= -2;
                this.javaPackage_ = FileOptions.getDefaultInstance().getJavaPackage();
                onChanged();
                return this;
            }

            void setJavaPackage(ByteString value) {
                this.bitField0_ |= 1;
                this.javaPackage_ = value;
                onChanged();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaOuterClassname() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public String getJavaOuterClassname() {
                Object ref = this.javaOuterClassname_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.javaOuterClassname_ = s;
                return s;
            }

            public Builder setJavaOuterClassname(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.javaOuterClassname_ = value;
                onChanged();
                return this;
            }

            public Builder clearJavaOuterClassname() {
                this.bitField0_ &= -3;
                this.javaOuterClassname_ = FileOptions.getDefaultInstance().getJavaOuterClassname();
                onChanged();
                return this;
            }

            void setJavaOuterClassname(ByteString value) {
                this.bitField0_ |= 2;
                this.javaOuterClassname_ = value;
                onChanged();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaMultipleFiles() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getJavaMultipleFiles() {
                return this.javaMultipleFiles_;
            }

            public Builder setJavaMultipleFiles(boolean value) {
                this.bitField0_ |= 4;
                this.javaMultipleFiles_ = value;
                onChanged();
                return this;
            }

            public Builder clearJavaMultipleFiles() {
                this.bitField0_ &= -5;
                this.javaMultipleFiles_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaGenerateEqualsAndHash() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getJavaGenerateEqualsAndHash() {
                return this.javaGenerateEqualsAndHash_;
            }

            public Builder setJavaGenerateEqualsAndHash(boolean value) {
                this.bitField0_ |= 8;
                this.javaGenerateEqualsAndHash_ = value;
                onChanged();
                return this;
            }

            public Builder clearJavaGenerateEqualsAndHash() {
                this.bitField0_ &= -9;
                this.javaGenerateEqualsAndHash_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasOptimizeFor() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public OptimizeMode getOptimizeFor() {
                return this.optimizeFor_;
            }

            public Builder setOptimizeFor(OptimizeMode value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 16;
                this.optimizeFor_ = value;
                onChanged();
                return this;
            }

            public Builder clearOptimizeFor() {
                this.bitField0_ &= -17;
                this.optimizeFor_ = OptimizeMode.SPEED;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasCcGenericServices() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getCcGenericServices() {
                return this.ccGenericServices_;
            }

            public Builder setCcGenericServices(boolean value) {
                this.bitField0_ |= 32;
                this.ccGenericServices_ = value;
                onChanged();
                return this;
            }

            public Builder clearCcGenericServices() {
                this.bitField0_ &= -33;
                this.ccGenericServices_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasJavaGenericServices() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getJavaGenericServices() {
                return this.javaGenericServices_;
            }

            public Builder setJavaGenericServices(boolean value) {
                this.bitField0_ |= 64;
                this.javaGenericServices_ = value;
                onChanged();
                return this;
            }

            public Builder clearJavaGenericServices() {
                this.bitField0_ &= -65;
                this.javaGenericServices_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean hasPyGenericServices() {
                return (this.bitField0_ & 128) == 128;
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public boolean getPyGenericServices() {
                return this.pyGenericServices_;
            }

            public Builder setPyGenericServices(boolean value) {
                this.bitField0_ |= 128;
                this.pyGenericServices_ = value;
                onChanged();
                return this;
            }

            public Builder clearPyGenericServices() {
                this.bitField0_ &= -129;
                this.pyGenericServices_ = false;
                onChanged();
                return this;
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 256) != 256) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 256;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return this.uninterpretedOptionBuilder_ == null ? Collections.unmodifiableList(this.uninterpretedOption_) : this.uninterpretedOptionBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.size() : this.uninterpretedOptionBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    GeneratedMessage.ExtendableBuilder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -257;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public UninterpretedOption.Builder getUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FileOptionsOrBuilder
            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                return this.uninterpretedOptionBuilder_ != null ? this.uninterpretedOptionBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder() {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<UninterpretedOption.Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder<>(this.uninterpretedOption_, (this.bitField0_ & 256) == 256, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class MessageOptions extends GeneratedMessage.ExtendableMessage<MessageOptions> implements MessageOptionsOrBuilder {
        public static final int MESSAGE_SET_WIRE_FORMAT_FIELD_NUMBER = 1;
        public static final int NO_STANDARD_DESCRIPTOR_ACCESSOR_FIELD_NUMBER = 2;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final MessageOptions defaultInstance = new MessageOptions(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean messageSetWireFormat_;
        private boolean noStandardDescriptorAccessor_;
        private List<UninterpretedOption> uninterpretedOption_;

        /* synthetic */ MessageOptions(Builder builder, MessageOptions messageOptions) {
            this(builder);
        }

        private MessageOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private MessageOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MessageOptions getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MessageOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f41x9c0b3d38;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasMessageSetWireFormat() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getMessageSetWireFormat() {
            return this.messageSetWireFormat_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean hasNoStandardDescriptorAccessor() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public boolean getNoStandardDescriptorAccessor() {
            return this.noStandardDescriptorAccessor_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int index) {
            return this.uninterpretedOption_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.messageSetWireFormat_ = false;
            this.noStandardDescriptorAccessor_ = false;
            this.uninterpretedOption_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                if (!getUninterpretedOption(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            GeneratedMessage.ExtendableMessage<MessageType>.ExtensionWriter extensionWriterNewExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeBool(1, this.messageSetWireFormat_);
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeBool(2, this.noStandardDescriptorAccessor_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, this.uninterpretedOption_.get(i));
            }
            extensionWriterNewExtensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBoolSize(1, this.messageSetWireFormat_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeBoolSize(2, this.noStandardDescriptorAccessor_);
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MessageOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MessageOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MessageOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MessageOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MessageOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MessageOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static MessageOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static MessageOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MessageOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MessageOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MessageOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.ExtendableBuilder<MessageOptions, Builder> implements MessageOptionsOrBuilder {
            private int bitField0_;
            private boolean messageSetWireFormat_;
            private boolean noStandardDescriptorAccessor_;
            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f41x9c0b3d38;
            }

            private Builder() {
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.messageSetWireFormat_ = false;
                this.bitField0_ &= -2;
                this.noStandardDescriptorAccessor_ = false;
                this.bitField0_ &= -3;
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MessageOptions.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MessageOptions getDefaultInstanceForType() {
                return MessageOptions.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MessageOptions build() {
                MessageOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public MessageOptions buildParsed() throws InvalidProtocolBufferException {
                MessageOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MessageOptions buildPartial() {
                MessageOptions result = new MessageOptions(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ = 0 | 1;
                }
                result.messageSetWireFormat_ = this.messageSetWireFormat_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.noStandardDescriptorAccessor_ = this.noStandardDescriptorAccessor_;
                if (this.uninterpretedOptionBuilder_ != null) {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                } else {
                    if ((this.bitField0_ & 4) == 4) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -5;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof MessageOptions) {
                    return mergeFrom((MessageOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MessageOptions other) {
                if (other != MessageOptions.getDefaultInstance()) {
                    if (other.hasMessageSetWireFormat()) {
                        setMessageSetWireFormat(other.getMessageSetWireFormat());
                    }
                    if (other.hasNoStandardDescriptorAccessor()) {
                        setNoStandardDescriptorAccessor(other.getNoStandardDescriptorAccessor());
                    }
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -5;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (!this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        } else {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -5;
                            this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null;
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                return extensionsAreInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 8:
                            this.bitField0_ |= 1;
                            this.messageSetWireFormat_ = input.readBool();
                            break;
                        case 16:
                            this.bitField0_ |= 2;
                            this.noStandardDescriptorAccessor_ = input.readBool();
                            break;
                        case 7994:
                            UninterpretedOption.Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasMessageSetWireFormat() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getMessageSetWireFormat() {
                return this.messageSetWireFormat_;
            }

            public Builder setMessageSetWireFormat(boolean value) {
                this.bitField0_ |= 1;
                this.messageSetWireFormat_ = value;
                onChanged();
                return this;
            }

            public Builder clearMessageSetWireFormat() {
                this.bitField0_ &= -2;
                this.messageSetWireFormat_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean hasNoStandardDescriptorAccessor() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public boolean getNoStandardDescriptorAccessor() {
                return this.noStandardDescriptorAccessor_;
            }

            public Builder setNoStandardDescriptorAccessor(boolean value) {
                this.bitField0_ |= 2;
                this.noStandardDescriptorAccessor_ = value;
                onChanged();
                return this;
            }

            public Builder clearNoStandardDescriptorAccessor() {
                this.bitField0_ &= -3;
                this.noStandardDescriptorAccessor_ = false;
                onChanged();
                return this;
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 4) != 4) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return this.uninterpretedOptionBuilder_ == null ? Collections.unmodifiableList(this.uninterpretedOption_) : this.uninterpretedOptionBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.size() : this.uninterpretedOptionBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    GeneratedMessage.ExtendableBuilder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public UninterpretedOption.Builder getUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.MessageOptionsOrBuilder
            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                return this.uninterpretedOptionBuilder_ != null ? this.uninterpretedOptionBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder() {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<UninterpretedOption.Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder<>(this.uninterpretedOption_, (this.bitField0_ & 4) == 4, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class FieldOptions extends GeneratedMessage.ExtendableMessage<FieldOptions> implements FieldOptionsOrBuilder {
        public static final int CTYPE_FIELD_NUMBER = 1;
        public static final int DEPRECATED_FIELD_NUMBER = 3;
        public static final int EXPERIMENTAL_MAP_KEY_FIELD_NUMBER = 9;
        public static final int PACKED_FIELD_NUMBER = 2;
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final FieldOptions defaultInstance = new FieldOptions(true);
        private static final long serialVersionUID = 0;
        private int bitField0_;
        private CType ctype_;
        private boolean deprecated_;
        private Object experimentalMapKey_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean packed_;
        private List<UninterpretedOption> uninterpretedOption_;

        /* synthetic */ FieldOptions(Builder builder, FieldOptions fieldOptions) {
            this(builder);
        }

        private FieldOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private FieldOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static FieldOptions getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FieldOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
        }

        public enum CType implements ProtocolMessageEnum {
            STRING(0, 0),
            CORD(1, 1),
            STRING_PIECE(2, 2);

            public static final int CORD_VALUE = 1;
            public static final int STRING_PIECE_VALUE = 2;
            public static final int STRING_VALUE = 0;
            private final int index;
            private final int value;
            private static Internal.EnumLiteMap<CType> internalValueMap = new Internal.EnumLiteMap<CType>() { // from class: com.google.protobuf.DescriptorProtos.FieldOptions.CType.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                public CType findValueByNumber(int number) {
                    return CType.valueOf(number);
                }
            };
            private static final CType[] VALUES = {STRING, CORD, STRING_PIECE};

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static CType[] valuesCustom() {
                CType[] cTypeArrValuesCustom = values();
                int length = cTypeArrValuesCustom.length;
                CType[] cTypeArr = new CType[length];
                System.arraycopy(cTypeArrValuesCustom, 0, cTypeArr, 0, length);
                return cTypeArr;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                return this.value;
            }

            public static CType valueOf(int value) {
                switch (value) {
                    case 0:
                        return STRING;
                    case 1:
                        return CORD;
                    case 2:
                        return STRING_PIECE;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<CType> internalGetValueMap() {
                return internalValueMap;
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumValueDescriptor getValueDescriptor() {
                return getDescriptor().getValues().get(this.index);
            }

            @Override // com.google.protobuf.ProtocolMessageEnum
            public final Descriptors.EnumDescriptor getDescriptorForType() {
                return getDescriptor();
            }

            public static final Descriptors.EnumDescriptor getDescriptor() {
                return FieldOptions.getDescriptor().getEnumTypes().get(0);
            }

            public static CType valueOf(Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            CType(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasCtype() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public CType getCtype() {
            return this.ctype_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasPacked() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getPacked() {
            return this.packed_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasDeprecated() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean getDeprecated() {
            return this.deprecated_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public boolean hasExperimentalMapKey() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public String getExperimentalMapKey() {
            Object ref = this.experimentalMapKey_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.experimentalMapKey_ = s;
            }
            return s;
        }

        private ByteString getExperimentalMapKeyBytes() {
            Object ref = this.experimentalMapKey_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.experimentalMapKey_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int index) {
            return this.uninterpretedOption_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.ctype_ = CType.STRING;
            this.packed_ = false;
            this.deprecated_ = false;
            this.experimentalMapKey_ = "";
            this.uninterpretedOption_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                if (!getUninterpretedOption(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            GeneratedMessage.ExtendableMessage<MessageType>.ExtensionWriter extensionWriterNewExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                output.writeEnum(1, this.ctype_.getNumber());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeBool(2, this.packed_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeBool(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeBytes(9, getExperimentalMapKeyBytes());
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, this.uninterpretedOption_.get(i));
            }
            extensionWriterNewExtensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeEnumSize(1, this.ctype_.getNumber()) : 0;
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeBoolSize(2, this.packed_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeBoolSize(3, this.deprecated_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size2 += CodedOutputStream.computeBytesSize(9, getExperimentalMapKeyBytes());
            }
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static FieldOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static FieldOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static FieldOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static FieldOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(FieldOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.ExtendableBuilder<FieldOptions, Builder> implements FieldOptionsOrBuilder {
            private int bitField0_;
            private CType ctype_;
            private boolean deprecated_;
            private Object experimentalMapKey_;
            private boolean packed_;
            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable;
            }

            private Builder() {
                this.ctype_ = CType.STRING;
                this.experimentalMapKey_ = "";
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.ctype_ = CType.STRING;
                this.experimentalMapKey_ = "";
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                this.ctype_ = CType.STRING;
                this.bitField0_ &= -2;
                this.packed_ = false;
                this.bitField0_ &= -3;
                this.deprecated_ = false;
                this.bitField0_ &= -5;
                this.experimentalMapKey_ = "";
                this.bitField0_ &= -9;
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FieldOptions.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FieldOptions getDefaultInstanceForType() {
                return FieldOptions.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FieldOptions build() {
                FieldOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public FieldOptions buildParsed() throws InvalidProtocolBufferException {
                FieldOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FieldOptions buildPartial() {
                FieldOptions result = new FieldOptions(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if ((from_bitField0_ & 1) == 1) {
                    to_bitField0_ = 0 | 1;
                }
                result.ctype_ = this.ctype_;
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ |= 2;
                }
                result.packed_ = this.packed_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 4;
                }
                result.deprecated_ = this.deprecated_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 8;
                }
                result.experimentalMapKey_ = this.experimentalMapKey_;
                if (this.uninterpretedOptionBuilder_ != null) {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                } else {
                    if ((this.bitField0_ & 16) == 16) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -17;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof FieldOptions) {
                    return mergeFrom((FieldOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FieldOptions other) {
                if (other != FieldOptions.getDefaultInstance()) {
                    if (other.hasCtype()) {
                        setCtype(other.getCtype());
                    }
                    if (other.hasPacked()) {
                        setPacked(other.getPacked());
                    }
                    if (other.hasDeprecated()) {
                        setDeprecated(other.getDeprecated());
                    }
                    if (other.hasExperimentalMapKey()) {
                        setExperimentalMapKey(other.getExperimentalMapKey());
                    }
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -17;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (!this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        } else {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -17;
                            this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null;
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                return extensionsAreInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 8:
                            int rawValue = input.readEnum();
                            CType value = CType.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(1, rawValue);
                                break;
                            } else {
                                this.bitField0_ |= 1;
                                this.ctype_ = value;
                                break;
                            }
                        case 16:
                            this.bitField0_ |= 2;
                            this.packed_ = input.readBool();
                            break;
                        case 24:
                            this.bitField0_ |= 4;
                            this.deprecated_ = input.readBool();
                            break;
                        case SPenImageFilterConstants.FILTER_COLORSKETCH /* 74 */:
                            this.bitField0_ |= 8;
                            this.experimentalMapKey_ = input.readBytes();
                            break;
                        case 7994:
                            UninterpretedOption.Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasCtype() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public CType getCtype() {
                return this.ctype_;
            }

            public Builder setCtype(CType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 1;
                this.ctype_ = value;
                onChanged();
                return this;
            }

            public Builder clearCtype() {
                this.bitField0_ &= -2;
                this.ctype_ = CType.STRING;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasPacked() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getPacked() {
                return this.packed_;
            }

            public Builder setPacked(boolean value) {
                this.bitField0_ |= 2;
                this.packed_ = value;
                onChanged();
                return this;
            }

            public Builder clearPacked() {
                this.bitField0_ &= -3;
                this.packed_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasDeprecated() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean getDeprecated() {
                return this.deprecated_;
            }

            public Builder setDeprecated(boolean value) {
                this.bitField0_ |= 4;
                this.deprecated_ = value;
                onChanged();
                return this;
            }

            public Builder clearDeprecated() {
                this.bitField0_ &= -5;
                this.deprecated_ = false;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public boolean hasExperimentalMapKey() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public String getExperimentalMapKey() {
                Object ref = this.experimentalMapKey_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.experimentalMapKey_ = s;
                return s;
            }

            public Builder setExperimentalMapKey(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 8;
                this.experimentalMapKey_ = value;
                onChanged();
                return this;
            }

            public Builder clearExperimentalMapKey() {
                this.bitField0_ &= -9;
                this.experimentalMapKey_ = FieldOptions.getDefaultInstance().getExperimentalMapKey();
                onChanged();
                return this;
            }

            void setExperimentalMapKey(ByteString value) {
                this.bitField0_ |= 8;
                this.experimentalMapKey_ = value;
                onChanged();
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 16) != 16) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return this.uninterpretedOptionBuilder_ == null ? Collections.unmodifiableList(this.uninterpretedOption_) : this.uninterpretedOptionBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.size() : this.uninterpretedOptionBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    GeneratedMessage.ExtendableBuilder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public UninterpretedOption.Builder getUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.FieldOptionsOrBuilder
            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                return this.uninterpretedOptionBuilder_ != null ? this.uninterpretedOptionBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder() {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<UninterpretedOption.Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder<>(this.uninterpretedOption_, (this.bitField0_ & 16) == 16, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class EnumOptions extends GeneratedMessage.ExtendableMessage<EnumOptions> implements EnumOptionsOrBuilder {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final EnumOptions defaultInstance = new EnumOptions(true);
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<UninterpretedOption> uninterpretedOption_;

        /* synthetic */ EnumOptions(Builder builder, EnumOptions enumOptions) {
            this(builder);
        }

        private EnumOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private EnumOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static EnumOptions getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EnumOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int index) {
            return this.uninterpretedOption_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.uninterpretedOption_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                if (!getUninterpretedOption(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            GeneratedMessage.ExtendableMessage<MessageType>.ExtensionWriter extensionWriterNewExtensionWriter = newExtensionWriter();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, this.uninterpretedOption_.get(i));
            }
            extensionWriterNewExtensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static EnumOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.ExtendableBuilder<EnumOptions, Builder> implements EnumOptionsOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable;
            }

            private Builder() {
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EnumOptions.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EnumOptions getDefaultInstanceForType() {
                return EnumOptions.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnumOptions build() {
                EnumOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public EnumOptions buildParsed() throws InvalidProtocolBufferException {
                EnumOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnumOptions buildPartial() {
                EnumOptions result = new EnumOptions(this, null);
                int i = this.bitField0_;
                if (this.uninterpretedOptionBuilder_ != null) {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                } else {
                    if ((this.bitField0_ & 1) == 1) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -2;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                }
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof EnumOptions) {
                    return mergeFrom((EnumOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnumOptions other) {
                if (other != EnumOptions.getDefaultInstance()) {
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (!this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        } else {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -2;
                            this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null;
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                return extensionsAreInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 7994:
                            UninterpretedOption.Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return this.uninterpretedOptionBuilder_ == null ? Collections.unmodifiableList(this.uninterpretedOption_) : this.uninterpretedOptionBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.size() : this.uninterpretedOptionBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    GeneratedMessage.ExtendableBuilder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public UninterpretedOption.Builder getUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumOptionsOrBuilder
            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                return this.uninterpretedOptionBuilder_ != null ? this.uninterpretedOptionBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder() {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<UninterpretedOption.Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder<>(this.uninterpretedOption_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class EnumValueOptions extends GeneratedMessage.ExtendableMessage<EnumValueOptions> implements EnumValueOptionsOrBuilder {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final EnumValueOptions defaultInstance = new EnumValueOptions(true);
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<UninterpretedOption> uninterpretedOption_;

        /* synthetic */ EnumValueOptions(Builder builder, EnumValueOptions enumValueOptions) {
            this(builder);
        }

        private EnumValueOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private EnumValueOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static EnumValueOptions getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EnumValueOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f37xdf65a421;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int index) {
            return this.uninterpretedOption_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.uninterpretedOption_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                if (!getUninterpretedOption(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            GeneratedMessage.ExtendableMessage<MessageType>.ExtensionWriter extensionWriterNewExtensionWriter = newExtensionWriter();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, this.uninterpretedOption_.get(i));
            }
            extensionWriterNewExtensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static EnumValueOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static EnumValueOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static EnumValueOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(EnumValueOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.ExtendableBuilder<EnumValueOptions, Builder> implements EnumValueOptionsOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f37xdf65a421;
            }

            private Builder() {
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EnumValueOptions.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EnumValueOptions getDefaultInstanceForType() {
                return EnumValueOptions.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnumValueOptions build() {
                EnumValueOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public EnumValueOptions buildParsed() throws InvalidProtocolBufferException {
                EnumValueOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EnumValueOptions buildPartial() {
                EnumValueOptions result = new EnumValueOptions(this, null);
                int i = this.bitField0_;
                if (this.uninterpretedOptionBuilder_ != null) {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                } else {
                    if ((this.bitField0_ & 1) == 1) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -2;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                }
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof EnumValueOptions) {
                    return mergeFrom((EnumValueOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EnumValueOptions other) {
                if (other != EnumValueOptions.getDefaultInstance()) {
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (!this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        } else {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -2;
                            this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null;
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                return extensionsAreInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 7994:
                            UninterpretedOption.Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return this.uninterpretedOptionBuilder_ == null ? Collections.unmodifiableList(this.uninterpretedOption_) : this.uninterpretedOptionBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.size() : this.uninterpretedOptionBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    GeneratedMessage.ExtendableBuilder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public UninterpretedOption.Builder getUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.EnumValueOptionsOrBuilder
            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                return this.uninterpretedOptionBuilder_ != null ? this.uninterpretedOptionBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder() {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<UninterpretedOption.Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder<>(this.uninterpretedOption_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class ServiceOptions extends GeneratedMessage.ExtendableMessage<ServiceOptions> implements ServiceOptionsOrBuilder {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final ServiceOptions defaultInstance = new ServiceOptions(true);
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<UninterpretedOption> uninterpretedOption_;

        /* synthetic */ ServiceOptions(Builder builder, ServiceOptions serviceOptions) {
            this(builder);
        }

        private ServiceOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private ServiceOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static ServiceOptions getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ServiceOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f45x371e666;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int index) {
            return this.uninterpretedOption_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.uninterpretedOption_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                if (!getUninterpretedOption(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            GeneratedMessage.ExtendableMessage<MessageType>.ExtensionWriter extensionWriterNewExtensionWriter = newExtensionWriter();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, this.uninterpretedOption_.get(i));
            }
            extensionWriterNewExtensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static ServiceOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static ServiceOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static ServiceOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static ServiceOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(ServiceOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.ExtendableBuilder<ServiceOptions, Builder> implements ServiceOptionsOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f45x371e666;
            }

            private Builder() {
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ServiceOptions.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ServiceOptions getDefaultInstanceForType() {
                return ServiceOptions.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServiceOptions build() {
                ServiceOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public ServiceOptions buildParsed() throws InvalidProtocolBufferException {
                ServiceOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ServiceOptions buildPartial() {
                ServiceOptions result = new ServiceOptions(this, null);
                int i = this.bitField0_;
                if (this.uninterpretedOptionBuilder_ != null) {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                } else {
                    if ((this.bitField0_ & 1) == 1) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -2;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                }
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof ServiceOptions) {
                    return mergeFrom((ServiceOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ServiceOptions other) {
                if (other != ServiceOptions.getDefaultInstance()) {
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (!this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        } else {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -2;
                            this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null;
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                return extensionsAreInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 7994:
                            UninterpretedOption.Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return this.uninterpretedOptionBuilder_ == null ? Collections.unmodifiableList(this.uninterpretedOption_) : this.uninterpretedOptionBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.size() : this.uninterpretedOptionBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    GeneratedMessage.ExtendableBuilder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public UninterpretedOption.Builder getUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.ServiceOptionsOrBuilder
            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                return this.uninterpretedOptionBuilder_ != null ? this.uninterpretedOptionBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder() {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<UninterpretedOption.Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder<>(this.uninterpretedOption_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class MethodOptions extends GeneratedMessage.ExtendableMessage<MethodOptions> implements MethodOptionsOrBuilder {
        public static final int UNINTERPRETED_OPTION_FIELD_NUMBER = 999;
        private static final MethodOptions defaultInstance = new MethodOptions(true);
        private static final long serialVersionUID = 0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<UninterpretedOption> uninterpretedOption_;

        /* synthetic */ MethodOptions(Builder builder, MethodOptions methodOptions) {
            this(builder);
        }

        private MethodOptions(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private MethodOptions(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static MethodOptions getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MethodOptions getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public List<UninterpretedOption> getUninterpretedOptionList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
            return this.uninterpretedOption_;
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public int getUninterpretedOptionCount() {
            return this.uninterpretedOption_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public UninterpretedOption getUninterpretedOption(int index) {
            return this.uninterpretedOption_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
        public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
            return this.uninterpretedOption_.get(index);
        }

        private void initFields() {
            this.uninterpretedOption_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessage, com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                if (!getUninterpretedOption(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            GeneratedMessage.ExtendableMessage<MessageType>.ExtensionWriter extensionWriterNewExtensionWriter = newExtensionWriter();
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                output.writeMessage(999, this.uninterpretedOption_.get(i));
            }
            extensionWriterNewExtensionWriter.writeUntil(536870912, output);
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.uninterpretedOption_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(999, this.uninterpretedOption_.get(i));
            }
            int size3 = size2 + extensionsSerializedSize() + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodOptions parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodOptions parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodOptions parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodOptions parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodOptions parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodOptions parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static MethodOptions parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static MethodOptions parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static MethodOptions parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static MethodOptions parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(MethodOptions prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.ExtendableBuilder<MethodOptions, Builder> implements MethodOptionsOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> uninterpretedOptionBuilder_;
            private List<UninterpretedOption> uninterpretedOption_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable;
            }

            private Builder() {
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.uninterpretedOption_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getUninterpretedOptionFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MethodOptions.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MethodOptions getDefaultInstanceForType() {
                return MethodOptions.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MethodOptions build() {
                MethodOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public MethodOptions buildParsed() throws InvalidProtocolBufferException {
                MethodOptions result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MethodOptions buildPartial() {
                MethodOptions result = new MethodOptions(this, null);
                int i = this.bitField0_;
                if (this.uninterpretedOptionBuilder_ != null) {
                    result.uninterpretedOption_ = this.uninterpretedOptionBuilder_.build();
                } else {
                    if ((this.bitField0_ & 1) == 1) {
                        this.uninterpretedOption_ = Collections.unmodifiableList(this.uninterpretedOption_);
                        this.bitField0_ &= -2;
                    }
                    result.uninterpretedOption_ = this.uninterpretedOption_;
                }
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof MethodOptions) {
                    return mergeFrom((MethodOptions) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MethodOptions other) {
                if (other != MethodOptions.getDefaultInstance()) {
                    if (this.uninterpretedOptionBuilder_ == null) {
                        if (!other.uninterpretedOption_.isEmpty()) {
                            if (this.uninterpretedOption_.isEmpty()) {
                                this.uninterpretedOption_ = other.uninterpretedOption_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureUninterpretedOptionIsMutable();
                                this.uninterpretedOption_.addAll(other.uninterpretedOption_);
                            }
                            onChanged();
                        }
                    } else if (!other.uninterpretedOption_.isEmpty()) {
                        if (!this.uninterpretedOptionBuilder_.isEmpty()) {
                            this.uninterpretedOptionBuilder_.addAllMessages(other.uninterpretedOption_);
                        } else {
                            this.uninterpretedOptionBuilder_.dispose();
                            this.uninterpretedOptionBuilder_ = null;
                            this.uninterpretedOption_ = other.uninterpretedOption_;
                            this.bitField0_ &= -2;
                            this.uninterpretedOptionBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getUninterpretedOptionFieldBuilder() : null;
                        }
                    }
                    mergeExtensionFields(other);
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.ExtendableBuilder, com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getUninterpretedOptionCount(); i++) {
                    if (!getUninterpretedOption(i).isInitialized()) {
                        return false;
                    }
                }
                return extensionsAreInitialized();
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 7994:
                            UninterpretedOption.Builder subBuilder = UninterpretedOption.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addUninterpretedOption(subBuilder.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            private void ensureUninterpretedOptionIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.uninterpretedOption_ = new ArrayList(this.uninterpretedOption_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public List<UninterpretedOption> getUninterpretedOptionList() {
                return this.uninterpretedOptionBuilder_ == null ? Collections.unmodifiableList(this.uninterpretedOption_) : this.uninterpretedOptionBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public int getUninterpretedOptionCount() {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.size() : this.uninterpretedOptionBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public UninterpretedOption getUninterpretedOption(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOption) this.uninterpretedOptionBuilder_.getMessage(index);
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption value) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, value);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addUninterpretedOption(UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUninterpretedOption(int index, UninterpretedOption.Builder builderForValue) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUninterpretedOption(Iterable<? extends UninterpretedOption> values) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    GeneratedMessage.ExtendableBuilder.addAll(values, this.uninterpretedOption_);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUninterpretedOption() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOption_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.clear();
                }
                return this;
            }

            public Builder removeUninterpretedOption(int index) {
                if (this.uninterpretedOptionBuilder_ == null) {
                    ensureUninterpretedOptionIsMutable();
                    this.uninterpretedOption_.remove(index);
                    onChanged();
                } else {
                    this.uninterpretedOptionBuilder_.remove(index);
                }
                return this;
            }

            public UninterpretedOption.Builder getUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public UninterpretedOptionOrBuilder getUninterpretedOptionOrBuilder(int index) {
                return this.uninterpretedOptionBuilder_ == null ? this.uninterpretedOption_.get(index) : (UninterpretedOptionOrBuilder) this.uninterpretedOptionBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.MethodOptionsOrBuilder
            public List<? extends UninterpretedOptionOrBuilder> getUninterpretedOptionOrBuilderList() {
                return this.uninterpretedOptionBuilder_ != null ? this.uninterpretedOptionBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.uninterpretedOption_);
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder() {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(UninterpretedOption.getDefaultInstance());
            }

            public UninterpretedOption.Builder addUninterpretedOptionBuilder(int index) {
                return (UninterpretedOption.Builder) getUninterpretedOptionFieldBuilder().addBuilder(index, UninterpretedOption.getDefaultInstance());
            }

            public List<UninterpretedOption.Builder> getUninterpretedOptionBuilderList() {
                return getUninterpretedOptionFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<UninterpretedOption, UninterpretedOption.Builder, UninterpretedOptionOrBuilder> getUninterpretedOptionFieldBuilder() {
                if (this.uninterpretedOptionBuilder_ == null) {
                    this.uninterpretedOptionBuilder_ = new RepeatedFieldBuilder<>(this.uninterpretedOption_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.uninterpretedOption_ = null;
                }
                return this.uninterpretedOptionBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class UninterpretedOption extends GeneratedMessage implements UninterpretedOptionOrBuilder {
        public static final int AGGREGATE_VALUE_FIELD_NUMBER = 8;
        public static final int DOUBLE_VALUE_FIELD_NUMBER = 6;
        public static final int IDENTIFIER_VALUE_FIELD_NUMBER = 3;
        public static final int NAME_FIELD_NUMBER = 2;
        public static final int NEGATIVE_INT_VALUE_FIELD_NUMBER = 5;
        public static final int POSITIVE_INT_VALUE_FIELD_NUMBER = 4;
        public static final int STRING_VALUE_FIELD_NUMBER = 7;
        private static final UninterpretedOption defaultInstance = new UninterpretedOption(true);
        private static final long serialVersionUID = 0;
        private Object aggregateValue_;
        private int bitField0_;
        private double doubleValue_;
        private Object identifierValue_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<NamePart> name_;
        private long negativeIntValue_;
        private long positiveIntValue_;
        private ByteString stringValue_;

        public interface NamePartOrBuilder extends MessageOrBuilder {
            boolean getIsExtension();

            String getNamePart();

            boolean hasIsExtension();

            boolean hasNamePart();
        }

        /* synthetic */ UninterpretedOption(Builder builder, UninterpretedOption uninterpretedOption) {
            this(builder);
        }

        private UninterpretedOption(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private UninterpretedOption(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static UninterpretedOption getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UninterpretedOption getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f51x2101041;
        }

        public static final class NamePart extends GeneratedMessage implements NamePartOrBuilder {
            public static final int IS_EXTENSION_FIELD_NUMBER = 2;
            public static final int NAME_PART_FIELD_NUMBER = 1;
            private static final NamePart defaultInstance = new NamePart(true);
            private static final long serialVersionUID = 0;
            private int bitField0_;
            private boolean isExtension_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Object namePart_;

            /* synthetic */ NamePart(Builder builder, NamePart namePart) {
                this(builder);
            }

            private NamePart(Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            private NamePart(boolean noInit) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            public static NamePart getDefaultInstance() {
                return defaultInstance;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public NamePart getDefaultInstanceForType() {
                return defaultInstance;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.f49xb111d23c;
            }

            @Override // com.google.protobuf.GeneratedMessage
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f50x1698fcba;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public boolean hasNamePart() {
                return (this.bitField0_ & 1) == 1;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public String getNamePart() {
                Object ref = this.namePart_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                ByteString bs = (ByteString) ref;
                String s = bs.toStringUtf8();
                if (Internal.isValidUtf8(bs)) {
                    this.namePart_ = s;
                }
                return s;
            }

            private ByteString getNamePartBytes() {
                Object ref = this.namePart_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.namePart_ = b;
                return b;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public boolean hasIsExtension() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
            public boolean getIsExtension() {
                return this.isExtension_;
            }

            private void initFields() {
                this.namePart_ = "";
                this.isExtension_ = false;
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte isInitialized = this.memoizedIsInitialized;
                if (isInitialized != -1) {
                    return isInitialized == 1;
                }
                if (!hasNamePart()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                if (!hasIsExtension()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream output) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    output.writeBytes(1, getNamePartBytes());
                }
                if ((this.bitField0_ & 2) == 2) {
                    output.writeBool(2, this.isExtension_);
                }
                getUnknownFields().writeTo(output);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                int size2 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getNamePartBytes()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    size2 += CodedOutputStream.computeBoolSize(2, this.isExtension_);
                }
                int size3 = size2 + getUnknownFields().getSerializedSize();
                this.memoizedSerializedSize = size3;
                return size3;
            }

            @Override // com.google.protobuf.GeneratedMessage
            protected Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static NamePart parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static NamePart parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static NamePart parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static NamePart parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static NamePart parseFrom(InputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static NamePart parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
            }

            public static NamePart parseDelimitedFrom(InputStream input) throws IOException {
                Builder builder = newBuilder();
                if (builder.mergeDelimitedFrom(input)) {
                    return builder.buildParsed();
                }
                return null;
            }

            public static NamePart parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Builder builder = newBuilder();
                if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                    return builder.buildParsed();
                }
                return null;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static NamePart parseFrom(CodedInputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            public static NamePart parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(NamePart prototype) {
                return newBuilder().mergeFrom(prototype);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder toBuilder() {
                return newBuilder(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessage
            public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
                Builder builder = new Builder(parent, null);
                return builder;
            }

            public static final class Builder extends GeneratedMessage.Builder<Builder> implements NamePartOrBuilder {
                private int bitField0_;
                private boolean isExtension_;
                private Object namePart_;

                public static final Descriptors.Descriptor getDescriptor() {
                    return DescriptorProtos.f49xb111d23c;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder
                protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                    return DescriptorProtos.f50x1698fcba;
                }

                private Builder() {
                    this.namePart_ = "";
                    maybeForceBuilderInitialization();
                }

                /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                    this(builderParent);
                }

                private Builder(GeneratedMessage.BuilderParent parent) {
                    super(parent);
                    this.namePart_ = "";
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean z = GeneratedMessage.alwaysUseFieldBuilders;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static Builder create() {
                    return new Builder();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.namePart_ = "";
                    this.bitField0_ &= -2;
                    this.isExtension_ = false;
                    this.bitField0_ &= -3;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                /* renamed from: clone */
                public Builder m3102clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return NamePart.getDescriptor();
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public NamePart getDefaultInstanceForType() {
                    return NamePart.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public NamePart build() {
                    NamePart result = buildPartial();
                    if (!result.isInitialized()) {
                        throw newUninitializedMessageException((Message) result);
                    }
                    return result;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public NamePart buildParsed() throws InvalidProtocolBufferException {
                    NamePart result = buildPartial();
                    if (!result.isInitialized()) {
                        throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                    }
                    return result;
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public NamePart buildPartial() {
                    NamePart result = new NamePart(this, null);
                    int from_bitField0_ = this.bitField0_;
                    int to_bitField0_ = 0;
                    if ((from_bitField0_ & 1) == 1) {
                        to_bitField0_ = 0 | 1;
                    }
                    result.namePart_ = this.namePart_;
                    if ((from_bitField0_ & 2) == 2) {
                        to_bitField0_ |= 2;
                    }
                    result.isExtension_ = this.isExtension_;
                    result.bitField0_ = to_bitField0_;
                    onBuilt();
                    return result;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message other) {
                    if (other instanceof NamePart) {
                        return mergeFrom((NamePart) other);
                    }
                    super.mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(NamePart other) {
                    if (other != NamePart.getDefaultInstance()) {
                        if (other.hasNamePart()) {
                            setNamePart(other.getNamePart());
                        }
                        if (other.hasIsExtension()) {
                            setIsExtension(other.getIsExtension());
                        }
                        mergeUnknownFields(other.getUnknownFields());
                    }
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return hasNamePart() && hasIsExtension();
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                    while (true) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            case 10:
                                this.bitField0_ |= 1;
                                this.namePart_ = input.readBytes();
                                break;
                            case 16:
                                this.bitField0_ |= 2;
                                this.isExtension_ = input.readBool();
                                break;
                            default:
                                if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    setUnknownFields(unknownFields.build());
                                    onChanged();
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    return this;
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public boolean hasNamePart() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public String getNamePart() {
                    Object ref = this.namePart_;
                    if (ref instanceof String) {
                        return (String) ref;
                    }
                    String s = ((ByteString) ref).toStringUtf8();
                    this.namePart_ = s;
                    return s;
                }

                public Builder setNamePart(String value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    this.bitField0_ |= 1;
                    this.namePart_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearNamePart() {
                    this.bitField0_ &= -2;
                    this.namePart_ = NamePart.getDefaultInstance().getNamePart();
                    onChanged();
                    return this;
                }

                void setNamePart(ByteString value) {
                    this.bitField0_ |= 1;
                    this.namePart_ = value;
                    onChanged();
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public boolean hasIsExtension() {
                    return (this.bitField0_ & 2) == 2;
                }

                @Override // com.google.protobuf.DescriptorProtos.UninterpretedOption.NamePartOrBuilder
                public boolean getIsExtension() {
                    return this.isExtension_;
                }

                public Builder setIsExtension(boolean value) {
                    this.bitField0_ |= 2;
                    this.isExtension_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearIsExtension() {
                    this.bitField0_ &= -3;
                    this.isExtension_ = false;
                    onChanged();
                    return this;
                }
            }

            static {
                defaultInstance.initFields();
            }
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public List<NamePart> getNameList() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public List<? extends NamePartOrBuilder> getNameOrBuilderList() {
            return this.name_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public int getNameCount() {
            return this.name_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public NamePart getName(int index) {
            return this.name_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public NamePartOrBuilder getNameOrBuilder(int index) {
            return this.name_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasIdentifierValue() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public String getIdentifierValue() {
            Object ref = this.identifierValue_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.identifierValue_ = s;
            }
            return s;
        }

        private ByteString getIdentifierValueBytes() {
            Object ref = this.identifierValue_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.identifierValue_ = b;
            return b;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasPositiveIntValue() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public long getPositiveIntValue() {
            return this.positiveIntValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasNegativeIntValue() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public long getNegativeIntValue() {
            return this.negativeIntValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasDoubleValue() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public double getDoubleValue() {
            return this.doubleValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasStringValue() {
            return (this.bitField0_ & 16) == 16;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public ByteString getStringValue() {
            return this.stringValue_;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public boolean hasAggregateValue() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
        public String getAggregateValue() {
            Object ref = this.aggregateValue_;
            if (ref instanceof String) {
                return (String) ref;
            }
            ByteString bs = (ByteString) ref;
            String s = bs.toStringUtf8();
            if (Internal.isValidUtf8(bs)) {
                this.aggregateValue_ = s;
            }
            return s;
        }

        private ByteString getAggregateValueBytes() {
            Object ref = this.aggregateValue_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.aggregateValue_ = b;
            return b;
        }

        private void initFields() {
            this.name_ = Collections.emptyList();
            this.identifierValue_ = "";
            this.positiveIntValue_ = 0L;
            this.negativeIntValue_ = 0L;
            this.doubleValue_ = 0.0d;
            this.stringValue_ = ByteString.EMPTY;
            this.aggregateValue_ = "";
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            for (int i = 0; i < getNameCount(); i++) {
                if (!getName(i).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.name_.size(); i++) {
                output.writeMessage(2, this.name_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                output.writeBytes(3, getIdentifierValueBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                output.writeUInt64(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                output.writeInt64(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) == 8) {
                output.writeDouble(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                output.writeBytes(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                output.writeBytes(8, getAggregateValueBytes());
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.name_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.name_.get(i));
            }
            if ((this.bitField0_ & 1) == 1) {
                size2 += CodedOutputStream.computeBytesSize(3, getIdentifierValueBytes());
            }
            if ((this.bitField0_ & 2) == 2) {
                size2 += CodedOutputStream.computeUInt64Size(4, this.positiveIntValue_);
            }
            if ((this.bitField0_ & 4) == 4) {
                size2 += CodedOutputStream.computeInt64Size(5, this.negativeIntValue_);
            }
            if ((this.bitField0_ & 8) == 8) {
                size2 += CodedOutputStream.computeDoubleSize(6, this.doubleValue_);
            }
            if ((this.bitField0_ & 16) == 16) {
                size2 += CodedOutputStream.computeBytesSize(7, this.stringValue_);
            }
            if ((this.bitField0_ & 32) == 32) {
                size2 += CodedOutputStream.computeBytesSize(8, getAggregateValueBytes());
            }
            int size3 = size2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static UninterpretedOption parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static UninterpretedOption parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static UninterpretedOption parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static UninterpretedOption parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static UninterpretedOption parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static UninterpretedOption parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static UninterpretedOption parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static UninterpretedOption parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static UninterpretedOption parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(UninterpretedOption prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements UninterpretedOptionOrBuilder {
            private Object aggregateValue_;
            private int bitField0_;
            private double doubleValue_;
            private Object identifierValue_;
            private RepeatedFieldBuilder<NamePart, NamePart.Builder, NamePartOrBuilder> nameBuilder_;
            private List<NamePart> name_;
            private long negativeIntValue_;
            private long positiveIntValue_;
            private ByteString stringValue_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f51x2101041;
            }

            private Builder() {
                this.name_ = Collections.emptyList();
                this.identifierValue_ = "";
                this.stringValue_ = ByteString.EMPTY;
                this.aggregateValue_ = "";
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.name_ = Collections.emptyList();
                this.identifierValue_ = "";
                this.stringValue_ = ByteString.EMPTY;
                this.aggregateValue_ = "";
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getNameFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.nameBuilder_ == null) {
                    this.name_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.nameBuilder_.clear();
                }
                this.identifierValue_ = "";
                this.bitField0_ &= -3;
                this.positiveIntValue_ = 0L;
                this.bitField0_ &= -5;
                this.negativeIntValue_ = 0L;
                this.bitField0_ &= -9;
                this.doubleValue_ = 0.0d;
                this.bitField0_ &= -17;
                this.stringValue_ = ByteString.EMPTY;
                this.bitField0_ &= -33;
                this.aggregateValue_ = "";
                this.bitField0_ &= -65;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UninterpretedOption.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UninterpretedOption getDefaultInstanceForType() {
                return UninterpretedOption.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UninterpretedOption build() {
                UninterpretedOption result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public UninterpretedOption buildParsed() throws InvalidProtocolBufferException {
                UninterpretedOption result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UninterpretedOption buildPartial() {
                UninterpretedOption result = new UninterpretedOption(this, null);
                int from_bitField0_ = this.bitField0_;
                int to_bitField0_ = 0;
                if (this.nameBuilder_ != null) {
                    result.name_ = this.nameBuilder_.build();
                } else {
                    if ((this.bitField0_ & 1) == 1) {
                        this.name_ = Collections.unmodifiableList(this.name_);
                        this.bitField0_ &= -2;
                    }
                    result.name_ = this.name_;
                }
                if ((from_bitField0_ & 2) == 2) {
                    to_bitField0_ = 0 | 1;
                }
                result.identifierValue_ = this.identifierValue_;
                if ((from_bitField0_ & 4) == 4) {
                    to_bitField0_ |= 2;
                }
                result.positiveIntValue_ = this.positiveIntValue_;
                if ((from_bitField0_ & 8) == 8) {
                    to_bitField0_ |= 4;
                }
                result.negativeIntValue_ = this.negativeIntValue_;
                if ((from_bitField0_ & 16) == 16) {
                    to_bitField0_ |= 8;
                }
                result.doubleValue_ = this.doubleValue_;
                if ((from_bitField0_ & 32) == 32) {
                    to_bitField0_ |= 16;
                }
                result.stringValue_ = this.stringValue_;
                if ((from_bitField0_ & 64) == 64) {
                    to_bitField0_ |= 32;
                }
                result.aggregateValue_ = this.aggregateValue_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof UninterpretedOption) {
                    return mergeFrom((UninterpretedOption) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UninterpretedOption other) {
                if (other != UninterpretedOption.getDefaultInstance()) {
                    if (this.nameBuilder_ == null) {
                        if (!other.name_.isEmpty()) {
                            if (this.name_.isEmpty()) {
                                this.name_ = other.name_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureNameIsMutable();
                                this.name_.addAll(other.name_);
                            }
                            onChanged();
                        }
                    } else if (!other.name_.isEmpty()) {
                        if (!this.nameBuilder_.isEmpty()) {
                            this.nameBuilder_.addAllMessages(other.name_);
                        } else {
                            this.nameBuilder_.dispose();
                            this.nameBuilder_ = null;
                            this.name_ = other.name_;
                            this.bitField0_ &= -2;
                            this.nameBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getNameFieldBuilder() : null;
                        }
                    }
                    if (other.hasIdentifierValue()) {
                        setIdentifierValue(other.getIdentifierValue());
                    }
                    if (other.hasPositiveIntValue()) {
                        setPositiveIntValue(other.getPositiveIntValue());
                    }
                    if (other.hasNegativeIntValue()) {
                        setNegativeIntValue(other.getNegativeIntValue());
                    }
                    if (other.hasDoubleValue()) {
                        setDoubleValue(other.getDoubleValue());
                    }
                    if (other.hasStringValue()) {
                        setStringValue(other.getStringValue());
                    }
                    if (other.hasAggregateValue()) {
                        setAggregateValue(other.getAggregateValue());
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                for (int i = 0; i < getNameCount(); i++) {
                    if (!getName(i).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 18:
                            NamePart.Builder subBuilder = NamePart.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addName(subBuilder.buildPartial());
                            break;
                        case 26:
                            this.bitField0_ |= 2;
                            this.identifierValue_ = input.readBytes();
                            break;
                        case 32:
                            this.bitField0_ |= 4;
                            this.positiveIntValue_ = input.readUInt64();
                            break;
                        case 40:
                            this.bitField0_ |= 8;
                            this.negativeIntValue_ = input.readInt64();
                            break;
                        case 49:
                            this.bitField0_ |= 16;
                            this.doubleValue_ = input.readDouble();
                            break;
                        case InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_SECOND_DISPLAY /* 58 */:
                            this.bitField0_ |= 32;
                            this.stringValue_ = input.readBytes();
                            break;
                        case 66:
                            this.bitField0_ |= 64;
                            this.aggregateValue_ = input.readBytes();
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            private void ensureNameIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.name_ = new ArrayList(this.name_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public List<NamePart> getNameList() {
                return this.nameBuilder_ == null ? Collections.unmodifiableList(this.name_) : this.nameBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public int getNameCount() {
                return this.nameBuilder_ == null ? this.name_.size() : this.nameBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public NamePart getName(int index) {
                return this.nameBuilder_ == null ? this.name_.get(index) : (NamePart) this.nameBuilder_.getMessage(index);
            }

            public Builder setName(int index, NamePart value) {
                if (this.nameBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNameIsMutable();
                    this.name_.set(index, value);
                    onChanged();
                } else {
                    this.nameBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setName(int index, NamePart.Builder builderForValue) {
                if (this.nameBuilder_ == null) {
                    ensureNameIsMutable();
                    this.name_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nameBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addName(NamePart value) {
                if (this.nameBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNameIsMutable();
                    this.name_.add(value);
                    onChanged();
                } else {
                    this.nameBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addName(int index, NamePart value) {
                if (this.nameBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureNameIsMutable();
                    this.name_.add(index, value);
                    onChanged();
                } else {
                    this.nameBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addName(NamePart.Builder builderForValue) {
                if (this.nameBuilder_ == null) {
                    ensureNameIsMutable();
                    this.name_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.nameBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addName(int index, NamePart.Builder builderForValue) {
                if (this.nameBuilder_ == null) {
                    ensureNameIsMutable();
                    this.name_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.nameBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllName(Iterable<? extends NamePart> values) {
                if (this.nameBuilder_ == null) {
                    ensureNameIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.name_);
                    onChanged();
                } else {
                    this.nameBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearName() {
                if (this.nameBuilder_ == null) {
                    this.name_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.nameBuilder_.clear();
                }
                return this;
            }

            public Builder removeName(int index) {
                if (this.nameBuilder_ == null) {
                    ensureNameIsMutable();
                    this.name_.remove(index);
                    onChanged();
                } else {
                    this.nameBuilder_.remove(index);
                }
                return this;
            }

            public NamePart.Builder getNameBuilder(int index) {
                return (NamePart.Builder) getNameFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public NamePartOrBuilder getNameOrBuilder(int index) {
                return this.nameBuilder_ == null ? this.name_.get(index) : (NamePartOrBuilder) this.nameBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public List<? extends NamePartOrBuilder> getNameOrBuilderList() {
                return this.nameBuilder_ != null ? this.nameBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.name_);
            }

            public NamePart.Builder addNameBuilder() {
                return (NamePart.Builder) getNameFieldBuilder().addBuilder(NamePart.getDefaultInstance());
            }

            public NamePart.Builder addNameBuilder(int index) {
                return (NamePart.Builder) getNameFieldBuilder().addBuilder(index, NamePart.getDefaultInstance());
            }

            public List<NamePart.Builder> getNameBuilderList() {
                return getNameFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<NamePart, NamePart.Builder, NamePartOrBuilder> getNameFieldBuilder() {
                if (this.nameBuilder_ == null) {
                    this.nameBuilder_ = new RepeatedFieldBuilder<>(this.name_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.name_ = null;
                }
                return this.nameBuilder_;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasIdentifierValue() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public String getIdentifierValue() {
                Object ref = this.identifierValue_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.identifierValue_ = s;
                return s;
            }

            public Builder setIdentifierValue(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 2;
                this.identifierValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearIdentifierValue() {
                this.bitField0_ &= -3;
                this.identifierValue_ = UninterpretedOption.getDefaultInstance().getIdentifierValue();
                onChanged();
                return this;
            }

            void setIdentifierValue(ByteString value) {
                this.bitField0_ |= 2;
                this.identifierValue_ = value;
                onChanged();
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasPositiveIntValue() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public long getPositiveIntValue() {
                return this.positiveIntValue_;
            }

            public Builder setPositiveIntValue(long value) {
                this.bitField0_ |= 4;
                this.positiveIntValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearPositiveIntValue() {
                this.bitField0_ &= -5;
                this.positiveIntValue_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasNegativeIntValue() {
                return (this.bitField0_ & 8) == 8;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public long getNegativeIntValue() {
                return this.negativeIntValue_;
            }

            public Builder setNegativeIntValue(long value) {
                this.bitField0_ |= 8;
                this.negativeIntValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearNegativeIntValue() {
                this.bitField0_ &= -9;
                this.negativeIntValue_ = 0L;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasDoubleValue() {
                return (this.bitField0_ & 16) == 16;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public double getDoubleValue() {
                return this.doubleValue_;
            }

            public Builder setDoubleValue(double value) {
                this.bitField0_ |= 16;
                this.doubleValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearDoubleValue() {
                this.bitField0_ &= -17;
                this.doubleValue_ = 0.0d;
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasStringValue() {
                return (this.bitField0_ & 32) == 32;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public ByteString getStringValue() {
                return this.stringValue_;
            }

            public Builder setStringValue(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 32;
                this.stringValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearStringValue() {
                this.bitField0_ &= -33;
                this.stringValue_ = UninterpretedOption.getDefaultInstance().getStringValue();
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public boolean hasAggregateValue() {
                return (this.bitField0_ & 64) == 64;
            }

            @Override // com.google.protobuf.DescriptorProtos.UninterpretedOptionOrBuilder
            public String getAggregateValue() {
                Object ref = this.aggregateValue_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.aggregateValue_ = s;
                return s;
            }

            public Builder setAggregateValue(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.bitField0_ |= 64;
                this.aggregateValue_ = value;
                onChanged();
                return this;
            }

            public Builder clearAggregateValue() {
                this.bitField0_ &= -65;
                this.aggregateValue_ = UninterpretedOption.getDefaultInstance().getAggregateValue();
                onChanged();
                return this;
            }

            void setAggregateValue(ByteString value) {
                this.bitField0_ |= 64;
                this.aggregateValue_ = value;
                onChanged();
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static final class SourceCodeInfo extends GeneratedMessage implements SourceCodeInfoOrBuilder {
        public static final int LOCATION_FIELD_NUMBER = 1;
        private static final SourceCodeInfo defaultInstance = new SourceCodeInfo(true);
        private static final long serialVersionUID = 0;
        private List<Location> location_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;

        public interface LocationOrBuilder extends MessageOrBuilder {
            int getPath(int i);

            int getPathCount();

            List<Integer> getPathList();

            int getSpan(int i);

            int getSpanCount();

            List<Integer> getSpanList();
        }

        /* synthetic */ SourceCodeInfo(Builder builder, SourceCodeInfo sourceCodeInfo) {
            this(builder);
        }

        private SourceCodeInfo(Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private SourceCodeInfo(boolean noInit) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static SourceCodeInfo getDefaultInstance() {
            return defaultInstance;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SourceCodeInfo getDefaultInstanceForType() {
            return defaultInstance;
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return DescriptorProtos.f48x532209f9;
        }

        public static final class Location extends GeneratedMessage implements LocationOrBuilder {
            public static final int PATH_FIELD_NUMBER = 1;
            public static final int SPAN_FIELD_NUMBER = 2;
            private static final Location defaultInstance = new Location(true);
            private static final long serialVersionUID = 0;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int pathMemoizedSerializedSize;
            private List<Integer> path_;
            private int spanMemoizedSerializedSize;
            private List<Integer> span_;

            /* synthetic */ Location(Builder builder, Location location) {
                this(builder);
            }

            private Location(Builder builder) {
                super(builder);
                this.pathMemoizedSerializedSize = -1;
                this.spanMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            private Location(boolean noInit) {
                this.pathMemoizedSerializedSize = -1;
                this.spanMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            public static Location getDefaultInstance() {
                return defaultInstance;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Location getDefaultInstanceForType() {
                return defaultInstance;
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.f46xb210d08d;
            }

            @Override // com.google.protobuf.GeneratedMessage
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f47x9611a0b;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public List<Integer> getPathList() {
                return this.path_;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getPathCount() {
                return this.path_.size();
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getPath(int index) {
                return this.path_.get(index).intValue();
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public List<Integer> getSpanList() {
                return this.span_;
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getSpanCount() {
                return this.span_.size();
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
            public int getSpan(int index) {
                return this.span_.get(index).intValue();
            }

            private void initFields() {
                this.path_ = Collections.emptyList();
                this.span_ = Collections.emptyList();
            }

            @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte isInitialized = this.memoizedIsInitialized;
                if (isInitialized != -1) {
                    return isInitialized == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream output) throws IOException {
                getSerializedSize();
                if (getPathList().size() > 0) {
                    output.writeRawVarint32(10);
                    output.writeRawVarint32(this.pathMemoizedSerializedSize);
                }
                for (int i = 0; i < this.path_.size(); i++) {
                    output.writeInt32NoTag(this.path_.get(i).intValue());
                }
                if (getSpanList().size() > 0) {
                    output.writeRawVarint32(18);
                    output.writeRawVarint32(this.spanMemoizedSerializedSize);
                }
                for (int i2 = 0; i2 < this.span_.size(); i2++) {
                    output.writeInt32NoTag(this.span_.get(i2).intValue());
                }
                getUnknownFields().writeTo(output);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int size = this.memoizedSerializedSize;
                if (size != -1) {
                    return size;
                }
                int dataSize = 0;
                for (int i = 0; i < this.path_.size(); i++) {
                    dataSize += CodedOutputStream.computeInt32SizeNoTag(this.path_.get(i).intValue());
                }
                int size2 = 0 + dataSize;
                if (!getPathList().isEmpty()) {
                    size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
                }
                this.pathMemoizedSerializedSize = dataSize;
                int dataSize2 = 0;
                for (int i2 = 0; i2 < this.span_.size(); i2++) {
                    dataSize2 += CodedOutputStream.computeInt32SizeNoTag(this.span_.get(i2).intValue());
                }
                int size3 = size2 + dataSize2;
                if (!getSpanList().isEmpty()) {
                    size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
                }
                this.spanMemoizedSerializedSize = dataSize2;
                int size4 = size3 + getUnknownFields().getSerializedSize();
                this.memoizedSerializedSize = size4;
                return size4;
            }

            @Override // com.google.protobuf.GeneratedMessage
            protected Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static Location parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static Location parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static Location parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static Location parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static Location parseFrom(InputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static Location parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
            }

            public static Location parseDelimitedFrom(InputStream input) throws IOException {
                Builder builder = newBuilder();
                if (builder.mergeDelimitedFrom(input)) {
                    return builder.buildParsed();
                }
                return null;
            }

            public static Location parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                Builder builder = newBuilder();
                if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                    return builder.buildParsed();
                }
                return null;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static Location parseFrom(CodedInputStream input) throws IOException {
                return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
            }

            public static Location parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
            }

            public static Builder newBuilder() {
                return Builder.create();
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder(Location prototype) {
                return newBuilder().mergeFrom(prototype);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder toBuilder() {
                return newBuilder(this);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessage
            public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
                Builder builder = new Builder(parent, null);
                return builder;
            }

            public static final class Builder extends GeneratedMessage.Builder<Builder> implements LocationOrBuilder {
                private int bitField0_;
                private List<Integer> path_;
                private List<Integer> span_;

                public static final Descriptors.Descriptor getDescriptor() {
                    return DescriptorProtos.f46xb210d08d;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder
                protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                    return DescriptorProtos.f47x9611a0b;
                }

                private Builder() {
                    this.path_ = Collections.emptyList();
                    this.span_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                    this(builderParent);
                }

                private Builder(GeneratedMessage.BuilderParent parent) {
                    super(parent);
                    this.path_ = Collections.emptyList();
                    this.span_ = Collections.emptyList();
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    boolean z = GeneratedMessage.alwaysUseFieldBuilders;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static Builder create() {
                    return new Builder();
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    super.clear();
                    this.path_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    this.span_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                /* renamed from: clone */
                public Builder m3102clone() {
                    return create().mergeFrom(buildPartial());
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return Location.getDescriptor();
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public Location getDefaultInstanceForType() {
                    return Location.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Location build() {
                    Location result = buildPartial();
                    if (!result.isInitialized()) {
                        throw newUninitializedMessageException((Message) result);
                    }
                    return result;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public Location buildParsed() throws InvalidProtocolBufferException {
                    Location result = buildPartial();
                    if (!result.isInitialized()) {
                        throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                    }
                    return result;
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Location buildPartial() {
                    Location result = new Location(this, null);
                    int i = this.bitField0_;
                    if ((this.bitField0_ & 1) == 1) {
                        this.path_ = Collections.unmodifiableList(this.path_);
                        this.bitField0_ &= -2;
                    }
                    result.path_ = this.path_;
                    if ((this.bitField0_ & 2) == 2) {
                        this.span_ = Collections.unmodifiableList(this.span_);
                        this.bitField0_ &= -3;
                    }
                    result.span_ = this.span_;
                    onBuilt();
                    return result;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(Message other) {
                    if (other instanceof Location) {
                        return mergeFrom((Location) other);
                    }
                    super.mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(Location other) {
                    if (other != Location.getDefaultInstance()) {
                        if (!other.path_.isEmpty()) {
                            if (this.path_.isEmpty()) {
                                this.path_ = other.path_;
                                this.bitField0_ &= -2;
                            } else {
                                ensurePathIsMutable();
                                this.path_.addAll(other.path_);
                            }
                            onChanged();
                        }
                        if (!other.span_.isEmpty()) {
                            if (this.span_.isEmpty()) {
                                this.span_ = other.span_;
                                this.bitField0_ &= -3;
                            } else {
                                ensureSpanIsMutable();
                                this.span_.addAll(other.span_);
                            }
                            onChanged();
                        }
                        mergeUnknownFields(other.getUnknownFields());
                    }
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }

                @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                    UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                    while (true) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            case 8:
                                ensurePathIsMutable();
                                this.path_.add(Integer.valueOf(input.readInt32()));
                                break;
                            case 10:
                                int length = input.readRawVarint32();
                                int limit = input.pushLimit(length);
                                while (input.getBytesUntilLimit() > 0) {
                                    addPath(input.readInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 16:
                                ensureSpanIsMutable();
                                this.span_.add(Integer.valueOf(input.readInt32()));
                                break;
                            case 18:
                                int length2 = input.readRawVarint32();
                                int limit2 = input.pushLimit(length2);
                                while (input.getBytesUntilLimit() > 0) {
                                    addSpan(input.readInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            default:
                                if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    setUnknownFields(unknownFields.build());
                                    onChanged();
                                    break;
                                } else {
                                    break;
                                }
                        }
                    }
                    return this;
                }

                private void ensurePathIsMutable() {
                    if ((this.bitField0_ & 1) != 1) {
                        this.path_ = new ArrayList(this.path_);
                        this.bitField0_ |= 1;
                    }
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public List<Integer> getPathList() {
                    return Collections.unmodifiableList(this.path_);
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getPathCount() {
                    return this.path_.size();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getPath(int index) {
                    return this.path_.get(index).intValue();
                }

                public Builder setPath(int index, int value) {
                    ensurePathIsMutable();
                    this.path_.set(index, Integer.valueOf(value));
                    onChanged();
                    return this;
                }

                public Builder addPath(int value) {
                    ensurePathIsMutable();
                    this.path_.add(Integer.valueOf(value));
                    onChanged();
                    return this;
                }

                public Builder addAllPath(Iterable<? extends Integer> values) {
                    ensurePathIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.path_);
                    onChanged();
                    return this;
                }

                public Builder clearPath() {
                    this.path_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                    return this;
                }

                private void ensureSpanIsMutable() {
                    if ((this.bitField0_ & 2) != 2) {
                        this.span_ = new ArrayList(this.span_);
                        this.bitField0_ |= 2;
                    }
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public List<Integer> getSpanList() {
                    return Collections.unmodifiableList(this.span_);
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getSpanCount() {
                    return this.span_.size();
                }

                @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfo.LocationOrBuilder
                public int getSpan(int index) {
                    return this.span_.get(index).intValue();
                }

                public Builder setSpan(int index, int value) {
                    ensureSpanIsMutable();
                    this.span_.set(index, Integer.valueOf(value));
                    onChanged();
                    return this;
                }

                public Builder addSpan(int value) {
                    ensureSpanIsMutable();
                    this.span_.add(Integer.valueOf(value));
                    onChanged();
                    return this;
                }

                public Builder addAllSpan(Iterable<? extends Integer> values) {
                    ensureSpanIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.span_);
                    onChanged();
                    return this;
                }

                public Builder clearSpan() {
                    this.span_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                    return this;
                }
            }

            static {
                defaultInstance.initFields();
            }
        }

        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public List<Location> getLocationList() {
            return this.location_;
        }

        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public List<? extends LocationOrBuilder> getLocationOrBuilderList() {
            return this.location_;
        }

        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public int getLocationCount() {
            return this.location_.size();
        }

        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public Location getLocation(int index) {
            return this.location_.get(index);
        }

        @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
        public LocationOrBuilder getLocationOrBuilder(int index) {
            return this.location_.get(index);
        }

        private void initFields() {
            this.location_ = Collections.emptyList();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized != -1) {
                return isInitialized == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.location_.size(); i++) {
                output.writeMessage(1, this.location_.get(i));
            }
            getUnknownFields().writeTo(output);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.location_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.location_.get(i));
            }
            int size3 = size2 + getUnknownFields().getSerializedSize();
            this.memoizedSerializedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static SourceCodeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static SourceCodeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static SourceCodeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static SourceCodeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return ((Builder) newBuilder().mergeFrom(data, extensionRegistry)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static SourceCodeInfo parseFrom(InputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static SourceCodeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input, extensionRegistry)).buildParsed();
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream input) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input)) {
                return builder.buildParsed();
            }
            return null;
        }

        public static SourceCodeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            Builder builder = newBuilder();
            if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
                return builder.buildParsed();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static SourceCodeInfo parseFrom(CodedInputStream input) throws IOException {
            return ((Builder) newBuilder().mergeFrom(input)).buildParsed();
        }

        public static SourceCodeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return newBuilder().mergeFrom(input, extensionRegistry).buildParsed();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder(SourceCodeInfo prototype) {
            return newBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return newBuilder(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessage
        public Builder newBuilderForType(GeneratedMessage.BuilderParent parent) {
            Builder builder = new Builder(parent, null);
            return builder;
        }

        public static final class Builder extends GeneratedMessage.Builder<Builder> implements SourceCodeInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilder<Location, Location.Builder, LocationOrBuilder> locationBuilder_;
            private List<Location> location_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder
            protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
                return DescriptorProtos.f48x532209f9;
            }

            private Builder() {
                this.location_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            /* synthetic */ Builder(GeneratedMessage.BuilderParent builderParent, Builder builder) {
                this(builderParent);
            }

            private Builder(GeneratedMessage.BuilderParent parent) {
                super(parent);
                this.location_ = Collections.emptyList();
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GeneratedMessage.alwaysUseFieldBuilders) {
                    getLocationFieldBuilder();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                return new Builder();
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                super.clear();
                if (this.locationBuilder_ == null) {
                    this.location_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.locationBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            /* renamed from: clone */
            public Builder m3102clone() {
                return create().mergeFrom(buildPartial());
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SourceCodeInfo.getDescriptor();
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SourceCodeInfo getDefaultInstanceForType() {
                return SourceCodeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SourceCodeInfo build() {
                SourceCodeInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result);
                }
                return result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public SourceCodeInfo buildParsed() throws InvalidProtocolBufferException {
                SourceCodeInfo result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException((Message) result).asInvalidProtocolBufferException();
                }
                return result;
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SourceCodeInfo buildPartial() {
                SourceCodeInfo result = new SourceCodeInfo(this, null);
                int i = this.bitField0_;
                if (this.locationBuilder_ != null) {
                    result.location_ = this.locationBuilder_.build();
                } else {
                    if ((this.bitField0_ & 1) == 1) {
                        this.location_ = Collections.unmodifiableList(this.location_);
                        this.bitField0_ &= -2;
                    }
                    result.location_ = this.location_;
                }
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof SourceCodeInfo) {
                    return mergeFrom((SourceCodeInfo) other);
                }
                super.mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SourceCodeInfo other) {
                if (other != SourceCodeInfo.getDefaultInstance()) {
                    if (this.locationBuilder_ == null) {
                        if (!other.location_.isEmpty()) {
                            if (this.location_.isEmpty()) {
                                this.location_ = other.location_;
                                this.bitField0_ &= -2;
                            } else {
                                ensureLocationIsMutable();
                                this.location_.addAll(other.location_);
                            }
                            onChanged();
                        }
                    } else if (!other.location_.isEmpty()) {
                        if (!this.locationBuilder_.isEmpty()) {
                            this.locationBuilder_.addAllMessages(other.location_);
                        } else {
                            this.locationBuilder_.dispose();
                            this.locationBuilder_ = null;
                            this.location_ = other.location_;
                            this.bitField0_ &= -2;
                            this.locationBuilder_ = GeneratedMessage.alwaysUseFieldBuilders ? getLocationFieldBuilder() : null;
                        }
                    }
                    mergeUnknownFields(other.getUnknownFields());
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                UnknownFieldSet.Builder unknownFields = UnknownFieldSet.newBuilder(getUnknownFields());
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            setUnknownFields(unknownFields.build());
                            onChanged();
                            break;
                        case 10:
                            Location.Builder subBuilder = Location.newBuilder();
                            input.readMessage(subBuilder, extensionRegistry);
                            addLocation(subBuilder.buildPartial());
                            break;
                        default:
                            if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                setUnknownFields(unknownFields.build());
                                onChanged();
                                break;
                            } else {
                                break;
                            }
                    }
                }
                return this;
            }

            private void ensureLocationIsMutable() {
                if ((this.bitField0_ & 1) != 1) {
                    this.location_ = new ArrayList(this.location_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public List<Location> getLocationList() {
                return this.locationBuilder_ == null ? Collections.unmodifiableList(this.location_) : this.locationBuilder_.getMessageList();
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public int getLocationCount() {
                return this.locationBuilder_ == null ? this.location_.size() : this.locationBuilder_.getCount();
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public Location getLocation(int index) {
                return this.locationBuilder_ == null ? this.location_.get(index) : (Location) this.locationBuilder_.getMessage(index);
            }

            public Builder setLocation(int index, Location value) {
                if (this.locationBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLocationIsMutable();
                    this.location_.set(index, value);
                    onChanged();
                } else {
                    this.locationBuilder_.setMessage(index, value);
                }
                return this;
            }

            public Builder setLocation(int index, Location.Builder builderForValue) {
                if (this.locationBuilder_ == null) {
                    ensureLocationIsMutable();
                    this.location_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.locationBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLocation(Location value) {
                if (this.locationBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLocationIsMutable();
                    this.location_.add(value);
                    onChanged();
                } else {
                    this.locationBuilder_.addMessage(value);
                }
                return this;
            }

            public Builder addLocation(int index, Location value) {
                if (this.locationBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureLocationIsMutable();
                    this.location_.add(index, value);
                    onChanged();
                } else {
                    this.locationBuilder_.addMessage(index, value);
                }
                return this;
            }

            public Builder addLocation(Location.Builder builderForValue) {
                if (this.locationBuilder_ == null) {
                    ensureLocationIsMutable();
                    this.location_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.locationBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLocation(int index, Location.Builder builderForValue) {
                if (this.locationBuilder_ == null) {
                    ensureLocationIsMutable();
                    this.location_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.locationBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLocation(Iterable<? extends Location> values) {
                if (this.locationBuilder_ == null) {
                    ensureLocationIsMutable();
                    GeneratedMessage.Builder.addAll(values, this.location_);
                    onChanged();
                } else {
                    this.locationBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLocation() {
                if (this.locationBuilder_ == null) {
                    this.location_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.locationBuilder_.clear();
                }
                return this;
            }

            public Builder removeLocation(int index) {
                if (this.locationBuilder_ == null) {
                    ensureLocationIsMutable();
                    this.location_.remove(index);
                    onChanged();
                } else {
                    this.locationBuilder_.remove(index);
                }
                return this;
            }

            public Location.Builder getLocationBuilder(int index) {
                return (Location.Builder) getLocationFieldBuilder().getBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public LocationOrBuilder getLocationOrBuilder(int index) {
                return this.locationBuilder_ == null ? this.location_.get(index) : (LocationOrBuilder) this.locationBuilder_.getMessageOrBuilder(index);
            }

            @Override // com.google.protobuf.DescriptorProtos.SourceCodeInfoOrBuilder
            public List<? extends LocationOrBuilder> getLocationOrBuilderList() {
                return this.locationBuilder_ != null ? this.locationBuilder_.getMessageOrBuilderList() : Collections.unmodifiableList(this.location_);
            }

            public Location.Builder addLocationBuilder() {
                return (Location.Builder) getLocationFieldBuilder().addBuilder(Location.getDefaultInstance());
            }

            public Location.Builder addLocationBuilder(int index) {
                return (Location.Builder) getLocationFieldBuilder().addBuilder(index, Location.getDefaultInstance());
            }

            public List<Location.Builder> getLocationBuilderList() {
                return getLocationFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilder<Location, Location.Builder, LocationOrBuilder> getLocationFieldBuilder() {
                if (this.locationBuilder_ == null) {
                    this.locationBuilder_ = new RepeatedFieldBuilder<>(this.location_, (this.bitField0_ & 1) == 1, getParentForChildren(), isClean());
                    this.location_ = null;
                }
                return this.locationBuilder_;
            }
        }

        static {
            defaultInstance.initFields();
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        String[] descriptorData = {"\n google/protobuf/descriptor.proto\u0012\u000fgoogle.protobuf\"G\n\u0011FileDescriptorSet\u00122\n\u0004file\u0018\u0001 \u0003(\u000b2$.google.protobuf.FileDescriptorProto\"\u0097\u0003\n\u0013FileDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000f\n\u0007package\u0018\u0002 \u0001(\t\u0012\u0012\n\ndependency\u0018\u0003 \u0003(\t\u00126\n\fmessage_type\u0018\u0004 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0005 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u00128\n\u0007service\u0018\u0006 \u0003(\u000b2'.google.protobuf.ServiceDescriptorProto\u00128\n\textension\u0018\u0007 \u0003(\u000b2%.google.p", "rotobuf.FieldDescriptorProto\u0012-\n\u0007options\u0018\b \u0001(\u000b2\u001c.google.protobuf.FileOptions\u00129\n\u0010source_code_info\u0018\t \u0001(\u000b2\u001f.google.protobuf.SourceCodeInfo\"©\u0003\n\u000fDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00124\n\u0005field\u0018\u0002 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00128\n\textension\u0018\u0006 \u0003(\u000b2%.google.protobuf.FieldDescriptorProto\u00125\n\u000bnested_type\u0018\u0003 \u0003(\u000b2 .google.protobuf.DescriptorProto\u00127\n\tenum_type\u0018\u0004 \u0003(\u000b2$.google.protobuf.EnumDescriptorProto\u0012H\n\u000fexte", "nsion_range\u0018\u0005 \u0003(\u000b2/.google.protobuf.DescriptorProto.ExtensionRange\u00120\n\u0007options\u0018\u0007 \u0001(\u000b2\u001f.google.protobuf.MessageOptions\u001a,\n\u000eExtensionRange\u0012\r\n\u0005start\u0018\u0001 \u0001(\u0005\u0012\u000b\n\u0003end\u0018\u0002 \u0001(\u0005\"\u0094\u0005\n\u0014FieldDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0003 \u0001(\u0005\u0012:\n\u0005label\u0018\u0004 \u0001(\u000e2+.google.protobuf.FieldDescriptorProto.Label\u00128\n\u0004type\u0018\u0005 \u0001(\u000e2*.google.protobuf.FieldDescriptorProto.Type\u0012\u0011\n\ttype_name\u0018\u0006 \u0001(\t\u0012\u0010\n\bextendee\u0018\u0002 \u0001(\t\u0012\u0015\n\rdefault_value\u0018\u0007 \u0001(\t\u0012.\n\u0007o", "ptions\u0018\b \u0001(\u000b2\u001d.google.protobuf.FieldOptions\"¶\u0002\n\u0004Type\u0012\u000f\n\u000bTYPE_DOUBLE\u0010\u0001\u0012\u000e\n\nTYPE_FLOAT\u0010\u0002\u0012\u000e\n\nTYPE_INT64\u0010\u0003\u0012\u000f\n\u000bTYPE_UINT64\u0010\u0004\u0012\u000e\n\nTYPE_INT32\u0010\u0005\u0012\u0010\n\fTYPE_FIXED64\u0010\u0006\u0012\u0010\n\fTYPE_FIXED32\u0010\u0007\u0012\r\n\tTYPE_BOOL\u0010\b\u0012\u000f\n\u000bTYPE_STRING\u0010\t\u0012\u000e\n\nTYPE_GROUP\u0010\n\u0012\u0010\n\fTYPE_MESSAGE\u0010\u000b\u0012\u000e\n\nTYPE_BYTES\u0010\f\u0012\u000f\n\u000bTYPE_UINT32\u0010\r\u0012\r\n\tTYPE_ENUM\u0010\u000e\u0012\u0011\n\rTYPE_SFIXED32\u0010\u000f\u0012\u0011\n\rTYPE_SFIXED64\u0010\u0010\u0012\u000f\n\u000bTYPE_SINT32\u0010\u0011\u0012\u000f\n\u000bTYPE_SINT64\u0010\u0012\"C\n\u0005Label\u0012\u0012\n\u000eLABEL_OPTIONAL\u0010\u0001\u0012\u0012\n\u000eLABEL_REQUI", "RED\u0010\u0002\u0012\u0012\n\u000eLABEL_REPEATED\u0010\u0003\"\u008c\u0001\n\u0013EnumDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00128\n\u0005value\u0018\u0002 \u0003(\u000b2).google.protobuf.EnumValueDescriptorProto\u0012-\n\u0007options\u0018\u0003 \u0001(\u000b2\u001c.google.protobuf.EnumOptions\"l\n\u0018EnumValueDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u000e\n\u0006number\u0018\u0002 \u0001(\u0005\u00122\n\u0007options\u0018\u0003 \u0001(\u000b2!.google.protobuf.EnumValueOptions\"\u0090\u0001\n\u0016ServiceDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u00126\n\u0006method\u0018\u0002 \u0003(\u000b2&.google.protobuf.MethodDescriptorProto\u00120\n\u0007options\u0018\u0003 \u0001(\u000b2\u001f.googl", "e.protobuf.ServiceOptions\"\u007f\n\u0015MethodDescriptorProto\u0012\f\n\u0004name\u0018\u0001 \u0001(\t\u0012\u0012\n\ninput_type\u0018\u0002 \u0001(\t\u0012\u0013\n\u000boutput_type\u0018\u0003 \u0001(\t\u0012/\n\u0007options\u0018\u0004 \u0001(\u000b2\u001e.google.protobuf.MethodOptions\"Õ\u0003\n\u000bFileOptions\u0012\u0014\n\fjava_package\u0018\u0001 \u0001(\t\u0012\u001c\n\u0014java_outer_classname\u0018\b \u0001(\t\u0012\"\n\u0013java_multiple_files\u0018\n \u0001(\b:\u0005false\u0012,\n\u001djava_generate_equals_and_hash\u0018\u0014 \u0001(\b:\u0005false\u0012F\n\foptimize_for\u0018\t \u0001(\u000e2).google.protobuf.FileOptions.OptimizeMode:\u0005SPEED\u0012\"\n\u0013cc_generic_services\u0018", "\u0010 \u0001(\b:\u0005false\u0012$\n\u0015java_generic_services\u0018\u0011 \u0001(\b:\u0005false\u0012\"\n\u0013py_generic_services\u0018\u0012 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\":\n\fOptimizeMode\u0012\t\n\u0005SPEED\u0010\u0001\u0012\r\n\tCODE_SIZE\u0010\u0002\u0012\u0010\n\fLITE_RUNTIME\u0010\u0003*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"¸\u0001\n\u000eMessageOptions\u0012&\n\u0017message_set_wire_format\u0018\u0001 \u0001(\b:\u0005false\u0012.\n\u001fno_standard_descriptor_accessor\u0018\u0002 \u0001(\b:\u0005false\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOpti", "on*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u0094\u0002\n\fFieldOptions\u0012:\n\u0005ctype\u0018\u0001 \u0001(\u000e2#.google.protobuf.FieldOptions.CType:\u0006STRING\u0012\u000e\n\u0006packed\u0018\u0002 \u0001(\b\u0012\u0019\n\ndeprecated\u0018\u0003 \u0001(\b:\u0005false\u0012\u001c\n\u0014experimental_map_key\u0018\t \u0001(\t\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption\"/\n\u0005CType\u0012\n\n\u0006STRING\u0010\u0000\u0012\b\n\u0004CORD\u0010\u0001\u0012\u0010\n\fSTRING_PIECE\u0010\u0002*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"]\n\u000bEnumOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"b\n\u0010EnumValue", "Options\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"`\n\u000eServiceOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"_\n\rMethodOptions\u0012C\n\u0014uninterpreted_option\u0018ç\u0007 \u0003(\u000b2$.google.protobuf.UninterpretedOption*\t\bè\u0007\u0010\u0080\u0080\u0080\u0080\u0002\"\u009e\u0002\n\u0013UninterpretedOption\u0012;\n\u0004name\u0018\u0002 \u0003(\u000b2-.google.protobuf.UninterpretedOption.NamePart\u0012\u0018\n\u0010identifier_value\u0018\u0003 \u0001(\t\u0012\u001a\n\u0012pos", "itive_int_value\u0018\u0004 \u0001(\u0004\u0012\u001a\n\u0012negative_int_value\u0018\u0005 \u0001(\u0003\u0012\u0014\n\fdouble_value\u0018\u0006 \u0001(\u0001\u0012\u0014\n\fstring_value\u0018\u0007 \u0001(\f\u0012\u0017\n\u000faggregate_value\u0018\b \u0001(\t\u001a3\n\bNamePart\u0012\u0011\n\tname_part\u0018\u0001 \u0002(\t\u0012\u0014\n\fis_extension\u0018\u0002 \u0002(\b\"|\n\u000eSourceCodeInfo\u0012:\n\blocation\u0018\u0001 \u0003(\u000b2(.google.protobuf.SourceCodeInfo.Location\u001a.\n\bLocation\u0012\u0010\n\u0004path\u0018\u0001 \u0003(\u0005B\u0002\u0010\u0001\u0012\u0010\n\u0004span\u0018\u0002 \u0003(\u0005B\u0002\u0010\u0001B)\n\u0013com.google.protobufB\u0010DescriptorProtosH\u0001"};
        Descriptors.FileDescriptor.InternalDescriptorAssigner assigner = new Descriptors.FileDescriptor.InternalDescriptorAssigner() { // from class: com.google.protobuf.DescriptorProtos.1
            @Override // com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner
            public ExtensionRegistry assignDescriptors(Descriptors.FileDescriptor root) {
                DescriptorProtos.descriptor = root;
                DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(0);
                DescriptorProtos.f40x15a6a952 = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileDescriptorSet_descriptor, new String[]{"File"}, FileDescriptorSet.class, FileDescriptorSet.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(1);
                DescriptorProtos.f39x4b52780c = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileDescriptorProto_descriptor, new String[]{"Name", "Package", "Dependency", TTSRequestParams.TYPE, "EnumType", "Service", "Extension", "Options", "SourceCodeInfo"}, FileDescriptorProto.class, FileDescriptorProto.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(2);
                DescriptorProtos.f33x907d0bf0 = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor, new String[]{"Name", "Field", "Extension", "NestedType", "EnumType", "ExtensionRange", "Options"}, DescriptorProto.class, DescriptorProto.Builder.class);
                DescriptorProtos.f31x1458f8d = DescriptorProtos.internal_static_google_protobuf_DescriptorProto_descriptor.getNestedTypes().get(0);
                DescriptorProtos.f32xf366d90b = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.f31x1458f8d, new String[]{"Start", "End"}, DescriptorProto.ExtensionRange.class, DescriptorProto.ExtensionRange.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(3);
                DescriptorProtos.f38x4734b330 = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FieldDescriptorProto_descriptor, new String[]{"Name", "Number", "Label", "Type", "TypeName", "Extendee", "DefaultValue", "Options"}, FieldDescriptorProto.class, FieldDescriptorProto.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(4);
                DescriptorProtos.f34x9945f651 = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumDescriptorProto_descriptor, new String[]{"Name", "Value", "Options"}, EnumDescriptorProto.class, EnumDescriptorProto.Builder.class);
                DescriptorProtos.f35xf18031a8 = DescriptorProtos.getDescriptor().getMessageTypes().get(5);
                DescriptorProtos.f36xfb173026 = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.f35xf18031a8, new String[]{"Name", "Number", "Options"}, EnumValueDescriptorProto.class, EnumValueDescriptorProto.Builder.class);
                DescriptorProtos.f43x158c73ed = DescriptorProtos.getDescriptor().getMessageTypes().get(6);
                DescriptorProtos.f44xee335d6b = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.f43x158c73ed, new String[]{"Name", "Method", "Options"}, ServiceDescriptorProto.class, ServiceDescriptorProto.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(7);
                DescriptorProtos.f42xc5331ef1 = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MethodDescriptorProto_descriptor, new String[]{"Name", "InputType", "OutputType", "Options"}, MethodDescriptorProto.class, MethodDescriptorProto.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(8);
                DescriptorProtos.internal_static_google_protobuf_FileOptions_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FileOptions_descriptor, new String[]{"JavaPackage", "JavaOuterClassname", "JavaMultipleFiles", "JavaGenerateEqualsAndHash", "OptimizeFor", "CcGenericServices", "JavaGenericServices", "PyGenericServices", "UninterpretedOption"}, FileOptions.class, FileOptions.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(9);
                DescriptorProtos.f41x9c0b3d38 = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MessageOptions_descriptor, new String[]{"MessageSetWireFormat", "NoStandardDescriptorAccessor", "UninterpretedOption"}, MessageOptions.class, MessageOptions.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(10);
                DescriptorProtos.internal_static_google_protobuf_FieldOptions_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_FieldOptions_descriptor, new String[]{"Ctype", "Packed", "Deprecated", "ExperimentalMapKey", "UninterpretedOption"}, FieldOptions.class, FieldOptions.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(11);
                DescriptorProtos.internal_static_google_protobuf_EnumOptions_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumOptions_descriptor, new String[]{"UninterpretedOption"}, EnumOptions.class, EnumOptions.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(12);
                DescriptorProtos.f37xdf65a421 = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_EnumValueOptions_descriptor, new String[]{"UninterpretedOption"}, EnumValueOptions.class, EnumValueOptions.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(13);
                DescriptorProtos.f45x371e666 = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_ServiceOptions_descriptor, new String[]{"UninterpretedOption"}, ServiceOptions.class, ServiceOptions.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(14);
                DescriptorProtos.internal_static_google_protobuf_MethodOptions_fieldAccessorTable = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_MethodOptions_descriptor, new String[]{"UninterpretedOption"}, MethodOptions.class, MethodOptions.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(15);
                DescriptorProtos.f51x2101041 = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor, new String[]{"Name", "IdentifierValue", "PositiveIntValue", "NegativeIntValue", "DoubleValue", "StringValue", "AggregateValue"}, UninterpretedOption.class, UninterpretedOption.Builder.class);
                DescriptorProtos.f49xb111d23c = DescriptorProtos.internal_static_google_protobuf_UninterpretedOption_descriptor.getNestedTypes().get(0);
                DescriptorProtos.f50x1698fcba = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.f49xb111d23c, new String[]{"NamePart", "IsExtension"}, UninterpretedOption.NamePart.class, UninterpretedOption.NamePart.Builder.class);
                DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor = DescriptorProtos.getDescriptor().getMessageTypes().get(16);
                DescriptorProtos.f48x532209f9 = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor, new String[]{"Location"}, SourceCodeInfo.class, SourceCodeInfo.Builder.class);
                DescriptorProtos.f46xb210d08d = DescriptorProtos.internal_static_google_protobuf_SourceCodeInfo_descriptor.getNestedTypes().get(0);
                DescriptorProtos.f47x9611a0b = new GeneratedMessage.FieldAccessorTable(DescriptorProtos.f46xb210d08d, new String[]{"Path", "Span"}, SourceCodeInfo.Location.class, SourceCodeInfo.Location.Builder.class);
                return null;
            }
        };
        Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(descriptorData, new Descriptors.FileDescriptor[0], assigner);
    }
}
