package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;



public class hjy_main extends Activity  {

    private Gallery galleryM,galleryS ;
    private EditText recipeName;
    private TextView outputRecipeName, outputMaterials,outputSeasons;
    private Context mContext = null;
    private Button cancelRecipe, createRecipe;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        cll_exit.getInstance().addActivity(this);
        super .onCreate(savedInstanceState);
        setContentView(R.layout.hjy_main );
        mContext = this;
        hjy_adapter adapter = new hjy_adapter( this );
        hjy_dadpter_seasons adapters = new hjy_dadpter_seasons(this);
        final String materials[] = {
                "bacon","balsam pear","beef","carrot","celery","checken","checken breast",
                "chinese cabbage","corn","drumstick","egg","eggplant","fish","leek",
                "lettuce","tomato","mushroom","potapo","pumpkin","rice","shrimp",};
        final String seasons[] = {
                "chilli","cinnamon","cumin","curry","garlic","ginger","onion",
                "rosemary","salt","shallot","soy sauce","star anise","sugar","tsaoko"};
        recipeName = (EditText) findViewById(R.id.editRecipeName);
        outputRecipeName = (TextView) findViewById(R.id.outputName);
        outputMaterials = (TextView) findViewById(R.id.outputMaterials);
        outputSeasons = (TextView) findViewById(R.id.outputSeasons);
//        recipeName.setOnKeyListener(new EditText.OnKeyListener(){
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event){
//                outputRecipeName.setText(recipeName.getText().toString());
//                return false;
//            }
//        });
        recipeName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                outputRecipeName.setText(recipeName.getText().toString());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        galleryM = (Gallery) this .findViewById(R.id.galleryM );
        galleryS = (Gallery) this.findViewById(R.id.galleryS);
        galleryM.setSpacing(6);
        galleryS.setSpacing(6);
        galleryM.setAdapter(adapter);
        galleryS.setAdapter(adapters);
        galleryM.setSelection(4);
        galleryS.setSelection(4);


        galleryM.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText ( mContext , "Position = " + position, Toast. LENGTH_SHORT ).show();
                String test = outputMaterials.getText().toString();
                int result = test.indexOf(materials[position]);
                if(result>=0){
                    String delted = test.replace(materials[position]+"; ","");
                    outputMaterials.setText(delted);
                }else{
                    outputMaterials.append(materials[position]+"; ");
                }
            }
        });
        galleryS.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String test = outputSeasons.getText().toString();
                int result = test.indexOf(seasons[position]);
                if(result>=0){
                    String delted = test.replace(seasons[position]+"; ","");
                    outputSeasons.setText(delted);
                }else{
                    outputSeasons.append(seasons[position]+"; ");
                }
            }
        });
        cancelRecipe = (Button) findViewById(R.id.cancelRecipe);
        cancelRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        createRecipe = (Button) findViewById(R.id.createRecipe);
        createRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "haha" , Toast. LENGTH_SHORT).show();
            }
        });
    }

}