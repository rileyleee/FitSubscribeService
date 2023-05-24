<template>
  <v-app>
    <v-main>
      <header-nav></header-nav>
      <facility-map></facility-map>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>
import HeaderNav from "./components/common/HeaderNav.vue";
import FacilityMap from "./components/subs/FacilityMap.vue";
export default {
  name: "App",
  components: { HeaderNav, FacilityMap },

  data: () => ({
    //
  }),
};
</script>
