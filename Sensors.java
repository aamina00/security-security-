//AAMINA BINTE KHURRAM

public class Sensors extends SecuritySystem {

    //---------------------------------------ATTRIBUTES UNIQUE TO SENSORS CLASS------------------------------------------

    private double range;//in feet
    private String sensitivity; //low, medium, high
    private double weight; //in g
    private double vol;  //in cubic cm

    //---------------------------------------METHODS UNIQUE TO ALARM CLASS------------------------------------------

    public void detect() {
        System.out.println("Danger has been detected!");
    } //detection of hazard

    public void getHelp() {
        System.out.println("Calling for help.");
    } //calling for help i.e. police, ambulance etc
    //resetting sensor
    public void resetAll() {
        super.reset();
        setRange(3);
        setSensitivity("high");
        setWeight(100);
        setVol(250);
    }
    //setters and getters
    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public String getSensitivity() {
        return sensitivity;
    }

    public void setSensitivity(String sensitivity) {
        this.sensitivity = sensitivity;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVol() {
        return vol;
    }

    public void setVol(double volume) {
        this.vol = volume;
    }

    //----------------------------------------------CONSTRUCTORS-------------------------------------------------------

    //default constructor
    public Sensors() {
        super();
        setRange(3);
        setSensitivity("high");
        setWeight(100);
        setVol(250);
    }

    //completely parametrized constructor
    public Sensors(double range, String sensitivity, double weight, double volume) {
        super();
        this.range = range;
        this.sensitivity = sensitivity;
        this.weight = weight;
        this.vol = volume;

    }

    //------------------------------------------------OVERRIDDEN METHODS------------------------------------------------

    //overriding reset()
    @Override
    public void reset() {
        resetAll();
        System.out.println("Sensor has been reset.");
    }
    //overriding switchOn()
    @Override
    public void switchOn() {
        System.out.println("Sensor is on.");
        setIsOn(true);
    }
    //overriding switchOff()
    @Override
    public void switchOff() {
        System.out.println("Sensor is off.");
        setIsOn(false);
    }
    //overriding toString()
    @Override
    public String toString() {
        //if call to super.toString() is from within a subclass, class name is not included in main toString()
        // to avoid redundancy
        if (insideSubClass) {
            return (super.toString() +
                    "\nCalling toString() of class Sensors:" + "\n" +
                    "Range(in feet): " + getRange() + "\nSensitivity(low/medium/high): " + getSensitivity() +
                    "\nWeight(in grams): " + getWeight() + "\nVolume(in cubic cm): " + getVol() +
                    "\n"
            );
        } else {
            insideSubClass = true;
            return ("\nCalling toString() of class Sensors:\nThis is a " + this.getClass().getName() + "\n" +
                    "Range(in feet): " + getRange() + "\nSensitivity(low/medium/high): " + getSensitivity() +
                    "\nWeight(in grams): " + getWeight() + "\nVolume(in cubic cm): " + getVol() +
                    "\n\n");
        }
    }
}

/*
Types of sensors:
1) SmokeDetector
2) GasDetector
3) CarbonMonoxideDetector
4) GlassBreakDetector
5) InfraredMotionDetector
6) WindowSensor
7) DoorSensor
8) PressureDetector
*/

//------------------------------------------------SUBCLASSES OF SENSORS CLASS------------------------------------------------

//smoke detectors detect smoke
class SmokeDetector extends Sensors {

    boolean waterReleased; //attribute controlling release of water spray

    //-----------------------------------method unique to sensor subclass------------------------------------------------
    public void sprayWater() {
        setWaterReleased(true);
        System.out.println("Water stream has been released.");
    }
    //setters and getters
    public boolean isWaterReleased() {
        return waterReleased;
    }
    public void setWaterReleased(boolean waterReleased) {
        this.waterReleased = waterReleased;
    }

    //---------------------------------------------constructors-------------------------------------------------------
    //default
    public SmokeDetector() {
        super();
        setWaterReleased(false);
    }
    //parametrized
    public SmokeDetector(double range, String sensitivity, double weight, double volume, boolean waterReleased) {
        super(range, sensitivity, weight, volume);
        setWaterReleased(waterReleased);
    }

    //-----------------------------------------------overridden methods-----------------------------------------------

    @Override
    public void detect() {
        System.out.println("Smoke has been detected!");
        Lights smokeLight = new Lights();
        smokeLight.switchOn();
        smokeLight.rotate();
        Alarm smokeAlarm = new Alarm();
        smokeAlarm.switchOn();
    }

    @Override
    public void reset() {
        System.out.println("SmokeDetector has been reset.");
        resetAll();
        setWaterReleased(false);
    }

    @Override
    public void getHelp() {
        System.out.println("Fire brigade has been called.");
    }

    @Override
    public String toString() {
        insideSubClass = true;
        return (super.toString() +
                "This is a " + this.getClass().getName() + "\n" +
                "Water sprayed? " + (isWaterReleased() ? "yes" : "no") +
                "\n"
        );
    }
}

// gas detectors detect gas in surroundings
class GasDetector extends Sensors {

    boolean gasMasksCanBeAccessed; //attribute controlling access to gas masks
    boolean areVentsOpen; //attribute controlling opening of vents

    //-----------------------------------methods unique to sensor subclass------------------------------------------------

    //setters and getters
    public boolean isGasMasksCanBeAccessed() {
        return gasMasksCanBeAccessed;
    }

    public void setGasMasksCanBeAccessed(boolean gasMasksCanBeAccessed) {
        this.gasMasksCanBeAccessed = gasMasksCanBeAccessed;
    }

    public void setAreVentsOpen(boolean areVentsOpen) {
        this.areVentsOpen = areVentsOpen;
    }

    public boolean getAreVentsOpen() {
        return areVentsOpen;
    }
    //accessing gas masks
    public void accessGasMasks() {
        setGasMasksCanBeAccessed(true);
        System.out.println("Gas masks can now be accessed.");
    }
    //opening vents
    public void openVents() {
        setAreVentsOpen(true);
        System.out.println("Ventilation shafts have been opened.");
    }
    //---------------------------------------------constructors-------------------------------------------------------
    //default
    public GasDetector() {
        super();
        gasMasksCanBeAccessed = false;
        areVentsOpen = false;
    }
    //parametrized
    public GasDetector(double range, String sensitivity, double weight, double volume, boolean gasMasksCanBeAccessed, boolean areVentsOpen) {
        super(range, sensitivity, weight, volume);
        setGasMasksCanBeAccessed(gasMasksCanBeAccessed);
        setAreVentsOpen(areVentsOpen);
    }
    //-----------------------------------------------overridden methods-----------------------------------------------
    @Override
    public void detect() {
        System.out.println("Gas has been detected!");
        Lights gasLight = new Lights();
        gasLight.switchOn();
        Alarm gasAlarm = new Alarm();
        gasAlarm.setSound("ringing");
        gasAlarm.switchOn();
    }
    @Override
    public void reset() {
        System.out.println("GasDetector has been reset.");
        resetAll();
        gasMasksCanBeAccessed = false;
        areVentsOpen = false;
    }

    @Override
    public void getHelp() {
        System.out.println("Hospital has been called.");
        System.out.println("Ambulance is on its way.");
    }

    @Override
    public String toString() {
        insideSubClass = true;
        return (super.toString() +
                "This is a " + this.getClass().getName() + "\n" +
                "Can gas masks currently be accessed? " + (isGasMasksCanBeAccessed() ? "yes" : "no") +
                "\n" + "Are the ventilation shafts currently open? " + (getAreVentsOpen() ? "yes" : "no") +
                "\n"
        );
    }
}

// carbon monoxide detectors detect hazardous levels of carbon monoxide in the atmosphere
class CarbonMonoxideDetector extends Sensors {

    boolean windowsOpen;//attribute controlling opening of windows
    boolean ventsOpen;//attribute controlling opening of vents

    //-----------------------------------methods unique to sensor subclass----------------------------------------------

    public boolean isWindowsOpen() {
        return windowsOpen;
    }

    public void setWindowsOpen(boolean windowsOpen) {
        this.windowsOpen = windowsOpen;
    }

    public boolean isVentsOpen() {
        return ventsOpen;
    }

    public void setVentsOpen(boolean ventsOpen) {
        this.ventsOpen = ventsOpen;
    }
    //opening vents
    public void openVents() {
        setVentsOpen(true);
        System.out.println("Ventilation shafts have been opened.");
    }
    //opening windows
    public void openWindows() {
        setWindowsOpen(true);
        System.out.println("Windows have been opened.");
    }

    //---------------------------------------------constructors-------------------------------------------------------
    //default
    public CarbonMonoxideDetector() {
        super();
        windowsOpen = false;
        ventsOpen = false;
    }
    //parametrized
    public CarbonMonoxideDetector(double range, String sensitivity, double weight, double volume, boolean windowsOpen,
                                  boolean ventsOpen) {
        super(range, sensitivity, weight, volume);
        setWindowsOpen(windowsOpen);
        setVentsOpen(ventsOpen);
    }

    //-----------------------------------------------overridden methods-----------------------------------------------

    @Override
    public void reset() {
        System.out.println("CarbonMonoxideDetector has been reset.");
        resetAll();
        windowsOpen = false;
        ventsOpen = false;
    }

    @Override
    public void detect() {
        System.out.println("High levels of carbon monoxide have been detected!");
        Lights COLight = new Lights();
        COLight.switchOn();
        Alarm COalarm = new Alarm();
        COalarm.setVolume(100);
        COalarm.switchOn();
    }

    @Override
    public void getHelp() {
        System.out.println("Hospital has been called and informed of occurrence of carbon monoxide poisoning.");
    }

    @Override
    public String toString() {
        insideSubClass = true;
        return (super.toString() +
                "This is a " + this.getClass().getName() + "\n" +
                "Are the windows currently open? " + (isWindowsOpen() ? "yes" : "no") +
                "\n" + "Are the ventilation shafts currently open? " + (isVentsOpen() ? "yes" : "no") +
                "\n"
        );
    }
}

//detects shattering of glass in windows/doors
class GlassBreakDetector extends Sensors {

    boolean SMSalert;//attribute controlling sending out of text alerts

    //-----------------------------------methods unique to sensor subclass----------------------------------------------

    public boolean isSMSalert() {
        return SMSalert;
    }

    public void setSMSalert(boolean SMSalert) {
        this.SMSalert = SMSalert;
    }

    public void sendAlert() {
        setSMSalert(true);
        System.out.println("Mobile alert has been sent.");
    }

    //---------------------------------------------constructors-------------------------------------------------------

    public GlassBreakDetector() {
        super();
        setSMSalert(false);
    }

    public GlassBreakDetector(double range, String sensitivity, double weight, double volume, boolean SMSalert) {
        super(range, sensitivity, weight, volume);
        setSMSalert(SMSalert);
    }

    //-----------------------------------------------overridden methods-----------------------------------------------

    @Override
    public void reset() {
        System.out.println("GlassBreakDetector has been reset.");
        resetAll();
        setSMSalert(false);
    }

    @Override
    public void detect() {
        System.out.println("Glass breakage has been detected.");
        Lights glassBreakLight = new Lights();
        glassBreakLight.switchOn();
        Alarm glassBreakAlarm = new Alarm();
        glassBreakAlarm.switchOn();
    }

    @Override
    public void getHelp() {
        System.out.println("Police has been called.");
    }

    @Override
    public String toString() {
        insideSubClass = true;
        return (super.toString() +
                "This is a " + this.getClass().getName() + "\n" +
                "Have mobile alerts been sent out? " + (isSMSalert() ? "yes" : "no") +
                "\n"
        );
    }
}

//detects infrared radiation released by intruders as heat
class InfraredMotionDetector extends Sensors {

    boolean safeLocked; //true if locked, false if unlocked
    boolean doorsAndWindowsOpen; //true if open, false if closed

    //-----------------------------------methods unique to sensor subclass----------------------------------------------

    public boolean isDoorsAndWindowsOpen() {
        return doorsAndWindowsOpen;
    }

    public void setDoorsAndWindowsOpen(boolean doorsAndWindowssOpen) {
        this.doorsAndWindowsOpen = doorsAndWindowssOpen;
    }

    public boolean isSafeLocked() {
        return safeLocked;
    }

    public void setSafeLocked(boolean safeLocked) {
        this.safeLocked = safeLocked;
    }

    public void sendMobileAlert() {
        System.out.println("Mobile alert has been sent to owners.");
    }

    public void lockDoorsAndWindows() {
        setDoorsAndWindowsOpen(false);
        System.out.println("External doors have been locked.");
    }

    public void lockSafe() {
        setSafeLocked(true);
        System.out.println("Safe has been locked.");
    }

    //---------------------------------------------constructors-------------------------------------------------------

    public InfraredMotionDetector() {
        super();
        setDoorsAndWindowsOpen(true);
        setSafeLocked(false);
    }

    public InfraredMotionDetector(double range, String sensitivity, double weight, double volume, boolean safeLocked,
                                  boolean doorsAndWindowsOpen) {
        super(range, sensitivity, weight, volume);
        setDoorsAndWindowsOpen(doorsAndWindowsOpen);
        setSafeLocked(safeLocked);
    }

    //-----------------------------------------------overridden methods-----------------------------------------------

    @Override
    public void reset() {
        System.out.println("InfraredMotionDetector has been reset.");
        resetAll();
        setDoorsAndWindowsOpen(true);
        setSafeLocked(false);
    }

    @Override
    public void detect() {
        System.out.println("Suspicious motion has been detected.");
        Lights motionLight = new Lights();
        motionLight.blink();
        motionLight.switchOn();
        Alarm motionAlarm = new Alarm();
        motionAlarm.switchOn();
    }

    @Override
    public void getHelp() {
        System.out.println("Police has been called.");
    }

    @Override
    public String toString() {
        insideSubClass = true;
        return (super.toString() +
                "This is a " + this.getClass().getName() + "\n" +
                "Have doors and windows been locked? " + (isDoorsAndWindowsOpen() ? "no" : "yes") +
                "\nHas the safe been locked? " + (isSafeLocked() ? "yes" : "no") +
                "\n"
        );
    }
}

//window sensors detect opening of windows
class WindowSensor extends Sensors {

    boolean doorsOpen; //true if doors unlocked, false otherwise

    //-----------------------------------methods unique to sensor subclass----------------------------------------------

    public boolean isDoorsOpen() {
        return doorsOpen;
    }

    public void setDoorsOpen(boolean doorsOpen) {
        this.doorsOpen = doorsOpen;
    }

    public void lockDoors() {
        setDoorsOpen(false);
        System.out.println("Doors have been locked.");
    }

    //---------------------------------------------constructors-------------------------------------------------------

    public WindowSensor() {
        super();
        setDoorsOpen(true);
    }

    public WindowSensor(double range, String sensitivity, double weight, double volume, boolean doorsOpen) {
        super(range, sensitivity, weight, volume);
        setDoorsOpen(doorsOpen);
    }

    //-----------------------------------------------overridden methods-----------------------------------------------

    @Override
    public void reset() {
        System.out.println("WindowSensor has been reset.");
        resetAll();
        setDoorsOpen(true);
    }

    @Override
    public void detect() {
        System.out.println("Opening of window has been detected!");
        Lights windowLight = new Lights();
        windowLight.setColor("orange");
        windowLight.switchOn();
        Alarm windowAlarm = new Alarm();
        windowAlarm.switchOn();
    }

    @Override
    public void getHelp() {
        System.out.println("Police has been called.");
    }

    @Override
    public String toString() {
        insideSubClass = true;
        return (super.toString() +
                "This is a " + this.getClass().getName() + "\n" +
                "Have doors been locked? " + (isDoorsOpen() ? "no" : "yes") +
                "\n"
        );
    }
}

//door sensors detect opening of doors
class DoorSensor extends Sensors {

    boolean windowsOpen;//true if windows unlocked, false otherwise

    //-----------------------------------methods unique to sensor subclass----------------------------------------------

    public boolean isWindowsOpen() {
        return windowsOpen;
    }

    public void setWindowsOpen(boolean windowsOpen) {
        this.windowsOpen = windowsOpen;
    }

    public void lockWindows() {
        setWindowsOpen(false);
        System.out.println("Windows have been locked.");
    }

    //---------------------------------------------constructors-------------------------------------------------------

    public DoorSensor() {
        setWindowsOpen(true);
    }

    public DoorSensor(double range, String sensitivity, double weight, double volume, boolean windowsOpen) {
        super(range, sensitivity, weight, volume);
        setWindowsOpen(windowsOpen);
    }

    //-----------------------------------------------overridden methods-----------------------------------------------

    @Override
    public void reset() {
        System.out.println("DoorSensor has been reset.");
        resetAll();
        setWindowsOpen(true);
    }

    @Override
    public void detect() {
        System.out.println("Opening of door has been detected!");
        Lights doorLight = new Lights();
        doorLight.switchOn();
        Alarm doorAlarm = new Alarm();
        doorAlarm.switchOn();
    }

    @Override
    public void getHelp() {
        System.out.println("Police has been called.");
    }

    @Override
    public String toString() {
        insideSubClass = true;
        return (super.toString() +
                "This is a " + this.getClass().getName() + "\n" +
                "Have windows been locked? " + (isWindowsOpen() ? "no" : "yes") +
                "\n"
        );
    }
}

// pressure detectors are installed underground and can detect trespassers in the outdoor property
class PressureDetector extends Sensors {

    boolean floodlights; //true if on, false if off
    boolean guardDogsReleased; //true if released, false otherwise

    //-----------------------------------methods unique to sensor subclass----------------------------------------------

    public boolean isGuardDogsReleased() {
        return guardDogsReleased;
    }

    public void setGuardDogsReleased(boolean guardDogsReleased) {
        this.guardDogsReleased = guardDogsReleased;
    }

    public boolean isFloodlights() {
        return floodlights;
    }

    public void setFloodlights(boolean floodlights) {
        this.floodlights = floodlights;
    }

    public void releaseGuardDogs() {
        setGuardDogsReleased(true);
        System.out.println("Guard dogs have been released.");
    }

    public void turnOnFloodLights() {
        setFloodlights(true);
        System.out.println("Floodlights have been turned on.");
    }

    //---------------------------------------------constructors-------------------------------------------------------

    public PressureDetector() {
        super();
        setGuardDogsReleased(false);
        setFloodlights(false);
    }

    public PressureDetector(double range, String sensitivity, double weight, double volume, boolean floodlights, boolean guardDogsReleased) {
        super(range, sensitivity, weight, volume);
        setGuardDogsReleased(guardDogsReleased);
        setFloodlights(floodlights);
    }

    //-----------------------------------------------overridden methods-----------------------------------------------

    @Override
    public void reset() {
        System.out.println("PressureDetector has been reset.");
        resetAll();
        setGuardDogsReleased(false);
        setFloodlights(false);
    }

    @Override
    public void detect() {
        System.out.println("Change in pressure levels around outdoor infrastructure has been detected!");
        Lights pressureLight = new Lights();
        pressureLight.switchOn();
        Alarm pressureAlarm = new Alarm();
        pressureAlarm.switchOn();
    }

    @Override
    public void getHelp() {
        System.out.println("Police has been called.");
    }

    @Override
    public String toString() {
        insideSubClass = true;
        return (super.toString() +
                "This is a " + this.getClass().getName() + "\n" +
                "Have the guard dogs been released? " + (isGuardDogsReleased() ? "yes" : "no") +
                "\nHave the floodlights been switched on? " + (isFloodlights() ? "yes" : "no") +
                "\n"
        );
    }
}

