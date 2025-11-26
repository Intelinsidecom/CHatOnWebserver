package com.vlingo.sdk.internal.xml;

import com.vlingo.sdk.internal.util.ToIntHashtable;
import com.vlingo.sdk.internal.util.ToIntHashtableFactory;

/* loaded from: classes.dex */
public abstract class SimpleXmlParser implements XmlHandler {
    private byte elementIndex = 50;
    private byte attributeIndex = 1;
    final ToIntHashtable xmlElements = ToIntHashtableFactory.createNewHashtable();
    final ToIntHashtable xmlAttributes = ToIntHashtableFactory.createNewHashtable();

    protected SimpleXmlParser() {
    }

    protected int registerElement(String tagName) {
        if (this.xmlElements.containsKey(tagName)) {
            return this.xmlElements.get(tagName);
        }
        this.elementIndex = (byte) (this.elementIndex + 1);
        this.xmlElements.put(tagName, this.elementIndex);
        return this.elementIndex;
    }

    protected int registerAttribute(String attrName) {
        if (this.xmlAttributes.containsKey(attrName)) {
            return this.xmlAttributes.get(attrName);
        }
        this.attributeIndex = (byte) (this.attributeIndex + 1);
        this.xmlAttributes.put(attrName, this.attributeIndex);
        return this.attributeIndex;
    }

    public void parseXML(String xml) {
        char[] chars = xml.toCharArray();
        onParseBegin(chars);
        XmlParser parser = new XmlParser(chars, 0, chars.length, this, this.xmlElements, this.xmlAttributes, true, false);
        parser.parseXml();
    }

    public void onParseBegin(char[] xml) {
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void beginDocument() {
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void endDocument() {
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void characters(char[] cData) {
    }
}
