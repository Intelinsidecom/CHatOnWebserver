package com.coolots.chaton.common.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.chaton.C0000R;

/* loaded from: classes.dex */
public class ChatONDialog extends Dialog implements DialogInterface {
    public ChatONDialog(Context context, int theme) {
        super(context, theme);
    }

    public ChatONDialog(Context context) {
        super(context);
    }

    public static class Builder {
        private boolean cancelable;
        private Context context;
        private int itemsId;
        private DialogInterface.OnClickListener listener;
        private int mDialogMode;
        public DialogInterface.OnCancelListener mOnCancelListener;
        private Button mPositiveBtn;
        private View mView;
        private String message;
        private DialogInterface.OnClickListener negativeButtonClickListener;
        private String negativeButtonText;
        private DialogInterface.OnClickListener neutralButtonClickListener;
        private String neutralButtonText;
        private DialogInterface.OnClickListener positiveButtonClickListener;
        private String positiveButtonText;
        private String title;
        private int mTitleIcon = 0;
        private FrameLayout customPanel = null;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder(Context context, int mode) {
            this.context = context;
            this.mDialogMode = mode;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setMessage(CharSequence message) {
            this.message = (String) message;
            return this;
        }

        public Builder setMessage(int message) {
            this.message = (String) this.context.getText(message);
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

        public Builder setItems(int itemsId, DialogInterface.OnClickListener listener) {
            this.itemsId = itemsId;
            this.listener = listener;
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
            this.mView = view;
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

        public Builder setNeutralButton(int neutralButtonText, DialogInterface.OnClickListener listener) {
            this.neutralButtonText = (String) this.context.getText(neutralButtonText);
            this.neutralButtonClickListener = listener;
            return this;
        }

        public Builder setNeutralButton(String neutralButtonText, DialogInterface.OnClickListener listener) {
            this.neutralButtonText = neutralButtonText;
            this.neutralButtonClickListener = listener;
            return this;
        }

        public Builder setNeutralButton(CharSequence neutralButtonText, DialogInterface.OnClickListener listener) {
            this.neutralButtonText = (String) neutralButtonText;
            this.neutralButtonClickListener = listener;
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

        public ChatONDialog show() {
            ChatONDialog dialog = create();
            dialog.show();
            return dialog;
        }

        public Button getPositiveButton() {
            return this.mPositiveBtn;
        }

        public ChatONDialog create() {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            final ChatONDialog dialog = new ChatONDialog(this.context, C0000R.style.Dialog);
            View layout = inflater.inflate(C0000R.layout.chatonv_custom_dialog, (ViewGroup) null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(-1, -2));
            dialog.setCancelable(this.cancelable);
            ((TextView) layout.findViewById(C0000R.id.general_dialog_title)).setText(this.title);
            if (this.positiveButtonText != null) {
                this.mPositiveBtn = (Button) layout.findViewById(C0000R.id.general_dialog_positive_btn);
                this.mPositiveBtn.setText(this.positiveButtonText);
                if (this.positiveButtonClickListener != null) {
                    ((Button) layout.findViewById(C0000R.id.general_dialog_positive_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.common.util.ChatONDialog.Builder.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            Builder.this.positiveButtonClickListener.onClick(dialog, -1);
                            dialog.dismiss();
                        }
                    });
                }
            } else {
                ((Button) layout.findViewById(C0000R.id.general_dialog_positive_btn)).setVisibility(8);
            }
            if (this.negativeButtonText != null) {
                ((Button) layout.findViewById(C0000R.id.general_dialog_negative_btn)).setText(this.negativeButtonText);
                if (this.negativeButtonClickListener != null) {
                    ((Button) layout.findViewById(C0000R.id.general_dialog_negative_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.common.util.ChatONDialog.Builder.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            Builder.this.negativeButtonClickListener.onClick(dialog, -2);
                            dialog.dismiss();
                        }
                    });
                }
            } else {
                ((Button) layout.findViewById(C0000R.id.general_dialog_negative_btn)).setVisibility(8);
            }
            if (this.neutralButtonText != null) {
                ((Button) layout.findViewById(C0000R.id.general_dialog_cancel_btn)).setText(this.neutralButtonText);
                if (this.neutralButtonClickListener != null) {
                    ((Button) layout.findViewById(C0000R.id.general_dialog_cancel_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.common.util.ChatONDialog.Builder.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            Builder.this.neutralButtonClickListener.onClick(dialog, -3);
                            dialog.dismiss();
                        }
                    });
                }
            } else {
                ((Button) layout.findViewById(C0000R.id.general_dialog_cancel_btn)).setVisibility(8);
            }
            if (this.message != null) {
                ((TextView) layout.findViewById(C0000R.id.general_dialog_message)).setText(this.message);
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
            if (this.mView != null) {
                this.customPanel = (FrameLayout) layout.findViewById(C0000R.id.chaton_customPanel);
                FrameLayout custom = (FrameLayout) layout.findViewById(C0000R.id.chaton_custom);
                layout.findViewById(C0000R.id.general_dialog_message_layout).setVisibility(8);
                custom.addView(this.mView, new ViewGroup.LayoutParams(-1, -2));
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
}
