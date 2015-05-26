package com.example.theoakteam.ramadanapp;


import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hasan Abdullah on 24-May-15.
 */
public class DistrictsTimeClass {

    private Map<String,String> districtTimeMap = new HashMap<String,String>();
    private String[] centralSehriTime = new String[35];
    private String[] centralIftarTime = new String[35];



    public String getDistrictPlusMinusTime(String districtKey){

        districtTimeMap.put("barguna", "2");
        districtTimeMap.put("barisal", "0");// Check it
        districtTimeMap.put("bhola", "-2");
        districtTimeMap.put("jhalokati", "1");
        districtTimeMap.put("patuakhali", "1");
        districtTimeMap.put("pirojpur", "2"); //Barisal End
        districtTimeMap.put("bandarban", "-8");
        districtTimeMap.put("brahmanbaria", "-3");
        districtTimeMap.put("chandpur", "-2");
        districtTimeMap.put("chittagong", "-6");
        districtTimeMap.put("comilla", "-4");
        districtTimeMap.put("cox's bazar", "-7");
        districtTimeMap.put("feni", "-5");
        districtTimeMap.put("khagrachhari", "-7");
        districtTimeMap.put("lakshmipur", "-2");
        districtTimeMap.put("noakhali", "-3");
        districtTimeMap.put("rangamati", "-8"); //Chittagong End
        districtTimeMap.put("dhaka", "0");
        districtTimeMap.put("faridpur", "3");
        districtTimeMap.put("gazipur", "0");
        districtTimeMap.put("gopalganj", "3");
        districtTimeMap.put("jamalpur", "2");
        districtTimeMap.put("kishoreganj", "-2");
        districtTimeMap.put("madaripur", "1");
        districtTimeMap.put("manikganj", "2");
        districtTimeMap.put("munshiganj", "-1");
        districtTimeMap.put("mymensingh", "-1");
        districtTimeMap.put("narayanganj", "-1");
        districtTimeMap.put("narsingdi", "-2");
        districtTimeMap.put("netrakona", "-2");
        districtTimeMap.put("rajbari", "2");
        districtTimeMap.put("shariatpur", "0");// Check it
        districtTimeMap.put("sherpur", "2");
        districtTimeMap.put("tangail", "2"); //Dhaka End
        districtTimeMap.put("bagerhat", "3");
        districtTimeMap.put("chuadanga", "7");
        districtTimeMap.put("jessore", "5");
        districtTimeMap.put("jhenaidah", "5");
        districtTimeMap.put("khulna", "4");
        districtTimeMap.put("kushtia", "5");
        districtTimeMap.put("magura", "4");
        districtTimeMap.put("meherpur", "8");
        districtTimeMap.put("narail", "4");
        districtTimeMap.put("satkhira", "6"); //Khulna End
        districtTimeMap.put("bogra", "5");
        districtTimeMap.put("chapainawabganj", "9");
        districtTimeMap.put("joypurhat", "6");
        districtTimeMap.put("pabna", "5");
        districtTimeMap.put("naogaon", "6");
        districtTimeMap.put("natore", "6");
        districtTimeMap.put("rajshahi", "7");
        districtTimeMap.put("sirajganj", "3"); //Rajshahi End
        districtTimeMap.put("dinajpur", "7");
        districtTimeMap.put("gaibandha", "4");
        districtTimeMap.put("kurigram", "3");
        districtTimeMap.put("lalmonirhat", "4");
        districtTimeMap.put("nilphamari", "7");
        districtTimeMap.put("panchagarh", "8");
        districtTimeMap.put("rangpur", "5");
        districtTimeMap.put("thakurgaon", "8"); //Rangpur End
        districtTimeMap.put("habiganj", "-5");
        districtTimeMap.put("moulvibazar ", "-6");
        districtTimeMap.put("sunamganj", "-4");
        districtTimeMap.put("sylhet", "-6"); //Sylhet End

        return  districtTimeMap.get(districtKey);

    }

    public String calculateTime(String centralTime, String plusMinusTime){
        String finalTime;
        int minute,hour;


        hour = centralTime.charAt(0)-'0';
        minute = (centralTime.charAt(2)-'0') * 10 + centralTime.charAt(3)-'0';

        if(plusMinusTime.charAt(0)=='-'){

            int subMinuteAmount = plusMinusTime.charAt(1)-'0';

            if(minute<subMinuteAmount){
                minute = (minute+60) - subMinuteAmount;
                hour--;
            }
            else{
                minute = minute - subMinuteAmount;
            }

        }
        else {

            int addMinute = minute + plusMinusTime.charAt(0)-'0';

            if(addMinute>=60){
                hour++;
                minute = addMinute - 60;
            }
            else {
                minute = addMinute;
            }

        }

        finalTime = String.valueOf(hour) + ":" + String.valueOf(minute);

        return finalTime;
    }

    public String getDistrictIndividualSehriTime(String districtName, int date){

        String centralTime = getCentralSehriTime(date);
        String districtPlusMinusTime = getDistrictPlusMinusTime(districtName);

        String districtSehriTime;

        districtSehriTime = calculateTime(centralTime,districtPlusMinusTime);

        return districtSehriTime;
    }

    public String getDistrictIndividualIftarTime(String districtName){
        String centralTime = getCentralIftarTime(1);//Just testing with 1st Ramadan
        String plusMinusTime = getDistrictPlusMinusTime(districtName);
        String individualTime = calculateTime(centralTime,plusMinusTime);

        return individualTime;
    }

    public void setCentralSehriTime(){

        centralSehriTime[1] = "3:37";
        centralSehriTime[2] = "3:37";
        centralSehriTime[3] = "3:37";
        centralSehriTime[4] = "3:38";
        centralSehriTime[5] = "3:38";
        centralSehriTime[6] = "3:38";
        centralSehriTime[7] = "3:39";
        centralSehriTime[8] = "3:39";
        centralSehriTime[9] = "3:40";
        centralSehriTime[10] = "3:40";
        centralSehriTime[11] = "3:41";
        centralSehriTime[12] = "3:41";
        centralSehriTime[13] = "3:42";
        centralSehriTime[14] = "3:42";
        centralSehriTime[15] = "3:42";
        centralSehriTime[16] = "3:43";
        centralSehriTime[17] = "3:43";
        centralSehriTime[18] = "3:44";
        centralSehriTime[19] = "3:44";
        centralSehriTime[20] = "3:45";
        centralSehriTime[21] = "3:45";
        centralSehriTime[22] = "3:46";
        centralSehriTime[23] = "3:46";
        centralSehriTime[24] = "3:47";
        centralSehriTime[25] = "3:48";
        centralSehriTime[26] = "3:48";
        centralSehriTime[27] = "3:49";
        centralSehriTime[28] = "3:49";
        centralSehriTime[29] = "3:52";
        centralSehriTime[30] = "3:51";

    }

    public String getCentralSehriTime(int date){

        return centralSehriTime[date];
    }

    public void setCentralIftarTime(){
        centralIftarTime[1] = "6:49";
        centralIftarTime[2] = "6:49";
        centralIftarTime[3] = "6:50";
        centralIftarTime[4] = "6:50";
        centralIftarTime[5] = "6:50";
        centralIftarTime[6] = "6:51";
        centralIftarTime[7] = "6:51";
        centralIftarTime[8] = "6:52";
        centralIftarTime[9] = "6:52";
        centralIftarTime[10] = "6:52";
        centralIftarTime[11] = "6:52";
        centralIftarTime[12] = "6:53";
        centralIftarTime[13] = "6:53";
        centralIftarTime[14] = "6:54";
        centralIftarTime[15] = "6:54";
        centralIftarTime[16] = "6:54";
        centralIftarTime[17] = "6:55";
        centralIftarTime[18] = "6:55";
        centralIftarTime[19] = "6:54";
        centralIftarTime[20] = "6:54";
        centralIftarTime[21] = "6:54";
        centralIftarTime[22] = "6:54";
        centralIftarTime[23] = "6:53";
        centralIftarTime[24] = "6:53";
        centralIftarTime[25] = "6:53";
        centralIftarTime[26] = "6:53";
        centralIftarTime[27] = "6:52";
        centralIftarTime[28] = "6:52";
        centralIftarTime[29] = "6:52";
        centralIftarTime[30] = "6:51";
    }

    public String getCentralIftarTime(int date){
        setCentralIftarTime();
        return centralIftarTime[date];
    }

    public boolean isDistrictPresent(String string){
        String temp = getDistrictPlusMinusTime(string);

        if(temp==null)
            return false;
        else
            return true;
    }

    public String removeEndSpace(String string){
        String finalString=null;
        String tempString=null;
        int i,length,lastIndex=-1;
        length = string.length();

        for(i=length-1; i>=0; i--){
            if(string.charAt(i)!=' ')
            {
                lastIndex = i+1;
                break;
            }
        }

        finalString = string.substring(0,lastIndex);

        return finalString;
    }

}
