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
/**
 * 
 */
package com.github.gwtd3.api.scales;

import com.github.gwtd3.api.arrays.Array;
import com.github.gwtd3.api.core.Formatter;

/**
 * Power scales are similar to linear scales, except there's an exponential
 * transform that is applied to the input domain value before the output range
 * value is computed.
 * <p>
 * The mapping to the output range value y can be expressed as a function of the
 * input domain value x: y = mx^k + b, where k is the exponent value.
 * <p>
 * Power scales also support negative values, in which case the input value is
 * multiplied by -1, and the resulting output value is also multiplied by -1.
 * <p>
 * As with {@link LinearScale}s, power scales can also accept more than two
 * values for the domain and range, thus resulting in polypower scale.
 * <p>
 * 
 * @author <a href="mailto:schiochetanthoni@gmail.com">Anthony Schiochet</a>
 * 
 */
public class PowScale extends ContinuousQuantitativeScale<PowScale> {

	protected PowScale() {

	}

	// =========== base ==========
	/**
	 * Returns the current exponent, which defaults to 1.
	 * 
	 * @return the current exponent
	 */
	public native final double exponent()/*-{
		return this.exponent();
	}-*/;

	/**
	 * Sets the current exponent to the given numeric value.
	 * 
	 * @return the current scale
	 */
	public native final PowScale exponent(double e)/*-{
		return this.exponent(e);
	}-*/;

	// =========== nice ==========

	/**
	 * Extends the domain so that it starts and ends on nice round values.
	 * <p>
	 * This method typically modifies the scale's domain, and may only extend
	 * the bounds to the nearest round value.
	 * <p>
	 * The precision of the round value is dependent on the extent of the domain
	 * dx according to the following formula: exp(round(log(*dx*)) - 1).
	 * <p>
	 * Nicing is useful if the domain is computed from data and may be
	 * irregular.
	 * <p>
	 * For example, for a domain of [0.20147987687960267, 0.996679553296417],
	 * the nice domain is [0.2, 1]. If the domain has more than two values,
	 * nicing the domain only affects the first and last value.
	 * <p>
	 * 
	 * @return the current scale
	 */
	public native final PowScale nice()/*-{
		return this.nice();
	}-*/;

	/**
	 * Same as {@link #nice()} but with more control.
	 * <p>
	 * The tick count argument allows greater control over the step size used to
	 * extend the bounds, guaranteeing that the ticks returned by
	 * {@link #ticks(int)} will exactly cover the domain.
	 * <p>
	 * 
	 * @return the current scale
	 */
	public native final PowScale nice(int count)/*-{
		return this.nice(count);
	}-*/;

	// =========== ticks ==========

	/**
	 * Returns approximately count representative values from the scale's input
	 * domain.
	 * <p>
	 * The returned tick values are uniformly spaced, have human-readable values
	 * (such as multiples of powers of 10), and are guaranteed to be within the
	 * extent of the input domain.
	 * <p>
	 * Ticks are often used to display reference lines, or tick marks, in
	 * conjunction with the visualized data. The specified count is only a hint;
	 * the scale may return more or fewer values depending on the input domain.
	 * <p>
	 * 
	 *
	 */
	public native final <T> Array<T> ticks(int count)/*-{
		return this.ticks(count);
	}-*/;

	/**
	 * Alias for {@link #ticks(int) ticks(10)}.
	 * 
	 * @return the array of reference ticks
	 */
	public native final <T> Array<T> ticks()/*-{
		return this.ticks(count);
	}-*/;

	// =========== tickFormat ==========

	/**
	 * Returns a number format function suitable for displaying a tick value.
	 * <p>
	 * The returned tick format is implemented as d.toPrecision(1).
	 * <p>
	 * 
	 * @return the number format
	 */
	public native final Formatter tickFormat()/*-{
		return this.tickFormat();
	}-*/;

	/**
	 * Returns a number format function suitable for displaying a tick value.
	 * <p>
	 * The specified count should have the same value as the count that is used
	 * to generate the tick values you want to display.
	 * <p>
	 * You don't have to use the scale's built-in tick format, but it
	 * automatically computes the appropriate precision based on the fixed
	 * interval between tick values.
	 * <p>
	 * 
	 * @param count
	 *            the number of ticks to take into account to create the
	 *            {@link Formatter}.
	 * @return a number format
	 */
	public native final Formatter tickFormat(int count)/*-{
		return this.tickFormat(count);
	}-*/;

	/**
	 * Returns a number format function suitable for displaying a tick value.
	 * <p>
	 * This is the same as {@link #tickFormat(int)}, except that the format
	 * argument allows a format specifier to be specified.
	 * <p>
	 * If the format specifier doesn’t have a defined precision, the precision
	 * will be set automatically by the scale, returning the appropriate format.
	 * <p>
	 * This provides a convenient, declarative way of specifying a format whose
	 * precision will be automatically set by the scale.
	 * <p>
	 * 
	 * @param count
	 *            the number of ticks to take into account to create the
	 *            {@link Formatter}.
	 * @param formatSpecifier
	 *            the format specified, as documented in {@link Formatter}, to be
	 *            used as a basis of the Formatter.
	 * @return a number format
	 */
	public native final Formatter tickFormat(int count, String formatSpecifier)/*-{
		return this.tickFormat(count, formatSpecifier);
	}-*/;

}
