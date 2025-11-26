package com.sec.chaton.smsplugin.p104d;

import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* compiled from: NodeListImpl.java */
/* renamed from: com.sec.chaton.smsplugin.d.f */
/* loaded from: classes.dex */
public class C3846f implements NodeList {

    /* renamed from: a */
    private ArrayList<Node> f13745a;

    /* renamed from: b */
    private ArrayList<Node> f13746b;

    /* renamed from: c */
    private Node f13747c;

    /* renamed from: d */
    private String f13748d;

    /* renamed from: e */
    private boolean f13749e;

    public C3846f(Node node, String str, boolean z) {
        this.f13747c = node;
        this.f13748d = str;
        this.f13749e = z;
    }

    public C3846f(ArrayList<Node> arrayList) {
        this.f13746b = arrayList;
    }

    @Override // org.w3c.dom.NodeList
    public int getLength() {
        if (this.f13746b != null) {
            return this.f13746b.size();
        }
        m14616a(this.f13747c);
        return this.f13745a.size();
    }

    @Override // org.w3c.dom.NodeList
    public Node item(int i) {
        if (this.f13746b == null) {
            m14616a(this.f13747c);
            try {
                return this.f13745a.get(i);
            } catch (IndexOutOfBoundsException e) {
                return null;
            }
        }
        try {
            return this.f13746b.get(i);
        } catch (IndexOutOfBoundsException e2) {
            return null;
        }
    }

    /* renamed from: a */
    private void m14616a(Node node) {
        if (node == this.f13747c) {
            this.f13745a = new ArrayList<>();
        } else if (this.f13748d == null || node.getNodeName().equals(this.f13748d)) {
            this.f13745a.add(node);
        }
        for (Node firstChild = node.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (this.f13749e) {
                m14616a(firstChild);
            } else if (this.f13748d == null || firstChild.getNodeName().equals(this.f13748d)) {
                this.f13745a.add(firstChild);
            }
        }
    }
}
