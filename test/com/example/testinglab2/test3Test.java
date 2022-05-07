package com.example.testinglab2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class test3Test {
    test3 test;

    @Nested
    class UpdateState {
        @BeforeEach
        public void before () {
            test = new test3();
            test.state = "UPDATE";
        }
        @Test
        public void expectedMinIncreaseFrom0to1() {
            test.state2 = "MIN";
            test.h = 0;
            test.m = 0;
            test.watch('b');
            assertEquals("0:1", test.displayTime());
        }
        @Test
        public void expectedMinResetFrom59to0() {
            test.state2 = "MIN";
            test.h = 0;
            test.m = 59;
            test.watch('b');
            assertEquals("0:0", test.displayTime());
        }
        @Test
        public void expectedHourIncreaseFrom8to9() {
            test.state2 = "HOUR";
            test.h = 8;
            test.m = 5;
            test.watch('b');
            assertEquals("9:5", test.displayTime());
        }
        @Test
        public void expectedHourResetFrom23to0() {
            test.state2 = "HOUR";
            test.h = 23;
            test.m = 19;
            test.watch('b');
            assertEquals("0:19", test.displayTime());
        }
        @Test
        public void expectedDayIncreaseFrom16to17() {
            test.state2 = "DAY";
            test.D = 16;
            test.M = 11;
            test.Y = 2010;
            test.watch('b');
            assertEquals("2010-11-17", test.displayDate());
        }
        @Test
        public void expectedDayResetFrom31to1() {
            test.state2 = "DAY";
            test.D = 31;
            test.M = 11;
            test.Y = 2010;
            test.watch('b');
            assertEquals("2010-11-1", test.displayDate());
        }
        @Test
        public void expectedMonthIncreaseFrom10to11() {
            test.state2 = "MONTH";
            test.D = 21;
            test.M = 10;
            test.Y = 2020;
            test.watch('b');
            assertEquals("2020-11-21", test.displayDate());
        }
        @Test
        public void expectedMonthResetFrom12to1() {
            test.state2 = "MONTH";
            test.D = 15;
            test.M = 12;
            test.Y = 2009;
            test.watch('b');
            assertEquals("2009-1-15", test.displayDate());
        }
        @Test
        public void expectedYearIncreaseFrom1999to2000() {
            test.state2 = "YEAR";
            test.D = 16;
            test.M = 11;
            test.Y = 1999;
            test.watch('b');
            assertEquals("2000-11-16", test.displayDate());
        }
        @Test
        public void dInputChangesStateToNormal() {
            test.watch('d');
            assertEquals("NORMAL", test.state);
        }
        @Test
        public void aInputChangesMINtoHOUR(){
            test.state2 = "MIN";
            test.watch('a');
            assertEquals("HOUR", test.state2);
        }
        @Test
        public void aInputChangesHOURtoDAY(){
            test.state2 = "HOUR";
            test.watch('a');
            assertEquals("DAY", test.state2);
        }
        @Test
        public void aInputChangesDAYtoMONTH(){
            test.state2 = "DAY";
            test.watch('a');
            assertEquals("MONTH", test.state2);
        }
        @Test
        public void aInputChangesMONTHtoHYEAR(){
            test.state2 = "MONTH";
            test.watch('a');
            assertEquals("YEAR", test.state2);
        }
        @Test
        public void aInputChangesWhenState2IsYEARReturnsToNormalDisplay(){
            test.state2 = "YEAR";
            test.watch('a');
            assertEquals("NORMAL", test.displayState());
        }
    }

    @Nested
    class AlarmState {
        @BeforeEach
        public void before() {
            test = new test3();
            test.state = "ALARM";
        }
        @Test
        public void aInputChangesALARMtoCHIME() {
            test.state3 = "ALARM";
            test.watch('a');
            assertEquals("CHIME", test.state3);
        }
        @Test
        public void dInputChangesStateToNormalDisplay() {
            test.watch('d');
            assertEquals("NORMAL", test.displayState());
        }
    }

    @Nested
    class NormalState {
        @BeforeEach
        public void before() {
            test = new test3();
            test.state = "NORMAL";
        }
        @Test
        public void cInputChangesStateToUpdate() {
            test.watch('c');
            assertEquals("UPDATE", test.displayState());
        }
        @Test
        public void bInputChangesStateToAlarm() {
            test.watch('b');
            assertEquals("ALARM", test.displayState());
        }
        @Test
        public void aInputChangesState1toDateIfItWasTime() {
            test.state1 = "TIME";
            test.watch('a');
            assertEquals("DATE", test.state1);
        }
        @Test
        public void aInputChangesState1toTimeIfItWasDate() {
            test.state1 = "DATE";
            test.watch('a');
            assertEquals("TIME", test.state1);
        }
    }

    @AfterEach
    public void after () {
        test = null;
    }
}
