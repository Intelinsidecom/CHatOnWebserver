package com.sec.chaton.settings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.preference.Preference;
import android.util.AttributeSet;
import com.sec.chaton.R;
import com.sec.chaton.util.C1789u;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class RingtonePreference extends Preference implements DialogInterface.OnClickListener {

    /* renamed from: a */
    private RingtoneManager f4716a;

    /* renamed from: b */
    private Cursor f4717b;

    /* renamed from: c */
    private AlertDialogBuilderC2120a f4718c;

    /* renamed from: d */
    private AlertDialog f4719d;

    /* renamed from: e */
    private String f4720e;

    /* renamed from: f */
    private SharedPreferences f4721f;

    /* renamed from: g */
    private SharedPreferences.Editor f4722g;

    public RingtonePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RingtonePreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4721f = C1789u.m6075a();
        this.f4722g = this.f4721f.edit();
        m4694a();
    }

    /* renamed from: a */
    private void m4694a() {
        int ringtonePosition;
        this.f4716a = new RingtoneManager(getContext());
        this.f4716a.setType(2);
        this.f4717b = this.f4716a.getCursor();
        Uri uriM4696b = m4696b();
        if (uriM4696b == null) {
            this.f4720e = "Silent";
            ringtonePosition = 0;
        } else {
            this.f4720e = uriM4696b.toString();
            ringtonePosition = this.f4716a.getRingtonePosition(Uri.parse(this.f4720e)) + 1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(getContext().getString(R.string.ringtone_silent));
        this.f4717b.moveToFirst();
        do {
            arrayList.add(this.f4717b.getString(1));
        } while (this.f4717b.moveToNext());
        this.f4718c = new AlertDialogBuilderC2120a(getContext());
        this.f4718c.setTitle(getTitle());
        this.f4718c.setSingleChoiceItems((CharSequence[]) arrayList.toArray(new CharSequence[1]), ringtonePosition, this);
        this.f4718c.setNegativeButton(android.R.string.ok, this);
        this.f4718c.setPositiveButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        this.f4719d = this.f4718c.create();
        this.f4719d.setOnDismissListener(new DialogInterfaceOnDismissListenerC1304db(this));
    }

    @Override // android.preference.Preference
    protected void onClick() {
        super.onClick();
        this.f4719d.getListView().setItemChecked(this.f4716a.getRingtonePosition(m4696b()) + 1, true);
        this.f4719d.show();
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        if (i == -2) {
            callChangeListener(this.f4720e);
            m4695a(this.f4720e);
            return;
        }
        this.f4716a.stopPreviousRingtone();
        if (i == 0) {
            this.f4720e = "Silent";
            return;
        }
        int i2 = i - 1;
        this.f4716a.getRingtone(i2).play();
        this.f4720e = this.f4716a.getRingtoneUri(i2).toString();
    }

    @Override // android.preference.Preference
    protected Object onGetDefaultValue(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    @Override // android.preference.Preference
    protected void onSetInitialValue(boolean z, Object obj) {
        if (z) {
            m4695a(getPersistedString(this.f4720e));
        } else {
            m4695a((String) obj);
        }
    }

    /* renamed from: a */
    private void m4695a(String str) {
        persistString(str);
    }

    /* renamed from: b */
    private Uri m4696b() {
        String string = this.f4721f.getString("Ringtone", null);
        if (string != null) {
            if ("Silent".equals(string)) {
                return null;
            }
            return Uri.parse(string);
        }
        Uri actualDefaultRingtoneUri = RingtoneManager.getActualDefaultRingtoneUri(getContext(), 2);
        if (actualDefaultRingtoneUri != null) {
            this.f4722g.putString("Ringtone", actualDefaultRingtoneUri.toString());
            this.f4722g.commit();
            return actualDefaultRingtoneUri;
        }
        this.f4722g.putString("Ringtone", "Silent");
        this.f4722g.commit();
        return actualDefaultRingtoneUri;
    }
}
