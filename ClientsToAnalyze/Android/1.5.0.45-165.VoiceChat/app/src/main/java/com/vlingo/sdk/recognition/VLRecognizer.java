package com.vlingo.sdk.recognition;

import com.vlingo.sdk.VLComponent;
import com.vlingo.sdk.internal.recognizer.XMLResponseListener;
import com.vlingo.sdk.recognition.dialog.VLDialogContext;

/* loaded from: classes.dex */
public interface VLRecognizer extends VLComponent {
    void acceptedText(String str, String str2);

    void addXMLResponseListener(XMLResponseListener xMLResponseListener);

    void cancelRecognition();

    String[] getSupportedLanguageList();

    void removeXMLResponseListener(XMLResponseListener xMLResponseListener);

    void sendEvent(VLDialogContext vLDialogContext, VLRecognitionListener vLRecognitionListener);

    void startRecognition(VLRecognitionContext vLRecognitionContext, VLRecognitionListener vLRecognitionListener);

    void stopRecognition();
}
