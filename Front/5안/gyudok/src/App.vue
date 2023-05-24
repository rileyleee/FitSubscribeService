<template>
  <div id=app>
    <div>
      <header-nav></header-nav>
      <router-view />
    </div>
  </div>
</template>

<script>
import HeaderNav from "./components/common/HeaderNav.vue";
export default {
  name: "App",
  components: { HeaderNav },

  data: () => ({}),
};
</script>
