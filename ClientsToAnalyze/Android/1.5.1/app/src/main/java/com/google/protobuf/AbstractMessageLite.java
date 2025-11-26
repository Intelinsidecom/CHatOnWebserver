package com.google.protobuf;

import com.google.protobuf.MessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class AbstractMessageLite implements MessageLite {

    public abstract class Builder implements MessageLite.Builder {
        protected static void addAll(Iterable iterable, Collection collection) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == null) {
                    throw new NullPointerException();
                }
            }
            if (iterable instanceof Collection) {
                collection.addAll((Collection) iterable);
                return;
            }
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                collection.add(it2.next());
            }
        }

        protected static UninitializedMessageException newUninitializedMessageException(MessageLite messageLite) {
            return new UninitializedMessageException(messageLite);
        }

        @Override // 
        /* renamed from: clone */
        public abstract Builder mo4397clone();

        public boolean mergeDelimitedFrom(InputStream inputStream) {
            return mergeDelimitedFrom(inputStream, ExtensionRegistryLite.m339a());
        }

        public boolean mergeDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            int i = inputStream.read();
            if (i == -1) {
                return false;
            }
            mergeFrom((InputStream) new C0060h(inputStream, CodedInputStream.m270a(i, inputStream)), extensionRegistryLite);
            return true;
        }

        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m4398mergeFrom(ByteString byteString) throws InvalidProtocolBufferException {
            try {
                CodedInputStream codedInputStreamM269a = byteString.m269a();
                m4400mergeFrom(codedInputStreamM269a);
                codedInputStreamM269a.m277a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e2);
            }
        }

        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m4399mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            try {
                CodedInputStream codedInputStreamM269a = byteString.m269a();
                mergeFrom(codedInputStreamM269a, extensionRegistryLite);
                codedInputStreamM269a.m277a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e2);
            }
        }

        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m4400mergeFrom(CodedInputStream codedInputStream) {
            return mergeFrom(codedInputStream, ExtensionRegistryLite.m339a());
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public abstract Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(InputStream inputStream) throws InvalidProtocolBufferException {
            CodedInputStream codedInputStreamM271a = CodedInputStream.m271a(inputStream);
            m4400mergeFrom(codedInputStreamM271a);
            codedInputStreamM271a.m277a(0);
            return this;
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            CodedInputStream codedInputStreamM271a = CodedInputStream.m271a(inputStream);
            mergeFrom(codedInputStreamM271a, extensionRegistryLite);
            codedInputStreamM271a.m277a(0);
            return this;
        }

        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m4401mergeFrom(byte[] bArr) {
            return mergeFrom(bArr, 0, bArr.length);
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            try {
                CodedInputStream codedInputStreamM273a = CodedInputStream.m273a(bArr, i, i2);
                m4400mergeFrom(codedInputStreamM273a);
                codedInputStreamM273a.m277a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
            }
        }

        @Override // com.google.protobuf.MessageLite.Builder
        public Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            try {
                CodedInputStream codedInputStreamM273a = CodedInputStream.m273a(bArr, i, i2);
                mergeFrom(codedInputStreamM273a, extensionRegistryLite);
                codedInputStreamM273a.m277a(0);
                return this;
            } catch (InvalidProtocolBufferException e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
            }
        }

        /* renamed from: mergeFrom, reason: merged with bridge method [inline-methods] */
        public Builder m4402mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return mergeFrom(bArr, 0, bArr.length, extensionRegistryLite);
        }
    }

    @Override // com.google.protobuf.MessageLite
    public byte[] toByteArray() {
        try {
            byte[] bArr = new byte[getSerializedSize()];
            CodedOutputStream codedOutputStreamM299a = CodedOutputStream.m299a(bArr);
            writeTo(codedOutputStreamM299a);
            codedOutputStreamM299a.m333c();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public ByteString toByteString() {
        try {
            C0058f c0058fM268a = ByteString.m268a(getSerializedSize());
            writeTo(c0058fM268a.m355b());
            return c0058fM268a.m354a();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a ByteString threw an IOException (should never happen).", e);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        CodedOutputStream codedOutputStreamM298a = CodedOutputStream.m298a(outputStream, CodedOutputStream.m296a(CodedOutputStream.m316i(serializedSize) + serializedSize));
        codedOutputStreamM298a.m338h(serializedSize);
        writeTo(codedOutputStreamM298a);
        codedOutputStreamM298a.m317a();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        CodedOutputStream codedOutputStreamM298a = CodedOutputStream.m298a(outputStream, CodedOutputStream.m296a(getSerializedSize()));
        writeTo(codedOutputStreamM298a);
        codedOutputStreamM298a.m317a();
    }
}
