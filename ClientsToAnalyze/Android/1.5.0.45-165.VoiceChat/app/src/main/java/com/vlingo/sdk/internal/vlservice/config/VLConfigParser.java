package com.vlingo.sdk.internal.vlservice.config;

import android.util.Pair;
import com.vlingo.sdk.internal.xml.SimpleXmlParser;
import com.vlingo.sdk.internal.xml.XmlAttributes;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class VLConfigParser extends SimpleXmlParser {
    public static final String TYPE_BOOLEAN = "boolean";
    public static final String TYPE_FLOAT = "float";
    public static final String TYPE_STRING = "string";
    String minimumAppVersion;
    Hashtable<String, Pair<String, String>> settings;
    final int ELEM_SETTING = registerElement("Setting");
    final int ELEM_VLCONFIG = registerElement("VLConfig");
    final int ATTR_N = registerAttribute("n");
    final int ATTR_V = registerAttribute("v");
    final int ATTR_T = registerAttribute("t");
    final int ATTR_MIN_APP_VERSION = registerAttribute("MinAppVersion");

    @Override // com.vlingo.sdk.internal.xml.SimpleXmlParser
    public void onParseBegin(char[] xml) {
        this.settings = new Hashtable<>();
        this.minimumAppVersion = null;
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void beginElement(int elementType, XmlAttributes attributes, char[] cData, int elementEndPosition) {
        if (this.ELEM_VLCONFIG == elementType) {
            this.minimumAppVersion = attributes.lookup(this.ATTR_MIN_APP_VERSION);
            return;
        }
        if (this.ELEM_SETTING == elementType) {
            String name = attributes.lookup(this.ATTR_N);
            String type = attributes.lookup(this.ATTR_T);
            String value = attributes.lookup(this.ATTR_V);
            if (value == null) {
                value = new String(cData);
            }
            addSetting(name, value, type);
        }
    }

    @Override // com.vlingo.sdk.internal.xml.XmlHandler
    public void endElement(int elementType, int elementStartPosition) {
    }

    private void addSetting(String name, String value, String type) {
        if (name != null) {
            if (value == null) {
                value = "";
            }
            if (type == null) {
                if ("false".equalsIgnoreCase(value) || "true".equalsIgnoreCase(value)) {
                    type = TYPE_BOOLEAN;
                } else {
                    type = TYPE_STRING;
                }
            }
            this.settings.put(name, new Pair<>(value, type.toLowerCase()));
        }
    }

    public String getMinimumAppVersion() {
        return this.minimumAppVersion;
    }

    public Hashtable<String, Pair<String, String>> getSettings() {
        return this.settings;
    }
}
