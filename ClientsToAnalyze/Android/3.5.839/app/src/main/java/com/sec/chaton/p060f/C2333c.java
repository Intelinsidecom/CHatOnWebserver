package com.sec.chaton.p060f;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.multimedia.p078a.C2722d;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.util.C5047m;
import java.util.ArrayList;

/* compiled from: DialogMenuAdapter.java */
/* renamed from: com.sec.chaton.f.c */
/* loaded from: classes.dex */
public class C2333c extends BaseAdapter {

    /* renamed from: a */
    public ChatFragment f8288a;

    /* renamed from: b */
    private final LayoutInflater f8289b;

    /* renamed from: c */
    private ArrayList<C2337g> f8290c;

    public C2333c(ChatFragment chatFragment, ArrayList<C2337g> arrayList) {
        this.f8290c = new ArrayList<>();
        this.f8288a = chatFragment;
        this.f8289b = (LayoutInflater) this.f8288a.getActivity().getSystemService("layout_inflater");
        this.f8290c = arrayList;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2337g c2337g = (C2337g) getItem(i);
        if (view == null) {
            view = this.f8289b.inflate(R.layout.item_dialog_menu, viewGroup, false);
            C2335e c2335e = new C2335e();
            c2335e.f8291a = (ImageView) view.findViewById(R.id.insertMenuIcon);
            c2335e.f8292b = (TextView) view.findViewById(R.id.insertMenuText);
            c2335e.f8293c = (ImageView) view.findViewById(R.id.bigfileTag);
            c2335e.f8294d = (FrameLayout) view.findViewById(R.id.insertMenuFrame);
            view.setTag(c2335e);
        }
        C2335e c2335e2 = (C2335e) view.getTag();
        try {
            c2335e2.f8291a.setImageResource(c2337g.f8296b);
        } catch (OutOfMemoryError e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
            c2335e2.f8291a.setImageDrawable(null);
        }
        if (C4822an.m18205O() && m10254a(c2337g.f8297c)) {
            c2335e2.f8293c.setVisibility(0);
            c2335e2.f8294d.setForeground(this.f8288a.getResources().getDrawable(R.drawable.chat_insert_menu_background_bigfile));
        } else {
            if (c2337g.f8297c == 12 && !C5047m.m19188a(this.f8288a.getActivity(), C2722d.m11408a(this.f8288a.getActivity()))) {
                c2335e2.f8291a.setImageResource(R.drawable.co_attach_p_glympse_disable);
                c2335e2.f8293c.setVisibility(0);
                c2335e2.f8293c.setImageResource(R.drawable.anicon_package_item_download_event_xml);
            } else if (c2337g.f8297c == 9 && !C2948h.m12190a().m12192a(this.f8288a.getActivity(), EnumC2949i.Animessage)) {
                c2335e2.f8291a.setImageResource(R.drawable.co_attach_p_ams_disable);
                c2335e2.f8293c.setVisibility(0);
                c2335e2.f8293c.setImageResource(R.drawable.anicon_package_item_download_event_xml);
            } else {
                c2335e2.f8293c.setVisibility(8);
            }
            c2335e2.f8294d.setForeground(this.f8288a.getResources().getDrawable(R.drawable.chat_insert_menu_background));
        }
        c2335e2.f8292b.setText(this.f8288a.getResources().getString(c2337g.f8295a));
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f8290c.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f8290c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* renamed from: a */
    private boolean m10254a(int i) {
        return i == 0 || i == 2 || i == 3 || i == 4 || i == 10;
    }
}
