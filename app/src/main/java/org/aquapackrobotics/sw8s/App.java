/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.aquapackrobotics.sw8s;

import java.util.concurrent.ScheduledThreadPoolExecutor;

import org.aquapackrobotics.sw8s.missions.Mission;
import org.aquapackrobotics.sw8s.missions.AutoMission;
import org.aquapackrobotics.sw8s.missions.ManualMission;
public class App {

    static final int POOLSIZE = 1;
    
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(POOLSIZE);
        String helpFlag[] = {"\nBasic Utility:", "\n'test' -- The Command Flag used in Testing", "'help' or 'h' -- displays list of command flags", "\nStates:", "\n"};
        System.out.println("Basic Format: gradle run --args '_'");
        for (String str: args) {
            switch (str) {
                case "--test":
                    System.out.println("Yay! it worked!");
                    break;
                case "-h":
                    for(int i = 0; i < helpFlag.length; i++){
                        System.out.println(helpFlag[i]);
                    }
                case "--help":
                    for(int i = 0; i < helpFlag.length; i++){
                        System.out.println(helpFlag[i]);
                    }
                    break;
                case "--raw_test":
                    Mission missionRaw_Test = (Mission) new Raw_TestMission(pool);
                    missionRaw_Test.run();
                    break;
                case "--local_test":
                    Mission missionLocal_Test = (Mission) new Local_TestMission(pool);
                    missionLocal_Test.run();
                    break;
                // case "-s1":
                //     executeState(State1);
                //     break;
                // case "-s2":
                //     executeState(State2);
                //     break;
                // case "-s3":
                //     executeState(State3);
                //     break;
                case "manual":
                    Mission missionManual = (Mission) new ManualMission(pool);
                    missionManual.run();
                    break;
                default:
                    Mission missionAuto = (Mission) new AutoMission(pool);
                    missionAuto.run();
                    break;

            }
        }
        
        Mission mission = (Mission) new AutoMission(pool);

        
    }
}
