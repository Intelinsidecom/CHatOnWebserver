package com.sec.chaton.updates;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.sec.chaton.R;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.common.CommonApplication;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: UpdatesAdapter.java */
/* renamed from: com.sec.chaton.updates.a */
/* loaded from: classes.dex */
public class C4694a extends BaseAdapter {

    /* renamed from: a */
    private Context f17002a;

    /* renamed from: b */
    private LayoutInflater f17003b;

    /* renamed from: c */
    private int f17004c;

    /* renamed from: d */
    private ArrayList<C4709p> f17005d;

    /* renamed from: e */
    private InterfaceC4702i f17006e;

    /* renamed from: a */
    public void m17752a(InterfaceC4702i interfaceC4702i) {
        this.f17006e = interfaceC4702i;
    }

    public C4694a(Context context, ArrayList<C4709p> arrayList, int i) {
        this.f17002a = context;
        this.f17003b = (LayoutInflater) this.f17002a.getSystemService("layout_inflater");
        this.f17005d = arrayList;
        this.f17004c = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f17005d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f17005d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C4701h c4701h;
        if (view == null) {
            View viewInflate = this.f17003b.inflate(this.f17004c, viewGroup, false);
            view = viewInflate;
            c4701h = new C4701h((ViewGroup) viewInflate);
        } else {
            c4701h = (C4701h) view.getTag();
        }
        C2496n.m10765a(c4701h.f17041a, this.f17005d.get(i).m17763a(0), EnumC2498p.ROUND);
        c4701h.f17041a.setBackgroundResource(R.drawable.circle_background);
        c4701h.f17041a.setContentDescription(this.f17002a.getResources().getString(R.string.mypage_profile_image));
        c4701h.f17041a.setOnClickListener(new ViewOnClickListenerC4695b(this, i));
        c4701h.f17044d.setText(m17751a(this.f17005d.get(i)));
        if (this.f17005d.get(i).m17767d()) {
            c4701h.f17042b.setVisibility(0);
            if (this.f17005d.get(i).m17774k()) {
                c4701h.f17044d.setTextAppearance(this.f17002a, R.style.TextAppearance_List67);
            } else {
                c4701h.f17044d.setTextAppearance(this.f17002a, R.style.TextAppearance_List65);
            }
            String strM17768e = this.f17005d.get(i).m17768e();
            c4701h.f17045e.setVisibility(0);
            c4701h.f17045e.setText(strM17768e);
            if (this.f17005d.get(i).m17774k()) {
                c4701h.f17045e.setTextAppearance(this.f17002a, R.style.TextAppearance_List09);
            } else {
                c4701h.f17045e.setTextAppearance(this.f17002a, R.style.TextAppearance_List68);
            }
        } else {
            c4701h.f17042b.setVisibility(8);
            if (this.f17005d.get(i).m17774k()) {
                c4701h.f17044d.setTextAppearance(this.f17002a, R.style.TextAppearance_List66);
            } else {
                c4701h.f17044d.setTextAppearance(this.f17002a, R.style.TextAppearance_List65);
            }
        }
        switch (this.f17005d.get(i).m17770g()) {
            case IMAGE:
                c4701h.f17043c.setVisibility(0);
                c4701h.f17048h.setImageResource(R.drawable.update_ic_image_normal);
                c4701h.f17048h.setVisibility(0);
                break;
            case VIDEO:
                c4701h.f17043c.setVisibility(0);
                c4701h.f17048h.setImageResource(R.drawable.update_ic_video_normal);
                c4701h.f17048h.setVisibility(0);
                break;
            case LOCATION:
                c4701h.f17043c.setVisibility(0);
                c4701h.f17048h.setImageResource(R.drawable.update_ic_location_normal);
                c4701h.f17048h.setVisibility(0);
                break;
            case IMGLOC:
                c4701h.f17043c.setVisibility(0);
                c4701h.f17048h.setImageResource(R.drawable.update_ic_image_normal);
                c4701h.f17048h.setVisibility(0);
                c4701h.f17049i.setImageResource(R.drawable.update_ic_location_normal);
                c4701h.f17049i.setVisibility(0);
                break;
            case VDOLOC:
                c4701h.f17043c.setVisibility(0);
                c4701h.f17043c.setVisibility(0);
                c4701h.f17048h.setImageResource(R.drawable.update_ic_video_normal);
                c4701h.f17048h.setVisibility(0);
                c4701h.f17049i.setImageResource(R.drawable.update_ic_location_normal);
                c4701h.f17049i.setVisibility(0);
                break;
            default:
                c4701h.f17043c.setVisibility(8);
                break;
        }
        c4701h.f17046f.setText(m17750a(Long.parseLong(this.f17005d.get(i).m17766c())));
        c4701h.f17047g.setText(m17753b(Long.parseLong(this.f17005d.get(i).m17766c())));
        view.setTag(c4701h);
        return view;
    }

    /* renamed from: a */
    public String m17751a(C4709p c4709p) {
        switch (c4709p.m17773j()) {
            case POST:
                switch (c4709p.m17772i()) {
                    case POSTON:
                        return CommonApplication.m18732r().getString(R.string.update_notification_post, c4709p.m17765b(0));
                    default:
                        return null;
                }
            case REACTION:
                switch (c4709p.m17772i()) {
                    case POSTON:
                        return c4709p.m17771h() ? CommonApplication.m18732r().getString(R.string.update_notification_reaction_post_1_buddy, c4709p.m17765b(0)) : CommonApplication.m18732r().getString(R.string.update_notification_reaction_post_2_buddy, c4709p.m17765b(0), c4709p.m17765b(1));
                    case TRUNK:
                        return CommonApplication.m18732r().getString(R.string.update_notification_reaction_album, c4709p.m17765b(0));
                    default:
                        return null;
                }
            case RECOMMEND:
                switch (c4709p.m17772i()) {
                    case BUDDY:
                        return c4709p.m17769f() == 0 ? CommonApplication.m18732r().getString(R.string.update_notification_recommend_1_buddy, c4709p.m17765b(0)) : CommonApplication.m18732r().getString(R.string.update_notification_recommend_n_buddy, c4709p.m17765b(0), Integer.valueOf(c4709p.m17769f()));
                    default:
                        return null;
                }
            case UPDATE:
                switch (c4709p.m17772i()) {
                    case PROFILE:
                        return CommonApplication.m18732r().getString(R.string.update_notification_update_profile, c4709p.m17765b(0));
                    default:
                        return null;
                }
            case INVITE:
                switch (c4709p.m17772i()) {
                    case BUDDY:
                        return CommonApplication.m18732r().getString(R.string.update_notification_invite, c4709p.m17765b(0));
                    default:
                        return null;
                }
            case JOIN:
                switch (c4709p.m17772i()) {
                    case BUDDY:
                        return CommonApplication.m18732r().getString(R.string.update_notification_join, c4709p.m17765b(0));
                    default:
                        return null;
                }
            default:
                return null;
        }
    }

    /* renamed from: a */
    public String m17750a(long j) {
        return DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(j));
    }

    /* renamed from: b */
    public String m17753b(long j) {
        return DateFormat.getTimeFormat(CommonApplication.m18732r()).format(new Date(j));
    }
}
