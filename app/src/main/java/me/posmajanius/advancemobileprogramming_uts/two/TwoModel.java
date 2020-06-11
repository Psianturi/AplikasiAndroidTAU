package me.posmajanius.advancemobileprogramming_uts.two;

import android.os.Parcel;
import android.os.Parcelable;


public class TwoModel implements Parcelable {
    private int photoTwo;
    private String nameTwo;
    private String placeTwo;
    private String cityTwo;
    private String descriptionTwo;

    public int getPhotoTwo() {
        return photoTwo;
    }

    public void setPhotoTwo(int photoTwo) {
        this.photoTwo = photoTwo;
    }


    public String getNameTwo() {
        return nameTwo;
    }

    public void setNameTwo(String nameTwo) {
        this.nameTwo = nameTwo;
    }

    public String getPlaceTwo() {
        return placeTwo;
    }

    public void setPlaceTwo(String placeTwo) {
        this.placeTwo = placeTwo;
    }

    public String getCityTwo() {
        return cityTwo;
    }

    public void setCityTwo(String cityTwo) {
        this.cityTwo = cityTwo;
    }

    public String getDescriptionTwo() {
        return descriptionTwo;
    }

    public void setDescriptionTwo(String descriptionTwo) {
        this.descriptionTwo = descriptionTwo;
    }

    private TwoModel(Parcel in) {
        this.photoTwo = in.readInt();
        //this.backdropTwo = in.readInt();
        this.nameTwo = in.readString();
        this.placeTwo = in.readString();
        this.cityTwo = in.readString();
        this.descriptionTwo = in.readString();
    }

    public static final Creator<TwoModel> CREATOR = new Creator<TwoModel>() {
        @Override
        public TwoModel createFromParcel(Parcel in) {
            return new TwoModel(in);
        }

        @Override
        public TwoModel[] newArray(int size) {
            return new TwoModel[size];
        }
    };


    public TwoModel(){

    }
    public TwoModel(int photoTwo, String nameTwo, String descriptionTwo, String placeTwo, String cityTwo) {
        this.photoTwo = photoTwo;
        this.nameTwo = nameTwo;
        this.placeTwo = placeTwo;
        this.cityTwo = cityTwo;
        this.descriptionTwo = descriptionTwo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.photoTwo);
        parcel.writeString(this.nameTwo);
        parcel.writeString(this.placeTwo);
        parcel.writeString(this.cityTwo);
        parcel.writeString(this.descriptionTwo);
    }
}

