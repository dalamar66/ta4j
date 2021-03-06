/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 Marc de Verdelhan & respective authors (see AUTHORS)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package eu.verdelhan.ta4j.indicators.oscillators;

import eu.verdelhan.ta4j.Indicator;
import eu.verdelhan.ta4j.Decimal;
import eu.verdelhan.ta4j.indicators.CachedIndicator;
import eu.verdelhan.ta4j.indicators.trackers.SMAIndicator;

/**
 * Awesome oscillator. (AO)
 * <p>
 * @see http://www.forexgurus.co.uk/indicators/awesome-oscillator
 */
public class AwesomeOscillatorIndicator extends CachedIndicator<Decimal> {

    private SMAIndicator sma5;

    private SMAIndicator sma34;

    public AwesomeOscillatorIndicator(Indicator<Decimal> indicator, int timeFrameSma1, int timeFrameSma2) {
        super(indicator);
        this.sma5 = new SMAIndicator(indicator, timeFrameSma1);
        this.sma34 = new SMAIndicator(indicator, timeFrameSma2);
    }

    public AwesomeOscillatorIndicator(Indicator<Decimal> indicator) {
        this(indicator, 5, 34);
    }

    @Override
    protected Decimal calculate(int index) {
        return sma5.getValue(index).minus(sma34.getValue(index));
    }
}
