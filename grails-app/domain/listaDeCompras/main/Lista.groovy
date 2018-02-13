package listaDeCompras.main

class Lista {
	
	String nome;
	String descricao;

    static constraints = {
		nome(nullable:true);
		descricao(nullable:true);
    }
	
	String toString() {
		return "${this.nome} (${this.descricao})"
	}
}
