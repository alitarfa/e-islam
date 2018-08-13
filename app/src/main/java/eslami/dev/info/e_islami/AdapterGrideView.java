package eslami.dev.info.e_islami;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import eslami.dev.info.e_islami.Models.ApiGlobalModel;
import eslami.dev.info.e_islami.Models.docModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdapterGrideView extends RecyclerView.Adapter<AdapterGrideView.GridViewHolder> {

    private List<docModel> list=new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;

    public AdapterGrideView(Context context) {
        this.context = context;
        this.inflater=LayoutInflater.from(context);
    }

    public void setList(ArrayList<docModel> list) {
        this.list = list;
    }



    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.item_play_list_grid,viewGroup,false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, final int i) {

        /**
         * set title
         */

        gridViewHolder.id_text_title_card_playlist.setText(list.get(i).getTitle());

        /**
         * this for the set the image of the cards background
         */

        gridViewHolder.id_image_below_card.setImageDrawable(Utils.getRandomImage(context));

        /**
         * this for the press on card ^_^ that is mean the  play list
         */
        gridViewHolder.card_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(context,detailsActivity.class);
                intent.putExtra("identifier",list.get(i).getIdentifier());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {

        public CardView card_item;
        public ImageView id_image_below_card;
        public TextView id_text_title_card_playlist;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            card_item=itemView.findViewById(R.id.card_item);
            id_image_below_card=itemView.findViewById(R.id.id_image_below_card);
            id_text_title_card_playlist=itemView.findViewById(R.id.id_text_title_card_playlist);

        }
    }


}
