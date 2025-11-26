package com.vlingo.sdk.internal.vlservice.response;

import java.util.Vector;

/* loaded from: classes.dex */
public class VLServiceResponse {
    protected ActionList actionList;
    private String dialogGUID;
    protected byte[] dialogState;
    protected boolean isError = false;
    protected Vector<ServerMessage> messages = new Vector<>();
    private int dialogTurn = -1;

    public boolean isError() {
        return hasMessageOfType(3);
    }

    public boolean hasWarnings() {
        return hasMessageOfType(2);
    }

    public boolean hasMessageOfType(int type) {
        if (this.messages.size() > 0) {
            for (int i = 0; i < this.messages.size(); i++) {
                ServerMessage message = this.messages.elementAt(i);
                if (message.getType() == type) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasActions() {
        return this.actionList != null && this.actionList.size() > 0;
    }

    public ActionList getActionList() {
        return this.actionList;
    }

    public boolean hasMessages() {
        return this.messages.size() > 0;
    }

    public Vector<ServerMessage> getMessages() {
        return this.messages;
    }

    public ServerMessage getFirstMessage() {
        if (this.messages.size() > 0) {
            return this.messages.elementAt(0);
        }
        return null;
    }

    public void addMessage(ServerMessage message) {
        this.messages.addElement(message);
    }

    public void setActionList(ActionList actionList) {
        this.actionList = actionList;
    }

    public void addAction(Action action) {
        if (this.actionList == null) {
            this.actionList = new ActionList();
        }
        this.actionList.addElement(action);
    }

    public String getDialogGuid() {
        return this.dialogGUID;
    }

    public void setDialogGuid(String guid) {
        this.dialogGUID = guid;
    }

    public int getDialogTurn() {
        return this.dialogTurn;
    }

    public void setDialogTurn(int turn) {
        this.dialogTurn = turn;
    }

    public boolean hasDialogState() {
        return this.dialogState != null && this.dialogState.length > 0;
    }

    public void setDialogState(byte[] state) {
        this.dialogState = state;
    }

    public byte[] getDialogState() {
        return this.dialogState;
    }

    public static VLServiceResponse createFromXml(String xml) {
        VLResponseParser responseParser = new VLResponseParser();
        VLServiceResponse res = responseParser.parseResponseXml(xml);
        return res;
    }

    public String toString() {
        StringBuffer buff = new StringBuffer();
        if (getFirstMessage() != null) {
            for (int i = 0; i < this.messages.size(); i++) {
                ServerMessage msg = this.messages.elementAt(i);
                buff.append(msg.toString());
                buff.append("\n");
            }
        } else {
            buff.append("<no message>");
        }
        buff.append("\n");
        if (this.actionList != null) {
            buff.append(this.actionList.toString());
        } else {
            buff.append("<no actions>");
        }
        return buff.toString();
    }
}
