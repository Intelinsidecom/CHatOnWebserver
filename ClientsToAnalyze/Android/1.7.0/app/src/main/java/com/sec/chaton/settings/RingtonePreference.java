package com.sec.chaton.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.Preference;
import android.util.AttributeSet;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;
import com.sec.widget.AlertDialogBuilderC1625m;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class RingtonePreference extends Preference implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private RingtoneManager f3591a;

    /* renamed from: b */
    private Cursor f3592b;

    /* renamed from: c */
    private AlertDialogBuilderC1625m f3593c;

    /* renamed from: d */
    private AlertDialog f3594d;

    /* renamed from: e */
    private String f3595e;

    /* renamed from: f */
    private SharedPreferences f3596f;

    /* renamed from: g */
    private SharedPreferences.Editor f3597g;

    public RingtonePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RingtonePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3596f = C1323bs.m4575a();
        this.f3597g = this.f3596f.edit();
        m3904a();
    }

    /* renamed from: a */
    private void m3904a() {
        int ringtonePosition;
        this.f3591a = new RingtoneManager(getContext());
        this.f3591a.setType(2);
        this.f3592b = this.f3591a.getCursor();
        Uri uriM3908b = m3908b();
        if (uriM3908b == null) {
            this.f3595e = "Silent";
            ringtonePosition = 0;
        } else {
            this.f3595e = uriM3908b.toString();
            ringtonePosition = this.f3591a.getRingtonePosition(Uri.parse(this.f3595e)) + 1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(getContext().getString(R.string.ringtone_silent));
        this.f3592b.moveToFirst();
        do {
            arrayList.add(this.f3592b.getString(1));
        } while (this.f3592b.moveToNext());
        this.f3593c = new AlertDialogBuilderC1625m(getContext());
        this.f3593c.setTitle(getTitle());
        this.f3593c.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new CharSequence[1]), ringtonePosition, this);
        this.f3593c.setPositiveButton(android.R.string.ok, new DialogInterfaceOnClickListenerC1043bn(this));
        this.f3593c.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        this.f3594d = this.f3593c.create();
    }

    @Override // android.preference.Preference
    protected void onClick() {
        int ringtonePosition;
        super.onClick();
        Uri uriM3908b = m3908b();
        if (uriM3908b == null) {
            this.f3595e = "Silent";
            ringtonePosition = 0;
        } else {
            this.f3595e = uriM3908b.toString();
            ringtonePosition = this.f3591a.getRingtonePosition(Uri.parse(this.f3595e)) + 1;
        }
        this.f3594d.getListView().setItemChecked(ringtonePosition, true);
        this.f3594d.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f3591a.stopPreviousRingtone();
        if (i == 0) {
            this.f3595e = "Silent";
            return;
        }
        int i2 = i - 1;
        Ringtone ringtone = this.f3591a.getRingtone(i2);
        if (ringtone != null) {
            ringtone.play();
        }
        this.f3595e = this.f3591a.getRingtoneUri(i2).toString();
    }

    @Override // android.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // android.preference.Preference
    protected void onSetInitialValue(boolean z, Object obj) {
        if (z) {
            m3906a(getPersistedString(this.f3595e));
        } else {
            m3906a((String) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3906a(String str) {
        persistString(str);
    }

    /* renamed from: b */
    private Uri m3908b() {
        String string = this.f3596f.getString("Ringtone", null);
        if (string != null) {
            if ("Silent".equals(string)) {
                return null;
            }
            return Uri.parse(string);
        }
        Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(getContext(), 2);
        this.f3597g.putString("Ringtone", actualDefaultRingtoneUri.toString());
        this.f3597g.commit();
        return actualDefaultRingtoneUri;
    }
}
