<template>
  <div class="list row">
    <div class="col-md-12">
		<div class="mt-9">
			<h5 class="text-center font-weight-bold ">Número de Ticket</h5>
		</div>
	</div>
	
	<div class="col-md-12">
		<div class="my-3">
			<input type="text" class="bg-Gray text-center form-control form-rounded form" placeholder="Ej: 12345-123">
		</div>
    </div>
	

	
	<div class="col-md-12">
		<div class="mt-8 text-center">
			<a href="/infolocaldejar" class="active dim-boton btn btn-lg btn-color4 font-weight-bold" @click="enviarTicket">
				ACEPTAR
			</a>
		</div>
	</div>
    
	
      
   
  </div>
</template>

<script>
import LocalDataService from "../services/LocalDataService";

export default {
  name: "locales-list",
  data() {
    return {
      usuario: null,
      nombre: "",
	  numero: ""
    };
  },
  methods: {
    enviarTicket() {
      LocalDataService.enviarUsuario()
        .then(response => {
          console.log(response.data);
          this.refreshList();
        })
        .catch(e => {
          console.log(e);
        });
    },
    
   
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}

.mt-9 {
  margin-top: 225px !important;
}
.mt-8 {
  margin-top: 200px !important;
}
.mt-7 {
  margin-top: 80px !important;
}
.mt-6 {
  margin-top: 65px !important;
}
.form-rounded {
border-radius: 1rem;
}

.bg-Gray {
    background-color: #FAFAFA !important;
}

.dim-boton{
  padding-left: 120px !important;
  padding-right: 120px !important;
  padding-top: 40px !important;
  padding-bottom: 40px !important;
}

.btn-color4 {
    color: #fff;
    background-color: #457b9d;
    border-color: #457b9d;
}
</style>
