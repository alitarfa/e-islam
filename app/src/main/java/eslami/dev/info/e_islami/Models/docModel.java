package eslami.dev.info.e_islami.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class docModel {

   @SerializedName("format")
   private ArrayList<String> format;
   @SerializedName("title")
   private String title;

   @SerializedName("identifier")
   private String identifier;

   public docModel(ArrayList<String> format, String title, String identifier) {
      this.format = format;
      this.title = title;
      this.identifier = identifier;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public ArrayList<String> getFormat() {
      return format;
   }

   public void setFormat(ArrayList<String> format) {
      this.format = format;
   }

   public String getIdentifier() {
      return identifier;
   }

   public void setIdentifier(String identifier) {
      this.identifier = identifier;
   }
}
