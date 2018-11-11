package com.juhnowski.ilya.flikrbrowser

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import java.io.IOException
import java.io.ObjectStreamException
import java.io.Serializable

class Photo(var title: String, var author:String, var authorId:String, var link:String, var tags:String, var image: String)
    :Parcelable{ //:Serializable

    private val TAG = "Photo"

    override fun toString(): String {
        return "Photo(title='$title', author='$author', authorId='$authorId', link='$link', tags='$tags', image='$image')"
    }


    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(author)
        parcel.writeString(authorId)
        parcel.writeString(link)
        parcel.writeString(tags)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Photo> {
        override fun createFromParcel(parcel: Parcel): Photo {
            return Photo(parcel)
        }

        override fun newArray(size: Int): Array<Photo?> {
            return arrayOfNulls(size)
        }
    }

//    @Throws(IOException::class)
//    private fun writeObject(out: java.io.ObjectOutputStream){
//        Log.d(TAG,"writeObject called")
//        out.writeUTF(title)
//        out.writeUTF(author)
//        out.writeUTF(authorId)
//        out.writeUTF(link)
//        out.writeUTF(tags)
//        out.writeUTF(image)
//    }
//
//    @Throws(IOException::class, ClassNotFoundException::class)
//    private fun readObject(inStream: java.io.ObjectInputStream){
//        Log.d(TAG,"readObject called")
//        title = inStream.readUTF()
//        author = inStream.readUTF()
//        authorId = inStream.readUTF()
//        link = inStream.readUTF()
//        tags = inStream.readUTF()
//        image = inStream.readUTF()
//    }
//
//    @Throws(ObjectStreamException::class)
//    private fun readObjectNoData(){
//        Log.d(TAG,"readObjectNoData called")
//    }
}