package com.vlingo.sdk.recognition.dialog;

import com.vlingo.sdk.recognition.dialog.VLDialogEvent;

/* loaded from: classes.dex */
public final class VLDialogEventFieldGroup extends VLDialogEvent {

    public static final class Builder extends VLDialogEvent.Builder {
        public Builder(String fieldGroupName) {
            super(fieldGroupName);
        }

        @Override // com.vlingo.sdk.recognition.dialog.VLDialogEvent.Builder
        public VLDialogEventFieldGroup build() {
            return new VLDialogEventFieldGroup(this, null);
        }
    }

    /* synthetic */ VLDialogEventFieldGroup(Builder builder, VLDialogEventFieldGroup vLDialogEventFieldGroup) {
        this(builder);
    }

    private VLDialogEventFieldGroup(Builder builder) {
        super(builder);
    }
}
