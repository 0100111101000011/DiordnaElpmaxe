package volleyjson.hfad.com.maintenanceissue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Supplier> mySupplierList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.articles);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        // tworzymy źródło danych - tablicę z artykułami
        mySupplierList = new ArrayList<>();

        //dane do list abplanalp

        String[] supplier = {
                "Kitamura",
                "Ibarmia",
                "Juaristi",
                "Lagun",
                "Vision Wide",
                "OPS-Ingers oll",
                "Nakamura",
                "Geminis",
                "You Ji"
        };

        int [] supplierlogo={
                R.drawable.kitamura,
                R.drawable.ibarmialogo,
                R.drawable.juaristilog,
                R.drawable.logogoratulagun,
                R.drawable.visionwidelog,
                R.drawable.opsingersolllogo,
                R.drawable.logonakamuratome,
                R.drawable.nomuradslogo,
                R.drawable.geminislogo,
                R.drawable.youjilogo
        };

        for (int i=0; i<supplier.length; i++)
        {
            mySupplierList.add(new Supplier(supplier[i], supplierlogo[i]));
        }

        ImagesAdapter adapter = new ImagesAdapter(getApplicationContext(), mySupplierList);
        adapter.setListener(new ImagesAdapter.OnItemClickListener(){
            public void onClick(int position) {
                Intent intent = new Intent(MainActivity.this, SupplierDetails.class);
                intent.putExtra("activity", position);
                startActivity(intent);

            }
        });

        recyclerView.setAdapter(adapter);
    }
}

