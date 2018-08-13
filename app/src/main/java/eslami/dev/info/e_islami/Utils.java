package eslami.dev.info.e_islami;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;

import eslami.dev.info.e_islami.Models.ApiModel;
import eslami.dev.info.e_islami.Models.FileModel;

public class Utils {


    public static final String URL_BY_ID="https://archive.org/metadata";
    public static final String BASE_URL = "https://archive.org";

    /**
     * this method to get the random image from the drawable folder
     * @param context
     * @return
     */
    public static Drawable getRandomImage(Context context){

        Drawable listImages [] = {
                context.getResources().getDrawable(R.drawable.a),
                context.getResources().getDrawable(R.drawable.b),
                context.getResources().getDrawable(R.drawable.c),
                context.getResources().getDrawable(R.drawable.d),
                context.getResources().getDrawable(R.drawable.e),
                context.getResources().getDrawable(R.drawable.f),
                context.getResources().getDrawable(R.drawable.i),
                context.getResources().getDrawable(R.drawable.g),
                context.getResources().getDrawable(R.drawable.j),
                context.getResources().getDrawable(R.drawable.h),
                context.getResources().getDrawable(R.drawable.image_one)
        };

        int size =listImages.length;

       return  listImages[(int) (Math.random()*size)];
    }


    /**
     * this method for filter the item to mp3
     * @param fileModel
     * @return
     */

    public static ArrayList<FileModel> filterList(ArrayList<FileModel> fileModel){

        ArrayList<FileModel> models=new ArrayList<>();
        for (FileModel item : fileModel ) {
            if (item.getName().endsWith("mp3")){
                models.add(item);
            }
        }

        return models;
    }
}
