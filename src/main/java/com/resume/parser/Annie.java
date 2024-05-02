package com.resume.parser;

import java.io.*;

import gate.*;
import gate.util.*;
import gate.util.persistence.PersistenceManager;

public class Annie {

	private CorpusController annieController;

/*	public void initAnnie() throws GateException, IOException {
		File gateHome = Gate.getGateHome();
		File annieGapp = new File(gateHome, "ANNIEResumeParser.gapp");
		annieController = (CorpusController) PersistenceManager.loadObjectFromFile(annieGapp);
	}*/
	public void initAnnie() throws GateException, IOException {
		// Chemin absolu vers le fichier .gapp
		String absolutePath = "C:\\Users\\user2024\\Downloads\\resume-parser\\GATEFiles\\ANNIEResumeParser.gapp";
		File annieGapp = new File(absolutePath);
		annieController = (CorpusController) PersistenceManager.loadObjectFromFile(annieGapp);
	}
	public void setCorpus(Corpus corpus) {
		annieController.setCorpus(corpus);
	}

	public void execute() throws GateException {
		annieController.execute();
	}
}
