package com.sec.chaton.localbackup;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3228cp;
import com.sec.common.p063a.AbstractC3271a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes.dex */
public class BackupListView extends Fragment implements InterfaceC1614b {

    /* renamed from: b */
    ArrayList<C1651m> f5957b;

    /* renamed from: c */
    C1656o f5958c;

    /* renamed from: d */
    ListView f5959d;

    /* renamed from: e */
    TextView f5960e;

    /* renamed from: g */
    private EnumC1652n f5961g;

    /* renamed from: h */
    private CheckedTextView f5962h;

    /* renamed from: i */
    private Menu f5963i;

    /* renamed from: f */
    private static final String f5956f = BackupListView.class.getSimpleName();

    /* renamed from: a */
    public static String f5955a = "backup_file_name";

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_backuplist, viewGroup, false);
        this.f5959d = (ListView) viewInflate.findViewById(R.id.backuplist);
        this.f5962h = (CheckedTextView) viewInflate.findViewById(R.id.selectAll);
        this.f5960e = (TextView) viewInflate.findViewById(R.id.emptylist);
        View viewFindViewById = viewInflate.findViewById(R.id.backup_path);
        ((TextView) viewFindViewById.findViewById(R.id.text1)).setText(C1658q.f6136a);
        this.f5957b = new ArrayList<>();
        this.f5957b.clear();
        m6816b();
        this.f5958c = new C1656o(getActivity(), this.f5957b);
        this.f5959d.setAdapter((ListAdapter) this.f5958c);
        this.f5959d.setOnItemClickListener(new C1647i(this));
        this.f5962h.setOnClickListener(new ViewOnClickListenerC1648j(this));
        setHasOptionsMenu(true);
        if (GlobalApplication.m6456e()) {
            viewInflate.findViewById(R.id.breadcrumb).setVisibility(8);
            viewFindViewById.setVisibility(8);
            m6813a(EnumC1652n.DELETE);
            m6818c();
        } else {
            m6813a(EnumC1652n.NORMAL);
        }
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6814a(boolean z) {
        for (int i = 0; i < this.f5959d.getCount(); i++) {
            this.f5959d.setItemChecked(i, z);
        }
    }

    /* renamed from: b */
    private void m6816b() {
        File file = new File(C1658q.f6136a);
        if (file != null) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                this.f5959d.setVisibility(0);
                this.f5960e.setVisibility(8);
                for (File file2 : fileArrListFiles) {
                    if (file2.getName().toLowerCase().endsWith(".crypt")) {
                        this.f5957b.add(new C1651m(file2.getPath(), file2.getName(), m6810a(Long.valueOf(file2.lastModified())), Long.toString(file2.lastModified())));
                    }
                }
                return;
            }
            this.f5959d.setVisibility(8);
            this.f5960e.setVisibility(0);
        }
    }

    /* renamed from: a */
    private String m6810a(Long l) {
        Date date = new Date();
        date.setTime(l.longValue());
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(date);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.backup_list_menu, menu);
        this.f5963i = menu;
        if (GlobalApplication.m6456e()) {
            this.f5963i.setGroupVisible(R.id.backcuplist_noraml_menu, false);
            this.f5963i.setGroupVisible(R.id.backcuplist_menu_delete, true);
            this.f5963i.findItem(R.id.btnDeleteComplete).setEnabled(false);
            C3228cp.m11343a(this.f5963i.findItem(R.id.btnDeleteComplete));
        } else {
            this.f5963i.setGroupVisible(R.id.backcuplist_noraml_menu, true);
            this.f5963i.setGroupVisible(R.id.backcuplist_menu_delete, false);
            if (this.f5957b.size() > 0) {
                this.f5963i.findItem(R.id.btnDeleteMode).setEnabled(true);
            } else {
                this.f5963i.findItem(R.id.btnDeleteMode).setEnabled(false);
            }
            C3228cp.m11343a(this.f5963i.findItem(R.id.btnDeleteMode));
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.btnDeleteMode /* 2131166581 */:
                m6813a(EnumC1652n.DELETE);
                if (this.f5959d != null) {
                    int checkedItemCount = this.f5959d.getCheckedItemCount();
                    if (checkedItemCount > 0 && this.f5963i != null) {
                        this.f5963i.findItem(R.id.btnDeleteComplete).setEnabled(true);
                    }
                    if (checkedItemCount == this.f5957b.size() && this.f5962h != null) {
                        this.f5962h.setChecked(true);
                        break;
                    }
                }
                break;
            case R.id.btnForModeChange /* 2131166583 */:
                if (GlobalApplication.m6456e()) {
                    getActivity().finish();
                    break;
                } else {
                    m6813a(EnumC1652n.NORMAL);
                    break;
                }
            case R.id.btnDeleteComplete /* 2131166584 */:
                AbstractC3271a.m11494a(getActivity()).mo11500a(getResources().getString(R.string.menu_chat_delete)).mo11509b(getResources().getString(R.string.selected_backup_delete)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1649k(this)).mo11501a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo11512b();
                break;
        }
        return false;
    }

    /* renamed from: c */
    private void m6818c() {
        if (this.f5959d != null) {
            int checkedItemCount = this.f5959d.getCheckedItemCount();
            if (checkedItemCount > 0 && this.f5963i != null) {
                this.f5963i.findItem(R.id.btnDeleteComplete).setEnabled(true);
            }
            if (checkedItemCount == this.f5957b.size() && this.f5962h != null) {
                this.f5962h.setChecked(true);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005a, code lost:
    
        r8.f5957b.remove(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        new java.io.File(r0.f6114a).delete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0069, code lost:
    
        r0 = com.sec.widget.C3641ai.m13210a(getActivity(), com.sec.chaton.R.string.trunk_toast_deleted, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007b, code lost:
    
        if (com.sec.chaton.util.C3250y.f11737e != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007d, code lost:
    
        com.sec.chaton.util.C3250y.m11443a(r0, com.sec.chaton.localbackup.BackupListView.f5956f);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0082, code lost:
    
        r0 = com.sec.widget.C3641ai.m13210a(getActivity(), com.sec.chaton.R.string.trunk_toast_deleted, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x008b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008c, code lost:
    
        com.sec.widget.C3641ai.m13210a(getActivity(), com.sec.chaton.R.string.trunk_toast_deleted, 0).show();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0097, code lost:
    
        throw r0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m6819a() {
        /*
            r8 = this;
            r7 = 2131427684(0x7f0b0164, float:1.8476991E38)
            r2 = 0
            android.widget.ListView r0 = r8.f5959d
            android.util.SparseBooleanArray r3 = r0.getCheckedItemPositions()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1 = r2
        L10:
            int r0 = r3.size()
            if (r1 >= r0) goto L2d
            boolean r0 = r3.valueAt(r1)
            if (r0 == 0) goto L29
            java.util.ArrayList<com.sec.chaton.localbackup.m> r0 = r8.f5957b
            java.lang.Object r0 = r0.get(r1)
            com.sec.chaton.localbackup.m r0 = (com.sec.chaton.localbackup.C1651m) r0
            java.lang.String r0 = r0.f6114a
            r4.add(r0)
        L29:
            int r0 = r1 + 1
            r1 = r0
            goto L10
        L2d:
            if (r4 == 0) goto L98
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto L98
            r1 = r2
        L36:
            int r0 = r4.size()
            if (r1 >= r0) goto L98
            java.util.ArrayList<com.sec.chaton.localbackup.m> r0 = r8.f5957b
            java.util.Iterator r3 = r0.iterator()
        L42:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L74
            java.lang.Object r0 = r3.next()
            com.sec.chaton.localbackup.m r0 = (com.sec.chaton.localbackup.C1651m) r0
            java.lang.String r5 = r0.f6114a
            java.lang.Object r6 = r4.get(r1)
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L42
            java.util.ArrayList<com.sec.chaton.localbackup.m> r3 = r8.f5957b
            r3.remove(r0)
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8b
            java.lang.String r0 = r0.f6114a     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8b
            r3.<init>(r0)     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8b
            r3.delete()     // Catch: java.lang.Exception -> L78 java.lang.Throwable -> L8b
            android.support.v4.app.FragmentActivity r0 = r8.getActivity()
            android.widget.Toast r0 = com.sec.widget.C3641ai.m13210a(r0, r7, r2)
        L71:
            r0.show()
        L74:
            int r0 = r1 + 1
            r1 = r0
            goto L36
        L78:
            r0 = move-exception
            boolean r3 = com.sec.chaton.util.C3250y.f11737e     // Catch: java.lang.Throwable -> L8b
            if (r3 == 0) goto L82
            java.lang.String r3 = com.sec.chaton.localbackup.BackupListView.f5956f     // Catch: java.lang.Throwable -> L8b
            com.sec.chaton.util.C3250y.m11443a(r0, r3)     // Catch: java.lang.Throwable -> L8b
        L82:
            android.support.v4.app.FragmentActivity r0 = r8.getActivity()
            android.widget.Toast r0 = com.sec.widget.C3641ai.m13210a(r0, r7, r2)
            goto L71
        L8b:
            r0 = move-exception
            android.support.v4.app.FragmentActivity r1 = r8.getActivity()
            android.widget.Toast r1 = com.sec.widget.C3641ai.m13210a(r1, r7, r2)
            r1.show()
            throw r0
        L98:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.localbackup.BackupListView.m6819a():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6813a(EnumC1652n enumC1652n) {
        this.f5961g = enumC1652n;
        switch (C1650l.f6113a[enumC1652n.ordinal()]) {
            case 1:
                if (this.f5962h != null) {
                    this.f5962h.setVisibility(8);
                }
                if (this.f5963i != null) {
                    this.f5963i.setGroupVisible(R.id.backcuplist_noraml_menu, true);
                    this.f5963i.setGroupVisible(R.id.backcuplist_menu_delete, false);
                    if (this.f5957b.size() > 0) {
                        this.f5963i.findItem(R.id.btnDeleteMode).setEnabled(true);
                    } else {
                        this.f5963i.findItem(R.id.btnDeleteMode).setEnabled(false);
                    }
                    C3228cp.m11343a(this.f5963i.findItem(R.id.btnDeleteMode));
                    ((ActivityBackupList) getActivity()).m6788c().mo11583a(GlobalApplication.m6451b().getString(R.string.view_backedup));
                }
                if (this.f5959d != null) {
                    this.f5959d.clearChoices();
                }
                if (this.f5962h != null) {
                    this.f5962h.setChecked(false);
                }
                if (this.f5959d != null) {
                    this.f5959d.setChoiceMode(0);
                }
                this.f5958c.f6127a = false;
                if (this.f5959d != null) {
                    this.f5959d.invalidateViews();
                    break;
                }
                break;
            case 2:
                this.f5962h.setVisibility(0);
                if (this.f5963i != null) {
                    this.f5963i.setGroupVisible(R.id.backcuplist_noraml_menu, false);
                    this.f5963i.setGroupVisible(R.id.backcuplist_menu_delete, true);
                    this.f5963i.findItem(R.id.btnDeleteComplete).setEnabled(false);
                    C3228cp.m11343a(this.f5963i.findItem(R.id.btnDeleteComplete));
                }
                ((ActivityBackupList) getActivity()).m6788c().mo11583a(GlobalApplication.m6451b().getString(R.string.menu_chat_delete));
                this.f5959d.setChoiceMode(2);
                this.f5958c.f6127a = true;
                this.f5959d.invalidateViews();
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.f5957b != null && !this.f5957b.isEmpty()) {
            this.f5957b.clear();
        }
        super.onDestroyView();
    }

    @Override // com.sec.chaton.localbackup.InterfaceC1614b
    public boolean switchViewMode() {
        if (GlobalApplication.m6456e()) {
            getActivity().finish();
            return true;
        }
        if (this.f5961g == EnumC1652n.DELETE) {
            m6813a(EnumC1652n.NORMAL);
            return true;
        }
        return false;
    }
}
