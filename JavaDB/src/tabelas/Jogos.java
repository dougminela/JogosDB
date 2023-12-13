package tabelas;

public class Jogos {

    private int idJogo, ano, id;
    private String nome;
    private String plataformas;

    public void setIdJogo(int idJogo) {
        this.idJogo = idJogo;
    }

    public int getIdJogo() {
        return idJogo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public String getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(String plataformas) {
        this.plataformas = plataformas;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}