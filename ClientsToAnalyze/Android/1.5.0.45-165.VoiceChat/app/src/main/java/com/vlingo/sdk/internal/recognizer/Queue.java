package com.vlingo.sdk.internal.recognizer;

/* loaded from: classes.dex */
public class Queue {
    protected Element m_Last;
    protected Element m_Nodes;

    public synchronized void add(Object element) {
        Element e = new Element(element);
        if (this.m_Last == null) {
            this.m_Nodes = e;
        } else {
            this.m_Last.m_Next = e;
        }
        this.m_Last = e;
        notifyAll();
    }

    public synchronized boolean isEmpty() {
        return this.m_Nodes == null;
    }

    public synchronized Object pop() {
        Object element;
        element = null;
        if (this.m_Nodes != null) {
            element = this.m_Nodes.m_Element;
            if (this.m_Nodes == this.m_Last) {
                this.m_Last = null;
                this.m_Nodes = null;
            } else {
                this.m_Nodes = this.m_Nodes.m_Next;
            }
        }
        return element;
    }

    public synchronized boolean clear() {
        boolean inProgress;
        inProgress = this.m_Nodes != null;
        this.m_Last = null;
        this.m_Nodes = null;
        return inProgress;
    }

    static final class Element {
        Object m_Element;
        Element m_Next;

        Element(Object obj) {
            this.m_Element = obj;
        }
    }
}
