package app.mrquan.text;

import app.mrquan.factory.ServiceFactory;
import app.mrquan.vo.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *  student表数据类型
 *      id char(10),name varchar(10),sex boolean,birthday date,header bytea,
 * 	    约束 id
 *  telephone子表数据类型
 *      id char(10),tel char(11)
 *
 */
public class Text {
    public static void main(String[] args) throws IOException, SQLException {
        long startTime = System.currentTimeMillis();
        int all=0;
        while (all<1000){
            List<Student> vos = new ArrayList<>();
            for (int j = 0; j < 100; j++) {
                vos.add(new RandomStudent().random());
            }
            all += ServiceFactory.getIStudentServiceInstance().insert(vos);
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime-startTime)+"ms");
    }
}
