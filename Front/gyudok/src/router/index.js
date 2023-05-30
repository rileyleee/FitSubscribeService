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
    path: "/signup",
    name: "signup",
    component: () => import("../views/SignupView.vue"),
  },
  {
    path: "/login",
    name: "login",
    component: () => import("../views/LoginView.vue"),
  },
  {
    path: "/community",
    component: () => import("../views/CommunityView.vue"),
    children: [
      {
        path: "",
        name: "boardList",
        component: () => import("@/components/community/CommunityList.vue"),
      },
      {
        path: "create",
        name: "boardCreate",
        component: () => import("@/components/board/BoardCreate.vue"),
      },
      {
        path: "detail",
        name: "boardDetail",
        component: () => import("@/components/board/BoardDetail.vue"),
      },
      {
        path: "modify",
        name: "boardModify",
        component: () => import("@/components/board/BoardModify.vue"),
      },
    ],
  },
  {
    path: "/facsubs",
    component: () => import("../views/FacSubsView.vue"),
    children: [
      {
        path: "subscribe",
        name: "fac-subscribe",
        component: () => import("@/components/subs/FacilitySubscribe.vue"),
      },
      {
        path: "mysubscribe",
        name: "fac-mysubscribe",
        component: () => import("@/components/subs/MyFacSubscribe.vue"),
      },
      {
        path: "search",
        name: "fac-search",
        component: () => import("@/components/subs/FacilitySearch.vue"),
      },
      {
        path: "result",
        name: "fac-searchresult",
        component: () => import("@/components/subs/FacilitySearchResult.vue"),
      },
      {
        path: "detail",
        name: "fac-detail",
        component: () => import("@/components/subs/FacilityDetail.vue"),
      },
      {
        path: "use",
        name: "fac-use",
        component: () => import("@/components/subs/FacilityUseList.vue"),
      },
    ],
    redirect: () => {},
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
