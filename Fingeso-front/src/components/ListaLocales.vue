<template>
  <div class="list row">
    <div class="col-md-8">
      <div class="input-group mb-3">
        <input type="text" class="form-control" placeholder="Buscar por nombre"
          v-model="nombre"/>
        <div class="input-group-append">
          <button class="btn btn-outline-secondary" type="button"
            @click="searchNombre"
          >
            Buscar
          </button>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <h4>Lista de Locales</h4>
      <ul class="list-group">
        <li class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(local, index) in locales"
          :key="index"
          @click="setActiveLocal(local, index)"
        >
          {{ local.nombre }}
        </li>
      </ul>

      <button class="m-3 btn btn-sm btn-danger" @click="removeAllLocales">
        Borrar Todos
      </button>
    </div>
    <div class="col-md-6">
      <div v-if="currentLocal">
        <h4>Local</h4>
        <div>
          <label><strong>Nombre:</strong></label> {{ currentLocal.nombre }}
        </div>
        <div>
          <label><strong>Direccion:</strong></label> {{ currentLocal.direccion }}
        </div>

        <a class="badge badge-warning"
          :href="'/locales/' + currentLocal.id"
        >
          Edit
        </a>
      </div>
      <div v-else>
        <br />
        <p>Cliquee un Local...</p>
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
      locales: [],
      currentLocal: null,
      currentIndex: -1,
      nombre: ""
    };
  },
  methods: {
    retrieveLocales() {
      LocalDataService.getAll()
        .then(response => {
          this.locales = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    },

    refreshList() {
      this.retrieveLocales();
      this.currentLocal = null;
      this.currentIndex = -1;
    },

    setActiveLocal(local, index) {
      this.currentLocal = local;
      this.currentIndex = index;
    },

    removeAllLocales() {
      LocalDataService.deleteAll()
        .then(response => {
          console.log(response.data);
          this.refreshList();
        })
        .catch(e => {
          console.log(e);
        });
    },
    
    searchNombre() {
      LocalDataService.findByNombre(this.nombre)
        .then(response => {
          this.locales = response.data;
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },
  mounted() {
    this.retrieveLocales();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>
