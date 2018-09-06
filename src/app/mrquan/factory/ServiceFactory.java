package app.mrquan.factory;

        import app.mrquan.service.IStudentService;
        import app.mrquan.service.impl.StudentServiceImpl;

public class ServiceFactory {
    public static IStudentService getIStudentServiceInstance(){
        return new StudentServiceImpl();
    }
}
