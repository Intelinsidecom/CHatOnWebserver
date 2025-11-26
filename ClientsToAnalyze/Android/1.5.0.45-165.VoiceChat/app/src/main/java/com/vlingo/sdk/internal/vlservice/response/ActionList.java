package com.vlingo.sdk.internal.vlservice.response;

import com.google.android.gcm.GCMConstants;
import com.vlingo.sdk.internal.logging.Logger;
import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.internal.util.UrlUtils;
import java.util.Enumeration;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ActionList implements Cloneable {
    private static final Logger log = Logger.getLogger(ActionList.class);
    Vector list = new Vector();

    public Object clone() throws CloneNotSupportedException {
        ActionList clone = (ActionList) super.clone();
        clone.list = (Vector) this.list.clone();
        return clone;
    }

    public boolean containsErrorMessage() {
        for (int i = 0; i < size(); i++) {
            Action a = elementAt(i);
            if (a.getName().equals("ShowMessage")) {
                String typeStr = a.getStringParamValue("Type");
                if (typeStr.equals(GCMConstants.EXTRA_ERROR)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsActionWithName(String actionName) {
        for (int i = 0; i < size(); i++) {
            Action a = elementAt(i);
            if (actionName.equalsIgnoreCase(a.name)) {
                return true;
            }
        }
        return false;
    }

    public void removeActionByName(String actionName) {
        for (int i = 0; i < size(); i++) {
            Action a = elementAt(i);
            if (actionName.equalsIgnoreCase(a.name)) {
                this.list.removeElement(a);
                return;
            }
        }
    }

    public Action getActionByName(String actionName) {
        for (int i = 0; i < size(); i++) {
            Action a = elementAt(i);
            if (actionName.equalsIgnoreCase(a.name)) {
                return a;
            }
        }
        return null;
    }

    public static ActionList createActionListFromXML(String xml) {
        VLServiceResponse res = VLServiceResponse.createFromXml(xml);
        return res.getActionList();
    }

    public static ActionList createActionListFromJSONArray(String jsonArray) {
        ActionList al = new ActionList();
        try {
            ActionList al2 = createActionListFromJSONArray(new JSONArray(jsonArray));
            return al2;
        } catch (JSONException e) {
            return al;
        }
    }

    public static ActionList createActionListFromJSONArray(JSONArray actions) throws JSONException {
        ActionList al = new ActionList();
        for (int j = 0; j < actions.length(); j++) {
            try {
                JSONObject jAction = actions.getJSONObject(j);
                Action action = new Action(jAction.getString("Name"));
                if (jAction.has("If")) {
                    action.ifCondition = jAction.getString("If");
                }
                if (jAction.has("Else")) {
                    action.elseStatement = jAction.getString("Else");
                }
                if (jAction.has("Params")) {
                    JSONArray params = jAction.getJSONArray("Params");
                    for (int k = 0; k < params.length(); k++) {
                        JSONObject param = params.getJSONObject(k);
                        String name = param.getString("Name");
                        String value = param.getString("Value");
                        action.addParameter(name, value, null);
                    }
                }
                al.addElement(action);
            } catch (JSONException e) {
            }
        }
        return al;
    }

    public static ActionList createActionListFromURL(String url) {
        String actionName;
        ActionList al = new ActionList();
        if (url.startsWith("action:") || url.startsWith("vvaction:")) {
            String queryString = "";
            int colonIndex = url.indexOf(58);
            String[] actions = StringUtils.split(url.substring(colonIndex + 1), ',');
            for (String actionString : actions) {
                log.debug("Parsing magic action: " + actionString);
                int qPos = actionString.indexOf("?");
                if (qPos > -1) {
                    actionName = actionString.substring(0, qPos);
                    queryString = actionString.substring(qPos + 1);
                } else {
                    actionName = actionString;
                }
                log.debug("Magic action: " + actionName);
                Action a = new Action(actionName);
                if (queryString.length() > 0) {
                    String[] params = StringUtils.split(queryString, '&');
                    for (String parm : params) {
                        String[] pv = StringUtils.split(parm, '=');
                        String pname = pv[0];
                        String pval = UrlUtils.urlDecode(pv[1]);
                        log.debug("\tParam " + pname + "=" + pval);
                        a.addParameter(pname, pval, null);
                    }
                }
                al.addElement(a);
            }
        }
        return al;
    }

    public Action elementAt(int index) {
        return (Action) this.list.elementAt(index);
    }

    public int size() {
        return this.list.size();
    }

    public synchronized void removeAllElements() {
        this.list.removeAllElements();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public synchronized Enumeration elements() {
        return this.list.elements();
    }

    public synchronized void addElement(Action arg0) {
        this.list.addElement(arg0);
    }
}
