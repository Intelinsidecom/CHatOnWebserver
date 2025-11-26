package com.vlingo.sdk.internal.vlservice.response;

import com.sec.spp.push.Config;
import com.vlingo.sdk.internal.xml.XmlAttributes;

/* loaded from: classes.dex */
public class ServerMessageParser extends VLResponseSectionParser {
    private final int XML_ELEMENT_CODE;
    private final int XML_ELEMENT_DETAILS;
    private final int XML_ELEMENT_ERROR;
    private final int XML_ELEMENT_MESSAGE;
    private final int XML_ELEMENT_STATUS;
    private final int XML_ELEMENT_WARNING;
    private boolean inDetails;
    private ServerMessage msg;

    public ServerMessageParser(VLResponseParser parser) {
        super(parser);
        this.XML_ELEMENT_STATUS = parser.registerElement("Status");
        this.XML_ELEMENT_WARNING = parser.registerElement("Warning");
        this.XML_ELEMENT_ERROR = parser.registerElement(Config.EXTRA_ERROR);
        this.XML_ELEMENT_MESSAGE = parser.registerElement("Message");
        this.XML_ELEMENT_CODE = parser.registerElement("Code");
        this.XML_ELEMENT_DETAILS = parser.registerElement("Details");
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void beginElement(int elementType, XmlAttributes attributes, char[] cData, int elementEndPosition) {
        String cDataString = null;
        if (cData != null) {
            cDataString = String.valueOf(cData);
        }
        if (this.XML_ELEMENT_STATUS == elementType) {
            this.msg = new ServerMessage();
            this.msg.setType(1);
            return;
        }
        if (this.XML_ELEMENT_WARNING == elementType) {
            this.msg = new ServerMessage();
            this.msg.setType(2);
            return;
        }
        if (this.XML_ELEMENT_ERROR == elementType) {
            this.msg = new ServerMessage();
            this.msg.setType(3);
            return;
        }
        if (this.XML_ELEMENT_MESSAGE == elementType) {
            if (this.inDetails) {
                this.msg.setDetailMessage(cDataString);
                return;
            } else {
                this.msg.setMessage(cDataString);
                return;
            }
        }
        if (this.XML_ELEMENT_CODE == elementType) {
            if (this.inDetails) {
                this.msg.setDetailCode(cDataString);
                return;
            } else {
                this.msg.setCode(cDataString);
                return;
            }
        }
        if (this.XML_ELEMENT_DETAILS == elementType) {
            this.inDetails = true;
        }
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void endElement(int elementType, int elementStartPosition) {
        if (this.XML_ELEMENT_STATUS == elementType || this.XML_ELEMENT_WARNING == elementType || this.XML_ELEMENT_ERROR == elementType) {
            this.responseParser.getResponse().addMessage(this.msg);
            this.responseParser.onSectionComplete();
        } else if (this.inDetails && this.XML_ELEMENT_DETAILS == elementType) {
            this.inDetails = false;
        }
    }

    @Override // com.vlingo.sdk.internal.vlservice.response.VLResponseSectionParser
    public boolean handlesElement(int elementType) {
        return this.XML_ELEMENT_STATUS == elementType || this.XML_ELEMENT_WARNING == elementType || this.XML_ELEMENT_ERROR == elementType;
    }
}
