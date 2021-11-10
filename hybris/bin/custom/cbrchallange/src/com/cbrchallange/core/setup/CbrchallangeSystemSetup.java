/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.cbrchallange.core.setup;

import static com.cbrchallange.core.constants.CbrchallangeConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.cbrchallange.core.constants.CbrchallangeConstants;
import com.cbrchallange.core.service.CbrchallangeService;


@SystemSetup(extension = CbrchallangeConstants.EXTENSIONNAME)
public class CbrchallangeSystemSetup
{
	private final CbrchallangeService cbrchallangeService;

	public CbrchallangeSystemSetup(final CbrchallangeService cbrchallangeService)
	{
		this.cbrchallangeService = cbrchallangeService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		cbrchallangeService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return CbrchallangeSystemSetup.class.getResourceAsStream("/cbrchallange/sap-hybris-platform.png");
	}
}
