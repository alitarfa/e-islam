package eslami.dev.info.e_islami.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * this Api Model for the API Interface of the Archive
 */
public class ApiModel {


    @SerializedName("d1")
   private String d1;

    @SerializedName("d2")
   private String d2;

    @SerializedName("dir")
   private String dir;

    @SerializedName("files")
   private List<FileModel> files;

    @SerializedName("files_count")
   private int files_count;



    @SerializedName("metadata")
   private MetaDataModel metadata;




    public ApiModel( String d1, String d2, String dir, List<FileModel> files, int files_count,   MetaDataModel metadata) {

        this.d1 = d1;
        this.d2 = d2;
        this.dir = dir;
        this.files = files;
        this.files_count = files_count;

        this.metadata = metadata;

    }



    public String getD1() {
        return d1;
    }

    public void setD1(String d1) {
        this.d1 = d1;
    }

    public String getD2() {
        return d2;
    }

    public void setD2(String d2) {
        this.d2 = d2;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public List<FileModel> getFiles() {
        return files;
    }

    public void setFiles(List<FileModel> files) {
        this.files = files;
    }

    public int getFiles_count() {
        return files_count;
    }

    public void setFiles_count(int files_count) {
        this.files_count = files_count;
    }

    public MetaDataModel getMetadata() {
        return metadata;
    }

    public void setMetadata(MetaDataModel metadata) {
        this.metadata = metadata;
    }


}
