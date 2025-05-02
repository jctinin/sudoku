import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.dio.util.model.Board;
import br.com.dio.util.model.BoardTemplate;
import br.com.dio.util.model.GameStatusEnum;
import br.com.dio.util.model.Space;

public class App {

    private final static Scanner scanner = new Scanner(System.in);
    private static Board board;

    private static Map<String, String> positions;
    private final static int BOARD_LIMIT = 9;

    public static void main(String[] args) throws Exception {

        positions = new HashMap<>();

        if (args.length > 0) {
            String[] entries = args[0].split(" ");
            for (String entry : entries) {
                String[] parts = entry.split(":");
                if (parts.length == 2) {
                    positions.put(parts[0], parts[1]);
                }
            }
        }

        var option = -1;
        while (true) {
            System.out.println("Selecione uma das opções abaixo:");
            System.out.println("1. Iniciar um novo jogo");
            System.out.println("2. Inserir um novo numero");
            System.out.println("3. Remover um número");
            System.out.println("4. Visualizar o jogo atual");
            System.out.println("5. Varificar Status do jogo");
            System.out.println("6. Limpar jogo");
            System.out.println("7. Finalizar o jogo");

            option = scanner.nextInt();

            switch (option) {
                case 1 -> startGame(positions);
                case 2 -> insertNumber();
                case 3 -> removeNumber();
                case 4 -> showGame();
                case 5 -> checkGameStatus();
                case 6 -> clearGame();
                case 7 -> finishGame();
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        }

    }

    private static void startGame(final Map<String, String> positions) {
        if (board != null) {
            System.out.println("Um jogo já está em andamento. Por favor, finalize-o antes de iniciar um novo.");
            return;
        }

        System.out.println("Posições recebidas: " + positions);

        List<List<Space>> spaces = new ArrayList<>();

        for (int i = 0; i < BOARD_LIMIT; i++) {
            List<Space> row = new ArrayList<>();
            for (int j = 0; j < BOARD_LIMIT; j++) {
                String key = i + "," + j;
                String positionConfig = positions.get(key);

                if (positionConfig != null) {
                    String[] parts = positionConfig.split(",");
                    try {
                        int expected = Integer.parseInt(parts[0].trim());
                        boolean fixed = Boolean.parseBoolean(parts[1].trim());

                        Space space = new Space(expected, fixed);
                        if (fixed) {
                            space.setActual(expected);
                        }

                        row.add(space);
                    } catch (Exception e) {
                        row.add(new Space(0, false));
                    }
                } else {
                    row.add(new Space(0, false));
                }
            }
            spaces.add(row);
        }

        board = new Board(spaces);

        System.out.println("Tabuleiro inicializado com sucesso!");
        showGame();
    }

    private static void insertNumber() {
        if (board == null) {
            System.out.println("Nenhum jogo iniciado.");
            return;
        }

        int row = readIntInput("Insira a linha (0-8): ", 0, 8);
        int column = readIntInput("Insira a coluna (0-8): ", 0, 8);
        int number = readIntInput("Insira o número (1-9): ", 1, 9);

        if (board.changeValue(row, column, number)) {
            System.out.println("Número inserido com sucesso!");
            showGame();
        } else {
            System.out.println("Não foi possível inserir o número (posição fixa ou inválida).");
        }
    }

    private static void removeNumber() {
        if (board == null) {
            System.out.println("Nenhum jogo iniciado.");
            return;
        }

        int row = readIntInput("Insira a linha (0-8): ", 0, 8);
        int column = readIntInput("Insira a coluna (0-8): ", 0, 8);

        if (board.clearValue(row, column)) {
            System.out.println("Número removido com sucesso!");
            showGame();
        } else {
            System.out.println("Não foi possível remover o número (posição fixa ou vazia).");
        }
    }

    private static void showGame() {
        if (board == null) {
            System.out.println("Nenhum jogo iniciado.");
            return;
        }

        Object[] args = new Object[81];
        int argPos = 0;

        for (int i = 0; i < BOARD_LIMIT; i++) {
            for (int j = 0; j < BOARD_LIMIT; j++) {
                Space space = board.getSpace(i, j);
                args[argPos++] = space.isFixed() ? String.format("%2d", space.getExpected())
                        : (space.getActual() != null ? String.format("%2d", space.getActual()) : "  ");
            }
        }

        System.out.println("Seu jogo atual é:");
        BoardTemplate boardTemplate = new BoardTemplate();
        System.out.printf(boardTemplate.BOARD_TEMPLATE.replaceAll("%s", "%2s"), args);
    }

    private static void clearGame() {
        if (board == null) {
            System.out.println("Nenhum jogo iniciado.");
            return;
        }

        System.out.println("Tem certeza que deseja limpar o jogo? (S/N)");
        String op = scanner.next();

        if (op.equalsIgnoreCase("S")) {
            board.reset();
            System.out.println("Jogo limpo com sucesso!");
            showGame();
        } else {
            System.out.println("Operação cancelada.");
        }
    }

    private static void checkGameStatus() {
        if (board == null) {
            System.out.println("Nenhum jogo iniciado.");
            return;
        }

        GameStatusEnum status = board.getGameStatus();
        switch (status) {
            case COMPLETE -> System.out.println("Parabéns! Você completou o jogo corretamente!");
            case INCOMPLETE -> System.out.println("O jogo ainda não está completo.");
            case NON_STARTED -> System.out.println("Jogo não iniciado ou vazio.");
        }

        if (board.hasErrors()) {
            System.out.println("Atenção: Existem números incorretos no tabuleiro!");
        }
    }

    private static void finishGame() {
        if (board == null) {
            System.out.println("Nenhum jogo iniciado.");
            return;
        }

        checkGameStatus();
        board = null;
        System.out.println("Jogo finalizado. Você pode iniciar um novo jogo agora.");
    }

    private static int readIntInput(String message, int min, int max) {
        while (true) {
            System.out.print(message);
            try {
                int input = scanner.nextInt();
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.println("Valor deve estar entre " + min + " e " + max);
            } catch (Exception e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.next();
            }
        }
    }

}
