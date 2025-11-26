package com.vlingo.sdk.internal.recognizer.results;

import com.vlingo.sdk.internal.vlservice.response.VLServiceResponse;

/* loaded from: classes.dex */
public class SRRecognitionResponse extends VLServiceResponse {
    private String guttid;
    private TaggedResults results = null;

    public boolean hasResults() {
        return (this.results == null || this.results.isEmpty()) ? false : true;
    }

    public TaggedResults getResults() {
        return this.results;
    }

    public void setTaggedResults(TaggedResults results) {
        this.results = results;
    }

    public String getGUttId() {
        return this.guttid;
    }

    public void setGUttId(String guttid) {
        this.guttid = guttid;
    }

    @Override // com.vlingo.sdk.internal.vlservice.response.VLServiceResponse
    public String toString() {
        StringBuffer buff = new StringBuffer();
        buff.append(super.toString());
        if (this.results != null) {
            buff.append(this.results.toString());
        } else {
            buff.append("<no results>");
        }
        buff.append("\n");
        return buff.toString();
    }
}
