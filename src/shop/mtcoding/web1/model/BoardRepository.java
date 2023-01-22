package shop.mtcoding.web1.model;

import shop.mtcoding.web1.controller.BoardController;

import java.util.Arrays;
import java.util.List;

public class BoardRepository {
    private BoardRepository(){}
    private static BoardRepository boardRepository = new BoardRepository();
    public static BoardRepository getInstance(){
        return boardRepository;
    }

    public List<Board> findAll(){
        // DB접근
        List<Board> boards = Arrays.asList(newBoard(1), newBoard(2), newBoard(3));
        return boards;
    }

    public Board findById(int id){
        // DB접근
        return newBoard(id);
    }

    private Board newBoard(int id){
        Board board = new Board();
        board.setId(id);
        board.setTitle("제목 "+id);
        board.setUserId(1);
        return board;
    }

}
