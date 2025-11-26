package com.vlingo.sdk.internal.vlservice.response;

import com.vlingo.sdk.internal.recognizer.results.SRRecognitionResponse;
import com.vlingo.sdk.internal.recognizer.results.TaggedResults;
import com.vlingo.sdk.internal.xml.XmlAttributes;
import com.vlingo.sdk.internal.xml.XmlParser;

/* loaded from: classes.dex */
public class ActionParser extends VLResponseSectionParser {
    private final int XML_ATTR_ELSE;
    private final int XML_ATTR_IF;
    private final int XML_ATTR_N;
    private final int XML_ATTR_V;
    private final int XML_ELEMENT_ACTION;
    private final int XML_ELEMENT_ACTIONLIST;
    private final int XML_ELEMENT_PARAM;
    ActionList actionList;
    Action currentAction;
    String currentParameterName;
    String currentParameterValue;
    int currentParameterValueStartPos;
    char[] origXML;
    TaggedResults taggedResults;

    public ActionParser(VLResponseParser parser) {
        super(parser);
        this.origXML = null;
        this.actionList = null;
        this.currentAction = null;
        this.taggedResults = null;
        this.XML_ELEMENT_ACTIONLIST = parser.registerElement("ActionList");
        this.XML_ELEMENT_ACTION = parser.registerElement("Action");
        this.XML_ELEMENT_PARAM = parser.registerElement("Param");
        this.XML_ATTR_N = parser.registerAttribute("n");
        this.XML_ATTR_V = parser.registerAttribute("v");
        this.XML_ATTR_IF = parser.registerAttribute("if");
        this.XML_ATTR_ELSE = parser.registerAttribute("else");
    }

    @Override // com.vlingo.sdk.internal.vlservice.response.VLResponseSectionParser
    public boolean handlesElement(int elementType) {
        return this.XML_ELEMENT_ACTIONLIST == elementType;
    }

    @Override // com.vlingo.sdk.internal.vlservice.response.VLResponseSectionParser
    public void onParseBegin(char[] xml) {
        this.origXML = xml;
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void beginElement(int elementType, XmlAttributes attributes, char[] cData, int elementEndPosition) {
        if (this.XML_ELEMENT_ACTIONLIST == elementType) {
            this.actionList = new ActionList();
            VLServiceResponse res = this.responseParser.getResponse();
            if (res instanceof SRRecognitionResponse) {
                this.taggedResults = ((SRRecognitionResponse) res).getResults();
                return;
            } else {
                this.taggedResults = null;
                return;
            }
        }
        if (this.XML_ELEMENT_ACTION == elementType) {
            this.currentAction = new Action(attributes.lookup(this.XML_ATTR_N));
            this.currentAction.ifCondition = attributes.lookup(this.XML_ATTR_IF);
            this.currentAction.elseStatement = attributes.lookup(this.XML_ATTR_ELSE);
            return;
        }
        if (this.XML_ELEMENT_PARAM == elementType) {
            String name = attributes.lookup(this.XML_ATTR_N);
            String value = attributes.lookup(this.XML_ATTR_V);
            this.currentParameterName = name;
            this.currentParameterValue = value;
            this.currentParameterValueStartPos = elementEndPosition;
        }
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void endElement(int elementType, int elementStartPosition) {
        if (this.XML_ELEMENT_PARAM == elementType) {
            String value = this.currentParameterValue;
            if (value == null) {
                int l = elementStartPosition;
                int s = this.currentParameterValueStartPos;
                while (true) {
                    if (this.origXML[s] != ' ' && this.origXML[s] != '\t' && this.origXML[s] != '\r' && this.origXML[s] != '\n') {
                        break;
                    } else {
                        s++;
                    }
                }
                while (true) {
                    if (this.origXML[l - 1] != ' ' && this.origXML[l - 1] != '\t' && this.origXML[l - 1] != '\r' && this.origXML[l - 1] != '\n') {
                        break;
                    } else {
                        l--;
                    }
                }
                value = XmlParser.createString(this.origXML, s, l - s, false);
            }
            this.currentAction.addParameter(this.currentParameterName, value, this.taggedResults);
            return;
        }
        if (this.XML_ELEMENT_ACTIONLIST == elementType) {
            this.responseParser.getResponse().setActionList(this.actionList);
            this.responseParser.onSectionComplete();
        } else if (this.XML_ELEMENT_ACTION == elementType) {
            this.actionList.addElement(this.currentAction);
        }
    }
}
