package com.example.ziyang.potpan.Main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ziyang.potpan.Data.zzy_data;
import com.example.ziyang.potpan.Login.cll_exit;
import com.example.ziyang.potpan.R;
import com.example.ziyang.potpan.util.SocketClient;

import java.util.ArrayList;
import java.util.List;

import static com.example.ziyang.potpan.Data.zzy_constants.*;
/*
*Created by jingye.hong
*1301034
*/
public class DesignRecipe extends Activity {

    private Gallery galleryM, galleryS;
    private EditText recipeName;
    private TextView outputRecipeName, outputMaterials, outputSeasons;
    private Context mContext = null;
    private Button cancelRecipe, createRecipe;

    private Handler myHandler;
    private Thread thread;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        cll_exit.getInstance().addActivity(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.DesignRecipe);
        mContext = this;
        hjy_adapter adapter = new hjy_adapter(this);
        hjy_dadpter_seasons adapters = new hjy_dadpter_seasons(this);

        //Get account
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final String RecipeName = bundle.getString("recipename");
        final String AccountName = bundle.getString("accountname");

        final String materials[] = {
                "bacon", "balsam pear", "beef", "carrot", "celery", "checken",
                 "corn", "drumstick", "egg", "eggplant", "fish", "leek",
                "lettuce", "tomato", "mushroom", "potapo", "pumpkin", "rice", "shrimp"};
        final String seasons[] = {
                "chilli", "cinnamon", "cumin", "curry", "garlic", "ginger", "onion",
                "rosemary", "salt", "shallot", "soy sauce", "sugar", "tsaoko"};

        recipeName = (EditText) findViewById(R.id.editRecipeName);
        outputRecipeName = (TextView) findViewById(R.id.outputName);
        outputMaterials = (TextView) findViewById(R.id.outputMaterials);
        outputSeasons = (TextView) findViewById(R.id.outputSeasons);
        cancelRecipe = (Button) findViewById(R.id.cancelRecipe);
        createRecipe = (Button) findViewById(R.id.createRecipe);

        recipeName.setText(RecipeName);
        outputRecipeName.setText(RecipeName);
        if (RecipeName != null && RecipeName.length() != 0) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    StringBuffer submitContent = new StringBuffer();
                    submitContent.append(GET_CONTENTBYNAME + RecipeName);
                    SocketClient.ConnectSevert(submitContent.toString());
                    String readinfo = SocketClient.readinfo;
                    Message message = new Message();
                    message.obj = readinfo;
                    message.what = 1;
                    myHandler.sendMessage(message);
                }
            }).start();
        }
        //dynamic changes the textview according edittext
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
        galleryM = (Gallery) this.findViewById(R.id.galleryM);
        galleryS = (Gallery) this.findViewById(R.id.galleryS);
        galleryM.setSpacing(6);
        galleryS.setSpacing(6);
        galleryM.setAdapter(adapter);
        galleryS.setAdapter(adapters);
        galleryM.setSelection(4);
        galleryS.setSelection(4);
        //set gallery click listener
        //judge the output, make sure no repeated data
        galleryM.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String test = outputMaterials.getText().toString();
                int result = test.indexOf(materials[position]);
                if (result >= 0) {
                    String delted = test.replace(materials[position] + "; ", "");
                    outputMaterials.setText(delted);
                } else {
                    outputMaterials.append(materials[position] + "; ");
                }
            }
        });
        //set gallery click listener
        //judge the output, make sure no repeated data
        galleryS.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String test = outputSeasons.getText().toString();
                int result = test.indexOf(seasons[position]);
                if (result >= 0) {
                    String delted = test.replace(seasons[position] + "; ", "");
                    outputSeasons.setText(delted);
                } else {
                    outputSeasons.append(seasons[position] + "; ");
                }
            }
        });
        //go back to previous interface
        cancelRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(DesignRecipe.this, wxx_main.class);
                intent.putExtra("useraccount", AccountName);
                startActivity(intent);
                DesignRecipe.this.finish();
            }
        });
        //send recipe data to database
        createRecipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final String name = outputRecipeName.getText().toString();
                        final String materiallist = outputMaterials.getText().toString();
                        final String seasoninglist = outputSeasons.getText().toString();
                        System.out.println("1");
                        StringBuffer submitContent = new StringBuffer();
                        submitContent.append(UPDATE_RECIPE + AccountName + "; " + RecipeName + "; " + name + "; " + UPDATE_RECIPE + name + "; " + materiallist + UPDATE_RECIPE + name + "; " + seasoninglist);
                        SocketClient.ConnectSevert(submitContent.toString());
                        String readinfo = SocketClient.readinfo;
                        if (readinfo.equals("ok")) {
                            Message message = new Message();
                            message.what = 2;
                            myHandler.sendMessage(message);
                        } else {
                            Message message = new Message();
                            message.what = 3;
                            myHandler.sendMessage(message);
                        }
                    }
                });
                thread.start();
            }
        });

        myHandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        List<String[]> list = new ArrayList<String[]>();
                        String info = (String) msg.obj;
                        String[] str1 = info.split("#");
                        for (int i = 0; i < str1.length; i++) {
                            if (str1[i].length() > 0) {
                                list.add(str1[i].split("η"));
                            }
                        }
                        for (int i = 0; i < list.size(); i++) {
                            String[] str = list.get(i);
                            outputMaterials.append(str[0] + "; ");
                            outputSeasons.append(str[1] + "; ");
                        }
                        String checkNullS = outputMaterials.getText().toString();
                        String deltedNullS = checkNullS.replace("null; ","");
                        outputMaterials.setText(deltedNullS);
                        String checkNullX = outputSeasons.getText().toString();
                        String delterNullX = checkNullX.replace("null; ","");
                        outputSeasons.setText(delterNullX);
                        break;
                    case 2:
                        zzy_data.setI(2);
                        Intent intent = new Intent();
                        intent.setClass(DesignRecipe.this, wxx_main.class);
                        intent.putExtra("useraccount", AccountName);
                        startActivity(intent);
                        DesignRecipe.this.finish();
                        break;
                    case 3:
                        Toast.makeText(mContext, "Fail", Toast.LENGTH_SHORT).show();
                        break;

                }
                super.handleMessage(msg);
            }
        };
    }
    //Adapter for materials gallery
    public class hjy_adapter extends BaseAdapter {
        private Context ctx;
        private int[] images = {
                R.drawable.hjy_bacon,
                R.drawable.hjy_balsampear,
                R.drawable.hjy_beef,
                R.drawable.hjy_carrot,
                R.drawable.hjy_celery,
                R.drawable.hjy_checken,
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
                R.drawable.hjy_shrimp};

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
    //Adapter for seasons gallery
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
                R.drawable.hjy_s_sugar,
                R.drawable.hjy_s_tsaoko,};

        public hjy_dadpter_seasons(Context ctx) {
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

}
