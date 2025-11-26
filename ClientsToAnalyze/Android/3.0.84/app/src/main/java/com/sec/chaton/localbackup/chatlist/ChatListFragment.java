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
import com.sec.chaton.localbackup.database.C1641a;
import com.sec.chaton.p027e.p028a.C1377u;
import com.sec.chaton.p027e.p028a.InterfaceC1378v;
import com.sec.chaton.widget.C3263j;

/* loaded from: classes.dex */
public class ChatListFragment extends Fragment implements AdapterView.OnItemClickListener {

    /* renamed from: b */
    private static final String f6009b = ChatListFragment.class.getSimpleName();

    /* renamed from: a */
    InterfaceC1378v f6010a = new C1619d(this);

    /* renamed from: c */
    private C1377u f6011c;

    /* renamed from: d */
    private ChatListActivity f6012d;

    /* renamed from: e */
    private C1616a f6013e;

    /* renamed from: f */
    private ListView f6014f;

    /* renamed from: g */
    private String f6015g;

    /* renamed from: h */
    private ProgressDialog f6016h;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f6011c = new C1377u(this.f6012d.getContentResolver(), this.f6010a);
        setHasOptionsMenu(true);
        this.f6015g = getArguments().getString(BackupListView.f5955a);
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_localbackup_chatlist, viewGroup, false);
        this.f6013e = new C1616a(getActivity(), R.layout.list_item_common_6, null);
        this.f6014f = (ListView) viewInflate.findViewById(R.id.chat_listview);
        this.f6014f.setAdapter((ListAdapter) this.f6013e);
        this.f6014f.setOnItemClickListener(this);
        this.f6011c.startQuery(1, null, C1641a.m6916a(), null, null, new String[]{""}, null);
        m6861b();
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        if (getActivity() != null) {
            ((ChatListActivity) getActivity()).m11543k().mo11583a(this.f6015g);
        }
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        m6862c();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        this.f6012d = (ChatListActivity) activity;
        super.onAttach(activity);
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        this.f6012d = null;
        super.onDetach();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Cursor cursor = null;
        if (this.f6013e != null) {
            cursor = (Cursor) this.f6013e.getItem(i);
        }
        if (cursor != null && !cursor.isClosed()) {
            Intent intent = new Intent(this.f6012d, (Class<?>) ChatViewActivity.class);
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
        if (this.f6012d != null) {
            this.f6012d.m6857c();
        }
        return true;
    }

    /* renamed from: b */
    private void m6861b() {
        if (this.f6016h == null) {
            this.f6016h = (ProgressDialog) new C3263j(this.f6012d).m11487a(R.string.setting_webview_please_wait);
        }
        if (!this.f6016h.isShowing()) {
            this.f6016h.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m6862c() {
        if (this.f6016h != null && this.f6012d != null) {
            this.f6016h.dismiss();
        }
    }
}
