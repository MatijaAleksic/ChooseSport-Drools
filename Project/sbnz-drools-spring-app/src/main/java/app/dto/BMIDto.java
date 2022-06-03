package app.dto;


public class BMIDto {
	private Long user_id;
	
	private int tezina;
	private int visina;
	private int godine;
	
	public BMIDto() {}

	public BMIDto(Long user_id, int tezina, int visina, int godine) {
		super();
		this.user_id = user_id;
		this.tezina = tezina;
		this.visina = visina;
		this.godine = godine;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public int getTezina() {
		return tezina;
	}

	public void setTezina(int tezina) {
		this.tezina = tezina;
	}

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}

	public int getGodine() {
		return godine;
	}

	public void setGodine(int godine) {
		this.godine = godine;
	}
}