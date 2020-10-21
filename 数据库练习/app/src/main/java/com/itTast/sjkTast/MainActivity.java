package com.itTast.sjkTast;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements OnClickListener{
private MySQLite mySQLite;
private Button cj, zj,sc,gg,cz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySQLite = new MySQLite(this,"Users.db",null,1);
        cj = (Button) findViewById(R.id.cj);
        zj = (Button) findViewById(R.id.zj);
        sc = (Button) findViewById(R.id.sc);
        gg = (Button) findViewById(R.id.gg);
        cz = (Button) findViewById(R.id.cz);
        cj.setOnClickListener(this);
        zj.setOnClickListener(this);
        sc.setOnClickListener(this);
        gg.setOnClickListener(this);
        cz.setOnClickListener(this);
    }

    @Override
    public void onClick(View p1){
        switch(p1.getId()){
            case R.id.cj:
                mySQLite.getWritableDatabase();
                break;
            case R.id.zj:
               SQLiteDatabase db =  mySQLite.getWritableDatabase();
               ContentValues values = new ContentValues();
               values.put("username","2696294477");
               values.put("password","123456789");
               db.insert("User",null,values);
               values.clear();
                Toast.makeText(MainActivity.this,"增加成功",Toast.LENGTH_LONG).show();
            break;
            case R.id.sc:
                Toast.makeText(MainActivity.this,"删除",Toast.LENGTH_LONG).show();
                break;
            case R.id.gg:
                Toast.makeText(MainActivity.this,"更改",Toast.LENGTH_LONG).show();
                break;
            case R.id.cz:
              SQLiteDatabase czs =   mySQLite.getWritableDatabase();
            Cursor cursor =  czs.query("User",null,null,null,null,null,null);
            if(cursor.moveToFirst()){
                do{
                    String username =  cursor.getString(cursor.getColumnIndex("username"));
                    String password =  cursor.getString(cursor.getColumnIndex("password"));
                    Log.d("MainActivity","用户名:"+username);
                    Log.d("MainActivity","密码:"+password);
                }while(cursor.moveToNext());
                    
                
            }
            cursor.close();
                Toast.makeText(MainActivity.this,"查找",Toast.LENGTH_LONG).show();
                break;
        default:
            break;
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(mySQLite != null){
            mySQLite.close();
        }
    }
    
} 
