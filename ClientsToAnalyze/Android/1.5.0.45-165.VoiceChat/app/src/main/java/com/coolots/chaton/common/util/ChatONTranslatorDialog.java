package com.coolots.chaton.common.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.coolots.chaton.call.util.ITranslatorDialog;
import com.sds.coolots.common.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes.dex */
public class ChatONTranslatorDialog extends Dialog implements DialogInterface {
    private static final String CLASSNAME = "[ChatONTranslatorDialog]";

    private static void logE(String message) {
        Log.m2958e(CLASSNAME + message);
    }

    public ChatONTranslatorDialog(Context context, int theme) {
        super(context, theme);
    }

    public ChatONTranslatorDialog(Context context) {
        super(context);
    }

    public static class Builder {
        private ArrayList<String> addFirstCountryList;
        private ArrayList<String> addSecondCountryList;
        private boolean cancelable;
        private Context context;
        private Spinner countrySpinnerMiddle;
        private Spinner countrySpinnerTop;
        private CheckBox incomingMsgOnly;
        private int mDialogMode;
        public DialogInterface.OnCancelListener mOnCancelListener;
        private Button mPositiveBtn;
        private Set<Integer> mSupportLanguageSet;
        private Set<Integer> mSupportOutLanguageSet;
        private String messageTop;
        private BuddyImageView myImage;
        private String myImageID;
        private String myName;
        private TextView myNameText;
        private DialogInterface.OnClickListener negativeButtonClickListener;
        private String negativeButtonText;
        private BuddyImageView otherPartyImage;
        private String otherPartyImageID;
        private String otherPartyName;
        private TextView otherPartyNameText;
        private DialogInterface.OnClickListener positiveButtonClickListener;
        private String positiveButtonText;
        private String title;
        private ITranslatorDialog translatorDialogInterface;
        private View view;
        private ArrayAdapter<String> spinnerTopAdapter = null;
        private ArrayAdapter<String> spinnerMiddleAdapter = null;
        private int topLanguageCode = -1;
        private int middleLanguageCode = -1;
        private String topLanguageCodeToString = null;
        private String middleLanguageCodeToString = null;
        private int mTitleIcon = 0;
        private FrameLayout customPanel = null;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder(Context context, ITranslatorDialog translatorDialogInterface, Set<Integer> supportLanguageSet) {
            this.context = context;
            this.mSupportLanguageSet = supportLanguageSet;
            this.translatorDialogInterface = translatorDialogInterface;
        }

        public Builder(Context context, int mode) {
            this.context = context;
            this.mDialogMode = mode;
        }

        public Builder setMessageTop(String message) {
            this.messageTop = message;
            return this;
        }

        public Builder setMessageTop(CharSequence message) {
            this.messageTop = (String) message;
            return this;
        }

        public Builder setMessageTop(int message) {
            this.messageTop = (String) this.context.getText(message);
            return this;
        }

        public Builder setTitle(int title) {
            this.title = (String) this.context.getText(title);
            return this;
        }

        public Builder setTitle(CharSequence title) {
            this.title = (String) title;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setView(View view) {
            this.view = view;
            return this;
        }

        public Builder setPositiveButton(int positiveButtonText, DialogInterface.OnClickListener listener) {
            this.positiveButtonText = (String) this.context.getText(positiveButtonText);
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText, DialogInterface.OnClickListener listener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setPositiveButton(CharSequence positiveButtonText, DialogInterface.OnClickListener listener) {
            this.positiveButtonText = (String) positiveButtonText;
            this.positiveButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(int negativeButtonText, DialogInterface.OnClickListener listener) {
            this.negativeButtonText = (String) this.context.getText(negativeButtonText);
            this.negativeButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonText, DialogInterface.OnClickListener listener) {
            this.negativeButtonText = negativeButtonText;
            this.negativeButtonClickListener = listener;
            return this;
        }

        public Builder setNegativeButton(CharSequence negativeButtonText, DialogInterface.OnClickListener listener) {
            this.negativeButtonText = (String) negativeButtonText;
            this.negativeButtonClickListener = listener;
            return this;
        }

        public Builder setIcon(int titleIcon) {
            this.mTitleIcon = titleIcon;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.mOnCancelListener = onCancelListener;
            return this;
        }

        public ChatONTranslatorDialog show() throws IOException {
            ChatONTranslatorDialog dialog = create();
            dialog.show();
            return dialog;
        }

        public Button getPositiveButton() {
            return this.mPositiveBtn;
        }

        public void setTopCountryLanguageCode(int topLanguageCode) {
            this.topLanguageCode = topLanguageCode;
        }

        public void setMiddleCountryLanguageCode(int middleLanguageCode) {
            this.middleLanguageCode = middleLanguageCode;
        }

        public void setMiddleCountryLanguageCode(int middleLanguageCode, Set<Integer> supportOutLanguageSet) {
            this.middleLanguageCode = middleLanguageCode;
            this.mSupportOutLanguageSet = supportOutLanguageSet;
        }

        public int getTopCountryLanguageCode() {
            return this.topLanguageCode;
        }

        public int getMiddleCountryLanguageCode() {
            return this.middleLanguageCode;
        }

        public void setMyImage(String myImageID) {
            this.myImageID = myImageID;
        }

        public void setMyName(String myName) {
            this.myName = myName;
        }

        public void setOtherPartyImage(String otherPartyImageID) {
            this.otherPartyImageID = otherPartyImageID;
        }

        public void setOtherPartyName(String otherPartyName) {
            this.otherPartyName = otherPartyName;
        }

        public ChatONTranslatorDialog create() throws IOException {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            final ChatONTranslatorDialog dialog = new ChatONTranslatorDialog(this.context, C0000R.style.Dialog);
            View layout = inflater.inflate(C0000R.layout.chatonv_custom_translator_dialog, (ViewGroup) null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(-1, -2));
            dialog.setCancelable(this.cancelable);
            ((TextView) layout.findViewById(C0000R.id.general_dialog_title)).setText(this.title);
            this.countrySpinnerTop = (Spinner) layout.findViewById(C0000R.id.add_country_spinner_top);
            this.countrySpinnerMiddle = (Spinner) layout.findViewById(C0000R.id.add_country_spinner_middle);
            if (this.addFirstCountryList == null) {
                this.addFirstCountryList = new ArrayList<>();
            }
            if (this.addSecondCountryList == null) {
                this.addSecondCountryList = new ArrayList<>();
            }
            ChatONTranslatorDialog.setSpinnerItemList(this.mSupportLanguageSet, this.addFirstCountryList);
            this.spinnerTopAdapter = new ArrayAdapter<>(this.context, C0000R.layout.translator_spinner_item, this.addFirstCountryList);
            this.spinnerMiddleAdapter = new ArrayAdapter<>(this.context, C0000R.layout.translator_spinner_item, this.addSecondCountryList);
            this.spinnerTopAdapter.setDropDownViewResource(C0000R.layout.translator_spinner_dropdown_item);
            this.spinnerMiddleAdapter.setDropDownViewResource(C0000R.layout.translator_spinner_dropdown_item);
            this.countrySpinnerTop.setAdapter((SpinnerAdapter) this.spinnerTopAdapter);
            this.countrySpinnerMiddle.setAdapter((SpinnerAdapter) this.spinnerMiddleAdapter);
            int firstLangIndex = this.addFirstCountryList.indexOf(ChatONTranslatorDialog.changeToStringLangCode(this.topLanguageCode));
            if (firstLangIndex == -1) {
                firstLangIndex = 0;
            }
            this.countrySpinnerTop.setSelection(firstLangIndex);
            this.countrySpinnerTop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.coolots.chaton.common.util.ChatONTranslatorDialog.Builder.1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> arg0, View arg1, int topIndex, long arg3) {
                    int topSelectionLangCode = ChatONTranslatorDialog.changeToLangCode((String) Builder.this.addFirstCountryList.get(topIndex));
                    Builder.this.setTopCountryLanguageCode(topSelectionLangCode);
                    Set<Integer> mSupportOutLanguageSet = Builder.this.translatorDialogInterface.sendTranslatorHostLanguage(topSelectionLangCode);
                    if (Builder.this.spinnerMiddleAdapter != null && mSupportOutLanguageSet != null) {
                        Builder.this.spinnerMiddleAdapter.clear();
                        Builder.this.addSecondCountryList.clear();
                        Builder.this.addSecondCountryList = new ArrayList();
                        ChatONTranslatorDialog.setSpinnerItemList(mSupportOutLanguageSet, Builder.this.addSecondCountryList);
                        Builder.this.spinnerMiddleAdapter.addAll(Builder.this.addSecondCountryList);
                        Builder.this.countrySpinnerMiddle.setSelection(0);
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });
            this.countrySpinnerMiddle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.coolots.chaton.common.util.ChatONTranslatorDialog.Builder.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> arg0, View arg1, int middleIndex, long arg3) {
                    int middleSelectionLangCode = ChatONTranslatorDialog.changeToLangCode((String) Builder.this.addSecondCountryList.get(middleIndex));
                    Builder.this.setMiddleCountryLanguageCode(middleSelectionLangCode);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });
            if (this.positiveButtonText != null) {
                this.mPositiveBtn = (Button) layout.findViewById(C0000R.id.general_dialog_positive_btn);
                this.mPositiveBtn.setText(this.positiveButtonText);
                if (this.positiveButtonClickListener != null) {
                    ((Button) layout.findViewById(C0000R.id.general_dialog_positive_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.common.util.ChatONTranslatorDialog.Builder.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            Builder.this.positiveButtonClickListener.onClick(dialog, -1);
                            dialog.dismiss();
                        }
                    });
                }
            }
            if (this.negativeButtonText != null) {
                ((Button) layout.findViewById(C0000R.id.general_dialog_negative_btn)).setText(this.negativeButtonText);
                if (this.negativeButtonClickListener != null) {
                    ((Button) layout.findViewById(C0000R.id.general_dialog_negative_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.common.util.ChatONTranslatorDialog.Builder.4
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            Builder.this.negativeButtonClickListener.onClick(dialog, -2);
                            dialog.dismiss();
                        }
                    });
                }
            }
            if (this.messageTop != null) {
                ((TextView) layout.findViewById(C0000R.id.general_dialog_message_top)).setText(this.messageTop);
            }
            dialog.setOnCancelListener(this.mOnCancelListener);
            ViewGroup.MarginLayoutParams margin_general_dialog_title = new ViewGroup.MarginLayoutParams(layout.findViewById(C0000R.id.general_dialog_title).getLayoutParams());
            if (this.mTitleIcon != 0) {
                layout.findViewById(C0000R.id.general_dialog_title_image).setVisibility(0);
                layout.findViewById(C0000R.id.general_dialog_title_image).setBackgroundResource(this.mTitleIcon);
                margin_general_dialog_title.setMargins(10, 0, 0, 0);
            } else {
                layout.findViewById(C0000R.id.general_dialog_title_image).setVisibility(8);
                margin_general_dialog_title.setMargins(17, 0, 0, 0);
            }
            if (this.view != null) {
                FrameLayout custom = (FrameLayout) layout.findViewById(C0000R.id.chaton_custom);
                layout.findViewById(C0000R.id.general_dialog_message_layout).setVisibility(8);
                custom.addView(this.view, new ViewGroup.LayoutParams(-1, -2));
            } else {
                layout.findViewById(C0000R.id.general_dialog_message_layout).setVisibility(0);
            }
            layout.findViewById(C0000R.id.general_dialog_title).setLayoutParams(new LinearLayout.LayoutParams(margin_general_dialog_title));
            this.incomingMsgOnly = (CheckBox) layout.findViewById(C0000R.id.translator_checkbox);
            this.incomingMsgOnly.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.coolots.chaton.common.util.ChatONTranslatorDialog.Builder.5
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (buttonView.getId() == C0000R.id.translator_checkbox) {
                        if (isChecked) {
                            Builder.this.translatorDialogInterface.sendIncomingMsgOnly(true);
                        } else {
                            Builder.this.translatorDialogInterface.sendIncomingMsgOnly(false);
                        }
                    }
                }
            });
            this.myImage = (BuddyImageView) layout.findViewById(C0000R.id.translator_top_buddy_profile);
            this.otherPartyImage = (BuddyImageView) layout.findViewById(C0000R.id.translator_middle_buddy_profile);
            this.myImage.setImageViewMode(0);
            this.otherPartyImage.setImageViewMode(0);
            this.myImage.loadThumbImage(this.myImageID);
            this.otherPartyImage.loadThumbImage(this.otherPartyImageID);
            this.myNameText = (TextView) layout.findViewById(C0000R.id.translator_top_buddy_name);
            this.otherPartyNameText = (TextView) layout.findViewById(C0000R.id.translator_middle_buddy_name);
            this.myNameText.setText(this.myName);
            this.otherPartyNameText.setText(this.otherPartyName);
            dialog.setContentView(layout);
            return dialog;
        }
    }

    public View getButton(int buttonPositive) {
        return null;
    }

    public static String changeToStringLangCode(int langCode) {
        switch (langCode) {
            case 0:
                break;
            case 10:
                break;
            case 20:
                break;
            case 21:
                break;
            case 30:
                break;
            case 31:
                break;
            case 40:
                break;
            case 50:
                break;
        }
        return "English";
    }

    public static int changeToLangCode(String langCodeString) {
        if (langCodeString.equals("Korean")) {
            return 10;
        }
        if (langCodeString.equals("English")) {
            return 20;
        }
        if (langCodeString.equals("English_UK")) {
            return 21;
        }
        if (langCodeString.equals("Chinese")) {
            return 30;
        }
        if (langCodeString.equals("Chinese_HK")) {
            return 31;
        }
        if (langCodeString.equals("Japanese")) {
            return 40;
        }
        return 50;
    }

    public static void setSpinnerItemList(Set<Integer> supportLanguageSet, ArrayList<String> spinnerItemList) {
        if (spinnerItemList != null) {
            spinnerItemList.clear();
        }
        for (Integer i : supportLanguageSet) {
            switch (i.intValue()) {
                case 0:
                    spinnerItemList.add("");
                    break;
                case 10:
                    spinnerItemList.add("Korean");
                    break;
                case 20:
                    spinnerItemList.add("English");
                    break;
                case 21:
                    spinnerItemList.add("English_UK");
                    break;
                case 30:
                    spinnerItemList.add("Chinese");
                    break;
                case 31:
                    spinnerItemList.add("Chinese_HK");
                    break;
                case 40:
                    spinnerItemList.add("Japanese");
                    break;
                case 50:
                    spinnerItemList.add("Others");
                    break;
                default:
                    spinnerItemList.add("yyyyy");
                    break;
            }
        }
    }
}
