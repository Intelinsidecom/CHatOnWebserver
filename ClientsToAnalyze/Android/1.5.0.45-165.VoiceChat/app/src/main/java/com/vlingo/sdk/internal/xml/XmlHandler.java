package com.vlingo.sdk.internal.xml;

/* loaded from: classes.dex */
public interface XmlHandler {
    void beginDocument();

    void beginElement(int i, XmlAttributes xmlAttributes, char[] cArr, int i2);

    void characters(char[] cArr);

    void endDocument();

    void endElement(int i, int i2);
}
