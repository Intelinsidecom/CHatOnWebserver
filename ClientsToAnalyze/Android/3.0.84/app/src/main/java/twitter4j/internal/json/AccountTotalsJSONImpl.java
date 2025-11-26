package twitter4j.internal.json;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONObject;
import twitter4j.AccountTotals;
import twitter4j.conf.Configuration;
import twitter4j.internal.http.HttpResponse;
import twitter4j.internal.util.z_T4JInternalParseUtil;

/* loaded from: classes.dex */
class AccountTotalsJSONImpl extends TwitterResponseImpl implements Serializable, AccountTotals {
    private static final long serialVersionUID = -2291419345865627123L;
    private final int favorites;
    private final int followers;
    private final int friends;
    private final int updates;

    private AccountTotalsJSONImpl(HttpResponse httpResponse, JSONObject jSONObject) {
        super(httpResponse);
        this.updates = z_T4JInternalParseUtil.getInt("updates", jSONObject);
        this.followers = z_T4JInternalParseUtil.getInt("followers", jSONObject);
        this.favorites = z_T4JInternalParseUtil.getInt("favorites", jSONObject);
        this.friends = z_T4JInternalParseUtil.getInt("friends", jSONObject);
    }

    AccountTotalsJSONImpl(HttpResponse httpResponse, Configuration configuration) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this(httpResponse, httpResponse.asJSONObject());
        if (configuration.isJSONStoreEnabled()) {
            DataObjectFactoryUtil.clearThreadLocalMap();
            DataObjectFactoryUtil.registerJSONObject(this, httpResponse.asJSONObject());
        }
    }

    AccountTotalsJSONImpl(JSONObject jSONObject) {
        this((HttpResponse) null, jSONObject);
    }

    @Override // twitter4j.AccountTotals
    public int getUpdates() {
        return this.updates;
    }

    @Override // twitter4j.AccountTotals
    public int getFollowers() {
        return this.followers;
    }

    @Override // twitter4j.AccountTotals
    public int getFavorites() {
        return this.favorites;
    }

    @Override // twitter4j.AccountTotals
    public int getFriends() {
        return this.friends;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AccountTotalsJSONImpl accountTotalsJSONImpl = (AccountTotalsJSONImpl) obj;
        return this.favorites == accountTotalsJSONImpl.favorites && this.followers == accountTotalsJSONImpl.followers && this.friends == accountTotalsJSONImpl.friends && this.updates == accountTotalsJSONImpl.updates;
    }

    public int hashCode() {
        return (((((this.updates * 31) + this.followers) * 31) + this.favorites) * 31) + this.friends;
    }

    public String toString() {
        return new StringBuffer().append("AccountTotalsJSONImpl{updates=").append(this.updates).append(", followers=").append(this.followers).append(", favorites=").append(this.favorites).append(", friends=").append(this.friends).append('}').toString();
    }
}
