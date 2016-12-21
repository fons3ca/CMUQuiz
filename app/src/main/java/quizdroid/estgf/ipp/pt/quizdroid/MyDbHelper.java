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

        db.execSQL("INSERT INTO tblNivel (nome, descricao) VALUES('Facil', 'modo facil')");
        db.execSQL("INSERT INTO tblCategoria (nome, descricao) VALUES('Cultura geral', 'Perguntas de conhecimento geral')");
        db.execSQL("INSERT INTO tblPergunta (pergunta, resp1, resp2, resp3, resp4, respCorreta, nId, pontuacao, cId) VALUES('Qual é a matéria mais dura encontrada na natureza?', 'Diamante negro', 'Obsidium', 'Carvao', 'Calhau', 'Diamante negro', 1, 100, 1) ");
        db.execSQL("INSERT INTO tblPergunta (pergunta, resp1, resp2, resp3, resp4, respCorreta, nId, pontuacao, cId) VALUES('Por meio de qual substância prima é fabricado o papel?', 'Celulose vegetal', 'Celulose animal', 'Celulose bacteriana', 'Celulose microcristalina', 'Celulose vegetal', 1, 100, 1) ");
        db.execSQL("INSERT INTO tblPergunta (pergunta, resp1, resp2, resp3, resp4, respCorreta, nId, pontuacao, cId) VALUES('Qual é a vitamina que a pele humana absorve em contato com a luz solar?', 'Vitamina D', 'Vitamina C', 'Vitamina D1', 'Vitamina A', 'Vitamina D', 1, 100, 1) ");
        db.execSQL("INSERT INTO tblPergunta (pergunta, resp1, resp2, resp3, resp4, respCorreta, nId, pontuacao, cId) VALUES('Qual é o alimento mais completo da natureza?', 'Leite', 'Abacaxi', 'Arroz', 'Batata', 'Leite', 1, 100, 1) ");
        db.execSQL("INSERT INTO tblPergunta (pergunta, resp1, resp2, resp3, resp4, respCorreta, nId, pontuacao, cId) VALUES('Que nome era dado à carta de libertação de um escravo?', 'Alforria', 'Carta de Libertaçao', 'Carta de condução', 'Alvará', 'Alforria', 1, 100, 1) ");
        db.execSQL("INSERT INTO tblPergunta (pergunta, resp1, resp2, resp3, resp4, respCorreta, nId, pontuacao, cId) VALUES('A quantos graus centígrados na escala Celsius a água ferve?', '100º', '77º', '90º', '-100º', '100º', 1, 100, 1) ");
        db.execSQL("INSERT INTO tblPergunta (pergunta, resp1, resp2, resp3, resp4, respCorreta, nId, pontuacao, cId) VALUES('Qual é o menor e mais quente planeta do sistema solar?', 'Mercurio', 'Saturno', 'Terra', 'Marte', 'Mercurio', 1, 100, 1) ");
        //teste
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
