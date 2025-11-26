package com.google.protobuf;

import com.google.protobuf.DescriptorProtos;
import com.google.protobuf.FieldSet;
import com.google.protobuf.Internal;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.TextFormat;
import com.google.protobuf.WireFormat;
import com.infraware.office.evengine.InterfaceC0507E;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class Descriptors {

    private interface GenericDescriptor {
        FileDescriptor getFile();

        String getFullName();

        String getName();

        Message toProto();
    }

    public static final class FileDescriptor {
        private final FileDescriptor[] dependencies;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] extensions;
        private final Descriptor[] messageTypes;
        private final DescriptorPool pool;
        private DescriptorProtos.FileDescriptorProto proto;
        private final ServiceDescriptor[] services;

        public interface InternalDescriptorAssigner {
            ExtensionRegistry assignDescriptors(FileDescriptor fileDescriptor);
        }

        public DescriptorProtos.FileDescriptorProto toProto() {
            return this.proto;
        }

        public String getName() {
            return this.proto.getName();
        }

        public String getPackage() {
            return this.proto.getPackage();
        }

        public DescriptorProtos.FileOptions getOptions() {
            return this.proto.getOptions();
        }

        public List<Descriptor> getMessageTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.messageTypes));
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public List<ServiceDescriptor> getServices() {
            return Collections.unmodifiableList(Arrays.asList(this.services));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public List<FileDescriptor> getDependencies() {
            return Collections.unmodifiableList(Arrays.asList(this.dependencies));
        }

        public Descriptor findMessageTypeByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            if (getPackage().length() > 0) {
                name = String.valueOf(getPackage()) + '.' + name;
            }
            GenericDescriptor result = this.pool.findSymbol(name);
            if (result != null && (result instanceof Descriptor) && result.getFile() == this) {
                return (Descriptor) result;
            }
            return null;
        }

        public EnumDescriptor findEnumTypeByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            if (getPackage().length() > 0) {
                name = String.valueOf(getPackage()) + '.' + name;
            }
            GenericDescriptor result = this.pool.findSymbol(name);
            if (result != null && (result instanceof EnumDescriptor) && result.getFile() == this) {
                return (EnumDescriptor) result;
            }
            return null;
        }

        public ServiceDescriptor findServiceByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            if (getPackage().length() > 0) {
                name = String.valueOf(getPackage()) + '.' + name;
            }
            GenericDescriptor result = this.pool.findSymbol(name);
            if (result != null && (result instanceof ServiceDescriptor) && result.getFile() == this) {
                return (ServiceDescriptor) result;
            }
            return null;
        }

        public FieldDescriptor findExtensionByName(String name) {
            if (name.indexOf(46) != -1) {
                return null;
            }
            if (getPackage().length() > 0) {
                name = String.valueOf(getPackage()) + '.' + name;
            }
            GenericDescriptor result = this.pool.findSymbol(name);
            if (result != null && (result instanceof FieldDescriptor) && result.getFile() == this) {
                return (FieldDescriptor) result;
            }
            return null;
        }

        public static FileDescriptor buildFrom(DescriptorProtos.FileDescriptorProto proto, FileDescriptor[] dependencies) throws DescriptorValidationException {
            DescriptorValidationException descriptorValidationException = null;
            DescriptorPool pool = new DescriptorPool(dependencies);
            FileDescriptor result = new FileDescriptor(proto, dependencies, pool);
            if (dependencies.length != proto.getDependencyCount()) {
                throw new DescriptorValidationException(result, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.", descriptorValidationException);
            }
            for (int i = 0; i < proto.getDependencyCount(); i++) {
                if (!dependencies[i].getName().equals(proto.getDependency(i))) {
                    throw new DescriptorValidationException(result, "Dependencies passed to FileDescriptor.buildFrom() don't match those listed in the FileDescriptorProto.", descriptorValidationException);
                }
            }
            result.crossLink();
            return result;
        }

        public static void internalBuildGeneratedFileFrom(String[] descriptorDataParts, FileDescriptor[] dependencies, InternalDescriptorAssigner descriptorAssigner) throws UnsupportedEncodingException {
            StringBuilder descriptorData = new StringBuilder();
            for (String part : descriptorDataParts) {
                descriptorData.append(part);
            }
            try {
                byte[] descriptorBytes = descriptorData.toString().getBytes("ISO-8859-1");
                try {
                    DescriptorProtos.FileDescriptorProto proto = DescriptorProtos.FileDescriptorProto.parseFrom(descriptorBytes);
                    try {
                        FileDescriptor result = buildFrom(proto, dependencies);
                        ExtensionRegistry registry = descriptorAssigner.assignDescriptors(result);
                        if (registry != null) {
                            try {
                                result.setProto(DescriptorProtos.FileDescriptorProto.parseFrom(descriptorBytes, registry));
                            } catch (InvalidProtocolBufferException e) {
                                throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e);
                            }
                        }
                    } catch (DescriptorValidationException e2) {
                        throw new IllegalArgumentException("Invalid embedded descriptor for \"" + proto.getName() + "\".", e2);
                    }
                } catch (InvalidProtocolBufferException e3) {
                    throw new IllegalArgumentException("Failed to parse protocol buffer descriptor for generated code.", e3);
                }
            } catch (UnsupportedEncodingException e4) {
                throw new RuntimeException("Standard encoding ISO-8859-1 not supported by JVM.", e4);
            }
        }

        private FileDescriptor(DescriptorProtos.FileDescriptorProto fileDescriptorProto, FileDescriptor[] fileDescriptorArr, DescriptorPool descriptorPool) throws DescriptorValidationException {
            Descriptor descriptor = null;
            byte b = 0;
            byte b2 = 0;
            byte b3 = 0;
            byte b4 = 0;
            byte b5 = 0;
            byte b6 = 0;
            this.pool = descriptorPool;
            this.proto = fileDescriptorProto;
            this.dependencies = (FileDescriptor[]) fileDescriptorArr.clone();
            descriptorPool.addPackage(getPackage(), this);
            this.messageTypes = new Descriptor[fileDescriptorProto.getMessageTypeCount()];
            for (int i = 0; i < fileDescriptorProto.getMessageTypeCount(); i++) {
                this.messageTypes[i] = new Descriptor(fileDescriptorProto.getMessageType(i), this, descriptor, i, b6 == true ? 1 : 0);
            }
            this.enumTypes = new EnumDescriptor[fileDescriptorProto.getEnumTypeCount()];
            for (int i2 = 0; i2 < fileDescriptorProto.getEnumTypeCount(); i2++) {
                this.enumTypes[i2] = new EnumDescriptor(fileDescriptorProto.getEnumType(i2), this, b5 == true ? 1 : 0, i2, b4 == true ? 1 : 0);
            }
            this.services = new ServiceDescriptor[fileDescriptorProto.getServiceCount()];
            for (int i3 = 0; i3 < fileDescriptorProto.getServiceCount(); i3++) {
                this.services[i3] = new ServiceDescriptor(fileDescriptorProto.getService(i3), this, i3, b3 == true ? 1 : 0);
            }
            this.extensions = new FieldDescriptor[fileDescriptorProto.getExtensionCount()];
            for (int i4 = 0; i4 < fileDescriptorProto.getExtensionCount(); i4++) {
                this.extensions[i4] = new FieldDescriptor(fileDescriptorProto.getExtension(i4), this, b2 == true ? 1 : 0, i4, true, b == true ? 1 : 0);
            }
        }

        private void crossLink() throws DescriptorValidationException {
            for (Descriptor messageType : this.messageTypes) {
                messageType.crossLink();
            }
            for (ServiceDescriptor service : this.services) {
                service.crossLink();
            }
            for (FieldDescriptor extension : this.extensions) {
                extension.crossLink();
            }
        }

        private void setProto(DescriptorProtos.FileDescriptorProto proto) {
            this.proto = proto;
            for (int i = 0; i < this.messageTypes.length; i++) {
                this.messageTypes[i].setProto(proto.getMessageType(i));
            }
            for (int i2 = 0; i2 < this.enumTypes.length; i2++) {
                this.enumTypes[i2].setProto(proto.getEnumType(i2));
            }
            for (int i3 = 0; i3 < this.services.length; i3++) {
                this.services[i3].setProto(proto.getService(i3));
            }
            for (int i4 = 0; i4 < this.extensions.length; i4++) {
                this.extensions[i4].setProto(proto.getExtension(i4));
            }
        }
    }

    public static final class Descriptor implements GenericDescriptor {
        private final Descriptor containingType;
        private final EnumDescriptor[] enumTypes;
        private final FieldDescriptor[] extensions;
        private final FieldDescriptor[] fields;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private final Descriptor[] nestedTypes;
        private DescriptorProtos.DescriptorProto proto;

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.DescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public DescriptorProtos.MessageOptions getOptions() {
            return this.proto.getOptions();
        }

        public List<FieldDescriptor> getFields() {
            return Collections.unmodifiableList(Arrays.asList(this.fields));
        }

        public List<FieldDescriptor> getExtensions() {
            return Collections.unmodifiableList(Arrays.asList(this.extensions));
        }

        public List<Descriptor> getNestedTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.nestedTypes));
        }

        public List<EnumDescriptor> getEnumTypes() {
            return Collections.unmodifiableList(Arrays.asList(this.enumTypes));
        }

        public boolean isExtensionNumber(int number) {
            for (DescriptorProtos.DescriptorProto.ExtensionRange range : this.proto.getExtensionRangeList()) {
                if (range.getStart() <= number && number < range.getEnd()) {
                    return true;
                }
            }
            return false;
        }

        public FieldDescriptor findFieldByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(String.valueOf(this.fullName) + '.' + name);
            if (result == null || !(result instanceof FieldDescriptor)) {
                return null;
            }
            return (FieldDescriptor) result;
        }

        public FieldDescriptor findFieldByNumber(int number) {
            return (FieldDescriptor) this.file.pool.fieldsByNumber.get(new DescriptorPool.DescriptorIntPair(this, number));
        }

        public Descriptor findNestedTypeByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(String.valueOf(this.fullName) + '.' + name);
            if (result == null || !(result instanceof Descriptor)) {
                return null;
            }
            return (Descriptor) result;
        }

        public EnumDescriptor findEnumTypeByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(String.valueOf(this.fullName) + '.' + name);
            if (result == null || !(result instanceof EnumDescriptor)) {
                return null;
            }
            return (EnumDescriptor) result;
        }

        private Descriptor(DescriptorProtos.DescriptorProto proto, FileDescriptor file, Descriptor parent, int index) throws DescriptorValidationException {
            this.index = index;
            this.proto = proto;
            this.fullName = Descriptors.computeFullName(file, parent, proto.getName());
            this.file = file;
            this.containingType = parent;
            this.nestedTypes = new Descriptor[proto.getNestedTypeCount()];
            for (int i = 0; i < proto.getNestedTypeCount(); i++) {
                this.nestedTypes[i] = new Descriptor(proto.getNestedType(i), file, this, i);
            }
            this.enumTypes = new EnumDescriptor[proto.getEnumTypeCount()];
            for (int i2 = 0; i2 < proto.getEnumTypeCount(); i2++) {
                this.enumTypes[i2] = new EnumDescriptor(proto.getEnumType(i2), file, this, i2, null);
            }
            this.fields = new FieldDescriptor[proto.getFieldCount()];
            for (int i3 = 0; i3 < proto.getFieldCount(); i3++) {
                this.fields[i3] = new FieldDescriptor(proto.getField(i3), file, this, i3, false, null);
            }
            this.extensions = new FieldDescriptor[proto.getExtensionCount()];
            for (int i4 = 0; i4 < proto.getExtensionCount(); i4++) {
                this.extensions[i4] = new FieldDescriptor(proto.getExtension(i4), file, this, i4, true, null);
            }
            file.pool.addSymbol(this);
        }

        /* synthetic */ Descriptor(DescriptorProtos.DescriptorProto descriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, Descriptor descriptor2) throws DescriptorValidationException {
            this(descriptorProto, fileDescriptor, descriptor, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            for (Descriptor nestedType : this.nestedTypes) {
                nestedType.crossLink();
            }
            for (FieldDescriptor field : this.fields) {
                field.crossLink();
            }
            for (FieldDescriptor extension : this.extensions) {
                extension.crossLink();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProto(DescriptorProtos.DescriptorProto proto) {
            this.proto = proto;
            for (int i = 0; i < this.nestedTypes.length; i++) {
                this.nestedTypes[i].setProto(proto.getNestedType(i));
            }
            for (int i2 = 0; i2 < this.enumTypes.length; i2++) {
                this.enumTypes[i2].setProto(proto.getEnumType(i2));
            }
            for (int i3 = 0; i3 < this.fields.length; i3++) {
                this.fields[i3].setProto(proto.getField(i3));
            }
            for (int i4 = 0; i4 < this.extensions.length; i4++) {
                this.extensions[i4].setProto(proto.getExtension(i4));
            }
        }
    }

    public static final class FieldDescriptor implements GenericDescriptor, Comparable<FieldDescriptor>, FieldSet.FieldDescriptorLite<FieldDescriptor> {

        /* renamed from: $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType */
        private static /* synthetic */ int[] f52xfcc84f65;

        /* renamed from: $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type */
        private static /* synthetic */ int[] f53x792aeea3;
        private static final WireFormat.FieldType[] table = WireFormat.FieldType.values();
        private Descriptor containingType;
        private Object defaultValue;
        private EnumDescriptor enumType;
        private final Descriptor extensionScope;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private Descriptor messageType;
        private DescriptorProtos.FieldDescriptorProto proto;
        private Type type;

        /* renamed from: $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$JavaType */
        static /* synthetic */ int[] m1xfcc84f65() {
            int[] iArr = f52xfcc84f65;
            if (iArr == null) {
                iArr = new int[JavaType.valuesCustom().length];
                try {
                    iArr[JavaType.BOOLEAN.ordinal()] = 5;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[JavaType.BYTE_STRING.ordinal()] = 7;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[JavaType.DOUBLE.ordinal()] = 4;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[JavaType.ENUM.ordinal()] = 8;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[JavaType.FLOAT.ordinal()] = 3;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[JavaType.INT.ordinal()] = 1;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[JavaType.LONG.ordinal()] = 2;
                } catch (NoSuchFieldError e7) {
                }
                try {
                    iArr[JavaType.MESSAGE.ordinal()] = 9;
                } catch (NoSuchFieldError e8) {
                }
                try {
                    iArr[JavaType.STRING.ordinal()] = 6;
                } catch (NoSuchFieldError e9) {
                }
                f52xfcc84f65 = iArr;
            }
            return iArr;
        }

        /* renamed from: $SWITCH_TABLE$com$google$protobuf$Descriptors$FieldDescriptor$Type */
        static /* synthetic */ int[] m2x792aeea3() {
            int[] iArr = f53x792aeea3;
            if (iArr == null) {
                iArr = new int[Type.valuesCustom().length];
                try {
                    iArr[Type.BOOL.ordinal()] = 8;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Type.BYTES.ordinal()] = 12;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Type.DOUBLE.ordinal()] = 1;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[Type.ENUM.ordinal()] = 14;
                } catch (NoSuchFieldError e4) {
                }
                try {
                    iArr[Type.FIXED32.ordinal()] = 7;
                } catch (NoSuchFieldError e5) {
                }
                try {
                    iArr[Type.FIXED64.ordinal()] = 6;
                } catch (NoSuchFieldError e6) {
                }
                try {
                    iArr[Type.FLOAT.ordinal()] = 2;
                } catch (NoSuchFieldError e7) {
                }
                try {
                    iArr[Type.GROUP.ordinal()] = 10;
                } catch (NoSuchFieldError e8) {
                }
                try {
                    iArr[Type.INT32.ordinal()] = 5;
                } catch (NoSuchFieldError e9) {
                }
                try {
                    iArr[Type.INT64.ordinal()] = 3;
                } catch (NoSuchFieldError e10) {
                }
                try {
                    iArr[Type.MESSAGE.ordinal()] = 11;
                } catch (NoSuchFieldError e11) {
                }
                try {
                    iArr[Type.SFIXED32.ordinal()] = 15;
                } catch (NoSuchFieldError e12) {
                }
                try {
                    iArr[Type.SFIXED64.ordinal()] = 16;
                } catch (NoSuchFieldError e13) {
                }
                try {
                    iArr[Type.SINT32.ordinal()] = 17;
                } catch (NoSuchFieldError e14) {
                }
                try {
                    iArr[Type.SINT64.ordinal()] = 18;
                } catch (NoSuchFieldError e15) {
                }
                try {
                    iArr[Type.STRING.ordinal()] = 9;
                } catch (NoSuchFieldError e16) {
                }
                try {
                    iArr[Type.UINT32.ordinal()] = 13;
                } catch (NoSuchFieldError e17) {
                }
                try {
                    iArr[Type.UINT64.ordinal()] = 4;
                } catch (NoSuchFieldError e18) {
                }
                f53x792aeea3 = iArr;
            }
            return iArr;
        }

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.FieldDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public int getNumber() {
            return this.proto.getNumber();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        public JavaType getJavaType() {
            return this.type.getJavaType();
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.JavaType getLiteJavaType() {
            return getLiteType().getJavaType();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public Type getType() {
            return this.type;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public WireFormat.FieldType getLiteType() {
            return table[this.type.ordinal()];
        }

        static {
            if (Type.valuesCustom().length == DescriptorProtos.FieldDescriptorProto.Type.valuesCustom().length) {
            } else {
                throw new RuntimeException("descriptor.proto has a new declared type but Desrciptors.java wasn't updated.");
            }
        }

        public boolean isRequired() {
            return this.proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REQUIRED;
        }

        public boolean isOptional() {
            return this.proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_OPTIONAL;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isRepeated() {
            return this.proto.getLabel() == DescriptorProtos.FieldDescriptorProto.Label.LABEL_REPEATED;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public boolean isPacked() {
            return getOptions().getPacked();
        }

        public boolean isPackable() {
            return isRepeated() && getLiteType().isPackable();
        }

        public boolean hasDefaultValue() {
            return this.proto.hasDefaultValue();
        }

        public Object getDefaultValue() {
            if (getJavaType() == JavaType.MESSAGE) {
                throw new UnsupportedOperationException("FieldDescriptor.getDefaultValue() called on an embedded message field.");
            }
            return this.defaultValue;
        }

        public DescriptorProtos.FieldOptions getOptions() {
            return this.proto.getOptions();
        }

        public boolean isExtension() {
            return this.proto.hasExtendee();
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public Descriptor getExtensionScope() {
            if (!isExtension()) {
                throw new UnsupportedOperationException("This field is not an extension.");
            }
            return this.extensionScope;
        }

        public Descriptor getMessageType() {
            if (getJavaType() != JavaType.MESSAGE) {
                throw new UnsupportedOperationException("This field is not of message type.");
            }
            return this.messageType;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public EnumDescriptor getEnumType() {
            if (getJavaType() != JavaType.ENUM) {
                throw new UnsupportedOperationException("This field is not of enum type.");
            }
            return this.enumType;
        }

        @Override // java.lang.Comparable
        public int compareTo(FieldDescriptor other) {
            if (other.containingType != this.containingType) {
                throw new IllegalArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
            }
            return getNumber() - other.getNumber();
        }

        public enum Type {
            DOUBLE(JavaType.DOUBLE),
            FLOAT(JavaType.FLOAT),
            INT64(JavaType.LONG),
            UINT64(JavaType.LONG),
            INT32(JavaType.INT),
            FIXED64(JavaType.LONG),
            FIXED32(JavaType.INT),
            BOOL(JavaType.BOOLEAN),
            STRING(JavaType.STRING),
            GROUP(JavaType.MESSAGE),
            MESSAGE(JavaType.MESSAGE),
            BYTES(JavaType.BYTE_STRING),
            UINT32(JavaType.INT),
            ENUM(JavaType.ENUM),
            SFIXED32(JavaType.INT),
            SFIXED64(JavaType.LONG),
            SINT32(JavaType.INT),
            SINT64(JavaType.LONG);

            private JavaType javaType;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static Type[] valuesCustom() {
                Type[] typeArrValuesCustom = values();
                int length = typeArrValuesCustom.length;
                Type[] typeArr = new Type[length];
                System.arraycopy(typeArrValuesCustom, 0, typeArr, 0, length);
                return typeArr;
            }

            Type(JavaType javaType) {
                this.javaType = javaType;
            }

            public DescriptorProtos.FieldDescriptorProto.Type toProto() {
                return DescriptorProtos.FieldDescriptorProto.Type.valueOf(ordinal() + 1);
            }

            public JavaType getJavaType() {
                return this.javaType;
            }

            public static Type valueOf(DescriptorProtos.FieldDescriptorProto.Type type) {
                return valuesCustom()[type.getNumber() - 1];
            }
        }

        public enum JavaType {
            INT(0),
            LONG(0L),
            FLOAT(Float.valueOf(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET)),
            DOUBLE(Double.valueOf(0.0d)),
            BOOLEAN(false),
            STRING(""),
            BYTE_STRING(ByteString.EMPTY),
            ENUM(null),
            MESSAGE(null);

            private final Object defaultDefault;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static JavaType[] valuesCustom() {
                JavaType[] javaTypeArrValuesCustom = values();
                int length = javaTypeArrValuesCustom.length;
                JavaType[] javaTypeArr = new JavaType[length];
                System.arraycopy(javaTypeArrValuesCustom, 0, javaTypeArr, 0, length);
                return javaTypeArr;
            }

            JavaType(Object defaultDefault) {
                this.defaultDefault = defaultDefault;
            }
        }

        private FieldDescriptor(DescriptorProtos.FieldDescriptorProto proto, FileDescriptor file, Descriptor parent, int index, boolean isExtension) throws DescriptorValidationException {
            DescriptorValidationException descriptorValidationException = null;
            this.index = index;
            this.proto = proto;
            this.fullName = Descriptors.computeFullName(file, parent, proto.getName());
            this.file = file;
            if (proto.hasType()) {
                this.type = Type.valueOf(proto.getType());
            }
            if (getNumber() <= 0) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Field numbers must be positive integers.", descriptorValidationException);
            }
            if (proto.getOptions().getPacked() && !isPackable()) {
                throw new DescriptorValidationException((GenericDescriptor) this, "[packed = true] can only be specified for repeated primitive fields.", descriptorValidationException);
            }
            if (isExtension) {
                if (!proto.hasExtendee()) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "FieldDescriptorProto.extendee not set for extension field.", descriptorValidationException);
                }
                this.containingType = null;
                if (parent != null) {
                    this.extensionScope = parent;
                } else {
                    this.extensionScope = null;
                }
            } else {
                if (proto.hasExtendee()) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "FieldDescriptorProto.extendee set for non-extension field.", descriptorValidationException);
                }
                this.containingType = parent;
                this.extensionScope = null;
            }
            file.pool.addSymbol(this);
        }

        /* synthetic */ FieldDescriptor(DescriptorProtos.FieldDescriptorProto fieldDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, boolean z, FieldDescriptor fieldDescriptor) throws DescriptorValidationException {
            this(fieldDescriptorProto, fileDescriptor, descriptor, i, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public void crossLink() throws DescriptorValidationException {
            DescriptorValidationException descriptorValidationException = null;
            if (this.proto.hasExtendee()) {
                GenericDescriptor extendee = this.file.pool.lookupSymbol(this.proto.getExtendee(), this);
                if (!(extendee instanceof Descriptor)) {
                    throw new DescriptorValidationException((GenericDescriptor) this, String.valueOf('\"') + this.proto.getExtendee() + "\" is not a message type.", descriptorValidationException);
                }
                this.containingType = (Descriptor) extendee;
                if (!getContainingType().isExtensionNumber(getNumber())) {
                    throw new DescriptorValidationException((GenericDescriptor) this, String.valueOf('\"') + getContainingType().getFullName() + "\" does not declare " + getNumber() + " as an extension number.", descriptorValidationException);
                }
            }
            if (this.proto.hasTypeName()) {
                GenericDescriptor typeDescriptor = this.file.pool.lookupSymbol(this.proto.getTypeName(), this);
                if (!this.proto.hasType()) {
                    if (typeDescriptor instanceof Descriptor) {
                        this.type = Type.MESSAGE;
                    } else if (typeDescriptor instanceof EnumDescriptor) {
                        this.type = Type.ENUM;
                    } else {
                        throw new DescriptorValidationException((GenericDescriptor) this, String.valueOf('\"') + this.proto.getTypeName() + "\" is not a type.", descriptorValidationException);
                    }
                }
                if (getJavaType() == JavaType.MESSAGE) {
                    if (!(typeDescriptor instanceof Descriptor)) {
                        throw new DescriptorValidationException((GenericDescriptor) this, String.valueOf('\"') + this.proto.getTypeName() + "\" is not a message type.", descriptorValidationException);
                    }
                    this.messageType = (Descriptor) typeDescriptor;
                    if (this.proto.hasDefaultValue()) {
                        throw new DescriptorValidationException((GenericDescriptor) this, "Messages can't have default values.", descriptorValidationException);
                    }
                } else if (getJavaType() == JavaType.ENUM) {
                    if (!(typeDescriptor instanceof EnumDescriptor)) {
                        throw new DescriptorValidationException((GenericDescriptor) this, String.valueOf('\"') + this.proto.getTypeName() + "\" is not an enum type.", descriptorValidationException);
                    }
                    this.enumType = (EnumDescriptor) typeDescriptor;
                } else {
                    throw new DescriptorValidationException((GenericDescriptor) this, "Field with primitive type has type_name.", descriptorValidationException);
                }
            } else if (getJavaType() == JavaType.MESSAGE || getJavaType() == JavaType.ENUM) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Field with message or enum type missing type_name.", descriptorValidationException);
            }
            if (this.proto.hasDefaultValue()) {
                if (isRepeated()) {
                    throw new DescriptorValidationException((GenericDescriptor) this, "Repeated fields cannot have default values.", descriptorValidationException);
                }
                try {
                    switch (m2x792aeea3()[getType().ordinal()]) {
                        case 1:
                            if (this.proto.getDefaultValue().equals("inf")) {
                                this.defaultValue = Double.valueOf(Double.POSITIVE_INFINITY);
                                break;
                            } else if (this.proto.getDefaultValue().equals("-inf")) {
                                this.defaultValue = Double.valueOf(Double.NEGATIVE_INFINITY);
                                break;
                            } else if (this.proto.getDefaultValue().equals("nan")) {
                                this.defaultValue = Double.valueOf(Double.NaN);
                                break;
                            } else {
                                this.defaultValue = Double.valueOf(this.proto.getDefaultValue());
                                break;
                            }
                        case 2:
                            if (this.proto.getDefaultValue().equals("inf")) {
                                this.defaultValue = Float.valueOf(Float.POSITIVE_INFINITY);
                                break;
                            } else if (this.proto.getDefaultValue().equals("-inf")) {
                                this.defaultValue = Float.valueOf(Float.NEGATIVE_INFINITY);
                                break;
                            } else if (this.proto.getDefaultValue().equals("nan")) {
                                this.defaultValue = Float.valueOf(Float.NaN);
                                break;
                            } else {
                                this.defaultValue = Float.valueOf(this.proto.getDefaultValue());
                                break;
                            }
                        case 3:
                        case 16:
                        case 18:
                            this.defaultValue = Long.valueOf(TextFormat.parseInt64(this.proto.getDefaultValue()));
                            break;
                        case 4:
                        case 6:
                            this.defaultValue = Long.valueOf(TextFormat.parseUInt64(this.proto.getDefaultValue()));
                            break;
                        case 5:
                        case 15:
                        case 17:
                            this.defaultValue = Integer.valueOf(TextFormat.parseInt32(this.proto.getDefaultValue()));
                            break;
                        case 7:
                        case 13:
                            this.defaultValue = Integer.valueOf(TextFormat.parseUInt32(this.proto.getDefaultValue()));
                            break;
                        case 8:
                            this.defaultValue = Boolean.valueOf(this.proto.getDefaultValue());
                            break;
                        case 9:
                            this.defaultValue = this.proto.getDefaultValue();
                            break;
                        case 10:
                        case 11:
                            throw new DescriptorValidationException((GenericDescriptor) this, "Message type had default value.", (DescriptorValidationException) null);
                        case 12:
                            try {
                                this.defaultValue = TextFormat.unescapeBytes(this.proto.getDefaultValue());
                                break;
                            } catch (TextFormat.InvalidEscapeSequenceException e) {
                                throw new DescriptorValidationException(this, "Couldn't parse default value: " + e.getMessage(), e, null);
                            }
                        case 14:
                            this.defaultValue = this.enumType.findValueByName(this.proto.getDefaultValue());
                            if (this.defaultValue == null) {
                                throw new DescriptorValidationException((GenericDescriptor) this, "Unknown enum default value: \"" + this.proto.getDefaultValue() + '\"', (DescriptorValidationException) null);
                            }
                            break;
                    }
                } catch (NumberFormatException e2) {
                    throw new DescriptorValidationException(this, "Could not parse default value: \"" + this.proto.getDefaultValue() + '\"', e2, descriptorValidationException);
                }
            } else if (isRepeated()) {
                this.defaultValue = Collections.emptyList();
            } else {
                switch (m1xfcc84f65()[getJavaType().ordinal()]) {
                    case 8:
                        this.defaultValue = this.enumType.getValues().get(0);
                        break;
                    case 9:
                        this.defaultValue = null;
                        break;
                    default:
                        this.defaultValue = getJavaType().defaultDefault;
                        break;
                }
            }
            if (!isExtension()) {
                this.file.pool.addFieldByNumber(this);
            }
            if (this.containingType != null && this.containingType.getOptions().getMessageSetWireFormat()) {
                if (isExtension()) {
                    if (!isOptional() || getType() != Type.MESSAGE) {
                        throw new DescriptorValidationException((GenericDescriptor) this, "Extensions of MessageSets must be optional messages.", descriptorValidationException);
                    }
                    return;
                }
                throw new DescriptorValidationException((GenericDescriptor) this, "MessageSets cannot have fields, only extensions.", descriptorValidationException);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProto(DescriptorProtos.FieldDescriptorProto proto) {
            this.proto = proto;
        }

        @Override // com.google.protobuf.FieldSet.FieldDescriptorLite
        public MessageLite.Builder internalMergeFrom(MessageLite.Builder to, MessageLite from) {
            return ((Message.Builder) to).mergeFrom((Message) from);
        }
    }

    public static final class EnumDescriptor implements GenericDescriptor, Internal.EnumLiteMap<EnumValueDescriptor> {
        private final Descriptor containingType;
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private DescriptorProtos.EnumDescriptorProto proto;
        private EnumValueDescriptor[] values;

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public Descriptor getContainingType() {
            return this.containingType;
        }

        public DescriptorProtos.EnumOptions getOptions() {
            return this.proto.getOptions();
        }

        public List<EnumValueDescriptor> getValues() {
            return Collections.unmodifiableList(Arrays.asList(this.values));
        }

        public EnumValueDescriptor findValueByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(String.valueOf(this.fullName) + '.' + name);
            if (result == null || !(result instanceof EnumValueDescriptor)) {
                return null;
            }
            return (EnumValueDescriptor) result;
        }

        @Override // com.google.protobuf.Internal.EnumLiteMap
        public EnumValueDescriptor findValueByNumber(int number) {
            return (EnumValueDescriptor) this.file.pool.enumValuesByNumber.get(new DescriptorPool.DescriptorIntPair(this, number));
        }

        private EnumDescriptor(DescriptorProtos.EnumDescriptorProto enumDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i) throws DescriptorValidationException {
            DescriptorValidationException descriptorValidationException = null;
            byte b = 0;
            this.index = i;
            this.proto = enumDescriptorProto;
            this.fullName = Descriptors.computeFullName(fileDescriptor, descriptor, enumDescriptorProto.getName());
            this.file = fileDescriptor;
            this.containingType = descriptor;
            if (enumDescriptorProto.getValueCount() == 0) {
                throw new DescriptorValidationException((GenericDescriptor) this, "Enums must contain at least one value.", descriptorValidationException);
            }
            this.values = new EnumValueDescriptor[enumDescriptorProto.getValueCount()];
            for (int i2 = 0; i2 < enumDescriptorProto.getValueCount(); i2++) {
                this.values[i2] = new EnumValueDescriptor(enumDescriptorProto.getValue(i2), fileDescriptor, this, i2, b == true ? 1 : 0);
            }
            fileDescriptor.pool.addSymbol(this);
        }

        /* synthetic */ EnumDescriptor(DescriptorProtos.EnumDescriptorProto enumDescriptorProto, FileDescriptor fileDescriptor, Descriptor descriptor, int i, EnumDescriptor enumDescriptor) throws DescriptorValidationException {
            this(enumDescriptorProto, fileDescriptor, descriptor, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProto(DescriptorProtos.EnumDescriptorProto proto) {
            this.proto = proto;
            for (int i = 0; i < this.values.length; i++) {
                this.values[i].setProto(proto.getValue(i));
            }
        }
    }

    public static final class EnumValueDescriptor implements GenericDescriptor, Internal.EnumLite {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private DescriptorProtos.EnumValueDescriptorProto proto;
        private final EnumDescriptor type;

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.EnumValueDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public int getNumber() {
            return this.proto.getNumber();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public EnumDescriptor getType() {
            return this.type;
        }

        public DescriptorProtos.EnumValueOptions getOptions() {
            return this.proto.getOptions();
        }

        private EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto proto, FileDescriptor file, EnumDescriptor parent, int index) throws DescriptorValidationException {
            this.index = index;
            this.proto = proto;
            this.file = file;
            this.type = parent;
            this.fullName = String.valueOf(parent.getFullName()) + '.' + proto.getName();
            file.pool.addSymbol(this);
            file.pool.addEnumValueByNumber(this);
        }

        /* synthetic */ EnumValueDescriptor(DescriptorProtos.EnumValueDescriptorProto enumValueDescriptorProto, FileDescriptor fileDescriptor, EnumDescriptor enumDescriptor, int i, EnumValueDescriptor enumValueDescriptor) throws DescriptorValidationException {
            this(enumValueDescriptorProto, fileDescriptor, enumDescriptor, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProto(DescriptorProtos.EnumValueDescriptorProto proto) {
            this.proto = proto;
        }
    }

    public static final class ServiceDescriptor implements GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private MethodDescriptor[] methods;
        private DescriptorProtos.ServiceDescriptorProto proto;

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.ServiceDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public DescriptorProtos.ServiceOptions getOptions() {
            return this.proto.getOptions();
        }

        public List<MethodDescriptor> getMethods() {
            return Collections.unmodifiableList(Arrays.asList(this.methods));
        }

        public MethodDescriptor findMethodByName(String name) {
            GenericDescriptor result = this.file.pool.findSymbol(String.valueOf(this.fullName) + '.' + name);
            if (result == null || !(result instanceof MethodDescriptor)) {
                return null;
            }
            return (MethodDescriptor) result;
        }

        private ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto proto, FileDescriptor file, int index) throws DescriptorValidationException {
            MethodDescriptor methodDescriptor = null;
            this.index = index;
            this.proto = proto;
            this.fullName = Descriptors.computeFullName(file, null, proto.getName());
            this.file = file;
            this.methods = new MethodDescriptor[proto.getMethodCount()];
            for (int i = 0; i < proto.getMethodCount(); i++) {
                this.methods[i] = new MethodDescriptor(proto.getMethod(i), file, this, i, methodDescriptor);
            }
            file.pool.addSymbol(this);
        }

        /* synthetic */ ServiceDescriptor(DescriptorProtos.ServiceDescriptorProto serviceDescriptorProto, FileDescriptor fileDescriptor, int i, ServiceDescriptor serviceDescriptor) throws DescriptorValidationException {
            this(serviceDescriptorProto, fileDescriptor, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            for (MethodDescriptor method : this.methods) {
                method.crossLink();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProto(DescriptorProtos.ServiceDescriptorProto proto) {
            this.proto = proto;
            for (int i = 0; i < this.methods.length; i++) {
                this.methods[i].setProto(proto.getMethod(i));
            }
        }
    }

    public static final class MethodDescriptor implements GenericDescriptor {
        private final FileDescriptor file;
        private final String fullName;
        private final int index;
        private Descriptor inputType;
        private Descriptor outputType;
        private DescriptorProtos.MethodDescriptorProto proto;
        private final ServiceDescriptor service;

        public int getIndex() {
            return this.index;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public DescriptorProtos.MethodDescriptorProto toProto() {
            return this.proto;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getName() {
            return this.proto.getName();
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public String getFullName() {
            return this.fullName;
        }

        @Override // com.google.protobuf.Descriptors.GenericDescriptor
        public FileDescriptor getFile() {
            return this.file;
        }

        public ServiceDescriptor getService() {
            return this.service;
        }

        public Descriptor getInputType() {
            return this.inputType;
        }

        public Descriptor getOutputType() {
            return this.outputType;
        }

        public DescriptorProtos.MethodOptions getOptions() {
            return this.proto.getOptions();
        }

        private MethodDescriptor(DescriptorProtos.MethodDescriptorProto proto, FileDescriptor file, ServiceDescriptor parent, int index) throws DescriptorValidationException {
            this.index = index;
            this.proto = proto;
            this.file = file;
            this.service = parent;
            this.fullName = String.valueOf(parent.getFullName()) + '.' + proto.getName();
            file.pool.addSymbol(this);
        }

        /* synthetic */ MethodDescriptor(DescriptorProtos.MethodDescriptorProto methodDescriptorProto, FileDescriptor fileDescriptor, ServiceDescriptor serviceDescriptor, int i, MethodDescriptor methodDescriptor) throws DescriptorValidationException {
            this(methodDescriptorProto, fileDescriptor, serviceDescriptor, i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void crossLink() throws DescriptorValidationException {
            DescriptorValidationException descriptorValidationException = null;
            GenericDescriptor input = this.file.pool.lookupSymbol(this.proto.getInputType(), this);
            if (!(input instanceof Descriptor)) {
                throw new DescriptorValidationException((GenericDescriptor) this, String.valueOf('\"') + this.proto.getInputType() + "\" is not a message type.", descriptorValidationException);
            }
            this.inputType = (Descriptor) input;
            GenericDescriptor output = this.file.pool.lookupSymbol(this.proto.getOutputType(), this);
            if (!(output instanceof Descriptor)) {
                throw new DescriptorValidationException((GenericDescriptor) this, String.valueOf('\"') + this.proto.getOutputType() + "\" is not a message type.", descriptorValidationException);
            }
            this.outputType = (Descriptor) output;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setProto(DescriptorProtos.MethodDescriptorProto proto) {
            this.proto = proto;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String computeFullName(FileDescriptor file, Descriptor parent, String name) {
        if (parent != null) {
            return String.valueOf(parent.getFullName()) + '.' + name;
        }
        if (file.getPackage().length() > 0) {
            return String.valueOf(file.getPackage()) + '.' + name;
        }
        return name;
    }

    public static class DescriptorValidationException extends Exception {
        private static final long serialVersionUID = 5750205775490483148L;
        private final String description;
        private final String name;
        private final Message proto;

        public String getProblemSymbolName() {
            return this.name;
        }

        public Message getProblemProto() {
            return this.proto;
        }

        public String getDescription() {
            return this.description;
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor genericDescriptor, String str, DescriptorValidationException descriptorValidationException) {
            this(genericDescriptor, str);
        }

        private DescriptorValidationException(GenericDescriptor problemDescriptor, String description) {
            super(String.valueOf(problemDescriptor.getFullName()) + ": " + description);
            this.name = problemDescriptor.getFullName();
            this.proto = problemDescriptor.toProto();
            this.description = description;
        }

        /* synthetic */ DescriptorValidationException(GenericDescriptor genericDescriptor, String str, Throwable th, DescriptorValidationException descriptorValidationException) {
            this(genericDescriptor, str, th);
        }

        private DescriptorValidationException(GenericDescriptor problemDescriptor, String description, Throwable cause) {
            this(problemDescriptor, description);
            initCause(cause);
        }

        /* synthetic */ DescriptorValidationException(FileDescriptor fileDescriptor, String str, DescriptorValidationException descriptorValidationException) {
            this(fileDescriptor, str);
        }

        private DescriptorValidationException(FileDescriptor problemDescriptor, String description) {
            super(String.valueOf(problemDescriptor.getName()) + ": " + description);
            this.name = problemDescriptor.getName();
            this.proto = problemDescriptor.toProto();
            this.description = description;
        }
    }

    private static final class DescriptorPool {
        static final /* synthetic */ boolean $assertionsDisabled;
        private final DescriptorPool[] dependencies;
        private final Map<String, GenericDescriptor> descriptorsByName = new HashMap();
        private final Map<DescriptorIntPair, FieldDescriptor> fieldsByNumber = new HashMap();
        private final Map<DescriptorIntPair, EnumValueDescriptor> enumValuesByNumber = new HashMap();

        static {
            $assertionsDisabled = !Descriptors.class.desiredAssertionStatus();
        }

        DescriptorPool(FileDescriptor[] dependencies) {
            this.dependencies = new DescriptorPool[dependencies.length];
            for (int i = 0; i < dependencies.length; i++) {
                this.dependencies[i] = dependencies[i].pool;
            }
            for (FileDescriptor dependency : dependencies) {
                try {
                    addPackage(dependency.getPackage(), dependency);
                } catch (DescriptorValidationException e) {
                    if (!$assertionsDisabled) {
                        throw new AssertionError();
                    }
                }
            }
        }

        GenericDescriptor findSymbol(String fullName) {
            GenericDescriptor result = this.descriptorsByName.get(fullName);
            if (result != null) {
                return result;
            }
            for (DescriptorPool dependency : this.dependencies) {
                GenericDescriptor result2 = dependency.descriptorsByName.get(fullName);
                if (result2 != null) {
                    return result2;
                }
            }
            return null;
        }

        GenericDescriptor lookupSymbol(String name, GenericDescriptor relativeTo) throws DescriptorValidationException {
            String firstPart;
            GenericDescriptor result;
            if (name.startsWith(".")) {
                result = findSymbol(name.substring(1));
            } else {
                int firstPartLength = name.indexOf(46);
                if (firstPartLength == -1) {
                    firstPart = name;
                } else {
                    firstPart = name.substring(0, firstPartLength);
                }
                StringBuilder scopeToTry = new StringBuilder(relativeTo.getFullName());
                while (true) {
                    int dotpos = scopeToTry.lastIndexOf(".");
                    if (dotpos == -1) {
                        result = findSymbol(name);
                        break;
                    }
                    scopeToTry.setLength(dotpos + 1);
                    scopeToTry.append(firstPart);
                    result = findSymbol(scopeToTry.toString());
                    if (result != null) {
                        if (firstPartLength != -1) {
                            scopeToTry.setLength(dotpos + 1);
                            scopeToTry.append(name);
                            result = findSymbol(scopeToTry.toString());
                        }
                    } else {
                        scopeToTry.setLength(dotpos);
                    }
                }
            }
            if (result == null) {
                throw new DescriptorValidationException(relativeTo, String.valueOf('\"') + name + "\" is not defined.", (DescriptorValidationException) null);
            }
            return result;
        }

        void addSymbol(GenericDescriptor descriptor) throws DescriptorValidationException {
            DescriptorValidationException descriptorValidationException = null;
            validateSymbolName(descriptor);
            String fullName = descriptor.getFullName();
            int dotpos = fullName.lastIndexOf(46);
            GenericDescriptor old = this.descriptorsByName.put(fullName, descriptor);
            if (old != null) {
                this.descriptorsByName.put(fullName, old);
                if (descriptor.getFile() == old.getFile()) {
                    if (dotpos == -1) {
                        throw new DescriptorValidationException(descriptor, String.valueOf('\"') + fullName + "\" is already defined.", descriptorValidationException);
                    }
                    throw new DescriptorValidationException(descriptor, String.valueOf('\"') + fullName.substring(dotpos + 1) + "\" is already defined in \"" + fullName.substring(0, dotpos) + "\".", descriptorValidationException);
                }
                throw new DescriptorValidationException(descriptor, String.valueOf('\"') + fullName + "\" is already defined in file \"" + old.getFile().getName() + "\".", descriptorValidationException);
            }
        }

        private static final class PackageDescriptor implements GenericDescriptor {
            private final FileDescriptor file;
            private final String fullName;
            private final String name;

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public Message toProto() {
                return this.file.toProto();
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public String getName() {
                return this.name;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public String getFullName() {
                return this.fullName;
            }

            @Override // com.google.protobuf.Descriptors.GenericDescriptor
            public FileDescriptor getFile() {
                return this.file;
            }

            PackageDescriptor(String name, String fullName, FileDescriptor file) {
                this.file = file;
                this.fullName = fullName;
                this.name = name;
            }
        }

        void addPackage(String fullName, FileDescriptor file) throws DescriptorValidationException {
            String name;
            int dotpos = fullName.lastIndexOf(46);
            if (dotpos == -1) {
                name = fullName;
            } else {
                addPackage(fullName.substring(0, dotpos), file);
                name = fullName.substring(dotpos + 1);
            }
            GenericDescriptor old = this.descriptorsByName.put(fullName, new PackageDescriptor(name, fullName, file));
            if (old != null) {
                this.descriptorsByName.put(fullName, old);
                if (!(old instanceof PackageDescriptor)) {
                    throw new DescriptorValidationException(file, String.valueOf('\"') + name + "\" is already defined (as something other than a package) in file \"" + old.getFile().getName() + "\".", (DescriptorValidationException) null);
                }
            }
        }

        private static final class DescriptorIntPair {
            private final GenericDescriptor descriptor;
            private final int number;

            DescriptorIntPair(GenericDescriptor descriptor, int number) {
                this.descriptor = descriptor;
                this.number = number;
            }

            public int hashCode() {
                return (this.descriptor.hashCode() * InterfaceC0507E.EV_GUI_EVENT.eEV_GUI_MAX_EVENT) + this.number;
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof DescriptorIntPair)) {
                    return false;
                }
                DescriptorIntPair other = (DescriptorIntPair) obj;
                return this.descriptor == other.descriptor && this.number == other.number;
            }
        }

        void addFieldByNumber(FieldDescriptor field) throws DescriptorValidationException {
            DescriptorIntPair key = new DescriptorIntPair(field.getContainingType(), field.getNumber());
            FieldDescriptor old = this.fieldsByNumber.put(key, field);
            if (old != null) {
                this.fieldsByNumber.put(key, old);
                throw new DescriptorValidationException((GenericDescriptor) field, "Field number " + field.getNumber() + "has already been used in \"" + field.getContainingType().getFullName() + "\" by field \"" + old.getName() + "\".", (DescriptorValidationException) null);
            }
        }

        void addEnumValueByNumber(EnumValueDescriptor value) {
            DescriptorIntPair key = new DescriptorIntPair(value.getType(), value.getNumber());
            EnumValueDescriptor old = this.enumValuesByNumber.put(key, value);
            if (old != null) {
                this.enumValuesByNumber.put(key, old);
            }
        }

        static void validateSymbolName(GenericDescriptor descriptor) throws DescriptorValidationException {
            DescriptorValidationException descriptorValidationException = null;
            String name = descriptor.getName();
            if (name.length() == 0) {
                throw new DescriptorValidationException(descriptor, "Missing name.", descriptorValidationException);
            }
            boolean valid = true;
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                if (c >= 128) {
                    valid = false;
                }
                if (!Character.isLetter(c) && c != '_' && (!Character.isDigit(c) || i <= 0)) {
                    valid = false;
                }
            }
            if (!valid) {
                throw new DescriptorValidationException(descriptor, String.valueOf('\"') + name + "\" is not a valid identifier.", descriptorValidationException);
            }
        }
    }
}
