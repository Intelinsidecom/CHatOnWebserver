package com.google.protobuf;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class ExtensionRegistryLite {

    /* renamed from: b */
    private static final ExtensionRegistryLite f236b = new ExtensionRegistryLite(true);

    /* renamed from: a */
    private final Map f237a;

    ExtensionRegistryLite() {
        this.f237a = new HashMap();
    }

    private ExtensionRegistryLite(boolean z) {
        this.f237a = Collections.emptyMap();
    }

    /* renamed from: a */
    public static ExtensionRegistryLite m339a() {
        return f236b;
    }
}
