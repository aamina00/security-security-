//AAMINA BINTE KHURRAM -

import java.util.Date; //importing Date class

public class Alarm extends SecuritySystem {

    //attributes unique to class Alarm

    String sound; //may be beeping, ringing etc
    double volume; //in decibels

    //---------------------------------------METHODS UNIQUE TO ALARM CLASS------------------------------------------

    //setters and getters
    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    //for over-ridden reset function of Alarm class
    public void resetAll() {
        super.reset();
        sound = "beeping";
        volume = 100;
    }

    //----------------------------------------------CONSTRUCTORS-------------------------------------------------------

    //default constructor
    public Alarm() {
        super();
        sound = "beeping";
        volume = 100;
    }
    //fully parametrized constructor
    public Alarm(Date dateOfInstallation, String placeOfInstallation, boolean isOn, boolean isWorking, String sound, double volume) {
        super(dateOfInstallation, placeOfInstallation, isOn, isWorking);
        this.sound = sound;
        this.volume = volume;
    }

    //------------------------------------------------OVERRIDDEN METHODS------------------------------------------------

    //overriding toString()
    @Override
    public String toString() {
        insideSubClass = true; //setting to true so that redundancy does not occur when calling parent class toString()
        return (
                "Calling toString() of class Alarm:\nAn object of " + this.getClass().getName() + " class.\n" +
                        "Sound(ringing/beeping etc): " + getSound() + "\nVolume(in decibels): " + getVolume() +
                        "\n"
        );
    }
    //overriding reset()
    @Override
    public void reset() {
        System.out.println("Alarm has been reset.");
        resetAll();
    }
    //overriding switchOn()
    @Override
    public void switchOn() {
        System.out.println("!!A " + getSound() + " alarm of " + getVolume() + " decibels has been switched on!!");
        setIsOn(true);
    }
    //overriding switchOff()
    @Override
    public void switchOff() {
        System.out.println("Alarm is off.");
        setIsOn(false);
    }
}
