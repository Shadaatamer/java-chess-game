package ChessCore;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
import ChessCore.ChessGame;
import ChessCore.Square;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Shada
 */
public class ChessBoardPanel extends javax.swing.JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        int squareSize = getWidth() / 8;

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                int x = col * squareSize;
                int y = row * squareSize;

                if ((row + col) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.BLACK);
                }

                g.fillRect(x, y, squareSize, squareSize);

                if (row == 0) {
                    if (col == 0 || col == 7) {
                        drawChessPiece(g, "D:\\BlackRook.png", x, y);
                    } else if (col == 1 || col == 6) {
                        drawChessPiece(g, "D:\\BlackKnight.png", x, y);
                    } else if (col == 2 || col == 5) {
                        drawChessPiece(g, "D:\\BlackBishop.png", x, y);
                    } else if (col == 4) {
                        drawChessPiece(g, "D:\\BlackKing.png", x, y);
                    } else if (col == 3) {
                        drawChessPiece(g, "D:\\BlackQueen.png", x, y);
                    }

                } else if (row == 1) {
                    drawChessPiece(g, "D:\\BlackPawn.png", x, y);
                } else if (row == 6) {
                    drawChessPiece(g, "D:\\WhitePawn.png", x, y);
                } else if (row == 7) {
                    if (col == 0 || col == 7) {
                        drawChessPiece(g, "D:\\WhiteRook.png", x, y);
                    } else if (col == 1 || col == 6) {
                        drawChessPiece(g, "D:\\WhiteKnight.png", x, y);
                    } else if (col == 2 || col == 5) {
                        drawChessPiece(g, "D:\\WhiteBishop.png", x, y);
                    } else if (col == 4) {
                        drawChessPiece(g, "D:\\WhiteKing.png", x, y);
                    } else if (col == 3) {
                        drawChessPiece(g, "D:\\WhiteQueen.png", x, y);
                    }
                }
            }
        }
    }

    private void drawChessPiece(Graphics g, String imagePath, int x, int y) {

        ImageIcon icon = new ImageIcon(imagePath);
        Image image = icon.getImage();
        g.drawImage(image, x, y, this);

    }
//    private Square selectedSquare;
//    private Square destinationSquare;
//    private ChessGame game;
//    private int squareSize;
//
//    public ChessBoardPanel(ChessGame game) {
//        this.game = game;
//        addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                squareSize = getWidth() / 8; 
//                int mouseX = e.getX();
//                int mouseY = e.getY();
//
//                int file = mouseX / squareSize;
//                int rank = 7 - mouseY / squareSize;
//
//                Square clickedSquare = new Square(BoardFile.values()[file], BoardRank.values()[rank]);
//
//                if (selectedSquare == null) {
//                    // If no piece is selected, check if there is a piece at the clicked square
//                    if (game.hasPieceInSquareForPlayer(clickedSquare, game.getWhoseTurn())) {
//                        selectedSquare = clickedSquare;
//                    }
//                } else {
//                    // If a piece is already selected, check if the clicked square is a valid move
//                    if (game.isValidMove(new Move(selectedSquare, clickedSquare))) {
//                        destinationSquare = clickedSquare;
//                        game.makeMove(new Move(selectedSquare, destinationSquare));
//                        selectedSquare = null;
//                        destinationSquare = null;
//                        repaint(); // Redraw the board after the move
//                    } else {
//                        // If the clicked square is not a valid move, deselect the piece
//                        selectedSquare = null;
//                    }
//                }
//            }
//        });
//      
//    }
//
//    @Override
//
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//
//        int numRows = 8;
//        int numCols = 8;
//        if (selectedSquare != null) {
//            drawHighlight(g, selectedSquare, Color.BLUE);
//
//            // Highlight valid moves for the selected piece
//            List<Square> validMoves = game.getAllValidMovesFromSquare(selectedSquare);
//            for (Square validMove : validMoves) {
//                drawHighlight(g, validMove, Color.GREEN);
//            }
//        }
//
//        // Check if there is a destination square
//        if (destinationSquare != null) {
//            drawHighlight(g, destinationSquare, Color.RED);
//        }
//        int squareSize = getWidth() / numCols; // Calculate square size dynamically
//
//        for (int row = 0; row < numRows; row++) {
//            for (int col = 0; col < numCols; col++) {
//                int x = col * squareSize;
//                int y = row * squareSize;
//
//                // Alternate colors for the chessboard
//                if ((row + col) % 2 == 0) {
//                    g.setColor(Color.WHITE);
//                } else {
//                    g.setColor(Color.BLACK);
//                }
//
//                g.fillRect(x, y, squareSize, squareSize);
//
//                // Draw chess pieces
//                if (row == 0) {
//                    drawTopRowPieces(g, col, x, y, squareSize, squareSize);
//                } else if (row == 1) {
//                    drawPawn(g, "D:\\BlackPawn.png", x, y, squareSize, squareSize);
//                } else if (row == 6) {
//                    drawPawn(g, "D:\\WhitePawn.png", x, y, squareSize, squareSize);
//                } else if (row == 7) {
//                    drawBottomRowPieces(g, col, x, y, squareSize, squareSize);
//                }
//            }
//        }
//
//    }
//
//    private void drawHighlight(Graphics g, Square square, Color color) {
//        int x = square.getFile().ordinal() * squareSize;
//        int y = (7 - square.getRank().ordinal()) * squareSize;
//        g.setColor(color);
//        g.fillRect(x, y, squareSize, squareSize);
//    }
//
//    private void drawChessPiece(Graphics g, String imagePath, int x, int y, int width, int height) {
//        try {
//            ImageIcon icon = new ImageIcon(imagePath);
//            Image image = icon.getImage();
//            g.drawImage(image, x, y, width, height, this);
//        } catch (Exception e) {
//            System.err.println("Error loading image: " + e.getMessage());
//        }
//    }
//
//    private void drawTopRowPieces(Graphics g, int col, int x, int y, int width, int height) {
//        switch (col) {
//            case 0:
//                drawChessPiece(g, "D:\\BlackRook.png", x, y, width, height);
//                break;
//            case 1:
//                drawChessPiece(g, "D:\\BlackKnight.png", x, y, width, height);
//                break;
//            case 2:
//                drawChessPiece(g, "D:\\BlackBishop.png", x, y, width, height);
//                break;
//            case 3:
//                drawChessPiece(g, "D:\\BlackQueen.png", x, y, width, height);
//                break;
//            case 4:
//                drawChessPiece(g, "D:\\BlackKing.png", x, y, width, height);
//                break;
//            case 5:
//                drawChessPiece(g, "D:\\BlackBishop.png", x, y, width, height);
//                break;
//            case 6:
//                drawChessPiece(g, "D:\\BlackKnight.png", x, y, width, height);
//                break;
//            case 7:
//                drawChessPiece(g, "D:\\BlackRook.png", x, y, width, height);
//                break;
//        }
//    }
//
//    private void drawBottomRowPieces(Graphics g, int col, int x, int y, int width, int height) {
//        switch (col) {
//            case 0:
//                drawChessPiece(g, "D:\\WhiteRook.png", x, y, width, height);
//                break;
//            case 1:
//                drawChessPiece(g, "D:\\WhiteKnight.png", x, y, width, height);
//                break;
//            case 2:
//                drawChessPiece(g, "D:\\WhiteBishop.png", x, y, width, height);
//                break;
//            case 3:
//                drawChessPiece(g, "D:\\WhiteQueen.png", x, y, width, height);
//                break;
//            case 4:
//                drawChessPiece(g, "D:\\WhiteKing.png", x, y, width, height);
//                break;
//            case 5:
//                drawChessPiece(g, "D:\\WhiteBishop.png", x, y, width, height);
//                break;
//            case 6:
//                drawChessPiece(g, "D:\\WhiteKnight.png", x, y, width, height);
//                break;
//            case 7:
//                drawChessPiece(g, "D:\\WhiteRook.png", x, y, width, height);
//                break;
//        }
//    }
//
//    private void drawPawn(Graphics g, String imagePath, int x, int y, int width, int height) {
//        drawChessPiece(g, imagePath, x, y, width, height);
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
//  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
