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
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.ProgressDialogC1354a;
import java.util.ArrayList;

/* compiled from: FragmentRingToneView.java */
/* renamed from: com.sec.chaton.settings.f */
/* loaded from: classes.dex */
class AsyncTaskC1074f extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ FragmentRingToneView f3718a;

    private AsyncTaskC1074f(FragmentRingToneView fragmentRingToneView) {
        this.f3718a = fragmentRingToneView;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.f3718a.f3514j = this.f3718a.f3512h.inflate(R.layout.layout_ringtone_type, this.f3718a.f3513i, false);
        this.f3718a.f3517m = ProgressDialogC1354a.m4724a(this.f3718a.getActivity(), null, this.f3718a.getResources().getString(R.string.wait_sending), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) {
        this.f3718a.f3507c = new ArrayList();
        this.f3718a.f3510f = new RingtoneManager((Activity) this.f3718a.getActivity());
        this.f3718a.f3510f.setType(2);
        Cursor cursor = this.f3718a.f3510f.getCursor();
        this.f3718a.f3509e = new String[cursor.getCount() + 2];
        this.f3718a.f3509e[0] = this.f3718a.getString(R.string.ringtone_default);
        this.f3718a.f3509e[1] = this.f3718a.getString(R.string.ringtone_silent);
        this.f3718a.f3507c.add(this.f3718a.f3509e[0]);
        this.f3718a.f3507c.add(this.f3718a.f3509e[1]);
        for (int i = 0; i < cursor.getCount(); i++) {
            this.f3718a.f3511g = this.f3718a.f3510f.getRingtone(i);
            this.f3718a.f3509e[i + 2] = this.f3718a.f3511g.getTitle(this.f3718a.getActivity());
            C1341p.m4660c("ring = " + this.f3718a.f3511g.getTitle(this.f3718a.getActivity()), getClass().getSimpleName());
            this.f3718a.f3507c.add(this.f3718a.f3509e[i + 2]);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        Uri defaultUri;
        String title;
        int i = 0;
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.f3718a.getActivity(), android.R.layout.simple_list_item_single_choice, this.f3718a.f3507c);
        this.f3718a.f3508d = (ListView) this.f3718a.f3514j.findViewById(R.id.list_ringtone_type);
        this.f3718a.f3508d.setAdapter((ListAdapter) arrayAdapter);
        this.f3718a.f3508d.setChoiceMode(1);
        String string = this.f3718a.f3505a.getString("Ringtone", null);
        if (string != null) {
            defaultUri = !"Silent".equals(string) ? Uri.parse(string) : null;
        } else {
            defaultUri = RingtoneManager.getDefaultUri(2);
        }
        if (defaultUri == null || RingtoneManager.getActualDefaultRingtoneUri(this.f3718a.getActivity(), 2) == null) {
            title = "Silent";
        } else {
            title = RingtoneManager.getRingtone(this.f3718a.getActivity(), defaultUri).getTitle(this.f3718a.getActivity());
        }
        if (RingtoneManager.getRingtone(this.f3718a.getActivity(), Uri.parse(this.f3718a.f3505a.getString("Ringtone", ""))).getTitle(this.f3718a.getActivity()) == null) {
            this.f3718a.f3508d.setItemChecked(1, true);
        } else {
            if (title.startsWith("Default")) {
                this.f3718a.f3508d.setItemChecked(0, true);
            }
            while (true) {
                if (i >= this.f3718a.f3509e.length) {
                    break;
                }
                if (title.equals(this.f3718a.f3509e[i])) {
                    this.f3718a.f3508d.setItemChecked(i, true);
                    break;
                }
                i++;
            }
        }
        this.f3718a.f3508d.setOnItemClickListener(new C1071co(this));
        if (this.f3718a.f3517m != null && this.f3718a.f3517m.isShowing()) {
            this.f3718a.f3517m.dismiss();
        }
    }
}
