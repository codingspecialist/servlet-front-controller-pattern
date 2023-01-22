package shop.mtcoding.web1.controller;

public class UserController{
    private UserController(){}
    private static UserController userController = new UserController();
    public static UserController getInstance(){
        return userController;
    }

    public String join(){
        System.out.println("join : 요청됨!");
        return "/user/join.jsp";
    }

    public String userInfo(){
        System.out.println("userInfo : 요청됨");
        return "/user/userInfo.jsp";
    }

}
