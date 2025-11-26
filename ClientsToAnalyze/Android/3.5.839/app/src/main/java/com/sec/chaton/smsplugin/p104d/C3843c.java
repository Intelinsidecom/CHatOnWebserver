package com.sec.chaton.smsplugin.p104d;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;

/* compiled from: ElementImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.c */
/* loaded from: classes.dex */
public class C3843c extends AbstractC3845e implements Element {

    /* renamed from: b */
    private String f13738b;

    /* renamed from: c */
    private NamedNodeMap f13739c;

    protected C3843c(AbstractC3816b abstractC3816b, String str) {
        super(abstractC3816b);
        this.f13739c = new C3844d();
        this.f13738b = str;
    }

    @Override // org.w3c.dom.Element
    public String getAttribute(String str) {
        Attr attributeNode = getAttributeNode(str);
        if (attributeNode == null) {
            return "";
        }
        return attributeNode.getValue();
    }

    @Override // org.w3c.dom.Element
    public String getAttributeNS(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.Element
    public Attr getAttributeNode(String str) {
        return (Attr) this.f13739c.getNamedItem(str);
    }

    @Override // org.w3c.dom.Element
    public Attr getAttributeNodeNS(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.Element
    public NodeList getElementsByTagName(String str) {
        return new C3846f(this, str, true);
    }

    @Override // org.w3c.dom.Element
    public NodeList getElementsByTagNameNS(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.Element
    public String getTagName() {
        return this.f13738b;
    }

    @Override // org.w3c.dom.Element
    public boolean hasAttribute(String str) {
        return getAttributeNode(str) != null;
    }

    @Override // org.w3c.dom.Element
    public boolean hasAttributeNS(String str, String str2) {
        return false;
    }

    @Override // org.w3c.dom.Element
    public void removeAttribute(String str) {
    }

    @Override // org.w3c.dom.Element
    public void removeAttributeNS(String str, String str2) {
    }

    @Override // org.w3c.dom.Element
    public Attr removeAttributeNode(Attr attr) {
        return null;
    }

    @Override // org.w3c.dom.Element
    public void setAttribute(String str, String str2) throws DOMException {
        Attr attributeNode = getAttributeNode(str);
        if (attributeNode == null) {
            attributeNode = this.f13741a.createAttribute(str);
        }
        attributeNode.setNodeValue(str2);
        this.f13739c.setNamedItem(attributeNode);
    }

    @Override // org.w3c.dom.Element
    public void setAttributeNS(String str, String str2, String str3) {
    }

    @Override // org.w3c.dom.Element
    public Attr setAttributeNode(Attr attr) {
        return null;
    }

    @Override // org.w3c.dom.Element
    public Attr setAttributeNodeNS(Attr attr) {
        return null;
    }

    @Override // org.w3c.dom.Node
    public short getNodeType() {
        return (short) 1;
    }

    @Override // org.w3c.dom.Node
    public String getNodeName() {
        return this.f13738b;
    }

    @Override // com.sec.chaton.smsplugin.p104d.AbstractC3845e, org.w3c.dom.Node
    public NamedNodeMap getAttributes() {
        return this.f13739c;
    }

    @Override // com.sec.chaton.smsplugin.p104d.AbstractC3845e, org.w3c.dom.Node
    public boolean hasAttributes() {
        return this.f13739c.getLength() > 0;
    }

    @Override // org.w3c.dom.Element
    public TypeInfo getSchemaTypeInfo() {
        return null;
    }

    @Override // org.w3c.dom.Element
    public void setIdAttribute(String str, boolean z) {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Element
    public void setIdAttributeNS(String str, String str2, boolean z) {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Element
    public void setIdAttributeNode(Attr attr, boolean z) {
        throw new DOMException((short) 9, null);
    }
}
