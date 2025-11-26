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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes.dex */
public class ChatONTranslatorChangeLanguageDialog extends Dialog implements DialogInterface {
    public ChatONTranslatorChangeLanguageDialog(Context context, int theme) {
        super(context, theme);
    }

    public ChatONTranslatorChangeLanguageDialog(Context context) {
        super(context);
    }

    public static class Builder {
        private ArrayList<String> addCountryList;
        private boolean cancelable;
        private Context context;
        private Spinner countrySpinner;
        private int mDialogMode;
        public DialogInterface.OnCancelListener mOnCancelListener;
        private Button mPositiveBtn;
        private Set<Integer> mSupportLanguageSet;
        private String messageMiddle;
        private String messageTop;
        private DialogInterface.OnClickListener negativeButtonClickListener;
        private String negativeButtonText;
        private DialogInterface.OnClickListener positiveButtonClickListener;
        private String positiveButtonText;
        private String title;
        private View view;
        private ArrayAdapter<String> spinnerAdapter = null;
        private int mLanguageCode = -1;
        private int mTitleIcon = 0;
        private FrameLayout customPanel = null;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder(Context context, Set<Integer> supportLanguageSet) {
            this.context = context;
            this.mSupportLanguageSet = supportLanguageSet;
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

        public Builder setMessageMiddle(String message) {
            this.messageMiddle = message;
            return this;
        }

        public Builder setMessageMiddle(CharSequence message) {
            this.messageMiddle = (String) message;
            return this;
        }

        public Builder setMessageTop(int message) {
            this.messageTop = (String) this.context.getText(message);
            return this;
        }

        public Builder setMessageMiddle(int message) {
            this.messageMiddle = (String) this.context.getText(message);
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

        public ChatONTranslatorChangeLanguageDialog show() {
            ChatONTranslatorChangeLanguageDialog dialog = create();
            dialog.show();
            return dialog;
        }

        public Button getPositiveButton() {
            return this.mPositiveBtn;
        }

        public void setCountryLanguageCode(int languageCode) {
            this.mLanguageCode = languageCode;
        }

        public int getCountryLanguageCode() {
            return this.mLanguageCode;
        }

        public ChatONTranslatorChangeLanguageDialog create() {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            final ChatONTranslatorChangeLanguageDialog dialog = new ChatONTranslatorChangeLanguageDialog(this.context, C0000R.style.Dialog);
            View layout = inflater.inflate(C0000R.layout.chatonv_custom_translator_change_language_dialog, (ViewGroup) null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(-1, -2));
            dialog.setCancelable(this.cancelable);
            ((TextView) layout.findViewById(C0000R.id.general_dialog_title)).setText(this.title);
            this.countrySpinner = (Spinner) layout.findViewById(C0000R.id.add_country_spinner);
            if (this.addCountryList == null) {
                this.addCountryList = new ArrayList<>();
            }
            ChatONTranslatorChangeLanguageDialog.setSpinnerItemList(this.mSupportLanguageSet, this.addCountryList);
            this.spinnerAdapter = new ArrayAdapter<>(this.context, C0000R.layout.translator_spinner_item, this.addCountryList);
            this.spinnerAdapter.setDropDownViewResource(C0000R.layout.translator_spinner_dropdown_item);
            this.countrySpinner.setAdapter((SpinnerAdapter) this.spinnerAdapter);
            int langIndex = this.addCountryList.indexOf(ChatONTranslatorChangeLanguageDialog.changeToStringLangCode(this.mLanguageCode));
            if (langIndex == -1) {
                langIndex = 0;
            }
            this.countrySpinner.setSelection(langIndex);
            this.countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.coolots.chaton.common.util.ChatONTranslatorChangeLanguageDialog.Builder.1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> arg0, View arg1, int langIndex2, long arg3) {
                    int topSelectionLangCode = ChatONTranslatorChangeLanguageDialog.changeToLangCode((String) Builder.this.addCountryList.get(langIndex2));
                    Builder.this.setCountryLanguageCode(topSelectionLangCode);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> arg0) {
                }
            });
            if (this.positiveButtonText != null) {
                this.mPositiveBtn = (Button) layout.findViewById(C0000R.id.general_dialog_positive_btn);
                this.mPositiveBtn.setText(this.positiveButtonText);
                if (this.positiveButtonClickListener != null) {
                    ((Button) layout.findViewById(C0000R.id.general_dialog_positive_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.common.util.ChatONTranslatorChangeLanguageDialog.Builder.2
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
                    ((Button) layout.findViewById(C0000R.id.general_dialog_negative_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.common.util.ChatONTranslatorChangeLanguageDialog.Builder.3
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
            if (this.messageMiddle != null) {
                ((TextView) layout.findViewById(C0000R.id.general_dialog_message_middle)).setText(this.messageMiddle);
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
                this.customPanel = (FrameLayout) layout.findViewById(C0000R.id.chaton_customPanel);
                FrameLayout custom = (FrameLayout) layout.findViewById(C0000R.id.chaton_custom);
                layout.findViewById(C0000R.id.general_dialog_message_layout).setVisibility(8);
                custom.addView(this.view, new ViewGroup.LayoutParams(-1, -2));
            } else {
                layout.findViewById(C0000R.id.chaton_customPanel).setVisibility(8);
                layout.findViewById(C0000R.id.general_dialog_message_layout).setVisibility(0);
            }
            layout.findViewById(C0000R.id.general_dialog_title).setLayoutParams(new LinearLayout.LayoutParams(margin_general_dialog_title));
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
