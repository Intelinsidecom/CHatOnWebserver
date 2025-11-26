package com.sec.chaton.hide;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.widget.C3263j;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: HideBuddyAdapter.java */
/* renamed from: com.sec.chaton.hide.a */
/* loaded from: classes.dex */
class C1510a extends ArrayAdapter<C1515f> {

    /* renamed from: a */
    public ArrayList<C1515f> f5557a;

    /* renamed from: b */
    private Context f5558b;

    /* renamed from: c */
    private String f5559c;

    /* renamed from: d */
    private String f5560d;

    /* renamed from: e */
    private LayoutInflater f5561e;

    /* renamed from: f */
    private ProgressDialog f5562f;

    /* renamed from: g */
    private ViewGroup f5563g;

    /* renamed from: h */
    private InterfaceC1513d f5564h;

    /* renamed from: i */
    private View.OnClickListener f5565i;

    /* renamed from: j */
    private View.OnClickListener f5566j;

    /* renamed from: a */
    public void m6487a(InterfaceC1513d interfaceC1513d) {
        this.f5564h = interfaceC1513d;
    }

    public C1510a(Context context, int i, ArrayList<C1515f> arrayList) {
        super(context, 0, arrayList);
        this.f5565i = new ViewOnClickListenerC1511b(this);
        this.f5566j = new ViewOnClickListenerC1512c(this);
        this.f5558b = context;
        this.f5557a = arrayList;
        this.f5561e = (LayoutInflater) this.f5558b.getSystemService("layout_inflater");
        this.f5563g = (ViewGroup) this.f5561e.inflate(i, (ViewGroup) null);
        this.f5562f = (ProgressDialog) new C3263j(this.f5558b).m11487a(R.string.dialog_userprofile_updating);
    }

    /* renamed from: a */
    public void m6488a(ArrayList<C1515f> arrayList) {
        this.f5557a = arrayList;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1514e c1514e;
        if (view == null) {
            view = this.f5561e.inflate(R.layout.list_item_common_5, (ViewGroup) null);
            c1514e = new C1514e();
            c1514e.f5569a = (TextView) view.findViewById(R.id.text1);
            c1514e.f5570b = (ImageView) view.findViewById(R.id.image1);
            c1514e.f5571c = (Button) view.findViewById(R.id.button1);
            view.setTag(c1514e);
        } else {
            c1514e = (C1514e) view.getTag();
        }
        c1514e.f5570b.setBackgroundResource(R.drawable.frame_background);
        c1514e.f5570b.setOnClickListener(this.f5565i);
        c1514e.f5570b.setTag(Integer.valueOf(i));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.f5558b).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        c1514e.f5571c.setMaxWidth((int) (displayMetrics.density * 100.0f));
        c1514e.f5571c.setSingleLine(false);
        c1514e.f5571c.setMaxLines(2);
        c1514e.f5571c.setEllipsize(TextUtils.TruncateAt.END);
        c1514e.f5571c.setText(R.string.hide_list_button_show);
        c1514e.f5571c.setTag(Integer.valueOf(i));
        c1514e.f5571c.setOnClickListener(this.f5566j);
        C1515f item = getItem(i);
        c1514e.f5569a.setText(item.f5573b);
        C3205bt.m11182a(this.f5558b).m11210a(c1514e.f5570b, item.f5572a);
        return view;
    }

    /* renamed from: a */
    public void m6489a(String[] strArr) throws RemoteException, OperationApplicationException {
        try {
            ArrayList<ContentProviderOperation> arrayList = new ArrayList<>();
            ContentResolver contentResolver = GlobalApplication.m11493l().getContentResolver();
            for (String str : strArr) {
                arrayList.add(C1360d.m6053g(contentResolver, str));
            }
            CommonApplication.m11493l().getContentResolver().applyBatch("com.sec.chaton.provider", arrayList);
        } catch (OperationApplicationException e) {
            e.printStackTrace();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
