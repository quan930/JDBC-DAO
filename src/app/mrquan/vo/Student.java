package app.mrquan.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * create table student (
 * 	 id char(10) not null,
 * 	 name varchar(10),
 * 	 sex boolean,
 * 	 birthday date,
 * 	 header bytea,
 * 	 primary key (id)
 *  );
 */
public class Student implements Serializable {
    private String id;
    private String name;
    private Boolean sex;
    private Date birthday;
    private Byte[] headPortrait;
    private List<String> tels;

    public List<String> getTels() {
        return tels;
    }

    public void setTels(List<String> tels) {
        this.tels = tels;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Byte[] getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(Byte[] headPortrait) {
        this.headPortrait = headPortrait;
    }

    @Override
    public String toString() {
        return "id:"+id+"\t名字:"+name+"\t性别:"+(sex==true?"男":"女")+"\t生日:"+birthday+"\t\t电话"+tels;
    }
}
