/*
 * Copyright (c) 2014-2015 University of Ulm
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership.  Licensed under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package de.uniulm.omi.cloudiator.visor.reporting.modules.impl;

import de.uniulm.omi.cloudiator.visor.reporting.api.ReportingInterface;
import de.uniulm.omi.cloudiator.visor.reporting.modules.api.ReportingModule;
import de.uniulm.omi.cloudiator.visor.monitoring.api.Metric;
import de.uniulm.omi.cloudiator.visor.reporting.impl.kairos.KairosDb;

/**
 * Created by daniel on 10.12.14.
 */
public class KairosReportingModule extends ReportingModule {
    @Override
    protected Class<? extends ReportingInterface<Metric>> getReportingInterface() {
        return KairosDb.class;
    }
}
