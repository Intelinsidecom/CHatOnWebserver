package com.google.protobuf;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
final class FieldSet {

    /* renamed from: b */
    private static final FieldSet f238b = new FieldSet(true);

    /* renamed from: a */
    private Map f239a;

    public interface FieldDescriptorLite extends Comparable {
    }

    private FieldSet() {
        this.f239a = new TreeMap();
    }

    private FieldSet(boolean z) {
        this.f239a = Collections.emptyMap();
    }

    /* renamed from: a */
    public static FieldSet m340a() {
        return new FieldSet();
    }
}
