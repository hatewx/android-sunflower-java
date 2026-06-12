/*
 * Copyright 2019 Shawn Wang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.workers;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.samples.apps.sunflower.data.AppDatabase;
import com.google.samples.apps.sunflower.data.Plant;
import com.google.samples.apps.sunflower.utilities.Constants;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/**
 * Created by Shawn Wang on 3/26/19.
 */
public class SeedDatabaseWorker extends Worker {

    private static final String TAG = SeedDatabaseWorker.class.getSimpleName();

    /**
     * @param appContext   The application {@link Context}
     * @param workerParams Parameters to setup the internal state of this worker
     */
    public SeedDatabaseWorker(@NonNull Context appContext, @NonNull WorkerParameters workerParams) {
        super(appContext, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        try {
            InputStream input = getApplicationContext().getAssets().open(Constants.PLANT_DATA_FILENAME);
            JsonReader reader = new JsonReader(new InputStreamReader(input));
            Type plantType = new TypeToken<List<Plant>>(){}.getType();
            List<Plant> plantList = new Gson().fromJson(reader, plantType);
            input.close();

            AppDatabase database = AppDatabase.getInstance(getApplicationContext());
            database.getPlantDao().insertAll(plantList);

            return Result.success();
        } catch (IOException e) {
            Log.e(TAG, "Error seeding database", e);
            return Result.failure();
        }
    }
}
