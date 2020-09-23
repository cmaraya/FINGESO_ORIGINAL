<template>
  <v-container>
    <v-card class="mx-auto" max-width="460">
      <v-card-text>
        <div class="text--primary">
          Nombre de local
          <br />
          DIINF
          <br />
          Tiempo estimado de ingreso
          <br />
          38 Min.
          <br />
          Cantidad de personas en la cola
          <br />
          4
        </div>
      </v-card-text>
    </v-card>

    <div class="col-md-12">
      <div class="mt-9 text-center">
        <a href="/colaabandonada" class="active dim-boton btn btn-lg btn-color4 font-weight-bold">
          DEJAR LA FILA
        </a>
      </div>
    </div>
  </v-container>
</template>

<style>
.mt-9 {
  margin-top: 15px !important;
}
.dim-boton {
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
