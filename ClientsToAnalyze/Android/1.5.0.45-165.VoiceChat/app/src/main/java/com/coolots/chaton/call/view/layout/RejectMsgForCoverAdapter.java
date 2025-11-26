package com.coolots.chaton.call.view.layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.coolots.chaton.C0000R;
import com.sds.coolots.common.view.DisposeInterface;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class RejectMsgForCoverAdapter extends ArrayAdapter<String> implements DisposeInterface {
    private ArrayList<String> items;
    private RejectMsgLayoutForCover rejectMsgLayoutForCover;

    public RejectMsgForCoverAdapter(Context context, int resource, ArrayList<String> objects, RejectMsgLayoutForCover rejectMsgLayout) {
        super(context, resource, objects);
        this.rejectMsgLayoutForCover = null;
        this.items = objects;
        this.rejectMsgLayoutForCover = rejectMsgLayout;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService("layout_inflater");
            v = vi.inflate(C0000R.layout.reject_call_with_msg_item_for_cover, (ViewGroup) null);
        }
        String rejectMessage = this.items.get(position);
        if (rejectMessage != null) {
            final TextView rejectMessageText = (TextView) v.findViewById(C0000R.id.reject_call_with_msg_item_text_for_cover);
            Button sendRejectMessageBtn = (Button) v.findViewById(C0000R.id.reject_call_with_msg_item_button_for_cover);
            rejectMessageText.setText(rejectMessage);
            sendRejectMessageBtn.setOnClickListener(new View.OnClickListener() { // from class: com.coolots.chaton.call.view.layout.RejectMsgForCoverAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View arg0) {
                    RejectMsgForCoverAdapter.this.rejectMsgLayoutForCover.sendMSGforRejectCover((String) rejectMessageText.getText());
                }
            });
        }
        return v;
    }

    @Override // com.sds.coolots.common.view.DisposeInterface
    public void dispose() {
        if (this.rejectMsgLayoutForCover != null) {
            this.rejectMsgLayoutForCover = null;
        }
        if (this.items != null) {
            this.items = null;
        }
    }
}
