package ChessCore;

public final class Square {
    private final BoardFile file;
    private final BoardRank rank;

    public Square(BoardFile file, BoardRank rank) {
        this.file = file;
        this.rank = rank;
    }

    public BoardFile getFile() {
        return file;
    }

    public BoardRank getRank() {
        return rank;
    }

    Object getColor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
