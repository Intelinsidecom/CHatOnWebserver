package com.sec.chaton.userprofile;

import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0703r;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.RoundedImageView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MyPageInteraction extends Fragment {

    /* renamed from: s */
    private static int f5904s;

    /* renamed from: b */
    private C0666j f5906b;

    /* renamed from: c */
    private ArrayList f5907c;

    /* renamed from: d */
    private LinearLayout f5908d;

    /* renamed from: e */
    private LinearLayout f5909e;

    /* renamed from: f */
    private RelativeLayout f5910f;

    /* renamed from: g */
    private RelativeLayout f5911g;

    /* renamed from: h */
    private RelativeLayout f5912h;

    /* renamed from: i */
    private ImageView f5913i;

    /* renamed from: j */
    private View f5914j;

    /* renamed from: k */
    private RelativeLayout f5915k;

    /* renamed from: l */
    private View.OnClickListener f5916l;

    /* renamed from: m */
    private String f5917m;

    /* renamed from: n */
    private String f5918n;

    /* renamed from: o */
    private String f5919o;

    /* renamed from: p */
    private String f5920p;

    /* renamed from: q */
    private String f5921q;

    /* renamed from: r */
    private String f5922r;

    /* renamed from: t */
    private InterfaceC0667k f5923t = new C1630ag(this);

    /* renamed from: a */
    AdapterView.OnItemClickListener f5905a = new C1634ak(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6061b("onCreate...", getClass().getSimpleName());
        this.f5906b = new C0666j(getActivity().getContentResolver(), this.f5923t);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1786r.m6061b("onCreateView...", getClass().getSimpleName());
        this.f5914j = layoutInflater.inflate(R.layout.mypage_fragment_container, viewGroup, false);
        this.f5908d = (LinearLayout) this.f5914j.findViewById(R.id.interaction_container);
        this.f5909e = (LinearLayout) this.f5914j.findViewById(R.id.flayout_relationship);
        this.f5910f = (RelativeLayout) this.f5914j.findViewById(R.id.interaction_rank1);
        this.f5911g = (RelativeLayout) this.f5914j.findViewById(R.id.interaction_rank2);
        this.f5912h = (RelativeLayout) this.f5914j.findViewById(R.id.interaction_rank3);
        this.f5907c = new ArrayList();
        this.f5916l = new ViewOnClickListenerC1629af(this);
        this.f5915k = (RelativeLayout) this.f5914j.findViewById(R.id.rlay_details);
        this.f5913i = (ImageView) this.f5914j.findViewById(R.id.title_interaction_rank);
        this.f5915k.setOnClickListener(this.f5916l);
        return this.f5914j;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1786r.m6061b("onResume", getClass().getSimpleName());
        m5656a();
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        C1786r.m6061b("onActivityCreated...", getClass().getSimpleName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003c A[Catch: all -> 0x0085, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0085, blocks: (B:3:0x0002, B:5:0x0008, B:9:0x003c), top: B:15:0x0002 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m5644a(android.database.Cursor r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L3c
            int r0 = r5.getCount()     // Catch: java.lang.Throwable -> L85
            if (r0 <= 0) goto L3c
            android.widget.LinearLayout r0 = r4.f5908d     // Catch: java.lang.Throwable -> L85
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L85
            android.widget.RelativeLayout r0 = r4.f5910f     // Catch: java.lang.Throwable -> L85
            r1 = 4
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L85
            android.widget.RelativeLayout r0 = r4.f5911g     // Catch: java.lang.Throwable -> L85
            r1 = 4
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L85
            android.widget.RelativeLayout r0 = r4.f5912h     // Catch: java.lang.Throwable -> L85
            r1 = 4
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L85
            android.widget.LinearLayout r0 = r4.f5909e     // Catch: java.lang.Throwable -> L85
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L85
            android.widget.RelativeLayout r0 = r4.f5915k     // Catch: java.lang.Throwable -> L85
            r1 = 1
            r0.setEnabled(r1)     // Catch: java.lang.Throwable -> L85
            android.widget.ImageView r0 = r4.f5913i     // Catch: java.lang.Throwable -> L85
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L85
            r4.m5647b(r5)     // Catch: java.lang.Throwable -> L85
        L36:
            if (r5 == 0) goto L3b
            r5.close()
        L3b:
            return
        L3c:
            android.widget.LinearLayout r0 = r4.f5908d     // Catch: java.lang.Throwable -> L85
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L85
            android.widget.LinearLayout r0 = r4.f5909e     // Catch: java.lang.Throwable -> L85
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L85
            android.content.SharedPreferences r0 = com.sec.chaton.util.C1789u.m6075a()     // Catch: java.lang.Throwable -> L85
            java.lang.String r1 = "Push Name"
            java.lang.String r2 = ""
            java.lang.String r0 = r0.getString(r1, r2)     // Catch: java.lang.Throwable -> L85
            android.content.Context r1 = com.sec.chaton.global.GlobalApplication.m3260b()     // Catch: java.lang.Throwable -> L85
            r2 = 2131428041(0x7f0b02c9, float:1.8477715E38)
            java.lang.String r1 = r1.getString(r2)     // Catch: java.lang.Throwable -> L85
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L85
            r3 = 0
            r2[r3] = r0     // Catch: java.lang.Throwable -> L85
            java.lang.String r1 = java.lang.String.format(r1, r2)     // Catch: java.lang.Throwable -> L85
            android.widget.LinearLayout r0 = r4.f5909e     // Catch: java.lang.Throwable -> L85
            r2 = 2131494011(0x7f0c047b, float:1.8611518E38)
            android.view.View r0 = r0.findViewById(r2)     // Catch: java.lang.Throwable -> L85
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch: java.lang.Throwable -> L85
            r0.setText(r1)     // Catch: java.lang.Throwable -> L85
            android.widget.RelativeLayout r0 = r4.f5915k     // Catch: java.lang.Throwable -> L85
            r1 = 1
            r0.setEnabled(r1)     // Catch: java.lang.Throwable -> L85
            android.widget.ImageView r0 = r4.f5913i     // Catch: java.lang.Throwable -> L85
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Throwable -> L85
            goto L36
        L85:
            r0 = move-exception
            if (r5 == 0) goto L8b
            r5.close()
        L8b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.userprofile.MyPageInteraction.m5644a(android.database.Cursor):void");
    }

    /* renamed from: b */
    private void m5647b(Cursor cursor) {
        if (cursor != null) {
            while (cursor.moveToNext()) {
                if (cursor.getPosition() == 0) {
                    this.f5910f.setVisibility(0);
                    m5649c(cursor);
                } else if (cursor.getPosition() == 1) {
                    this.f5911g.setVisibility(0);
                    m5651d(cursor);
                } else if (cursor.getPosition() == 2) {
                    this.f5912h.setVisibility(0);
                    m5653e(cursor);
                }
            }
        }
    }

    /* renamed from: c */
    private void m5649c(Cursor cursor) {
        RoundedImageView roundedImageView = (RoundedImageView) this.f5914j.findViewById(R.id.relation_img1);
        TextView textView = (TextView) this.f5914j.findViewById(R.id.relation_point1);
        TextView textView2 = (TextView) this.f5914j.findViewById(R.id.relation_rank_text1);
        TextView textView3 = (TextView) this.f5914j.findViewById(R.id.relation_rank_text_name1);
        TextView textView4 = (TextView) this.f5914j.findViewById(R.id.relation_send1);
        TextView textView5 = (TextView) this.f5914j.findViewById(R.id.relation_sent_count1);
        TextView textView6 = (TextView) this.f5914j.findViewById(R.id.relation_received1);
        TextView textView7 = (TextView) this.f5914j.findViewById(R.id.relation_received_count1);
        RelativeLayout relativeLayout = (RelativeLayout) this.f5914j.findViewById(R.id.rbar1);
        C1746bb.m5945a(GlobalApplication.m3260b()).m5959a(roundedImageView, cursor.getString(cursor.getColumnIndex("buddy_no")));
        textView3.setText(cursor.getString(cursor.getColumnIndex("buddy_name")));
        textView.setText(cursor.getString(cursor.getColumnIndex("relation_point")));
        textView2.setText(cursor.getString(cursor.getColumnIndex("relation_rank")));
        textView5.setText(cursor.getString(cursor.getColumnIndex("relation_send")));
        textView7.setText(cursor.getString(cursor.getColumnIndex("relation_received")));
        f5904s = Integer.parseInt(cursor.getString(cursor.getColumnIndex("relation_point")));
        int i = f5904s - (Integer.parseInt(cursor.getString(cursor.getColumnIndex("relation_send"))) + Integer.parseInt(cursor.getString(cursor.getColumnIndex("relation_received"))));
        relativeLayout.setEnabled(true);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.weight = i;
        relativeLayout.setLayoutParams(layoutParams);
        textView4.setEnabled(true);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView4.getLayoutParams();
        layoutParams2.weight = cursor.getInt(cursor.getColumnIndex("relation_send"));
        textView4.setLayoutParams(layoutParams2);
        textView6.setEnabled(true);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) textView6.getLayoutParams();
        layoutParams3.weight = cursor.getInt(cursor.getColumnIndex("relation_received"));
        textView6.setLayoutParams(layoutParams3);
        this.f5917m = cursor.getString(cursor.getColumnIndex("buddy_no"));
        this.f5918n = cursor.getString(cursor.getColumnIndex("buddy_name"));
        roundedImageView.setClickable(true);
        roundedImageView.setOnClickListener(new ViewOnClickListenerC1631ah(this));
    }

    /* renamed from: d */
    private void m5651d(Cursor cursor) {
        RoundedImageView roundedImageView = (RoundedImageView) this.f5914j.findViewById(R.id.relation_img2);
        TextView textView = (TextView) this.f5914j.findViewById(R.id.relation_point2);
        TextView textView2 = (TextView) this.f5914j.findViewById(R.id.relation_rank_text2);
        TextView textView3 = (TextView) this.f5914j.findViewById(R.id.relation_rank_text_name2);
        TextView textView4 = (TextView) this.f5914j.findViewById(R.id.relation_send2);
        TextView textView5 = (TextView) this.f5914j.findViewById(R.id.relation_sent_count2);
        TextView textView6 = (TextView) this.f5914j.findViewById(R.id.relation_received2);
        TextView textView7 = (TextView) this.f5914j.findViewById(R.id.relation_received_count2);
        RelativeLayout relativeLayout = (RelativeLayout) this.f5914j.findViewById(R.id.rbar2);
        C1746bb.m5945a(GlobalApplication.m3260b()).m5959a(roundedImageView, cursor.getString(cursor.getColumnIndex("buddy_no")));
        textView3.setText(cursor.getString(cursor.getColumnIndex("buddy_name")));
        textView.setText(cursor.getString(cursor.getColumnIndex("relation_point")));
        textView2.setText(cursor.getString(cursor.getColumnIndex("relation_rank")));
        textView5.setText(cursor.getString(cursor.getColumnIndex("relation_send")));
        textView7.setText(cursor.getString(cursor.getColumnIndex("relation_received")));
        int i = f5904s - (Integer.parseInt(cursor.getString(cursor.getColumnIndex("relation_send"))) + Integer.parseInt(cursor.getString(cursor.getColumnIndex("relation_received"))));
        relativeLayout.setEnabled(true);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.weight = i;
        relativeLayout.setLayoutParams(layoutParams);
        textView4.setEnabled(true);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView4.getLayoutParams();
        layoutParams2.weight = cursor.getInt(cursor.getColumnIndex("relation_send"));
        textView4.setLayoutParams(layoutParams2);
        textView6.setEnabled(true);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) textView6.getLayoutParams();
        layoutParams3.weight = cursor.getInt(cursor.getColumnIndex("relation_received"));
        textView6.setLayoutParams(layoutParams3);
        this.f5919o = cursor.getString(cursor.getColumnIndex("buddy_no"));
        this.f5920p = cursor.getString(cursor.getColumnIndex("buddy_name"));
        roundedImageView.setClickable(true);
        roundedImageView.setOnClickListener(new ViewOnClickListenerC1632ai(this));
    }

    /* renamed from: e */
    private void m5653e(Cursor cursor) {
        RoundedImageView roundedImageView = (RoundedImageView) this.f5914j.findViewById(R.id.relation_img3);
        TextView textView = (TextView) this.f5914j.findViewById(R.id.relation_point3);
        TextView textView2 = (TextView) this.f5914j.findViewById(R.id.relation_rank_text3);
        TextView textView3 = (TextView) this.f5914j.findViewById(R.id.relation_rank_text_name3);
        TextView textView4 = (TextView) this.f5914j.findViewById(R.id.relation_send3);
        TextView textView5 = (TextView) this.f5914j.findViewById(R.id.relation_sent_count3);
        TextView textView6 = (TextView) this.f5914j.findViewById(R.id.relation_received3);
        TextView textView7 = (TextView) this.f5914j.findViewById(R.id.relation_received_count3);
        RelativeLayout relativeLayout = (RelativeLayout) this.f5914j.findViewById(R.id.rbar3);
        C1746bb.m5945a(GlobalApplication.m3260b()).m5959a(roundedImageView, cursor.getString(cursor.getColumnIndex("buddy_no")));
        textView3.setText(cursor.getString(cursor.getColumnIndex("buddy_name")));
        textView.setText(cursor.getString(cursor.getColumnIndex("relation_point")));
        textView2.setText(cursor.getString(cursor.getColumnIndex("relation_rank")));
        textView5.setText(cursor.getString(cursor.getColumnIndex("relation_send")));
        textView7.setText(cursor.getString(cursor.getColumnIndex("relation_received")));
        int i = f5904s - (Integer.parseInt(cursor.getString(cursor.getColumnIndex("relation_send"))) + Integer.parseInt(cursor.getString(cursor.getColumnIndex("relation_received"))));
        relativeLayout.setEnabled(true);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.weight = i;
        relativeLayout.setLayoutParams(layoutParams);
        textView4.setEnabled(true);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) textView4.getLayoutParams();
        layoutParams2.weight = cursor.getInt(cursor.getColumnIndex("relation_send"));
        textView4.setLayoutParams(layoutParams2);
        textView6.setEnabled(true);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) textView6.getLayoutParams();
        layoutParams3.weight = cursor.getInt(cursor.getColumnIndex("relation_received"));
        textView6.setLayoutParams(layoutParams3);
        this.f5921q = cursor.getString(cursor.getColumnIndex("buddy_no"));
        this.f5922r = cursor.getString(cursor.getColumnIndex("buddy_name"));
        roundedImageView.setClickable(true);
        roundedImageView.setOnClickListener(new ViewOnClickListenerC1633aj(this));
    }

    /* renamed from: a */
    public void m5656a() {
        this.f5906b.startQuery(-1, null, C0703r.m3166a(), null, "relation_date = ?  AND buddy_relation_hide = 'N'  AND relation_rank != 0 ", new String[]{Integer.toString(1)}, "relation_rank ASC LIMIT 30");
    }
}
