package com.infinitycraft.plugin.general.authentication;

import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import okhttp3.*;
import org.bukkit.Bukkit;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.Arrays;

public class ImageUploader {
    public static String uploadImage(byte[] image) {
        String url = null;
        String encoded = Base64.encode(image);
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("image", encoded)
                .build();
        Request request = new Request.Builder()
                .url("https://api.imgur.com/3/image")
                .method("POST", body)
                .addHeader("Authorization", "Client-ID d3d4aedc307168a")
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(response.body().string());
            JSONObject json2 = (JSONObject) json.get("data");
            url = (String) json2.get("link");
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return url;
    }
}