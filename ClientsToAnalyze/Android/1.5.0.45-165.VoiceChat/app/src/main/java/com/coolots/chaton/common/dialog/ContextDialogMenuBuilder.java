package com.coolots.chaton.common.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ContextDialogMenuBuilder extends Dialog {
    public ContextDialogMenuBuilder(Context context, int theme) {
        super(context, theme);
    }

    public ContextDialogMenuBuilder(Context context) {
        super(context);
    }

    public static class Builder {
        private Context context;
        private ContextDialogMenuInterface iContextDialog;
        private LinearLayout listBody;
        private int mMenuArrayId;
        private String message;
        private String title;
        private int mDisableIdx = -1;
        private int mRejectIndex = -1;

        public Builder(Context context, ContextDialogMenuInterface contextDialog) {
            this.context = context;
            this.iContextDialog = contextDialog;
        }

        public Builder setMessage(String message) {
            this.message = message;
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

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public void setMenuArray(int menuarrayid) {
            this.mMenuArrayId = menuarrayid;
        }

        public void setDisableMenuItem(int index) {
            this.mDisableIdx = index;
        }

        public void setRejectMsgIndex(int rejectIndex) {
            this.mRejectIndex = rejectIndex;
        }

        public ContextDialogMenuBuilder create() throws Resources.NotFoundException {
            this.context.getResources();
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
            ContextDialogMenuBuilder dialog = new ContextDialogMenuBuilder(this.context, C0000R.style.ChatONContextMenuTheme);
            View layout = inflater.inflate(C0000R.layout.chatoncontextmenuview, (ViewGroup) null);
            TextView contextmenutitle = (TextView) layout.findViewById(C0000R.id.general_dialog_title);
            contextmenutitle.setText(this.title);
            ListView contextmenulist = (ListView) layout.findViewById(C0000R.id.contextmenu_itemlist);
            String[] menuText = this.context.getResources().getStringArray(this.mMenuArrayId);
            ArrayList<String> menuTextArrayList = new ArrayList<>();
            for (String str : menuText) {
                menuTextArrayList.add(str);
            }
            ArrayAdapter<String> adapter = new ContextDialogMenuArrayAdapter(this.context, C0000R.layout.context_simple_list_item, menuTextArrayList);
            ((ContextDialogMenuArrayAdapter) adapter).setDisableMenuItem(this.mDisableIdx);
            contextmenulist.setAdapter((ListAdapter) adapter);
            this.listBody = (LinearLayout) layout.findViewById(C0000R.id.body);
            if (contextmenulist.getCount() == 2) {
                this.listBody.setBackground(this.context.getResources().getDrawable(C0000R.drawable.popup_winset_bottom_medium_02));
            } else {
                this.listBody.setBackground(this.context.getResources().getDrawable(C0000R.drawable.popup_winset_center_bright));
            }
            contextmenulist.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coolots.chaton.common.dialog.ContextDialogMenuBuilder.Builder.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView arg0, View view, int position, long arg3) {
                    if (position != Builder.this.mDisableIdx) {
                        if (Builder.this.mRejectIndex == -1) {
                            Builder.this.iContextDialog.sendMsgFromDialog(position);
                            Builder.this.iContextDialog.contextDialogDismiss();
                        } else {
                            Builder.this.iContextDialog.sendMsgFromDialog(position, Builder.this.mRejectIndex);
                            Builder.this.iContextDialog.contextDialogDismiss();
                            Builder.this.mRejectIndex = -1;
                        }
                    }
                }
            });
            dialog.addContentView(layout, new ViewGroup.LayoutParams(-1, -2));
            return dialog;
        }
    }
}
