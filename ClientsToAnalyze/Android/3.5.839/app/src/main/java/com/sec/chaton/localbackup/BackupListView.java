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
import com.sec.chaton.util.C4880cr;
import com.sec.chaton.widget.AdaptableTextView;
import com.sec.common.p123a.AbstractC4932a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes.dex */
public class BackupListView extends Fragment implements InterfaceC2516b {

    /* renamed from: b */
    ArrayList<C2556o> f8998b;

    /* renamed from: c */
    C2558q f8999c;

    /* renamed from: d */
    ListView f9000d;

    /* renamed from: e */
    TextView f9001e;

    /* renamed from: g */
    private EnumC2557p f9002g;

    /* renamed from: h */
    private CheckedTextView f9003h;

    /* renamed from: i */
    private Menu f9004i;

    /* renamed from: j */
    private View f9005j;

    /* renamed from: f */
    private static final String f8997f = BackupListView.class.getSimpleName();

    /* renamed from: a */
    public static String f8996a = "backup_file_name";

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_backuplist, viewGroup, false);
        this.f9000d = (ListView) viewInflate.findViewById(R.id.backuplist);
        this.f9003h = (CheckedTextView) viewInflate.findViewById(R.id.selectAll);
        this.f9001e = (TextView) viewInflate.findViewById(R.id.emptylist);
        this.f9005j = viewInflate.findViewById(R.id.backup_path);
        ((AdaptableTextView) this.f9005j.findViewById(R.id.text1)).setText(C2560s.f9180a);
        this.f8998b = new ArrayList<>();
        this.f8998b.clear();
        m10845c();
        this.f8999c = new C2558q(getActivity(), this.f8998b);
        this.f9000d.setAdapter((ListAdapter) this.f8999c);
        this.f9000d.setOnItemClickListener(new C2551k(this));
        this.f9003h.setOnClickListener(new ViewOnClickListenerC2552l(this));
        setHasOptionsMenu(true);
        m10841a(EnumC2557p.NORMAL);
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10842a(boolean z) {
        for (int i = 0; i < this.f9000d.getCount(); i++) {
            this.f9000d.setItemChecked(i, z);
        }
    }

    /* renamed from: c */
    private void m10845c() {
        File file = new File(C2560s.f9180a);
        if (file != null) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles != null) {
                this.f9000d.setVisibility(0);
                this.f9001e.setVisibility(8);
                for (File file2 : fileArrListFiles) {
                    if (file2.getName().toLowerCase().endsWith(".crypt")) {
                        this.f8998b.add(new C2556o(file2.getPath(), file2.getName(), m10838a(Long.valueOf(file2.lastModified())), Long.toString(file2.lastModified())));
                    }
                }
                return;
            }
            this.f9000d.setVisibility(8);
            this.f9001e.setVisibility(0);
        }
    }

    /* renamed from: a */
    private String m10838a(Long l) {
        Date date = new Date();
        date.setTime(l.longValue());
        return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(date);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.backup_list_menu, menu);
        this.f9004i = menu;
        this.f9004i.setGroupVisible(R.id.backcuplist_noraml_menu, true);
        this.f9004i.setGroupVisible(R.id.backcuplist_menu_delete, false);
        if (this.f8998b.size() > 0) {
            this.f9004i.findItem(R.id.btnDeleteMode).setEnabled(true);
        } else {
            this.f9004i.findItem(R.id.btnDeleteMode).setEnabled(false);
        }
        C4880cr.m18523a(this.f9004i.findItem(R.id.btnDeleteMode));
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.btnDeleteMode /* 2131166663 */:
                m10841a(EnumC2557p.DELETE);
                break;
            case R.id.btnForModeChange /* 2131166665 */:
                m10841a(EnumC2557p.NORMAL);
                break;
            case R.id.btnDeleteComplete /* 2131166666 */:
                AbstractC4932a.m18733a(getActivity()).mo18740a(getResources().getString(R.string.menu_chat_delete)).mo18749b(getResources().getString(R.string.selected_backup_delete)).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2553m(this)).mo18741a(getResources().getString(R.string.dialog_cancel), (DialogInterface.OnClickListener) null).mo18752b();
                break;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0059, code lost:
    
        new java.io.File(r7.f8998b.get(r3).f9164a).delete();
        r7.f8998b.remove(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0070, code lost:
    
        r0 = com.sec.widget.C5179v.m19810a(getActivity(), com.sec.chaton.R.string.trunk_toast_deleted, 0);
     */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m10847b() {
        /*
            r7 = this;
            r6 = 2131428009(0x7f0b02a9, float:1.847765E38)
            r2 = 0
            android.widget.ListView r0 = r7.f9000d
            android.util.SparseBooleanArray r3 = r0.getCheckedItemPositions()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1 = r2
        L10:
            int r0 = r3.size()
            if (r1 >= r0) goto L2d
            boolean r0 = r3.valueAt(r1)
            if (r0 == 0) goto L29
            java.util.ArrayList<com.sec.chaton.localbackup.o> r0 = r7.f8998b
            java.lang.Object r0 = r0.get(r1)
            com.sec.chaton.localbackup.o r0 = (com.sec.chaton.localbackup.C2556o) r0
            java.lang.String r0 = r0.f9164a
            r4.add(r0)
        L29:
            int r0 = r1 + 1
            r1 = r0
            goto L10
        L2d:
            if (r4 == 0) goto La3
            boolean r0 = r4.isEmpty()
            if (r0 != 0) goto La3
            r1 = r2
        L36:
            int r0 = r4.size()
            if (r1 >= r0) goto La3
            r3 = r2
        L3d:
            java.util.ArrayList<com.sec.chaton.localbackup.o> r0 = r7.f8998b
            int r0 = r0.size()
            if (r3 >= r0) goto L7b
            java.util.ArrayList<com.sec.chaton.localbackup.o> r0 = r7.f8998b
            java.lang.Object r0 = r0.get(r3)
            com.sec.chaton.localbackup.o r0 = (com.sec.chaton.localbackup.C2556o) r0
            java.lang.String r0 = r0.f9164a
            java.lang.Object r5 = r4.get(r1)
            boolean r0 = r0.equals(r5)
            if (r0 == 0) goto L9f
            java.io.File r5 = new java.io.File     // Catch: java.lang.Exception -> L7f java.lang.Throwable -> L92
            java.util.ArrayList<com.sec.chaton.localbackup.o> r0 = r7.f8998b     // Catch: java.lang.Exception -> L7f java.lang.Throwable -> L92
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Exception -> L7f java.lang.Throwable -> L92
            com.sec.chaton.localbackup.o r0 = (com.sec.chaton.localbackup.C2556o) r0     // Catch: java.lang.Exception -> L7f java.lang.Throwable -> L92
            java.lang.String r0 = r0.f9164a     // Catch: java.lang.Exception -> L7f java.lang.Throwable -> L92
            r5.<init>(r0)     // Catch: java.lang.Exception -> L7f java.lang.Throwable -> L92
            r5.delete()     // Catch: java.lang.Exception -> L7f java.lang.Throwable -> L92
            java.util.ArrayList<com.sec.chaton.localbackup.o> r0 = r7.f8998b     // Catch: java.lang.Exception -> L7f java.lang.Throwable -> L92
            r0.remove(r3)     // Catch: java.lang.Exception -> L7f java.lang.Throwable -> L92
            android.support.v4.app.FragmentActivity r0 = r7.getActivity()
            android.widget.Toast r0 = com.sec.widget.C5179v.m19810a(r0, r6, r2)
        L78:
            r0.show()
        L7b:
            int r0 = r1 + 1
            r1 = r0
            goto L36
        L7f:
            r0 = move-exception
            boolean r3 = com.sec.chaton.util.C4904y.f17875e     // Catch: java.lang.Throwable -> L92
            if (r3 == 0) goto L89
            java.lang.String r3 = com.sec.chaton.localbackup.BackupListView.f8997f     // Catch: java.lang.Throwable -> L92
            com.sec.chaton.util.C4904y.m18635a(r0, r3)     // Catch: java.lang.Throwable -> L92
        L89:
            android.support.v4.app.FragmentActivity r0 = r7.getActivity()
            android.widget.Toast r0 = com.sec.widget.C5179v.m19810a(r0, r6, r2)
            goto L78
        L92:
            r0 = move-exception
            android.support.v4.app.FragmentActivity r1 = r7.getActivity()
            android.widget.Toast r1 = com.sec.widget.C5179v.m19810a(r1, r6, r2)
            r1.show()
            throw r0
        L9f:
            int r0 = r3 + 1
            r3 = r0
            goto L3d
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.localbackup.BackupListView.m10847b():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m10841a(EnumC2557p enumC2557p) {
        this.f9002g = enumC2557p;
        switch (C2554n.f9161a[enumC2557p.ordinal()]) {
            case 1:
                if (this.f9003h != null) {
                    this.f9003h.setVisibility(8);
                }
                this.f9005j.setVisibility(0);
                if (this.f9004i != null) {
                    this.f9004i.setGroupVisible(R.id.backcuplist_noraml_menu, true);
                    this.f9004i.setGroupVisible(R.id.backcuplist_menu_delete, false);
                    if (this.f8998b.size() > 0) {
                        this.f9004i.findItem(R.id.btnDeleteMode).setEnabled(true);
                    } else {
                        this.f9004i.findItem(R.id.btnDeleteMode).setEnabled(false);
                    }
                    C4880cr.m18523a(this.f9004i.findItem(R.id.btnDeleteMode));
                    ((ActivityBackupList) getActivity()).m10814h().mo18823a(GlobalApplication.m10283b().getString(R.string.view_backedup));
                }
                if (this.f9000d != null) {
                    this.f9000d.clearChoices();
                }
                if (this.f9003h != null) {
                    this.f9003h.setChecked(false);
                }
                if (this.f9000d != null) {
                    this.f9000d.setChoiceMode(0);
                }
                this.f8999c.f9171a = false;
                if (this.f9000d != null) {
                    this.f9000d.invalidateViews();
                    break;
                }
                break;
            case 2:
                this.f9003h.setVisibility(0);
                this.f9005j.setVisibility(8);
                if (this.f9004i != null) {
                    this.f9004i.setGroupVisible(R.id.backcuplist_noraml_menu, false);
                    this.f9004i.setGroupVisible(R.id.backcuplist_menu_delete, true);
                    this.f9004i.findItem(R.id.btnDeleteComplete).setEnabled(false);
                    C4880cr.m18523a(this.f9004i.findItem(R.id.btnDeleteComplete));
                }
                ((ActivityBackupList) getActivity()).m10814h().mo18823a(GlobalApplication.m10283b().getString(R.string.menu_chat_delete));
                if (this.f9000d != null) {
                    this.f9000d.setChoiceMode(2);
                    this.f9000d.clearChoices();
                    this.f9000d.invalidateViews();
                }
                this.f8999c.f9171a = true;
                break;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        if (this.f8998b != null && !this.f8998b.isEmpty()) {
            this.f8998b.clear();
        }
        super.onDestroyView();
    }

    @Override // com.sec.chaton.localbackup.InterfaceC2516b
    /* renamed from: a */
    public boolean mo10846a() {
        if (this.f9002g != EnumC2557p.DELETE) {
            return false;
        }
        m10841a(EnumC2557p.NORMAL);
        return true;
    }
}
