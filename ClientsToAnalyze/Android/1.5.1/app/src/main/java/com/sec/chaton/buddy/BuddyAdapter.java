package com.sec.chaton.buddy;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
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
import android.widget.Toast;
import com.sec.chaton.C0062R;
import com.sec.chaton.buddy.item.BuddyGroupItem;
import com.sec.chaton.buddy.item.BuddyItem;
import com.sec.chaton.chat.ChatFragment;
import com.sec.chaton.database.ChatONContract;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.util.ProfileImageLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BuddyAdapter extends BaseExpandableListAdapter implements SectionIndexer {

    /* renamed from: a */
    private ExpandableListView f383a;

    /* renamed from: b */
    private LayoutInflater f384b;

    /* renamed from: c */
    private Context f385c;

    /* renamed from: d */
    private ArrayList f386d;

    /* renamed from: e */
    private int f387e;

    /* renamed from: f */
    private ArrayList f388f;

    /* renamed from: g */
    private int f389g;

    /* renamed from: h */
    private boolean f390h;

    /* renamed from: i */
    private int f391i;

    /* renamed from: j */
    private int f392j;

    /* renamed from: k */
    private String[] f393k;

    /* renamed from: l */
    private HashMap f394l;

    /* renamed from: m */
    private LinearLayout f395m;

    /* renamed from: n */
    private TextView f396n;

    /* renamed from: o */
    private Bundle f397o;

    /* renamed from: p */
    private HorizontalScrollView f398p;

    /* renamed from: q */
    private View.OnClickListener f399q = new ViewOnClickListenerC0126s(this);

    public class ChildViewHolder {

        /* renamed from: a */
        CheckBox f400a;

        /* renamed from: b */
        ImageView f401b;

        /* renamed from: c */
        TextView f402c;

        /* renamed from: d */
        TextView f403d;

        /* renamed from: e */
        RelativeLayout f404e;

        public ChildViewHolder(RelativeLayout relativeLayout) {
            this.f404e = relativeLayout;
            this.f400a = (CheckBox) this.f404e.findViewById(C0062R.id.buddy_child_check);
            this.f401b = (ImageView) this.f404e.findViewById(C0062R.id.buddy_child_profile);
            this.f402c = (TextView) this.f404e.findViewById(C0062R.id.buddy_child_name);
            this.f403d = (TextView) this.f404e.findViewById(C0062R.id.buddy_child_status_msg);
        }
    }

    public class GroupViewHolder {

        /* renamed from: a */
        TextView f405a;

        /* renamed from: b */
        TextView f406b;

        /* renamed from: c */
        ImageView f407c;

        /* renamed from: d */
        LinearLayout f408d;

        public GroupViewHolder(LinearLayout linearLayout) {
            this.f408d = linearLayout;
            this.f405a = (TextView) linearLayout.findViewById(C0062R.id.buddy_group_name);
            this.f406b = (TextView) linearLayout.findViewById(C0062R.id.buddy_group_participants);
            this.f407c = (ImageView) linearLayout.findViewById(C0062R.id.buddy_group_fold);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m445a(int i) {
            this.f408d.setVisibility(i);
            this.f405a.setVisibility(i);
            this.f406b.setVisibility(i);
            this.f407c.setVisibility(i);
        }
    }

    public BuddyAdapter(ExpandableListView expandableListView, Context context, ArrayList arrayList, int i, ArrayList arrayList2, int i2, boolean z, int i3, LinearLayout linearLayout, int i4, TextView textView, Bundle bundle) {
        this.f383a = expandableListView;
        this.f384b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f385c = context;
        this.f386d = arrayList;
        this.f387e = i;
        this.f388f = arrayList2;
        this.f389g = i2;
        this.f390h = z;
        this.f391i = i3;
        this.f392j = i4;
        this.f395m = linearLayout;
        this.f396n = textView;
        this.f397o = bundle;
    }

    /* renamed from: a */
    private void m434a(String str) {
        LinearLayout linearLayout;
        View viewFindViewWithTag;
        if (this.f398p == null || (viewFindViewWithTag = (linearLayout = (LinearLayout) this.f398p.getChildAt(0)).findViewWithTag(str)) == null) {
            return;
        }
        linearLayout.removeView(viewFindViewWithTag);
        if (linearLayout.getChildCount() == 0 && this.f398p.getVisibility() == 0) {
            this.f398p.setVisibility(8);
        }
    }

    /* renamed from: b */
    private void m436b(int i) {
        ChatONLogWriter.m3512f("setTitle() : " + i, "BuddyFragment");
        if (this.f392j == 1) {
            this.f396n.setVisibility(8);
            return;
        }
        if (this.f392j == 2) {
            this.f396n.setVisibility(0);
            this.f396n.setText(this.f385c.getString(C0062R.string.buddy_list_optionmenu_groupchat) + " (" + i + ")");
            return;
        }
        if (this.f392j == 3) {
            this.f396n.setVisibility(0);
            this.f396n.setText(this.f385c.getString(C0062R.string.buddy_list_optionmenu_broadcast) + " (" + i + ")");
            return;
        }
        if (this.f392j == 5) {
            this.f396n.setVisibility(0);
            this.f396n.setText(this.f385c.getString(C0062R.string.chat_view_menu_invite) + " (" + i + ")");
        } else if (this.f392j == 6) {
            this.f396n.setVisibility(0);
            this.f396n.setText(this.f385c.getString(C0062R.string.buddy_chat_profile));
        } else if (this.f392j == 9) {
            this.f396n.setVisibility(0);
            this.f396n.setText(this.f385c.getString(C0062R.string.memo_btn_blind) + " (" + i + ")");
        }
    }

    /* renamed from: a */
    public void m439a() {
        if (this.f391i != 11) {
            return;
        }
        this.f394l = new HashMap();
        for (int i = 0; i < this.f386d.size(); i++) {
            if (((BuddyGroupItem) this.f386d.get(i)).m659d() == 2) {
                this.f394l.put(((BuddyGroupItem) this.f386d.get(i)).m657b(), Integer.valueOf(i));
            }
        }
        this.f393k = new String[this.f386d.size()];
        for (int i2 = 0; i2 < this.f386d.size(); i2++) {
            if (((BuddyGroupItem) this.f386d.get(i2)).m659d() == 0 || ((BuddyGroupItem) this.f386d.get(i2)).m659d() == -1 || ((BuddyGroupItem) this.f386d.get(i2)).m659d() == 4) {
                this.f393k[i2] = "";
            } else if (((BuddyGroupItem) this.f386d.get(i2)).m659d() == 1) {
                this.f393k[i2] = "★";
            } else {
                this.f393k[i2] = ((BuddyGroupItem) this.f386d.get(i2)).m657b().substring(0, 1);
            }
        }
    }

    /* renamed from: a */
    public void m440a(int i) {
        this.f391i = i;
    }

    /* renamed from: a */
    public void m441a(HorizontalScrollView horizontalScrollView) {
        this.f398p = horizontalScrollView;
        this.f398p.setVisibility(8);
    }

    /* renamed from: a */
    public void m442a(String str, String str2) {
        if (this.f398p == null) {
            return;
        }
        String str3 = str2.length() > 20 ? str2.substring(0, 20) + "..." : str2;
        LinearLayout linearLayout = (LinearLayout) this.f398p.getChildAt(0);
        if (linearLayout.findViewWithTag(str) == null) {
            Button button = new Button(this.f398p.getContext());
            button.setOnClickListener(this.f399q);
            button.setText(str3);
            button.setTag(str);
            button.setBackgroundResource(C0062R.drawable.btn_choice_panel_xml);
            button.setTextColor(this.f385c.getResources().getColorStateList(C0062R.color.buddy_list_selected_buddy_xml));
            button.setTextSize(1, 16.0f);
            int i = (int) ((8.0d * this.f385c.getResources().getDisplayMetrics().density) + 0.5d);
            button.setPadding(i, 0, i, 0);
            linearLayout.addView(button, -2, -1);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(button.getLayoutParams());
            marginLayoutParams.setMargins(3, 0, 3, 0);
            button.setLayoutParams(new LinearLayout.LayoutParams(marginLayoutParams));
            if (this.f398p.getVisibility() == 8) {
                this.f398p.setVisibility(0);
            }
            this.f398p.post(new RunnableC0125r(this));
        }
    }

    /* renamed from: a */
    public void m443a(String str, boolean z) {
        Iterator it = this.f388f.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                BuddyItem buddyItem = (BuddyItem) it2.next();
                if (buddyItem.m668a().equals(str)) {
                    buddyItem.m672a(z);
                    if (z) {
                        m442a(str, buddyItem.m673b());
                    } else {
                        m434a(str);
                    }
                }
            }
        }
        if (this.f392j != 9) {
            m436b(((LinearLayout) this.f398p.getChildAt(0)).getChildCount());
        }
    }

    /* renamed from: b */
    public void m444b() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f388f.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                BuddyItem buddyItem = (BuddyItem) it2.next();
                if (buddyItem.m692q()) {
                    hashSet.add(buddyItem.m668a());
                }
            }
        }
        if (hashSet.size() <= 0) {
            this.f395m.findViewById(C0062R.id.buddy_menu_group_chat).setEnabled(false);
            this.f395m.findViewById(C0062R.id.buddy_menu_broadcast).setEnabled(false);
            this.f395m.findViewById(C0062R.id.buddy_menu_invite).setEnabled(false);
            this.f395m.findViewById(C0062R.id.buddy_menu_add_group).setEnabled(false);
            return;
        }
        if (this.f392j == 2) {
            if (hashSet.size() + 1 > 50) {
                Toast.makeText(this.f385c, String.format(this.f385c.getString(C0062R.string.buddy_list_groupchat_toast_failed_exceed), 50), 0).show();
                this.f395m.findViewById(C0062R.id.buddy_menu_group_chat).setEnabled(false);
            } else {
                this.f395m.findViewById(C0062R.id.buddy_menu_group_chat).setEnabled(true);
            }
        }
        if (this.f392j == 3) {
            if (hashSet.size() > 100) {
                Toast.makeText(this.f385c, String.format(this.f385c.getString(C0062R.string.buddy_list_broadcast_toast_failed_exceed), 100), 0).show();
                this.f395m.findViewById(C0062R.id.buddy_menu_broadcast).setEnabled(false);
            } else {
                this.f395m.findViewById(C0062R.id.buddy_menu_broadcast).setEnabled(true);
            }
        }
        if (this.f392j == 5) {
            int length = this.f397o.getStringArray(ChatFragment.f724c).length;
            if (this.f397o.getInt("chatType") == ChatONContract.InBoxTable.ChatType.ONETOONE.m2189a() || this.f397o.getInt("chatType") == ChatONContract.InBoxTable.ChatType.GROUPCHAT.m2189a()) {
                if (length + hashSet.size() + 1 > 50) {
                    Toast.makeText(this.f385c, String.format(this.f385c.getString(C0062R.string.buddy_list_groupchat_toast_failed_exceed), 50), 0).show();
                    this.f395m.findViewById(C0062R.id.buddy_menu_invite).setEnabled(false);
                } else {
                    this.f395m.findViewById(C0062R.id.buddy_menu_invite).setEnabled(true);
                }
            } else if (this.f397o.getInt("chatType") == ChatONContract.InBoxTable.ChatType.BROADCAST.m2189a()) {
                if (length + hashSet.size() > 100) {
                    Toast.makeText(this.f385c, String.format(this.f385c.getString(C0062R.string.buddy_list_broadcast_toast_failed_exceed), 100), 0).show();
                    this.f395m.findViewById(C0062R.id.buddy_menu_invite).setEnabled(false);
                } else {
                    this.f395m.findViewById(C0062R.id.buddy_menu_invite).setEnabled(true);
                }
            }
        }
        this.f395m.findViewById(C0062R.id.buddy_menu_add_group).setEnabled(true);
        this.f395m.findViewById(C0062R.id.buddy_menu_blind_memo).setEnabled(true);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((ArrayList) this.f388f.get(i)).get(i2);
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
            View viewInflate = this.f384b.inflate(this.f389g, viewGroup, false);
            childViewHolder = new ChildViewHolder((RelativeLayout) viewInflate);
            view2 = viewInflate;
        } else {
            childViewHolder = (ChildViewHolder) view.getTag();
            view2 = view;
        }
        BuddyItem buddyItem = (BuddyItem) ((ArrayList) this.f388f.get(i)).get(i2);
        if (buddyItem.m697v()) {
            ProfileImageLoader.m3610a(this.f385c).m3622a(childViewHolder.f401b, ProfileImageLoader.ImageType.GROUP);
        } else {
            ProfileImageLoader.m3610a(this.f385c).m3624a(childViewHolder.f401b, buddyItem.m668a(), buddyItem.m693r());
        }
        buddyItem.m670a(childViewHolder.f401b);
        if (this.f392j == 1) {
            if (buddyItem.m697v()) {
                childViewHolder.f401b.setOnClickListener(new ViewOnClickListenerC0124q(this, buddyItem));
            } else {
                childViewHolder.f401b.setOnClickListener(new ViewOnClickListenerC0128u(this, i, i2));
            }
        } else if (this.f392j == 6) {
            childViewHolder.f401b.setOnClickListener(new ViewOnClickListenerC0127t(this, i, i2));
        } else {
            childViewHolder.f401b.setClickable(false);
        }
        if (buddyItem.m697v()) {
            childViewHolder.f402c.setText(buddyItem.m673b() + " (" + (buddyItem.m698w() != null ? buddyItem.m698w().size() : 0) + ")");
        } else {
            childViewHolder.f402c.setText(buddyItem.m673b());
        }
        String strM676c = buddyItem.m676c();
        if (buddyItem.m697v()) {
            if (buddyItem.m698w() != null) {
                Iterator it = buddyItem.m698w().keySet().iterator();
                StringBuffer stringBuffer = new StringBuffer();
                while (it.hasNext()) {
                    stringBuffer.append(((String) buddyItem.m698w().get(it.next())) + ", ");
                }
                ChatONLogWriter.m3512f(stringBuffer.toString(), "BuddyFragment");
                strM676c = stringBuffer.toString();
                if (strM676c.endsWith(", ")) {
                    strM676c = strM676c.substring(0, strM676c.length() - 2);
                }
            } else {
                strM676c = "";
            }
        } else if (strM676c == null || strM676c.trim().length() == 0) {
            strM676c = "";
        }
        childViewHolder.f403d.setText(strM676c);
        if (buddyItem.m695t()) {
            childViewHolder.f403d.setTextColor(Color.parseColor("#F6FF00"));
        } else {
            childViewHolder.f403d.setTextColor(Color.parseColor("#EFAD51"));
        }
        if (!this.f390h || buddyItem.m697v()) {
            childViewHolder.f400a.setVisibility(8);
        } else {
            childViewHolder.f400a.setVisibility(0);
            if (buddyItem.m692q()) {
                childViewHolder.f400a.setChecked(true);
            } else {
                childViewHolder.f400a.setChecked(false);
            }
        }
        if (buddyItem.m685j()) {
            childViewHolder.f404e.setBackgroundColor(Color.parseColor("#4C91BD"));
        } else {
            childViewHolder.f404e.setBackgroundResource(C0062R.drawable.buddy_item_xml);
        }
        view2.setTag(childViewHolder);
        return view2;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((ArrayList) this.f388f.get(i)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f386d.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f386d.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        GroupViewHolder groupViewHolder;
        View view2;
        if (view == null) {
            View viewInflate = this.f384b.inflate(this.f387e, viewGroup, false);
            GroupViewHolder groupViewHolder2 = new GroupViewHolder((LinearLayout) viewInflate);
            viewInflate.setTag(groupViewHolder2);
            view2 = viewInflate;
            groupViewHolder = groupViewHolder2;
        } else {
            groupViewHolder = (GroupViewHolder) view.getTag();
            view2 = view;
        }
        if (this.f391i == 21) {
            groupViewHolder.m445a(8);
            view2.setBackgroundResource(0);
            return view2;
        }
        groupViewHolder.m445a(0);
        view2.setBackgroundResource(C0062R.drawable.buddy_group_background);
        groupViewHolder.f405a.setText(((BuddyGroupItem) this.f386d.get(i)).m657b());
        groupViewHolder.f406b.setText("(" + ((BuddyGroupItem) this.f386d.get(i)).m658c() + ")");
        if (z) {
            groupViewHolder.f407c.setBackgroundResource(C0062R.drawable.messenger_subtitle_icon_up);
        } else {
            groupViewHolder.f407c.setBackgroundResource(C0062R.drawable.messenger_subtitle_icon_down);
        }
        view2.setTag(groupViewHolder);
        return view2;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        return ((Integer) this.f394l.get(this.f393k[i])).intValue();
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.f393k;
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
