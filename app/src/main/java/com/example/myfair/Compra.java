package com.example.myfair;

import android.os.Parcel;
import android.os.Parcelable;

public class Compra implements Parcelable {

        public int codigo;
        public String nome;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public Compra(String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    protected Compra(Parcel in) {
        codigo = in.readInt();
        nome = in.readString();
    }

    public static final Creator<Compra> CREATOR = new Creator<Compra>() {
        @Override
        public Compra createFromParcel(Parcel in) {
            return new Compra(in);
        }

        @Override
        public Compra[] newArray(int size) {
            return new Compra[size];
        }
    };

    public Compra(){

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(codigo);
        dest.writeString(nome);
    }

    @Override
    public String toString(){
        return nome;
    }
}
