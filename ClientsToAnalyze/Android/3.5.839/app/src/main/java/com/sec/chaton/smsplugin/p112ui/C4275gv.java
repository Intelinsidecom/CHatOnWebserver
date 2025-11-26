package com.sec.chaton.smsplugin.p112ui;

import android.database.Cursor;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p102b.C3790i;
import java.util.HashSet;

/* compiled from: PluginConversationList.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gv */
/* loaded from: classes.dex */
class C4275gv implements AbsListView.MultiChoiceModeListener {

    /* renamed from: a */
    final /* synthetic */ PluginConversationList f15651a;

    /* renamed from: b */
    private View f15652b;

    /* renamed from: c */
    private TextView f15653c;

    /* renamed from: d */
    private HashSet<Long> f15654d;

    private C4275gv(PluginConversationList pluginConversationList) {
        this.f15651a = pluginConversationList;
    }

    /* synthetic */ C4275gv(PluginConversationList pluginConversationList, C4266gm c4266gm) {
        this(pluginConversationList);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        MenuInflater menuInflater = this.f15651a.getMenuInflater();
        this.f15654d = new HashSet<>();
        menuInflater.inflate(R.menu.conversation_multi_select_menu, menu);
        if (this.f15652b == null) {
            this.f15652b = LayoutInflater.from(this.f15651a).inflate(R.layout.conversation_list_multi_select_actionbar, (ViewGroup) null);
            this.f15653c = (TextView) this.f15652b.findViewById(R.id.selected_conv_count);
        }
        actionMode.setCustomView(this.f15652b);
        ((TextView) this.f15652b.findViewById(R.id.title)).setText(R.string.menu_delete);
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        if (this.f15652b == null) {
            ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f15651a).inflate(R.layout.conversation_list_multi_select_actionbar, (ViewGroup) null);
            actionMode.setCustomView(viewGroup);
            this.f15653c = (TextView) viewGroup.findViewById(R.id.selected_conv_count);
            return true;
        }
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.delete /* 2131166330 */:
                if (this.f15654d.size() > 0) {
                    PluginConversationList.m16142a(this.f15654d, this.f15651a.f15058b);
                }
                actionMode.finish();
                break;
        }
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        ((C4349p) this.f15651a.getListView().getAdapter()).m16526a();
        this.f15654d = null;
        this.f15651a.f15059c.notifyDataSetChanged();
    }

    @Override // android.widget.AbsListView.MultiChoiceModeListener
    public void onItemCheckedStateChanged(ActionMode actionMode, int i, long j, boolean z) {
        ListView listView = this.f15651a.getListView();
        this.f15653c.setText(Integer.toString(listView.getCheckedItemCount()));
        Cursor cursor = (Cursor) listView.getItemAtPosition(i);
        if (cursor != null) {
            C3790i c3790iM14318a = C3790i.m14318a(this.f15651a, cursor);
            c3790iM14318a.m14358c(z);
            this.f15651a.f15059c.notifyDataSetChanged();
            long jM14359d = c3790iM14318a.m14359d();
            if (z) {
                this.f15654d.add(Long.valueOf(jM14359d));
            } else {
                this.f15654d.remove(Long.valueOf(jM14359d));
            }
        }
    }
}
