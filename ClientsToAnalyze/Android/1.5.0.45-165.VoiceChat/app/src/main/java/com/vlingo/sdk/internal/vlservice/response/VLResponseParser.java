package com.vlingo.sdk.internal.vlservice.response;

import com.vlingo.sdk.VLSdk;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.recognizer.results.SRRecognitionResponse;
import com.vlingo.sdk.internal.util.ToIntHashtable;
import com.vlingo.sdk.internal.util.ToIntHashtableFactory;
import com.vlingo.sdk.internal.xml.XmlAttributes;
import com.vlingo.sdk.internal.xml.XmlHandler;
import com.vlingo.sdk.internal.xml.XmlParser;
import com.vlingo.sdk.util.SDKDebugSettings;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Vector;

/* loaded from: classes.dex */
public class VLResponseParser {
    static final String path = "/sdcard/vlingo";
    private static Logger log = Logger.getLogger(VLResponseParser.class);
    private static SDKDebugSettings dbgSettings = null;
    static int reponseCount = 0;
    private byte elementIndex = 50;
    private byte attributeIndex = 1;
    VLResponseSectionParser currentParser = null;
    VLServiceResponse currentResponse = null;
    private final ToIntHashtable xmlElements = ToIntHashtableFactory.createNewHashtable();
    private final ToIntHashtable xmlAttributes = ToIntHashtableFactory.createNewHashtable();
    Vector<VLResponseSectionParser> sectionParsers = new Vector<>();

    public VLResponseParser() {
        initParsers();
        initDebugSettings();
    }

    public static void initDebugSettings() {
        dbgSettings = VLSdk.getInstance().getDebugSettings();
        if (dbgSettings != null && dbgSettings.getServerResponseLoggingState() != SDKDebugSettings.ServerResponseLoggingState.NONE) {
            File f = new File(path);
            if (!f.isDirectory()) {
                f.mkdirs();
            } else {
                clearOldRecordings();
            }
        }
    }

    public static void resetResponseCount() {
        reponseCount = 0;
        initDebugSettings();
    }

    private static void clearOldRecordings() {
        if (dbgSettings.getServerResponseLoggingState() == SDKDebugSettings.ServerResponseLoggingState.SAVE) {
            reponseCount = 0;
            File dir = new File(path);
            FilenameFilter fileFilter = new FilenameFilter() { // from class: com.vlingo.sdk.internal.vlservice.response.VLResponseParser.1
                @Override // java.io.FilenameFilter
                public boolean accept(File dir2, String name) {
                    return name.startsWith(VLResponseParser.dbgSettings.getmRawServerLogBase());
                }
            };
            File[] files = dir.listFiles(fileFilter);
            for (File f : files) {
                f.delete();
            }
        }
    }

    public void addParser(VLResponseSectionParser parser) {
        this.sectionParsers.addElement(parser);
    }

    public void initParsers() {
        addParser(new DialogParser(this));
        addParser(new ServerMessageParser(this));
        addParser(new ActionParser(this));
    }

    public VLServiceResponse parseResponseXml(String responseXml) {
        return parseResponseXml(responseXml, new SRRecognitionResponse());
    }

    public VLServiceResponse parseResponseXml(String responseXml, VLServiceResponse initialResponse) throws IOException {
        log.debug(responseXml);
        try {
            if (dbgSettings != null) {
                if (dbgSettings.getServerResponseLoggingState() == SDKDebugSettings.ServerResponseLoggingState.SAVE) {
                    StringBuilder sbAppend = new StringBuilder("/sdcard/vlingo/").append(dbgSettings.getmRawServerLogBase()).append(".");
                    int i = reponseCount;
                    reponseCount = i + 1;
                    FileWriter fstream = new FileWriter(sbAppend.append(i).toString());
                    BufferedWriter out = new BufferedWriter(fstream);
                    out.write(responseXml);
                    out.close();
                } else if (dbgSettings.getServerResponseLoggingState() == SDKDebugSettings.ServerResponseLoggingState.REPLAY) {
                    StringBuilder sbAppend2 = new StringBuilder("/sdcard/vlingo/").append(dbgSettings.getmRawServerLogBase()).append(".");
                    int i2 = reponseCount;
                    reponseCount = i2 + 1;
                    FileReader fstream2 = new FileReader(sbAppend2.append(i2).toString());
                    BufferedReader in = new BufferedReader(fstream2);
                    responseXml = in.readLine();
                    in.close();
                }
            }
        } catch (IOException e) {
        }
        this.currentResponse = initialResponse;
        this.currentParser = null;
        try {
            char[] chars = responseXml.toCharArray();
            onParseBegin(chars);
            XmlParser parser = new XmlParser(chars, 0, chars.length, new XmlHandlerImpl(), this.xmlElements, this.xmlAttributes, true, false);
            parser.parseXml();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        log.debug(this.currentResponse.toString());
        return this.currentResponse;
    }

    public VLServiceResponse getResponse() {
        return this.currentResponse;
    }

    public int registerElement(String tagName) {
        if (this.xmlElements.containsKey(tagName)) {
            return this.xmlElements.get(tagName);
        }
        this.elementIndex = (byte) (this.elementIndex + 1);
        this.xmlElements.put(tagName, this.elementIndex);
        return this.elementIndex;
    }

    public int registerAttribute(String attrName) {
        if (this.xmlAttributes.containsKey(attrName)) {
            return this.xmlAttributes.get(attrName);
        }
        this.attributeIndex = (byte) (this.attributeIndex + 1);
        this.xmlAttributes.put(attrName, this.attributeIndex);
        return this.attributeIndex;
    }

    public void onSectionComplete() {
        this.currentParser = null;
    }

    private void onParseBegin(char[] xml) {
        for (int i = 0; i < this.sectionParsers.size(); i++) {
            VLResponseSectionParser p = this.sectionParsers.elementAt(i);
            p.onParseBegin(xml);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public VLResponseSectionParser getParserForElement(int elementType) {
        for (int i = 0; i < this.sectionParsers.size(); i++) {
            VLResponseSectionParser p = this.sectionParsers.elementAt(i);
            if (p.handlesElement(elementType)) {
                return p;
            }
        }
        return null;
    }

    class XmlHandlerImpl implements XmlHandler {
        XmlHandlerImpl() {
        }

        @Override // com.vlingo.sdk.internal.xml.XmlHandler
        public void beginElement(int elementType, XmlAttributes attributes, char[] cData, int elementEndPosition) {
            if (VLResponseParser.this.currentParser == null) {
                VLResponseParser.this.currentParser = VLResponseParser.this.getParserForElement(elementType);
            }
            if (VLResponseParser.this.currentParser != null) {
                VLResponseParser.this.currentParser.beginElement(elementType, attributes, cData, elementEndPosition);
            }
        }

        @Override // com.vlingo.sdk.internal.xml.XmlHandler
        public void endElement(int elementType, int elementStartPosition) {
            if (VLResponseParser.this.currentParser != null) {
                VLResponseParser.this.currentParser.endElement(elementType, elementStartPosition);
            }
        }

        @Override // com.vlingo.sdk.internal.xml.XmlHandler
        public void beginDocument() {
            if (VLResponseParser.this.currentParser != null) {
                VLResponseParser.this.currentParser.beginDocument();
            }
        }

        @Override // com.vlingo.sdk.internal.xml.XmlHandler
        public void endDocument() {
            if (VLResponseParser.this.currentParser != null) {
                VLResponseParser.this.currentParser.endDocument();
            }
        }

        @Override // com.vlingo.sdk.internal.xml.XmlHandler
        public void characters(char[] cData) {
            if (VLResponseParser.this.currentParser != null) {
                VLResponseParser.this.currentParser.characters(cData);
            }
        }
    }
}
