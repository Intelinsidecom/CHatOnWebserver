package com.sec.chaton.p035io.entry;

import com.sec.chaton.util.C3250y;
import com.sec.common.p066d.p067a.AbstractC3314a;
import com.sec.common.util.C3364o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    }

    public class ChatONVApplicatoinInfoParser extends AbstractC3314a {
        @Override // com.sec.common.p066d.p067a.AbstractC3314a
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
                            if (C3250y.f11734b) {
                                C3250y.m11450b(C3364o.m11849a("Raw JSON: ", sb.toString()), ChatONVApplicationInfoEntry.TAG);
                            }
                            try {
                                JSONObject jSONObject = new JSONObject(sb.toString());
                                JSONObject jSONObject2 = (JSONObject) jSONObject.get("install");
                                JSONObject jSONObject3 = (JSONObject) jSONObject.get("config");
                                chatONVApplicationInfoEntry.install.enable = Boolean.valueOf(jSONObject2.getBoolean("enable"));
                                chatONVApplicationInfoEntry.config.videoCallMax = Integer.valueOf(jSONObject3.getInt("videoCallMax"));
                                chatONVApplicationInfoEntry.config.voiceCallMax = Integer.valueOf(jSONObject3.getInt("voiceCallMax"));
                                return chatONVApplicationInfoEntry;
                            } catch (JSONException e2) {
                                throw new IOException(e2);
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
