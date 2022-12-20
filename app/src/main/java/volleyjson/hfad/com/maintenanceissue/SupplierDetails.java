package volleyjson.hfad.com.maintenanceissue;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SupplierDetails extends AppCompatActivity {
    List<SupplierMachines> Kitamura, Ibarmia, Juaristi, Lagun, VisionWide, OPSIngersoll, Nakamura, Nomura, Geminis, YouJi, SupplierName;
    RecyclerView recyclerViewDetails;

    public int supplierNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.machines);

        //intecja odebranie
        Bundle bundle = getIntent().getExtras();
        supplierNumber = bundle.getInt("activity");

        recyclerViewDetails = (RecyclerView) findViewById(R.id.machines);
        // w celach optymalizacji
        recyclerViewDetails.setHasFixedSize(true);
        // ustawiamy LayoutManagera
        recyclerViewDetails.setLayoutManager(new LinearLayoutManager(this));
        // ustawiamy animatora, który odpowiada za animację dodania/usunięcia elementów listy
        recyclerViewDetails.setItemAnimator(new DefaultItemAnimator());
        SupplierName = new ArrayList<>();

        // tworzymy źródło danych
        if (supplierNumber==0)
        {
            Kitamura = new ArrayList<>();
            Kitamura.add(new SupplierMachines("Mycenter 2XD SP"));
            Kitamura.add(new SupplierMachines("Mycenter 3XD"));
            Kitamura.add(new SupplierMachines("Mycenter 4XiD"));
            Kitamura.add(new SupplierMachines("Bridgecenter 6G"));
            Kitamura.add(new SupplierMachines("Bridgecenter 8G"));
            Kitamura.add(new SupplierMachines("Mycenter HX250 G"));
            Kitamura.add(new SupplierMachines("Mycenter HX400 G"));
            Kitamura.add(new SupplierMachines("Mycenter HX500 G"));
            Kitamura.add(new SupplierMachines("Mycenter HX630 G"));
            Kitamura.add(new SupplierMachines("Mycenter HX800 G"));
            Kitamura.add(new SupplierMachines("Mycenter HX1000i"));
            Kitamura.add(new SupplierMachines("Mycenter HX1250i"));
            Kitamura.add(new SupplierMachines("Mytrunnion 4G"));
            Kitamura.add(new SupplierMachines("Mytrunnion 5"));
            Kitamura.add(new SupplierMachines("Mytrunnion 7G"));

            SupplierName = Kitamura;

        }

        if (supplierNumber==1)
        {
            Ibarmia = new ArrayList<>();
            Ibarmia.add(new SupplierMachines("ZVH Extreme"));
            Ibarmia.add(new SupplierMachines("ZVH Multiprocess"));
            Ibarmia.add(new SupplierMachines("ZV Extreme"));
            Ibarmia.add(new SupplierMachines("ZV Classic"));
            Ibarmia.add(new SupplierMachines("THC Extreme"));
            Ibarmia.add(new SupplierMachines("THC Multiprocess"));
            SupplierName = Ibarmia;
        }

        if (supplierNumber==2)
        {
            Juaristi = new ArrayList<>();
            Juaristi.add(new SupplierMachines("Juaristi TX1"));
            Juaristi.add(new SupplierMachines("Juaristi TX3"));
            Juaristi.add(new SupplierMachines("Juaristi TX7"));
            Juaristi.add(new SupplierMachines("Juaristi TS5"));
            Juaristi.add(new SupplierMachines("Juaristi MX5/MX5RAM"));
            Juaristi.add(new SupplierMachines("Juaristi MX7/MX7RAM"));
            Juaristi.add(new SupplierMachines("Juaristi MX9RAM"));
            Juaristi.add(new SupplierMachines("Juaristi MP5RAM"));
            Juaristi.add(new SupplierMachines("Juaristi MP6RAM"));
            Juaristi.add(new SupplierMachines("Juaristi MP7RAM"));
            Juaristi.add(new SupplierMachines("Juaristi MP9RAM"));
            Juaristi.add(new SupplierMachines("Juaristi MP10RAM"));
            SupplierName = Juaristi;
        }

        if (supplierNumber==3)
        {
            Lagun = new ArrayList<>();
            Lagun.add(new SupplierMachines("Lagun | GBR 2"));
            Lagun.add(new SupplierMachines("Lagun | GTM 2"));
            Lagun.add(new SupplierMachines("Lagun | GCM"));
            Lagun.add(new SupplierMachines("Lagun | GMM"));
            Lagun.add(new SupplierMachines("Lagun | GML"));
            Lagun.add(new SupplierMachines("Lagun | GMP"));
            Lagun.add(new SupplierMachines("Lagun | GBR 3"));
            Lagun.add(new SupplierMachines("Lagun | GBR 4"));
            Lagun.add(new SupplierMachines("Lagun | GBR 5"));
            Lagun.add(new SupplierMachines("Lagun | GTM 3"));
            Lagun.add(new SupplierMachines("Lagun | GTM 4"));
            SupplierName = Lagun;
        }

        if (supplierNumber==4)
        {
            VisionWide  = new ArrayList<>();
            VisionWide.add(new SupplierMachines("Seria SE"));
            VisionWide.add(new SupplierMachines("Seria SF"));
            VisionWide.add(new SupplierMachines("Seria NF"));
            VisionWide.add(new SupplierMachines("Seria HF"));
            VisionWide.add(new SupplierMachines("Seria VB"));
            VisionWide.add(new SupplierMachines("Seria VF"));
            VisionWide.add(new SupplierMachines("Seria BM"));
            VisionWide.add(new SupplierMachines("Seria GS"));
            VisionWide.add(new SupplierMachines("Seria FA"));
            SupplierName = VisionWide;
        }

        if (supplierNumber==5)
        {
            OPSIngersoll = new ArrayList<>();
            OPSIngersoll.add(new SupplierMachines("Eagle V5"));
            OPSIngersoll.add(new SupplierMachines("SpeedHawk550"));
            OPSIngersoll.add(new SupplierMachines("SpeedHawk650"));
            OPSIngersoll.add(new SupplierMachines("Eagle V9"));
            SupplierName = OPSIngersoll;
        }

        if (supplierNumber==6)
        {
            Nakamura = new ArrayList<>();
            Nakamura.add(new SupplierMachines("AS-200L"));
            Nakamura.add(new SupplierMachines("AS-200L"));
            Nakamura.add(new SupplierMachines("SC-450LL"));
            Nakamura.add(new SupplierMachines("SC-450L"));
            Nakamura.add(new SupplierMachines("SC-450"));
            Nakamura.add(new SupplierMachines("SC-300L"));
            Nakamura.add(new SupplierMachines("SC-300 II"));
            Nakamura.add(new SupplierMachines("SC-250"));
            Nakamura.add(new SupplierMachines("SC-200L"));
            Nakamura.add(new SupplierMachines("SC-200"));
            Nakamura.add(new SupplierMachines("TW-30"));
            Nakamura.add(new SupplierMachines("TW-20"));
            Nakamura.add(new SupplierMachines("TW-8"));
            Nakamura.add(new SupplierMachines("WT-300"));
            Nakamura.add(new SupplierMachines("WT-250II"));
            Nakamura.add(new SupplierMachines("WT-150II"));
            Nakamura.add(new SupplierMachines("WT-100"));
            Nakamura.add(new SupplierMachines("WY-150"));
            Nakamura.add(new SupplierMachines("WY-100"));
            Nakamura.add(new SupplierMachines("NTY3-250"));
            Nakamura.add(new SupplierMachines("NTY3-150"));
            Nakamura.add(new SupplierMachines("NTY3-100"));
            Nakamura.add(new SupplierMachines("WTW-150"));
            Nakamura.add(new SupplierMachines("NTJ-100"));
            Nakamura.add(new SupplierMachines("Super NTJX"));
            Nakamura.add(new SupplierMachines("Super NTX"));
            Nakamura.add(new SupplierMachines("Super NTMXL"));
            Nakamura.add(new SupplierMachines("Super NTMX"));
            Nakamura.add(new SupplierMachines("NTRX-300L"));
            Nakamura.add(new SupplierMachines("NTRX-300"));
            SupplierName = Nakamura;
        }

        if (supplierNumber==7)
        {
            Nomura = new ArrayList<>();
            Nomura.add(new SupplierMachines("NN-10EK"));
            Nomura.add(new SupplierMachines("NN-10EX"));
            Nomura.add(new SupplierMachines("NN-16SB6"));
            Nomura.add(new SupplierMachines("NN-16SB7"));
            Nomura.add(new SupplierMachines("NN-16J2"));
            Nomura.add(new SupplierMachines("NN-16J3"));
            Nomura.add(new SupplierMachines("NN-20J3 XB"));
            Nomura.add(new SupplierMachines("NN-20J3"));
            Nomura.add(new SupplierMachines("NN-20J2"));
            Nomura.add(new SupplierMachines("NN-20U5"));
            Nomura.add(new SupplierMachines("NN-25U5"));
            Nomura.add(new SupplierMachines("NN-20UB8"));
            Nomura.add(new SupplierMachines("NN-25UB8"));
            Nomura.add(new SupplierMachines("NN-32UB8/K/K2"));
            Nomura.add(new SupplierMachines("NN-20UB8K"));
            Nomura.add(new SupplierMachines("NN-20UB8K2"));
            Nomura.add(new SupplierMachines("NN-25UB8K"));
            Nomura.add(new SupplierMachines("NN-25YB3"));
            Nomura.add(new SupplierMachines("NN-32YB3"));
            Nomura.add(new SupplierMachines("NN-32UB8"));
            Nomura.add(new SupplierMachines("NN-32YB2"));
            Nomura.add(new SupplierMachines("NN-32YB2 XB"));
            Nomura.add(new SupplierMachines("NN-32YB3 XB"));
            SupplierName = Nomura;
        }

        if(supplierNumber==8)
        {
            Geminis = new ArrayList<>();
            Geminis.add(new SupplierMachines("Geminis | GT5 G2"));
            Geminis.add(new SupplierMachines("Geminis | GT5 G4"));
            Geminis.add(new SupplierMachines("Geminis | GT7 G2"));
            Geminis.add(new SupplierMachines("Geminis | GT7 G4"));
            Geminis.add(new SupplierMachines("Geminis | GHT9 G2"));
            Geminis.add(new SupplierMachines("Geminis | GHT9 G4"));
            Geminis.add(new SupplierMachines("Geminis | GHT11 G2"));
            Geminis.add(new SupplierMachines("Geminis | GHT11 G4"));
            Geminis.add(new SupplierMachines("Geminis | GHT12 DB"));
            SupplierName = Geminis;
        }

        if (supplierNumber==9)
        {
            YouJi  = new ArrayList<>();
            YouJi.add(new SupplierMachines("You Ji | YV200"));
            YouJi.add(new SupplierMachines("You Ji | YV250"));
            YouJi.add(new SupplierMachines("You Ji | YV320"));
            YouJi.add(new SupplierMachines("You Ji | YV420"));
            YouJi.add(new SupplierMachines("You Ji | YV500"));
            YouJi.add(new SupplierMachines("You Ji | YV550"));
            YouJi.add(new SupplierMachines("You Ji | YV600"));
            YouJi.add(new SupplierMachines("You Ji | YV700"));
            YouJi.add(new SupplierMachines("You Ji | YV800"));
            YouJi.add(new SupplierMachines("You Ji | YV1000"));
            YouJi.add(new SupplierMachines("You Ji | YV1200"));
            YouJi.add(new SupplierMachines("You Ji | YV1600"));
            YouJi.add(new SupplierMachines("You Ji | VTL1000"));
            YouJi.add(new SupplierMachines("You Ji | VTL1200"));
            YouJi.add(new SupplierMachines("You Ji | VTL1600"));
            YouJi.add(new SupplierMachines("You Ji | VTL2000"));
            YouJi.add(new SupplierMachines("You Ji | VTL2500"));
            YouJi.add(new SupplierMachines("You Ji | VTL3000"));
            YouJi.add(new SupplierMachines("You Ji | VTL3500"));
            YouJi.add(new SupplierMachines("You Ji | VTL4000"));
            YouJi.add(new SupplierMachines("You Ji | VTL4500"));
            YouJi.add(new SupplierMachines("You Ji | VTH3000"));
            YouJi.add(new SupplierMachines("You Ji | VTH3500"));
            YouJi.add(new SupplierMachines("You Ji | VTH4000"));
            YouJi.add(new SupplierMachines("You Ji | VTH4500"));
            YouJi.add(new SupplierMachines("You Ji | VTH5000"));
            YouJi.add(new SupplierMachines("You Ji | VTH6000"));
            YouJi.add(new SupplierMachines("You Ji | VTH7000"));
            YouJi.add(new SupplierMachines("You Ji | VTH8000"));
            SupplierName = YouJi;
        }
        final SupplierDetailsAdapter adapter = new SupplierDetailsAdapter(getApplicationContext() ,SupplierName);
        adapter.setListener(new SupplierDetailsAdapter.OnItemClickListener(){
            public void onClick(int position) {

                    Intent intent = new Intent(SupplierDetails.this,
                            Documentation.class);
                    intent.putExtra("activity", position);
                    startActivity(intent);

            }
        });

        recyclerViewDetails.setAdapter(adapter);

    }
}
