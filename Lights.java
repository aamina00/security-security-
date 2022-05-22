//AAMINA BINTE KHURRAM

import java.util.Date; //importing Date class

public class Lights extends SecuritySystem {

    //attributes unique to class Lights

    String color;
    boolean blinking; //true if light blinks, false if continuous light
    boolean rotating; //true if light is rotating else false

    //---------------------------------------METHODS UNIQUE TO LIGHTS CLASS------------------------------------------

    //SETTERS AND GETTERS
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isBlinking() {
        return blinking;
    }

    public void setBlinking(boolean blinks) {
        this.blinking = blinks;
    }

    public boolean isRotating() {
        return rotating;
    }

    public void setRotating(boolean rotating) {
        this.rotating = rotating;
    }

    //method to rotate security light
    public void rotate() {
        if (getIsOn()) {
            System.out.println("Security light is rotating.");
            setRotating(true);
        } else {
            System.out.println("Security light is off. To rotate light, first turn it on.");
        }
    }
    //method to make security light blink
    public void blink() {
        if (getIsOn()) {
            System.out.println("Security light is blinking.");
            setBlinking(true);
        } else {
            System.out.println("Security light is off. To make light blink, first turn it on.");
        }
    }
    //method to stop rotation of security light
    public void stopRotating() {
        if (isRotating()) {
            System.out.println("Security light is no longer rotating.");
            setRotating(false);
        }
    }
    //method to stop blinking of security light
    public void stopBlinking() {
        if (isBlinking()) {
            System.out.println("Security light is no longer blinking.");
            setBlinking(false);
        }
    }
    //method used in overridden reset method
    public void resetAll() {
        super.reset();
        blinking = true;
        rotating = true;
        color = "red";
    }

    //----------------------------------------------CONSTRUCTORS-------------------------------------------------------

    //default constructor
    public Lights() {
        super();
        blinking = true;
        rotating = true;
        color = "red";
    }
    //completely parametrized constructor
    public Lights(Date dateOfInstallation, String placeOfInstallation, boolean isOn, boolean isWorking, String color, boolean blinks) {
        super(dateOfInstallation, placeOfInstallation, isOn, isWorking);
        this.color = color;
        this.blinking = blinks;
    }
    //------------------------------------------------OVERRIDDEN METHODS------------------------------------------------

    //overriding toString()
    @Override
    public String toString() {
        return (
                "Calling toString() of class Lights:\nAn object of " + this.getClass().getName() + " class.\n" +
                        "Color: " + getColor() + "\nRotating: " + (isRotating() ? "yes" : "no") + "\nBlinking: " +
                        (isBlinking() ? "yes" : "no") +
                        "\n"
        );
    }

    //overriding reset()
    @Override
    public void reset() {
        System.out.println("Light has been reset.");
        resetAll();
    }
    //overriding switchOn()
    @Override
    public void switchOn() {
        System.out.println("!! " + getColor().toUpperCase() + " security light is ON!!");
        setIsOn(true);
    }
    //overriding switchOff()
    @Override
    public void switchOff() {
        System.out.println("Security light has been turned off.");
        setIsOn(false);
    }
}
