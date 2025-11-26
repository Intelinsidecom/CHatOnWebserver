package com.sec.chaton.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.Preference;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.audio.C1769a;
import com.sec.chaton.p027e.C1398ap;
import com.sec.chaton.p027e.EnumC1399aq;
import com.sec.chaton.settings.downloads.C2620df;
import com.sec.chaton.util.C3159aa;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.common.util.C3364o;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class RingtonePreference2 extends Preference {

    /* renamed from: a */
    DialogInterface.OnClickListener f9242a;

    /* renamed from: b */
    private RingtoneManager f9243b;

    /* renamed from: c */
    private InterfaceC3274d f9244c;

    /* renamed from: d */
    private ArrayList<C2680eq> f9245d;

    /* renamed from: e */
    private C1769a f9246e;

    /* renamed from: f */
    private HashMap<Uri, C2680eq> f9247f;

    /* renamed from: g */
    private int f9248g;

    /* renamed from: h */
    private C2680eq f9249h;

    public RingtonePreference2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9242a = new DialogInterfaceOnClickListenerC2685ev(this);
    }

    public RingtonePreference2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9242a = new DialogInterfaceOnClickListenerC2685ev(this);
        m9178d();
    }

    public RingtonePreference2(Context context) {
        super(context);
        this.f9242a = new DialogInterfaceOnClickListenerC2685ev(this);
    }

    @Override // android.preference.Preference
    protected void onClick() {
        this.f9249h = null;
        m9178d();
        this.f9244c.mo11519b().setItemChecked(m9175c(), true);
        this.f9244c.show();
    }

    /* renamed from: c */
    private int m9175c() {
        C2680eq c2680eq;
        Uri uriM9181f = m9181f();
        if (uriM9181f != null && (c2680eq = this.f9247f.get(uriM9181f)) != null) {
            return c2680eq.m9689e();
        }
        return 0;
    }

    /* renamed from: d */
    private void m9178d() {
        if (this.f9243b == null) {
            this.f9243b = new RingtoneManager(getContext());
            this.f9243b.setType(2);
            this.f9243b.setIncludeDrm(true);
            this.f9243b.setStopPreviousRingtone(false);
        }
        if (this.f9245d != null) {
            this.f9245d.clear();
        } else {
            this.f9245d = new ArrayList<>();
        }
        if (this.f9247f != null) {
            this.f9247f.clear();
        } else {
            this.f9247f = new HashMap<>();
        }
        this.f9248g = 0;
        ArrayList<C2680eq> arrayList = this.f9245d;
        int i = this.f9248g;
        this.f9248g = i + 1;
        arrayList.add(new C2680eq(i, EnumC2681er.SYSTEM, getContext().getString(R.string.ringtone_silent), null));
        Cursor cursor = this.f9243b.getCursor();
        if (cursor != null) {
            int i2 = 0;
            while (cursor.moveToNext()) {
                String string = cursor.getString(1);
                Uri ringtoneUri = this.f9243b.getRingtoneUri(i2);
                int i3 = this.f9248g;
                this.f9248g = i3 + 1;
                C2680eq c2680eq = new C2680eq(i3, EnumC2681er.SYSTEM, string, ringtoneUri, i2);
                this.f9247f.put(ringtoneUri, c2680eq);
                this.f9245d.add(c2680eq);
                i2++;
            }
        }
        Cursor cursorQuery = getContext().getContentResolver().query(C1398ap.m6249a(EnumC1399aq.Sound), null, C3364o.m11849a("item_id", "< '0'"), null, "name");
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("item_id"));
                    int iM9610e = C2620df.m9610e(getContext(), string3);
                    Uri uriM9606c = C2620df.m9606c(getContext(), string3);
                    int i4 = this.f9248g;
                    this.f9248g = i4 + 1;
                    C2680eq c2680eq2 = new C2680eq(i4, EnumC2681er.EMBED, string2, uriM9606c, iM9610e);
                    this.f9247f.put(uriM9606c, c2680eq2);
                    this.f9245d.add(c2680eq2);
                } finally {
                }
            }
            cursorQuery.close();
        }
        cursorQuery = getContext().getContentResolver().query(C1398ap.m6249a(EnumC1399aq.Sound), null, C3364o.m11849a("item_id", "> '0' AND ", "install", "!= '0'"), null, "name");
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
                    Uri uriM9606c2 = C2620df.m9606c(getContext(), cursorQuery.getString(cursorQuery.getColumnIndex("item_id")));
                    int i5 = this.f9248g;
                    this.f9248g = i5 + 1;
                    C2680eq c2680eq3 = new C2680eq(i5, EnumC2681er.DOWNLOAD, string4, uriM9606c2);
                    this.f9247f.put(uriM9606c2, c2680eq3);
                    this.f9245d.add(c2680eq3);
                } finally {
                }
            }
        }
        CharSequence[] charSequenceArr = new CharSequence[this.f9245d.size()];
        for (int i6 = 0; i6 < this.f9245d.size(); i6++) {
            charSequenceArr[i6] = this.f9245d.get(i6).m9686b();
        }
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getContext());
        RelativeLayout relativeLayout = (RelativeLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.title_ringtone_popup, (ViewGroup) null);
        ((ImageButton) relativeLayout.findViewById(R.id.layout_download)).setOnClickListener(new ViewOnClickListenerC2682es(this));
        abstractC3271aM11494a.mo11499a(relativeLayout);
        abstractC3271aM11494a.mo11503a(charSequenceArr, m9175c(), this.f9242a);
        abstractC3271aM11494a.mo11515d(android.R.string.ok, new DialogInterfaceOnClickListenerC2683et(this));
        abstractC3271aM11494a.mo11507b(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        if (this.f9244c != null) {
            this.f9244c.dismiss();
        }
        this.f9244c = abstractC3271aM11494a.mo11505a();
        this.f9244c.setOnDismissListener(new DialogInterfaceOnDismissListenerC2684eu(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m9179e() {
        this.f9246e = new C1769a(new C2686ew(this));
    }

    /* renamed from: f */
    private Uri m9181f() {
        String strM10979a = C3159aa.m10962a().m10979a("Ringtone", (String) null);
        if (!TextUtils.isEmpty(strM10979a)) {
            if ("Silent".equals(strM10979a)) {
                return null;
            }
            return Uri.parse(strM10979a);
        }
        Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(getContext(), 2);
        if (actualDefaultRingtoneUri != null) {
            C3159aa.m10962a().m10986b("Ringtone", actualDefaultRingtoneUri.toString());
            return actualDefaultRingtoneUri;
        }
        return actualDefaultRingtoneUri;
    }

    /* renamed from: a */
    public void m9185a() {
        if (this.f9243b != null) {
            this.f9243b.stopPreviousRingtone();
        }
    }

    /* renamed from: b */
    public void m9186b() {
        Cursor cursor;
        if (this.f9243b != null && (cursor = this.f9243b.getCursor()) != null) {
            cursor.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m9183g() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        GlobalApplication.m11493l().sendBroadcast(intent);
    }
}
