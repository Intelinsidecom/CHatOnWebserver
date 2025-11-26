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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.audio.C2723a;
import com.sec.chaton.p057e.C2257bc;
import com.sec.chaton.p057e.EnumC2258bd;
import com.sec.chaton.settings.p096a.C3455ab;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.common.util.C5052r;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class RingtonePreference2 extends Preference {

    /* renamed from: a */
    DialogInterface.OnClickListener f12817a;

    /* renamed from: b */
    private RingtoneManager f12818b;

    /* renamed from: c */
    private InterfaceC4936e f12819c;

    /* renamed from: d */
    private ArrayList<C3632fo> f12820d;

    /* renamed from: e */
    private C2723a f12821e;

    /* renamed from: f */
    private HashMap<Uri, C3632fo> f12822f;

    /* renamed from: g */
    private int f12823g;

    /* renamed from: h */
    private C3632fo f12824h;

    public RingtonePreference2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12817a = new DialogInterfaceOnClickListenerC3637ft(this);
    }

    public RingtonePreference2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12817a = new DialogInterfaceOnClickListenerC3637ft(this);
        m13665d();
    }

    public RingtonePreference2(Context context) {
        super(context);
        this.f12817a = new DialogInterfaceOnClickListenerC3637ft(this);
    }

    @Override // android.preference.Preference
    protected void onClick() {
        this.f12824h = null;
        m13665d();
        this.f12819c.mo18760b().setItemChecked(m13662c(), true);
        this.f12819c.show();
    }

    /* renamed from: c */
    private int m13662c() {
        C3632fo c3632fo;
        Uri uriM13668f = m13668f();
        if (uriM13668f != null && (c3632fo = this.f12822f.get(uriM13668f)) != null) {
            return c3632fo.m13914e();
        }
        return 0;
    }

    /* renamed from: d */
    private void m13665d() {
        if (this.f12818b == null) {
            this.f12818b = new RingtoneManager(getContext());
            this.f12818b.setType(2);
            this.f12818b.setIncludeDrm(true);
            this.f12818b.setStopPreviousRingtone(false);
        }
        if (this.f12820d != null) {
            this.f12820d.clear();
        } else {
            this.f12820d = new ArrayList<>();
        }
        if (this.f12822f != null) {
            this.f12822f.clear();
        } else {
            this.f12822f = new HashMap<>();
        }
        this.f12823g = 0;
        ArrayList<C3632fo> arrayList = this.f12820d;
        int i = this.f12823g;
        this.f12823g = i + 1;
        arrayList.add(new C3632fo(i, EnumC3633fp.SYSTEM, getContext().getString(R.string.ringtone_silent), null));
        Cursor cursor = this.f12818b.getCursor();
        if (cursor != null) {
            int i2 = 0;
            while (cursor.moveToNext()) {
                String string = cursor.getString(1);
                Uri ringtoneUri = this.f12818b.getRingtoneUri(i2);
                int i3 = this.f12823g;
                this.f12823g = i3 + 1;
                C3632fo c3632fo = new C3632fo(i3, EnumC3633fp.SYSTEM, string, ringtoneUri, i2);
                this.f12822f.put(ringtoneUri, c3632fo);
                this.f12820d.add(c3632fo);
                i2++;
            }
        }
        Cursor cursorQuery = getContext().getContentResolver().query(C2257bc.m10121a(EnumC2258bd.Sound), null, C5052r.m19199a("item_id", "< '0'"), null, "name");
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("item_id"));
                    int iM13755e = C3455ab.m13755e(getContext(), string3);
                    Uri uriM13753c = C3455ab.m13753c(getContext(), string3);
                    int i4 = this.f12823g;
                    this.f12823g = i4 + 1;
                    C3632fo c3632fo2 = new C3632fo(i4, EnumC3633fp.EMBED, string2, uriM13753c, iM13755e);
                    this.f12822f.put(uriM13753c, c3632fo2);
                    this.f12820d.add(c3632fo2);
                } finally {
                }
            }
            cursorQuery.close();
        }
        cursorQuery = getContext().getContentResolver().query(C2257bc.m10121a(EnumC2258bd.Sound), null, C5052r.m19199a("item_id", "> '0' AND ", "install", "!= '0'"), null, "name");
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("name"));
                    Uri uriM13753c2 = C3455ab.m13753c(getContext(), cursorQuery.getString(cursorQuery.getColumnIndex("item_id")));
                    int i5 = this.f12823g;
                    this.f12823g = i5 + 1;
                    C3632fo c3632fo3 = new C3632fo(i5, EnumC3633fp.DOWNLOAD, string4, uriM13753c2);
                    this.f12822f.put(uriM13753c2, c3632fo3);
                    this.f12820d.add(c3632fo3);
                } finally {
                }
            }
        }
        CharSequence[] charSequenceArr = new CharSequence[this.f12820d.size()];
        for (int i6 = 0; i6 < this.f12820d.size(); i6++) {
            charSequenceArr[i6] = this.f12820d.get(i6).m13911b();
        }
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getContext());
        RelativeLayout relativeLayout = (RelativeLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.title_ringtone_popup, (ViewGroup) null);
        ImageButton imageButton = (ImageButton) relativeLayout.findViewById(R.id.layout_download);
        ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.ringtone_badge);
        if (C3455ab.m13743a() > 0) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
        if (C4822an.m18218a()) {
            imageButton.setVisibility(0);
            imageButton.setOnClickListener(new ViewOnClickListenerC3634fq(this));
        } else {
            imageButton.setVisibility(8);
        }
        abstractC4932aM18733a.mo18738a(relativeLayout);
        abstractC4932aM18733a.mo18743a(charSequenceArr, m13662c(), this.f12817a);
        abstractC4932aM18733a.mo18756d(android.R.string.ok, new DialogInterfaceOnClickListenerC3635fr(this));
        abstractC4932aM18733a.mo18747b(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        if (this.f12819c != null) {
            this.f12819c.dismiss();
        }
        this.f12819c = abstractC4932aM18733a.mo18745a();
        this.f12819c.mo18758a().setVolumeControlStream(5);
        this.f12819c.setOnDismissListener(new DialogInterfaceOnDismissListenerC3636fs(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m13666e() {
        this.f12821e = new C2723a(new C3638fu(this));
    }

    /* renamed from: f */
    private Uri m13668f() {
        String strM18121a = C4809aa.m18104a().m18121a("Ringtone", (String) null);
        if (!TextUtils.isEmpty(strM18121a)) {
            if ("Silent".equals(strM18121a)) {
                return null;
            }
            return Uri.parse(strM18121a);
        }
        return m13670g();
    }

    /* renamed from: g */
    private Uri m13670g() {
        Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(getContext(), 2);
        if (actualDefaultRingtoneUri != null) {
            C4809aa.m18104a().m18128b("Ringtone", actualDefaultRingtoneUri.toString());
            callChangeListener(actualDefaultRingtoneUri.toString());
        }
        return actualDefaultRingtoneUri;
    }

    /* renamed from: a */
    public void m13673a() {
        if (this.f12818b != null) {
            this.f12818b.stopPreviousRingtone();
        }
    }

    /* renamed from: b */
    public void m13674b() {
        Cursor cursor;
        if (this.f12818b != null && (cursor = this.f12818b.getCursor()) != null) {
            cursor.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m13672h() {
        Intent intent = new Intent("com.android.music.musicservicecommand");
        intent.putExtra("command", "pause");
        GlobalApplication.m18732r().sendBroadcast(intent);
    }
}
