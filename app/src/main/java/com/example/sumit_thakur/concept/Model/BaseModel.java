package com.example.sumit_thakur.concept.Model;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Base Model
 */
public class BaseModel implements Parcelable {
    public static final Creator<BaseModel> CREATOR = new Creator<BaseModel>() {
        @Override
        public BaseModel createFromParcel(final Parcel in) {
            return new BaseModel(in);
        }

        @Override
        public BaseModel[] newArray(final int size) {
            return new BaseModel[size];
        }
    };
    private String mName;

    /**
     *
     * @param mName useer name parameter
     */
    public BaseModel(final String mName) {
        this.mName = mName;
    }

    /**
     *
     * @param in parcel in
     */
    protected BaseModel(final Parcel in) {
        mName = in.readString();
    }

    /**
     *
     * @param mName set user name
     */
    public void setmName(final String mName) {
        this.mName = mName;
    }

    /**
     *
     * @return get user Name
     */
    public String getmName() {
        return mName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeString(mName);
    }
}
