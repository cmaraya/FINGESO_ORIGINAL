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
      path: "/user",
      name: "user",
      component: () => import("./components/usuario")
    }
	,
    {
      path: "/solicitud",
      name: "solicitud",
      component: () => import("./components/Solicitud")
    }
	,
	{
      path: "/infolocal",
      name: "infolocal",
      component: () => import("./components/InfoTicket")
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
      path: "/estado",
      name: "estado",
      component: () => import("./components/Estado")
    }
	,
	{
      path: "/infolocaldejar",
      name: "infolocaldejar",
      component: () => import("./components/InfoTicketDejar")
    }
	,
	{
      path: "/colaabandonada",
      name: "colaabandonada",
      component: () => import("./components/ColaAbandonada")
    }
  ]
});
