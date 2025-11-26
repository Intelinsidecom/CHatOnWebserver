package com.sec.chaton.smsplugin.p103c;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: MmsDialogMenuAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.c.c */
/* loaded from: classes.dex */
public class C3808c extends BaseAdapter {

    /* renamed from: a */
    private Context f13670a;

    /* renamed from: b */
    private LayoutInflater f13671b;

    /* renamed from: c */
    private ArrayList<C3809d> f13672c;

    public C3808c(Context context, ArrayList<C3809d> arrayList) {
        this.f13672c = new ArrayList<>();
        this.f13670a = context;
        this.f13671b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f13672c = arrayList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3809d c3809d = (C3809d) getItem(i);
        if (view == null) {
            view = this.f13671b.inflate(R.layout.item_dialog_menu, viewGroup, false);
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.insertMenuFrame);
        ImageView imageView = (ImageView) view.findViewById(R.id.insertMenuIcon);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.bigfileTag);
        TextView textView = (TextView) view.findViewById(R.id.insertMenuText);
        try {
            imageView.setImageResource(c3809d.f13674b);
        } catch (OutOfMemoryError e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
            imageView.setImageDrawable(null);
        }
        switch (c3809d.f13675c) {
            case 0:
            case 2:
            case 4:
                if (C3847e.m14652aC()) {
                    imageView2.setVisibility(0);
                    frameLayout.setForeground(this.f13670a.getResources().getDrawable(R.drawable.chat_insert_menu_background_bigfile));
                    break;
                }
            case 1:
            case 3:
            default:
                imageView2.setVisibility(8);
                frameLayout.setForeground(this.f13670a.getResources().getDrawable(R.drawable.chat_insert_menu_background));
                break;
        }
        textView.setText(CommonApplication.m18732r().getResources().getString(c3809d.f13673a));
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13672c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f13672c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
