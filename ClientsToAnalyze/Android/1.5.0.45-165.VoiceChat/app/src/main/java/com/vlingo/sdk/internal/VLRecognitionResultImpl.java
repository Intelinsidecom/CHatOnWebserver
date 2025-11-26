package com.vlingo.sdk.internal;

import com.vlingo.sdk.internal.recognizer.results.SRRecognitionResponse;
import com.vlingo.sdk.internal.recognizer.results.TaggedResults;
import com.vlingo.sdk.internal.vlservice.response.Action;
import com.vlingo.sdk.internal.vlservice.response.ActionList;
import com.vlingo.sdk.recognition.NBestData;
import com.vlingo.sdk.recognition.VLAction;
import com.vlingo.sdk.recognition.VLRecognitionResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class VLRecognitionResultImpl implements VLRecognitionResult {
    private List<VLAction> mActionList;
    private String mDialogGuid;
    private byte[] mDialogState;
    private int mDialogTurn;
    private String mGUttId;
    private NBestData mNBestData;
    private String mResult;

    public VLRecognitionResultImpl(SRRecognitionResponse response) {
        ActionList actionList;
        int listSize;
        if (response != null) {
            TaggedResults results = response.getResults();
            if (results != null) {
                this.mGUttId = response.getResults().getGUttID();
                this.mResult = results.getUttResults().toString();
                this.mNBestData = new NBestData(results.getUttResults());
            }
            this.mDialogGuid = response.getDialogGuid();
            this.mDialogTurn = response.getDialogTurn();
            this.mDialogState = response.getDialogState();
            if (response.hasActions() && (listSize = (actionList = response.getActionList()).size()) > 0) {
                this.mActionList = new ArrayList(listSize);
                for (int i = 0; i < listSize; i++) {
                    Action action = actionList.elementAt(i);
                    this.mActionList.add(new VLActionImpl(action));
                }
            }
        }
    }

    @Override // com.vlingo.sdk.recognition.VLRecognitionResult
    public String getGUttId() {
        return this.mGUttId;
    }

    @Override // com.vlingo.sdk.recognition.VLRecognitionResult
    public String getDialogGUID() {
        return this.mDialogGuid;
    }

    @Override // com.vlingo.sdk.recognition.VLRecognitionResult
    public int getDialogTurn() {
        return this.mDialogTurn;
    }

    @Override // com.vlingo.sdk.recognition.VLRecognitionResult
    public byte[] getDialogState() {
        return this.mDialogState;
    }

    @Override // com.vlingo.sdk.recognition.VLRecognitionResult
    public String getResultString() {
        return this.mResult;
    }

    @Override // com.vlingo.sdk.recognition.VLRecognitionResult
    public List<VLAction> getActions() {
        return this.mActionList;
    }

    @Override // com.vlingo.sdk.recognition.VLRecognitionResult
    public NBestData getNBestData() {
        return this.mNBestData;
    }
}
