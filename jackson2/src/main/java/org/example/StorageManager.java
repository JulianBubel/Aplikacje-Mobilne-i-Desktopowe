package org.example;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;

public class StorageManager {
    private static final String FILE_NAME = "profile.json";
    private static final Gson gson = new Gson();

    public static void save(UserProfile profile) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            gson.toJson(profile, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UserProfile load() {
        try (FileReader reader = new FileReader(FILE_NAME)) {
            return gson.fromJson(reader, UserProfile.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}