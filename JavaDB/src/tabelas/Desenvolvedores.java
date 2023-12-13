package tabelas;

public class Desenvolvedores {
    private String nome;
    private String cidadeOrigem;
    private int idDesenvolvedor;

    public Desenvolvedores() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidadeOrigem) {
		this.cidadeOrigem = cidadeOrigem;
	}
	
	public int getIdDesenvolvedor() {
		return idDesenvolvedor;
	}
	public void setIdDesenvolvedor(int idDesenvolvedor) {
		this.idDesenvolvedor = idDesenvolvedor;
	}
}