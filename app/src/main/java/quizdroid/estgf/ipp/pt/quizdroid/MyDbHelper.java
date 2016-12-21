package quizdroid.estgf.ipp.pt.quizdroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by DanyM on 19/12/2016.
 */

public class MyDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 3;

    public MyDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys = ON;");
        db.execSQL("CREATE TABLE tblNivel(nId INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR(50) NOT NULL,descricao VARCHAR(50) NOT NULL)");
        db.execSQL("CREATE TABLE tblCategoria(cId INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR(50) NOT NULL,descricao VARCHAR(50) NOT NULL)");
        db.execSQL("CREATE TABLE tblUtilizador(uId INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR(50) NOT NULL,passwd VARCHAR(50) NOT NULL, pergResp INTEGER NOT NULL, respCorrectas INTEGER NOT NULL, jogosTerm INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE tblJogo(jId INTEGER PRIMARY KEY AUTOINCREMENT, uId INTEGER NOT NULL, nId INTEGER NOT NULL, cId INTEGER NOT NULL, publicHelp INTEGER NOT NULL, phoneHelp INTEGER NOT NULL, fiftyFiftyHelp INTEGER NOT NULL, terminated INTEGER NOT NULL, pontuacao INTEGER NOT NULL, FOREIGN KEY (nId) REFERENCES tblNivel(nId), FOREIGN KEY (uId) REFERENCES tblUtilizador(uId), FOREIGN KEY (cId) REFERENCES tblCategoria(cId))");
        db.execSQL("CREATE TABLE tblPergunta(pId INTEGER PRIMARY KEY AUTOINCREMENT,pergunta VARCHAR(200) NOT NULL, resp1 VARCHAR(100) NOT NULL,  resp2 VARCHAR(100) NOT NULL, resp3 VARCHAR(100) NOT NULL, resp4 VARCHAR(100) NOT NULL, respCorreta VARCHAR(100) NOT NULL, nId INTEGER NOT NULL, pontuacao INTEGER NOT NULL, cId INTEGER NOT NULL, FOREIGN KEY (nId) REFERENCES tblNivel(nId), FOREIGN KEY (cId) REFERENCES tblCategoria(cId))");
        db.execSQL("CREATE TABLE tblJogadas(jgId INTEGER PRIMARY KEY, jId INTEGER ,pId INTEGER, FOREIGN KEY (jId) REFERENCES tblJogo(jId), FOREIGN KEY (pId) REFERENCES tblPergunta(pId))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE tblNivel");
        db.execSQL("DROP TABLE tblUtilizador");
        db.execSQL("DROP TABLE tblJogo");
        db.execSQL("DROP TABLE tblPergunta");
        db.execSQL("DROP TABLE tblJogadas");

    }

    public ArrayList<Pergunta> getPerguntasByNivel(Context context, int idNivel){
        ArrayList<Pergunta> perguntas = new ArrayList<>();
        String sql;

        MyDbHelper dbHelper = new MyDbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        sql = "SELECT * FROM tblPergunta WHERE nId='" + idNivel +"'";
        Cursor c = db.rawQuery(sql,null);
        if(c != null && c.moveToFirst()){
            do{
                perguntas.add( new Pergunta(c.getInt(0),c.getInt(7), c.getString(1),
                        c.getString(2), c.getString(3), c.getString(4), c.getString(5),
                        c.getString(6), c.getInt(8), c.getInt(9)));
            }while(c.moveToNext());
        }

        return perguntas;
    }

    public ArrayList<Pergunta> getPerguntasByCategoria(Context context, int idCategoria){
        ArrayList<Pergunta> perguntas = new ArrayList<>();
        String sql;

        MyDbHelper dbHelper = new MyDbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        sql = "SELECT * FROM tblPergunta WHERE cId='" + idCategoria +"'";
        Cursor c = db.rawQuery(sql,null);
        if(c != null && c.moveToFirst()){
            do{
                perguntas.add( new Pergunta(c.getInt(0),c.getInt(7), c.getString(1),
                        c.getString(2), c.getString(3), c.getString(4), c.getString(5),
                        c.getString(6), c.getInt(8), c.getInt(9)));
            }while(c.moveToNext());
        }

        return perguntas;
    }

    public ArrayList<Pergunta> getPerguntasByNivelAndCategoria(Context context, int idNivel, int idCategoria){
        ArrayList<Pergunta> perguntas = new ArrayList<>();
        String sql;

        MyDbHelper dbHelper = new MyDbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        sql = "SELECT * FROM tblPergunta WHERE cId='" + idCategoria +"' AND nId='" + idNivel + "'";
        Cursor c = db.rawQuery(sql,null);
        if(c != null && c.moveToFirst()){
            do{
                perguntas.add( new Pergunta(c.getInt(0),c.getInt(7), c.getString(1),
                        c.getString(2), c.getString(3), c.getString(4), c.getString(5),
                        c.getString(6), c.getInt(8), c.getInt(9)));
            }while(c.moveToNext());
        }

        return perguntas;
    }

}