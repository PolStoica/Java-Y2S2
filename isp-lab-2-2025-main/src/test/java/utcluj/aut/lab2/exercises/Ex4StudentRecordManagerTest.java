package utcluj.aut.lab2.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Ex4StudentRecordManagerTest {

    @Test
    public void testParseStudentRecord() {
        String record = "John Doe,20,85";
        String[] expected = {"John Doe", "20", "85"};
        assertArrayEquals(expected, Ex4StudentRecordManager.parseStudentRecord(record));
    }

    @Test
    public void testParseStudentRecordInvalidFormat() {
        String record = "John Doe,20";
        assertThrows(IllegalArgumentException.class, () -> {
            Ex4StudentRecordManager.parseStudentRecord(record);
        });
    }

    @Test
    public void testFilterByGrade() {
        String[][] records = {
            {"John Doe", "20", "85"},
            {"Jane Smith", "22", "90"},
            {"Bob Johnson", "19", "70"}
        };
        String[][] expected = {
            {"John Doe", "20", "85"},
            {"Jane Smith", "22", "90"}
        };
        assertArrayEquals(expected, Ex4StudentRecordManager.filterByGrade(records, "80"));
    }

    @Test
    public void testSortRecordsByNameAscending() {
        String[][] records = {
            {"John Doe", "20", "85"},
            {"Jane Smith", "22", "90"},
            {"Bob Johnson", "19", "70"}
        };
        String[][] expected = {
            {"Bob Johnson", "19", "70"},
            {"Jane Smith", "22", "90"},
            {"John Doe", "20", "85"}
        };
        assertArrayEquals(expected, Ex4StudentRecordManager.sortRecords(records, "name", true));
    }

    @Test
    public void testSortRecordsByGradeDescending() {
        String[][] records = {
            {"John Doe", "20", "85"},
            {"Jane Smith", "22", "90"},
            {"Bob Johnson", "19", "70"}
        };
        String[][] expected = {
            {"Jane Smith", "22", "90"},
            {"John Doe", "20", "85"},
            {"Bob Johnson", "19", "70"}
        };
        assertArrayEquals(expected, Ex4StudentRecordManager.sortRecords(records, "grade", false));
    }

    @Test
    public void testIsInteger() {
        assertTrue(Ex4StudentRecordManager.isInteger("123"));
        assertFalse(Ex4StudentRecordManager.isInteger("abc"));
    }
}