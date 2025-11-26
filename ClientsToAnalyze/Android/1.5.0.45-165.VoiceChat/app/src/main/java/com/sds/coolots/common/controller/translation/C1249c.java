package com.sds.coolots.common.controller.translation;

import android.os.Handler;
import android.os.Message;
import com.coolots.p2pmsg.MessageInfo;
import com.coolots.p2pmsg.model.MsgBody;
import com.coolots.p2pmsg.model.MsgHeader;
import com.coolots.p2pmsg.model.RecognitionAsk;
import com.coolots.p2pmsg.model.RecognitionRep;
import com.coolots.p2pmsg.model.TTSAsk;
import com.coolots.p2pmsg.model.TTSRep;
import com.coolots.p2pmsg.model.TranslationAsk;
import com.coolots.p2pmsg.model.TranslationRep;
import com.sds.coolots.EngineInterface;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.p014b.C1149a;
import com.sds.coolots.common.controller.translation.data.TranslationData;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;

/* renamed from: com.sds.coolots.common.controller.translation.c */
/* loaded from: classes.dex */
public class C1249c implements TranslationNotificationCallbackInterface, TranslationNotificationManagerInterface, DisposeInterface {

    /* renamed from: i */
    private static final String f2990i = "[TranslationNotification]";

    /* renamed from: a */
    public Handler f2991a;

    /* renamed from: b */
    public int f2992b;

    /* renamed from: c */
    public int f2993c;

    /* renamed from: d */
    public int f2994d;

    /* renamed from: e */
    public int f2995e;

    /* renamed from: f */
    public int f2996f;

    /* renamed from: g */
    public int f2997g;

    /* renamed from: h */
    public int f2998h;

    /* renamed from: j */
    private int f2999j;

    /* renamed from: a */
    private void m2885a() {
        m2890b("sendToUIRecognitionStop() ");
        if (this.f2991a == null) {
            m2888a("mUIEventHandler is null");
            return;
        }
        Message message = new Message();
        message.what = this.f2994d;
        this.f2991a.sendMessage(message);
    }

    /* renamed from: a */
    private void m2886a(MsgHeader msgHeader, MsgBody msgBody) {
        EngineInterface.getInstance().sendPushMessageByP2P(this.f2999j, msgHeader, msgBody);
    }

    /* renamed from: a */
    private void m2887a(TranslationDisplayData translationDisplayData) {
        m2890b("sendToUIRecognitionStart()");
        if (this.f2991a == null) {
            m2888a("mUIEventHandler is null");
            return;
        }
        Message message = new Message();
        message.what = this.f2992b;
        message.obj = translationDisplayData.clone();
        this.f2991a.sendMessage(message);
    }

    /* renamed from: a */
    private void m2888a(String str) {
        Log.m2958e(f2990i + str);
    }

    /* renamed from: b */
    private void m2889b(TranslationDisplayData translationDisplayData) {
        m2890b("sendToUIRecognitionEnd() " + translationDisplayData.getRecognizedText());
        if (this.f2991a == null) {
            m2888a("mUIEventHandler is null");
            return;
        }
        Message message = new Message();
        message.what = this.f2993c;
        message.obj = translationDisplayData.clone();
        this.f2991a.sendMessage(message);
    }

    /* renamed from: b */
    private void m2890b(String str) {
        Log.m2963i(f2990i + str);
    }

    /* renamed from: b */
    private boolean m2891b() {
        return MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationManager() != null && MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationManager().isActiveRecognition();
    }

    /* renamed from: c */
    private void m2892c(TranslationDisplayData translationDisplayData) {
        m2890b("sendToUITranslationStart()");
        if (this.f2991a == null) {
            m2888a("mUIEventHandler is null");
            return;
        }
        Message message = new Message();
        message.what = this.f2995e;
        message.obj = translationDisplayData.clone();
        this.f2991a.sendMessage(message);
    }

    /* renamed from: d */
    private void m2893d(TranslationDisplayData translationDisplayData) {
        m2890b("sendToUITranslationEnd() " + translationDisplayData.getTranslatedText());
        if (this.f2991a == null) {
            m2888a("mUIEventHandler is null");
            return;
        }
        Message message = new Message();
        message.what = this.f2996f;
        message.obj = translationDisplayData.clone();
        this.f2991a.sendMessage(message);
    }

    /* renamed from: e */
    private void m2894e(TranslationDisplayData translationDisplayData) {
        m2890b("sendToUITTSPlayStart() ");
        if (this.f2991a == null) {
            m2888a("mUIEventHandler is null");
            return;
        }
        Message message = new Message();
        message.what = this.f2997g;
        message.obj = translationDisplayData.clone();
        this.f2991a.sendMessage(message);
    }

    /* renamed from: f */
    private void m2895f(TranslationDisplayData translationDisplayData) {
        m2890b("sendToUITTSPlayEnd() ");
        if (this.f2991a == null) {
            m2888a("mUIEventHandler is null");
            return;
        }
        Message message = new Message();
        message.what = this.f2998h;
        message.obj = translationDisplayData.clone();
        this.f2991a.sendMessage(message);
    }

    /* renamed from: g */
    private void m2896g(TranslationDisplayData translationDisplayData) {
        if (MainApplication.mConfig.getProfileUserID().equals(translationDisplayData.getUserID())) {
            m2890b("sendToOtherpartyRecognitionStart");
            RecognitionAsk recognitionAsk = new RecognitionAsk();
            recognitionAsk.setID(translationDisplayData.getID());
            recognitionAsk.setUserID(translationDisplayData.getUserID());
            recognitionAsk.setVoiceLanguage(translationDisplayData.getInLanguage());
            recognitionAsk.setRecognitionLanguage(translationDisplayData.getOutLanguage());
            recognitionAsk.setRecognizedText(null);
            recognitionAsk.setIsRecognitionStart(true);
            recognitionAsk.setNationalFlag(translationDisplayData.getNatinalFlag());
            m2886a(C1149a.m2140a(MessageInfo.RecognitionAsk.getServiceCode(), MessageInfo.RecognitionAsk.getMessageCode()), recognitionAsk);
        }
    }

    /* renamed from: h */
    private void m2897h(TranslationDisplayData translationDisplayData) {
        if (MainApplication.mConfig.getProfileUserID().equals(translationDisplayData.getUserID())) {
            m2890b("sendToOtherpartyRecognitionEnd " + translationDisplayData.getRecognizedText());
            RecognitionAsk recognitionAsk = new RecognitionAsk();
            recognitionAsk.setID(translationDisplayData.getID());
            recognitionAsk.setUserID(translationDisplayData.getUserID());
            recognitionAsk.setVoiceLanguage(translationDisplayData.getInLanguage());
            recognitionAsk.setRecognitionLanguage(translationDisplayData.getOutLanguage());
            recognitionAsk.setRecognizedText(translationDisplayData.getRecognizedText());
            recognitionAsk.setIsRecognitionStart(false);
            recognitionAsk.setNationalFlag(translationDisplayData.getNatinalFlag());
            m2886a(C1149a.m2140a(MessageInfo.RecognitionAsk.getServiceCode(), MessageInfo.RecognitionAsk.getMessageCode()), recognitionAsk);
        }
    }

    /* renamed from: i */
    private void m2898i(TranslationDisplayData translationDisplayData) {
        m2890b("sendToOtherpartyTranslationStart");
        TranslationAsk translationAsk = new TranslationAsk();
        translationAsk.setID(translationDisplayData.getID());
        translationAsk.setUserID(translationDisplayData.getUserID());
        translationAsk.setVoiceLanguage(translationDisplayData.getInLanguage());
        translationAsk.setRecognitionLanguage(translationDisplayData.getOutLanguage());
        translationAsk.setRecognizedText(translationDisplayData.getRecognizedText());
        translationAsk.setTranslatedText(null);
        translationAsk.setIsTranslationStart(true);
        translationAsk.setNationalFlag(translationDisplayData.getNatinalFlag());
        m2886a(C1149a.m2140a(MessageInfo.TranslationAsk.getServiceCode(), MessageInfo.TranslationAsk.getMessageCode()), translationAsk);
    }

    /* renamed from: j */
    private void m2899j(TranslationDisplayData translationDisplayData) {
        if (MainApplication.mConfig.getProfileUserID().equals(translationDisplayData.getUserID())) {
            m2890b("sendToOtherpartyTranslationEnd " + translationDisplayData.getTranslatedText());
            TranslationAsk translationAsk = new TranslationAsk();
            translationAsk.setID(translationDisplayData.getID());
            translationAsk.setUserID(translationDisplayData.getUserID());
            translationAsk.setVoiceLanguage(translationDisplayData.getInLanguage());
            translationAsk.setRecognitionLanguage(translationDisplayData.getOutLanguage());
            translationAsk.setRecognizedText(translationDisplayData.getRecognizedText());
            translationAsk.setTranslatedText(translationDisplayData.getTranslatedText());
            translationAsk.setIsTranslationStart(false);
            translationAsk.setNationalFlag(translationDisplayData.getNatinalFlag());
            m2886a(C1149a.m2140a(MessageInfo.TranslationAsk.getServiceCode(), MessageInfo.TranslationAsk.getMessageCode()), translationAsk);
        }
    }

    /* renamed from: k */
    private void m2900k(TranslationDisplayData translationDisplayData) {
        m2890b("sendToOtherpartyTTSStart");
        TTSAsk tTSAsk = new TTSAsk();
        tTSAsk.setID(translationDisplayData.getID());
        tTSAsk.setUserID(translationDisplayData.getUserID());
        tTSAsk.setIsNowPlay(true);
        m2886a(C1149a.m2140a(MessageInfo.TTSAsk.getServiceCode(), MessageInfo.TTSAsk.getMessageCode()), tTSAsk);
    }

    /* renamed from: l */
    private void m2901l(TranslationDisplayData translationDisplayData) {
        m2890b("sendToOtherpartyTTSEnd");
        TTSAsk tTSAsk = new TTSAsk();
        tTSAsk.setID(translationDisplayData.getID());
        tTSAsk.setUserID(translationDisplayData.getUserID());
        tTSAsk.setIsNowPlay(false);
        m2886a(C1149a.m2140a(MessageInfo.TTSAsk.getServiceCode(), MessageInfo.TTSAsk.getMessageCode()), tTSAsk);
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface, com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        m2890b("dispose()");
        this.f2991a = null;
        EngineInterface.getInstance().setEngineTranslationCallback(null);
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void init(Handler handler, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m2890b("init()");
        EngineInterface.getInstance().setEngineTranslationCallback(this);
        this.f2999j = i8;
        this.f2991a = handler;
        this.f2992b = i;
        this.f2993c = i2;
        this.f2994d = i3;
        this.f2995e = i4;
        this.f2996f = i5;
        this.f2997g = i6;
        this.f2998h = i7;
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationCallbackInterface
    public void onReceiveRecognitionAsk(RecognitionAsk recognitionAsk) {
        m2890b("onReceiveRecognitionAsk");
        if (m2891b()) {
            if (recognitionAsk.getID() == null) {
                m2890b("onReceiveRecognitionAsk: recognition stop!!!!");
                receiveRecognitionStop();
                return;
            }
            TranslationDisplayData translationDisplayData = new TranslationDisplayData(recognitionAsk.getID(), recognitionAsk.getUserID(), recognitionAsk.getVoiceLanguage(), recognitionAsk.getRecognitionLanguage(), 0, recognitionAsk.getRecognizedText(), null);
            if (recognitionAsk.getIsRecognitionStart().booleanValue()) {
                receiveRecognitionStart(translationDisplayData);
            } else {
                receiveRecognitionEnd(translationDisplayData);
            }
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationCallbackInterface
    public void onReceiveRecognitionRep(RecognitionRep recognitionRep) {
        m2890b("onReceiveRecognitionRep");
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationCallbackInterface
    public void onReceiveTTSAsk(TTSAsk tTSAsk) {
        m2890b("onReceiveTTSAsk");
        if (m2891b()) {
            if (tTSAsk.getIsNowPlay().booleanValue()) {
                receiveTTSPlayStart(tTSAsk.getID());
            } else {
                receiveTTSPlayEnd(tTSAsk.getID());
            }
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationCallbackInterface
    public void onReceiveTTSRep(TTSRep tTSRep) {
        m2890b("onReceiveTTSRep");
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationCallbackInterface
    public void onReceiveTranslationAsk(TranslationAsk translationAsk) {
        m2890b("onReceiveTranslationAsk");
        if (m2891b()) {
            TranslationDisplayData translationDisplayData = new TranslationDisplayData(translationAsk.getID(), translationAsk.getUserID(), translationAsk.getVoiceLanguage(), translationAsk.getRecognitionLanguage(), 0, translationAsk.getRecognizedText(), translationAsk.getTranslatedText());
            if (translationAsk.getIsTranslationStart().booleanValue()) {
                receiveTranslationStart(translationDisplayData);
            } else {
                receiveTranslationEnd(new TranslationData(translationDisplayData.getID(), translationDisplayData.getUserID(), translationDisplayData.getOutLanguage(), MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationManager().getVoiceLanguage(), 0, translationDisplayData.getTranslatedText(), null));
            }
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationCallbackInterface
    public void onReceiveTranslationRep(TranslationRep translationRep) {
        m2890b("onReceiveTranslationRep");
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void onRecognitionEnd(TranslationData translationData) {
        m2890b("onRecognitionEnd" + translationData.getRecognizedText());
        TranslationListManagerInterface translationListManager = MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationListManager();
        if (translationListManager == null) {
            m2888a("List is null");
            return;
        }
        translationListManager.updateRecognitionEnd(translationData);
        m2889b(translationListManager.get(translationData.getID()));
        if (C1248b.m2882a(translationData.getRecognizedText())) {
            return;
        }
        m2897h(translationListManager.get(translationData.getID()));
        translationListManager.removeListData(translationData.getID());
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void onRecognitionStart(TranslationData translationData) {
        m2890b("onRecognitionStart");
        TranslationListManagerInterface translationListManager = MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationListManager();
        if (translationListManager == null) {
            m2888a("List is null");
            return;
        }
        translationListManager.updateRecognitionStart(translationData);
        m2887a(translationListManager.get(translationData.getID()));
        m2896g(translationListManager.get(translationData.getID()));
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void onTTSPlayEnd(String str) {
        m2890b("onTTSPlayEnd" + str);
        TranslationListManagerInterface translationListManager = MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationListManager();
        if (translationListManager == null) {
            m2888a("List is null");
        } else if (!translationListManager.updateTTSPlayEnd(str)) {
            m2888a("There is no such id " + str);
        } else {
            m2895f(translationListManager.get(str));
            m2901l(translationListManager.get(str));
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void onTTSPlayStart(String str) {
        m2890b("onTTSPlayStart");
        TranslationListManagerInterface translationListManager = MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationListManager();
        if (translationListManager == null) {
            m2888a("List is null");
        } else if (!translationListManager.updateTTSPlayStart(str)) {
            m2888a("There is no such id " + str);
        } else {
            m2894e(translationListManager.get(str));
            m2900k(translationListManager.get(str));
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void onTranslationEnd(TranslationData translationData) {
        m2890b("onTranslationEnd " + translationData.getTranslatedText());
        TranslationListManagerInterface translationListManager = MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationListManager();
        if (translationListManager == null) {
            m2888a("List is null");
            return;
        }
        translationListManager.updateTranslationEnd(translationData);
        m2893d(translationListManager.get(translationData.getID()));
        m2899j(translationListManager.get(translationData.getID()));
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void onTranslationStart(TranslationData translationData) {
        m2890b("onTranslationStart");
        TranslationListManagerInterface translationListManager = MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationListManager();
        if (translationListManager == null) {
            m2888a("List is null");
        } else {
            translationListManager.updateTranslationStart(translationData);
            m2892c(translationListManager.get(translationData.getID()));
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void receiveRecognitionEnd(TranslationData translationData) {
        m2890b("receiveRecognitionEnd() " + translationData.getRecognizedText());
        TranslationListManagerInterface translationListManager = MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationListManager();
        if (translationListManager == null) {
            m2888a("List is null");
            return;
        }
        translationListManager.updateRecognitionEnd(translationData);
        m2889b(translationListManager.get(translationData.getID()));
        if (C1248b.m2882a(translationData.getRecognizedText())) {
            return;
        }
        translationListManager.removeListData(translationData.getID());
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void receiveRecognitionStart(TranslationData translationData) {
        m2890b("receiveRecognitionStart()");
        TranslationListManagerInterface translationListManager = MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationListManager();
        if (translationListManager == null) {
            m2888a("List is null");
        } else {
            translationListManager.updateRecognitionStart(translationData);
            m2887a(translationListManager.get(translationData.getID()));
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void receiveRecognitionStop() {
        m2890b("receiveRecognitionStop() ");
        m2885a();
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void receiveTTSPlayEnd(String str) {
        m2890b("receiveTTSPlayEnd() ");
        TranslationListManagerInterface translationListManager = MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationListManager();
        if (translationListManager == null) {
            m2888a("List is null");
        } else if (translationListManager.updateTTSPlayEnd(str)) {
            m2895f(translationListManager.get(str));
        } else {
            m2888a("There is no such id " + str);
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void receiveTTSPlayStart(String str) {
        m2890b("receiveTTSPlayStart() ");
        TranslationListManagerInterface translationListManager = MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationListManager();
        if (translationListManager == null) {
            m2888a("List is null");
        } else if (translationListManager.updateTTSPlayStart(str)) {
            m2894e(translationListManager.get(str));
        } else {
            m2888a("There is no such id " + str);
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void receiveTranslationEnd(TranslationData translationData) {
        m2890b("receiveTranslationEnd() " + translationData.toString());
        TranslationListManagerInterface translationListManager = MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationListManager();
        if (translationListManager == null) {
            m2888a("List is null");
        } else {
            translationListManager.updateRecognitionEnd(translationData);
            m2889b(translationListManager.get(translationData.getID()));
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void receiveTranslationStart(TranslationData translationData) {
        m2890b("receiveTranslationStart()");
        TranslationListManagerInterface translationListManager = MainApplication.mPhoneManager.getPhoneStateMachine().getTranslationListManager();
        if (translationListManager == null) {
            m2888a("List is null");
        } else {
            translationListManager.updateTranslationStart(translationData);
            m2892c(translationListManager.get(translationData.getID()));
        }
    }

    @Override // com.sds.coolots.common.controller.translation.TranslationNotificationManagerInterface
    public void sendToOtherpartyRecognitionStop() {
        m2890b("sendToOtherpartyRecognitionStop");
        RecognitionAsk recognitionAsk = new RecognitionAsk();
        recognitionAsk.setID(null);
        recognitionAsk.setUserID(null);
        recognitionAsk.setVoiceLanguage(0);
        recognitionAsk.setRecognitionLanguage(0);
        recognitionAsk.setRecognizedText(null);
        recognitionAsk.setIsRecognitionStart(false);
        recognitionAsk.setNationalFlag(0);
        m2886a(C1149a.m2140a(MessageInfo.RecognitionAsk.getServiceCode(), MessageInfo.RecognitionAsk.getMessageCode()), recognitionAsk);
    }
}
