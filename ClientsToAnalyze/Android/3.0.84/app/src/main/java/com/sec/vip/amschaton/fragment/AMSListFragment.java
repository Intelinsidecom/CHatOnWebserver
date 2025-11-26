package com.sec.vip.amschaton.fragment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.settings.downloads.ActivityAmsItemDownloads;
import com.sec.chaton.settings.downloads.C2642q;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3228cp;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.ProgressDialogC3265l;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.vip.amschaton.AMSDrawManager;
import com.sec.vip.amschaton.C3584q;
import com.sec.vip.amschaton.p071a.C3398f;
import java.io.File;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class AMSListFragment extends AMSFragment implements View.OnClickListener {

    /* renamed from: a */
    private int f12728a = 2000;

    /* renamed from: b */
    private int f12729b = 0;

    /* renamed from: c */
    private long f12730c = 0;

    /* renamed from: m */
    private GridView f12731m = null;

    /* renamed from: n */
    private C3499bt f12732n = null;

    /* renamed from: o */
    private CheckedTextView f12733o = null;

    /* renamed from: p */
    private boolean f12734p = false;

    /* renamed from: q */
    private ProgressDialogC3265l f12735q = null;

    /* renamed from: r */
    private LinearLayout f12736r = null;

    /* renamed from: s */
    private View f12737s = null;

    /* renamed from: t */
    private View f12738t = null;

    /* renamed from: u */
    private int f12739u = 4001;

    /* renamed from: v */
    private C3497br f12740v = null;

    /* renamed from: w */
    private C3398f f12741w = null;

    /* renamed from: x */
    private View f12742x = null;

    /* renamed from: y */
    private boolean f12743y = false;

    /* renamed from: z */
    private boolean f12744z = false;

    /* renamed from: A */
    private boolean f12722A = true;

    /* renamed from: B */
    private AdapterView.OnItemLongClickListener f12723B = new C3485bf(this);

    /* renamed from: C */
    private final View.OnClickListener f12724C = new ViewOnClickListenerC3486bg(this);

    /* renamed from: D */
    private Handler f12725D = new HandlerC3487bh(this);

    /* renamed from: E */
    private AdapterView.OnItemClickListener f12726E = new C3489bj(this);

    /* renamed from: F */
    private Handler f12727F = new HandlerC3476ax(this);

    @Override // com.sec.vip.amschaton.fragment.AMSFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseActivity.m3081a(this, true);
        this.f12741w = new C3398f(getActivity());
        this.f12741w.m12126b();
        m12561e(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setRetainInstance(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        getActivity().setTitle(R.string.media_animessage);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_ams_list, viewGroup, false);
        this.f12733o = (CheckedTextView) viewInflate.findViewById(R.id.layout_select_all);
        this.f12733o.setVisibility(8);
        this.f12733o.setOnClickListener(this.f12724C);
        ((FrameLayout) viewInflate.findViewById(R.id.ams_message_list)).setVisibility(0);
        ((FrameLayout) viewInflate.findViewById(R.id.ams_stamp_list)).setVisibility(8);
        this.f12731m = (GridView) viewInflate.findViewById(R.id.grid_user_file_list);
        registerForContextMenu(this.f12731m);
        this.f12731m.setOnItemLongClickListener(this.f12723B);
        m12549b(true);
        m12534a(viewInflate);
        this.f12736r = (LinearLayout) viewInflate.findViewById(R.id.layout_recent_sample);
        this.f12737s = viewInflate.findViewById(R.id.btn_recently);
        this.f12738t = viewInflate.findViewById(R.id.btn_sample);
        this.f12736r.setVisibility(0);
        this.f12737s.setOnClickListener(this);
        this.f12738t.setOnClickListener(this);
        if (this.f12728a == 2002) {
            m12542a(true);
        }
        m12532a(this.f12739u, false);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        C3250y.m11453c("[onDestroy]", getClass().getName());
        if (this.f12741w != null) {
            this.f12741w.mo12098a();
        }
        m12564f();
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        if (this.f12728a == 2002) {
            getActivity().setTitle(R.string.ams_btn_delete);
            menuInflater.inflate(R.menu.cancel_done_menu, menu);
            if (!this.f12743y) {
                menu.findItem(R.id.menu_done).setEnabled(false);
            } else {
                menu.findItem(R.id.menu_done).setEnabled(true);
            }
        } else {
            getActivity().setTitle(R.string.media_animessage);
            menuInflater.inflate(R.menu.ams_list_menu, menu);
            MenuItem menuItemFindItem = menu.findItem(R.id.ams_delete);
            if (this.f12728a == 2000 || this.f12739u == 4000) {
                menuItemFindItem.setEnabled(false);
                C3228cp.m11343a(menuItemFindItem);
            } else {
                menuItemFindItem.setEnabled(true);
                C3228cp.m11343a(menuItemFindItem);
            }
            m12533a(menu.findItem(R.id.ams_download));
        }
        super.onCreateOptionsMenu(menu, menuInflater);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        if (this.f12728a == 2002) {
            if (m12543a()) {
                menu.findItem(R.id.menu_done).setEnabled(true);
            } else {
                menu.findItem(R.id.menu_done).setEnabled(false);
            }
        }
        super.onPrepareOptionsMenu(menu);
    }

    /* renamed from: a */
    private boolean m12543a() {
        boolean[] zArrM12579k = m12579k();
        if (zArrM12579k == null) {
            return false;
        }
        for (boolean z : zArrM12579k) {
            if (z) {
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int i;
        boolean z = false;
        z = false;
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_cancel) {
            mo12415c();
            z = true;
        } else if (itemId == R.id.ams_delete) {
            m12549b(false);
            m12542a(true);
            m12551c(2002);
            m12580l();
            getActivity().supportInvalidateOptionsMenu();
            z = true;
        } else if (itemId == R.id.menu_done) {
            m12549b(true);
            String string = getActivity().getApplicationContext().getString(R.string.ams_delete_single_item);
            boolean[] zArrM12579k = m12579k();
            if (zArrM12579k != null) {
                i = 0;
                for (boolean z2 : zArrM12579k) {
                    if (z2) {
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_btn_delete).mo11509b(i > 1 ? getActivity().getApplicationContext().getString(R.string.selected_items_deleted) : string).mo11515d(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC3482bc(this)).mo11507b(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC3475aw(this)).mo11505a().show();
            getActivity().supportInvalidateOptionsMenu();
            z = true;
        } else if (itemId == R.id.ams_download) {
            Intent intent = new Intent(getActivity(), (Class<?>) ActivityAmsItemDownloads.class);
            intent.putExtra("amsType", EnumC1327e.Template);
            startActivityForResult(intent, 201);
        }
        if (!z) {
            return super.onOptionsItemSelected(menuItem);
        }
        return z;
    }

    @Override // com.sec.vip.amschaton.fragment.AMSFragment
    /* renamed from: c */
    public void mo12415c() {
        if (this.f12728a == 2002) {
            m12549b(true);
            m12553c(false);
            m12551c(2001);
            m12580l();
            m12542a(false);
            this.f12743y = false;
            getActivity().supportInvalidateOptionsMenu();
            return;
        }
        super.mo12415c();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1 && i == 201) {
            m12561e(true);
        }
    }

    @Override // android.support.v4.app.Fragment, android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (view.equals(this.f12731m)) {
            contextMenu.setHeaderTitle(R.string.ams_app_name);
            getActivity().getMenuInflater().inflate(R.menu.ams_ics2_context_menu_my_works, contextMenu);
            if (this.f12739u == 4000 || this.f12722A) {
                contextMenu.findItem(R.id.context_menu_item_delete).setVisible(false);
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onContextItemSelected(MenuItem menuItem) {
        String strM12793a;
        int i;
        Cursor cursorM12125b;
        if (this.f12739u == 4000) {
            if (this.f12741w == null || (cursorM12125b = this.f12741w.m12125b(this.f12730c)) == null) {
                return true;
            }
            String string = cursorM12125b.getString(cursorM12125b.getColumnIndex("ams_path"));
            int iIntValue = Integer.valueOf(cursorM12125b.getString(cursorM12125b.getColumnIndex("ams_type"))).intValue();
            if (string == null) {
                C3250y.m11442a("amsFile is NULL!", getClass().getSimpleName());
                return true;
            }
            switch (menuItem.getItemId()) {
                case R.id.context_menu_item_play /* 2131166571 */:
                    m12552c(string, iIntValue);
                    break;
                case R.id.context_menu_item_send /* 2131166572 */:
                    m12526a(string, null, iIntValue, 1);
                    break;
                case R.id.context_menu_item_edit /* 2131166573 */:
                    m12557d(string, iIntValue);
                    break;
                case R.id.context_menu_item_delete /* 2131166574 */:
                    m12531a(iIntValue, string);
                    break;
            }
            return super.onContextItemSelected(menuItem);
        }
        if (this.f12729b > 0 && this.f12729b < m12571h() + 1) {
            strM12793a = C3584q.m12778a().m12794a(getActivity(), this.f12729b - 1);
            i = 2002;
        } else if (this.f12729b > m12571h() && this.f12729b < m12571h() + m12574i() + 1) {
            strM12793a = C3584q.m12778a().m12805b((this.f12729b - m12571h()) - 1);
            i = 2001;
        } else {
            if (this.f12729b <= m12571h() + m12574i() || this.f12729b >= m12571h() + m12574i() + m12576j() + 1) {
                return true;
            }
            strM12793a = C3584q.m12778a().m12793a(((this.f12729b - m12571h()) - m12574i()) - 1);
            i = 2000;
        }
        if (strM12793a == null) {
            C3250y.m11442a("amsFile is NULL!", getClass().getSimpleName());
            return true;
        }
        switch (menuItem.getItemId()) {
            case R.id.context_menu_item_play /* 2131166571 */:
                m12552c(strM12793a, i);
                break;
            case R.id.context_menu_item_send /* 2131166572 */:
                m12526a(strM12793a, null, i, 1);
                break;
            case R.id.context_menu_item_edit /* 2131166573 */:
                m12557d(strM12793a, i);
                break;
            case R.id.context_menu_item_delete /* 2131166574 */:
                m12531a(i, strM12793a);
                break;
        }
        return super.onContextItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12542a(boolean z) {
        if (this.f12733o != null && this.f12736r != null) {
            this.f12744z = z && this.f12744z;
            this.f12733o.setChecked(this.f12744z);
            this.f12733o.setVisibility(z ? 0 : 8);
            this.f12736r.setVisibility(z ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12549b(boolean z) {
        if (this.f12731m != null) {
            this.f12731m.setOnItemClickListener(null);
            if (z) {
                this.f12731m.setOnItemClickListener(this.f12726E);
            }
        }
    }

    /* renamed from: c */
    private void m12553c(boolean z) {
        if (this.f12739u == 4000) {
            if (this.f12740v != null) {
                this.f12740v.m12718a(z);
            }
        } else if (this.f12732n != null) {
            this.f12732n.m12725a(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m12546b() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean[] zArrM12579k = m12579k();
        if (zArrM12579k != null) {
            if (this.f12739u == 4000) {
                if (this.f12741w != null) {
                    Cursor cursorM12128c = this.f12741w.m12128c();
                    int length = zArrM12579k.length;
                    if (cursorM12128c == null || cursorM12128c.getCount() == 0 || cursorM12128c.getCount() != length) {
                        if (cursorM12128c != null && !cursorM12128c.isClosed()) {
                            cursorM12128c.close();
                            return;
                        }
                        return;
                    }
                    for (int i = 0; i < zArrM12579k.length; i++) {
                        if (zArrM12579k[i]) {
                            cursorM12128c.moveToPosition(i);
                            String string = cursorM12128c.getString(cursorM12128c.getColumnIndex("ams_path"));
                            switch (cursorM12128c.getInt(cursorM12128c.getColumnIndex("ams_type"))) {
                                case 2001:
                                    arrayList2.add(string);
                                    break;
                                case 2002:
                                    arrayList.add(string);
                                    break;
                            }
                        }
                    }
                    if (cursorM12128c != null && !cursorM12128c.isClosed()) {
                        cursorM12128c.close();
                    }
                } else {
                    return;
                }
            } else {
                int length2 = zArrM12579k.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    if (zArrM12579k[i2]) {
                        String strM12805b = null;
                        int iM12571h = m12571h();
                        int iM12574i = m12574i();
                        if (i2 < iM12571h) {
                            strM12805b = C3584q.m12778a().m12794a(getActivity(), i2);
                            if (strM12805b != null) {
                                arrayList.add(strM12805b);
                            }
                        } else if (i2 < iM12574i + iM12571h && (strM12805b = C3584q.m12778a().m12805b(i2 - iM12571h)) != null) {
                            arrayList2.add(strM12805b);
                        }
                        if (strM12805b != null) {
                            m12541a(strM12805b);
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                C3584q.m12778a().m12799a(getActivity(), (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (arrayList2.size() > 0) {
                C3584q.m12778a().m12803a((String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
            m12524a(R.string.ams_msg_deleted);
            m12561e(false);
        }
    }

    /* renamed from: a */
    private void m12531a(int i, String str) {
        AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_btn_delete).mo11506b(R.string.ams_delete_single_item).mo11515d(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC3484be(this, i, str)).mo11507b(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC3483bd(this)).mo11505a().show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_recently /* 2131165790 */:
                if (!this.f12737s.isSelected()) {
                    m12532a(4000, true);
                    break;
                }
                break;
            case R.id.btn_sample /* 2131165791 */:
                if (!this.f12738t.isSelected()) {
                    m12532a(4001, true);
                    break;
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m12558d(boolean z) {
        m12553c(z);
        m12580l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12561e(boolean z) {
        if (!z) {
            this.f12725D.sendEmptyMessage(0);
        } else if (!this.f12734p) {
            this.f12734p = true;
            new AsyncTaskC3496bq(this, null).execute(new Void[0]);
        }
    }

    /* renamed from: a */
    private void m12533a(MenuItem menuItem) {
        int iM9632a = C2642q.m9632a(EnumC1327e.Template);
        C3228cp.m11346b(menuItem);
        C3228cp.m11344a(menuItem, iM9632a > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12532a(int i, boolean z) {
        this.f12739u = i;
        switch (this.f12739u) {
            case 4000:
                this.f12737s.setSelected(true);
                this.f12738t.setSelected(false);
                m12565f(z);
                break;
            case 4001:
                this.f12738t.setSelected(true);
                this.f12737s.setSelected(false);
                m12570g(z);
                break;
        }
        m12547b(this.f12739u);
        m12568g();
    }

    /* renamed from: f */
    private void m12565f(boolean z) {
        if (this.f12741w != null && this.f12731m != null) {
            if (this.f12740v == null || z) {
                Cursor cursorM12128c = this.f12741w.m12128c();
                if (cursorM12128c != null) {
                    boolean z2 = false;
                    for (boolean zMoveToFirst = cursorM12128c.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorM12128c.moveToNext()) {
                        String string = cursorM12128c.getString(cursorM12128c.getColumnIndex("ams_path"));
                        if (string != null && !new File(string).exists()) {
                            m12541a(string);
                            z2 = true;
                        }
                    }
                    this.f12740v = new C3497br(this, getActivity(), z2 ? this.f12741w.m12128c() : cursorM12128c);
                } else {
                    return;
                }
            }
            this.f12731m.setAdapter((ListAdapter) this.f12740v);
            this.f12740v.m12717a(this.f12727F);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m12541a(String str) {
        if (str != null) {
            this.f12741w.m12127b(str);
        }
    }

    /* renamed from: b */
    private void m12547b(int i) {
        if (this.f12742x != null) {
            switch (i) {
                case 4000:
                    ((ImageView) this.f12742x.findViewById(R.id.image1)).setImageResource(R.drawable.no_contents_ams_recently);
                    ((TextView) this.f12742x.findViewById(R.id.text1)).setText(R.string.ams_no_recent_animessages);
                    ((TextView) this.f12742x.findViewById(R.id.text2)).setVisibility(8);
                    break;
                default:
                    ((ImageView) this.f12742x.findViewById(R.id.image1)).setImageResource(R.drawable.nocontents_ams_backgroud);
                    ((TextView) this.f12742x.findViewById(R.id.text1)).setText(R.string.ams_no_animation_messages);
                    ((TextView) this.f12742x.findViewById(R.id.text2)).setVisibility(0);
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m12534a(View view) {
        this.f12742x = view.findViewById(R.id.layout_no_items);
        ((ImageView) this.f12742x.findViewById(R.id.image1)).setMinimumHeight((int) C3172an.m11086b(110.0f));
        ((ImageView) this.f12742x.findViewById(R.id.image1)).setMinimumWidth((int) C3172an.m11086b(110.0f));
        ((ImageView) this.f12742x.findViewById(R.id.image1)).setScaleType(ImageView.ScaleType.FIT_XY);
        ((TextView) this.f12742x.findViewById(R.id.text2)).setText(R.string.ams_tap_create_button);
        View viewFindViewById = this.f12742x.findViewById(R.id.image1);
        viewFindViewById.setOnClickListener(new ViewOnClickListenerC3488bi(this, viewFindViewById));
        this.f12731m.setEmptyView(this.f12742x);
        this.f12731m.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m12560e() {
        if (this.f12735q != null) {
            this.f12735q = null;
        }
        this.f12735q = new ProgressDialogC3265l(getActivity());
        this.f12735q.setProgressStyle(0);
        this.f12735q.setMessage(getString(R.string.ams_msg_progress_ams_file_loading));
        this.f12735q.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m12564f() {
        if (this.f12735q != null && this.f12735q.isShowing()) {
            this.f12735q.dismiss();
        }
        this.f12735q = null;
    }

    /* renamed from: g */
    private void m12570g(boolean z) {
        if (this.f12731m != null) {
            if (this.f12732n == null || z) {
                this.f12732n = new C3499bt(this, getActivity());
            }
            this.f12732n.m12724a(this.f12727F);
            this.f12731m.setAdapter((ListAdapter) this.f12732n);
            m12580l();
        }
    }

    /* renamed from: g */
    private void m12568g() {
        if (this.f12728a != 2002) {
            int iM12571h = 0;
            if (this.f12739u == 4000) {
                if (this.f12740v != null) {
                    iM12571h = this.f12740v.getCount();
                }
            } else {
                iM12571h = m12571h() + m12574i();
            }
            if (iM12571h > 0) {
                m12551c(2001);
            } else {
                m12551c(2000);
            }
            if (getActivity() != null && !isDetached()) {
                getActivity().supportInvalidateOptionsMenu();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12551c(int i) {
        this.f12728a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public int m12571h() {
        return C3584q.m12778a().m12809c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public int m12574i() {
        return C3584q.m12778a().m12811e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public int m12576j() {
        return C3584q.m12778a().m12810d();
    }

    /* renamed from: k */
    private boolean[] m12579k() {
        if (this.f12739u == 4000) {
            if (this.f12740v == null) {
                return null;
            }
            return this.f12740v.m12719a();
        }
        if (this.f12732n != null) {
            return this.f12732n.m12726a();
        }
        return null;
    }

    /* renamed from: l */
    private void m12580l() {
        if (this.f12739u == 4000) {
            if (this.f12740v != null) {
                this.f12740v.notifyDataSetChanged();
            }
        } else if (this.f12732n != null) {
            this.f12732n.m12727b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12552c(String str, int i) {
        if (new AMSDrawManager(getActivity()).m12019b(str)) {
            m12549b(false);
            m12525a(str, i);
        } else {
            AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_attention_title).mo11506b(R.string.ams_attention_non_editable).mo11515d(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC3478az(this, str, i)).mo11507b(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC3477ay(this)).mo11505a().show();
        }
    }

    /* renamed from: d */
    private void m12557d(String str, int i) {
        if (new AMSDrawManager(getActivity()).m12019b(str)) {
            m12549b(false);
            m12527a(str, false, true, false, true);
        } else {
            AbstractC3271a.m11494a(getActivity()).mo11495a(R.string.ams_attention_title).mo11506b(R.string.ams_attention_non_editable).mo11515d(R.string.ams_btn_ok, new DialogInterfaceOnClickListenerC3481bb(this, str, i)).mo11507b(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC3480ba(this)).mo11505a().show();
        }
    }
}
