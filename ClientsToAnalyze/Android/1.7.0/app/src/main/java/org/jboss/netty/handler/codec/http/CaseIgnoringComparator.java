package org.jboss.netty.handler.codec.http;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes.dex */
final class CaseIgnoringComparator implements Serializable, Comparator {
    static final CaseIgnoringComparator INSTANCE = new CaseIgnoringComparator();
    private static final long serialVersionUID = 4582133183775373862L;

    private CaseIgnoringComparator() {
    }

    @Override // java.util.Comparator
    public int compare(String str, String str2) {
        return str.compareToIgnoreCase(str2);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
