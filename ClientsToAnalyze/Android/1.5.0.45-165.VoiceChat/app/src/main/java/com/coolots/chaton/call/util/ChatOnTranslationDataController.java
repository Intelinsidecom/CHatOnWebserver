package com.coolots.chaton.call.util;

import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class ChatOnTranslationDataController implements DisposeInterface {
    private ArrayList<TranslationDisplayTTSData> TranslationTTSList = new ArrayList<>();

    public static class TranslationDisplayTTSData {
        public static final int READ_STATE_DONE = 2;
        public static final int READ_STATE_INIT = 0;
        public static final int READ_STATE_NOT_DONE = 1;
        private TranslationDisplayData mData;
        private boolean mIsGuest;
        private int mTTSReadDone = 1;

        public TranslationDisplayTTSData(TranslationDisplayData data, boolean isguest) {
            this.mIsGuest = false;
            this.mData = data;
            this.mIsGuest = isguest;
        }

        public TranslationDisplayData getTranslationDisplayData() {
            return this.mData;
        }

        public void setTTSReadDone(int setValue) {
            this.mTTSReadDone = setValue;
        }

        public int getTTSReadDone() {
            return this.mTTSReadDone;
        }

        public void setOnOffGuestMode(boolean setValue) {
            this.mIsGuest = setValue;
        }

        public boolean getOnOffGuestMode() {
            return this.mIsGuest;
        }
    }

    public TranslationDisplayTTSData getFirstTranslationDisplayTTSData() {
        if (this.TranslationTTSList.size() <= 0) {
            return null;
        }
        for (int i = 0; i < this.TranslationTTSList.size(); i++) {
            if (this.TranslationTTSList.get(i).getTTSReadDone() != 2) {
                this.TranslationTTSList.get(i).setTTSReadDone(0);
            }
        }
        for (int i2 = this.TranslationTTSList.size() - 1; i2 > -1; i2--) {
            if (this.TranslationTTSList.get(i2).getTTSReadDone() == 0 && this.TranslationTTSList.get(i2).getOnOffGuestMode()) {
                return this.TranslationTTSList.get(i2);
            }
        }
        return null;
    }

    public TranslationDisplayTTSData getNextTranslationDisplayTTSData() {
        if (this.TranslationTTSList.size() <= 0) {
            return null;
        }
        for (int i = 0; i < this.TranslationTTSList.size(); i++) {
            if (this.TranslationTTSList.get(i).getTTSReadDone() == 1 && this.TranslationTTSList.get(i).getOnOffGuestMode()) {
                return this.TranslationTTSList.get(i);
            }
        }
        return null;
    }

    public void initTTSData() {
        if (this.TranslationTTSList.size() > 0) {
            this.TranslationTTSList.clear();
        }
    }

    public void addTranslationDisplayTTSData(TranslationDisplayTTSData data) {
        if (this.TranslationTTSList.size() > 0) {
            if (this.TranslationTTSList.indexOf(data) == -1) {
                this.TranslationTTSList.add(data);
                return;
            }
            return;
        }
        this.TranslationTTSList.add(data);
    }

    public boolean removeTranslationDisplayTTSData(String id) {
        if (this.TranslationTTSList.size() > 0) {
            Iterator<TranslationDisplayTTSData> it = this.TranslationTTSList.iterator();
            while (it.hasNext()) {
                TranslationDisplayTTSData data = it.next();
                if (data.getTranslationDisplayData().getID().equals(id)) {
                    this.TranslationTTSList.remove(data);
                    return true;
                }
            }
        }
        return false;
    }

    public TranslationDisplayTTSData getDataforId(String id) {
        if (this.TranslationTTSList.size() > 0) {
            Iterator<TranslationDisplayTTSData> it = this.TranslationTTSList.iterator();
            while (it.hasNext()) {
                TranslationDisplayTTSData TTSData = it.next();
                if (TTSData.getTranslationDisplayData().getID().equals(id)) {
                    return TTSData;
                }
            }
        }
        return null;
    }

    public int getDataSize() {
        if (this.TranslationTTSList.size() > 0) {
            return this.TranslationTTSList.size();
        }
        return 0;
    }

    public ArrayList<TranslationDisplayTTSData> getTranslationDisplayTTSData() {
        if (this.TranslationTTSList == null || this.TranslationTTSList.size() <= 0) {
            return null;
        }
        return this.TranslationTTSList;
    }

    public boolean setDoneTranslation(String id) {
        if (this.TranslationTTSList.size() > 0) {
            Iterator<TranslationDisplayTTSData> it = this.TranslationTTSList.iterator();
            while (it.hasNext()) {
                TranslationDisplayTTSData data = it.next();
                if (data.getTranslationDisplayData().getID().equals(id)) {
                    data.setTTSReadDone(2);
                    return true;
                }
            }
        }
        return false;
    }

    public void finish() {
        dispose();
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        initTTSData();
    }
}
