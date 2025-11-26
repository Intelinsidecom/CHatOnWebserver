package com.vlingo.sdk.internal.xml;

/* loaded from: classes.dex */
public class XmlAttribute {
    private final int attributeType;
    private final String attributeValue;

    public XmlAttribute(int attributeType, String attributeValue) {
        this.attributeType = attributeType;
        this.attributeValue = attributeValue;
    }

    public int getType() {
        return this.attributeType;
    }

    public String getValue() {
        return this.attributeValue;
    }
}
