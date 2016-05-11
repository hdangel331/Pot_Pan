package com.example.ziyang.potpan;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class hjy_main extends Activity implements OnItemClickListener {

    private Gallery galleryM,galleryS ;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        cll_exit.getInstance().addActivity(this);
        super .onCreate(savedInstanceState);
        setContentView(R.layout.hjy_main );
        // 创建一个 ImageAdapter 对象
        hjy_adapter adapter = new hjy_adapter( this );
        hjy_dadpter_seasons adapters = new hjy_dadpter_seasons(this);
        // 获取在 main.xml 中定义的 Gallery 对象
        galleryM = (Gallery) this .findViewById(R.id.galleryM );
        galleryS = (Gallery) this.findViewById(R.id.galleryS);
        // 设定图片之间的间隔 ( 如果无下面的语句，有时候图片会重叠 )
        galleryM.setSpacing(2);
        galleryS.setSpacing(2);
        // 将 adapter 和 gallery 关联起来
        galleryM.setAdapter(adapter);
        galleryS.setAdapter(adapters);
        galleryM.setSelection(4);
        galleryS.setSelection(4);
        // 给 gallery 设定 OnItemClickListener
        galleryM.setOnItemClickListener( this );
        galleryS.setOnItemClickListener(this);
    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText ( this , "Position = " + position, Toast. LENGTH_SHORT ).show();
    }
}