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

public class ErrorList extends AppCompatActivity {

    ArrayList<HashMap<String, String>>  errorList;
    private ListView viewListErrorList;

    // search listview
    EditText errorSearch;
    String[] errorName;
    SimpleAdapter adapterError;
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_list);

        errorList = new ArrayList<>();
        viewListErrorList = (ListView) findViewById(R.id.list_error);

        //example data

        String [] errorsName =
                {
                    "M01 Dog overrun 0001",
                    "M01 Some ax does not pass Z phase 0002",
                        "M01 R-pnt direction illegal 0003",
                        "M01 External interlock axis exists 0004",
                        "M01 Internal interlock axis exists 0005",
                    "M01 H/W stroke end axis exists 0006",
                        "M01 S/W stroke end axis exists 0007",
                        "M01 Chuck/tailstock stroke end ax 0008",
                        "M01 Ref point return No. invalid 0009",
                        "M01 Illegal op in mid pt sg block 0013",
                };
        String [] errorsDescription =
                {
                        "Szczegóły\n" +
                             "Podczas powrotu do pozycji referencyjnej ogranicznik wykrywający zbliżenie nie zatrzymał osi i minęła ona\n" +
                             "punkt.\n" +
                             "Czynności zaradcze\n" +
                             "Zwiększ długość obszaru zbliżenia do czujnika typu dog.\n" +
                             "Zmniejsz prędkość powrotu do pozycji referencyjnej.",
                        "Szczegóły\n" +
                                "Jedna z osi nie przeszła testu fazy Z podczas początkowego powrotu do pozycji referencyjnej po włączeniu\n" +
                                "zasilania.\n" +
                                "Czynności zaradcze\n" +
                                "Obróć detektor o jeden obrót lub więcej w kierunku przeciwnym do pozycji referencyjnej i ponownie wykonaj\n" +
                                "powrót do pozycji referencyjnej.",
                        "Szczegóły\n" +
                                "Podczas ręcznego powrotu do pozycji referencyjnej kierunek powrotu różni się od kierunku posuwu osi wybranej\n" +
                                "klawiszem wyboru osi.\n" +
                                "Czynności zaradcze\n" +
                                "Wybór kierunku +/ klawiszem wyboru osi jest nieprawidłowy. Błąd ten można skasować posuwając oś w\n" +
                                "prawidłowym kierunku.",
                        "Szczegóły\n" +
                                "Włączona została funkcja zewnętrznej blokady (sygnał wejściowy jest w stanie wyłączonym) i jedna z osi\n" +
                                "weszła w stan blokady.\n" +
                                "Czynności zaradcze\n" +
                                "Jako że włączona została funkcja blokady, przed wznowieniem pracy należy ją wyłączyć.\n" +
                                "Sprawdź sekwencję po stronie obrabiarki.\n" +
                                "Sprawdź czy linia sygnału blokady nie ma uszkodzonych przewodów.",
                        "Szczegóły\n" +
                                "Urządzenie weszło w stan blokady wewnętrznej.\n" +
                                "Oś detekcji pozycji bezwzględnej została usunięta.\n" +
                                "W trybie automatycznym wydano polecenie dla osi dopuszczającej jednocześnie polecenia w trybie automatycznym\n" +
                                "i ręcznym.\n" +
                                "Wydano ręczne polecenie prędkości gdy sygnał pomiaru długości narzędzia 1 był włączony.\n" +
                                "Wydano polecenie ruchu osi nachylonej, której oś podstawowa uczestniczy w synchronizacji osi sterowanej\n" +
                                "pomiędzy podsystemami.\n" +
                                "Wybrano oś inną niż pierwsza gdy wydano ręczne polecenie prędkości.\n" +
                                "Wydano polecenie ruchu dla osi zatrzymanej funkcją detekcji kolizji.\n" +
                                "Wydano polecenie pozycjonowania albo interpolacji w trybie sterowanie osią obrotową typu wrzeciona.\n" +
                                "Czynności zaradcze\n" +
                                "\uF073Włączono funkcję wyłączającą serwo, należy więc ją wpierw wyłączyć.\n" +
                                "\uF073Wyznaczono oś przeznaczoną do usunięcia, więc wykonaj czynności naprawcze.\n" +
                                "\uF073Wydano polecenie w tym samym kierunku, w którym włączyła się funkcja ręcznego przeskoku, więc wykonaj\n" +
                                "czynności naprawcze.\n" +
                                "\uF073Jednocześnie dozwolone były polecenia ręczne i automatyczne, więc oś obsługiwana w trybie automatycznym\n" +
                                "stała się osią obsługiwaną w trybie ręcznym. Wyłącz sygnał zezwalający na operacje ręczne i automatyczne\n" +
                                "dla tej osi.\n" +
                                "\uF073Ponownie włącz zasilanie i przeprowadź inicjalizację pozycji bezwzględnej.\n" +
                                "\uF073Wyłącz sygnał pomiaru długości narzędzia 1, by rozpocząć program ręcznym poleceniem prędkości.\n" +
                                "\uF073Wyłącz synchronizację osi sterowanej pomiędzy podsystemami, a potem wydaj polecenie ruchu dla osi\n" +
                                "nachylonej.\n" +
                                "\uF073Jeśli wydajesz ręczne polecenie prędkości, wybierz pierwszą oś w każdym podsystemie.\n" +
                                "\uF073Wyłącz alarm detekcji kolizji.\n" +
                                "\uF073Sprawdź program po wyłączeniu błędu za pomocą wyzerowania.",
                        "Szczegóły\n" +
                                "Aktywowana została funkcja końca obszaru pracy (sygnał wejściowy jest w stanie wyłączonym) i jedna z osi\n" +
                                "weszła w stan końca obszaru pracy.\n" +
                                "Czynności zaradcze\n" +
                                "\uF073Przesuń oś ręcznie.\n" +
                                "\uF073Sprawdź czy linia sygnału końca obszaru pracy nie ma uszkodzonych przewodów.\n" +
                                "\uF073Sprawdź czy nie ma uszkodzonych krańcówek.\n",
                        "Szczegóły\n" +
                                "Aktywowana została funkcja zapisanego końca obszaru pracy I, II, IIB albo IB.\n" +
                                "Czynności zaradcze\n" +
                                "\uF073Przesuń oś ręcznie.\n" +
                                "\uF073Popraw błędne ustawienia parametrów zapisanego końca obszaru pracy.",
                        "Szczegóły\n" +
                                "Aktywowana została funkcja konturu uchwytu/konika i jedna z osi weszła w stan końca obszaru pracy.\n" +
                                "Czynności zaradcze\n" +
                                "\uF073Wyłącz alarm przez wyzerowanie i przesuń oś w przeciwnym kierunku.",
                        "Szczegóły\n" +
                                "Wykonano powrót do drugiej pozycji referencyjnej przed zakończeniem powrotu do pierwszej pozycji referencyjnej.\n" +
                                "Czynności zaradcze\n" +
                                "\uF073Wykonaj powrót do pierwszej pozycji referencyjnej.",
                        "Szczegóły\n" +
                                "Tryb pracy został zmieniony na MDI w trybie zatrzymania pojedynczego bloku w punkcie pośrednim polecenia\n" +
                                "G28/G29/G30.\n" +
                                "Czynności zaradcze\n" +
                                "\uF073Zmień tryb pracy.\n" +
                                "\uF073Wyzeruj aby wyłączyć alarm.",
                };
        //kolekcja danych
        for (int i=0; i<errorsName.length; i++)
        {
            HashMap<String, String> details_Errorlist = new HashMap<>();
            details_Errorlist.put("errorsName", errorsName[i]);
            details_Errorlist.put("errorsDescription", errorsDescription[i]);
            errorList.add(details_Errorlist);
        }

        adapterError = new SimpleAdapter(
                ErrorList.this,errorList, R.layout.error_list_details,
                new String[] {"errorsName", "errorsDescription"},
                new int[] {R.id.error_list_details_name, R.id.error_list_details_description});
        viewListErrorList.setAdapter(adapterError);

        // search listview
        errorSearch=(EditText)findViewById(R.id.textSearchError);
        errorSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ErrorList.this.adapterError.getFilter().filter(charSequence);
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}


