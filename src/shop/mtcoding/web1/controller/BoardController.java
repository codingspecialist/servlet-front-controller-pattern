package shop.mtcoding.web1.controller;

import shop.mtcoding.web1.config.ViewResolver;

public class BoardController{
    private BoardController(){}
    private static BoardController boardController = new BoardController();
    public static BoardController getInstance(){
        return boardController;
    }

    public String list(){
        System.out.println("list : 요청됨");
        return ViewResolver.resolve("/board/list");
    }
    public String detail(){
        System.out.println("detail : 요청됨");
        return ViewResolver.resolve("/board/detail");
    }

    public String write(){
        System.out.println("write : 요청됨");
        return "/WEB-INF/board/write.jsp";
    }
}
