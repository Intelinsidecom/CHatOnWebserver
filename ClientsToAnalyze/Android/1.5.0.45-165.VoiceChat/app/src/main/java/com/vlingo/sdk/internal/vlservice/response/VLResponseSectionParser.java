package com.vlingo.sdk.internal.vlservice.response;

import com.vlingo.sdk.internal.xml.XmlHandler;

/* loaded from: classes.dex */
public abstract class VLResponseSectionParser implements XmlHandler {
    protected VLResponseParser responseParser;

    public abstract boolean handlesElement(int i);

    public VLResponseSectionParser(VLResponseParser responseParser) {
        this.responseParser = null;
        this.responseParser = responseParser;
    }

    public void onParseBegin(char[] xml) {
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void beginDocument() {
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void endDocument() {
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void characters(char[] cData) {
    }
}
