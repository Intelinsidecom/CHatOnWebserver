package com.nuance.nmsp.client.sdk.components.resource.nmas;

/* loaded from: classes.dex */
public interface Sequence {
    public static final String INDEX_IS_OF_WRONG_TYPE = "index is of wrong type.";

    void addAsciiString(String str);

    void addByteString(byte[] bArr);

    void addDictionary(Dictionary dictionary);

    void addInteger(int i);

    void addSequence(Sequence sequence);

    void addUTF8String(String str);

    String getAsciiString(int i);

    byte[] getByteString(int i);

    Dictionary getDictionary(int i);

    int getInteger(int i);

    Sequence getSequence(int i);

    short getType(int i);

    String getUTF8String(int i);

    int size();
}
