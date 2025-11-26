package com.vlingo.sdk.internal.xml;

import com.vlingo.sdk.internal.util.ToIntHashtable;
import java.util.Vector;

/* loaded from: classes.dex */
public class XmlAttributes {
    public static final byte ATTRIBUTE_UNDEF = 0;
    private Vector<XmlAttribute> attributeList;
    private ToIntHashtable xmlAttributes;

    public XmlAttributes(int initialCapacity, ToIntHashtable xmlAttributes) {
        this.xmlAttributes = xmlAttributes;
        this.attributeList = new Vector<>(initialCapacity);
    }

    public XmlAttributes(ToIntHashtable xmlAttributes) {
        this.xmlAttributes = xmlAttributes;
        this.attributeList = new Vector<>();
    }

    public void add(byte type, String value) {
        this.attributeList.addElement(new XmlAttribute(type, value));
    }

    public byte getAttributeType(char[] data, int offset, int len) {
        String name = String.valueOf(data, offset, len);
        if (this.xmlAttributes.containsKey(name)) {
            return (byte) this.xmlAttributes.get(name);
        }
        return (byte) 0;
    }

    public int getLength() {
        return this.attributeList.size();
    }

    public int getType(int index) {
        XmlAttribute attribute;
        if (index >= this.attributeList.size() || (attribute = this.attributeList.elementAt(index)) == null) {
            return -1;
        }
        return attribute.getType();
    }

    public String getValue(int index) {
        XmlAttribute attribute;
        if (index >= this.attributeList.size() || (attribute = this.attributeList.elementAt(index)) == null) {
            return null;
        }
        return attribute.getValue();
    }

    public String lookup(int key) {
        for (int i = 0; i < this.attributeList.size(); i++) {
            XmlAttribute attribute = this.attributeList.elementAt(i);
            if (attribute != null && attribute.getType() == key) {
                return attribute.getValue();
            }
        }
        return null;
    }

    public XmlAttribute getAttribute(int index) {
        return this.attributeList.elementAt(index);
    }
}
