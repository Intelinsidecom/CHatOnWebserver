package com.sec.chaton.buddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.item.BuddyGroupItem;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.util.ProfileImageLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BuddyGroupEditAdapter extends BaseExpandableListAdapter implements SectionIndexer {

    /* renamed from: a */
    private LayoutInflater f529a;

    /* renamed from: b */
    private Context f530b;

    /* renamed from: c */
    private ExpandableListView f531c;

    /* renamed from: d */
    private int f532d;

    /* renamed from: e */
    private int f533e;

    /* renamed from: f */
    private LinearLayout f534f;

    /* renamed from: g */
    private boolean f535g;

    /* renamed from: h */
    private boolean f536h;

    /* renamed from: i */
    private int f537i;

    /* renamed from: j */
    private ArrayList f538j;

    /* renamed from: k */
    private ArrayList f539k;

    /* renamed from: l */
    private HashMap f540l;

    /* renamed from: m */
    private String[] f541m;

    /* renamed from: n */
    private TextView f542n;

    /* renamed from: o */
    private HorizontalScrollView f543o;

    /* renamed from: p */
    private View.OnClickListener f544p = new ViewOnClickListenerC0089am(this);

    public class ChildViewHolder {

        /* renamed from: a */
        CheckBox f545a;

        /* renamed from: b */
        ImageView f546b;

        /* renamed from: c */
        TextView f547c;

        /* renamed from: d */
        TextView f548d;

        public ChildViewHolder(RelativeLayout relativeLayout) {
            this.f545a = (CheckBox) relativeLayout.findViewById(C0062R.id.buddy_child_check);
            this.f546b = (ImageView) relativeLayout.findViewById(C0062R.id.buddy_child_profile);
            this.f547c = (TextView) relativeLayout.findViewById(C0062R.id.buddy_child_name);
            this.f548d = (TextView) relativeLayout.findViewById(C0062R.id.buddy_child_status_msg);
        }
    }

    public class GroupViewHolder {

        /* renamed from: a */
        TextView f549a;

        /* renamed from: b */
        TextView f550b;

        /* renamed from: c */
        ImageView f551c;

        public GroupViewHolder(LinearLayout linearLayout) {
            this.f549a = (TextView) linearLayout.findViewById(C0062R.id.buddy_group_name);
            this.f550b = (TextView) linearLayout.findViewById(C0062R.id.buddy_group_participants);
            this.f551c = (ImageView) linearLayout.findViewById(C0062R.id.buddy_group_fold);
        }
    }

    public BuddyGroupEditAdapter(ExpandableListView expandableListView, Context context, ArrayList arrayList, int i, ArrayList arrayList2, int i2, LinearLayout linearLayout, boolean z, int i3, TextView textView) {
        this.f531c = expandableListView;
        this.f529a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f530b = context;
        this.f538j = arrayList;
        this.f532d = i;
        this.f539k = arrayList2;
        this.f533e = i2;
        this.f534f = linearLayout;
        this.f535g = z;
        this.f537i = i3;
        this.f542n = textView;
        if (this.f537i == 2) {
            this.f536h = true;
        } else {
            this.f536h = false;
        }
    }

    /* renamed from: a */
    public ArrayList m589a() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f539k.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                BuddyItem buddyItem = (BuddyItem) it2.next();
                if (buddyItem.m692q() && !arrayList.contains(buddyItem.m668a())) {
                    arrayList.add(buddyItem.m668a());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void m590a(int i) {
        ArrayList arrayListM589a = m589a();
        if (arrayListM589a.size() <= 0) {
            ((Button) this.f534f.findViewById(C0062R.id.buddy_add_to_group)).setEnabled(false);
            ((Button) this.f534f.findViewById(C0062R.id.buddy_remove_to_group)).setEnabled(false);
            ((Button) this.f534f.findViewById(C0062R.id.buddy_menu_groupchat)).setEnabled(false);
            ((Button) this.f534f.findViewById(C0062R.id.buddy_menu_broadcast)).setEnabled(false);
            return;
        }
        if (i == 1) {
            ((Button) this.f534f.findViewById(C0062R.id.buddy_remove_to_group)).setEnabled(true);
            return;
        }
        if (i == 2) {
            ((Button) this.f534f.findViewById(C0062R.id.buddy_add_to_group)).setEnabled(true);
            return;
        }
        if (i == 3) {
            if (arrayListM589a.size() < 50) {
                ((Button) this.f534f.findViewById(C0062R.id.buddy_menu_groupchat)).setEnabled(true);
            } else {
                ((Button) this.f534f.findViewById(C0062R.id.buddy_menu_groupchat)).setEnabled(false);
            }
            if (arrayListM589a.size() <= 100) {
                ((Button) this.f534f.findViewById(C0062R.id.buddy_menu_broadcast)).setEnabled(true);
            } else {
                ((Button) this.f534f.findViewById(C0062R.id.buddy_menu_broadcast)).setEnabled(false);
            }
        }
    }

    /* renamed from: a */
    public void m591a(HorizontalScrollView horizontalScrollView) {
        this.f543o = horizontalScrollView;
        this.f543o.setVisibility(8);
    }

    /* renamed from: a */
    public void m592a(String str) {
        LinearLayout linearLayout;
        View viewFindViewWithTag;
        if (this.f543o == null || (viewFindViewWithTag = (linearLayout = (LinearLayout) this.f543o.getChildAt(0)).findViewWithTag(str)) == null) {
            return;
        }
        linearLayout.removeView(viewFindViewWithTag);
        if (linearLayout.getChildCount() == 0 && this.f543o.getVisibility() == 0) {
            this.f543o.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void m593a(String str, String str2) {
        if (this.f543o == null) {
            return;
        }
        String str3 = str2.length() > 10 ? str2.substring(0, 10) + "..." : str2;
        LinearLayout linearLayout = (LinearLayout) this.f543o.getChildAt(0);
        if (linearLayout.findViewWithTag(str) == null) {
            Button button = new Button(this.f543o.getContext());
            button.setOnClickListener(this.f544p);
            button.setText(str3);
            button.setTag(str);
            button.setBackgroundResource(C0062R.drawable.btn_choice_panel_xml);
            button.setTextColor(this.f530b.getResources().getColorStateList(C0062R.color.buddy_list_selected_buddy_xml));
            button.setTextSize(1, 16.0f);
            int i = (int) ((8.0d * this.f530b.getResources().getDisplayMetrics().density) + 0.5d);
            button.setPadding(i, 0, i, 0);
            linearLayout.addView(button, -2, -1);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(button.getLayoutParams());
            marginLayoutParams.setMargins(3, 0, 3, 0);
            button.setLayoutParams(new LinearLayout.LayoutParams(marginLayoutParams));
            if (this.f543o.getVisibility() == 8) {
                this.f543o.setVisibility(0);
            }
            this.f543o.post(new RunnableC0090an(this));
        }
    }

    /* renamed from: a */
    public void m594a(String str, boolean z) {
        Iterator it = this.f539k.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                BuddyItem buddyItem = (BuddyItem) it2.next();
                if (buddyItem.m668a().equals(str)) {
                    buddyItem.m672a(z);
                    if (z) {
                        m593a(str, buddyItem.m673b());
                    } else {
                        m592a(str);
                    }
                }
            }
        }
        if (this.f537i == 2) {
            this.f542n.setText(this.f530b.getString(C0062R.string.buddy_group_profile_title_add_member) + " (" + ((LinearLayout) this.f543o.getChildAt(0)).getChildCount() + ")");
        }
    }

    /* renamed from: a */
    public void m595a(boolean z) {
        this.f535g = z;
    }

    /* renamed from: b */
    public void m596b() {
        this.f540l = new HashMap();
        for (int i = 0; i < this.f538j.size(); i++) {
            if (((BuddyGroupItem) this.f538j.get(i)).m659d() == 2) {
                this.f540l.put(((BuddyGroupItem) this.f538j.get(i)).m657b(), Integer.valueOf(i));
            }
        }
        this.f541m = new String[this.f538j.size()];
        for (int i2 = 0; i2 < this.f538j.size(); i2++) {
            if (((BuddyGroupItem) this.f538j.get(i2)).m659d() == 0 || ((BuddyGroupItem) this.f538j.get(i2)).m659d() == -1 || ((BuddyGroupItem) this.f538j.get(i2)).m659d() == 4) {
                this.f541m[i2] = "";
            } else if (((BuddyGroupItem) this.f538j.get(i2)).m659d() == 1) {
                this.f541m[i2] = "★";
            } else {
                this.f541m[i2] = ((BuddyGroupItem) this.f538j.get(i2)).m657b().substring(0, 1);
            }
        }
    }

    /* renamed from: b */
    public void m597b(boolean z) {
        this.f536h = z;
    }

    /* renamed from: c */
    public void m598c() {
        if (this.f543o == null) {
            return;
        }
        ((LinearLayout) this.f543o.getChildAt(0)).removeAllViews();
        this.f543o.setVisibility(8);
    }

    /* renamed from: d */
    public boolean m599d() {
        return this.f536h;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((ArrayList) this.f539k.get(i)).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        ChildViewHolder childViewHolder;
        View view2;
        if (view == null) {
            View viewInflate = this.f529a.inflate(this.f533e, viewGroup, false);
            view2 = viewInflate;
            childViewHolder = new ChildViewHolder((RelativeLayout) viewInflate);
        } else {
            childViewHolder = (ChildViewHolder) view.getTag();
            view2 = view;
        }
        childViewHolder.f547c.setText(((BuddyItem) ((ArrayList) this.f539k.get(i)).get(i2)).m673b());
        String strM676c = ((BuddyItem) ((ArrayList) this.f539k.get(i)).get(i2)).m676c();
        childViewHolder.f548d.setText(strM676c);
        if (((BuddyItem) ((ArrayList) this.f539k.get(i)).get(i2)).m697v() || strM676c == null || strM676c.equals("")) {
            childViewHolder.f548d.setVisibility(4);
        } else {
            childViewHolder.f548d.setVisibility(0);
        }
        if (!this.f536h || ((BuddyItem) ((ArrayList) this.f539k.get(i)).get(i2)).m697v()) {
            childViewHolder.f545a.setVisibility(8);
            childViewHolder.f545a.setOnClickListener(null);
        } else {
            childViewHolder.f545a.setVisibility(0);
            childViewHolder.f545a.setOnClickListener(new ViewOnClickListenerC0088al(this, i, i2));
            if (((BuddyItem) ((ArrayList) this.f539k.get(i)).get(i2)).m692q()) {
                childViewHolder.f545a.setChecked(true);
            } else {
                childViewHolder.f545a.setChecked(false);
            }
        }
        if (((BuddyItem) ((ArrayList) this.f539k.get(i)).get(i2)).m697v()) {
            ProfileImageLoader.m3610a(this.f530b).m3622a(childViewHolder.f546b, ProfileImageLoader.ImageType.GROUP);
        } else {
            ProfileImageLoader.m3610a(this.f530b).m3624a(childViewHolder.f546b, ((BuddyItem) ((ArrayList) this.f539k.get(i)).get(i2)).m668a(), ((BuddyItem) ((ArrayList) this.f539k.get(i)).get(i2)).m693r());
        }
        view2.setTag(childViewHolder);
        return view2;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((ArrayList) this.f539k.get(i)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f538j.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f538j.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (this.f535g) {
            return this.f529a.inflate(C0062R.layout.buddy_adapter_group_item_gone, viewGroup, false);
        }
        View viewInflate = this.f529a.inflate(this.f532d, viewGroup, false);
        GroupViewHolder groupViewHolder = new GroupViewHolder((LinearLayout) viewInflate);
        groupViewHolder.f549a.setText(((BuddyGroupItem) this.f538j.get(i)).m657b());
        groupViewHolder.f550b.setText("(" + ((BuddyGroupItem) this.f538j.get(i)).m658c() + ")");
        if (z) {
            groupViewHolder.f551c.setBackgroundResource(C0062R.drawable.messenger_subtitle_icon_up);
        } else {
            groupViewHolder.f551c.setBackgroundResource(C0062R.drawable.messenger_subtitle_icon_down);
        }
        viewInflate.setTag(groupViewHolder);
        return viewInflate;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        return ((Integer) this.f540l.get(this.f541m[i])).intValue();
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.f541m;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
