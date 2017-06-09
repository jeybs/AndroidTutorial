package com.jb.androidtutorial.ui.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jb.androidtutorial.R;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> mNameList;
    private RecyclerListCallback mCallback;

    public RecyclerViewAdapter(Context context, List<String> nameList, RecyclerListCallback callback) {
        mContext = context;
        mNameList = nameList;
        mCallback = callback;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_row_names, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final String name = mNameList.get(position);

        holder.nameText.setText(name.toUpperCase());
        holder.relativeContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onItemClick(name);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNameList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nameText;
        RelativeLayout relativeContainer;

        public MyViewHolder(View itemView) {
            super(itemView);
            nameText = (TextView) itemView.findViewById(R.id.text_name);
            relativeContainer = (RelativeLayout) itemView.findViewById(R.id.relative_container);
        }
    }

}
