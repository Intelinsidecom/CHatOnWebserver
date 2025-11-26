package com.sec.chaton.settings.downloads;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p025d.EnumC1327e;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.p027e.p028a.C1351a;
import com.sec.chaton.p035io.entry.inner.AmsItem;
import com.sec.chaton.settings.downloads.p056a.C2510a;
import com.sec.chaton.settings.downloads.p056a.C2525p;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3364o;
import java.text.DateFormat;
import java.util.Date;
import org.json.JSONException;

/* loaded from: classes.dex */
public class AmsItemBackgroundDetail extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, View.OnClickListener {

    /* renamed from: b */
    private static final String f9413b = AmsItemBackgroundDetail.class.getSimpleName();

    /* renamed from: a */
    DateFormat f9414a;

    /* renamed from: c */
    private Activity f9415c;

    /* renamed from: d */
    private ImageView f9416d;

    /* renamed from: e */
    private TextView f9417e;

    /* renamed from: f */
    private ImageView f9418f;

    /* renamed from: g */
    private ImageView f9419g;

    /* renamed from: h */
    private String f9420h;

    /* renamed from: i */
    private String f9421i;

    /* renamed from: j */
    private long f9422j;

    /* renamed from: k */
    private boolean f9423k;

    /* renamed from: l */
    private C2510a f9424l;

    /* renamed from: m */
    private Bitmap f9425m;

    /* renamed from: n */
    private Cursor f9426n;

    /* renamed from: o */
    private boolean f9427o;

    /* renamed from: p */
    private Handler f9428p = new HandlerC2630e(this);

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f9415c = activity;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        if (this.f9424l != null) {
            this.f9424l.m9451b(this.f9428p);
        }
        getLoaderManager().destroyLoader(0);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        getLoaderManager().getLoader(0).stopLoading();
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        getLoaderManager().getLoader(0).startLoading();
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f9415c = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9421i = getArguments().getString("filePath");
        this.f9420h = getArguments().getString("amsItemId");
        this.f9414a = android.text.format.DateFormat.getMediumDateFormat(CommonApplication.m11493l());
        this.f9427o = true;
        getLoaderManager().initLoader(0, null, this);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_ams_item_background_detail, viewGroup, false);
        this.f9417e = (TextView) viewInflate.findViewById(R.id.volume_text_view);
        this.f9417e.setSelected(true);
        this.f9417e.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        this.f9418f = (ImageView) viewInflate.findViewById(R.id.item_download_view);
        this.f9418f.setOnClickListener(this);
        this.f9416d = (ImageView) viewInflate.findViewById(R.id.ams_item_background_detail_image_view);
        this.f9425m = BitmapFactory.decodeFile(this.f9421i);
        this.f9416d.setImageBitmap(this.f9425m);
        this.f9419g = (ImageView) viewInflate.findViewById(R.id.anicon_background_item_thumbnail);
        this.f9419g.setImageBitmap(this.f9425m);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f9416d.setImageBitmap(null);
        if (this.f9425m != null) {
            this.f9425m.recycle();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item_download_view /* 2131165784 */:
                if (!TextUtils.isEmpty(this.f9420h)) {
                    if (this.f9423k) {
                        C2555av.m9492d(this.f9415c).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC2631f(this)).mo11512b();
                        break;
                    } else {
                        if (this.f9424l == null) {
                            this.f9424l = new C2510a(this.f9421i, EnumC1327e.Background, this.f9420h);
                            this.f9424l.m9446a(this.f9428p);
                            this.f9424l.m11745d(new Void[0]);
                        } else if (this.f9424l.m9455d() == 5) {
                            this.f9424l = new C2510a(this.f9421i, EnumC1327e.Background, this.f9420h);
                            this.f9424l.m9446a(this.f9428p);
                            this.f9424l.m11745d(new Void[0]);
                        } else {
                            switch (this.f9424l.m9455d()) {
                                case 0:
                                case 1:
                                case 2:
                                    this.f9424l.m11744a(true);
                                    break;
                            }
                        }
                        m9270a(this.f9426n);
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this.f9415c, C1398ap.m6249a(EnumC1399aq.AmsBackground), null, C3364o.m11849a("item_id", "=?"), new String[]{this.f9420h}, null);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.f9426n = cursor;
        if (this.f9427o) {
            this.f9427o = false;
            this.f9424l = (C2510a) C2525p.m9458a().m9459a(EnumC1399aq.AmsBackground, this.f9420h);
            if (this.f9424l != null) {
                this.f9424l.m9446a(this.f9428p);
            }
        }
        m9270a(cursor);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m9270a(Cursor cursor) {
        long j = 0;
        if (cursor != null && cursor.getCount() > 0) {
            cursor.moveToFirst();
            String string = cursor.getString(cursor.getColumnIndex("extras"));
            try {
                AmsItem amsItem = new AmsItem();
                C1351a.m5951a(amsItem, string);
                this.f9422j = amsItem.filesize.longValue();
            } catch (JSONException e) {
                if (C3250y.f11737e) {
                    C3250y.m11443a(e, f9413b);
                }
            }
            j = cursor.getLong(cursor.getColumnIndex("expiration_time"));
            this.f9423k = cursor.getInt(cursor.getColumnIndex("install")) != 0;
        }
        this.f9418f.setVisibility(0);
        if (this.f9423k) {
            this.f9418f.setImageResource(R.drawable.anicon_package_item_uninstall_event_xml);
            this.f9417e.setText(C3364o.m11849a(" (", Long.valueOf(this.f9422j / 1000), "KB) / ", getString(R.string.download_unlimited)));
            C2646u.m9657b(this.f9417e);
        }
        if (this.f9424l == null) {
            String str = this.f9414a.format((Date) new java.sql.Date(j));
            this.f9418f.setImageResource(R.drawable.anicon_package_item_download_event_xml);
            this.f9417e.setText(C3364o.m11849a(" (", Long.valueOf(this.f9422j / 1000), "KB)", " / ", "~", str));
            C2646u.m9649a(this.f9417e);
            return;
        }
        if (this.f9424l.m9455d() == 5) {
            String str2 = this.f9414a.format((Date) new java.sql.Date(j));
            this.f9418f.setImageResource(R.drawable.anicon_package_item_download_fail_event_xml);
            this.f9417e.setText(C3364o.m11849a(" (", Long.valueOf(this.f9422j / 1000), "KB)", " / ", "~", str2));
            C2646u.m9649a(this.f9417e);
            return;
        }
        switch (this.f9424l.m9455d()) {
            case 0:
                this.f9418f.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                this.f9417e.setText(C3364o.m11849a(" (", getString(R.string.download_progressing), ")"));
                C2646u.m9665c(this.f9417e);
                break;
            case 1:
                this.f9418f.setImageResource(R.drawable.anicon_package_item_downloading_event_xml);
                this.f9417e.setText(C3364o.m11849a(" (", Long.valueOf(this.f9422j / 1000), "KB)"));
                C2646u.m9665c(this.f9417e);
                break;
            case 2:
                this.f9418f.setVisibility(4);
                this.f9417e.setText(getString(R.string.download_installing));
                C2646u.m9668d(this.f9417e);
                break;
        }
    }
}
