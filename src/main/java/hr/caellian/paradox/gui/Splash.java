/*
 * The MIT License (MIT)
 * Paradox Generator, random sentence generator.
 * Copyright (c) 2017 Tin Švagelj <tin.svagelj@live.com> a.k.a. Caellian
 *
 * Permission is hereby granted, free of charge, to any person obtaining a
 * copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package hr.caellian.paradox.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 21.4.2015. at 15:23.
 */
public abstract class Splash extends JFrame {

    public Graphics2D g;
    public SplashScreen splashScreen;

    public Splash() {
        splashScreen = SplashScreen.getSplashScreen();
        if (splashScreen == null) {
            System.err.println("Unable to initialize splash screen!");
            return;
        }

        g = splashScreen.createGraphics();
        g.setComposite(AlphaComposite.Clear);
        setupGraphics(g);
    }

    public void close() {
        if (splashScreen != null) splashScreen.close();
    }

    public abstract void setupGraphics(Graphics2D g);

    public void renderState(Object... state){
        if (splashScreen != null) renderState(g, state);
    }

    public abstract void renderState(Graphics2D g, Object... state);
}
