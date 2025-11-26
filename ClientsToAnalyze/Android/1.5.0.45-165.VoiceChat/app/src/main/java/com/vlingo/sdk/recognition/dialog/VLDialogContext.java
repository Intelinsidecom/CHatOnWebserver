package com.vlingo.sdk.recognition.dialog;

import com.vlingo.sdk.internal.util.StringUtils;
import com.vlingo.sdk.recognition.VLRecognitionContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class VLDialogContext extends VLRecognitionContext {
    private String dialogGUID;
    private byte[] dialogState;
    private int dialogTurnNumber;
    private HashMap<String, String> dmHeaderKVPairs;
    private List<VLDialogEvent> eventList;
    private String username;

    public static final class Builder extends VLRecognitionContext.Builder {
        private String dialogGUID;
        private byte[] dialogState;
        private String username;
        private int dialogTurnNumber = -1;
        private List<VLDialogEvent> eventList = new ArrayList();
        private HashMap<String, String> dmHeaderKVPairs = new HashMap<>();

        public Builder addEvent(VLDialogEvent event) {
            this.eventList.add(event);
            return this;
        }

        public Builder setState(byte[] state) {
            this.dialogState = state;
            return this;
        }

        public Builder setUsername(String name) {
            this.username = name;
            return this;
        }

        public Builder setDialogGUID(String guid) {
            this.dialogGUID = guid;
            return this;
        }

        public Builder setTurnNumber(int turn) {
            this.dialogTurnNumber = turn;
            return this;
        }

        public Builder addDMHeaderKVPair(String name, String value) {
            if (StringUtils.isNullOrWhiteSpace(name)) {
                throw new IllegalArgumentException("name cannot be null or empty");
            }
            this.dmHeaderKVPairs.put(name, value);
            return this;
        }

        @Override // com.vlingo.sdk.recognition.VLRecognitionContext.Builder
        public VLDialogContext build() {
            return new VLDialogContext(this, null);
        }
    }

    /* synthetic */ VLDialogContext(Builder builder, VLDialogContext vLDialogContext) {
        this(builder);
    }

    private VLDialogContext(Builder builder) {
        super(builder);
        this.dialogState = builder.dialogState;
        this.username = builder.username;
        this.dialogGUID = builder.dialogGUID;
        this.dialogTurnNumber = builder.dialogTurnNumber;
        this.eventList = new ArrayList(builder.eventList.size());
        this.eventList.addAll(builder.eventList);
        this.dmHeaderKVPairs = new HashMap<>(builder.dmHeaderKVPairs.size());
        this.dmHeaderKVPairs.putAll(builder.dmHeaderKVPairs);
    }

    public List<VLDialogEvent> getEvents() {
        return this.eventList;
    }

    public byte[] getDialogState() {
        return this.dialogState;
    }

    public String getUsername() {
        return this.username;
    }

    public String getDialogGUID() {
        return this.dialogGUID;
    }

    public int getDialogTurnNumber() {
        return this.dialogTurnNumber;
    }

    public HashMap<String, String> getDMHeaderKVPairs() {
        return this.dmHeaderKVPairs;
    }
}
