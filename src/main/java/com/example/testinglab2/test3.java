package com.example.testinglab2;

public class test3 {
    String state = "NORMAL";
    String state1 = "TIME";
    String state2 = "MIN";
    String state3 = "Alarm";
    int m = 0, h = 0, D = 1, M = 1, Y = 2000;
    public void watch(char x) {
        switch (state){
            case "NORMAL":{
                if (x == 'c') state = "UPDATE";
                if (x == 'b') state = "ALARM";
                if (x == 'a') {
                    if (state1 == "TIME")
                        state1 = "DATE";
                    else
                        state1 = "TIME";
                }
                break;
            }
            case "ALARM":{
                if (x == 'a') state3 = "CHIME";
                if (x == 'd') state = "NORMAL";
                break;
            }
            case "UPDATE":{
                if (x == 'a'){
                    if (state2 == "MIN") state2 = "HOUR";
                    else if (state2 == "HOUR") state2 = "DAY";
                    else if (state2 == "DAY") state2 = "MONTH";
                    else if (state2 == "MONTH") state2 = "YEAR";
                    else if (state2 == "YEAR") state = "NORMAL";
                }
                if (x == 'b'){
                    if (state2 == "MIN"){
                        if (m == 59){
                            m = 0;
                        } else m++;
                    } else if (state2 == "HOUR") {
                        if (h == 23){
                            h = 0;
                        } else h++;
                    } else if (state2 == "DAY") {
                        if (D == 31){
                            D = 1;
                        } else D++;
                    } else if (state2 == "MONTH") {
                        if (M == 12){
                            M = 1;
                        } else M++;
                    } else if (state2 == "YEAR") {
                        Y++;
                    }
                }
                if (x == 'd'){
                    state = "NORMAL";
                }
                break;
            }
        }
    }
    public String displayDate(){
        return Integer.toString(Y)+"-"+Integer.toString(M)+"-"+Integer.toString(D);
    }
    public String displayTime(){

        return Integer.toString(h)+":"+Integer.toString(m);
    }
    public String displayState(){
        return state;
    }

}
