package com.nuance.nmsp.client.sdk.components.resource.nmas;

import java.util.Enumeration;

/* loaded from: classes.dex */
public interface Dictionary {
    public static final String KEY_DOES_NOT_EXIST = "key does not exist. ";
    public static final String KEY_IS_OF_WRONG_TYPE = "key is of wrong type. ";

    void addAsciiString(String str, String str2);

    void addByteString(String str, byte[] bArr);

    void addDictionary(String str, Dictionary dictionary);

    void addInteger(String str, int i);

    void addSequence(String str, Sequence sequence);

    void addUTF8String(String str, String str2);

    boolean containsKey(String str);

    String getAsciiString(String str);

    byte[] getByteString(String str);

    Dictionary getDictionary(String str);

    int getInteger(String str);

    Sequence getSequence(String str);

    short getType(String str);

    String getUTF8String(String str);

    Enumeration keys();
}
