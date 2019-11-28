package xadrez;
import tabuleiro.Tabuleiro;
import tabuleiro.Posicao;

public class PecaXadrez extends Posicao{
	private Cor cor;

	public PecaXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
	}

	public Cor getCor() {
		return cor;
	}

	
}
