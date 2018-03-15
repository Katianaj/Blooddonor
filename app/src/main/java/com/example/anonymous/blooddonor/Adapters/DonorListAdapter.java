package com.example.anonymous.blooddonor.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.anonymous.blooddonor.Models.Donor;
import com.example.anonymous.blooddonor.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anonymous on 9/21/2017.
 */

public class DonorListAdapter extends RecyclerView.Adapter<DonorListAdapter.ViewHolder> {

    Context context;
    List<Donor>donorList;


    public DonorListAdapter(List<Donor>donorList,Context context) {
        super();
        this.context = context;
        this.donorList=donorList;
    }

    public void addData(List<Donor> data) {
        this.donorList.addAll(data);
        notifyDataSetChanged();

    }

    @Override
    public DonorListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.donor_list,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DonorListAdapter.ViewHolder holder, int position) {
         Donor donor=donorList.get(position);
         holder.mFirstname.setText(donor.getFname());
         holder.mLastname.setText(donor.getLname());
    }

    @Override
    public int getItemCount() {

        return donorList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

       public TextView mFirstname,mLastname;
       public Button mViewmoreBtn;

        public ViewHolder(View itemView) {
            super(itemView);

            mFirstname=(TextView)itemView.findViewById(R.id.mFirstName);
            mLastname=(TextView)itemView.findViewById(R.id.mLastName);
            mViewmoreBtn=(Button) itemView.findViewById(R.id.mViewMore);
        }
    }
}
