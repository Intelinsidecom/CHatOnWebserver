package com.sec.chaton.chat;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.buddy.BuddyChatInfoActivity;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;
import twitter4j.MediaEntity;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.c */
/* loaded from: classes.dex */
class C0497c implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2091a;

    C0497c(ChatFragment chatFragment) {
        this.f2091a = chatFragment;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (this.f2091a.getActivity() != null) {
            if (view.isPressed() || view.isInTouchMode()) {
                if (i == 0) {
                    Intent intent = new Intent(this.f2091a.getActivity(), (Class<?>) BuddyChatInfoActivity.class);
                    intent.putExtra("ACTIVITY_PURPOSE", 6);
                    C1786r.m6064d("namelist:" + this.f2091a.f1786aA);
                    String strSubstring = this.f2091a.f1765F != EnumC0695j.ONETOONE ? this.f2091a.f1786aA.substring(0, this.f2091a.f1786aA.length() - (Integer.toString(this.f2091a.f1834aw.size()).length() + 3)) : this.f2091a.f1786aA;
                    intent.putExtra(ChatFragment.f1753i, this.f2091a.f1761B);
                    intent.putExtra(ChatFragment.f1750f, strSubstring);
                    intent.putExtra("inboxNO", this.f2091a.f1912z);
                    intent.putExtra("chatType", this.f2091a.f1765F.m3146a());
                    intent.putExtra(ChatFragment.f1755k, this.f2091a.f1869bf);
                    intent.putExtra(ChatFragment.f1758n, this.f2091a.f1799aN);
                    intent.putExtra(ChatFragment.f1757m, 2);
                    synchronized (this.f2091a.f1782W) {
                        intent.putExtra(ChatFragment.f1749e, (String[]) this.f2091a.f1834aw.toArray(new String[this.f2091a.f1834aw.size()]));
                    }
                    intent.putExtra("ACTIVITY_TYPE", MediaEntity.Size.CROP);
                    if (!this.f2091a.f1862bY) {
                        this.f2091a.startActivityForResult(intent, 17);
                        return;
                    } else {
                        ((BaseActivity) this.f2091a.getActivity()).mo1830a(intent);
                        return;
                    }
                }
                if (i == 1) {
                    if (this.f2091a.f1797aL && this.f2091a.f1786aA != null) {
                        this.f2091a.f1827ap.requestFocus();
                        String str = "";
                        Uri uriM3120a = C0688c.m3120a();
                        String[] strArr = (String[]) this.f2091a.f1834aw.toArray(new String[this.f2091a.f1834aw.size()]);
                        StringBuffer stringBuffer = new StringBuffer();
                        if (strArr.length > 0) {
                            String str2 = "buddy_no NOT IN ( ";
                            for (String str3 : strArr) {
                                stringBuffer.append(", '" + str3 + "'");
                            }
                            str = str2 + stringBuffer.toString().substring(1) + " )";
                        }
                        this.f2091a.f1783X.startQuery(13, null, uriM3120a, null, str, null, null);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    this.f2091a.m2600a(this.f2091a.f1912z, this.f2091a.f1765F, this.f2091a.f1766G, this.f2091a.f1789aD);
                    return;
                }
                if (i == 3) {
                    AlertDialogBuilderC2120a alertDialogBuilderC2120a = new AlertDialogBuilderC2120a(this.f2091a.getActivity(), "");
                    alertDialogBuilderC2120a.setTitle(R.string.backup);
                    FragmentActivity activity = this.f2091a.getActivity();
                    this.f2091a.getActivity();
                    View viewInflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(R.layout.backup_dialog, (ViewGroup) null);
                    CheckBox checkBox = (CheckBox) viewInflate.findViewById(R.id.includeAttach);
                    alertDialogBuilderC2120a.setView(viewInflate);
                    CharSequence[] charSequenceArr = {this.f2091a.getString(R.string.option_sdcard), this.f2091a.getString(R.string.option_send_email)};
                    alertDialogBuilderC2120a.setItems(charSequenceArr, new DialogInterfaceOnClickListenerC0498d(this, checkBox, charSequenceArr));
                    alertDialogBuilderC2120a.setNegativeButton(R.string.dialog_cancel, new DialogInterfaceOnClickListenerC0499e(this));
                    alertDialogBuilderC2120a.setCancelable(true);
                    alertDialogBuilderC2120a.show();
                }
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView adapterView) {
    }
}
