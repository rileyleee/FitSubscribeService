<template>
  <div id="app">
    <HeaderNav></HeaderNav>
    <router-view />
  </div>
</template>

<script>
import HeaderNav from "./components/common/HeaderNav.vue";

export default {
  name: "App",
  components: {
    HeaderNav,
  },
};
</script>

<style></style>
