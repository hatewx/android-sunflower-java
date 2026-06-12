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

package com.google.samples.apps.sunflower.viewmodels;

import com.google.samples.apps.sunflower.data.Plant;
import com.google.samples.apps.sunflower.data.PlantRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

/**
 * Created by Shawn Wang on 3/26/19.
 */
public class PlantListViewModel extends ViewModel {
    private static final int NO_GROW_ZONE = -1;

    private PlantRepository plantRepository;

    private MutableLiveData<Integer> growZoneNumber;

    public LiveData<List<Plant>> plants;

    PlantListViewModel(@NonNull PlantRepository plantRepository) {
        super();
        this.plantRepository = plantRepository;
        this.growZoneNumber = new MutableLiveData<>(-1);
        this.plants = Transformations.switchMap(growZoneNumber, it -> {
            if (it == NO_GROW_ZONE) {
                return this.plantRepository.getPlants();
            } else {
                return this.plantRepository.getPlantsWithGrowZoneNumber(it);
            }
        });
    }

    public void setGrowZoneNumber(int num) {
        this.growZoneNumber.setValue(num);
    }

    public void cleanGrowZoneNumber() {
        this.growZoneNumber.setValue(NO_GROW_ZONE);
    }

    public boolean isFiltered() {
        return this.growZoneNumber.getValue() != NO_GROW_ZONE;
    }
}
