package com.vlingo.sdk.internal.recognizer.results;

import com.vlingo.sdk.internal.recognizer.XMLResponseListener;
import com.vlingo.sdk.internal.vlservice.response.VLResponseParser;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SRResponseParser {
    private ArrayList<XMLResponseListener> mXMLListeners = null;
    VLResponseParser parser = new VLResponseParser();

    public SRResponseParser() {
        this.parser.addParser(new TaggedResultsParser(this));
    }

    public SRRecognitionResponse parseResponseXml(String responseXml) {
        if (this.mXMLListeners != null) {
            Iterator<XMLResponseListener> it = this.mXMLListeners.iterator();
            while (it.hasNext()) {
                XMLResponseListener listener = it.next();
                listener.notifyXMLResponse(responseXml);
            }
        }
        SRRecognitionResponse res = (SRRecognitionResponse) this.parser.parseResponseXml(responseXml, new SRRecognitionResponse());
        return res;
    }

    public int registerElement(String tagName) {
        return this.parser.registerElement(tagName);
    }

    public int registerAttribute(String attrName) {
        return this.parser.registerAttribute(attrName);
    }

    public SRRecognitionResponse getResponse() {
        return (SRRecognitionResponse) this.parser.getResponse();
    }

    public void addXMLResponseListener(XMLResponseListener listener) {
        if (this.mXMLListeners == null) {
            this.mXMLListeners = new ArrayList<>();
        }
        this.mXMLListeners.add(listener);
    }

    public void removeXMLResponseListener(XMLResponseListener listener) {
        if (this.mXMLListeners != null) {
            this.mXMLListeners.remove(listener);
        }
    }
}
