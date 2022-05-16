import java.util.Date;

public class SecuritySystem {
    private Date dateOfInstallation;
    private String placeOfInstallation;
    private boolean isOn;
    private boolean isWorking;

    private void switchOn() {
        System.out.println("Element has been switched on.");
        isOn = true;

    }

    private void switchOff() {
        System.out.println("Element has been switched off." );
        isOn = false;
    }

    private void reset() {
        System.out.println("Element has been reset." );
        isOn = false;
    }

    public SecuritySystem() {
        this.dateOfInstallation = new Date();
        this.placeOfInstallation = "Islamabad";
        this.isOn = false;
        this.isWorking = true;
    }

    public SecuritySystem(Date dateOfInstallation, String placeOfInstallation, boolean isOn, boolean isWorking) {
        this.dateOfInstallation = dateOfInstallation;
        this.placeOfInstallation = placeOfInstallation;
        this.isOn = isOn;
        this.isWorking = isWorking;
    }

    public SecuritySystem(Date dateOfInstallation, String placeOfInstallation, boolean isOn) {
        this.dateOfInstallation = dateOfInstallation;
        this.placeOfInstallation = placeOfInstallation;
        this.isOn = isOn;
        this.isWorking = true;
    }

    public SecuritySystem(Date dateOfInstallation, String placeOfInstallation) {
        this.dateOfInstallation = dateOfInstallation;
        this.placeOfInstallation = placeOfInstallation;
        this.isOn = false;
        this.isWorking = true;
    }

    public SecuritySystem(Date dateOfInstallation) {
        this.dateOfInstallation = dateOfInstallation;
        this.placeOfInstallation = "Islamabad";
        this.isOn = false;
        this.isWorking = true;
    }

    public SecuritySystem(boolean isOn) {
        this.isOn = isOn;
        this.dateOfInstallation = new Date();
        this.placeOfInstallation = "Islamabad";
        this.isWorking = true;
    }

    public SecuritySystem(boolean isOn, boolean isWorking) {
        this.isOn = isOn;
        this.isWorking = isWorking;
        this.dateOfInstallation = new Date();
        this.placeOfInstallation = "Islamabad";
    }

    public SecuritySystem(String placeOfInstallation) {
        this.placeOfInstallation = placeOfInstallation;
        this.dateOfInstallation = new Date();
        this.isOn = false;
        this.isWorking = true;
    }

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

    public void getIsOn(boolean on_offState) {
        this.isOn = on_offState;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }
    public static void main(String[] args){
        Date today = new Date();
        System.out.println(today);
    }
}


