package com.sec.chaton.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import com.sec.chaton.R;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: ChatInfoAdapter.java */
/* renamed from: com.sec.chaton.chat.eo */
/* loaded from: classes.dex */
public class C1688eo extends BaseExpandableListAdapter implements SectionIndexer {

    /* renamed from: a */
    public static final String[] f6271a = {"buddy_no", "buddy_name", "buddy_status_message", "is_buddy"};

    /* renamed from: b */
    private LayoutInflater f6272b;

    /* renamed from: c */
    private Context f6273c;

    /* renamed from: d */
    private InterfaceC1691er f6274d;

    /* renamed from: e */
    private ArrayList<C1693et> f6275e;

    /* renamed from: f */
    private ArrayList<ArrayList<C1692es>> f6276f;

    /* renamed from: a */
    public void m8523a(InterfaceC1691er interfaceC1691er) {
        this.f6274d = interfaceC1691er;
    }

    public C1688eo(Context context, ArrayList<C1692es> arrayList, ArrayList<C1692es> arrayList2) {
        this.f6273c = context;
        this.f6272b = (LayoutInflater) context.getSystemService("layout_inflater");
        m8524a(arrayList, arrayList2);
    }

    /* renamed from: a */
    public void m8524a(ArrayList<C1692es> arrayList, ArrayList<C1692es> arrayList2) {
        this.f6276f = m8522b(arrayList, arrayList2);
        this.f6275e = m8521a(this.f6276f.size());
    }

    /* renamed from: a */
    private ArrayList<C1693et> m8521a(int i) {
        ArrayList<C1693et> arrayList = new ArrayList<>();
        if (i > 0) {
            arrayList.add(new C1693et(0, CommonApplication.m18732r().getString(R.string.chatinfo_subtitle_description_participants)));
            if (i > 1) {
                arrayList.add(new C1693et(1, CommonApplication.m18732r().getString(R.string.chatinfo_subtitle_description_pending)));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private ArrayList<ArrayList<C1692es>> m8522b(ArrayList<C1692es> arrayList, ArrayList<C1692es> arrayList2) {
        ArrayList<ArrayList<C1692es>> arrayList3 = new ArrayList<>();
        if (arrayList != null) {
            arrayList3.add(arrayList);
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            arrayList3.add(arrayList2);
        }
        return arrayList3;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return this.f6276f.get(i).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C1694eu c1694eu;
        View view2;
        C1692es c1692es = this.f6276f.get(i).get(i2);
        if (view == null) {
            View viewInflate = this.f6272b.inflate(R.layout.list_item_common_7_non_checkable, viewGroup, false);
            view2 = viewInflate;
            c1694eu = new C1694eu((ViewGroup) viewInflate, this.f6273c);
        } else {
            c1694eu = (C1694eu) view.getTag();
            view2 = view;
        }
        if (c1694eu == null) {
            return view2;
        }
        c1694eu.f6291c.setText(c1692es.m8526b());
        c1694eu.f6292d.setText(c1692es.m8527c());
        if (i == 1) {
            c1694eu.f6290b.setBackgroundResource(R.drawable.frame_background);
            C2496n.m10784c(c1694eu.f6290b, c1692es.m8525a(), EnumC2498p.SQUARE);
        } else {
            c1694eu.f6290b.setBackgroundResource(R.drawable.circle_background);
            C2496n.m10765a(c1694eu.f6290b, c1692es.m8525a(), EnumC2498p.ROUND);
        }
        if (!c1692es.m8528d()) {
            ImageView imageView = new ImageView(this.f6273c);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 21;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(R.drawable.list_ic_add);
            imageView.setBackgroundResource(R.drawable.actionbar_item_background);
            imageView.setOnTouchListener(new ViewOnTouchListenerC1689ep(this));
            imageView.setOnClickListener(new ViewOnClickListenerC1690eq(this, c1692es));
            c1694eu.f6293e.addView(imageView);
            imageView.setVisibility(0);
            c1694eu.f6293e.setVisibility(0);
        } else {
            c1694eu.f6293e.setVisibility(8);
        }
        c1694eu.f6294f = c1692es.m8525a();
        c1694eu.f6295g = c1692es.m8526b();
        c1694eu.f6296h = c1692es.m8527c();
        view2.setTag(c1694eu);
        return view2;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return this.f6276f.get(i).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f6275e.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f6275e.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C1695ev c1695ev;
        if (view == null) {
            View viewInflate = this.f6272b.inflate(R.layout.layout_common_group_header, viewGroup, false);
            C1695ev c1695ev2 = new C1695ev((ViewGroup) viewInflate);
            viewInflate.setTag(c1695ev2);
            view = viewInflate;
            c1695ev = c1695ev2;
        } else {
            c1695ev = (C1695ev) view.getTag();
        }
        c1695ev.f6297a.setText(String.format(this.f6275e.get(i).m8529a(), Integer.valueOf(this.f6276f.get(i).size())));
        if (this.f6275e.size() > 1) {
            if (z) {
                c1695ev.f6297a.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.list_ic_arrow_up, 0);
            } else {
                c1695ev.f6297a.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.list_ic_arrow_down, 0);
            }
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return null;
    }
}
