package weibo4android;

import java.util.ArrayList;
import weibo4android.http.PostParameter;
import weibo4android.http.Response;
import weibo4android.org.json.JSONException;
import weibo4android.org.json.JSONObject;

/* loaded from: classes.dex */
public class Privacy extends WeiboResponse {
    private static final long serialVersionUID = -8143436310519276882L;
    private Boolean allUserCanComment;
    private Boolean allUserCanMessage;
    private Boolean findByRealname;
    private Boolean showBadge;
    private Boolean showGeo;

    public Boolean getAllUserCanComment() {
        return this.allUserCanComment;
    }

    public void setAllUserCanComment(Boolean bool) {
        this.allUserCanComment = bool;
    }

    public Boolean getAllUserCanMessage() {
        return this.allUserCanMessage;
    }

    public void setAllUserCanMessage(Boolean bool) {
        this.allUserCanMessage = bool;
    }

    public Boolean getFindByRealname() {
        return this.findByRealname;
    }

    public void setFindByRealname(Boolean bool) {
        this.findByRealname = bool;
    }

    public Boolean getShowGeo() {
        return this.showGeo;
    }

    public void setShowGeo(Boolean bool) {
        this.showGeo = bool;
    }

    public Boolean getShowBadge() {
        return this.showBadge;
    }

    public void setShowBadge(Boolean bool) {
        this.showBadge = bool;
    }

    public Privacy(JSONObject jSONObject) throws WeiboException {
        this.allUserCanComment = null;
        this.allUserCanMessage = null;
        this.findByRealname = null;
        this.showGeo = null;
        this.showBadge = null;
        try {
            if (jSONObject.getString("comment") != null) {
                this.allUserCanComment = Boolean.valueOf("0".equals(jSONObject.getString("comment")));
            }
            if (jSONObject.getString("message") != null) {
                this.allUserCanMessage = Boolean.valueOf("0".equals(jSONObject.getString("message")));
            }
            if (jSONObject.getString("realname") != null) {
                this.findByRealname = Boolean.valueOf("0".equals(jSONObject.getString("realname")));
            }
            if (jSONObject.getString("geo") != null) {
                this.showGeo = Boolean.valueOf("0".equals(jSONObject.getString("geo")));
            }
            if (jSONObject.getString("badge") != null) {
                this.showBadge = Boolean.valueOf("0".equals(jSONObject.getString("badge")));
            }
        } catch (JSONException e) {
            throw new WeiboException(String.valueOf(e.getMessage()) + ":" + jSONObject.toString(), e);
        }
    }

    public Privacy(Response response) throws WeiboException {
        super(response);
        this.allUserCanComment = null;
        this.allUserCanMessage = null;
        this.findByRealname = null;
        this.showGeo = null;
        this.showBadge = null;
        JSONObject jSONObjectAsJSONObject = response.asJSONObject();
        try {
            if (jSONObjectAsJSONObject.getString("comment") != null) {
                this.allUserCanComment = Boolean.valueOf("0".equals(jSONObjectAsJSONObject.getString("comment")));
            }
            if (jSONObjectAsJSONObject.getString("message") != null) {
                this.allUserCanMessage = Boolean.valueOf("0".equals(jSONObjectAsJSONObject.getString("message")));
            }
            if (jSONObjectAsJSONObject.getString("realname") != null) {
                this.findByRealname = Boolean.valueOf("0".equals(jSONObjectAsJSONObject.getString("realname")));
            }
            if (jSONObjectAsJSONObject.getString("geo") != null) {
                this.showGeo = Boolean.valueOf("0".equals(jSONObjectAsJSONObject.getString("geo")));
            }
            if (jSONObjectAsJSONObject.getString("badge") != null) {
                this.showBadge = Boolean.valueOf("0".equals(jSONObjectAsJSONObject.getString("badge")));
            }
        } catch (JSONException e) {
            throw new WeiboException(String.valueOf(e.getMessage()) + ":" + jSONObjectAsJSONObject.toString(), e);
        }
    }

    public Privacy() {
        this.allUserCanComment = null;
        this.allUserCanMessage = null;
        this.findByRealname = null;
        this.showGeo = null;
        this.showBadge = null;
    }

    public PostParameter[] getParameters() {
        ArrayList arrayList = new ArrayList();
        if (this.allUserCanComment != null) {
            arrayList.add(getParameterValue("comment", this.allUserCanComment));
        }
        if (this.allUserCanMessage != null) {
            arrayList.add(getParameterValue("message", this.allUserCanMessage));
        }
        if (this.findByRealname != null) {
            arrayList.add(getParameterValue("realname", this.findByRealname));
        }
        if (this.showGeo != null) {
            arrayList.add(getParameterValue("geo", this.showGeo));
        }
        if (this.showBadge != null) {
            arrayList.add(getParameterValue("badge", this.showBadge));
        }
        return (PostParameter[]) arrayList.toArray(new PostParameter[arrayList.size()]);
    }

    private PostParameter getParameterValue(String str, Boolean bool) {
        return new PostParameter(str, bool.booleanValue() ? "0" : "1");
    }

    public String toString() {
        return "Privacy [allUserCanComment=" + this.allUserCanComment + ", allUserCanMessage=" + this.allUserCanMessage + ", findByRealname=" + this.findByRealname + ", showGeo=" + this.showGeo + ", showBadge=" + this.showBadge + "]";
    }
}
