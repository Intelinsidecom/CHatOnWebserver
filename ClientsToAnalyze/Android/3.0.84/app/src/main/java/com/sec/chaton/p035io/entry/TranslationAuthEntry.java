package com.sec.chaton.p035io.entry;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class TranslationAuthEntry extends Entry {
    private ServerInfo __gldInfo;
    private boolean __parsed = false;
    public String error;
    public Long error_code;
    public String error_description;
    public JSONObject gld_region;
    public Long rcode;
    public String uid;

    public class ServerInfo {
        public Long expdate;
        public List<Server> primary = new ArrayList();
        public List<Server> secondary = new ArrayList();

        public ServerInfo() {
        }
    }

    public class Server {
        public String address;
        public String name;
        public String port;
        public String region;

        public Server() {
        }
    }

    public String getUrlPrimary() {
        return getUrl(EnumC1538a.PRIMARY);
    }

    public String getUrlSecondary() {
        return getUrl(EnumC1538a.SECONDARY);
    }

    private String getUrl(EnumC1538a enumC1538a) throws NumberFormatException {
        List<Server> list;
        try {
            parseMore();
            if (this.__gldInfo == null) {
                return null;
            }
            if (enumC1538a == EnumC1538a.PRIMARY) {
                list = this.__gldInfo.primary;
            } else {
                list = this.__gldInfo.secondary;
            }
            if (list == null || list.size() <= 0) {
                return null;
            }
            Server server = list.get(0);
            String str = server.address;
            int i = Integer.parseInt(server.port);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith("http://") || str.startsWith("https://")) {
                return str + ":" + i;
            }
            if (i == 443) {
                return "https://" + server.address + ":" + i;
            }
            return "http://" + server.address + ":" + i;
        } catch (JSONException e) {
            return null;
        }
    }

    private boolean parseMore() throws JSONException {
        if (this.__parsed) {
            return true;
        }
        if (this.gld_region == null) {
            return false;
        }
        this.__gldInfo = new ServerInfo();
        this.__gldInfo.expdate = Long.valueOf(this.gld_region.getLong("expdate"));
        JSONArray jSONArray = new JSONArray(this.gld_region.getString("primary"));
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            Server server = new Server();
            server.region = jSONObject.getString("region");
            server.name = jSONObject.getString("name");
            server.port = jSONObject.getString("port");
            server.address = jSONObject.getString("address");
            this.__gldInfo.primary.add(server);
        }
        JSONArray jSONArray2 = new JSONArray(this.gld_region.getString("secondary"));
        int length2 = jSONArray2.length();
        for (int i2 = 0; i2 < length2; i2++) {
            JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
            Server server2 = new Server();
            server2.region = jSONObject2.getString("region");
            server2.name = jSONObject2.getString("name");
            server2.port = jSONObject2.getString("port");
            server2.address = jSONObject2.getString("address");
            this.__gldInfo.secondary.add(server2);
        }
        this.__parsed = true;
        return true;
    }
}
