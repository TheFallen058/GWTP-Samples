/**
 * Copyright 2013 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.carstore.server.api;

import javax.inject.Singleton;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.gwtplatform.carstore.shared.api.CarResource;
import com.gwtplatform.carstore.shared.api.CarsResource;
import com.gwtplatform.carstore.shared.api.ManufacturersResource;
import com.gwtplatform.carstore.shared.api.RatingResource;
import com.gwtplatform.carstore.shared.api.SessionResource;

public class ApiModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(JacksonProvider.class).in(Singleton.class);

        bind(CarsResource.class).to(CarsResourceImpl.class);
        bind(ManufacturersResource.class).to(ManufacturersResourceImpl.class);
        bind(SessionResource.class).to(SessionResourceImpl.class);
        bind(RatingResource.class).to(RatingResourceImpl.class);
        bind(StatisticsResourceImpl.class);

        install(new FactoryModuleBuilder()
                .implement(CarResource.class, CarResourceImpl.class)
                .build(ResourcesFactory.class));
    }
}
