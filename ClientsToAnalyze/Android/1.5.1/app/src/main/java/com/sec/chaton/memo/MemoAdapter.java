package com.sec.chaton.memo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.ProfileImageLoader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class MemoAdapter extends BaseAdapter {

    /* renamed from: e */
    private static String f1922e = "";

    /* renamed from: a */
    private Context f1923a;

    /* renamed from: b */
    private ArrayList f1924b;

    /* renamed from: c */
    private LayoutInflater f1925c;

    /* renamed from: d */
    private int f1926d;

    public class MemoItem {

        /* renamed from: a */
        private String f1927a;

        /* renamed from: b */
        private String f1928b;

        /* renamed from: c */
        private String f1929c;

        /* renamed from: d */
        private String f1930d;

        public MemoItem(String str, String str2, String str3, String str4) {
            this.f1927a = str;
            this.f1928b = str2;
            this.f1929c = str3;
            this.f1930d = str4;
        }

        /* renamed from: a */
        public String m2399a() {
            return this.f1927a;
        }

        /* renamed from: b */
        public String m2400b() {
            return this.f1928b;
        }

        /* renamed from: c */
        public String m2401c() {
            return this.f1929c;
        }

        /* renamed from: d */
        public String m2402d() {
            return this.f1930d;
        }
    }

    public class MemoViewHolder {

        /* renamed from: a */
        public ImageView f1931a;

        /* renamed from: b */
        public TextView f1932b;

        /* renamed from: c */
        public TextView f1933c;

        /* renamed from: d */
        public TextView f1934d;

        /* renamed from: e */
        public RelativeLayout f1935e;

        public MemoViewHolder(RelativeLayout relativeLayout) {
            this.f1935e = relativeLayout;
            this.f1931a = (ImageView) this.f1935e.findViewById(C0062R.id.memo_profile_image);
            this.f1932b = (TextView) this.f1935e.findViewById(C0062R.id.memo_profile_name);
            this.f1933c = (TextView) this.f1935e.findViewById(C0062R.id.memo_content);
            this.f1934d = (TextView) this.f1935e.findViewById(C0062R.id.memo_time);
        }
    }

    public MemoAdapter(ListView listView, Context context, ArrayList arrayList, int i) {
        this.f1923a = context;
        this.f1924b = arrayList;
        this.f1926d = i;
        this.f1925c = (LayoutInflater) this.f1923a.getSystemService("layout_inflater");
        f1922e = ChatONPref.m3519a().getString("msisdn", "");
    }

    /* renamed from: a */
    public String m2398a(long j) {
        String[] strArrSplit = new SimpleDateFormat("dd MMM/hh:mmaa", Locale.ENGLISH).format(Long.valueOf(j)).split("/");
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis)).equals(str) ? strArrSplit[1].toLowerCase() : str2.equals(new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis))) ? strArrSplit[0] : new SimpleDateFormat("d MMM,yyyy", Locale.ENGLISH).format(Long.valueOf(j));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1924b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f1924b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        MemoViewHolder memoViewHolder;
        View view2;
        if (view == null) {
            View viewInflate = this.f1925c.inflate(this.f1926d, viewGroup, false);
            view2 = viewInflate;
            memoViewHolder = new MemoViewHolder((RelativeLayout) viewInflate);
        } else {
            memoViewHolder = (MemoViewHolder) view.getTag();
            view2 = view;
        }
        memoViewHolder.f1933c.setText(((MemoItem) this.f1924b.get(i)).m2401c());
        memoViewHolder.f1934d.setText(m2398a(Long.parseLong(((MemoItem) this.f1924b.get(i)).m2402d())));
        ProfileImageLoader.m3610a(this.f1923a).m3623a(memoViewHolder.f1931a, ((MemoItem) this.f1924b.get(i)).m2399a());
        memoViewHolder.f1931a.setOnClickListener(new ViewOnClickListenerC0247b(this, i));
        if (((MemoItem) this.f1924b.get(i)).m2399a().equals(f1922e)) {
            memoViewHolder.f1932b.setText(GlobalApplication.m2388f().getString(C0062R.string.setting_interaction_me));
            memoViewHolder.f1935e.setBackgroundResource(C0062R.drawable.memo_item_xml);
        } else {
            memoViewHolder.f1932b.setText(((MemoItem) this.f1924b.get(i)).m2400b());
            if (this.f1923a instanceof Activity) {
                memoViewHolder.f1935e.setBackgroundColor(-16777216);
                memoViewHolder.f1933c.setTextColor(Color.parseColor("#FFFFA800"));
            } else {
                memoViewHolder.f1935e.setBackgroundResource(C0062R.drawable.buddy_item_xml);
            }
        }
        view2.setTag(memoViewHolder);
        return view2;
    }
}
