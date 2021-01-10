/**
 * File: ScenarioDG.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

/**
 * @author prost
 * @mise à jour : Stéphanie DANG
 */

public class Scenario {
	private static final String MSG_EMPTY_SCENARIO = "Sorry, no scenario was found.";
	private static final String MSG_FINALE = "That's all folks!";
	private Event head;
	private GUIManager gui;

	public Scenario(GUIManager gui, Event head){
		this.gui = gui;
		this.head = head;
	}

	public String run (){
		if (head == null)
		{
			this.gui.output(this.MSG_EMPTY_SCENARIO);
			return this.MSG_EMPTY_SCENARIO;
		}
		Event currentEvent = this.getHead();
		return currentEvent.run();
	}

	/* MAIN */
	public static void main(String[] args) {
		Scenario scenario;
		GUIManager gui = new GUIManager(System.in, System.out, System.err);


		Event event0 = new Event (gui, "Vous êtes en retard pour aller en cours \n"
			+ "Vous continuez votre route -> 2 \n"
			+ "Tant pis, vous faites demi tour pour rentrer chez vous -> 1 \n");

		Event event2 = new Event (gui, "Vous avez faim. Vous voyez une caféteria \n"
			+ "Vous y allez, et vous prenez un petit encas -> 6 \n"
			+ "Vous y allez sans hésiter pour vous prendre votre meilleur petit déjeuner -> 7 \n"
			+ "Tant pis, vous continuez votre chemin -> 8 \n");

		Event event1 = new Event (gui, "Votre maison n'est pas loin, vous hésitez encore à l'idée d'aller en cours"
			+ "Vous ne flanchez pas, vous allez vite en cours -> 5 \n"
			+ "Vous faites demi tour -> 4\n");

		Event event6 = new Event (gui, "Vous prenez votre pain au chocolat et vous vous barrez -> 1 \n");

		Event event7 = new Event (gui, "Vous avez perdu trop de temps à manger. Vous avez raté voter cours à cause de votre gourmandise -> 0");

		Event event8 = new Event (gui, "Vous être à un arrêt de bus, mais vous ne savez pas quand est-ce qu'il passe."
			+ "Vous attendez le bus pour aller en cours -> 8 \n"
			+ "Vous continuez le chemin à pied -> 9 \n");

		Event event4 = new Event (gui, "De retour chez vous, vouq tapez votre meilleur sieste -> 0 \n");

		Event event9 = new Event (gui, "Plusieurs chemins s'opposent"
			+ "Vous emprunter le chemin habité -> 2 \n"
			+ "Vous emprunter le chemin de sentier battu -> 3 \n"
			+ "Vous passez par un parc -> 3 \n"
			+ "Vous passez par un tunnel -> 3 \n");

		Event event3 = new Event (gui, "Vous êtes bien arrivés à destination. Vous entrez en classe en toquant la porte. Le prof de nous accepte pas. \n La prochaine fois, soyez à l'heure");

		Event event5 = new Event (gui, "Vous vous dépechez pour aller en cours -> 3 \n");



		// S
		// *1:event1
		// **1.1
		// ***S
		// **1.2
		// ***E
		// *2:event2
		// **2.1
		// ***1
		// **2.2
		// ***S

		//C'est un exemple de scénario
//		Event startEvent = new Event(gui, "Go!\n" + "(1)1 (2)2");
//		Event event1 = new Event(gui, "event1:\n" + "(1)1.1 (2)1.2");
//		Event event2 = new Event(gui, "event2:\n" + "(1)2.1 (2)2.2");
//		Event endEvent = new Event(gui, "End event: that's it :-)");
//		startEvent.addDaughter(event1);
//		startEvent.setDaughter(event2, 1);
//		event1.addDaughter(startEvent);
//		event1.addDaughter(endEvent);
//		event2.addDaughter(event1);
//		event2.addDaughter(startEvent);
		scenario = new Scenario(gui, event0);

		event0.setDaughter(event2, 2);
		event0.setDaughter(event1,1);
		event0.addDaughter(event1);
		event0.addDaughter(event2);

		event1.setDaughter(event5, 5);
		event1.setDaughter(event4, 4);
		event1.addDaughter(event4);
		event1.addDaughter(event5);

		event2.setDaughter(event6, 6);
		event2.setDaughter(event7, 7);
		event2.setDaughter(event8, 8);
		event2.addDaughter(event6);
		event2.addDaughter(event7);
		event2.addDaughter(event8);

		event4.setDaughter(event0, 0);
		event4.addDaughter(event0);

		event5.setDaughter(event3, 3);
		event6.setDaughter(event1, 1);
		event7.setDaughter(event0, 0);
		event8.setDaughter(event8, 8);
		event8.setDaughter(event9, 9);
		event9.setDaughter(event2, 2);
		event9.setDaughter(event3, 3);


		event0.addDaughter(event1);
		event0.

		// *2
		// ...
		// **2.3:event3
		// ***E
		// ***event3

//		Event event3 = new EventExactSolution(gui, "Wizard: how much is worth pi?", "3.14159");
//		event2.setData(event2.getData() + " (3)2.3");
//		event2.addDaughter(event3);
//		event3.addDaughter(endEvent);
//		event3.addDaughter(event3);

		/* ******* */
		// **2.3
		// ***event4
		// ****event2
		// ****E
		// ****event3
		// ...

		int[] mask = { 3, 6, 7 };
		Event event4 = new EventRandomSolution(gui, "Random choice of the next event...", mask, "Dice rolling... Roll=",
				"\nNext event is ");
		event3.setDaughter(event4, 0);
		event4.addDaughter(event2);
		event4.addDaughter(event3);
		scenario = new Scenario(gui, event0);

		System.out.println(scenario.run());

	}
}

// eof
