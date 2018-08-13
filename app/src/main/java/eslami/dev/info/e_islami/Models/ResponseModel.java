package eslami.dev.info.e_islami.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {


    @SerializedName("numFound")
    private String numFound;

    @SerializedName("start")
    private String start;

    @SerializedName("docs")
    private List<docModel> docs;

    public ResponseModel(String numFound, String start, List<docModel> docs) {
        this.numFound = numFound;
        this.start = start;
        this.docs = docs;

    }


    public String getNumFound() {
        return numFound;
    }

    public void setNumFound(String numFound) {
        this.numFound = numFound;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public List<docModel> getDocs() {
        return docs;
    }

    public void setDocs(List<docModel> docs) {
        this.docs = docs;
    }
}
