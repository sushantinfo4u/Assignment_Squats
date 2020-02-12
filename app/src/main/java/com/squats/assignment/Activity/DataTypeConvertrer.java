package com.squats.assignment.Activity;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squats.assignment.Activity.API.Model.PostDetails;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class DataTypeConvertrer {

    private static Gson gson = new Gson();

    @TypeConverter
    public String fromCountryLangList(List<PostDetails> countryLang) {
        if (countryLang == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<PostDetails>>() {}.getType();
        String json = gson.toJson(countryLang, type);
        return json;
    }

    @TypeConverter
    public List<PostDetails> toCountryLangList(String countryLangString) {
        if (countryLangString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<PostDetails>>() {}.getType();
        List<PostDetails> countryLangList = gson.fromJson(countryLangString, type);
        return countryLangList;
    }

}
