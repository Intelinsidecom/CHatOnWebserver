package com.coolots.chaton.common.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.coolots.chaton.C0000R;

/* loaded from: classes.dex */
public class ChatONDialogFun extends Dialog implements DialogInterface {
    public ChatONDialogFun(Context context, int theme) {
        super(context, theme);
    }

    public ChatONDialogFun(Context context) {
        super(context);
    }

    public static class Builder {
        private DialogInterface.OnClickListener cartoonviewButtonClickListener;
        private Context context;
        private DialogInterface.OnClickListener emotianiButtonClickListener;
        public LayoutInflater inflater = null;
        private boolean mCartoonViewState;
        private boolean mDualCameraState;
        public DialogInterface.OnCancelListener mOnCancelListener;
        private DialogInterface.OnClickListener themeshotButtonClickListener;
        private String title;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setTitle(int title) {
            this.title = (String) this.context.getText(title);
            return this;
        }

        public Builder setTitle(CharSequence title) {
            this.title = (String) title;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setEmotiAnidButton(DialogInterface.OnClickListener listener) {
            this.emotianiButtonClickListener = listener;
            return this;
        }

        public Builder setThemeShotButton(DialogInterface.OnClickListener listener) {
            this.themeshotButtonClickListener = listener;
            return this;
        }

        public Builder setCarttonViewButton(DialogInterface.OnClickListener listener) {
            this.cartoonviewButtonClickListener = listener;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.mOnCancelListener = onCancelListener;
            return this;
        }

        public ChatONDialogFun show() {
            ChatONDialogFun dialog = create();
            dialog.show();
            return dialog;
        }

        public void setCartoonViewState(boolean state) {
            this.mCartoonViewState = state;
        }

        public void setDualCameraSate(boolean state) {
            this.mDualCameraState = state;
        }

        private boolean getCartoonViewState() {
            return this.mCartoonViewState;
        }

        public ChatONDialogFun create() {
            if (this.inflater == null) {
                this.inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            }
            final ChatONDialogFun dialog = new ChatONDialogFun(this.context, C0000R.style.Dialog);
            View layout = this.inflater.inflate(C0000R.layout.chatonv_custom_dialog_fun, (ViewGroup) null);
            dialog.addContentView(layout, new ViewGroup.LayoutParams(-2, -2));
            dialog.setCancelable(true);
            ((TextView) layout.findViewById(C0000R.id.general_dialog_title)).setText(this.title);
            TextView tvCartoonView = (TextView) layout.findViewById(C0000R.id.txt_cartoon_view);
            ImageView ivCartoonSwitch = (ImageView) layout.findViewById(C0000R.id.img_cartoon_view_switch);
            if (getCartoonViewState()) {
                tvCartoonView.setText(C0000R.string.call_menu_cartoon_view_off);
                ((Button) layout.findViewById(C0000R.id.btn_cartoon_view)).setContentDescription(this.context.getResources().getText(C0000R.string.call_menu_cartoon_view_off));
                ivCartoonSwitch.setBackgroundDrawable(this.context.getResources().getDrawable(C0000R.drawable.vt_call_popup_icon_enable_cartoon_veiw_on));
            } else {
                tvCartoonView.setText(C0000R.string.call_menu_cartoon_view_on);
                ((Button) layout.findViewById(C0000R.id.btn_cartoon_view)).setContentDescription(this.context.getResources().getText(C0000R.string.call_menu_cartoon_view_on));
                ivCartoonSwitch.setBackgroundDrawable(this.context.getResources().getDrawable(C0000R.drawable.vt_call_popup_icon_enable_cartoon_veiw_off));
            }
            if (this.mDualCameraState) {
                ((Button) layout.findViewById(C0000R.id.btn_emoti_ani)).setEnabled(false);
                ((Button) layout.findViewById(C0000R.id.btn_theme_shot)).setEnabled(false);
                ((TextView) layout.findViewById(C0000R.id.txt_emoti_ani)).setEnabled(false);
                ((TextView) layout.findViewById(C0000R.id.txt_theme_shot)).setEnabled(false);
                layout.findViewById(C0000R.id.img_emoti_ani).setEnabled(false);
                layout.findViewById(C0000R.id.img_theme_shot).setEnabled(false);
            } else {
                if (this.emotianiButtonClickListener != null) {
                    Button emotiAniBtn = (Button) layout.findViewById(C0000R.id.btn_emoti_ani);
                    emotiAniBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.common.util.ChatONDialogFun.Builder.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            Builder.this.emotianiButtonClickListener.onClick(dialog, -1);
                            dialog.dismiss();
                        }
                    });
                }
                if (this.themeshotButtonClickListener != null) {
                    Button themeShotBtn = (Button) layout.findViewById(C0000R.id.btn_theme_shot);
                    themeShotBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.common.util.ChatONDialogFun.Builder.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View v) {
                            Builder.this.themeshotButtonClickListener.onClick(dialog, -2);
                            dialog.dismiss();
                        }
                    });
                }
            }
            if (this.cartoonviewButtonClickListener != null) {
                ((Button) layout.findViewById(C0000R.id.btn_cartoon_view)).setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.common.util.ChatONDialogFun.Builder.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v) {
                        Builder.this.cartoonviewButtonClickListener.onClick(dialog, -2);
                        dialog.dismiss();
                    }
                });
            }
            dialog.setOnCancelListener(this.mOnCancelListener);
            dialog.setContentView(layout);
            return dialog;
        }
    }

    public View getButton(int buttonPositive) {
        return null;
    }
}
