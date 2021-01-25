package com.entrevista.musicaweb.entidades;


public enum GeneroEnum {
	
	ROCK(1,"ROCK"),
	FORRO(2,"FORRO"),
	SERTANEJO(3,"SERTANEJO");
	
	private Integer cod;
	
	private String genero;
	
	 GeneroEnum( Integer cod,String genero) {
		 this.genero = genero;
		 this.cod = cod;
	}
	 
		public  static GeneroEnum getPorNome(String nome) {
			GeneroEnum generoEnum = null;
			for ( GeneroEnum genero : values()) {
				if (genero.getGenero().equalsIgnoreCase(nome)) {
					generoEnum = genero;
				}
			}
			
			return generoEnum;
		}
		
		public  static GeneroEnum getPorCod(Integer cod) {
			GeneroEnum generoEnum = null;
			for ( GeneroEnum genero : values()) {
				if (genero.getCod() == cod) {
					generoEnum = genero;
				}
			}
			
			return generoEnum;
		}

		public Integer getCod() {
			return cod;
		}

		public void setCod(Integer cod) {
			this.cod = cod;
		}

		public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}

	
	
}
