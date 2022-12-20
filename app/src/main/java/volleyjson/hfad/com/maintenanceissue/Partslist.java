package volleyjson.hfad.com.maintenanceissue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Partslist extends AppCompatActivity {

    ArrayList<HashMap<String, String>>  KitamuraPartslist;
    private ListView viewListPartslist;

    // search listview
    EditText text;
    String[] parts = {
            " AIR CIRCUIT",
            " HYDRAULIC CIRCUIT",
            " BED・SADDLE ASSEMBLY ",
            " COLUMN ASSEMBLY ",
            " HEAD ASSEMBLY ",
            " X-AXIS FEED ASSEMBLY",
            " Y-AXIS FEED ASSEMBLY ",
            " Z-AXIS FEED ASSEMBLY ",
            " TABLE ASSEMBLY ",
            " PALLET TABLE ASSEMBLY ",
            " 50ATC MAGAZINE ASSEMBLY ",
            " 100ATC MAGAZINE ASSEMBLY ",
            " ATC UNIT ASSEMBLY ",
            " AUTO PALLET CHANGER ASSEMBLY",
            " APC YAGURA ASSEMBLY ",
            " ATC DOOR ASSEMBLY ",
            " CABLE DUCT ASSEMBLY ",
            " Z-AXIS COVER ASSEMBLY ",
            " SPLASH GUARD ASSEMBLY ",
            " X-Y COVER ASSEMBLY ",
            " APC SAFETY GUARD ASSEMBLY ",
            " 100ATC MAGAZINE COVER ASSEMBLY ",
            " MACHINE CHIP CONVEYOR ASSEMBLY ",
            " COOLANT TANK ASSEMBLY ",
            " FRONT OIL PAN ASSEMBLY ",
            " X-AXIS SCALE ASSEMBLY ",
            " Y-AXIS SCALE ASSEMBLY ",
            " Z-AXIS SCALE ASSEMBLY ",
            " SKIRT ASSEMBLY ",
            " OPERATION BOX ASSEMBLY ",
            " OPERATION PANEL PARTS LIST ",
            " OPERATION PANEL PARTS LIST1 ",
            " OPERATION PANEL PARTS LIST2 ",
            " OPERATION PANEL PARTS LIST3 ",
            " OPERATION PANEL PARTS LIST4 ",
            " CONTROL BOX LAYOUT "
    };
    SimpleAdapter  adapterDocumentation;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partslist);

        KitamuraPartslist = new ArrayList<>();
        viewListPartslist = (ListView) findViewById(R.id.list_partslist);

        //dane do list

        for (int i=0; i<parts.length; i++)
        {
            HashMap<String, String> details_Partslist = new HashMap<>();
            details_Partslist.put("KitamuraPartslist", parts[i]);
            KitamuraPartslist.add(details_Partslist);
        }

         adapterDocumentation = new SimpleAdapter(Partslist.this,
                KitamuraPartslist,
                R.layout.documentation_details_layout,new String[]{"KitamuraPartslist"},
                new int[]{R.id.documentation_details_name});

        viewListPartslist.setAdapter(adapterDocumentation);

        // search listview
        text=(EditText)findViewById(R.id.textSearch);

        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    //search clas
                 Partslist.this.adapterDocumentation.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        AdapterView.OnItemClickListener viewListPartslistParts= new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> viewListFDA,
                                    View v,
                                    int position,
                                    long id) {
                {

                    Intent intentFDA = new Intent(Partslist.this, Drawing.class);
                    startActivity(intentFDA);
                }
            }
        };
        ListView viewListFDA = (ListView) findViewById(R.id.list_partslist);
        viewListPartslist.setOnItemClickListener(viewListPartslistParts);
    }



}

