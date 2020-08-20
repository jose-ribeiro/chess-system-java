package boardgame;

public class Board {
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns <1) {
			throw new BoardException("Erro, e preciso pelo menos uma linha e uma coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece [rows][columns];
	}
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece pice (int row, int column) {
		if(!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		 return pieces [row][column];
	}
	 public Piece piece (Position position) {
		 if(!positionExists(position)) {
				throw new BoardException("There is already a piece os position" + position);
			}
	 return pieces [position.getRow()][position.getColumn()];//retorno da peça na matrix
	 }
	 public void placePiece(Piece piece, Position position) {
		 pieces[position.getRow()][position.getColumn()] = piece;
		 piece.position = position;
	 }
		 
	 public Piece removePiece(Position position) {
		 if(!positionExists(position)) {
			 throw new BoardException("Position not on the board");
		 }
		 if(piece(position)== null) {
			 return null;
		 }
		 Piece aux = piece(position);
		 aux.position = null;
		 pieces[position.getRow()][position.getColumn()] = null;
		 return aux;
		 
	 }
	 private boolean positionExists(int row, int column) {//testar linha e por coluna
		 return row >= 0 && row < rows && column >= 0 && column < columns;
		 // metodo axiliar do metodo a abaixo, para retornar se uma posição realmente existe
	 }
	 public boolean positionExists(Position position) {
		 return positionExists(position.getRow(), position.getColumn());// reaproveitando o metodo de cuna
		 
	 }
	 public boolean thereIsAPiece(Position position) {
		 if(!positionExists(position)) {
				throw new BoardException("Position not on the board");
			}
		 return piece(position) != null; //teste se a peça e diferente de nulo
	 }
}
