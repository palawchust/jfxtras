/**
 * AgendaRenderTest.java
 *
 * Copyright (c) 2011-2015, JFXtras
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the organization nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package jfxtras.scene.control.agenda.test;

import javafx.scene.Parent;
import javafx.scene.control.Slider;
import jfxtras.internal.scene.control.skin.agenda.AgendaDaysFromDisplayedSkin;
import jfxtras.test.TestUtil;
import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */
public class AgendaRenderDaysFromDisplayedDateTest extends AbstractAgendaTestBase {

	/**
	 * 
	 */
	public Parent getRootNode()
	{
		Parent parent = super.getRootNode();
//		agenda.setSkin(new AgendaDaysFromDisplayedSkin(agenda));
		return parent;
	}

	@Test
	public void dummy()
	{
	}
	
	/**
	 * 
	 */
//	@Test
	public void renderVanilla()
	{
		Slider daysBackSlider = (Slider)find("#daysBackSlider");
		Assert.assertEquals(-1.0, daysBackSlider.getValue(), 0.0001);
		Slider daysForwardSlider = (Slider)find("#daysForwardSlider");
		Assert.assertEquals(6.0, daysForwardSlider.getValue(), 0.0001);
		//TestUtil.sleep(3000);
	}

	/**
	 * 
	 */
//	@Test
	public void renderAfterCSS()
	{
		TestUtil.runThenWaitForPaintPulse( () -> {
			agenda.setStyle("-fxx-days-before-furthest:-5; -fxx-days-after-furthest:20;");
		});
			
		Slider daysBackSlider = (Slider)find("#daysBackSlider");
		Assert.assertEquals(-5.0, daysBackSlider.getValue(), 0.0001);
		Slider daysForwardSlider = (Slider)find("#daysForwardSlider");
		Assert.assertEquals(20.0, daysForwardSlider.getValue(), 0.0001);
		TestUtil.sleep(3000);
	}
}