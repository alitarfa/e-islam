package eslami.dev.info.e_islami.Models;

import com.google.gson.annotations.SerializedName;

public class TitleModel {
    @SerializedName("title")
    private String title;

    public TitleModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
