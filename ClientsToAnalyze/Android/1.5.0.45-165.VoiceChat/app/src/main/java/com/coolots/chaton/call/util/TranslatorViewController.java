package com.coolots.chaton.call.util;

import com.coolots.chaton.call.util.ChatOnTranslationDataController;
import com.coolots.chaton.common.util.ChatONStringConvert;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class TranslatorViewController {
    private static final String CLASSNAME = "[TranslatorViewController]";
    private ChatOnTranslationDataController mDataController;
    private Destination mDestination;
    private String mGuestAccoutId;
    private String mGuestName;
    private ArrayList<ITranslatorViewController> mITranslatorViewControllerList = new ArrayList<>();
    private TranslateModeValue mTranslateModeValue = new TranslateModeValue();

    public static class TranslateModeValue {
        boolean ViewOnOff = true;
        boolean TTSOnOff = false;
        boolean InComingMsgOnlyOnOff = false;

        public void setViewOnOff(boolean OnOff) {
            this.ViewOnOff = OnOff;
        }

        public void setTTSOnOff(boolean OnOff) {
            this.TTSOnOff = OnOff;
        }

        public void setInComingMsgOnlyOnOff(boolean OnOff) {
            this.InComingMsgOnlyOnOff = OnOff;
        }

        public boolean getViewOnOff() {
            return this.ViewOnOff;
        }

        public boolean getTTSOnOff() {
            return this.TTSOnOff;
        }

        public boolean getInComingMsgOnlyOnOff() {
            return this.InComingMsgOnlyOnOff;
        }
    }

    private void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public TranslatorViewController(String guestName, Destination destination, ChatOnTranslationDataController chatOnTranslationDataController, boolean OnlyIncomingMsgOnOff) {
        this.mDestination = destination;
        this.mGuestAccoutId = ChatONStringConvert.getInstance().removeFooter(this.mDestination.getString());
        this.mGuestName = guestName;
        this.mDataController = chatOnTranslationDataController;
        this.mTranslateModeValue.setInComingMsgOnlyOnOff(OnlyIncomingMsgOnOff);
    }

    public void addITranslatorViewController(ITranslatorViewController translatorViewController) {
        this.mITranslatorViewControllerList.add(translatorViewController);
    }

    public void removeITranslatorViewController() {
        if (this.mITranslatorViewControllerList.size() > 0) {
            this.mITranslatorViewControllerList.clear();
        }
    }

    public void setGuestName() {
        Iterator<ITranslatorViewController> it = this.mITranslatorViewControllerList.iterator();
        while (it.hasNext()) {
            ITranslatorViewController ViewController = it.next();
            ViewController.setGuestName(this.mGuestName);
        }
    }

    public void loadAllDatatoTranslatorView() {
        if (this.mDataController.getTranslationDisplayTTSData() != null) {
            Iterator<ChatOnTranslationDataController.TranslationDisplayTTSData> it = this.mDataController.getTranslationDisplayTTSData().iterator();
            while (it.hasNext()) {
                ChatOnTranslationDataController.TranslationDisplayTTSData data = it.next();
                addTranslatePopup(data.getTranslationDisplayData());
            }
        }
    }

    public void handleRecognitionStart(TranslationDisplayData data) {
        logI("YKYU handleRecognitionStart()");
        logI("YKYU handleRecognitionStart() mGuestAccoutId = " + this.mGuestAccoutId);
        logI("YKYU handleRecognitionStart() data.getUserID() = " + data.getUserID());
        Iterator<ITranslatorViewController> it = this.mITranslatorViewControllerList.iterator();
        while (it.hasNext()) {
            ITranslatorViewController ViewController = it.next();
            ViewController.startDurationTranslatePopup(data, isGuestId(data));
        }
    }

    public void handleRecognitionEnd(TranslationDisplayData data, boolean OnlyIncomingMessage) {
        logI("YKYU handleRecognitionEnd()");
        logI("YKYU handleRecognitionEnd() mGuestAccoutId = " + this.mGuestAccoutId);
        logI("YKYU handleRecognitionEnd() data.getUserID() = " + data.getUserID());
        Iterator<ITranslatorViewController> it = this.mITranslatorViewControllerList.iterator();
        while (it.hasNext()) {
            ITranslatorViewController ViewController = it.next();
            ViewController.endDurationTranslatePopup(data);
        }
        if (OnlyIncomingMessage) {
            addTranslatePopup(data);
            this.mDataController.addTranslationDisplayTTSData(new ChatOnTranslationDataController.TranslationDisplayTTSData(data, isGuestId(data)));
        }
    }

    public void handleRecognitionStop(TranslationDisplayData data) {
        logI("handleRecognitionStop()");
    }

    public void handleTranslationStart(TranslationDisplayData data) {
        logI("handleTranslationStart()");
    }

    public void handleTranslationEnd(TranslationDisplayData data) {
        logI("YKYU handleTranslationEnd()");
        addTranslatePopup(data);
        Iterator<ITranslatorViewController> it = this.mITranslatorViewControllerList.iterator();
        while (it.hasNext()) {
            ITranslatorViewController ViewController = it.next();
            ViewController.endDurationTranslatePopup(data);
        }
        this.mDataController.addTranslationDisplayTTSData(new ChatOnTranslationDataController.TranslationDisplayTTSData(data, isGuestId(data)));
    }

    public void addTranslatePopup(TranslationDisplayData data) {
        if (isGuestId(data)) {
            Iterator<ITranslatorViewController> it = this.mITranslatorViewControllerList.iterator();
            while (it.hasNext()) {
                ITranslatorViewController ViewController = it.next();
                ViewController.removeGuestTranslatePopup(data);
            }
            return;
        }
        Iterator<ITranslatorViewController> it2 = this.mITranslatorViewControllerList.iterator();
        while (it2.hasNext()) {
            ITranslatorViewController ViewController2 = it2.next();
            ViewController2.addtHostTranslatePopup(data, getInComingMsgOnlyOnOff(data));
        }
    }

    private boolean isGuestId(TranslationDisplayData data) {
        return this.mGuestAccoutId.equals(ChatONStringConvert.getInstance().removeFooter(data.getUserID()));
    }

    public void handleTTSStart(String id) {
        logI("YKYU handleTTSStart() id = " + id);
    }

    public void handleTTSEnd(String id) {
        logI("handleTTSEnd() id = " + id);
        ChatOnTranslationDataController.TranslationDisplayTTSData data = this.mDataController.getDataforId(id);
        if (data != null) {
            Iterator<ITranslatorViewController> it = this.mITranslatorViewControllerList.iterator();
            while (it.hasNext()) {
                ITranslatorViewController ViewController = it.next();
                ViewController.visibleTranslatorIcon(id);
            }
        }
    }

    public TranslateModeValue getTranslateModeValue() {
        return this.mTranslateModeValue;
    }

    public void setIncomingMsgOnlyOnOff(boolean OnOff) {
        this.mTranslateModeValue.setInComingMsgOnlyOnOff(OnOff);
    }

    public boolean getInComingMsgOnlyOnOff(TranslationDisplayData data) {
        return !isGuestId(data) && this.mTranslateModeValue.getInComingMsgOnlyOnOff();
    }
}
