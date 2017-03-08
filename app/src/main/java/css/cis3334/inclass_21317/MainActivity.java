package css.cis3334.inclass_21317;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import static css.cis3334.inclass_21317.R.id.spinnerXML;

public class MainActivity extends AppCompatActivity {

    TextView tvDisplay;
    Button button2;
    Button button3;
    Spinner spinnerJava;
    Spinner spinnerXML, spinnerCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //=========================================================
        tvDisplay = (TextView) findViewById(R.id.textViewDisplay);
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(buttonClick2);
        //=========================================================
        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Do something in response to button click
                tvDisplay.setText("Button Click 3 method called");
            }
        });
        //=========================================================
        spinnerJava = (Spinner) findViewById(R.id.SpinnerJava);
        ArrayList<String> items = new ArrayList<String>();
        items.add("Red");
        items.add("Green");
        items.add("Blue");
        items.add("Grey");
        items.add("Orange");
        items.add("Yellow");
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        // Specify the layout to use when the list of choices appears
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerJava.setAdapter(itemsAdapter);
        //------------
        spinnerJava.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvDisplay.setText("Spinner Java selected : "+ parent.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //--------------------------------------
        spinnerXML = (Spinner) findViewById(R.id.spinnerXML);
        spinnerXML.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tvDisplay.setText("Spinner XML selected : "+ parent.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });
        //=========================================================
        spinnerCustom = (Spinner) findViewById(R.id.spinnerCustom);
        ArrayList<Planet> planetList = new ArrayList<Planet>();
        // planet data from http://www.enchantedlearning.com/subjects/astronomy/planets/
        planetList.add(new Planet("Mercury", 57.9, 4800.0));
        planetList.add(new Planet("Venus", 108.2, 12104.0));
        planetList.add(new Planet("Mars", 227.9, 6787.0));
        planetList.add(new Planet("Pluto", 227.9, 6787.0));
        planetList.add(new Planet("Saturn", 227.9, 6787.0));
        planetList.add(new Planet("Uranus", 227.9, 6787.0));
        planetList.add(new Planet("Neptune", 227.9, 6787.0));
        planetList.add(new Planet("Earth", 227.9, 6787.0));
        PlanetAdapter planetAdapter = new PlanetAdapter(this, android.R.layout.simple_list_item_1, planetList);
        itemsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCustom.setAdapter(planetAdapter);


        //============================================================
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onButtonClick1(View view) {
        tvDisplay.setText("Button 1 clicked");
    }

    private View.OnClickListener buttonClick2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tvDisplay.setText("Button Click 2 method called");
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
