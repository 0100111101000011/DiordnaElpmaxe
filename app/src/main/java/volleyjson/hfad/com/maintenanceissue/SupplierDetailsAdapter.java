package volleyjson.hfad.com.maintenanceissue;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;



public class SupplierDetailsAdapter extends RecyclerView.Adapter<SupplierDetailsAdapter.SupplierDetailsAdapterViewHolder>{

    //this context we will use to inflate the layout
    private Context mCtx;
    private List<SupplierMachines> Machines;

    //on clik
    private OnItemClickListener listener;
    public static interface OnItemClickListener {
        public void onClick(int position);
    }
    public void setListener (OnItemClickListener listener){
        this.listener =listener;
    }


    //getting the context and product list with constructor
    public SupplierDetailsAdapter(Context mCtx, List<SupplierMachines> Machines) {
        this.mCtx = mCtx;
        this.Machines = Machines;
    }

    @Override
    public SupplierDetailsAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_supplier_details, null);
        return new SupplierDetailsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SupplierDetailsAdapterViewHolder holder, final int position) {
        //getting the product of the specified position
        SupplierMachines machines = Machines.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(machines.getTitle());
        //on clik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Machines.size();
    }

    class SupplierDetailsAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle;

        public SupplierDetailsAdapterViewHolder (View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.machines_title);
        }

    }
}
