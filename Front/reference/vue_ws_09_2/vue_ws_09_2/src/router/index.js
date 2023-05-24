import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "HomeView",
    component: HomeView,
  },
  {
    path: "/movie",
    name: "movie",
    component: () => import("../views/MovieView.vue"),
    children: [
      {
        path: "create",
        name: "movie-create",
        component: () => import("@/components/movie/MovieCreate.vue"),
      },
      {
        path: "list",
        name: "movie-list",
        component: () => import("@/components/movie/MovieList.vue"),
      },
      {
        path: "detail",
        name: "movie-detail",
        component: () => import("@/components/movie/MovieDetail.vue"),
      },
      {
        path: "modify",
        name: "movie-modify",
        component: () => import("@/components/movie/MovieModify.vue"),
      },
    ],
    redirect: () => {
      return "/moview";
    },
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
