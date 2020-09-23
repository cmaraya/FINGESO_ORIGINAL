<template>
<v-container>
    <v-card
        class="mx-auto"
        max-width="460"
    >
    <v-card-text>
        <div class="text--primary">
            Para usar la siguiente página debe permitir que el sitio pueda utilizar la cámara de su dispositivo para escanear el código QR del local al que desea ingresar. Luego de escanear se le mostrarpa el tiempo estimado de ingreso al local, si desea ingresar a la fila debe presionar en tomar ticket de esta forma se le solicitará su nombre y número de teléfono para completar su ingreso a la fila.
        </div>
        </v-card-text>
    </v-card>

    <div class="col-md-12">
		<div class="mt-9 text-center">
			<a href="/estado" class="active dim-boton btn btn-lg btn-color4 font-weight-bold">
				INGRESAR TICKET
			</a>
		</div>
	</div>

    <div class="col-md-12">
		<div class="mt-9 text-center">
			<a class="active dim-boton btn btn-lg btn-color4 font-weight-bold">
				ESCANEAR QR
			</a>
		</div>
	</div>

</v-container>

</template>

<style>
.mt-9 {
  margin-top: 15px !important;
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