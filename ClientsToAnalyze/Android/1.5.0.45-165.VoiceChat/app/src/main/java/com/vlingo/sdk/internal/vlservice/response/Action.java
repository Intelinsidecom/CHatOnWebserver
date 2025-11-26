package com.vlingo.sdk.internal.vlservice.response;

import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.recognizer.results.RecResults;
import com.vlingo.sdk.internal.recognizer.results.TaggedResults;
import java.util.Enumeration;
import java.util.Hashtable;

/* loaded from: classes.dex */
public class Action implements Cloneable {
    private static final String c_VPathPrefix = "${";
    private static Logger log = Logger.getLogger(Action.class);
    public String elseStatement;
    public String ifCondition;
    public String name;
    protected Hashtable parameters;

    protected Action(Action a) {
        this.name = a.name;
        this.parameters = a.parameters;
    }

    public boolean isConditional() {
        return this.ifCondition != null && this.ifCondition.length() > 0;
    }

    public Object clone() throws CloneNotSupportedException {
        Action clone = (Action) super.clone();
        clone.parameters = (Hashtable) this.parameters.clone();
        return clone;
    }

    public Action() {
        this.parameters = new Hashtable();
    }

    public Action(String name) {
        this();
        this.name = name;
    }

    public void addParameter(String name, String value, TaggedResults results) {
        Object vPath = value;
        if (results != null && isVPath(value)) {
            vPath = parseVPath(value, results);
        }
        if (vPath == null) {
            vPath = "";
        }
        setParameterValue(name, vPath);
    }

    public void setParameterValue(String name, Object value) {
        this.parameters.put(name, value);
    }

    private Object parseVPath(String vpath, TaggedResults results) {
        String resultString = vpath;
        String newString = expandVariableSection(resultString, results);
        while (newString != null) {
            resultString = newString;
            newString = expandVariableSection(resultString, results);
        }
        return resultString;
    }

    private String expandVariableSection(String input, TaggedResults results) {
        int endVSection;
        String newString;
        int tagnameStart;
        int tagnameEnd;
        TaggedResults.Tag tag;
        int startVSection = input.toLowerCase().indexOf("${alternates");
        if (startVSection >= 0 && (endVSection = input.indexOf("}", startVSection)) >= 0) {
            String vOutput = "";
            String vSection = input.substring(startVSection + 2, endVSection);
            if (vSection.equalsIgnoreCase("alternates.wl") || vSection.equalsIgnoreCase("alternates.ul")) {
                vOutput = results.getUttResults().getString();
            } else {
                int tagnameStart2 = vSection.indexOf("tag(");
                if (tagnameStart2 >= 0 && (tagnameEnd = vSection.indexOf(")", (tagnameStart = tagnameStart2 + 4))) >= 0) {
                    String tagName = vSection.substring(tagnameStart, tagnameEnd);
                    TaggedResults.ParseGroup pg = results.getParseGroup();
                    RecResults res = null;
                    if (pg != null && (tag = pg.lookupTagByName(tagName)) != null) {
                        res = tag.getRecResults();
                    }
                    String canonicalString = vSection.substring(tagnameEnd + 1);
                    if (res != null && canonicalString.length() > 0 && res.uttListCannonical != null && res.uttListCannonical.length > 0) {
                        vOutput = res.uttListCannonical[0];
                    } else if (res != null) {
                        vOutput = res.getString();
                    }
                }
            }
            if (vOutput == null) {
                log.error("ACT1", "Unable to parse vSection " + vSection);
                return null;
            }
            if (startVSection > 0) {
                newString = String.valueOf(input.substring(0, startVSection)) + vOutput;
            } else {
                newString = vOutput;
            }
            if (endVSection < input.length() - 1) {
                return String.valueOf(newString) + input.substring(endVSection + 1);
            }
            return newString;
        }
        return null;
    }

    boolean isVPath(String str) {
        return str != null && str.length() > 3 && str.indexOf(c_VPathPrefix) >= 0;
    }

    public String getStringParamValue(String name) {
        Object v = getParamValue(name);
        if (v == null) {
            return "";
        }
        if (v instanceof RecResults) {
            RecResults r = (RecResults) v;
            return r.getString();
        }
        return (String) v;
    }

    public Object getParamValue(String name) {
        if (name == null) {
            return null;
        }
        return this.parameters.get(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hashtable getParameters() {
        return this.parameters;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Action: ");
        sb.append(this.name);
        sb.append("\n");
        sb.append("    If: ");
        sb.append(this.ifCondition);
        sb.append("\n");
        sb.append("  Else: ");
        sb.append(this.elseStatement);
        sb.append("\n");
        Enumeration e = this.parameters.keys();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            Object value = this.parameters.get(key);
            sb.append("   ");
            sb.append(key);
            sb.append(": ");
            sb.append(value.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public String toHtmlString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Action: ");
        sb.append(this.name);
        sb.append("<br/>");
        sb.append("    If: ");
        sb.append(this.ifCondition);
        sb.append("<br/>");
        sb.append("  Else: ");
        sb.append(this.elseStatement);
        sb.append("<br/>");
        Enumeration e = this.parameters.keys();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            Object value = this.parameters.get(key);
            sb.append("   ");
            sb.append(key);
            sb.append(": ");
            sb.append(value.toString());
            sb.append("<br/>");
        }
        return sb.toString();
    }

    public Enumeration keys() {
        if (this.parameters != null) {
            return this.parameters.keys();
        }
        return null;
    }

    public Enumeration<String> getParams() {
        return this.parameters.keys();
    }
}
