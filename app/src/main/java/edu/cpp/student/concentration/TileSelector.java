package edu.cpp.student.concentration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TileSelector extends AppCompatActivity
{
    private Spinner spinner;
    private String[] tileNumber = new String[] {"4","6","8","10","12","14","16","18","20"};
    private List<String> tilesList;
    private Button okayButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tile_selector);
        spinner = (Spinner) findViewById(R.id.spinner);
        tilesList = new ArrayList<String>(Arrays.asList(tileNumber));
        okayButton = (Button) findViewById(R.id.ok);
        ArrayAdapter<String> adp= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,tilesList);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adp);

        okayButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String text = spinner.getSelectedItem().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", Integer.valueOf(text));
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
        });

    }


}
