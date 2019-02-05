package com.example.usrdel.myapplication

import android.os.Parcel
import android.os.Parcelable

class Pelicula(val identificadorPelicula:String, val nombre:String, val anioLanzamiento:String, val rating:String):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(identificadorPelicula)
        parcel.writeString(nombre)
        parcel.writeString(anioLanzamiento)
        parcel.writeString(rating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pelicula> {
        override fun createFromParcel(parcel: Parcel): Pelicula {
            return Pelicula(parcel)
        }

        override fun newArray(size: Int): Array<Pelicula?> {
            return arrayOfNulls(size)
        }
    }

}