package com.vlingo.sdk.internal.vlservice.response;

import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.Base64;
import com.vlingo.sdk.internal.util.Base64DecoderException;
import com.vlingo.sdk.internal.xml.XmlAttributes;

/* loaded from: classes.dex */
public class DialogParser extends VLResponseSectionParser {
    private static final Logger log = Logger.getLogger(DialogParser.class);
    private final int XML_ATTR_GUID;
    private final int XML_ATTR_TURN;
    private final int XML_ELEMENT_DIALOGSTATE;
    private final int XML_ELEMENT_VVS;
    int currentParameterValueStartPos;
    char[] origXML;

    public DialogParser(VLResponseParser parser) {
        super(parser);
        this.origXML = null;
        this.XML_ELEMENT_VVS = parser.registerElement("VV");
        this.XML_ELEMENT_DIALOGSTATE = parser.registerElement("DialogState");
        this.XML_ATTR_GUID = parser.registerAttribute("dialog-guid");
        this.XML_ATTR_TURN = parser.registerAttribute("turn");
    }

    @Override // com.vlingo.sdk.internal.vlservice.response.VLResponseSectionParser
    public boolean handlesElement(int elementType) {
        return this.XML_ELEMENT_VVS == elementType || this.XML_ELEMENT_DIALOGSTATE == elementType;
    }

    @Override // com.vlingo.sdk.internal.vlservice.response.VLResponseSectionParser
    public void onParseBegin(char[] xml) {
        this.origXML = xml;
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void beginElement(int elementType, XmlAttributes attributes, char[] cData, int elementEndPosition) throws NumberFormatException {
        if (this.XML_ELEMENT_VVS == elementType) {
            if (attributes != null) {
                String guid = attributes.lookup(this.XML_ATTR_GUID);
                String turnStr = attributes.lookup(this.XML_ATTR_TURN);
                int turn = -1;
                if (turnStr != null && turnStr.length() > 0) {
                    turn = Integer.parseInt(turnStr);
                }
                this.responseParser.getResponse().setDialogGuid(guid);
                this.responseParser.getResponse().setDialogTurn(turn);
            }
            this.responseParser.onSectionComplete();
            return;
        }
        if (this.XML_ELEMENT_DIALOGSTATE == elementType) {
            try {
                String dialogDataBase64 = new String(cData);
                byte[] dialogData = Base64.decode(dialogDataBase64);
                this.responseParser.getResponse().setDialogState(dialogData);
            } catch (Base64DecoderException e) {
                log.debug("Error decoding dialog data");
                e.printStackTrace();
            }
        }
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void endElement(int elementType, int elementStartPosition) {
        if (this.XML_ELEMENT_DIALOGSTATE == elementType) {
            this.responseParser.onSectionComplete();
        }
    }
}
