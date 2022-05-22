//AAMINA BINTE KHURRAM

import java.util.Date; //importing Date class

public abstract class SecuritySystem {

    //-----------------------------attributes common to main class and all subclasses----------------------------------

    private Date dateOfInstallation;
    private String placeOfInstallation;
    private boolean isOn;
    private boolean isWorking;
    boolean insideSubClass;

    //-----------------------------methods common to main class and all subclasses----------------------------------

    public abstract void switchOn(); //switching on element

    public abstract void switchOff(); //switching off element

    public void reset() { isWorking = true;} //resetting element

    //SETTERS AND GETTERS

    public Date getDateOfInstallation() {
        return dateOfInstallation;
    }

    public void setDateOfInstallation(Date dateOfInstallation) {
        this.dateOfInstallation = dateOfInstallation;
    }

    public String getPlaceOfInstallation() {
        return placeOfInstallation;
    }

    public void setPlaceOfInstallation(String placeOfInstallation) {
        this.placeOfInstallation = placeOfInstallation;
    }

    public boolean getIsOn() {
        return isOn;
    }

    public void setIsOn(boolean on_offState) {
        this.isOn = on_offState;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    //toString()

    public String toString() {
        //if call to super.toString() is from within a subclass, class name is not included in main toString()
        // to avoid redundancy
        if (insideSubClass) {
            return (
                    "\nCalling toString() of class SecuritySystem:\n" + "\n" +
                            "Date of installation: " + getDateOfInstallation() + "\nPlace of installation: " + getPlaceOfInstallation() +
                            "\nOn/off state: " + (getIsOn() ? "on" : "off") + "\nDevice function/malfunction: " + (isWorking() ? "functioning" : "out-of-order") +
                            "\n\n"
            );
        } else {
            return (
                    "\nCalling toString() of class SecuritySystem:\nAn object of " + this.getClass().getName() + "class.\n" +
                            "Date of installation: " + getDateOfInstallation() + "\nPlace of installation: " + getPlaceOfInstallation() +
                            "\nOn/off state: " + (getIsOn() ? "on" : "off") + "\nDevice function/malfunction: " + (isWorking() ? "functioning" : "out-of-order") +
                            "\n\n"
            );
        }
    }

    //---------------------------------------constructors---------------------------------------------------------------
    //default
    public SecuritySystem() {
        setDateOfInstallation(new Date());
        setPlaceOfInstallation("Islamabad");
        this.isOn = true;
        setWorking(true);
    }
    //completely parametrized
    public SecuritySystem(Date dateOfInstallation, String placeOfInstallation, boolean isOn, boolean isWorking) {
        setDateOfInstallation(dateOfInstallation);
        setPlaceOfInstallation(placeOfInstallation);
        this.isOn = isOn;
        setWorking(isWorking);
    }
}


