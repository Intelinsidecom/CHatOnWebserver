package com.sec.chaton.smsplugin.p104d;

import com.sec.chaton.smsplugin.p104d.p105a.C3814b;
import java.util.NoSuchElementException;
import java.util.Vector;
import org.p146b.p147a.p148a.InterfaceC5237b;
import org.p146b.p147a.p148a.InterfaceC5239d;
import org.p146b.p147a.p148a.InterfaceC5240e;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

/* compiled from: NodeImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.e */
/* loaded from: classes.dex */
public abstract class AbstractC3845e implements InterfaceC5240e, Node {

    /* renamed from: a */
    AbstractC3816b f13741a;

    /* renamed from: b */
    private Node f13742b;

    /* renamed from: c */
    private final Vector<Node> f13743c = new Vector<>();

    /* renamed from: d */
    private final InterfaceC5240e f13744d = new C3814b(this);

    protected AbstractC3845e(AbstractC3816b abstractC3816b) {
        this.f13741a = abstractC3816b;
    }

    @Override // org.w3c.dom.Node
    public Node appendChild(Node node) {
        ((AbstractC3845e) node).m14615a(this);
        this.f13743c.remove(node);
        this.f13743c.add(node);
        return node;
    }

    @Override // org.w3c.dom.Node
    public Node cloneNode(boolean z) {
        return null;
    }

    public NamedNodeMap getAttributes() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public NodeList getChildNodes() {
        return new C3846f(this, null, false);
    }

    @Override // org.w3c.dom.Node
    public Node getFirstChild() {
        try {
            return this.f13743c.firstElement();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override // org.w3c.dom.Node
    public Node getLastChild() {
        try {
            return this.f13743c.lastElement();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    @Override // org.w3c.dom.Node
    public String getLocalName() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public String getNamespaceURI() {
        return null;
    }

    public Node getNextSibling() {
        if (this.f13742b == null || this == this.f13742b.getLastChild()) {
            return null;
        }
        Vector<Node> vector = ((AbstractC3845e) this.f13742b).f13743c;
        return vector.elementAt(vector.indexOf(this) + 1);
    }

    @Override // org.w3c.dom.Node
    public String getNodeValue() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public Document getOwnerDocument() {
        return this.f13741a;
    }

    public Node getParentNode() {
        return this.f13742b;
    }

    @Override // org.w3c.dom.Node
    public String getPrefix() {
        return null;
    }

    public Node getPreviousSibling() {
        if (this.f13742b == null || this == this.f13742b.getFirstChild()) {
            return null;
        }
        return ((AbstractC3845e) this.f13742b).f13743c.elementAt(r0.indexOf(this) - 1);
    }

    public boolean hasAttributes() {
        return false;
    }

    @Override // org.w3c.dom.Node
    public boolean hasChildNodes() {
        return !this.f13743c.isEmpty();
    }

    @Override // org.w3c.dom.Node
    public Node insertBefore(Node node, Node node2) {
        return null;
    }

    @Override // org.w3c.dom.Node
    public boolean isSupported(String str, String str2) {
        return false;
    }

    @Override // org.w3c.dom.Node
    public void normalize() {
    }

    @Override // org.w3c.dom.Node
    public Node removeChild(Node node) {
        if (this.f13743c.contains(node)) {
            this.f13743c.remove(node);
            ((AbstractC3845e) node).m14615a((Node) null);
            return null;
        }
        throw new DOMException((short) 8, "Child does not exist");
    }

    @Override // org.w3c.dom.Node
    public Node replaceChild(Node node, Node node2) {
        if (this.f13743c.contains(node2)) {
            try {
                this.f13743c.remove(node);
            } catch (DOMException e) {
            }
            this.f13743c.setElementAt(node, this.f13743c.indexOf(node2));
            ((AbstractC3845e) node).m14615a(this);
            ((AbstractC3845e) node2).m14615a((Node) null);
            return node2;
        }
        throw new DOMException((short) 8, "Old child does not exist");
    }

    public void setNodeValue(String str) {
    }

    @Override // org.w3c.dom.Node
    public void setPrefix(String str) {
    }

    /* renamed from: a */
    private void m14615a(Node node) {
        this.f13742b = node;
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5240e
    /* renamed from: a */
    public void mo14500a(String str, InterfaceC5239d interfaceC5239d, boolean z) {
        this.f13744d.mo14500a(str, interfaceC5239d, z);
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5240e
    /* renamed from: b */
    public void mo14502b(String str, InterfaceC5239d interfaceC5239d, boolean z) {
        this.f13744d.mo14502b(str, interfaceC5239d, z);
    }

    @Override // org.p146b.p147a.p148a.InterfaceC5240e
    /* renamed from: a */
    public boolean mo14501a(InterfaceC5237b interfaceC5237b) {
        return this.f13744d.mo14501a(interfaceC5237b);
    }

    @Override // org.w3c.dom.Node
    public String getBaseURI() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public short compareDocumentPosition(Node node) {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Node
    public String getTextContent() {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Node
    public void setTextContent(String str) {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Node
    public boolean isSameNode(Node node) {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Node
    public String lookupPrefix(String str) {
        return null;
    }

    @Override // org.w3c.dom.Node
    public boolean isDefaultNamespace(String str) {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Node
    public String lookupNamespaceURI(String str) {
        return null;
    }

    @Override // org.w3c.dom.Node
    public boolean isEqualNode(Node node) {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Node
    public Object getFeature(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.Node
    public Object setUserData(String str, Object obj, UserDataHandler userDataHandler) {
        throw new DOMException((short) 9, null);
    }

    @Override // org.w3c.dom.Node
    public Object getUserData(String str) {
        return null;
    }
}
