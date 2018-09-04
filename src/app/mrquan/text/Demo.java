package app.mrquan.text;

import app.mrquan.factory.ServiceFactory;
import app.mrquan.vo.Student;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//    create table student (
//        id char(10) not null,
//        name varchar(10),
//        sex boolean,
//        birthday date,
//        header bytea,
//        primary key (id)
//        );

// create table telephone(
//         id char(10) not null,
//         tel char(11)
//         )
public class Demo {
    public static void main(String[] args) throws IOException, SQLException {
        List<Student> vosStu = new ArrayList<>();
        Student s = new Student();
        for (int i = 0; i < 100; i++) {
            vosStu.add(new RandomStudent().random());
        }
        int len[] = ServiceFactory.getIStudentServiceInstance().insert(vosStu);
        System.out.println("student表增加行数："+len[0]+"\ttelephone表增加行数："+len[1]);

        List<Student> vos= ServiceFactory.getIStudentServiceInstance().list();
        System.out.println(vos.size());
        for (int i = 0; i < vos.size(); i++) {
            System.out.println(vos.get(i));
        }

//        int len = ServiceFactory.getIStudentServiceInstance().insertTel("1489188290","13804128609");
//        System.out.println(len);

//        Student student = new RandomStudent().random();
//        student.setTels(null);
//        int len[] = ServiceFactory.getIStudentServiceInstance().insert(student);
//        System.out.println("student表增加行数："+len[0]+"\ttelephone表增加行数："+len[1]);


//        Student vo = ServiceFactory.getIStudentServiceInstance().get("1263392923");
//        funFiel(vo,"/Users/daquan/Desktop/pood.png");
//        System.out.println(vo);
    }
    private static void funFiel(Student student,String pathname) throws IOException {
        Byte bu[] = student.getHeadPortrait();
        byte[] bytes = new byte[bu.length];
        for(int j = 0; j < bu.length; j++) {
            bytes[j] = bu[j];
        }
        BufferedOutputStream bos = null;
        bos = new BufferedOutputStream(new FileOutputStream(new File(pathname)));
        bos.write(bytes);
        bos.flush();
        bos.close();
    }
}
