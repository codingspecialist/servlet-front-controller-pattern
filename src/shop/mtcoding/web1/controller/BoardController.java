package shop.mtcoding.web1.controller;

import shop.mtcoding.web1.config.ViewResolver;
import shop.mtcoding.web1.model.Board;

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
    public Board detail(int id){
        // json 응답 23
        System.out.println("detail : 요청됨");
        Board board = new Board();
        board.setId(id);
        board.setTitle("제목 "+id);
        board.setUserId(1);
        return board;
    }

    public String write(){
        System.out.println("write : 요청됨");
        return "/WEB-INF/board/write.jsp";
    }
}
