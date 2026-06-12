/*
 * Copyright 2019 Google LLC
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

package com.google.samples.apps.sunflower.viewmodels;

import android.content.Context;

import com.google.samples.apps.sunflower.data.AppDatabase;
import com.google.samples.apps.sunflower.data.GardenPlantingRepository;
import com.google.samples.apps.sunflower.data.PlantRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.platform.app.InstrumentationRegistry;

import static com.google.samples.apps.sunflower.utilities.LiveDataTestUtil.getValue;
import static com.google.samples.apps.sunflower.utilities.TestUtils.testPlant;
import static org.junit.Assert.assertFalse;

/**
 * Created by Shawn Wang on 2019-05-06.
 */
public class PlantDetailViewModelTest {
    private AppDatabase appDatabase;
    private PlantDetailViewModel viewModel;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();

        PlantRepository plantRepo = PlantRepository.getInstance(appDatabase.getPlantDao());
        GardenPlantingRepository gardenPlantingRepo = GardenPlantingRepository.getInstance(
                appDatabase.getGardenPlantingDao());
        viewModel = new PlantDetailViewModel(plantRepo, gardenPlantingRepo, testPlant.getPlantId());
    }

    @After
    public void tearDown() {
        appDatabase.close();
    }

    @Test
    public void testDefaultValues() throws InterruptedException {
        assertFalse(getValue(viewModel.getIsPlanted()));
    }
}
