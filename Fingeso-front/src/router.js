import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      alias: "/locales",
      name: "locales",
      component: () => import("./components/ListaLocales")
    },
    {
      path: "/locales/:id",
      name: "local-detalle",
      component: () => import("./components/Local")
    },
    {
      path: "/add",
      name: "add",
      component: () => import("./components/AddLocal")
    }
	,
    {
      path: "/solicitud",
      name: "solicitud",
      component: () => import("./components/Solicitud")
    }
	,
    {
      path: "/ticket",
      name: "ticket",
      component: () => import("./components/Ticket")
    }
    ,
    {
      path: "/ingresar",
      name: "ingresar",
      component: () => import("./components/IngresarOrScan")
    }
    ,
    {
      path: "/user",
      name: "user",
      component: () => import("./components/usuario")
    }
    ,
    {
      path: "/info",
      name: "info",
      component: () => import("./components/InfoTicket")
    }
  ]
});
