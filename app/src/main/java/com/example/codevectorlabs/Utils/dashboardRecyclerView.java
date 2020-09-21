package com.example.codevectorlabs.Utils;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.codevectorlabs.R;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;
import com.example.codevectorlabs.Database.model.post;
import com.squareup.picasso.Picasso;

public class dashboardRecyclerView extends RecyclerView.Adapter<dashboardRecyclerView.dashboardViewHolder> {

    class dashboardViewHolder extends RecyclerView.ViewHolder {
        CircleImageView profileImage;
        TextView myNameTextView,uploadedTimeTextView,postCaptionTextView;
        ImageView uploadedImage;
        private dashboardViewHolder(View itemView) {
            super(itemView);
            profileImage = itemView.findViewById(R.id.profile_image);
            myNameTextView = itemView.findViewById(R.id.myNameTextView);
            uploadedImage = itemView.findViewById(R.id.uploadedImage);
            uploadedTimeTextView = itemView.findViewById(R.id.uploadedTimeTextView); //
            postCaptionTextView = itemView.findViewById(R.id.postCaptionTextView);
        }
    }


    private final LayoutInflater mInflater;
    public dashboardRecyclerView(Context context , ArrayList<post> p) {
        mInflater = LayoutInflater.from(context);
        allPosts = p;
    }

    private ArrayList<post> allPosts;


    @Override
    public dashboardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.dashboard_item, parent, false);
        return new dashboardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(dashboardViewHolder holder, int position) {
        if (allPosts != null) {
            post current = allPosts.get(position);
            Picasso.get().load(Uri.parse(current.getProfileImage())).noPlaceholder().centerCrop().fit().into(holder.profileImage);
            Picasso.get().load(Uri.parse(current.getUploadedImage())).noPlaceholder().centerCrop().fit().into(holder.uploadedImage);
            holder.myNameTextView.setText(current.getName());
            holder.postCaptionTextView.setText(current.getCaption());
            holder.uploadedTimeTextView.setText("Uploaded at - " + current.getUploadingTime());
        }
    }

    @Override
    public int getItemCount() {
        if (allPosts != null)
            return allPosts.size();
        else return 0;
    }
}
