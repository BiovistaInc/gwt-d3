/**
 * Copyright (c) 2013, Anthony Schiochet and Eric Citaire
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * * The names Anthony Schiochet and Eric Citaire may not be used to endorse or promote products
 *   derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL MICHAEL BOSTOCK BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY
 * OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.gwtd3.api.behaviour;

import com.github.gwtd3.api.D3;
import com.github.gwtd3.api.IsFunction;
import com.github.gwtd3.api.arrays.Array;
import com.github.gwtd3.api.functions.DatumFunction;
import com.github.gwtd3.api.scales.LinearScale;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * This behavior automatically creates event listeners to handle scroll gestures
 * and pan gestures on an element. Events including mouse, touch, and scroll are
 * supported.
 * <p>
 * Usage:
 * 
 * <pre>
 * {
 * 	&#064;code
 * 	Zoom zoom = D3.behavior.zoom().on(ZoomEventType.Zoom, new MyZoomListener());
 * 	mySelection.call(zoom);
 * }
 * </pre>
 * 
 * @author <a href="mailto:schiochetanthoni@gmail.com">Anthony Schiochet</a> <br />
 *         <a href="https://github.com/augbog">Augustus Yuan</a>
 * 
 */

public class Zoom extends JavaScriptObject implements IsFunction {

	protected Zoom() {

	}

	/**
	 * Type of scroll event to listen to.
	 */
	public static enum ZoomEventType {
		/**
		 * Registers the specified listener to receive events of the specified
		 * type from the zoom behavior. Currently, only the "zoom" event is
		 * supported.
		 */
		Zoom
	}

	/**
	 * Registers the specified listener to receive events of the specified type
	 * from the zoom behavior.
	 * <p>
	 * See {@link ZoomEventType} for more information.
	 * 
	 * @param type
	 * @param listener
	 * @return
	 */
	public final native Zoom on(ZoomEventType type, DatumFunction<Void> listener)/*-{
		return this
				.on(
						type.@com.github.gwtd3.api.behaviour.Zoom.ZoomEventType::name()()
								.toLowerCase(),
						function(d, index) {
							listener.@com.github.gwtd3.api.functions.DatumFunction::apply(Lcom/google/gwt/dom/client/Element;Lcom/github/gwtd3/api/core/Value;I)(this,{datum:d},index);
						});
	}-*/;

	/**
	 * Specifies an x-scale whose domain should be automatically adjusted when
	 * zooming. If not specified, returns the current x-scale, which defaults to
	 * null. If the scale's domain or range is modified programmatically, this
	 * function should be called again.
	 * 
	 * @param o
	 * @return
	 */
	public final native Zoom x(LinearScale scale)/*-{
		return this.x(scale);
	}-*/;

	/**
	 * Specifies an y-scale whose domain should be automatically adjusted when
	 * zooming. If not specified, returns the current y-scale, which defaults to
	 * null. If the scale's domain or range is modified programmatically, this
	 * function should be called again.
	 * 
	 * @param o
	 * @return Zoom object
	 */

	public final native Zoom y(LinearScale scale)/*-{
		return this.y(scale);
	}-*/;

	/**
	 * Specifies the zoom scale's allowed range as a two-element array,
	 * [*minimum*, maximum]. If not specified, returns the current scale extent,
	 * which defaults to [0, Infinity].
	 * 
	 * @param o
	 * @return Zoom object
	 */
	public final native Zoom scaleExtent(double[] scale)/*-{
		return this.scaleExtent(scale);
	}-*/;

	/**
	 * Specifies the current zoom scale. If not specified, returns the current
	 * zoom scale, which defaults to 1.
	 * 
	 * @param o
	 * @return Zoom object
	 */
	public final native Zoom scale(LinearScale scale)/*-{
		return this.scale(scale);
	}-*/;

	/**
	 * Specifies the current zoom translation vector. If not specified, returns
	 * the current translation vector, which defaults to [0, 0].
	 * 
	 * @param o
	 * @return Zoom object
	 */
	public final native Zoom translate(double[] vector)/*-{
		return this.translate(vector);
	}-*/;

	/**
	 * Provide access to the properties of a zoom event.
	 * <p>
	 * Use {@link D3#zoomEvent()} from within a
	 * {@link Zoom#on(ZoomEventType, DatumFunction)} listener.
	 * <p>
	 * 
	 * @author <a href="mailto:schiochetanthoni@gmail.com">Anthony Schiochet</a>
	 * 
	 */

	public static class ZoomEvent extends JavaScriptObject {

		protected ZoomEvent() {

		}

		/**
		 * The scale of the zoom
		 * <p>
		 * 
		 * @return the scale of the zoom
		 */

		public native final double scale()/*-{
			return this.scale;
		}-*/;

		/**
		 * A two-element array representing the current translation vector.
		 * 
		 * @return the translation vector
		 */

		public native final Array<Double> translate()/*-{
			return this.translate;
		}-*/;

		/**
		 * Shortcut to translate().getNumber(0).
		 * 
		 * @return the translation x coord
		 */

		public native final double translateX()/*-{

			return this.translate[0];

		}-*/;

		/**
		 * Shortcut to translate().getNumber(1).
		 * 
		 * @return the translation y coord
		 */

		public native final double translateY()/*-{

			return this.translate[1];

		}-*/;
	}
}
