//AAMINA BINTE KHURRAM

import java.util.Scanner; //importing Scanner class

public class TestSecuritySystem {
    public static void main(String[] args) {
        testing(); //calling testing function
    }

    public static void testing() {
        Sensors[] testArr = new Sensors[8]; //creating a polymorphic array
        testArr[0] = new SmokeDetector();
        testArr[1] = new GasDetector();
        testArr[2] = new CarbonMonoxideDetector();
        testArr[3] = new GlassBreakDetector();
        testArr[4] = new InfraredMotionDetector();
        testArr[5] = new WindowSensor();
        testArr[6] = new DoorSensor();
        testArr[7] = new PressureDetector();

        boolean show = true; //boolean value show controls flow in do-while loop, and in inner for-loop
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome!\nPlease type 1 if u wish to see tests of sensors.");
            if (!(input.next().equals("1"))) //testing begins i.e. loop entered only if user wishes to see tests
            {
                show = false;
            }
            else {
                for (int i = 0; i < 8; i++) {
                    //---------------------------------testing smoke detector------------------------------
                    if (i == 0) {
                        testArr[i].detect();
                        testArr[i].getHelp();
                        SmokeDetector s1 = (SmokeDetector) testArr[i];
                        s1.sprayWater(); //calling method unique to SmokeDetector
                        testArr[i].switchOff();
                    }
                    //---------------------------------testing gas detector------------------------------
                    if (i == 1) {
                        testArr[i].detect();
                        testArr[i].getHelp();
                        GasDetector g1 = (GasDetector) testArr[i];
                        g1.openVents(); //calling method unique to GasDetector
                    }
                    //---------------------------------testing carbon monoxide detector------------------------------
                    if (i == 2) {
                        testArr[i].detect();
                        testArr[i].getHelp();
                        CarbonMonoxideDetector c1 = (CarbonMonoxideDetector) testArr[i];
                        c1.openWindows(); //calling method unique to CarbonMonoxideDetector
                    }
                    //---------------------------------testing glass break detector------------------------------
                    if (i == 3) {
                        testArr[i].detect();
                        testArr[i].getHelp();
                        GlassBreakDetector g1 = (GlassBreakDetector)testArr[i];
                        g1.sendAlert();
                        g1.reset();

                    }
                    //---------------------------------testing infrared motion detector------------------------------
                    if (i == 4) {
                        testArr[i].detect();
                        testArr[i].getHelp();
                        InfraredMotionDetector m1 = (InfraredMotionDetector) testArr[i];
                        m1.sendMobileAlert(); //calling method unique to InfraredMotionDetector

                    }
                    //---------------------------------testing window sensor------------------------------
                    if (i == 5) {
                        testArr[i].detect();
                        testArr[i].getHelp();
                        WindowSensor w1 = (WindowSensor) testArr[i];
                        w1.lockDoors(); //calling method unique to WindowSensor
                    }
                    //---------------------------------testing door sensor------------------------------
                    if (i == 6) {
                        testArr[i].detect();
                        testArr[i].getHelp();
                        System.out.println(testArr[i]); //calling toString() of door sensor object
                    }
                    //---------------------------------testing pressure detector------------------------------
                    if (i == 7) {
                        testArr[i].detect();
                        PressureDetector p1 = (PressureDetector) testArr[i];
                        //calling methods unique to PressureDetector
                        p1.turnOnFloodLights();
                        p1.releaseGuardDogs();

                        System.out.println("Please type 1 if you'd like to see the tests again.");
                        //loop restarts at i=0 only if user wishes to see tests again
                        if (!(input.next().equals("1"))) {
                            show = false;
                            break;
                        }
                    }
                    System.out.println("Please type 1 if you'd like to see the tests for the next sensor.");
                    //next test i.e. next iteration of loop commences only if user wishes to see next test
                    if (!(input.next().equals("1"))) {
                        show = false;
                        break;
                    }
                }
            }
        } while (show);
    }

}

