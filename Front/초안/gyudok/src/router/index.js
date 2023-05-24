import Vue from "vue";
import VueRouter from "vue-router";
import MainIntroView from "../views/MainIntroView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "mainintro",
    component: MainIntroView,
  },
  {
    path: "/facsubs",
    name: "facsubs",
    component: () => import("../views/FacSubsView.vue"),
    children: [
      {
        path: "subscribe",
        name: "fac-subscribe",
        component: () => import("@/components/subs/FacilitySubscribe.vue"),
      },
      {
        path: "search",
        name: "fac-search",
        component: () => import("@/components/subs/FacilitySearch.vue"),
      },
      {
        path: "detail",
        name: "fac-detail",
        component: () => import("@/components/subs/FacilityDetail.vue"),
      },
      {
        path: "visit",
        name: "fac-visit",
        component: () => import("@/components/subs/FacilityVisit.vue"),
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
