
//package ohiohealth;

/** Just to test git*/

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Babysitter_Test {

 private Babysitter testObject;

 @Before
 public void executedBeforeEachTest() {
  testObject = new Babysitter();
 }

 // Creating a method to convert time to a 0 - 11 scale.
 @Test
 public void shouldConvertTime5to0() {
  assertEquals(0, testObject.convertTime(5));
 }

 @Test
 public void shouldConvertTime4to11() {
  assertEquals(11, testObject.convertTime(4));
 }

 // Creating a method to validate that converted start time is before 4am
 // (i.e. is less than 11).
 @Test
 public void shouldReturnTrueConvertedStartTime5pmIsLessThan11() {
  assertEquals(true, testObject.validateStartTime(5));
 }

 @Test
 public void shouldReturnFalseConvertedStartTime4amIsLessThan11() {
  assertEquals(false, testObject.validateStartTime(4));
 }

 // Creating a method to validate that end time is after start time.
 @Test
 public void shouldReturnTrueEndTime4amIsAfterStartTime5pm() {
  assertEquals(true, testObject.validateEndTime(4, 5));
 }

 @Test
 public void shouldReturnFalseEndTime7pmIsAfterStartTime8pm() {
  assertEquals(false, testObject.validateEndTime(7, 8));
 }

 // Creating a method to validate that bedtime is within range of start time
 // to end time.
 @Test
 public void shouldReturnTrueBedTime9pmIsWithinStartTime5pmEndTime4am() {
  assertEquals(true, testObject.validateBedTime(9, 5, 4));
 }

 @Test
 public void shouldReturnFalseBedTime6pmIsWithinStartTime7pmEndTime11pm() {
  assertEquals(false, testObject.validateBedTime(6, 7, 11));
 }

 // Creating a method to calculate amount of hours in the midnight shift.
 // The midnight shift pay rate supersedes other pay rates so we will create
 // it first.
 @Test
 public void shouldReturn4HoursFromMidnightToEndTime4am() {
  assertEquals(4, testObject.calculateMidnightShiftHours(4));
 }

 ////// This method is to return 2 hours from Midnight to and end time of 2 AM
 @Test
 public void shouldReturn2HoursFromMidnightToEndTime2am() {
  assertEquals(2, testObject.calculateMidnightShiftHours(2));
 }


///// This method should return the hours from Midnight to an ending time of 11 PM
 @Test
 public void shouldReturn0HoursFromMidnightToEndTime11pm() {
  assertEquals(0, testObject.calculateMidnightShiftHours(11));
 }

 // Creating a method to calculate amount of hours in the bedtime shift.
 // Midnight shift hours pay rate supersedes bedtime shift hours pay rate
 // which in turn supersedes regular shift hours pay rate.
 @Test
 public void shouldReturn6HoursBedTime6pmStartTime5pmEndTime4am() {
  assertEquals(6, testObject.calculateBedtimeShiftHours(5, 4, 6));
 }

 @Test
 public void shouldReturn1HoursBedTime11pmStartTime5pmEndTime4am() {
  assertEquals(1, testObject.calculateBedtimeShiftHours(5, 4, 11));
 }

 @Test
 public void shouldReturn0HoursBedtime1amStartTime1amEndTime3am() {
  assertEquals(0, testObject.calculateBedtimeShiftHours(1, 3, 1));
 }

 // Creating a method to calculate the amount of hours in the regular shift.
 @Test
 public void shouldReturn7HoursStartTime5pmEndTime4amBedtime4am() {
  assertEquals(7, testObject.calculateRegularShiftHours(5, 4, 4));
 }

 @Test
 public void shouldReturn6HoursStartTime5pmEndTime4amBedtime11pm() {
  assertEquals(6, testObject.calculateRegularShiftHours(5, 4, 11));
 }

 // Create method to return total pay.
 // Pay rates are hardcoded in the class.
 @Test
 public void shouldReturn136ForStartTime5pmBedTime9pmEndTime4am() {
  assertEquals(136, testObject.calculateTotalPay(5, 9, 4));
 }

 @Test
 public void shouldReturn124ForStartTime6pmBedTime9pmEndTime4am() {
  assertEquals(124, testObject.calculateTotalPay(6, 9, 4));
 }

}
