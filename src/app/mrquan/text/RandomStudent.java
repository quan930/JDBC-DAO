package app.mrquan.text;

import app.mrquan.vo.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class RandomStudent {
    public Student random() throws IOException {
        Student student = new Student();
        String id = randomID();
        student.setId(id);
        student.setName(name());
        student.setSex(true);
        student.setBirthday(new Date());
        student.setHeadPortrait(headPro());
        student.setTels(randomTel());
        return student;
    }
    private String randomID(){
        int random = 1;
        for(int i=0;i< 9;i ++) {
            random = random*10+(int)(10*(Math.random()));
        }
        String id = String.valueOf(random);
        return id;
    }
    private List<String> randomTel(){
        List<String> telephone = new ArrayList<>();

        int size = (int)(8*(Math.random()))+1;
        for (int i = 0; i < size; i++) {
            telephone.add(tel());
        }

        return telephone;
    }
    private String tel(){
        long random = 1;
        for(int i=0;i< 10;i ++) {
            random = random*10+(long)(10*(Math.random()));
        }
        String tel = String.valueOf(random);
        return tel;
    }
    private Byte[] headPro() throws IOException {
        byte[] headOne;
        File file = new File("/Users/daquan/Desktop/laugh.png");
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
        byte[] b = new byte[1000];
        int n;
        while ((n = fis.read(b)) != -1) {
            bos.write(b, 0, n);
        }
        fis.close();
        bos.close();
        headOne = bos.toByteArray();
        Byte[] headTwo = new Byte[headOne.length];
        int i = 0;
        for (byte c : headOne) headTwo[i++] = c;
        return headTwo;
    }
    private String name(){
        String str="zxcvbnmlkjhgfdsaqwertyuiop";
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0; i<5; ++i){
            int number=random.nextInt(25);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
