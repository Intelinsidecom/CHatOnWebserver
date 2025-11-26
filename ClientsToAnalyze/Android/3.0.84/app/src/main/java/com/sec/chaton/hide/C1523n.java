package com.sec.chaton.hide;

import android.app.ProgressDialog;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.widget.C3263j;
import com.sec.chaton.widget.CheckableRelativeLayout;
import com.sec.common.CommonApplication;
import com.sec.widget.C3641ai;
import java.util.ArrayList;

/* compiled from: HideListBuddyAdapter.java */
/* renamed from: com.sec.chaton.hide.n */
/* loaded from: classes.dex */
class C1523n extends ArrayAdapter<C1515f> {

    /* renamed from: a */
    ArrayList<C1515f> f5602a;

    /* renamed from: b */
    ArrayList<C1515f> f5603b;

    /* renamed from: c */
    public boolean[] f5604c;

    /* renamed from: d */
    private Context f5605d;

    /* renamed from: e */
    private LayoutInflater f5606e;

    /* renamed from: f */
    private ProgressDialog f5607f;

    /* renamed from: g */
    private ViewGroup f5608g;

    /* renamed from: h */
    private InterfaceC1524o f5609h;

    /* renamed from: a */
    public void m6516a(InterfaceC1524o interfaceC1524o) {
        this.f5609h = interfaceC1524o;
    }

    public C1523n(Context context, int i, ArrayList<C1515f> arrayList) {
        super(context, 0, arrayList);
        this.f5605d = context;
        this.f5602a = arrayList;
        this.f5603b = new ArrayList<>();
        this.f5604c = new boolean[this.f5602a.size()];
        this.f5606e = (LayoutInflater) this.f5605d.getSystemService("layout_inflater");
        this.f5608g = (ViewGroup) this.f5606e.inflate(i, (ViewGroup) null);
        this.f5607f = (ProgressDialog) new C3263j(this.f5605d).m11487a(R.string.dialog_userprofile_updating);
    }

    /* renamed from: a */
    public void m6515a() throws RemoteException, OperationApplicationException {
        try {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            ContentResolver contentResolver = GlobalApplication.m11493l().getContentResolver();
            for (int i = 0; i < this.f5603b.size(); i++) {
                arrayList.add(C1360d.m6052f(contentResolver, this.f5603b.get(i).f5572a));
                this.f5602a.remove(this.f5603b.get(i));
            }
            CommonApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
            this.f5609h.mo6520c();
            C3641ai.m13211a(this.f5605d, this.f5605d.getResources().getString(R.string.hide_list_button_shown), 0).show();
            notifyDataSetChanged();
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m6517a(boolean z) {
        int length = this.f5604c.length;
        for (int i = 0; i < length; i++) {
            this.f5604c[i] = z;
        }
        if (z) {
            this.f5603b.clear();
            this.f5603b.addAll(this.f5602a);
        } else {
            this.f5603b.clear();
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1525p c1525p;
        if (view == null) {
            View viewInflate = this.f5606e.inflate(R.layout.list_item_common_6, (ViewGroup) null);
            C1525p c1525p2 = new C1525p((CheckableRelativeLayout) viewInflate);
            viewInflate.setTag(c1525p2);
            view = viewInflate;
            c1525p = c1525p2;
        } else {
            c1525p = (C1525p) view.getTag();
        }
        c1525p.f5613d.setChecked(this.f5604c[i]);
        C1515f item = getItem(i);
        c1525p.f5610a.setText(item.f5573b);
        C3205bt.m11182a(this.f5605d).m11210a(c1525p.f5612c, item.f5572a);
        return view;
    }
}
