package com.vlingo.sdk.internal;

import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.internal.vlservice.response.Action;
import com.vlingo.sdk.recognition.VLAction;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class VLActionImpl implements VLAction {
    private String elseStatement;
    private String ifCondition;
    private String mName;
    private HashMap<String, String> mParameters = new HashMap<>();

    VLActionImpl(Action action) {
        this.mName = action.getName();
        Enumeration<String> e = action.getParams();
        while (e.hasMoreElements()) {
            String pName = e.nextElement();
            String pValue = action.getStringParamValue(pName);
            this.mParameters.put(pName, pValue);
        }
        this.ifCondition = action.ifCondition;
        this.elseStatement = action.elseStatement;
    }

    @Override // com.vlingo.sdk.recognition.VLAction
    public boolean isConditional() {
        return !StringUtils.isNullOrWhiteSpace(this.ifCondition);
    }

    @Override // com.vlingo.sdk.recognition.VLAction
    public String getName() {
        return this.mName;
    }

    @Override // com.vlingo.sdk.recognition.VLAction
    public Set<String> getParameterNames() {
        return this.mParameters.keySet();
    }

    @Override // com.vlingo.sdk.recognition.VLAction
    public String getParamValue(String paramName) {
        if (this.mParameters != null) {
            return this.mParameters.get(paramName);
        }
        return null;
    }

    @Override // com.vlingo.sdk.recognition.VLAction
    public String getIfCondition() {
        return this.ifCondition;
    }

    @Override // com.vlingo.sdk.recognition.VLAction
    public String getElseStatement() {
        return this.elseStatement;
    }

    public String toString() {
        return "Action: " + this.mName + this.mParameters.toString();
    }
}
