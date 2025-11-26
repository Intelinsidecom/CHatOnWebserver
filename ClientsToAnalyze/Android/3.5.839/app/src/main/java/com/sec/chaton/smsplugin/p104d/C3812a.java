package com.sec.chaton.smsplugin.p104d;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

/* compiled from: AttrImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.a */
/* loaded from: classes.dex */
public class C3812a extends AbstractC3845e implements Attr {

    /* renamed from: b */
    private String f13676b;

    /* renamed from: c */
    private String f13677c;

    protected C3812a(AbstractC3816b abstractC3816b, String str) {
        super(abstractC3816b);
        this.f13676b = str;
    }

    @Override // org.w3c.dom.Attr
    public String getName() {
        return this.f13676b;
    }

    @Override // org.w3c.dom.Attr
    public Element getOwnerElement() {
        return null;
    }

    @Override // org.w3c.dom.Attr
    public boolean getSpecified() {
        return this.f13677c != null;
    }

    @Override // org.w3c.dom.Attr
    public String getValue() {
        return this.f13677c;
    }

    @Override // org.w3c.dom.Attr
    public void setValue(String str) {
        this.f13677c = str;
    }

    @Override // org.w3c.dom.Node
    public String getNodeName() {
        return this.f13676b;
    }

    @Override // org.w3c.dom.Node
    public short getNodeType() {
        return (short) 2;
    }

    @Override // com.sec.chaton.smsplugin.p104d.AbstractC3845e, org.w3c.dom.Node
    public Node getParentNode() {
        return null;
    }

    @Override // com.sec.chaton.smsplugin.p104d.AbstractC3845e, org.w3c.dom.Node
    public Node getPreviousSibling() {
        return null;
    }

    @Override // com.sec.chaton.smsplugin.p104d.AbstractC3845e, org.w3c.dom.Node
    public Node getNextSibling() {
        return null;
    }

    @Override // com.sec.chaton.smsplugin.p104d.AbstractC3845e, org.w3c.dom.Node
    public void setNodeValue(String str) {
        setValue(str);
    }

    @Override // org.w3c.dom.Attr
    public TypeInfo getSchemaTypeInfo() {
        return null;
    }

    @Override // org.w3c.dom.Attr
    public boolean isId() {
        return false;
    }
}
