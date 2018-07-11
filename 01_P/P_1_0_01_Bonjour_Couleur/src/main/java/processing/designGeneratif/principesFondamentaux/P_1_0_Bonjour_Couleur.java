// P_1_0_01.pde
// 
// Generative Gestaltung, ISBN: 978-3-87439-759-9
// First Edition, Hermann Schmidt, Mainz, 2009
// Hartmut Bohnacker, Benedikt Gross, Julia Laub, Claudius Lazzeroni
// Copyright 2009 Hartmut Bohnacker, Benedikt Gross, Julia Laub, Claudius Lazzeroni
//
// http://www.generative-gestaltung.de
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * changing colors and size by moving the mouse
 * 	 
 * MOUSE
 * position x          : size
 * position y          : color
 * 
 * KEYS
 * s                   : save png
 * p                   : save pdf
 * q				   : quit
 */

package processing.designGeneratif.principesFondamentaux;
import processing.core.PApplet;
import processing.designGeneratif.utils.version.TheVersionClass;
import processing.pdf.*;

import java.io.IOException;
import java.util.Calendar;

@SuppressWarnings("unused")
public class P_1_0_Bonjour_Couleur extends PApplet {
	boolean savePDF = false;


	public static void main( String[] args ) {
		String path;
		/*
	 		Version: 0.0.1-SNAPSHOT
			groupId: processing.designGeneratif.principesFondamentaux
			artifactId: P_1_0_Bonjour_Couleur
			Path: processing.designGeneratif.principesFondamentaux.P_1_0_Bonjour_Couleur
		 */
		
		TheVersionClass theVersion = new TheVersionClass();
		path = theVersion.getPath();
		
		//PApplet.main("processing.designGeneratif.principesFondamentaux.P_1_0_Bonjour_Couleur");	
		PApplet.main(path);	
		
	}

	@Override
	public void settings() {
		size(720, 720);
	}    

	@Override
	public void setup() {
		noCursor();
	}

	@Override
	public void draw() {
		// this line will start pdf export, if the variable savePDF was set to true 
		if (savePDF) beginRecord(PDF, timestamp()+".pdf");

		colorMode(HSB, 360, 100, 100);
		rectMode(CENTER); 
		noStroke();
		background(mouseY/2, 100, 100);

		fill(360-mouseY/2, 100, 100);
		rect(360, 360, mouseX+1, mouseX+1);

		// end of pdf recording
		if (savePDF) {
			savePDF = false;
			endRecord();
		}
	}

	@Override
	public void keyPressed() {
		if (key=='s' || key=='S') saveFrame(timestamp()+"_##.png");
		if (key=='p' || key=='P') savePDF = true;
		if (key=='q' || key=='Q') fin();
	}


	String timestamp() {
		Calendar now = Calendar.getInstance();
		return String.format("%1$ty%1$tm%1$td_%1$tH%1$tM%1$tS", now);
	}   
	
	public void fin() {
		System.out.println("Exit ...");
		dispose();
		System.exit(0);
	}

}
