package com.sec.chaton.trunk;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
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
import com.sec.chaton.trunk.database.EnumC1588d;
import com.sec.chaton.trunk.p047a.C1514b;
import com.sec.chaton.trunk.p048b.EnumC1551b;
import com.sec.chaton.trunk.p050c.AsyncTaskC1570b;
import com.sec.chaton.trunk.p050c.C1569a;
import com.sec.chaton.trunk.p053e.C1592a;
import com.sec.chaton.trunk.p053e.C1598g;
import com.sec.chaton.trunk.p053e.EnumC1599h;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.util.C1791w;
import java.io.File;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

/* compiled from: TrunkAdapter.java */
/* renamed from: com.sec.chaton.trunk.o */
/* loaded from: classes.dex */
public class C1609o extends CursorAdapter {

    /* renamed from: a */
    private static final String f5718a = C1609o.class.getSimpleName();

    /* renamed from: b */
    private Context f5719b;

    /* renamed from: c */
    private EnumC1551b f5720c;

    /* renamed from: d */
    private String f5721d;

    /* renamed from: e */
    private Map f5722e;

    /* renamed from: f */
    private InterfaceC1607m f5723f;

    /* renamed from: g */
    private InterfaceC1608n f5724g;

    /* renamed from: h */
    private C1514b f5725h;

    /* renamed from: i */
    private Handler f5726i;

    public C1609o(Context context, Cursor cursor, int i, EnumC1551b enumC1551b, String str, C1514b c1514b) {
        super(context, cursor, false);
        this.f5726i = new HandlerC1610p(this);
        this.f5719b = context;
        this.f5720c = enumC1551b;
        this.f5721d = str;
        this.f5722e = new HashMap();
        this.f5723f = null;
        this.f5724g = null;
        this.f5725h = c1514b;
    }

    /* renamed from: a */
    public void m5520a(EnumC1551b enumC1551b) {
        this.f5720c = enumC1551b;
    }

    /* renamed from: a */
    public void m5521a(InterfaceC1607m interfaceC1607m) {
        this.f5723f = interfaceC1607m;
    }

    /* renamed from: a */
    public void m5522a(InterfaceC1608n interfaceC1608n) {
        this.f5724g = interfaceC1608n;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.item_trunk, viewGroup, false);
        C1614t c1614t = new C1614t(this, null);
        c1614t.f5744a = (ImageView) viewInflate.findViewById(R.id.thumbnail);
        c1614t.f5745b = (ProgressBar) viewInflate.findViewById(R.id.downloadProgressbar);
        c1614t.f5746c = (ImageView) viewInflate.findViewById(R.id.playButton);
        c1614t.f5747d = (TextView) viewInflate.findViewById(R.id.totalCommentCountTextView);
        c1614t.f5748e = viewInflate.findViewById(R.id.unreadCommentBorder);
        viewInflate.setTag(c1614t);
        return viewInflate;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        String strM5519c;
        C1614t c1614t = (C1614t) view.getTag();
        ImageView imageView = c1614t.f5744a;
        ProgressBar progressBar = c1614t.f5745b;
        ImageView imageView2 = c1614t.f5746c;
        TextView textView = c1614t.f5747d;
        View view2 = c1614t.f5748e;
        String string = cursor.getString(cursor.getColumnIndex("item_id"));
        EnumC1588d enumC1588dM5480a = EnumC1588d.m5480a(cursor.getInt(cursor.getColumnIndex("item_type")));
        if (enumC1588dM5480a == EnumC1588d.Item) {
            imageView.setImageDrawable(null);
            progressBar.setVisibility(8);
            imageView2.setVisibility(8);
            textView.setVisibility(0);
            int i = cursor.getInt(cursor.getColumnIndex("total_comment_count"));
            String string2 = cursor.getString(cursor.getColumnIndex("thumbnail"));
            int i2 = cursor.getInt(cursor.getColumnIndex("unread_comment_count"));
            EnumC1599h enumC1599hM5506a = C1598g.m5506a(cursor.getString(cursor.getColumnIndex("content_type")));
            String string3 = cursor.getString(cursor.getColumnIndex("down_url"));
            if (i2 > 0) {
                view2.setVisibility(0);
            } else {
                view2.setVisibility(8);
            }
            C1598g.m5507a(textView, i);
            if (i <= 0) {
                textView.setVisibility(8);
            }
            String str = "";
            String str2 = "";
            if (enumC1599hM5506a == EnumC1599h.VIDEO) {
                strM5519c = m5517b();
            } else {
                strM5519c = m5519c();
            }
            try {
                String strM5508b = C1598g.m5508b(string2);
                if (enumC1599hM5506a == EnumC1599h.IMAGE) {
                    str = m5517b() + File.separator + strM5508b;
                    str2 = C1592a.m5494a() + File.separator + strM5508b;
                }
                String str3 = strM5519c + File.separator + strM5508b;
                if (enumC1599hM5506a == EnumC1599h.VIDEO || C1598g.m5509c(str) || C1598g.m5509c(str2)) {
                    imageView2.setVisibility(0);
                } else {
                    imageView2.setVisibility(8);
                }
                AsyncTaskC1570b asyncTaskC1570b = (AsyncTaskC1570b) this.f5722e.remove(imageView);
                if (asyncTaskC1570b != null) {
                    asyncTaskC1570b.m5436a((Object) null);
                    asyncTaskC1570b.cancel(true);
                }
                C1569a c1569aM5430a = C1569a.m5430a();
                Bitmap bitmap = (Bitmap) this.f5725h.m5363a(str3);
                if (bitmap != null) {
                    imageView.setImageBitmap(bitmap);
                } else {
                    Uri uriM5492a = C1592a.m5492a(str3);
                    if (uriM5492a == null) {
                        if (enumC1599hM5506a == EnumC1599h.IMAGE) {
                            C1786r.m6061b("Can't find cache data. Execting download.", f5718a);
                            C1615u c1615u = new C1615u(this, null);
                            c1615u.m5526a(enumC1599hM5506a);
                            c1615u.m5524a(imageView);
                            c1615u.m5525a(progressBar);
                            this.f5722e.put(imageView, c1569aM5430a.m5431a(this.f5726i, string2, strM5519c, strM5508b, c1615u));
                            progressBar.setVisibility(0);
                        } else if (enumC1599hM5506a == EnumC1599h.VIDEO) {
                            C1786r.m6061b("Can't find cache data. Show default image for video.", f5718a);
                            imageView.setImageResource(R.drawable.trunk_video_default);
                        }
                    } else {
                        C1786r.m6061b("Found cached data.", f5718a);
                        m5513a(imageView, enumC1599hM5506a, uriM5492a);
                    }
                }
                imageView.setOnClickListener(new ViewOnClickListenerC1611q(this, view, string, EnumC1588d.Item, string3, enumC1599hM5506a));
                view.findViewById(R.id.item_layout).setOnKeyListener(new ViewOnKeyListenerC1613s(this, view, string, EnumC1588d.Item, string3, enumC1599hM5506a));
                return;
            } catch (MalformedURLException e) {
                C1786r.m6054a("TrunkAdapter.ExtractFileNameFromUrl", f5718a);
                C1786r.m6056a(e, f5718a);
                return;
            }
        }
        if (enumC1588dM5480a == EnumC1588d.LoadMore) {
            C1786r.m6061b("OrderingType: " + this.f5720c, f5718a);
            AsyncTaskC1570b asyncTaskC1570b2 = (AsyncTaskC1570b) this.f5722e.remove(imageView);
            if (asyncTaskC1570b2 != null) {
                asyncTaskC1570b2.m5436a((Object) null);
                asyncTaskC1570b2.cancel(true);
            }
            if (this.f5720c == EnumC1551b.Recent) {
                view2.setVisibility(8);
                imageView.setImageResource(R.drawable.loadmore_selector);
                progressBar.setVisibility(8);
                imageView2.setVisibility(8);
                view2.setVisibility(8);
                textView.setVisibility(8);
                imageView.setOnClickListener(new ViewOnClickListenerC1612r(this, view, string, EnumC1588d.LoadMore));
            }
        }
    }

    /* renamed from: b */
    private String m5517b() {
        return C1592a.m5494a() + File.separator + this.f5721d;
    }

    /* renamed from: c */
    private String m5519c() {
        return C1592a.m5494a() + File.separator + this.f5721d + File.separator + "thumbnail";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5513a(ImageView imageView, EnumC1599h enumC1599h, Uri uri) {
        Bitmap bitmapCreateVideoThumbnail = null;
        if (enumC1599h == EnumC1599h.IMAGE) {
            bitmapCreateVideoThumbnail = C1791w.m6086a(this.f5719b, uri);
        } else if (enumC1599h == EnumC1599h.VIDEO) {
            bitmapCreateVideoThumbnail = ThumbnailUtils.createVideoThumbnail(uri.toString(), 3);
        }
        this.f5725h.m5365a(uri.toString(), bitmapCreateVideoThumbnail);
        imageView.setImageBitmap(bitmapCreateVideoThumbnail);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5512a(ImageView imageView, EnumC1599h enumC1599h) {
        if (enumC1599h == EnumC1599h.IMAGE) {
            imageView.setImageResource(R.drawable.trunk_image_default);
        }
        if (enumC1599h == EnumC1599h.VIDEO) {
            imageView.setImageResource(R.drawable.trunk_video_default);
        }
    }
}
