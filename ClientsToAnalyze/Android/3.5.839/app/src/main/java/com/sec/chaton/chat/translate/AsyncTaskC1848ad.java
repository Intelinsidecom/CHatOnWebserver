package com.sec.chaton.chat.translate;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.EditText;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.widget.C5179v;

/* compiled from: TranslatorFragment.java */
/* renamed from: com.sec.chaton.chat.translate.ad */
/* loaded from: classes.dex */
class AsyncTaskC1848ad extends AsyncTask<Void, Void, String> {

    /* renamed from: a */
    final /* synthetic */ TranslatorFragment f7029a;

    /* renamed from: b */
    private EditText f7030b;

    /* renamed from: c */
    private EditText f7031c;

    /* renamed from: d */
    private String f7032d;

    /* renamed from: e */
    private String f7033e;

    public AsyncTaskC1848ad(TranslatorFragment translatorFragment, EditText editText, EditText editText2, String str, String str2) {
        this.f7029a = translatorFragment;
        this.f7030b = editText;
        this.f7031c = editText2;
        this.f7032d = str;
        this.f7033e = str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Void... voidArr) {
        C4904y.m18639b("Source Lang Code for Translator Request : " + this.f7029a.f6979l, TranslatorFragment.f6968a);
        C4904y.m18639b("Target Lang Code for Translator Request : " + this.f7029a.f6980m, TranslatorFragment.f6968a);
        if (isCancelled()) {
            return null;
        }
        String string = this.f7030b.getText().toString();
        if (!TextUtils.isEmpty(string)) {
            return this.f7029a.f6970c.m9027a(Long.valueOf(this.f7029a.f6983p), string, true, this.f7033e, this.f7032d, this.f7029a.f6982o, false);
        }
        C4904y.m18639b("Request Msg is null ", TranslatorFragment.f6968a);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        if (this.f7029a.f6977j != null) {
            super.onPostExecute(str);
            if (this.f7029a.f6978k != null && this.f7029a.f6978k.isShowing()) {
                this.f7029a.f6978k.dismiss();
            }
            if (str == null || TextUtils.isEmpty(str)) {
                this.f7029a.m8987a(false);
                C5179v.m19810a(CommonApplication.m18732r(), R.string.failed_to_translate, 0).show();
                return;
            }
            this.f7031c.setText(str);
            this.f7031c.requestFocus();
            try {
                this.f7031c.setSelection(str.length());
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            this.f7029a.f6984q = this.f7029a.f6974g.getText().toString();
            this.f7029a.f6985r = str;
            this.f7029a.m8987a(true);
        }
    }
}
