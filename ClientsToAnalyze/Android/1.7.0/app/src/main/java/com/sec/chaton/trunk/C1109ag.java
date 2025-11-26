package com.sec.chaton.trunk;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.trunk.database.EnumC1177e;
import com.sec.chaton.trunk.p042b.AsyncTaskC1130a;
import com.sec.chaton.trunk.p042b.C1131b;
import com.sec.chaton.trunk.p043c.EnumC1152a;
import com.sec.chaton.trunk.p045d.C1165c;
import com.sec.chaton.trunk.p045d.C1169g;
import com.sec.chaton.trunk.p045d.EnumC1168f;
import com.sec.chaton.util.C1341p;
import com.sec.p007b.p008a.p011c.C0119d;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.ag */
/* loaded from: classes.dex */
public class C1109ag extends CursorAdapter {

    /* renamed from: h */
    private static C0630j f3907h;

    /* renamed from: b */
    private Context f3909b;

    /* renamed from: c */
    private EnumC1152a f3910c;

    /* renamed from: d */
    private String f3911d;

    /* renamed from: e */
    private Map f3912e;

    /* renamed from: f */
    private C0119d f3913f;

    /* renamed from: g */
    private Handler f3914g;

    /* renamed from: a */
    private static final String f3906a = C1109ag.class.getSimpleName();

    /* renamed from: i */
    private static InterfaceC0626f f3908i = new C1200z();

    /* renamed from: a */
    public static void m4145a(String str, String str2, String str3, boolean z) {
        f3907h = new C0630j(GlobalApplication.m3100a().getContentResolver(), f3908i);
        f3907h.startQuery(99, new String[]{str2, str3, String.valueOf(z)}, C0662o.f2289a, null, "message_inbox_no='" + str + "' AND (message_content_type='" + EnumC0651d.IMAGE.m2978a() + "' OR message_content_type='" + EnumC0651d.VIDEO.m2978a() + "') AND message_content is not null AND (message_type!=1 AND message_type!=4)", null, null);
    }

    public C1109ag(Context context, Cursor cursor, int i, EnumC1152a enumC1152a, String str, C0119d c0119d) {
        super(context, cursor, false);
        this.f3914g = new HandlerC1103aa(this);
        this.f3913f = c0119d;
        this.f3909b = context;
        this.f3910c = enumC1152a;
        this.f3911d = str;
        this.f3912e = new HashMap();
    }

    /* renamed from: a */
    public void m4152a(EnumC1152a enumC1152a) {
        this.f3910c = enumC1152a;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_item_trunk, viewGroup, false);
        C1199y c1199y = new C1199y(this);
        c1199y.f4071a = (ImageView) viewInflate.findViewById(R.id.thumbnail);
        c1199y.f4072b = (ProgressBar) viewInflate.findViewById(R.id.downloadProgressbar);
        c1199y.f4073c = (TextView) viewInflate.findViewById(R.id.totalCommentCountTextView);
        c1199y.f4074d = viewInflate.findViewById(R.id.unreadCommentBorder);
        viewInflate.setTag(c1199y);
        return viewInflate;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        String strM4150e;
        C1199y c1199y = (C1199y) view.getTag();
        ImageView imageView = c1199y.f4071a;
        ProgressBar progressBar = c1199y.f4072b;
        TextView textView = c1199y.f4073c;
        String string = cursor.getString(cursor.getColumnIndex("item_id"));
        EnumC1177e.m4253a(cursor.getInt(cursor.getColumnIndex("item_type")));
        imageView.setImageDrawable(null);
        progressBar.setVisibility(8);
        textView.setVisibility(0);
        int i = cursor.getInt(cursor.getColumnIndex("total_comment_count"));
        String string2 = cursor.getString(cursor.getColumnIndex("thumbnail"));
        int i2 = cursor.getInt(cursor.getColumnIndex("unread_comment_count"));
        EnumC1168f enumC1168fM4204a = C1165c.m4204a(cursor.getString(cursor.getColumnIndex("content_type")));
        String string3 = cursor.getString(cursor.getColumnIndex("down_url"));
        if (i2 > 0) {
            textView.setBackgroundResource(R.drawable.trunk_badge_select);
        } else {
            textView.setBackgroundResource(R.drawable.trunk_badge);
        }
        C1165c.m4205a(textView, i);
        if (i <= 0) {
            textView.setVisibility(8);
        }
        if (enumC1168fM4204a == EnumC1168f.VIDEO) {
            strM4150e = m4149d();
        } else {
            strM4150e = m4150e();
        }
        try {
            String strM4206b = C1165c.m4206b(string2);
            String str = strM4150e + File.separator + strM4206b;
            AsyncTaskC1130a asyncTaskC1130a = (AsyncTaskC1130a) this.f3912e.remove(imageView);
            if (asyncTaskC1130a != null) {
                asyncTaskC1130a.m4156a((Object) null);
                asyncTaskC1130a.cancel(true);
            }
            C1131b c1131bM4159a = C1131b.m4159a();
            Uri uriM4214a = C1169g.m4214a(str);
            if (uriM4214a == null) {
                this.f3913f.m602a(imageView);
                if (enumC1168fM4204a == EnumC1168f.IMAGE) {
                    C1341p.m4658b("Can't find cache data. Execting download.", f3906a);
                    C1196v c1196v = new C1196v(this, null);
                    c1196v.m4260a(enumC1168fM4204a);
                    c1196v.m4258a(imageView);
                    c1196v.m4259a(progressBar);
                    this.f3912e.put(imageView, c1131bM4159a.m4160a(this.f3914g, string2, strM4150e, strM4206b, c1196v));
                    progressBar.setVisibility(0);
                } else if (enumC1168fM4204a == EnumC1168f.VIDEO) {
                    C1341p.m4658b("Can't find cache data. Show default image for video.", f3906a);
                    m4143a(imageView, EnumC1168f.VIDEO);
                }
            } else {
                C1341p.m4658b("Found cached data.", f3906a);
                this.f3913f.m603a(imageView, new C1147bk(uriM4214a, enumC1168fM4204a, false));
            }
            c1199y.f4075e = string;
            c1199y.f4076f = EnumC1177e.Item;
            c1199y.f4077g = string3;
            c1199y.f4078h = enumC1168fM4204a;
        } catch (MalformedURLException e) {
            C1341p.m4651a("TrunkAdapter.ExtractFileNameFromUrl", f3906a);
            C1341p.m4653a(e, f3906a);
        }
    }

    /* renamed from: a */
    public void m4151a() {
        Iterator it = this.f3912e.keySet().iterator();
        while (it.hasNext()) {
            AsyncTaskC1130a asyncTaskC1130a = (AsyncTaskC1130a) this.f3912e.get((View) it.next());
            if (asyncTaskC1130a != null) {
                asyncTaskC1130a.m4156a((Object) null);
                asyncTaskC1130a.cancel(true);
            }
        }
        this.f3912e.clear();
    }

    /* renamed from: d */
    private String m4149d() {
        return C1169g.m4216a() + File.separator + this.f3911d;
    }

    /* renamed from: e */
    private String m4150e() {
        return C1169g.m4216a() + File.separator + this.f3911d + File.separator + "thumbnail";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m4143a(ImageView imageView, EnumC1168f enumC1168f) {
        if (enumC1168f == EnumC1168f.IMAGE) {
            imageView.setImageResource(R.drawable.trunk_image_default);
        }
        if (enumC1168f == EnumC1168f.VIDEO) {
            imageView.setImageResource(R.drawable.trunk_video_default);
        }
    }
}
