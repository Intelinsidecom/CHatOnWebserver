package com.coolots.chaton.call.view.layout;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.util.ITranslatorViewController;
import com.coolots.chaton.call.util.TranslatorPopupTime;
import com.coolots.chaton.call.view.StrokeTextView;
import com.coolots.chaton.common.util.BuddyImageView;
import com.sds.coolots.MainApplication;
import com.sds.coolots.call.model.Destination;
import com.sds.coolots.common.controller.translation.data.TranslationDisplayData;
import com.sds.coolots.common.util.Log;
import com.sds.coolots.common.view.DisposeInterface;
import java.io.IOException;

/* loaded from: classes.dex */
public class CallTranslatorScrollViewLayout extends ScrollView implements ITranslatorViewController, DisposeInterface {
    private static final String CLASSNAME = "[VoiceCallTranslatorLayout]";
    private final String RECOGNITION_TAG;
    private Context mContex;
    private Destination mDestination;
    private String mGuestAccoutId;
    private String mGuestName;
    private LinearLayout mTranslatorContentLayout;
    private boolean visibleDurationPopup;

    private static void logI(String message) {
        Log.m2963i(CLASSNAME + message);
    }

    public CallTranslatorScrollViewLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContex = null;
        this.mGuestName = null;
        this.RECOGNITION_TAG = "RECOG_ID_";
        this.visibleDurationPopup = false;
        this.mContex = context;
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(C0000R.layout.voice_call_translator_content, (ViewGroup) this, true);
        this.mTranslatorContentLayout = (LinearLayout) findViewById(C0000R.id.translator_content_layout);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Log.m2958e("YKYU onTouchEvent()");
        return false;
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void setGuestName(String guestName) {
        this.mGuestName = guestName;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        logI("onWindowVisibilityChanged : " + visibility);
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void addtHostTranslatePopup(TranslationDisplayData data, boolean OnlyIncomingMessage) throws IOException {
        LayoutInflater inflater = LayoutInflater.from(this.mContex);
        LinearLayout HostTranslatorPopupLayout = (LinearLayout) inflater.inflate(C0000R.layout.voice_call_translator_content_host_item, (ViewGroup) null);
        TextView tv = (TextView) HostTranslatorPopupLayout.findViewById(C0000R.id.voice_call_translator_host_text);
        TextView translator_tv = (TextView) HostTranslatorPopupLayout.findViewById(C0000R.id.voice_call_translator_host_translator_text);
        if (data.getInLanguage() == data.getOutLanguage() || OnlyIncomingMessage) {
            tv.setText(data.getRecognizedText());
            translator_tv.setVisibility(8);
        } else {
            tv.setText(data.getRecognizedText());
            translator_tv.setText(data.getTranslatedText());
        }
        BuddyImageView hostPhoto = (BuddyImageView) HostTranslatorPopupLayout.findViewById(C0000R.id.voice_call_host_image);
        hostPhoto.setImageViewMode(0);
        hostPhoto.loadThumbImage(MainApplication.mConfig.getProfileUserID());
        StrokeTextView timepopup = (StrokeTextView) HostTranslatorPopupLayout.findViewById(C0000R.id.voice_call_translator_host_time_text);
        timepopup.setText(new TranslatorPopupTime().getCurrentTime(this.mContex));
        HostTranslatorPopupLayout.setTag(data.getID());
        this.mTranslatorContentLayout.addView(HostTranslatorPopupLayout);
        moveToAddTranslatePopup(data.getID());
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void removeGuestTranslatePopup(TranslationDisplayData data) throws IOException {
        LayoutInflater inflater = LayoutInflater.from(this.mContex);
        LinearLayout GuestTranslatorPopupLayout = (LinearLayout) inflater.inflate(C0000R.layout.voice_call_translator_content_guest_item, (ViewGroup) null);
        StrokeTextView guestName_tv = (StrokeTextView) GuestTranslatorPopupLayout.findViewById(C0000R.id.voice_call_translator_guest_name);
        TextView tv = (TextView) GuestTranslatorPopupLayout.findViewById(C0000R.id.voice_call_translator_guest_text);
        TextView translator_tv = (TextView) GuestTranslatorPopupLayout.findViewById(C0000R.id.voice_call_translator_guest_translator_text);
        BuddyImageView guestPhoto = (BuddyImageView) GuestTranslatorPopupLayout.findViewById(C0000R.id.voice_call_guest_image);
        guestPhoto.setImageViewMode(0);
        guestPhoto.loadThumbImage(this.mGuestAccoutId);
        guestName_tv.setText(this.mGuestName);
        if (data.getInLanguage() == data.getOutLanguage()) {
            tv.setText(data.getRecognizedText());
            translator_tv.setVisibility(8);
        } else {
            tv.setText(data.getRecognizedText());
            translator_tv.setText(data.getTranslatedText());
        }
        StrokeTextView timepopup = (StrokeTextView) GuestTranslatorPopupLayout.findViewById(C0000R.id.voice_call_translator_guest_time_text);
        timepopup.setText(new TranslatorPopupTime().getCurrentTime(this.mContex));
        GuestTranslatorPopupLayout.setTag(data.getID());
        this.mTranslatorContentLayout.addView(GuestTranslatorPopupLayout);
        moveToAddTranslatePopup(data.getID());
    }

    public void moveToAddTranslatePopup(String Tag) {
        for (int i = 0; i < this.mTranslatorContentLayout.getChildCount(); i++) {
            LinearLayout tempLayout = (LinearLayout) this.mTranslatorContentLayout.getChildAt(i);
            String recong_id = (String) tempLayout.getTag();
            if (recong_id.equals(Tag)) {
                requestChildFocus(this.mTranslatorContentLayout, this.mTranslatorContentLayout.getChildAt(i));
                return;
            }
        }
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void startDurationTranslatePopup(TranslationDisplayData data, boolean isGuest) {
        LinearLayout DuringPopupLayout;
        if (this.visibleDurationPopup) {
            LayoutInflater inflater = LayoutInflater.from(this.mContex);
            if (isGuest) {
                DuringPopupLayout = (LinearLayout) inflater.inflate(C0000R.layout.voice_call_translator_guest_duration_item, (ViewGroup) null);
            } else {
                DuringPopupLayout = (LinearLayout) inflater.inflate(C0000R.layout.voice_call_translator_host_duration_item, (ViewGroup) null);
            }
            DuringPopupLayout.setTag("RECOG_ID_" + data.getID());
            this.mTranslatorContentLayout.addView(DuringPopupLayout);
        }
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void endDurationTranslatePopup(TranslationDisplayData data) {
        if (this.visibleDurationPopup) {
            for (int i = 0; i < this.mTranslatorContentLayout.getChildCount(); i++) {
                LinearLayout tempLayout = (LinearLayout) this.mTranslatorContentLayout.getChildAt(i);
                String recong_id = (String) tempLayout.getTag();
                if (recong_id.equals("RECOG_ID_" + data.getID())) {
                    this.mTranslatorContentLayout.removeViewAt(i);
                    return;
                }
            }
        }
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void visibleTranslatorIcon(String Id) throws Resources.NotFoundException {
        addTranslatorIcon(Id);
    }

    @Override // com.coolots.chaton.call.util.ITranslatorViewController
    public void goneTranslatorIcon(String Id) {
    }

    private void addTranslatorIcon(String Id) throws Resources.NotFoundException {
        for (int i = 0; i < this.mTranslatorContentLayout.getChildCount(); i++) {
            LinearLayout tempLayout = (LinearLayout) this.mTranslatorContentLayout.getChildAt(i);
            String bubbleId = (String) tempLayout.getTag();
            if (bubbleId.equals(Id)) {
                TextView tv = (TextView) tempLayout.findViewById(C0000R.id.voice_call_translator_guest_text);
                TextView translator_tv = (TextView) tempLayout.findViewById(C0000R.id.voice_call_translator_guest_translator_text);
                Drawable tts_speak_icon = getResources().getDrawable(C0000R.drawable.translator_done_selector);
                tts_speak_icon.setBounds(0, 0, tts_speak_icon.getIntrinsicWidth(), tts_speak_icon.getIntrinsicHeight());
                if (translator_tv == null || translator_tv.getVisibility() == 8) {
                    if (tv != null) {
                        tv.setText(((Object) tv.getText()) + "  ");
                        tv.setCompoundDrawables(null, null, tts_speak_icon, null);
                        return;
                    }
                    return;
                }
                translator_tv.setText(((Object) translator_tv.getText()) + "  ");
                translator_tv.setCompoundDrawables(null, null, tts_speak_icon, null);
                return;
            }
        }
    }

    private String getPopupString(String Id) {
        for (int i = 0; i < this.mTranslatorContentLayout.getChildCount(); i++) {
            LinearLayout tempLayout = (LinearLayout) this.mTranslatorContentLayout.getChildAt(i);
            String bubbleId = (String) tempLayout.getTag();
            if (bubbleId.equals(Id)) {
                TextView tv = (TextView) tempLayout.findViewById(C0000R.id.voice_call_translator_guest_text);
                TextView translator_tv = (TextView) tempLayout.findViewById(C0000R.id.voice_call_translator_guest_translator_text);
                if (translator_tv.getVisibility() == 8) {
                    return tv.getText().toString();
                }
                return translator_tv.getText().toString();
            }
        }
        return null;
    }
}
