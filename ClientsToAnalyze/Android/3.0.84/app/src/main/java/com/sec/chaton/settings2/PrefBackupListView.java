package com.sec.chaton.settings2;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.localbackup.ActivityBackupList;
import com.sec.chaton.localbackup.ActivitySecretKey;
import com.sec.chaton.localbackup.C1651m;
import com.sec.chaton.localbackup.C1656o;
import com.sec.chaton.localbackup.C1657p;
import com.sec.chaton.localbackup.C1658q;
import com.sec.chaton.localbackup.InterfaceC1614b;
import com.sec.chaton.localbackup.chatlist.ChatListActivity;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3228cp;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@TargetApi(11)
/* loaded from: classes.dex */
public class PrefBackupListView extends Fragment implements MenuItem.OnMenuItemClickListener, InterfaceC1614b {
    public static String BACKUP_FILE_NAME = "backup_file_name";
    private Activity mActivity;
    C1656o mAdapter;
    ArrayList<C1651m> mBackuplistData;
    private HashMap<String, String> mCheckedatas;
    TextView mEmptylist;
    private BroadcastReceiver mExternalStorageReceiver;
    ListView mListView;
    private CheckedTextView mSelectAll;
    private SwitchViewType mSwitchViewType;
    private TextView mText;
    private Menu mbackuplistMenu;

    enum SwitchViewType {
        NORMAL,
        DELETE
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        this.mActivity = getActivity();
        setHasOptionsMenu(true);
        super.onCreate(bundle);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_backuplist, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) viewGroup.getParent();
        if (Build.VERSION.SDK_INT >= 16) {
            linearLayout.setBackground(null);
        } else {
            linearLayout.setBackgroundDrawable(null);
        }
        linearLayout.setBackgroundColor(0);
        linearLayout.setPadding(0, 0, 0, 0);
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, 0, 0, 0);
            if (Build.VERSION.SDK_INT >= 17) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(0);
                ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(0);
            }
        }
        View viewFindViewById = viewInflate.findViewById(R.id.breadcrumb);
        TextView textView = (TextView) viewFindViewById.findViewById(R.id.breadcrumb1);
        textView.setText(R.string.backup);
        textView.setClickable(true);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.settings2.PrefBackupListView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrefBackupListView.this.getActivity().getFragmentManager().popBackStack();
            }
        });
        TextView textView2 = (TextView) viewFindViewById.findViewById(R.id.breadcrumb2);
        textView2.setText(R.string.view_backedup);
        textView2.setTextColor(getActivity().getResources().getColor(R.color.buddy_list_item_status_changed));
        ((ImageView) viewFindViewById.findViewById(R.id.separator2)).setVisibility(8);
        this.mListView = (ListView) viewInflate.findViewById(R.id.backuplist);
        this.mSelectAll = (CheckedTextView) viewInflate.findViewById(R.id.selectAll);
        this.mEmptylist = (TextView) viewInflate.findViewById(R.id.emptylist);
        View viewFindViewById2 = viewInflate.findViewById(R.id.backup_path);
        ((TextView) viewFindViewById2.findViewById(R.id.text1)).setText(C1658q.f6136a);
        viewFindViewById2.setClickable(false);
        this.mBackuplistData = new ArrayList<>();
        this.mCheckedatas = new HashMap<>();
        this.mBackuplistData.clear();
        this.mCheckedatas.clear();
        filterBackupFiles();
        this.mAdapter = new C1656o(getActivity(), this.mBackuplistData);
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.sec.chaton.settings2.PrefBackupListView.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                C1657p c1657p = (C1657p) view.getTag();
                if (PrefBackupListView.this.mSwitchViewType == SwitchViewType.DELETE) {
                    if (c1657p.f6131c.isChecked()) {
                        PrefBackupListView.this.setKeyInHashmap(c1657p, true);
                        if (PrefBackupListView.this.mCheckedatas.isEmpty()) {
                            PrefBackupListView.this.mbackuplistMenu.findItem(R.id.btnDeleteComplete).setEnabled(false);
                        }
                    } else {
                        PrefBackupListView.this.setKeyInHashmap(c1657p, false);
                        PrefBackupListView.this.mbackuplistMenu.findItem(R.id.btnDeleteComplete).setEnabled(true);
                    }
                    if (PrefBackupListView.this.mCheckedatas.size() == PrefBackupListView.this.mBackuplistData.size()) {
                        PrefBackupListView.this.mSelectAll.setChecked(true);
                        return;
                    } else {
                        PrefBackupListView.this.mSelectAll.setChecked(false);
                        return;
                    }
                }
                if (!c1657p.f6134f.equals(C3159aa.m10962a().m10979a("backup_checkkey", ""))) {
                    Intent intent = new Intent(PrefBackupListView.this.getActivity(), (Class<?>) ActivitySecretKey.class);
                    intent.putExtra("password_mode", false);
                    intent.putExtra("target_filepath", c1657p.f6132d);
                    intent.putExtra(PrefBackupListView.BACKUP_FILE_NAME, c1657p.f6135g);
                    PrefBackupListView.this.startActivity(intent);
                    return;
                }
                Intent intent2 = new Intent(PrefBackupListView.this.getActivity(), (Class<?>) ChatListActivity.class);
                intent2.putExtra(PrefBackupListView.BACKUP_FILE_NAME, c1657p.f6135g);
                PrefBackupListView.this.startActivity(intent2);
            }
        });
        this.mSelectAll.setOnClickListener(new View.OnClickListener() { // from class: com.sec.chaton.settings2.PrefBackupListView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (PrefBackupListView.this.mSelectAll.isChecked()) {
                    PrefBackupListView.this.mSelectAll.setChecked(false);
                    PrefBackupListView.this.mCheckedatas.clear();
                    PrefBackupListView.this.mbackuplistMenu.findItem(R.id.btnDeleteComplete).setEnabled(false);
                    PrefBackupListView.this.mListView.clearChoices();
                } else {
                    PrefBackupListView.this.mSelectAll.setChecked(true);
                    PrefBackupListView.this.setAlldata(PrefBackupListView.this.mBackuplistData);
                    PrefBackupListView.this.allcheck();
                    PrefBackupListView.this.mbackuplistMenu.findItem(R.id.btnDeleteComplete).setEnabled(true);
                }
                PrefBackupListView.this.mAdapter.notifyDataSetChanged();
            }
        });
        setHasOptionsMenu(true);
        switchView(SwitchViewType.NORMAL);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onResume() {
        startWatchingExternalStorage();
        refreshBackupList();
        super.onResume();
    }

    private void refreshBackupList() {
        this.mBackuplistData = new ArrayList<>();
        this.mCheckedatas = new HashMap<>();
        this.mBackuplistData.clear();
        filterBackupFiles();
        this.mAdapter = new C1656o(getActivity(), this.mBackuplistData);
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
        this.mActivity.invalidateOptionsMenu();
    }

    private void startWatchingExternalStorage() {
        this.mExternalStorageReceiver = new BroadcastReceiver() { // from class: com.sec.chaton.settings2.PrefBackupListView.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                PrefBackupListView.this.handleExternalStorageState();
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        this.mActivity.registerReceiver(this.mExternalStorageReceiver, intentFilter);
        handleExternalStorageState();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleExternalStorageState() {
        if (!C3223ck.m11327a()) {
            C3641ai.m13210a(this.mActivity, R.string.sdcard_not_found, 0).show();
        }
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        stopWatchingExternalStorage();
    }

    private void stopWatchingExternalStorage() {
        this.mActivity.unregisterReceiver(this.mExternalStorageReceiver);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void allcheck() {
        for (int i = 0; i < this.mListView.getCount(); i++) {
            this.mListView.setItemChecked(i, true);
        }
    }

    private void filterBackupFiles() {
        File file = new File(C1658q.f6136a);
        if (file != null) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                this.mListView.setVisibility(0);
                this.mEmptylist.setVisibility(8);
                for (File file2 : fileArrListFiles) {
                    if (file2.getName().toLowerCase().endsWith(".crypt")) {
                        this.mBackuplistData.add(new C1651m(file2.getPath(), file2.getName(), makeTimeFormat(Long.valueOf(file2.lastModified())), Long.toString(file2.lastModified())));
                    }
                }
                return;
            }
            this.mListView.setVisibility(8);
            this.mEmptylist.setVisibility(0);
        }
    }

    private String makeTimeFormat(Long l) {
        Date date = new Date();
        date.setTime(l.longValue());
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(date);
    }

    @Override // android.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.backup_list_menu, menu);
        this.mbackuplistMenu = menu;
        this.mbackuplistMenu.setGroupVisible(R.id.backcuplist_noraml_menu, true);
        this.mbackuplistMenu.setGroupVisible(R.id.backcuplist_menu_delete, false);
        if (this.mBackuplistData != null && this.mBackuplistData.size() > 0) {
            this.mbackuplistMenu.findItem(R.id.btnDeleteMode).setEnabled(true);
        } else {
            this.mbackuplistMenu.findItem(R.id.btnDeleteMode).setEnabled(false);
        }
        C3228cp.m11343a(this.mbackuplistMenu.findItem(R.id.btnDeleteMode));
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.mbackuplistMenu.findItem(R.id.btnDeleteMode).setOnMenuItemClickListener(this);
        this.mbackuplistMenu.findItem(R.id.btnForModeChange).setOnMenuItemClickListener(this);
        this.mbackuplistMenu.findItem(R.id.btnDeleteComplete).setOnMenuItemClickListener(this);
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        return onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.btnDeleteMode /* 2131166581 */:
                startActivity(new Intent(this.mActivity, (Class<?>) ActivityBackupList.class));
                break;
            case R.id.btnForModeChange /* 2131166583 */:
                switchView(SwitchViewType.NORMAL);
                break;
            case R.id.btnDeleteComplete /* 2131166584 */:
                AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.menu_chat_delete)).mo11509b(getResources().getString(R.string.selected_backup_delete)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterface.OnClickListener() { // from class: com.sec.chaton.settings2.PrefBackupListView.5
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PrefBackupListView.this.DeleteFromPreview(PrefBackupListView.this.mCheckedatas);
                        PrefBackupListView.this.switchView(SwitchViewType.NORMAL);
                        PrefBackupListView.this.mListView.invalidateViews();
                    }
                }).mo11501a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                break;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
    
        r8.mBackuplistData.remove(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0043, code lost:
    
        new java.io.File(r1.f6114a).delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004d, code lost:
    
        com.sec.widget.C3641ai.m13210a(getActivity(), com.sec.chaton.R.string.trunk_toast_deleted, 0).show();
        r0 = getActivity();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        com.sec.widget.C3641ai.m13210a(getActivity(), com.sec.chaton.R.string.trunk_toast_deleted, 0).show();
        r0 = getActivity();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0078, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0079, code lost:
    
        com.sec.widget.C3641ai.m13210a(getActivity(), com.sec.chaton.R.string.trunk_toast_deleted, 0).show();
        ((com.sec.chaton.localbackup.ActivityBackupList) getActivity()).finish();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008e, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void DeleteFromPreview(java.util.HashMap<java.lang.String, java.lang.String> r9) {
        /*
            r8 = this;
            r7 = 2131427684(0x7f0b0164, float:1.8476991E38)
            r6 = 0
            if (r9 == 0) goto L8f
            boolean r0 = r9.isEmpty()
            if (r0 != 0) goto L8f
            java.util.Set r0 = r9.entrySet()
            java.util.Iterator r2 = r0.iterator()
        L14:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L8f
            java.lang.Object r0 = r2.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.ArrayList<com.sec.chaton.localbackup.m> r1 = r8.mBackuplistData
            java.util.Iterator r3 = r1.iterator()
        L26:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L14
            java.lang.Object r1 = r3.next()
            com.sec.chaton.localbackup.m r1 = (com.sec.chaton.localbackup.C1651m) r1
            java.lang.String r4 = r1.f6114a
            java.lang.Object r5 = r0.getKey()
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L26
            java.util.ArrayList<com.sec.chaton.localbackup.m> r0 = r8.mBackuplistData
            r0.remove(r1)
            java.io.File r0 = new java.io.File     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L78
            java.lang.String r1 = r1.f6114a     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L78
            r0.<init>(r1)     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L78
            r0.delete()     // Catch: java.lang.Exception -> L62 java.lang.Throwable -> L78
            android.app.Activity r0 = r8.getActivity()
            android.widget.Toast r0 = com.sec.widget.C3641ai.m13210a(r0, r7, r6)
            r0.show()
            android.app.Activity r0 = r8.getActivity()
            com.sec.chaton.localbackup.ActivityBackupList r0 = (com.sec.chaton.localbackup.ActivityBackupList) r0
        L5e:
            r0.finish()
            goto L14
        L62:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L78
            android.app.Activity r0 = r8.getActivity()
            android.widget.Toast r0 = com.sec.widget.C3641ai.m13210a(r0, r7, r6)
            r0.show()
            android.app.Activity r0 = r8.getActivity()
            com.sec.chaton.localbackup.ActivityBackupList r0 = (com.sec.chaton.localbackup.ActivityBackupList) r0
            goto L5e
        L78:
            r0 = move-exception
            r1 = r0
            android.app.Activity r0 = r8.getActivity()
            android.widget.Toast r0 = com.sec.widget.C3641ai.m13210a(r0, r7, r6)
            r0.show()
            android.app.Activity r0 = r8.getActivity()
            com.sec.chaton.localbackup.ActivityBackupList r0 = (com.sec.chaton.localbackup.ActivityBackupList) r0
            r0.finish()
            throw r1
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.settings2.PrefBackupListView.DeleteFromPreview(java.util.HashMap):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchView(SwitchViewType switchViewType) {
        this.mSwitchViewType = switchViewType;
        switch (switchViewType) {
            case NORMAL:
                this.mSelectAll.setVisibility(8);
                if (this.mbackuplistMenu != null) {
                    this.mbackuplistMenu.setGroupVisible(R.id.backcuplist_noraml_menu, true);
                    this.mbackuplistMenu.setGroupVisible(R.id.backcuplist_menu_delete, false);
                    if (this.mBackuplistData.size() > 0) {
                        this.mbackuplistMenu.findItem(R.id.btnDeleteComplete).setEnabled(true);
                    } else {
                        this.mbackuplistMenu.findItem(R.id.btnDeleteComplete).setEnabled(false);
                    }
                }
                if (this.mListView != null) {
                    this.mListView.clearChoices();
                }
                if (this.mSelectAll != null) {
                    this.mSelectAll.setChecked(false);
                }
                if (this.mCheckedatas != null) {
                    this.mCheckedatas.clear();
                }
                this.mListView.setChoiceMode(0);
                this.mAdapter.f6127a = false;
                this.mListView.invalidateViews();
                break;
            case DELETE:
                this.mSelectAll.setVisibility(0);
                if (this.mbackuplistMenu != null) {
                    this.mbackuplistMenu.setGroupVisible(R.id.backcuplist_noraml_menu, false);
                    this.mbackuplistMenu.setGroupVisible(R.id.backcuplist_menu_delete, true);
                }
                this.mbackuplistMenu.findItem(R.id.btnDeleteComplete).setEnabled(false);
                ((SettingActivity) getActivity()).getActionBar().setTitle(GlobalApplication.m6451b().getString(R.string.menu_chat_delete));
                this.mListView.setChoiceMode(2);
                this.mAdapter.f6127a = true;
                this.mListView.invalidateViews();
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> setAlldata(ArrayList<C1651m> arrayList) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                if (!this.mCheckedatas.containsKey(arrayList.get(i2).f6114a)) {
                    this.mCheckedatas.put(arrayList.get(i2).f6114a, arrayList.get(i2).f6116c);
                }
                i = i2 + 1;
            } else {
                return this.mCheckedatas;
            }
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        if (this.mBackuplistData != null && !this.mBackuplistData.isEmpty()) {
            this.mBackuplistData.clear();
        }
        if (this.mCheckedatas != null && !this.mCheckedatas.isEmpty()) {
            this.mCheckedatas.clear();
        }
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyInHashmap(C1657p c1657p, boolean z) {
        if (z) {
            this.mCheckedatas.put(c1657p.f6132d, c1657p.f6133e);
        } else if (this.mCheckedatas.containsKey(c1657p.f6132d)) {
            this.mCheckedatas.remove(c1657p.f6132d);
        }
    }

    @Override // com.sec.chaton.localbackup.InterfaceC1614b
    public boolean switchViewMode() {
        if (this.mSwitchViewType != SwitchViewType.DELETE) {
            return false;
        }
        switchView(SwitchViewType.NORMAL);
        return true;
    }
}
