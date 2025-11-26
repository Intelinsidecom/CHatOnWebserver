package com.sec.chaton.localbackup.chatlist;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.localbackup.BackupListView;
import com.sec.chaton.localbackup.chatview.ChatViewActivity;
import com.sec.chaton.localbackup.database.C2543a;
import com.sec.chaton.p057e.p058a.C2210x;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;
import com.sec.chaton.widget.C4923p;

/* loaded from: classes.dex */
public class ChatListFragment extends Fragment implements AdapterView.OnItemClickListener {

    /* renamed from: b */
    private static final String f9053b = ChatListFragment.class.getSimpleName();

    /* renamed from: a */
    InterfaceC2211y f9054a = new C2521d(this);

    /* renamed from: c */
    private C2210x f9055c;

    /* renamed from: d */
    private ChatListActivity f9056d;

    /* renamed from: e */
    private C2518a f9057e;

    /* renamed from: f */
    private ListView f9058f;

    /* renamed from: g */
    private String f9059g;

    /* renamed from: h */
    private ProgressDialog f9060h;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f9055c = new C2210x(this.f9056d.getContentResolver(), this.f9054a);
        setHasOptionsMenu(true);
        this.f9059g = getArguments().getString(BackupListView.f8996a);
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_localbackup_chatlist, viewGroup, false);
        this.f9057e = new C2518a(getActivity(), R.layout.list_item_common_6, null);
        this.f9058f = (ListView) viewInflate.findViewById(R.id.chat_listview);
        this.f9058f.setAdapter((ListAdapter) this.f9057e);
        this.f9058f.setOnItemClickListener(this);
        this.f9055c.startQuery(2, null, C2543a.f9147b, null, null, null, null);
        m10891b();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        if (getActivity() != null) {
            ((ChatListActivity) getActivity()).m18784t().mo18823a(this.f9059g);
        }
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        m10893c();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f9056d = (ChatListActivity) activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f9056d = null;
        super.onDetach();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Cursor cursor = null;
        if (this.f9057e != null) {
            cursor = (Cursor) this.f9057e.getItem(i);
        }
        if (cursor != null && !cursor.isClosed()) {
            Intent intent = new Intent(this.f9056d, (Class<?>) ChatViewActivity.class);
            String string = cursor.getString(cursor.getColumnIndex("inbox_no"));
            int i2 = cursor.getInt(cursor.getColumnIndex("inbox_chat_type"));
            intent.putExtra("inboxNO", string);
            intent.putExtra("chatType", i2);
            intent.putExtra("inbox_title", cursor.getString(cursor.getColumnIndex("inbox_title")));
            intent.putExtra("inbox_participants", cursor.getInt(cursor.getColumnIndex("inbox_participants")));
            startActivity(intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.f9056d != null) {
            this.f9056d.m10887h();
        }
        return true;
    }

    /* renamed from: b */
    private void m10891b() {
        if (this.f9060h == null) {
            this.f9060h = (ProgressDialog) new C4923p(this.f9056d).m18724a(R.string.setting_webview_please_wait);
        }
        if (!this.f9060h.isShowing()) {
            this.f9060h.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m10893c() {
        if (this.f9060h != null && this.f9056d != null) {
            this.f9060h.dismiss();
        }
    }
}
