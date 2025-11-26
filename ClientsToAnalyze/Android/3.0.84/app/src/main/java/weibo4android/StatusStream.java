package weibo4android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import weibo4android.http.Response;
import weibo4android.org.json.JSONException;

/* loaded from: classes.dex */
public class StatusStream {

    /* renamed from: br */
    private BufferedReader f13754br;

    /* renamed from: is */
    private InputStream f13755is;
    private Response response;
    private boolean streamAlive;

    StatusStream(InputStream inputStream) {
        this.streamAlive = true;
        this.f13755is = inputStream;
        this.f13754br = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
    }

    StatusStream(Response response) {
        this(response.asStream());
        this.response = response;
    }

    public Status next() throws IOException, WeiboException {
        if (!this.streamAlive) {
            throw new IllegalStateException("Stream already closed.");
        }
        while (this.streamAlive) {
            try {
                String line = this.f13754br.readLine();
                if (line != null && line.length() > 0) {
                    try {
                        return new Status(line);
                    } catch (JSONException e) {
                    }
                }
            } catch (IOException e2) {
                try {
                    this.f13755is.close();
                } catch (IOException e3) {
                }
                this.streamAlive = false;
                throw new WeiboException("Stream closed.", e2);
            }
        }
        throw new WeiboException("Stream closed.");
    }

    public void close() throws IOException {
        this.f13755is.close();
        this.f13754br.close();
        if (this.response != null) {
            this.response.disconnect();
        }
    }
}
