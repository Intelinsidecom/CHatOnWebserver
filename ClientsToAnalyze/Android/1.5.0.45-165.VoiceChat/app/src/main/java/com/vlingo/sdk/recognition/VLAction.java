package com.vlingo.sdk.recognition;

import java.util.Set;

/* loaded from: classes.dex */
public interface VLAction {
    String getElseStatement();

    String getIfCondition();

    String getName();

    String getParamValue(String str);

    Set<String> getParameterNames();

    boolean isConditional();
}
