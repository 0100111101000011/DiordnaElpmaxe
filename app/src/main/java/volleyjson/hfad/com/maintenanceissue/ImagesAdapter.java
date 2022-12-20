package volleyjson.hfad.com.maintenanceissue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ImagesAdapterViewHolder>

{
    //this context we will use to inflate the layout
    private Context mCtx;
    //we are storing all the products in a list
    private List<Supplier> supplierList;

    //OnClick
    private OnItemClickListener listener;
    public static interface OnItemClickListener {
        public void onClick(int position);
    }

    public void setListener (OnItemClickListener listener){
        this.listener =listener;
    }
    //


    //getting the context and product list with constructor
    public ImagesAdapter(Context mCtx, List<Supplier> supplierList) {
        this.mCtx = mCtx;
        this.supplierList = supplierList;
    }

    @Override
    public ImagesAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.supplier_layout, null);
        return new ImagesAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImagesAdapterViewHolder holder, final int position) {
        //getting the product of the specified position
        Supplier product = supplierList.get(position);

        //binding the data with the viewholder views
        holder.info_text.setText(product.getTitle());
        holder.info_image.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

        //OnClick
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
        //
    }

    @Override
    public int getItemCount() {
        return supplierList.size();
    }

    class ImagesAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView  info_text;
        ImageView info_image;


        public ImagesAdapterViewHolder(View itemView) {
            super(itemView);

            info_text = itemView.findViewById(R.id.info_text);
            info_image = itemView.findViewById(R.id.info_image);

        }
    }
}
