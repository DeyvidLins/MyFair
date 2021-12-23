package com.example.myfair;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;


public class Dados {
    private Conexao conexao;
    private SQLiteDatabase banco;

    public Dados(Context context){/*preciso do context para criar a conexão*/
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();/*iniciar o banco e escrever com a conexão*/
    }

    public long insert(Compra comp){
        ContentValues values = new ContentValues();  /*criar objeto value com os valores que serão inseridos na tabela aluno*/
        values.put("nome_compra", comp.getNome());  /*o value nome irá receber o valor q será inserido na variável nome o mesmo ocorre abaixo*/
        return banco.insert("compra", null, values);/*retrun para retornar o método inserir*/
    }

}
