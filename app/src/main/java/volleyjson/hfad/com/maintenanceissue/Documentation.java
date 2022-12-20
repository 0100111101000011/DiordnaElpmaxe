package volleyjson.hfad.com.maintenanceissue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class Documentation extends AppCompatActivity {

    ArrayList<HashMap<String, String>> documentation_details_name_variable;
    private ListView viewListDocumentation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_documentation);

        documentation_details_name_variable = new ArrayList<>();
        viewListDocumentation = (ListView) findViewById(R.id.list_documentation);


        AdapterView.OnItemClickListener itemClickListenerFDA= new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> viewListFDA,
                                    View v,
                                    int position,
                                    long id) {
                {
                    if (position==2){
                        Intent intent = new Intent(Documentation.this, ErrorList.class);
                        intent.putExtra("activity", position);
                        startActivity(intent);
                    }
                    else
                    {
                        Intent intentFDA = new Intent(Documentation.this, Partslist.class);
                        startActivity(intentFDA);
                    }
                }
            }
            };
        ListView viewListFDA = (ListView) findViewById(R.id.list_documentation);
                viewListFDA.setOnItemClickListener(itemClickListenerFDA);

        for (int i = 0; i < 1; i++)
        {
            HashMap<String, String> details_name_variable = new HashMap<>();
            details_name_variable.put("DocumentationTest", "Maintenance");
            documentation_details_name_variable.add(details_name_variable);
        }

        for (int i = 0; i < 1; i++)
        {
            HashMap<String, String> details_name_variable = new HashMap<>();
            details_name_variable.put("DocumentationTest","Partslist");
            documentation_details_name_variable.add(details_name_variable);
        }


        for (int i = 0; i < 1; i++)
        {
            HashMap<String, String> details_name_variable = new HashMap<>();
            details_name_variable.put("DocumentationTest", "Error");
            documentation_details_name_variable.add(details_name_variable);
        }


        ListAdapter adapterDocumentation = new SimpleAdapter(Documentation.this,
                                                            documentation_details_name_variable,
                                                            R.layout.documentation_details_layout,
                new String[]{"DocumentationTest"},
                new int[]{R.id.documentation_details_name});

        viewListDocumentation.setAdapter(adapterDocumentation);

    }
}
