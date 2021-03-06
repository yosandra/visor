
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

package de.uniulm.omi.cloudiator.visor.monitoring.sensors.logsensors;

import java.util.regex.Pattern;

import de.uniulm.omi.cloudiator.visor.monitoring.api.MeasurementNotAvailableException;
import de.uniulm.omi.cloudiator.visor.monitoring.api.SensorInitializationException;
import de.uniulm.omi.cloudiator.visor.monitoring.sensors.AbstractSensor;

/**
 * 
 * @author zarioha
 * This Sensor read log file from OFBizLog
 */

public class OFBizLogSensor extends AbstractLogSensor {

	public OFBizLogSensor() {
		this.fileName = "logs/ofbiz.log";
	}
	
	public static void main(String[] args) throws SensorInitializationException,
      MeasurementNotAvailableException {
		AbstractSensor logReader = new OFBizLogSensor();
		logReader.init();
		logReader.getMeasurement();
	}

    protected void initialize() throws SensorInitializationException {
    	super.initialize();
    	String pattern = "(19|20\\d{2})-(0?[1-9]|1[012])-(0?[1-9]|[12]\\d|3[01]) ([01]?\\d|2[0-3]):([0-5]\\d):([0-5]\\d),(\\d{3}).*\\((http.+?)\\).*\\[\\[\\[(.+?)\\(Domain.*(Request Done).*total:(.*),";
    	this.requestPattern = Pattern.compile(pattern);
    
    }
}
