package listaDeCompras.main

class ListaController {

    def index() { 
		
	}
	
	def create(){
		[listaInstance: new Lista()];
	}
	
	def edit(Long id){
		[listaInstance: Lista.findById(id)];
	}
	
	def save(Long id){
		
		Lista listInstance = Lista.findById(id);

		try {
			if(!listInstance){
				listInstance = new Lista(params);
			} else {
				listInstance.properties = params;
			}

			listInstance?.save(flush:true,failOnError:true);

			redirect(action:'show', id: listInstance?.id);
		} catch (Exception e) {
			log.error("Ocorreu um erro interno de servidor", e.printStackTrace());
		}
	}
	
	def delete(Long id){
		
		Lista listInstance = Lista.findById(id);
		
		if(!listInstance){
			log.error('Lista ja não existe mais.');
			return
			
		} else {
			listInstance.properties = params;
		}
		
		listInstance?.save(flush:true,failOnError:true);
		
		redirect(action:'show', id: listInstance?.id);
		
	}
	
	def show(Long id){
		
	}
}
