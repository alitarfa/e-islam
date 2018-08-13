package eslami.dev.info.e_islami;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import eslami.dev.info.e_islami.Models.FileModel;

public class AdapterDetails  extends RecyclerView.Adapter<AdapterDetails.DetailsViewHolder> {

    private List<FileModel> list=new ArrayList<>();
    private Context context;
    private LayoutInflater inflater;
    private String dir;

    public AdapterDetails(Context context) {
        this.context = context;
        this.inflater=LayoutInflater.from(context);
    }

    public void setList(ArrayList<FileModel> list, String dir) {
        this.list = list;
        this.dir=dir;
    }




    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.item_play_list,viewGroup,false);

        return new DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder detailsViewHolder, final int i) {

        detailsViewHolder.card_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,PlayerMain.class);
                intent.putExtra("name",list.get(i).getName());
                intent.putExtra("dir",dir);
                context.startActivity(intent);
            }
        });

        detailsViewHolder.id_text_title.setText(list.get(i).getName());
        int msTime=Integer.parseInt(list.get(i).getMtime());
        int minTime=(msTime/1000)/60;
        detailsViewHolder.id_text_time.setText(String.valueOf(minTime));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder {

        public CardView card_item;
        public TextView id_text_title;
        public TextView id_text_desc;
        public TextView id_text_time;

        public DetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            card_item=itemView.findViewById(R.id.id_card_item);
            id_text_title=itemView.findViewById(R.id.id_text_title);

            id_text_time=itemView.findViewById(R.id.id_text_time);
        }
    }
}


