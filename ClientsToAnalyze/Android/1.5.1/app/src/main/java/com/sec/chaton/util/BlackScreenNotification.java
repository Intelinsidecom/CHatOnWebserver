package com.sec.chaton.util;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.multimedia.emoticon.RichString;

/* loaded from: classes.dex */
public class BlackScreenNotification extends BaseActivity {

    /* renamed from: a */
    public static boolean f3611a;

    /* renamed from: b */
    private String f3612b;

    /* renamed from: c */
    private String f3613c;

    /* renamed from: d */
    private String f3614d;

    /* renamed from: e */
    private int f3615e;

    /* renamed from: f */
    private AlertDialog f3616f;

    /* renamed from: a */
    private void m3474a() {
        View viewInflate = getLayoutInflater().inflate(C0062R.layout.layout_blackscreen_noti, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(C0062R.id.black_noti_content);
        RichString richString = new RichString(getResources(), this.f3613c, 40);
        textView.setText(richString);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (this.f3616f == null) {
            this.f3616f = builder.setTitle(C0062R.string.app_name).setView(viewInflate).setIcon(C0062R.drawable.popup_chat_icon).setPositiveButton(C0062R.string.dialog_ok, new DialogInterfaceOnClickListenerC0612j(this)).setNegativeButton(C0062R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0613k(this)).create();
            this.f3616f.setOnDismissListener(new DialogInterfaceOnDismissListenerC0611i(this));
            this.f3616f.show();
        } else {
            this.f3616f.setMessage(richString);
            if (this.f3616f.isShowing()) {
                return;
            }
            this.f3616f.show();
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(2621440);
        setContentView(C0062R.layout.activity_singlepane_base);
        Bundle extras = getIntent().getExtras();
        this.f3612b = extras.getString("Sender");
        this.f3614d = extras.getString("InboxNO");
        this.f3615e = extras.getInt("Chattype");
        String string = extras.getString("Content");
        ChatONContract.MessageTable.MsgContentType msgContentTypeM2195a = ChatONContract.MessageTable.MsgContentType.m2195a(extras.getInt("MediaType"));
        if (msgContentTypeM2195a != ChatONContract.MessageTable.MsgContentType.TEXT) {
            String strM2196a = ChatONContract.MessageTable.MsgContentType.m2196a(msgContentTypeM2195a);
            if (TextUtils.isEmpty(strM2196a)) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.f3612b).append("\n\n").append(string);
                this.f3613c = sb.toString();
            } else {
                this.f3613c = String.format(strM2196a, this.f3612b);
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f3612b).append("\n\n").append(string);
            this.f3613c = sb2.toString();
        }
        m3474a();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        Bundle extras = getIntent().getExtras();
        this.f3612b = extras.getString("Sender");
        this.f3613c = extras.getString("Content");
        this.f3614d = extras.getString("InboxNO");
        this.f3615e = extras.getInt("Chattype");
        m3474a();
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        f3611a = false;
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        f3611a = true;
    }
}
