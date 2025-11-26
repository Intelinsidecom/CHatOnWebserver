package com.sec.chaton.settings;

import android.app.Activity;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.ProgressDialogC1806j;
import java.util.ArrayList;

/* compiled from: FragmentRingToneView.java */
/* renamed from: com.sec.chaton.settings.cd */
/* loaded from: classes.dex */
class AsyncTaskC1279cd extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ FragmentRingToneView f4825a;

    private AsyncTaskC1279cd(FragmentRingToneView fragmentRingToneView) {
        this.f4825a = fragmentRingToneView;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f4825a.f4639j = this.f4825a.f4637h.inflate(R.layout.layout_ringtone_type, this.f4825a.f4638i, false);
        this.f4825a.f4642m = ProgressDialogC1806j.m6141a(this.f4825a.getActivity(), null, this.f4825a.getResources().getString(R.string.wait_sending), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) {
        this.f4825a.f4632c = new ArrayList();
        this.f4825a.f4635f = new RingtoneManager((Activity) this.f4825a.getActivity());
        this.f4825a.f4635f.setType(2);
        Cursor cursor = this.f4825a.f4635f.getCursor();
        this.f4825a.f4634e = new String[cursor.getCount() + 2];
        this.f4825a.f4634e[0] = this.f4825a.getString(R.string.ringtone_default);
        this.f4825a.f4634e[1] = this.f4825a.getString(R.string.ringtone_silent);
        this.f4825a.f4632c.add(this.f4825a.f4634e[0]);
        this.f4825a.f4632c.add(this.f4825a.f4634e[1]);
        for (int i = 0; i < cursor.getCount(); i++) {
            this.f4825a.f4636g = this.f4825a.f4635f.getRingtone(i);
            this.f4825a.f4634e[i + 2] = this.f4825a.f4636g.getTitle(this.f4825a.getActivity());
            C1786r.m6063c("ring = " + this.f4825a.f4636g.getTitle(this.f4825a.getActivity()), getClass().getSimpleName());
            this.f4825a.f4632c.add(this.f4825a.f4634e[i + 2]);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        Uri defaultUri;
        String title;
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.f4825a.getActivity(), R.layout.simple_list_item_single_choice, this.f4825a.f4632c);
        this.f4825a.f4633d = (ListView) this.f4825a.f4639j.findViewById(R.id.list_ringtone_type);
        this.f4825a.f4633d.setAdapter((ListAdapter) arrayAdapter);
        this.f4825a.f4633d.setChoiceMode(1);
        String string = this.f4825a.f4630a.getString("Ringtone", null);
        if (string != null) {
            defaultUri = !"Silent".equals(string) ? Uri.parse(string) : null;
        } else {
            defaultUri = RingtoneManager.getDefaultUri(2);
        }
        if (defaultUri == null || RingtoneManager.getActualDefaultRingtoneUri(this.f4825a.getActivity(), 2) == null) {
            title = "Silent";
        } else {
            title = RingtoneManager.getRingtone(this.f4825a.getActivity(), defaultUri).getTitle(this.f4825a.getActivity());
        }
        boolean zEquals = defaultUri != null ? defaultUri.toString().equals(RingtoneManager.getDefaultUri(2).toString()) : false;
        if (title == null) {
            this.f4825a.f4633d.setItemChecked(1, true);
        } else {
            if (zEquals) {
                this.f4825a.f4633d.setItemChecked(0, true);
            }
            int i = 0;
            while (true) {
                if (i >= this.f4825a.f4634e.length) {
                    break;
                }
                if (title.equals(this.f4825a.f4634e[i])) {
                    this.f4825a.f4633d.setItemChecked(i, true);
                    break;
                }
                i++;
            }
        }
        this.f4825a.f4633d.setOnItemClickListener(new C1280ce(this));
        if (this.f4825a.f4642m != null && this.f4825a.f4642m.isShowing()) {
            this.f4825a.f4642m.dismiss();
        }
    }
}
