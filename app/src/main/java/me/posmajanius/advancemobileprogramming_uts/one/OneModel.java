package me.posmajanius.advancemobileprogramming_uts.one;

import android.os.Parcel;
import android.os.Parcelable;

public class OneModel implements Parcelable {
    private int photoOne;
    private String nameOne;
    private String placeOne;
    //private String cityOne;
    private String descriptionOne;

    public int getPhotoOne() {
        return photoOne;
    }

    public void setPhotoOne(int photoOne) {
        this.photoOne = photoOne;
    }

    public String getNameOne() {
        return nameOne;
    }

    public void setNameOne(String nameOne) {
        this.nameOne = nameOne;
    }

    public String getPlaceOne() {
        return placeOne;
    }

    public void setPlaceOne(String placeOne) {
        this.placeOne = placeOne;
    }


    public String getDescriptionOne() {
        return descriptionOne;
    }

    public void setDescriptionOne(String descriptionOne) {
        this.descriptionOne = descriptionOne;
    }

    private OneModel(Parcel in) {
        this.photoOne = in.readInt();
        this.nameOne = in.readString();
        this.placeOne = in.readString();
        //this.cityOne = in.readString();
        this.descriptionOne = in.readString();
    }

    public static final Creator<OneModel> CREATOR = new Creator<OneModel>() {
        @Override
        public OneModel createFromParcel(Parcel in) {
            return new OneModel(in);
        }

        @Override
        public OneModel[] newArray(int size) {
            return new OneModel[size];
        }
    };




    public OneModel(){

    }
    public OneModel(int photoOne, String nameOne, String descriptionOne, String placeOne) {
        this.photoOne = photoOne;
        this.nameOne = nameOne;
        this.placeOne = placeOne;
        //this.cityOne = cityOne;
        this.descriptionOne = descriptionOne;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.photoOne);
        parcel.writeString(this.nameOne);
        parcel.writeString(this.placeOne);
        //parcel.writeString(this.cityOne);
        parcel.writeString(this.descriptionOne);
    }
}
