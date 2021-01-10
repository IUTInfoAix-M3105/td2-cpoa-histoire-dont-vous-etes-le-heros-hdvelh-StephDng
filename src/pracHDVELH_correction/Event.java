/**
 * File: NodeMultipleEvents.java
 * Creation: 7 nov. 2020, Jean-Philippe.Prost@univ-amu.fr
 * Template étudiants
 */
package pracHDVELH;

import java.util.Scanner;

import myUtils.ErrorNaiveHandler;

/**
 * @author prost
 * @contributeur : Erwann LUBRANO
 */
public class Event extends NodeMultiple {
    public static final String ERROR_MSG_UNEXPECTED_END = "Sorry, for some unexpected reason the story ends here...";
    public static final String PROMPT_ANSWER = "Answer: ";
    public static final String WARNING_MSG_INTEGER_EXPECTED = "Please input a integer within range!";

    private GUIManager gui;
    private String playerAnswer = null;
    private int chosenPath;
    private int id;

    public Event(GUIManager gui, String data){
        this.gui = gui;
        super.setData(data);
    }

    public Event(){
        gui = new GUIManager();
    }

    @java.lang.Override
    public String toString() {
        return "Event #" + getId() + " ([class]):" + getData();
    }

    /**
     * @return the playerAnswer
     */
    public String getPlayerAnswer() {
        return playerAnswer;
    }

    /**
     * @param playerAnswer the playerAnswer to set
     */
    public void setPlayerAnswer(String playerAnswer) {
        this.playerAnswer = playerAnswer;
    }

    /**
     * @return the reader
     */
    public Scanner getReader() {
        return gui.getInputReader();
    }

    /**
     * @param reader the reader to set
     */
    public void setReader(Scanner reader) {
        gui.setInputReader(reader);
    }

    /**
     * @return the chosenPath
     */
    public int getChosenPath() {
        return chosenPath;
    }

    /**
     * @param chosenPath the chosenPath to set
     */
    public void setChosenPath(int chosenPath) {
        this.chosenPath = chosenPath;
    }

    /* Methods */
    /**
     * @see pracHDVELH.NodeMultiple#getData()
     */
    public String getData() {
        return super.getData().toString();
    }

    /**
     * @see pracHDVELH.NodeMultiple#setData(Object)
     * @param data
     */
    public void setData(String data) {
        super.setData(data);
    }

    /**
     * @see pracHDVELH.NodeMultiple#getDaughter(int)
     */
    @Override
    public Event getDaughter(int i) {
        return (Event) super.getDaughter(i);
    }

    /**
     * @see pracHDVELH.NodeMultiple#setDaughter(NodeMultiple, int)
     * @param daughter
     * @param i
     */
    public void setDaughter(Event daughter, int i) {
        super.setDaughter(daughter,i);
    }

    /**
     * @return the gui
     */
    public GUIManager getGui() {
        return gui;
    }

    /**
     * @param gui the gui to set
     */
    public void setGui(GUIManager gui) {
        this.gui = gui;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /* Methods */
    /* TO BE COMPLETED */
    public Event run(){
        gui.output(getData());
        int i = gui.getAnswer()-1;

        if(i > NODE_MAX_ARITY)return null;
        return getDaughter(i);
    }
}

// eof