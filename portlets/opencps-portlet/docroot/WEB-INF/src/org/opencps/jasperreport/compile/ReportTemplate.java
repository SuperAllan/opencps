/**
* OpenCPS is the open source Core Public Services software
* Copyright (C) 2016-present OpenCPS community

* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Affero General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* any later version.

* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Affero General Public License for more details.
* You should have received a copy of the GNU Affero General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>
*/

package org.opencps.jasperreport.compile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import net.sf.jasperreports.engine.JRExpressionCollector;
import net.sf.jasperreports.engine.JRReport;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.base.JRBaseObjectFactory;

/**
 * @author trungnt
 */
public class ReportTemplate extends JasperReport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReportTemplate(
	    JRReport report, String compilerClass, Serializable compileData,
	    JRExpressionCollector expressionCollector, String compileNameSuffix) {
		super(
		    report, compilerClass, compileData, expressionCollector, compileNameSuffix);

	}

	public ReportTemplate(
	    JRReport report, String compilerClass, Serializable compileData,
	    JRBaseObjectFactory factory, String compileNameSuffix) {
		super(
		    report, compilerClass, compileData, factory, compileNameSuffix);

	}

	public static ReportTemplate compile(String jrxmlTemplate) {

		ReportTemplate reportTemplate = null;
		try {
			InputStream isTemplate = new ByteArrayInputStream(jrxmlTemplate
			    .getBytes(StandardCharsets.UTF_8));
			reportTemplate = (ReportTemplate) JasperCompileManager
			    .compileReport(isTemplate);

		}
		catch (Exception e) {
			_log
			    .error(e);
		}

		return reportTemplate;
	}

	private static Log _log = LogFactoryUtil
	    .getLog(ReportTemplate.class);
}
