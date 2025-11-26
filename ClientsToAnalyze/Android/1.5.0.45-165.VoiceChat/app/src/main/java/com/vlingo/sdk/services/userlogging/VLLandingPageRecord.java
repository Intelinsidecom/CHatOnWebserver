package com.vlingo.sdk.services.userlogging;

import com.vlingo.sdk.internal.util.XmlUtils;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class VLLandingPageRecord {
    private int actionCount;
    private int actionNoEditCount;
    private int actionUtteranceCount;
    private int alternativePhrasePickedCount;
    private int backCount;
    private int backNoEditCount;
    private int backUtteranceCount;
    private int contactChangeCount;
    private List<TextFieldRecord> fields = new LinkedList();
    private int fromEmailChangedCount;
    private int launchCount;
    private long launchTimeTotal;
    private int noteTypeChangeCount;
    private String pageId;
    private int phoneChangeCount;
    private int undoCount;
    private int viewCount;

    public static class Builder {
        private int actionCount;
        private int actionNoEditCount;
        private int actionUtteranceCount;
        private int alternativePhrasePickedCount;
        private int backCount;
        private int backNoEditCount;
        private int backUtteranceCount;
        private int contactChangeCount;
        private boolean fieldLoggingEnabled;
        private List<TextFieldRecord> fields = new LinkedList();
        private int fromEmailChangedCount;
        private int launchCount;
        private long launchTimeTotal;
        private int noteTypeChangeCount;
        private String pageId;
        private int phoneChangeCount;
        private int undoCount;
        private int viewCount;

        public Builder(String pageId, boolean doFieldLogging) {
            this.pageId = pageId;
            this.fieldLoggingEnabled = doFieldLogging;
        }

        public Builder fromEmailChanged() {
            this.fromEmailChangedCount++;
            return this;
        }

        public Builder alterPhrasePicked() {
            this.alternativePhrasePickedCount++;
            return this;
        }

        public Builder incrContactChange() {
            this.contactChangeCount++;
            return this;
        }

        public Builder incrPhoneChange() {
            this.phoneChangeCount++;
            return this;
        }

        public Builder incrNoteChanged() {
            this.noteTypeChangeCount++;
            return this;
        }

        public Builder incrUndoCount() {
            this.undoCount++;
            return this;
        }

        public Builder pageViewed() {
            this.viewCount++;
            return this;
        }

        public Builder actionClicked(List<TextFieldUsageCounts> textFieldData) {
            updateTextFieldRecords(textFieldData, true);
            if (noTextFieldEdits(textFieldData)) {
                this.actionNoEditCount++;
            } else {
                this.actionCount++;
            }
            return this;
        }

        public Builder backClicked(List<TextFieldUsageCounts> textFieldData) {
            updateTextFieldRecords(textFieldData, false);
            if (noTextFieldEdits(textFieldData)) {
                this.backNoEditCount++;
            } else {
                this.backCount++;
            }
            return this;
        }

        public Builder addLaunchTime(long time) {
            this.launchTimeTotal += time;
            this.launchCount++;
            return this;
        }

        public int getFieldCount() {
            return this.fields.size();
        }

        private void updateTextFieldRecords(List<TextFieldUsageCounts> textFieldData, boolean action) {
            if (this.fieldLoggingEnabled && textFieldData != null) {
                for (int i = 0; i < textFieldData.size(); i++) {
                    TextFieldUsageCounts fieldData = textFieldData.get(i);
                    TextFieldRecord rec = getTextFieldRecord(fieldData.getFieldID());
                    rec.update(fieldData);
                    if (action) {
                        this.actionUtteranceCount += fieldData.getCountRecognitions();
                    } else {
                        this.backUtteranceCount += fieldData.getCountRecognitions();
                    }
                }
            }
        }

        private boolean noTextFieldEdits(List<TextFieldUsageCounts> textFieldData) {
            if (textFieldData != null) {
                for (int i = 0; i < textFieldData.size(); i++) {
                    if (textFieldData.get(i).isEdited()) {
                        return false;
                    }
                }
            }
            return true;
        }

        private TextFieldRecord getTextFieldRecord(String fieldId) {
            for (TextFieldRecord rec : this.fields) {
                if (rec.getFieldId().equals(fieldId)) {
                    return rec;
                }
            }
            TextFieldRecord rec2 = new TextFieldRecord(fieldId);
            this.fields.add(rec2);
            return rec2;
        }

        public VLLandingPageRecord build() {
            return new VLLandingPageRecord(this);
        }
    }

    VLLandingPageRecord(Builder builder) {
        this.pageId = builder.pageId;
        this.viewCount = builder.viewCount;
        this.launchTimeTotal = builder.launchTimeTotal;
        this.launchCount = builder.launchCount;
        this.backCount = builder.backCount;
        this.backNoEditCount = builder.backNoEditCount;
        this.backUtteranceCount = builder.backUtteranceCount;
        this.actionCount = builder.actionCount;
        this.actionNoEditCount = builder.actionNoEditCount;
        this.actionUtteranceCount = builder.actionUtteranceCount;
        this.fromEmailChangedCount = builder.fromEmailChangedCount;
        this.alternativePhrasePickedCount = builder.alternativePhrasePickedCount;
        this.contactChangeCount = builder.contactChangeCount;
        this.phoneChangeCount = builder.phoneChangeCount;
        this.noteTypeChangeCount = builder.noteTypeChangeCount;
        this.undoCount = builder.undoCount;
        this.fields.addAll(builder.fields);
    }

    public String getPageId() {
        return this.pageId;
    }

    String generateXml() {
        float launchTimeAvg = this.launchCount == 0 ? VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET : this.launchTimeTotal / this.launchCount;
        StringBuilder sb = new StringBuilder();
        sb.append("<landing-page page-id=\"" + XmlUtils.xmlEncode(this.pageId) + "\" count=\"" + this.viewCount + "\" launch-time-avg=\"" + launchTimeAvg + "\" back-count=\"" + this.backCount + "\" back-noedit-count=\"" + this.backNoEditCount + "\" back-utt-avg=\"" + this.backUtteranceCount + "\" action-count=\"" + this.actionCount + "\" action-noedit-count=\"" + this.actionNoEditCount + "\" action-utt-avg=\"" + this.actionUtteranceCount + "\" from-email-count=\"" + this.fromEmailChangedCount + "\" undo-count=\"" + this.undoCount + "\" alternative-count=\"" + this.alternativePhrasePickedCount + "\" contact-change-count=\"" + this.contactChangeCount + "\" phone-change-count=\"" + this.phoneChangeCount + "\" note-change-count=\"" + this.noteTypeChangeCount + "\">");
        for (TextFieldRecord field : this.fields) {
            sb.append(field.generateXml());
        }
        sb.append("</landing-page>");
        return sb.toString();
    }

    private static class TextFieldRecord {
        private int clearCount;
        private int deleteCount;
        private String fieldId;
        private int fixAcceptCount;
        private int fixInvokeCount;
        private int keyCount;
        private int recognitionCount;

        TextFieldRecord(String fieldId) {
            this.fieldId = fieldId;
        }

        void update(TextFieldUsageCounts counts) {
            this.fixInvokeCount += counts.getCountFixInvoke();
            this.fixAcceptCount += counts.getCountFixAccept();
            this.clearCount += counts.getCountClears();
            this.keyCount += counts.getCountKeys();
            this.deleteCount += counts.getCountDeletes();
            this.recognitionCount += counts.getCountRecognitions();
        }

        String generateXml() {
            StringBuilder sb = new StringBuilder();
            sb.append("<field field-id=\"" + XmlUtils.xmlEncode(this.fieldId) + "\" fix-invoke-count=\"" + this.fixInvokeCount + "\" fix-accept-count=\"" + this.fixAcceptCount + "\" clear-count=\"" + this.clearCount + "\" key-count=\"" + this.keyCount + "\" char-delete-count=\"" + this.deleteCount + "\" char-recs-count=\"" + this.recognitionCount + "\"/>");
            return sb.toString();
        }

        String getFieldId() {
            return this.fieldId;
        }
    }

    public static class TextFieldUsageCounts {
        private String fieldID;
        private HashMap<String, Integer> usageCounts;

        public TextFieldUsageCounts(String fieldID, HashMap<String, Integer> counts) {
            this.fieldID = fieldID;
            this.usageCounts = counts;
        }

        public String getFieldID() {
            return this.fieldID;
        }

        public int getCountFixInvoke() {
            return -1;
        }

        public int getCountFixAccept() {
            return getCount("NBCOR");
        }

        public int getCountClears() {
            return getCount("CLR");
        }

        public int getCountKeys() {
            return getCount("KEY") + getCount("NAV");
        }

        public int getCountDeletes() {
            return getCount("CDEL") + getCount("WDEL");
        }

        public int getCountRecognitions() {
            return getCount("CREC") + getCount("WREC");
        }

        public boolean isEdited() {
            return getCountKeys() > 0 || getCountDeletes() > 0 || getCountClears() > 0 || getCountFixAccept() > 0 || getCountRecognitions() > 0;
        }

        private int getCount(String name) {
            try {
                return this.usageCounts.get(name).intValue();
            } catch (Exception e) {
                return -1;
            }
        }
    }
}
