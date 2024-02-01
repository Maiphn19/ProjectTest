/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package TaskManager;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import TaskManager.Task;

/**
 *
 * @author Mai
 */
public class TaskManagerIT {
    private TaskManager task;
    
    public TaskManagerIT() {
        task = new TaskManager();
    }

    @Test
    public void testCheckDuplicate() {
        String date = "2023-07-05";
        String assignee = "John Doe";
        double planFrom = 9.0;
        double planTo = 11.0;

        // Create a list of tasks
        ArrayList<Task> taskList = new ArrayList<>();
        Task task1 = new Task("2023-07-05", "John Doe", 8.0, 9.0);
        Task task2 = new Task("2023-07-05", "John Doe", 11.0, 12.0);
        taskList.add(task1);
        taskList.add(task2);

        boolean isDuplicate = task.checkDuplicate(date, assignee, planFrom, planTo, taskList);

        assertEquals(true, isDuplicate);
    }
    
}
