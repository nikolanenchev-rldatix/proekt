package com.example.proekt;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.cityViewHolder> {

    private int cityrowLayout;
    private final Context cityContext;
    private final RecyclerViewClickListener listener;
    DBHelper myDB;
    String user;

    public MyAdapter(Context ct, DBHelper mDB,int rowlayout,RecyclerViewClickListener listener, String user) {
        this.cityrowLayout = rowlayout;
        this.cityContext = ct;
        this.listener = listener;
        myDB = mDB;
        this.user = user;
    }
    public class cityViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {

        public TextView cityName;
        public ImageView cityPic;
        public Button rsrvButton;

        public cityViewHolder(final View itemView) {
            super(itemView);
            cityName = (TextView) itemView.findViewById(R.id.myText1);
            cityPic = (ImageView) itemView.findViewById(R.id.myImageView);
            rsrvButton = (Button) itemView.findViewById(R.id.rsrvbutton);
            rsrvButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ReservationForm.class);
                    intent.putExtra("cityname", cityName.getText());
                    intent.putExtra("username", user);
                    v.getContext().startActivity(intent);
                }
            });

        }
        @Override
        public void onClick(View v){
            listener.onClick(itemView, getAdapterPosition());
        }
    }
    @Override
    public MyAdapter.cityViewHolder onCreateViewHolder(ViewGroup parent, int i){
        View v=LayoutInflater.from(parent.getContext()).inflate(cityrowLayout,parent,false);
        return new cityViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final cityViewHolder viewHolder, final int position){

        City current =  myDB.query(position);

        viewHolder.cityName.setText(current.getCityName());

        if(viewHolder.cityName.getText().equals("Скопје") ) {
            viewHolder.cityPic.setImageResource(R.drawable.skopje);
        }
        else if(viewHolder.cityName.getText().equals("Велес") ){
            viewHolder.cityPic.setImageResource(R.drawable.veles);
        }

        else if(viewHolder.cityName.getText().equals("Струмица")) {
            viewHolder.cityPic.setImageResource(R.drawable.strumica);
        }
        else if(viewHolder.cityName.getText().equals( "Битола") ){
            viewHolder.cityPic.setImageResource(R.drawable.bitola);
        }

        else if(viewHolder.cityName.getText().equals( "Охрид")) {
            viewHolder.cityPic.setImageResource(R.drawable.ohrid);
        }
        else if(viewHolder.cityName.getText().equals("Гостивар")) {
            viewHolder.cityPic.setImageResource(R.drawable.gostivar);
        }
        else if(viewHolder.cityName.getText().equals("Тетово")) {
            viewHolder.cityPic.setImageResource(R.drawable.tetovo);
        }
        final cityViewHolder h = viewHolder;

        viewHolder.cityName.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView tv = (TextView) v;
                Toast.makeText(cityContext, tv.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public int getItemCount(){
        return (int) myDB.count();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }
}
