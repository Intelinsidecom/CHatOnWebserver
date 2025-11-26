package com.sec.chaton.hugefiletransfer;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.sec.chaton.R;
import com.sec.chaton.p057e.C2218af;
import com.sec.chaton.p057e.C2296p;
import com.sec.chaton.p057e.C2306z;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2300t;
import com.sec.chaton.p057e.p058a.C2204r;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4843bh;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import java.io.File;
import java.util.ArrayList;

/* compiled from: HugeFileDbOperationTask.java */
/* renamed from: com.sec.chaton.hugefiletransfer.c */
/* loaded from: classes.dex */
public class AsyncTaskC2389c extends AsyncTask<Void, Void, Boolean> {

    /* renamed from: a */
    private static final String f8498a = AsyncTaskC2389c.class.getSimpleName();

    /* renamed from: b */
    private int f8499b;

    /* renamed from: c */
    private ContentValues f8500c;

    /* renamed from: d */
    private EnumC2300t f8501d;

    /* renamed from: a */
    public static AsyncTaskC2389c m10386a(int i, ContentValues contentValues) {
        return new AsyncTaskC2389c(i, contentValues);
    }

    /* renamed from: a */
    public static AsyncTaskC2389c m10387a(int i, ContentValues contentValues, EnumC2300t enumC2300t) {
        return new AsyncTaskC2389c(i, contentValues, enumC2300t);
    }

    public AsyncTaskC2389c(int i, ContentValues contentValues) {
        this.f8499b = i;
        this.f8500c = contentValues;
    }

    private AsyncTaskC2389c(int i, ContentValues contentValues, EnumC2300t enumC2300t) {
        this.f8499b = i;
        this.f8500c = contentValues;
        this.f8501d = enumC2300t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) throws Throwable {
        Cursor cursor = null;
        switch (this.f8499b) {
            case 1:
                File file = new File(this.f8500c.getAsString("message_download_uri"));
                this.f8500c.put("_id", Long.valueOf(C4843bh.m18322a()));
                C2204r.m10014a(CommonApplication.m18732r().getContentResolver(), this.f8500c.getAsString("_id"), this.f8500c.getAsString("message_inbox_no"), EnumC2214ab.HUGEFILE, this.f8500c.getAsString("message_download_uri"), 0, String.format("hugefile\n%s\n%s\n%s\n%s\n%s", null, null, null, null, String.format("[%s]\n%s (%.1f MB)\n%s", null, file.getName(), Float.valueOf(file.length() / 1048576.0f), CommonApplication.m18732r().getString(R.string.hugefile_sending_message))), 0, null);
                return true;
            case 2:
                String str = String.format("[%s]\n%s (%.1f MB)\n%s", null, new File(this.f8500c.getAsString("message_download_uri")).getName(), Float.valueOf(r0.length() / 1048576.0f), CommonApplication.m18732r().getString(R.string.hugefile_sending_message));
                ContentValues contentValues = new ContentValues();
                contentValues.put("message_content", String.format("hugefile\n%s\n%s\n%s\n%s\n%s", null, null, null, null, str));
                contentValues.put("message_type", (Integer) 0);
                contentValues.put("message_is_failed", (Integer) 1);
                CommonApplication.m18732r().getContentResolver().update(C2306z.f8229a, contentValues, "_id=?", new String[]{this.f8500c.getAsString("_id")});
                return true;
            case 3:
                try {
                    Cursor cursorQuery = CommonApplication.m18732r().getContentResolver().query(C2296p.f8206a, null, "request_id=? AND request_type=?", new String[]{this.f8500c.getAsString("request_id"), this.f8500c.getAsString("request_type")}, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.getCount() > 0) {
                                if (C4904y.f17872b) {
                                    C4904y.m18639b("already exists : " + this.f8500c.getAsString("request_id"), f8498a);
                                }
                                if (cursorQuery == null) {
                                    return null;
                                }
                                cursorQuery.close();
                                return null;
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    CommonApplication.m18732r().getContentResolver().insert(C2218af.f7940a.buildUpon().appendPath("huge_file_upload_mapping").build(), this.f8500c);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                }
            case 4:
                try {
                    Cursor cursorQuery2 = CommonApplication.m18732r().getContentResolver().query(C2306z.f8229a, new String[]{"message_time"}, "_id=?", new String[]{this.f8500c.getAsString("_id")}, null);
                    if (cursorQuery2 != null) {
                        try {
                            if (cursorQuery2.moveToNext()) {
                                C2204r.m10007a(CommonApplication.m18732r().getContentResolver(), this.f8500c.getAsString("message_inbox_no"), this.f8500c.getAsString("message_content"), cursorQuery2.getLong(cursorQuery2.getColumnIndex("message_time")) + 1, C4809aa.m18104a().m18121a("chaton_id", ""));
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = cursorQuery2;
                            if (cursor != null) {
                                cursor.close();
                            }
                            throw th;
                        }
                    }
                    if (cursorQuery2 == null) {
                        return null;
                    }
                    cursorQuery2.close();
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                }
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        super.onPostExecute(bool);
        if (bool != null && bool.booleanValue()) {
            switch (this.f8499b) {
                case 1:
                case 2:
                    Intent intent = new Intent(CommonApplication.m18732r(), (Class<?>) HugeFileUploadService.class);
                    intent.putExtra("huge_file_request_id", this.f8500c.getAsLong("_id"));
                    intent.putExtra("huge_file_from_chat", true);
                    intent.putExtra("inboxNO", this.f8500c.getAsString("message_inbox_no"));
                    intent.putExtra("chatType", this.f8501d.m10210a());
                    intent.setData(Uri.parse(this.f8500c.getAsString("message_download_uri")));
                    ArrayList stringArrayList = this.f8500c.getStringArrayList("receivers");
                    Intent intent2 = new Intent();
                    intent2.setData(Uri.parse("chaton://chatroom?inboxNo=" + this.f8500c.getAsString("message_inbox_no")));
                    intent2.setAction("android.intent.action.SEND");
                    if (stringArrayList != null) {
                        intent2.putExtra("receivers", (String[]) stringArrayList.toArray(new String[0]));
                    }
                    intent.putExtra("huge_file_pending_intent", PendingIntent.getActivity(CommonApplication.m18732r(), 0, intent2, 134217728));
                    if (stringArrayList != null) {
                        intent.putExtra("receivers", (String[]) stringArrayList.toArray(new String[0]));
                    }
                    CommonApplication.m18732r().startService(intent);
                    break;
            }
        }
    }
}
