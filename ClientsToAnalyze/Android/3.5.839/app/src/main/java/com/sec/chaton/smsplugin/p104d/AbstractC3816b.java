package com.sec.chaton.smsplugin.p104d;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

/* compiled from: DocumentImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.b */
/* loaded from: classes.dex */
public abstract class AbstractC3816b extends AbstractC3845e implements Document {
    public AbstractC3816b() {
        super(null);
    }

    @Override // org.w3c.dom.Document
    public Attr createAttribute(String str) {
        return new C3812a(this, str);
    }

    @Override // org.w3c.dom.Document
    public Attr createAttributeNS(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public CDATASection createCDATASection(String str) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public Comment createComment(String str) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public DocumentFragment createDocumentFragment() {
        return null;
    }

    @Override // org.w3c.dom.Document
    public Element createElementNS(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public EntityReference createEntityReference(String str) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public ProcessingInstruction createProcessingInstruction(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public Text createTextNode(String str) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public DocumentType getDoctype() {
        return null;
    }

    @Override // org.w3c.dom.Document
    public Element getElementById(String str) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public NodeList getElementsByTagName(String str) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public NodeList getElementsByTagNameNS(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.Document
    public DOMImplementation getImplementation() {
        return null;
    }

    @Override // org.w3c.dom.Document
    public Node importNode(Node node, boolean z) {
        return null;
    }

    @Override // org.w3c.dom.Node
    public short getNodeType() {
        return (short) 9;
    }

    @Override // org.w3c.dom.Node
    public String getNodeName() {
        return "#document";
    }

    @Override // org.w3c.dom.Document
    public String getInputEncoding() {
        return null;
    }

    @Override // org.w3c.dom.Document
    public String getXmlEncoding() {
        return null;
    }

    @Override // org.w3c.dom.Document
    public boolean getXmlStandalone() {
        return false;
    }

    @Override // org.w3c.dom.Document
    public void setXmlStandalone(boolean z) {
    }

    @Override // org.w3c.dom.Document
    public String getXmlVersion() {
        return null;
    }

    @Override // org.w3c.dom.Document
    public void setXmlVersion(String str) {
    }

    @Override // org.w3c.dom.Document
    public boolean getStrictErrorChecking() {
        return true;
    }

    @Override // org.w3c.dom.Document
    public void setStrictErrorChecking(boolean z) {
    }

    @Override // org.w3c.dom.Document
    public String getDocumentURI() {
        return null;
    }

    @Override // org.w3c.dom.Document
    public void setDocumentURI(String str) {
    }

    @Override // org.w3c.dom.Document
    public Node adoptNode(Node node) {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Document
    public DOMConfiguration getDomConfig() {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Document
    public void normalizeDocument() {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Document
    public Node renameNode(Node node, String str, String str2) {
        throw new DOMException((short) 9, null);
    }
}
