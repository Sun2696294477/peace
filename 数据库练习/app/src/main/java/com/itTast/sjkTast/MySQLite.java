package com.itTast.sjkTast;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.widget.Toast;

public class MySQLite extends SQLiteOpenHelper
{
public static final String TABLE_OK = "create table User ("
+" id integer primary key autoincrement,"
+" username text,"
+" password text)";

    @Override
    public void onCreate(SQLiteDatabase p1){
        p1.execSQL(TABLE_OK);
        Toast .makeText(mContext,"数据库创建成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase p1, int p2, int p3){
        
    }
    private Context mContext;
    
    public MySQLite(Context context,String name,SQLiteDatabase.CursorFactory factory,int bbh){
        super(context,name,factory,bbh);
        mContext = context;
    }
}
