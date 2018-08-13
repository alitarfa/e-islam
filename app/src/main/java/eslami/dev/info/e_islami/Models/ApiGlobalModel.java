package eslami.dev.info.e_islami.Models;

import com.google.gson.annotations.SerializedName;

public class ApiGlobalModel {



       @SerializedName("response")
       private ResponseModel response;

       public ApiGlobalModel(ResponseModel response) {
              this.response = response;
       }

       public ResponseModel getResponse() {
              return response;
       }

       public void setResponse(ResponseModel response) {
              this.response = response;
       }
}
