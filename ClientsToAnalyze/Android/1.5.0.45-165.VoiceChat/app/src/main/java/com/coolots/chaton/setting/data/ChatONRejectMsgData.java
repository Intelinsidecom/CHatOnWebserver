package com.coolots.chaton.setting.data;

import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ChatONRejectMsgData implements Serializable, DisposeInterface {
    private static final String CLASSNAME = "[ChatONRejectMsgData]";
    public static final int VIEW_TYPE_MSG_MODIFIED = 0;
    private static final long serialVersionUID = 1;
    private List<Integer> mType = null;
    private List<String> mMsg = null;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    private void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    private void addItems(Integer type, String msg) {
        if (this.mType == null) {
            this.mType = new ArrayList();
        }
        if (this.mMsg == null) {
            this.mMsg = new ArrayList();
        }
        logI("addItems " + type + ", " + msg);
        this.mType.add(type);
        this.mMsg.add(msg);
    }

    private void deleteItems(int index) {
        this.mType.remove(index);
        this.mMsg.remove(index);
    }

    public void loadSavedData(ChatONRejectMsgData savedData) {
        logI("loadSavedData()");
        if (savedData == null) {
            logE("saved data is null");
            return;
        }
        for (int i = 0; i < savedData.getCount(); i++) {
            if (savedData.getType(i) == 0) {
                logI("[" + i + "] modified " + savedData.getMessage(i));
                addItems(Integer.valueOf(savedData.getType(i)), savedData.getMessage(i));
            } else {
                logI("[" + i + "] default (" + savedData.getType(i) + ") ");
                addItems(Integer.valueOf(savedData.getType(i)), "default string");
            }
        }
    }

    public void loadDefaultData(int maxCount) {
        logI("loadDefaultData()");
        for (int i = 0; i < maxCount; i++) {
            logI("i: " + i);
            addItems(Integer.valueOf(i + 1), "default string");
        }
    }

    public int getCount() {
        return this.mType.size();
    }

    public int getType(int index) {
        return this.mType.get(index).intValue();
    }

    public String getMessage(int index) {
        if (index >= this.mMsg.size()) {
            return null;
        }
        logI("getMessage(" + index + ")" + this.mMsg.get(index));
        return this.mMsg.get(index);
    }

    public boolean modifyMessage(int index, String msg) {
        if (index >= this.mMsg.size() || msg == null || msg.isEmpty()) {
            return false;
        }
        this.mType.set(index, 0);
        this.mMsg.set(index, msg);
        return true;
    }

    public boolean addMessage(int type, String msg) {
        if (msg == null || msg.isEmpty()) {
            logI("addMessage() msg is null");
            return false;
        }
        addItems(Integer.valueOf(type), msg);
        return true;
    }

    public void addMessages(ChatONRejectMsgData data) {
        if (data != null && data.getCount() != 0) {
            int tCount = data.getCount();
            for (int index = 0; index < tCount; index++) {
                if (data.getType(index) == 0) {
                    logI("[" + index + "] modified " + data.getMessage(index));
                    addItems(Integer.valueOf(data.getType(index)), data.getMessage(index));
                } else {
                    logI("[" + index + "] default (" + data.getType(index) + ") ");
                    addItems(Integer.valueOf(data.getType(index)), "default string");
                }
            }
        }
    }

    public boolean deleteMessage(int index) {
        if (index >= this.mType.size()) {
            return false;
        }
        deleteItems(index);
        return true;
    }

    public void description() {
        Iterator<String> iter = this.mMsg.iterator();
        while (iter.hasNext()) {
            logI("Msg: " + iter.next());
        }
    }

    public void description(int index) {
        logI("[" + index + "] Type: " + this.mType.get(index) + "Msg: " + this.mMsg.get(index));
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.mType != null) {
            this.mType.clear();
            this.mType = null;
        }
        if (this.mMsg != null) {
            this.mMsg.clear();
            this.mMsg = null;
        }
    }
}
