package com.google.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class UnknownFieldSet implements MessageLite {
    private static final UnknownFieldSet defaultInstance = new UnknownFieldSet(Collections.emptyMap());
    private Map<Integer, Field> fields;

    private UnknownFieldSet() {
    }

    public static Builder newBuilder() {
        return Builder.create();
    }

    public static Builder newBuilder(UnknownFieldSet copyFrom) {
        return newBuilder().mergeFrom(copyFrom);
    }

    public static UnknownFieldSet getDefaultInstance() {
        return defaultInstance;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getDefaultInstanceForType() {
        return defaultInstance;
    }

    private UnknownFieldSet(Map<Integer, Field> fields) {
        this.fields = fields;
    }

    /* synthetic */ UnknownFieldSet(Map map, UnknownFieldSet unknownFieldSet) {
        this(map);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UnknownFieldSet) && this.fields.equals(((UnknownFieldSet) other).fields);
    }

    public int hashCode() {
        return this.fields.hashCode();
    }

    public Map<Integer, Field> asMap() {
        return this.fields;
    }

    public boolean hasField(int number) {
        return this.fields.containsKey(Integer.valueOf(number));
    }

    public Field getField(int number) {
        Field result = this.fields.get(Integer.valueOf(number));
        return result == null ? Field.getDefaultInstance() : result;
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream output) throws IOException {
        for (Map.Entry<Integer, Field> entry : this.fields.entrySet()) {
            entry.getValue().writeTo(entry.getKey().intValue(), output);
        }
    }

    public String toString() {
        return TextFormat.printToString(this);
    }

    @Override // com.google.protobuf.MessageLite
    public ByteString toByteString() {
        try {
            ByteString.CodedBuilder out = ByteString.newCodedBuilder(getSerializedSize());
            writeTo(out.getCodedOutput());
            return out.build();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        try {
            byte[] result = new byte[getSerializedSize()];
            CodedOutputStream output = CodedOutputStream.newInstance(result);
            writeTo(output);
            output.checkNoSpaceLeft();
            return result;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(OutputStream output) throws IOException {
        CodedOutputStream codedOutput = CodedOutputStream.newInstance(output);
        writeTo(codedOutput);
        codedOutput.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeDelimitedTo(OutputStream output) throws IOException {
        CodedOutputStream codedOutput = CodedOutputStream.newInstance(output);
        codedOutput.writeRawVarint32(getSerializedSize());
        writeTo(codedOutput);
        codedOutput.flush();
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int result = 0;
        for (Map.Entry<Integer, Field> entry : this.fields.entrySet()) {
            result += entry.getValue().getSerializedSize(entry.getKey().intValue());
        }
        return result;
    }

    public void writeAsMessageSetTo(CodedOutputStream output) throws IOException {
        for (Map.Entry<Integer, Field> entry : this.fields.entrySet()) {
            entry.getValue().writeAsMessageSetExtensionTo(entry.getKey().intValue(), output);
        }
    }

    public int getSerializedSizeAsMessageSet() {
        int result = 0;
        for (Map.Entry<Integer, Field> entry : this.fields.entrySet()) {
            result += entry.getValue().getSerializedSizeAsMessageSetExtension(entry.getKey().intValue());
        }
        return result;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        return true;
    }

    public static UnknownFieldSet parseFrom(CodedInputStream input) throws IOException {
        return newBuilder().mergeFrom(input).build();
    }

    public static UnknownFieldSet parseFrom(ByteString data) throws InvalidProtocolBufferException {
        return newBuilder().mergeFrom(data).build();
    }

    public static UnknownFieldSet parseFrom(byte[] data) throws InvalidProtocolBufferException {
        return newBuilder().mergeFrom(data).build();
    }

    public static UnknownFieldSet parseFrom(InputStream input) throws IOException {
        return newBuilder().mergeFrom(input).build();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return newBuilder().mergeFrom(this);
    }

    public static final class Builder implements MessageLite.Builder {
        private Map<Integer, Field> fields;
        private Field.Builder lastField;
        private int lastFieldNumber;

        private Builder() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Builder create() {
            Builder builder = new Builder();
            builder.reinitialize();
            return builder;
        }

        private Field.Builder getFieldBuilder(int number) {
            if (this.lastField != null) {
                if (number == this.lastFieldNumber) {
                    return this.lastField;
                }
                addField(this.lastFieldNumber, this.lastField.build());
            }
            if (number == 0) {
                return null;
            }
            Field existing = this.fields.get(Integer.valueOf(number));
            this.lastFieldNumber = number;
            this.lastField = Field.newBuilder();
            if (existing != null) {
                this.lastField.mergeFrom(existing);
            }
            return this.lastField;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UnknownFieldSet build() {
            UnknownFieldSet result;
            UnknownFieldSet unknownFieldSet = null;
            getFieldBuilder(0);
            if (this.fields.isEmpty()) {
                result = UnknownFieldSet.getDefaultInstance();
            } else {
                result = new UnknownFieldSet(Collections.unmodifiableMap(this.fields), unknownFieldSet);
            }
            this.fields = null;
            return result;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public UnknownFieldSet buildPartial() {
            return build();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        /* renamed from: clone, reason: merged with bridge method [inline-methods] */
        public Builder m3102clone() {
            getFieldBuilder(0);
            return UnknownFieldSet.newBuilder().mergeFrom(new UnknownFieldSet(this.fields, null));
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UnknownFieldSet getDefaultInstanceForType() {
            return UnknownFieldSet.getDefaultInstance();
        }

        private void reinitialize() {
            this.fields = Collections.emptyMap();
            this.lastFieldNumber = 0;
            this.lastField = null;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            reinitialize();
            return this;
        }

        public Builder mergeFrom(UnknownFieldSet other) {
            if (other != UnknownFieldSet.getDefaultInstance()) {
                for (Map.Entry<Integer, Field> entry : other.fields.entrySet()) {
                    mergeField(entry.getKey().intValue(), entry.getValue());
                }
            }
            return this;
        }

        public Builder mergeField(int number, Field field) {
            if (number == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            if (hasField(number)) {
                getFieldBuilder(number).mergeFrom(field);
            } else {
                addField(number, field);
            }
            return this;
        }

        public Builder mergeVarintField(int number, int value) {
            if (number == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            getFieldBuilder(number).addVarint(value);
            return this;
        }

        public boolean hasField(int number) {
            if (number == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            return number == this.lastFieldNumber || this.fields.containsKey(Integer.valueOf(number));
        }

        public Builder addField(int number, Field field) {
            if (number == 0) {
                throw new IllegalArgumentException("Zero is not a valid field number.");
            }
            if (this.lastField != null && this.lastFieldNumber == number) {
                this.lastField = null;
                this.lastFieldNumber = 0;
            }
            if (this.fields.isEmpty()) {
                this.fields = new TreeMap();
            }
            this.fields.put(Integer.valueOf(number), field);
            return this;
        }

        public Map<Integer, Field> asMap() {
            getFieldBuilder(0);
            return Collections.unmodifiableMap(this.fields);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream input) throws IOException {
            int tag;
            do {
                tag = input.readTag();
                if (tag == 0) {
                    break;
                }
            } while (mergeFieldFrom(tag, input));
            return this;
        }

        public boolean mergeFieldFrom(int tag, CodedInputStream input) throws IOException {
            int number = WireFormat.getTagFieldNumber(tag);
            switch (WireFormat.getTagWireType(tag)) {
                case 0:
                    getFieldBuilder(number).addVarint(input.readInt64());
                    return true;
                case 1:
                    getFieldBuilder(number).addFixed64(input.readFixed64());
                    return true;
                case 2:
                    getFieldBuilder(number).addLengthDelimited(input.readBytes());
                    return true;
                case 3:
                    Builder subBuilder = UnknownFieldSet.newBuilder();
                    input.readGroup(number, subBuilder, ExtensionRegistry.getEmptyRegistry());
                    getFieldBuilder(number).addGroup(subBuilder.build());
                    return true;
                case 4:
                    return false;
                case 5:
                    getFieldBuilder(number).addFixed32(input.readFixed32());
                    return true;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(ByteString data) throws InvalidProtocolBufferException {
            try {
                CodedInputStream input = data.newCodedInput();
                mergeFrom(input);
                input.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e2);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] data) throws InvalidProtocolBufferException {
            try {
                CodedInputStream input = CodedInputStream.newInstance(data);
                mergeFrom(input);
                input.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(InputStream input) throws IOException {
            CodedInputStream codedInput = CodedInputStream.newInstance(input);
            mergeFrom(codedInput);
            codedInput.checkLastTagWas(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream input) throws IOException {
            int firstByte = input.read();
            if (firstByte == -1) {
                return false;
            }
            int size = CodedInputStream.readRawVarint32(firstByte, input);
            InputStream limitedInput = new AbstractMessageLite.Builder.LimitedInputStream(input, size);
            mergeFrom(limitedInput);
            return true;
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public boolean mergeDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return mergeDelimitedFrom(input);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return mergeFrom(input);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return mergeFrom(data);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] data, int off, int len) throws InvalidProtocolBufferException {
            try {
                CodedInputStream input = CodedInputStream.newInstance(data, off, len);
                mergeFrom(input);
                input.checkLastTagWas(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return mergeFrom(data);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(byte[] data, int off, int len, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return mergeFrom(data, off, len);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder mergeFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return mergeFrom(input);
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return true;
        }
    }

    public static final class Field {
        private static final Field fieldDefaultInstance = newBuilder().build();
        private List<Integer> fixed32;
        private List<Long> fixed64;
        private List<UnknownFieldSet> group;
        private List<ByteString> lengthDelimited;
        private List<Long> varint;

        private Field() {
        }

        /* synthetic */ Field(Field field) {
            this();
        }

        public static Builder newBuilder() {
            return Builder.create();
        }

        public static Builder newBuilder(Field copyFrom) {
            return newBuilder().mergeFrom(copyFrom);
        }

        public static Field getDefaultInstance() {
            return fieldDefaultInstance;
        }

        public List<Long> getVarintList() {
            return this.varint;
        }

        public List<Integer> getFixed32List() {
            return this.fixed32;
        }

        public List<Long> getFixed64List() {
            return this.fixed64;
        }

        public List<ByteString> getLengthDelimitedList() {
            return this.lengthDelimited;
        }

        public List<UnknownFieldSet> getGroupList() {
            return this.group;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Field)) {
                return false;
            }
            return Arrays.equals(getIdentityArray(), ((Field) other).getIdentityArray());
        }

        public int hashCode() {
            return Arrays.hashCode(getIdentityArray());
        }

        private Object[] getIdentityArray() {
            return new Object[]{this.varint, this.fixed32, this.fixed64, this.lengthDelimited, this.group};
        }

        public void writeTo(int fieldNumber, CodedOutputStream output) throws IOException {
            Iterator<Long> it = this.varint.iterator();
            while (it.hasNext()) {
                long value = it.next().longValue();
                output.writeUInt64(fieldNumber, value);
            }
            Iterator<Integer> it2 = this.fixed32.iterator();
            while (it2.hasNext()) {
                int value2 = it2.next().intValue();
                output.writeFixed32(fieldNumber, value2);
            }
            Iterator<Long> it3 = this.fixed64.iterator();
            while (it3.hasNext()) {
                long value3 = it3.next().longValue();
                output.writeFixed64(fieldNumber, value3);
            }
            for (ByteString value4 : this.lengthDelimited) {
                output.writeBytes(fieldNumber, value4);
            }
            for (UnknownFieldSet value5 : this.group) {
                output.writeGroup(fieldNumber, value5);
            }
        }

        public int getSerializedSize(int fieldNumber) {
            int result = 0;
            Iterator<Long> it = this.varint.iterator();
            while (it.hasNext()) {
                long value = it.next().longValue();
                result += CodedOutputStream.computeUInt64Size(fieldNumber, value);
            }
            Iterator<Integer> it2 = this.fixed32.iterator();
            while (it2.hasNext()) {
                int value2 = it2.next().intValue();
                result += CodedOutputStream.computeFixed32Size(fieldNumber, value2);
            }
            Iterator<Long> it3 = this.fixed64.iterator();
            while (it3.hasNext()) {
                long value3 = it3.next().longValue();
                result += CodedOutputStream.computeFixed64Size(fieldNumber, value3);
            }
            for (ByteString value4 : this.lengthDelimited) {
                result += CodedOutputStream.computeBytesSize(fieldNumber, value4);
            }
            for (UnknownFieldSet value5 : this.group) {
                result += CodedOutputStream.computeGroupSize(fieldNumber, value5);
            }
            return result;
        }

        public void writeAsMessageSetExtensionTo(int fieldNumber, CodedOutputStream output) throws IOException {
            for (ByteString value : this.lengthDelimited) {
                output.writeRawMessageSetExtension(fieldNumber, value);
            }
        }

        public int getSerializedSizeAsMessageSetExtension(int fieldNumber) {
            int result = 0;
            for (ByteString value : this.lengthDelimited) {
                result += CodedOutputStream.computeRawMessageSetExtensionSize(fieldNumber, value);
            }
            return result;
        }

        public static final class Builder {
            private Field result;

            private Builder() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static Builder create() {
                Builder builder = new Builder();
                builder.result = new Field(null);
                return builder;
            }

            public Field build() {
                if (this.result.varint == null) {
                    this.result.varint = Collections.emptyList();
                } else {
                    this.result.varint = Collections.unmodifiableList(this.result.varint);
                }
                if (this.result.fixed32 == null) {
                    this.result.fixed32 = Collections.emptyList();
                } else {
                    this.result.fixed32 = Collections.unmodifiableList(this.result.fixed32);
                }
                if (this.result.fixed64 == null) {
                    this.result.fixed64 = Collections.emptyList();
                } else {
                    this.result.fixed64 = Collections.unmodifiableList(this.result.fixed64);
                }
                if (this.result.lengthDelimited == null) {
                    this.result.lengthDelimited = Collections.emptyList();
                } else {
                    this.result.lengthDelimited = Collections.unmodifiableList(this.result.lengthDelimited);
                }
                if (this.result.group == null) {
                    this.result.group = Collections.emptyList();
                } else {
                    this.result.group = Collections.unmodifiableList(this.result.group);
                }
                Field returnMe = this.result;
                this.result = null;
                return returnMe;
            }

            public Builder clear() {
                this.result = new Field(null);
                return this;
            }

            public Builder mergeFrom(Field other) {
                if (!other.varint.isEmpty()) {
                    if (this.result.varint == null) {
                        this.result.varint = new ArrayList();
                    }
                    this.result.varint.addAll(other.varint);
                }
                if (!other.fixed32.isEmpty()) {
                    if (this.result.fixed32 == null) {
                        this.result.fixed32 = new ArrayList();
                    }
                    this.result.fixed32.addAll(other.fixed32);
                }
                if (!other.fixed64.isEmpty()) {
                    if (this.result.fixed64 == null) {
                        this.result.fixed64 = new ArrayList();
                    }
                    this.result.fixed64.addAll(other.fixed64);
                }
                if (!other.lengthDelimited.isEmpty()) {
                    if (this.result.lengthDelimited == null) {
                        this.result.lengthDelimited = new ArrayList();
                    }
                    this.result.lengthDelimited.addAll(other.lengthDelimited);
                }
                if (!other.group.isEmpty()) {
                    if (this.result.group == null) {
                        this.result.group = new ArrayList();
                    }
                    this.result.group.addAll(other.group);
                }
                return this;
            }

            public Builder addVarint(long value) {
                if (this.result.varint == null) {
                    this.result.varint = new ArrayList();
                }
                this.result.varint.add(Long.valueOf(value));
                return this;
            }

            public Builder addFixed32(int value) {
                if (this.result.fixed32 == null) {
                    this.result.fixed32 = new ArrayList();
                }
                this.result.fixed32.add(Integer.valueOf(value));
                return this;
            }

            public Builder addFixed64(long value) {
                if (this.result.fixed64 == null) {
                    this.result.fixed64 = new ArrayList();
                }
                this.result.fixed64.add(Long.valueOf(value));
                return this;
            }

            public Builder addLengthDelimited(ByteString value) {
                if (this.result.lengthDelimited == null) {
                    this.result.lengthDelimited = new ArrayList();
                }
                this.result.lengthDelimited.add(value);
                return this;
            }

            public Builder addGroup(UnknownFieldSet value) {
                if (this.result.group == null) {
                    this.result.group = new ArrayList();
                }
                this.result.group.add(value);
                return this;
            }
        }
    }
}
