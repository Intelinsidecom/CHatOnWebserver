package com.sec.chaton.p065io.entry;

import android.text.TextUtils;
import com.sec.chaton.p049b.C1057b;
import com.sec.chaton.util.C4904y;
import com.sec.common.p126d.p127a.AbstractC4976a;
import com.sec.common.util.C5052r;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ChatONVApplicationInfoEntry extends Entry {
    private static final String TAG = ChatONVApplicationInfoEntry.class.getSimpleName();
    public Install install = new Install();
    public Config config = new Config();

    public class Config extends Entry {
        public Integer videoCallMax;
        public Integer voiceCallMax;
    }

    public class Install extends Entry {
        public Boolean enable;
        public ArrayList<String> urlList = new ArrayList<>(2);
    }

    public class ChatONVApplicatoinInfoParser extends AbstractC4976a {
        @Override // com.sec.common.p126d.p127a.AbstractC4976a
        public Object parse(InputStream inputStream) throws Throwable {
            BufferedReader bufferedReader;
            ChatONVApplicationInfoEntry chatONVApplicationInfoEntry = new ChatONVApplicationInfoEntry();
            StringBuilder sb = new StringBuilder();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e) {
                                }
                            }
                            if (C4904y.f17872b) {
                                C4904y.m18639b(C5052r.m19199a("Raw JSON: ", sb.toString()), ChatONVApplicationInfoEntry.TAG);
                            }
                            try {
                                JSONObject jSONObject = new JSONObject(sb.toString());
                                JSONObject jSONObject2 = (JSONObject) jSONObject.get("install");
                                JSONObject jSONObject3 = (JSONObject) jSONObject.get("config");
                                chatONVApplicationInfoEntry.install.enable = Boolean.valueOf(jSONObject2.getBoolean("enable"));
                                if (chatONVApplicationInfoEntry.install.enable.booleanValue()) {
                                    JSONArray jSONArray = jSONObject2.getJSONArray("urlList");
                                    for (int i = 0; i < jSONArray.length(); i++) {
                                        if (jSONArray.get(i) == null || TextUtils.isEmpty(jSONArray.get(i).toString())) {
                                            if (C4904y.f17872b) {
                                                C4904y.m18639b(jSONArray.get(i) + " is null or empty string", ChatONVApplicationInfoEntry.TAG);
                                            }
                                            chatONVApplicationInfoEntry.install.urlList.add(i, "");
                                        } else {
                                            chatONVApplicationInfoEntry.install.urlList.add(i, jSONArray.get(i).toString());
                                        }
                                    }
                                }
                                chatONVApplicationInfoEntry.config.videoCallMax = Integer.valueOf(jSONObject3.getInt("videoCallMax"));
                                chatONVApplicationInfoEntry.config.voiceCallMax = Integer.valueOf(jSONObject3.getInt("voiceCallMax"));
                                return chatONVApplicationInfoEntry;
                            } catch (JSONException e2) {
                                throw C1057b.m6157a(e2);
                            }
                        }
                        if (Thread.interrupted()) {
                            throw new InterruptedException("ChatONVApplicatoinInfoParser is interrupted.");
                        }
                        sb.append(line);
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        }
    }
}
