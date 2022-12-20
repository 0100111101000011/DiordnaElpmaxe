package volleyjson.hfad.com.maintenanceissue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Maintenance extends AppCompatActivity{

    ArrayList<HashMap<String, String>> maintenanceList;
    private ListView viewListMaintenanceList;

    // search listview
    EditText maintenanceSearch;
    //String[] maintenanceName;
    SimpleAdapter adapterMaintenance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);

        maintenanceList = new ArrayList<>();
        viewListMaintenanceList = (ListView) findViewById(R.id.maintenancelist);

        //dane
        String [] maintenanceName =
                {
                        ""
                };
        String [] maintenanceDescription =
                {
                        "",
                };

        //kolekcja danych
        for (int i=0; i<maintenanceName.length; i++)
        {
            HashMap<String, String> details_Errorlist = new HashMap<>();
            details_Errorlist.put("maintenanceName", maintenanceName[i]);
            details_Errorlist.put("maintenanceDescription", maintenanceDescription[i]);
            maintenanceList.add(details_Errorlist);
        }

        adapterMaintenance = new SimpleAdapter(
                Maintenance.this,maintenanceList, R.layout.error_list_details,
                new String[] {"errorsName", "errorsDescription"},
                new int[] {R.id.error_list_details_name, R.id.error_list_details_description});
        viewListMaintenanceList.setAdapter(adapterMaintenance);

        // search listview
        maintenanceSearch=(EditText)findViewById(R.id.textSearchError);

        maintenanceSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Maintenance.this.adapterMaintenance.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}


