package com.example.ziyang.potpan;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
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
    public static class hjy_adapter extends BaseAdapter {
        private Context ctx;
        private int[] images = {
                R.drawable.hjy_bacon,
                R.drawable.hjy_balsampear,
                R.drawable.hjy_beef,
                R.drawable.hjy_carrot,
                R.drawable.hjy_celery,
                R.drawable.hjy_checken,
                R.drawable.hjy_checkenbreast,
                R.drawable.hjy_chinesecabbage,
                R.drawable.hjy_corn,
                R.drawable.hjy_drumstick,
                R.drawable.hjy_egg,
                R.drawable.hjy_eggplant,
                R.drawable.hjy_fish,
                R.drawable.hjy_leek,
                R.drawable.hjy_lettuce,
                R.drawable.hjy_loveapple,
                R.drawable.hjy_mushroom,
                R.drawable.hjy_potapo,
                R.drawable.hjy_pumpkin,
                R.drawable.hjy_rice,
                R.drawable.hjy_shrimp, };

        public hjy_adapter(Context ctx) {
            this.ctx = ctx;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return images[position];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView view = (ImageView) convertView;
            if (view == null) {
                view = new ImageView(ctx);
            }
            view.setImageResource(images[position]);
            view.setLayoutParams(new Gallery.LayoutParams(300, 300));
            view.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            return view;
        }
    }
    public class hjy_dadpter_seasons extends BaseAdapter {
        private Context ctx;
        private int[] images = {
                R.drawable.hjy_s_chilli,
                R.drawable.hjy_s_cinnamon,
                R.drawable.hjy_s_cumin,
                R.drawable.hjy_s_curry,
                R.drawable.hjy_s_garlic,
                R.drawable.hjy_s_ginger,
                R.drawable.hjy_s_onion,
                R.drawable.hjy_s_rosemary,
                R.drawable.hjy_s_salt,
                R.drawable.hjy_s_shallot,
                R.drawable.hjy_s_soysauce,
                R.drawable.hjy_s_staranise,
                R.drawable.hjy_s_sugar,
                R.drawable.hjy_s_tsaoko,};

        public hjy_dadpter_seasons(Context ctx)
        {
            this.ctx = ctx;
        }
        @Override
        public int getCount()
        {
            return images . length ;
        }
        @Override
        public Object getItem( int position)
        {
            return images [position];
        }
        @Override
        public long getItemId( int position)
        {
            return images [position];
        }
        @Override
        public View getView( int position, View convertView, ViewGroup parent)
        {

            ImageView view = (ImageView) convertView;
            if (view == null )
            {
                view = new ImageView( ctx );
            }
            view.setImageResource( images [position]);

            view.setLayoutParams( new Gallery.LayoutParams(300, 300));

            view.setScaleType(ImageView.ScaleType. CENTER_INSIDE );
            return view;
        }
    }
}