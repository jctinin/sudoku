package br.com.dio.util.model;

import java.util.List;

public class BoardTemplate {

    public final String BOARD_TEMPLATE = """
        *|**********************************************************************************************************************
        *|-----0-----||-----1-----||-----2-----|*|-----3-----||-----4-----||-----5-----|*|-----6-----||-----7-----||-----8-----|
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        0|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        *|-----------||-----------||-----------|*|-----------||-----------||-----------|*|-----------||-----------||-----------|
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        1|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        *|-----------||-----------||-----------|*|-----------||-----------||-----------|*|-----------||-----------||-----------|
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        2|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        *|===========||===========||===========|*|===========||===========||===========|*|===========||===========||===========|
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        3|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        *|-----------||-----------||-----------|*|-----------||-----------||-----------|*|-----------||-----------||-----------|
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        4|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        *|-----------||-----------||-----------|*|-----------||-----------||-----------|*|-----------||-----------||-----------|
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        5|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        *|===========||===========||===========|*|===========||===========||===========|*|===========||===========||===========|
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        6|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        *|-----------||-----------||-----------|*|-----------||-----------||-----------|*|-----------||-----------||-----------|
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        7|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        *|-----------||-----------||-----------|*|-----------||-----------||-----------|*|-----------||-----------||-----------|
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        8|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |*|     %s    ||     %s    ||     %s    |
        *|           ||           ||           |*|           ||           ||           |*|           ||           ||           |
        *|**********************************************************************************************************************
        """;

    public void printBoard(List<List<Integer>> board) {
        String formattedBoard = String.format(BOARD_TEMPLATE,
            board.get(0).get(0), board.get(0).get(1), board.get(0).get(2), board.get(0).get(3), board.get(0).get(4), board.get(0).get(5),
            board.get(0).get(6), board.get(0).get(7), board.get(0).get(8),
            board.get(1).get(0), board.get(1).get(1), board.get(1).get(2), board.get(1).get(3), board.get(1).get(4), board.get(1).get(5),
            board.get(1).get(6), board.get(1).get(7), board.get(1).get(8),
            board.get(2).get(0), board.get(2).get(1), board.get(2).get(2), board.get(2).get(3), board.get(2).get(4), board.get(2).get(5),
            board.get(2).get(6), board.get(2).get(7), board.get(2).get(8),
            board.get(3).get(0), board.get(3).get(1), board.get(3).get(2), board.get(3).get(3), board.get(3).get(4), board.get(3).get(5),
            board.get(3).get(6), board.get(3).get(7), board.get(3).get(8),
            board.get(4).get(0), board.get(4).get(1), board.get(4).get(2), board.get(4).get(3), board.get(4).get(4), board.get(4).get(5),
            board.get(4).get(6), board.get(4).get(7), board.get(4).get(8),
            board.get(5).get(0), board.get(5).get(1), board.get(5).get(2), board.get(5).get(3), board.get(5).get(4), board.get(5).get(5),
            board.get(5).get(6), board.get(5).get(7), board.get(5).get(8),
            board.get(6).get(0), board.get(6).get(1), board.get(6).get(2), board.get(6).get(3), board.get(6).get(4), board.get(6).get(5),
            board.get(6).get(6), board.get(6).get(7), board.get(6).get(8),
            board.get(7).get(0), board.get(7).get(1), board.get(7).get(2), board.get(7).get(3), board.get(7).get(4), board.get(7).get(5),
            board.get(7).get(6), board.get(7).get(7), board.get(7).get(8),
            board.get(8).get(0), board.get(8).get(1), board.get(8).get(2), board.get(8).get(3), board.get(8).get(4), board.get(8).get(5),
            board.get(8).get(6), board.get(8).get(7), board.get(8).get(8)
        );
        System.out.println(formattedBoard);
    }
}
