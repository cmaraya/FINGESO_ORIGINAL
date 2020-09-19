<template>
  <div class="submit-form">
    <div v-if="!submitted">
      <div class="form-group">
        <label for="Nombre">Nombre</label>
        <input
          type="text"
          class="form-control"
          id="local"
          required
          v-model="local.nombre"
          name="nombre"
        />
      </div>

      <div class="form-group">
        <label for="direccion">Direccion</label>
        <input
          class="form-control"
          id="direccion"
          required
          v-model="local.direccion"
          name="direccion"
        />
      </div>

      <button @click="saveLocal" class="btn btn-success">Enviar</button>
    </div>

    <div v-else>
      <h4>Agregaste un local correctamente!</h4>
      <button class="btn btn-success" @click="newLocal">Añadir</button>
    </div>
  </div>
</template>

<script>
import LocalDataService from "../services/LocalDataService";

export default {
  name: "add-local",
  data() {
    return {
      local: {
        id: null,
        nombre: "",
        direccion: "",
      },
      submitted: false
    };
  },
  methods: {
    saveLocal() {
      var data = {
        nombre: this.local.nombre,
        direccion: this.local.direccion
      };

      LocalDataService.create(data)
        .then(response => {
          this.local.id = response.data.id;
          console.log(response.data);
          this.submitted = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    newLocal() {
      this.submitted = false;
      this.local = {};
    }
  }
};
</script>

</script>

<style>
.submit-form {
  max-width: 300px;
  margin: auto;
}
</style>