/*
 *
 *  * Copyright (c) 2014 University of Ulm
 *  *
 *  * See the NOTICE file distributed with this work for additional information
 *  * regarding copyright ownership.  Licensed under the Apache License, Version 2.0 (the
 *  * "License"); you may not use this file except in compliance
 *  * with the License.  You may obtain a copy of the License at
 *  *
 *  *   http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing,
 *  * software distributed under the License is distributed on an
 *  * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  * KIND, either express or implied.  See the License for the
 *  * specific language governing permissions and limitations
 *  * under the License.
 *
 */

package de.uniulm.omi.monitoring.probes.strategies.impl;

import com.sun.management.OperatingSystemMXBean;
import de.uniulm.omi.monitoring.metric.api.MetricNotAvailableException;
import de.uniulm.omi.monitoring.probes.strategies.api.CpuMeasurementStrategy;

import java.lang.management.ManagementFactory;

/**
 * Created by daniel on 16.12.14.
 */
public class OSMxBeanCpuStrategy implements CpuMeasurementStrategy<Double> {

    @Override
    public Double measure() throws MetricNotAvailableException {
        OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(
                OperatingSystemMXBean.class);

        double systemCpuLoad = osBean.getSystemCpuLoad();
        double systemCpuLoadPercentage = systemCpuLoad * 100;

        if (systemCpuLoad < 0) {
            throw new MetricNotAvailableException("Received negative value");
        }

        return systemCpuLoadPercentage;
    }
}
