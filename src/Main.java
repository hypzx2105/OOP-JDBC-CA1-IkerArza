

import DAOs.MysqlTaskDao;
import DAOs.TaskDaoInterface;
import DTOs.tasks;
import Exceptions.DaoException;

import java.util.Base64;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        TaskDaoInterface IUserDao = new MysqlTaskDao() {
            @Override
            public tasks findTasksByTitleAndTag(String title, String tag) throws DaoException {
                return null;
            }
        };

        try
        {
            System.out.println("\nCall findAllTasks()");
            List<tasks> tasks = IUserDao.findAllTasks();     // call a method in the DAO

            if( tasks.isEmpty() )
                System.out.println("There are no tasks");
            else {
                for (tasks task : tasks)
                    System.out.println("Task: " + task.toString());
            }



        }
        catch( DaoException e )
        {
            e.printStackTrace();
        }
    }
}