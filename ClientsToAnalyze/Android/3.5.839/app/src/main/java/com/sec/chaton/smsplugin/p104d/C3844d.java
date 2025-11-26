package com.sec.chaton.smsplugin.p104d;

import java.util.Vector;
import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* compiled from: NamedNodeMapImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.d */
/* loaded from: classes.dex */
public class C3844d implements NamedNodeMap {

    /* renamed from: a */
    private Vector<Node> f13740a = new Vector<>();

    @Override // org.w3c.dom.NamedNodeMap
    public int getLength() {
        return this.f13740a.size();
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node getNamedItem(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f13740a.size()) {
                return null;
            }
            if (!str.equals(this.f13740a.elementAt(i2).getNodeName())) {
                i = i2 + 1;
            } else {
                return this.f13740a.elementAt(i2);
            }
        }
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node getNamedItemNS(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node item(int i) {
        if (i < this.f13740a.size()) {
            return this.f13740a.elementAt(i);
        }
        return null;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node removeNamedItem(String str) {
        Node namedItem = getNamedItem(str);
        if (namedItem == null) {
            throw new DOMException((short) 8, "Not found");
        }
        this.f13740a.remove(namedItem);
        return namedItem;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node removeNamedItemNS(String str, String str2) {
        return null;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node setNamedItem(Node node) {
        Node namedItem = getNamedItem(node.getNodeName());
        if (namedItem != null) {
            this.f13740a.remove(namedItem);
        }
        this.f13740a.add(node);
        return namedItem;
    }

    @Override // org.w3c.dom.NamedNodeMap
    public Node setNamedItemNS(Node node) {
        return null;
    }
}
