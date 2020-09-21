<template>
  <div v-if="currentLocal" class="edit-form">
    <h4>Local</h4>
    <form>
      <div class="form-group">
        <label for="nombre">Nombre</label>
        <input type="text" class="form-control" id="nombre"
          v-model="currentLocal.nombre"
        />
      </div>
      <div class="form-group">
        <label for="direccion">Direccion</label>
        <input type="text" class="form-control" id="direccion"
          v-model="currentLocal.direccion"
        />
      </div>
	</form>

    <button class="badge badge-danger mr-2"
      @click="deleteLocal"
    >
      Borrar
    </button>

    <button type="submit" class="badge badge-success"
      @click="updateLocal"
    >
      Actualizar
    </button>
    <p>{{ message }}</p>
  </div>

  <div v-else>
    <br />
    <p>Cliquee un Local...</p>
  </div>
</template>

<script>
import LocalDataService from "../services/LocalDataService";

export default {
  name: "local",
  data() {
    return {
      currentLocal: null,
      message: ''
    };
  },
  methods: {
    getLocal(id) {
      LocalDataService.get(id)
        .then(response => {
          this.currentLocal = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    updateLocal() {
      LocalDataService.update(this.currentLocal.id, this.currentLocal)
        .then(response => {
          console.log(response.data);
          this.message = 'El local fue correctamente actualizado!';
        })
        .catch(e => {
          console.log(e);
        });
    },

    deleteLocal() {
      LocalDataService.delete(this.currentLocal.id)
        .then(response => {
          console.log(response.data);
          this.$router.push({ name: "locales" });
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.message = '';
    this.getLocal(this.$route.params.id);
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>
