package sreimerdevelopment.flickrbrowser;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by sreim on 7/11/2016.
 */
public class FlickrRecyclerViewAdapter extends RecyclerView.Adapter<FlickrImageViewHolder> {
    private List<Photo> photosList;
    private Context mContext;

    public FlickrRecyclerViewAdapter(List<Photo> photosList, Context mContext) {
        this.photosList = photosList;
        this.mContext = mContext;
    }

    @Override
    public FlickrImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate our layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.browse,null);
        FlickrImageViewHolder flickrImageViewHolder = new FlickrImageViewHolder(view);
        return flickrImageViewHolder;
    }

    @Override
    public int getItemCount() {
        return (null != photosList ? photosList.size() : 0);
    }

    @Override
    public void onBindViewHolder(FlickrImageViewHolder holder, int position) {
        Photo photoItem = photosList.get(position);
        Picasso.with(mContext).load(photoItem.getmImage())
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(holder.thumbnail);
        holder.title.setText(photoItem.getmTitle());
    }

    public void loadNewData(List<Photo> newPhotos) {
        photosList = newPhotos;
        notifyDataSetChanged();
    }
}
