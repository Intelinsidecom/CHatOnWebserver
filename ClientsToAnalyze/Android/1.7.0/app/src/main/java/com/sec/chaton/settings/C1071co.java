package com.sec.chaton.settings;

import android.media.RingtoneManager;
import android.view.View;
import android.widget.AdapterView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;

/* compiled from: FragmentRingToneView.java */
/* renamed from: com.sec.chaton.settings.co */
/* loaded from: classes.dex */
class C1071co implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1074f f3716a;

    C1071co(AsyncTaskC1074f asyncTaskC1074f) {
        this.f3716a = asyncTaskC1074f;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C1341p.m4660c("position = " + i, getClass().getSimpleName());
        if (i == 0) {
            this.f3716a.f3718a.f3511g = RingtoneManager.getRingtone(this.f3716a.f3718a.getActivity(), RingtoneManager.getDefaultUri(2));
            this.f3716a.f3718a.f3511g.play();
            this.f3716a.f3718a.f3515k = this.f3716a.f3718a.f3511g.getTitle(this.f3716a.f3718a.getActivity());
            C1057ca.m3938b(this.f3716a.f3718a.f3515k);
            this.f3716a.f3718a.f3516l = RingtoneManager.getDefaultUri(2).toString();
            return;
        }
        if (i == 1) {
            this.f3716a.f3718a.f3515k = this.f3716a.f3718a.getString(R.string.ringtone_silent);
            this.f3716a.f3718a.f3516l = "Silent";
            return;
        }
        this.f3716a.f3718a.f3511g = this.f3716a.f3718a.f3510f.getRingtone(i - 2);
        this.f3716a.f3718a.f3511g.play();
        if (i < this.f3716a.f3718a.f3509e.length) {
            this.f3716a.f3718a.f3515k = this.f3716a.f3718a.f3509e[i];
        } else {
            C1341p.m4651a("arrayindexounofbounded", getClass().getSimpleName());
            this.f3716a.f3718a.f3515k = "";
        }
        this.f3716a.f3718a.f3516l = this.f3716a.f3718a.f3510f.getRingtoneUri(i - 2).toString();
        C1057ca.m3938b(this.f3716a.f3718a.f3515k);
    }
}
